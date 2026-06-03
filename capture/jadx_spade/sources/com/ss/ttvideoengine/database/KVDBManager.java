package com.ss.ttvideoengine.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class KVDBManager implements IKVStorage {
    private boolean createDBSuccess;
    private SQLiteDatabase mDB;
    private KVDBHelper mHelper;
    private String mTableName;

    static {
        Covode.recordClassIndex(652421);
    }

    public boolean isCreateDBSuccess() {
        return this.createDBSuccess;
    }

    @Override // com.ss.ttvideoengine.database.IKVStorage
    public boolean clear() {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2 = this.mDB;
        if (sQLiteDatabase2 == null) {
            return false;
        }
        try {
            sQLiteDatabase2.beginTransaction();
            try {
                try {
                    this.mDB.execSQL(String.format("DELETE FROM %s ", this.mTableName));
                    this.mDB.setTransactionSuccessful();
                    TTVideoEngineLog.d("KVDBManager", "all cleared");
                    sQLiteDatabase = this.mDB;
                } catch (Exception e) {
                    TTVideoEngineLog.d(e);
                    sQLiteDatabase = this.mDB;
                }
                sQLiteDatabase.endTransaction();
                return true;
            } catch (Throwable th) {
                this.mDB.endTransaction();
                throw th;
            }
        } catch (Exception e2) {
            TTVideoEngineLog.d(e2);
            return false;
        }
    }

    @Override // com.ss.ttvideoengine.database.IKVStorage
    public String getString(String str) {
        return get(str);
    }

    @Override // com.ss.ttvideoengine.database.IKVStorage
    public boolean removeString(String str) {
        return remove(str);
    }

    public String get(String str) {
        String str2;
        if (!TextUtils.isEmpty(str) && this.mDB != null) {
            try {
                Cursor rawQuery = this.mDB.rawQuery(String.format("SELECT * FROM %s WHERE key='%s'", this.mTableName, str), null);
                if (rawQuery.moveToFirst()) {
                    str2 = rawQuery.getString(rawQuery.getColumnIndex("value"));
                } else {
                    str2 = null;
                }
                try {
                    try {
                        rawQuery.close();
                        TTVideoEngineLog.d("KVDBManager", "get key: " + str + " value: " + str2);
                        return str2;
                    } catch (Exception e) {
                        e = e;
                        TTVideoEngineLog.d(e);
                        return null;
                    }
                } catch (Throwable unused) {
                    return str2;
                }
            } catch (Exception e2) {
                e = e2;
                str2 = null;
            } catch (Throwable unused2) {
                return null;
            }
        } else {
            TTVideoEngineLog.e("KVDBManager", "open db fail");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005c A[Catch: all -> 0x0071, TRY_LEAVE, TryCatch #1 {all -> 0x0071, blocks: (B:7:0x0011, B:10:0x002f, B:32:0x0055, B:34:0x005c), top: B:6:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean remove(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "remove key "
            android.database.sqlite.SQLiteDatabase r1 = r7.mDB
            java.lang.String r2 = "KVDBManager"
            r3 = 0
            if (r1 == 0) goto L7b
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L10
            goto L7b
        L10:
            r1 = 1
            android.database.sqlite.SQLiteDatabase r4 = r7.mDB     // Catch: java.lang.Throwable -> L71
            r4.beginTransaction()     // Catch: java.lang.Throwable -> L71
            java.lang.String r4 = "DELETE FROM %s WHERE key='%s'"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L55
            java.lang.String r6 = r7.mTableName     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L55
            r5[r3] = r6     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L55
            r5[r1] = r8     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L55
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L55
            android.database.sqlite.SQLiteDatabase r5 = r7.mDB     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L55
            r5.execSQL(r4)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L55
            android.database.sqlite.SQLiteDatabase r4 = r7.mDB     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L55
            r4.setTransactionSuccessful()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L55
            android.database.sqlite.SQLiteDatabase r4 = r7.mDB     // Catch: java.lang.Throwable -> L71
            r4.endTransaction()     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r4.<init>()     // Catch: java.lang.Throwable -> L71
            r4.append(r0)     // Catch: java.lang.Throwable -> L71
            r4.append(r8)     // Catch: java.lang.Throwable -> L71
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L71
            com.ss.ttvideoengine.utils.TTVideoEngineLog.d(r2, r8)     // Catch: java.lang.Throwable -> L71
            return r1
        L47:
            r4 = move-exception
            com.ss.ttvideoengine.utils.TTVideoEngineLog.d(r4)     // Catch: java.lang.Throwable -> L54
            android.database.sqlite.SQLiteDatabase r8 = r7.mDB     // Catch: java.lang.Throwable -> L51
            r8.endTransaction()     // Catch: java.lang.Throwable -> L51
            return r3
        L51:
            r8 = move-exception
            r3 = 1
            goto L72
        L54:
            r3 = 1
        L55:
            android.database.sqlite.SQLiteDatabase r4 = r7.mDB     // Catch: java.lang.Throwable -> L71
            r4.endTransaction()     // Catch: java.lang.Throwable -> L71
            if (r3 != 0) goto L6e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r4.<init>()     // Catch: java.lang.Throwable -> L71
            r4.append(r0)     // Catch: java.lang.Throwable -> L71
            r4.append(r8)     // Catch: java.lang.Throwable -> L71
            java.lang.String r8 = r4.toString()     // Catch: java.lang.Throwable -> L71
            com.ss.ttvideoengine.utils.TTVideoEngineLog.d(r2, r8)     // Catch: java.lang.Throwable -> L71
        L6e:
            r8 = r3 ^ 1
            return r8
        L71:
            r8 = move-exception
        L72:
            com.ss.ttvideoengine.utils.TTVideoEngineLog.d(r8)     // Catch: java.lang.Throwable -> L78
            r8 = r3 ^ 1
            return r8
        L78:
            r8 = r3 ^ 1
            return r8
        L7b:
            java.lang.String r8 = "open db fail"
            com.ss.ttvideoengine.utils.TTVideoEngineLog.d(r2, r8)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttvideoengine.database.KVDBManager.remove(java.lang.String):boolean");
    }

    @Override // com.ss.ttvideoengine.database.IKVStorage
    public boolean putString(String str, String str2) {
        return save(str, str2);
    }

    public KVDBManager(Context context, String str) {
        this.mDB = null;
        this.mTableName = null;
        this.mHelper = null;
        this.createDBSuccess = false;
        if (context != null && !TextUtils.isEmpty(str)) {
            this.mTableName = str;
            KVDBHelper kVDBHelper = new KVDBHelper(context, this.mTableName);
            this.mHelper = kVDBHelper;
            try {
                SQLiteDatabase writableDatabase = kVDBHelper.getWritableDatabase();
                this.mDB = writableDatabase;
                if (writableDatabase != null) {
                    this.mDB.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(key TEXT PRIMARY KEY,value TEXT,time INTEGER)", this.mTableName));
                }
            } catch (Throwable th) {
                try {
                    TTVideoEngineLog.d(th);
                    TTVideoEngineLog.e("KVDBManager", "create db fail, table name " + this.mTableName);
                    if (this.mHelper == null) {
                        TTVideoEngineLog.e("KVDBManager", "create db fail, mHelper == null, table name " + this.mTableName);
                    }
                    KVDBHelper kVDBHelper2 = this.mHelper;
                } finally {
                    if (this.mHelper == null) {
                        TTVideoEngineLog.e("KVDBManager", "create db fail, mHelper == null, table name " + this.mTableName);
                    }
                    this.createDBSuccess = this.mHelper != null;
                }
            }
            return;
        }
        TTVideoEngineLog.e("KVDBManager", "context or name is invalid");
    }

    public boolean save(String str, String str2) {
        boolean z = false;
        if (this.mDB != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            TTVideoEngineLog.i("KVDBManager", "save key: " + str + " value: " + str2);
            try {
                this.mDB.beginTransaction();
                try {
                    try {
                        this.mDB.execSQL(String.format("REPLACE INTO %s VALUES ('%s','%s',%d)", this.mTableName, str, str2, Long.valueOf(System.currentTimeMillis())));
                        this.mDB.setTransactionSuccessful();
                        this.mDB.endTransaction();
                        return true;
                    } catch (Throwable unused) {
                        this.mDB.endTransaction();
                        return true;
                    }
                } catch (SQLException e) {
                    TTVideoEngineLog.d(e);
                    try {
                        this.mDB.endTransaction();
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        try {
                            TTVideoEngineLog.d(th);
                            return !z;
                        } catch (Throwable unused2) {
                            return !z;
                        }
                    }
                } catch (IllegalStateException e2) {
                    TTVideoEngineLog.d(e2);
                    this.mDB.endTransaction();
                    return true;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            TTVideoEngineLog.e("KVDBManager", "open db fail");
            return false;
        }
    }
}
