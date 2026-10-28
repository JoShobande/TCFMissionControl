package com.tcfmissioncontrol.TCFMissionControl;

public class PracticeScore {
	private String skill;
	private int score;

	public PracticeScore(String skill, int score) {
	    this.skill = skill;
	    this.score = score;
	}
	
	public String getSkill() {
	    return skill;
	}

	public int getScore() {
	    return score;
	}
	
	@Override
	public String toString() {
	    return "Skill: " + skill + "\nScore: " + score;
	}

}
