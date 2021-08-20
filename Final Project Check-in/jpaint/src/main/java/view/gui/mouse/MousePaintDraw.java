package view.gui.mouse;

import controller.MouseCoordinates;
import controller.shapeactions.ShapeCreate;
import model.GeometryConfig;
import model.ShapeColor;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MousePaintDraw extends MouseAdapter {
        private InterfaceofShapes geometry;
        private GeometryConfig geometryConfig;
        ArrayList<ShapeColor> shapecolor = new ArrayList();
        private MouseCoordinates Point;
        private MouseCoordinates Point1;
        private IApplicationState iApplicationState;


        public MousePaintDraw(IApplicationState iApplicationState, InterfaceofShapes geometry, GeometryConfig geometryConfig) {
            this.iApplicationState = iApplicationState;
            this.geometry = geometry;
            this.geometryConfig = geometryConfig;
        }

        @Override
        public void mouseClicked(MouseEvent event) {

            ShapeColor primaryColor = iApplicationState.getActivePrimaryColor();
            shapecolor.add(primaryColor);
            ShapeColor secondaryColor = iApplicationState.getActiveSecondaryColor();
            shapecolor.add(secondaryColor);

            if (SwingUtilities.isLeftMouseButton(event)) {
                iApplicationState.set_ActivePrimaryColor(shapecolor.get(0));
                iApplicationState.set_ActiveSecondaryColor(shapecolor.get(1));

            } else if (SwingUtilities.isRightMouseButton(event)) {
                iApplicationState.set_ActivePrimaryColor(shapecolor.get(1));
                iApplicationState.set_ActiveSecondaryColor(shapecolor.get(0));
            }
        }

        @Override
        public void mouseReleased(MouseEvent event) {
            Point1 = new MouseCoordinates(event.getX(), event.getY());
            iApplicationState.setPoint1(Point1);
            ShapeCreate newShape = new ShapeCreate(iApplicationState, geometry, geometryConfig);
            newShape.implement();
        }

        @Override
        public void mousePressed(MouseEvent event) {
            Point = new MouseCoordinates(event.getY(), event.getY());
            iApplicationState.setPoint(Point);
        }
    }

