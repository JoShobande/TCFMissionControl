package com.tcfmissioncontrol.TCFMissionControl;

public class SpeakingSession extends StudySession {

	public SpeakingSession(int id, String date, int duration, String notes) {
		super(id, date, duration, notes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSkill() {
		// TODO Auto-generated method stub
		return "Speaking";
	}

}
