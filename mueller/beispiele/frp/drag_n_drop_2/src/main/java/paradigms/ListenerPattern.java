package paradigms;

import api.Document;
import api.KeyEventType;
import api.MouseEvent;
import api.Paradigm;

public class ListenerPattern implements Paradigm {

    private final DocumentListener documentListener;
    private Document document;

    public ListenerPattern(Document initDoc,  DocumentListener documentListener) {
        this.document = initDoc;
        this.documentListener = documentListener;
    }

    private static class Dragging {
        Dragging(MouseEvent mouseEvent, Document.Entry entry) {
            this.mouseEvent = mouseEvent;
            this.entry = entry;
        }
        final MouseEvent mouseEvent;
        final Document.Entry entry;
    }

    public void mouseEvent(MouseEvent mouseEvent) {
    }

    public void shiftEvent(KeyEventType type) {
    }

    public void dispose() {}
}
