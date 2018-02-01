/*
 * NormalTweet
 *
 * Version 1.0
 *
 * Copyright 2018 Team X. CMPUT 301. University of Alberta. All Rights Reserved.
 * You may use, distribute, or modify the code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise, please contact alido@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

/**
 * Represents a NormalTweet class
 *
 * @author alido
 * @version 1.0
 * @see Tweet
 */

public class NormalTweet extends Tweet {

    /**
     * Constructs a NormalTweet object
     * @param message NormalTweet message
     */

    NormalTweet(String message){
        super(message);
    }

    /**
     * Constructs a NormalTweet object (with date override)
     * @param message NormalTweet message
     * @param date NormalTweet date to be set
     */

    NormalTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Constructs a NormalTweet object with mood
     * @param message NormalTweet message
     * @param mood Mood object to be associated with NormalTweet
     */

    NormalTweet(String message, Mood mood){
        super(message,mood);
    }

    /**
     * NormalTweet set to be not important
     * @return Boolean value suggesting importance level of tweet
     */

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
