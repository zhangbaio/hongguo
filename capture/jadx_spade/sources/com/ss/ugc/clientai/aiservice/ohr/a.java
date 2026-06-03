package com.ss.ugc.clientai.aiservice.ohr;

import com.bytedance.covode.number.Covode;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a<T> {
    private final CopyOnWriteArrayList<T> a = new CopyOnWriteArrayList<>();

    static {
        Covode.recordClassIndex(652784);
    }

    public final void a(T t) {
        this.a.add(t);
    }

    public final void b(Function1<? super T, Unit> lambda) {
        Intrinsics.checkNotNullParameter(lambda, "lambda");
        Iterator<T> it2 = this.a.iterator();
        while (it2.hasNext()) {
            lambda.invoke(it2.next());
        }
    }
}
