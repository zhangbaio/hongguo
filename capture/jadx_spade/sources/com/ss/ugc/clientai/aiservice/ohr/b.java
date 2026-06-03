package com.ss.ugc.clientai.aiservice.ohr;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class b {
    public long a;
    public int b;
    public final xi6.b c;

    static {
        Covode.recordClassIndex(652785);
    }

    public b(xi6.b engineFactory) {
        Intrinsics.checkNotNullParameter(engineFactory, "engineFactory");
        this.c = engineFactory;
        this.a = 5000L;
        this.b = 9;
    }
}
