package com.dragon.read.kmp.share.business.series;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.jb0;
import com.dragon.read.kmp.share.business.series.g;
import com.dragon.read.kmp.share.manger.KmpShareManger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g implements vf1.b {
    static {
        Covode.recordClassIndex(608917);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n b() {
        return new n();
    }

    public vf1.a buildConfig() {
        vf1.a aVar = new vf1.a();
        aVar.a("video_player_poster");
        aVar.b(new Function0() { // from class: com.dragon.read.kmp.share.business.series.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n b2;
                b2 = g.b();
                return b2;
            }
        });
        aVar.d = new a();
        aVar.c = new b();
        return aVar;
    }

    public static final class a implements uh1.d {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(Function1 function1, Object obj) {
            function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(Function1 function1, Object obj) {
            function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(un4.j jVar, un4.e eVar, Function1 function1, Object obj) {
            un4.h hVar;
            Function0<un4.h> function0 = jVar.l;
            if (function0 != null) {
                hVar = function0.invoke();
            } else {
                hVar = null;
            }
            r.b(eVar, hVar);
            function1.invoke(obj);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit j(Object obj, Function1 function1, un4.j jVar, Throwable th) {
            un4.e eVar;
            un4.h hVar = null;
            if (obj instanceof un4.e) {
                eVar = (un4.e) obj;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                Function0<un4.h> function0 = jVar.l;
                if (function0 != null) {
                    hVar = function0.invoke();
                }
                r.b(eVar, hVar);
            }
            function1.invoke(obj);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(final Object obj, final un4.j jVar, final Function1 function1, String str) {
            final un4.e eVar;
            un4.h hVar = null;
            if (obj instanceof un4.e) {
                eVar = (un4.e) obj;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                eVar.f = str;
                if (Intrinsics.areEqual(str, jVar.j.getValue())) {
                    Function0<un4.h> function0 = jVar.l;
                    if (function0 != null) {
                        hVar = function0.invoke();
                    }
                    r.b(eVar, hVar);
                    function1.invoke(obj);
                } else {
                    MutableStateFlow<String> mutableStateFlow = jVar.j;
                    Intrinsics.checkNotNull(str);
                    mutableStateFlow.setValue(str);
                    jVar.k = new Function0() { // from class: com.dragon.read.kmp.share.business.series.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit h;
                            h = g.a.h(un4.j.this, eVar, function1, obj);
                            return h;
                        }
                    };
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
        
            if (r7 == null) goto L26;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(java.lang.Object r7, final java.lang.Object r8, bh1.a r9, final kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit> r10) {
            /*
                r6 = this;
                java.lang.String r0 = "channel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                java.lang.String r0 = "completion"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                boolean r0 = r8 instanceof un4.e
                r1 = 0
                if (r0 == 0) goto L13
                r2 = r8
                un4.e r2 = (un4.e) r2
                goto L14
            L13:
                r2 = r1
            L14:
                if (r2 == 0) goto L2a
                java.lang.String r3 = r2.f
                if (r3 == 0) goto L2a
                com.dragon.read.kmp.share.manger.c r4 = com.dragon.read.kmp.share.manger.c.a
                xn4.f0 r5 = xn4.f0.a
                java.util.Map r5 = r5.b()
                java.lang.String r9 = r9.a
                java.lang.String r9 = r4.d(r3, r5, r9)
                r2.f = r9
            L2a:
                boolean r9 = r7 instanceof un4.j
                if (r9 == 0) goto L31
                un4.j r7 = (un4.j) r7
                goto L32
            L31:
                r7 = r1
            L32:
                if (r7 == 0) goto L6e
                r7.k = r1
                com.bytedance.kmp.reading.model.jb0 r9 = r7.m
                if (r9 == 0) goto L67
                com.dragon.read.kmp.share.manger.c r9 = com.dragon.read.kmp.share.manger.c.a
                if (r0 == 0) goto L41
                r1 = r8
                un4.e r1 = (un4.e) r1
            L41:
                if (r1 == 0) goto L47
                java.lang.String r0 = r1.f
                if (r0 != 0) goto L49
            L47:
                java.lang.String r0 = ""
            L49:
                io.reactivex.Observable r9 = r9.e(r0)
                com.dragon.read.kmp.share.business.series.b r0 = new com.dragon.read.kmp.share.business.series.b
                r0.<init>()
                com.dragon.read.kmp.share.business.series.c r1 = new com.dragon.read.kmp.share.business.series.c
                r1.<init>()
                com.dragon.read.kmp.share.business.series.d r0 = new com.dragon.read.kmp.share.business.series.d
                r0.<init>()
                com.dragon.read.kmp.share.business.series.e r7 = new com.dragon.read.kmp.share.business.series.e
                r7.<init>()
                io.reactivex.disposables.Disposable r7 = r9.subscribe(r1, r7)
                if (r7 != 0) goto L6c
            L67:
                r10.invoke(r8)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
            L6c:
                if (r7 != 0) goto L73
            L6e:
                r10.invoke(r8)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
            L73:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.share.business.series.g.a.a(java.lang.Object, java.lang.Object, bh1.a, kotlin.jvm.functions.Function1):void");
        }
    }

    public static final class b implements uh1.c {
        b() {
        }

        public List<bh1.a> a(List<bh1.a> channels, bh1.b params) {
            o oVar;
            List<String> emptyList;
            jb0 jb0Var;
            Intrinsics.checkNotNullParameter(channels, "channels");
            Intrinsics.checkNotNullParameter(params, "params");
            KmpShareManger kmpShareManger = KmpShareManger.a;
            if (params instanceof o) {
                oVar = (o) params;
            } else {
                oVar = null;
            }
            if (oVar == null || (jb0Var = oVar.m) == null || (emptyList = jb0Var.a) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            return kmpShareManger.t(params, emptyList);
        }
    }
}
