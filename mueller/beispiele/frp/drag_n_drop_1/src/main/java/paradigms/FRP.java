package paradigms;

import api.*;
import nz.sodium.*;

public class FRP implements Paradigm {

    private final Listener l;
    private final StreamSink<MouseEvent> sMouse = new StreamSink<>();

    public FRP(Document initDoc, DocumentListener registeredListener) {
        l = Transaction.run(() -> {
            sMouse
                .filter(event -> event.type() == MouseEvent.Type.DOWN)
                .
            return null;
        });
    }

    public void mouseEvent(MouseEvent me) {
        sMouse.send(me);
    }

    public void dispose() {
        l.unlisten();
    }
}