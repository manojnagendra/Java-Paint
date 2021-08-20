package controller.copypastedelete;

import controller.CommandHistory;
import controller.undoredo.UndoRedoInterface;
import model.GeometryConfig;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import model.interfaces.UndoRedo;
import view.interfaces.shape.Geometry;

import java.util.ArrayList;

public class DeleteTheShapes implements UndoRedo, UndoRedoInterface {
    ArrayList<Geometry> ShapesSelection;
    private GeometryConfig geometryConfig;
    private InterfaceofShapes geometry;
    private IApplicationState iApplicationState;

    public DeleteTheShapes(IApplicationState iApplicationState, InterfaceofShapes geometry, GeometryConfig geometryConfig) {
        this.iApplicationState = iApplicationState;
        this.geometryConfig = geometryConfig;
        this.geometry = geometry;
    }

    public void implement() {
        ShapesSelection = geometry.getShapesSelected();
        if(ShapesSelection.isEmpty())
        {
            System.out.println("There are no shapes that are selected in the canvas");
        }
        CommandHistory.add(this);
        for (Geometry shape : ShapesSelection) {
            geometry.removingshape(shape);
            geometry.Notify();
            System.out.println("The shapes are now deleted");
        }
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        for(Geometry shape : ShapesSelection) {
            geometry.addingshape(shape);
        }
    }
    @Override
    public void redo() {
        for(Geometry shape : ShapesSelection) {
            geometry.removingshape(shape);
        }
    }

}

