package controller.copypastedelete;

import controller.CommandHistory;
import controller.shapeactions.ShapeCreate;
import controller.undoredo.UndoRedoInterface;
import model.GeometryConfig;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import model.interfaces.UndoRedo;
import view.interfaces.shape.Geometry;

import java.util.ArrayList;

public class PasteTheShapes implements UndoRedoInterface, UndoRedo {
    private IApplicationState iApplicationState;
    private final ArrayList<Geometry> interimshape = new ArrayList<>();
    private GeometryConfig geometryConfig;
    private InterfaceofShapes geometry;
    private Geometry shape1;

    public PasteTheShapes(IApplicationState iApplicationState, InterfaceofShapes geometry, GeometryConfig geometryConfig)
    {
        this.iApplicationState = iApplicationState;
        this.geometryConfig = geometryConfig;
        this.geometry = geometry;
    }

    public void implement() {
        for (Geometry shapeselected : geometry.getShapesSelected()) {
            shape1 = shapeselected;
            shapeselected.sumCoord(300);
            shapeselected.sumCoord1(300);
            ShapeCreate shape = new ShapeCreate(iApplicationState, geometry, shapeselected.getGeometryConfig());
            interimshape.add(shape.factory.shapecreation(shapeselected.getGeometryConfig()));
        }
        for (Geometry shapeselected : interimshape) {
            geometry.addingshape(shapeselected);
        }
        CommandHistory.add(this);
        System.out.println("Paste Action Done");
    }
        @Override
        public void undo() {
            geometry.removingshape(shape1);
        }
        @Override
        public void redo() {
            geometry.addingshape(shape1);
        }
    }
