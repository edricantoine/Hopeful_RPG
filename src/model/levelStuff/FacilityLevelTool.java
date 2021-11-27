package model.levelStuff;

import model.Item;
import model.PlayerCharacter;
import model.enemies.Enemy;
import model.enemies.Facility.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FacilityLevelTool {
    private List<Item> inventory;
    private List<PlayerCharacter> party;
    private List<List<Enemy>> configs;
    private Room facilityRooms;

    public FacilityLevelTool(List<Item> inventory, List<PlayerCharacter> party) {
        this.inventory = inventory;
        this.party = party;
        configs = new ArrayList<>();
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
                new FacilityDrone(), new FacilityGuard(), new FacilityTank(), new FacilitySecurity()
        ));

        facilityRooms = new Room(configB2, party ,inventory,null);
    }

    public List<Enemy> selectConfig() {
        Random rand = new Random();
        int chosenconfig = rand.nextInt(configs.size());
        return configs.get(chosenconfig);
    }

    public Room getFacilityRooms() {
        return facilityRooms;
    }
}
