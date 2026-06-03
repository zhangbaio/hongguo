package com.dragon.read.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.util.FileUtils;
import er4.s;
import java.io.File;
import java.io.Serializable;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CacheWrapper {
    static {
        Covode.recordClassIndex(611462);
    }

    public static void r(String str) {
        u(AppUtils.getUserId(), str);
    }

    public static <T> T c(String str) {
        return (T) k(AppUtils.getUserId(), str);
    }

    public static void t(String str) {
        a.b(i(AppUtils.getUserId(), str)).a();
    }

    public static <T> T d(String str, String str2) {
        return (T) l(AppUtils.getUserId(), str, str2);
    }

    public static byte[] j(String str, String str2) {
        return a.b(i(str, "public_dir")).d(str2, true);
    }

    public static <T> T k(String str, String str2) {
        return (T) a.b(i(str, "public_dir")).f(str2);
    }

    public static boolean q(String str, String str2) {
        return p(AppUtils.getUserId(), str, str2);
    }

    public static void s(String str, String str2) {
        a.b(i(AppUtils.getUserId(), str)).p(str2);
    }

    public static void u(String str, String str2) {
        a.b(i(str, "public_dir")).p(str2);
    }

    public static <T> T f(String str, boolean z) {
        return (T) a.b(i(AppUtils.getUserId(), "public_dir")).g(str, z);
    }

    public static SharedPreferences g(Context context, String str) {
        return KvCacheMgr.mmkv(context, "prefix_private_" + str);
    }

    public static SharedPreferences h(Context context, String str) {
        return KvCacheMgr.mmkv(context, "prefix_public_" + str);
    }

    public static File i(String str, String str2) {
        return FileUtils.createDir(new PolarisFileWrapper(s.g(str), "prefix_public_" + str2), false);
    }

    public static void saveCurrentUserObject(String str, Serializable serializable, int i) {
        y(AppUtils.getUserId(), str, serializable, i);
    }

    public static <T> T e(String str, String str2, boolean z) {
        return (T) n(AppUtils.getUserId(), str, str2, false, z);
    }

    public static <T> T l(String str, String str2, String str3) {
        return (T) a.b(i(str, str2)).f(str3);
    }

    public static boolean p(String str, String str2, String str3) {
        return a.b(i(str, str2)).i(str3);
    }

    public static void x(String str, String str2, byte[] bArr) {
        a.b(i(str, "public_dir")).m(str2, bArr);
    }

    public static void v(String str, String str2, Serializable serializable, int i) {
        a(AppUtils.getUserId(), str, str2, serializable, i);
    }

    public static <T> T m(String str, String str2, String str3, boolean z) {
        return (T) a.b(i(str, str2)).g(str3, z);
    }

    public static void o(String str, String str2, int i, int i2) {
        a.c(i(str, str2), i, i2);
    }

    public static void y(String str, String str2, Serializable serializable, int i) {
        a.b(i(str, "public_dir")).k(str2, serializable, i);
    }

    public static <T> T n(String str, String str2, String str3, boolean z, boolean z2) {
        return (T) a.b(i(str, str2)).h(str3, z, z2);
    }

    public static void w(String str, String str2, Serializable serializable, int i, boolean z) {
        A(AppUtils.getUserId(), str, str2, serializable, i, z);
    }

    public static void z(String str, String str2, String str3, Serializable serializable, int i) {
        a.b(i(str, str2)).k(str3, serializable, i);
    }

    @Proxy("saveUserObject")
    @TargetClass("com.dragon.read.local.CacheWrapper")
    public static void a(String str, String str2, String str3, Serializable serializable, int i) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ls5.a.d(str, str2, str3, serializable);
        ls5.a.c(str, str2, str3, serializable);
        ls5.a.a.i("检测书籍缓存耗时：%d", new Object[]{Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)});
        z(str, str2, str3, serializable, i);
    }

    public static void A(String str, String str2, String str3, Serializable serializable, int i, boolean z) {
        a.b(i(str, str2)).l(str3, serializable, i, z);
    }
}
