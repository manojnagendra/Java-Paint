package controller;

import model.FactoryPattern;
import model.GeometryConfig;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import model.interfaces.UndoRedo;
import view.interfaces.Geometry;

    public class ShapeCreation implements UndoRedoInterface,UndoRedo {

        FactoryPattern factoryPattern = new FactoryPattern();
        private final IApplicationState iApplicationState;
        private GeometryConfig geometryConfig;
        private InterfaceofShapes geometry;
        private Geometry shape;

        public ShapeCreation(IApplicationState iApplicationState, InterfaceofShapes geometry, GeometryConfig geometryConfig) {
            this.iApplicationState = iApplicationState;
            this.geometry = geometry;
            this.geometryConfig = geometryConfig;
        }

        @Override
        public void execute() {
            geometryConfig = iApplicationState.getGeometryConfiguration();
            shape = factoryPattern.shapecreation(geometryConfig);
            this.geometry.addingshape(shape);
            CommandHistory.add(this);
        }

        public Geometry getShape()
        {
        return shape;
        }

        @Override
        public void undo() {
            geometry.removingshape(shape);
        }
        @Override
        public void redo() {
            geometry.addingshape(shape);
        }
    }
