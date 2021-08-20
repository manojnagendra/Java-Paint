package controller.groupingandungroupingshapes;

import controller.undoredo.UndoRedoInterface;
import model.GeometryConfig;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import view.gui.shapes.EllipseBorder;
import view.gui.shapes.RectangleBorder;
import view.gui.shapes.TriangleBorder;
import view.interfaces.shape.Geometry;

import java.util.ArrayList;

public class GroupingTheShapes1 implements UndoRedoInterface
{
    ArrayList<Geometry>dimensions = new ArrayList<>();
    private IApplicationState iApplicationState;
    private GeometryConfig geometryConfig;
    int group = 0, group1 = 0, group2 = 0, group3;
    private InterfaceofShapes geometry;
    private Geometry shapeselection;
    private Geometry lenghtofshape, breadthofshape;
    private Geometry geometry1, geometry2;

    public GroupingTheShapes1(InterfaceofShapes geometry, IApplicationState iApplicationState)
    {
        this.geometry = geometry;
        this.iApplicationState = iApplicationState;
    }

    @Override
    public void implement() {
        group3 = geometry.get_ListOfShapes().size();
        lenghtofshape = geometry.get_ListOfShapes().get(0);
        breadthofshape = geometry.get_ListOfShapes().get(group3 - 1);
        geometryConfig = iApplicationState.getGeometryConfiguration();
        for (Geometry shape : geometry.get_ListOfShapes()) {
            group1 = group1 + shape.getShapeWidth();
            group2 = group2 + shape.getShapeHeight();
            if (shape instanceof RectangleBorder) {
                geometry2 = shape;
                dimensions.add(geometry2);
            } else if (shape instanceof EllipseBorder) {
                geometry2 = shape;
                dimensions.add(geometry2);
            } else if (shape instanceof TriangleBorder) {
                geometry2 = shape;
                dimensions.add(geometry2);
            }
        }
        for (Geometry list : dimensions) {
            geometry.removingshape(list);
        }
        GroupingTheShapes GroupCommand = new GroupingTheShapes(geometryConfig, lenghtofshape.getStartingpoint().getCoord(),
                lenghtofshape.getStartingpoint().getCoord1(),
                group1, group2);
        geometry1 = new GroupingTheShapes(geometryConfig, lenghtofshape.getStartingpoint().getCoord(),
                lenghtofshape.getStartingpoint().getCoord1(),
                group1, group2);
        GroupCommand.GroupingShapes1(geometry1);
        this.geometry.addingshape(GroupCommand);
    }
}

