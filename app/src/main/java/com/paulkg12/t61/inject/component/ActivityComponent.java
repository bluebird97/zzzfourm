package com.paulkg12.t61.inject.component;

import com.paulkg12.t61.MainActivity;
import com.paulkg12.t61.inject.ActivityScope;
import com.paulkg12.t61.inject.module.ActivityModule;
import com.paulkg12.t61.ui.activity.EditIssueActivity;
import com.paulkg12.t61.ui.activity.FirstPageActivity;
import com.paulkg12.t61.ui.activity.IssueDetailActivity;
import com.paulkg12.t61.ui.activity.IssuesActivity;
import com.paulkg12.t61.ui.activity.LoginActivity;
import com.paulkg12.t61.ui.activity.SplashActivity;

import dagger.Component;

@ActivityScope
@Component(modules = ActivityModule.class, dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(SplashActivity activity);
    void inject(LoginActivity activity);
    void inject(MainActivity activity);

    void inject(IssuesActivity activity);
    void inject(IssueDetailActivity activity);
    void inject(EditIssueActivity activity);
    void inject(FirstPageActivity activity);
}