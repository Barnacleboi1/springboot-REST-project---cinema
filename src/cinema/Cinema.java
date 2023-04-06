package cinema;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;


public class Cinema {
    private int totalRows;
    private int totalColumns;
    private List<Seat> availableSeats;

    public Cinema(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;
        this.availableSeats = new ArrayList<>();
        for (int i = 1; i < totalRows + 1; i++) {
            for (int j = 1; j < totalColumns + 1; j++) {
                availableSeats.add(new Seat(i, j));
            }
        }
    }
    public boolean purchaseSeat(Seat seat) {

        if (availableSeats.contains(seat)) {
            availableSeats.remove(seat);
            return true;
        } else {
            return false;
        }
    }
    public int getTotalRows() {
        return totalRows;
    }
    public int getTotalColumns() {
        return totalColumns;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }
}
