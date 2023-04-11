package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static cinema.ErrorMSG.*;

@Service
public class CinemaService {
    private Cinema cinema = new Cinema(9,9);
    public Cinema getAvailibleSeats() {
        return cinema;
    }
    public ResponseEntity<Map<String, Object>> purchaseSeat(@RequestBody SeatRequest seatRequest) {
        Seat seat = new Seat (seatRequest.getRow(), seatRequest.getColumn());

        boolean success = cinema.purchaseSeat(seat);

        if (success) {
            String token = UUID.randomUUID().toString();
            Ticket ticket = new Ticket(seat, token);
            cinema.addToFilledSeats(ticket);
            Map<String, Object> result = new HashMap<>();
            result.put("token", ticket.getToken());
            result.put("ticket", ticket.getSeat());
            return ResponseEntity.ok(result);
        }

        else {
            if (seat.getRow() > cinema.getTotalRows() || seat.getRow() < 1 || seat.getColumn() > cinema.getTotalColumns() || seat.getColumn() < 1) {
                return new ResponseEntity<>(Map.of("error", OUT_OF_BOUNDS_ERROR.toString()), HttpStatus.BAD_REQUEST);
            }
            else if (!cinema.getAvailableSeats().contains(seat)) {
                return new ResponseEntity<>(Map.of("error", ALREADY_PURCHASED_ERROR.toString()), HttpStatus.BAD_REQUEST);
            }
        }
        return null;
    }
    public ResponseEntity<Map<String, Object>> refundSeat(@RequestBody Ticket ticket) {
        String token = ticket.getToken();
        Ticket returnedTicket = null;

        for (Ticket filledTicket : cinema.getFilledTickets()) {
            if (filledTicket.getToken().equals(token)) {
                returnedTicket = filledTicket;
            }
        }
        try {
            cinema.addSeat(returnedTicket.getSeat());
            cinema.removeFromFilledSeats(returnedTicket);
            return ResponseEntity.ok(Map.of("returned_ticket", returnedTicket.getSeat()));
        } catch (NullPointerException e){
            return new ResponseEntity<>(Map.of("error", WRONG_TOKEN_ERROR.toString()), HttpStatus.BAD_REQUEST);
        }
    }
}
