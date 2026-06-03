package com.xiaomi.push;

import android.content.Context;
import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class dl extends dk {
    static {
        Covode.recordClassIndex(655448);
    }

    @Override // com.xiaomi.push.ad.a
    /* renamed from: a */
    public String mo187a() {
        return "23";
    }

    @Override // com.xiaomi.push.dk
    public gg a() {
        return gg.Storage;
    }

    @Override // com.xiaomi.push.dk
    public String b() {
        return "ram:" + i.m618a() + ",rom:" + i.m623b() + "|ramOriginal:" + i.c() + ",romOriginal:" + i.d();
    }

    public dl(Context context, int i) {
        super(context, i);
    }
}
