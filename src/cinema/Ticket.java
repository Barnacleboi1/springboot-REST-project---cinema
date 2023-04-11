package cinema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Objects;
import java.util.UUID;

public class Ticket {
    @JsonPropertyOrder({"token", "seat"})
    @JsonProperty
    private String token;
    @JsonProperty
    private Seat seat;
    public Ticket(Seat seat, String token) {
        this.token = token;
        this.seat = seat;
    }
    public Ticket() {}

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(seat, ticket.seat) && Objects.equals(token, ticket.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seat, token);
    }
}
