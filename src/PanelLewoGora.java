import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class PanelLewoGora extends JPanel{
    int licznikSeriiKropek = 0;
    int licznikSeriiLinii = 0;
    private ExecutorService executorService;
    public PanelLewoGora(PanelRysowanie panelRysowanie, DefaultListModel<String> model, JList<String> lista) {

        executorService = Executors.newCachedThreadPool();

        JButton przycisk1 = new JButton("10 pkt");
        JButton przycisk2 = new JButton("5 linii");
        JButton przycisk3 = new JButton("tło");

        przycisk1.addActionListener(e -> {
            Random random = new Random();

            Future<?> future = executorService.submit(() -> {
                SwingUtilities.invokeLater(() -> {
                model.addElement("SERIA KROPEK- [START]");
                lista.ensureIndexIsVisible(model.getSize() - 1);
                /*lista.revalidate();
                lista.repaint();*/
                });
                for(int i = 0; i < 10; i++) {
                    int x = random.nextInt(panelRysowanie.getWidth());
                    int y = random.nextInt(panelRysowanie.getHeight());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }


            panelRysowanie.dodajPunkt(x, y);
                }
                SwingUtilities.invokeLater(() -> {
                    model.addElement("SERIA KROPEK- [KONIEC]");
                    lista.ensureIndexIsVisible(model.getSize() - 1);
                });

            });
        });

        przycisk2.addActionListener(e -> {
            Random random = new Random();

            Future<?> future = executorService.submit(() -> {
                SwingUtilities.invokeLater(() -> {
                    model.addElement("SERIA LINII- [START]");
                    lista.ensureIndexIsVisible(model.getSize() - 1);
                });
                for(int i = 0; i < 5; i++) {
                    panelRysowanie.dodajLinie();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    panelRysowanie.dodajLinie();
                }
                    SwingUtilities.invokeLater(() -> {
                    model.addElement("SERIA LINII- [KONIEC]");
                    lista.ensureIndexIsVisible(model.getSize() - 1);
                    });

            });
        });


        przycisk3.addActionListener(e -> {
            Future<?> future = executorService.submit(() -> {
                Random random = new Random();

                SwingUtilities.invokeLater(() -> {
                    model.addElement("ROZPOCZECIE PLYNNENEJ ZMIANY TŁA!");
                    lista.ensureIndexIsVisible(model.getSize() - 1);
                });

                Color startColor = panelRysowanie.getBackground();
                Color endColor = new Color(
                        random.nextInt(256),
                        random.nextInt(256),
                        random.nextInt(256)
                );

                int steps = 100;
                int delay = 20;

                for (int i = 0; i <= steps; i++) {

                    float ratio = (float) i / steps;
                    int red = (int) (startColor.getRed() * (1 - ratio) + endColor.getRed() * ratio);
                    int green = (int) (startColor.getGreen() * (1 - ratio) + endColor.getGreen() * ratio);
                    int blue = (int) (startColor.getBlue() * (1 - ratio) + endColor.getBlue() * ratio);

                    Color interpolatedColor = new Color(red, green, blue);
                    SwingUtilities.invokeLater(() -> {
                        panelRysowanie.setBackground(interpolatedColor);

                    });

                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                SwingUtilities.invokeLater(() -> {
                    model.addElement("TLO ZMIENIONE PLYNNIE!");
                    lista.ensureIndexIsVisible(model.getSize() - 1);
                });
            });
        });

        add(przycisk1);
        add(przycisk2);
        add(przycisk3);
    }
    public void shutdown(){
        executorService.shutdown();
    }
}
