import javax.swing.*;
import java.awt.*;

public class Lista extends JList<String>{
    public Lista(DefaultListModel<String> model){
        super(model);
        setPreferredSize(new Dimension(150,6000));

    }
}
