package model.levelStuff;

import model.Char;
import model.PlayerCharacter;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Room {
    private List<Enemy> enemies;
    private List<PlayerCharacter> party;
    private List<Char> allChars;

    public Room(List<Enemy> enemies, List<PlayerCharacter> party) {
        this.enemies = enemies;
        this.party = party;
        this.allChars = new ArrayList<>();
        createAllChars();
    }

    public void createAllChars() {
        for(Char c : enemies) {
            allChars.add(c);
        }
        for(Char c : party) {
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
