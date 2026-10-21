package com.tcfmissioncontrol.TCFMissionControl;

public class StudySession {

		private int id;
		private String skill;
		private String date;
		private int duration;
		private String notes;
		
		public StudySession(int id, String skill, String date, int duration, String notes) {
		    this.id = id;
		    this.skill = skill;
		    this.date = date;
		    this.duration = duration;
		    this.notes = notes;
		}
		
		public int getId() {
		    return id;
		}

		public String getSkill() {
		    return skill;
		}

		public String getDate() {
		    return date;
		}

		public int getDuration() {
		    return duration;
		}

		public String getNotes() {
		    return notes;
		}
		
		public void setSkill(String skill) {
		    this.skill = skill;
		}

		public void setDate(String date) {
		    this.date = date;
		}

		public void setDuration(int duration) {
		    this.duration = duration;
		}

		public void setNotes(String notes) {
		    this.notes = notes;
		}
		
		@Override
		public String toString() {
		    return "ID: " + id +
		            "\nSkill: " + skill +
		            "\nDate: " + date +
		            "\nDuration: " + duration + " minutes" +
		            "\nNotes: " + notes;
		}
		
		
	

}
