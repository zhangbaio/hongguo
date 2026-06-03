package com.dragon.read.kmp.reader.services;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsReaderServiceApi;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d0 implements m {
    public static final d0 a;
    private static final HashMap<fm4.b, fm4.e> b;
    public static final int c;

    private d0() {
    }

    @Override // com.dragon.read.kmp.reader.services.m
    public fm4.c O() {
        return fm4.g.a;
    }

    static {
        Covode.recordClassIndex(608560);
        a = new d0();
        b = new HashMap<>();
        c = 8;
    }

    @Override // com.dragon.read.kmp.reader.services.m
    public void b2(fm4.b creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        fm4.e eVar = new fm4.e(creator);
        b.put(creator, eVar);
        NsReaderServiceApi.IMPL.readerLifecycleService().a(eVar);
    }
}
