package com.dragon.read.local.db;

import android.util.Log;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.LogWrapper;
import com.ss.android.common.lib.AppLogNewUtils;
import er4.i0;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class AbsRoomDatabase extends RoomDatabase {
    private static final Map<Class<? extends AbsRoomDatabase>, AbsRoomDatabase> CONFIG_MAP;
    private static final Map<String, AbsRoomDatabase> ROOM_DATABASE_MAP;

    protected abstract String getDatabaseName(String str);

    static {
        Covode.recordClassIndex(611513);
        ROOM_DATABASE_MAP = new HashMap();
        CONFIG_MAP = new HashMap();
    }

    class a extends RoomDatabase.Callback {
        a() {
        }

        public void onDestructiveMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            super.onDestructiveMigration(supportSQLiteDatabase);
            try {
                String path = supportSQLiteDatabase.getPath();
                LogWrapper.warn("AbsRoomDatabase", "数据库发生销毁重建：path=%s, error=%s", new Object[]{path, Log.getStackTraceString(new Exception("destructive migration"))});
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("db_path", path);
                AppLogNewUtils.onEventV3("db_destructive_migration", jSONObject);
            } catch (Throwable th) {
                LogWrapper.error("AbsRoomDatabase", th.getMessage(), new Object[0]);
            }
        }
    }

    protected <T extends AbsRoomDatabase> void onConfig(RoomDatabase.Builder<T> builder) {
        if (AppUtils.isOfficialBuild()) {
            builder.fallbackToDestructiveMigration();
            builder.addCallback(new a());
        }
    }

    private static <T> T getGeneratedImplementation(Class<T> cls) {
        try {
            String name = cls.getPackage().getName();
            String canonicalName = cls.getCanonicalName();
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String str = canonicalName.replace('.', '_') + "_Impl";
            if (!name.isEmpty()) {
                str = name + "." + str;
            }
            return (T) Class.forName(str, true, cls.getClassLoader()).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName() + ", error=" + e);
        }
    }

    protected static <T extends AbsRoomDatabase> T obtainRoomDatabase(Class<T> cls, String str) {
        Map<Class<? extends AbsRoomDatabase>, AbsRoomDatabase> map = CONFIG_MAP;
        AbsRoomDatabase absRoomDatabase = map.get(cls);
        if (absRoomDatabase == null) {
            absRoomDatabase = (AbsRoomDatabase) getGeneratedImplementation(cls);
            map.put(cls, absRoomDatabase);
        }
        String absolutePath = i0.b().a(str, absRoomDatabase.getDatabaseName(str)).getAbsolutePath();
        Map<String, AbsRoomDatabase> map2 = ROOM_DATABASE_MAP;
        T t = (T) map2.get(absolutePath);
        if (t != null && cls.isAssignableFrom(t.getClass())) {
            return t;
        }
        RoomDatabase.Builder<T> databaseBuilder = Room.databaseBuilder(AppUtils.context(), cls, absolutePath);
        absRoomDatabase.onConfig(databaseBuilder);
        T t2 = (T) databaseBuilder.build();
        map2.put(absolutePath, t2);
        return t2;
    }
}
