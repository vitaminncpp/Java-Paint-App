/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shapes;

import com.IO.MouseAction;
import com.math.Vec2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Akshay
 */
public class Brush extends Shape implements MouseAction {

    private  List<Vec2> vert;
    private int n;
    private  double strokeSize;

    public Brush ( Vec2 pos , Color color , boolean fill,double strokeSize ) {
        super ( pos , color , fill );
        this.vert = new ArrayList<Vec2> ();
        this.vert.add ( pos );
        this.n=1;
        this.strokeSize=strokeSize;
    }

    @Override
    public void translate ( Vec2 v ) {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void scal ( double s ) {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rotate ( double orientation ) {
        
    }

    @Override
    public void render ( Graphics2D g ) {
        g.setColor ( color );
        System.out.println ("Brush | render | "+this.strokeSize);
        for(int i=0;i<this.n;i++){
           g.fillOval ( ( int ) (this. vert.get(i).getX ()-this.strokeSize/2 ) , ( int )( this.vert.get ( i).getY ()-this.strokeSize/2)  , ( int )this.strokeSize  , ( int )  this.strokeSize  );
        }
    }

    @Override
    public void setPos ( Vec2 pos ) {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onDrag ( MouseEvent e ) {
        this.vert.add ( new Vec2(e.getX (),e.getY ()));
        this.n++;
    }

    @Override
    public void onLeftPressed ( MouseEvent e ) {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onRightPressed ( MouseEvent e ) {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onLeftReleased ( MouseEvent e ) {
        
    }

    @Override
    public void onRightReleased ( MouseEvent e ) {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onMouseWheelUp ( MouseWheelEvent e ) {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onMouseWheelDown ( MouseWheelEvent e ) {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void scal ( double s , Vec2 v ) {
        for(int i=0;i<this.vert.size ();i++){
            this.vert.get ( i ).scal ( s , v );
        }
    }
    @Override
    public Shape getCopy () {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString () {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

}
