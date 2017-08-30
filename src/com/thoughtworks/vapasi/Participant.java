package com.thoughtworks.vapasi;

public class Participant {
    private int participantId;
    String firstName;
    String lastName;
    Address address;


    public Participant(ParticipantRepository participantRepo)
    {
        this.participantId = participantRepo.getParticipantId();
    }

    public String getFullName()
    {
        return firstName + " " + lastName;
    }

    public int getParticipantId()
    {
        return (this.participantId );
    }


}
