package view.gui.shapes;

import controller.MouseCoordinates;
import model.GeometryConfig;
import model.ShapeType;
import view.interfaces.shape.Geometry;
import java.awt.*;

public class Rectangle1 implements Geometry
{
    private GeometryConfig geometryConfig;
    private int ShapeWidth, ShapeHeight;
    private MouseCoordinates Start, End, Point, Point1;
    private ShapeType shapeType;
    private Graphics2D jpaint;

    public Rectangle1(GeometryConfig geometryConfig)
    {
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

        Color color = new Color(0,0,0,0.0f);
        graph.setColor(color);
        graph.drawRect(Start.getCoord(),Start.getCoord1(),ShapeWidth,ShapeHeight);
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
    public MouseCoordinates getThefirstpoint() {
        return Point;
    }

    @Override
    public MouseCoordinates getThesecondpoint() {
        return End;
    }

    @Override
    public void setStartingpoint(MouseCoordinates Start) {
        this.Start = Start;
    }

    @Override
    public void setEndingpoint(MouseCoordinates End) {
        this.End = End;
    }

    @Override
    public MouseCoordinates getStartingpoint() {
        return Start;
    }

    @Override
    public MouseCoordinates getEndingpoint() {
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


