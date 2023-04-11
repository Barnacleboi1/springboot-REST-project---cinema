package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Map;

@RestController
public class CinemaController {
    Cinema cinema = new Cinema(9, 9);
    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity purchaseSeat(@RequestBody SeatRequest seatRequest) {
        Seat seat = new Seat (seatRequest.getRow(), seatRequest.getColumn());
        boolean success = cinema.purchaseSeat(seat);
        if (success) {
            return ResponseEntity.ok(seat);
        }

        else {
            if (seat.getRow() > cinema.getTotalRows() || seat.getRow() < 1 || seat.getColumn() > cinema.getTotalColumns() || seat.getColumn() < 1) {
                return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
            }
            else if (!cinema.getAvailableSeats().contains(seat)) {
                return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);


            }
        }
        return null;
    }
    /*
    @PostMapping("/purchase")
    public Seat purchaseSeat(@RequestBody Seat seat) {
        boolean success = cinema.purchaseSeat(seat);
        if (success) {
            return seat;
        }
        else {
            if (seat.getRow() > 9 || seat.getRow() < 1 || seat.getColumn() > 9 || seat.getColumn() < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST
                        , "The number of a row or a column is out of bounds!");
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST
                        , "The ticket has been already purchased!");
            }
        }
    }

     */
}


