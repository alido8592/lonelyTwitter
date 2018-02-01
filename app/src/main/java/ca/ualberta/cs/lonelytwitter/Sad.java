/*
 * Sad
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
 * Represents a Sad mood object
 * @author alido
 * @version 1.0
 * @see Mood
 */

public class Sad extends Mood {

    private String moodName = "Sad";

    /**
     * Constructs a sad mood object
     */

    public Sad() {
        super();
        setMoodName(moodName);
    }

    /**
     * Constructs a sad mood object with a date to set for the mood's date
     * @param date date for the mood object
     */

    public Sad(Date date) {
        super();
        setMoodName(moodName);
        super.setDate(date);
    }

    /**
     * Sets the date for the mood object
     * @param date date object for the mood
     */

    public void setDate(Date date){
        super.setDate(date);
    }

}
