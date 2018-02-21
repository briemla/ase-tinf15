package api;

import java.awt.*;

public interface Element {
    boolean contains(Point point);
    Element translate(Point translation);
    void draw(Graphics graphics);
}
