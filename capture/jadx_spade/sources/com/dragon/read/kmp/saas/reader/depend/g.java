package com.dragon.read.kmp.saas.reader.depend;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsReaderDepend;
import dm4.m;
import m25.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g implements m {
    public static final g a;

    static {
        Covode.recordClassIndex(608728);
        a = new g();
    }

    private g() {
    }

    @Override // dm4.m
    public boolean isPlaying(String str) {
        o playerDepend = NsReaderDepend.IMPL.playerDepend();
        if (playerDepend != null) {
            return playerDepend.isPlaying(str);
        }
        return false;
    }
}
