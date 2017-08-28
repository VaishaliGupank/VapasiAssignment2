package com.thoughtworks.vapasi;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public abstract class Conference {
    private String conferenceName;
    int noOfDays;
    String organizerName;
    String sponsoredBy;
    Date startDate;
    Date endDate;
    String venue;
    List<Session> sessions = new ArrayList<Session>();

    public Conference(String conferenceName)
    {
        this.conferenceName = conferenceName;
    }

    public void SetNoOfDays(int noOfDays)
    {
        this.noOfDays = noOfDays;
    }

    public int GetNoOfDays(int noOfDays)
    {
        return this.noOfDays;
    }

    public void SetOrganizerName(String organizerName)
    {
        this.organizerName = organizerName;
    }

    public String GetOrganizerName()
    {
        return this.organizerName;
    }

    public void SetSponsoredBy(String sponsoredBy)
    {
        this.sponsoredBy = sponsoredBy;
    }

    public String GetSponsoredBy()
    {
        return this.sponsoredBy;
    }

    public void SetStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date GetStartDate()
    {
        return this.startDate;
    }
    public void SetEndDate(Date endDate)
    {
        this.endDate = startDate;
    }
    public Date GetEndDate()
    {
        return this.endDate;
    }

    public List<String> getAvailableSessions()
    {
        List<String> sessionsAvailable = new ArrayList<String>();

        for(int i=0; i<sessions.size(); i++)
        {
            if(sessions.get(i).IsSessionAvailable())
                sessionsAvailable.add(sessions.get(i).GetSessionName());
        }

       return  sessionsAvailable;
    }
}
