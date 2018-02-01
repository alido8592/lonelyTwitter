/*
 * Tweet
 *
 * Version 1.0
 *
 * January 30, 2018
 *
 * Copyright 2018 Team X. CMPUT 301. University of Alberta. All Rights Reserved.
 * You may use, distribute, or modify the code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise, please contact alido@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by dezfuli on 1/16/18.
 */

/**
 * Represents a tweet class
 *
 * @author alido
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 */

public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;
    private Mood mood;

    /**
     * Constructs tweet object
     * @param message tweet message
     */

    Tweet(String message){

        this.message = message;
        date = new Date();
        if (mood!=null) {
            String newMessage = message + " | Current mood is: " + mood.getMoodName();
            this.message = newMessage;
        }
//        message = message;
    }

    /**
     * Constructs tweet object with mood
     * @param message tweet message
     * @param mood Mood object to associate with tweet
     */

    Tweet(String message, Mood mood) {

        this.message = message + " | Current mood is: " + mood.getMoodName();
        date = new Date();
    }

    /**
     * Constructs tweet object
     *
     * @param message tweet message
     * @param date tweet date
     */

    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     * Gets tweet message
     * @return string containing the tweet message
     */

    public String getMessage(){
        return message;
    }

    /**
     * Sets tweet message.
     * @param message tweet message
     * @throws TweetTooLongException the tweet message is over 140 characters
     */

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    /**
     * Gets the date of the tweet object
     * @return the date of the tweet object
     */

    public Date getDate(){
        return date;
    }

    /**
     * Sets the date of the tweet
     * @param date date for tweet
     */

    public void setDate(Date date){
        this.date = date;
    }

    /**
     * Sets the tweet to be important or not
     */

    public abstract Boolean isImportant();

    /**
     * Convert tweet to string including date and message
     * @return formatted string to display tweet with date
     */

    public String toString() {
        return date.toString() + " | " + message;
    }

    /**
     * Sets the mood object associated with tweet
     * @param mood Mood object for tweet
     */

    public void setMood(Mood mood) { this.mood = mood;}

}
