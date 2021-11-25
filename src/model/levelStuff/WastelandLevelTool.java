package model.levelStuff;

import model.*;
import model.enemies.*;
import model.enemies.Wasteland.*;

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
                new WastelandFrankie(), new WastelandAssassin(), new WastelandAssassin()
        ));
        List<Enemy> configB2 = new ArrayList<>(Arrays.asList(
                new WastelandSentry(), new WastelandMelee(), new WastelandMelee()
        ));
        List<Enemy> configB3 = new ArrayList<Enemy>(Arrays.asList(
                new WastelandRev(), new WastelandSupport(), new WastelandSupport()
        ));

        wastelandRooms = (new Room(config1, party, inventory, new Item("Food Rations", "Heals by 20 HP.",
                0.0, 20.0, 0, 1.0, 1.0, false, StatusEffect.NONE, 0, "one"),
                new Room(config2, party, inventory, new Item("Hot Coals", "Burns the target",
                10.0, 0.0, 0, 1.0, 1.0, false, StatusEffect.BURNED, 1, "one"),
                        new Room(configB1, party, inventory, new Item("Frankie's Engine", "Increases attack drastically but burns the user",
                                0.0, 0.0, 0, 3.00, 1.0, false, StatusEffect.BURNED, 1, "one"),
                                new Room(config5, party, inventory, new Item("AP Potion", "Heals 10 AP",
                0.0, 0.0, 10, 1.0, 1.0, false, StatusEffect.NONE, 0, "one"),
                                        new Room(config6, party, inventory, new Item("Food Rations", "Heals by 20 HP.",
                                                0.0, 20.0, 0, 1.0, 1.0, false, StatusEffect.NONE, 0, "one"),
                                                new Room(configB2, party, inventory, null,
                                                        new Room(config7, party, inventory, new Item("SEN-3's Shield", "Massive increase to defense but decreases attack",
                                                                0.0, 0.0, 0, 0.30, 0.30, false, StatusEffect.NONE, 0, "one"),
                                                                new Room(config8, party, inventory, new Item("Bomb", "A bomb.", 50.0, 0.0, 0, 1.0, 1.0, false,
                                                                        StatusEffect.NONE, 0, "all"),
                                                                        new Room(config9, party, inventory, null,
                                                                                new Room(configB3, party, inventory, null, null)))))))))));









    }

    public Room getWastelandRooms() {
        return wastelandRooms;
    }
}
