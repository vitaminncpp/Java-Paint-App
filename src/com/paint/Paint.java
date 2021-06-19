package com.paint;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

import com.IO.MouseAction;
import com.main.Display;
import com.math.Vec2;
import com.shapes.Brush;
import com.shapes.Circle;
import com.shapes.Shape;
import com.shapes.Line;
import com.shapes.Rect;
import com.statemachine.State;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Paint implements MouseAction {
	public final Display panel;
	
        
        private int itemSelected=-1;
        private final List<Shape> model;
        private final List<Shape> view;
        
        
	private Shape currShape;
	public int shapeState = 0;
        public Color currColor;
        public Color background;
        public boolean fill;
        public double strokeSize;
        public double zoom;
        public Vec2 pan;
	public Paint(Display panel) {
            this.model = new ArrayList<Shape>();
            this.view=new ArrayList<Shape>();
            this.panel = panel;
            this.shapeState = State.CIRCLE_SELECTED;
            this.currColor=Color.BLACK;
            this.background=Color.WHITE;
            this.fill=false;
            this.strokeSize=20;
            
            
            
            this.zoom=1;
            this.pan=new Vec2(0,0);
	}

	public void add(Shape shape) {
		this.model.add(shape);
	}

	public void render(Graphics2D g) {
            System.out.println("Paint | render ");
            g.setColor(this.background);
            g.fillRect ( 0, 0, Display.WIDTH+10, Display.HEIGHT+10);
		for (int i = 0; i < this.model.size(); i++) {
		model.get(i).render(g);
		}
		if(currShape==null) {
			return;
		}
		this.currShape.render(g);
	}

	@Override
	public void onDrag(MouseEvent e) {
		System.out.println("Paint | onDrag");
		switch (this.shapeState) {
		case State.NONE_SELECTED:
			
			break;
		case State.LINE_SELECTED:
			System.out.println("Paint | onDrag | LINE_SELECTED");
			this.currShape.onDrag(e);
			this.panel.render();
			break;
                case State.CIRCLE_SELECTED:
                    System.out.println("Paint | onDrag | CIRCLE_SELECTED");
                    this.currShape.onDrag ( e );
                    this.panel.render();
                    break;
                case State.RECT_SELECTED:
                    System.out.println("Paint | onDrag | RECT_SELECTED");
                    this.currShape.onDrag ( e );
                    this.panel.render();
                    break;
                case State.BRUSH_SELETED:
                    System.out.println("Paint | onDrag | BRUSH_SELECTED");
                    this.currShape.onDrag ( e );
                    this.panel.render ();
                    break;
		default:
			break;
		}

	}

        

	@Override
	public void onLeftPressed(MouseEvent e) {
		switch (this.shapeState) {
		case State.NONE_SELECTED:
			
			break;
		case State.LINE_SELECTED:
			this.currShape = new Line(new Vec2(e.getX(), e.getY()), new Vec2(e.getX(), e.getY()), this.currColor,this.fill,this.strokeSize);
                        
			break;
                case State.CIRCLE_SELECTED:
                    this.currShape=new Circle(new Vec2(e.getX() ,e.getY ()),5,this.currColor,this.fill,this.strokeSize);
                    break;
                case State.RECT_SELECTED:
                    this.currShape=new Rect(new Vec2(e.getX() ,e.getY ()),new Vec2(e.getX() ,e.getY ()),this.currColor,this.fill,this.strokeSize);
                    break;
                
                case State.BRUSH_SELETED:
                    System.out.println ("Paint | onLeftPress | BRUSH_SELECTED | "+this.strokeSize);
                    this.currShape=new Brush(new Vec2(e.getX (),e.getY ()),this.currColor,false,this.strokeSize);
                    break;
                default:
                       break;
		}

	}

	@Override
	public void onRightPressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onLeftReleased(MouseEvent e) {

            if(this.shapeState==State.NONE_SELECTED){
                return false;
            }
		if(this.currShape.onLeftReleased(e)){
                    this.addCurrent();
                    this.panel.render();
                    return true;
                    
                }
		
		//this.shapeState=State.NONE_SELECTED;
		this.currShape=null;
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
	
	public void addCurrent() {
		System.out.println("Paint | addCCurrent");
		if(this.currShape==null ) {
			return;
		}
		this.model.add(this.currShape);
                this.view.add(this.currShape);
                currShape.unSelect ();
		this.currShape=null;
	}
        
      public void zoom(double s,Vec2 v){
          for(int i=0;i<this.view.size();i++){
              this.view.get(i).scal ( s,v);
          }
      }
      
      public void setSelected(int select){
          this.view.get ( this.itemSelected ).unSelect();
          this.view.get ( select ).select();
          this.itemSelected=select;
      }
      public int getSelected(){
          return this.itemSelected;
      }
}
