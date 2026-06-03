package com.dragon.read.kmp.reader.services;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.NetworkListener;
import com.dragon.read.base.util.NetworkManager;
import com.dragon.read.util.NetworkUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z implements i {
    public static final z a;

    static {
        Covode.recordClassIndex(608556);
        a = new z();
    }

    private z() {
    }

    @Override // com.dragon.read.kmp.reader.services.i
    public boolean isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailable();
    }

    @Override // com.dragon.read.kmp.reader.services.i
    public void T4(final wf4.c onConnect) {
        Intrinsics.checkNotNullParameter(onConnect, "onConnect");
        NetworkManager.getInstance().register(new NetworkListener() { // from class: com.dragon.read.kmp.reader.services.y
            public final void onNetworkConnect(boolean z) {
                z.F0(onConnect, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(wf4.c cVar, boolean z) {
        cVar.a();
    }
}
