

package com.paulkg12.t61.inject.component;

import com.paulkg12.t61.AppApplication;
import com.paulkg12.t61.dao.DaoSession;
import com.paulkg12.t61.inject.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * AppComponent
 * Created by ThirtyDegreesRay on 2016/8/30 14:08
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    /**
     * 获取AppApplication
     * @return
     */
    AppApplication getApplication();

    /**
     * 获取数据库Dao
     * @return
     */
    DaoSession getDaoSession();

}
