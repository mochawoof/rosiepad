import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Window extends JFrame {

    public JPanel centerPanel;
    public JScrollPane centerScrollPane;
    public GridBagConstraints centerc;

    public JToolBar toolsBar;
    public GridBagConstraints toolsc;

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

        toolsBar.add(new JButton("Brush"));
        add(toolsBar, BorderLayout.LINE_START);

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