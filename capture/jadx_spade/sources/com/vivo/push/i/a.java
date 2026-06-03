package com.vivo.push.i;

import com.bytedance.covode.number.Covode;
import java.util.ArrayList;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private static String[] a;
    private ArrayList<String> b;

    /* renamed from: com.vivo.push.i.a$a, reason: collision with other inner class name */
    private static class C0126a {
        private static a a;

        static {
            Covode.recordClassIndex(655083);
            a = new a((byte) 0);
        }
    }

    public static a a() {
        return C0126a.a;
    }

    private a() {
        this.b = null;
        this.b = new ArrayList<>();
    }

    public final boolean b() {
        ArrayList<String> arrayList = this.b;
        if (arrayList != null && arrayList.size() != 0) {
            return true;
        }
        return false;
    }

    static {
        Covode.recordClassIndex(655082);
        a = new String[]{"com.vivo.pushservice", "com.vivo.pushdemo.test", "com.vivo.sdk.test"};
    }

    /* synthetic */ a(byte b) {
        this();
    }
}
