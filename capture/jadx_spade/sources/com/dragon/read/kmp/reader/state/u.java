package com.dragon.read.kmp.reader.state;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.api.NsReaderServiceApi;
import com.dragon.read.component.biz.interfaces.NsReaderActivity;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class u {
    static {
        Covode.recordClassIndex(608585);
    }

    public static final int a(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (context instanceof NsReaderActivity) {
            return ((NsReaderActivity) context).i2().getTheme();
        }
        return NsReaderServiceApi.IMPL.readerInitConfigService().n().f();
    }
}
