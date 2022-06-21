package model.levelStuff;

import model.Char;
import model.Item;
import model.PlayerCharacter;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
// A class representing a room in a level.

public class NewRoom {
    private List<Item> inventory; //current room inventory
    private List<Enemy> enemies; //enemies in room
    private List<PlayerCharacter> party; //current party
    private List<Char> allChars; //all characters in room, sorted by speed
    private Item item; //room's item
    private Boolean hasBattle; //whether room has battle
    private Boolean isFinalRoom; //whether room is final one
    private RoomEvent event; //room event
    private int whichBoss; // can be 0 (no boss),  1 2 or 3


    public NewRoom(List<Enemy> enemies, List<PlayerCharacter> party, List<Item> inventory, Item i, Boolean hb, Boolean f, int whichBoss,
                   RoomEvent ev) {
        this.enemies = enemies;
        this.event = ev;
        this.party = party;
        this.inventory = inventory;
        this.allChars = new ArrayList<>();
        this.item = i;
        this.hasBattle = hb;
        this.isFinalRoom = f;
        this.whichBoss = whichBoss;

        createAllChars();
    }

    //getters, setters

    public RoomEvent getEvent() {
        return event;
    }

    public int getWhichBoss() {
        return whichBoss;
    }

    public Item getItem() {
        return item;
    }

    public Boolean getHasBattle() {
        return hasBattle;
    }

    public Boolean getFinalRoom() {
        return isFinalRoom;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<PlayerCharacter> getParty() {
        return party;
    }

    public List<Char> getAllChars() {
        return allChars;
    }


    //returns true if there is room in inventory for another item
    public Boolean canPickUpItem() {
        return inventory.size() < 10;
    }
    //sets event to null
    public void useEvent() {
        event = null;
    }
    //sets item to null
    public void setItemNull() {
        this.item = null;
    }
    //removes i from inventory
    public void removeFromInventory(Item i) {
        inventory.remove(i);
    }

    //returns true if all enemies are dead
    public Boolean isBattleWon() {
        for(Enemy e : enemies) {
            if(!e.getDead()) {
                return false;
            }
        }
        return true;
    }
    //returns true if all party members are dead
    public Boolean isBattleLost() {
        for(PlayerCharacter e : party) {
            if(!e.getDead()) {
                return false;
            }
        }
        return true;
    }

    //sorts all characters by speed
    public void createAllChars() {
        List<Char> temp = new ArrayList<>();
        for(Enemy c : enemies) {
            temp.add(c);
        }
        for(PlayerCharacter c : party) {
            c.setPartyWith(party);
            c.setEnemiesFighting(enemies);
            temp.add(c);
        }
        temp.sort(Comparator.comparing(Char::getSpeed).reversed());
        allChars = temp;

    }


}
