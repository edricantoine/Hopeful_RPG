package ui;

import model.Item;
import model.PlayerCharacter;
import model.enemies.Enemy;
import model.levelStuff.NewRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//Class representing the screen where the user chooses the target of an item.

public class SelectItemTargetTool {
    private NewRoom room; //room the battle is taking place in
    private Item item; //the item being used
    private PlayerCharacter user; // the user of the item
    private Battle battle; //the battle currently happening
    private JPanel SelectItemTargetPanel;
    private List<JButton> playerButtons;
    private List<JButton> enemyButtons;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;

    public SelectItemTargetTool(NewRoom r, Item it, PlayerCharacter user, Battle bat) {
        playerButtons = new ArrayList<>();
        enemyButtons = new ArrayList<>();
        //only up to 4 player characters and 4 enemies can be in the battle at a time
        playerButtons.add(button1);
        playerButtons.add(button2);
        playerButtons.add(button3);
        playerButtons.add(button4);
        enemyButtons.add(button5);
        enemyButtons.add(button6);
        enemyButtons.add(button7);
        enemyButtons.add(button8);
        room = r;
        item = it;
        this.user = user;
        battle = bat;
        initializeButtons();
        JFrame frame = new JFrame("Select Target");
        frame.setContentPane(SelectItemTargetPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void initializeButtons() {
        //sets labels to specific character names if the item only affects one target,
        //sets labels on 2 buttons to "all enemies" and "all allies" if the item affects all of a group,
        //sets all other labels to "N/A"
        if (item.getTarget().equals("one")) {
            for (int i = 0; i < playerButtons.size(); i++) {
                playerButtons.get(i).setText(room.getParty().get(i).getName());
            }
            for (int i = 0; i < Math.min(enemyButtons.size(), room.getEnemies().size()); i++) {
                enemyButtons.get(i).setText(room.getEnemies().get(i).getName());
            }
            for (int i = 0; i < enemyButtons.size(); i++) {
                if (enemyButtons.get(i).getText().equals("Button")) {
                    enemyButtons.get(i).setText("Cancel");
                }
            }
        } else if (item.getTarget().equals("all")) {
            playerButtons.get(0).setText("All allies");
            enemyButtons.get(0).setText("All enemies");
            for (int i = 1; i < playerButtons.size(); i++) {
                playerButtons.get(i).setText("Cancel");
            }
            for (int i = 1; i < enemyButtons.size(); i++) {
                enemyButtons.get(i).setText("Cancel");
            }
        }
        initializeListeners();
    }

    public void initializeListeners() {
        for (int i = 0; i < playerButtons.size(); i++) {
            int finalI = i;
            String text = playerButtons.get(i).getText();
            if (text.equals("Cancel")) { //any button with label "N/A" simply closes the screen
                playerButtons.get(i).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                        battle.refreshButtons();
                    }
                });
            } else {
                if (item.getTarget().equals("one")) { //in this case, only ONE character is the selected target of the item
                    playerButtons.get(i).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            user.setSelectedItem(item);
                            item.addToSetTargets(room.getParty().get(finalI));
                            battle.checkReadyToTurn();
                            Component cButton = (Component) e.getSource();
                            SwingUtilities.getWindowAncestor(cButton).dispose();
                        }
                    });
                } else if (item.getTarget().equals("all")) { //in this case, ALL allies are targeted
                    playerButtons.get(i).addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            user.setSelectedItem(item);
                            for (PlayerCharacter p : room.getParty()) {
                                item.addToSetTargets(p);
                            }

                            battle.checkReadyToTurn();
                            Component cButton = (Component) e.getSource();
                            SwingUtilities.getWindowAncestor(cButton).dispose();
                        }
                    });
                }
            }
        }


        for (int i = 0; i < enemyButtons.size(); i++) {
            int finalI = i;
            String text = enemyButtons.get(i).getText();
            if (text.equals("Cancel")) {
                enemyButtons.get(i).addActionListener(new ActionListener() { //same as above
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                        battle.refreshButtons();

                    }
                });
            } else {
                if (item.getTarget().equals("one")) {
                    enemyButtons.get(i).addActionListener(new ActionListener() { //same as above
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            user.setSelectedItem(item);
                            item.addToSetTargets(room.getEnemies().get(finalI));
                            battle.checkReadyToTurn();
                            Component cButton = (Component) e.getSource();
                            SwingUtilities.getWindowAncestor(cButton).dispose();

                        }
                    });
                } else if (item.getTarget().equals("all")) {
                    enemyButtons.get(i).addActionListener(new ActionListener() { //same as above, but with ALL enemies instead
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            user.setSelectedItem(item);
                            for (Enemy a : room.getEnemies()) {
                                item.addToSetTargets(a);
                            }
                            battle.checkReadyToTurn();
                            Component cButton = (Component) e.getSource();
                            SwingUtilities.getWindowAncestor(cButton).dispose();

                        }
                    });
                }
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
        SelectItemTargetPanel = new JPanel();
        SelectItemTargetPanel.setLayout(new GridBagLayout());
        SelectItemTargetPanel.setBackground(new Color(-4988956));
        button1 = new JButton();
        button1.setText("Button");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectItemTargetPanel.add(button1, gbc);
        button2 = new JButton();
        button2.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectItemTargetPanel.add(button2, gbc);
        button3 = new JButton();
        button3.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectItemTargetPanel.add(button3, gbc);
        button4 = new JButton();
        button4.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectItemTargetPanel.add(button4, gbc);
        button5 = new JButton();
        button5.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectItemTargetPanel.add(button5, gbc);
        button6 = new JButton();
        button6.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectItemTargetPanel.add(button6, gbc);
        button7 = new JButton();
        button7.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectItemTargetPanel.add(button7, gbc);
        button8 = new JButton();
        button8.setText("Button");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        SelectItemTargetPanel.add(button8, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return SelectItemTargetPanel;
    }

}
