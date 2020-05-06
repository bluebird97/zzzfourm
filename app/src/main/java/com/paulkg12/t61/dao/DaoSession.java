package com.paulkg12.t61.dao;


import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;


// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 *
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig authUserDaoConfig;
    private final DaoConfig localUserDaoConfig;
    private final DaoConfig localRepoDaoConfig;

    private final AuthUserDao authUserDao;
    private final LocalUserDao localUserDao;
    private final LocalRepoDao localRepoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        authUserDaoConfig = daoConfigMap.get(AuthUserDao.class).clone();
        authUserDaoConfig.initIdentityScope(type);

        localUserDaoConfig = daoConfigMap.get(LocalUserDao.class).clone();
        localUserDaoConfig.initIdentityScope(type);

        localRepoDaoConfig = daoConfigMap.get(LocalRepoDao.class).clone();
        localRepoDaoConfig.initIdentityScope(type);


        authUserDao = new AuthUserDao(authUserDaoConfig, this);
        localUserDao = new LocalUserDao(localUserDaoConfig, this);
        localRepoDao = new LocalRepoDao(localRepoDaoConfig, this);

        registerDao(AuthUser.class, authUserDao);
        registerDao(LocalUser.class, localUserDao);
        registerDao(LocalRepo.class, localRepoDao);
    }

    public void clear() {
        authUserDaoConfig.clearIdentityScope();
        localUserDaoConfig.clearIdentityScope();
        localRepoDaoConfig.clearIdentityScope();
    }

    public AuthUserDao getAuthUserDao() {
        return authUserDao;
    }


    public LocalUserDao getLocalUserDao() {
        return localUserDao;
    }

    public LocalRepoDao getLocalRepoDao() {
        return localRepoDao;
    }


}
