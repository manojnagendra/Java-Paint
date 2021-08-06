package controller.copypastedelete;

import controller.UndoRedoInterface;
import model.GeometryConfig;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import view.interfaces.shape.Geometry;

import java.util.ArrayList;

public class CopyTheShapes implements UndoRedoInterface {
    private InterfaceofShapes geometry;
    private IApplicationState iApplicationState;
    private GeometryConfig geometryConfig;

    public CopyTheShapes(IApplicationState iApplicationState, InterfaceofShapes geometry, GeometryConfig geometryConfig)
    {
        this.iApplicationState = iApplicationState;
        this.geometryConfig = geometryConfig;
        this.geometry = geometry;
    }

    @Override
    public void execute()
    {
        for(Geometry shape: geometry.getShapesSelected())
        {
            geometry.addingtoboard(shape);
        }
        System.out.println("Copy Action Done:" + geometry.get_boardshapes().size());
    }
}
