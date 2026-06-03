package com.dragon.read.kmp.reader.download;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.utils.p;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DownloadViewMgr {
    public static final int g;
    private final im4.d a;
    private final wf4.b b;
    private final DownloadUiState c;
    private final com.dragon.read.kmp.i d;
    private final CoroutineScope e;
    private int f;

    static {
        Covode.recordClassIndex(608411);
        g = 8;
    }

    public final int v(float f) {
        return 0;
    }

    public final boolean h() {
        if (this.c.d() && !this.c.c() && this.c.g()) {
            return true;
        }
        return false;
    }

    private final void k(String str) {
        this.c.o(str);
    }

    private final void m(String str) {
        this.c.q(str);
    }

    private final void o(Function2<? super cm4.i, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.c.n(function2);
    }

    public final void i(boolean z) {
        this.c.k(z);
    }

    public final void j(boolean z) {
        this.c.m(z);
    }

    public final void l(boolean z) {
        this.c.l(z);
    }

    public final void n(float f) {
        this.c.j(f);
    }

    public final void g(cm4.i reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        kotlinx.coroutines.i.e(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DownloadViewMgr$initDownloadViewText$1(this, reader, null), 3, null);
    }

    private final void q(cm4.i iVar, String str) {
        j(false);
        l(true);
        i(true);
        m("查看下载");
        o(new DownloadViewMgr$updateDownloadTextFinishState$1(this, iVar, str, null));
    }

    public final void p(cm4.i reader, boolean z) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        boolean p = reader.f().f().p();
        this.c.p(z);
        this.c.l(p);
    }

    private final void r(cm4.i iVar, String str) {
        if (!tm4.a.a.a(str)) {
            q(iVar, str);
            return;
        }
        j(true);
        p(iVar, true);
        l(false);
        i(true);
        m("查看下载");
        k("更新");
        o(new DownloadViewMgr$updateDownloadTextHasUpdateState$1(this, iVar, str, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(cm4.i r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.DownloadViewMgr.f(cm4.i, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public DownloadViewMgr(im4.d bookInfo, wf4.b onAddBookShelfCallback, DownloadUiState uiState) {
        Intrinsics.checkNotNullParameter(bookInfo, "bookInfo");
        Intrinsics.checkNotNullParameter(onAddBookShelfCallback, "onAddBookShelfCallback");
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        this.a = bookInfo;
        this.b = onAddBookShelfCallback;
        this.c = uiState;
        this.d = new com.dragon.read.kmp.i(p.c("Download"));
        this.e = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this.f = -1;
    }

    private final void s(String str, int i, boolean z) {
        String a;
        if (i == 100 && z) {
            i(false);
            n(0.4f);
            a = "已下载";
        } else if (i >= 0 && i != 100) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append('%');
            a = sb.toString();
            i(true);
            n(1.0f);
        } else {
            a = dm4.f.c().a(str, i);
            if (!(!StringsKt__StringsKt.isBlank(a))) {
                a = "下载";
            }
            i(true);
            n(1.0f);
        }
        m(a);
        o(new DownloadViewMgr$updateDownloadTextView$1(this, null));
    }

    public final void u(int i, String bookId, boolean z, cm4.i iVar) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (iVar == null) {
            return;
        }
        kotlinx.coroutines.i.e(this.e, null, null, new DownloadViewMgr$updateDownloadViewNoSuspend$1(this, iVar, i, bookId, z, null), 3, null);
    }

    public final Object t(cm4.i iVar, int i, String str, boolean z, Continuation<? super Unit> continuation) {
        this.f = i;
        if (i == 100 && z) {
            q(iVar, str);
        } else if (i == 100) {
            r(iVar, str);
        } else {
            s(str, i, z);
        }
        this.d.d("updateDownloadView, uiState: " + this.c);
        return Unit.INSTANCE;
    }
}
