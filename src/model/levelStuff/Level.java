package model.levelStuff;

//THIS CLASS WILL BE DELETED.

public class Level {
    private String name;
    private Room rooms;

    public Level(String name, Room rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public Room getRooms() {
        return rooms;
    }
}
