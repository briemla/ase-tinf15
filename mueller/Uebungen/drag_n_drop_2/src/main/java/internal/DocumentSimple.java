package internal;

import api.Document;
import api.Element;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class DocumentSimple implements Document {

    private final Map<UUID, Element> entries;

    public DocumentSimple(Map<UUID, Element> entries) {
        this.entries = entries;
    }

    @Override
    public Optional<? extends Entry> atPoint(Point point) {
        return entries.entrySet().stream()
                .filter(entry -> entry.getValue().contains(point))
                .map(entry -> new DocumentEntrySimple(entry.getKey(), entry.getValue()))
                .findFirst();
    }

    @Override
    public Document insert(UUID id, Element element) {
        Map<UUID, Element> resultingEntries = new HashMap<>(entries);
        resultingEntries.put(id, element);
        return new DocumentSimple(resultingEntries);
    }

    @Override
    public void draw(Graphics graphics) {
        entries.entrySet().stream()
                .forEach(entry -> entry.getValue().draw(graphics));
    }

    public class DocumentEntrySimple implements Document.Entry {

        private final UUID uuid;
        private final Element element;

        public DocumentEntrySimple(UUID uuid, Element element) {
            this.uuid = uuid;
            this.element = element;
        }

        @Override
        public UUID id() {
            return uuid;
        }

        @Override
        public Element element() {
            return element;
        }
    }
}
