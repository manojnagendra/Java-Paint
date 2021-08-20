package view.gui.shapes;

import controller.MouseCoordinates;
import model.GeometryConfig;
import model.TypeOfShading;
import model.ShapeType;
import model.dialogs.ColorPattern;
import view.interfaces.PaintCanvasBase;
import view.interfaces.shape.Geometry;
import java.awt.*;

public class Ellipse extends PaintCanvasBase implements Geometry {
    private Color thefirstcolour, thesecondcolour;
    private int ShapeWidth, ShapeHeight;
    private MouseCoordinates Startingpoint, Endingpoint, thefirstpoint;
    private ShapeType typeofshape;
    private Graphics2D jpaint;
    private GeometryConfig geometryConfig;
    private TypeOfShading typeofshading;

    public Ellipse(GeometryConfig geometryConfig) {
        this.geometryConfig = geometryConfig;
        this.typeofshading = geometryConfig.getShadingType();
        this.thefirstcolour = ColorPattern.getColor(geometryConfig.getPrimaryColor());
        this.thesecondcolour = ColorPattern.getColor(geometryConfig.getSecondaryColor());
        this.ShapeWidth = geometryConfig.getShapeWidth();
        this.ShapeHeight = geometryConfig.getShapeHeight();
        this.Startingpoint = geometryConfig.getStart();
        this.Endingpoint = geometryConfig.getEnd();
        this.thefirstpoint = geometryConfig.getPoint();
        this.typeofshape = geometryConfig.getShapeType();
    }

    @Override
    public void draw(Graphics graph) {
        Graphics2D graph2d = (Graphics2D) graph;
        if (typeofshading.equals(TypeOfShading.OUTLINE)) {
            graph.setColor(thefirstcolour);
            graph2d.setStroke(new BasicStroke(6));
            graph.drawOval(Startingpoint.getCoord(), Startingpoint.getCoord1(), ShapeWidth, ShapeHeight);
        } else if (typeofshading.equals(TypeOfShading.FILLED_IN)) {
            graph.setColor(thesecondcolour);
            graph.fillOval(Startingpoint.getCoord(), Startingpoint.getCoord1(), ShapeWidth, ShapeHeight);
        } else if (typeofshading.equals(TypeOfShading.OUTLINE_AND_FILLED_IN)) {
            graph.setColor(thefirstcolour);
            graph2d.setStroke(new BasicStroke(6));
            graph.drawOval(Startingpoint.getCoord(), Startingpoint.getCoord1(), ShapeWidth, ShapeHeight);
            graph.setColor(thesecondcolour);
            graph.fillOval(Startingpoint.getCoord(), Startingpoint.getCoord1(), ShapeWidth, ShapeHeight);
        }
    }

    @Override
    public boolean contains(MouseCoordinates thefirstpoint) {
        return (Startingpoint.getCoord() < thefirstpoint.getCoord()
                && Startingpoint.getCoord1() < thefirstpoint.getCoord1()
                && Startingpoint.getCoord() + ShapeWidth > thefirstpoint.getCoord() && Startingpoint.getCoord1() + ShapeHeight > thefirstpoint.getCoord1());
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
        return thefirstpoint;
    }

    @Override
    public MouseCoordinates getThesecondpoint() {
        return Endingpoint;
    }

    @Override
    public void setStartingpoint(MouseCoordinates Start) {
        this.Startingpoint = Start;
    }

    @Override
    public void setEndingpoint(MouseCoordinates End) {
        this.Endingpoint = End;
    }
    public MouseCoordinates getStartingpoint() {
        return Startingpoint;
    }

    @Override
    public MouseCoordinates getEndingpoint() {
        return Endingpoint;
    }

    @Override
    public void sumCoord(int deltaCoord) {
        Startingpoint.setCoord(Startingpoint.getCoord() + deltaCoord);
        Endingpoint.setCoord1(Endingpoint.getCoord() + deltaCoord);
    }

    @Override
    public void sumCoord1(int deltaCoord1) {
        Startingpoint.setCoord1(Startingpoint.getCoord1() + deltaCoord1);
        Endingpoint.setCoord1(Endingpoint.getCoord1() + deltaCoord1);
    }

    @Override
    public GeometryConfig getGeometryConfig() {
        return geometryConfig;
    }

    @Override
    public Graphics2D getGraphics2D() {
        return jpaint;
    }
}


