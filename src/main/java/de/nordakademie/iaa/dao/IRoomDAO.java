package de.nordakademie.iaa.dao;

import de.nordakademie.iaa.model.Room;
import de.nordakademie.iaa.model.RoomType;

import java.util.List;

/**
 * Created by arvid on 18.10.17.
 */

public interface IRoomDAO {
    Room findRoomByBuildingAndNumber(String building, int number);
    List<Room> findRoomsByType(RoomType type);
}