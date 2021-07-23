package view.gui.mouse;

import controller.MouseCoordinates;
import controller.ShapeSelection;
import model.ShapeColor;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MousePaintSelect extends MouseAdapter
{
    private MouseCoordinates Point;
    private MouseCoordinates Point1;
    private IApplicationState iApplicationState;
    private InterfaceofShapes geometry;
    //UndoRedoInterface undoRedoInterface = null;
    //Alias selectAlias;
    ArrayList<ShapeColor> shapecolor = new ArrayList();

        public MousePaintSelect(IApplicationState iApplicationState, InterfaceofShapes geometry) {
            this.iApplicationState = iApplicationState;
            this.geometry = geometry;
        }

        @Override
        public void mouseReleased(MouseEvent event)
        {
            Point1 = new MouseCoordinates(event.getX(), event.getY());
            iApplicationState.setPoint1(Point1);
            ShapeSelection newShapeSelection = new ShapeSelection(iApplicationState,geometry);
            newShapeSelection.execute();
            //undoRedoInterface = new ShapeSelection(iApplicationState, geometry);
            //undoRedoInterface.execute();
            //selectAlias = new Alias(undoRedoInterface, iApplicationState, geometry);
            //printAlias(selectAlias);
        }

        @Override
        public void mousePressed(MouseEvent event) {
            Point = new MouseCoordinates(event.getX(), event.getY());
            iApplicationState.setPoint(Point);
        }
        //public static void printAlias(IBorder iBorder)
        //{
            //iBorder.border();
        //}
    }
