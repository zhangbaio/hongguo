package com.ss.ugc.clientai.aiservice.ohr;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi6.g;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class OHRService {
    public static final a o;
    private xi6.a a;
    private volatile boolean b;
    private final Handler c = new HandlerDelegate(Looper.getMainLooper());
    public final com.ss.ugc.clientai.aiservice.ohr.a<com.ss.ugc.clientai.aiservice.ohr.c> d = new com.ss.ugc.clientai.aiservice.ohr.a<>();
    private final f e = new f();
    private com.ss.ugc.clientai.aiservice.ohr.b f;
    public d g;
    public List<e> h;
    public long i;
    private float[] j;
    private long k;
    private float l;
    private float m;
    private float n;

    static {
        Covode.recordClassIndex(652789);
        o = new a(null);
    }

    static final class b implements Runnable {
        final /* synthetic */ List b;

        b(List list) {
            this.b = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OHRService.this.e(this.b);
        }
    }

    private final long i() {
        com.ss.ugc.clientai.aiservice.ohr.b bVar = this.f;
        if (bVar != null) {
            return bVar.a;
        }
        return 5000L;
    }

    private final int j() {
        com.ss.ugc.clientai.aiservice.ohr.b bVar = this.f;
        if (bVar != null) {
            return bVar.b;
        }
        return 9;
    }

    private final float[] h() {
        float[] fArr = this.j;
        int j = j() * 6;
        if (fArr != null && fArr.length == j) {
            return fArr;
        }
        float[] fArr2 = new float[j];
        this.j = fArr2;
        return fArr2;
    }

    public final void n() {
        if (!this.b) {
            return;
        }
        xi6.a aVar = this.a;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ohrEngine");
        }
        aVar.start();
        this.c.post(new Runnable() { // from class: com.ss.ugc.clientai.aiservice.ohr.OHRService$startup$1
            @Override // java.lang.Runnable
            public final void run() {
                OHRService.this.d.b(new Function1<c, Unit>() { // from class: com.ss.ugc.clientai.aiservice.ohr.OHRService$startup$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                        invoke2(cVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(c it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        it2.b(c.W0.b());
                    }
                });
            }
        });
    }

    public static final class a {
        static {
            Covode.recordClassIndex(652790);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class c implements xi6.f {
        c() {
        }

        @Override // xi6.f
        public void a(xi6.d result) {
            Intrinsics.checkNotNullParameter(result, "result");
            OHRService.this.g(result);
            OHRService.this.l(result);
        }
    }

    protected final void d(List<e> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        com.ss.ugc.clientai.common.c.c(new b(dataList), 100L);
    }

    public final void m(com.ss.ugc.clientai.aiservice.ohr.c observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.d.a(observer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(xi6.d dVar) {
        float[] fArr;
        if (dVar.c() && !Intrinsics.areEqual(dVar.b, g.f.a()) && (fArr = this.j) != null) {
            this.e.b(dVar.b.b, fArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(xi6.d dVar) {
        Object obj;
        Object obj2;
        Object obj3;
        boolean z;
        boolean z2;
        int i = dVar.b.b;
        Iterator<T> it2 = dVar.c.iterator();
        while (true) {
            obj = null;
            if (it2.hasNext()) {
                obj2 = it2.next();
                if (((g) obj2).b == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        g gVar = (g) obj2;
        if (gVar != null) {
            float f = gVar.d;
            Iterator<T> it4 = dVar.c.iterator();
            while (true) {
                if (it4.hasNext()) {
                    obj3 = it4.next();
                    if (((g) obj3).b == 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj3 = null;
                    break;
                }
            }
            g gVar2 = (g) obj3;
            if (gVar2 != null) {
                float f2 = gVar2.d;
                Object obj4 = dVar.b.a;
                if (obj4 instanceof RectF) {
                    obj = obj4;
                }
                final d dVar2 = new d(i, f, f2, (RectF) obj);
                this.g = dVar2;
                this.c.post(new Runnable() { // from class: com.ss.ugc.clientai.aiservice.ohr.OHRService$notifyPredictResult$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        OHRService.this.d.b(new Function1<c, Unit>() { // from class: com.ss.ugc.clientai.aiservice.ohr.OHRService$notifyPredictResult$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                                invoke2(cVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(c it5) {
                                Intrinsics.checkNotNullParameter(it5, "it");
                                it5.a(dVar2);
                            }
                        });
                    }
                });
            }
        }
    }

    public final void f(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!this.b) {
            return;
        }
        if (ev.getPointerCount() > 1) {
            this.h = null;
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.i < i()) {
            return;
        }
        if (ev.getAction() == 0) {
            this.h = new LinkedList();
        }
        List<e> list = this.h;
        if (list != null) {
            int historySize = ev.getHistorySize();
            for (int i = 0; i < historySize; i++) {
                list.add(new e(ev.getHistoricalX(i), ev.getHistoricalY(i), ev.getHistoricalEventTime(i)));
            }
            list.add(new e(ev.getX(), ev.getY(), ev.getEventTime()));
            if (ev.getAction() == 1 && list.size() >= j()) {
                this.i = elapsedRealtime;
                d(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(List<e> list) {
        if (!this.b) {
            if (com.ss.ugc.clientai.common.b.a) {
                com.ss.ugc.clientai.common.b.e("ohr", "service hasn't initialized");
                return;
            }
            return;
        }
        xi6.a aVar = this.a;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ohrEngine");
        }
        if (!aVar.isStarted()) {
            if (com.ss.ugc.clientai.common.b.a) {
                com.ss.ugc.clientai.common.b.a("ohr", "engine hasn't started");
                return;
            }
            return;
        }
        boolean z = com.ss.ugc.clientai.common.b.a;
        if (z) {
            com.ss.ugc.clientai.common.b.a("ohr", "feedData, dataList.size=" + list.size());
        }
        if (!list.isEmpty() && list.size() >= j()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long j = ((e) CollectionsKt___CollectionsKt.first((List) list)).c;
            float size = list.size() / j();
            float[] h = h();
            int j2 = j();
            for (int i = 0; i < j2; i++) {
                e eVar = list.get((int) (i * size));
                int i2 = i * 6;
                h[i2] = eVar.a;
                h[i2 + 1] = eVar.b;
                h[i2 + 2] = eVar.c - j;
                h[i2 + 3] = this.l;
                h[i2 + 4] = this.m;
                h[i2 + 5] = this.n;
            }
            com.ss.ugc.clientai.aiservice.ohr.b bVar = this.f;
            this.k = uptimeMillis;
            xi6.a aVar2 = this.a;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ohrEngine");
            }
            aVar2.a(new xi6.c(h));
            return;
        }
        if (z) {
            com.ss.ugc.clientai.common.b.a("ohr", "sample not enough, dataList.size=" + list.size());
        }
    }

    public final void k(Context application, com.ss.ugc.clientai.aiservice.ohr.b config) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.b) {
            return;
        }
        this.f = config;
        xi6.a a2 = config.c.a();
        this.a = a2;
        if (a2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ohrEngine");
        }
        a2.b(new c());
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Object systemService = application.getSystemService("window");
            if (systemService != null) {
                ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
                this.l = displayMetrics.widthPixels;
                this.m = displayMetrics.heightPixels;
                this.n = displayMetrics.density;
                this.b = true;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        } catch (Exception unused) {
            com.ss.ugc.clientai.common.b.b("ohr", "failed to retrieve the DisplayMetrics");
        }
    }
}
