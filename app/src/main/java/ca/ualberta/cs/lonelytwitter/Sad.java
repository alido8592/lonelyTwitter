package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Sad extends Mood {

    private String moodName = "Sad";

    public Sad() {
        super();
    }
    public Sad(Date date) {
        super();
        super.setDate(date);
    }

    public void setDate(Date date){
        super.setDate(date);
    }

    public String getMoodName(){
        return this.moodName;
    }
}
