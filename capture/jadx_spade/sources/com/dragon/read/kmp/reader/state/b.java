package com.dragon.read.kmp.reader.state;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.l0;
import androidx.compose.ui.graphics.n0;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.annotation.BDExportToObjc;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b extends ViewModel {
    public static final int m;
    private final MutableState<a> a;
    public final State<a> b;
    private final MutableState<l0> c;
    public final State<l0> d;
    private final MutableState<l0> e;
    public final State<l0> f;
    private final MutableState<l0> g;
    public final State<l0> h;
    private int i;
    private ReaderBgColorType j;
    private String k;
    private final List<Function3<Integer, Integer, Integer, Unit>> l;

    static {
        Covode.recordClassIndex(608568);
        m = 8;
    }

    public b() {
        String str = null;
        MutableState<a> mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(new a(null, null, null, null, null, null, null, null, null, null, null, null, null, str, str, null, null, null, null, null, null, null, null, null, false, 33554431, null), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.a = mutableStateOf$default;
        this.b = mutableStateOf$default;
        l0.a aVar = l0.b;
        MutableState<l0> mutableStateOf$default2 = SnapshotStateKt.mutableStateOf$default(l0.j(aVar.h()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.c = mutableStateOf$default2;
        this.d = mutableStateOf$default2;
        MutableState<l0> mutableStateOf$default3 = SnapshotStateKt.mutableStateOf$default(l0.j(aVar.h()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.e = mutableStateOf$default3;
        this.f = mutableStateOf$default3;
        MutableState<l0> mutableStateOf$default4 = SnapshotStateKt.mutableStateOf$default(l0.j(aVar.h()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.g = mutableStateOf$default4;
        this.h = mutableStateOf$default4;
        this.i = 1;
        this.j = ReaderBgColorType.STANDARD;
        this.k = "";
        this.l = new ArrayList();
    }

    public final void G0(Function3<? super Integer, ? super Integer, ? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.l.remove(listener);
    }

    public final void H0(a newState) {
        String str;
        Intrinsics.checkNotNullParameter(newState, "newState");
        str = BookCoverViewModelKt.a;
        com.dragon.read.kmp.base.util.b.a(str, "setState " + newState);
        this.a.setValue(newState);
        if (!Intrinsics.areEqual(this.k, newState.v)) {
            this.k = newState.v;
            F0(newState, this.i, this.j);
        }
    }

    public final void J0(boolean z) {
        a a;
        MutableState<a> mutableState = this.a;
        a = r0.a((r43 & 1) != 0 ? r0.a : null, (r43 & 2) != 0 ? r0.b : null, (r43 & 4) != 0 ? r0.c : null, (r43 & 8) != 0 ? r0.d : null, (r43 & 16) != 0 ? r0.e : null, (r43 & 32) != 0 ? r0.f : null, (r43 & 64) != 0 ? r0.g : null, (r43 & 128) != 0 ? r0.h : null, (r43 & 256) != 0 ? r0.i : null, (r43 & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) != 0 ? r0.j : null, (r43 & 1024) != 0 ? r0.k : null, (r43 & 2048) != 0 ? r0.l : null, (r43 & 4096) != 0 ? r0.m : null, (r43 & 8192) != 0 ? r0.n : null, (r43 & 16384) != 0 ? r0.o : null, (r43 & 32768) != 0 ? r0.p : null, (r43 & 65536) != 0 ? r0.q : null, (r43 & 131072) != 0 ? r0.r : null, (r43 & 262144) != 0 ? r0.s : null, (r43 & 524288) != 0 ? r0.t : null, (r43 & 1048576) != 0 ? r0.u : null, (r43 & 2097152) != 0 ? r0.v : null, (r43 & 4194304) != 0 ? r0.w : null, (r43 & 8388608) != 0 ? r0.x : null, (r43 & 16777216) != 0 ? ((a) mutableState.getValue()).y : z);
        mutableState.setValue(a);
    }

    public final void E0(Function3<? super Integer, ? super Integer, ? super Integer, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.l.contains(listener)) {
            this.l.add(listener);
            if (!l0.p(((l0) this.e.getValue()).x(), l0.b.h())) {
                listener.invoke(Integer.valueOf(n0.k(((l0) this.e.getValue()).x())), Integer.valueOf(n0.k(((l0) this.c.getValue()).x())), Integer.valueOf(n0.k(((l0) this.g.getValue()).x())));
            }
        }
    }

    public final void I0(int i, ReaderBgColorType bgType) {
        Intrinsics.checkNotNullParameter(bgType, "bgType");
        if (this.i != i || this.j != bgType) {
            this.i = i;
            this.j = bgType;
            F0((a) this.a.getValue(), this.i, this.j);
        }
    }

    private final void F0(a aVar, int i, ReaderBgColorType readerBgColorType) {
        long a;
        long c;
        long b;
        boolean z;
        zl4.b b2 = zl4.c.b(i);
        String str = aVar.v;
        boolean z2 = true;
        if (!pm4.r.a(i)) {
            if (str != null && !StringsKt__StringsKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                z2 = false;
            }
        }
        if (z2) {
            if (pm4.r.a(i)) {
                a = b2.m(readerBgColorType);
            } else {
                a = zl4.h.a.m(readerBgColorType);
            }
        } else {
            a = com.dragon.read.kmp.reader.utils.d.a.a(str);
        }
        if (z2) {
            c = b2.o();
        } else {
            c = com.dragon.read.kmp.reader.utils.d.a.c(a);
        }
        if (z2) {
            b = b2.u();
        } else {
            b = com.dragon.read.kmp.reader.utils.d.a.b(a);
        }
        this.g.setValue(l0.j(b));
        this.c.setValue(l0.j(c));
        if (!l0.p(((l0) this.e.getValue()).x(), a)) {
            this.e.setValue(l0.j(a));
            Iterator<T> it2 = this.l.iterator();
            while (it2.hasNext()) {
                ((Function3) it2.next()).invoke(Integer.valueOf(n0.k(a)), Integer.valueOf(n0.k(c)), Integer.valueOf(n0.k(b)));
            }
        }
    }
}
