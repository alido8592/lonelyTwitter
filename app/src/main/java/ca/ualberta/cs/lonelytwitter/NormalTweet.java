package ca.ualberta.cs.lonelytwitter;

/**
 * Created by dezfuli on 1/16/18.
 */
import java.util.Date;

public class NormalTweet extends Tweet {
    NormalTweet(String message){
        super(message);
    }

    NormalTweet(String message, Date date){
        super(message, date);
    }

    NormalTweet(String message, Mood mood){
        super(message,mood);
    }

    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
