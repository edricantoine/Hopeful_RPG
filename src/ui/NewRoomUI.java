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

//A class representing the UI displayed in a non-battle room.

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
    private JButton partyStatusButton;
    private JButton inventoryButton;
    private JLabel eventLabel;

    private NewLevel level;
    private NewRoom room;
    private int row;
    private int col;

    public NewRoomUI(NewLevel l, NewRoom rm, int r, int c) {
        level = l;
        room = rm;
        this.row = r;
        this.col = c;
        //row, col are stored in this Room for the ability to change the room from its Battle (if any).
        JFrame frame = new JFrame("Room");

        frame.setContentPane(nRoomPanel);


        initializeButtonsAndLabels();
        inititializeActionListeners();
        nRoomPanel.setBackground(level.getColor());
        centerPanel.setBackground(level.getColor());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        //creates a new Battle UI if this room has a battle
        if (room.getHasBattle()) {
            frame.dispose();
            new Battle(room, level.getColor(), level, r, c);
        }
        if (room.getEvent() != null) {
            room.getEvent().takeEffect(room.getParty());
            room.useEvent();
        }
        partyStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PartyStatusUI(room.getParty(), level.getColor());
            }
        });
        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewInventoryTool(room.getInventory());
            }
        });
    }



    public void inititializeActionListeners() {
        //left, down, right, up button listeners: moves to the next room in the direction of the pressed button.

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

        //takes the room's item, then sets the item to null so it can't be picked up again
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

    //This function initializes buttons like so:
    //for the room navigation buttons, if there is no room to the top, right, left, or bottom, the respective button
    //will be disabled.
    // for the item button, if the user cannot pick up an item, the item button is disabled.

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

        if (room.getEvent() != null) {
            eventLabel.setText(room.getEvent().getFlavor());
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
        takeItemButton = new JButton();
        Font takeItemButtonFont = this.$$$getFont$$$("Courier New", -1, -1, takeItemButton.getFont());
        if (takeItemButtonFont != null) takeItemButton.setFont(takeItemButtonFont);
        takeItemButton.setText("Take item");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(takeItemButton, gbc);
        centerLabel = new JLabel();
        Font centerLabelFont = this.$$$getFont$$$("Courier New", -1, -1, centerLabel.getFont());
        if (centerLabelFont != null) centerLabel.setFont(centerLabelFont);
        centerLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(centerLabel, gbc);
        roomLabel = new JLabel();
        Font roomLabelFont = this.$$$getFont$$$("Courier New", -1, -1, roomLabel.getFont());
        if (roomLabelFont != null) roomLabel.setFont(roomLabelFont);
        roomLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(roomLabel, gbc);
        bossLabel = new JLabel();
        Font bossLabelFont = this.$$$getFont$$$("Courier New", -1, -1, bossLabel.getFont());
        if (bossLabelFont != null) bossLabel.setFont(bossLabelFont);
        bossLabel.setText("Label");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        centerPanel.add(bossLabel, gbc);
        partyStatusButton = new JButton();
        Font partyStatusButtonFont = this.$$$getFont$$$("Courier New", -1, -1, partyStatusButton.getFont());
        if (partyStatusButtonFont != null) partyStatusButton.setFont(partyStatusButtonFont);
        partyStatusButton.setText("Party status");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(partyStatusButton, gbc);
        inventoryButton = new JButton();
        Font inventoryButtonFont = this.$$$getFont$$$("Courier New", -1, -1, inventoryButton.getFont());
        if (inventoryButtonFont != null) inventoryButton.setFont(inventoryButtonFont);
        inventoryButton.setText("Inventory");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(inventoryButton, gbc);
        eventLabel = new JLabel();
        Font eventLabelFont = this.$$$getFont$$$("Courier New", -1, -1, eventLabel.getFont());
        if (eventLabelFont != null) eventLabel.setFont(eventLabelFont);
        eventLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(eventLabel, gbc);
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
