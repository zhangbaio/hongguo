package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class m {
    public static final boolean a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static final boolean e;
    private static Method f;
    private static String g;
    private static String h;

    static {
        Covode.recordClassIndex(655198);
        a = ah.b("ro.vivo.product.overseas", "no").equals("yes");
        b = b("rom_1.0");
        c = b("rom_2.0");
        d = b("rom_2.5");
        e = b("rom_3.0");
        g = null;
        h = null;
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            t.d("Device", "Build.MANUFACTURER is null");
            return false;
        }
        t.d("Device", "Build.MANUFACTURER is " + str);
        if (!str.toLowerCase().contains("bbk") && !str.toLowerCase().startsWith("vivo")) {
            return false;
        }
        return true;
    }

    public static synchronized String a() {
        synchronized (m.class) {
            if (g == null && h == null) {
                try {
                    Method declaredMethod = l3.a.q("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class);
                    f = declaredMethod;
                    declaredMethod.setAccessible(true);
                    g = (String) f.invoke(null, "ro.vivo.rom", "@><@");
                    h = (String) f.invoke(null, "ro.vivo.rom.version", "@><@");
                } catch (Exception unused) {
                    t.b("Device", "getRomCode error");
                }
            }
            t.d("Device", "sRomProperty1 : " + g + " ; sRomProperty2 : " + h);
            String a2 = a(g);
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
            String a3 = a(h);
            if (TextUtils.isEmpty(a3)) {
                return null;
            }
            return a3;
        }
    }

    private static String a(String str) {
        String substring;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(matcher.group(1));
        if (TextUtils.isEmpty(matcher.group(2))) {
            substring = "0";
        } else {
            substring = matcher.group(2).substring(0, 1);
        }
        sb.append(substring);
        return sb.toString();
    }

    private static boolean b(String str) {
        String b2 = ah.b("ro.vivo.rom", "");
        String b3 = ah.b("ro.vivo.rom.version", "");
        t.d("Device", "ro.vivo.rom = " + b2 + " ; ro.vivo.rom.version = " + b3);
        if (b2 == null || !b2.contains(str)) {
            if (b3 != null && b3.contains(str)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) l3.a.q("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = str2;
        }
        if (str3 != null && str3.length() != 0) {
            return str3;
        }
        return str2;
    }
}
