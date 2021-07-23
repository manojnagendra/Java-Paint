package view.gui.shapes;

import controller.MouseCoordinates;
import model.GeometryConfig;
import model.ShapeShadingType;
import model.ShapeType;
import model.dialogs.ColorPattern;
import view.interfaces.Geometry;

import java.awt.*;

public class Triangle implements Geometry {
    private GeometryConfig geometryConfig;
    private ShapeShadingType shapeShadingType;
    private Color primaryColor, secondaryColor;
    private int ShapeWidth, ShapeHeight;
    private MouseCoordinates Start, End, Point;
    private ShapeType shapeType;
    private int[] Coord = new int[3];
    private int[] Coord1 = new int[3];

    public Triangle(GeometryConfig geometryConfig) {
        this.geometryConfig = geometryConfig;
        this.shapeShadingType = geometryConfig.getShadingType();
        this.primaryColor = ColorPattern.getColor(geometryConfig.getPrimaryColor());
        this.secondaryColor = ColorPattern.getColor(geometryConfig.getSecondaryColor());
        this.Start = geometryConfig.getStart();
        this.End = geometryConfig.getEnd();
        this.Point = geometryConfig.getPoint();
        this.ShapeWidth = geometryConfig.getShapeWidth();
        this.ShapeHeight = geometryConfig.getShapeHeight();
        this.Coord[0] = geometryConfig.getStart().getCoord();
        this.Coord[1] = geometryConfig.getEnd().getCoord();
        this.Coord[2] = geometryConfig.getStart().getCoord();
        this.Coord1[0] = geometryConfig.getStart().getCoord1();
        this.Coord1[1] = geometryConfig.getEnd().getCoord1();
        this.Coord1[2] = geometryConfig.getEnd().getCoord1();
    }


    public void draw(Graphics graph) {
        Graphics2D graph1 = (Graphics2D) graph;
        if (shapeShadingType.equals(ShapeShadingType.OUTLINE)) {
            graph.setColor(primaryColor);
            graph1.setStroke(new BasicStroke(8));
            graph.drawPolygon(Coord, Coord1, 3);

        } else if (shapeShadingType.equals(ShapeShadingType.FILLED_IN)) {
            graph.setColor(secondaryColor);
            graph.fillPolygon(Coord, Coord1, 3);

        } else if (shapeShadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            graph.setColor(primaryColor);
            graph1.setStroke(new BasicStroke(8));
            graph.drawPolygon(Coord, Coord1, 3);
            graph.setColor(secondaryColor);
            graph.fillPolygon(Coord, Coord1, 3);
        }
    }

    double area(int xcoord1, int ycoord1, int xcoord2, int ycoord2, int xcoord3, int ycoord3) {
        return Math.abs((xcoord1 * (ycoord2 - ycoord3) + xcoord2 * (ycoord3 - ycoord1) + xcoord3 * (ycoord1 - ycoord2)) / 2.0);
    }

    boolean isInside(int xcoord1, int ycoord1, int xcoord2, int ycoord2, int xcoord3, int ycoord3, int Coord, int Coord1) {

        double trianglepoints = area(xcoord1, ycoord1, xcoord2, ycoord2, xcoord3, ycoord3);
        double trianglepoints1 = area(Coord, Coord1, xcoord2, ycoord2, xcoord3, ycoord3);
        double trianglepoints2 = area(xcoord1, ycoord1, Coord, Coord1, xcoord3, ycoord3);
        double trianglepoints3 = area(xcoord1, ycoord1, xcoord2, ycoord2, Coord, Coord1);
        return (trianglepoints == trianglepoints1 + trianglepoints2 + trianglepoints3);
    }


    public boolean contains(MouseCoordinates start) {
        if (isInside(Coord[0], Coord1[0], Coord[1], Coord1[1], Coord[2], Coord1[2], start.getCoord(), start.getCoord1())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getShapeWidth() {
        return ShapeWidth;
    }

    @Override
    public int getShapeHeight() {
        return ShapeHeight;
    }

    public MouseCoordinates getStart()
    {
        return Start;
    }

    public MouseCoordinates getEnd()
    {
        return End;
    }

    @Override
    public MouseCoordinates getPoint()
    {
        return Point;
    }

    @Override
    public MouseCoordinates getPoint1() {
        return null;
    }

    @Override
    public void setStart(MouseCoordinates Start)
    {
        this.Start = Start;
    }

    @Override
    public void setEnd(MouseCoordinates End)
    {
        this.End = End;
    }

    @Override
    public void sumCoord(int deltax)
    {
        this.Coord[0] = Start.getCoord() + deltax;
        this.Coord[1] = End.getCoord() + deltax;
        this.Coord[2] = Start.getCoord() + deltax;
    }

    @Override
    public void sumCoord1(int deltay)
    {
        this.Coord1[0] = Start.getCoord1() + deltay;
        this.Coord1[1] = End.getCoord1() + deltay;
        this.Coord1[2] = End.getCoord1() + deltay;
    }

    public GeometryConfig getGeometryConfig()
    {
        return geometryConfig;
    }
}



