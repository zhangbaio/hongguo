package com.dragon.read.kmp.utils;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.http.exception.ErrorCodeException;
import com.dragon.read.kmp.compose.ToastDuration;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class y {
    public static final y a;

    static {
        Covode.recordClassIndex(609544);
        a = new y();
    }

    private y() {
    }

    public final boolean a(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (!(throwable instanceof ErrorCodeException)) {
            return false;
        }
        switch (((ErrorCodeException) throwable).getCode()) {
            case 101143:
                ig4.g.b("手速太快，请稍后再试", (ToastDuration) null, 2, (Object) null);
                return true;
            case 101144:
                ig4.g.b("预约失败，请稍后再试", (ToastDuration) null, 2, (Object) null);
                return true;
            default:
                return false;
        }
    }
}
