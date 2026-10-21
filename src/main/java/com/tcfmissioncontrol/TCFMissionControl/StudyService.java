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

}
