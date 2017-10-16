package api;

public interface Paradigm {
    interface DocumentListener {
        void documentUpdated(Document document);
    }
    interface Factory {
        Paradigm create(Document document, DocumentListener documentListener);
    }
    void mouseEvent(MouseEvent mouseEvent);
    void dispose();
}

