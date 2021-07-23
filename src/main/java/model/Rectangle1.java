package view.gui.shapes;

import controller.MouseCoordinates;
import model.*;
import model.GeometryConfig;
import model.ShapeShadingType;
import model.ShapeType;
import model.dialogs.ColorPattern;
import view.interfaces.Geometry;
import java.awt.*;

public class Rectangle1 implements Geometry {
    private GeometryConfig geometryConfig;
    private Graphics2D graphics2D;
    private MouseCoordinates Start, End, Point, Point1;
    private int ShapeWidth, ShapeHeight;
    private ShapeType shapeType;

    public Rectangle1(GeometryConfig geometryConfig) {
        this.geometryConfig = geometryConfig;
        this.ShapeWidth = geometryConfig.getShapeWidth();
        this.ShapeHeight = geometryConfig.getShapeHeight();
        this.Start = geometryConfig.getStart();
        this.End = geometryConfig.getEnd();
        this.Point = geometryConfig.getPoint();
        this.shapeType = geometryConfig.getShapeType();
        this.Point1 = geometryConfig.getPoint1();

    }

    @Override
    public void draw(Graphics graph) {
        Color color = new Color(0, 0, 0, 0.0f);
        graph.setColor(color);
        graph.drawRect(Start.getCoord(), Start.getCoord1(), ShapeWidth, ShapeHeight);
    }

    @Override
    public boolean contains(MouseCoordinates Point) {
        return (Start.getCoord() < Point.getCoord() && Start.getCoord1() < Point.getCoord1()
                && Start.getCoord() + ShapeWidth > Point.getCoord() && Start.getCoord1() + ShapeHeight > Point.getCoord1());
    }

    @Override
    public int getShapeWidth() {
        return ShapeWidth;
    }

    @Override
    public int getShapeHeight() {
        return ShapeHeight;
    }

    @Override
    public MouseCoordinates getPoint() {
        return Point;
    }

    @Override
    public MouseCoordinates getPoint1() {
        return End;
    }

    @Override
    public void setStart(MouseCoordinates Start) {
        this.Start = Start;
    }

    @Override
    public void setEnd(MouseCoordinates End) {
        this.End = End;
    }

    @Override
    public MouseCoordinates getStart() {
        return Start;
    }

    @Override
    public MouseCoordinates getEnd() {
        return End;
    }

    @Override
    public void sumCoord(int deltaCoord) {
        Start.setCoord(Start.getCoord() + deltaCoord);
        End.setCoord1(End.getCoord() + deltaCoord);
    }

    @Override
    public void sumCoord1(int deltaCoord1) {
        Start.setCoord1(Start.getCoord1() + deltaCoord1);
        End.setCoord1(End.getCoord1() + deltaCoord1);
    }

    @Override
    public GeometryConfig getGeometryConfig() {
        return geometryConfig;
    }
}


