package com.dragon.read.local.db;

import android.util.Log;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dragon.read.base.util.LogHelper;
import nr4.e2;
import nr4.g2;
import nr4.i2;
import nr4.k2;
import nr4.m2;
import nr4.o2;
import nr4.q2;
import nr4.s2;
import nr4.u2;
import nr4.w2;
import or4.c0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class ReaderDBManager extends AbsReaderRoomDatabase {
    private static final LogHelper c;

    abstract e2 e();

    abstract g2 f();

    abstract i2 g();

    abstract k2 h();

    abstract m2 i();

    abstract o2 j();

    abstract q2 k();

    abstract s2 l();

    abstract u2 x();

    abstract w2 y();

    public static m2 q() {
        return new m2.a(t("0").i());
    }

    public static o2 r() {
        return new o2.a(t("0").j());
    }

    public static q2 s() {
        return new q2.a(t("0").k());
    }

    static {
        Covode.recordClassIndex(611535);
        c = new LogHelper(com.dragon.read.kmp.reader.utils.p.e(new String[0]));
    }

    class a extends RoomDatabase.Callback {
        a() {
        }

        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            super.onCreate(supportSQLiteDatabase);
            ReaderDBManager.c.i("database create. path=%s", new Object[]{a(supportSQLiteDatabase.getPath())});
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            super.onOpen(supportSQLiteDatabase);
            ReaderDBManager.c.i("database open. path=%s", new Object[]{a(supportSQLiteDatabase.getPath())});
        }

        private String a(String str) {
            long j;
            try {
                j = new PolarisFileWrapper(str).length();
            } catch (Exception e) {
                ReaderDBManager.c.i("获取大小异常 path=%s,e=%s", new Object[]{str, e});
                j = -1;
            }
            return str + "[" + j + "]";
        }

        public void onDestructiveMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            super.onDestructiveMigration(supportSQLiteDatabase);
            ReaderDBManager.c.i("recreate all tables. path=%s, error=%s", new Object[]{a(supportSQLiteDatabase.getPath()), Log.getStackTraceString(new Exception("destructive migration"))});
        }
    }

    public static i2 m(String str) {
        return new i2.a(t(str).g());
    }

    public static e2 n(String str) {
        return new e2.a(t(str).e());
    }

    public static g2 o(String str) {
        return new g2.a(t(str).f());
    }

    public static k2 p(String str) {
        return new k2.a(t(str).h());
    }

    public static synchronized ReaderDBManager t(String str) {
        ReaderDBManager readerDBManager;
        synchronized (ReaderDBManager.class) {
            readerDBManager = (ReaderDBManager) AbsReaderRoomDatabase.c(ReaderDBManager.class, str);
        }
        return readerDBManager;
    }

    public static s2 u(String str) {
        return new s2.a(t(str).l());
    }

    public static u2 v(String str) {
        return new u2.a(t(str).x());
    }

    public static w2 w(String str) {
        return new w2.a(t(str).y());
    }

    @Override // com.dragon.read.local.db.AbsReaderRoomDatabase
    protected String getDatabaseName(String str) {
        return "reader_db_" + str;
    }

    @Override // com.dragon.read.local.db.AbsReaderRoomDatabase
    protected <T extends AbsReaderRoomDatabase> void onConfig(RoomDatabase.Builder<T> builder) {
        super.onConfig(builder);
        builder.fallbackToDestructiveMigration();
        builder.addCallback(new a());
        builder.addMigrations(new Migration[]{new c0()});
    }
}
