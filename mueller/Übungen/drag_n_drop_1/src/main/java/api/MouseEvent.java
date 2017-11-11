package api;

import java.awt.*;

public interface MouseEvent {
    enum Type {UP, DOWN, MOVE}

    Type type();
    Point point();
}
