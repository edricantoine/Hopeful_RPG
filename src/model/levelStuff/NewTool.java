package model.levelStuff;

import model.Item;
import model.PlayerCharacter;
import model.enemies.Enemy;

import java.util.List;
import java.util.Random;

public abstract class NewTool {
    protected List<Item> inventory; //inventory of level
    protected List<PlayerCharacter> party; //the party that will go through the level
    protected List<String> enemies; //enemies able to be encountered in this level
    protected NewRoom[][] rooms; // grid of rooms belonging to this level

    public NewTool(List<Item> inventory, List<PlayerCharacter> party) {
        this.inventory = inventory;
        this.party = party;
    }

    //getter

    public NewRoom[][] getRooms() {
        return rooms;
    }

    public abstract List<Enemy> selectConfig();

    public abstract void setUpLevel();

    //pretty straightforward, returns either true or false randomly
    public Boolean returnRandom1to2() {
        Random rand = new Random();
        int chosen = rand.nextInt(2);
        return chosen == 0;
    }
}
