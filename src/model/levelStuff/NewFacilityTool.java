package model.levelStuff;

import model.Item;
import model.PlayerCharacter;
import model.StatusEffect;
import model.enemies.Enemy;
import model.enemies.Facility.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//A tool that helps set up the Facility level in the game.
//No unit tests exist for this class due to the heavy reliance on random numbers and the fact that
//any bugs can be easily detected by myself when play testing.

public class NewFacilityTool {
    private List<Item> inventory; //current inventory
    private List<PlayerCharacter> party; //current party

    private NewRoom[][] facilityRooms; //grid of rooms
    private List<String> enemies; //possible enemy types that can appear in this level

    public NewFacilityTool(List<Item> inventory, List<PlayerCharacter> party) {
        this.inventory = inventory;
        this.party = party;
        facilityRooms = new NewRoom[5][5];

        enemies = new ArrayList<>(Arrays.asList(
                "bom", "bul", "deb", "med", "mel"
        ));
        setUpFacilityLevel();
    }

    //getters

    public NewRoom[][] getFacilityRooms() {
        return facilityRooms;
    }

    //Sets up possible Room Events and Enemy configurations, then creates somewhat random rooms based on these


    public void setUpFacilityLevel() {

        RoomEvent e0 = new RoomEvent(0, 50.0, 0, 0, 0.0, 0.0, StatusEffect.NONE, 0, "all",
                "A strange machine is in this room. Upon examining it, your party is healed a bit!");

        RoomEvent e1 = new RoomEvent(10, 0, 0, 0, 0.0, 0.0, StatusEffect.BURNED, 0, "one",
                "While walking, a strange beaker falls off of a shelf, burning someone...! (Check your party!)");

        RoomEvent e3 = new RoomEvent(0, 0, 0, 0, 0, 0, StatusEffect.POISONED, 0, "all", "" +
                "The room is filled with toxic gas! You manage to shut it off but everyone is now poisoned.");

        RoomEvent e4 = new RoomEvent(0, 0, 50, 0, 0, 0, StatusEffect.NONE, 0, "all", "" +
                "A strange machine is in this room. Upon examining it, your party recovers a bit of AP!");

        RoomEvent e5 = new RoomEvent(100, 0, 0, 0, 0, 0, StatusEffect.NONE, 0, "one",
                "While attempting to open a door, someone in the party is viciously shocked by the facility's security system. (Check your party!)");


        List<Enemy> configB1 = new ArrayList<>(Arrays.asList(
                new FacilityGuard(), new FacilityMelee(), new FacilityMelee(), new FacilityMelee()
        ));
        List<Enemy> configB2 = new ArrayList<>(Arrays.asList(
                new FacilitySecurity(), new FacilityDrone()
        ));
        List<Enemy> configB3 = new ArrayList<Enemy>(Arrays.asList(
                new FacilityTank(), new FacilityMedic(), new FacilityMelee(), new FacilityDebuffer()
        ));

        facilityRooms[0][0] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, null);
        facilityRooms[0][1] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        facilityRooms[0][2] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, e0);
        facilityRooms[0][3] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        facilityRooms[0][4] = new NewRoom(selectConfig(), party, inventory, new Item("Food Rations", "Heals by 50 HP.",
                0.0, 50.0, 0, 1.0, 1.0, 0, false, StatusEffect.NONE, 0, "one"), false, false, 0, null);

        facilityRooms[1][0] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        facilityRooms[1][1] = new NewRoom(configB1, party, inventory, null, true, false, 1, null);
        facilityRooms[1][2] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        facilityRooms[1][3] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        facilityRooms[1][4] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, e1);

        facilityRooms[2][0] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        facilityRooms[2][1] = new NewRoom(selectConfig(), party, inventory, new Item("Flashbang Grenade", "Target's attack and defense are lowered, with chance to numb target", 10.0,
                0.0, 0, -0.10, 1.20, 0, false, StatusEffect.NUMB, 2, "one"), false, false, 0, null);
        facilityRooms[2][2] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        facilityRooms[2][3] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, e3);
        facilityRooms[2][4] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);

        facilityRooms[3][0] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, e4);
        facilityRooms[3][1] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        facilityRooms[3][2] = new NewRoom(selectConfig(), party, inventory,  new Item("Riot Shield", "Activates Riposte on one character.", 0.0,
                0.0, 0, 1.0, 1.0, 0, false, StatusEffect.RIPOSTE, 1, "one"), false, false, 0, null);
        facilityRooms[3][3] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        facilityRooms[3][4] = new NewRoom(configB2, party, inventory, null, true, false, 2, null);

        facilityRooms[4][0] = new NewRoom(selectConfig(), party, inventory,  new Item("Biofield", "Heals all allies by 50.", 0.0,
                50.0, 0, 1.0, 1.0, 0, false, StatusEffect.NONE, 1, "all"), false, false, 0, null);
        facilityRooms[4][1] = new NewRoom(configB3, party, inventory, null, true, false, 3, null);
        facilityRooms[4][2] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        facilityRooms[4][3] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, e5);
        facilityRooms[4][4] = new NewRoom(selectConfig(), party, inventory,  new Item("Pot of Coffee", "Permanently increases Speed this level.", 0.0,
                0.0, 0, 1.0, 1.0, 1, false, StatusEffect.NONE, 1, "one"), false, false, 0, null);










    }

    //returns a random true or false value

    public Boolean returnRandom1to2() {
        Random rand = new Random();
        int chosen = rand.nextInt(2);
        return chosen == 0;
    }

    //randomly creates a list of enemies from 1 to 4 members, then chooses random enemy types for each member

    public List<Enemy> selectConfig() {
        List<Enemy> toReturn = new ArrayList<>();
        Random rand = new Random();
        int chosenconfig = rand.nextInt(3) + 2;

        for(int i = 1; i <= chosenconfig; i++) {
            Random rand2 = new Random();
            int chosenenemy = rand2.nextInt(enemies.size());
            if(enemies.get(chosenenemy).equals("bom")) {
                toReturn.add(new FacilityBomber());
            } else if(enemies.get(chosenenemy).equals("bul")) {
                toReturn.add(new FacilityBulwark());
            } else if(enemies.get(chosenenemy).equals("deb")) {
                toReturn.add(new FacilityDebuffer());
            } else if(enemies.get(chosenenemy).equals("med")) {
                toReturn.add(new FacilityMedic());
            } else if(enemies.get(chosenenemy).equals("mel")) {
                toReturn.add(new FacilityMelee());
            }
        }

        return toReturn;


    }


}
