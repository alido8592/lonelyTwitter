/*
 * Mood
 *
 * Version 1.0
 *
 * Copyright 2018 Team X. CMPUT 301. University of Alberta. All Rights Reserved.
 * You may use, distribute, or modify the code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise, please contact alido@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a mood object
 * @author alido
 * @version 1.0
 */

public abstract class Mood { /** Date grab based off of https://www.mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/ */

	private Date date;
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private String todayDate;
	private String moodName;

	/**
	 * Constructs a mood object
	 */

	public Mood(){
		this.date = new Date();
		this.todayDate = format.format(this.date);
	}

	/**
	 * Constructs a mood with a provided date to replace the associated date
	 * @param date date to replace the mood's date
	 */

	public Mood(Date date){
		this.date = date;
		this.todayDate = format.format(this.date);
	}

	/**
	 * Gets the date associated with the mood object
	 * @return Date object from mood
	 */

	public Date getDate() {
		return this.date;
    }

	/**
	 * Sets the mood object's date
	 * @param date date object for the mood
	 */

	public void setDate(Date date) {
		this.date = date;
		String dateString = format.format(this.date);
		this.todayDate = dateString;
	}

	/**
	 * Gets the mood's name
	 * @return String with the mood's name
	 */

	public String getMoodName(){
		return this.moodName;
	}

	/**
	 * Sets the mood name
	 * @param moodName String for the mood's name
	 */

	public void setMoodName(String moodName) {
		this.moodName = moodName;
	}
}

