/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

import com.IO.Input;
import com.paint.Paint;
import java.awt.Graphics2D;

/**
 *
 * @author Akshay
 */
public class Display extends Canvas {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Game Windows

    //private Thread thread;
    final JFrame frame;
    private static String title = "Machine";

    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    private static boolean running = false;

    // FPS control
    private long lastTime;
    private long timer;
    private final double ns = 1000000000 / 60;
    private double delta = 0;
    private int frameCount = 0;
    private long now = 0;

    // Graphics
    private BufferStrategy bs;
    public  Graphics gT;
    public Graphics2D g;
    // Game Logic
    private Paint paint;
    private Color background = Color.BLACK;
    // Input
    private Input input;

    public Display () {

        this.paint = new Paint ( this );
        input = new Input ( this , this.paint );

        // Window initialization
        this.frame = new JFrame ( title );
        Dimension size = new Dimension ( WIDTH , HEIGHT );
        this.setPreferredSize ( size );
        this.addMouseListener ( this.input );
        this.addMouseMotionListener ( this.input );
        this.addMouseWheelListener ( this.input );

        this.addKeyListener ( this.input );
        this.addFocusListener ( this.input );

        this.setFocusable ( true );
        this.setFocusTraversalKeysEnabled ( true );

        this.frame.add ( this );
        this.frame.pack ();
        this.frame.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
        this.frame.setLocationRelativeTo ( null );
        this.frame.setResizable ( false );
        this.frame.setVisible ( true );
        // Canvas and Graphics initialization
        bs = this.getBufferStrategy ();
        if ( bs == null ) {
            this.createBufferStrategy ( 3 );
            bs = this.getBufferStrategy ();
        }
        gT = bs.getDrawGraphics ();
        this.g=(Graphics2D)gT;
        // Start the Game
        this.render ();
    }


    public void render () {
        
        this.paint.render (this.g);
        
        bs.show ();
        //g.dispose ();
    }

    private void update () {

        // c.rotateX(.037);
        // c.rotateZ(-.043);
    }

    public void setBack ( Color back ) {
        this.background = back;
    }
    
     
    Input getInput(){
        return this.input;
    }
    
    Paint getPaint(){
        return this.paint;
    }
     
}
