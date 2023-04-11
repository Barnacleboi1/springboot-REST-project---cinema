package cinema;

public enum ErrorMSG {
    OUT_OF_BOUNDS_ERROR("The number of a row or a column is out of bounds!"),
    ALREADY_PURCHASED_ERROR("The ticket has been already purchased!"),
    WRONG_TOKEN_ERROR("Wrong token!"),
    WRONG_PASSWORD_ERROR("The password is wrong!");
    private String msg;

    ErrorMSG(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
