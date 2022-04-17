package model;

public class Leg {

    private String mode;

    public Leg(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "mode='" + mode + '\'' +
                '}';
    }

    public Leg() {
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
