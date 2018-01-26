package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happy extends Mood {

    private String moodName = "Happy";

	public Happy() {
        super();
        setMoodName(moodName);
    }
    public Happy(Date date) {
        super();
        setMoodName(moodName);
        super.setDate(date);
    }

    public void setDate(Date date){
	    super.setDate(date);
    }
}

