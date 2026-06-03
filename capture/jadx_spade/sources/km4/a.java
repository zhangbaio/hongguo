package km4;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import cm4.i;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.bookcover.InsertState;
import com.dragon.read.reader.ui.y0;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import r45.h;
import xf4.e;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements qm4.a {
    static {
        Covode.recordClassIndex(608473);
    }

    private final h d() {
        Context b;
        i a = e.p3.a().readerLifecycleService().O().a();
        if (a != null && (b = a.b()) != null) {
            return y0.d(b);
        }
        return null;
    }

    @Override // qm4.a
    public Pair<Function2<Composer, Integer, Unit>, State<InsertState>> a(String bookId) {
        Pair<Function2<Composer, Integer, Unit>, State<InsertState>> u;
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        h d = d();
        if (d == null || (u = d.u()) == null) {
            return new Pair<>(null, SnapshotStateKt.mutableStateOf$default(InsertState.NOT_INSERT, (SnapshotMutationPolicy) null, 2, (Object) null));
        }
        return u;
    }

    @Override // qm4.a
    public Function2<Composer, Integer, Unit> b(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        h d = d();
        if (d != null) {
            return d.F0();
        }
        return null;
    }

    @Override // qm4.a
    public Pair<Function2<Composer, Integer, Unit>, State<InsertState>> c(String bookId) {
        Pair<Function2<Composer, Integer, Unit>, State<InsertState>> r;
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        h d = d();
        if (d == null || (r = d.r()) == null) {
            return new Pair<>(null, SnapshotStateKt.mutableStateOf$default(InsertState.NOT_INSERT, (SnapshotMutationPolicy) null, 2, (Object) null));
        }
        return r;
    }
}
