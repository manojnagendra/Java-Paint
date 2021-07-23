package controller;

import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import model.interfaces.UndoRedo;
import view.interfaces.Geometry;

import java.awt.*;
import java.util.ArrayList;

public class ShapeMove implements UndoRedoInterface, UndoRedo {
    private Graphics2D graphics2D;
    private IApplicationState iApplicationState;
    private InterfaceofShapes geometry;
    private Geometry old_shape;
    private Geometry new_shape;
    private ArrayList<Geometry> temporaryShapeList;

    public ShapeMove(IApplicationState iApplicationState, InterfaceofShapes geometry) {
        this.iApplicationState = iApplicationState;
        this.geometry = geometry;
    }

    @Override
    public void execute() {

        temporaryShapeList = new ArrayList<Geometry>();

        int dx = iApplicationState.getPoint1().getCoord() - iApplicationState.getPoint().getCoord();
        int dy = iApplicationState.getPoint1().getCoord1() - iApplicationState.getPoint().getCoord();

        for (Geometry ShapesSelected : geometry.getShapesSelected())
        {
            old_shape = ShapesSelected;
            temporaryShapeList.add(old_shape);
            geometry.removingshape(old_shape);

            for (Geometry tempShape : temporaryShapeList)
            {
                tempShape.sumCoord(dx);
                tempShape.sumCoord1(dy);
                new_shape = tempShape;
                geometry.addingshape(new_shape);
            }
            temporaryShapeList.clear();
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        geometry.removingshape(new_shape);
        geometry.addingshape(old_shape);
    }

    @Override
    public void redo() {
        geometry.addingshape(new_shape);
        geometry.removingshape(old_shape);
    }
}