package com.paulkg12.t61.inject.module;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.paulkg12.t61.AppApplication;
import com.paulkg12.t61.AppConfig;
import com.paulkg12.t61.dao.DBOpenHelper;
import com.paulkg12.t61.dao.DaoMaster;
import com.paulkg12.t61.dao.DaoSession;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
@Module
public class AppModule {

    private AppApplication application;

    public AppModule(AppApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public AppApplication provideApplication() {
        return application;
    }

    @NonNull
    @Provides
    @Singleton
    public DaoSession provideDaoSession() {
        DBOpenHelper helper = new DBOpenHelper(application, AppConfig.DB_NAME, null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        return daoMaster.newSession();
    }


}
