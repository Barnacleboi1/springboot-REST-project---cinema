package cinema;


import java.util.*;


public class Cinema {
    private int total_rows;
    private int total_columns;
    private List<Seat> availibleSeats;

    public Cinema(int rows, int columns) {
        this.total_rows = rows;
        this.total_columns = columns;
        this.availibleSeats = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                availibleSeats.add(new Seat(i, j));
            }
        }
    }

    public int getRows() {
        return total_rows;
    }
    public int getColumns() {
        return total_columns;
    }

    public List<Seat> getAvailibleSeats() {
        return availibleSeats;
    }
}
