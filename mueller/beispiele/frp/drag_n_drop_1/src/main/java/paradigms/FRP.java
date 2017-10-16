package paradigms;

import api.*;
import nz.sodium.*;

public class FRP implements Paradigm {

    private final Listener l;

    public FRP(Document initDoc, DocumentListener registeredListener) {
        l = Transaction.run(() -> {
            return null;
        });
    }

    public void mouseEvent(MouseEvent me) {
    }

    public void dispose() {
        l.unlisten();
    }
}
