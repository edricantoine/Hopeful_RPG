package model.levelStuff;

import java.awt.*;

public class NewLevel {
    private String name;
    private NewRoom[][] rooms;
    private int rs;
    private int cs;
    private Color color;

    public NewLevel(String name, NewRoom[][] rooms, Color c) {
        this.name = name;
        this.rooms = rooms;
        this.rs = rooms.length;
        this.cs = rooms[0].length;
        this.color = c;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewRoom[][] getRooms() {
        return rooms;
    }

    public void setRooms(NewRoom[][] rooms) {
        this.rooms = rooms;
    }

    public int getRs() {
        return rs;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }

    public int getCs() {
        return cs;
    }

    public void setCs(int cs) {
        this.cs = cs;
    }
}
