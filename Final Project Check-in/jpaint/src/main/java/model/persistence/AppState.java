package model.persistence;

import controller.OutlineShapes.BorderAlias;
import controller.MouseCoordinates;
import model.*;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import view.interfaces.IUiModule;
import view.interfaces.shape.MouseAdapterInterface;

import java.util.ArrayList;

public class AppState implements IApplicationState {
    private final IUiModule iUiModule;
    private final DialogProvider dialogProvider;
    private ArrayList<MouseAdapterInterface> mouseObservers = new ArrayList<>();
    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor, activeSecondaryColor;
    private TypeOfShading activeTypeOfShading;
    private StartAndEndPointMode activeStartAndEndPointMode;
    private MouseCoordinates Point, Point1, Start, End;
    private int ShapeWidth, ShapeHeight;
    BorderAlias undoAlias = null;
    BorderAlias redoAlias = null;

    public AppState(IUiModule iUiModule) {
        this.iUiModule = iUiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    private void setDefaults() {
        activeShapeType = ShapeType.RECTANGLE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeTypeOfShading = TypeOfShading.FILLED_IN;
        activeStartAndEndPointMode = StartAndEndPointMode.DRAW;
    }

    @Override
    public GeometryConfig getGeometryConfiguration() {
        GeometryConfig geometryConfig = new GeometryConfig();
        geometryConfig.setPrimaryColor(activePrimaryColor);
        geometryConfig.setSecondaryColor(activeSecondaryColor);
        geometryConfig.setShadingType(activeTypeOfShading);
        geometryConfig.setShapeType(activeShapeType);
        geometryConfig.setPoint1(Point1);
        geometryConfig.setPoint(Point);
        geometryConfig.setStart(Start);
        geometryConfig.setEnd(End);
        geometryConfig.setShapeWidth(ShapeWidth);
        geometryConfig.setShapeHeight(ShapeHeight);

        return geometryConfig;
    }
    @Override
    public GeometryConfig getGeometryConfiguration1() {
        GeometryConfig geometryConfig1 = new GeometryConfig();
        geometryConfig1.setShapeType(activeShapeType);
        geometryConfig1.setPoint1(Point1);
        geometryConfig1.setPoint(Point);
        geometryConfig1.setStart(Start);
        geometryConfig1.setEnd(End);
        geometryConfig1.setShapeWidth(ShapeWidth);
        geometryConfig1.setShapeHeight(ShapeHeight);
        return geometryConfig1;
    }

    @Override
    public void set_ActivePrimaryColor(ShapeColor activePrimaryColor) {
        this.activePrimaryColor = activePrimaryColor;
    }

    @Override
    public void set_ActiveSecondaryColor(ShapeColor activeSecondaryColor) {
        this.activeSecondaryColor = activeSecondaryColor;
    }

    @Override
    public void setPoint(MouseCoordinates Point) {
        this.Point = Point;
    }

    @Override
    public void setPoint1(MouseCoordinates Point1) {
        this.Point1 = Point1;
    }

    public void setShapeWidth(int ShapeWidth) {
        MouseCoordinates Start = getStart();
        MouseCoordinates End = getEnd();
        this.ShapeWidth = End.getCoord() - Start.getCoord();
    }

    public void setShapeHeight(int ShapeHeight) {
        MouseCoordinates Start = getStart();
        MouseCoordinates End = getEnd();
        this.ShapeHeight = End.getCoord1() - Start.getCoord1();
    }

    @Override
    public void setActiveShape() {
        activeShapeType = iUiModule.get_DialogResponse(dialogProvider.getChooseShapeDialog());
        System.out.println("GeometryConfig " + activeShapeType);
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = iUiModule.get_DialogResponse(dialogProvider.getChoosePrimaryColorDialog());
        System.out.println("The First Color is: " + activePrimaryColor);
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = iUiModule.get_DialogResponse(dialogProvider.getChooseSecondaryColorDialog());
        System.out.println("The Second Color is: " + activeSecondaryColor);
    }

    @Override
    public void setActiveShadingType() {
        activeTypeOfShading = iUiModule.get_DialogResponse(dialogProvider.getChooseShadingTypeDialog());
        System.out.println("The Type of Shading is" + activeTypeOfShading);
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = iUiModule.get_DialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
        System.out.println("The Mode of Mouse is " + activeStartAndEndPointMode);
        mousenotify();
    }

    public int getShapeWidth() {
        return ShapeWidth;
    }

    public int getShapeHeight() {
        return ShapeHeight;
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public TypeOfShading getActiveShapeShadingType() {
        return activeTypeOfShading;
    }

    @Override
    public StartAndEndPointMode getActiveStartAndEndPointMode() {
        return activeStartAndEndPointMode;
    }

    @Override
    public MouseCoordinates getPoint() {
        return Point;
    }

    @Override
    public MouseCoordinates getPoint1() {
        return Point1;
    }

    @Override
    public MouseCoordinates getStart() {
        int StartCoord = Math.min(Point.getCoord(), Point1.getCoord());
        int StartCoord1 = Math.min(Point.getCoord1(), Point1.getCoord1());
        Start = new MouseCoordinates(StartCoord, StartCoord1);
        return Start;
    }

    @Override
    public MouseCoordinates getEnd() {
        int EndCoord = Math.max(Point.getCoord(), Point1.getCoord());
        int EndCoord1 = Math.max(Point.getCoord1(), Point1.getCoord1());
        End = new MouseCoordinates(EndCoord, EndCoord1);
        return End;
    }

    public void setStart(MouseCoordinates Start) {
        this.Start = Start;
    }

    public void setEnd(MouseCoordinates End) {
        this.End = End;
    }

    @Override
    public void mousereg(MouseAdapterInterface m)
    {
        mouseObservers.add(m);
}

    @Override
    public void mousenotify() {
        for (MouseAdapterInterface observer : mouseObservers) {
            observer.implement();
        }
    }
}


