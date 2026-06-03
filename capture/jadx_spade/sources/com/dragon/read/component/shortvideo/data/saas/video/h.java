package com.dragon.read.component.shortvideo.data.saas.video;

import com.bytedance.covode.number.Covode;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class h<T> {
    private final Function0<T> a;
    private T b;
    private final Lazy c;

    static {
        Covode.recordClassIndex(599116);
    }

    private final T c() {
        return (T) this.c.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Function0<? extends T> raw) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(raw, "raw");
        this.a = raw;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.data.saas.video.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object b;
                b = h.b(h.this);
                return b;
            }
        });
        this.c = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object b(h hVar) {
        T invoke = hVar.a.invoke();
        if (TypeIntrinsics.isMutableList(invoke)) {
            return CollectionsKt___CollectionsKt.toMutableList((Collection) invoke);
        }
        if (invoke instanceof List) {
            return CollectionsKt___CollectionsKt.toList((Iterable) invoke);
        }
        return invoke;
    }

    public final T d(Object obj, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        T t = this.b;
        if (t == null) {
            return c();
        }
        return t;
    }

    public final void e(Object obj, KProperty<?> property, T t) {
        Intrinsics.checkNotNullParameter(property, "property");
        this.b = t;
    }
}
