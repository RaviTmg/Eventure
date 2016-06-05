package com.soch.foundation.eventure.Activity;

/**
 * Created by RawV on 6/4/2016.
 */
public class CommentObject {
    String userName, date;
    int comment;
    public CommentObject(int comment, String userName, String date) {
        this.comment = comment;
        this.userName = userName;
        this.date = date;
    }
}
