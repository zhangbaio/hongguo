package com.ss.ttvideoengine.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class VideoModelDBManager {
    private static int mCacheSize;
    private static SQLiteDatabase mDB;
    private static VideoModelDBManager mInstance;
    private static boolean sEnableSizeLimit;

    public static class CacheInfo {
        public long time = 0;
        public String videoModelStr = null;
        public String vid = null;

        static {
            Covode.recordClassIndex(652423);
        }
    }

    static {
        Covode.recordClassIndex(652422);
        mCacheSize = 200;
        sEnableSizeLimit = true;
    }

    public static void clear() {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = mDB;
        if (sQLiteDatabase2 == null) {
            return;
        }
        try {
            sQLiteDatabase2.beginTransaction();
            try {
                try {
                    mDB.execSQL(String.format("DELETE FROM %s ", "videomodel"));
                    mDB.setTransactionSuccessful();
                    TTVideoEngineLog.i("VideoModelDBManager", "all cleared");
                    sQLiteDatabase = mDB;
                } catch (Exception e) {
                    TTVideoEngineLog.d(e);
                    sQLiteDatabase = mDB;
                }
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                mDB.endTransaction();
                throw th;
            }
        } catch (Exception e2) {
            TTVideoEngineLog.d(e2);
        }
    }

    public static int count() {
        if (mDB == null) {
            return -1;
        }
        int i = 0;
        try {
            Cursor rawQuery = mDB.rawQuery(String.format("SELECT COUNT(*) FROM %s", "videomodel"), null);
            if (rawQuery.moveToFirst()) {
                i = (int) rawQuery.getLong(0);
            }
            rawQuery.close();
        } catch (Exception e) {
            TTVideoEngineLog.d(e);
        }
        TTVideoEngineLog.d("VideoModelDBManager", "count:" + i);
        return i;
    }

    public static void setCacheSize(int i) {
        mCacheSize = i;
    }

    public static void setEnableSizeLimit(boolean z) {
        sEnableSizeLimit = z;
    }

    public static VideoModelDBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (VideoModelDBManager.class) {
                if (mInstance == null) {
                    mInstance = new VideoModelDBManager(context);
                }
            }
        }
        return mInstance;
    }

    private VideoModelDBManager(Context context) {
        DBHelper dBHelper;
        if (context != null && (dBHelper = DBHelper.getInstance(context)) != null) {
            try {
                SQLiteDatabase writableDatabase = dBHelper.getWritableDatabase();
                mDB = writableDatabase;
                if (writableDatabase != null) {
                    mDB.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(vid TEXT PRIMARY KEY,videomodel TEXT,time INTEGER)", "videomodel"));
                }
            } catch (Throwable th) {
                TTVideoEngineLog.d(th);
            }
        }
    }

    public static void delete(String str) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = mDB;
        if (sQLiteDatabase2 == null) {
            return;
        }
        try {
            sQLiteDatabase2.beginTransaction();
            try {
                try {
                    mDB.execSQL(String.format("DELETE FROM %s WHERE vid='%s'", "videomodel", str));
                    mDB.setTransactionSuccessful();
                    sQLiteDatabase = mDB;
                } catch (Exception e) {
                    TTVideoEngineLog.d(e);
                    sQLiteDatabase = mDB;
                }
                sQLiteDatabase.endTransaction();
            } catch (Throwable th) {
                mDB.endTransaction();
                throw th;
            }
        } catch (Exception e2) {
            TTVideoEngineLog.d(e2);
        }
        TTVideoEngineLog.i("VideoModelDBManager", "deleted vid:" + str);
    }

    public static CacheInfo query(String str) {
        Cursor rawQuery;
        CacheInfo cacheInfo;
        CacheInfo cacheInfo2 = null;
        if (TextUtils.isEmpty(str) || mDB == null) {
            return null;
        }
        try {
            rawQuery = mDB.rawQuery(String.format("SELECT * FROM %s WHERE vid='%s'", "videomodel", str), null);
            cacheInfo = new CacheInfo();
        } catch (Exception e) {
            e = e;
        }
        try {
            cacheInfo.vid = str;
            if (rawQuery.moveToFirst()) {
                cacheInfo.videoModelStr = rawQuery.getString(rawQuery.getColumnIndex("videomodel"));
                cacheInfo.time = rawQuery.getLong(rawQuery.getColumnIndex("time"));
            }
            rawQuery.close();
            TTVideoEngineLog.d("VideoModelDBManager", "query vid:" + str + " videomodel:" + cacheInfo.videoModelStr);
            return cacheInfo;
        } catch (Exception e2) {
            e = e2;
            cacheInfo2 = cacheInfo;
            TTVideoEngineLog.d(e);
            return cacheInfo2;
        }
    }

    public static void insert(String str, String str2) {
        SQLiteDatabase sQLiteDatabase;
        if (mDB != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            TTVideoEngineLog.i("VideoModelDBManager", "insert vid:" + str + " videomodel:" + str2);
            boolean z = true;
            try {
                mDB.beginTransaction();
                try {
                    try {
                        try {
                            mDB.execSQL(String.format("REPLACE INTO %s VALUES ('%s','%s',%d)", "videomodel", str, str2, Long.valueOf(System.currentTimeMillis())));
                            if (sEnableSizeLimit) {
                                mDB.execSQL(String.format("DELETE FROM %s WHERE vid IN (SELECT vid FROM %s ORDER BY time DESC LIMIT -1 OFFSET %d)", "videomodel", "videomodel", Integer.valueOf(mCacheSize)));
                            }
                            mDB.setTransactionSuccessful();
                            sQLiteDatabase = mDB;
                        } catch (Throwable th) {
                            mDB.endTransaction();
                            throw th;
                        }
                    } catch (IllegalStateException e) {
                        TTVideoEngineLog.d(e);
                        sQLiteDatabase = mDB;
                    }
                    sQLiteDatabase.endTransaction();
                    z = false;
                } catch (SQLException e2) {
                    TTVideoEngineLog.d(e2);
                    mDB.endTransaction();
                }
            } catch (Exception e3) {
                TTVideoEngineLog.d(e3);
            }
            if (z) {
                int count = count();
                TTVideoEngineLog.d("VideoModelDBManager", "sqlExcHappen count " + count);
                if (count > 0) {
                    int i = count - 10;
                    mCacheSize = i;
                    if (i < 20) {
                        mCacheSize = 20;
                    }
                }
            }
        }
    }
}
