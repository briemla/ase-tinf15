package internal;

import api.Element;

import java.awt.*;

public class ElementSimple implements Element {

    private static final Color standardColor = new Color( 100,228, 100);
    private final Polygon polygon;

    public ElementSimple(Polygon polygon) {
        this.polygon = polygon;
    }

    @Override
    public boolean contains(Point point) {
        return polygon.contains(point);
    }

    @Override
    public Element translate(Point translation) {
        Polygon resultingPolygon = new Polygon(polygon.xpoints,polygon.ypoints,
                polygon.npoints);
        resultingPolygon.translate(translation.x, translation.y);
        return new ElementSimple(resultingPolygon);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(standardColor);
        graphics.fillPolygon(polygon);
        graphics.setColor(Color.black);
        graphics.drawPolygon(polygon);
    }
}
