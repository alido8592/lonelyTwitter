package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Sad extends Mood {

    private String moodName = "Sad";

    public Sad() {
        super();
        setMoodName(moodName);
    }
    public Sad(Date date) {
        super();
        setMoodName(moodName);
        super.setDate(date);
    }

    public void setDate(Date date){
        super.setDate(date);
    }

}
