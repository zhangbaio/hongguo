package com.dragon.read.kmp.story.impl.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.b2;
import androidx.compose.ui.layout.n0;
import androidx.compose.ui.layout.p1;
import androidx.compose.ui.layout.r0;
import androidx.compose.ui.layout.s0;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.us;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class d {
    static {
        Covode.recordClassIndex(609426);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Modifier modifier, List list, Function3 function3, Function2 function2, int i, Composer composer, int i2) {
        d(modifier, list, function3, function2, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> a;

        a(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.a = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-356622532, i, -1, "com.dragon.read.kmp.story.impl.widget.CommunityRecTagLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CommunityRecTagLayout.kt:50)");
                }
                this.a.invoke(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function3<us, Composer, Integer, Unit> a;
        final /* synthetic */ us b;

        b(Function3<? super us, ? super Composer, ? super Integer, Unit> function3, us usVar) {
            this.a = function3;
            this.b = usVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2141533560, i, -1, "com.dragon.read.kmp.story.impl.widget.CommunityRecTagLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CommunityRecTagLayout.kt:32)");
                }
                this.a.invoke(this.b, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    static final class c implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function3<us, Composer, Integer, Unit> a;
        final /* synthetic */ us b;

        c(Function3<? super us, ? super Composer, ? super Integer, Unit> function3, us usVar) {
            this.a = function3;
            this.b = usVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1527214865, i, -1, "com.dragon.read.kmp.story.impl.widget.CommunityRecTagLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CommunityRecTagLayout.kt:43)");
                }
                this.a.invoke(this.b, composer, 0);
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
    public static final Unit f(List list, Set set, Ref$IntRef ref$IntRef, p1.a layout) {
        int i;
        Intrinsics.checkNotNullParameter(layout, "$this$layout");
        int i2 = 0;
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            p1 p1Var = (p1) obj;
            if (set.contains(p1Var)) {
                i = (ref$IntRef.element - p1Var.b) / 2;
            } else {
                i = 0;
            }
            p1.a.N(layout, p1Var, i3, i, 0.0f, 4, (Object) null);
            i3 += p1Var.a;
            i2 = i4;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r0 e(List list, Function3 function3, Function2 function2, b2 SubcomposeLayout, x0.b bVar) {
        Iterator it2;
        Function3 function32 = function3;
        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
        final ArrayList arrayList = new ArrayList();
        int l = x0.b.l(bVar.r());
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        long b2 = x0.c.b(0, l, 0, x0.b.k(bVar.r()), 5, (Object) null);
        final LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it4 = list.iterator();
        int i = 0;
        int i2 = l;
        while (it4.hasNext()) {
            Object next = it4.next();
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            us usVar = (us) next;
            if (i == 0) {
                p1 L = ((n0) CollectionsKt___CollectionsKt.first(SubcomposeLayout.I1("content" + i, t.c(-2141533560, true, new b(function32, usVar))))).L(b2);
                int i4 = L.a;
                ref$IntRef.element = Math.max(ref$IntRef.element, L.b);
                i2 -= i4;
                arrayList.add(L);
                it2 = it4;
            } else {
                p1 L2 = ((n0) CollectionsKt___CollectionsKt.first(SubcomposeLayout.I1("content" + i, t.c(1527214865, true, new c(function32, usVar))))).L(b2);
                int i5 = L2.a;
                if (i5 > i2) {
                    break;
                }
                it2 = it4;
                p1 L3 = ((n0) CollectionsKt___CollectionsKt.first(SubcomposeLayout.I1("divider" + i, t.c(-356622532, true, new a(function2))))).L(b2);
                int i6 = L3.a;
                if (i2 < i5 + i6) {
                    break;
                }
                ref$IntRef.element = Math.max(ref$IntRef.element, L2.b);
                arrayList.add(L3);
                arrayList.add(L2);
                linkedHashSet.add(L3);
                i2 -= i5 - i6;
            }
            function32 = function3;
            it4 = it2;
            i = i3;
        }
        return s0.b(SubcomposeLayout, l, ref$IntRef.element, (Map) null, new Function1() { // from class: com.dragon.read.kmp.story.impl.widget.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f;
                f = d.f(arrayList, linkedHashSet, ref$IntRef, (p1.a) obj);
                return f;
            }
        }, 4, (Object) null);
    }

    public static final void d(final Modifier modifier, final List<us> tagList, final Function3<? super us, ? super Composer, ? super Integer, Unit> tagContent, final Function2<? super Composer, ? super Integer, Unit> dividerContent, Composer composer, final int i) {
        int i2;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        Intrinsics.checkNotNullParameter(tagContent, "tagContent");
        Intrinsics.checkNotNullParameter(dividerContent, "dividerContent");
        Composer startRestartGroup = composer.startRestartGroup(-185180145);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i2 = i6 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changedInstance(tagList)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i2 |= i5;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(tagContent)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i2 |= i4;
        }
        if ((i & 3072) == 0) {
            if (startRestartGroup.changedInstance(dividerContent)) {
                i3 = 2048;
            } else {
                i3 = 1024;
            }
            i2 |= i3;
        }
        boolean z3 = true;
        if ((i2 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-185180145, i2, -1, "com.dragon.read.kmp.story.impl.widget.CommunityRecTagLayout (CommunityRecTagLayout.kt:16)");
            }
            startRestartGroup.startReplaceGroup(-1746271574);
            boolean changedInstance = startRestartGroup.changedInstance(tagList);
            if ((i2 & 896) == 256) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z4 = changedInstance | z2;
            if ((i2 & 7168) != 2048) {
                z3 = false;
            }
            boolean z5 = z4 | z3;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function2() { // from class: com.dragon.read.kmp.story.impl.widget.a
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        r0 e;
                        e = d.e(tagList, tagContent, dividerContent, (b2) obj, (x0.b) obj2);
                        return e;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            SubcomposeLayoutKt.a(modifier, (Function2) rememberedValue, startRestartGroup, i2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        t3 endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.story.impl.widget.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit g;
                    g = d.g(modifier, tagList, tagContent, dividerContent, i, (Composer) obj, ((Integer) obj2).intValue());
                    return g;
                }
            });
        }
    }
}
