package model;

import java.util.List;

public class Plan {

    String selected ;
    List<Activity> activityList;
    List<Leg> legList;

    public Plan() {
    }

    @Override
    public String toString() {
        return activityList.toString();
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public List<Leg> getLegList() {
        return legList;
    }

    public void setLegList(List<Leg> legList) {
        this.legList = legList;
    }
}
