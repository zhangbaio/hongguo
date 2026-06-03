package com.dragon.read.kmp.reader.services;

import android.content.Context;
import android.view.Window;
import com.bytedance.covode.number.Covode;
import com.dragon.read.reader.ui.ReaderActivity;
import com.dragon.read.reader.utils.e2;
import com.dragon.read.util.r8;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s implements d {
    public static final s a;

    static {
        Covode.recordClassIndex(608551);
        a = new s();
    }

    private s() {
    }

    @Override // com.dragon.read.kmp.reader.services.d
    public void B4(Context context, boolean z) {
        ReaderActivity readerActivity;
        if (context instanceof ReaderActivity) {
            readerActivity = (ReaderActivity) context;
        } else {
            readerActivity = null;
        }
        if (readerActivity != null && readerActivity.getWindow() != null) {
            if (z) {
                e2.k(readerActivity);
                return;
            }
            Window window = readerActivity.getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
            r8.c(window);
            readerActivity.getWindow().addFlags(1024);
        }
    }
}
