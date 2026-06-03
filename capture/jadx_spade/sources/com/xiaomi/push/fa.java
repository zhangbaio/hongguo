package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class fa implements Cloneable {
    public static String a;
    public static String b;

    /* renamed from: a, reason: collision with other field name */
    private int f441a;

    /* renamed from: a, reason: collision with other field name */
    private fd f442a;

    /* renamed from: a, reason: collision with other field name */
    private boolean f443a = ez.f426a;

    /* renamed from: b, reason: collision with other field name */
    private boolean f444b = true;
    private String c;
    private String d;
    private String e;

    /* renamed from: a, reason: collision with other method in class */
    public byte[] mo426a() {
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m424a() {
        return this.f441a;
    }

    public String b() {
        return this.e;
    }

    static {
        Covode.recordClassIndex(655515);
        a = "wcc-ml-test10.bj";
        b = null;
    }

    public String c() {
        if (this.d == null) {
            this.d = a();
        }
        return this.d;
    }

    public static final String a() {
        String str = b;
        if (str != null) {
            return str;
        }
        if (w.m770a()) {
            return "sandbox.xmpush.xiaomi.com";
        }
        if (w.b()) {
            return "10.38.162.35";
        }
        return "app.chat.xiaomi.net";
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m425a() {
        return this.f443a;
    }

    public void c(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public static final void a(String str) {
        if (w.b()) {
            return;
        }
        b = str;
    }

    public void a(boolean z) {
        this.f443a = z;
    }

    private void a(Map<String, Integer> map, int i, String str, fd fdVar) {
        this.f441a = i;
        this.c = str;
        this.f442a = fdVar;
    }

    public fa(Map<String, Integer> map, int i, String str, fd fdVar) {
        a(map, i, str, fdVar);
    }
}
