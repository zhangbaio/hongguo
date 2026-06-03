package com.dragon.read.kmp.reader.detail.widget;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.a3;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.r2;
import androidx.compose.foundation.layout.u2;
import androidx.compose.foundation.layout.w2;
import androidx.compose.foundation.lazy.o0;
import androidx.compose.foundation.z0;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.internal.t;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.m0;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.d1;
import com.bytedance.kmp.reading.model.om0;
import com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType;
import com.dragon.read.kmp.reader.detail.p2;
import com.dragon.read.kmp.utils.k0;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import w0.s;
import x0.x;
import yo2.d2;
import yo2.f2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BookDetailHorizontalCoverListKt {
    static {
        Covode.recordClassIndex(608399);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(String str, String str2, int i, String str3, String str4, com.dragon.read.kmp.reader.detail.widget.a aVar, Function4 function4, int i2, Composer composer, int i3) {
        A(str, str2, i, str3, str4, aVar, function4, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(String str, String str2, int i, String str3, String str4, com.dragon.read.kmp.reader.detail.widget.a aVar, Function4 function4, int i2, Composer composer, int i3) {
        A(str, str2, i, str3, str4, aVar, function4, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(String str, String str2, String str3, String str4, List list, Function4 function4, boolean z, int i, int i2, Composer composer, int i3) {
        o(str, str2, str3, str4, list, function4, z, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(String str, String str2, String str3, String str4, String str5, List list, Modifier modifier, String str6, Function0 function0, Function4 function4, int i, int i2, Composer composer, int i3) {
        u(str, str2, str3, str4, str5, list, modifier, str6, function0, function4, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(String str, String str2, String str3, String str4, String str5, List list, Modifier modifier, String str6, Function0 function0, Function4 function4, int i, int i2, Composer composer, int i3) {
        u(str, str2, str3, str4, str5, list, modifier, str6, function0, function4, composer, x2.a(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(String str, String str2, Function0 function0, int i, Composer composer, int i2) {
        x(str, str2, function0, composer, x2.a(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState C() {
        return SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public static final class c implements Function1<Integer, Object> {
        final /* synthetic */ List a;

        public c(List list) {
            this.a = list;
        }

        public final Object a(int i) {
            this.a.get(i);
            return null;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<com.dragon.read.kmp.reader.detail.widget.a> s(MutableState<List<com.dragon.read.kmp.reader.detail.widget.a>> mutableState) {
        return (List) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final class b implements Function1<Integer, Object> {
        final /* synthetic */ Function2 a;
        final /* synthetic */ List b;

        public b(Function2 function2, List list) {
            this.a = function2;
            this.b = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
            return a(num.intValue());
        }

        public final Object a(int i) {
            return this.a.invoke(Integer.valueOf(i), this.b.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final String L(List<com.dragon.read.kmp.reader.detail.widget.a> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            sb.append(((com.dragon.read.kmp.reader.detail.widget.a) obj).hashCode());
            sb.append("|");
            i = i2;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(MutableState<List<com.dragon.read.kmp.reader.detail.widget.a>> mutableState, List<com.dragon.read.kmp.reader.detail.widget.a> list) {
        mutableState.setValue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object q(int i, com.dragon.read.kmp.reader.detail.widget.a item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return Integer.valueOf(item.hashCode());
    }

    static final class a implements Function4<String, BookType, com.dragon.read.kmp.reader.detail.widget.a, ym4.k, Unit> {
        final /* synthetic */ Function4<String, BookType, com.dragon.read.kmp.reader.detail.widget.a, ym4.k, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function4<? super String, ? super BookType, ? super com.dragon.read.kmp.reader.detail.widget.a, ? super ym4.k, Unit> function4) {
            this.a = function4;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(String str, BookType bookType, com.dragon.read.kmp.reader.detail.widget.a aVar, ym4.k kVar) {
            a(str, bookType, aVar, kVar);
            return Unit.INSTANCE;
        }

        public final void a(String itemId, BookType bookType, com.dragon.read.kmp.reader.detail.widget.a clickedItem, ym4.k pageRecorder) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(bookType, "bookType");
            Intrinsics.checkNotNullParameter(clickedItem, "clickedItem");
            Intrinsics.checkNotNullParameter(pageRecorder, "pageRecorder");
            this.a.invoke(itemId, bookType, clickedItem, pageRecorder);
        }
    }

    public static final class d implements Function4<androidx.compose.foundation.lazy.f, Integer, Composer, Integer, Unit> {
        final /* synthetic */ List a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ Function4 f;

        public d(List list, String str, String str2, String str3, String str4, Function4 function4) {
            this.a = list;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = function4;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.foundation.lazy.f fVar, Integer num, Composer composer, Integer num2) {
            a(fVar, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void a(androidx.compose.foundation.lazy.f fVar, int i, Composer composer, int i2) {
            int i3;
            boolean z;
            int i4;
            int i5;
            if ((i2 & 6) == 0) {
                if (composer.changed(fVar)) {
                    i5 = 4;
                } else {
                    i5 = 2;
                }
                i3 = i5 | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composer.changed(i)) {
                    i4 = 32;
                } else {
                    i4 = 16;
                }
                i3 |= i4;
            }
            if ((i3 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i3 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                int i6 = (i3 & 112) | (i3 & 14);
                com.dragon.read.kmp.reader.detail.widget.a aVar = (com.dragon.read.kmp.reader.detail.widget.a) this.a.get(i);
                composer.startReplaceGroup(-1385574352);
                int i7 = i + 1;
                String str = this.b;
                String str2 = this.c;
                String str3 = this.d;
                String str4 = this.e;
                composer.startReplaceGroup(5004770);
                boolean changed = composer.changed(this.f);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new a(this.f);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                BookDetailHorizontalCoverListKt.A(str, str2, i7, str3, str4, aVar, (Function4) rememberedValue, composer, (i6 << 9) & 458752);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    private static final void x(final String str, final String str2, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        boolean z;
        Composer composer2;
        boolean z2;
        int i3;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(2030903184);
        if ((i & 6) == 0) {
            if (startRestartGroup.changed(str)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i2 = i5 | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            if (startRestartGroup.changed(str2)) {
                i4 = 32;
            } else {
                i4 = 16;
            }
            i2 |= i4;
        }
        if ((i & 384) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                i3 = 256;
            } else {
                i3 = 128;
            }
            i2 |= i3;
        }
        int i6 = i2;
        if ((i6 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i6 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2030903184, i6, -1, "com.dragon.read.kmp.reader.detail.widget.Header (BookDetailHorizontalCoverList.kt:202)");
            }
            Modifier.a aVar = Modifier.Companion;
            float f = 16;
            Modifier u = f2.u(SizeKt.h(aVar, 0.0f, 1, (Object) null), x0.i.g(f), x0.i.g(28), x0.i.g(f), x0.i.g(f));
            e.a aVar2 = androidx.compose.ui.e.a;
            e.c i7 = aVar2.i();
            androidx.compose.foundation.layout.e eVar = androidx.compose.foundation.layout.e.a;
            p0 b2 = r2.b(eVar.h(), i7, startRestartGroup, 48);
            int a2 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
            e0 currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier e = ComposedModifierKt.e(startRestartGroup, u);
            ComposeUiNode.Companion companion = ComposeUiNode.o0;
            Function0 a3 = companion.a();
            if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                androidx.compose.runtime.i.d();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(a3);
            } else {
                startRestartGroup.useNode();
            }
            Composer b3 = g5.b(startRestartGroup);
            g5.e(b3, b2, companion.c());
            g5.e(b3, currentCompositionLocalMap, companion.e());
            Function2 b4 = companion.b();
            if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a2))) {
                b3.updateRememberedValue(Integer.valueOf(a2));
                b3.apply(Integer.valueOf(a2), b4);
            }
            g5.e(b3, e, companion.d());
            w2 w2Var = w2.b;
            long h = x.h(16);
            c0.a aVar3 = c0.b;
            c0 d2 = aVar3.d();
            og4.a aVar4 = og4.a.a;
            og4.a c2 = aVar4.c();
            int i8 = og4.a.b;
            a6.j(str, (Modifier) null, c2.b(startRestartGroup, i8).F3(), h, (y) null, d2, (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, s.b.b(), false, 1, 0, (Function1) null, (g3) null, startRestartGroup, (i6 & 14) | 199680, 3120, 120786);
            a3.a(u2.a(w2Var, aVar, 1.0f, false, 2, (Object) null), startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(-1088511244);
            if (function0 != null) {
                startRestartGroup.startReplaceGroup(5004770);
                if ((i6 & 896) == 256) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.reader.detail.widget.j
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit y;
                            y = BookDetailHorizontalCoverListKt.y(Function0.this);
                            return y;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(aVar, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                p0 b5 = r2.b(eVar.h(), aVar2.i(), startRestartGroup, 48);
                int a4 = j.a(androidx.compose.runtime.i.b(startRestartGroup, 0));
                e0 currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier e2 = ComposedModifierKt.e(startRestartGroup, modifier);
                Function0 a5 = companion.a();
                if (!(startRestartGroup.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(a5);
                } else {
                    startRestartGroup.useNode();
                }
                Composer b6 = g5.b(startRestartGroup);
                g5.e(b6, b5, companion.c());
                g5.e(b6, currentCompositionLocalMap2, companion.e());
                Function2 b7 = companion.b();
                if (b6.getInserting() || !Intrinsics.areEqual(b6.rememberedValue(), Integer.valueOf(a4))) {
                    b6.updateRememberedValue(Integer.valueOf(a4));
                    b6.apply(Integer.valueOf(a4), b7);
                }
                g5.e(b6, e2, companion.d());
                a6.j(str2, (Modifier) null, aVar4.c().b(startRestartGroup, i8).R0(), x.h(13), (y) null, aVar3.e(), (androidx.compose.ui.text.font.j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, (g3) null, startRestartGroup, ((i6 >> 3) & 14) | 199680, 0, 131026);
                composer2 = startRestartGroup;
                a3.a(SizeKt.x(aVar, x0.i.g(2)), composer2, 6);
                z0.g(org.jetbrains.compose.resources.c.a(d2.d(f2.a.a), composer2, 0), (String) null, SizeKt.s(aVar, x0.i.g(10)), (androidx.compose.ui.e) null, (androidx.compose.ui.layout.i) null, 0.0f, m0.a.c(m0.b, aVar4.c().b(composer2, i8).R0(), 0, 2, (Object) null), 0, composer2, 432, 184);
                composer2.endNode();
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.reader.detail.widget.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit z3;
                    z3 = BookDetailHorizontalCoverListKt.z(str, str2, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                    return z3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(MutableState mutableState, String str, String str2, String str3, String str4, Function4 function4, o0 LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        List<com.dragon.read.kmp.reader.detail.widget.a> s = s(mutableState);
        LazyRow.f(s.size(), new b(new Function2() { // from class: com.dragon.read.kmp.reader.detail.widget.l
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Object q;
                q = BookDetailHorizontalCoverListKt.q(((Integer) obj).intValue(), (a) obj2);
                return q;
            }
        }, s), new c(s), t.c(2039820996, true, new d(s, str, str2, str3, str4, function4)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0202, code lost:
    
        if (r2 == r31.getEmpty()) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0137, code lost:
    
        if (r0 == null) goto L102;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01fc  */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void A(final java.lang.String r43, final java.lang.String r44, final int r45, final java.lang.String r46, final java.lang.String r47, final com.dragon.read.kmp.reader.detail.widget.a r48, final kotlin.jvm.functions.Function4<? super java.lang.String, ? super com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType, ? super com.dragon.read.kmp.reader.detail.widget.a, ? super ym4.k, kotlin.Unit> r49, androidx.compose.runtime.Composer r50, final int r51) {
        /*
            Method dump skipped, instructions count: 1074
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.widget.BookDetailHorizontalCoverListKt.A(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, com.dragon.read.kmp.reader.detail.widget.a, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void o(final java.lang.String r30, final java.lang.String r31, java.lang.String r32, java.lang.String r33, final java.util.List<com.dragon.read.kmp.reader.detail.widget.a> r34, final kotlin.jvm.functions.Function4<? super java.lang.String, ? super com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType, ? super com.dragon.read.kmp.reader.detail.widget.a, ? super ym4.k, kotlin.Unit> r35, boolean r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 753
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.widget.BookDetailHorizontalCoverListKt.o(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, kotlin.jvm.functions.Function4, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit D(MutableState mutableState, Ref$ObjectRef ref$ObjectRef, p2 p2Var, Ref$ObjectRef ref$ObjectRef2, String str, String str2, int i, om0 om0Var, String str3, String str4, d1 d1Var) {
        String str5;
        String str6;
        String str7;
        String a2;
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            return Unit.INSTANCE;
        }
        mutableState.setValue(Boolean.TRUE);
        String str8 = null;
        Integer num = null;
        if (ref$ObjectRef.element == BookType.SHORT_SERIES) {
            String str9 = (String) ref$ObjectRef2.element;
            if (om0Var != null) {
                str5 = om0Var.z;
            } else {
                str5 = null;
            }
            if (om0Var != null) {
                str6 = om0Var.p;
            } else {
                str6 = null;
            }
            if (om0Var != null) {
                str7 = om0Var.a;
            } else {
                str7 = null;
            }
            if (om0Var != null) {
                num = om0Var.y;
            }
            if (num == null) {
                a2 = "";
            } else {
                nk4.a aVar = nk4.a.a;
                VideoContentType.a aVar2 = VideoContentType.Companion;
                Integer num2 = om0Var.y;
                Intrinsics.checkNotNull(num2);
                a2 = aVar.a(aVar2.a(num2.intValue()));
            }
            p2Var.p(str9, str, str2, i, str5, str6, str7, a2, str, str3, str4, k0.a.b());
        } else {
            String str10 = (String) ref$ObjectRef2.element;
            if (d1Var != null) {
                str8 = d1Var.w;
            }
            p2Var.n(str10, str, str2, i, str8, k0.a.b());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit G(Ref$ObjectRef ref$ObjectRef, p2 p2Var, Ref$ObjectRef ref$ObjectRef2, String str, String str2, int i, om0 om0Var, String str3, String str4, d1 d1Var, Function4 function4, com.dragon.read.kmp.reader.detail.widget.a aVar) {
        ym4.k g;
        String str5;
        String str6;
        String str7;
        String a2;
        String str8 = null;
        Integer num = null;
        if (ref$ObjectRef.element == BookType.SHORT_SERIES) {
            String str9 = (String) ref$ObjectRef2.element;
            if (om0Var != null) {
                str5 = om0Var.z;
            } else {
                str5 = null;
            }
            if (om0Var != null) {
                str6 = om0Var.p;
            } else {
                str6 = null;
            }
            if (om0Var != null) {
                str7 = om0Var.a;
            } else {
                str7 = null;
            }
            if (om0Var != null) {
                num = om0Var.y;
            }
            if (num == null) {
                a2 = "";
            } else {
                nk4.a aVar2 = nk4.a.a;
                VideoContentType.a aVar3 = VideoContentType.Companion;
                Integer num2 = om0Var.y;
                Intrinsics.checkNotNull(num2);
                a2 = aVar2.a(aVar3.a(num2.intValue()));
            }
            g = p2Var.j(str9, str, str2, i, str5, str6, str7, a2, str, str3, str4, k0.a.b());
        } else {
            String str10 = (String) ref$ObjectRef2.element;
            if (d1Var != null) {
                str8 = d1Var.w;
            }
            g = p2Var.g(str10, str, str2, i, str8, k0.a.b());
        }
        T t = ref$ObjectRef2.element;
        T t2 = ref$ObjectRef.element;
        if (g == null) {
            g = k0.a.b();
        }
        function4.invoke(t, t2, aVar, g);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void u(final java.lang.String r22, final java.lang.String r23, java.lang.String r24, java.lang.String r25, final java.lang.String r26, final java.util.List<com.dragon.read.kmp.reader.detail.widget.a> r27, androidx.compose.ui.Modifier r28, java.lang.String r29, kotlin.jvm.functions.Function0<kotlin.Unit> r30, final kotlin.jvm.functions.Function4<? super java.lang.String, ? super com.dragon.read.kmp.base_database.pages.bookshelf.model.BookType, ? super com.dragon.read.kmp.reader.detail.widget.a, ? super ym4.k, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.detail.widget.BookDetailHorizontalCoverListKt.u(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, androidx.compose.ui.Modifier, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }
}
