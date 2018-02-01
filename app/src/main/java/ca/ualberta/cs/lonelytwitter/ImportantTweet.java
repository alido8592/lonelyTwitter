/*
 * ImportantTweet
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
 * Represents ImportantTweet class
 *
 * @author alido
 * @version 1.0
 * @see Tweet
 */

public class ImportantTweet extends Tweet {

    /**
     * Constructs ImportantTweet with message
     * @param message ImportantTweet message
     */

    ImportantTweet(String message){
        super(message);
    }

    /**
     * Constructs ImportantTweet with message and date specified
     * @param message ImportantTweet message
     * @param date ImportantTweet date to be set
     */

    ImportantTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Override to specify ImportantTweet is important
     * @return Boolean value signifying importance of ImportantTweet
     */

    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
