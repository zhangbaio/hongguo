package com.dragon.read.kmp.reader.font;

import android.content.Context;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.reader.font.manager.FontDataManager;
import com.dragon.read.kmp.reader.font.manager.FontDownloadManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v0 {
    public static final int l;
    private final r0 a;
    private final Context b;
    private final boolean c;
    private final com.dragon.read.kmp.i d;
    private final String e;
    public final List<h> f;
    private final MutableState g;
    public final Map<String, DownloadStatus> h;
    public final Map<String, Integer> i;
    public final Map<String, Boolean> j;
    public h k;

    public static final class d implements DisposableEffectResult {
        public void dispose() {
        }
    }

    static {
        Covode.recordClassIndex(608436);
        l = 8;
    }

    public static final class c implements DisposableEffectResult {
        final /* synthetic */ String a;

        public void dispose() {
            com.dragon.read.kmp.reader.font.manager.f.d.a().g(this.a);
        }

        public c(String str) {
            this.a = str;
        }
    }

    public final String h() {
        return (String) this.g.getValue();
    }

    public final w0 g() {
        String str;
        String str2 = this.e;
        h hVar = (h) CollectionsKt___CollectionsKt.getOrNull(FontDataManager.a.q(), 0);
        if (hVar != null) {
            str = hVar.t;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str2, str)) {
            return new w0(48, 14, 70, 32, false, 3, false);
        }
        return new w0(0, 0, 0, 0, false, 0, false, 127, null);
    }

    public final void i() {
        String str;
        boolean z;
        com.dragon.read.kmp.i iVar = this.d;
        StringBuilder sb = new StringBuilder();
        sb.append("字体准备删除：");
        h hVar = this.k;
        if (hVar == null || (str = hVar.a) == null) {
            str = "null";
        }
        sb.append(str);
        iVar.a(sb.toString());
        h hVar2 = this.k;
        if (hVar2 == null) {
            return;
        }
        DownloadStatus downloadStatus = this.h.get(hVar2.b);
        if (downloadStatus == null) {
            downloadStatus = DownloadStatus.STATUS_NORMAL;
        }
        if (downloadStatus != DownloadStatus.STATUS_DOWNLOADED) {
            this.d.d("字体未下载，无法删除：" + hVar2.a);
            return;
        }
        if (s0.a(hVar2)) {
            ig4.g.b("暂不支持删除系统字体", (ToastDuration) null, 2, (Object) null);
            return;
        }
        if (this.a.b().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && Intrinsics.areEqual(hVar2.a, this.a.b())) {
            ig4.g.b("暂不支持删除正在使用中字体", (ToastDuration) null, 2, (Object) null);
            return;
        }
        if (hVar2.j) {
            ig4.g.b("暂不支持删除该字体", (ToastDuration) null, 2, (Object) null);
            this.d.d("预下载字体，无法删除：" + hVar2.a);
            return;
        }
        this.d.d("字体开始删除：" + hVar2.a);
        p(hVar2.a);
        FontDownloadManager.a.k(hVar2.i, hVar2.b, hVar2.e, e(hVar2));
    }

    private final com.dragon.read.kmp.reader.font.a e(h hVar) {
        return new a(hVar);
    }

    private final com.dragon.read.reader.newfont.a f(h hVar) {
        return new b(hVar);
    }

    private final void p(String str) {
        this.g.setValue(str);
    }

    public static final class a extends com.dragon.read.kmp.reader.font.a {
        final /* synthetic */ h b;

        @Override // com.dragon.read.kmp.reader.font.a, com.dragon.read.kmp.reader.font.x0
        public void onStart(String str) {
            v0.this.d.d("字体开始删除: " + this.b.a + ' ' + this.b.b);
            v0.this.h.put(this.b.b, DownloadStatus.STATUS_NORMAL);
        }

        a(h hVar) {
            this.b = hVar;
        }

        @Override // com.dragon.read.kmp.reader.font.a, com.dragon.read.kmp.reader.font.x0
        public void onFailed(String str, String e) {
            Intrinsics.checkNotNullParameter(e, "e");
            v0.this.d.d("字体删除失败: " + this.b.a + ' ' + this.b.b);
            if (FontDownloadManager.a.q(this.b.i)) {
                v0.this.h.put(this.b.b, DownloadStatus.STATUS_DOWNLOADED);
            }
            ig4.g.b("删除失败", (ToastDuration) null, 2, (Object) null);
        }

        @Override // com.dragon.read.kmp.reader.font.a, com.dragon.read.kmp.reader.font.x0
        public void a(String str, double d, String message) {
            int roundToInt;
            Intrinsics.checkNotNullParameter(message, "message");
            StringBuilder sb = new StringBuilder();
            sb.append("已删除字体，为你节省");
            roundToInt = MathKt__MathJVMKt.roundToInt(d);
            sb.append(roundToInt);
            sb.append("MB空间");
            String str2 = null;
            ig4.g.b(sb.toString(), (ToastDuration) null, 2, (Object) null);
            v0.this.h.put(this.b.b, DownloadStatus.STATUS_NORMAL);
            com.dragon.read.kmp.i iVar = v0.this.d;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("字体删除成功: ");
            sb2.append(this.b.a);
            sb2.append(' ');
            sb2.append(this.b.b);
            sb2.append(" downloadStatus: ");
            DownloadStatus downloadStatus = v0.this.h.get(this.b.b);
            if (downloadStatus != null) {
                str2 = downloadStatus.name();
            }
            sb2.append(str2);
            iVar.d(sb2.toString());
            ym4.o.a.a("font_delete", new ym4.a("font", this.b.a));
        }
    }

    public final void m(h font) {
        Intrinsics.checkNotNullParameter(font, "font");
        Boolean bool = this.j.get(font.b);
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2)) {
            return;
        }
        this.j.put(font.b, bool2);
        ym4.a aVar = new ym4.a();
        aVar.g("font", font.a);
        ym4.o.a.a("font_show", aVar);
    }

    public static final class b extends com.dragon.read.reader.newfont.a {
        final /* synthetic */ h c;

        public void onProgress(DownloadInfo downloadInfo) {
            Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
            v0.this.d.a("字体下载进度: " + this.c.a + ' ' + this.c.b + ' ' + downloadInfo.getDownloadProcess() + '%');
            v0.this.h.put(this.c.b, DownloadStatus.STATUS_DOWNLOADING);
            v0.this.i.put(this.c.b, Integer.valueOf(downloadInfo.getDownloadProcess()));
        }

        public void onStart(DownloadInfo downloadInfo) {
            Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
            v0.this.d.d("字体开始下载: " + this.c.a + ' ' + this.c.b);
            v0.this.h.put(this.c.b, DownloadStatus.STATUS_DOWNLOADING);
            v0.this.i.put(this.c.b, 1);
        }

        b(h hVar) {
            this.c = hVar;
        }

        public void b(DownloadInfo downloadInfo, String str) {
            v0.this.d.d("字体下载解压成功: " + str);
            if (Intrinsics.areEqual(this.c.b, str)) {
                v0.this.h.put(this.c.b, DownloadStatus.STATUS_DOWNLOADED);
                if (!Intrinsics.areEqual(v0.this.h(), this.c.a)) {
                    v0.this.d.d("解压字体不是最新应用的字体，取消设置: " + str + ", 最新引用字体: " + v0.this.h());
                    return;
                }
                y0 y0Var = v0.this.a.a;
                h hVar = this.c;
                y0Var.c(hVar, s0.a(hVar));
            }
        }

        public void onFailed(DownloadInfo downloadInfo, BaseException e) {
            Intrinsics.checkNotNullParameter(downloadInfo, "downloadInfo");
            Intrinsics.checkNotNullParameter(e, "e");
            v0.this.h.put(this.c.b, DownloadStatus.STATUS_NORMAL);
            ig4.g.b("网络错误，请稍后重新下载", (ToastDuration) null, 2, (Object) null);
            v0.this.d.d("字体下载失败: " + this.c.e + ". error code is " + Integer.valueOf(e.getErrorCode()) + ", error is " + e);
        }
    }

    public final boolean l(h font) {
        Intrinsics.checkNotNullParameter(font, "font");
        DownloadStatus downloadStatus = this.h.get(font.b);
        if (downloadStatus == null) {
            downloadStatus = DownloadStatus.STATUS_NORMAL;
        }
        if (downloadStatus != DownloadStatus.STATUS_DOWNLOADED) {
            this.d.d("字体未下载，无法删除：" + font.a);
            this.k = null;
            return false;
        }
        this.k = font;
        com.dragon.read.kmp.i iVar = this.d;
        StringBuilder sb = new StringBuilder();
        sb.append("长按字体即将删除：");
        String str = font.a;
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        iVar.a(sb.toString());
        return true;
    }

    public final void j(final h font) {
        Intrinsics.checkNotNullParameter(font, "font");
        DownloadStatus downloadStatus = this.h.get(font.b);
        if (downloadStatus == null) {
            downloadStatus = DownloadStatus.STATUS_NORMAL;
        }
        if (!s0.a(font) && downloadStatus != DownloadStatus.STATUS_DOWNLOADED) {
            if (downloadStatus == DownloadStatus.STATUS_DOWNLOADING) {
                this.d.d("字体正在下载，等待：" + font.a);
                p(font.a);
                return;
            }
            this.d.d("字体开始下载：" + font.a);
            p(font.a);
            FontDownloadManager.a.m(font.e, font.b, f(font));
            return;
        }
        this.d.d("字体已下载，直接应用：" + font.a);
        ym4.o.a.a("font_config", new ym4.a("clicked_content", font.a));
        if (s0.a(font)) {
            this.a.a.c(font, s0.a(font));
        } else {
            FontDownloadManager.a.i(font.i, new Function1() { // from class: com.dragon.read.kmp.reader.font.u0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit k;
                    k = v0.k(v0.this, font, ((Boolean) obj).booleanValue());
                    return k;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(v0 v0Var, h hVar, boolean z) {
        if (z) {
            v0Var.p(hVar.a);
            v0Var.a.a.c(hVar, s0.a(hVar));
        } else {
            v0Var.h.put(hVar.b, DownloadStatus.STATUS_NORMAL);
            ig4.g.b("字体显示异常，重新加载中", (ToastDuration) null, 2, (Object) null);
            v0Var.d.d("字体开始下载：" + hVar.a);
            v0Var.p(hVar.a);
            FontDownloadManager.a.m(hVar.e, hVar.b, v0Var.f(hVar));
        }
        return Unit.INSTANCE;
    }

    public v0(r0 params, Context context, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = params;
        this.b = context;
        this.c = z;
        this.d = new com.dragon.read.kmp.i(com.dragon.read.kmp.reader.utils.p.o("Font"));
        this.e = "reader_font_v693";
        ArrayList arrayList = new ArrayList();
        h hVar = new h();
        Font font = Font.DEFAULT;
        hVar.f(font.getFontFamily());
        hVar.h(font.getFontTitle());
        arrayList.add(hVar);
        List<h> q = FontDataManager.a.q();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : q) {
            h hVar2 = (h) obj;
            boolean z3 = !hVar2.k;
            boolean z4 = !s0.b(hVar2);
            if (!this.c && !com.dragon.read.kmp.reader.services.x.a.e().t7().contains(hVar2.b)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z3 && z4 && z2) {
                arrayList2.add(obj);
            }
        }
        arrayList.addAll(arrayList2);
        this.f = arrayList;
        this.d.d("FontListStateHolder 重建，isSimplified=" + this.c + "，displayList大小=" + arrayList.size());
        this.g = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
        this.h = SnapshotStateKt.mutableStateMapOf();
        this.i = SnapshotStateKt.mutableStateMapOf();
        this.j = SnapshotStateKt.mutableStateMapOf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult o(v0 v0Var, String str, String str2, h hVar, DisposableEffectScope DisposableEffect) {
        int i;
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        if (v0Var.h.get(str) == DownloadStatus.STATUS_DOWNLOADING) {
            Map<String, Integer> map = v0Var.i;
            DownloadInfo o = FontDownloadManager.a.o(str2);
            if (o != null) {
                i = o.getDownloadProcess();
            } else {
                i = 0;
            }
            map.put(str, Integer.valueOf(i));
            com.dragon.read.kmp.reader.font.manager.f.d.a().e(str2, v0Var.f(hVar));
            return new c(str2);
        }
        return new d();
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.dragon.read.kmp.reader.font.a0 n(final com.dragon.read.kmp.reader.font.h r23, boolean r24, boolean r25, androidx.compose.runtime.Composer r26, int r27) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.font.v0.n(com.dragon.read.kmp.reader.font.h, boolean, boolean, androidx.compose.runtime.Composer, int):com.dragon.read.kmp.reader.font.a0");
    }
}
