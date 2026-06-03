package com.dragon.read.kmp.subscribe;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.kmp_compat.com.ss.android.messagebus.BusProvider;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpSeriesSubscribeManger implements dq4.a {
    public static final KmpSeriesSubscribeManger a;

    static {
        Covode.recordClassIndex(609440);
        a = new KmpSeriesSubscribeManger();
    }

    private KmpSeriesSubscribeManger() {
    }

    @Override // dq4.a
    public void a() {
        o.b();
    }

    @Override // dq4.a
    public void onSeriesReserveStateChange(List<Pair<String, Boolean>> list) {
        kotlinx.coroutines.i.e(com.dragon.read.kmp.n.a, null, null, new KmpSeriesSubscribeManger$onSeriesReserveStateChange$1(list, null), 3, null);
        o.a(list);
    }

    public Object b(dq4.b bVar, Continuation<? super Unit> continuation) {
        Integer num;
        Object coroutine_suspended;
        com.dragon.read.kmp.j jVar = com.dragon.read.kmp.j.a;
        StringBuilder sb = new StringBuilder();
        sb.append("onSeriesReserveStateChange ");
        List<Pair<String, Boolean>> list = bVar.a;
        if (list != null) {
            num = Boxing.boxInt(list.size());
        } else {
            num = null;
        }
        sb.append(num);
        jVar.d("KmpSeriesSubscribeManger", sb.toString());
        Object c = BusProvider.a.c(bVar, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (c == coroutine_suspended) {
            return c;
        }
        return Unit.INSTANCE;
    }
}
