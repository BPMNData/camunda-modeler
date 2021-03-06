package org.camunda.bpm.modeler.core.layout.util;

import java.util.ArrayList;
import java.util.List;

import org.camunda.bpm.modeler.core.layout.util.LayoutUtil.Sector;
import org.camunda.bpm.modeler.core.utils.AnchorUtil.AnchorLocation;
import org.eclipse.draw2d.geometry.Vector;
import org.eclipse.graphiti.datatypes.IDimension;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.datatypes.IRectangle;
import org.eclipse.graphiti.internal.datatypes.impl.DimensionImpl;
import org.eclipse.graphiti.internal.datatypes.impl.LocationImpl;
import org.eclipse.graphiti.internal.datatypes.impl.RectangleImpl;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.services.Graphiti;

/**
 * Manages conversions between different Graphiti, Ecplise.draw2d, ...
 * datatypes.
 * 
 * @author nico.rehwaldt
 *
 */
public class ConversionUtil {
	
	public static Vector vector(Point point) {
		return new Vector(point.getX(), point.getY());
	}

	public static Vector vector(ILocation l) {
		return new Vector(l.getX(), l.getY());
	}

	public static Vector vector(double x, double y) {
		return new Vector(x, y);
	}

	public static ILocation location(Vector v) {
		return location((int) Math.round(v.x), (int) Math.round(v.y));
	}

	@SuppressWarnings("restriction")
	public static IDimension dimension(int width, int height) {
		return new DimensionImpl(width, height);
	}

	@SuppressWarnings("restriction")
	public static IDimension dimension(Point point) {
		return new DimensionImpl(point.getX(), point.getY());
	}
	
	public static Point point(int x, int y) {
		return Graphiti.getCreateService().createPoint(x, y);
	}
	
	public static Point point(Vector vector) {
		return point((int) Math.round(vector.x), (int) Math.round(vector.y));
	}
	
	public static Point point(org.eclipse.dd.dc.Point p) {
		return point((int) Math.round(p.getX()), (int) Math.round(p.getY()));
	}

	public static org.eclipse.dd.dc.Point diPoint(ILocation l) {
		org.eclipse.dd.dc.Point p = org.eclipse.dd.dc.DcFactory.eINSTANCE.createPoint();
		
		p.setX(l.getX());
		p.setY(l.getY());
		
		return p;
	}

	@SuppressWarnings("restriction")
	public static IRectangle rect(int x, int y, int width, int height) {
		return new RectangleImpl(x, y, width, height);
	}
	
	
	public static Point point(ILocation l) {
		return point(l.getX(), l.getY());
	}

	/**
	 * Converts a rectangle to a point by returning its x and y coordinates.
	 * 
	 * @param r
	 * @return
	 */
	public static Point point(IRectangle r) {
		return point(r.getX(), r.getY());
	}
	
	public static ILocation location(Point p) {
		return location(p.getX(), p.getY());
	}
	
	public static ILocation location(org.eclipse.dd.dc.Point p) {
		return location((int) Math.round(p.getX()), (int) Math.round(p.getY()));
	}
	
	@SuppressWarnings("restriction")
	public static ILocation location(int x, int y) {
		return new LocationImpl(x, y);
	}
	
	public static AnchorLocation anchorLocation(Sector sector) {
		switch (sector) {
		case BOTTOM: 
			return AnchorLocation.BOTTOM;
		case LEFT:
			return AnchorLocation.LEFT;
		case TOP: 
			return AnchorLocation.TOP;
		case RIGHT:
			return AnchorLocation.RIGHT;
		default:
			throw new IllegalArgumentException("No anchor location corresponding to Sector." + sector);
		}
	}

	public static IRectangle rectangle(int x, int y, int width, int height) {
		return rect(x, y, width, height);
	}
	
	public static IRectangle rectangle(int x, int y, IDimension dimension) {
		return rect(x, y, dimension.getWidth(), dimension.getHeight());
	}
	
	public static IRectangle rectangle(GraphicsAlgorithm graphicsAlgorithm) {
		return rect(graphicsAlgorithm.getX(), graphicsAlgorithm.getY(), graphicsAlgorithm.getWidth(), graphicsAlgorithm.getHeight());
	}
	
	/**
	 * Transforms a list of points to a corresponding list of vectors.
	 * 
	 * @param points
	 * @return
	 */
	public static List<Vector> asVectors(List<Point> points) {
		List<Vector> vectors = new ArrayList<Vector>();
		for (Point point : points) {
			vectors.add(vector(point));
		}
		
		return vectors;
	}
}
