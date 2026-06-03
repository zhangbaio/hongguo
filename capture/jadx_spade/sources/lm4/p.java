package lm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.properties.PropertyName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p extends h {
    public static final int k;
    private final Lazy j;

    static {
        Covode.recordClassIndex(608493);
        k = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h k() {
        return q.a();
    }

    public p() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: lm4.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                h k2;
                k2 = p.k();
                return k2;
            }
        });
        this.j = lazy;
    }

    private final h j() {
        return (h) this.j.getValue();
    }

    @Override // lm4.h
    public k h() {
        return j().h();
    }

    @Override // lm4.h
    public void update(cm4.i iVar) {
        j().update(iVar);
    }

    @Override // lm4.h
    public com.dragon.read.kmp.b d(PropertyName key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return j().d(key);
    }

    @Override // lm4.h
    public void update(pm4.h hVar) {
        j().update(hVar);
    }
}
