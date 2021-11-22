package ui;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class MainMenu {
    private JPanel MainMenuPanel;
    private JButton levelSelectButton;
    private JButton extrasMenuButton;

    public MainMenu() {
        JFrame frame = new JFrame("Main Menu");
        frame.setContentPane(MainMenuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        levelSelectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new LevelSelectUI();
            }
        });
        extrasMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new ExtrasMenu();
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        MainMenuPanel = new JPanel();
        MainMenuPanel.setLayout(new GridBagLayout());
        MainMenuPanel.setBackground(new Color(-4988956));
        extrasMenuButton = new JButton();
        Font extrasMenuButtonFont = this.$$$getFont$$$("Courier New", -1, -1, extrasMenuButton.getFont());
        if (extrasMenuButtonFont != null) extrasMenuButton.setFont(extrasMenuButtonFont);
        extrasMenuButton.setText("Extras");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        MainMenuPanel.add(extrasMenuButton, gbc);
        levelSelectButton = new JButton();
        Font levelSelectButtonFont = this.$$$getFont$$$("Courier New", -1, -1, levelSelectButton.getFont());
        if (levelSelectButtonFont != null) levelSelectButton.setFont(levelSelectButtonFont);
        levelSelectButton.setText("Level Select");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        MainMenuPanel.add(levelSelectButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MainMenuPanel;
    }
}
