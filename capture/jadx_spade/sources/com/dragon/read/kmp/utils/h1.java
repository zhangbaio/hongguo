package com.dragon.read.kmp.utils;

import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface h1 {

    public static final class a {
        static {
            Covode.recordClassIndex(609583);
        }

        public static <T> void a(h1 h1Var, VMStateFlow<T> receiver, T t) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            if (h1Var instanceof ViewModel) {
                receiver.b(t);
                return;
            }
            throw new IllegalStateException("must in vm".toString());
        }
    }
}
