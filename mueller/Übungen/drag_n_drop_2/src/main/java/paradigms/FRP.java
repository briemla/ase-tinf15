package paradigms;

import api.*;
import nz.sodium.*;

import java.awt.*;


public class FRP implements Paradigm {

    private final Listener l;
    private final StreamSink<MouseEvent> sMouse = new StreamSink<>();
    private final StreamSink<KeyEventType> sShift = new StreamSink<>();

    public FRP(Document initDoc, DocumentListener registeredListener) {
        l = Transaction.run(() -> {
            return null;
        });
    }

    public void mouseEvent(MouseEvent me) {
        sMouse.send(me);
    }

    public void shiftEvent(KeyEventType type) {
        sShift.send(type);
    }

    public void dispose() {
        l.unlisten();
    }
}
