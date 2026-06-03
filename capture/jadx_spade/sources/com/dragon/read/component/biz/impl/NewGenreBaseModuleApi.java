package com.dragon.read.component.biz.impl;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsNewGenreBaseApi;
import com.dragon.read.component.biz.impl.ui.y;
import dm3.a;
import dm3.b;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class NewGenreBaseModuleApi implements NsNewGenreBaseApi {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588091);
    }

    public b createNewGenreBookShelfPresenter(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new y(listener);
    }
}
