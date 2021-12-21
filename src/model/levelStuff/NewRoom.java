package model.levelStuff;

import model.Char;
import model.Item;
import model.PlayerCharacter;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NewRoom {
    private List<Item> inventory;
    private List<Enemy> enemies;
    private List<PlayerCharacter> party;
    private List<Char> allChars;
    private Item item;
    private Boolean hasBattle;
    private Boolean isFinalRoom;
    private RoomEvent event;
    private int whichBoss; // can be 0 1 2 or 3


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

    public RoomEvent getEvent() {
        return event;
    }

    public void useEvent() {
        event = null;
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

    public Boolean canPickUpItem() {
        return inventory.size() < 10;
    }

    public void setItemNull() {
        this.item = null;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void removeFromInventory(Item i) {
        inventory.remove(i);
    }


    public Boolean isBattleWon() {
        for(Enemy e : enemies) {
            if(!e.getDead()) {
                return false;
            }
        }
        return true;
    }

    public Boolean isBattleLost() {
        for(PlayerCharacter e : party) {
            if(!e.getDead()) {
                return false;
            }
        }
        return true;
    }

    public void createAllChars() {
        for(Enemy c : enemies) {
            allChars.add(c);
        }
        for(PlayerCharacter c : party) {
            c.setPartyWith(party);
            c.setEnemiesFighting(enemies);
            allChars.add(c);
        }
        allChars.sort(Comparator.comparing(Char::getSpeed).reversed());

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
}
