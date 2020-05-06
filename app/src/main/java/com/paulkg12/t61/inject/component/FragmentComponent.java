

package com.paulkg12.t61.inject.component;

import com.paulkg12.t61.inject.FragmentScope;
import com.paulkg12.t61.inject.module.FragmentModule;
import com.paulkg12.t61.ui.fragment.LabelManageFragment;
import com.paulkg12.t61.ui.fragment.IssueTimelineFragment;
import com.paulkg12.t61.ui.fragment.IssuesFragment;
import com.paulkg12.t61.ui.fragment.ViewerFragment;

import dagger.Component;

/**
 * Created on 2017/7/18.
 *
 * @author ThirtyDegreesRay
 */

@FragmentScope
@Component(modules = FragmentModule.class, dependencies = AppComponent.class)
public interface FragmentComponent {

    void inject(ViewerFragment fragment);
    void inject(IssuesFragment fragment);
    void inject(IssueTimelineFragment fragment);
    void inject(LabelManageFragment fragment);
}
