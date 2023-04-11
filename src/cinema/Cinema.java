package cinema;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;


public class Cinema {
    @JsonProperty
    private int totalRows;
    @JsonProperty
    private int totalColumns;
    @JsonProperty
    private List<Seat> availableSeats;
    @JsonIgnore
    private List<Ticket> filledTickets;
    @JsonIgnore
    private int currentIncome;
    @JsonIgnore
    private int numberOfAvailableSeats;
    @JsonIgnore
    private int numberOfPurchasedTickets;
    @JsonIgnore
    private final String password = "super_secret";

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

    public int getCurrentIncome() {
        int result = 0;
        for (Ticket filledTicket : filledTickets) {
            result += filledTicket.getSeat().getPrice();
        }
        return result;
    }

    public int getNumberOfAvailableSeats() {
        return availableSeats.size();
    }

    public int getNumberOfPurchasedTickets() {
        return filledTickets.size();
    }

    public String getPassword() {
        return password;
    }
}
