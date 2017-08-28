package com.thoughtworks.vapasi;

import java.util.Date;

public abstract class Session {
    private String sessionName;
    private String speakerName;
    private Date startTime;
    private Date endTime;
    private int nOfParticipants;
    private int seatsOccupied;

    public Session(String sessionName) {
        this.sessionName = sessionName;
    }

    public void SetSessionName(String sessionName)
    {
        this.sessionName = sessionName;
    }
    public String GetSessionName()
    {
        return sessionName;
    }
    public void SetSpeakerName(String speakerName)
    {
         this.speakerName = speakerName;
    }
    public String GetSpeakerName()
    {
        return speakerName;
    }

    public void SetStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date GetStartTime()
    {
        return startTime;
    }

    public void SetEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date GetEndTime()
    {
        return endTime;
    }

    public void SetNoOfParticipants(int noOfParticipants)
    {
        this.nOfParticipants = noOfParticipants;
    }

    public boolean IsSessionAvailable()
    {
        Date today = new Date();
        if(startTime.compareTo(today) < 0)
            return false;
          return true;
    }

    public boolean AreSeatsAvailable()
    {
        if((nOfParticipants - seatsOccupied) > 0)
            return true;
        return false;
    }

    public void UpdateSeatsAvailable(String status)
    {
        if(status.equals("Register")) {
            if (nOfParticipants > seatsOccupied)
                seatsOccupied = seatsOccupied + 1;
        }
        else
        {
            if(status.equals("Cancel"))
            {
                if(seatsOccupied > 0)
                    seatsOccupied = seatsOccupied - 1;
            }
        }
    }

    public int getAvailableSeats()
    {
        return (nOfParticipants - seatsOccupied);
    }



}
