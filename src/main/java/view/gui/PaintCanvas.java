package view.gui;

import model.interfaces.InterfaceofObserver;
import model.interfaces.InterfaceofShapes;
import view.interfaces.Geometry;

import javax.swing.JComponent;
import java.awt.*;

public class PaintCanvas extends JComponent implements InterfaceofObserver {
    private final InterfaceofShapes geometry;

    public PaintCanvas(InterfaceofShapes geometry) {
        this.geometry = geometry;
        geometry.notification(this);
    }

    @Override
    public void updating() {
    repaint();
    }

    @Override
    protected void paintComponent(Graphics graph) {
        for (Geometry shape: geometry.get_Geometry()) {
            shape.draw(graph);
        }
    }
    public Graphics2D getGraphics2D() {
        return (Graphics2D) getGraphics();
    }
}
