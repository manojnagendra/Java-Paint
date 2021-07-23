package model;

import model.interfaces.InterfaceofObserver;
import model.interfaces.InterfaceofShapes;

import java.util.ArrayList;

public class Geometry implements InterfaceofShapes {
    private final ArrayList<view.interfaces.Geometry> ListofShapes;
    private final ArrayList<InterfaceofObserver> observers;
    private final ArrayList<view.interfaces.Geometry> shapesselected;
    private final ArrayList<view.interfaces.Geometry> board;

    public Geometry() {
        ListofShapes = new ArrayList<view.interfaces.Geometry>();
        observers = new ArrayList<InterfaceofObserver>();
        shapesselected = new ArrayList<view.interfaces.Geometry>();
        board = new ArrayList<view.interfaces.Geometry>();
    }

    public void addingshape(view.interfaces.Geometry shapes) {
        ListofShapes.add(shapes);
        Notify();
    }

    public void removingshape(view.interfaces.Geometry shapes) {
        ListofShapes.remove(shapes);
        Notify();
    }

    public ArrayList<view.interfaces.Geometry> get_ListOfShapes() {
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

    public void addinglist(view.interfaces.Geometry shapes)
    {
        shapesselected.add(shapes);
    }
    public void removinglist() {
        shapesselected.removeAll(shapesselected);
        Notify();
    }
    public void clearing()
    {
        shapesselected.clear();
    }

    public ArrayList<view.interfaces.Geometry> getShapesSelected()
    {
        return shapesselected;
    }

    public void addingtoboard(view.interfaces.Geometry shapes)
    {
        board.add(shapes);
    }

    public void removingfromboard()
    {
        board.removeAll(shapesselected);
        Notify();
    }

    public void clearingboard()
    {
        board.clear();
    }

    public ArrayList<view.interfaces.Geometry> get_boardshapes()
    {
        return board;
    }
}


