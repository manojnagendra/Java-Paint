package controller;

import model.GeometryConfig;
import model.ShapeType;
import model.interfaces.BorderInterface;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import view.gui.shapes.EllipseBorder;
import view.gui.shapes.RectangleBorder;
import view.gui.shapes.TriangleBorder;
import view.interfaces.shape.Geometry;

public class BorderClass implements BorderInterface {
    private GeometryConfig geometryConfig;
    private IApplicationState iApplicationState;
    private Geometry shape1;
    private InterfaceofShapes interfaceofShapes;


    public BorderClass(IApplicationState iApplicationState, InterfaceofShapes interfaceofShapes) {
        this.interfaceofShapes = interfaceofShapes;
        this.iApplicationState = iApplicationState;
    }

    @Override
    public void border() {
        geometryConfig = iApplicationState.getGeometryConfiguration();
        ShapeType shapeType = geometryConfig.getShapeType();

        for (Geometry shape : interfaceofShapes.getShapesSelected()) {
            if (shapeType.equals(ShapeType.RECTANGLE)) {
                shape1 = new RectangleBorder(geometryConfig, shape.getStartingpoint().getCoord(), shape.getStartingpoint().getCoord1(),
                        shape.getShapeWidth(), shape.getShapeHeight());
                this.interfaceofShapes.addingshape(shape1);
            } else if (shapeType.equals(ShapeType.ELLIPSE)) {
                shape1 = new EllipseBorder(geometryConfig, shape.getStartingpoint().getCoord(), shape.getStartingpoint().getCoord1(),
                        shape.getShapeWidth(), shape.getShapeHeight());
                this.interfaceofShapes.addingshape(shape1);
            } else if (shapeType.equals(ShapeType.TRIANGLE)) {
                shape1 = new TriangleBorder(geometryConfig, shape.getStartingpoint().getCoord(), shape.getStartingpoint().getCoord1(),
                        shape.getEndingpoint().getCoord(), shape.getEndingpoint().getCoord1());
                this.interfaceofShapes.addingshape(shape1);
            } else {
            }

        }
    }
}


