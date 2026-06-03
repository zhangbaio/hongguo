package com.vv;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b {
    public static b b;
    public a a;

    public static b a() {
        return b;
    }

    static {
        Covode.recordClassIndex(655228);
        b = new b();
    }

    public void b(int i) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.onNotifyGuideDialogResult(i);
            this.a = null;
        }
    }
}
