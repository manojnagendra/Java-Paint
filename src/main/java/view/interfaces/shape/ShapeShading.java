package view.interfaces.shape;

import model.ShapeShadingType;
import model.ShapeType;

public interface ShapeShading {
        void draw_ShadedShape();
        ShapeShadingType shape_ShadingType();
        ShapeType get_ShapeType();
}
