package edu.eci.cvds.patterns.shapes;
import edu.eci.cvds.patterns.shapes.concrete.*;

public class ShapeFactory{
	public static Shape create(RegularShapeType type){
		Shape ans;
		switch (type){
			case Triangle:
				ans = new Triangle();
				break;
			case Quadrilateral:
				ans = new Quadrilateral();
				break;
			case Pentagon:
				ans = new Pentagon();
				break;
			case Hexagon:
				ans = new Hexagon();
				break;
			default:
				return null;
		}
		return ans;
	}
}