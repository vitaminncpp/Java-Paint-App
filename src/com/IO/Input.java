package com.IO;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.main.Display;
import com.paint.Paint;
import com.statemachine.State;

public class Input implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener, FocusListener {

	private Display panel;

	public int inputState=State.NORMAL;
	private Paint paint;
	
	/*
	 * state = 0 doesn't have any meaning 
	 * state = 10 => Left Mouse Button is kept pressed
	 * 
	 *
	 */
	
	public Input(Display panel,Paint paint) {
		this.panel = panel;
		this.paint=paint;
		this.inputState=State.NORMAL;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//panel.render();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//panel.render();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		//panel.render();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
           

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//panel.render();

		System.out.println("Input | MouseDragged");
		switch(this.inputState) {
		case State.NORMAL:
			System.out.println("Input | MouseDragged | NORMAL");
			break;
		case State.LEFT_PRESSED:
			System.out.println("Input | MouseDragged | LEFT_PRESSED");
			
			this.paint.onDrag(e);
			this.panel.render();
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//panel.render();
                System.out.println ("*******************************Clicked !********************************");
                panel.render();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
            System.out.println ("****************************Pressed***************************");
		System.out.println("Input | Mouse Pressed");
		// TODO Auto-generated method stub
		switch (this.inputState) {
		case State.NORMAL:			
			System.out.println("Input | MousePressed | NORMAL");
			this.inputState=State.LEFT_PRESSED;
			
			this.paint.onLeftPressed(e);
			break;

		case State.LEFT_PRESSED:
			System.out.println("Input | MousePressed | LEFT_PRESSED");
			this.panel.render();
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
            System.out.println ("*******************************Released !********************************");
                
		System.out.println("Input | Mouse Released "+ this.inputState);
		switch (this.inputState) {
		case State.NORMAL:
			System.out.println("Input | Mouse Released | NORMAL");
			break;
		case State.LEFT_PRESSED:
			System.out.println("Input | Mouse Released | LEFT_PRESSED");
			paint.onLeftReleased(e);
			this.inputState=State.NORMAL;
			break;
			

		default:
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//panel.render();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		//panel.render();
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		//panel.render();
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		//panel.render();
	}

}
