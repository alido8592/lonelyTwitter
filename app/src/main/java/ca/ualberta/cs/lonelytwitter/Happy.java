package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class Happy extends Mood {

    private String moodName = "Happy";

	public Happy() {
        super();
    }
    public Happy(Date date) {
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

