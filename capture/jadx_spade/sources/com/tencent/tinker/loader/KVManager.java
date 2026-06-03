package com.tencent.tinker.loader;

import android.content.SharedPreferences;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class KVManager {
    private static volatile KVManager sInstance;
    private SharedPreferences mPreferences = MuteApplication.getInstance().getSharedPreferences("_full_upgrade", 0);

    static {
        Covode.recordClassIndex(653946);
    }

    public static long combineInt2Long(int i, int i2) {
        return ((i << 32) & (-4294967296L)) | (i2 & 4294967295L);
    }

    public static int getHighLong(long j) {
        return (int) ((j & (-4294967296L)) >> 32);
    }

    public static int getLowLong(long j) {
        return (int) (j & 4294967295L);
    }

    public void clearInstalledVersion() {
        this.mPreferences.edit().remove("full_version").apply();
    }

    public boolean getEnableAlignDex() {
        return this.mPreferences.getBoolean("enable_aligned_dex", false);
    }

    public boolean getEnableLockMuteVersion() {
        return this.mPreferences.getBoolean("enable_lock_mute_version", false);
    }

    public int getInstalledVersion() {
        return this.mPreferences.getInt("full_version", 10000000);
    }

    public int getRuleId() {
        return this.mPreferences.getInt("rule_id", 0);
    }

    public boolean hasStartException() {
        if (this.mPreferences.getInt("start_exception_count", 0) < 2) {
            return false;
        }
        return true;
    }

    private KVManager() {
    }

    public static KVManager getInst() {
        if (sInstance == null) {
            synchronized (KVManager.class) {
                if (sInstance == null) {
                    sInstance = new KVManager();
                }
            }
        }
        return sInstance;
    }

    public void clearStartFlag() {
        this.mPreferences.edit().putInt("start_exception_count", 0).apply();
    }

    public void writeStartFlag() {
        this.mPreferences.edit().putInt("start_exception_count", this.mPreferences.getInt("start_exception_count", 0) + 1).apply();
    }

    public int[] getLastStartMode() {
        int[] iArr = {0, 0};
        long j = this.mPreferences.getLong("KEY_LAST_SATRT_MODE", 0L);
        iArr[0] = getHighLong(j);
        iArr[1] = getLowLong(j);
        return iArr;
    }

    public void setLastStartMode(int i, int i2) {
        this.mPreferences.edit().putLong("KEY_LAST_SATRT_MODE", combineInt2Long(i, i2)).apply();
    }
}
