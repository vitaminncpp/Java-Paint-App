package com.IO;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public interface MouseAction {

    void onDrag(MouseEvent e);

    void onLeftPressed(MouseEvent e);

    void onRightPressed(MouseEvent e);

    /**
     * @param e
     * @return
     */
    boolean onLeftReleased(MouseEvent e);

    void onRightReleased(MouseEvent e);

    void onMouseWheelUp(MouseWheelEvent e);

    void onMouseWheelDown(MouseWheelEvent e);
}
