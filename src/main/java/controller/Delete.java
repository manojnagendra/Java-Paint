package controller;

import model.GeometryConfig;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import model.interfaces.UndoRedo;
import view.interfaces.Geometry;

import java.util.ArrayList;

public class Delete implements UndoRedo, UndoRedoInterface {
    private InterfaceofShapes geometry;
    private IApplicationState iApplicationState;
    private GeometryConfig geometryConfig;
    ArrayList<Geometry> ShapesSelection;

    public Delete(IApplicationState iApplicationState, InterfaceofShapes geometry, GeometryConfig geometryConfig) {
        this.iApplicationState = iApplicationState;
        this.geometryConfig = geometryConfig;
        this.geometry = geometry;
    }

    public void execute() {

        ShapesSelection = geometry.get_Geometry();
        for (Geometry shape : ShapesSelection) {
            geometry.removingshape(shape);
            geometry.Notify();
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

