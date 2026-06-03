package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public abstract class cg {
    private int a;

    static {
        Covode.recordClassIndex(655411);
    }

    public abstract String a(Context context, String str, List<as> list);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m243a(Context context, String str, List<as> list) {
        return true;
    }

    public int a() {
        return this.a;
    }

    public cg(int i) {
        this.a = i;
    }
}
