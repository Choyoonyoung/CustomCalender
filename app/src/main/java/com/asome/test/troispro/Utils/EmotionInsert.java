package com.asome.test.troispro.Utils;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.net.URL;

public class EmotionInsert extends AsyncTask<String, Void, String> {
    String emotion_state, emotion_who, emotion_story;

    /**
     *
     *  emotion_state : 감정상태(화남, 무표정, 슬픔 등등)
     *  emotion_date : 감정기록 날짜
     *  emotion_who : 감정 유발 대상/원인
     *  emotion_story : 감정 유발 상황
     */
    public EmotionInsert(String emotion_state, String emotion_who, String emotion_story) {
        this.emotion_state = emotion_state;
        this.emotion_who = emotion_who;
        this.emotion_story = emotion_story;
        //감정 상세 정보 포함하여 달력에 감정 상태 기록할 경우
    }
    public EmotionInsert(String emotion_state) {
        this.emotion_state = emotion_state;
        //감정 상세 정보를 응답받지 않고 달력에 감정 상태 기록할 경우
    }
    protected void onPreExcute() {

    }

    /**
     *
     * HTTP 작업 공간
     */

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }
}
