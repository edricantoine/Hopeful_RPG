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

public class SelectItemTool {
    private Room room;
    private List<JButton> buttons;
    private List<Item> inventory;
    private PlayerCharacter user;
    private Battle battle;
    private JPanel ItemSelectPanel;
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

    public SelectItemTool(Room r, List<Item> inv, PlayerCharacter user, Battle bat) {
        buttons = new ArrayList<>();
        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(button10);
        room = r;
        inventory = inv;
        this.user = user;
        battle = bat;
        initializeButtons();
        JFrame frame = new JFrame("Select Target");
        frame.setContentPane(ItemSelectPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void initializeButtons() {
        for(int i = 0; i < Math.min(room.getInventory().size(), buttons.size()); i++) {
            buttons.get(i).setText(room.getInventory().get(i).getName());
        }
        initializeTooltips();
        initializeListeners();
    }

    public void initializeTooltips() {
        for(int i = 0; i < Math.min(room.getInventory().size(), buttons.size()); i++) {
            buttons.get(i).setToolTipText(room.getInventory().get(i).getFlavor());
        }
    }

    public void initializeListeners() {
        for(int i = 0; i < Math.min(room.getInventory().size(), buttons.size()); i++) {
            int finalI = i;
            buttons.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new SelectItemTargetTool(room, room.getInventory().get(finalI), user, battle);
                    Component cButton = (Component) e.getSource();
                    SwingUtilities.getWindowAncestor(cButton).dispose();
                }
            });
        }

        for(int i = 0; i < buttons.size(); i++) {
            String text = buttons.get(i).getText();
            if(text.equals("N/A")) {
                buttons.get(i).addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Component cButton = (Component) e.getSource();
                        SwingUtilities.getWindowAncestor(cButton).dispose();
                    }
                });
            }
        }
    }
}
