package com.tcfmissioncontrol.TCFMissionControl;

public class ListeningSession extends StudySession {

	public ListeningSession(int id, String date, int duration, String notes) {
		super(id, date, duration, notes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSkill() {
		// TODO Auto-generated method stub
		return "Listening";
	}

}
