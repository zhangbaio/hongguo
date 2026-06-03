package com.dragon.read.kmp.reader.utils;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.component.biz.interfaces.NsReaderActivity;
import com.dragon.read.kmp.utils.n0;
import com.dragon.read.reader.utils.v1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public static final m a;

    static {
        Covode.recordClassIndex(608656);
        a = new m();
    }

    private m() {
    }

    public final void a(Context context, String content, ym4.a aVar) {
        Args args;
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.dragon.read.component.biz.interfaces.NsReaderActivity");
        NsReaderActivity nsReaderActivity = (NsReaderActivity) context;
        if (aVar != null) {
            args = n0.a(aVar);
        } else {
            args = null;
        }
        v1.f(nsReaderActivity, content, args);
    }
}
