package com.dragon.read.kmp.shortvideo.distribution.page.tab;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b extends com.dragon.read.kmp.basenovel.ui.ui.a {
    public static final int i;
    private final SeriesRankTabViewModel h;

    static {
        Covode.recordClassIndex(609075);
        i = 8;
    }

    public boolean c() {
        return this.h.p.i();
    }

    public void f() {
        if (!c()) {
            j();
        } else {
            k();
            this.h.F(true);
        }
    }

    public b(SeriesRankTabViewModel tabViewModel) {
        Intrinsics.checkNotNullParameter(tabViewModel, "tabViewModel");
        this.h = tabViewModel;
    }
}
