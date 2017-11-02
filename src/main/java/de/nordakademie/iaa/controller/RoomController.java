package de.nordakademie.iaa.controller;


import de.nordakademie.iaa.model.Room;
import de.nordakademie.iaa.service.RoomService;
import de.nordakademie.iaa.service.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Transactional
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * List all rooms.
     *
     * @return the list of rooms.
     */
    @GetMapping
    public List<Room> listRooms() {
        return roomService.listRooms();
    }

    /**
     * Saves the given room (either by creating a new one or updating an existing).
     *
     * @param room The room to save.
     */
    @PostMapping
    public ResponseEntity saveRoom(@RequestBody Room room) {
        try {
            roomService.saveRoom(room);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Deletes the room with given id.
     *
     * @param id The id of the room to be deleted.
     */
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity deleteRoom(@PathVariable Long id) {
        try {
            roomService.deleteRoom(id);
            return ResponseEntity.ok(null);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
