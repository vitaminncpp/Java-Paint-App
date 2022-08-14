/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.IO.Input;
import com.paint.Paint;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * @author Akshay
 */
public class Display extends Canvas {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    // Game Windows
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    private static final String title = "Machine";
    private static final boolean running = false;
    //private Thread thread;
    final JFrame frame;
    private final double ns = 1000000000 / 60;
    public Graphics gT;
    public Graphics2D g;
    // FPS control
    private long lastTime;
    private long timer;
    private final double delta = 0;
    private final int frameCount = 0;
    private final long now = 0;
    // Graphics
    private BufferStrategy bs;
    // Game Logic
    private final Paint paint;
    private Color background = Color.BLACK;
    // Input
    private final Input input;

    public Display() {

        this.paint = new Paint(this);
        input = new Input(this, this.paint);

        // Window initialization
        this.frame = new JFrame(title);
        Dimension size = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(size);
        this.addMouseListener(this.input);
        this.addMouseMotionListener(this.input);
        this.addMouseWheelListener(this.input);

        this.addKeyListener(this.input);
        this.addFocusListener(this.input);

        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(true);

        this.frame.add(this);
        this.frame.pack();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
        // Canvas and Graphics initialization
        bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            bs = this.getBufferStrategy();
        }
        gT = bs.getDrawGraphics();
        this.g = (Graphics2D) gT;
        // Start the Game
        this.render();
    }


    public void render() {

        this.paint.render(this.g);

        bs.show();
        //g.dispose ();
    }

    private void update() {

        // c.rotateX(.037);
        // c.rotateZ(-.043);
    }

    public void setBack(Color back) {
        this.background = back;
    }


    Input getInput() {
        return this.input;
    }

    Paint getPaint() {
        return this.paint;
    }

}
