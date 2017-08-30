package com.thoughtworks.vapasi;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    Conference _confManager;
    AttendeesInSessionRepository attendeesInSessionRepository;

    public Registration(Conference _conf, AttendeesInSessionRepository repo)
    {
        this._confManager = _conf;
        this.attendeesInSessionRepository = repo;
    }

    public void Register(Participant participant, Session session)
    {
        if(session.IsSessionAvailable() && session.AreSeatsAvailable())
        {
            attendeesInSessionRepository.addAttendeesInList(new AttendeesInSession(participant.getParticipantId(),session.getSessionId()));
            session.UpdateSeatsAvailable("Register");
        }
    }

    public void CancelRegistration(Participant participant,Session session)
    {


    }

}
