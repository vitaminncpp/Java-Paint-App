/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shapes;

import com.IO.MouseAction;
import com.math.Vec2;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 *
 * @author Akshay
 */
public class Rect extends Shape implements MouseAction {

    private Vec2 start;
    private double width;
    private double height;
    private Vec2 end;

    public Rect ( Vec2 start , Vec2 end , Color color , boolean fill,double stroke ) {
        super ( start.addition ( end ).scalar ( 0.5 ) , color , fill,stroke );
        this.start = start;
        this.end = end;
        this.width = this.end.subtraction ( this.start ).getX ();
        this.height = this.end.subtraction ( this.start ).getY ();
    }

    @Override
    public void translate ( Vec2 v ) {
        this.pos.add ( v );
        this.end.add ( v );
        this.start.add ( v );
        this.width = this.end.subtraction ( this.start ).getX ();
        this.height = this.end.subtraction ( this.start ).getY ();
    }

    @Override
    public void scal ( double s ) {
        this.start.scal ( s , this.pos );
        this.end.scal ( s , this.pos );
        this.width = this.end.subtraction ( this.start ).getX ();
        this.height = this.end.subtraction ( this.start ).getY ();
    }

    @Override
    public void rotate ( double theta ) {
        start.rotate ( theta , pos );
        this.end.rotate ( theta , pos );
    }

    @Override
    public void render ( Graphics2D g ) {
        int x1, y1, x2, y2;
        g.setColor ( this.color );
    
            g.setStroke ( this.stroke);
        

        if ( this.width < 0 ) {
            x1 = ( int ) this.end.getX ();
            x2 =  - ( int ) this.width;
        }
        else {
            x1 = ( int ) this.start.getX ();
            x2 = ( int ) this.width;
        }

        if ( this.height < 0 ) {
            y1 = ( int ) this.end.getY ();
            y2 =  - ( int ) this.height;
        }
        else {
            y1 = ( int ) this.start.getY ();
            y2 = ( int ) this.height;
        }

        if ( this.fill ) {
            g.fillRect ( x1 , y1 , x2 , y2 );
            
        }
        else {
            g.drawRect ( x1 , y1 , x2 , y2 );
        }
        
    }

    @Override
    public void setPos ( Vec2 pos ) {
        this.start.add ( pos.subtraction ( this.pos ) );
        this.end.add ( pos.subtraction ( this.pos ) );
        this.pos = pos;

    }

    @Override
    public void onDrag ( MouseEvent e ) {
        this.end.setXY ( e.getX () , e.getY () );

        this.width = this.end.subtraction ( this.start ).getX ();
        this.height = this.end.subtraction ( this.start ).getY ();

        this.pos = this.start.subtraction ( this.end ).scalar ( 0.5 );
    }

    @Override
    public void onLeftPressed ( MouseEvent e ) {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onRightPressed ( MouseEvent e ) {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public boolean onLeftReleased ( MouseEvent e ) {
        this.end.setXY ( e.getX () , e.getY () );

        this.width = this.end.subtraction ( this.start ).getX ();
        this.height = this.end.subtraction ( this.start ).getY ();

        this.pos = this.start.subtraction ( this.end ).scalar ( 0.5 );
        return !(this.height==0&&this.width==0);
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
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
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
