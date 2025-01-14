/*
 * This software is public domain software, however it is preferred
 * that the following disclaimers be attached.
 * Software Copywrite/Warranty Disclaimer
 * 
 * This software was developed at the National Institute of Standards and
 * Technology by employees of the Federal Government in the course of their
 * official duties. Pursuant to title 17 Section 105 of the United States
 * Code this software is not subject to copyright protection and is in the
 * public domain.
 * 
 * This software is experimental. NIST assumes no responsibility whatsoever 
 * for its use by other parties, and makes no guarantees, expressed or 
 * implied, about its quality, reliability, or any other characteristic. 
 * We would appreciate acknowledgement if the software is used. 
 * This software can be redistributed and/or modified freely provided 
 * that any derivative works bear some notice that they are derived from it, 
 * and any modified versions bear some notice that they have been modified.
 * 
 *  See http://www.copyright.gov/title17/92chap1.html#105
 * 
 */
package com.github.wshackle.generate.copier.maven.plugin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.maven.plugin.MojoExecutionException;

/**
 *
 * @author Will Shackleford {@literal <william.shackleford@nist.gov>}
 */
public class JavaCloneUtilGenerator {

    public void generateCloneUtil(JavaCloneUtilOptions options) throws IOException, MojoExecutionException {
        String classname = options.classname;
        File dir = options.dir;
        List<Class<?>> classes = options.classes;
        if (null == classes) {
            throw new MojoExecutionException("classes=null");
        }

        if (classes.isEmpty()) {
            throw new MojoExecutionException("classes.isEmpty()");
        }
        Set<String> nocopyclassnamesSet = options.nocopyclassnamesSet;
        String logString = options.logString;
        if (classname.endsWith(".class")) {
            classname = classname.substring(0, classname.length() - 6);
        } else if (classname.endsWith(".java")) {
            classname = classname.substring(0, classname.length() - 5);
        }
        int lastp = classname.lastIndexOf('.');
        String packagename;
        String classonlyname;
        if (lastp > 0) {
            packagename = classname.substring(0, lastp);
            classonlyname = classname.substring(lastp + 1);
        } else {
            packagename = "";
            classonlyname = classname;
        }
        if (null == dir || !dir.exists() || !dir.isDirectory() || !dir.canWrite()) {

            throw new MojoExecutionException("Can't use given dir=" + dir);

//                System.out.println("Can't use given dir.");
//            System.out.println("dir = " + dir);
//            System.out.println("Using current user.dir property instead.");
//            final String userDirProperty = System.getProperty("user.dir");
//            System.out.println("userDirProperty = " + userDirProperty);
//
//            dir = new File(userDirProperty);
        }
        String classsubstring = classname;
        int pindex = classsubstring.indexOf('.');
        while (pindex > 0 && pindex < classsubstring.length() - 1) {
            dir = new File(dir, classsubstring.substring(0, pindex));
            dir.mkdirs();
            classsubstring = classsubstring.substring(pindex + 1);
            pindex = classsubstring.indexOf('.');
        }
        File f = new File(dir, classonlyname + ".java");
        System.out.println("JavaCloneUtilGenerator writing to " + f.getCanonicalPath());
        Set<String> classnamesSet = new TreeSet<>();
        for (int i = 0; i < classes.size(); i++) {
            Class<?> clzzi = classes.get(i);
            if (clzzi.isSynthetic()) {
                continue;
            }
            if (clzzi.isEnum()) {
                continue;
            }
            classnamesSet.add(clzzi.getName());
        }
        final Comparator<Method> methodNameComparator = new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                if (o1 == o2) {
                    return 0;
                } else if (null == o1) {
                    return 1;
                } else if (null == o2) {
                    return -1;
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        };
        try (PrintWriter pw = new PrintWriter(f)) {
            pw.println();
            pw.println();
            pw.println("/****************************************");
            pw.println("* This file was automatically generated by ");
            pw.println("* class=" + this.getClass());
            pw.println("* protection domain code source= " + this.getClass().getProtectionDomain().getCodeSource());
            pw.println("* dir=" + dir);
            pw.println("* classes=" + classes);
            pw.println("* nocopyclassnamesSet=" + nocopyclassnamesSet);
            pw.println("* logString will be printed at the end.");
            pw.println("****************************************/");
            pw.println();
            pw.println();
            if (packagename != null && packagename.length() > 1) {
                pw.println("package " + packagename + ";");
                pw.println();
            }
            for (String name : classnamesSet) {
                if (name.startsWith("java.lang.")) {
                    continue;
                }
                name = name.replace('$', '.');
                pw.println("import " + name + ";");
            }
            pw.println("import java.util.Iterator;");
            pw.println("import java.util.Arrays;");
            pw.println("import java.util.HashSet;");
            pw.println("import java.util.Set;");
            pw.println("import org.checkerframework.checker.nullness.qual.PolyNull;");
            pw.println();
            pw.println("public class " + classonlyname + " {");

            pw.println();

//            pw.println("    private static Class classForName(String name) {");
//            pw.println("        try {");
//            pw.println("            return Class.forName(name);");
//            pw.println("        } catch(ClassNotFoundException ex) {");
//            pw.println("            Logger.getLogger(\"" + classname + "\").log(Level.SEVERE, \"\", ex);");
//            pw.println("            return null;");
//            pw.println("        }");
//            pw.println("    }");
//            pw.println();
//
//            pw.println("    private final static Set<Class<?>> noCopyClasses = new HashSet<>(Arrays.asList(");
//            Iterator<String> nocopyClassNamesIterator = nocopyclassnamesSet.iterator();
//            while (nocopyClassNamesIterator.hasNext()) {
//                String nocopyclasssname = nocopyClassNamesIterator.next();
//                if (null == nocopyclasssname || nocopyclasssname.isEmpty()) {
//                    break;
//                }
//                pw.println("        classForName(\"" + nocopyclasssname + "\")" + ((nocopyClassNamesIterator.hasNext()) ? "," : ""));
//            }
            pw.println("    private final static Set<String> noCopyClasses = new HashSet<>(Arrays.asList(");
            Iterator<String> nocopyClassNamesIterator = nocopyclassnamesSet.iterator();
            while (nocopyClassNamesIterator.hasNext()) {
                String nocopyclasssname = nocopyClassNamesIterator.next();
                if (null == nocopyclasssname || nocopyclasssname.isEmpty()) {
                    break;
                }
                pw.println("        \"" + nocopyclasssname + "\"" + ((nocopyClassNamesIterator.hasNext()) ? "," : ""));
            }
            pw.println("        ));");
            pw.println();

            for (int i = 0; i < classes.size(); i++) {

                Class<?> clzzi = classes.get(i);
                pw.println("    // i = " + i + ",clzzi=" + clzzi);
                if (clzzi.isSynthetic()) {
                    continue;
                }
                if (clzzi.getName().startsWith("java.")) {
                    continue;
                }
                if (clzzi.isEnum()) {
                    continue;
                }
                if (clzzi.isInterface()) {
                    continue;
                }
                List<Class<?>> assigableClasses = new ArrayList<>();
                for (int j = classes.size() - 1; j > 0; j--) {
                    Class<?> clzzj = classes.get(j);
                    if (!clzzi.isAssignableFrom(clzzj)) {
                        continue;
                    }
                    if (clzzj.isInterface() || Modifier.isAbstract(clzzj.getModifiers())) {
                        continue;
                    }
                    Constructor<?> constructors[] = clzzj.getConstructors();
                    boolean publicNoArgConstructorFound = false;
                    for (int k = 0; k < constructors.length; k++) {
                        Constructor<?> constructor = constructors[k];
                        if (constructor.getParameterCount() == 0 && Modifier.isPublic(constructor.getModifiers())) {
                            publicNoArgConstructorFound = true;
                            break;
                        }
                    }
                    if (publicNoArgConstructorFound) {
                        assigableClasses.add(clzzj);
                    }
                }
                if (assigableClasses.size() < 1) {
                    throw new RuntimeException("no assignable classes/constructors for " + clzzi);
                }
//                Collections.sort(assigableClasses, classNameComparator);
                pw.println();
                pw.println("    public static @PolyNull");
                pw.println("    " + clzzi.getSimpleName() + " copy(@PolyNull " + clzzi.getSimpleName() + " in) {");
                pw.println("        if(in != null) {");
                final String assignableZeroSimpleName = assigableClasses.get(0).getSimpleName();
                boolean createCopyTo = false;
                if (assigableClasses.size() == 1) {
                    if (assigableClasses.get(0) != clzzi) {
                        pw.println("            " + clzzi.getSimpleName() + " out = copy((" + assignableZeroSimpleName + ")in);");
                    } else {
                        pw.println("            " + clzzi.getSimpleName() + " out = new " + assignableZeroSimpleName + "();");
                        pw.println("            return copyTo(in,out);");
                        createCopyTo = true;
                    }
                } else {
                    pw.println("            " + clzzi.getSimpleName() + " out;");
                    pw.println("            if(in instanceof " + assignableZeroSimpleName + ") {");
                    if (assigableClasses.get(0) != clzzi) {
                        pw.println("                out = copy((" + assignableZeroSimpleName + ")in);");
                    } else {
                        pw.println("                out = new " + assignableZeroSimpleName + "();");
                        pw.println("                copyTo(in,out);");
                        createCopyTo = true;

                    }
                    for (int j = 1; j < assigableClasses.size(); j++) {
                        final String assignableJsimpleName = assigableClasses.get(j).getSimpleName();
                        pw.println("            } else if(in instanceof " + assignableJsimpleName + ") {");
                        if (assigableClasses.get(j) != clzzi) {
                            pw.println("                out = copy((" + assignableJsimpleName + ")in);");
                        } else {
                            pw.println("                out = new " + assignableJsimpleName + "();");
                            pw.println("                copyTo(in,out);");
                            createCopyTo = true;
                        }
                    }
                    pw.println("            } else {");
                    pw.println("                throw new RuntimeException(\"Unrecognized class for in=\"+in);");
                    pw.println("            }");
                    pw.println("            assert(out!=null):\"out==null\";");
                    pw.println("            return out;");
                }
                pw.println("        } else {");
                pw.println("            return in;");
                pw.println("        }");
                pw.println("    }");
                pw.println();
                if (createCopyTo) {
                    pw.println("    public static");
                    pw.println("    " + clzzi.getSimpleName() + " copyTo(" + clzzi.getSimpleName() + " in," + clzzi.getSimpleName() + " out) {");
                    pw.println("        assert(in.getClass()==" + clzzi.getSimpleName() + ".class): \"in.getClass()!=" + clzzi.getSimpleName() + ".class : in.getClass()=\"+in.getClass();");
                    pw.println("        assert(out.getClass()==" + clzzi.getSimpleName() + ".class): \"out.getClass()!=" + clzzi.getSimpleName() + ".class: out.getClass()=\"+out.getClass();");
                    Method methods[] = clzzi.getMethods();
                    Arrays.sort(methods, methodNameComparator);
                    for (int j = 0; j < methods.length; j++) {
                        Method methodJ = methods[j];
                        final Class<?> returnType = methodJ.getReturnType();
                        if (methodJ.getParameterCount() == 1
                                && methodJ.getName().startsWith("set")
                                && (returnType == void.class || returnType == Void.class)) {
                            Method getterMethod = null;
                            final Class<?> parameterType0 = methodJ.getParameterTypes()[0];
                            if (Boolean.class.isAssignableFrom(parameterType0)
                                    || boolean.class.isAssignableFrom(parameterType0)) {
                                try {
                                    final String getterName = "is" + methodJ.getName().substring(3);
                                    System.out.println("getterName = " + getterName);
                                    getterMethod = clzzi.getMethod(getterName);
                                } catch (NoSuchMethodException | SecurityException ex) {
                                    Logger.getLogger(JavaCloneUtilGenerator.class.getName()).log(Level.SEVERE, "", ex);
                                }
                            } else {
                                try {
                                    getterMethod = clzzi.getMethod("get" + methodJ.getName().substring(3));
                                } catch (NoSuchMethodException | SecurityException ex) {
                                    Logger.getLogger(JavaCloneUtilGenerator.class.getName()).log(Level.SEVERE, "", ex);
                                }
                            }
                            if (null != getterMethod) {
                                if (parameterType0.isPrimitive() || parameterType0.isEnum() || !classes.contains(parameterType0) || parameterType0.getName().startsWith("java.")
                                        || nocopyclassnamesSet.contains(parameterType0.getName())) {
                                    pw.println("        out." + methodJ.getName() + "(in." + getterMethod.getName() + "());");
                                } else {
                                    pw.println("        out." + methodJ.getName() + "(copy(in." + getterMethod.getName() + "()));");
                                }
                            }
                        } else if (methodJ.getParameterCount() == 0
                                && methodJ.getName().startsWith("get")
                                && Collection.class.isAssignableFrom(returnType)) {
                            String returnTypeName = methodJ.getGenericReturnType().getTypeName();
                            int ltIndex = returnTypeName.indexOf('<');
                            int gtIndex = returnTypeName.lastIndexOf('>');
                            if (ltIndex > 0 && gtIndex > ltIndex + 1 && gtIndex < returnTypeName.length()) {
                                returnTypeName = returnTypeName.replace('$', '.');
                                String componentTypeName = returnTypeName.substring(ltIndex + 1, gtIndex);
                                Class<?> componentClass = null;
                                for (int k = 0; k < classes.size(); k++) {
                                    Class<?> classK = classes.get(k);
                                    if (classK.getName().equals(componentTypeName)) {
                                        componentClass = classK;
                                    }
                                }
                                if (null == componentClass) {
                                    try {
                                        componentClass = Class.forName(componentTypeName);
                                        System.out.println("componentClass = " + componentClass);
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(JavaCloneUtilGenerator.class.getName()).log(Level.SEVERE, "", ex);
                                    }
                                }
                                String outColName = "out" + methodJ.getName().substring(3);
                                pw.println("        " + returnTypeName + " " + outColName + " = out." + methodJ.getName() + "();");
                                pw.println("        assert(" + outColName + " !=null):\"" + outColName + "==null\";");
                                pw.println("        " + outColName + ".clear();");
                                String itname = "iterator" + methodJ.getName().substring(3);
                                pw.println("        Iterator<" + componentTypeName + "> " + itname + " = in." + methodJ.getName() + "().iterator();");
                                pw.println("        while(" + itname + ".hasNext()) {");
                                if(null == componentClass) { 
                                    throw new RuntimeException("componentClass == null: componentTypeName="+componentTypeName);
                                }
                                if (componentClass.isInterface() || nocopyclassnamesSet.contains(componentTypeName)) {
                                    pw.println("            " + outColName + ".add(" + itname + ".next());");
                                } else {
                                    if (nocopyclassnamesSet.isEmpty()) {
                                        pw.println("            " + outColName + ".add(copy(" + itname + ".next()));");
                                    } else {
                                        pw.println("            " + componentTypeName + " " + itname + "Next  = " + itname + ".next();");
                                        pw.println("            boolean skipCopy" + itname + " = noCopyClasses.contains(" + itname + "Next.getClass().getName());");
                                        pw.println("            if(skipCopy" + itname + ") {");
                                        pw.println("                " + outColName + ".add(" + itname + "Next);");
                                        pw.println("            } else {");
                                        pw.println("                " + outColName + ".add(copy(" + itname + "Next));");
                                        pw.println("            }");
                                    }
                                }
                                pw.println("        }");
                            }
                        }
                    }
                    pw.println("        return out;");
                    pw.println("    }");
                    pw.println();
                }

            }
            pw.println("}");
            pw.println();
            pw.println();
            pw.println("/*********************************************");
            pw.println("* Log data:");
            pw.println("*");
            pw.println(logString);
            pw.println("*");
            pw.println("*********************************************/");
            pw.println();

        }
    }
}
