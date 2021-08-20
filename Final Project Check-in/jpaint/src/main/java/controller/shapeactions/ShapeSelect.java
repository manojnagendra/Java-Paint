package controller.shapeactions;
import controller.undoredo.UndoRedoInterface;
import model.Factory;
import model.GeometryConfig;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import view.gui.shapes.Rectangle1;
import view.interfaces.shape.Geometry;

public class ShapeSelect implements UndoRedoInterface {
    private Geometry ShapeSelections;
    private IApplicationState iApplicationState;
    private GeometryConfig geometryConfig;
    private Geometry shape1;
    Boolean containsShapeSelections = false;
    private InterfaceofShapes geometry;
    public ShapeSelect(IApplicationState iApplicationState, InterfaceofShapes geometry) {
        this.geometry = geometry;
        this.iApplicationState = iApplicationState;
    }

    @Override
    public void implement() {
        System.out.println("Mouse is in the Select Mode");
        geometryConfig = iApplicationState.getGeometryConfiguration1();
        shape1 = new Rectangle1(geometryConfig);
        this.geometry.addingshape(shape1);
        for (Geometry shape2 : geometry.get_ListOfShapes()) {
            boolean contain = shape2.contains(iApplicationState.getPoint());
            if((shape1.getEndingpoint().getCoord()) <
                    (shape2.getEndingpoint().getCoord()))
            {
                geometry.addinglist(shape2);
            }
            else if((shape1.getEndingpoint().getCoord()) >
                    (shape2.getEndingpoint().getCoord()))
            {
                geometry.addinglist(shape2);
            }
            else if((shape1.getEndingpoint().getCoord1()) <
                    (shape2.getEndingpoint().getCoord1()))
            {
                geometry.addinglist(shape2);
            }
            else if((shape1.getEndingpoint().getCoord1()) >
                    (shape2.getEndingpoint().getCoord1()))
            {
                geometry.addinglist(shape2);
            }
            else if((containsShapeSelections == false) && (shape1.getEndingpoint()!=null))
            {
                geometry.addinglist(shape2);
            }
            else {
            }
            if(contain)
            {
                containsShapeSelections = true;
                ShapeSelections = shape2;
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

    public Geometry getShapeSelections()
    {
        return ShapeSelections;
    }

    public boolean containsShapeSelections()
    {
        return containsShapeSelections;
    }
}
