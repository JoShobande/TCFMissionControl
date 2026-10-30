package com.tcfmissioncontrol.TCFMissionControl;

import java.util.ArrayList;


public class StudyService {
	private ArrayList<StudySession> sessions = new ArrayList<>();

	public StudyService() {
		
	}
	
	public void addSession(StudySession session) throws DuplicateSessionIdException {

	    validateUniqueSessionId(session.getId());

	    sessions.add(session);
	}
	
	public void validateUniqueSessionId(int id) throws DuplicateSessionIdException {

	    if (sessionIdExists(id)) {
	        throw new DuplicateSessionIdException(
	                "A session with ID " + id + " already exists."
	        );
	    }
	}
	
	public void viewSessions() {
		if (sessions.isEmpty()) {
	        System.out.println("No study sessions found.");
	        return;
	    }
	    for (StudySession session : sessions) {
	        System.out.println(session);
	        System.out.println("--------------------");
	    }
	    
//	    for(int i =0; i<sessions.size(); i++) {
//	    	 System.out.println(sessions.get(i));
//		        System.out.println("--------------------");
//	    }
	}
	public StudySession findSessionById(int id) {
	    for (StudySession session : sessions) {
	        if (session.getId() == id) {
	            return session;
	        }
	    }

	    return null;
	}
	
	public boolean sessionIdExists(int id) {
	    return findSessionById(id) != null;
	}
	
//	public boolean updateSession(
//	        int id,
//	        String newDate,
//	        int newDuration,
//	        String newNotes
//	) {
//	    StudySession session = findSessionById(id);
//
//	    if (session == null) {
//	        return false;
//	    }
//
////	    session.setSkill(newSkill);
//	    session.setDate(newDate);
//	    session.setDuration(newDuration);
//	    session.setNotes(newNotes);
//
//	    return true;
//	}
//	public boolean updateSessionDate(int id, String newDate) {
//
//	    StudySession session = findSessionById(id);
//
//	    if (session == null) {
//	        return false;
//	    }
//
//	    session.setDate(newDate);
//	    return true;
//	}
	
//	public boolean updateSessionDuration(int id, int newDuration) {
//
//	    StudySession session = findSessionById(id);
//
//	    if (session == null) {
//	        return false;
//	    }
//
//	    session.setDuration(newDuration);
//	    return true;
//	}
	
//	public boolean updateSessionNotes(int id, String newNotes) {
//
//	    StudySession session = findSessionById(id);
//
//	    if (session == null) {
//	        return false;
//	    }
//
//	    session.setNotes(newNotes);
//	    return true;
//	}
	
	public boolean deleteSession(int id) {
	    StudySession session = findSessionById(id);

	    if (session == null) {
	        return false;
	    }

	    sessions.remove(session);
	    return true;
	}
	
	public int getTotalSessions() {
	    return sessions.size();
	}
	
	public int getTotalStudyTime() {
	    int totalMinutes = 0;

	    for (StudySession session : sessions) {
	        totalMinutes += session.getDuration();
	    }

	    return totalMinutes;
	}

}
