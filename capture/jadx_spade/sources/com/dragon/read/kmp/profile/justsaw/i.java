package com.dragon.read.kmp.profile.justsaw;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import gk4.q;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i {
    public static final int f;
    private boolean a;
    public boolean b;
    private final MutableState c;
    private final MutableState d;
    private final MutableState e;

    static {
        Covode.recordClassIndex(608196);
        f = 8;
    }

    public final void a() {
        h(false);
    }

    public final void k() {
        h(true);
    }

    public final boolean b() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) this.c.getValue()).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    public final void f() {
        i(false);
        b.a.f();
    }

    public final void g() {
        h(false);
        this.a = false;
        i(false);
    }

    public i() {
        Boolean bool = Boolean.FALSE;
        this.c = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.d = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.e = SnapshotStateKt.mutableStateOf$default(bool, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final boolean l() {
        boolean z = false;
        if (!this.b && !e()) {
            b bVar = b.a;
            if (!bVar.d()) {
                if (q.Companion.a().c && !bVar.c()) {
                    z = true;
                }
                i(z);
                j(true);
                return true;
            }
        }
        com.dragon.read.kmp.j.a.d("JustSawView", "Show skipped: foreverGone=" + this.b);
        return false;
    }

    public final void c(boolean z) {
        j(false);
        if (!z) {
            this.b = true;
        }
        g();
    }

    public final void h(boolean z) {
        this.c.setValue(Boolean.valueOf(z));
    }

    public final void i(boolean z) {
        this.e.setValue(Boolean.valueOf(z));
    }

    public final void j(boolean z) {
        this.d.setValue(Boolean.valueOf(z));
    }
}
