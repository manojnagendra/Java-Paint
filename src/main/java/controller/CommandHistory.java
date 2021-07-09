package controller;

import model.interfaces.UndoRedo;

import java.util.Stack;

public class CommandHistory {
	private static final Stack<UndoRedo> undo = new Stack<UndoRedo>();
	private static final Stack<UndoRedo> redo = new Stack<UndoRedo>();

	public static void add(UndoRedo cmd) {
		undo.push(cmd);
		redo.clear();
	}

	public static boolean undo() {
		boolean res = !undo.empty();
		if (res) {
			UndoRedo c = undo.pop();
			redo.push(c);
			c.undo();
		}
		return res;
	}

	public static boolean redo() {
		boolean res = !redo.empty();
		if (res) {
			UndoRedo c = redo.pop();
			undo.push(c);
			c.redo();
		}
		return res;
	}
}

