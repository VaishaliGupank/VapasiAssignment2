package com.thoughtworks.vapasi;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SessionRepository {
    private List<Session> sessions = new ArrayList<Session>();

    public SessionRepository()
    {
        populateSessions();
    }

    public void AddSessions(Session session)
    {
        sessions.add(session);
    }

    public void RemoveSessions(Session session)
    {
        sessions.remove(session);
    }

    public  int getSessionId()
    {
        if(sessions.size() == 0)
            return 1;
        else {
            int max = sessions.get(0).getSessionId();
            for (int i = 1; i < sessions.size(); i++) {
                if (max < sessions.get(i).getSessionId())
                    max = sessions.get(i).getSessionId();
            }

            return (max + 1);
        }
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

    public Session getSessionDetailsById(int sessionId)
    {
        for(int i=0; i<sessions.size(); i++)
        {
            if(sessions.get(i).getSessionId() == sessionId)
               return sessions.get(i);
        }
        return null;

    }

    public Session getSessionDetailsByName(String name)
    {
        for(int i=0; i<sessions.size(); i++)
        {
            if(sessions.get(i).GetSessionName() == name)
                return sessions.get(i);
        }
        return null;

    }

    public void populateSessions()
    {
        Session vapasiSession = new VapasiOOPsSession("Vapasi OOPs Session", getSessionId());
        vapasiSession.SetNoOfParticipants(50);
        vapasiSession.SetStartTime(getDate());
        sessions.add(vapasiSession);

        Session solidSessions = new SolidSessions("SOLID Principles",getSessionId());
        solidSessions.SetNoOfParticipants(60);
        solidSessions.SetStartTime(getDate());
        sessions.add(solidSessions);
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
