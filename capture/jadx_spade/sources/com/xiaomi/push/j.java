package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class j {
    private static volatile int a;

    /* renamed from: a, reason: collision with other field name */
    private static Map<String, m> f840a;
    private static int b;

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m630a() {
        return a() == 1;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m631a(Context context) {
        return context != null && m632a(context.getPackageName());
    }

    public static String c() {
        return m628a("ro.miui.ui.version.name");
    }

    public static String d() {
        return m628a("ro.build.characteristics");
    }

    public static String e() {
        return m628a("ro.product.manufacturer");
    }

    static {
        Covode.recordClassIndex(655618);
        a = 0;
        b = -1;
        f840a = null;
    }

    /* renamed from: e, reason: collision with other method in class */
    public static boolean m637e() {
        String str = "";
        try {
            str = p.a("ro.miui.ui.version.code", "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(str);
    }

    /* renamed from: c, reason: collision with other method in class */
    public static boolean m635c() {
        if (b < 0) {
            b = !m637e() ? 1 : 0;
        }
        if (b > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: d, reason: collision with other method in class */
    public static boolean m636d() {
        return !m.China.name().equalsIgnoreCase(a(b()).name());
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m627a() {
        int a2 = q.a();
        if (m630a() && a2 > 0) {
            if (a2 < 2) {
                return "alpha";
            }
            if (a2 < 3) {
                return "development";
            }
            return "stable";
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a() {
        /*
            int r0 = com.xiaomi.push.j.a
            if (r0 != 0) goto L47
            r0 = 0
            java.lang.String r1 = "ro.miui.ui.version.code"
            java.lang.String r1 = m628a(r1)     // Catch: java.lang.Throwable -> L29
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L29
            r2 = 1
            if (r1 == 0) goto L21
            java.lang.String r1 = "ro.miui.ui.version.name"
            java.lang.String r1 = m628a(r1)     // Catch: java.lang.Throwable -> L29
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L29
            if (r1 != 0) goto L1f
            goto L21
        L1f:
            r1 = 0
            goto L22
        L21:
            r1 = 1
        L22:
            if (r1 == 0) goto L25
            goto L26
        L25:
            r2 = 2
        L26:
            com.xiaomi.push.j.a = r2     // Catch: java.lang.Throwable -> L29
            goto L31
        L29:
            r1 = move-exception
            java.lang.String r2 = "get isMIUI failed"
            com.xiaomi.channel.commonutils.logger.b.a(r2, r1)
            com.xiaomi.push.j.a = r0
        L31:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isMIUI's value is: "
            r0.append(r1)
            int r1 = com.xiaomi.push.j.a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.b(r0)
        L47:
            int r0 = com.xiaomi.push.j.a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.j.a():int");
    }

    /* renamed from: b, reason: collision with other method in class */
    public static boolean m634b() {
        if (a() == 2) {
            return true;
        }
        return false;
    }

    public static String b() {
        String a2 = p.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = m633b(p.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a2)) {
            a2 = p.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("get region from system, region = " + a2);
        }
        if (TextUtils.isEmpty(a2)) {
            String country = Locale.getDefault().getCountry();
            com.xiaomi.channel.commonutils.logger.b.m54a("locale.default.country = " + country);
            return country;
        }
        return a2;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static void m629a() {
        if (f840a != null) {
            return;
        }
        HashMap hashMap = new HashMap();
        f840a = hashMap;
        hashMap.put("CN", m.China);
        Map<String, m> map = f840a;
        m mVar = m.Europe;
        map.put("FI", mVar);
        f840a.put("SE", mVar);
        f840a.put("NO", mVar);
        f840a.put("FO", mVar);
        f840a.put("EE", mVar);
        f840a.put("LV", mVar);
        f840a.put("LT", mVar);
        f840a.put("BY", mVar);
        f840a.put("MD", mVar);
        f840a.put("UA", mVar);
        f840a.put("PL", mVar);
        f840a.put("CZ", mVar);
        f840a.put("SK", mVar);
        f840a.put("HU", mVar);
        f840a.put("DE", mVar);
        f840a.put("AT", mVar);
        f840a.put("CH", mVar);
        f840a.put("LI", mVar);
        f840a.put("GB", mVar);
        f840a.put("IE", mVar);
        f840a.put("NL", mVar);
        f840a.put("BE", mVar);
        f840a.put("LU", mVar);
        f840a.put("FR", mVar);
        f840a.put("RO", mVar);
        f840a.put("BG", mVar);
        f840a.put("RS", mVar);
        f840a.put("MK", mVar);
        f840a.put("AL", mVar);
        f840a.put("GR", mVar);
        f840a.put("SI", mVar);
        f840a.put("HR", mVar);
        f840a.put("IT", mVar);
        f840a.put("SM", mVar);
        f840a.put("MT", mVar);
        f840a.put("ES", mVar);
        f840a.put("PT", mVar);
        f840a.put("AD", mVar);
        f840a.put("CY", mVar);
        f840a.put("DK", mVar);
        f840a.put("IS", mVar);
        f840a.put("UK", mVar);
        f840a.put("EL", mVar);
        f840a.put("RU", m.Russia);
        f840a.put("IN", m.India);
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m632a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static m a(String str) {
        m b2 = b(str);
        if (b2 == null) {
            return m.Global;
        }
        return b2;
    }

    public static int b(Context context) {
        try {
            return INVOKEVIRTUAL_com_xiaomi_push_j_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), "com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int a(Context context) {
        String m628a = m628a("ro.miui.ui.version.code");
        if (!TextUtils.isEmpty(m628a) && TextUtils.isDigitsOnly(m628a)) {
            return Integer.parseInt(m628a);
        }
        return 0;
    }

    private static m b(String str) {
        m629a();
        return f840a.get(str.toUpperCase());
    }

    /* renamed from: b, reason: collision with other method in class */
    private static String m633b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("-");
            if (split.length > 0) {
                return split[0];
            }
            return str;
        }
        return str;
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append("null");
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    sb.append(Arrays.toString((int[]) obj));
                } else if (obj instanceof byte[]) {
                    sb.append(Arrays.toString((byte[]) obj));
                } else if (obj instanceof boolean[]) {
                    sb.append(Arrays.toString((boolean[]) obj));
                } else if (obj instanceof short[]) {
                    sb.append(Arrays.toString((short[]) obj));
                } else if (obj instanceof long[]) {
                    sb.append(Arrays.toString((long[]) obj));
                } else if (obj instanceof float[]) {
                    sb.append(Arrays.toString((float[]) obj));
                } else if (obj instanceof double[]) {
                    sb.append(Arrays.toString((double[]) obj));
                } else if (obj instanceof String[]) {
                    sb.append(Arrays.toString((String[]) obj));
                } else if (obj instanceof CharSequence[]) {
                    sb.append(Arrays.toString((CharSequence[]) obj));
                } else if (obj instanceof Parcelable[]) {
                    sb.append(Arrays.toString((Parcelable[]) obj));
                } else if (obj instanceof Bundle) {
                    sb.append(a((Bundle) obj));
                } else {
                    sb.append(obj);
                }
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m628a(String str) {
        try {
            try {
                return (String) av.a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to get property. " + e);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_j_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_xiaomi_push_j_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_xiaomi_push_j_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_j_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_xiaomi_push_j_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_xiaomi_push_j_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_xiaomi_push_j_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_xiaomi_push_j_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_xiaomi_push_j_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_xiaomi_push_j_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_xiaomi_push_j_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }
}
