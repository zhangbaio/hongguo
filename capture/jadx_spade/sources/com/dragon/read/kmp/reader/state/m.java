package com.dragon.read.kmp.reader.state;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.annotation.BDExportToObjc;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import com.dragon.read.kmp.reader.background.ReaderBgType;
import kotlin.jvm.internal.Intrinsics;
import xf4.e;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m extends ViewModel {
    public static final int c;
    private final MutableState<a> a;
    public final State<a> b;

    static {
        Covode.recordClassIndex(608581);
        c = 8;
    }

    public m() {
        MutableState<a> mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(E0(), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.a = mutableStateOf$default;
        this.b = mutableStateOf$default;
    }

    private final a E0() {
        int theme;
        Context b = ig4.f.b();
        if (b != null) {
            theme = u.a(b);
        } else {
            theme = xf4.e.p3.a().H5().getTheme();
        }
        e.a aVar = xf4.e.p3;
        int h5 = aVar.a().H5().h5();
        ReaderBgColorType a2 = ReaderBgColorType.Companion.a(h5);
        boolean z4 = aVar.a().H5().z4();
        com.dragon.read.kmp.k.c(com.dragon.read.kmp.reader.utils.p.o("RSStateViewModel"), "init theme: " + theme + ", background: " + h5 + ", backgroundType: " + a2.getValue());
        return new a(theme, h5, a2, z4);
    }

    public final void F0(@ReaderBgType int i) {
        ReaderBgColorType a2 = ReaderBgColorType.Companion.a(i);
        MutableState<a> mutableState = this.a;
        mutableState.setValue(a.b((a) mutableState.getValue(), 0, i, a2, false, 9, null));
    }

    public final void G0(boolean z) {
        MutableState<a> mutableState = this.a;
        mutableState.setValue(a.b((a) mutableState.getValue(), 0, 0, null, z, 7, null));
    }

    public final void H0(int i) {
        MutableState<a> mutableState = this.a;
        mutableState.setValue(a.b((a) mutableState.getValue(), i, 0, null, false, 14, null));
    }

    public static final class a {
        public final int a;
        public final int b;
        public final ReaderBgColorType c;
        public final boolean d;

        static {
            Covode.recordClassIndex(608582);
        }

        public static /* synthetic */ a b(a aVar, int i, int i2, ReaderBgColorType readerBgColorType, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = aVar.a;
            }
            if ((i3 & 2) != 0) {
                i2 = aVar.b;
            }
            if ((i3 & 4) != 0) {
                readerBgColorType = aVar.c;
            }
            if ((i3 & 8) != 0) {
                z = aVar.d;
            }
            return aVar.a(i, i2, readerBgColorType, z);
        }

        public final a a(int i, int i2, ReaderBgColorType backgroundType, boolean z) {
            Intrinsics.checkNotNullParameter(backgroundType, "backgroundType");
            return new a(i, i2, backgroundType, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
        }

        public int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + this.c.hashCode()) * 31) + androidx.compose.animation.m.a(this.d);
        }

        public String toString() {
            return "ReaderState(theme=" + this.a + ", background=" + this.b + ", backgroundType=" + this.c + ", isInSplitMode=" + this.d + ')';
        }

        public a(int i, int i2, ReaderBgColorType backgroundType, boolean z) {
            Intrinsics.checkNotNullParameter(backgroundType, "backgroundType");
            this.a = i;
            this.b = i2;
            this.c = backgroundType;
            this.d = z;
        }
    }
}
