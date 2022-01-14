package ui;

import model.AttackSkill;
import model.PlayerCharacter;
import model.StatusEffect;
import model.SupportSkill;
import model.enemies.Facility.*;
import model.enemies.Wasteland.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

//Class representing the screen where the user chooses which characters' profile pages they wish to view.

public class SelectCharacterMenuArea {
    private JButton wastelandButton;
    private JPanel selectAreaPanel;
    private JButton partyButton;
    private JButton backButton;
    private JButton facilityButton;

    public SelectCharacterMenuArea() {
        JFrame frame = new JFrame("Character Profiles");
        frame.setContentPane(selectAreaPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        partyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                //initializes similar characters to the ones in-game to display as a string.
                new CharacterMenu(Arrays.asList(new PlayerCharacter("Jack", 150, 100, new ArrayList<>(Arrays.asList(
                        new AttackSkill("Icicle Throw", "launched an icicle at", 0, "one", 25,
                                StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),

                        new AttackSkill("Blizzard", "formed a huge cloud of frost!", 75, "all",
                                50, StatusEffect.NUMB, 1.0, 1.0, 2, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Shatter", "punched with a fist of ice, hitting", 40, "one",
                                50, StatusEffect.NONE, 1.0, 1.0, 2, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),

                        new AttackSkill("Freeze!", "coated the enemy in frost, chilling", 30, "one", 30,
                                StatusEffect.NUMB, 1.0, 1.0, 3, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE)


                )), 5,
                        "A dragon-like creature who can use his frosty breath as an offensive tactic.", new ArrayList<>(),
                        new ArrayList<>()),

                new PlayerCharacter("Trip", 200, 130, new ArrayList<>(Arrays.asList(

                        new AttackSkill("Slash", "slashed with a katana, hitting", 0, "one",
                                20, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new SupportSkill("Bloody Mary", "procured a spicy drink for", 20, "one",
                                50.0, 0, 0.25, 1.0, false, 0, 0, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.NONE),
                        new SupportSkill("Numbing Tonic", "procured a numbing drink for", 20, "one",
                                50.0, 0, 1.0, -0.15, false, 0, 0, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.NONE),
                        new SupportSkill("Toast", "and the party drank together!", 40, "all",
                                70.0, 0, 1.0, 1.0, true, 0, 0, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.NONE)


                )), 3,
                        "A former bartender who uses alcoholic concoctions to support the party.", new ArrayList<>(),
                        new ArrayList<>()),

                new PlayerCharacter("Boyle", 100, 150, new ArrayList<>(Arrays.asList(

                        new AttackSkill("Skate Kick", "did a roundhouse kick, hitting", 0, "one", 40
                                , StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Torch", "launched flames from her flamethrower, scorching", 30, "one",
                                50, StatusEffect.BURNED, 1.0, 1.0, 2, 0, 0, 1.0, 1.0,
                                0, 0, StatusEffect.NONE),
                        new AttackSkill("Immolate", "blanketed the area in flames!", 75, "all",
                                75, StatusEffect.BURNED, 1.0, 1.0, 3, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Fumes", "sprayed toxic gas at", 20, "one",
                                0, StatusEffect.POISONED, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE)


                )), 9,
                        "A rollerblade-riding, flamethrower-wielding pyromaniac who uses her skills to burn whoever stands in her way.",
                        new ArrayList<>(),
                        new ArrayList<>()),

                new PlayerCharacter("Oscar", 110, 100, new ArrayList<>(Arrays.asList(

                        new AttackSkill("Tendrilize", "attacked in all directions!", 0, "all",
                                15, StatusEffect.NONE, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new AttackSkill("Primal Fear", "induced fear in the enemies...", 60, "all",
                                0, StatusEffect.AFRAID, 1.0, 1.0, 1, 0, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE),
                        new SupportSkill("Devotion", "gave his life for", 100, "one",
                                300.0, 200, 2.00, 0.0, false, 0, 3, 0, StatusEffect.NONE,
                                0, 0, 1.0, 1.0, StatusEffect.NONE),
                        new AttackSkill("Bloodlust",
                                "acted on his cravings, biting into", 30, "one",
                                50, StatusEffect.NONE, 1.0, 1.0, 0, 25, 0, 1.0, 1.0, 0, 0, StatusEffect.NONE)


                )), 8,
                        "A half-canine, half-eldritch-abomination hybrid. Despite his appearances, he has a heart of gold. " +
                                "He uses his skills to inflict status on enemies, and attack them in groups.",
                        new ArrayList<>(),
                        new ArrayList<>())
));
            }
        });
        //to view the wasteland level's enemy profiles
        wastelandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new CharacterMenu(Arrays.asList(new WastelandMelee(), new WastelandAssassin(), new WastelandSupport(),
                        new WastelandTank(), new WastelandFrankie(), new WastelandSentry(), new WastelandRev()));
            }
        });
        //to view the facility level's enemy profiles
        facilityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new CharacterMenu(Arrays.asList(new FacilityMelee(), new FacilityDebuffer(), new FacilityBomber(),
                        new FacilityBulwark(), new FacilityMedic(), new FacilityGuard(), new FacilityDrone(),
                        new FacilitySecurity(), new FacilityTank()));
            }
        });
        //back to the extras menu
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component cButton = (Component) e.getSource();
                SwingUtilities.getWindowAncestor(cButton).dispose();
                new ExtrasMenu();
            }
        });
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
        selectAreaPanel = new JPanel();
        selectAreaPanel.setLayout(new GridBagLayout());
        selectAreaPanel.setBackground(new Color(-4988956));
        wastelandButton = new JButton();
        wastelandButton.setEnabled(true);
        Font wastelandButtonFont = this.$$$getFont$$$("Courier New", -1, -1, wastelandButton.getFont());
        if (wastelandButtonFont != null) wastelandButton.setFont(wastelandButtonFont);
        wastelandButton.setText("Wasteland");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        selectAreaPanel.add(wastelandButton, gbc);
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Courier New", -1, 18, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Select a category:");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        selectAreaPanel.add(label1, gbc);
        partyButton = new JButton();
        Font partyButtonFont = this.$$$getFont$$$("Courier New", -1, -1, partyButton.getFont());
        if (partyButtonFont != null) partyButton.setFont(partyButtonFont);
        partyButton.setText("Party");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        selectAreaPanel.add(partyButton, gbc);
        backButton = new JButton();
        Font backButtonFont = this.$$$getFont$$$("Courier New", -1, -1, backButton.getFont());
        if (backButtonFont != null) backButton.setFont(backButtonFont);
        backButton.setText("Back");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        selectAreaPanel.add(backButton, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        selectAreaPanel.add(spacer1, gbc);
        facilityButton = new JButton();
        Font facilityButtonFont = this.$$$getFont$$$("Courier New", -1, -1, facilityButton.getFont());
        if (facilityButtonFont != null) facilityButton.setFont(facilityButtonFont);
        facilityButton.setText("Facility");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        selectAreaPanel.add(facilityButton, gbc);
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
        return selectAreaPanel;
    }

}
