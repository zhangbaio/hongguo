package com.dragon.read.kmp.reader.font;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.ComposeView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.ui.util.ScreenUtils;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.reader.extend.other.ReaderFontChecker;
import com.dragon.read.reader.newfont.FontStyle;
import com.dragon.read.reader.newfont.TypefaceManager;
import com.dragon.read.reader.ui.ReaderActivity;
import com.dragon.reader.lib.ReaderClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m25.b1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class z0 extends com.dragon.read.kmp.ui.a {
    public static final int h;
    private final LogHelper b;
    private final ReaderClient c;
    private final ComposeView d;
    private final c e;
    private final b f;
    private final r0 g;

    static {
        Covode.recordClassIndex(608440);
        h = 8;
    }

    @Override // com.dragon.read.kmp.ui.a
    public String getViewId() {
        return "font";
    }

    public boolean yb() {
        return false;
    }

    public static final class c implements y0 {
        final /* synthetic */ Context b;

        @Override // rm4.a
        public void b() {
            z0.this.e();
        }

        @Override // rm4.a
        public void a(boolean z) {
            z0.this.d(z);
        }

        c(Context context) {
            this.b = context;
        }

        @Override // com.dragon.read.kmp.reader.font.y0
        public void c(h config, boolean z) {
            Intrinsics.checkNotNullParameter(config, "config");
            ReaderActivity context = z0.this.c.getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.dragon.read.reader.ui.ReaderActivity");
            lm4.h w2 = context.w2();
            if (z0.this.n(config)) {
                i25.r.b.a(this.b);
                w2.b().l(Boolean.FALSE);
                w2.b().m(config.a);
                ReaderActivity context2 = z0.this.c.getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type com.dragon.read.reader.ui.ReaderActivity");
                w2.update(context2.h2());
                z0.this.b.i("字体发生切换: 系统字体", new Object[0]);
                return;
            }
            if (TypefaceManager.z(TypefaceManager.a, config.b, (FontStyle) null, 2, (Object) null) != null) {
                z0.this.b.i("字体发生切换: %s.", new Object[]{config.a});
                if (config.l == 1 && !b1.b.a()) {
                    ReaderFontChecker readerFontChecker = ReaderFontChecker.a;
                    if (!readerFontChecker.d()) {
                        String W = z0.this.c.getReaderConfig().W();
                        Intrinsics.checkNotNullExpressionValue(W, "getFontName(...)");
                        readerFontChecker.g(W);
                    } else {
                        readerFontChecker.e();
                        AppUtils.sendLocalBroadcast(new Intent("action_try_out_vip_font_expired"));
                    }
                    readerFontChecker.f(config.a);
                }
                i25.r.b.a(this.b);
                w2.b().l(Boolean.FALSE);
                w2.b().m(config.a);
                ReaderActivity context3 = z0.this.c.getContext();
                Intrinsics.checkNotNull(context3, "null cannot be cast to non-null type com.dragon.read.reader.ui.ReaderActivity");
                w2.update(context3.h2());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c.getConfigObservable().o0(this.f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c.getConfigObservable().V0(this.f);
    }

    public static final class b extends jx5.d {
        b() {
        }

        public void f(String fontName) {
            Intrinsics.checkNotNullParameter(fontName, "fontName");
            r0 r0Var = z0.this.g;
            String W = z0.this.c.getReaderConfig().W();
            Intrinsics.checkNotNullExpressionValue(W, "getFontName(...)");
            r0Var.e(W);
        }
    }

    @Override // com.dragon.read.kmp.ui.a
    public void d(boolean z) {
        this.g.f(true);
        super.d(z);
    }

    @Override // com.dragon.read.kmp.ui.a
    public void g(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.g.f(false);
        super.g(parent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(h hVar) {
        String str;
        if (hVar != null) {
            str = hVar.a;
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, Font.DEFAULT.getFontTitle());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = new LogHelper(com.dragon.read.kmp.reader.utils.p.o("KmpFontListView"));
        ReaderClient readerClient = ((ReaderActivity) context).getReaderClient();
        Intrinsics.checkNotNull(readerClient);
        this.c = readerClient;
        ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.d = composeView;
        c cVar = new c(context);
        this.e = cVar;
        this.f = new b();
        String W = readerClient.getReaderConfig().W();
        Intrinsics.checkNotNullExpressionValue(W, "getFontName(...)");
        this.g = new r0(false, W, ScreenUtils.getScreenHeightDp(context), cVar, System.currentTimeMillis());
        addView(composeView);
        composeView.setContent(androidx.compose.runtime.internal.t.c(894904424, true, new a()));
    }

    static final class a implements Function2<Composer, Integer, Unit> {
        a() {
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
                    ComposerKt.traceEventStart(894904424, i, -1, "com.dragon.read.kmp.reader.font.KmpFontListView.<anonymous> (KmpFontListView.kt:84)");
                }
                FontListCpnKt.p(z0.this.g, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }
}
