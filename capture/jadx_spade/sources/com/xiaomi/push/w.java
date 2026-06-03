package com.xiaomi.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class w {
    private static int a;

    /* renamed from: a, reason: collision with other field name */
    public static final String f1038a;

    /* renamed from: a, reason: collision with other field name */
    public static boolean f1039a;

    public static int a() {
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m770a() {
        if (a == 2) {
            return true;
        }
        return false;
    }

    public static boolean b() {
        if (a == 3) {
            return true;
        }
        return false;
    }

    static {
        String str;
        Covode.recordClassIndex(655756);
        if (z.a) {
            str = "ONEBOX";
        } else {
            str = "@SHIP.TO.2A2FE0D7@";
        }
        f1038a = str;
        f1039a = false;
        a = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            a = 2;
        } else if (str.equalsIgnoreCase("ONEBOX")) {
            a = 3;
        } else {
            a = 1;
        }
    }

    public static void a(int i) {
        a = i;
    }
}
