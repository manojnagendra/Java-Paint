package model;

import controller.MouseCoordinates;
import view.interfaces.shape.Geometry;

public class GeometryConfig {
    private MouseCoordinates Point;
    private MouseCoordinates Point1;
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private TypeOfShading shadingType;
    private ShapeType shapeType;
    private Geometry shape;
    private MouseCoordinates Start;
    private MouseCoordinates End;
    private int ShapeWidth;
    private int ShapeHeight;

    public void setPrimaryColor(ShapeColor primaryColor)
    {
        this.primaryColor = primaryColor;
    }
    public void setSecondaryColor(ShapeColor secondaryColor)
    {
        this.secondaryColor=secondaryColor;
    }
    public void setPoint(MouseCoordinates Point) {this.Point = Point;}
    public void setPoint1(MouseCoordinates Point1) {this.Point1 = Point1;}
    public void setShadingType(TypeOfShading shadingType)
    {
        this.shadingType=shadingType;
    }
    public void setShapeType(ShapeType shapeType)
    {
        this.shapeType=shapeType;
    }
    
    public ShapeColor getPrimaryColor()
    {
       return primaryColor;
    }
    public ShapeColor getSecondaryColor()
    {
        return secondaryColor;
    }
    public MouseCoordinates getPoint()
    {
        return Point;
    }
    public MouseCoordinates getPoint1() {
        return Point1;
    }
    public TypeOfShading getShadingType() {
        return shadingType;
    }
    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeWidth(int ShapeWidth) { this.ShapeWidth = ShapeWidth;}
    public void setShapeHeight(int ShapeHeight) {
        this.ShapeHeight = ShapeHeight;
    }
    public int getShapeWidth()
    {
        MouseCoordinates Start = getStart();
        MouseCoordinates End = getEnd();
        return End.getCoord() - Start.getCoord();
    }
    public int getShapeHeight()
    {
        MouseCoordinates Start = getStart();
        MouseCoordinates End = getEnd();
        return End.getCoord1() - Start.getCoord1();
    }
    public MouseCoordinates getStart() {
        int startCoord = Math.min(Point.getCoord(), Point1.getCoord());
        int startCoord1 = Math.min(Point.getCoord1(), Point1.getCoord1());
        return new MouseCoordinates(startCoord,startCoord1);
    }

    public MouseCoordinates getEnd() {
        int EndCoord = Math.max(Point.getCoord(), Point1.getCoord());
        int EndCoord1 = Math.max(Point.getCoord1(), Point1.getCoord1());
        return new MouseCoordinates(EndCoord,EndCoord1);
    }

    public void setEnd(MouseCoordinates End)
    {
        this.End = End;
    }
    public void setStart(MouseCoordinates Start)
    {
        this.Start = Start;
    }
    public void setShape(Geometry shape)
    {
        this.shape=shape;
    }
    public Geometry getshape()
    {
        return shape;
    }

}

