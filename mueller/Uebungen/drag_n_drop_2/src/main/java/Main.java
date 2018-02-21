import api.Document;
import api.Element;
import internal.DocumentSimple;
import internal.ElementSimple;
import internal.gui.ParadigmView;
import paradigms.FRP;
import paradigms.ListenerPattern;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// Neues Feature: Shift lockt die Achsen und aktualisert die Elemente entsprechend
public class Main {

    private static Element shape(int ox, int oy, int sides, double angle) {
        int[] xs = new int[sides];
        int[] ys = new int[sides];
        angle *= Math.PI / 180.0;
        for (int i = 0; i < sides; i++) {
            double theta = angle + Math.PI * 2 * (double) i / (double) sides;
            xs[i] = (int) ((double) ox + Math.sin(theta) * 25);
            ys[i] = (int) ((double) oy - Math.cos(theta) * 25);
        }
        return new ElementSimple(new Polygon(xs, ys, sides));
    }

    public static void main(String[] args) {
        Map<UUID, Element> elements = new HashMap<UUID, Element>();

        //TRIANGLE
        elements.put(UUID.randomUUID(), shape(50, 50, 3, 0.0));
        //SQUARE
        elements.put(UUID.randomUUID(), shape(125, 50, 4, 45.0));
        //PENTAGON
        elements.put(UUID.randomUUID(), shape(200, 50, 5, 0.0));
        //HEXAGON
        elements.put(UUID.randomUUID(), shape(50, 125, 6, 30.0));
        //HEPTAGON
        elements.put(UUID.randomUUID(), shape(125, 125, 7, 0.0));
        //OCTAGON
        elements.put(UUID.randomUUID(), shape(200, 125, 8, 22.5));

        Document doc = new DocumentSimple(elements);
        JFrame frame = new JFrame("Drag And Drop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel view = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        view.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        view.add(new JLabel("Drag the polygons with your mouse"), c);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        view.add(new ParadigmView(doc, frame, ListenerPattern::new), c);
        c.gridx = 0;
        c.gridy = 2;
        view.add(new JLabel("Listener Pattern"), c);
        c.gridx = 1;
        c.gridy = 1;
        view.add(new ParadigmView(doc, frame, FRP::new), c);
        c.gridx = 1;
        c.gridy = 2;
        view.add(new JLabel("FRP"), c);
        frame.setContentPane(view);
        frame.pack();
        frame.setVisible(true);
    }
}
