package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.Geometry;
import model.GeometryConfig;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.MousePaint;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import javax.swing.*;
import java.awt.*;

public class Main{

    public static void main(String[] args){

        Geometry geometry = new Geometry();
        GeometryConfig geometryConfig = new GeometryConfig();
        PaintCanvas paintCanvas = new PaintCanvas(geometry);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        paintCanvas.setCursor((new Cursor(Cursor.CROSSHAIR_CURSOR)));
        IJPaintController controller = new JPaintController(uiModule, appState, geometry, geometryConfig);
        MousePaint mousePaint = new MousePaint (appState, paintCanvas, geometry, geometryConfig);
        mousePaint.execute();
        controller.setup();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

