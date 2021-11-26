package ui;

import model.*;
import model.levelStuff.FacilityLevelTool;
import model.levelStuff.Level;
import model.levelStuff.WastelandLevelTool;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LevelSelectUI {
    private List<Item> inventory;
    private PlayerCharacter jack;
    private PlayerCharacter trip;
    private PlayerCharacter boyle;
    private PlayerCharacter oscar;
    private List<PlayerCharacter> party;
    private List<Level> levels;
    private Level wasteland;
    private Level facility;
    private FacilityLevelTool flt;
    private WastelandLevelTool wlt;

    private JPanel lselectpanel;
    private JButton wastelandButton;
    private JButton facilityButton;

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
        wastelandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new Battle(wasteland.getRooms(), wasteland.getRooms().getLoot(), new Color(-2899838));
            }
        });
        facilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new Battle(facility.getRooms(), facility.getRooms().getLoot(), Color.GRAY);
            }
        });
    }

    public void setUpParty() {
        jack = new PlayerCharacter("Jack", 150, 100, new ArrayList<>(Arrays.asList(
                new AttackSkill("Icicle Throw", "threw an icicle at", 0, "one", 20,
                        StatusEffect.NONE, 1.0, 1.0, 1),

                new AttackSkill("Blizzard", "formed a huge cloud of frost!", 75, "all",
                        50, StatusEffect.NUMB, 1.0, 1.0, 2),

                new SupportSkill("Ice Shield", "formed a shield of ice, protecting", 25, "one",
                        0.0, 0, 1.0, 0.5, false),
                new AttackSkill("Freeze!", "coated the enemy in frost, chilling", 40, "one", 60,
                        StatusEffect.NUMB, 1.0, 1.0, 3)


        )), 5,
                "A dragon-like creature who can use his frosty breath as an offensive tactic.", new ArrayList<>(),
                new ArrayList<>());

        trip = new PlayerCharacter("Trip", 200, 130, new ArrayList<>(Arrays.asList(

                new AttackSkill("Slash", "slashed with a katana, hitting", 0, "one",
                        20, StatusEffect.NONE, 1.0, 1.0, 1),
                new SupportSkill("Bloody Mary", "procured a spicy drink for", 20, "one",
                        50.0, 0, 1.50, 1.0, false),
                new SupportSkill("Numbing Tonic", "procured a numbing drink for", 20, "one",
                        50.0, 0, 1.0, 0.5, false),
                new SupportSkill("Toast", "and the party drank together!", 40, "all",
                        70.0, 0, 1.0, 1.0, true)


        )), 3,
                "A former bartender who uses alcoholic concoctions to support the party.", new ArrayList<>(),
                new ArrayList<>());

        boyle = new PlayerCharacter("Boyle", 100, 150, new ArrayList<>(Arrays.asList(

                new AttackSkill("Skate Kick", "did a roundhouse kick, hitting", 0, "one",
                        30, StatusEffect.NONE, 1.0, 1.0, 1),
                new AttackSkill("Torch", "launched flames from her flamethrower, scorching", 30, "one",
                        30, StatusEffect.BURNED, 1.0, 1.0, 2),
                new AttackSkill("Immolate", "blanketed the area in flames!", 75, "all",
                        50, StatusEffect.BURNED, 1.0, 1.0, 3),
                new AttackSkill("Fumes", "sprayed toxic gas.", 50, "all",
                        0, StatusEffect.POISONED, 1.0, 1.0, 1)


        )), 9,
                "A rollerblade-riding, flamethrower-wielding pyromaniac who uses her skills to burn whoever stands in her way.",
                new ArrayList<>(),
                new ArrayList<>());

        oscar = new PlayerCharacter("Oscar", 110, 100, new ArrayList<>(Arrays.asList(

                new AttackSkill("Tendrilize", "attacked in all directions!", 0, "all",
                        10, StatusEffect.NONE, 1.0, 1.0, 1),
                new AttackSkill("Primal Fear", "induced fear in the enemies...", 60, "all",
                        0, StatusEffect.AFRAID, 1.0, 1.0, 1),
                new SupportSkill("Devotion", "gave his life for", 100, "one",
                        300.0, 200, 1.50, 0.50, false),
                new AttackSkill("Bloodlust",
                        "acted on his cravings, biting into", 30, "one",
                        25.0, StatusEffect.NONE, 1.0, 1.0, 0)


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
        flt = new FacilityLevelTool(inventory, party);
        facility = new Level("The Facility", flt.getFacilityRooms());
        levels.add(facility);
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
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Courier New", -1, 16, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Select level.");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        lselectpanel.add(label1, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        lselectpanel.add(spacer1, gbc);
        wastelandButton = new JButton();
        wastelandButton.setEnabled(true);
        Font wastelandButtonFont = this.$$$getFont$$$("Courier New", -1, -1, wastelandButton.getFont());
        if (wastelandButtonFont != null) wastelandButton.setFont(wastelandButtonFont);
        wastelandButton.setText("Wasteland");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        lselectpanel.add(wastelandButton, gbc);
        facilityButton = new JButton();
        Font facilityButtonFont = this.$$$getFont$$$("Courier New", -1, -1, facilityButton.getFont());
        if (facilityButtonFont != null) facilityButton.setFont(facilityButtonFont);
        facilityButton.setText("Facility");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        lselectpanel.add(facilityButton, gbc);
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
        return lselectpanel;
    }

}


