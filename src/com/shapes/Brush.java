/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shapes;

import com.IO.MouseAction;
import com.math.Vec2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Akshay
 */
public class Brush extends Shape implements MouseAction {

    private final List<Vec2> vert;
    private int n;


    public Brush(Vec2 pos, Color color, boolean fill, double strokeSize) {
        super(pos, color, fill, strokeSize);
        this.vert = new ArrayList<Vec2>();
        this.vert.add(pos);
        this.n = 1;

    }

    @Override
    public void translate(Vec2 v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void scal(double s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rotate(double orientation) {

    }

    /**
     * @param g
     */
    @Override
    public void render(Graphics2D g) {
        g.setColor(color);
        g.setStroke(this.stroke);
        System.out.println("Brush | render | " + this.stroke);
        for (int i = 1; i < this.n; i++) {
            g.drawLine((int) this.vert.get(i - 1).getX(), (int) this.vert.get(i - 1).getY(), (int) this.vert.get(i).getX(), (int) this.vert.get(i).getY());
        }
    }

    @Override
    public void setPos(Vec2 pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onDrag(MouseEvent e) {
        this.vert.add(new Vec2(e.getX(), e.getY()));
        this.n++;
    }

    @Override
    public void onLeftPressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onRightPressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean onLeftReleased(MouseEvent e) {
        this.vert.add(new Vec2(e.getX(), e.getY()));
        this.n++;
        return this.n > 1;
    }

    @Override
    public void onRightReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onMouseWheelUp(MouseWheelEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onMouseWheelDown(MouseWheelEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void scal(double s, Vec2 v) {
        for (int i = 0; i < this.vert.size(); i++) {
            this.vert.get(i).scal(s, v);
        }
    }

    @Override
    public Shape getCopy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
