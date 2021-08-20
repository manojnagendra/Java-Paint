package view.interfaces.shape;

import model.TypeOfShading;
import model.ShapeType;

public interface ShapeShading {
        void draw_ShadedShape();
        TypeOfShading shape_ShadingType();
        ShapeType get_ShapeType();
}
