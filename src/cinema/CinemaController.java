package cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

import static cinema.ErrorMSG.*;

@RestController
public class CinemaController {
    @Autowired
    CinemaService cinemaService = new CinemaService();
    Cinema cinema = new Cinema(9, 9);

    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinemaService.getAvailibleSeats();
    }

    @PostMapping("/purchase")
    public ResponseEntity<Map<String, Object>> purchaseSeat(@RequestBody SeatRequest seatRequest) {
        return cinemaService.purchaseSeat(seatRequest);
    }

    @PostMapping("/return")
    public ResponseEntity<Map<String, Object>> refundSeat(@RequestBody Ticket ticket) {
        return cinemaService.refundSeat(ticket);
    }
}



