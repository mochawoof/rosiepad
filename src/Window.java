import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JFrame {

    public JPanel centerPanel;
    public JScrollPane centerScrollPane;
    public GridBagConstraints centerc;

    public JToolBar toolsBar;
    public GridBagConstraints toolsc;
        public JButton brushb;
        public JButton eraserb;
        public JButton pencilb;
        public JButton eyedropperb;
        public JButton lassob;
        public JButton marqueeb;
        public JButton textb;
        public JButton typeb;

    public Window() {
        setTitle("Rosiepad");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLaf("FlatLightLaf");

        // centerPanel
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        centerc = new GridBagConstraints();

        centerScrollPane = new JScrollPane(centerPanel);
        centerScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        add(centerScrollPane, BorderLayout.CENTER);

        centerc.gridx = 0; centerc.gridy = 0;
        centerPanel.add(new Page(), centerc);
        centerc.gridy = 1;
        centerPanel.add(new Page(), centerc);

        // toolsBar        
        UIManager.put("ToolBar.floatable", true);
        toolsBar = new JToolBar("Tools");
        toolsBar.setLayout(new GridBagLayout());

        toolsc = new GridBagConstraints();
        toolsc.gridx = 0; toolsc.gridy = 0;

        brushb = createAndAddToolsBarButton("B", "Brush");
        eraserb = createAndAddToolsBarButton("E", "Eraser");
        pencilb = createAndAddToolsBarButton("P", "Pencil");
        eyedropperb = createAndAddToolsBarButton("EY", "Eyedropper");
        lassob = createAndAddToolsBarButton("L", "Lasso");
        marqueeb = createAndAddToolsBarButton("M", "Marquee");
        textb = createAndAddToolsBarButton("T", "Text");
        typeb = createAndAddToolsBarButton("TY", "Type");
        
        add(toolsBar, BorderLayout.LINE_START);

        setVisible(true);
    }

    public JButton createAndAddToolsBarButton(String name, String tooltip) {
        JButton b = new JButton(name);
        b.setToolTipText(tooltip);

        toolsBar.add(b, toolsc);

        if (toolsc.gridx >= 1) {
            toolsc.gridx = 0; toolsc.gridy++;
        } else {
            toolsc.gridx++;
        }

        return b;
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