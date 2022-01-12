package model.levelStuff;

import model.Item;
import model.PlayerCharacter;
import model.enemies.Enemy;
import model.enemies.Facility.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//THIS CLASS WILL BE DELETED.

public class FacilityLevelTool {
    private List<Item> inventory;
    private List<PlayerCharacter> party;
    private List<String> enemies;
    private Room facilityRooms;

    public FacilityLevelTool(List<Item> inventory, List<PlayerCharacter> party) {
        this.inventory = inventory;
        this.party = party;
        enemies = new ArrayList<>(Arrays.asList(
                "bom", "bul", "deb", "med", "mel"
        ));
        setUpFacilityLevel();
    }

    public void setUpFacilityLevel() {
        List<Enemy> configB1 = new ArrayList<>(Arrays.asList(
                new FacilityGuard(), new FacilityMelee(), new FacilityMelee(), new FacilityMelee()
        ));
        List<Enemy> configB2 = new ArrayList<>(Arrays.asList(
                new FacilitySecurity(), new FacilityDrone()
        ));
        List<Enemy> configB3 = new ArrayList<>(Arrays.asList(
                new FacilityTank(), new FacilityGuard(), new FacilityDrone(), new FacilitySecurity()));
        List<Enemy> configBTest = new ArrayList<>(Arrays.asList(
                 new FacilityTank()));




        facilityRooms = new Room(selectConfig(), party ,inventory,
                new Room(selectConfig(), party ,inventory,
                        new Room(configB1, party ,inventory,
                                new Room(selectConfig(), party ,inventory,
                                        new Room(selectConfig(), party ,inventory,
                                                new Room(configB2, party ,inventory,
                                                        new Room(selectConfig(), party ,inventory,
                                                                new Room(selectConfig(), party ,inventory,
                                                                        new Room(configB3, party ,inventory,null)))))))));
    }

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

    public Room getFacilityRooms() {
        return facilityRooms;
    }
}
