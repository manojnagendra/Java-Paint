**JPaint Project**

The various Design Patterns used in this JPaint project are Command Pattern, Singleton Pattern, Proxy Pattern, Observer Pattern, and Composite Pattern. 

**Command Pattern** <br /> 
•	  Undo, Redo operations, Creating a shape are implemented using Command Pattern. The controller->undoredo package contains Undo, Redo class, UndoRedoInterface and Undo Interface. <br /> 
•	  Under view->shapeactions->ShapeCreate class implements the UndoRedoInterface and Undo Interface, and these are defined in the CommandHistory class under controller package.


**Singleton Pattern** <br /> 
•	Under model->dialogs->ColorPattern, different colors for the shape are defined. Here, Singleton pattern is used for implementation. 


**Proxy Pattern** <br /> 
•	Proxy Pattern which is a structural design pattern has been implemented for the border created around the shapes when it is selected. <br /> 
•	The classes can be found under controller->OutlineShapes->BorderAlias, BorderClass. <br /> 
•	The interface used is BorderInterface and both the BorderAlias and BorderClass classes implements this interface. <br /> 


**Observer Pattern** <br /> 
•	Under view->gui->mouse, different mouse operations like Drawing the shape, Moving the shape, and Selecting the shape are implemented using the Observer Pattern.<br /> 
•	While selecting and moving the shapes, the shape drawn first is selected, then the next shape is selected. Then, the shapes are moved after selection. <br /> 
•	Selecting the Shape Type draws a rectangle or an ellipse or a triangle and Selecting the Mouse Mode enables Draw or Move or Select functionality.<br /> 


**Composite Pattern** <br /> 
•	Composite Pattern which is a structural design pattern has been implemented for Grouping and Ungrouping the shapes. It lets us to compose the objects in a tree-like structure and handle it as a single object. <br /> 
•	The classes can be found under controller->groupingandungroupingshapes package with the class names GroupingTheShapes, GroupingTheShapes1, UnGroupingTheShapes.<br /> 


**Static Factory Method** <br /> 
•	Under model package, the classes Factory, TypeOfShading uses Static Factory which returns a new instance of the object and it helps in changing names of the instantiated classes. 
