import javax.swing.*;
import java.awt.*;

class Page extends JComponent {
    public Page() {
        setPreferredSize(new Dimension(400, 500));
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}