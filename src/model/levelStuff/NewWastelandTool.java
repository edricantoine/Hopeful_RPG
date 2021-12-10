package model.levelStuff;

import model.Item;
import model.PlayerCharacter;
import model.StatusEffect;
import model.enemies.Enemy;
import model.enemies.Wasteland.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class NewWastelandTool {
    private List<Item> inventory;
    private List<PlayerCharacter> party;
    private List<List<Enemy>> configs;
    private NewRoom[][] wastelandRooms;
    private List<String> enemies;

    public NewWastelandTool(List<Item> inventory, List<PlayerCharacter> party) {
        this.inventory = inventory;
        this.party = party;
        configs = new ArrayList<>();
        enemies = new ArrayList<>(Arrays.asList(
                "as", "mel", "sup", "tan"
        ));
        wastelandRooms = new NewRoom[4][4];
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

        wastelandRooms[0][0] = new NewRoom(selectConfig(), party, inventory, null, false, false);
        wastelandRooms[0][1] = new NewRoom(selectConfig(), party, inventory, null, true, false);
        wastelandRooms[0][2] = new NewRoom(selectConfig(), party, inventory, new Item("Hot Coals", "Burns the target",
                10.0, 0.0, 0, 1.0, 1.0, false, StatusEffect.BURNED, 1, "one"), false, false);
        wastelandRooms[0][3] = new NewRoom(selectConfig(), party, inventory, null, true, false);

        wastelandRooms[1][0] = new NewRoom(selectConfig(), party, inventory, null, false, false);
        wastelandRooms[1][1] = new NewRoom(selectConfig(), party, inventory, new Item("Food Rations", "Heals by 50 HP.",
                0.0, 50.0, 0, 1.0, 1.0, false, StatusEffect.NONE, 0, "one"), false, false);
        wastelandRooms[1][2] = new NewRoom(selectConfig(), party, inventory, null, true, false);
        wastelandRooms[1][3] = new NewRoom(selectConfig(), party, inventory, null, false, false);

        wastelandRooms[2][0] = new NewRoom(selectConfig(), party, inventory, new Item("AP Potion", "Heals 50 AP",
                0.0, 0.0, 50, 1.0, 1.0, false, StatusEffect.NONE, 0, "one"), false, false);
        wastelandRooms[2][1] = new NewRoom(selectConfig(), party, inventory, null, true, false);
        wastelandRooms[2][2] = new NewRoom(selectConfig(), party, inventory, null, true, false);
        wastelandRooms[2][3] = new NewRoom(selectConfig(), party, inventory, new Item("Bomb", "A bomb. Deals 100 damage.", 100, 0.0, 0, 1.0, 1.0, false,
                StatusEffect.NONE, 0, "all"), false, false);

        wastelandRooms[3][0] = new NewRoom(selectBossConfig(), party, inventory, null, true, true);
        wastelandRooms[3][1] = new NewRoom(selectConfig(), party, inventory, new Item("AP Potion", "Heals 50 AP",
                0.0, 0.0, 50, 1.0, 1.0, false, StatusEffect.NONE, 0, "one"), false, false);
        wastelandRooms[3][2] = new NewRoom(selectConfig(), party, inventory, null, true, false);
        wastelandRooms[3][3] = new NewRoom(selectConfig(), party, inventory, new Item("Food Rations", "Heals by 50 HP.",
                0.0, 50.0, 0, 1.0, 1.0, false, StatusEffect.NONE, 0, "one"), false, false);





    }

    public List<Enemy> selectBossConfig() {
        List<Enemy> configB1 = new ArrayList<>(Arrays.asList(
                new WastelandFrankie(), new WastelandAssassin(), new WastelandAssassin()
        ));
        List<Enemy> configB2 = new ArrayList<>(Arrays.asList(
                new WastelandSentry(), new WastelandMelee(), new WastelandMelee()
        ));
        List<Enemy> configB3 = new ArrayList<Enemy>(Arrays.asList(
                new WastelandRev(), new WastelandSupport(), new WastelandSupport()
        ));
        Random rand = new Random();
        int chosenConfig = rand.nextInt(3);
        if(chosenConfig == 0) {
            return configB1;
        } else if (chosenConfig == 1) {
            return configB2;
        } else {
            return configB3;
        }
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

    public NewRoom[][] getWastelandRooms() {
        return wastelandRooms;
    }
}
