package com.paulkg12.t61.http.model;

import com.paulkg12.t61.mvp.model.Issue;
import com.paulkg12.t61.mvp.model.Label;
import com.paulkg12.t61.mvp.model.User;

import java.util.ArrayList;

public class IssueRequestModel {

    private String title;
    private Issue.IssueState state;
    private String body;


    public static IssueRequestModel generateFromIssue(Issue issue){
        IssueRequestModel model = new IssueRequestModel();
        model.setTitle(issue.getTitle());
        model.setState(issue.getState());
        model.setBody(issue.getBody());
        return model;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Issue.IssueState getState() {
        return state;
    }

    public void setState(Issue.IssueState state) {
        this.state = state;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}

