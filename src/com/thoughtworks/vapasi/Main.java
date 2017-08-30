package com.thoughtworks.vapasi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here


        SessionRepository sessionRepo = new SessionRepository();
        ParticipantRepository participantRepo = new ParticipantRepository();
        AttendeesInSessionRepository attendeesInSessionRepository = new AttendeesInSessionRepository(participantRepo,sessionRepo);


        Session vapasiSessions = new VapasiOOPsSession("Vapasi OOPs Session",sessionRepo);
        vapasiSessions.SetNoOfParticipants(50);
        vapasiSessions.SetStartTime(getDate());
        sessionRepo.AddSessions(vapasiSessions);


        Session solidSessions = new SolidSessions("SOLID Principles",sessionRepo);
        solidSessions.SetNoOfParticipants(60);
        solidSessions.SetStartTime(getDate());
        sessionRepo.AddSessions(solidSessions);

        Conference conference = new GetWomenBackToWork("GetWomenBackToWork",sessionRepo);

        Registration registration = new Registration(conference,attendeesInSessionRepository);

        List<String> sessions = registration._confManager.sessionRepository.getAvailableSessions();
        for(int i=0; i< sessions.size(); i++)
            System.out.println(sessions.get(i));

        Participant participant1 = new Participant(participantRepo);
        participant1.firstName = "Vaishali";
        participant1.lastName = "Purwar";
        participantRepo.AddParticipant(participant1);
        AttendeesInSession attendee1 = new AttendeesInSession(participant1.getParticipantId(), vapasiSessions.getSessionId());
        registration.Register(participant1,vapasiSessions);

        Participant participant2 = new Participant(participantRepo);
        participant2.firstName = "Varun";
        participant2.lastName = "Purwar";
        participantRepo.AddParticipant(participant2);
        AttendeesInSession attendee2 = new AttendeesInSession(participant2.getParticipantId(), vapasiSessions.getSessionId());
        registration.Register(participant2,vapasiSessions);


        List<Session> attendedSessionsForAParticipant = attendeesInSessionRepository.getAttendedSessionsForAParticipant(1);
        System.out.println("List of attended sessions for a Participant ---  " + attendeesInSessionRepository.participantRepo.getParticipantDetailsById(1).getFullName());
        for(int i=0; i< attendedSessionsForAParticipant.size(); i++) {
            System.out.println(attendedSessionsForAParticipant.get(i).GetSessionName());
        }

        System.out.println("List of Participants for Session ---  " + conference.sessionRepository.getSessionDetailsById(1).GetSessionName());
        List<Participant> getListOfParticipantForASession = attendeesInSessionRepository.getListOfParticipantForASession(1);
        for(int i=0; i< getListOfParticipantForASession.size(); i++) {
            if(getListOfParticipantForASession.get(i) != null)
            System.out.println(getListOfParticipantForASession.get(i).getFullName());
        }


    }

    public static Date getDate()
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 9);
        cal.set(Calendar.DATE, 24);
        cal.set(Calendar.YEAR, 2017);
        cal.set(Calendar.HOUR,13);
        cal.set(Calendar.MINUTE,45);
        cal.set(Calendar.SECOND,52);
        return cal.getTime();
    }
}



//Read about factory pattern
//Repository pattern
//MVC Pattern
