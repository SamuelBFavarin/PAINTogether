/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PAINTogether.listener;

import PAINTogether.components.Drawer;
import PAINTogether.dispatcher.ServerDispatcher;
import PAINTogether.swingGUI.room_form_class.DrawArea;
import PAINTogether.utils.Settings;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author samuel
 */
public class DrawMouseListener extends MouseAdapter {
    private DrawArea drawArea;

    public DrawMouseListener(DrawArea drawArea) {
        this.drawArea = drawArea;

        drawArea.addMouseListener(this);
        drawArea.addMouseMotionListener(this);
    }

    private void mouseDown(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e) && !SwingUtilities.isRightMouseButton(e))
            Drawer.getInstance().drawBrush(e.getX(), e.getY(), false);
        else if (SwingUtilities.isRightMouseButton(e) && !SwingUtilities.isLeftMouseButton(e))
            Drawer.getInstance().drawBrush(e.getX(), e.getY(), true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseDown(e);
        drawArea.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseDown(e);
        drawArea.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (Settings.getInstance().isOnline())
            ServerDispatcher.getInstance().dispatch();
    }

}
