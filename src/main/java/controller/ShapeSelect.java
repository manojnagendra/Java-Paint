package controller;
import model.Factory;
import model.GeometryConfig;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import view.gui.shapes.Rectangle;
import view.interfaces.Geometry;

public class ShapeSelection implements UndoRedoInterface {
    private InterfaceofShapes geometry;
    Factory factory = new Factory();
    private Geometry ShapeSelections;
    private IApplicationState iApplicationState;
    private GeometryConfig geometryConfig;
    private Geometry shapes,s1;
    Boolean containsShapeSelections = false;
    public ShapeSelection(IApplicationState iApplicationState, InterfaceofShapes geometry) {
        this.geometry = geometry;
        this.iApplicationState = iApplicationState;
    }

    @Override
    public void execute() {
        System.out.println("Mouse is in the Select Mode");
        geometryConfig = iApplicationState.getGeometryConfiguration();
        shapes = new Rectangle(geometryConfig);
        this.geometry.addingshape(shapes);
        for (Geometry shape : geometry.get_ListOfShapes()) {
            boolean contain = shape.contains(iApplicationState.getPoint());
            if((shapes.getEnd().getCoord())<(shape.getEnd().getCoord()))
            {
                geometry.addinglist(shape);
            }
            else if((shapes.getEnd().getCoord())>(shape.getEnd().getCoord()))
            {
                geometry.addinglist(shape);
            }
            else if((shapes.getEnd().getCoord1())<(shape.getEnd().getCoord1()))
            {
                geometry.addinglist(shape);
            }
            else if((shapes.getEnd().getCoord1())>(shape.getEnd().getCoord1()))
            {
                geometry.addinglist(shape);
            }
            else if((containsShapeSelections == false) && (shapes.getEnd()!=null))
            {
                geometry.addinglist(shape);
            }
            else {
            }
            if(contain)
            {
                containsShapeSelections = true;
                ShapeSelections = shape;
                System.out.println("The current shape is now highlighted");
                break;
            }
            else
            {
                containsShapeSelections = false;
            }
        }
        if(containsShapeSelections == false)
        {
            geometry.clearing();
            geometry.get_boardshapes().clear();
            System.out.println("All the shapes are cleared. The current shape that is selected is" +geometry.getShapesSelected().size());
        }
    }

    public Geometry getShapeSelections() {
        return ShapeSelections;
    }

    public boolean containsShapeSelections() {
        return containsShapeSelections;
    }
}
