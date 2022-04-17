package model;

public class Activity {
    private String type;
    private String x;
    private String y;
    private String end_time;

    public Activity() {
    }

    public Activity(String type, String x, String y, String end_time) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.end_time = end_time;
    }

    public Activity(String type, String x, String y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x='" + x + '\'' + ", y='" + y ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
