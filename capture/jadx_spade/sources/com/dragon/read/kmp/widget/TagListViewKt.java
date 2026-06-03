package com.dragon.read.kmp.widget;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.x2;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.a3;
import androidx.compose.ui.text.b3;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.g3;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.image.options.i;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.w40;
import com.bytedance.kmp.reading.model.y40;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class TagListViewKt {
    static {
        Covode.recordClassIndex(609667);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(e90 e90Var, g3 g3Var, long j, androidx.compose.ui.graphics.l0 l0Var, boolean z, float f, boolean z2, Function1 function1, int i, Composer composer, int i2) {
        f(e90Var, g3Var, j, l0Var, z, f, z2, function1, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    private static final float h(androidx.compose.runtime.v1 v1Var) {
        return v1Var.getFloatValue();
    }

    private static final androidx.compose.ui.text.font.j j(State<? extends androidx.compose.ui.text.font.j> state) {
        return (androidx.compose.ui.text.font.j) state.getValue();
    }

    private static final boolean t(e90 e90Var) {
        boolean z;
        w40 w40Var = e90Var.o;
        if (w40Var != null) {
            z = Intrinsics.areEqual(w40Var.n, Boolean.TRUE);
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        return true;
    }

    public static final class a implements com.bytedance.kmp.image.options.i {
        final /* synthetic */ float a;
        final /* synthetic */ float b;
        final /* synthetic */ androidx.compose.runtime.v1 c;

        public void onFail(Throwable error) {
            Intrinsics.checkNotNullParameter(error, "error");
        }

        public void onLoadStart() {
        }

        public void a(i.c successResult) {
            float f;
            Intrinsics.checkNotNullParameter(successResult, "successResult");
            int i = successResult.b;
            if (i > 0) {
                f = (successResult.a / i) * this.a;
            } else {
                f = this.b;
            }
            TagListViewKt.i(this.c, Math.min(this.b, f));
        }

        a(float f, float f2, androidx.compose.runtime.v1 v1Var) {
            this.a = f;
            this.b = f2;
            this.c = v1Var;
        }
    }

    public static final String u(e90 info) {
        boolean z;
        List split$default;
        String str;
        Intrinsics.checkNotNullParameter(info, "info");
        String str2 = info.y;
        List list = info.z;
        if (str2 != null && str2.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) str2, new String[]{"%s"}, false, 0, 6, (Object) null);
            if (split$default.size() == 1) {
                return (String) split$default.get(0);
            }
            StringBuilder sb = new StringBuilder();
            int size = split$default.size();
            for (int i = 0; i < size; i++) {
                sb.append((String) split$default.get(i));
                if (i < split$default.size() - 1) {
                    if (list == null || (str = (String) CollectionsKt___CollectionsKt.getOrNull(list, i)) == null) {
                        str = "";
                    }
                    sb.append(str);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
        String str3 = info.a;
        if (str3 == null) {
            return "";
        }
        return str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(androidx.compose.runtime.v1 v1Var, float f) {
        v1Var.setFloatValue(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function1 function1, e90 e90Var) {
        if (function1 != null) {
            function1.invoke(e90Var);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Float] */
    public static final Unit e(Ref$ObjectRef ref$ObjectRef, androidx.compose.ui.layout.w coords) {
        Intrinsics.checkNotNullParameter(coords, "coords");
        ref$ObjectRef.element = Float.valueOf((int) (coords.a() >> 32));
        return Unit.INSTANCE;
    }

    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int i;
            int compareValues;
            Long l = ((y40) t).a;
            int i2 = 0;
            if (l != null) {
                i = (int) l.longValue();
            } else {
                i = 0;
            }
            Integer valueOf = Integer.valueOf(i);
            Long l2 = ((y40) t2).a;
            if (l2 != null) {
                i2 = (int) l2.longValue();
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Integer.valueOf(i2));
            return compareValues;
        }
    }

    public static final class c<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int i;
            int compareValues;
            Long l = ((y40) t).a;
            int i2 = 0;
            if (l != null) {
                i = (int) l.longValue();
            } else {
                i = 0;
            }
            Integer valueOf = Integer.valueOf(i);
            Long l2 = ((y40) t2).a;
            if (l2 != null) {
                i2 = (int) l2.longValue();
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(valueOf, Integer.valueOf(i2));
            return compareValues;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier s(Modifier modifier, boolean z, Function0<Unit> function0) {
        if (z) {
            return ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, function0, 15, (Object) null);
        }
        return modifier;
    }

    public static final String w(e90 info, g3 style, a3 measurer, float f) {
        List list;
        List split$default;
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(measurer, "measurer");
        String str = info.y;
        String str2 = null;
        if (str == null || (list = info.z) == null || list.size() != 1) {
            return null;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"%s"}, false, 0, 6, (Object) null);
        if (split$default.size() != 2) {
            return null;
        }
        String str3 = (String) split$default.get(0);
        String str4 = (String) split$default.get(1);
        String str5 = (String) list.get(0);
        if (str5 == null) {
            str5 = "";
        }
        String str6 = str3 + "…" + str4;
        String str7 = "…";
        String str8 = str4;
        String str9 = str3;
        if (((int) (a3.b(measurer, str6, style, 0, false, 0, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1020, (Object) null).c >> 32)) > f) {
            return null;
        }
        int length = str5.length();
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) / 2;
            StringBuilder sb = new StringBuilder();
            String str10 = str9;
            sb.append(str10);
            String substring = str5.substring(0, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            sb.append(substring);
            String str11 = str7;
            sb.append(str11);
            String str12 = str8;
            sb.append(str12);
            String sb2 = sb.toString();
            int i3 = i;
            int i4 = length;
            if (((int) (a3.b(measurer, sb2, style, 0, false, 0, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1020, (Object) null).c >> 32)) <= f) {
                i = i2 + 1;
                str2 = sb2;
                str9 = str10;
                length = i4;
                str8 = str12;
                str7 = str11;
            } else {
                length = i2 - 1;
                str7 = str11;
                str9 = str10;
                i = i3;
                str8 = str12;
            }
        }
        if (str2 != null) {
            return str2;
        }
        return str6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long r(e90 e90Var, androidx.compose.ui.graphics.l0 l0Var, boolean z, Composer composer, int i) {
        boolean z2;
        long x;
        String str;
        String str2;
        composer.startReplaceGroup(-1173739939);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1173739939, i, -1, "com.dragon.read.kmp.widget.buildTextColor (TagListView.kt:473)");
        }
        og4.a aVar = og4.a.a;
        int i2 = og4.a.b;
        boolean z3 = true;
        if (com.dragon.read.kmp.service.d1.d(aVar.e(composer, i2)) && !z) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (l0Var == null) {
            if (z) {
                x = aVar.d().h();
            } else {
                x = aVar.h(composer, i2).h();
            }
        } else {
            x = l0Var.x();
        }
        String str3 = null;
        if (z2) {
            w40 w40Var = e90Var.o;
            if (w40Var != null) {
                str = w40Var.g;
            }
            str = null;
        } else {
            w40 w40Var2 = e90Var.o;
            if (w40Var2 != null) {
                str = w40Var2.c;
            }
            str = null;
        }
        if (z2) {
            w40 w40Var3 = e90Var.o;
            if (w40Var3 != null) {
                str3 = w40Var3.h;
            }
        } else {
            w40 w40Var4 = e90Var.o;
            if (w40Var4 != null) {
                str3 = w40Var4.d;
            }
        }
        if (str != null && str.length() != 0) {
            z3 = false;
        }
        if (!z3) {
            long b2 = com.dragon.read.kmp.utils.o0.a.b(str, str3, x);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return b2;
        }
        if (Intrinsics.areEqual(e90Var.c, Boolean.TRUE)) {
            if (z2) {
                str2 = "#A8804CFF";
            } else {
                str2 = "#D7A461FF";
            }
            long e = com.dragon.read.kmp.utils.j.e(str2, x);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return e;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float v(e90 e90Var, g3 g3Var, a3 a3Var, x0.e eVar, boolean z) {
        List emptyList;
        int i;
        int coerceAtLeast;
        int i2;
        int coerceAtLeast2;
        String str;
        int coerceAtLeast3;
        float f;
        boolean z2;
        String str2 = e90Var.a;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        w40 w40Var = e90Var.o;
        if (w40Var == null || (emptyList = w40Var.l) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        if (emptyList.isEmpty()) {
            return (int) (a3.b(a3Var, str3, g3Var, 0, false, 0, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1020, (Object) null).c >> 32);
        }
        List sortedWith = CollectionsKt___CollectionsKt.sortedWith(emptyList, new c());
        float M0 = eVar.M0(x0.i.g(12)) * eVar.getFontScale();
        Iterator it2 = sortedWith.iterator();
        boolean z3 = false;
        float f2 = 0.0f;
        int i3 = 0;
        while (true) {
            boolean z4 = true;
            if (!it2.hasNext()) {
                break;
            }
            y40 y40Var = (y40) it2.next();
            Long l = y40Var.a;
            if (l != null) {
                i = (int) l.longValue();
            } else {
                i = 0;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i, 0);
            Long l2 = y40Var.b;
            if (l2 != null) {
                i2 = (int) l2.longValue();
            } else {
                i2 = coerceAtLeast;
            }
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i2, coerceAtLeast);
            if (i3 < coerceAtLeast) {
                String substring = str3.substring(i3, coerceAtLeast);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                if (substring.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    f2 += (int) (a3.b(a3Var, substring, g3Var, 0, false, 0, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1020, (Object) null).c >> 32);
                }
            }
            if (!z || (str = y40Var.e) == null) {
                str = y40Var.d;
            }
            coerceAtLeast3 = RangesKt___RangesKt.coerceAtLeast(coerceAtLeast2 - coerceAtLeast, 0);
            if (str != null && str.length() != 0) {
                z4 = false;
            }
            if (!z4) {
                f = coerceAtLeast3 * M0;
            } else {
                String substring2 = str3.substring(coerceAtLeast, coerceAtLeast2);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                f = (int) (a3.b(a3Var, substring2, g3Var, 0, false, 0, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1020, (Object) null).c >> 32);
            }
            f2 += f;
            i3 = coerceAtLeast2;
        }
        if (i3 < str3.length()) {
            String substring3 = str3.substring(i3);
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            if (substring3.length() > 0) {
                z3 = true;
            }
            if (z3) {
                return f2 + ((int) (a3.b(a3Var, substring3, g3Var, 0, false, 0, 0L, (LayoutDirection) null, (x0.e) null, (j.b) null, false, 1020, (Object) null).c >> 32));
            }
            return f2;
        }
        return f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0120 A[LOOP:1: B:136:0x011a->B:138:0x0120, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.compose.ui.graphics.c0 q(com.bytedance.kmp.reading.model.e90 r22, androidx.compose.ui.graphics.l0 r23, boolean r24, androidx.compose.runtime.Composer r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 711
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.TagListViewKt.q(com.bytedance.kmp.reading.model.e90, androidx.compose.ui.graphics.l0, boolean, androidx.compose.runtime.Composer, int, int):androidx.compose.ui.graphics.c0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0401  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(final com.bytedance.kmp.reading.model.e90 r40, final androidx.compose.ui.text.g3 r41, final long r42, final androidx.compose.ui.graphics.l0 r44, final boolean r45, final float r46, final boolean r47, final kotlin.jvm.functions.Function1<? super com.bytedance.kmp.reading.model.e90, kotlin.Unit> r48, androidx.compose.runtime.Composer r49, final int r50) {
        /*
            Method dump skipped, instructions count: 1502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.TagListViewKt.f(com.bytedance.kmp.reading.model.e90, androidx.compose.ui.text.g3, long, androidx.compose.ui.graphics.l0, boolean, float, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    public static final boolean d(List<e90> recTags, Integer num, Modifier modifier, boolean z, Function1<? super e90, Unit> function1, Function1<? super e90, Unit> function12, androidx.compose.ui.graphics.l0 l0Var, androidx.compose.ui.graphics.l0 l0Var2, boolean z2, Composer composer, int i, int i2) {
        Integer num2;
        Modifier modifier2;
        boolean z3;
        Function1<? super e90, Unit> function13;
        Function1<? super e90, Unit> function14;
        androidx.compose.ui.graphics.l0 l0Var3;
        androidx.compose.ui.graphics.l0 l0Var4;
        boolean z4;
        Intrinsics.checkNotNullParameter(recTags, "recTags");
        composer.startReplaceGroup(128875204);
        if ((i2 & 2) != 0) {
            num2 = null;
        } else {
            num2 = num;
        }
        if ((i2 & 4) != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i2 & 8) != 0) {
            z3 = true;
        } else {
            z3 = z;
        }
        if ((i2 & 16) != 0) {
            function13 = null;
        } else {
            function13 = function1;
        }
        if ((i2 & 32) != 0) {
            function14 = null;
        } else {
            function14 = function12;
        }
        if ((i2 & 64) != 0) {
            l0Var3 = null;
        } else {
            l0Var3 = l0Var;
        }
        if ((i2 & 128) != 0) {
            l0Var4 = null;
        } else {
            l0Var4 = l0Var2;
        }
        if ((i2 & 256) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(128875204, i, -1, "com.dragon.read.kmp.widget.KmpTagListView (TagListView.kt:79)");
        }
        if (recTags.isEmpty()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return false;
        }
        a3 a2 = b3.a(0, composer, 0, 1);
        x0.e eVar = (x0.e) composer.consume(CompositionLocalsKt.f());
        g3 g3Var = new g3(0L, x0.x.h(12), (androidx.compose.ui.text.font.c0) null, (androidx.compose.ui.text.font.y) null, (androidx.compose.ui.text.font.z) null, (androidx.compose.ui.text.font.j) null, (String) null, 0L, (w0.a) null, (w0.p) null, (s0.f) null, 0L, (w0.i) null, (androidx.compose.ui.graphics.e2) null, (androidx.compose.ui.graphics.drawscope.g) null, 0, 0, 0L, (w0.q) null, (androidx.compose.ui.text.l0) null, (w0.g) null, 0, 0, (w0.r) null, 16777213, (DefaultConstructorMarker) null);
        float M0 = eVar.M0(x0.i.g(10)) * eVar.getFontScale();
        float M02 = eVar.M0(x0.i.g(4));
        float g = x0.i.g(2);
        Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        androidx.compose.foundation.layout.u.c(androidx.compose.ui.layout.d1.a(modifier2, new Function1() { // from class: com.dragon.read.kmp.widget.g2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit e;
                e = TagListViewKt.e(Ref$ObjectRef.this, (androidx.compose.ui.layout.w) obj);
                return e;
            }
        }), (androidx.compose.ui.e) null, false, androidx.compose.runtime.internal.t.e(-1775489638, true, new TagListViewKt$KmpTagListView$2(num2, eVar, ref$ObjectRef, recTags, l0Var3, z4, l0Var4, g3Var, z3, M0, function13, function14, ref$BooleanRef, M02, a2, g), composer, 54), composer, 3072, 6);
        boolean z5 = ref$BooleanRef.element;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return z5;
    }
}
