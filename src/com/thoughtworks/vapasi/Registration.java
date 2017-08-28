package com.thoughtworks.vapasi;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    private List<Participant> attendees = new ArrayList<Participant>();

    public void Register(Participant participant, Session session)
    {
        if(session.IsSessionAvailable() && session.AreSeatsAvailable())
        {
            attendees.add(participant);
            session.UpdateSeatsAvailable("Register");
        }
    }

    public void CancelRegistration(Participant participant,Session session)
    {
        attendees.remove(participant);
        session.UpdateSeatsAvailable("Cancel");

    }

    public void ShowAttendees()
    {
        if(attendees.size() == 0)
            System.out.println("No attendees in the session.");
        for(int i=0; i< attendees.size(); i++)
            System.out.println(attendees.get(i).getFullName());

    }
}
