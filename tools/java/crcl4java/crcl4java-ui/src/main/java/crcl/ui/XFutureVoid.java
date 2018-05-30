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
package crcl.ui;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Will Shackleford {@literal <william.shackleford@nist.gov>}
 */
public class XFutureVoid extends XFuture<Void> {

    public XFutureVoid(String name) {
        super(name);
    }

    public static XFutureVoid completedFutureWithName(String name) {
        XFutureVoid ret = new XFutureVoid(name);
        ret.complete(null);
        return ret;
    }

    public static XFutureVoid completedFuture() {
        XFutureVoid ret = new XFutureVoid("completedFuture( )");
        ret.complete(null);
        return ret;
    }

    public boolean complete() {
        return super.complete(null);
    }

    private void alsoCancelAddAll(Iterable<? extends CompletableFuture<?>> cfs) {
        for (CompletableFuture cf : cfs) {
            alsoCancelAdd(cf);
        }
    }

    public static XFutureVoid runAsync(String name, Runnable r) {
        return runAsync(name, r, getDefaultThreadPool());
    }

    @SuppressWarnings("unchecked")
    public static XFutureVoid runAsync(String name, Runnable r, ExecutorService es) {
        XFutureVoid myf = new XFutureVoid(name);
        Future<?> f = es.submit(() -> {
            try {
                String tname = Thread.currentThread().getName();
                int cindex = tname.indexOf(':');
                String tname_sub = tname;
                if (cindex > 0) {
                    tname_sub = tname.substring(0, cindex);
                }
                Thread.currentThread().setName(tname_sub + ":" + name);
                r.run();
                Thread.currentThread().setName(tname);
            } catch (Throwable throwable) {
                myf.completeExceptionally(throwable);
                Logger.getLogger(XFuture.class.getName()).log(Level.SEVERE, null, throwable);
                throw new RuntimeException(throwable);
            }
            myf.complete(null);
//            myf.alsoCancel.clear();
        });
        myf.setFutureFromExecSubmit((Future<Void>) f);
        return myf;
    }

    public <U> XFuture<U> thenCompose(Supplier< ? extends CompletionStage<U>> supplier) {
        return super.thenCompose(getName() + ".thenCompose", c -> supplier.get());
    }

    public <U> XFuture<U> thenComposeAsync(Supplier< ? extends CompletionStage<U>> supplier) {
        return super.thenComposeAsync(getName() + ".thenCompose", c -> supplier.get());
    }

    public <U> XFuture<U> thenComposeAsync(Supplier< ? extends CompletionStage<U>> supplier, ExecutorService es) {
        return super.thenCompose(getName() + ".thenCompose", c -> supplier.get());
    }

    public XFutureVoid thenComposeVoid(Supplier< XFuture<Void>> supplier) {
        XFuture<Void> f = super.thenCompose(getName() + ".thenCompose", c -> supplier.get());
        XFutureVoid ret = staticwrapvoid(f.getName(), f);
        ret.alsoCancelAdd(f);
        return ret;
    }
    
    @Override
    public XFutureVoid thenRun(Runnable r) {
        XFuture<Void> f = super.thenRun(r);
        XFutureVoid ret = staticwrapvoid(f.getName(), f);
        ret.alsoCancelAdd(f);
        return ret;
    }

    @Override
    public XFutureVoid thenRun(String name, Runnable r) {
        XFuture<Void> f = super.thenRun(name,r);
        XFutureVoid ret = staticwrapvoid(f.getName(), f);
        ret.alsoCancelAdd(f);
        return ret;
    }
    
    @Override
    public XFutureVoid thenRunAsync(Runnable r) {
        XFuture<Void> f = super.thenRunAsync(r);
        XFutureVoid ret = staticwrapvoid(f.getName(), f);
        ret.alsoCancelAdd(f);
        return ret;
    }

    @Override
    public XFutureVoid thenRunAsync(String name, Runnable r) {
        XFuture<Void> f = super.thenRunAsync(name,r);
        XFutureVoid ret = staticwrapvoid(f.getName(), f);
        ret.alsoCancelAdd(f);
        return ret;
    }
    
    @Override
    public XFutureVoid thenRunAsync(String name, Runnable r, ExecutorService es) {
        XFuture<Void> f = super.thenRunAsync(name,r,es);
        XFutureVoid ret = staticwrapvoid(f.getName(), f);
        ret.alsoCancelAdd(f);
        return ret;
    }
    
    
    public <U> XFuture<U> thenSupply(Supplier<U> supplier ){
        return super.thenApply(x -> supplier.get());
    }

    public <U> XFuture<U> thenSupply(String name, Supplier<U> supplier) {
        return super.thenApply(name,x -> supplier.get());
    }
    
    public <U> XFuture<U> thenSupplyAsync(Supplier<U> supplier) {
        return super.thenApplyAsync(x-> supplier.get());
    }

    public <U> XFuture<U> thenSupplyAsync(String name, Supplier<U> supplier) {
        return super.thenApplyAsync(name, x-> supplier.get());
    }
    
    public <U> XFuture<U> thenSupplyAsync(String name, Supplier<U> supplier, ExecutorService es) {
        return super.thenApplyAsync(name, x-> supplier.get(),es);
    }
    
    public XFutureVoid thenComposeVoidAsync(Supplier< XFuture<Void>> supplier) {
        XFuture<Void> f = super.thenComposeAsync(getName() + ".thenCompose", c -> supplier.get());
        XFutureVoid ret = staticwrapvoid(f.getName(), f);
        ret.alsoCancelAdd(f);
        return ret;
    }

    public XFutureVoid thenComposeVoid(Supplier< XFuture<Void>> supplier, ExecutorService es) {
        XFuture<Void> f = super.thenComposeAsync(getName() + ".thenCompose", c -> supplier.get(), es);
        XFutureVoid ret = staticwrapvoid(f.getName(), f);
        ret.alsoCancelAdd(f);
        return ret;
    }

    private static XFutureVoid staticwrapvoid(String name, CompletableFuture<Void> future) {
        if (future instanceof XFutureVoid) {
            return (XFutureVoid) future;
        }
        XFutureVoid newFuture = new XFutureVoid(name);
        future.handle(newFuture::logException)
                .thenAccept(x -> {
                    newFuture.complete(x);
                });
        newFuture.alsoCancelAdd(future);
        return newFuture;
    }

    public static XFutureVoid allOfWithName(String name, CompletableFuture<?>... cfs) {
        CompletableFuture<Void> orig = CompletableFuture.allOf(cfs);
        XFutureVoid ret = staticwrapvoid(name, orig);
        ret.alsoCancelAddAll(Arrays.asList(cfs));
        return ret;
    }

    public static XFutureVoid allOf(CompletableFuture<?>... cfs) {
        CompletableFuture<Void> orig = CompletableFuture.allOf(cfs);
        XFutureVoid ret = staticwrapvoid("allOfWithName", orig);
        ret.alsoCancelAddAll(Arrays.asList(cfs));
        return ret;
    }
    
    @Override
    public XFutureVoid alwaysAsync(Runnable r, ExecutorService service) {
        return staticwrapvoid(this.getName() + ".alwaysAsync", super.handleAsync((x, t) -> {
            try {
                r.run();
            } catch (Throwable t2) {
                Logger.getLogger(XFuture.class.getName()).log(Level.SEVERE, null, t2);
                if (null == t) {
                    if (t2 instanceof RuntimeException) {
                        throw ((RuntimeException) t2);
                    } else {
                        throw new RuntimeException(t2);
                    }
                }
            }
            if (null != t) {
                if (t instanceof RuntimeException) {
                    throw ((RuntimeException) t);
                } else {
                    throw new RuntimeException(t);
                }
            }
            return x;
        }, service));
    }
}
