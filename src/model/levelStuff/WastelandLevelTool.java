package model.levelStuff;

import model.*;
import model.enemies.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WastelandLevelTool {
    private List<Item> inventory;
    private List<PlayerCharacter> party;
    private Room wastelandRooms;

    public WastelandLevelTool(List<Item> inventory, List<PlayerCharacter> party) {
        this.inventory = inventory;
        this.party = party;
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
                new WastelandFrankie()
        ));
        List<Enemy> configB2 = new ArrayList<>(Arrays.asList(
                new WastelandSentry(), new WastelandMelee(), new WastelandMelee()
        ));
        List<Enemy> configB3 = new ArrayList<Enemy>(Arrays.asList(
                new WastelandRev(), new WastelandSupport(), new WastelandSupport()
        ));

        wastelandRooms = (new Room(config1, party, inventory,
                new Room(config2, party, inventory,
                        new Room(config3, party, inventory,
                                new Room(config4, party, inventory,
                                        new Room(configB1, party, inventory,
                                                new Room(config5, party, inventory,
                                                        new Room(config6, party, inventory,
                                                                new Room(config7, party, inventory,
                                                                        new Room(config8, party, inventory,
                                                                                new Room(configB2, party, inventory,
                                                                                        new Room(config5, party, inventory,
                                                                                                new Room(config1, party, inventory,
                                                                                                        new Room(config2, party, inventory,
                                                                                                                new Room(config4, party, inventory,
                                                                                                                        new Room(configB3, party, inventory, null))))) )))))))))));








    }

    public Room getWastelandRooms() {
        return wastelandRooms;
    }
}
