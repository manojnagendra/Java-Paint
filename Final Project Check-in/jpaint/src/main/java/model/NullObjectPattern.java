package model;

import controller.MouseCoordinates;
import view.interfaces.shape.Geometry;

import java.awt.*;

public class NullObjectPattern implements Geometry
{
    @Override
    public void draw(Graphics graph) {
        System.out.println("Null");
    }

    @Override
    public boolean contains(MouseCoordinates point) {
        return false;
    }

    @Override
    public MouseCoordinates getThefirstpoint() {
        return null;
    }

    @Override
    public MouseCoordinates getThesecondpoint() {
        return null;
    }

    @Override
    public void sumCoord(int deltacoord) {
    System.out.println("Here, there are no Coordinates for Coord");
    }

    @Override
    public void sumCoord1(int deltacoord1) {
        System.out.println("Here, there are no Coordinates for Coord1");

    }

    @Override
    public void setEndingpoint(MouseCoordinates End) {
        System.out.println("Here, there are no coordinates for Ending point");
    }

    @Override
    public void setStartingpoint(MouseCoordinates Start) {
        System.out.println("Here, there are no coordinates for Starting point");

    }

    @Override
    public MouseCoordinates getStartingpoint() {
        return null;
    }

    @Override
    public MouseCoordinates getEndingpoint() {
        return null;
    }

    @Override
    public GeometryConfig getGeometryConfig() {
        return null;
    }

    @Override
    public int getShapeWidth() {
        return 0;
    }

    @Override
    public int getShapeHeight() {
        return 0;
    }
}
