package com.dragon.read.kmp.reader.download;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.AppUtils;
import com.dragon.read.kmprpc.reader.saas.model.r2;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import dm4.u;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class EpubImageTaskDispatcher implements IDownloadListener {
    public static final a j;
    public static final int k;
    private static final com.dragon.read.kmp.i l;
    private r2 a;
    private int d;
    private String b = "";
    private wf4.a c = new wf4.a(3);
    private final int e = 1;
    private final di6.e<String, Job> f = new di6.e<>(new LinkedHashMap(), (Object) null, 2, (DefaultConstructorMarker) null);
    private final di6.e<String, Deferred<Boolean>> g = new di6.e<>(new LinkedHashMap(), (Object) null, 2, (DefaultConstructorMarker) null);
    private final di6.e<String, l> h = new di6.e<>(new LinkedHashMap(), (Object) null, 2, (DefaultConstructorMarker) null);
    private final CoroutineScope i = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());

    public static final class a {
        static {
            Covode.recordClassIndex(608417);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void onCanceled(DownloadInfo entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
    }

    public void onFirstStart(DownloadInfo entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
    }

    public void onFirstSuccess(DownloadInfo entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
    }

    public void onPause(DownloadInfo entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
    }

    public void onPrepare(DownloadInfo entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
    }

    public void onProgress(DownloadInfo entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
    }

    public void onRetry(DownloadInfo entity, BaseException e) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(e, "e");
    }

    public void onRetryDelay(DownloadInfo entity, BaseException e) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(e, "e");
    }

    public void onStart(DownloadInfo entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
    }

    static {
        Covode.recordClassIndex(608416);
        j = new a(null);
        k = 8;
        l = new com.dragon.read.kmp.i("EpubImageTaskDispatcher");
    }

    public void onSuccessed(DownloadInfo entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        l lVar = (l) this.h.get(entity.getExtra());
        if (lVar != null) {
            boolean z = true;
            lVar.e++;
            com.dragon.read.kmp.i iVar = l;
            StringBuilder sb = new StringBuilder();
            sb.append("execute task, image succeed left pic: ");
            int i = this.d;
            this.d = i - 1;
            sb.append(i);
            iVar.d(sb.toString());
            Set<String> set = lVar.a;
            if (set == null || lVar.e + lVar.d != set.size()) {
                z = false;
            }
            if (z) {
                this.f.remove(entity.getExtra());
                this.c.b();
                iVar.d("execute task, image batch succeed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(l lVar) {
        Set<String> set = lVar.a;
        if (set != null) {
            for (String str : set) {
                com.dragon.read.kmp.local.a aVar = com.dragon.read.kmp.local.a.a;
                u uVar = u.b;
                if (new rn0.c(aVar.d(uVar.b(), this.b) + str.hashCode()).exists()) {
                    DownloadInfo downloadInfo = new DownloadInfo();
                    downloadInfo.setExtra(lVar.c);
                    onSuccessed(downloadInfo);
                    l.d("execute task, exist");
                } else {
                    mh4.a.a.a(AppUtils.a.a()).f(str).b(lVar.c).d(aVar.d(uVar.b(), this.b)).c("png" + str.hashCode()).e(this).a();
                }
            }
        }
        l.d("execute task, download");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0089 A[Catch: Exception -> 0x00e3, TryCatch #1 {Exception -> 0x00e3, blocks: (B:16:0x0079, B:18:0x0089, B:21:0x009a, B:22:0x003a, B:24:0x0048), top: B:15:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048 A[Catch: Exception -> 0x00e3, TryCatch #1 {Exception -> 0x00e3, blocks: (B:16:0x0079, B:18:0x0089, B:21:0x009a, B:22:0x003a, B:24:0x0048), top: B:15:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0046 -> B:15:0x0079). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0076 -> B:15:0x0079). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.EpubImageTaskDispatcher.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final l d(List<String> list, String str) {
        Set set;
        if (list != null) {
            set = CollectionsKt___CollectionsKt.toSet(list);
        } else {
            set = null;
        }
        return new l(set, this.b, str, 0, 0, 24, null);
    }

    public void onFailed(DownloadInfo entity, BaseException e) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(e, "e");
        l lVar = (l) this.h.get(entity.getExtra());
        if (lVar != null) {
            boolean z = true;
            lVar.d++;
            com.dragon.read.kmp.i iVar = l;
            iVar.d("execute task, image failed");
            Set<String> set = lVar.a;
            if (set == null || lVar.e + lVar.d != set.size()) {
                z = false;
            }
            if (z) {
                iVar.d("execute task, image batch failed");
                this.c.b();
            }
        }
    }

    public final void f(r2 itemImage, String bookId) {
        Map<String, ? extends List<String>> map;
        Set<String> keySet;
        boolean z;
        Deferred b;
        Intrinsics.checkNotNullParameter(itemImage, "itemImage");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        this.a = itemImage;
        this.b = bookId;
        if (itemImage == null || (map = itemImage.a) == null || (keySet = map.keySet()) == null) {
            return;
        }
        for (String str : keySet) {
            List<String> list = map.get(str);
            int i = 0;
            if (list != null && !list.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                l d = d(map.get(str), str);
                this.h.put(str, d);
                di6.e<String, Deferred<Boolean>> eVar = this.g;
                b = kotlinx.coroutines.i.b(this.i, null, null, new EpubImageTaskDispatcher$prepareDownload$1$1(this, d, null), 3, null);
                eVar.put(str, b);
                int i2 = this.d;
                List<String> list2 = map.get(str);
                if (list2 != null) {
                    i = list2.size();
                }
                this.d = i2 + i;
            }
        }
        l.d("start download " + this.g.size() + " picNum: " + this.d);
    }

    public final Object c(r2 r2Var, String str, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        f(r2Var, str);
        if (!this.g.isEmpty()) {
            Object g = g(continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (g == coroutine_suspended) {
                return g;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
