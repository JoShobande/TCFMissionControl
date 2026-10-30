package com.tcfmissioncontrol.TCFMissionControl;

public class ReadingSession extends StudySession {

	public ReadingSession(int id, String date, int duration, String notes) {
		super(id, date, duration, notes);
	}

	@Override
	public String getSkill() {
	    return "Reading";
	}

}
