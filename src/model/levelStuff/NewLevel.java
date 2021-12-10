package model.levelStuff;

public class NewLevel {
    private String name;
    NewRoom[][] rooms;
    int rs;
    int cs;

    public NewLevel(String name, NewRoom[][] rooms) {
        this.name = name;
        this.rooms = rooms;
        this.rs = rooms.length;
        this.cs = rooms[0].length;
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
