package de.nordakademie.iaa.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

/**
 * Room entity.
 *
 * @author Arvid Ottenberg
 */
@Entity
public class Room extends HasTransientFullName implements Serializable {

    private String building;
    private String number;
    private int maxSeats;
    private RoomType roomType;

    public Room() {
    }

    public Room(int minChangeoverTime, String building, int maxSeats, String number, RoomType roomType) {
        super(minChangeoverTime);
        this.building = building;
        this.maxSeats = maxSeats;
        this.number = number;
        this.roomType = roomType;
    }

    @NaturalId
    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    @NaturalId
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    public int getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(int maxSeats) {
        this.maxSeats = maxSeats;
    }

    @Enumerated(EnumType.STRING)
    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String getFullName() {
        return building + number;
    }

    @Override
    public String toString() {
        return "Raum " + building + number + " (" + maxSeats + " Sitzplätze, " + roomType.getTranslation() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        if (!building.equals(room.building)) return false;
        return number.equals(room.number);
    }

    @Override
    public int hashCode() {
        int result = building.hashCode();
        result = 31 * result + number.hashCode();
        return result;
    }
}