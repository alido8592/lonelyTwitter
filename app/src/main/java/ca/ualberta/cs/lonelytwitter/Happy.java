/*
 * Happy
 *
 * Version 1.0
 *
 * Copyright 2018 Team X. CMPUT 301. University of Alberta. All Rights Reserved.
 * You may use, distribute, or modify the code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise, please contact alido@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a Happy mood object
 * @author alido
 * @version 1.0
 * @see Mood
 */

public class Happy extends Mood {

    private String moodName = "Happy";

    /**
     * Constructs a Happy mood object
     */

	public Happy() {
        super();
        setMoodName(moodName);
    }

    /**
     * Constructs a Happy mood object with a date to change the mood's date
     * @param date date for the mood
     */

    public Happy(Date date) {
        super();
        setMoodName(moodName);
        super.setDate(date);
    }

    /**
     * Sets the date for the Happy mood object
     * @param date date object for the mood
     */

    public void setDate(Date date){
	    super.setDate(date);
    }
}

