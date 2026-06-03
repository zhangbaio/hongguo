package ko4;

import androidx.compose.animation.m;
import androidx.compose.runtime.MutableState;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.common.load.LoadStatus;
import com.dragon.read.kmp.compose.common.uicontext.color.Theme;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qg4.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b {
    public final LoadStatus a;
    public final boolean b;
    public final List<a> c;
    public final String d;
    public final MutableState<Boolean> e;
    public final int f;

    static {
        Covode.recordClassIndex(609073);
    }

    public b() {
        this(null, false, null, null, null, 0, 63, null);
    }

    public static /* synthetic */ b b(b bVar, LoadStatus loadStatus, boolean z, List list, String str, MutableState mutableState, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            loadStatus = bVar.a;
        }
        if ((i2 & 2) != 0) {
            z = bVar.b;
        }
        boolean z2 = z;
        if ((i2 & 4) != 0) {
            list = bVar.c;
        }
        List list2 = list;
        if ((i2 & 8) != 0) {
            str = bVar.d;
        }
        String str2 = str;
        if ((i2 & 16) != 0) {
            mutableState = bVar.e;
        }
        MutableState mutableState2 = mutableState;
        if ((i2 & 32) != 0) {
            i = bVar.f;
        }
        return bVar.a(loadStatus, z2, list2, str2, mutableState2, i);
    }

    public final b a(LoadStatus loadSate, boolean z, List<a> pageBgColors, String str, MutableState<Boolean> showRuleDialog, int i) {
        Intrinsics.checkNotNullParameter(loadSate, "loadSate");
        Intrinsics.checkNotNullParameter(pageBgColors, "pageBgColors");
        Intrinsics.checkNotNullParameter(showRuleDialog, "showRuleDialog");
        return new b(loadSate, z, pageBgColors, str, showRuleDialog, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.b == bVar.b && Intrinsics.areEqual(this.c, bVar.c) && Intrinsics.areEqual(this.d, bVar.d) && Intrinsics.areEqual(this.e, bVar.e) && this.f == bVar.f;
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + m.a(this.b)) * 31) + this.c.hashCode()) * 31;
        String str = this.d;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.e.hashCode()) * 31) + this.f;
    }

    public String toString() {
        return "SeriesRankPageUiState(loadSate=" + this.a + ", isRankingListLandingPageStyle=" + this.b + ", pageBgColors=" + this.c + ", ruleText=" + this.d + ", showRuleDialog=" + this.e + ", rankListDisplayStyle=" + this.f + ')';
    }

    public final boolean d() {
        return po4.b.e(this.f);
    }

    public final boolean e() {
        return po4.b.f(this.f);
    }

    public final a c(Number index) {
        Intrinsics.checkNotNullParameter(index, "index");
        if (e()) {
            return new a(c.a(Theme.LIGHT).b(), c.a(Theme.DARK).b(), null);
        }
        a aVar = (a) CollectionsKt___CollectionsKt.getOrNull(this.c, index.intValue());
        if (aVar == null) {
            return new a(c.a(Theme.LIGHT).b(), c.a(Theme.DARK).b(), null);
        }
        return aVar;
    }

    public b(LoadStatus loadSate, boolean z, List<a> pageBgColors, String str, MutableState<Boolean> showRuleDialog, int i) {
        Intrinsics.checkNotNullParameter(loadSate, "loadSate");
        Intrinsics.checkNotNullParameter(pageBgColors, "pageBgColors");
        Intrinsics.checkNotNullParameter(showRuleDialog, "showRuleDialog");
        this.a = loadSate;
        this.b = z;
        this.c = pageBgColors;
        this.d = str;
        this.e = showRuleDialog;
        this.f = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ b(com.dragon.read.kmp.compose.common.load.LoadStatus r5, boolean r6, java.util.List r7, java.lang.String r8, androidx.compose.runtime.MutableState r9, int r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L6
            com.dragon.read.kmp.compose.common.load.LoadStatus r5 = com.dragon.read.kmp.compose.common.load.LoadStatus.Loading
        L6:
            r12 = r11 & 2
            if (r12 == 0) goto Ld
            r6 = 0
            r12 = 0
            goto Le
        Ld:
            r12 = r6
        Le:
            r6 = r11 & 4
            if (r6 == 0) goto L17
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L17:
            r0 = r7
            r6 = r11 & 8
            r7 = 0
            if (r6 == 0) goto L1f
            r1 = r7
            goto L20
        L1f:
            r1 = r8
        L20:
            r6 = r11 & 16
            if (r6 == 0) goto L2b
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            r8 = 2
            androidx.compose.runtime.MutableState r9 = androidx.compose.runtime.SnapshotStateKt.mutableStateOf$default(r6, r7, r8, r7)
        L2b:
            r2 = r9
            r6 = r11 & 32
            if (r6 == 0) goto L36
            com.bytedance.kmp.reading.model.SelectorDisplayStyle r6 = com.bytedance.kmp.reading.model.SelectorDisplayStyle.Default
            int r10 = r6.getValue()
        L36:
            r3 = r10
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ko4.b.<init>(com.dragon.read.kmp.compose.common.load.LoadStatus, boolean, java.util.List, java.lang.String, androidx.compose.runtime.MutableState, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
