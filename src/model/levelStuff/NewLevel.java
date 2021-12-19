package model.levelStuff;

import java.awt.*;

public class NewLevel {
    private String name;
    private NewRoom[][] rooms;
    private int rs;
    private int cs;
    private Color color;
    private Boolean boss1dead;
    private Boolean boss2dead;
    private Boolean boss3dead;
    private Boolean complete;


    public NewLevel(String name, NewRoom[][] rooms, Color c) {
        this.name = name;
        this.rooms = rooms;
        this.rs = rooms.length;
        this.cs = rooms[0].length;
        this.color = c;
        boss1dead = false;
        boss2dead = false;
        boss3dead = false;
        complete = false;

    }

    public Boolean getBoss1dead() {
        return boss1dead;
    }

    public Boolean getBoss3dead() {
        return boss3dead;
    }

    public Boolean getBoss2dead() {
        return boss2dead;
    }

    public void kill1Boss() {
        boss1dead = true;
        if (boss1dead && boss2dead && boss3dead) {
            complete = true;
        }
    }
    public void kill2Boss() {
        boss2dead = true;
        if (boss1dead && boss2dead && boss3dead) {
            complete = true;
        }
    }
    public void kill3Boss() {
        boss3dead = true;
        if (boss1dead && boss2dead && boss3dead) {
            complete = true;
        }
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
