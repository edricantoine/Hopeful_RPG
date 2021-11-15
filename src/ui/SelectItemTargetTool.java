package ui;

import model.Item;
import model.PlayerCharacter;
import model.levelStuff.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectItemTargetTool {
    private Room room;
    private Item item;
    private PlayerCharacter user;
    private Battle battle;
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

    public SelectItemTargetTool(Room r, Item it, PlayerCharacter user, Battle bat) {
        playerButtons = new ArrayList<>();
        enemyButtons = new ArrayList<>();
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
        for(int i = 0; i < playerButtons.size(); i++) {
            playerButtons.get(i).setText(room.getParty().get(i).getName());
        }
        for(int i = 0; i < Math.min(enemyButtons.size(), room.getEnemies().size()); i++) {
            enemyButtons.get(i).setText(room.getEnemies().get(i).getName());
        }
        initializeListeners();
    }

    public void initializeListeners() {
        for(int i = 0; i < playerButtons.size(); i++) {
            int finalI = i;
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
        }

        for(int i = 0; i < Math.min(enemyButtons.size(), room.getEnemies().size()); i++) {
            int finalI = i;
            enemyButtons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    user.setSelectedItem(item);
                    item.addToSetTargets(room.getEnemies().get(finalI));
                    battle.checkReadyToTurn();
                    Component cButton = (Component) e.getSource();
                    SwingUtilities.getWindowAncestor(cButton).dispose();

                }
            });
        }

        for(int i = 0; i < enemyButtons.size(); i++) {
            int finalI = i;
            String text = enemyButtons.get(i).getText();
            if(text.equals("N/A")) {
                enemyButtons.get(i).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        user.setSelectedItem(item);
                        item.addToSetTargets(room.getEnemies().get(finalI));
                        battle.checkReadyToTurn();
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();

                    }
                });
            }
        }

    }
}
