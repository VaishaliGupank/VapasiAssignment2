package com.thoughtworks.vapasi;

import java.util.ArrayList;
import java.util.List;

public class AttendeesInSessionRepository {

    ParticipantRepository participantRepo;
    SessionRepository sessionRepo;
    public AttendeesInSessionRepository(ParticipantRepository participantRepo, SessionRepository sessionRepo)
    {
        this.participantRepo = participantRepo;
        this.sessionRepo = sessionRepo;
    }
    private List<AttendeesInSession> attendeesRepository = new ArrayList<>();

    public void addAttendeesInList(AttendeesInSession attendee)
    {
        attendeesRepository.add(attendee);
    }

    public List<Participant> getListOfParticipantForASession(int sessionId)
    {
        List<Participant> participantsInASession = new ArrayList<Participant>();
        for(int i=0; i<attendeesRepository.size(); i++)
        {
            if(attendeesRepository.get(i).session == sessionId)
                participantsInASession.add(participantRepo.getParticipantDetailsById(attendeesRepository.get(i).participant));

        }

        return participantsInASession;
    }

    public List<Session> getAttendedSessionsForAParticipant(int participantId)
    {
        List<Session> attendedSessionsForAParticipant = new ArrayList<Session>();
        for(int i=0; i<attendeesRepository.size(); i++)
        {
            if(attendeesRepository.get(i).participant == participantId)
                attendedSessionsForAParticipant.add(sessionRepo.getSessionDetailsById(attendeesRepository.get(i).session));

        }
        return attendedSessionsForAParticipant;
    }
}

