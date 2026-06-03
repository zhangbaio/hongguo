package com.dragon.read.component.shortvideo.api.docker.viewmamanager;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    static {
        Covode.recordClassIndex(598701);
    }

    public static final b a(int i, boolean z) {
        if (z) {
            return new b(HandlerStyleType.Inner);
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 3 && i != 4) {
                    return new b(HandlerStyleType.Others);
                }
                return new b(HandlerStyleType.Special);
            }
            return new b(HandlerStyleType.Outer);
        }
        return new b(HandlerStyleType.Inner);
    }
}
