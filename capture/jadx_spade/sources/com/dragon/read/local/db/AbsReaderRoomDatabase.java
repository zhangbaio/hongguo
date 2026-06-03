package com.dragon.read.local.db;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dragon.read.base.depend.NsBaseDatabaseDependImpl;
import com.dragon.read.base.util.AppUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class AbsReaderRoomDatabase extends RoomDatabase {
    private static final Map<String, AbsReaderRoomDatabase> a;
    private static final Map<Class<? extends AbsReaderRoomDatabase>, AbsReaderRoomDatabase> b;

    protected abstract String getDatabaseName(String str);

    protected <T extends AbsReaderRoomDatabase> void onConfig(RoomDatabase.Builder<T> builder) {
    }

    static {
        Covode.recordClassIndex(611512);
        a = new HashMap();
        b = new HashMap();
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

    protected static <T extends AbsReaderRoomDatabase> T c(Class<T> cls, String str) {
        Map<Class<? extends AbsReaderRoomDatabase>, AbsReaderRoomDatabase> map = b;
        AbsReaderRoomDatabase absReaderRoomDatabase = map.get(cls);
        if (absReaderRoomDatabase == null) {
            absReaderRoomDatabase = (AbsReaderRoomDatabase) getGeneratedImplementation(cls);
            map.put(cls, absReaderRoomDatabase);
        }
        String absolutePath = new PolarisFileWrapper(NsBaseDatabaseDependImpl.INSTANCE.getUserCacheDir(str), absReaderRoomDatabase.getDatabaseName(str)).getAbsolutePath();
        Map<String, AbsReaderRoomDatabase> map2 = a;
        T t = (T) map2.get(absolutePath);
        if (t != null && cls.isAssignableFrom(t.getClass())) {
            return t;
        }
        RoomDatabase.Builder<T> databaseBuilder = Room.databaseBuilder(AppUtils.context(), cls, absolutePath);
        absReaderRoomDatabase.onConfig(databaseBuilder);
        T t2 = (T) databaseBuilder.build();
        map2.put(absolutePath, t2);
        return t2;
    }
}
