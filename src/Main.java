import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                MainWindow MW = new MainWindow();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
