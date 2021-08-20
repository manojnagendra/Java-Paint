package controller.groupingandungroupingshapes;

import controller.MouseCoordinates;
import model.GeometryConfig;
import model.ShapeType;
import model.TypeOfShading;
import model.dialogs.ColorPattern;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import view.gui.shapes.EllipseBorder;
import view.gui.shapes.RectangleBorder;
import view.gui.shapes.TriangleBorder;
import view.interfaces.shape.Geometry;

import java.awt.*;
import java.util.ArrayList;

public class GroupingTheShapes implements Geometry {
    ArrayList<Geometry> groupingshapes = null;
    private Graphics2D jpaint;
    private Color primaryColor, secondaryColor;
    private TypeOfShading typeOfShading;
    private GeometryConfig geometryConfig;
    private ShapeType shapeType;
    private int ShapeWidth, ShapeHeight, ShapeWidth1, ShapeHeight1, Dot, Dot1;
    private MouseCoordinates Start, End, Point, Point1;

    public GroupingTheShapes(GeometryConfig geometryConfig, int x, int y, int ShapeWidth1, int ShapeHeight1)
    {
        groupingshapes = new ArrayList<>();
        this.geometryConfig = geometryConfig;
        this.typeOfShading = geometryConfig.getShadingType();
        this.primaryColor = ColorPattern.getColor(geometryConfig.getPrimaryColor());
        this.secondaryColor = ColorPattern.getColor(geometryConfig.getSecondaryColor());
        this.ShapeWidth = geometryConfig.getShapeWidth();
        this.ShapeHeight = geometryConfig.getShapeHeight();
        this.Start = geometryConfig.getStart();
        this.End = geometryConfig.getEnd();
        this.Point = geometryConfig.getPoint();
        this.shapeType = geometryConfig.getShapeType();
        this.Point1 = geometryConfig.getPoint1();
        this.ShapeWidth1 = ShapeWidth1;
        this.ShapeHeight1 = ShapeHeight1;
        this.Dot = x;
        this.Dot1 = y;
    }

    public void GroupingShapes1 (Geometry geometry)
    {
    groupingshapes.add(geometry);
    }

    @Override
    public void draw(Graphics graph) {

        if (shapeType == ShapeType.RECTANGLE) {
            jpaint = (Graphics2D) graph;
            jpaint.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, new float[]{3}, 0);
            jpaint.setStroke(stroke);
            jpaint.drawRect(Dot - 100, Dot1, ShapeWidth1 + 150, ShapeHeight1 + 150);
            System.out.println("Grouping the Rectangular Shapes Done");
        }
        else if (shapeType == ShapeType.ELLIPSE)
        {
            jpaint = (Graphics2D) graph;
            jpaint.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, new float[]{3}, 0);
            jpaint.setStroke(stroke);
            jpaint.drawRect(Dot - 100, Dot1, ShapeWidth1 + 150, ShapeHeight1 + 150);
            System.out.println("Grouping the Elliptical Shapes Done");
        }
        else if (shapeType == ShapeType.TRIANGLE)
        {
            jpaint = (Graphics2D) graph;
            jpaint.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, new float[]{3}, 0);
            jpaint.setStroke(stroke);
            jpaint.drawRect(Dot - 150, Dot1, ShapeWidth1 + 350, ShapeHeight1 + 350);
            System.out.println("Grouping the Triangular Shapes Done");
        }
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
