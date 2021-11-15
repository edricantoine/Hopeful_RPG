package ui;

import model.AttackSkill;
import model.PlayerCharacter;
import model.Skill;
import model.SupportSkill;
import model.enemies.Enemy;
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

public class SelectTargetTool {
    private List<JButton> buttons;
    private JButton e4b;
    private JButton e1b;
    private JButton e2b;
    private JButton e3b;
    private JPanel SelectTargetPanel;
    private Room room;
    private Skill skill;
    private PlayerCharacter user;
    private Battle bat;

    public SelectTargetTool(Room r, Skill s, PlayerCharacter u, Battle bat) {
        buttons = new ArrayList<>();
        room = r;
        skill = s;
        user = u;
        this.bat = bat;
        buttons.add(e1b);
        buttons.add(e2b);
        buttons.add(e3b);
        buttons.add(e4b);
        inititalizeButtons();
        JFrame frame = new JFrame("Select Target");
        frame.setContentPane(SelectTargetPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void inititalizeButtons() {
        if (skill.getTarget().equals("one")) {

            if (skill instanceof AttackSkill) {

                for (int i = 0; i < Math.min(buttons.size(), room.getEnemies().size()); i++) {
                    buttons.get(i).setText(room.getEnemies().get(i).getName());
                }

            } else if (skill instanceof SupportSkill) {
                for (int i = 0; i < Math.min(buttons.size(), room.getParty().size()); i++) {
                    buttons.get(i).setText(room.getParty().get(i).getName());
                }
            }

        } else {

            buttons.get(0).setText("All");
            for (int i = 1; i < buttons.size(); i++) {
                buttons.get(i).setText("N/A");
            }

        }

        initializeListeners();
    }

    public void initializeListeners() {
        e1b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String t = e1b.getText();
                if (skill instanceof AttackSkill) {

                    if (t.equals("N/A")) {
                        Toolkit.getDefaultToolkit().beep();
                    } else if (t.equals("All")) {
                        for (Enemy n : room.getEnemies()) {
                            skill.addToSetTargets(n);
                        }
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    } else {
                        skill.addToSetTargets(room.getEnemies().get(0));
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    }

                } else if (skill instanceof SupportSkill) {
                    if (t.equals("N/A")) {
                        Toolkit.getDefaultToolkit().beep();
                    } else if (t.equals("All")) {
                        for (PlayerCharacter n : room.getParty()) {
                            skill.addToSetTargets(n);
                        }
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    } else {
                        skill.addToSetTargets(room.getParty().get(0));
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    }
                }
            }
        });

        e2b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String t = e2b.getText();
                if (skill instanceof AttackSkill) {

                    if (t.equals("N/A")) {
                        Toolkit.getDefaultToolkit().beep();
                    } else if (t.equals("All")) {
                        for (Enemy n : room.getEnemies()) {
                            skill.addToSetTargets(n);
                        }
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    } else {
                        skill.addToSetTargets(room.getEnemies().get(1));
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    }

                } else if (skill instanceof SupportSkill) {
                    if (t.equals("N/A")) {
                        Toolkit.getDefaultToolkit().beep();
                    } else if (t.equals("All")) {
                        for (PlayerCharacter n : room.getParty()) {
                            skill.addToSetTargets(n);
                        }
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    } else {
                        skill.addToSetTargets(room.getParty().get(1));
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    }
                }

            }
        });
        e3b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String t = e3b.getText();
                if (skill instanceof AttackSkill) {

                    if (t.equals("N/A")) {
                        Toolkit.getDefaultToolkit().beep();
                    } else if (t.equals("All")) {
                        for (Enemy n : room.getEnemies()) {
                            skill.addToSetTargets(n);
                        }
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    } else {
                        skill.addToSetTargets(room.getEnemies().get(2));
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    }

                } else if (skill instanceof SupportSkill) {
                    if (t.equals("N/A")) {
                        Toolkit.getDefaultToolkit().beep();
                    } else if (t.equals("All")) {
                        for (PlayerCharacter n : room.getParty()) {
                            skill.addToSetTargets(n);
                        }
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    } else {
                        skill.addToSetTargets(room.getParty().get(2));
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    }
                }
            }
        });
        e4b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String t = e4b.getText();
                if (skill instanceof AttackSkill) {

                    if (t.equals("N/A")) {
                        Toolkit.getDefaultToolkit().beep();
                    } else if (t.equals("All")) {
                        for (Enemy n : room.getEnemies()) {
                            skill.addToSetTargets(n);
                        }
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    } else {
                        skill.addToSetTargets(room.getEnemies().get(3));
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    }

                } else if (skill instanceof SupportSkill) {
                    if (t.equals("N/A")) {
                        Toolkit.getDefaultToolkit().beep();
                    } else if (t.equals("All")) {
                        for (PlayerCharacter n : room.getParty()) {
                            skill.addToSetTargets(n);
                        }
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    } else {
                        skill.addToSetTargets(room.getParty().get(3));
                        user.setSelectedSkill(skill);
                        bat.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    }
                }
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
        SelectTargetPanel = new JPanel();
        SelectTargetPanel.setLayout(new GridBagLayout());
        SelectTargetPanel.setBackground(new Color(-4988956));
        e1b = new JButton();
        Font e1bFont = this.$$$getFont$$$("Courier New", -1, -1, e1b.getFont());
        if (e1bFont != null) e1b.setFont(e1bFont);
        e1b.setText("N/A");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectTargetPanel.add(e1b, gbc);
        e3b = new JButton();
        Font e3bFont = this.$$$getFont$$$("Courier New", -1, -1, e3b.getFont());
        if (e3bFont != null) e3b.setFont(e3bFont);
        e3b.setText("N/A");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectTargetPanel.add(e3b, gbc);
        e4b = new JButton();
        Font e4bFont = this.$$$getFont$$$("Courier New", -1, -1, e4b.getFont());
        if (e4bFont != null) e4b.setFont(e4bFont);
        e4b.setText("N/A");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 4;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectTargetPanel.add(e4b, gbc);
        e2b = new JButton();
        Font e2bFont = this.$$$getFont$$$("Courier New", -1, -1, e2b.getFont());
        if (e2bFont != null) e2b.setFont(e2bFont);
        e2b.setText("N/A");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectTargetPanel.add(e2b, gbc);
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
        return SelectTargetPanel;
    }

}
