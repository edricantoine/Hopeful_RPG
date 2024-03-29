package ui;

import model.*;
import model.enemies.City.CityBruiser;
import model.enemies.City.CityKnifer;
import model.enemies.Enemy;
import model.enemies.Facility.FacilityDrone;
import model.enemies.Facility.FacilitySecurity;
import model.levelStuff.NewLevel;
import model.levelStuff.NewRoom;

import javax.swing.Timer;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.*;

public class Battle {

    private NewRoom room; //room the battle is based around
    private NewLevel level; //level this battle is part of
    private Color color; //background color of battle screen
    private List<JLabel> pLabs; //player labels
    private List<JLabel> eLabs; //enemy labels
    public List<JButton> jButtons; //Jack's skill buttons
    public List<JButton> tButtons; //Trip's skill buttons
    public List<JButton> bButtons; //Boyle's skill buttons
    public List<JButton> oButtons; //Oscar's skill buttons
    private List<Item> possibleLoot; //Possible loot drops from enemies
    private List<JLabel> allLabs; //ALl labels, sorted by turn order
    private Map<Char, Integer> turnOrder; //maps character to their turn order
    //party labels
    private JLabel p1;
    private JLabel p2;
    private JLabel p3;
    private JLabel p4;
    //enemy labels
    private JLabel e1;
    private JLabel e2;
    private JLabel e3;
    private JLabel e4;
    //Swing components
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
    public JButton itemButton;
    public JButton itemButton1;
    public JButton itemButton2;
    public JButton itemButton3;
    private JLabel bossLabel;
    private Battle temp;
    private Item loot;
    private JFrame frame;
    //Turn timer
    private Timer timer;
    //Loot obtaining timer
    private Timer lootTimer;

    private int row; //row of level's room grid that this battle is in
    private int col; //column of level's room grid that this battle is in

    public Battle(NewRoom r, Color color, NewLevel level, int row, int col) {
        this.row = row;
        this.col = col;
        temp = this;
        jButtons = new ArrayList<>();
        tButtons = new ArrayList<>();
        bButtons = new ArrayList<>();
        oButtons = new ArrayList<>();
        pLabs = new ArrayList<>();
        eLabs = new ArrayList<>();

        possibleLoot = new ArrayList<>();
        this.room = r;
        this.level = level;
        this.color = color;
        this.loot = null;
        battlePanel.setBackground(color);
        frame = new JFrame("Battle");
        frame.setContentPane(battlePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeLabels();
        initializeButtons();
        initializeTurnOrder();
        initializeAllLabs();
        if (decideLoot()) {
            chooseLoot();
        }
        frame.pack();
        frame.setVisible(true);
//        playSound();


    }

    //getters, setters used in program
    public Color getColor() {
        return color;
    }

    //initializes turn order map

    public void initializeTurnOrder() {
        turnOrder = new HashMap<>();
        for (int i = 0; i < room.getAllChars().size(); i++) {
            turnOrder.put(room.getAllChars().get(i), i);
        }
    }

    // initializes labels sorted by respective character speed

    public void initializeAllLabs() {

        allLabs = new ArrayList<>();
        for (int i = 0; i < room.getAllChars().size(); i++) {
            for (int j = 0; j < room.getParty().size(); j++) {
                if (turnOrder.containsKey(room.getParty().get(j))) {
                    if (turnOrder.get(room.getParty().get(j)) == i) {
                        allLabs.add(pLabs.get(j));
                    }
                }
            }
            for (int k = 0; k < room.getEnemies().size(); k++) {
                if (turnOrder.containsKey(room.getEnemies().get(k))) {
                    if (turnOrder.get(room.getEnemies().get(k)) == i) {
                        allLabs.add(eLabs.get(k));
                    }
                }
            }
        }
    }

    //decides if this room has loot

    public Boolean decideLoot() {
        Random rand = new Random();
        int lootchance = rand.nextInt(2);
        return lootchance == 0;
    }

    //chooses which enemy to get the room's loot drop from

    public void chooseLoot() {
        for (Enemy e : room.getEnemies()) {
            possibleLoot.add(e.getLoot());
        }

        Random rand = new Random();
        int index = rand.nextInt(possibleLoot.size());
        this.loot = possibleLoot.get(index);
    }

    //initializes all labels

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
        if (room.getWhichBoss() != 0) {
            bossLabel.setText("BOSS BATTLE");
        }
    }

    //initializes buttons and adds them to their proper lists

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

    //initialize labels on buttons

    public void initializeButtonLabels() {
        for (int i = 0; i < jButtons.size(); i++) {
            jButtons.get(i).setText("<html>" + room.getParty().get(0).getSkills().get(i).getName() + "<br/>" +
                    room.getParty().get(0).getSkills().get(i).getApCost() + " AP</html>");
            jButtons.get(i).setEnabled(false);

        }
        for (int i = 0; i < tButtons.size(); i++) {
            tButtons.get(i).setText("<html>" + room.getParty().get(1).getSkills().get(i).getName() + "<br/>" +
                    room.getParty().get(1).getSkills().get(i).getApCost() + " AP</html>");
            tButtons.get(i).setEnabled(false);
        }
        for (int i = 0; i < bButtons.size(); i++) {
            bButtons.get(i).setText("<html>" + room.getParty().get(2).getSkills().get(i).getName() + "<br/>" +
                    room.getParty().get(2).getSkills().get(i).getApCost() + " AP</html>");
            bButtons.get(i).setEnabled(false);
        }
        for (int i = 0; i < oButtons.size(); i++) {
            oButtons.get(i).setText("<html>" + room.getParty().get(3).getSkills().get(i).getName() + "<br/>" +
                    room.getParty().get(3).getSkills().get(i).getApCost() + " AP</html>");
            oButtons.get(i).setEnabled(false);
        }

        for (int i = 0; i < jButtons.size(); i++) {
            if (room.getParty().get(0).getDead() || room.getParty().get(0).canUseSkill(room.getParty().get(0).getSkills().get(i))) {
                jButtons.get(i).setEnabled(true);
            }

        }
        for (int i = 0; i < tButtons.size(); i++) {
            if (room.getParty().get(1).getDead() || room.getParty().get(1).canUseSkill(room.getParty().get(1).getSkills().get(i))) {
                tButtons.get(i).setEnabled(true);
            }

        }
        for (int i = 0; i < bButtons.size(); i++) {
            if (room.getParty().get(2).getDead() || room.getParty().get(2).canUseSkill(room.getParty().get(2).getSkills().get(i))) {
                bButtons.get(i).setEnabled(true);
            }

        }
        for (int i = 0; i < oButtons.size(); i++) {
            if (room.getParty().get(3).getDead() || room.getParty().get(3).canUseSkill(room.getParty().get(3).getSkills().get(i))) {
                oButtons.get(i).setEnabled(true);
            }

        }
        itemButton.setEnabled(true);
        itemButton1.setEnabled(true);
        itemButton2.setEnabled(true);
        itemButton3.setEnabled(true);

        initializeTooltips();
    }

    //initializes tooltips for buttons

    public void initializeTooltips() {
        button2.setToolTipText("Deals 50 damage to all enemies with 1/2 chance to freeze.");
        button1.setToolTipText("Deals 25 damage.");
        button3.setToolTipText("Deals 50 damage, 75 to a Numbed enemy.");
        button4.setToolTipText("Deals 60 damage to one enemy with 1/3 chance to freeze.");
        button5.setToolTipText("Deals 20 damage - and looks totally badass.");
        button6.setToolTipText("Heals 50 damage to an ally, increases attack, and cures status.");
        button7.setToolTipText("Heals 50 damage to an ally, increases defense, and cures status.");
        button8.setToolTipText("Heals 70 damage to all allies.");
        button9.setToolTipText("Deals 40 damage.");
        button10.setToolTipText("Deals 50 damage to an enemy with 1/2 chance to burn.");
        button11.setToolTipText("Deals 75 damage to all enemies with 1/3 chance to burn.");
        button12.setToolTipText("Guaranteed to poison an enemy.");
        button13.setToolTipText("Deals 15 damage to all enemies.");
        button14.setToolTipText("Makes all enemies afraid.");
        button15.setToolTipText("Gives his life to fully heal an ally's HP and AP and increase damage and defense. If " +
                "he targets himself, does this to himself at the cost of all AP.");
        button16.setToolTipText("Deals 50 damage to an enemy and heals Oscar by 25 HP.");

        initializeActionListeners();
    }

    //initializes action listeners for buttons

    public void initializeActionListeners() {

        //ON EACH GIVEN SKILL BUTTON:
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Skill s : room.getParty().get(0).getSkills()) {
                    s.setSetTargets(new ArrayList<>()); //sets respective skill's targets to a new ArrayList
                }
                room.getParty().get(0).setSelectedItem(null); //sets corresponding character's selected item to null
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
        //ON EACH GIVEN ITEM BUTTON:

        itemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                room.getParty().get(0).setSelectedSkill(null); //sets corresponding character's selected skill to null
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

    //takes all actions needed for 1 turn of the game

    public void checkReadyToTurn() {


        if (isReadyToTakeAction()) {

            //all buttons temporarily disabled

            for (int i = 0; i < jButtons.size(); i++) {
                jButtons.get(i).setEnabled(false);

            }
            for (int i = 0; i < tButtons.size(); i++) {
                tButtons.get(i).setEnabled(false);

            }
            for (int i = 0; i < bButtons.size(); i++) {
                bButtons.get(i).setEnabled(false);

            }
            for (int i = 0; i < oButtons.size(); i++) {
                oButtons.get(i).setEnabled(false);

            }
            itemButton.setEnabled(false);
            itemButton1.setEnabled(false);
            itemButton2.setEnabled(false);
            itemButton3.setEnabled(false);

            //new key listener added to frame that lets player fast-forward text

            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    timer.restart();
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    timer.setDelay(0);
                }

                @Override
                public void keyReleased(KeyEvent e) {

                }
            });

            timer = new Timer(3000, null);
            timer.setRepeats(true);
            timer.setInitialDelay(0);
            //this happens every time timer fires, with delay of 3 sec. that can be skipped with key press
            timer.addActionListener(new ActionListener() {
                int n = 0; //current turn number

                @Override
                public void actionPerformed(ActionEvent e) {
                    for (JLabel l : allLabs) {
                        l.setForeground(Color.BLACK); //resets label colors
                    }
                    if (n > 0) {
                        //turns all labels non-bold
                        allLabs.get(n - 1).setFont(allLabs.get(n - 1).getFont().deriveFont(allLabs.get(n - 1).getFont().getStyle() & ~Font.BOLD));
                    }
                    timer.setDelay(3000);

                    if (n < room.getAllChars().size()) { // battle cycle is still going

                        if (room.getAllChars().get(n) instanceof PlayerCharacter) {

                            if (room.getAllChars().get(n).getSelectedItem() == null) { //uses skill if no item selected

                                usePlayerSkill((PlayerCharacter) room.getAllChars().get(n));

                            } else if (room.getAllChars().get(n).getSelectedSkill() == null) { // uses item if no skill selected

                                usePlayerItem((PlayerCharacter) room.getAllChars().get(n));

                            }

                            //DUE TO THE WAY THE GAME IS CODED, AN ITEM AND A SKILL CANNOT BE BOTH SELECTED.


                        } else if (room.getAllChars().get(n) instanceof Enemy) {


                            useEnemySkill((Enemy) room.getAllChars().get(n)); //enemies can't use items


                        }


                        n++; //increment turn counter
                        allLabs.get(n - 1).setFont(allLabs.get(n - 1).getFont().deriveFont(allLabs.get(n - 1).getFont().getStyle() | Font.BOLD));
                        //set current character's label to bold

                    } else {
                        timer.stop();
                        for (Char c : room.getAllChars()) {
                            c.turnEndRoutine();
                            refresh();
                        }
                        //resets inventory items' targets
                        for (Item i : room.getInventory()) {
                            i.setSetTargets(new ArrayList<>());
                        }

                        checkBattleOver();
                        battleLabel.setText("The battle rages on...");
                        //enables skill buttons if character can use that skill.
                        for (int i = 0; i < jButtons.size(); i++) {
                            if (room.getParty().get(0).getDead() || room.getParty().get(0).canUseSkill(room.getParty().get(0).getSkills().get(i))) {
                                jButtons.get(i).setEnabled(true);
                            }

                        }
                        for (int i = 0; i < tButtons.size(); i++) {
                            if (room.getParty().get(1).getDead() || room.getParty().get(1).canUseSkill(room.getParty().get(1).getSkills().get(i))) {
                                tButtons.get(i).setEnabled(true);
                            }

                        }
                        for (int i = 0; i < bButtons.size(); i++) {
                            if (room.getParty().get(2).getDead() || room.getParty().get(2).canUseSkill(room.getParty().get(2).getSkills().get(i))) {
                                bButtons.get(i).setEnabled(true);
                            }

                        }
                        for (int i = 0; i < oButtons.size(); i++) {
                            if (room.getParty().get(3).getDead() || room.getParty().get(3).canUseSkill(room.getParty().get(3).getSkills().get(i))) {
                                oButtons.get(i).setEnabled(true);
                            }

                        }
                        //item buttons always enabled
                        itemButton.setEnabled(true);
                        itemButton1.setEnabled(true);
                        itemButton2.setEnabled(true);
                        itemButton3.setEnabled(true);
                        //removes last key listener to avoid excess key listeners
                        frame.removeKeyListener(frame.getKeyListeners()[0]);
                    }

                    refresh();
                }
            });
            for (Char c : room.getAllChars()) {
                c.turnBeginRoutine();
                refresh();
            }

            //special case to account for FacilityDrone and FacilitySecurity's unique mechanics
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


        } else {
            refreshButtons();
        }

    }

    // sets all buttons of usable skills (and item buttons) to be enabled
    public void refreshButtons() {
        for (int i = 0; i < jButtons.size(); i++) {
            if (room.getParty().get(0).getDead() || room.getParty().get(0).canUseSkill(room.getParty().get(0).getSkills().get(i))) {
                jButtons.get(i).setEnabled(true);
            }

        }
        for (int i = 0; i < tButtons.size(); i++) {
            if (room.getParty().get(1).getDead() || room.getParty().get(1).canUseSkill(room.getParty().get(1).getSkills().get(i))) {
                tButtons.get(i).setEnabled(true);
            }

        }
        for (int i = 0; i < bButtons.size(); i++) {
            if (room.getParty().get(2).getDead() || room.getParty().get(2).canUseSkill(room.getParty().get(2).getSkills().get(i))) {
                bButtons.get(i).setEnabled(true);
            }

        }
        for (int i = 0; i < oButtons.size(); i++) {
            if (room.getParty().get(3).getDead() || room.getParty().get(3).canUseSkill(room.getParty().get(3).getSkills().get(i))) {
                oButtons.get(i).setEnabled(true);
            }

        }
        //item buttons always enabled
        itemButton.setEnabled(true);
        itemButton1.setEnabled(true);
        itemButton2.setEnabled(true);
        itemButton3.setEnabled(true);
    }


    private void usePlayerItem(PlayerCharacter p) {

        Item i = p.getSelectedItem();

        if (!room.getInventory().contains(i)) {
            //if two characters use the same item on their turn, item will only be used one time
            battleLabel.setText(p.getName() + " used " + i.getName() + "! But the item was gone...");
        } else {


            for (Char c : i.getSetTargets()) {
                if (!p.getDead() && !p.getCurrentStatus().equals(StatusEffect.NUMB)) {

                    if (i.getTarget().equals("all")) {
                        battleLabel.setText(p.getName() + " used " + i.getName() + "!");
                    } else if (i.getTarget().equals("one")) {
                        battleLabel.setText(p.getName() + " used " + i.getName() + " on " + c.getName() + "!");
                    }

                    i.takeEffect(c);
                    room.removeFromInventory(i);


                } else {
                    battleLabel.setText(p.getName() + " " + "couldn't move this turn...!");

                }
            }
        }
    }


    private void usePlayerSkill(PlayerCharacter p) {
        Skill s = p.getSelectedSkill();

        if (p.canUseSkill(s) && !p.getCurrentStatus().equals(StatusEffect.NUMB)) { //numb characters can't move.
            p.useAp(s.getApCost());
            s.setAtkMod(p.getAtkMod()); //sets skill's attack mod to user's attack mod
            for (Char c : s.getSetTargets()) {
                if (s.getTarget().equals("one")) { //update label to reflect skill used
                    battleLabel.setText(p.getName() + " " + s.getFlavor() + " " + s.getSetTargets().get(0).getName() + "!");
                } else {
                    battleLabel.setText(p.getName() + " " + s.getFlavor());
                }

                if (s instanceof AttackSkill) {
                    for (int i = 0; i < room.getEnemies().size(); i++) {
                        if (room.getEnemies().get(i).equals(c)) {
                            eLabs.get(i).setForeground(Color.RED); //sets target's label color to red
                        }
                    }
                } else if (s instanceof SupportSkill) {
                    for (int i = 0; i < room.getParty().size(); i++) {
                        if (room.getParty().get(i).equals(c)) {
                            pLabs.get(i).setForeground(Color.GREEN.darker().darker()); //sets target's label color to green
                        }
                    }
                }

                s.takeEffect(c);

                //apply relevant effects to user

                if (s instanceof AttackSkill) {
                    ((AttackSkill) s).takeUserEffect(p);
                } else if (s instanceof SupportSkill) {
                    ((SupportSkill) s).takeUserEffect(p);
                }

                //counter effect from RIPOSTE skill

                if (c.getCurrentStatus() == StatusEffect.RIPOSTE) {
                    p.takeDamage(s.getDamage());
                }

                //special case accounting for Jack's Shatter skill

                if (s.equals(room.getParty().get(0).getSkills().get(2)) && c.getCurrentStatus().equals(StatusEffect.NUMB)) {
                    c.takeDamage(25);
                }


                //special case accounting for Oscar's Devotion skill

                if (s.equals(room.getParty().get(3).getSkills().get(2))) {
                    if (!s.getSetTargets().get(0).equals(room.getParty().get(3))) {
                        p.takeDamage(500);
                    } else {
                        battleLabel.setText("Oscar fully heals himself!");

                    }

                }

                s.setAtkMod(1.00);
            }
        } else {
            battleLabel.setText(p.getName() + " " + "couldn't move this turn...!");
        }

    }

    private void useEnemySkill(Enemy e) { //pretty similar to usePlayerSkill method. see that method for details
        Skill s = e.getSelectedSkill();
        if (e.canUseSkill(s) && !e.getCurrentStatus().equals(StatusEffect.NUMB)) {
            s.setAtkMod(e.getAtkMod());
            for (Char c : s.getSetTargets()) {
                if (s.getTarget().equals("one")) {
                    battleLabel.setText(e.getName() + " " + s.getFlavor() + " " + s.getSetTargets().get(0).getName() + "!");
                } else {
                    battleLabel.setText(e.getName() + " " + s.getFlavor());
                }
                s.takeEffect(c);


                if (s instanceof AttackSkill) {

                    for (int i = 0; i < room.getParty().size(); i++) {
                        if (room.getParty().get(i).equals(c)) {
                            pLabs.get(i).setForeground(Color.RED);
                        }
                    }
                } else if (s instanceof SupportSkill) {
                    for (int i = 0; i < room.getEnemies().size(); i++) {
                        if (room.getEnemies().get(i).equals(c)) {
                            eLabs.get(i).setForeground(Color.GREEN.darker().darker());
                        }
                    }
                }

                if (s instanceof AttackSkill) {
                    ((AttackSkill) s).takeUserEffect(e);
                } else if (s instanceof SupportSkill) {
                    ((SupportSkill) s).takeUserEffect(e);
                }

                if (c.getCurrentStatus() == StatusEffect.RIPOSTE) {
                    e.takeDamage(s.getDamage());
                }
            }

            //Special case for Punk Doppel and Alt Punk Doppels' Transform skill
            if (e.getName().equals("Alt Punk Doppel") && s.getName().equals("Transform")) {
                e.setName("Alt Punk Doppel (" + s.getSetTargets().get(0).getName() + ")");
                if (s.getSetTargets().get(0).getName().equals("Jack")) {
                    e.setSkills(new ArrayList<>(Arrays.asList(
                            new AttackSkill("Icicle Throw", "launched an icicle at", 0, "one", 25,
                                    StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),

                            new AttackSkill("Blizzard", "formed a huge cloud of frost!", 75, "all",
                                    50, StatusEffect.NUMB, 1.0, 1.0, 2, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE)
                    )));
                } else if (s.getSetTargets().get(0).getName().equals("Trip")) {
                    e.setSkills(new ArrayList<>(Arrays.asList(
                            new AttackSkill("Slash", "slashed with a katana, hitting", 0, "one",
                                    20, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                            new SupportSkill("Bloody Mary", "procured a spicy drink for", 20, "one",
                                    50.0, 0, 0.25, 1.0, true, 0, 0, 0, StatusEffect.NONE,
                                    0, 0, 1.0, 1.0, StatusEffect.NONE)
                    )));

                } else if (s.getSetTargets().get(0).getName().equals("Boyle")) {

                    e.setSkills(new ArrayList<>(Arrays.asList(
                            new AttackSkill("Skate Kick", "did a roundhouse kick, hitting", 0, "one", 40
                                    , StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                            new AttackSkill("Torch", "launched flames from her flamethrower, scorching", 30, "one",
                                    50, StatusEffect.BURNED, 1.0, 1.0, 2, 0, 0, 1.0, 1.0,
                                    0, 0, StatusEffect.NONE)
                    )));

                } else if (s.getSetTargets().get(0).getName().equals("Oscar")) {
                    e.setSkills(new ArrayList<>(Arrays.asList(
                            new AttackSkill("Tendrilize", "attacked in all directions!", 0, "all",
                                    15, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                            new AttackSkill("Primal Fear", "induced fear in the enemies...", 60, "all",
                                    0, StatusEffect.AFRAID, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE)
                    )));
                }

            }

            if (e.getName().equals("Punk Doppel") && s.getName().equals("Transform")) {
                e.setName("Punk Doppel (" + s.getSetTargets().get(0).getName() + ")");
                if (s.getSetTargets().get(0).getName().equals("Jack")) {
                    e.setSkills(new ArrayList<>(Arrays.asList(
                            new AttackSkill("Shatter", "punched with a fist of ice, hitting", 40, "one",
                                    50, StatusEffect.NONE, 1.0, 1.0, 2, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),

                            new AttackSkill("Freeze!", "coated the enemy in frost, chilling", 30, "one", 30,
                                    StatusEffect.NUMB, 1.0, 1.0, 3, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE)
                    )));
                } else if (s.getSetTargets().get(0).getName().equals("Trip")) {
                    e.setSkills(new ArrayList<>(Arrays.asList(
                            new SupportSkill("Bloody Mary", "procured a spicy drink for", 20, "one",
                                    50.0, 0, 0.25, 1.0, true, 0, 0, 0, StatusEffect.NONE,
                                    0, 0, 1.0, 1.0, StatusEffect.NONE),
                            new SupportSkill("Numbing Tonic", "procured a numbing drink for", 20, "one",
                                    50.0, 0, 1.0, -0.15, true, 0, 0, 0, StatusEffect.NONE,
                                    0, 0, 1.0, 1.0, StatusEffect.NONE)
                    )));

                } else if (s.getSetTargets().get(0).getName().equals("Boyle")) {

                    e.setSkills(new ArrayList<>(Arrays.asList(
                            new AttackSkill("Immolate", "blanketed the area in flames!", 75, "all",
                                    75, StatusEffect.BURNED, 1.0, 1.0, 3, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                            new AttackSkill("Fumes", "sprayed toxic gas at", 20, "one",
                                    0, StatusEffect.POISONED, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE)
                    )));

                } else if (s.getSetTargets().get(0).getName().equals("Oscar")) {
                    e.setSkills(new ArrayList<>(Arrays.asList(
                            new AttackSkill("Tendrilize", "attacked in all directions!", 0, "all",
                                    15, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                            new AttackSkill("Bloodlust",
                                    "acted on his cravings, biting into", 30, "one",
                                    50, StatusEffect.NONE, 1.0, 1.0, 0, 25, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE)
                    )));
                }
            }

            //Special case for Squealing Rat's "Squeal" skill
            if (e.getName().equals("Squealing Rat") && s.getName().equals("Squeal")) {
                if (room.getEnemies().size() < 4) {
                    Random rand = new Random();
                    int chosen = rand.nextInt(2);
                    if (chosen == 0) {
                        Enemy temp = new CityBruiser();
                        temp.setSelectedSkill(new AttackSkill("n/a", "did nothing this turn", 0, "all",
                                0, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE));
                        room.getEnemies().add(temp);
                    } else if (chosen == 1) {
                        Enemy temp = new CityKnifer();
                        temp.setSelectedSkill(new AttackSkill("n/a", "did nothing this turn", 0, "all",
                                0, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE));
                        room.getEnemies().add(temp);
                    }
                    refresh();
                } else {
                    battleLabel.setText("Squealing Rat called for help... but nobody came.");
                }
            }


            s.setAtkMod(1.00);

        } else {
            battleLabel.setText(e.getName() + " " + "couldn't move this turn...!");
        }
    }

    //Enemy selects a skill to use at random
    public void selectEnemySkill(Enemy e) {
        List<Skill> eSkills = e.getSkills();
        int chooseNum = eSkills.size();
        Random rand = new Random();
        int chosenSkillNum = rand.nextInt(chooseNum);
        Skill chosenSkill = eSkills.get(chosenSkillNum);
        e.setSelectedSkill(chosenSkill);
        chosenSkill.setSetTargets(new ArrayList<>());
        chooseEnemySkillTarget(e, chosenSkill);
    }

    //If skill affects all, all party is targeted.
    //If skill affects one, a party member is targeted at random.

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

    //returns true if all party members have either an item or skill selected

    public Boolean isReadyToTakeAction() {
        for (PlayerCharacter p : room.getParty()) {

            if (p.getSelectedSkill() == null && p.getSelectedItem() == null) {
                return false;
            }

        }
        return true;
    }

    //clears + remakes turn order map, clears + remakes sorted labels list, updates all labels in panel, finally
    //repacks JFrame

    public void refresh() {
        room.createAllChars();
        initializeTurnOrder();
        initializeAllLabs();
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

    //things the program does when it detects that the battle is over

    public void checkBattleOver() {
        lootTimer = new Timer(3000, null);
        lootTimer.setRepeats(true);
        lootTimer.setInitialDelay(0);

        //Every 3 seconds, while timer is started
        lootTimer.addActionListener(new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count == 0) { //first screen: "You win!"

                    battleLabel.setText("You win!");

                    count++;
                } else if (count == 1) { //second and last screen: loot receiving screen

                    if (loot != null) {
                        battleLabel.setText("You got " + loot.getName() + ".");
                        addLootToInventory(); //loot is actually added here
                    } else {
                        battleLabel.setText("There was no item in this room...");
                    }

                    count++;

                } else {
                    lootTimer.stop();
                    // marks appropriate boss as killed in this battle's level, if applicable
                    if (room.getWhichBoss() == 1) {
                        level.kill1Boss();
                    } else if (room.getWhichBoss() == 2) {
                        level.kill2Boss();
                    } else if (room.getWhichBoss() == 3) {
                        level.kill3Boss();
                    }

                    if (level.getComplete()) {
                        frame.dispose();
                        new LevelEndStoryUI(level);
                    } else {
                        //sets room at row, col in level's room grid to have no battle
                        level.getRooms()[row][col] = new NewRoom(room.getEnemies(), room.getParty(), room.getInventory(),
                                null, false, false, 0, room.getEvent());
                        frame.dispose();
                        //resets all party attack, defense, speed modifiers
                        for (int k = 0; k < room.getParty().size(); k++) {
                            room.getParty().get(k).setAtkMod(1.0);
                            room.getParty().get(k).setDefMod(1.0);
                            if (k == 0) {
                                room.getParty().get(k).setSpeed(5);
                            } else if (k == 1) {
                                room.getParty().get(k).setSpeed(3);
                            } else if (k == 2) {
                                room.getParty().get(k).setSpeed(9);
                            } else if (k == 4) {
                                room.getParty().get(k).setSpeed(8);
                            }

                        }

                        //launches new Room UI based on "completed" room (now with no battle)
                        new NewRoomUI(level, level.getRooms()[row][col], row, col);
                    }

                }
            }
        });

        if (room.isBattleWon()) {
            lootTimer.start(); //starts timer
        } else if (room.isBattleLost()) {
            frame.dispose(); //timer is not used at all in this case...
            new GameOverUI();
        }
    }

    //where loot is actually added to room inventory

    public void addLootToInventory() {
        if (loot == null) {
            battleLabel.setText("There was no loot in this room.");
            refresh();
        } else {
            if (room.getInventory().size() < 10) { //we can pick up loot
                System.out.println("You got " + loot.getName() + "!");
                battleLabel.setText("You got " + loot.getName() + "!");
                room.getInventory().add(loot);
            } else {  //there is loot ,but we don't have room to pick it up


                battleLabel.setText("You got " + loot.getName() + "! But your inventory is full! You didn't take the item.");
            }
        }
    }

    //plays battle music - disabled for now
//    public void playSound() {
//        try {
//            if (room.getWhichBoss() != 0) {
//
//            } else {
//                if (level.getName().equals("The Wasteland")) {
//                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("funky.wav").getAbsoluteFile());
//                    Clip clip = AudioSystem.getClip();
//                    clip.open(audioInputStream);
//                    clip.start();
//                    clip.loop(Clip.LOOP_CONTINUOUSLY);
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println("Error with playing sound.");
//            ex.printStackTrace();
//        }
//    }

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
        bossLabel = new JLabel();
        Font bossLabelFont = this.$$$getFont$$$("Courier New", -1, -1, bossLabel.getFont());
        if (bossLabelFont != null) bossLabel.setFont(bossLabelFont);
        bossLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        battlePanel.add(bossLabel, gbc);
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
