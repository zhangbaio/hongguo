package com.dragon.read.kmp.reader.download;

import android.content.Context;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.biz.interfaces.NsReaderActivity;
import com.dragon.read.reader.ui.y0;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k {
    static {
        Covode.recordClassIndex(608413);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(wf4.d dVar, boolean z) {
        dVar.a(z);
        return Unit.INSTANCE;
    }

    public static final Boolean b(Context context, String bookId, boolean z, final wf4.d startDownloadAction) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(startDownloadAction, "startDownloadAction");
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.dragon.read.component.biz.interfaces.NsReaderActivity");
        NsReaderActivity nsReaderActivity = (NsReaderActivity) context;
        r45.l f = y0.f(nsReaderActivity);
        if (f != null) {
            return Boolean.valueOf(f.f3(nsReaderActivity, z, new Function1() { // from class: com.dragon.read.kmp.reader.download.j
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit c;
                    c = k.c(startDownloadAction, ((Boolean) obj).booleanValue());
                    return c;
                }
            }));
        }
        return null;
    }
}
