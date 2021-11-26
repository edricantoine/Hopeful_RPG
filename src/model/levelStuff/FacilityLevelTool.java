package model.levelStuff;

import model.Item;
import model.PlayerCharacter;
import model.enemies.Enemy;
import model.enemies.Facility.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FacilityLevelTool {
    private List<Item> inventory;
    private List<PlayerCharacter> party;
    private Room facilityRooms;

    public FacilityLevelTool(List<Item> inventory, List<PlayerCharacter> party) {
        this.inventory = inventory;
        this.party = party;
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

        facilityRooms = new Room(configB2, party ,inventory, null, null);
    }

    public Room getFacilityRooms() {
        return facilityRooms;
    }
}
