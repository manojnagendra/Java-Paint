package controller.shapeactions;

import controller.CommandHistory;
import controller.undoredo.UndoRedoInterface;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import model.interfaces.UndoRedo;
import view.interfaces.shape.Geometry;

import java.util.ArrayList;

public class ShapeMove implements UndoRedoInterface, UndoRedo {
    private Geometry shape1;
    private Geometry shape2;
    private ArrayList<Geometry> shape3;
    private IApplicationState iApplicationState;
    private InterfaceofShapes geometry;

    public ShapeMove(IApplicationState iApplicationState, InterfaceofShapes geometry) {
        this.iApplicationState = iApplicationState;
        this.geometry = geometry;
    }

    @Override
    public void implement() {

        shape3 = new ArrayList<>();

        int deltax = iApplicationState.getPoint1().getCoord() - iApplicationState.getPoint().getCoord();
        int deltay = iApplicationState.getPoint1().getCoord1() - iApplicationState.getPoint().getCoord1();

        for (Geometry ShapesSelected : geometry.getShapesSelected())
        {
            shape1 = ShapesSelected;
            shape3.add(shape1);
            geometry.removingshape(shape1);

            for (Geometry interim : shape3)
            {
                interim.sumCoord(deltax);
                interim.sumCoord1(deltay);
                shape2 = interim;
                geometry.addingshape(shape2);
            }
            shape3.clear();
        }
        System.out.println("The shape(s) have been moved");
    }

    @Override
    public void undo() {
        geometry.removingshape(shape2);
        geometry.addingshape(shape1);
        CommandHistory.add(this);
    }

    @Override
    public void redo() {
        geometry.addingshape(shape2);
        geometry.removingshape(shape1);
        CommandHistory.add(this);
    }
}
