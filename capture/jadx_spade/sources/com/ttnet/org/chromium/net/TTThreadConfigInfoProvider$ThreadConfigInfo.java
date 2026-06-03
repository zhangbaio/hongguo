package com.ttnet.org.chromium.net;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTThreadConfigInfoProvider$ThreadConfigInfo {
    public TTThreadConfigInfoProvider$ThreadType a;
    public int b = 20;
    public int c;

    static {
        Covode.recordClassIndex(654542);
    }

    public int getThreadPriority() {
        return this.b;
    }

    public int getThreadStackSize() {
        return this.c;
    }

    public int getThreadType() {
        return this.a.ordinal();
    }
}
