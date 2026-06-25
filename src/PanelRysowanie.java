import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
public class PanelRysowanie extends JPanel {
    private List<Point> listaKPunktow;
    private Map<Point, Point> listaLinii;

    public PanelRysowanie() {
        setBackground(Color.GREEN);
        setLayout(new FlowLayout());
        listaKPunktow = new ArrayList<>();
    }

    public void dodajPunkt(int x, int y) {
        listaKPunktow.add(new Point(x, y));
        repaint();
    }
    public void dodajLinie(){
        Random random = new Random();
        Point punkt1 = listaKPunktow.get(random.nextInt(listaKPunktow.size()));
        Point punkt2 = listaKPunktow.get(random.nextInt(listaKPunktow.size()));

        listaLinii.put(punkt1, punkt2);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        for (Point point : listaKPunktow) {
            g.fillOval(point.x, point.y, 10, 10);
        }

        g.setColor(Color.BLUE);

        for (Map.Entry<Point, Point> entry : listaLinii.entrySet()) {
            Point start = entry.getKey();
            Point end = entry.getValue();

            g.drawLine(start.x, start.y, end.x, end.y);
        }
    }
}
*/

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PanelRysowanie extends JPanel {
    private List<Point> listaKPunktow;
    private Map<Point, Point> listaLinii;

    public PanelRysowanie() {
        setBackground(Color.GRAY);
        listaKPunktow = new ArrayList<>();
        listaLinii = new HashMap<>();
    }

    public void dodajPunkt(int x, int y) {
        listaKPunktow.add(new Point(x, y));
        repaint();
    }

    public void dodajLinie() {
        if (listaKPunktow.size() < 10) {
            return;
        }

        Random random = new Random();
        Point punkt1 = listaKPunktow.get(random.nextInt(listaKPunktow.size()));
        Point punkt2 = listaKPunktow.get(random.nextInt(listaKPunktow.size()));

        while (punkt1.equals(punkt2)) {
            punkt2 = listaKPunktow.get(random.nextInt(listaKPunktow.size()));
        }

        listaLinii.put(punkt1, punkt2);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

            g.setColor(Color.RED);
            for (Point point : listaKPunktow) {
                g.fillOval(point.x, point.y, 10, 10);
            }

            g.setColor(Color.BLUE);
            for (Map.Entry<Point, Point> entry : listaLinii.entrySet()) {
                Point start = entry.getKey();
                Point end = entry.getValue();
                g.drawLine(start.x + 5, start.y + 5, end.x + 5, end.y + 5);
            }
    }
}

