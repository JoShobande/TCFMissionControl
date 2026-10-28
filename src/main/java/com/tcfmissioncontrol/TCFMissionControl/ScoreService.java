package com.tcfmissioncontrol.TCFMissionControl;

import java.util.ArrayList;

public class ScoreService {

    private ArrayList<PracticeScore> scores = new ArrayList<>();
    
    public void addScore(PracticeScore score) {
        scores.add(score);
    }
    
    public void viewScores() {
        if (scores.isEmpty()) {
            System.out.println("No practice scores recorded.");
            return;
        }

        for (PracticeScore score : scores) {
            System.out.println(score);
            System.out.println("--------------------");
        }
    }

}