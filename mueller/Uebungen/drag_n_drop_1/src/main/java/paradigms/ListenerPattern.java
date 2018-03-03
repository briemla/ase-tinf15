package paradigms;

import api.Document;
import api.MouseEvent;
import api.Paradigm;

public class ListenerPattern implements Paradigm {

    private final DocumentListener documentListener;
    private Document document;

    public ListenerPattern(Document initDoc,  DocumentListener documentListener) {
        this.document = initDoc;
        this.documentListener = documentListener;
    }

    public void mouseEvent(MouseEvent mouseEvent) {
    }

    public void dispose() {}
}
