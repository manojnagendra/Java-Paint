package controller.undoredo;

import controller.CommandHistory;

public class Undo implements UndoRedoInterface {

    @Override
    public void implement() {
        System.out.println("Undo");
        CommandHistory.undo();
    }
}
