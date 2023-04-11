package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statistics {
    @JsonProperty
    private int currentIncome;
    @JsonProperty
    private int numberOfAvailableSeats;
    @JsonProperty
    private int numberOfPurchasedTickets;
    private Cinema cinema;

    public Statistics(Cinema cinema) {
       this.cinema = cinema;
       this.currentIncome = cinema.getCurrentIncome();
       this.numberOfAvailableSeats = cinema.getNumberOfAvailableSeats();
       this.numberOfPurchasedTickets = cinema.getNumberOfPurchasedTickets();
    }
}
