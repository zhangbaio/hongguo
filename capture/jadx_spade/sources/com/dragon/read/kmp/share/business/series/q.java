package com.dragon.read.kmp.share.business.series;

import com.bytedance.covode.number.Covode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xn4.f0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class q implements vf1.b {
    static {
        Covode.recordClassIndex(608920);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoPlayerSharePanelController b() {
        return new VideoPlayerSharePanelController();
    }

    public vf1.a buildConfig() {
        vf1.a aVar = new vf1.a();
        aVar.a("video_player");
        aVar.b(new Function0() { // from class: com.dragon.read.kmp.share.business.series.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoPlayerSharePanelController b2;
                b2 = q.b();
                return b2;
            }
        });
        aVar.d = new a();
        aVar.c = new b();
        return aVar;
    }

    public static final class b implements uh1.c {
        b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
        
            if (r4 != false) goto L31;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.List<bh1.a> a(java.util.List<bh1.a> r7, bh1.b r8) {
            /*
                r6 = this;
                java.lang.String r0 = "channels"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.lang.String r0 = "params"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r7)
                java.util.Iterator r7 = r7.iterator()
            L12:
                boolean r1 = r7.hasNext()
                java.lang.String r2 = "long_image"
                if (r1 == 0) goto L40
                java.lang.Object r1 = r7.next()
                bh1.a r1 = (bh1.a) r1
                java.lang.String r3 = r1.a
                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)
                if (r2 == 0) goto L12
                ec4.h0$b r2 = ec4.h0.Companion
                ec4.h0 r2 = r2.a()
                boolean r2 = r2.b
                if (r2 == 0) goto L39
                java.lang.String r2 = "生成海报"
                r1.b(r2)
                goto L12
            L39:
                java.lang.String r2 = "海报分享"
                r1.b(r2)
                goto L12
            L40:
                boolean r7 = r8 instanceof com.dragon.read.kmp.share.business.series.e0
                r1 = 0
                if (r7 == 0) goto L49
                r3 = r8
                com.dragon.read.kmp.share.business.series.e0 r3 = (com.dragon.read.kmp.share.business.series.e0) r3
                goto L4a
            L49:
                r3 = r1
            L4a:
                r4 = 1
                r5 = 0
                if (r3 == 0) goto L54
                boolean r3 = r3.p
                if (r3 != r4) goto L54
                r3 = 1
                goto L55
            L54:
                r3 = 0
            L55:
                if (r3 != 0) goto L67
                if (r7 == 0) goto L5c
                com.dragon.read.kmp.share.business.series.e0 r8 = (com.dragon.read.kmp.share.business.series.e0) r8
                goto L5d
            L5c:
                r8 = r1
            L5d:
                if (r8 == 0) goto L64
                boolean r7 = r8.r
                if (r7 != r4) goto L64
                goto L65
            L64:
                r4 = 0
            L65:
                if (r4 == 0) goto L88
            L67:
                java.util.Iterator r7 = r0.iterator()
            L6b:
                boolean r8 = r7.hasNext()
                if (r8 == 0) goto L81
                java.lang.Object r8 = r7.next()
                r3 = r8
                bh1.a r3 = (bh1.a) r3
                java.lang.String r3 = r3.a
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r2)
                if (r3 == 0) goto L6b
                r1 = r8
            L81:
                bh1.a r1 = (bh1.a) r1
                if (r1 == 0) goto L88
                r0.remove(r1)
            L88:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.share.business.series.q.b.a(java.util.List, bh1.b):java.util.List");
        }
    }

    public static final class a implements uh1.d {
        a() {
        }

        public void a(Object obj, Object obj2, bh1.a channel, Function1<Object, Unit> completion) {
            un4.e eVar;
            String str;
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(completion, "completion");
            if (obj2 instanceof un4.e) {
                eVar = (un4.e) obj2;
            } else {
                eVar = null;
            }
            if (eVar != null && (str = eVar.f) != null) {
                eVar.f = com.dragon.read.kmp.share.manger.c.a.d(str, f0.a.b(), channel.a);
            }
            completion.invoke(obj2);
        }
    }
}
