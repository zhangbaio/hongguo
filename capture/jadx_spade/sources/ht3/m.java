package ht3;

import c64.e0;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.shortvideo.api.NsShortVideoApi;
import com.dragon.read.pages.video.model.SeriesPostModel;
import com.ss.android.messagebus.BusProvider;
import com.ss.android.messagebus.Subscriber;
import gk4.b0;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lr4.r1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class m {
    public static final m a;
    private static final CopyOnWriteArraySet<Function1<b0, Unit>> b;
    public static final int c;

    private m() {
    }

    static {
        Covode.recordClassIndex(599227);
        a = new m();
        b = new CopyOnWriteArraySet<>();
        c = 8;
    }

    private final synchronized void c() {
        if (b.isEmpty()) {
            BusProvider.register(this);
        }
    }

    private final synchronized void d() {
        if (b.isEmpty()) {
            BusProvider.unregister(this);
        }
    }

    public final void b(Function1<? super b0, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        c();
        b.add(listener);
    }

    public final void e(Function1<? super b0, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        b.remove(listener);
        d();
    }

    @Subscriber
    public final void onPostLikeStatusChangeEvent(i event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Iterator<T> it2 = b.iterator();
        while (it2.hasNext()) {
            ((Function1) it2.next()).invoke(new b0(1, event.b.getPostId(), event.c, event.b.getLikeCount(), null, null, 48, null));
        }
    }

    @Subscriber
    public final void onVideoLikeStatusChangeEvent(e0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Iterator<T> it2 = b.iterator();
        while (it2.hasNext()) {
            Function1 function1 = (Function1) it2.next();
            tu4.a aVar = event.a;
            function1.invoke(new b0(0, aVar.a, aVar.i, aVar.h, aVar.g, null, 32, null));
        }
    }

    public final void a(String scene, b0 model) {
        Object m773constructorimpl;
        String stackTraceToString;
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(model, "model");
        int type = model.getType();
        if (type != 0) {
            if (type == 1) {
                SeriesPostModel seriesPostModel = new SeriesPostModel(model.b, "", "", new r1(), false);
                seriesPostModel.setLike(model.c);
                seriesPostModel.setLikeCount(model.d);
                boolean z = model.c;
                Map<String, String> map = model.f;
                if (map == null) {
                    map = MapsKt__MapsKt.emptyMap();
                }
                BusProvider.post(new i(scene, seriesPostModel, z, map));
                return;
            }
            return;
        }
        tu4.a aVar = new tu4.a((String) null, (String) null, (String) null, 0L, (String) null, (String) null, (String) null, 0L, false, false, (String) null, 0L, 0, 0, 0, 0L, (String) null, (String) null, 0L, 0, (String) null, 0L, 0, 0, 0, (String) null, false, (String) null, false, (String) null, (String) null, false, (String) null, (String) null, (String) null, 0L, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false, false, false, 0L, (String) null, false, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0L, (String) null, (String) null, (String) null, (String) null, false, 0L, (String) null, (String) null, (String) null, 0L, 0L, (String) null, (Integer) null, (String) null, (String) null, -1, -1, 127, (DefaultConstructorMarker) null);
        aVar.s(model.b);
        boolean z2 = model.c;
        aVar.i = z2;
        aVar.h = model.d;
        try {
            Result.Companion companion = Result.Companion;
            if (z2) {
                NsShortVideoApi.IMPL.addLikeModel(aVar);
            } else {
                NsShortVideoApi.IMPL.deleteLikeModel(aVar);
            }
            m773constructorimpl = Result.m773constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
        if (m776exceptionOrNullimpl != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("add or delete likeModel failed: ");
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m776exceptionOrNullimpl);
            sb.append(stackTraceToString);
            LogWrapper.error("VideoOrPostLikeStatusChangeManager", sb.toString(), new Object[0]);
        }
        BusProvider.post(new e0(aVar, model.f));
    }
}
