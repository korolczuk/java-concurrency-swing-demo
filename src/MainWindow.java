import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    PanelRysowanie panelRysowanie = new PanelRysowanie();
    public MainWindow() throws InterruptedException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,900);
        setLayout(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();
        add(new PanelGlowny(model, panelRysowanie), BorderLayout.NORTH);
        add(panelRysowanie);

        Thread.sleep(2000);

        //model.addElement("i nowe bum beng");

        setVisible(true);
    }
    public PanelRysowanie panelRys(){
        return panelRysowanie;
    }
}
