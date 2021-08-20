package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.Geometry;
import model.GeometryConfig;
import model.persistence.AppState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.mouse.Drawing;
import view.gui.mouse.MousePaint;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;

public class Main{

    public static void main(String[] args){

        Geometry geometry = new Geometry();
        GeometryConfig geometryConfig = new GeometryConfig();
        PaintCanvas paintCanvas = new PaintCanvas(geometry);
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        AppState appState = new AppState(uiModule);
        paintCanvas.setCursor((new Cursor(Cursor.CROSSHAIR_CURSOR)));
        paintCanvas.addMouseListener(new Drawing(appState, geometry, geometryConfig));
        IJPaintController controller = new JPaintController(uiModule, appState, geometry, geometryConfig);
        MousePaint mousePaint = new MousePaint (appState, paintCanvas, geometry, geometryConfig);
        mousePaint.implement();
        controller.setup();
    }
}

