package com.epam.hackathon2016.event.dao;

import com.epam.hackathon2016.event.domain.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by asavitsky on 9/10/16.
 */
public class EventDaoImpl implements EventDao{

    List<Event> events;
    List<Action> actions;
    List<Survey> surveys;
    List<Group> groups;

    private static int lastEventId = 0;
    private static int lastActionId = 0;
    private static int lastSurveyId = 0;
    private static int lastGroupId = 0;

    public EventDaoImpl() {

    }

    @Override
    public Event getEventById(int id) {
        Iterator<Event> iterator= events.iterator();
        while(iterator.hasNext()) {
            Event event=iterator.next();
                if (event.getEventId() == id)
                    return event;
        }
        return null;
    }

    @Override
    public int createEvent(Event event) {
        ++lastEventId;
        event.setEventId(lastEventId);
        events.add(event);
        return lastEventId;
    }

    @Override
    public List<Event> getAllEvents() {
        return events;
    }

    @Override
    public boolean updateEvent(Event event) {
        return false;
    }

    @Override
    public Action getActionById(int id) {
        Iterator<Action> iterator= actions.iterator();
        while(iterator.hasNext()) {
            Action action=iterator.next();
            if (action.getActionId() == id)
                return action;
        }
        return null;
    }

    @Override
    public int createAction(Action action) {
        ++lastActionId;
        action.setActionId(lastActionId);
        actions.add(action);
        return lastActionId;
    }

    @Override
    public List<Action> getAllActions() {
        return actions;
    }

    @Override
    public boolean updateAction(Action action) {
        return false;
    }

    @Override
    public Survey getSurveyById(int id) {
        Iterator<Survey> iterator= surveys.iterator();
        while(iterator.hasNext()) {
            Survey survey=iterator.next();
            if (survey.getSurveyId() == id)
                return survey;
        }
        return null;
    }

    @Override
    public int createSurvey(Survey survey) {
        ++lastSurveyId;
        survey.setSurveyId(lastSurveyId);
        surveys.add(survey);
        return lastSurveyId;
    }


    @Override
    public List<Survey> getAllSurveys() {
        return surveys;
    }

    @Override
    public boolean updateSurvey(Survey survey) {
        return false;
    }

    @Override
    public Group getGroupById(int id) {
        Iterator<Group> iterator= groups.iterator();
        while(iterator.hasNext()) {
            Group group=iterator.next();
            if (group.getGroupId() == id)
                return group;
        }
        return null;
    }

    @Override
    public int createGroup(Group group) {
        ++lastGroupId;
        group.setGroupId(lastGroupId);
        groups.add(group);
        return lastGroupId;
    }

    @Override
    public List<Group> getAllGroups() {
        return groups;
    }

    @Override
    public boolean updateGroup(Group group) {
        return false;
    }
}
