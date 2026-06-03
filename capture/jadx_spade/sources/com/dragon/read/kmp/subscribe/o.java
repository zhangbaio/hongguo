package com.dragon.read.kmp.subscribe;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.NsShortVideoApi;
import java.util.List;
import kotlin.Pair;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    static {
        Covode.recordClassIndex(609441);
    }

    public static final void b() {
        NsShortVideoApi.IMPL.getSeriesSubscribeManager().a();
    }

    public static final void a(List<Pair<String, Boolean>> list) {
        NsShortVideoApi.IMPL.onSeriesReserveStateChange(list);
    }
}
