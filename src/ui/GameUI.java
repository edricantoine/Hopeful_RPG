package ui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

//A class representing the main menu screen, seen upon booting up the game.

public class GameUI {


    private JPanel titlePanel;
    private JLabel titleLabel;
    private JButton beginButton;
    private JButton passButton;

    public GameUI() {
        beginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new MainMenu();
            }
        });
        passButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new EnterPasswordTool();
            }
        });


    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("HOPEFUL");
        frame.setContentPane(new GameUI().titlePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        System.out.println("Version 0.4 - City level released"); //current version of the game
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
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridBagLayout());
        titlePanel.setBackground(new Color(-4988956));
        Font titlePanelFont = this.$$$getFont$$$("Courier New", -1, -1, titlePanel.getFont());
        if (titlePanelFont != null) titlePanel.setFont(titlePanelFont);
        titlePanel.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        titleLabel = new JLabel();
        titleLabel.setBackground(new Color(-6774876));
        Font titleLabelFont = this.$$$getFont$$$("Courier New", Font.PLAIN, 20, titleLabel.getFont());
        if (titleLabelFont != null) titleLabel.setFont(titleLabelFont);
        titleLabel.setHorizontalAlignment(0);
        titleLabel.setText("HOPEFUL: a simple RPG");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        titlePanel.add(titleLabel, gbc);
        beginButton = new JButton();
        Font beginButtonFont = this.$$$getFont$$$("Courier New", -1, -1, beginButton.getFont());
        if (beginButtonFont != null) beginButton.setFont(beginButtonFont);
        beginButton.setText("START.");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        titlePanel.add(beginButton, gbc);
        passButton = new JButton();
        Font passButtonFont = this.$$$getFont$$$("Courier New", -1, -1, passButton.getFont());
        if (passButtonFont != null) passButton.setFont(passButtonFont);
        passButton.setText("PASSWORD");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        titlePanel.add(passButton, gbc);
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
        return titlePanel;
    }

}
