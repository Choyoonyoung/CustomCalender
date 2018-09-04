package com.asome.test.troispro.Calendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.asome.test.troispro.R;
import com.riontech.calendar.CustomCalendar;
import com.riontech.calendar.dao.EventData;
import com.riontech.calendar.dao.dataAboutDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CalendarActivity2 extends AppCompatActivity {

    private CustomCalendar customCalendar;
    ArrayList<Emotion> arr_emotion;
    List<String> allDatesString;
    int member_id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar2);
        customCalendar = (CustomCalendar) findViewById(R.id.customCalendar);
        Intent intent = getIntent();
        arr_emotion = (ArrayList<Emotion>) intent.getSerializableExtra("arr_emotion");
        Log.e("calendar", String.valueOf(arr_emotion.size()));

        String[] arr_date = {"2018-08-10", "2018-08-11", "2018-08-12", "2018-09-16", "2018-08-25"};


        //날짜 레인지
        for (int i = 0; i < arr_emotion.size(); i++) {
            member_id=i;
            SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            String date = arr_emotion.get(i).getEmotion_date();
            try {
                Date d = myFormat.parse(date);

                List<Date> allDates = new ArrayList<Date>();//no
                allDatesString = new ArrayList<String>();

                d = addDays(d, 1);
                allDates.add(d);
                allDatesString.add(formatter.format(d));

                insertDate(allDatesString);

                System.out.println("date44 " + allDatesString);
                System.out.println("date44of size  " + allDatesString.size());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


    }
    int eventCount = 1;
    public void insertDate(List<String> dates) {
        for (int i = 0; i < dates.size(); i++) {

            // int index_role = i;
    /*        if(i<3)
                eventCount=i+1;*/
            customCalendar.addAnEvent(dates.get(i), eventCount, getEventDataList(eventCount, member_id));

        }
    }
    EventData dateData;
    ArrayList<dataAboutDate> dataAboutDates;
    public ArrayList<EventData> getEventDataList(int count, int index_emotion) {
        ArrayList<EventData> eventDataList = new ArrayList();

        // for (int i = 0; i < count; i++) {
        dateData = new EventData();
        dataAboutDates = new ArrayList();
//name
        dateData.setSection(arr_emotion.get(index_emotion).getEmotion_state());
        dataAboutDate dataAboutDate = new dataAboutDate();

        // int index = new Random().nextInt(CalendarUtils.getEVENTS().length);

        String emotion = arr_emotion.get(index_emotion).getEmotion_state();
        //String emotion_who = arr_emotion.get(index_who).getEmotion_who();
        //String emotion_story = arr_emotion.get(index_story).getEmotion_story();

        dataAboutDate.setTitle("감정 상태 : 미기록");//default감정 상태
        dataAboutDate.setTitle(emotion);//날짜 선택 시 뜨는 감정 이름

        dataAboutDate.setSubject("감정 상세 정보 : N/A");//default 감정 상세 정보
        //dateAboutDate.setSubject(emotion_who+emotion_story);//감정 관련 부가설명  ex. 감정발생원인, 상황 등등 없을 수도 있음
        dataAboutDates.add(dataAboutDate);
        dataAboutDates.add(dataAboutDate);


        dateData.setData(dataAboutDates);
        eventDataList.add(dateData);
        //    }

        return eventDataList;
    }

    private static Date addDays(Date d1, int i) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d1);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }
}