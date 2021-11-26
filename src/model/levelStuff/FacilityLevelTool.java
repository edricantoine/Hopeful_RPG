package model.levelStuff;

import model.Item;
import model.PlayerCharacter;
import model.enemies.Enemy;
import model.enemies.Facility.FacilityGuard;
import model.enemies.Facility.FacilityMelee;

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

        facilityRooms = new Room(configB1, party ,inventory, null, null);
    }

    public Room getFacilityRooms() {
        return facilityRooms;
    }
}
