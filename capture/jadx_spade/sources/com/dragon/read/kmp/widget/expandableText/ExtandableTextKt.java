package com.dragon.read.kmp.widget.expandableText;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.f2;
import androidx.compose.foundation.layout.m;
import androidx.compose.foundation.layout.v;
import androidx.compose.material.a6;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.e0;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.layout.p0;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.o;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.a3;
import androidx.compose.ui.text.e;
import androidx.compose.ui.text.font.c0;
import androidx.compose.ui.text.font.j;
import androidx.compose.ui.text.font.y;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.widget.expandableText.ExtandableTextKt;
import com.ss.ttm.player.MediaPlayer;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ExtandableTextKt {
    private static final float a;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(String str, String str2, long j, String str3, long j2, float f, Modifier modifier, boolean z, int i, g3 g3Var, Function0 function0, androidx.compose.animation.core.i iVar, Function5 function5, int i2, int i3, int i4, Composer composer, int i5) {
        e(str, str2, j, str3, j2, f, modifier, z, i, g3Var, function0, iVar, function5, composer, x2.a(i2 | 1), x2.a(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(androidx.compose.ui.text.e eVar, String str, long j, String str2, long j2, float f, Modifier modifier, boolean z, int i, g3 g3Var, Function0 function0, androidx.compose.animation.core.i iVar, Function5 function5, int i2, int i3, int i4, Composer composer, int i5) {
        d(eVar, str, j, str2, j2, f, modifier, z, i, g3Var, function0, iVar, function5, composer, x2.a(i2 | 1), x2.a(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(androidx.compose.ui.text.e eVar, g3 g3Var, int i, int i2, Composer composer, int i3) {
        h(eVar, g3Var, i, composer, x2.a(i2 | 1));
        return Unit.INSTANCE;
    }

    static {
        Covode.recordClassIndex(609678);
        a = x0.i.g(6);
    }

    static final class a implements Function3<v, Composer, Integer, Unit> {
        final /* synthetic */ g3 a;
        final /* synthetic */ androidx.compose.ui.text.e b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ boolean e;
        final /* synthetic */ float f;
        final /* synthetic */ int g;
        final /* synthetic */ androidx.compose.animation.core.i<Float> h;
        final /* synthetic */ a3 i;
        final /* synthetic */ Function0<Unit> j;
        final /* synthetic */ Function5<androidx.compose.ui.text.e, g3, Integer, Composer, Integer, Unit> k;
        final /* synthetic */ long l;
        final /* synthetic */ long m;

        a(g3 g3Var, androidx.compose.ui.text.e eVar, String str, String str2, boolean z, float f, int i, androidx.compose.animation.core.i<Float> iVar, a3 a3Var, Function0<Unit> function0, Function5<? super androidx.compose.ui.text.e, ? super g3, ? super Integer, ? super Composer, ? super Integer, Unit> function5, long j, long j2) {
            this.a = g3Var;
            this.b = eVar;
            this.c = str;
            this.d = str2;
            this.e = z;
            this.f = f;
            this.g = i;
            this.h = iVar;
            this.i = a3Var;
            this.j = function0;
            this.k = function5;
            this.l = j;
            this.m = j2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit d(Function0 function0) {
            function0.invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(Function0 function0) {
            function0.invoke();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(v vVar, Composer composer, Integer num) {
            c(vVar, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void c(v BoxWithConstraints, Composer composer, int i) {
            int i2;
            boolean z;
            String str;
            long j;
            int i3;
            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
            if ((i & 6) == 0) {
                if (composer.changed(BoxWithConstraints)) {
                    i3 = 4;
                } else {
                    i3 = 2;
                }
                i2 = i | i3;
            } else {
                i2 = i;
            }
            if ((i2 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i2 & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-661896393, i2, -1, "com.dragon.read.kmp.widget.expandableText.ExpandableText.<anonymous> (ExtandableText.kt:104)");
                }
                g3 G = ((g3) composer.consume(a6.q())).G(this.a);
                b s = ExtandableTextKt.s(BoxWithConstraints.e(), this.b, this.c, this.d, this.e, this.f, this.g, G, this.h, this.i, composer, 0);
                Modifier.a aVar = Modifier.Companion;
                Modifier i4 = SizeKt.i(SizeKt.h(aVar, 0.0f, 1, (Object) null), ((x0.e) composer.consume(CompositionLocalsKt.f())).w1(s.e));
                composer.startReplaceGroup(5004770);
                boolean changed = composer.changed(this.j);
                final Function0<Unit> function0 = this.j;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: com.dragon.read.kmp.widget.expandableText.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit d;
                            d = ExtandableTextKt.a.d(Function0.this);
                            return d;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceGroup();
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(i4, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue, 15, (Object) null);
                Function5<androidx.compose.ui.text.e, g3, Integer, Composer, Integer, Unit> function5 = this.k;
                int i5 = this.g;
                boolean z2 = this.e;
                String str2 = this.d;
                String str3 = this.c;
                long j2 = this.l;
                long j3 = this.m;
                final Function0<Unit> function02 = this.j;
                e.a aVar2 = androidx.compose.ui.e.a;
                p0 i6 = m.i(aVar2.o(), false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, modifier);
                ComposeUiNode.Companion companion = ComposeUiNode.o0;
                Function0 a2 = companion.a();
                if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                    androidx.compose.runtime.i.d();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(a2);
                } else {
                    composer.useNode();
                }
                Composer b = g5.b(composer);
                g5.e(b, i6, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                function5.invoke(s.a, G, Integer.valueOf(s.b), composer, 0);
                composer.startReplaceGroup(375308970);
                if (s.c > i5) {
                    if (z2) {
                        str = str2;
                    } else {
                        str = str3;
                    }
                    if (z2) {
                        j = j2;
                    } else {
                        j = j3;
                    }
                    Modifier a3 = o.a(f2.v(boxScopeInstance.b(aVar, aVar2.c()), 0.0f, 0.0f, ExtandableTextKt.a, 0.0f, 11, (Object) null), 1.0f);
                    composer.startReplaceGroup(5004770);
                    boolean changed2 = composer.changed(function02);
                    Object rememberedValue2 = composer.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                        rememberedValue2 = new Function0() { // from class: com.dragon.read.kmp.widget.expandableText.g
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                Unit e2;
                                e2 = ExtandableTextKt.a.e(Function0.this);
                                return e2;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue2);
                    }
                    composer.endReplaceGroup();
                    a6.j(str, ClickableKt.clickable-oSLSa3U$default(a3, false, (String) null, (Role) null, (androidx.compose.foundation.interaction.i) null, (Function0) rememberedValue2, 15, (Object) null), j, 0L, (y) null, (c0) null, (j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, 0, 0, (Function1) null, G, composer, 0, 0, 65528);
                }
                composer.endReplaceGroup();
                composer.endNode();
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
    public static final androidx.compose.ui.text.e t(MutableState<androidx.compose.ui.text.e> mutableState) {
        return (androidx.compose.ui.text.e) mutableState.getValue();
    }

    private static final int v(MutableState<Integer> mutableState) {
        return ((Number) mutableState.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean x(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(MutableState<androidx.compose.ui.text.e> mutableState, androidx.compose.ui.text.e eVar) {
        mutableState.setValue(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(MutableState<Integer> mutableState, int i) {
        mutableState.setValue(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final androidx.compose.ui.text.e p(androidx.compose.ui.text.e eVar, int i) {
        androidx.compose.ui.text.e o = eVar.o(0, i);
        e.b bVar = new e.b(0, 1, (DefaultConstructorMarker) null);
        bVar.f(o);
        bVar.c((char) 8230);
        bVar.c(' ');
        return bVar.q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
    
        if (r26.changed(r25) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004c, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004d, code lost:
    
        r2 = r3 | r4;
        r3 = r26.rememberedValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r2 != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0081, code lost:
    
        r3 = (androidx.compose.ui.text.y2) r3;
        r26.endReplaceGroup();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008a, code lost:
    
        if (androidx.compose.runtime.ComposerKt.isTraceInProgress() == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008c, code lost:
    
        androidx.compose.runtime.ComposerKt.traceEventEnd();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
    
        r26.endReplaceGroup();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0092, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005d, code lost:
    
        r3 = androidx.compose.ui.text.a3.d(r23, new androidx.compose.ui.text.e(r24, (java.util.List) null, 2, (kotlin.jvm.internal.DefaultConstructorMarker) null), r25, 0, false, 1, (java.util.List) null, 0, (androidx.compose.ui.unit.LayoutDirection) null, (x0.e) null, (androidx.compose.ui.text.font.j.b) null, false, 2028, (java.lang.Object) null);
        r26.updateRememberedValue(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
    
        if ((r27 & 384) == 256) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final androidx.compose.ui.text.y2 A(androidx.compose.ui.text.a3 r23, java.lang.String r24, androidx.compose.ui.text.g3 r25, androidx.compose.runtime.Composer r26, int r27) {
        /*
            r0 = r24
            r1 = r26
            r2 = r27
            r3 = 1457912965(0x56e5fc85, float:1.2643636E14)
            r1.startReplaceGroup(r3)
            boolean r4 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r4 == 0) goto L18
            r4 = -1
            java.lang.String r5 = "com.dragon.read.kmp.widget.expandableText.rememberTextResult (ExtandableText.kt:340)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r2, r4, r5)
        L18:
            r3 = -1633490746(0xffffffff9ea2e8c6, float:-1.724869E-20)
            r1.startReplaceGroup(r3)
            r3 = r2 & 112(0x70, float:1.57E-43)
            r3 = r3 ^ 48
            r4 = 0
            r5 = 1
            r6 = 32
            if (r3 <= r6) goto L2e
            boolean r3 = r1.changed(r0)
            if (r3 != 0) goto L32
        L2e:
            r3 = r2 & 48
            if (r3 != r6) goto L34
        L32:
            r3 = 1
            goto L35
        L34:
            r3 = 0
        L35:
            r6 = r2 & 896(0x380, float:1.256E-42)
            r6 = r6 ^ 384(0x180, float:5.38E-43)
            r7 = 256(0x100, float:3.59E-43)
            if (r6 <= r7) goto L46
            r6 = r25
            boolean r8 = r1.changed(r6)
            if (r8 != 0) goto L4c
            goto L48
        L46:
            r6 = r25
        L48:
            r2 = r2 & 384(0x180, float:5.38E-43)
            if (r2 != r7) goto L4d
        L4c:
            r4 = 1
        L4d:
            r2 = r3 | r4
            java.lang.Object r3 = r26.rememberedValue()
            if (r2 != 0) goto L5d
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r3 != r2) goto L81
        L5d:
            androidx.compose.ui.text.e r9 = new androidx.compose.ui.text.e
            r2 = 2
            r3 = 0
            r9.<init>(r0, r3, r2, r3)
            r11 = 0
            r12 = 0
            r13 = 1
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 2028(0x7ec, float:2.842E-42)
            r22 = 0
            r8 = r23
            r10 = r25
            androidx.compose.ui.text.y2 r3 = androidx.compose.ui.text.a3.d(r8, r9, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r21, r22)
            r1.updateRememberedValue(r3)
        L81:
            androidx.compose.ui.text.y2 r3 = (androidx.compose.ui.text.y2) r3
            r26.endReplaceGroup()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L8f
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L8f:
            r26.endReplaceGroup()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.expandableText.ExtandableTextKt.A(androidx.compose.ui.text.a3, java.lang.String, androidx.compose.ui.text.g3, androidx.compose.runtime.Composer, int):androidx.compose.ui.text.y2");
    }

    public static final void h(final androidx.compose.ui.text.e text, final g3 style, final int i, Composer composer, final int i2) {
        int i3;
        boolean z;
        Composer composer2;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Composer startRestartGroup = composer.startRestartGroup(647031054);
        if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(text)) {
                i6 = 4;
            } else {
                i6 = 2;
            }
            i3 = i6 | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            if (startRestartGroup.changed(style)) {
                i5 = 32;
            } else {
                i5 = 16;
            }
            i3 |= i5;
        }
        if ((i2 & 384) == 0) {
            if (startRestartGroup.changed(i)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        int i7 = i3;
        if ((i7 & MediaPlayer.MEDIA_PLAYER_OPTION_ABR_STREAM_INFO) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i7 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(647031054, i7, -1, "com.dragon.read.kmp.widget.expandableText.SimpleExpandableTextContent (ExtandableText.kt:153)");
            }
            composer2 = startRestartGroup;
            a6.k(text, (Modifier) null, 0L, 0L, (y) null, (c0) null, (j) null, 0L, (w0.i) null, (w0.h) null, 0L, 0, false, i, 0, (Map) null, (Function1) null, style, composer2, i7 & 14, ((i7 << 3) & 7168) | ((i7 << 18) & 29360128), 122878);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.widget.expandableText.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i8;
                    i8 = ExtandableTextKt.i(text, style, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return i8;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        if (r26.changed(r22) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final androidx.compose.ui.text.y2 z(androidx.compose.ui.text.a3 r21, androidx.compose.ui.text.e r22, androidx.compose.ui.text.g3 r23, long r24, androidx.compose.runtime.Composer r26, int r27) {
        /*
            r0 = r26
            r1 = r27
            r2 = 109323622(0x6842566, float:4.9707833E-35)
            r0.startReplaceGroup(r2)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L16
            r3 = -1
            java.lang.String r4 = "com.dragon.read.kmp.widget.expandableText.rememberExpandedTextLayoutResult (ExtandableText.kt:372)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r3, r4)
        L16:
            r2 = -1746271574(0xffffffff97ea02aa, float:-1.5122568E-24)
            r0.startReplaceGroup(r2)
            r2 = r1 & 112(0x70, float:1.57E-43)
            r2 = r2 ^ 48
            r3 = 32
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L2f
            r2 = r22
            boolean r6 = r0.changed(r2)
            if (r6 != 0) goto L35
            goto L31
        L2f:
            r2 = r22
        L31:
            r6 = r1 & 48
            if (r6 != r3) goto L37
        L35:
            r3 = 1
            goto L38
        L37:
            r3 = 0
        L38:
            r6 = r1 & 896(0x380, float:1.256E-42)
            r6 = r6 ^ 384(0x180, float:5.38E-43)
            r7 = 256(0x100, float:3.59E-43)
            r8 = r23
            if (r6 <= r7) goto L48
            boolean r6 = r0.changed(r8)
            if (r6 != 0) goto L4c
        L48:
            r6 = r1 & 384(0x180, float:5.38E-43)
            if (r6 != r7) goto L4e
        L4c:
            r6 = 1
            goto L4f
        L4e:
            r6 = 0
        L4f:
            r3 = r3 | r6
            r6 = r1 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 ^ 3072(0xc00, float:4.305E-42)
            r7 = 2048(0x800, float:2.87E-42)
            r13 = r24
            if (r6 <= r7) goto L60
            boolean r6 = r0.changed(r13)
            if (r6 != 0) goto L64
        L60:
            r1 = r1 & 3072(0xc00, float:4.305E-42)
            if (r1 != r7) goto L65
        L64:
            r4 = 1
        L65:
            r1 = r3 | r4
            java.lang.Object r3 = r26.rememberedValue()
            if (r1 != 0) goto L75
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L93
        L75:
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 1980(0x7bc, float:2.775E-42)
            r20 = 0
            r6 = r21
            r7 = r22
            r8 = r23
            r13 = r24
            androidx.compose.ui.text.y2 r3 = androidx.compose.ui.text.a3.d(r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20)
            r0.updateRememberedValue(r3)
        L93:
            androidx.compose.ui.text.y2 r3 = (androidx.compose.ui.text.y2) r3
            r26.endReplaceGroup()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto La1
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        La1:
            r26.endReplaceGroup()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.expandableText.ExtandableTextKt.z(androidx.compose.ui.text.a3, androidx.compose.ui.text.e, androidx.compose.ui.text.g3, long, androidx.compose.runtime.Composer, int):androidx.compose.ui.text.y2");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        if (r27.changed(r22) != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final androidx.compose.ui.text.y2 r(androidx.compose.ui.text.a3 r21, androidx.compose.ui.text.e r22, androidx.compose.ui.text.g3 r23, int r24, long r25, androidx.compose.runtime.Composer r27, int r28) {
        /*
            r0 = r27
            r1 = r28
            r2 = -1435858673(0xffffffffaa6a890f, float:-2.0830927E-13)
            r0.startReplaceGroup(r2)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L16
            r3 = -1
            java.lang.String r4 = "com.dragon.read.kmp.widget.expandableText.rememberCollapsedTextLayoutResult (ExtandableText.kt:356)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r1, r3, r4)
        L16:
            r2 = -1224400529(0xffffffffb705216f, float:-7.935202E-6)
            r0.startReplaceGroup(r2)
            r2 = r1 & 112(0x70, float:1.57E-43)
            r2 = r2 ^ 48
            r3 = 32
            r4 = 0
            r5 = 1
            if (r2 <= r3) goto L2f
            r2 = r22
            boolean r6 = r0.changed(r2)
            if (r6 != 0) goto L35
            goto L31
        L2f:
            r2 = r22
        L31:
            r6 = r1 & 48
            if (r6 != r3) goto L37
        L35:
            r3 = 1
            goto L38
        L37:
            r3 = 0
        L38:
            r6 = r1 & 896(0x380, float:1.256E-42)
            r6 = r6 ^ 384(0x180, float:5.38E-43)
            r7 = 256(0x100, float:3.59E-43)
            r8 = r23
            if (r6 <= r7) goto L48
            boolean r6 = r0.changed(r8)
            if (r6 != 0) goto L4c
        L48:
            r6 = r1 & 384(0x180, float:5.38E-43)
            if (r6 != r7) goto L4e
        L4c:
            r6 = 1
            goto L4f
        L4e:
            r6 = 0
        L4f:
            r3 = r3 | r6
            r6 = r1 & 7168(0x1c00, float:1.0045E-41)
            r6 = r6 ^ 3072(0xc00, float:4.305E-42)
            r7 = 2048(0x800, float:2.87E-42)
            r11 = r24
            if (r6 <= r7) goto L60
            boolean r6 = r0.changed(r11)
            if (r6 != 0) goto L64
        L60:
            r6 = r1 & 3072(0xc00, float:4.305E-42)
            if (r6 != r7) goto L66
        L64:
            r6 = 1
            goto L67
        L66:
            r6 = 0
        L67:
            r3 = r3 | r6
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r1
            r6 = r6 ^ 24576(0x6000, float:3.4438E-41)
            r7 = 16384(0x4000, float:2.2959E-41)
            r13 = r25
            if (r6 <= r7) goto L7a
            boolean r6 = r0.changed(r13)
            if (r6 != 0) goto L7e
        L7a:
            r1 = r1 & 24576(0x6000, float:3.4438E-41)
            if (r1 != r7) goto L7f
        L7e:
            r4 = 1
        L7f:
            r1 = r3 | r4
            java.lang.Object r3 = r27.rememberedValue()
            if (r1 != 0) goto L8f
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto Lae
        L8f:
            r9 = 0
            r10 = 0
            r12 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 1964(0x7ac, float:2.752E-42)
            r20 = 0
            r6 = r21
            r7 = r22
            r8 = r23
            r11 = r24
            r13 = r25
            androidx.compose.ui.text.y2 r3 = androidx.compose.ui.text.a3.d(r6, r7, r8, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20)
            r0.updateRememberedValue(r3)
        Lae:
            androidx.compose.ui.text.y2 r3 = (androidx.compose.ui.text.y2) r3
            r27.endReplaceGroup()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto Lbc
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        Lbc:
            r27.endReplaceGroup()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.expandableText.ExtandableTextKt.r(androidx.compose.ui.text.a3, androidx.compose.ui.text.e, androidx.compose.ui.text.g3, int, long, androidx.compose.runtime.Composer, int):androidx.compose.ui.text.y2");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x009e, code lost:
    
        if (r33.changed(r29) != false) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final androidx.compose.ui.text.e q(androidx.compose.ui.text.y2 r24, androidx.compose.ui.text.e r25, int r26, int r27, androidx.compose.ui.text.g3 r28, long r29, int r31, androidx.compose.ui.text.a3 r32, androidx.compose.runtime.Composer r33, int r34) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.expandableText.ExtandableTextKt.q(androidx.compose.ui.text.y2, androidx.compose.ui.text.e, int, int, androidx.compose.ui.text.g3, long, int, androidx.compose.ui.text.a3, androidx.compose.runtime.Composer, int):androidx.compose.ui.text.e");
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x02b9, code lost:
    
        if (r38.changed(r9) == false) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0345  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.dragon.read.kmp.widget.expandableText.b s(long r27, androidx.compose.ui.text.e r29, java.lang.String r30, java.lang.String r31, boolean r32, float r33, int r34, androidx.compose.ui.text.g3 r35, androidx.compose.animation.core.i<java.lang.Float> r36, androidx.compose.ui.text.a3 r37, androidx.compose.runtime.Composer r38, int r39) {
        /*
            Method dump skipped, instructions count: 844
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.expandableText.ExtandableTextKt.s(long, androidx.compose.ui.text.e, java.lang.String, java.lang.String, boolean, float, int, androidx.compose.ui.text.g3, androidx.compose.animation.core.i, androidx.compose.ui.text.a3, androidx.compose.runtime.Composer, int):com.dragon.read.kmp.widget.expandableText.b");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void d(final androidx.compose.ui.text.e r60, final java.lang.String r61, long r62, final java.lang.String r64, long r65, float r67, androidx.compose.ui.Modifier r68, final boolean r69, int r70, androidx.compose.ui.text.g3 r71, final kotlin.jvm.functions.Function0<kotlin.Unit> r72, androidx.compose.animation.core.i<java.lang.Float> r73, kotlin.jvm.functions.Function5<? super androidx.compose.ui.text.e, ? super androidx.compose.ui.text.g3, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, androidx.compose.runtime.Composer r75, final int r76, final int r77, final int r78) {
        /*
            Method dump skipped, instructions count: 756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.expandableText.ExtandableTextKt.d(androidx.compose.ui.text.e, java.lang.String, long, java.lang.String, long, float, androidx.compose.ui.Modifier, boolean, int, androidx.compose.ui.text.g3, kotlin.jvm.functions.Function0, androidx.compose.animation.core.i, kotlin.jvm.functions.Function5, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final java.lang.String r63, final java.lang.String r64, long r65, final java.lang.String r67, long r68, float r70, androidx.compose.ui.Modifier r71, boolean r72, int r73, androidx.compose.ui.text.g3 r74, final kotlin.jvm.functions.Function0<kotlin.Unit> r75, androidx.compose.animation.core.i<java.lang.Float> r76, kotlin.jvm.functions.Function5<? super androidx.compose.ui.text.e, ? super androidx.compose.ui.text.g3, ? super java.lang.Integer, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r77, androidx.compose.runtime.Composer r78, final int r79, final int r80, final int r81) {
        /*
            Method dump skipped, instructions count: 777
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.expandableText.ExtandableTextKt.e(java.lang.String, java.lang.String, long, java.lang.String, long, float, androidx.compose.ui.Modifier, boolean, int, androidx.compose.ui.text.g3, kotlin.jvm.functions.Function0, androidx.compose.animation.core.i, kotlin.jvm.functions.Function5, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
