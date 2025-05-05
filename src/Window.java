import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JFrame {
    public Window() {
        setTitle("Rosiepad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLaf("FlatLightLaf");

        setVisible(true);
    }

    public void setLaf(String lafName) {
        try {
            if (lafName.startsWith("Flat")) {
                UIManager.setLookAndFeel("com.formdev.flatlaf." + lafName);
            } else {
                for (UIManager.LookAndFeelInfo lafInfo : UIManager.getInstalledLookAndFeels()) {
                    if (lafInfo.getName().equals(lafName)) {
                        UIManager.setLookAndFeel(lafInfo.getClassName());
                        break;
                    }
                }
            }
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}