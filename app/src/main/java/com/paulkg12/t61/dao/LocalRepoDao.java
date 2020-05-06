package com.paulkg12.t61.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/**
 * DAO for table "LOCAL_REPO".
 */
public class LocalRepoDao extends AbstractDao<LocalRepo, Long> {

    public static final String TABLENAME = "LOCAL_REPO";

    /**
     * Properties of entity LocalRepo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "ID");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Description = new Property(2, String.class, "description", false, "DESCRIPTION");
        public final static Property Language = new Property(3, String.class, "language", false, "LANGUAGE");
        public final static Property StargazersCount = new Property(4, Integer.class, "stargazersCount", false, "STARGAZERS_COUNT");
        public final static Property WatchersCount = new Property(5, Integer.class, "watchersCount", false, "WATCHERS_COUNT");
        public final static Property ForksCount = new Property(6, Integer.class, "forksCount", false, "FORKS_COUNT");
        public final static Property Fork = new Property(7, Boolean.class, "fork", false, "FORK");
        public final static Property OwnerLogin = new Property(8, String.class, "ownerLogin", false, "OWNER_LOGIN");
        public final static Property OwnerAvatarUrl = new Property(9, String.class, "ownerAvatarUrl", false, "OWNER_AVATAR_URL");
    }


    public LocalRepoDao(DaoConfig config) {
        super(config);
    }

    public LocalRepoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"LOCAL_REPO\" (" + //
                "\"ID\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"DESCRIPTION\" TEXT," + // 2: description
                "\"LANGUAGE\" TEXT," + // 3: language
                "\"STARGAZERS_COUNT\" INTEGER," + // 4: stargazersCount
                "\"WATCHERS_COUNT\" INTEGER," + // 5: watchersCount
                "\"FORKS_COUNT\" INTEGER," + // 6: forksCount
                "\"FORK\" INTEGER," + // 7: fork
                "\"OWNER_LOGIN\" TEXT," + // 8: ownerLogin
                "\"OWNER_AVATAR_URL\" TEXT);"); // 9: ownerAvatarUrl
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"LOCAL_REPO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, LocalRepo entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getName());

        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(3, description);
        }

        String language = entity.getLanguage();
        if (language != null) {
            stmt.bindString(4, language);
        }

        Integer stargazersCount = entity.getStargazersCount();
        if (stargazersCount != null) {
            stmt.bindLong(5, stargazersCount);
        }

        Integer watchersCount = entity.getWatchersCount();
        if (watchersCount != null) {
            stmt.bindLong(6, watchersCount);
        }

        Integer forksCount = entity.getForksCount();
        if (forksCount != null) {
            stmt.bindLong(7, forksCount);
        }

        Boolean fork = entity.getFork();
        if (fork != null) {
            stmt.bindLong(8, fork ? 1L: 0L);
        }

        String ownerLogin = entity.getOwnerLogin();
        if (ownerLogin != null) {
            stmt.bindString(9, ownerLogin);
        }

        String ownerAvatarUrl = entity.getOwnerAvatarUrl();
        if (ownerAvatarUrl != null) {
            stmt.bindString(10, ownerAvatarUrl);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, LocalRepo entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindString(2, entity.getName());

        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(3, description);
        }

        String language = entity.getLanguage();
        if (language != null) {
            stmt.bindString(4, language);
        }

        Integer stargazersCount = entity.getStargazersCount();
        if (stargazersCount != null) {
            stmt.bindLong(5, stargazersCount);
        }

        Integer watchersCount = entity.getWatchersCount();
        if (watchersCount != null) {
            stmt.bindLong(6, watchersCount);
        }

        Integer forksCount = entity.getForksCount();
        if (forksCount != null) {
            stmt.bindLong(7, forksCount);
        }

        Boolean fork = entity.getFork();
        if (fork != null) {
            stmt.bindLong(8, fork ? 1L: 0L);
        }

        String ownerLogin = entity.getOwnerLogin();
        if (ownerLogin != null) {
            stmt.bindString(9, ownerLogin);
        }

        String ownerAvatarUrl = entity.getOwnerAvatarUrl();
        if (ownerAvatarUrl != null) {
            stmt.bindString(10, ownerAvatarUrl);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }

    @Override
    public LocalRepo readEntity(Cursor cursor, int offset) {
        LocalRepo entity = new LocalRepo( //
                cursor.getLong(offset + 0), // id
                cursor.getString(offset + 1), // name
                cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // description
                cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // language
                cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4), // stargazersCount
                cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // watchersCount
                cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6), // forksCount
                cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0, // fork
                cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // ownerLogin
                cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9) // ownerAvatarUrl
        );
        return entity;
    }

    @Override
    public void readEntity(Cursor cursor, LocalRepo entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setDescription(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLanguage(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setStargazersCount(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setWatchersCount(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setForksCount(cursor.isNull(offset + 6) ? null : cursor.getInt(offset + 6));
        entity.setFork(cursor.isNull(offset + 7) ? null : cursor.getShort(offset + 7) != 0);
        entity.setOwnerLogin(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setOwnerAvatarUrl(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
    }

    @Override
    protected final Long updateKeyAfterInsert(LocalRepo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }

    @Override
    public Long getKey(LocalRepo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(LocalRepo entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }

}

