package model.interfaces;

import view.interfaces.shape.Geometry;

import java.util.ArrayList;

public interface InterfaceofShapes {
    void addingshape(Geometry shape);
    void removingshape(Geometry shape);
    ArrayList<Geometry> get_ListOfShapes();
    void notification(InterfaceofObserver paintCanvas);
    void deletenotification(InterfaceofObserver paintCanvas);
    void Notify();
    void addinglist(Geometry shapes);
    ArrayList<Geometry> getShapesSelected();
    ArrayList<Geometry> getShapesInternal();
    void removinglist();
    void clearing();
    void addingtoboard(Geometry shapes);
    void removingfromboard();
    void clearingboard();
    ArrayList<Geometry>get_boardshapes();
}
