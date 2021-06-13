package com.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import com.math.Vec2;

public class Line extends Shape {

    Vec2 start;
    Vec2 end;

    public Line ( Vec2 start , Vec2 end , Color color , boolean fill ) {

        super ( start.addition ( end ).scalar ( .5 ) , color , fill );
        this.start = start;
        this.end = end;

    }

    @Override
    public void render ( Graphics g ) {

        g.setColor ( this.color );
        g.drawLine ( ( int ) this.start.getX () , ( int ) this.start.getY () , ( int ) this.end.getX () , ( int ) this.end.getY () );
    }

    @Override
    public void translate ( Vec2 v ) {
        this.start.add ( v );
        this.end.add ( v );
        this.pos.add ( v );
    }

    @Override
    public void scal ( double s ) {
        // TODO Auto-generated method stub
        this.start.scal ( s );
        this.end.scal ( s );
    }

    @Override
    public void rotate ( double orientation ) {
        // TODO Auto-generated method stub
        this.start.rotate ( orientation , this.pos );
        this.end.rotate ( orientation , this.pos );
    }

    @Override
    public void setPos ( Vec2 pos ) {
        // TODO Auto-generated method stub
        Vec2 v = pos.subtraction ( this.pos );
        this.translate ( v );

    }

    public void getLenght () {
        this.start.subtraction ( end ).getR ();

    }

    public void setEnd ( Vec2 end ) {
        this.end = end;
        this.pos = this.start.addition ( end ).scalar ( .5 );
    }

    public void setEnd ( int x , int y ) {
        this.end.setXY ( x , y );
        this.pos = this.start.addition ( end ).scalar ( .5 );
    }

    @Override
    public void onDrag ( MouseEvent e ) {
        System.out.println ( "Line | onDrag" );
        this.end.setXY ( e.getX () , e.getY () );

    }

    @Override
    public void onLeftPressed ( MouseEvent e ) {
        this.setEnd ( new Vec2 ( e.getX () , e.getY () ) );

    }

    @Override
    public void onRightPressed ( MouseEvent e ) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onLeftReleased ( MouseEvent e ) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onRightReleased ( MouseEvent e ) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onMouseWheelUp ( MouseWheelEvent e ) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onMouseWheelDown ( MouseWheelEvent e ) {
        // TODO Auto-generated method stub

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
