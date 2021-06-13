package com.shapes;

import java.awt.Color;
import java.awt.Graphics;

import com.IO.MouseAction;
import com.math.Vec2;

public abstract class Shape implements MouseAction{
	protected Vec2 pos;
	protected Color color;
	protected boolean fill;
        
	public Shape(Vec2 pos,Color color,boolean fill) {
		this.pos=pos;
		this.color=color;
                this.fill=fill;
	}
	

	public abstract void translate(Vec2 v);
	public abstract void scal(double s);
        public abstract void scal(double s,Vec2 v);
	public abstract void rotate(double orientation);
	public abstract void render(Graphics g);
	public void setColor(Color color) {
		this.color=color;
		
	}
	
	public abstract void setPos(Vec2 pos);
	
	
	


	public Color getColor() {
		return color;
		
	}

	public Vec2 getPos() {
		return pos;
	}

    /**
     *
     * @return
     */
	public abstract Shape getCopy(); 

    /**
     *
     * @return
     */
    @Override
        public abstract String toString();
}
