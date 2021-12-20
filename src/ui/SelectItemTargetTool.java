package ui;

import model.Item;
import model.PlayerCharacter;
import model.levelStuff.NewRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SelectItemTargetTool {
    private NewRoom room;
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

    public SelectItemTargetTool(NewRoom r, Item it, PlayerCharacter user, Battle bat) {
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
        for (int i = 0; i < playerButtons.size(); i++) {
            playerButtons.get(i).setText(room.getParty().get(i).getName());
        }
        for (int i = 0; i < Math.min(enemyButtons.size(), room.getEnemies().size()); i++) {
            enemyButtons.get(i).setText(room.getEnemies().get(i).getName());
        }
        for (int i = 0; i < enemyButtons.size(); i++) {
            if (enemyButtons.get(i).getText().equals("Button")) {
                enemyButtons.get(i).setText("N/A");
            }
        }
        initializeListeners();
    }

    public void initializeListeners() {
        for (int i = 0; i < playerButtons.size(); i++) {
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

        for (int i = 0; i < Math.min(enemyButtons.size(), room.getEnemies().size()); i++) {
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

        for (int i = 0; i < enemyButtons.size(); i++) {
            int finalI = i;
            String text = enemyButtons.get(i).getText();
            if (text.equals("N/A")) {
                enemyButtons.get(i).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();

                    }
                });
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
