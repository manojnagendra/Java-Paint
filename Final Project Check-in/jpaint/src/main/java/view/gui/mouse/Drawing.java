package view.gui.mouse;

import controller.MouseCoordinates;
import controller.shapeactions.ShapeCreate;
import controller.shapeactions.ShapeMove;
import controller.shapeactions.ShapeSelect;
import model.GeometryConfig;
import model.ShapeColor;
import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Drawing extends MouseAdapter {
    ArrayList<ShapeColor> shapecolor = new ArrayList();
    private InterfaceofShapes geometry;
    private GeometryConfig geometryConfig;
    private MouseCoordinates Point, Point1;
    private IApplicationState iApplicationState;

    public Drawing(IApplicationState iApplicationState, InterfaceofShapes geometry, GeometryConfig geometryConfig) {
        this.iApplicationState = iApplicationState;
        this.geometry = geometry;
        this.geometryConfig = geometryConfig;
    }

    @Override
    public void mousePressed(MouseEvent event) {
        Point = new MouseCoordinates(event.getX(), event.getY());
        iApplicationState.setPoint(Point);
    }

    @Override
    public void mouseReleased(MouseEvent event)
    {
        Point1 = new MouseCoordinates(event.getX(), event.getY());
        iApplicationState.setPoint1(Point1);
        StartAndEndPointMode mouseMode = iApplicationState.getActiveStartAndEndPointMode();

        switch (mouseMode) {
            case DRAW:
                ShapeCreate newShape = new ShapeCreate(iApplicationState, geometry, geometryConfig);
                newShape.implement();
                break;
            case MOVE:
                ShapeMove newMoveShape = new ShapeMove(iApplicationState, geometry);
                newMoveShape.implement();
                break;
            case SELECT:
                ShapeSelect newSelectShape = new ShapeSelect(iApplicationState, geometry);
                newSelectShape.implement();
                break;
        }
    }
}
