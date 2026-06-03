package wn4;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import com.bytedance.covode.number.Covode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wn4.i;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i extends rn4.b {
    public static final int o;
    private String m;
    private final vn4.a n;

    static {
        Covode.recordClassIndex(608950);
        o = 8;
    }

    @Override // rn4.b
    public int e() {
        return 2131038326;
    }

    @Override // rn4.b
    public void f() {
    }

    @Override // rn4.b
    public ViewGroup b() {
        View findViewById = findViewById(2131826731);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        return (ViewGroup) findViewById;
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ List<bh1.a> b;
        final /* synthetic */ boolean c;
        final /* synthetic */ Function1<bh1.a, Unit> d;

        a(List<bh1.a> list, boolean z, Function1<? super bh1.a, Unit> function1) {
            this.b = list;
            this.c = z;
            this.d = function1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit e(i iVar) {
            iVar.dismiss("mask_layer");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit f(i iVar) {
            iVar.dismiss("close_button");
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(i iVar, boolean z) {
            iVar.n.n(z);
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
                    ComposerKt.traceEventStart(-2036195317, i, -1, "com.dragon.read.kmp.share.panel.KmpPosterSharePanelDialog.getFullscreenComposeView.<anonymous> (KmpPosterSharePanelDialog.kt:42)");
                }
                String str = i.this.m;
                vn4.a aVar = i.this.n;
                List<bh1.a> list = this.b;
                boolean z2 = this.c;
                composer.startReplaceGroup(5004770);
                boolean changedInstance = composer.changedInstance(i.this);
                final i iVar = i.this;
                Object rememberedValue = composer.rememberedValue();
                if (changedInstance || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = new Function0() { // from class: wn4.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit e;
                            e = i.a.e(i.this);
                            return e;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue);
                }
                Function0 function0 = (Function0) rememberedValue;
                composer.endReplaceGroup();
                composer.startReplaceGroup(5004770);
                boolean changedInstance2 = composer.changedInstance(i.this);
                final i iVar2 = i.this;
                Object rememberedValue2 = composer.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: wn4.g
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit f;
                            f = i.a.f(i.this);
                            return f;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue2);
                }
                Function0 function02 = (Function0) rememberedValue2;
                composer.endReplaceGroup();
                composer.startReplaceGroup(5004770);
                boolean changedInstance3 = composer.changedInstance(i.this);
                final i iVar3 = i.this;
                Object rememberedValue3 = composer.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: wn4.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit g;
                            g = i.a.g(i.this, ((Boolean) obj).booleanValue());
                            return g;
                        }
                    };
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceGroup();
                com.dragon.read.kmp.share.view.l.b(str, aVar, list, z2, function0, function02, (Function1) rememberedValue3, this.d, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    @Override // rn4.b
    public Function2<Composer, Integer, Unit> c(un4.j tvUgPostShareParams, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener, boolean z) {
        Intrinsics.checkNotNullParameter(tvUgPostShareParams, "tvUgPostShareParams");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        return t.c(-2036195317, true, new a(shareChannelList, z, onClickListener));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Activity activity, String title, vn4.a shareParams, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener, int i, boolean z) {
        super(activity, shareParams, shareChannelList, onClickListener, i, z);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.m = title;
        this.n = shareParams;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ i(android.app.Activity r10, java.lang.String r11, vn4.a r12, java.util.List r13, kotlin.jvm.functions.Function1 r14, int r15, boolean r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r9 = this;
            r0 = r17 & 32
            if (r0 == 0) goto Lb
            r0 = 2131297279(0x7f0903ff, float:1.8212498E38)
            r7 = 2131297279(0x7f0903ff, float:1.8212498E38)
            goto Lc
        Lb:
            r7 = r15
        Lc:
            r0 = r17 & 64
            if (r0 == 0) goto L16
            boolean r0 = com.dragon.read.base.skin.SkinManager.isNightMode()
            r8 = r0
            goto L18
        L16:
            r8 = r16
        L18:
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wn4.i.<init>(android.app.Activity, java.lang.String, vn4.a, java.util.List, kotlin.jvm.functions.Function1, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
