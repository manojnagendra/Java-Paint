package model.interfaces;

import controller.MouseCoordinates;
import model.*;
import view.interfaces.shape.MouseAdapterInterface;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    TypeOfShading getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();

    GeometryConfig getGeometryConfiguration1();

    GeometryConfig getGeometryConfiguration();

    void setPoint(MouseCoordinates point);
    void setPoint1(MouseCoordinates point1);
    MouseCoordinates getPoint();
    MouseCoordinates getPoint1();
    MouseCoordinates getStart();
    MouseCoordinates getEnd();
    void set_ActivePrimaryColor(ShapeColor activePrimaryColor);
    void set_ActiveSecondaryColor(ShapeColor activeSecondaryColor);
    void mousereg(MouseAdapterInterface m);
    void mousenotify();

}
