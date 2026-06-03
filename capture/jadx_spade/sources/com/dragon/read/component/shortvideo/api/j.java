package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.model.WalletAccountInfo;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface j {
    Object a(Continuation<? super WalletAccountInfo> continuation);

    m34.b b(String str, boolean z);

    StateFlow<m34.b> c(String str);

    void d(String str);

    void release(String str);

    public static final class a {
        static {
            Covode.recordClassIndex(598136);
        }

        public static /* synthetic */ m34.b a(j jVar, String str, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                return jVar.b(str, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSeriesPayDetailFromCache");
        }
    }
}
