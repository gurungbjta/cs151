import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

public class CompositeShape implements Shape {
    private ArrayList<Shape> shapes; // list of all composite shapes

    public CompositeShape() {
        shapes = new ArrayList<>();
    }

    public void add(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public Rectangle getBounds() { // looping through each shape of the array and combining their bounds
        Rectangle rect = shapes.get(0).getBounds();
        for (int i = 1; i < shapes.size(); i++) {
            rect.union(shapes.get(i).getBounds());
        }
        return rect;
    }

    @Override
    public Rectangle2D getBounds2D() {
        Rectangle2D rect = shapes.get(0).getBounds();
        for (int i = 1; i < shapes.size(); i++) {
            rect.createUnion(shapes.get(i).getBounds());
        }
        return rect;
    }

    @Override
    public boolean contains(double x, double y) {
        boolean bool = true;
        for (Shape s : shapes) { // looping through each shape in the arraylist and checking their contains methods
            bool = s.contains(x, y);
        }
        return bool;
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        boolean bool = true;
        for (Shape s : shapes) {
            bool = s.contains(x, y, w, h);
        }
        return bool;
    }

    @Override
    public boolean contains(Point2D p) {
        boolean bool = true;
        for (Shape s : shapes) {
            bool = s.contains(p);
        }
        return bool;
    }


    @Override
    public boolean contains(Rectangle2D r) {
        boolean bool = true;
        for (Shape s : shapes) {
            bool = s.contains(r);
        }
        return bool;
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        boolean bool = true;
        for (Shape s : shapes) { // looping through each shape in the arraylist and checking their intersects methods
            bool = s.intersects(x, y, w, h);
        }
        return bool;
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        boolean bool = true;
        for (Shape s : shapes) {
            bool = s.intersects(r);
        }
        return bool;
    }


    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return new PathIterator() {
            private PathIterator currentPathIterator;
            private Iterator<Shape> shapesIterator;

            // Constructor for an anonymous class
            {
                shapesIterator = shapes.iterator(); // iterator that iterates through array of shapes
                nextShape();
            }

            private void nextShape() {
                if (shapesIterator.hasNext()) { // if the iterator has a next shape, set the current path to that shape's path iterator
                    currentPathIterator = shapesIterator.next().getPathIterator(at);
                } else {
                    currentPathIterator = null;
                }
            }

            @Override
            public int getWindingRule() {
                return WIND_NON_ZERO;
            }

            @Override
            public boolean isDone() {
                if (currentPathIterator == null)
                    return true;
                if (!currentPathIterator.isDone())
                    return false;
                nextShape();
                return isDone(); // using recursion here but you can just loop through it too
            }

            @Override
            public void next() {
                currentPathIterator.next();
            }

            @Override
            public int currentSegment(float[] coords) {
                return currentPathIterator.currentSegment(coords);
            }

            @Override
            public int currentSegment(double[] coords) {
                return currentPathIterator.currentSegment(coords);
            }
        };

    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return new PathIterator() {
            private PathIterator currentPathIterator;
            private Iterator<Shape> shapesIterator;

            // Constructor for an anonymous class
            {
                shapesIterator = shapes.iterator();
                nextShape();
            }

            private void nextShape() {
                if (shapesIterator.hasNext()) {
                    currentPathIterator = shapesIterator.next().getPathIterator(at, flatness);
                } else {
                    currentPathIterator = null;
                }
            }

            @Override
            public int getWindingRule() {
                return WIND_NON_ZERO;
            }

            @Override
            public boolean isDone() {
                if (currentPathIterator == null)
                    return true;
                if (!currentPathIterator.isDone())
                    return false;
                nextShape();
                return isDone(); // using recursion here but you can just loop through it too
            }

            @Override
            public void next() {
                currentPathIterator.next();
            }

            @Override
            public int currentSegment(float[] coords) {
                return currentPathIterator.currentSegment(coords);
            }

            @Override
            public int currentSegment(double[] coords) {
                return currentPathIterator.currentSegment(coords);
            }
        };
    }

}
