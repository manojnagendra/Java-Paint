package view.gui.shapes;

import controller.MouseCoordinates;
import model.GeometryConfig;
import model.TypeOfShading;
import model.ShapeType;
import model.dialogs.ColorPattern;
import view.interfaces.shape.Geometry;
import java.awt.*;

public class Rectangle implements Geometry {
    private MouseCoordinates Start, End, Point, Point1;
    private ShapeType shapeType;
    private Graphics2D jpaint;
    private GeometryConfig geometryConfig;
    private TypeOfShading typeOfShading;
    private Color thefirstcolor, thesecondcolor;
    private int ShapeWidth, ShapeHeight;

    public Rectangle(GeometryConfig geometryConfig) {
        this.geometryConfig = geometryConfig;
        this.typeOfShading = geometryConfig.getShadingType();
        this.thefirstcolor = ColorPattern.getColor(geometryConfig.getPrimaryColor());
        this.thesecondcolor = ColorPattern.getColor(geometryConfig.getSecondaryColor());
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
        Graphics2D graph2d = (Graphics2D) graph;
        if (typeOfShading.equals(TypeOfShading.OUTLINE)) {
            graph.setColor(thefirstcolor);
            graph2d.setStroke(new BasicStroke(4));
            graph.drawRect(Start.getCoord(), Start.getCoord1(), ShapeWidth, ShapeHeight);
        } else if (typeOfShading.equals(TypeOfShading.FILLED_IN)) {
            graph.setColor(thefirstcolor);
            graph.fillRect(Start.getCoord(), Start.getCoord1(), ShapeWidth, ShapeHeight);
        } else if (typeOfShading.equals(TypeOfShading.OUTLINE_AND_FILLED_IN)) {
            graph.setColor(thefirstcolor);
            graph2d.setStroke(new BasicStroke(4));
            graph.drawRect(Start.getCoord(), Start.getCoord1(), ShapeWidth, ShapeHeight);
            graph.setColor(thesecondcolor);
            graph.fillRect(Start.getCoord(), Start.getCoord1(), ShapeWidth, ShapeHeight);
        }
    }

    @Override
    public boolean contains(MouseCoordinates Point) {
        return (Start.getCoord() < Point.getCoord() && Start.getCoord1() < Point.getCoord1()
                && Start.getCoord() + ShapeWidth > Point.getCoord() && Start.getCoord1() + ShapeHeight > Point.getCoord1());
    }

    public int getShapeWidth() {
        return ShapeWidth;
    }

    public int getShapeHeight() {
        return ShapeHeight;
    }

    public MouseCoordinates getThefirstpoint() {
        return Point;
    }

    public MouseCoordinates getThesecondpoint() {
        return End;
    }

    public void setStartingpoint(MouseCoordinates Start) {
        this.Start = Start;
    }

    public void setEndingpoint(MouseCoordinates End) {
        this.End = End;
    }

    public MouseCoordinates getStartingpoint() {
        return Start;
    }

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


