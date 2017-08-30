package com.thoughtworks.vapasi;

import java.util.ArrayList;
import java.util.List;

public class SessionRepository {
    private List<Session> sessions = new ArrayList<Session>();



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
}
