package model.dialogs;

import model.TypeOfShading;
import model.interfaces.IApplicationState;
import view.interfaces.IDialogChoice;

public class ChooseShadingTypeDialog implements IDialogChoice<TypeOfShading> {
    private final IApplicationState applicationState;

    public ChooseShadingTypeDialog(IApplicationState applicationState) {

        this.applicationState = applicationState;
    }

    @Override
    public String getDialogTitle() {
        return "Shading Type";
    }

    @Override
    public String getDialogText() {
        return "Select a shading type from the menu below:";
    }

    @Override
    public TypeOfShading[] getDialogOptions() {
        return TypeOfShading.values();
    }

    @Override
    public TypeOfShading getCurrentSelection() {
        return applicationState.getActiveShapeShadingType();
    }
}
