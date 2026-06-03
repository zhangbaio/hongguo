package hq4;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.x2;
import androidx.compose.ui.graphics.f2;
import com.bytedance.covode.number.Covode;
import hq4.b0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b0 {
    static {
        Covode.recordClassIndex(609672);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(String str, String str2, Integer num, String str3, String str4, Function0 function0, Function0 function02, Function0 function03, r rVar, f2 f2Var, boolean z, boolean z2, boolean z3, String str5, int i, w0.h hVar, int i2, int i3, int i4, Composer composer, int i5) {
        g(str, str2, num, str3, str4, function0, function02, function03, rVar, f2Var, z, z2, z3, str5, i, hVar, composer, x2.a(i2 | 1), x2.a(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function0 function0, String str, String str2, Integer num, String str3, String str4, Function0 function02, Function0 function03, Function0 function04, r rVar, f2 f2Var, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str5, int i, w0.h hVar, float f, androidx.compose.ui.window.f fVar, int i2, int i3, int i4, int i5, Composer composer, int i6) {
        f(function0, str, str2, num, str3, str4, function02, function03, function04, rVar, f2Var, z, z2, z3, z4, z5, z6, str5, i, hVar, f, fVar, composer, x2.a(i2 | 1), x2.a(i3), x2.a(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j() {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.INSTANCE;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ float a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ Integer d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ Function0<Unit> g;
        final /* synthetic */ boolean h;
        final /* synthetic */ Function0<Unit> i;
        final /* synthetic */ Function0<Unit> j;
        final /* synthetic */ Function0<Unit> k;
        final /* synthetic */ r l;
        final /* synthetic */ f2 m;
        final /* synthetic */ boolean n;
        final /* synthetic */ boolean o;
        final /* synthetic */ boolean p;
        final /* synthetic */ String q;
        final /* synthetic */ int r;
        final /* synthetic */ w0.h s;

        a(float f, String str, String str2, Integer num, String str3, String str4, Function0<Unit> function0, boolean z, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, r rVar, f2 f2Var, boolean z2, boolean z3, boolean z4, String str5, int i, w0.h hVar) {
            this.a = f;
            this.b = str;
            this.c = str2;
            this.d = num;
            this.e = str3;
            this.f = str4;
            this.g = function0;
            this.h = z;
            this.i = function02;
            this.j = function03;
            this.k = function04;
            this.l = rVar;
            this.m = f2Var;
            this.n = z2;
            this.o = z3;
            this.p = z4;
            this.q = str5;
            this.r = i;
            this.s = hVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(Function0 function0, Function0 function02) {
            function0.invoke();
            function02.invoke();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            d(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void d(Composer composer, int i) {
            boolean z;
            if ((i & 3) != 2) {
                z = true;
            } else {
                z = false;
            }
            if (composer.shouldExecute(z, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(931472218, i, -1, "com.dragon.read.kmp.widget.dialog.ConfirmDialog.<anonymous> (ConfirmDialog.kt:105)");
                }
                e0.c(this.a, composer, 0);
                String str = this.b;
                String str2 = this.c;
                Integer num = this.d;
                String str3 = this.e;
                String str4 = this.f;
                composer.startReplaceGroup(-1746271574);
                boolean changed = composer.changed(this.g) | composer.changed(this.h) | composer.changed(this.i);
                final Function0<Unit> function0 = this.g;
                final boolean z2 = this.h;
                final Function0<Unit> function02 = this.i;
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: hq4.y
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit e;
                            e = b0.a.e(Function0.this, z2, function02);
                            return e;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function03 = (Function0) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(-1746271574);
                boolean changed2 = composer.changed(this.j) | composer.changed(this.h) | composer.changed(this.i);
                final Function0<Unit> function04 = this.j;
                final boolean z3 = this.h;
                final Function0<Unit> function05 = this.i;
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: hq4.z
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit f;
                            f = b0.a.f(Function0.this, z3, function05);
                            return f;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                Function0 function06 = (Function0) rememberedValue2;
                composer.endReplaceGroup();
                composer.startReplaceGroup(-1633490746);
                boolean changed3 = composer.changed(this.k) | composer.changed(this.i);
                final Function0<Unit> function07 = this.k;
                final Function0<Unit> function08 = this.i;
                Object rememberedValue3 = composer.rememberedValue();
                if (changed3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: hq4.a0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit g;
                            g = b0.a.g(Function0.this, function08);
                            return g;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                b0.g(str, str2, num, str3, str4, function03, function06, (Function0) rememberedValue3, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, composer, 0, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(Function0 function0, boolean z, Function0 function02) {
            function0.invoke();
            if (z) {
                function02.invoke();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(Function0 function0, boolean z, Function0 function02) {
            function0.invoke();
            if (z) {
                function02.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    static final class b implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ boolean a;
        final /* synthetic */ Function0<Unit> b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ r e;
        final /* synthetic */ Integer f;
        final /* synthetic */ String g;
        final /* synthetic */ int h;
        final /* synthetic */ w0.h i;
        final /* synthetic */ String j;
        final /* synthetic */ Function0<Unit> k;
        final /* synthetic */ String l;
        final /* synthetic */ Function0<Unit> m;
        final /* synthetic */ boolean n;
        final /* synthetic */ boolean o;

        b(boolean z, Function0<Unit> function0, String str, String str2, r rVar, Integer num, String str3, int i, w0.h hVar, String str4, Function0<Unit> function02, String str5, Function0<Unit> function03, boolean z2, boolean z3) {
            this.a = z;
            this.b = function0;
            this.c = str;
            this.d = str2;
            this.e = rVar;
            this.f = num;
            this.g = str3;
            this.h = i;
            this.i = hVar;
            this.j = str4;
            this.k = function02;
            this.l = str5;
            this.m = function03;
            this.n = z2;
            this.o = z3;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Removed duplicated region for block: B:109:0x04f6  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x0502  */
        /* JADX WARN: Removed duplicated region for block: B:115:0x0525  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x0552  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x055e  */
        /* JADX WARN: Removed duplicated region for block: B:139:0x0664  */
        /* JADX WARN: Removed duplicated region for block: B:143:0x0670  */
        /* JADX WARN: Removed duplicated region for block: B:151:0x06af  */
        /* JADX WARN: Removed duplicated region for block: B:155:0x06bb  */
        /* JADX WARN: Removed duplicated region for block: B:174:0x07a7  */
        /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:185:0x064f  */
        /* JADX WARN: Removed duplicated region for block: B:188:0x0506  */
        /* JADX WARN: Removed duplicated region for block: B:195:0x048c  */
        /* JADX WARN: Removed duplicated region for block: B:209:0x037d  */
        /* JADX WARN: Removed duplicated region for block: B:212:0x027d  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0215  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x026d  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0279  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x029c  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x02c7  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x02d3  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0396  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x03a4  */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r3v23 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(androidx.compose.runtime.Composer r84, int r85) {
            /*
                Method dump skipped, instructions count: 1967
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: hq4.b0.b.a(androidx.compose.runtime.Composer, int):void");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(final java.lang.String r34, final java.lang.String r35, java.lang.Integer r36, final java.lang.String r37, final java.lang.String r38, final kotlin.jvm.functions.Function0<kotlin.Unit> r39, final kotlin.jvm.functions.Function0<kotlin.Unit> r40, final kotlin.jvm.functions.Function0<kotlin.Unit> r41, final hq4.r r42, final androidx.compose.ui.graphics.f2 r43, final boolean r44, final boolean r45, final boolean r46, final java.lang.String r47, final int r48, final w0.h r49, androidx.compose.runtime.Composer r50, final int r51, final int r52, final int r53) {
        /*
            Method dump skipped, instructions count: 753
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hq4.b0.g(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, hq4.r, androidx.compose.ui.graphics.f2, boolean, boolean, boolean, java.lang.String, int, w0.h, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(final kotlin.jvm.functions.Function0<kotlin.Unit> r45, java.lang.String r46, java.lang.String r47, java.lang.Integer r48, java.lang.String r49, java.lang.String r50, kotlin.jvm.functions.Function0<kotlin.Unit> r51, kotlin.jvm.functions.Function0<kotlin.Unit> r52, kotlin.jvm.functions.Function0<kotlin.Unit> r53, hq4.r r54, androidx.compose.ui.graphics.f2 r55, boolean r56, boolean r57, boolean r58, boolean r59, boolean r60, boolean r61, java.lang.String r62, int r63, w0.h r64, float r65, androidx.compose.ui.window.f r66, androidx.compose.runtime.Composer r67, final int r68, final int r69, final int r70, final int r71) {
        /*
            Method dump skipped, instructions count: 1320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: hq4.b0.f(kotlin.jvm.functions.Function0, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, hq4.r, androidx.compose.ui.graphics.f2, boolean, boolean, boolean, boolean, boolean, boolean, java.lang.String, int, w0.h, float, androidx.compose.ui.window.f, androidx.compose.runtime.Composer, int, int, int, int):void");
    }
}
