package ca.ualberta.cs.lonelytwitter;


import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Mood { /** Date grab based off of https://www.mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/ */

	private Date date;
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private String todayDate;
	private String moodName;

	public Mood(){
		this.date = new Date();
		this.todayDate = format.format(this.date);
	}

	public Mood(Date date){
		this.date = date;
		this.todayDate = format.format(this.date);
	}

	public Date getDate() {
		return this.date;
    }

    public void setDate(Date date) {
		this.date = date;
		String dateString = format.format(this.date);
		this.todayDate = dateString;
	}

	public String getMoodName(){
		return this.moodName;
	}

	public void setMoodName(String moodName) {
		this.moodName = moodName;
	}
}

