package controller;

public class Redo implements UndoRedoInterface{

    @Override
    public void execute() {
        System.out.println("Redo");
        CommandHistory.redo();
    }
}
