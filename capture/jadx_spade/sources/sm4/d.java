package sm4;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class d implements gk4.f {
    public final b a;
    private boolean b;
    public final com.dragon.read.kmp.util.f c;
    private boolean d;
    private MutableState<Boolean> e;

    static {
        Covode.recordClassIndex(608607);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public abstract String d();

    public boolean c() {
        return this.d;
    }

    public boolean e() {
        return this.b;
    }

    @Override // gk4.f
    public long a() {
        return wf4.e.a.a();
    }

    public final void b() {
        this.e.setValue(Boolean.FALSE);
    }

    public final void g() {
        this.e.setValue(Boolean.TRUE);
    }

    public final boolean f() {
        return ((Boolean) this.e.getValue()).booleanValue();
    }

    public int hashCode() {
        return d().hashCode();
    }

    public d(b bVar) {
        this.a = bVar;
        this.b = true;
        this.c = new com.dragon.read.kmp.util.f();
        this.e = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof d) && Intrinsics.areEqual(d(), ((d) obj).d())) {
            return true;
        }
        return false;
    }

    public /* synthetic */ d(b bVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bVar);
    }
}
