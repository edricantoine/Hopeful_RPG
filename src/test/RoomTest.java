package test;

import model.Char;
import model.Item;
import model.PlayerCharacter;
import model.StatusEffect;
import model.enemies.Enemy;
import model.levelStuff.NewRoom;
import model.levelStuff.RoomEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    private Enemy e1;
    private Enemy e2;
    private PlayerCharacter p1;
    private PlayerCharacter p2;
    private NewRoom r;
    private List<PlayerCharacter> party;
    private List<Enemy> ens;

    @BeforeEach
    public void setUp() {
        party = new ArrayList<>();
        ens = new ArrayList<>();
        e1 = new Enemy("Joe", 100, 100, new ArrayList<>(), 3, "It's Joe.", " enters.",
                " dies.");
        e2 = new Enemy("Jim", 100, 100, new ArrayList<>(), 6, "It's Jim.", " enters.",
                " dies.");

        p1 = new PlayerCharacter("John", 100, 100, new ArrayList<>(), 4,
                "Test", new ArrayList<>(), new ArrayList<>());

        p2 = new PlayerCharacter("Sally", 100, 100, new ArrayList<>(), 5, "Test",
                new ArrayList<>(), new ArrayList<>());

        party.add(p1);
        party.add(p2);


        ens.add(e1);
        ens.add(e2);

    }

    @Test
    public void testGetters() {
        r = new NewRoom(ens, party, new ArrayList<>(), null, false, false, 0, null);
        assertNull(r.getEvent());
        assertEquals(0, r.getWhichBoss());
        assertNull(r.getItem());
        assertFalse(r.getHasBattle());
        assertFalse(r.getFinalRoom());
        assertTrue(r.canPickUpItem());
        List<Item> i = r.getInventory();
        assertEquals(0, i.size());
    }

    @Test
    public void testAllChars() {
        r = new NewRoom(ens, party, new ArrayList<>(), null, false, false, 0, null);
        List<Char> chars = r.getAllChars();
        assertEquals(chars.size(), 4);
        assertEquals(chars.get(0), e2);
        assertEquals(chars.get(1), p2);
        assertEquals(chars.get(2), p1);
        assertEquals(chars.get(3), e1);
    }

    @Test
    public void testSetters() {
        RoomEvent e;
        Item i;
        List<Item> inv = new ArrayList<>();

        e = new RoomEvent(0, 0, 0, 0, 0, 0, StatusEffect.NONE, 0, "one", ".");
        i = new Item(". ", ".", 0, 0, 0, 0, 0, false, StatusEffect.NONE, 0, ".");
        inv.add(i);
        r = new NewRoom(ens, party, inv, i, false, false, 0, e);

        assertEquals(r.getParty().size(), 2);
        assertEquals(r.getEnemies().size(), 2);

        assertEquals(r.getInventory().size(), 1);
        r.removeFromInventory(i);
        assertEquals(r.getInventory().size(), 0);

        assertNotNull(r.getItem());
        r.setItemNull();
        assertNull(r.getItem());

        assertNotNull(r.getEvent());
        r.useEvent();
        assertNull(r.getEvent());

    }

    @Test
    public void testRoomWon() {
        r = new NewRoom(ens, party, new ArrayList<>(), null, false, false, 0, null);
        assertFalse(r.isBattleWon());
        for(Enemy e : ens) {
            e.kill();
        }

        assertTrue(r.isBattleWon());
    }

    @Test
    public void testRoomLost() {
        r = new NewRoom(ens, party, new ArrayList<>(), null, false, false, 0, null);
        assertFalse(r.isBattleLost());
        for(PlayerCharacter p : party) {
            p.kill();
        }

        assertTrue(r.isBattleLost());
    }
}
