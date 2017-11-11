package internal;

import api.MouseEvent;

import java.awt.*;

public class MouseEventSimple implements MouseEvent {

    private final Type type;
    private final Point point;

    public MouseEventSimple(Type type, Point point) {
        this.type = type;
        this.point = point;
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public Point point() {
        return new Point(point);
    }
}
