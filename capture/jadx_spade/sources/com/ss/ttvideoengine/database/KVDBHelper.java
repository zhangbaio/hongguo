package com.ss.ttvideoengine.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class KVDBHelper extends SQLiteOpenHelper {
    private static Integer Version;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    static {
        Covode.recordClassIndex(652420);
        Version = 1;
    }

    public KVDBHelper(Context context, String str) {
        this(context, str, Version.intValue());
    }

    public KVDBHelper(Context context, String str, int i) {
        this(context, str, null, i);
    }

    public KVDBHelper(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, str, cursorFactory, i);
    }
}
