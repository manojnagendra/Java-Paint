package view.gui;

import controller.MouseCoordinates;
import controller.ShapeCreation;
import model.GeometryConfig;
import model.ShapeColor;
import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Drawing extends MouseAdapter {
    private MouseCoordinates Point, Point1;
    private IApplicationState iApplicationState;
    private InterfaceofShapes geometry;
    private GeometryConfig geometryConfig;
    ArrayList<ShapeColor> shapecolor = new ArrayList();

    public Drawing(IApplicationState iApplicationState, InterfaceofShapes geometry, GeometryConfig geometryConfig) {
        this.iApplicationState = iApplicationState;
        this.geometry = geometry;
        this.geometryConfig = geometryConfig;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (iApplicationState.getActiveStartAndEndPointMode() == StartAndEndPointMode.DRAW)
        {
            ShapeColor primaryColor = iApplicationState.getActivePrimaryColor();
            shapecolor.add(primaryColor);
            ShapeColor secondaryColor = iApplicationState.getActiveSecondaryColor();
            shapecolor.add(secondaryColor);

            if (SwingUtilities.isLeftMouseButton(e)) {
                iApplicationState.set_ActivePrimaryColor(shapecolor.get(0));
                iApplicationState.set_ActiveSecondaryColor(shapecolor.get(1));

            } else if (SwingUtilities.isRightMouseButton(e)) {
                iApplicationState.set_ActivePrimaryColor(shapecolor.get(1));
                iApplicationState.set_ActiveSecondaryColor(shapecolor.get(0));
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent event)
    {
        Point1 = new MouseCoordinates(event.getX(), event.getY());
        iApplicationState.setPoint1(Point1);
        StartAndEndPointMode mouseMode = iApplicationState.getActiveStartAndEndPointMode();

        switch (mouseMode) {
            case DRAW:
                ShapeCreation newShape = new ShapeCreation(iApplicationState, geometry, geometryConfig);
                newShape.execute();
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        Point = new MouseCoordinates(event.getX(), event.getY());
        iApplicationState.setPoint(Point);
    }
}