package ui;

import model.levelStuff.NewLevel;
import model.levelStuff.NewRoom;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class NewRoomUI {
    private JPanel nRoomPanel;
    private JButton upButton;
    private JButton rightButton;
    private JButton downButton;
    private JButton leftButton;
    private JPanel centerPanel;
    private JButton takeItemButton;
    private JLabel centerLabel;
    private JLabel roomLabel;
    private JLabel bossLabel;

    private NewLevel level;
    private NewRoom room;
    private int row;
    private int col;

    public NewRoomUI(NewLevel l, NewRoom rm, int r, int c) {
        level = l;
        room = rm;
        this.row = r;
        this.col = c;


        initializeButtonsAndLabels();
        inititializeActionListeners();
        nRoomPanel.setBackground(level.getColor());


        JFrame frame = new JFrame("Room");
        frame.setContentPane(nRoomPanel);
        frame.getContentPane().setBackground(level.getColor());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        if (room.getHasBattle()) {
            frame.dispose();
            new Battle(room, level.getColor(), level, r, c);
        }
    }

    public void inititializeActionListeners() {
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new NewRoomUI(level, level.getRooms()[row][col - 1], row, col - 1);
            }
        });
        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new NewRoomUI(level, level.getRooms()[row + 1][col], row + 1, col);
            }
        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new NewRoomUI(level, level.getRooms()[row][col + 1], row, col + 1);
            }
        });
        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new NewRoomUI(level, level.getRooms()[row - 1][col], row - 1, col);
            }
        });
        takeItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getInventory().add(room.getItem());
                takeItemButton.setEnabled(false);
                centerLabel.setText("Item taken.");
                room.setItemNull();

            }
        });
    }

    public void initializeButtonsAndLabels() {
        int rows = level.getRs();
        int cols = level.getCs();

        if (this.row == rows - 1) {
            downButton.setEnabled(false);
        }

        if (this.row == 0) {
            upButton.setEnabled(false);
        }

        if (this.col == cols - 1) {
            rightButton.setEnabled(false);
        }

        if (this.col == 0) {
            leftButton.setEnabled(false);
        }

        if (room.getItem() == null || !room.canPickUpItem()) {
            takeItemButton.setEnabled(false);
        }

        if (room.getItem() == null) {
            centerLabel.setText("There is no item in this room...");
        } else {
            centerLabel.setText(room.getItem().getName() + " is in this room!");
        }

        roomLabel.setText("Room " + row + "-" + col);
        bossLabel.setText("Bosses defeated: " + level.howManyBossesDead() + "/3");
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
        nRoomPanel = new JPanel();
        nRoomPanel.setLayout(new BorderLayout(0, 0));
        upButton = new JButton();
        Font upButtonFont = this.$$$getFont$$$("Courier New", -1, -1, upButton.getFont());
        if (upButtonFont != null) upButton.setFont(upButtonFont);
        upButton.setText("Go Up");
        nRoomPanel.add(upButton, BorderLayout.NORTH);
        rightButton = new JButton();
        Font rightButtonFont = this.$$$getFont$$$("Courier New", -1, -1, rightButton.getFont());
        if (rightButtonFont != null) rightButton.setFont(rightButtonFont);
        rightButton.setText("Go right");
        nRoomPanel.add(rightButton, BorderLayout.EAST);
        downButton = new JButton();
        Font downButtonFont = this.$$$getFont$$$("Courier New", -1, -1, downButton.getFont());
        if (downButtonFont != null) downButton.setFont(downButtonFont);
        downButton.setText("Go down");
        nRoomPanel.add(downButton, BorderLayout.SOUTH);
        leftButton = new JButton();
        Font leftButtonFont = this.$$$getFont$$$("Courier New", -1, -1, leftButton.getFont());
        if (leftButtonFont != null) leftButton.setFont(leftButtonFont);
        leftButton.setText("Go Left");
        nRoomPanel.add(leftButton, BorderLayout.WEST);
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        nRoomPanel.add(centerPanel, BorderLayout.CENTER);
        final JPanel spacer1 = new JPanel();
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        centerPanel.add(spacer1, gbc);
        takeItemButton = new JButton();
        Font takeItemButtonFont = this.$$$getFont$$$("Courier New", -1, -1, takeItemButton.getFont());
        if (takeItemButtonFont != null) takeItemButton.setFont(takeItemButtonFont);
        takeItemButton.setText("Take item");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(takeItemButton, gbc);
        centerLabel = new JLabel();
        Font centerLabelFont = this.$$$getFont$$$("Courier New", -1, -1, centerLabel.getFont());
        if (centerLabelFont != null) centerLabel.setFont(centerLabelFont);
        centerLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        centerPanel.add(centerLabel, gbc);
        roomLabel = new JLabel();
        Font roomLabelFont = this.$$$getFont$$$("Courier New", -1, -1, roomLabel.getFont());
        if (roomLabelFont != null) roomLabel.setFont(roomLabelFont);
        roomLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(roomLabel, gbc);
        bossLabel = new JLabel();
        Font bossLabelFont = this.$$$getFont$$$("Courier New", -1, -1, bossLabel.getFont());
        if (bossLabelFont != null) bossLabel.setFont(bossLabelFont);
        bossLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        centerPanel.add(bossLabel, gbc);
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
        return nRoomPanel;
    }

}
