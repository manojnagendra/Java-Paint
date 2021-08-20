package view.gui.mouse;

import controller.MouseCoordinates;
import controller.shapeactions.ShapeMove;
import model.GeometryConfig;
import model.ShapeColor;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MousePaintMove extends MouseAdapter {
    private InterfaceofShapes geometry;
    private GeometryConfig geometryConfig;
    ArrayList<ShapeColor> shapecolor = new ArrayList();
    private MouseCoordinates Point;
    private MouseCoordinates Point1;
    private IApplicationState iApplicationState;

    public MousePaintMove(IApplicationState iApplicationState, InterfaceofShapes geometry, GeometryConfig geometryConfig) {
        this.iApplicationState = iApplicationState;
        this.geometry = geometry;
        this.geometryConfig = geometryConfig;
    }

    @Override
    public void mouseReleased(MouseEvent event) {

        Point1 = new MouseCoordinates(event.getX(), event.getY());
        iApplicationState.setPoint1(Point1);
        ShapeMove newMoveShape = new ShapeMove(iApplicationState, geometry);
        newMoveShape.implement();
    }

    @Override
    public void mousePressed(MouseEvent event) {
        Point = new MouseCoordinates(event.getX(), event.getY());
        iApplicationState.setPoint(Point);
    }
}
