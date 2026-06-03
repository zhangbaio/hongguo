package sl4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.x2;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.k0;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import gk4.n0;
import gk4.o0;
import gk4.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p {
    public static final p a;

    static {
        Covode.recordClassIndex(608155);
        a = new p();
    }

    private p() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(p pVar, int i, Object obj, Function0 function0, int i2, int i3, Composer composer, int i4) {
        pVar.p(i, obj, function0, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D() {
        yk4.b.a.c(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(tl4.l lVar, int i, Object obj) {
        lVar.K(i, (bl4.a) obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(tl4.l lVar, int i, Object obj) {
        lVar.K(i, (bl4.a) obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(tl4.l lVar, int i, Object obj) {
        lVar.J(i, (gk4.e) obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(tl4.l lVar, int i, Object obj) {
        lVar.J(i, (gk4.e) obj);
        return Unit.INSTANCE;
    }

    static final class b implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
        final /* synthetic */ Object a;

        b(Object obj) {
            this.a = obj;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
            a(rVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r VideoListItem3Column, Composer composer, int i) {
            boolean z;
            int i2;
            Intrinsics.checkNotNullParameter(VideoListItem3Column, "$this$VideoListItem3Column");
            if ((i & 6) == 0) {
                if (composer.changed(VideoListItem3Column)) {
                    i2 = 4;
                } else {
                    i2 = 2;
                }
                i |= i2;
            }
            if ((i & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-515170324, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.view.GuestProfileItemFactory.createGuestProfileItem.<anonymous> (GuestProfileItemFactory.kt:112)");
                }
                Object obj = this.a;
                if ((obj instanceof o0) && ((o0) obj).f) {
                    bl4.m.m(VideoListItem3Column, 0L, composer, i & 14, 1);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class d implements Function3<androidx.compose.foundation.layout.r, Composer, Integer, Unit> {
        final /* synthetic */ Object a;

        d(Object obj) {
            this.a = obj;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, Composer composer, Integer num) {
            a(rVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r PugcVideoListItem2Column, Composer composer, int i) {
            boolean z;
            int i2;
            Intrinsics.checkNotNullParameter(PugcVideoListItem2Column, "$this$PugcVideoListItem2Column");
            if ((i & 6) == 0) {
                if (composer.changed(PugcVideoListItem2Column)) {
                    i2 = 4;
                } else {
                    i2 = 2;
                }
                i |= i2;
            }
            if ((i & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(779186202, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.view.GuestProfileItemFactory.createGuestProfileItem.<anonymous> (GuestProfileItemFactory.kt:69)");
                }
                if (((gk4.r) this.a).f) {
                    bl4.m.m(PugcVideoListItem2Column, 0L, composer, i & 14, 1);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(tl4.l lVar, int i, Object obj) {
        lVar.K(i, ((ll4.e) obj).h);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(tl4.l lVar, Object obj, int i) {
        lVar.O((bl4.a) obj, i, 1, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(tl4.l lVar, Object obj, int i) {
        lVar.P((bl4.a) obj, i);
        yk4.b.a.c(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(tl4.l lVar, int i, Object obj) {
        ll4.e eVar = (ll4.e) obj;
        lVar.r(i, eVar.h);
        lVar.M(i, eVar.h, "preview_detail_page");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(tl4.l lVar, Object obj, int i) {
        lVar.P((bl4.a) obj, i);
        ym4.a j = new ym4.a().j(((gk4.r) obj).w(i));
        lVar.o(j);
        lVar.l(j, (w) obj);
        ym4.o.a.d("show_post_card", j);
        yk4.b.a.c(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Object obj, int i, tl4.l lVar) {
        ym4.a j = new ym4.a().j(((gk4.s) obj).p(i, "card"));
        lVar.o(j);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.dragon.read.kmp.model.IDoubleColumn");
        lVar.l(j, (w) obj);
        ym4.o.a.d("show_post_card", j);
        yk4.b.a.c(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(tl4.l lVar, Object obj, int i) {
        Integer num;
        String obj2;
        boolean z;
        ProfileTab profileTab = lVar.a.d;
        String str = null;
        if (profileTab != null) {
            num = Integer.valueOf(profileTab.getValue());
        } else {
            num = null;
        }
        String b2 = com.dragon.read.kmp.s.b(num);
        Object l = k0.a.b().l("enter_from");
        if (l != null && (obj2 = l.toString()) != null) {
            if (obj2.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str = obj2;
            }
            if (str != null) {
                b2 = str;
            }
        }
        ym4.o.a.d("show_post_card", new ym4.a().j(((n0) obj).p(i, "card")).g("enter_from", b2));
        yk4.b.a.c(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function0 function0, tl4.l lVar, Object obj, int i) {
        function0.invoke();
        lVar.O((bl4.a) obj, i, 1, false);
        return Unit.INSTANCE;
    }

    static final class a implements Function4<androidx.compose.foundation.layout.r, bl4.a, Composer, Integer, Unit> {
        final /* synthetic */ Object a;
        final /* synthetic */ int b;

        a(Object obj, int i) {
            this.a = obj;
            this.b = i;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, bl4.a aVar, Composer composer, Integer num) {
            a(rVar, aVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r VideoListItem3Column, bl4.a it2, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(VideoListItem3Column, "$this$VideoListItem3Column");
            Intrinsics.checkNotNullParameter(it2, "it");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1787581292, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.view.GuestProfileItemFactory.createGuestProfileItem.<anonymous> (GuestProfileItemFactory.kt:105)");
            }
            if (it2 instanceof ll4.d) {
                composer.startReplaceGroup(-534687351);
                Object obj = this.a;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.dragon.read.kmp.profile.guestprofile.celebrity.CelebrityVideoReservationItemModel");
                bl4.r.k(VideoListItem3Column, (ll4.d) obj, this.b, composer, i & 14);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-534550920);
                bl4.m.w(VideoListItem3Column, (bl4.a) this.a, composer, i & 14);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    static final class c implements Function4<androidx.compose.foundation.layout.r, n0, Composer, Integer, Unit> {
        final /* synthetic */ Object a;

        c(Object obj) {
            this.a = obj;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.layout.r rVar, n0 n0Var, Composer composer, Integer num) {
            a(rVar, n0Var, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.layout.r SeriesPostItem3Column, n0 it2, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(SeriesPostItem3Column, "$this$SeriesPostItem3Column");
            Intrinsics.checkNotNullParameter(it2, "it");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1746265375, i, -1, "com.dragon.read.kmp.profile.guestprofile.tabContent.view.GuestProfileItemFactory.createGuestProfileItem.<anonymous> (GuestProfileItemFactory.kt:152)");
            }
            bl4.m.u(SeriesPostItem3Column, (n0) this.a, composer, i & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:108:0x024a, code lost:
    
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0279, code lost:
    
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02c4, code lost:
    
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02f3, code lost:
    
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0369, code lost:
    
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0398, code lost:
    
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x03e7, code lost:
    
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0416, code lost:
    
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f5, code lost:
    
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0124, code lost:
    
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x019c, code lost:
    
        if (r13 == r5.getEmpty()) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01c8, code lost:
    
        if (r7 == r5.getEmpty()) goto L103;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x052c  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0526  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0537  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(final int r22, final java.lang.Object r23, kotlin.jvm.functions.Function0<kotlin.Unit> r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 1355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sl4.p.p(int, java.lang.Object, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
