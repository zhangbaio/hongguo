package vn4;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.annotation.BDExportToObjc;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import un4.j;

@BDExportToObjc
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends j {
    public static final int u;
    private final String o;
    public final String p;
    public final b q;
    private final MutableState r;
    private final MutableState s;
    public String t;

    static {
        Covode.recordClassIndex(608941);
        u = 8;
    }

    public final String getType() {
        return this.o;
    }

    public final boolean k() {
        return this.q.a;
    }

    public final String g() {
        c f = f();
        if (f != null) {
            return f.b;
        }
        return null;
    }

    public final String h() {
        c f = f();
        if (f != null) {
            return f.a;
        }
        return null;
    }

    public final d i() {
        c f = f();
        if (f != null) {
            return f.c;
        }
        return null;
    }

    public final int j() {
        return ((Number) this.s.getValue()).intValue();
    }

    public final boolean l() {
        return ((Boolean) this.r.getValue()).booleanValue();
    }

    public final c f() {
        int coerceAtLeast;
        List<c> list = this.q.b;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j(), 0);
        return (c) CollectionsKt___CollectionsKt.getOrNull(list, coerceAtLeast);
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.t = str;
    }

    public final void n(boolean z) {
        this.r.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String type, String scene, String entrance, String groupId, String itemDataValue, b posterContent, yn4.b bVar) {
        super(scene, entrance, groupId, bVar);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(itemDataValue, "itemDataValue");
        Intrinsics.checkNotNullParameter(posterContent, "posterContent");
        this.o = type;
        this.p = itemDataValue;
        this.q = posterContent;
        this.r = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.s = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.t = "";
        d(itemDataValue);
    }
}
