package com.dragon.read.kmp.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.x2;
import androidx.compose.ui.graphics.c0;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.TagInfoPosition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v {
    static {
        Covode.recordClassIndex(609638);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(androidx.compose.foundation.layout.r rVar, s sVar, t tVar, int i, int i2, Composer composer, int i3) {
        b(rVar, sVar, tVar, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final androidx.compose.ui.e f(Integer num) {
        int value = TagInfoPosition.TopLeft.getValue();
        if (num != null && num.intValue() == value) {
            return androidx.compose.ui.e.a.o();
        }
        int value2 = TagInfoPosition.TopRight.getValue();
        if (num != null && num.intValue() == value2) {
            return androidx.compose.ui.e.a.n();
        }
        int value3 = TagInfoPosition.BottomLeft.getValue();
        if (num != null && num.intValue() == value3) {
            return androidx.compose.ui.e.a.d();
        }
        int value4 = TagInfoPosition.BottomRight.getValue();
        if (num != null && num.intValue() == value4) {
            return androidx.compose.ui.e.a.c();
        }
        return androidx.compose.ui.e.a.o();
    }

    private static final long e(s sVar, long j, Composer composer, int i) {
        String str;
        composer.startReplaceGroup(1594237725);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1594237725, i, -1, "com.dragon.read.kmp.widget.resolveTextColor (CommonCoverTagView.kt:128)");
        }
        if (com.dragon.read.kmp.service.d1.d(og4.a.a.e(composer, og4.a.b))) {
            str = sVar.f;
        } else {
            str = sVar.d;
        }
        if (str != null) {
            j = uc4.a.c(str);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return j;
    }

    private static final androidx.compose.ui.graphics.c0 d(s sVar, long j, Composer composer, int i) {
        List<String> list;
        int i2;
        androidx.compose.ui.graphics.c0 g2Var;
        composer.startReplaceGroup(1670965758);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1670965758, i, -1, "com.dragon.read.kmp.widget.resolveBackgroundBrush (CommonCoverTagView.kt:101)");
        }
        if (com.dragon.read.kmp.service.d1.d(og4.a.a.e(composer, og4.a.b))) {
            list = sVar.e;
        } else {
            list = sVar.c;
        }
        if (list != null) {
            i2 = list.size();
        } else {
            i2 = 0;
        }
        Pair b = uc4.a.b(sVar.g);
        if (i2 >= 2) {
            c0.a aVar = androidx.compose.ui.graphics.c0.b;
            Intrinsics.checkNotNull(list);
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(androidx.compose.ui.graphics.l0.j(uc4.a.c((String) it2.next())));
            }
            g2Var = c0.a.h(aVar, arrayList, ((a0.f) b.getFirst()).t(), ((a0.f) b.getSecond()).t(), 0, 8, (Object) null);
        } else if (i2 == 1) {
            Intrinsics.checkNotNull(list);
            g2Var = new androidx.compose.ui.graphics.g2(uc4.a.c((String) CollectionsKt___CollectionsKt.first((List) list)), (DefaultConstructorMarker) null);
        } else {
            g2Var = new androidx.compose.ui.graphics.g2(j, (DefaultConstructorMarker) null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return g2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(final androidx.compose.foundation.layout.r r32, final com.dragon.read.kmp.widget.s r33, com.dragon.read.kmp.widget.t r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.v.b(androidx.compose.foundation.layout.r, com.dragon.read.kmp.widget.s, com.dragon.read.kmp.widget.t, androidx.compose.runtime.Composer, int, int):void");
    }
}
