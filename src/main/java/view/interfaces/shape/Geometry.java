package view.interfaces.shape;

import controller.MouseCoordinates;
import model.GeometryConfig;

import java.awt.*;

public interface Geometry {

    void draw(Graphics graph);
    boolean contains(MouseCoordinates point);
    MouseCoordinates getPoint();
    MouseCoordinates getPoint1();
    void sumCoord(int deltacoord);
    void sumCoord1(int deltacoord1);
    void setEnd(MouseCoordinates End);
    void setStart(MouseCoordinates Start);
    MouseCoordinates getStart();
    MouseCoordinates getEnd();
    GeometryConfig getGeometryConfig();
    int getShapeWidth();
    int getShapeHeight();
}
