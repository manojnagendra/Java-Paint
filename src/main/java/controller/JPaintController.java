package controller;

import model.Geometry;
import model.GeometryConfig;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import model.persistence.ApplicationState;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState iApplicationState;
    private InterfaceofShapes geometry;
    private GeometryConfig geometryConfig;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, InterfaceofShapes geometry, GeometryConfig geometryConfig) {
        this.uiModule = uiModule;
        this.iApplicationState = applicationState;
        this.geometry = geometry;
        this.geometryConfig = geometryConfig;
    }

    @Override
    public void setup() {
        Eventssetup();
    }

    private void Eventssetup() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> iApplicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> iApplicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> iApplicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> iApplicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> iApplicationState.setActiveStartAndEndPointMode());

        uiModule.addEvent(EventName.UNDO, () -> new Undo().execute());
        uiModule.addEvent(EventName.REDO, () -> new Redo().execute());
    }
}
