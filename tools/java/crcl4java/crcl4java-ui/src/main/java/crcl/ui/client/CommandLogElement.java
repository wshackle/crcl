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
package crcl.ui.client;

import crcl.utils.outer.interfaces.CommandStatusLogElement;
import crcl.base.CRCLCommandType;
import crcl.utils.CRCLSocket;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 *
 * @author Will Shackleford {@literal <william.shackleford@nist.gov>}
 */
public class CommandLogElement extends CommandStatusLogElement {
    
    @SuppressWarnings("nullness")
    public CommandLogElement(CRCLCommandType cmd, long time, @Nullable  String progName, int progIndex, @Nullable String svrString) {
        super(cmd.getCommandID(), time,progName, progIndex,svrString);
        this.cmd = cmd;
    }
    final CRCLCommandType cmd;

    /**
     * Get the value of status
     *
     * @return the value of status
     */
    public CRCLCommandType getCmd() {
        return cmd;
    }

    public String toString() {
        return CRCLSocket.cmdToString(cmd);
    }
    
}
