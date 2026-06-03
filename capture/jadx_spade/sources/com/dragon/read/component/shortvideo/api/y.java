package com.dragon.read.component.shortvideo.api;

import com.bytedance.covode.number.Covode;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class y {
    public static final a b;
    private final Lazy a;

    public static final class a {
        static {
            Covode.recordClassIndex(598174);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(598173);
        b = new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConcurrentHashMap c() {
        return new ConcurrentHashMap();
    }

    private final ConcurrentHashMap<Class<? extends lq3.a>, Object> e() {
        return (ConcurrentHashMap) this.a.getValue();
    }

    public y() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ConcurrentHashMap c;
                c = y.c();
                return c;
            }
        });
        this.a = lazy;
        er3.a.a(this);
    }

    public final <T extends lq3.a> T d(Class<T> clas) {
        Intrinsics.checkNotNullParameter(clas, "clas");
        Object obj = e().get(clas);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of com.dragon.read.component.shortvideo.api.SeriesDocker.get");
        return (T) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends lq3.a> void b(Class<T> clas, Class<? extends T> target) {
        Object first;
        Intrinsics.checkNotNullParameter(clas, "clas");
        Intrinsics.checkNotNullParameter(target, "target");
        Constructor<?>[] constructors = target.getConstructors();
        Intrinsics.checkNotNullExpressionValue(constructors, "getConstructors(...)");
        first = ArraysKt___ArraysKt.first(constructors);
        e().put(clas, ((Constructor) first).newInstance(new Object[0]));
    }
}
