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
    private List<Item> inventory; //current inventory
    private List<PlayerCharacter> party; //current party
    private NewRoom[][] wastelandRooms; //grid of rooms
    private List<String> enemies; //possible enemy types

    public NewWastelandTool(List<Item> inventory, List<PlayerCharacter> party) {
        this.inventory = inventory;
        this.party = party;

        enemies = new ArrayList<>(Arrays.asList(
                "as", "mel", "sup", "tan"
        ));
        wastelandRooms = new NewRoom[4][4];
        setUpWastelandLevel();
    }

    //getters
    public NewRoom[][] getWastelandRooms() {
        return wastelandRooms;
    }

    //Sets up possible Enemy configurations, then creates somewhat random rooms based on these
    public void setUpWastelandLevel() {

        List<Enemy> configB1 = new ArrayList<>(Arrays.asList(
                new WastelandFrankie(), new WastelandAssassin(), new WastelandAssassin()
        ));
        List<Enemy> configB2 = new ArrayList<>(Arrays.asList(
                new WastelandSentry(), new WastelandMelee(), new WastelandMelee()
        ));
        List<Enemy> configB3 = new ArrayList<Enemy>(Arrays.asList(
                new WastelandRev(), new WastelandSupport(), new WastelandSupport()
        ));




        wastelandRooms[0][0] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, null);
        wastelandRooms[0][1] = new NewRoom(selectConfig(), party, inventory, null, true, false, 0, null);
        wastelandRooms[0][2] = new NewRoom(selectConfig(), party, inventory, new Item("Hot Coals", "Burns the target",
                10.0, 0.0, 0, 1.0, 1.0, false, StatusEffect.BURNED, 1, "one"), false, false, 0, null);
        wastelandRooms[0][3] = new NewRoom(selectConfig(), party, inventory, null, true, false, 0, null);

        wastelandRooms[1][0] = new NewRoom(configB2, party, inventory, null, true, false, 2, null);
        wastelandRooms[1][1] = new NewRoom(selectConfig(), party, inventory, new Item("Food Rations", "Heals by 50 HP.",
                0.0, 50.0, 0, 1.0, 1.0, false, StatusEffect.NONE, 0, "one"), false, false, 0, null);
        wastelandRooms[1][2] = new NewRoom(selectConfig(), party, inventory, null, true, false, 0, null);
        wastelandRooms[1][3] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, null);

        wastelandRooms[2][0] = new NewRoom(selectConfig(), party, inventory, new Item("AP Potion", "Heals 50 AP",
                0.0, 0.0, 50, 1.0, 1.0, false, StatusEffect.NONE, 0, "one"), false, false ,0, null);
        wastelandRooms[2][1] = new NewRoom(configB3, party, inventory, null, true, false, 3, null);
        wastelandRooms[2][2] = new NewRoom(selectConfig(), party, inventory, null, true, false, 0, null);
        wastelandRooms[2][3] = new NewRoom(selectConfig(), party, inventory, new Item("Bomb", "A bomb. Deals 100 damage.", 100, 0.0, 0, 1.0, 1.0, false,
                StatusEffect.NONE, 0, "all"), false, false, 0, null);

        wastelandRooms[3][0] = new NewRoom(configB1, party, inventory, null, true, true, 1, null);
        wastelandRooms[3][1] = new NewRoom(selectConfig(), party, inventory, new Item("AP Potion", "Heals 50 AP",
                0.0, 0.0, 50, 1.0, 1.0, false, StatusEffect.NONE, 0, "one"), false, false, 0, null);
        wastelandRooms[3][2] = new NewRoom(selectConfig(), party, inventory, null, true, false, 0, null);
        wastelandRooms[3][3] = new NewRoom(selectConfig(), party, inventory, new Item("Food Rations", "Heals by 50 HP.",
                0.0, 50.0, 0, 1.0, 1.0, false, StatusEffect.NONE, 0, "one"), false, false, 0, null);





    }

    //randomly creates a list of enemies from 1 to 4 members, then chooses random enemy types for each member
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

}
