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
package crcl.ui.misc;

import crcl.base.CRCLProgramType;
import crcl.base.PointType;
import crcl.utils.ProgramPlotter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

/**
 *
 * @author Will Shackleford {@literal <william.shackleford@nist.gov>}
 */
public class ProgramPlotterJPanel extends JPanel {

    
    
    transient private  ProgramPlotter plotter;

    /**
     * Get the value of plotter
     *
     * @return the value of plotter
     */
    public ProgramPlotter getPlotter() {
        return plotter;
    }

    /**
     * Set the value of plotter
     *
     * @param plotter new value of plotter
     */
    public void setPlotter(ProgramPlotter plotter) {
        this.plotter = plotter;
    }

    transient private CRCLProgramType program;

    /**
     * Get the value of program
     *
     * @return the value of program
     */
    public CRCLProgramType getProgram() {
        return program;
    }

    /**
     * Set the value of program
     *
     * @param program new value of program
     */
    public void setProgram(CRCLProgramType program) {
        this.program = program;
    }

    private int index;

    /**
     * Get the value of index
     *
     * @return the value of index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Set the value of index
     *
     * @param index new value of index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (null != plotter) {
            plotter.setDimension(this.getSize());
            if (g instanceof Graphics2D) {
                Graphics2D g2d = (Graphics2D) g;
                if (null != program) {
                    plotter.paint(program, g2d, index);
                }
            }
        }
    }

}
