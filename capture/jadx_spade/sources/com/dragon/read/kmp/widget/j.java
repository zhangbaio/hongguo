package com.dragon.read.kmp.widget;

import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.v2;
import androidx.compose.foundation.text.w2;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.g5;
import androidx.compose.runtime.t3;
import androidx.compose.runtime.x2;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.e;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.g3;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.widget.j;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    static {
        Covode.recordClassIndex(609628);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(androidx.compose.ui.text.input.r0 r0Var, Function1 function1, Function1 function12, Modifier modifier, int i, Function2 function2, androidx.compose.ui.graphics.c0 c0Var, g3 g3Var, w2 w2Var, int i2, int i3, Composer composer, int i4) {
        d(r0Var, function1, function12, modifier, i, function2, c0Var, g3Var, w2Var, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(String str, Function1 function1, Modifier modifier, int i, Function2 function2, androidx.compose.ui.graphics.c0 c0Var, g3 g3Var, int i2, int i3, Composer composer, int i4) {
        g(str, function1, modifier, i, function2, c0Var, g3Var, composer, x2.a(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    static final class a implements Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit> {
        final /* synthetic */ androidx.compose.ui.text.input.r0 a;
        final /* synthetic */ Function2<Composer, Integer, Unit> b;

        a(androidx.compose.ui.text.input.r0 r0Var, Function2<? super Composer, ? super Integer, Unit> function2) {
            this.a = r0Var;
            this.b = function2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(androidx.compose.ui.semantics.x clearAndSetSemantics) {
            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
            b(function2, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void b(Function2<? super Composer, ? super Integer, Unit> innerTextField, Composer composer, int i) {
            int i2;
            boolean z;
            boolean z2;
            int i3;
            Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
            if ((i & 6) == 0) {
                if (composer.changedInstance(innerTextField)) {
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
                    ComposerKt.traceEventStart(1835751119, i2, -1, "com.dragon.read.kmp.widget.BasicTextFieldPlaceHolderWithSelection.<anonymous> (BasicTextFieldWithPlaceHolder.kt:71)");
                }
                Modifier.a aVar = Modifier.Companion;
                Modifier h = SizeKt.h(aVar, 0.0f, 1, (Object) null);
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.e h2 = aVar2.h();
                androidx.compose.ui.text.input.r0 r0Var = this.a;
                Function2<Composer, Integer, Unit> function2 = this.b;
                androidx.compose.ui.layout.p0 i4 = androidx.compose.foundation.layout.m.i(h2, false);
                int a = j.a(androidx.compose.runtime.i.b(composer, 0));
                androidx.compose.runtime.e0 currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier e = ComposedModifierKt.e(composer, h);
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
                g5.e(b, i4, companion.c());
                g5.e(b, currentCompositionLocalMap, companion.e());
                Function2 b2 = companion.b();
                if (b.getInserting() || !Intrinsics.areEqual(b.rememberedValue(), Integer.valueOf(a))) {
                    b.updateRememberedValue(Integer.valueOf(a));
                    b.apply(Integer.valueOf(a), b2);
                }
                g5.e(b, e, companion.d());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.a;
                composer.startReplaceGroup(-2128795347);
                if (r0Var.i().length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    Modifier v = androidx.compose.foundation.layout.f2.v(aVar, x0.i.g(2), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    composer.startReplaceGroup(1849434622);
                    Object rememberedValue = composer.rememberedValue();
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue = new Function1() { // from class: com.dragon.read.kmp.widget.i
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit c;
                                c = j.a.c((androidx.compose.ui.semantics.x) obj);
                                return c;
                            }
                        };
                        composer.updateRememberedValue(rememberedValue);
                    }
                    composer.endReplaceGroup();
                    Modifier a3 = androidx.compose.ui.semantics.s.a(v, (Function1) rememberedValue);
                    androidx.compose.ui.layout.p0 i5 = androidx.compose.foundation.layout.m.i(aVar2.o(), false);
                    int a4 = j.a(androidx.compose.runtime.i.b(composer, 0));
                    androidx.compose.runtime.e0 currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                    Modifier e2 = ComposedModifierKt.e(composer, a3);
                    Function0 a5 = companion.a();
                    if (!(composer.getApplier() instanceof androidx.compose.runtime.e)) {
                        androidx.compose.runtime.i.d();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(a5);
                    } else {
                        composer.useNode();
                    }
                    Composer b3 = g5.b(composer);
                    g5.e(b3, i5, companion.c());
                    g5.e(b3, currentCompositionLocalMap2, companion.e());
                    Function2 b4 = companion.b();
                    if (b3.getInserting() || !Intrinsics.areEqual(b3.rememberedValue(), Integer.valueOf(a4))) {
                        b3.updateRememberedValue(Integer.valueOf(a4));
                        b3.apply(Integer.valueOf(a4), b4);
                    }
                    g5.e(b3, e2, companion.d());
                    function2.invoke(composer, 0);
                    composer.endNode();
                }
                composer.endReplaceGroup();
                innerTextField.invoke(composer, Integer.valueOf(i2 & 14));
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
    public static final Unit e(Function1 function1, Function1 function12, androidx.compose.ui.text.input.r0 incoming) {
        Intrinsics.checkNotNullParameter(incoming, "incoming");
        function1.invoke(function12.invoke(incoming));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(final java.lang.String r51, final kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> r52, androidx.compose.ui.Modifier r53, int r54, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r55, androidx.compose.ui.graphics.c0 r56, androidx.compose.ui.text.g3 r57, androidx.compose.runtime.Composer r58, final int r59, final int r60) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.widget.j.g(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, int, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.c0, androidx.compose.ui.text.g3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void d(final androidx.compose.ui.text.input.r0 value, final Function1<? super androidx.compose.ui.text.input.r0, Unit> onValueChange, final Function1<? super androidx.compose.ui.text.input.r0, androidx.compose.ui.text.input.r0> transformInput, final Modifier modifier, final int i, final Function2<? super Composer, ? super Integer, Unit> placeholder, final androidx.compose.ui.graphics.c0 cursorBrush, final g3 textStyle, w2 w2Var, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        w2 w2Var2;
        int i13;
        boolean z;
        Composer composer2;
        final w2 w2Var3;
        w2 w2Var4;
        boolean z2;
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Intrinsics.checkNotNullParameter(transformInput, "transformInput");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(cursorBrush, "cursorBrush");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Composer startRestartGroup = composer.startRestartGroup(-54354964);
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (startRestartGroup.changed(value)) {
                i5 = 4;
            } else {
                i5 = 2;
            }
            i4 = i5 | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            if (startRestartGroup.changedInstance(onValueChange)) {
                i6 = 32;
            } else {
                i6 = 16;
            }
            i4 |= i6;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i2 & 384) == 0) {
            if (startRestartGroup.changedInstance(transformInput)) {
                i7 = 256;
            } else {
                i7 = 128;
            }
            i4 |= i7;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i2 & 3072) == 0) {
            if (startRestartGroup.changed(modifier)) {
                i8 = 2048;
            } else {
                i8 = 1024;
            }
            i4 |= i8;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((i2 & 24576) == 0) {
            if (startRestartGroup.changed(i)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i4 |= i9;
        }
        if ((i3 & 32) != 0) {
            i4 |= 196608;
        } else if ((i2 & 196608) == 0) {
            if (startRestartGroup.changedInstance(placeholder)) {
                i10 = 131072;
            } else {
                i10 = 65536;
            }
            i4 |= i10;
        }
        if ((i3 & 64) != 0) {
            i4 |= 1572864;
        } else if ((i2 & 1572864) == 0) {
            if (startRestartGroup.changed(cursorBrush)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i4 |= i11;
        }
        if ((i3 & 128) != 0) {
            i4 |= 12582912;
        } else if ((i2 & 12582912) == 0) {
            if (startRestartGroup.changed(textStyle)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i4 |= i12;
        }
        int i14 = i3 & 256;
        if (i14 != 0) {
            i4 |= 100663296;
            w2Var2 = w2Var;
        } else {
            w2Var2 = w2Var;
            if ((i2 & 100663296) == 0) {
                if (startRestartGroup.changed(w2Var2)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i4 |= i13;
            }
        }
        boolean z3 = false;
        if ((i4 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (startRestartGroup.shouldExecute(z, i4 & 1)) {
            if (i14 != 0) {
                w2Var4 = w2.g.a();
            } else {
                w2Var4 = w2Var2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-54354964, i4, -1, "com.dragon.read.kmp.widget.BasicTextFieldPlaceHolderWithSelection (BasicTextFieldWithPlaceHolder.kt:61)");
            }
            startRestartGroup.startReplaceGroup(-1633490746);
            if ((i4 & 112) == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((i4 & 896) == 256) {
                z3 = true;
            }
            boolean z4 = z2 | z3;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z4 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new Function1() { // from class: com.dragon.read.kmp.widget.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit e;
                        e = j.e(Function1.this, transformInput, (androidx.compose.ui.text.input.r0) obj);
                        return e;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            int i15 = i4;
            int i16 = i15 >> 6;
            w2 w2Var5 = w2Var4;
            composer2 = startRestartGroup;
            BasicTextFieldKt.r(value, (Function1) rememberedValue, modifier, false, false, textStyle, w2Var5, (v2) null, false, i, 0, (androidx.compose.ui.text.input.b1) null, (Function1) null, (androidx.compose.foundation.interaction.i) null, cursorBrush, androidx.compose.runtime.internal.t.e(1835751119, true, new a(value, placeholder), startRestartGroup, 54), startRestartGroup, (i15 & 14) | ((i15 >> 3) & 896) | (458752 & i16) | (3670016 & i16) | ((i15 << 15) & 1879048192), (57344 & i16) | 196608, 15768);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            w2Var3 = w2Var4;
        } else {
            composer2 = startRestartGroup;
            composer2.skipToGroupEnd();
            w2Var3 = w2Var2;
        }
        t3 endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.a(new Function2() { // from class: com.dragon.read.kmp.widget.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit f;
                    f = j.f(value, onValueChange, transformInput, modifier, i, placeholder, cursorBrush, textStyle, w2Var3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    return f;
                }
            });
        }
    }
}
