package model;

import view.gui.Rectangle;
import view.interfaces.Geometry;

public class FactoryPattern {
    private Object GeometryConfig;

    public static Geometry shapecreation(GeometryConfig geometryConfig)
    {
        ShapeType shapeType = geometryConfig.getShapeType();
        Geometry objectshape = null;
        if(shapeType.equals(ShapeType.RECTANGLE)) {
            System.out.println("Success! You have drawn a rectangle");
            objectshape = new Rectangle(geometryConfig);
        }
        return objectshape;
    }
}
