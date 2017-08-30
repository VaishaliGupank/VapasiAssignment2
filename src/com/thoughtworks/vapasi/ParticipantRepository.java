package com.thoughtworks.vapasi;

import java.util.ArrayList;
import java.util.List;

public class ParticipantRepository {

    private List<Participant> participants = new ArrayList<Participant>();



    public void AddParticipant(Participant attendee)
    {
        participants.add(attendee);
    }

    public void RemoveAttendee(Participant attendee)
    {
        participants.remove(attendee);
    }

    public  int getParticipantId()
    {
        if(participants.size() == 0)
            return 1;
        else {
            int max = participants.get(0).getParticipantId();
            for (int i = 1; i < participants.size(); i++) {
                if (max < participants.get(i).getParticipantId())
                    max = participants.get(i).getParticipantId();
            }

            return (max + 1);
        }
    }

    public Participant getParticipantDetailsById(int participantId)
    {
        for(int i=0; i<participants.size(); i++ )
        {
            if(participants.get(i).getParticipantId() == participantId)
                return participants.get(i);
        }
        return null;
    }
}
