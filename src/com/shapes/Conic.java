package com.shapes;

import com.math.Vec2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class Conic extends Shape {

    public Conic(Vec2... points) {
        super(null, null, false, 1);
    }

    @Override
    public void render(Graphics2D g) {

    }

    @Override
    public void translate(Vec2 v) {
        // TODO Auto-generated method stub

    }

    @Override
    public void scal(double s) {
        // TODO Auto-generated method stub

    }

    @Override
    public void rotate(double orientation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setPos(Vec2 pos) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onDrag(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onLeftPressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onRightPressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onLeftReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onRightReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onMouseWheelUp(MouseWheelEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onMouseWheelDown(MouseWheelEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void scal(double s, Vec2 v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
