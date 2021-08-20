package controller.undoredo;

import controller.CommandHistory;

public class Redo implements UndoRedoInterface {

    @Override
    public void implement() {
        System.out.println("Redo");
        CommandHistory.redo();
    }
}
