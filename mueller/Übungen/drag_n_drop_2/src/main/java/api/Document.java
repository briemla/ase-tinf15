package api;

import java.awt.*;
import java.util.Optional;
import java.util.UUID;

public interface Document {
    Optional<? extends Entry> atPoint(Point point);
    Document insert(UUID id, Element element);
    void draw(Graphics graphics);

    interface Entry {
        UUID id();
        Element element();
    }
}
