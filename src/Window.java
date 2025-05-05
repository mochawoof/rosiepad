import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JFrame {
    public Window() {
        setTitle("Rosiepad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        setVisible(true);
    }

    public void setLaf(String lafName) {
        
    }
}