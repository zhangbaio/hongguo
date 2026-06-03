package yr3;

import android.os.Build;
import com.bytedance.covode.number.Covode;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    private final Set<WeakReference<Object>> a = new LinkedHashSet();

    static {
        Covode.recordClassIndex(598848);
    }

    public final boolean e() {
        if (this.a.size() == 0) {
            return true;
        }
        return false;
    }

    public final void d(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.a.add(new WeakReference<>(obj));
    }

    public final void f(final Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (Build.VERSION.SDK_INT >= 24) {
            Set<WeakReference<Object>> set = this.a;
            final Function1 function1 = new Function1() { // from class: yr3.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    boolean g;
                    g = d.g(obj, (WeakReference) obj2);
                    return Boolean.valueOf(g);
                }
            };
            set.removeIf(new Predicate() { // from class: yr3.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj2) {
                    boolean h;
                    h = d.h(Function1.this, obj2);
                    return h;
                }
            });
            return;
        }
        CollectionsKt__MutableCollectionsKt.removeAll(this.a, new Function1() { // from class: yr3.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                boolean i;
                i = d.i(obj, (WeakReference) obj2);
                return Boolean.valueOf(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(Object obj, WeakReference it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Intrinsics.areEqual(it2.get(), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean i(Object obj, WeakReference it2) {
        Intrinsics.checkNotNullParameter(it2, "it");
        return Intrinsics.areEqual(it2.get(), obj);
    }
}
