/**
 *
 * ImportantTweet
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
 * Represents an ImportantTweet object.
 * @author Luis Anton Alido
 * @version 1.0
 * @see Tweet
 */

public class ImportantTweet extends Tweet implements Tweetable {

    public ImportantTweet(String message){
        super(message);
    }

    public ImportantTweet(String message, Date date) {
        super(message, date);
    }


    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
