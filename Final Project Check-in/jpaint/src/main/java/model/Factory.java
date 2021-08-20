package model;

import view.gui.shapes.Ellipse;
import view.gui.shapes.Rectangle;
import view.gui.shapes.Triangle;
import view.interfaces.shape.Geometry;

public class Factory {

    public Geometry shapecreation(GeometryConfig geometryConfig)
    {
        ShapeType shapeType = geometryConfig.getShapeType();
        Geometry objectshape = null;
        if(shapeType.equals(ShapeType.RECTANGLE)) {
            System.out.println("Success! You have drawn a rectangle");
            objectshape = new Rectangle(geometryConfig);
        }
        else if(shapeType.equals(ShapeType.ELLIPSE))
        {
            System.out.println("Success! You have drawn an ellipse");
            objectshape = new Ellipse(geometryConfig);
        }
        else if(shapeType.equals(ShapeType.TRIANGLE))
        {
            System.out.println("Success! You have drawn a triangle");
            objectshape = new Triangle(geometryConfig);
        }
        return objectshape;
    }
}
