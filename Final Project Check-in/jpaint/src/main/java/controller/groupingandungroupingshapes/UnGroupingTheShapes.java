package controller.groupingandungroupingshapes;

import controller.CommandHistory;
import controller.undoredo.UndoRedoInterface;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import model.interfaces.UndoRedo;
import view.interfaces.shape.Geometry;

import java.awt.*;
import java.util.ArrayList;

public class UnGroupingTheShapes implements UndoRedoInterface, UndoRedo {
    Geometry ungrouping;
    private ArrayList<Geometry> UnGroupingShapes;
    private Graphics2D jpaint;
    private InterfaceofShapes geometry;
    private IApplicationState iApplicationState;

    public UnGroupingTheShapes(InterfaceofShapes geometry, IApplicationState iApplicationState)
    {
        this.geometry = geometry;
        this.iApplicationState = iApplicationState;
    }

    @Override
    public void implement()
    {
        UnGroupingShapes = new ArrayList<>();
        for(Geometry theshape:geometry.get_ListOfShapes())
        {
            if(theshape instanceof GroupingTheShapes)
            {
                ungrouping = theshape;
            }
        }
        geometry.removingshape(ungrouping);
        CommandHistory.add(this);
        System.out.println("Ungrouping the Shapes Done");
    }
    @Override
    public void undo()
    {
        geometry.addingshape(ungrouping);
    }
    @Override
    public void redo()
    {
        geometry.removingshape(ungrouping);
    }

}
