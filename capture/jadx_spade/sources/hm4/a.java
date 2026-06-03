package hm4;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.t;
import androidx.compose.ui.platform.ComposeView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.download.DownloadButtonKt;
import com.dragon.read.kmp.reader.download.DownloadUiState;
import com.dragon.read.kmp.reader.download.DownloadViewMgr;
import com.dragon.read.kmp.reader.download.i;
import com.dragon.read.reader.model.SaaSBookInfo;
import com.dragon.read.reader.ui.ReaderActivity;
import com.dragon.read.reader.utils.g;
import com.dragon.reader.lib.ReaderClient;
import com.dragon.reader.lib.datalevel.AbsBookProviderProxy;
import im4.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a implements nm4.a {
    public static final int d;
    private DownloadViewMgr a;
    private ComposeView b;
    private final DownloadUiState c;

    static {
        Covode.recordClassIndex(608462);
        d = 8;
    }

    public void g(int i) {
    }

    @Override // nm4.a
    public View y2() {
        return this.b;
    }

    @Override // nm4.a
    public boolean n1() {
        return this.a.h();
    }

    public static final class b implements wf4.b {
        final /* synthetic */ i a;

        b(i iVar) {
            this.a = iVar;
        }

        public void a(boolean z) {
            this.a.c.invoke(Boolean.valueOf(z));
        }
    }

    @Override // nm4.a
    public int X1(float f) {
        return this.a.v(f);
    }

    @Override // nm4.a
    public void setNeedShowTips(boolean z) {
        this.a.j(z);
    }

    @Override // nm4.a
    public void setShownRedRect(boolean z) {
        this.a.l(z);
    }

    @Override // nm4.a
    public void A3(ReaderClient readerClient) {
        Intrinsics.checkNotNullParameter(readerClient, "readerClient");
        DownloadViewMgr downloadViewMgr = this.a;
        ReaderActivity context = readerClient.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.dragon.read.reader.ui.ReaderActivity");
        downloadViewMgr.g(context.h2());
    }

    public a(i params) {
        Intrinsics.checkNotNullParameter(params, "params");
        DownloadUiState downloadUiState = new DownloadUiState(0L, 1, null);
        this.c = downloadUiState;
        ReaderClient readerClient = params.b;
        Context context = params.getContext();
        b bVar = new b(params);
        AbsBookProviderProxy bookProviderProxy = readerClient.getBookProviderProxy();
        Intrinsics.checkNotNullExpressionValue(bookProviderProxy, "getBookProviderProxy(...)");
        SaaSBookInfo d2 = g.d(bookProviderProxy);
        this.a = new DownloadViewMgr(new d(d2 == null ? new SaaSBookInfo() : d2), bVar, downloadUiState);
        ComposeView composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setContent(t.c(-1621831543, true, new C0167a()));
        this.b = composeView;
    }

    /* renamed from: hm4.a$a, reason: collision with other inner class name */
    static final class C0167a implements Function2<Composer, Integer, Unit> {
        C0167a() {
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
                    ComposerKt.traceEventStart(-1621831543, i, -1, "com.dragon.read.kmp.reader.menu.view.DownloadViewMgrOfKmp.<anonymous>.<anonymous> (DownloadViewMgrOfKmp.kt:37)");
                }
                DownloadButtonKt.d(a.this.c, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    }

    @Override // nm4.a
    public void j0(Context context, boolean z) {
        DownloadViewMgr downloadViewMgr = this.a;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.dragon.read.reader.ui.ReaderActivity");
        downloadViewMgr.p(((ReaderActivity) context).h2(), z);
    }

    @Override // nm4.a
    public void A0(int i, String bookId, boolean z, Context context) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(context, "context");
        this.a.u(i, bookId, z, ((ReaderActivity) context).h2());
    }
}
