package com.thoughtworks.vapasi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Registration registration = new Registration();
        GetWomenBackToWork conference = new GetWomenBackToWork("GetWomenBackToWork");

        Session vapasiOOPs = new VapasiOOPsSession("OOps");
        vapasiOOPs.SetNoOfParticipants(50);
        vapasiOOPs.SetSessionName("Vapasi");
        vapasiOOPs.SetStartTime(getDate());
        conference.sessions = new ArrayList<Session>(Arrays.asList(vapasiOOPs));

        System.out.println("Session Name" + "  " + "Seats Available");
        System.out.println(conference.sessions.get(0).GetSessionName() + " " +  conference.sessions.get(0).getAvailableSeats());

        Participant participant1 = new Participant();
        participant1.firstName = "Vaishali";
        participant1.lastName = "Purwar";
        System.out.println("Do registration for participant " + participant1.getFullName());
        registration.Register(participant1,vapasiOOPs);

        System.out.println("Current available seats.");
        System.out.println(vapasiOOPs.getAvailableSeats());
        System.out.println("Attendees of " + vapasiOOPs.GetSessionName());
        registration.ShowAttendees();

        System.out.println("Cancel registration for participant " + participant1.getFullName());
        registration.CancelRegistration(participant1,vapasiOOPs);

        System.out.println("Current seats available ");
        System.out.println(conference.sessions.get(0).getAvailableSeats());

        registration.ShowAttendees();


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
