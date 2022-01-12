package ui;

import model.Item;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ViewInventoryTool {
    private JPanel invPanel;
    private JButton dropButton;
    private JButton dropButton1;
    private JButton dropButton2;
    private JButton dropButton3;
    private JButton dropButton4;
    private JButton dropButton5;
    private JButton dropButton6;
    private JButton dropButton7;
    private JButton dropButton8;
    private JButton dropButton9;
    private JLabel i1l;
    private JLabel i2l;
    private JLabel i3l;
    private JLabel i4l;
    private JLabel i5l;
    private JLabel i6l;
    private JLabel i7l;
    private JLabel i8l;
    private JLabel i9l;
    private JLabel i10l;
    private JButton backButton;
    private List<JButton> bs;
    private List<JLabel> ls;
    private List<Item> inventory;

    public ViewInventoryTool(List<Item> inventory) {
        bs = new ArrayList<>();
        ls = new ArrayList<>();
        this.inventory = inventory;
        JFrame frame = new JFrame("Inventory");
        setUpLists();
        setUpLabels();
        setUpButtons();
        setUpListeners();
        frame.setContentPane(invPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
            }
        });
    }

    public void setUpLists() {
        bs.add(dropButton);
        bs.add(dropButton1);
        bs.add(dropButton2);
        bs.add(dropButton3);
        bs.add(dropButton4);
        bs.add(dropButton5);
        bs.add(dropButton6);
        bs.add(dropButton7);
        bs.add(dropButton8);
        bs.add(dropButton9);
        ls.add(i1l);
        ls.add(i2l);
        ls.add(i3l);
        ls.add(i4l);
        ls.add(i5l);
        ls.add(i6l);
        ls.add(i7l);
        ls.add(i8l);
        ls.add(i9l);
        ls.add(i10l);
    }

    public void setUpLabels() {
        int marker = 0;
        for (int i = 0; i < Math.min(inventory.size(), ls.size()); i++) {
            marker = i;
            ls.get(i).setText(inventory.get(i).getName());
        }

        for (int j = marker + 1; j < ls.size(); j++) {
            ls.get(j).setText("None");
        }

    }

    public void setUpListeners() {
        for (int i = 0; i < inventory.size(); i++) {
            int finalI = i;
            int finalI1 = i;
            bs.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    inventory.remove(inventory.get(finalI));
                    refresh();

                }
            });
        }
    }

    public void setUpButtons() {

        int marker = 0;
        for (int i = 0; i < Math.min(inventory.size(), bs.size()); i++) {
            marker = i;
        }

        for (int j = marker + 1; j < bs.size(); j++) {
            bs.get(j).setEnabled(false);
        }

    }

    public void refresh() {
        setUpLists();
        setUpLabels();
        setUpButtons();
        setUpListeners();
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
        invPanel = new JPanel();
        invPanel.setLayout(new GridBagLayout());
        invPanel.setBackground(new Color(-4988956));
        dropButton = new JButton();
        Font dropButtonFont = this.$$$getFont$$$("Courier New", -1, -1, dropButton.getFont());
        if (dropButtonFont != null) dropButton.setFont(dropButtonFont);
        dropButton.setText("Drop");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        invPanel.add(dropButton, gbc);
        dropButton1 = new JButton();
        Font dropButton1Font = this.$$$getFont$$$("Courier New", -1, -1, dropButton1.getFont());
        if (dropButton1Font != null) dropButton1.setFont(dropButton1Font);
        dropButton1.setText("Drop");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        invPanel.add(dropButton1, gbc);
        dropButton2 = new JButton();
        Font dropButton2Font = this.$$$getFont$$$("Courier New", -1, -1, dropButton2.getFont());
        if (dropButton2Font != null) dropButton2.setFont(dropButton2Font);
        dropButton2.setText("Drop");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        invPanel.add(dropButton2, gbc);
        dropButton3 = new JButton();
        Font dropButton3Font = this.$$$getFont$$$("Courier New", -1, -1, dropButton3.getFont());
        if (dropButton3Font != null) dropButton3.setFont(dropButton3Font);
        dropButton3.setText("Drop");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        invPanel.add(dropButton3, gbc);
        dropButton4 = new JButton();
        dropButton4.setEnabled(true);
        Font dropButton4Font = this.$$$getFont$$$("Courier New", -1, -1, dropButton4.getFont());
        if (dropButton4Font != null) dropButton4.setFont(dropButton4Font);
        dropButton4.setText("Drop");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        invPanel.add(dropButton4, gbc);
        dropButton5 = new JButton();
        Font dropButton5Font = this.$$$getFont$$$("Courier New", -1, -1, dropButton5.getFont());
        if (dropButton5Font != null) dropButton5.setFont(dropButton5Font);
        dropButton5.setText("Drop");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        invPanel.add(dropButton5, gbc);
        dropButton6 = new JButton();
        Font dropButton6Font = this.$$$getFont$$$("Courier New", -1, -1, dropButton6.getFont());
        if (dropButton6Font != null) dropButton6.setFont(dropButton6Font);
        dropButton6.setText("Drop");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        invPanel.add(dropButton6, gbc);
        dropButton7 = new JButton();
        Font dropButton7Font = this.$$$getFont$$$("Courier New", -1, -1, dropButton7.getFont());
        if (dropButton7Font != null) dropButton7.setFont(dropButton7Font);
        dropButton7.setText("Drop");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        invPanel.add(dropButton7, gbc);
        dropButton8 = new JButton();
        Font dropButton8Font = this.$$$getFont$$$("Courier New", -1, -1, dropButton8.getFont());
        if (dropButton8Font != null) dropButton8.setFont(dropButton8Font);
        dropButton8.setText("Drop");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        invPanel.add(dropButton8, gbc);
        dropButton9 = new JButton();
        Font dropButton9Font = this.$$$getFont$$$("Courier New", -1, -1, dropButton9.getFont());
        if (dropButton9Font != null) dropButton9.setFont(dropButton9Font);
        dropButton9.setText("Drop");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        invPanel.add(dropButton9, gbc);
        i1l = new JLabel();
        Font i1lFont = this.$$$getFont$$$("Courier New", -1, -1, i1l.getFont());
        if (i1lFont != null) i1l.setFont(i1lFont);
        i1l.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        invPanel.add(i1l, gbc);
        i2l = new JLabel();
        Font i2lFont = this.$$$getFont$$$("Courier New", -1, -1, i2l.getFont());
        if (i2lFont != null) i2l.setFont(i2lFont);
        i2l.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        invPanel.add(i2l, gbc);
        i3l = new JLabel();
        Font i3lFont = this.$$$getFont$$$("Courier New", -1, -1, i3l.getFont());
        if (i3lFont != null) i3l.setFont(i3lFont);
        i3l.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        invPanel.add(i3l, gbc);
        i4l = new JLabel();
        Font i4lFont = this.$$$getFont$$$("Courier New", -1, -1, i4l.getFont());
        if (i4lFont != null) i4l.setFont(i4lFont);
        i4l.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        invPanel.add(i4l, gbc);
        i5l = new JLabel();
        Font i5lFont = this.$$$getFont$$$("Courier New", -1, -1, i5l.getFont());
        if (i5lFont != null) i5l.setFont(i5lFont);
        i5l.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        invPanel.add(i5l, gbc);
        i6l = new JLabel();
        Font i6lFont = this.$$$getFont$$$("Courier New", -1, -1, i6l.getFont());
        if (i6lFont != null) i6l.setFont(i6lFont);
        i6l.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        invPanel.add(i6l, gbc);
        i7l = new JLabel();
        Font i7lFont = this.$$$getFont$$$("Courier New", -1, -1, i7l.getFont());
        if (i7lFont != null) i7l.setFont(i7lFont);
        i7l.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        invPanel.add(i7l, gbc);
        i8l = new JLabel();
        Font i8lFont = this.$$$getFont$$$("Courier New", -1, -1, i8l.getFont());
        if (i8lFont != null) i8l.setFont(i8lFont);
        i8l.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        invPanel.add(i8l, gbc);
        i9l = new JLabel();
        Font i9lFont = this.$$$getFont$$$("Courier New", -1, -1, i9l.getFont());
        if (i9lFont != null) i9l.setFont(i9lFont);
        i9l.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        invPanel.add(i9l, gbc);
        i10l = new JLabel();
        Font i10lFont = this.$$$getFont$$$("Courier New", -1, -1, i10l.getFont());
        if (i10lFont != null) i10l.setFont(i10lFont);
        i10l.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        invPanel.add(i10l, gbc);
        backButton = new JButton();
        Font backButtonFont = this.$$$getFont$$$("Courier New", -1, -1, backButton.getFont());
        if (backButtonFont != null) backButton.setFont(backButtonFont);
        backButton.setText("Back");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        invPanel.add(backButton, gbc);
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
        return invPanel;
    }

}