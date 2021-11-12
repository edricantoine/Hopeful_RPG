package ui;

import model.*;
import model.levelStuff.Level;
import model.levelStuff.WastelandLevelTool;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelSelectUI {
    private List<Item> inventory;
    private PlayerCharacter jack;
    private PlayerCharacter trip;
    private PlayerCharacter boyle;
    private PlayerCharacter oscar;
    private List<PlayerCharacter> party;
    private List<Level> levels;
    private Level wasteland;
    private WastelandLevelTool wlt;

    private JPanel lselectpanel;
    private JLabel testlabel;

    public LevelSelectUI() {

        party = new ArrayList<>();
        setUpParty();
        inventory = new ArrayList<>();
        levels = new ArrayList<>();
        setUpLevels();
        JFrame frame = new JFrame("LevelSelectUI");
        frame.setContentPane(lselectpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setUpParty() {
        jack = new PlayerCharacter("Jack", 150, 100, new ArrayList<>(Arrays.asList(

                new AttackSkill("Blizzard", " formed a huge cloud of frost!", 75, "all",
                        50, StatusEffect.FROZEN, 1.0, 1.0, 2),
                new AttackSkill("Icicle Throw", " threw an icicle.", 0, "one", 30,
                        StatusEffect.NONE, 1.0, 1.0, 1),
                new SupportSkill("Ice Shield", " formed a shield of ice.", 25, "one",
                        0.0, 0, 1.0, 0.5, false),
                new AttackSkill("Freeze!", " coated the enemy in frost", 40, "one", 60,
                        StatusEffect.FROZEN, 1.0, 1.0, 3)


        )), 5,
                "A dragon-like creature who can use his frosty breath as an offensive tactic.", new ArrayList<>(),
                new ArrayList<>());

        trip = new PlayerCharacter("Trip", 200, 130, new ArrayList<>(Arrays.asList(

                new AttackSkill("Slash", " slashed with a katana.", 0, "one",
                        25, StatusEffect.NONE, 1.0, 1.0, 1),
                new SupportSkill("Bloody Mary", " procured a spicy drink!", 25, "one",
                        50.0, 0, 1.50, 1.0, false),
                new SupportSkill("Numbing Tonic", " procured a numbing drink!", 25, "one",
                        50.0, 0, 1.0, 0.5, false),
                new SupportSkill("Toast", " and the party drank together!", 60, "all",
                        60.0, 0, 1.0, 1.0, true)


        )), 3,
                "A dragon-like creature who can use his frosty breath as an offensive tactic.", new ArrayList<>(),
                new ArrayList<>());

        boyle = new PlayerCharacter("Boyle", 100, 150, new ArrayList<>(Arrays.asList(

                new AttackSkill("Skate Kick", " did a roundhouse kick!", 0, "one",
                        40, StatusEffect.NONE, 1.0, 1.0, 1),
                new AttackSkill("Torch", " launched flames from her flamethrower", 30, "one",
                        30, StatusEffect.BURNED, 1.0, 1.0, 2),
                new AttackSkill("Immolate", " blanketed the area in flames!", 75, "all",
                        50, StatusEffect.BURNED, 1.0, 1.0, 3),
                new AttackSkill("Fumes", " sprayed toxic gas", 50, "all",
                        0, StatusEffect.POISONED, 1.0, 1.0, 1)


        )), 9,
                "A rollerblade-riding, flamethrower-wielding pyromaniac who uses her skills to burn whoever stands in her way.",
                new ArrayList<>(),
                new ArrayList<>());

        oscar = new PlayerCharacter("Oscar", 110, 100, new ArrayList<>(Arrays.asList(

                new AttackSkill("Tendrilize", " attacked in all directions!", 0, "all",
                        20, StatusEffect.NONE, 1.0, 1.0, 1),
                new AttackSkill("Primal Fear", " induced fear in the enemies...", 60, "one",
                        0, StatusEffect.AFRAID, 1.0, 1.0, 1),
                new SupportSkill("Dark Cure", " uttered incomprehensible healing words", 10, "one",
                        0.0, 0, 1.0, 1.0, true),
                new AttackSkill("Incomprehensible Form",
                        " took on an incomprehensible appearance, making the enemies sick...!", 50, "all",
                        50, StatusEffect.POISONED, 1.0, 1.0, 5)




        )), 8,
                "A half-canine, half-eldritch-abomination hybrid. Despite his appearances, he has a heart of gold. " +
                        "He uses his skills to inflict status on enemies, and attack them in groups.",
                new ArrayList<>(),
                new ArrayList<>());

        party.add(jack);
        party.add(trip);
        party.add(boyle);
        party.add(oscar);
    }

    public void setUpLevels() {
        wlt = new WastelandLevelTool(inventory, party);
        wasteland = new Level("The Wasteland", wlt.getWastelandRooms());
        levels.add(wasteland);
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
        lselectpanel = new JPanel();
        lselectpanel.setLayout(new GridBagLayout());
        lselectpanel.setBackground(new Color(-4988956));
        lselectpanel.setEnabled(true);
        testlabel = new JLabel();
        testlabel.setText("TEST");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        lselectpanel.add(testlabel, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return lselectpanel;
    }

}

