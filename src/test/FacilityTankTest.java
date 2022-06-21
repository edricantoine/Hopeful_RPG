package test;

import model.enemies.Facility.FacilityTank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FacilityTankTest {
    private FacilityTank roach;

    @BeforeEach
    public void setUp() {
        roach = new FacilityTank();
    }

    @Test
    public void testCheckAndRevive() {
        roach.takeDamage(1);
        assertFalse(roach.getHasRevived());
        assertEquals(roach.getSkills().size(), 2);
        roach.takeDamage(roach.getMaxhp());
        assertTrue(roach.getHasRevived());
        assertEquals(roach.getSkills().size(), 3);
        roach.takeDamage(roach.getMaxhp());
        assertTrue(roach.getDead());
    }
}
