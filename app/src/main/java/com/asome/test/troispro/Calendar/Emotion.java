package com.asome.test.troispro.Calendar;

import java.io.Serializable;

public class Emotion implements Serializable {
    String emotion_state, emotion_date, emotion_who, emotion_story;

    /**
     *
     * @param emotion_state : 감정상태(화남, 무표정, 슬픔 등등)
     * @param emotion_date : 감정기록 날짜
     * @param emotion_who : 감정 유발 대상/원인
     * @param emotion_story : 감정 유발 상황
     */

    public Emotion(String emotion_state, String emotion_date, String emotion_who, String emotion_story){
        this.emotion_state = emotion_state;
        this.emotion_date = emotion_date;
        this.emotion_who = emotion_who;
        this.emotion_story = emotion_story;
    }

    public Emotion(String emotion_state, String emotion_date) {
        this.emotion_state = emotion_state;
        this.emotion_date = emotion_date;
    }

    public String getEmotion_state() {
        return emotion_state;
    }

    public void setEmotion_state(String emotion_state) {
        this.emotion_state = emotion_state;
    }

    public String getEmotion_date() {
        return emotion_date;
    }

    public void setEmotion_date(String emotion_date) {
        this.emotion_date = emotion_date;
    }

    public String getEmotion_who() {
        return emotion_who;
    }

    public void setEmotion_who(String emotion_who) {
        this.emotion_who = emotion_who;
    }

    public String getEmotion_story() {
        return emotion_story;
    }

    public void setEmotion_story(String emotion_story) {
        this.emotion_story = emotion_story;
    }
}