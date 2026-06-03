package com.xiaomi.push;

import com.bytedance.covode.number.Covode;
import java.net.InetSocketAddress;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class cd {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private String f185a;

    static {
        Covode.recordClassIndex(655406);
    }

    public int a() {
        return this.a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m230a() {
        return this.f185a;
    }

    public String toString() {
        if (this.a > 0) {
            return this.f185a + ":" + this.a;
        }
        return this.f185a;
    }

    public cd(String str, int i) {
        this.f185a = str;
        this.a = i;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static InetSocketAddress m229a(String str, int i) {
        cd a = a(str, i);
        return new InetSocketAddress(a.m230a(), a.a());
    }

    public static cd a(String str, int i) {
        int lastIndexOf = str.lastIndexOf(":");
        if (lastIndexOf != -1) {
            String substring = str.substring(0, lastIndexOf);
            try {
                int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                if (parseInt > 0) {
                    i = parseInt;
                }
            } catch (NumberFormatException unused) {
            }
            str = substring;
        }
        return new cd(str, i);
    }
}
