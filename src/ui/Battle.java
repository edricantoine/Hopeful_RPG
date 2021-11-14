package ui;

import model.levelStuff.Room;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Battle {
    private Room room;
    private List<JLabel> pLabs;
    private List<JLabel> eLabs;
    private JLabel p1;
    private JLabel p2;
    private JLabel p3;
    private JLabel p4;
    private JLabel e1;
    private JLabel e2;
    private JLabel e3;
    private JLabel e4;
    private JPanel battlePanel;
    private JLabel battleLabel;

    public Battle(Room r) {
        pLabs = new ArrayList<>();
        eLabs = new ArrayList<>();
        this.room = r;
        initializeLabels();
        JFrame frame = new JFrame("Battle");
        frame.setContentPane(battlePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void initializeLabels() {
        pLabs.add(p1);
        pLabs.add(p2);
        pLabs.add(p3);
        pLabs.add(p4);
        eLabs.add(e1);
        eLabs.add(e2);
        eLabs.add(e3);
        eLabs.add(e4);

        refresh();
        battleLabel.setText(room.getEnemies().get(0).getName() + " and its cohorts" + room.getEnemies().get(0).getEnterText());

    }

    public void refresh() {
        for (int i = 0; i < pLabs.size(); i++) {
            pLabs.get(i).setText("<html>Name: " + room.getParty().get(i).getName() + "<br/>" + "HP: " +
                    room.getParty().get(i).getHp() + "/" + room.getParty().get(i).getMaxhp() + "<br/>" +
                    "AP:" + room.getParty().get(i).getAp() + "/" + room.getParty().get(i).getMaxap() + "<br/>" +
                    "Status: " + room.getParty().get(i).getCurrentStatus());
        }

        for (int i = 0; i < Math.min(eLabs.size(), room.getEnemies().size()); i++) {
            eLabs.get(i).setText("<html>Name: " + room.getEnemies().get(i).getName() + "<br/>" + "HP: " + room.getEnemies().get(i).getHp() + "/" + room.getEnemies().get(i).getMaxhp() + "<br/>" +
                    "Status: " + room.getEnemies().get(i).getCurrentStatus());
        }
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
        battlePanel = new JPanel();
        battlePanel.setLayout(new GridBagLayout());
        battlePanel.setBackground(new Color(-2899838));
        p1 = new JLabel();
        p1.setEnabled(true);
        Font p1Font = this.$$$getFont$$$("Courier New", -1, -1, p1.getFont());
        if (p1Font != null) p1.setFont(p1Font);
        p1.setText("");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        battlePanel.add(p1, gbc);
        p2 = new JLabel();
        p2.setEnabled(true);
        Font p2Font = this.$$$getFont$$$("Courier New", -1, -1, p2.getFont());
        if (p2Font != null) p2.setFont(p2Font);
        p2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        battlePanel.add(p2, gbc);
        p3 = new JLabel();
        p3.setEnabled(true);
        Font p3Font = this.$$$getFont$$$("Courier New", -1, -1, p3.getFont());
        if (p3Font != null) p3.setFont(p3Font);
        p3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        battlePanel.add(p3, gbc);
        p4 = new JLabel();
        Font p4Font = this.$$$getFont$$$("Courier New", -1, -1, p4.getFont());
        if (p4Font != null) p4.setFont(p4Font);
        p4.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        battlePanel.add(p4, gbc);
        e1 = new JLabel();
        Font e1Font = this.$$$getFont$$$("Courier New", -1, -1, e1.getFont());
        if (e1Font != null) e1.setFont(e1Font);
        e1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        battlePanel.add(e1, gbc);
        e2 = new JLabel();
        Font e2Font = this.$$$getFont$$$("Courier New", -1, -1, e2.getFont());
        if (e2Font != null) e2.setFont(e2Font);
        e2.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        battlePanel.add(e2, gbc);
        e3 = new JLabel();
        Font e3Font = this.$$$getFont$$$("Courier New", -1, -1, e3.getFont());
        if (e3Font != null) e3.setFont(e3Font);
        e3.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        battlePanel.add(e3, gbc);
        e4 = new JLabel();
        Font e4Font = this.$$$getFont$$$("Courier New", -1, -1, e4.getFont());
        if (e4Font != null) e4.setFont(e4Font);
        e4.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        battlePanel.add(e4, gbc);
        battleLabel = new JLabel();
        Font battleLabelFont = this.$$$getFont$$$("Courier New", -1, -1, battleLabel.getFont());
        if (battleLabelFont != null) battleLabel.setFont(battleLabelFont);
        battleLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        battlePanel.add(battleLabel, gbc);
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
        return battlePanel;
    }

}
