package com.dragon.read.kmp.search.searchlinkpage;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class d0 {
    public static final int d;
    public boolean a;
    public MutableStateFlow<Boolean> b;
    public boolean c;

    static {
        Covode.recordClassIndex(608792);
        d = 8;
    }

    public d0() {
        this(false, null, false, 7, null);
    }

    public abstract String a();

    public d0(boolean z, MutableStateFlow<Boolean> add, boolean z2) {
        Intrinsics.checkNotNullParameter(add, "add");
        this.a = z;
        this.b = add;
        this.c = z2;
    }

    public /* synthetic */ d0(boolean z, MutableStateFlow mutableStateFlow, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? StateFlowKt.MutableStateFlow(Boolean.FALSE) : mutableStateFlow, (i & 4) != 0 ? false : z2);
    }
}
