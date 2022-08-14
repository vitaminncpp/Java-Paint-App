/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.IO;

import com.paint.Paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Akshay
 */
public class LabelListener implements MouseListener {

    private final int itemIndex;
    private final Paint paint;

    public LabelListener(Paint paint, int itemIndex) {
        this.paint = paint;
        this.itemIndex = itemIndex;

    }

    /**
     * @param arg0
     */
    @Override
    public void mouseClicked(MouseEvent arg0) {
        this.paint.setSelected(this.itemIndex);
        this.paint.panel.render();
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
