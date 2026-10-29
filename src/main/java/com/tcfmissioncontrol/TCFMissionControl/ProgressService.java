package com.tcfmissioncontrol.TCFMissionControl;

public class ProgressService {
	private StudyService studyService;
	private ScoreService scoreService;
	private String[] skills = {
		    "Reading",
		    "Listening",
		    "Speaking",
		    "Writing"
	};

	public ProgressService(
	        StudyService studyService,
	        ScoreService scoreService
	) {
	    this.studyService = studyService;
	    this.scoreService = scoreService;
	}
	
	public String getStrongestSkill() {
	    String strongestSkill = null;
	    double highestAverage = -1;

	    for (String skill : skills) {
	        double average = scoreService.getAverageScore(skill);

	        if (average > highestAverage) {
	            highestAverage = average;
	            strongestSkill = skill;
	        }
	    }

	    return strongestSkill;
	}
	
	public String getWeakestSkill() {
	    String weakestSkill = null;
	    double lowestAverage = Double.MAX_VALUE;

	    for (String skill : skills) {
	        double average = scoreService.getAverageScore(skill);

	        if (average < lowestAverage) {
	            lowestAverage = average;
	            weakestSkill = skill;
	        }
	    }

	    return weakestSkill;
	}
	
	public void viewProgressReport() {
	    System.out.println("\n==============================");
	    System.out.println("       PROGRESS REPORT");
	    System.out.println("==============================");

	    System.out.println("Total Study Sessions: "
	            + studyService.getTotalSessions());

	    System.out.println("Total Study Time: "
	            + studyService.getTotalStudyTime()
	            + " minutes");

	    System.out.println();

	    System.out.println("Reading Average: "
	            + scoreService.getAverageScore("Reading"));

	    System.out.println("Listening Average: "
	            + scoreService.getAverageScore("Listening"));

	    System.out.println("Speaking Average: "
	            + scoreService.getAverageScore("Speaking"));

	    System.out.println("Writing Average: "
	            + scoreService.getAverageScore("Writing"));

	    System.out.println();

	    System.out.println("Strongest Skill: "
	            + getStrongestSkill());

	    System.out.println("Weakest Skill: "
	            + getWeakestSkill());

	    System.out.println("==============================");
	}

}
