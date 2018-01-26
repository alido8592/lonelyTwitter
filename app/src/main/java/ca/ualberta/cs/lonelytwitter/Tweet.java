package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by dezfuli on 1/16/18.
 */

public abstract class Tweet implements Tweetable {
    private String message;
    private Date date;
    private Mood mood;

    Tweet(String message){

        this.message = message;
        date = new Date();
        if (mood!=null) {
            String newMessage = message + " | Current mood is: " + mood.getMoodName();
            this.message = newMessage;
        }
//        message = message;
    }

    Tweet(String message, Mood mood) {

        this.message = message + " | Current mood is: " + mood.getMoodName();
        date = new Date();
    }

    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new TweetTooLongException();
        }
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public abstract Boolean isImportant();

    public String toString() {
        return date.toString() + " | " + message;
    }

    public void setMood(Mood mood) { this.mood = mood;}

}
