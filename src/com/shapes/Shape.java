package com.shapes;

import java.awt.Color;
import java.awt.Graphics;

import com.IO.MouseAction;
import com.math.Vec2;
import java.awt.Graphics2D;

public abstract class Shape implements MouseAction{
	protected Vec2 pos;
	protected Color color;
	protected boolean fill;
        protected boolean selected=true;
	public Shape(Vec2 pos,Color color,boolean fill) {
		this.pos=pos;
		this.color=color;
                this.fill=fill;
                this.selected=true;
	}
	

	public abstract void translate(Vec2 v);
	public abstract void scal(double s);
        public abstract void scal(double s,Vec2 v);
	public abstract void rotate(double orientation);
	public abstract void render(Graphics2D g);
	public void setColor(Color color) {
		this.color=color;
		
	}
	
	public abstract void setPos(Vec2 pos);
	
	
        public void unSelect(){
            this.selected=false;
        }
        
        public void select(){
            this.selected=true;
        }
	
        
        public boolean isSelected(){
            return this.selected;
        }


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
