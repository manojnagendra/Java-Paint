package view.gui.mouse;

import controller.OutlineShapes.BorderAlias;
import controller.MouseCoordinates;
import controller.shapeactions.ShapeSelect;
import controller.undoredo.UndoRedoInterface;
import model.ShapeColor;
import model.interfaces.BorderInterface;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MousePaintSelect extends MouseAdapter
{
    ArrayList<ShapeColor> shapecolor = new ArrayList();
    UndoRedoInterface undoRedoInterface=null;
    BorderAlias borderAlias;
    private IApplicationState iApplicationState;
    private InterfaceofShapes geometry;
    private MouseCoordinates Point;
    private MouseCoordinates Point1;

        public MousePaintSelect(IApplicationState iApplicationState, InterfaceofShapes geometry) {
            this.iApplicationState = iApplicationState;
            this.geometry = geometry;
        }

        @Override
        public void mouseReleased(MouseEvent event)
        {
            Point1 = new MouseCoordinates(event.getX(), event.getY());
            iApplicationState.setPoint1(Point1);
            undoRedoInterface = new ShapeSelect(iApplicationState, geometry);
            undoRedoInterface.implement();
            borderAlias = new BorderAlias(undoRedoInterface, iApplicationState, geometry);
            printBorder(borderAlias);

        }

        @Override
        public void mousePressed(MouseEvent event) {
            Point = new MouseCoordinates(event.getX(), event.getY());
            iApplicationState.setPoint(Point);
        }

        public static void printBorder(BorderInterface borderInterface)
        {
            borderInterface.border();
        }
    }

