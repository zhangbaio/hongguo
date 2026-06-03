package cn4;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.k0;
import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ym4.k;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g extends ViewModel {
    public static final int c;
    private final MutableState<a> a;
    public final State<a> b;

    static {
        Covode.recordClassIndex(608742);
        c = 8;
    }

    public g() {
        MutableState<a> mutableStateOf$default = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.a = mutableStateOf$default;
        this.b = mutableStateOf$default;
    }

    private final ym4.a E0() {
        a aVar = (a) this.b.getValue();
        if (aVar == null) {
            return new ym4.a();
        }
        ym4.a aVar2 = new ym4.a();
        aVar2.g("conversation_position", aVar.e);
        aVar2.g("conversation_id", aVar.f);
        aVar2.g("conversation_type", "single_chat");
        aVar2.g("if_push_book_ai", 1);
        return aVar2;
    }

    public final void F0() {
        Map<String, ? extends Object> emptyMap;
        a aVar = (a) this.b.getValue();
        if (aVar != null) {
            k b = k0.a.b();
            b.g(E0());
            emptyMap = MapsKt__MapsKt.emptyMap();
            zm4.d dVar = zm4.d.a;
            String str = aVar.c;
            if (str == null) {
                str = "";
            }
            dVar.c(str, emptyMap, b);
        }
    }

    public final void G0() {
        a aVar = (a) this.a.getValue();
        boolean z = false;
        if (aVar != null && aVar.d) {
            z = true;
        }
        if (z) {
            return;
        }
        a aVar2 = (a) this.a.getValue();
        if (aVar2 != null) {
            aVar2.d = true;
        }
        H0();
    }

    public final void H0() {
        ym4.a aVar = new ym4.a();
        aVar.h(k0.a.b().i());
        aVar.j(E0());
        o.a.d("impr_im_chat_entrance", aVar);
    }

    public final void I0(a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.a.setValue(data);
    }
}
