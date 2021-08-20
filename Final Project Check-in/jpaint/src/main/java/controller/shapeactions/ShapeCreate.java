package controller.shapeactions;

import controller.CommandHistory;
import controller.undoredo.UndoRedoInterface;
import model.Factory;
import model.GeometryConfig;
import model.interfaces.IApplicationState;
import model.interfaces.InterfaceofShapes;
import model.interfaces.UndoRedo;
import view.interfaces.shape.Geometry;

    public class ShapeCreate implements UndoRedoInterface,UndoRedo {
        private InterfaceofShapes geometry;
        private Geometry shape;
        public Factory factory = new Factory();
        private final IApplicationState iApplicationState;
        private GeometryConfig geometryConfig;

        public ShapeCreate(IApplicationState iApplicationState, InterfaceofShapes geometry, GeometryConfig geometryConfig)
        {
            this.iApplicationState = iApplicationState;
            this.geometry = geometry;
            this.geometryConfig = geometryConfig;
        }

        @Override
        public void implement() {
            geometryConfig = iApplicationState.getGeometryConfiguration();
            shape = factory.shapecreation(geometryConfig);
            this.geometry.addingshape(shape);
            CommandHistory.add(this);
        }

        public Geometry getShape()
        {
        return shape;
        }

        @Override
        public void undo()
        {
            geometry.removingshape(shape);
        }
        @Override
        public void redo()
        {
            geometry.addingshape(shape);
        }
    }
