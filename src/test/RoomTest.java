package test;

import model.Char;
import model.PlayerCharacter;
import model.enemies.Enemy;
import model.levelStuff.Room;
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
    private Room r;
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
    public void testAllChars() {
        r = new Room(ens, party, new ArrayList<>(), null,null);
        List<Char> chars = r.getAllChars();
        assertEquals(chars.size(), 4);
        assertEquals(chars.get(0), e2);
        assertEquals(chars.get(1), p2);
        assertEquals(chars.get(2), p1);
        assertEquals(chars.get(3), e1);
    }
}
