package com.tcfmissioncontrol.TCFMissionControl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreService {

//    private ArrayList<PracticeScore> scores = new ArrayList<>();
	private Map<String, List<Integer>> scores = new HashMap<>();
//	ArrayList<Integer> scoresForSkill = new ArrayList<>();
    
//    public void addScore(PracticeScore score) {
//        scores.add(score);
//    }
	public void addScore(String skill, int score) {
	    if (!scores.containsKey(skill)) {
	        scores.put(skill, new ArrayList<>());
	    }

	    scores.get(skill).add(score);
	}
    
//    public void viewScores() {
//        if (scores.isEmpty()) {
//            System.out.println("No practice scores recorded.");
//            return;
//        }
//
//        for (score : scores) {
//            System.out.println(score);
//            System.out.println("--------------------");
//        }
//    }
	
	public void viewScores() {
	    if (scores.isEmpty()) {
	        System.out.println("No practice scores recorded.");
	        return;
	    }

	    for (Map.Entry<String, List<Integer>> entry : scores.entrySet()) {
	        System.out.println("Skill: " + entry.getKey());
	        System.out.println("Scores: " + entry.getValue());
	        System.out.println("--------------------");
	    }
	}
	
	public double getAverageScore(String skill) {
	    List<Integer> skillScores = scores.get(skill);

	    if (skillScores == null || skillScores.isEmpty()) {
	        return 0;
	    }

	    int total = 0;

	    for (int score : skillScores) {
	        total += score;
	    }

	    return (double) total / skillScores.size();
	}
	
	public void viewAverageScores() {
	    System.out.println("Reading Average: " + getAverageScore("Reading"));
	    System.out.println("Listening Average: " + getAverageScore("Listening"));
	    System.out.println("Speaking Average: " + getAverageScore("Speaking"));
	    System.out.println("Writing Average: " + getAverageScore("Writing"));
	}

}