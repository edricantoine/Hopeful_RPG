package test;

import model.PlayerCharacter;
import model.StatusEffect;
import model.levelStuff.RoomEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {
    private PlayerCharacter p1;
    private PlayerCharacter p2;
    private PlayerCharacter p3;

    private RoomEvent eGain;
    private RoomEvent eLoss;
    private RoomEvent eStatus;

    private RoomEvent eAll;

    private List<PlayerCharacter> party;
    private List<PlayerCharacter> solo;

    @BeforeEach
    private void setUp() {
        p1 = new PlayerCharacter("John", 100, 100, new ArrayList<>(), 5,
                "Test", new ArrayList<>(), new ArrayList<>());
        p2 = new PlayerCharacter("Joe", 100, 100, new ArrayList<>(), 5,
                "Test", new ArrayList<>(), new ArrayList<>());
        p3 = new PlayerCharacter("Jim", 100, 100, new ArrayList<>(), 5,
                "Test", new ArrayList<>(), new ArrayList<>());

        eGain = new RoomEvent(0, 10.0, 10, 0, 0.5, 0.5, StatusEffect.NONE, 1,
                "one", "A HAPPY event");
        eLoss = new RoomEvent(10.0, 0, 0, 10, -0.5, -0.5, StatusEffect.NONE, -1,
                "one", "A SAD event");
        eStatus = new RoomEvent(0, 0, 0, 10, 1.0, 1.0, StatusEffect.BURNED, 0,
                "one", "A HOT event");
        eAll = new RoomEvent(10, 0, 0, 10, 1.0, 1.0, StatusEffect.NONE, 0, "all",
                "A WIDE event");
        party = new ArrayList<>();
        solo = new ArrayList<>();

        party.add(p1);
        party.add(p2);
        solo.add(p3);

    }

    @Test
    public void testsoloGain() {
        p3.takeDamage(30);
        p3.useAp(40);
        eGain.takeEffect(solo);
        assertEquals(p3.getHp(), 80);
        assertEquals(p3.getAp(), 70);
        assertEquals(p3.getAtkMod(), 1.5);
        assertEquals(p3.getDefMod(), 1.5);
        assertEquals(p3.getSpeed(), 6);

        p3.setAtkMod(3.99);
        p3.setDefMod(3.99);

        eGain.takeEffect(solo);
        assertEquals(p3.getAtkMod(), 4.0);
        assertEquals(p3.getDefMod(), 4.0);
    }

    @Test
    public void testSoloLoss() {
        eLoss.takeEffect(solo);
        assertEquals(p3.getHp(), 90);
        assertEquals(p3.getAp(), 90);
        assertEquals(p3.getAtkMod(), 0.5);
        assertEquals(p3.getDefMod(), 0.5);
        assertEquals(p3.getSpeed(), 4);

        p3.setAtkMod(0.26);
        p3.setDefMod(0.26);

        eLoss.takeEffect(solo);
        assertEquals(p3.getAtkMod(), 0.25);
        assertEquals(p3.getDefMod(), 0.25);
    }

    @Test
    public void testSoloStatus() {
        eStatus.takeEffect(solo);
        assertEquals(p3.getCurrentStatus(), StatusEffect.BURNED);
    }

    @Test
    public void testAll() {
        assertEquals(p1.getHp(), 100);
        assertEquals(p2.getHp(), 100);
        eAll.takeEffect(party);
        assertEquals(p1.getHp(), 90);
        assertEquals(p2.getHp(), 90);
    }
}
