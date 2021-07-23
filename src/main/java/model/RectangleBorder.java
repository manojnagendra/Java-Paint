package view.gui.shapes;

import controller.MouseCoordinates;
import model.GeometryConfig;
import model.ShapeShadingType;
import model.ShapeType;
import model.dialogs.ColorPattern;
import view.interfaces.Geometry;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class RectangleBorder extends PaintCanvasBase implements Geometry
{
    private GeometryConfig geometryConfig;
    private ShapeShadingType shapeShadingType;
    private Graphics2D graphics2D;
    private Color primaryColor, secondaryColor;
    private int ShapeWidth, ShapeHeight, ShapeWidth1, ShapeHeight1;
    private int border, border1;
    private MouseCoordinates Start, End, Point, Point1;
    private ShapeType shapeType;

    public RectangleBorder(GeometryConfig geometryConfig, int Coord, int Coord1, int ShapeWidth1, int ShapeHeight1)
    {
        this.border = Coord;
        this.border1 = Coord1;
        this.ShapeWidth1 = ShapeWidth1;
        this.ShapeHeight1 = ShapeHeight1;
        this.geometryConfig = geometryConfig;
        this.shapeShadingType = geometryConfig.getShadingType();
        this.primaryColor = ColorPattern.getColor(geometryConfig.getPrimaryColor());
        this.secondaryColor = ColorPattern.getColor(geometryConfig.getSecondaryColor());
        this.ShapeWidth = geometryConfig.getShapeWidth();
        this.ShapeHeight = geometryConfig.getShapeHeight();
        this.Start = geometryConfig.getStart();
        this.End = geometryConfig.getEnd();
        this.Point = geometryConfig.getPoint();
        this.shapeType = geometryConfig.getShapeType();
        this.Point1 = geometryConfig.getPoint1();
    }

        @Override
        public void draw(Graphics graph)
        {
        graphics2D = (Graphics2D) graph;
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(border - 5, border1 - 5, ShapeWidth1 + 10, ShapeHeight1 + 10);
        }

        @Override
        public boolean contains (MouseCoordinates Point)
        {
            return (Start.getCoord() < Point.getCoord() && Start.getCoord1() < Point.getCoord1()
                    && Start.getCoord() + ShapeWidth > Point.getCoord() && Start.getCoord1() + ShapeHeight > Point.getCoord1());
        }

        @Override
        public int getShapeWidth()
        {
            return ShapeWidth;
        }

        @Override
        public int getShapeHeight()
        {
            return ShapeHeight;
        }

        @Override
        public MouseCoordinates getPoint () {
            return Point;
        }

        @Override
        public MouseCoordinates getPoint1 () {
            return End;
        }

        @Override
        public void setStart (MouseCoordinates Start){
            this.Start = Start;
        }

        @Override
        public void setEnd (MouseCoordinates End){
            this.End = End;
        }

        @Override
        public MouseCoordinates getStart () {
            return Start;
        }

        @Override
        public MouseCoordinates getEnd () {
            return End;
        }

        @Override
        public void sumCoord (int deltaCoord){
            Start.setCoord(Start.getCoord() + deltaCoord);
            End.setCoord1(End.getCoord() + deltaCoord);
        }

        @Override
        public void sumCoord1 (int deltaCoord1)
        {
            Start.setCoord1(Start.getCoord1() + deltaCoord1);
            End.setCoord1(End.getCoord1() + deltaCoord1);
        }

        @Override
        public Graphics2D getGraphics2D ()
        {
            return graphics2D;
        }

        @Override
        public GeometryConfig getGeometryConfig ()
        {
            return geometryConfig;
        }

}