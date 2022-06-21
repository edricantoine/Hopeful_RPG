package model.levelStuff;

import model.Item;
import model.PlayerCharacter;
import model.StatusEffect;
import model.enemies.City.*;
import model.enemies.Enemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//A tool that helps set up the City level in the game.
//No unit tests exist for this class due to the heavy reliance on random numbers and the fact that
//any bugs can be easily detected by myself when play testing.

public class NewCityTool extends NewTool{
    public NewCityTool(List<Item> inventory, List<PlayerCharacter> party) {
        super(inventory, party);
        rooms = new NewRoom[5][6];
        enemies = new ArrayList<>(Arrays.asList(
                "alm", "bru", "cop", "dop", "dop2", "kni"
        ));
        setUpLevel();
    }

    @Override
    public List<Enemy> selectConfig() {
        List<Enemy> toReturn = new ArrayList<>();
        Random rand = new Random();
        int chosenconfig = rand.nextInt(3) + 2;

        for(int i = 1; i <= chosenconfig; i++) {
            Random rand2 = new Random();
            int chosenenemy = rand2.nextInt(enemies.size());
            if(enemies.get(chosenenemy).equals("alm")) {
                toReturn.add(new CityAlarm());
            } else if(enemies.get(chosenenemy).equals("bru")) {
                toReturn.add(new CityBruiser());
            } else if(enemies.get(chosenenemy).equals("cop")) {
                toReturn.add(new CityCop());
            } else if(enemies.get(chosenenemy).equals("dop")) {
                toReturn.add(new CityDoppel());
            } else if(enemies.get(chosenenemy).equals("dop2")) {
                toReturn.add(new CityDoppel2());
            } else if (enemies.get(chosenenemy).equals("kni")) {
                toReturn.add(new CityKnifer());
            }
        }

        return toReturn;
    }

    @Override
    public void setUpLevel() {
        List<Enemy> configB1 = new ArrayList<>(Arrays.asList(
                new CityWhip(), new CityKnifer(), new CityKnifer()
        ));
        List<Enemy> configB2 = new ArrayList<>(Arrays.asList(
                new CityBiker(), new CityBruiser(), new CityBruiser()
        ));
        List<Enemy> configB3 = new ArrayList<>(Arrays.asList(
               new CityBoxer(), new CityCop(), new CityBruiser(), new CityKnifer()
        ));

        List<Enemy> configRats = new ArrayList<>(Arrays.asList(
                new CityAlarm(), new CityAlarm()
        ));
        List<Enemy> configDoppels = new ArrayList<>(Arrays.asList(
                new CityDoppel(), new CityDoppel2()
        ));

        RoomEvent e0 = new RoomEvent(0, 0, 0, 0, 1.1, 1.1, StatusEffect.NONE, 0,"all",
                "Stopping by a liquor store, the party decides to get drinks. Attack up, but defense down for the next " +
                        "fight!");

        RoomEvent e1 = new RoomEvent(0, 100, 100, 0, 1.0, 1.0, StatusEffect.NONE, 0, "all",
                "The party decides to stop by a restaurant and eat. HP and AP healed by 100!");

        RoomEvent e2 = new RoomEvent(0, 0, 0, 0, 1.0, 1.0, StatusEffect.NONE, -2, "all",
                "It's getting pretty late and the party is tired... -2 speed for the next battle!");

        RoomEvent e3 = new RoomEvent(60, 0, 0, 0, 1.0, 1.0, StatusEffect.NONE, 0, "one",
                "While traversing the city, your party gets mugged! One of the party members fights the attacker off, " +
                        "sustaining damage in the process. (Check your party status!)");

        RoomEvent e4 = new RoomEvent(0, 0, 0, 0, 1.0, 1.0, StatusEffect.NUMB, 0, "one",
                "A livewire lying across the road shocks and stuns one of your party members! (Check your party status!)");

        rooms[0][0] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, null);
        rooms[0][1] = new NewRoom(configRats, party, inventory, null, true, false, 0, null);
        rooms[0][2] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        rooms[0][3] = new NewRoom(selectConfig(), party, inventory, new Item("Protein Shake", "Increases one character's attack and defense!", 10.0,
                0.0, 0, 0.50, -0.10, 0, false, StatusEffect.NONE, 2, "one"), false, false, 0, null);
        rooms[0][4] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, e4);
        rooms[0][5] = new NewRoom(configB1, party, inventory, null, true, false, 1, null);

        rooms[1][0] = new NewRoom(configDoppels, party, inventory, null, true, false, 0, null);
        rooms[1][1] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, e3);
        rooms[1][2] = new NewRoom(selectConfig(), party, inventory, new Item("Riot Shield", "Activates Riposte on one character.", 0.0,
                0.0, 0, 1.0, 1.0, 0, false, StatusEffect.RIPOSTE, 1, "one"), false, false, 0, null);
        rooms[1][3] = new NewRoom(selectConfig(), party, inventory, new Item("Combo Meal", "Heals all targets for 50 HP and 20 AP", 0.0, 50.0, 20,
                1.0, 1.0, 0, false, StatusEffect.NONE, 1, "all"), false, false, 0, null);
        rooms[1][4] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        rooms[1][5] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);

        rooms[2][0] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, e3);
        rooms[2][1] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        rooms[2][2] = new NewRoom(configB2, party, inventory, null, true, false, 2, null);
        rooms[2][3] = new NewRoom(selectConfig(), party, inventory, new Item("Tranquilizer", "Heals a character, but Numbs them.", 0.0,
                80, 0, 1.0, 1.0, 0, false, StatusEffect.NUMB, 1, "one"), false, false, 0, null);
        rooms[2][4] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, e0);
        rooms[2][5] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);

        rooms[3][0] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, e1);
        rooms[3][1] = new NewRoom(selectConfig(), party, inventory, new Item("Burger", "Heals 50 AP",
                0.0, 0.0, 50, 1.0, 1.0, 0, false, StatusEffect.NONE, 0, "one"), false, false, 0, null);
        rooms[3][2] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        rooms[3][3] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        rooms[3][4] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, e4);
        rooms[3][5] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);

        rooms[4][0] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        rooms[4][1] = new NewRoom(selectConfig(), party, inventory, new Item("Energy Drink", "Permanently increases Speed this battle.", 0.0,
                0.0, 0, 1.0, 1.0, 2, false, StatusEffect.NONE, 1, "one"), false, false, 0, null);
        rooms[4][2] = new NewRoom(configB3, party, inventory, null, true, false, 3, null);
        rooms[4][3] = new NewRoom(selectConfig(), party, inventory, null, returnRandom1to2(), false, 0, null);
        rooms[4][4] = new NewRoom(selectConfig(), party, inventory, null, false, false, 0, e2);
        rooms[4][5] = new NewRoom(selectConfig(), party, inventory, new Item("Pepper Spray", "Damages and debuffs all targets", 40.0,
                0.0, 0, -0.2, 0.5, -1, false, StatusEffect.BURNED, 2, "all"), false, false, 0, null);

    }
}
