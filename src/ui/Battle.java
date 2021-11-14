package ui;

import model.PlayerCharacter;
import model.levelStuff.Room;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Battle {
    private Room room;
    private List<JLabel> pLabs;
    private List<JLabel> eLabs;
    private List<JButton> jButtons;
    private List<JButton> tButtons;
    private List<JButton> bButtons;
    private List<JButton> oButtons;
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
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;

    public Battle(Room r) {
        jButtons = new ArrayList<>();
        tButtons = new ArrayList<>();
        bButtons = new ArrayList<>();
        oButtons = new ArrayList<>();
        pLabs = new ArrayList<>();
        eLabs = new ArrayList<>();
        this.room = r;
        initializeLabels();
        initializeButtons();
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

    public void initializeButtons() {
        jButtons.add(button1);
        jButtons.add(button2);
        jButtons.add(button3);
        jButtons.add(button4);
        tButtons.add(button5);
        tButtons.add(button6);
        tButtons.add(button7);
        tButtons.add(button8);
        bButtons.add(button9);
        bButtons.add(button10);
        bButtons.add(button11);
        bButtons.add(button12);
        oButtons.add(button13);
        oButtons.add(button14);
        oButtons.add(button15);
        oButtons.add(button16);
        initializeButtonLabels();
    }

    public void initializeButtonLabels() {
        for (int i = 0; i < jButtons.size(); i++) {
            jButtons.get(i).setText("<html>" + room.getParty().get(0).getSkills().get(i).getName() + "<br/>" +
                    room.getParty().get(0).getSkills().get(i).getApCost() + " AP</html>");

        }
        for (int i = 0; i < tButtons.size(); i++) {
            tButtons.get(i).setText("<html>" + room.getParty().get(1).getSkills().get(i).getName() + "<br/>" +
                    room.getParty().get(1).getSkills().get(i).getApCost() + " AP</html>");
        }
        for (int i = 0; i < bButtons.size(); i++) {
            bButtons.get(i).setText("<html>" + room.getParty().get(2).getSkills().get(i).getName() + "<br/>" +
                    room.getParty().get(2).getSkills().get(i).getApCost() + " AP</html>");
        }
        for (int i = 0; i < oButtons.size(); i++) {
            oButtons.get(i).setText("<html>" + room.getParty().get(3).getSkills().get(i).getName() + "<br/>" +
                    room.getParty().get(3).getSkills().get(i).getApCost() + " AP</html>");
        }

        initializeTooltips();
    }

    public void initializeTooltips() {
        button1.setToolTipText("Deals 50 damage to all enemies with 1/2 chance to freeze.");
        button2.setToolTipText("Deals 30 damage.");
        button3.setToolTipText("Increases defense.");
        button4.setToolTipText("Deals 60 damage to one enemy with 1/3 chance to freeze.");
        button5.setToolTipText("Deals 25 damage and looks totally badass.");
        button6.setToolTipText("Heals 50 damage to an ally and increases attack.");
        button7.setToolTipText("Heals 50 damage to an ally and increases defense.");
        button8.setToolTipText("Heals 60 damage to all allies and cures status.");
        button9.setToolTipText("Deals 40 damage.");
        button10.setToolTipText("Deals 30 damage to an enemy with 1/2 chance to burn.");
        button11.setToolTipText("Deals 50 damage to all enemies with 1/3 chance to burn.");
        button12.setToolTipText("Guaranteed to poison an enemy.");
        button13.setToolTipText("Deals 20 damage to all enemies.");
        button14.setToolTipText("Makes an enemy afraid.");
        button15.setToolTipText("Cures status on one ally.");
        button16.setToolTipText("Deals 50 damage to all enemies with a 1/5 chance to poison.");

        initializeActionListeners();
    }

    public void initializeActionListeners() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(0).setSelectedSkill(room.getParty().get(0).getSkills().get(0));
                new SelectTargetTool(room, room.getParty().get(0).getSkills().get(0));
                checkReadyToTurn();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(0).setSelectedSkill(room.getParty().get(0).getSkills().get(1));
                new SelectTargetTool(room, room.getParty().get(0).getSkills().get(1));
                checkReadyToTurn();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(0).setSelectedSkill(room.getParty().get(0).getSkills().get(2));
                new SelectTargetTool(room, room.getParty().get(0).getSkills().get(2));
                checkReadyToTurn();
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(0).setSelectedSkill(room.getParty().get(0).getSkills().get(3));
                new SelectTargetTool(room, room.getParty().get(0).getSkills().get(3));
                checkReadyToTurn();
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(1).setSelectedSkill(room.getParty().get(1).getSkills().get(0));
                new SelectTargetTool(room, room.getParty().get(1).getSkills().get(0));
                checkReadyToTurn();
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(1).setSelectedSkill(room.getParty().get(1).getSkills().get(1));
                new SelectTargetTool(room, room.getParty().get(1).getSkills().get(1));
                checkReadyToTurn();
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(1).setSelectedSkill(room.getParty().get(1).getSkills().get(2));
                new SelectTargetTool(room, room.getParty().get(1).getSkills().get(2));
                checkReadyToTurn();
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(1).setSelectedSkill(room.getParty().get(1).getSkills().get(3));
                new SelectTargetTool(room, room.getParty().get(1).getSkills().get(3));
                checkReadyToTurn();
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(2).setSelectedSkill(room.getParty().get(2).getSkills().get(0));
                new SelectTargetTool(room, room.getParty().get(2).getSkills().get(0));
                checkReadyToTurn();
            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(2).setSelectedSkill(room.getParty().get(2).getSkills().get(1));
                new SelectTargetTool(room, room.getParty().get(2).getSkills().get(1));
                checkReadyToTurn();
            }
        });
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(2).setSelectedSkill(room.getParty().get(2).getSkills().get(2));
                new SelectTargetTool(room, room.getParty().get(2).getSkills().get(2));
                checkReadyToTurn();
            }
        });
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(2).setSelectedSkill(room.getParty().get(2).getSkills().get(3));
                new SelectTargetTool(room, room.getParty().get(2).getSkills().get(3));
                checkReadyToTurn();
            }
        });
        button13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(3).setSelectedSkill(room.getParty().get(3).getSkills().get(0));
                new SelectTargetTool(room, room.getParty().get(3).getSkills().get(0));
                checkReadyToTurn();
            }
        });
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(3).setSelectedSkill(room.getParty().get(3).getSkills().get(1));
                new SelectTargetTool(room, room.getParty().get(3).getSkills().get(1));
                checkReadyToTurn();
            }
        });
        button15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(3).setSelectedSkill(room.getParty().get(3).getSkills().get(2));
                new SelectTargetTool(room, room.getParty().get(3).getSkills().get(2));
                checkReadyToTurn();
            }
        });
        button16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(3).setSelectedSkill(room.getParty().get(3).getSkills().get(3));
                new SelectTargetTool(room, room.getParty().get(3).getSkills().get(3));
                checkReadyToTurn();
            }
        });

    }

    public void checkReadyToTurn() {

    }

    public Boolean isReadyToTakeAction() {
        for (PlayerCharacter p : room.getParty()) {
            if (p.getSelectedSkill() == null) {
                return false;
            }
        }
        return true;
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
        p1.setText("j");
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
        p2.setText("t");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        battlePanel.add(p2, gbc);
        p3 = new JLabel();
        p3.setEnabled(true);
        Font p3Font = this.$$$getFont$$$("Courier New", -1, -1, p3.getFont());
        if (p3Font != null) p3.setFont(p3Font);
        p3.setText("b");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        battlePanel.add(p3, gbc);
        p4 = new JLabel();
        Font p4Font = this.$$$getFont$$$("Courier New", -1, -1, p4.getFont());
        if (p4Font != null) p4.setFont(p4Font);
        p4.setText("o");
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
        button1 = new JButton();
        Font button1Font = this.$$$getFont$$$("Courier New", -1, -1, button1.getFont());
        if (button1Font != null) button1.setFont(button1Font);
        button1.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button1, gbc);
        button2 = new JButton();
        Font button2Font = this.$$$getFont$$$("Courier New", -1, -1, button2.getFont());
        if (button2Font != null) button2.setFont(button2Font);
        button2.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button2, gbc);
        button3 = new JButton();
        Font button3Font = this.$$$getFont$$$("Courier New", -1, -1, button3.getFont());
        if (button3Font != null) button3.setFont(button3Font);
        button3.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button3, gbc);
        button4 = new JButton();
        button4.setEnabled(true);
        Font button4Font = this.$$$getFont$$$("Courier New", -1, -1, button4.getFont());
        if (button4Font != null) button4.setFont(button4Font);
        button4.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button4, gbc);
        button5 = new JButton();
        button5.setEnabled(true);
        Font button5Font = this.$$$getFont$$$("Courier New", -1, -1, button5.getFont());
        if (button5Font != null) button5.setFont(button5Font);
        button5.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button5, gbc);
        button6 = new JButton();
        button6.setEnabled(true);
        Font button6Font = this.$$$getFont$$$("Courier New", -1, -1, button6.getFont());
        if (button6Font != null) button6.setFont(button6Font);
        button6.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button6, gbc);
        button7 = new JButton();
        button7.setEnabled(true);
        Font button7Font = this.$$$getFont$$$("Courier New", -1, -1, button7.getFont());
        if (button7Font != null) button7.setFont(button7Font);
        button7.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button7, gbc);
        button8 = new JButton();
        button8.setEnabled(true);
        Font button8Font = this.$$$getFont$$$("Courier New", -1, -1, button8.getFont());
        if (button8Font != null) button8.setFont(button8Font);
        button8.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button8, gbc);
        button9 = new JButton();
        Font button9Font = this.$$$getFont$$$("Courier New", -1, -1, button9.getFont());
        if (button9Font != null) button9.setFont(button9Font);
        button9.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button9, gbc);
        button10 = new JButton();
        Font button10Font = this.$$$getFont$$$("Courier New", -1, -1, button10.getFont());
        if (button10Font != null) button10.setFont(button10Font);
        button10.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button10, gbc);
        button11 = new JButton();
        Font button11Font = this.$$$getFont$$$("Courier New", -1, -1, button11.getFont());
        if (button11Font != null) button11.setFont(button11Font);
        button11.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button11, gbc);
        button12 = new JButton();
        Font button12Font = this.$$$getFont$$$("Courier New", -1, -1, button12.getFont());
        if (button12Font != null) button12.setFont(button12Font);
        button12.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button12, gbc);
        button13 = new JButton();
        Font button13Font = this.$$$getFont$$$("Courier New", -1, -1, button13.getFont());
        if (button13Font != null) button13.setFont(button13Font);
        button13.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button13, gbc);
        button14 = new JButton();
        Font button14Font = this.$$$getFont$$$("Courier New", -1, -1, button14.getFont());
        if (button14Font != null) button14.setFont(button14Font);
        button14.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button14, gbc);
        button15 = new JButton();
        Font button15Font = this.$$$getFont$$$("Courier New", -1, -1, button15.getFont());
        if (button15Font != null) button15.setFont(button15Font);
        button15.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button15, gbc);
        button16 = new JButton();
        Font button16Font = this.$$$getFont$$$("Courier New", -1, -1, button16.getFont());
        if (button16Font != null) button16.setFont(button16Font);
        button16.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(button16, gbc);
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
