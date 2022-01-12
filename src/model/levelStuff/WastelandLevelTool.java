package model.levelStuff;

import model.Item;
import model.PlayerCharacter;
import model.enemies.Enemy;
import model.enemies.Wasteland.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//THIS CLASS WILL BE DELETED.

public class WastelandLevelTool {
    private List<Item> inventory;
    private List<PlayerCharacter> party;
    private List<List<Enemy>> configs;
    private Room wastelandRooms;
    private List<String> enemies;

    public WastelandLevelTool(List<Item> inventory, List<PlayerCharacter> party) {
        this.inventory = inventory;
        this.party = party;
        configs = new ArrayList<>();
        enemies = new ArrayList<>(Arrays.asList(
                "as", "mel", "sup", "tan"
        ));
        setUpWastelandLevel();
    }


    public void setUpWastelandLevel() {
        List<Enemy> config1 = new ArrayList<>(Arrays.asList(
                new WastelandAssassin(), new WastelandMelee()
        ));
        List<Enemy> config2 = new ArrayList<>(Arrays.asList(
                new WastelandAssassin(), new WastelandMelee(), new WastelandTank()
        ));
        List<Enemy> config3 = new ArrayList<>(Arrays.asList(
                new WastelandTank(), new WastelandMelee(), new WastelandSupport()
        ));
        List<Enemy> config4 = new ArrayList<>(Arrays.asList(
                new WastelandAssassin(), new WastelandMelee(), new WastelandTank(), new WastelandSupport()
        ));
        List<Enemy> config5 = new ArrayList<>(Arrays.asList(
                new WastelandTank(), new WastelandSupport()
        ));
        List<Enemy> config6 = new ArrayList<>(Arrays.asList(
                new WastelandAssassin(), new WastelandMelee()
        ));
        List<Enemy> config7 = new ArrayList<>(Arrays.asList(
                new WastelandMelee(), new WastelandMelee(), new WastelandSupport()
        ));
        List<Enemy> config8 = new ArrayList<>(Arrays.asList(
                new WastelandAssassin(), new WastelandTank()
        ));
        List<Enemy> config9 = new ArrayList<>(Arrays.asList(
                new WastelandTank(), new WastelandTank(), new WastelandTank()
        ));
        List<Enemy> config10 = new ArrayList<>(Arrays.asList(
                new WastelandMelee(), new WastelandSupport(), new WastelandSupport()
        ));
        List<Enemy> configB1 = new ArrayList<>(Arrays.asList(
                new WastelandFrankie(), new WastelandAssassin(), new WastelandAssassin()
        ));
        List<Enemy> configB2 = new ArrayList<>(Arrays.asList(
                new WastelandSentry(), new WastelandMelee(), new WastelandMelee()
        ));
        List<Enemy> configB3 = new ArrayList<Enemy>(Arrays.asList(
                new WastelandRev(), new WastelandSupport(), new WastelandSupport()
        ));

        configs.add(config1);
        configs.add(config2);
        configs.add(config3);
        configs.add(config4);
        configs.add(config5);
        configs.add(config6);
        configs.add(config7);
        configs.add(config8);
        configs.add(config9);
        configs.add(config10);


        wastelandRooms = (new Room(selectConfig(), party, inventory,
                new Room(selectConfig(), party, inventory,
                        new Room(configB1, party, inventory,
                                new Room(selectConfig(), party, inventory,
                                        new Room(selectConfig(), party, inventory,
                                                        new Room(configB2, party, inventory,
                                                                new Room(selectConfig(), party, inventory,
                                                                        new Room(selectConfig(), party, inventory,
                                                                                new Room(configB3, party, inventory, null))))))))));


    }

    public List<Enemy> selectConfig() {
        List<Enemy> toReturn = new ArrayList<>();
        Random rand = new Random();
        int chosenconfig = rand.nextInt(3) + 2;

        for(int i = 1; i <= chosenconfig; i++) {
            Random rand2 = new Random();
            int chosenenemy = rand2.nextInt(enemies.size());
            if(enemies.get(chosenenemy).equals("as")) {
                toReturn.add(new WastelandAssassin());
            } else if(enemies.get(chosenenemy).equals("mel")) {
                toReturn.add(new WastelandMelee());
            } else if(enemies.get(chosenenemy).equals("sup")) {
                toReturn.add(new WastelandSupport());
            } else if(enemies.get(chosenenemy).equals("tan")) {
                toReturn.add(new WastelandTank());
            }
        }

        return toReturn;


    }

    public Room getWastelandRooms() {
        return wastelandRooms;
    }
}
