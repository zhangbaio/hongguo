package com.dragon.read.local.ad;

import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.local.db.AbsRoomDatabase;
import gr4.b;
import hr4.a;
import hr4.d;
import hr4.f;
import ir4.c;
import ir4.e;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class AbsAdvertiseDataBase extends AbsRoomDatabase {
    private static final LogHelper a;

    abstract b c();

    abstract c d();

    abstract e e();

    @Override // com.dragon.read.local.db.AbsRoomDatabase
    protected String getDatabaseName(String str) {
        return "advertise_db";
    }

    public static c f() {
        return h().d();
    }

    public static e g() {
        return h().e();
    }

    public static b i() {
        return h().c();
    }

    static {
        Covode.recordClassIndex(611487);
        a = new LogHelper("AdvertiseDataBase", 6);
    }

    private static synchronized AbsAdvertiseDataBase h() {
        AbsAdvertiseDataBase absAdvertiseDataBase;
        synchronized (AbsAdvertiseDataBase.class) {
            absAdvertiseDataBase = (AbsAdvertiseDataBase) AbsRoomDatabase.obtainRoomDatabase(AbsAdvertiseDataBase.class, "0");
        }
        return absAdvertiseDataBase;
    }

    @Override // com.dragon.read.local.db.AbsRoomDatabase
    protected <T extends AbsRoomDatabase> void onConfig(RoomDatabase.Builder<T> builder) {
        super.onConfig(builder);
        builder.addMigrations(new Migration[]{new a(), new hr4.b(), new hr4.c(), new d(), new hr4.e(), new f()});
    }
}
