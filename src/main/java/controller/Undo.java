package controller;

public class Undo implements UndoRedoInterface {

    @Override
    public void execute() {
        System.out.println("Undo");
        CommandHistory.undo();
    }
}
