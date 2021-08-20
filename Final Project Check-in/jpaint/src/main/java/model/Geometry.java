package model;

import model.interfaces.InterfaceofObserver;
import model.interfaces.InterfaceofShapes;

import java.util.ArrayList;

public class Geometry implements InterfaceofShapes {
    private final ArrayList<view.interfaces.shape.Geometry> ListofShapes;
    private final ArrayList<InterfaceofObserver> observers;
    private final ArrayList<view.interfaces.shape.Geometry> shapesselected;
    private final ArrayList<view.interfaces.shape.Geometry> shapesinternal;
    private final ArrayList<view.interfaces.shape.Geometry> board;

    public Geometry() {
        ListofShapes = new ArrayList<view.interfaces.shape.Geometry>();
        observers = new ArrayList<InterfaceofObserver>();
        shapesselected = new ArrayList<view.interfaces.shape.Geometry>();
        shapesinternal = new ArrayList<view.interfaces.shape.Geometry>();
        board = new ArrayList<view.interfaces.shape.Geometry>();
    }

    public void removingshape(view.interfaces.shape.Geometry shapes) {
        ListofShapes.remove(shapes);
        Notify();
    }

    public void addingshape(view.interfaces.shape.Geometry shapes) {
        ListofShapes.add(shapes);
        Notify();
    }

    public ArrayList<view.interfaces.shape.Geometry> get_ListOfShapes() {
        return ListofShapes;
    }

    @Override
    public void notification(InterfaceofObserver observer) {
        observers.add(observer);
    }

    @Override
    public void deletenotification(InterfaceofObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void Notify() {
        for (InterfaceofObserver observer1 : observers) {
            observer1.updating();
        }
    }

    public void removinglist()
    {
        shapesselected.removeAll(shapesselected);
        Notify();
    }
    public void addinglist(view.interfaces.shape.Geometry shapes)
    {
        shapesselected.add(shapes);
    }
    public void clearing()
    {
        shapesselected.clear();
    }

    public ArrayList<view.interfaces.shape.Geometry> getShapesSelected()
    {
        return shapesselected;
    }
    public ArrayList<view.interfaces.shape.Geometry> getShapesInternal()
    {
        return shapesinternal;
    }

    public void addingtoboard(view.interfaces.shape.Geometry shapes)
    {
        board.add(shapes);
    }

    public void removingfromboard()
    {
        board.removeAll(shapesselected);
        Notify();
    }

    public ArrayList<view.interfaces.shape.Geometry> get_boardshapes()
    {
        return board;
    }

    public void clearingboard()
    {
        board.clear();
    }
}


