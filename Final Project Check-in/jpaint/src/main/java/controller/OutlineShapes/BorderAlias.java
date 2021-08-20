package controller.OutlineShapes;

import controller.shapeactions.ShapeMove;
import controller.shapeactions.ShapeSelect;
import controller.undoredo.UndoRedoInterface;
import model.interfaces.BorderInterface;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;

public class BorderAlias implements BorderInterface
{
    private ShapeSelect shapeSelect = null;
    private ShapeMove shapeMove = null;
    UndoRedoInterface undoRedoInterface;
    private InterfaceofShapes interfaceofShapes;
    private IApplicationState iApplicationState;

    public BorderAlias(UndoRedoInterface undoRedoInterface, IApplicationState iApplicationState, InterfaceofShapes interfaceofShapes) {
        this.iApplicationState = iApplicationState;
        this.undoRedoInterface = undoRedoInterface;
        this.interfaceofShapes = interfaceofShapes;
        if (undoRedoInterface instanceof ShapeSelect) {
            shapeSelect = (ShapeSelect) undoRedoInterface;
        }
    }

    @Override
    public void border()
    {
        if (shapeSelect.containsShapeSelections()) {
            BorderClass borderClass = new BorderClass(iApplicationState, interfaceofShapes);
            borderClass.border();
            }
        }
    }



