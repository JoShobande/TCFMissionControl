package com.tcfmissioncontrol.TCFMissionControl;

public class WritingSession extends StudySession {

	public WritingSession(int id, String date, int duration, String notes) {
		super(id, date, duration, notes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSkill() {
		// TODO Auto-generated method stub
		return "Writing";
	}

}
