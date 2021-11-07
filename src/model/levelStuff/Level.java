package model.levelStuff;

import java.util.List;

public class Level {
    private String name;
    private List<Room> rooms;

    public Level(String name, List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }
}
