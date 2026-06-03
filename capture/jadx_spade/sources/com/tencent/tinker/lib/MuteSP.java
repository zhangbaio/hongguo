package com.tencent.tinker.lib;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class MuteSP {
    private static volatile MuteSP sInstance;
    private final SharedPreferences mSharedPrefs = Muter.getAppContext().getSharedPreferences("_full_upgrade", 0);

    static {
        Covode.recordClassIndex(653711);
    }

    public static long combineInt2Long(int i, int i2) {
        return ((i << 32) & (-4294967296L)) | (i2 & 4294967295L);
    }

    public Map<String, ?> getAll() {
        return this.mSharedPrefs.getAll();
    }

    public static void clearInstalledVerCode() {
        getInst().removePref("full_version");
    }

    public static boolean getHookAnim() {
        return getInst().getPref("enable_hook_anim", Boolean.FALSE);
    }

    public static String getInstallAlign() {
        return getInst().getPref("install_align", "");
    }

    public static String getInstallMd5() {
        return getInst().getPref("full_md5", "");
    }

    public static String getInstallOpt() {
        return getInst().getPref("install_opt", "");
    }

    public static boolean getInstallOptMode() {
        return getInst().getPref("install_opt_mode", Boolean.FALSE);
    }

    public static int getInstallRealHostUpdateVCode() {
        return getInst().getPref("KEY_INSTALL_REAL_HOST_UPDATE", 0);
    }

    public static int getInstallVerCode() {
        return getInst().getPref("full_version", 0);
    }

    public static int getOfflineVerCode() {
        return getInst().getPref("KEY_OFFLINE_VERSION", 0);
    }

    public static int getRuleId() {
        return getInst().getPref("rule_id", 0);
    }

    public static void removeInstallAlign() {
        getInst().removePref("install_align");
    }

    public static void removeInstallOpt() {
        getInst().removePref("install_opt");
    }

    public static void setRomUpdate() {
        getInst().setPref("KEY_ROM_LAST", Build.VERSION.INCREMENTAL);
    }

    private MuteSP() {
    }

    public static MuteSP getInst() {
        if (sInstance == null) {
            synchronized (MuteSP.class) {
                if (sInstance == null) {
                    sInstance = new MuteSP();
                }
            }
        }
        return sInstance;
    }

    public static boolean isRomUpdate() {
        String pref = getInst().getPref("KEY_ROM_LAST", "");
        String str = Build.VERSION.INCREMENTAL;
        if (!TextUtils.isEmpty(pref) && !TextUtils.isEmpty(str)) {
            return !TextUtils.equals(pref, str);
        }
        return false;
    }

    public static void removeTranStatus(String str) {
        getInst().removePref(str);
    }

    public static int getInstallTranStatus(String str) {
        return getInst().getPref(str, 0);
    }

    public static void setAlignDex(boolean z) {
        getInst().setPref("enable_aligned_dex", z);
    }

    public static void setEnableLockVersion(boolean z) {
        getInst().setPref("enable_lock_mute_version", z);
    }

    public static void setHookAnim(boolean z) {
        getInst().setPref("enable_hook_anim", z);
    }

    public static void setInstallAlign(String str) {
        getInst().setPref("install_align", str);
    }

    public static void setInstallMd5(String str) {
        getInst().setPref("full_md5", str);
    }

    public static void setInstallOpt(String str) {
        getInst().setPref("install_opt", str);
    }

    public static void setInstallOptMode(boolean z) {
        getInst().setPref("install_opt_mode", z);
    }

    public static void setInstallRealHostUpdateVCode(int i) {
        getInst().setPref("KEY_INSTALL_REAL_HOST_UPDATE", i);
    }

    public static void setInstallVerCode(int i) {
        getInst().setPref("full_version", i);
    }

    public static void setNeedDoOatVersion(int i) {
        getInst().setPref("KEY_DO_OAT_VERSION", i);
    }

    public static void setOfflineVerCode(int i) {
        getInst().setPref("KEY_OFFLINE_VERSION", i);
    }

    public static void setRuleId(int i) {
        getInst().setPref("rule_id", i);
    }

    public static void setSupportHostRange(String str) {
        getInst().setPref("KEY_SUPPORT_HOST_RANGER", str);
    }

    public void removePref(String str) {
        SharedPreferences.Editor edit = this.mSharedPrefs.edit();
        edit.remove(str);
        edit.apply();
    }

    public static int[] getSupportHostRange(int i) {
        int[] iArr = {0, 0};
        String pref = getInst().getPref("KEY_SUPPORT_HOST_RANGER", "");
        if (TextUtils.isEmpty(pref)) {
            return iArr;
        }
        String[] split = pref.split("\\|");
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        int parseInt3 = Integer.parseInt(split[2]);
        if (parseInt == i) {
            iArr[0] = parseInt2;
            iArr[1] = parseInt3;
        }
        return iArr;
    }

    public static void setInstallTranStatus(String str, int i) {
        getInst().setPref(str, i);
    }

    public float getPref(String str, float f) {
        return this.mSharedPrefs.getFloat(str, f);
    }

    public static void setLastStartMode(int i, int i2) {
        getInst().setPref("KEY_LAST_SATRT_MODE", combineInt2Long(i, i2));
    }

    public int getPref(String str, int i) {
        return this.mSharedPrefs.getInt(str, i);
    }

    public void setPref(String str, float f) {
        SharedPreferences.Editor edit = this.mSharedPrefs.edit();
        edit.putFloat(str, f);
        edit.apply();
    }

    public long getPref(String str, long j) {
        return this.mSharedPrefs.getLong(str, j);
    }

    public void setPref(String str, int i) {
        SharedPreferences.Editor edit = this.mSharedPrefs.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public String getPref(String str, String str2) {
        return this.mSharedPrefs.getString(str, str2);
    }

    public void setPref(String str, long j) {
        SharedPreferences.Editor edit = this.mSharedPrefs.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public Set<String> getPref(String str, Set<String> set) {
        return this.mSharedPrefs.getStringSet(str, set);
    }

    public void setPref(String str, String str2) {
        SharedPreferences.Editor edit = this.mSharedPrefs.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public boolean getPref(String str, Boolean bool) {
        return this.mSharedPrefs.getBoolean(str, bool.booleanValue());
    }

    public void setPref(String str, Set<String> set) {
        SharedPreferences.Editor edit = this.mSharedPrefs.edit();
        edit.putStringSet(str, set);
        edit.apply();
    }

    public void setPref(String str, boolean z) {
        SharedPreferences.Editor edit = this.mSharedPrefs.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }
}
