import javax.swing.*;
import java.awt.*;

public class PanelGlowny extends JPanel {

    public PanelGlowny(DefaultListModel<String> model, PanelRysowanie panelRysowanie) {
        setLayout(new GridLayout(1, 3));
        JList<String> lista = new Lista(model);
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(200,100));
        add(new PanelLewoGora(panelRysowanie, model, lista));
        add(scrollPane);
        add(Box.createRigidArea(new Dimension(0,20)));
    }
}
