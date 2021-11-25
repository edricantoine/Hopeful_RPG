package ui;

import model.*;
import model.enemies.Enemy;
import model.enemies.Facility.FacilityDrone;
import model.enemies.Facility.FacilityMelee;
import model.enemies.Facility.FacilitySecurity;
import model.enemies.Wasteland.WastelandFrankie;
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
import java.util.Random;

public class Battle {
    private Room room;
    private Color color;
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
    private JButton itemButton;
    private JButton itemButton1;
    private JButton itemButton2;
    private JButton itemButton3;
    private Battle temp;
    private Item loot;
    private JFrame frame;
    private Timer timer;
    private Timer lootTimer;

    public Battle(Room r, Item loot, Color color) {

        temp = this;
        jButtons = new ArrayList<>();
        tButtons = new ArrayList<>();
        bButtons = new ArrayList<>();
        oButtons = new ArrayList<>();
        pLabs = new ArrayList<>();
        eLabs = new ArrayList<>();
        this.room = r;
        this.loot = loot;
        this.color = color;
        battlePanel.setBackground(color);
        frame = new JFrame("Battle");
        frame.setContentPane(battlePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeLabels();
        initializeButtons();
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
        button2.setToolTipText("Deals 20 damage.");
        button3.setToolTipText("Increases defense.");
        button4.setToolTipText("Deals 60 damage to one enemy with 1/3 chance to freeze.");
        button5.setToolTipText("Deals 20 damage - and looks totally badass.");
        button6.setToolTipText("Heals 50 damage to an ally and increases attack.");
        button7.setToolTipText("Heals 50 damage to an ally and increases defense.");
        button8.setToolTipText("Heals 60 damage to all allies and cures status.");
        button9.setToolTipText("Deals 30 damage.");
        button10.setToolTipText("Deals 30 damage to an enemy with 1/2 chance to burn.");
        button11.setToolTipText("Deals 50 damage to all enemies with 1/3 chance to burn.");
        button12.setToolTipText("Guaranteed to poison an enemy.");
        button13.setToolTipText("Deals 10 damage to all enemies.");
        button14.setToolTipText("Makes all enemies afraid.");
        button15.setToolTipText("Gives his life to fully heal an ally's HP and AP and increase damage and defense.");
        button16.setToolTipText("Deals 25 damage to an enemy and heals Oscar by 25 HP.");

        initializeActionListeners();
    }

    public void initializeActionListeners() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(0).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(0).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(0).getSkills().get(0), room.getParty().get(0), temp);

            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(0).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(0).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(0).getSkills().get(1), room.getParty().get(0), temp);

            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(0).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(0).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(0).getSkills().get(2), room.getParty().get(0), temp);

            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(0).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(0).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(0).getSkills().get(3), room.getParty().get(0), temp);

            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(1).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(1).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(1).getSkills().get(0), room.getParty().get(1), temp);

            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(1).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(1).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(1).getSkills().get(1), room.getParty().get(1), temp);

            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(1).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(1).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(1).getSkills().get(2), room.getParty().get(1), temp);

            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(1).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(1).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(1).getSkills().get(3), room.getParty().get(1), temp);

            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(2).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(2).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(2).getSkills().get(0), room.getParty().get(2), temp);

            }
        });
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(2).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(2).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(2).getSkills().get(1), room.getParty().get(2), temp);

            }
        });
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(2).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(2).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(2).getSkills().get(2), room.getParty().get(2), temp);

            }
        });
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(2).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(2).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(2).getSkills().get(3), room.getParty().get(2), temp);

            }
        });
        button13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(3).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(3).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(3).getSkills().get(0), room.getParty().get(3), temp);


            }
        });
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(3).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(3).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(3).getSkills().get(1), room.getParty().get(3), temp);


            }
        });
        button15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(3).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(3).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(3).getSkills().get(2), room.getParty().get(3), temp);

            }
        });
        button16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(3).getSkills()) {
                    s.setSetTargets(new ArrayList<>());
                }
                room.getParty().get(3).setSelectedItem(null);
                new SelectTargetTool(room, room.getParty().get(3).getSkills().get(3), room.getParty().get(3), temp);

            }
        });
        itemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(0).setSelectedSkill(null);
                new SelectItemTool(room, room.getInventory(), room.getParty().get(0), temp);

            }
        });

        itemButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(1).setSelectedSkill(null);
                new SelectItemTool(room, room.getInventory(), room.getParty().get(1), temp);

            }
        });

        itemButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(2).setSelectedSkill(null);
                new SelectItemTool(room, room.getInventory(), room.getParty().get(2), temp);

            }
        });

        itemButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(3).setSelectedSkill(null);
                new SelectItemTool(room, room.getInventory(), room.getParty().get(3), temp);

            }
        });

    }


    public void checkReadyToTurn() {


        if (isReadyToTakeAction()) {
            timer = new Timer(3000, null);
            timer.setRepeats(true);
            timer.setInitialDelay(0);
            timer.addActionListener(new ActionListener() {
                int n = 0;

                @Override
                public void actionPerformed(ActionEvent e) {

                    if (n < room.getAllChars().size()) {

                        if (room.getAllChars().get(n) instanceof PlayerCharacter) {

                            if (room.getAllChars().get(n).getSelectedItem() == null) {
                                usePlayerSkill((PlayerCharacter) room.getAllChars().get(n));
                            } else if (room.getAllChars().get(n).getSelectedSkill() == null) {
                                usePlayerItem((PlayerCharacter) room.getAllChars().get(n));
                            }


                        } else if (room.getAllChars().get(n) instanceof Enemy) {

                            useEnemySkill((Enemy) room.getAllChars().get(n));

                        }

                        n++;
                    } else {
                        timer.stop();
                        for (Char c : room.getAllChars()) {
                            c.turnEndRoutine();
                            refresh();
                        }
                        for (Item i : room.getInventory()) {
                            i.setSetTargets(new ArrayList<>());
                        }
                        checkBattleOver();
                        battleLabel.setText("The battle rages on...");
                    }

                    refresh();
                }
            });
            for (Char c : room.getAllChars()) {
                c.turnBeginRoutine();
                refresh();
            }
            for (Enemy e : room.getEnemies()) {
                if (e instanceof FacilitySecurity) {
                    for (Enemy f : room.getEnemies()) {
                        if (f instanceof FacilityDrone && f.getDead()) {
                            ((FacilitySecurity) e).turnDroneDead();
                            ((FacilitySecurity) e).switchMoveset();
                        }
                    }
                }
                selectEnemySkill(e);
            }

            timer.start();


        }

    }


    private void usePlayerItem(PlayerCharacter p) {
        Item i = p.getSelectedItem();
        for (Char c : i.getSetTargets()) {
            if (!p.getDead()) {

                battleLabel.setText(p.getName() + " used" + i.getName() + "!");
                i.takeEffect(c);
                room.removeFromInventory(i);


            } else {

                battleLabel.setText(p.getName() + " " + "couldn't move this turn...!");

            }
        }
    }


    private void usePlayerSkill(PlayerCharacter p) {
        Skill s = p.getSelectedSkill();
        if (p.canUseSkill(s)) {
            p.useAp(s.getApCost());
            s.setAtkMod(p.getAtkMod());
            for (Char c : s.getSetTargets()) {
                if (s.getTarget().equals("one")) {
                    battleLabel.setText(p.getName() + " " + s.getFlavor() + " " + s.getSetTargets().get(0).getName() + "!");
                } else {
                    battleLabel.setText(p.getName() + " " + s.getFlavor());
                }

                s.takeEffect(c);
                if (c.getCurrentStatus() == StatusEffect.RIPOSTE) {
                    p.takeDamage(s.getDamage() / 2);
                }

                if (s.equals(room.getParty().get(3).getSkills().get(3))) {
                    p.healDamage(25.0);
                }

                if (s.equals(room.getParty().get(3).getSkills().get(2))) {
                    if (!s.getSetTargets().get(0).equals(room.getParty().get(3))) {
                        p.takeDamage(500);
                    } else {
                        battleLabel.setText("Oscar's actions had no effect...");
                        p.healAp(100);
                    }

                }

                s.setAtkMod(1.00);
            }
        } else {
            battleLabel.setText(p.getName() + " " + "couldn't move this turn...!");
        }

    }

    private void useEnemySkill(Enemy e) {
        Skill s = e.getSelectedSkill();
        if (e.canUseSkill(s)) {
            s.setAtkMod(e.getAtkMod());
            for (Char c : s.getSetTargets()) {
                if (s.getTarget().equals("one")) {
                    battleLabel.setText(e.getName() + " " + s.getFlavor() + " " + s.getSetTargets().get(0).getName() + "!");
                } else {
                    battleLabel.setText(e.getName() + " " + s.getFlavor());
                }
                s.takeEffect(c);

                if (e instanceof WastelandFrankie && s.getName().equals("You Know The Drill")) {
                    e.setAtkMod((e.getAtkMod() + 1.50) / 2.0);
                }

                if (e instanceof FacilityMelee && s.getName().equals("Defensive Stance")) {
                    e.setCurrentStatus(StatusEffect.RIPOSTE);
                }

                s.setAtkMod(1.00);
            }
        } else {
            battleLabel.setText(e.getName() + " " + "couldn't move this turn...!");
        }
    }

    public void selectEnemySkill(Enemy e) {
        List<Skill> eSkills = e.getSkills();
        int chooseNum = eSkills.size();
        Random rand = new Random();
        int chosenSkillNum = rand.nextInt(chooseNum);
        Skill chosenSkill = eSkills.get(chosenSkillNum);
        e.setSelectedSkill(chosenSkill);
        chooseEnemySkillTarget(e, chosenSkill);
    }

    public void chooseEnemySkillTarget(Enemy e, Skill s) {
        if (s instanceof AttackSkill) {
            if (s.getTarget().equals("all")) {
                for (PlayerCharacter p : room.getParty()) {
                    s.addToSetTargets(p);
                }
            } else if (s.getTarget().equals("one")) {
                Random rand = new Random();
                int chooseNum = room.getParty().size();
                int targetNum = rand.nextInt(chooseNum);
                s.addToSetTargets(room.getParty().get(targetNum));
            }
        } else if (s instanceof SupportSkill) {
            if (s.getTarget().equals("all")) {
                for (Enemy n : room.getEnemies()) {
                    s.addToSetTargets(n);
                }
            } else if (s.getTarget().equals("one")) {
                Random rand = new Random();
                int chooseNum = room.getEnemies().size();
                int targetNum = rand.nextInt(chooseNum);
                s.addToSetTargets(room.getEnemies().get(targetNum));
            }
        }
    }

    public Boolean isReadyToTakeAction() {
        for (PlayerCharacter p : room.getParty()) {

            if (p.getSelectedSkill() == null && p.getSelectedItem() == null) {
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
                    "Status: " + room.getParty().get(i).getCurrentStatus() + "<br/>" +
                    "Attack modifier: " + room.getParty().get(i).getAtkMod() + "<br/>" +
                    "Damage taken modifier: " + room.getParty().get(i).getDefMod());
        }

        for (int i = 0; i < Math.min(eLabs.size(), room.getEnemies().size()); i++) {
            eLabs.get(i).setText("<html>Name: " + room.getEnemies().get(i).getName() + "<br/>" + "HP: " + room.getEnemies().get(i).getHp() + "/" + room.getEnemies().get(i).getMaxhp() + "<br/>" +
                    "Status: " + room.getEnemies().get(i).getCurrentStatus() + "<br/>" +
                    "Attack modifier: " + room.getEnemies().get(i).getAtkMod() + "<br/>" +
                    "Damage taken modifier: " + room.getEnemies().get(i).getDefMod());
        }

        frame.pack();
    }

    public void checkBattleOver() {
        lootTimer = new Timer(3000, null);
        lootTimer.setRepeats(true);
        lootTimer.setInitialDelay(0);
        lootTimer.addActionListener(new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count == 0) {

                    battleLabel.setText("You win!");

                    count++;
                } else if (count == 1) {

                    if (loot != null) {
                        battleLabel.setText("You got " + loot.getName() + ".");
                        addLootToInventory();
                    } else {
                        battleLabel.setText("There was no item in this room...");
                    }

                    count++;

                } else {
                    lootTimer.stop();
                    if (room.getNextRoom() != null) {
                        frame.dispose();
                        new Battle(room.getNextRoom(), room.getNextRoom().getLoot(), temp.getColor());
                    } else {
                        frame.dispose();
                        new YouWinUI();
                    }

                }
            }
        });

        if (room.isBattleWon()) {
            lootTimer.start();
        } else if (room.isBattleLost()) {
            frame.dispose();
            new GameOverUI();
        }
    }

    public Color getColor() {
        return color;
    }

    public void addLootToInventory() {
        if (loot == null) {
            battleLabel.setText("There was no loot in this room.");
            refresh();
        } else {
            if (room.getInventory().size() < 10) {
                System.out.println("You got " + loot.getName() + "!");
                battleLabel.setText("You got " + loot.getName() + "!");
                room.getNextRoom().getInventory().add(loot);
            } else {
                System.out.println("oooo");
                battleLabel.setText("You got " + loot.getName() + "! But your inventory is full! You didn't take the item.");
            }
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
        itemButton = new JButton();
        Font itemButtonFont = this.$$$getFont$$$("Courier New", -1, -1, itemButton.getFont());
        if (itemButtonFont != null) itemButton.setFont(itemButtonFont);
        itemButton.setText("Item");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(itemButton, gbc);
        itemButton1 = new JButton();
        Font itemButton1Font = this.$$$getFont$$$("Courier New", -1, -1, itemButton1.getFont());
        if (itemButton1Font != null) itemButton1.setFont(itemButton1Font);
        itemButton1.setText("Item");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(itemButton1, gbc);
        itemButton2 = new JButton();
        Font itemButton2Font = this.$$$getFont$$$("Courier New", -1, -1, itemButton2.getFont());
        if (itemButton2Font != null) itemButton2.setFont(itemButton2Font);
        itemButton2.setText("Item");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(itemButton2, gbc);
        itemButton3 = new JButton();
        Font itemButton3Font = this.$$$getFont$$$("Courier New", -1, -1, itemButton3.getFont());
        if (itemButton3Font != null) itemButton3.setFont(itemButton3Font);
        itemButton3.setText("Item");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        battlePanel.add(itemButton3, gbc);
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
