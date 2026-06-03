package com.dragon.read.local;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.depend.NsBaseLocalCacheDependImpl;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class KvCacheMgr {
    static {
        Covode.recordClassIndex(611470);
    }

    public static List<String> getAllKeys(SharedPreferences sharedPreferences) {
        return NsBaseLocalCacheDependImpl.INSTANCE.allKeys(sharedPreferences);
    }

    public static SharedPreferences createSelfControl(Context context, String str) {
        return mmkv(context, str);
    }

    public static SharedPreferences mmkvNoLock(Context context, String str) {
        return NsBaseLocalCacheDependImpl.INSTANCE.createSharedPreferences(context, str);
    }

    public static synchronized SharedPreferences mmkvBigLock(Context context, String str) {
        SharedPreferences createSharedPreferences;
        synchronized (KvCacheMgr.class) {
            createSharedPreferences = NsBaseLocalCacheDependImpl.INSTANCE.createSharedPreferences(context, str);
        }
        return createSharedPreferences;
    }

    public static SharedPreferences getPrivate(Context context, String str) {
        return mmkv(context, "prefix_private_" + str);
    }

    public static SharedPreferences getPublic(Context context, String str) {
        return mmkv(context, "prefix_public_" + str);
    }

    public static SharedPreferences mmkv(Context context, String str) {
        if (NsBaseLocalCacheDependImpl.INSTANCE.mmkvLockOptEnable()) {
            return mmkvNoLock(context, str);
        }
        return mmkvBigLock(context, str);
    }
}
