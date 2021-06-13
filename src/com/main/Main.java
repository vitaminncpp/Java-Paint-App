package com.main;

import java.awt.Cursor;

public class Main { 

    public static void main ( String args[] ) {
        Display display = new Display ();
        display.frame.setVisible ( true );
        display.frame.setCursor (Cursor.CROSSHAIR_CURSOR);
        Navigation navigation=new Navigation (display , display.getInput () ,display. getPaint() );
        navigation.setVisible ( true );
        navigation.setTitle ( "Navigation");
    }
}
