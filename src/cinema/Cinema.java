package cinema;


import java.util.*;


public class Cinema {
    private int total_rows;
    private int total_columns;
    private List<Seat> available_seats;

    public Cinema(int rows, int columns) {
        this.total_rows = rows;
        this.total_columns = columns;
        this.available_seats = new ArrayList<>();
        for (int i = 1; i < total_rows + 1; i++) {
            for (int j = 1; j < total_columns + 1; j++) {
                available_seats.add(new Seat(i, j));
            }
        }
    }

    public int getTotal_rows() {
        return total_rows;
    }
    public int getTotal_columns() {
        return total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }
}
