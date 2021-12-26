package ui;

import model.*;
import model.levelStuff.*;

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
    private List<NewLevel> levels;
    private NewLevel wasteland;
    private NewLevel facility;
    private NewFacilityTool flt;
    private NewWastelandTool wlt;

    private JPanel lselectpanel;
    private JButton wastelandButton;
    private JButton facilityButton;
    private JLabel passwordLabel;
    private JLabel mainLabel;

    public LevelSelectUI(Boolean l1c, Boolean l2c, Boolean l3c) {

        party = new ArrayList<>();
        setUpParty();
        inventory = new ArrayList<>();
        if (l1c && !l2c) {
            passwordLabel.setText("PASSWORD: ab42pgf9");
        } else if (l2c && !l3c) {
            passwordLabel.setText("PASSWORD: b0wwg5gn");
            mainLabel.setText("You've completed all levels so far! To be continued...");
        }

        if (!l1c) {
            facilityButton.setEnabled(false);
        }
        if (l1c) {
            wastelandButton.setEnabled(false);
        }
        if (l2c) {
            wastelandButton.setEnabled(false);
        }

        levels = new ArrayList<>();
        setUpLevels();
        JFrame frame = new JFrame("LevelSelectUI");
        frame.setContentPane(lselectpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        wastelandButton.setToolTipText("A level good for beginners. Smaller size and no room events.");
        facilityButton.setToolTipText("Here, enemies will focus on debuffing your team and inflicting status ailments. Room events" +
                " have the potential to help or hinder your team, too.");
        wastelandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new LevelBeginStoryUI(wasteland, wasteland.getRooms()[0][0]);
            }
        });
        facilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new LevelBeginStoryUI(facility, facility.getRooms()[0][0]);
            }
        });
    }

    public void setUpParty() {
        jack = new PlayerCharacter("Jack", 150, 100, new ArrayList<>(Arrays.asList(
                new AttackSkill("Icicle Throw", "launched an icicle at", 0, "one", 25,
                        StatusEffect.NONE, 1.0, 1.0, 1),

                new AttackSkill("Blizzard", "formed a huge cloud of frost!", 75, "all",
                        50, StatusEffect.NUMB, 1.0, 1.0, 2),
                new AttackSkill("Shatter", "punched with a fist of ice, hitting", 40, "one",
                        50, StatusEffect.NONE, 1.0, 1.0, 2),

                new AttackSkill("Freeze!", "coated the enemy in frost, chilling", 30, "one", 30,
                        StatusEffect.NUMB, 1.0, 1.0, 3)


        )), 5,
                "A dragon-like creature who can use his frosty breath as an offensive tactic.", new ArrayList<>(),
                new ArrayList<>());

        trip = new PlayerCharacter("Trip", 200, 130, new ArrayList<>(Arrays.asList(

                new AttackSkill("Slash", "slashed with a katana, hitting", 0, "one",
                        20, StatusEffect.NONE, 1.0, 1.0, 1),
                new SupportSkill("Bloody Mary", "procured a spicy drink for", 20, "one",
                        50.0, 0, 0.25, 1.0, false),
                new SupportSkill("Numbing Tonic", "procured a numbing drink for", 20, "one",
                        50.0, 0, 1.0, -0.15, false),
                new SupportSkill("Toast", "and the party drank together!", 40, "all",
                        70.0, 0, 1.0, 1.0, true)


        )), 3,
                "A former bartender who uses alcoholic concoctions to support the party.", new ArrayList<>(),
                new ArrayList<>());

        boyle = new PlayerCharacter("Boyle", 100, 150, new ArrayList<>(Arrays.asList(

                new AttackSkill("Skate Kick", "did a roundhouse kick, hitting", 0, "one", 40
                        , StatusEffect.NONE, 1.0, 1.0, 1),
                new AttackSkill("Torch", "launched flames from her flamethrower, scorching", 30, "one",
                        50, StatusEffect.BURNED, 1.0, 1.0, 2),
                new AttackSkill("Immolate", "blanketed the area in flames!", 75, "all",
                        75, StatusEffect.BURNED, 1.0, 1.0, 3),
                new AttackSkill("Fumes", "sprayed toxic gas at", 20, "one",
                        0, StatusEffect.POISONED, 1.0, 1.0, 1)


        )), 9,
                "A rollerblade-riding, flamethrower-wielding pyromaniac who uses her skills to burn whoever stands in her way.",
                new ArrayList<>(),
                new ArrayList<>());

        oscar = new PlayerCharacter("Oscar", 110, 100, new ArrayList<>(Arrays.asList(

                new AttackSkill("Tendrilize", "attacked in all directions!", 0, "all",
                        15, StatusEffect.NONE, 1.0, 1.0, 1),
                new AttackSkill("Primal Fear", "induced fear in the enemies...", 60, "all",
                        0, StatusEffect.AFRAID, 1.0, 1.0, 1),
                new SupportSkill("Devotion", "gave his life for", 100, "one",
                        300.0, 200, 3.00, 0.0, false),
                new AttackSkill("Bloodlust",
                        "acted on his cravings, biting into", 30, "one",
                        50, StatusEffect.NONE, 1.0, 1.0, 0)


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
        wlt = new NewWastelandTool(inventory, party);
        wasteland = new NewLevel("The Wasteland", wlt.getWastelandRooms(), new Color(-2899838));
        wasteland.setIntroLabelText("<html><body><p style='width:200px;'>" + "Jack Munroe and a couple of acquaintances have decided to" +
                " venture out into the Scaravaje Wastelands, the former site of a military base, to investigate a strange phenomenon reported on the news. However, the locals" +
                " don't take very kindly to those intruding on their turf. Beat all 3 bosses to win!" + "</p></body></html>");
        wasteland.setEndLabelText("<html><body><p style='width:200px;'>" + "Unfortunately, nothing of substance relating to" +
                " the phenomenon was discovered, and on top of that, Jack and co. are accused of tampering with military" +
                " secrets. They are taken into custody and thrown into an underground prison facility..." + "</p></body></html>");
        levels.add(wasteland);

        flt = new NewFacilityTool(inventory, party);
        facility = new NewLevel("The Facility", flt.getFacilityRooms(), Color.GRAY);
        facility.setIntroLabelText("<html><body><p style='width:200px;'>" + "After being wrongfully imprisoned for the events in " +
                "the Scaravaje Wastelands, Jack and co. decide to attempt a prison break. They will need to use all of their strength" +
                " to stand a chance at escaping. Beat all 3 bosses to win!" + "</p></body></html>");
        facility.setEndLabelText("<html><body><p style='width:200px;'>" + "Fortunately, Jack and co. are able to avoid too much trouble" +
                " and are able to prove to the head warden of the prison that their imprisonment was a mistake. With no clues on " +
                "the strange phenomenon, they decide to head to the big city in search of clues..." + "</p></body></html>");
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
        mainLabel = new JLabel();
        Font mainLabelFont = this.$$$getFont$$$("Courier New", -1, 16, mainLabel.getFont());
        if (mainLabelFont != null) mainLabel.setFont(mainLabelFont);
        mainLabel.setText("Select level.");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        lselectpanel.add(mainLabel, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        lselectpanel.add(spacer1, gbc);
        wastelandButton = new JButton();
        wastelandButton.setEnabled(true);
        Font wastelandButtonFont = this.$$$getFont$$$("Courier New", -1, -1, wastelandButton.getFont());
        if (wastelandButtonFont != null) wastelandButton.setFont(wastelandButtonFont);
        wastelandButton.setText("Level 1: Wasteland");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        lselectpanel.add(wastelandButton, gbc);
        facilityButton = new JButton();
        Font facilityButtonFont = this.$$$getFont$$$("Courier New", -1, -1, facilityButton.getFont());
        if (facilityButtonFont != null) facilityButton.setFont(facilityButtonFont);
        facilityButton.setText("Level 2: Facility");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        lselectpanel.add(facilityButton, gbc);
        passwordLabel = new JLabel();
        Font passwordLabelFont = this.$$$getFont$$$("Courier New", -1, -1, passwordLabel.getFont());
        if (passwordLabelFont != null) passwordLabel.setFont(passwordLabelFont);
        passwordLabel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        lselectpanel.add(passwordLabel, gbc);
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


