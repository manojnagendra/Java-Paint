package view.gui.shapes;

import controller.MouseCoordinates;
import model.GeometryConfig;
import model.TypeOfShading;
import model.ShapeType;
import model.dialogs.ColorPattern;
import view.interfaces.PaintCanvasBase;
import view.interfaces.shape.Geometry;
import java.awt.*;

public class EllipseBorder extends PaintCanvasBase implements Geometry {
    private GeometryConfig geometryConfig;
    private TypeOfShading typeOfShading;
    private Color primaryColor, secondaryColor;
    private int ShapeWidth, ShapeHeight, ShapeWidth1, ShapeHeight1, Dot, Dot1;
    private MouseCoordinates Start, End, Point, Point1;
    private ShapeType shapeType;
    private Graphics2D jpaint;

    public EllipseBorder(GeometryConfig geometryConfig, int x, int y, int ShapeWidth1, int ShapeHeight1) {
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
        this.ShapeWidth1=ShapeWidth1;
        this.ShapeHeight1=ShapeHeight1;
        this.Dot=x;
        this.Dot1=y;
    }

    @Override
    public void draw(Graphics graph) {

        jpaint = (Graphics2D) graph;
        jpaint.setColor(Color.BLACK);
        Stroke stroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1, new float[]{5},0);
        jpaint.setStroke(stroke);
        jpaint.drawOval(Dot - 5, Dot1 - 5, ShapeWidth1 + 10, ShapeHeight1 + 10);
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

    @Override
    public Graphics2D getGraphics2D()
    {
        return jpaint;
    }
}


