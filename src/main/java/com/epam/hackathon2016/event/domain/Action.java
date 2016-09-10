package com.epam.hackathon2016.event.domain;

/**
 * Created by alexander on 10.9.16.
 */
public class Action {
    private int actionId;
    private String actionName;
    private ActionType type;
    private double costPerUser;
    private String actionDescription;
    private int actionRating;

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public double getCostPerUser() {
        return costPerUser;
    }

    public void setCostPerUser(double costPerUser) {
        this.costPerUser = costPerUser;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionDescription() {
        return actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public int getActionRating() {
        return actionRating;
    }

    public void setActionRating(int actionRating) {
        this.actionRating = actionRating;
    }
}
