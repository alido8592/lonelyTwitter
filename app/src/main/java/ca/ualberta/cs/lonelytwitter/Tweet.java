/**
 *
 * Tweet
 *
 * Version 1.0
 *
 * September 26, 2017
 *
 * Copyright 2017 Team Me. CMPUT 301 University of Alberta. - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You may find a copy of the license in this project. Otherwise please contact alido@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by watts1 on 9/12/17.
 */

/**
 * Represents a tweet.
 *
 * @author Luis Anton Alido
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */

public abstract class Tweet {

    private String message;
    private Date date;


    /**
     * Constructs a tweet object.
     *
     * @param message tweet message
     * @param date tweet date
     */

    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public abstract Boolean isImportant();

    /**
     * Sets tweet message.
     *
     * @param message tweet message
     * @throws TweetTooLongException
     */



    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }


    /**
     * Grabs message
     *
     * @return
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Grabs date
     *
     * @return
     */

    public Date getDate() {
        return date;
    }

    /**
     * Sets date
     *
     * @param date
     */

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Adds date to message
     *
     * @return
     */

    @Override
    public String toString() {
        return date.toString() + " | " + message;
    }
}
