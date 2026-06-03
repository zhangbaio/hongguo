package com.dragon.read.kmp.story.impl.feeds.data;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    public static final int g;
    private final Lazy a;
    public boolean b;
    public boolean c;
    private final MutableState d;
    private final MutableState e;
    public final MutableState<Boolean> f;

    static {
        Covode.recordClassIndex(609267);
        g = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tp4.b g() {
        return new tp4.b("StoryContentState");
    }

    private final tp4.b b() {
        return (tp4.b) this.a.getValue();
    }

    public final boolean c() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    public final boolean d() {
        if (this.b && this.c && !c()) {
            return true;
        }
        return false;
    }

    public d() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.story.impl.feeds.data.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                tp4.b g2;
                g2 = d.g();
                return g2;
            }
        });
        this.a = lazy;
        this.b = true;
        this.d = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        Boolean bool = Boolean.FALSE;
        this.e = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.f = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final boolean e() {
        boolean z;
        boolean z2 = this.b;
        if (z2 && ((!z2 || this.c) && (!z2 || !this.c || !c()))) {
            z = false;
        } else {
            z = true;
        }
        b().a("isRealExpandState: " + z + ", isEnableFold: " + this.b + ", isShowFoldAndExpand: " + this.c + ", isExpanded: " + c());
        return z;
    }

    public final void h(boolean z) {
        this.d.setValue(Boolean.valueOf(z));
    }

    public final void i(boolean z) {
        this.e.setValue(Boolean.valueOf(z));
    }
}
