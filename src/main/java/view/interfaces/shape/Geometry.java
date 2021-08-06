package view.interfaces.shape;

import controller.MouseCoordinates;
import model.GeometryConfig;

import java.awt.*;

public interface Geometry {

    void draw(Graphics graph);
    boolean contains(MouseCoordinates point);
    MouseCoordinates getThefirstpoint();
    MouseCoordinates getThesecondpoint();
    void sumCoord(int deltacoord);
    void sumCoord1(int deltacoord1);
    void setEndingpoint(MouseCoordinates End);
    void setStartingpoint(MouseCoordinates Start);
    MouseCoordinates getStartingpoint();
    MouseCoordinates getEndingpoint();
    GeometryConfig getGeometryConfig();
    int getShapeWidth();
    int getShapeHeight();
}
