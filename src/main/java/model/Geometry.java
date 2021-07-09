package model;

import model.interfaces.InterfaceofObserver;
import model.interfaces.InterfaceofShapes;

import java.util.ArrayList;

public class Geometry implements InterfaceofShapes {
    private final ArrayList<view.interfaces.Geometry> ListofShapes;
    private final ArrayList<InterfaceofObserver> observers;
    private final ArrayList<view.interfaces.Geometry> shapes;
    private final ArrayList<view.interfaces.Geometry> board;

    public Geometry() {
        ListofShapes = new ArrayList<view.interfaces.Geometry>();
        observers = new ArrayList<InterfaceofObserver>();
        shapes = new ArrayList<view.interfaces.Geometry>();
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

    public ArrayList<view.interfaces.Geometry> get_Geometry() {
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

    public void addinglist(view.interfaces.Geometry shapes) {
        ListofShapes.add(shapes);
    }

    @Override
    public ArrayList<view.interfaces.Geometry> get_shapes() {
        return null;
    }

    public void removinglist() {
        ListofShapes.removeAll(ListofShapes);
        Notify();
    }

    public void clearing() {
        ListofShapes.clear();
    }

    public ArrayList<view.interfaces.Geometry> get_ListofShapes() {
        return ListofShapes;
    }

    public void addingtoboard(view.interfaces.Geometry shapes) {
        board.add(shapes);
    }

    public void removingfromboard() {
        board.removeAll(ListofShapes);
        Notify();
    }

    public void clearingboard() {
        board.clear();
    }

    public ArrayList<view.interfaces.Geometry> get_boardshapes() {
        return board;
    }
}


