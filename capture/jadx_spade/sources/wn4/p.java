package wn4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.share.view.a0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class p extends rn4.o {
    public static final int p;
    public final String o;

    static {
        Covode.recordClassIndex(608954);
        p = 8;
    }

    @Override // rn4.o
    public ViewGroup k0(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        return (ViewGroup) rootView.findViewById(2131824992);
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ List<bh1.a> b;
        final /* synthetic */ Function1<bh1.a, Unit> c;
        final /* synthetic */ boolean d;

        a(List<bh1.a> list, Function1<? super bh1.a, Unit> function1, boolean z) {
            this.b = list;
            this.c = function1;
            this.d = z;
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
                    ComposerKt.traceEventStart(1774592378, i, -1, "com.dragon.read.kmp.share.panel.KmpWebSharePanelDialog.getSharePanelComposeView.<anonymous> (KmpWebSharePanelDialog.kt:28)");
                }
                a0.h(p.this.o, this.b, this.c, this.d, composer, 0);
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
        final /* synthetic */ String a;
        final /* synthetic */ List<bh1.a> b;
        final /* synthetic */ Function1<bh1.a, Unit> c;
        final /* synthetic */ p d;

        b(String str, List<bh1.a> list, Function1<? super bh1.a, Unit> function1, p pVar) {
            this.a = str;
            this.b = list;
            this.c = function1;
            this.d = pVar;
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
                    ComposerKt.traceEventStart(-448766130, i, -1, "com.dragon.read.kmp.share.panel.KmpWebSharePanelDialog.replaceContentView.<anonymous> (KmpWebSharePanelDialog.kt:39)");
                }
                a0.h(this.a, this.b, this.c, this.d.c, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    @Override // rn4.o
    public View m0(Context context, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(2131038329, viewGroup, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    @Override // rn4.o
    public Function2<Composer, Integer, Unit> n0(List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener, boolean z) {
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        return t.c(1774592378, true, new a(shareChannelList, onClickListener, z));
    }

    @Override // wn4.b
    public void C(String title, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        t0(t.c(-448766130, true, new b(title, shareChannelList, onClickListener, this)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Activity activity, String title, List<bh1.a> shareChannelList, Function1<? super bh1.a, Unit> onClickListener, int i, boolean z) {
        super(activity, shareChannelList, onClickListener, i, z);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.o = title;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ p(android.app.Activity r8, java.lang.String r9, java.util.List r10, kotlin.jvm.functions.Function1 r11, int r12, boolean r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 16
            if (r15 == 0) goto Lb
            r12 = 2131297279(0x7f0903ff, float:1.8212498E38)
            r5 = 2131297279(0x7f0903ff, float:1.8212498E38)
            goto Lc
        Lb:
            r5 = r12
        Lc:
            r12 = r14 & 32
            if (r12 == 0) goto L14
            boolean r13 = com.dragon.read.base.skin.SkinManager.isNightMode()
        L14:
            r6 = r13
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: wn4.p.<init>(android.app.Activity, java.lang.String, java.util.List, kotlin.jvm.functions.Function1, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
