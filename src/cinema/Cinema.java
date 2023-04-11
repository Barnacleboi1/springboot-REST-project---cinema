package cinema;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.*;


public class Cinema {
    private int totalRows;
    private int totalColumns;
    private List<Seat> availableSeats;
    @JsonIgnore
    private List<Ticket> filledTickets;

    public Cinema(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;
        this.availableSeats = new ArrayList<>();
        for (int i = 1; i < totalRows + 1; i++) {
            for (int j = 1; j < totalColumns + 1; j++) {
                availableSeats.add(new Seat(i, j));
            }
        }
        this.filledTickets = new ArrayList<>();
    }
    public void removeSeat(Seat seat) {
        availableSeats.remove(seat);
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
    public List<Ticket> getFilledTickets() {
        return filledTickets;
    }
    public void addToFilledSeats(Ticket ticket) {
        filledTickets.add(ticket);
    }
    public void removeFromFilledSeats(Ticket ticket) {
        filledTickets.remove(ticket);
    }
    public void addSeat(Seat seat) {
        availableSeats.add(seat);
    }
}
