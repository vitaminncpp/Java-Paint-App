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
public class Circle extends Shape implements MouseAction {

    private double radius;

    public Circle ( Vec2 pos , double radius , Color color , boolean fill ) {
        super ( pos , color , fill );

        this.radius = radius;

    }

    public void draw ( Graphics g ) {
        
        g.setColor ( this.color );

        g.drawOval ( ( int ) ( this.pos.getX () - this.radius ) , ( int ) ( this.pos.getY () - this.radius ) , ( int ) this.radius * 2 , ( int ) this.radius * 2 );
        if(selected){
            g.setColor ( Color.BLACK);
            g.drawOval ( ( int ) ( this.pos.getX () - this.radius )-1 , ( int ) ( this.pos.getY () - this.radius )-1 , ( int ) this.radius * 2+1 , ( int ) this.radius * 2 +1);
            g.setColor ( Color.WHITE);
            g.drawOval ( ( int ) ( this.pos.getX () - this.radius )-2 , ( int ) ( this.pos.getY () - this.radius )-2 , ( int ) this.radius * 2+2 , ( int ) this.radius * 2 +2);
            g.setColor ( Color.BLACK);
            g.drawOval ( ( int ) ( this.pos.getX () - this.radius )-3 , ( int ) ( this.pos.getY () - this.radius )-3 , ( int ) this.radius * 2+3 , ( int ) this.radius * 2 +3);
           
        }
        
    }

    public void setRadius ( double radius ) {
        this.radius = radius;
    }

    @Override
    public void translate ( Vec2 v ) {
        this.pos.add ( v );
    }

    @Override
    public void scal ( double s ) {
        this.radius *= s;
    }

    @Override
    public void rotate ( double orientation ) {
        throw new UnsupportedOperationException ( "Not supported yet." ); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPos ( Vec2 pos ) {
        this.pos = pos;
    }

    @Override
    public void onDrag ( MouseEvent e ) {
        Vec2 v = this.pos.subtraction ( new Vec2 ( e.getX () , e.getY () ) );
        System.out.println ( "Circle | OnDrag | " + v.getX () + " | " + v.getY () );
        this.radius = v.getR ();

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

        Vec2 v = this.pos.subtraction ( new Vec2 ( e.getX () , e.getY () ) );
        System.out.println ( "Circle | OnLeftRelease | " + v.getR () );
        this.radius = v.getR ();
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

    public void setCenter ( Vec2 center ) {
        this.pos = pos;

    }

//static drawings
    public static void fillOval ( Graphics g , Vec2 center , double a , double b , Color color ) {
        g.setColor ( color );
        g.fillOval ( ( int ) ( center.getX () - a / 2 ) , ( int )( center.getY ()-b / 2)  , ( int )a  , ( int )  b  );

    }

    public static void drawOval ( Graphics g , Vec2 center , double a , double b , Color color ) {
        g.setColor ( color );
        g.drawOval ( ( int ) ( center.getX () - a / 2 ) , ( int ) ( center.getY () - b / 2 ) , ( int ) ( center.getX () + a / 2 ) , ( int ) ( center.getY () + b / 2 ) );

    }

    @Override
    public void render ( Graphics2D g ) {
        if(this.selected){
            g.setStroke ( new BasicStroke(4));
        }
        g.setColor ( this.color );
        if ( this.fill ) {
            g.fillOval ( ( int ) ( this.pos.getX () - this.radius ) , ( int ) ( this.pos.getY () - this.radius ) , ( int ) this.radius * 2 , ( int ) this.radius * 2 );
            g.setColor ( Color.BLACK);
            if(selected){
                g.drawOval ( ( int ) ( this.pos.getX () - this.radius ) , ( int ) ( this.pos.getY () - this.radius ) , ( int ) this.radius * 2 , ( int ) this.radius * 2 );

            }
        }
        else {
            g.drawOval ( ( int ) ( this.pos.getX () - this.radius ) , ( int ) ( this.pos.getY () - this.radius ) , ( int ) this.radius * 2 , ( int ) this.radius * 2 );

        }
        if(this.selected){
            g.setStroke ( new BasicStroke(1));
        }

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
