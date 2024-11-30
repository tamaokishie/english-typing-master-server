package com.tamaokishie.english_typing_master_server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class StageController {

    // クラス変数としてステージ情報を保持
    private final List<Stage> stages = Arrays.asList(
        new Stage(1, "Stage 1", "writing✐", 3 , false),
        new Stage(2, "Stage 2", "listening🎧", 2 , false),
        new Stage(3, "Stage 3", "writing✐", 3 , false),
        new Stage(4, "Stage 4", "listening🎧", 2 , false),
        new Stage(5, "Stage 5", "writing✐", 3 , false),
        new Stage(6, "Stage 6", "listening🎧", 2 , false),
        new Stage(7, "Stage 7", "writing✐", 3, false),
        new Stage(8, "Stage 8", "listening🎧", 2, false)
    );

    @GetMapping("/api/stages")
    public List<Stage> getStages() {
        return stages; // クラス変数から返す
    }

    @PostMapping("/api/stages/{id}/challenge")
    public ResponseEntity<Void> challengeStage(@PathVariable int id) {
        // ステージのisChallengedフラグを更新
        stages.stream()
            .filter(stage -> stage.getId() == id)
            .forEach(stage -> stage.setChallenged(true));
        System.out.println("Stage " + id + " is now challenged!");
        return ResponseEntity.ok().build();
    }

    public static class Stage {
        private int id;
        private String title;
        private String mode;
        private int stars;
        private boolean isChallenged;

        public Stage(int id, String title, String mode, int stars, boolean isChallenged) {
            this.id = id;
            this.title = title;
            this.mode = mode;
            this.stars = stars;
            this.isChallenged = isChallenged;
        }

        // Getters and Setters
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getMode() { return mode; }
        public void setMode(String mode) { this.mode = mode; }
        public int getStars() { return stars; }
        public void setStars(int stars) { this.stars = stars; }
        public boolean isChallenged() { return isChallenged; }
        public void setChallenged(boolean challenged) { isChallenged = challenged; }
    }
}
