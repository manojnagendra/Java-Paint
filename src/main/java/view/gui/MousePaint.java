package view.gui;

import model.GeometryConfig;
import model.Geometry;
import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import view.interfaces.MouseAdapterInterface;

import javax.swing.*;
import java.awt.Cursor;
import java.awt.event.MouseListener;

public class MousePaint extends JFrame implements MouseAdapterInterface {
    private IApplicationState iApplicationState;
    private PaintCanvas paintCanvas;
    private InterfaceofShapes geometry;
    private GeometryConfig geometryConfig;

    public MousePaint(IApplicationState iApplicationState, PaintCanvas paintCanvas, InterfaceofShapes geometry, GeometryConfig geometryConfig) {
        this.iApplicationState = iApplicationState;
        this.paintCanvas = paintCanvas;
        this.geometry = geometry;
        this.geometryConfig = geometryConfig;
        iApplicationState.mousereg(this);
    }

    public void execute() {

        MouseListener[] mouseListeners = paintCanvas.getMouseListeners();
        for (MouseListener mouseListener : mouseListeners) {
            paintCanvas.removeMouseListener(mouseListener);
        }

        StartAndEndPointMode startAndEndPointMode = iApplicationState.getActiveStartAndEndPointMode();
        if (startAndEndPointMode.equals(StartAndEndPointMode.DRAW)) {
            paintCanvas.setCursor((new Cursor(Cursor.CROSSHAIR_CURSOR)));
            paintCanvas.addMouseListener(new MousePaintDraw(iApplicationState, geometry, geometryConfig));
        }
    }
}