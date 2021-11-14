package model.levelStuff;

import model.Char;
import model.Item;
import model.PlayerCharacter;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Room {
    private List<Item> inventory;
    private List<Enemy> enemies;
    private List<PlayerCharacter> party;
    private List<Char> allChars;
    private Room nextRoom;

    public Room(List<Enemy> enemies, List<PlayerCharacter> party, List<Item> inventory, Room nextRoom) {
        this.nextRoom = nextRoom;
        this.enemies = enemies;
        this.party = party;
        this.inventory = inventory;
        this.allChars = new ArrayList<>();
        createAllChars();
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
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
