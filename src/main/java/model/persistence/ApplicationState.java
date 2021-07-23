package model.persistence;

import controller.MouseCoordinates;
import model.*;
import model.dialogs.ChooseStartAndEndPointModeDialog;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;
import view.interfaces.MouseAdapterInterface;

import java.util.ArrayList;

public class ApplicationState implements IApplicationState {
    private final IUiModule iUiModule;
    private final DialogProvider dialogProvider;
    private ArrayList<MouseAdapterInterface> mouseObservers = new ArrayList<>();
    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor, activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private StartAndEndPointMode activeStartAndEndPointMode;
    private MouseCoordinates Point, Point1, Start, End;
    private int ShapeWidth, ShapeHeight;

    @Override
    public GeometryConfig getGeometryConfiguration() {
        GeometryConfig geometryConfig = new GeometryConfig();
        geometryConfig.setPrimaryColor(activePrimaryColor);
        geometryConfig.setSecondaryColor(activeSecondaryColor);
        geometryConfig.setShadingType(activeShapeShadingType);
        geometryConfig.setShapeType(activeShapeType);
        geometryConfig.setPoint1(Point1);
        geometryConfig.setPoint(Point);
        geometryConfig.setStart(Start);
        geometryConfig.setEnd(End);
        geometryConfig.setShapeWidth(ShapeWidth);
        geometryConfig.setShapeHeight(ShapeHeight);

        return geometryConfig;
    }

    public ApplicationState(IUiModule iUiModule) {
        this.iUiModule = iUiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    private void setDefaults() {
        activeShapeType = ShapeType.RECTANGLE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeStartAndEndPointMode = StartAndEndPointMode.DRAW;
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
        System.out.println("The First Color" + activePrimaryColor);
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = iUiModule.get_DialogResponse(dialogProvider.getChooseSecondaryColorDialog());
        System.out.println("The Second Color: " + activeSecondaryColor);
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = iUiModule.get_DialogResponse(dialogProvider.getChooseShadingTypeDialog());
        System.out.println("The Type of Shading " + activeShapeShadingType);
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = iUiModule.get_DialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
        System.out.println("The Mode of Mouse " + activeStartAndEndPointMode);
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
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
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
        int StartCoord = Math.min(Point.getCoord(), Point1.getCoord1());
        int StartCoord1 = Math.min(Point.getCoord1(), Point1.getCoord1());
        Start = new MouseCoordinates(StartCoord, StartCoord1);
        return Start;
    }

    @Override
    public MouseCoordinates getEnd() {
        int EndCoord = Math.max(Point.getCoord(), Point1.getCoord1());
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
            observer.execute();
        }
    }
}


