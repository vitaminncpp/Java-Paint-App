package com.IO;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public interface MouseAction {

    public void onDrag ( MouseEvent e );

    public void onLeftPressed ( MouseEvent e );

    public void onRightPressed ( MouseEvent e );

    public void onLeftReleased ( MouseEvent e );

    public void onRightReleased ( MouseEvent e );

    public void onMouseWheelUp ( MouseWheelEvent e );

    public void onMouseWheelDown ( MouseWheelEvent e );
}
