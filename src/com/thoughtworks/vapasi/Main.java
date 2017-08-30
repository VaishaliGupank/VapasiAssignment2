package com.thoughtworks.vapasi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        /* Getting handles to get access to data */
        SessionRepository sessionRepo = new SessionRepository();
        ParticipantRepository participantRepo = new ParticipantRepository();
        AttendeesInSessionRepository attendeesInSessionRepository = new AttendeesInSessionRepository(participantRepo,sessionRepo);


        /* Instantiating Conference class */
        Conference conference = new GetWomenBackToWork("GetWomenBackToWork",sessionRepo);

        /* Instantiating Registration class */
        Registration registration = new Registration(conference,attendeesInSessionRepository);

        /* Display list of sessions running in the conference */
        List<String> sessions = registration._confManager.sessionRepository.getAvailableSessions();
        for(int i=0; i< sessions.size(); i++)
            System.out.println(sessions.get(i));


        /* Partcipant Registration */
        Participant participant1 = new Participant(participantRepo);
        participant1.firstName = "Vaishali";
        participant1.lastName = "Purwar";
        participantRepo.AddParticipant(participant1);
        registration.Register(participant1,sessionRepo.getSessionDetailsByName("Vapasi OOPs Session"));

        Participant participant2 = new Participant(participantRepo);
        participant2.firstName = "Varun";
        participant2.lastName = "Purwar";
        participantRepo.AddParticipant(participant2);
        registration.Register(participant2,sessionRepo.getSessionDetailsByName("Vapasi OOPs Session"));


        /*  Get attended sessions for a participant */

        List<Session> attendedSessionsForAParticipant = attendeesInSessionRepository.getAttendedSessionsForAParticipant(1);
        System.out.println("List of attended sessions for a Participant ---  " + attendeesInSessionRepository.participantRepo.getParticipantDetailsById(1).getFullName());
        for(int i=0; i< attendedSessionsForAParticipant.size(); i++) {
            System.out.println(attendedSessionsForAParticipant.get(i).GetSessionName());
        }

        /* Get list of participants for a session */
        System.out.println("List of Participants for Session ---  " + conference.sessionRepository.getSessionDetailsById(1).GetSessionName());
        List<Participant> getListOfParticipantForASession = attendeesInSessionRepository.getListOfParticipantForASession(1);
        for(int i=0; i< getListOfParticipantForASession.size(); i++) {
            if(getListOfParticipantForASession.get(i) != null)
            System.out.println(getListOfParticipantForASession.get(i).getFullName());
        }


    }


}



//Read about factory pattern
//Repository pattern
//MVC Pattern
