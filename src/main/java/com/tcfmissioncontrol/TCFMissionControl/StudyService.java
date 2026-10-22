package com.tcfmissioncontrol.TCFMissionControl;

import java.util.ArrayList;


public class StudyService {
	private ArrayList<StudySession> sessions = new ArrayList<>();

	public StudyService() {
		
	}
	
	public void addSession(StudySession session) {
	    sessions.add(session);
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
	
	public boolean updateSession(
	        int id,
	        String newSkill,
	        String newDate,
	        int newDuration,
	        String newNotes
	) {
	    StudySession session = findSessionById(id);

	    if (session == null) {
	        return false;
	    }

	    session.setSkill(newSkill);
	    session.setDate(newDate);
	    session.setDuration(newDuration);
	    session.setNotes(newNotes);

	    return true;
	}
	
	public boolean deleteSession(int id) {
	    StudySession session = findSessionById(id);

	    if (session == null) {
	        return false;
	    }

	    sessions.remove(session);
	    return true;
	}

}
