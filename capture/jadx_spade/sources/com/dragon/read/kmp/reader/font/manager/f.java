package com.dragon.read.kmp.reader.font.manager;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.utils.p;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f extends com.dragon.read.reader.newfont.a {
    public static final a d;
    public static final int e;
    private static final Lazy<f> f;
    private final di6.e<String, di6.c<IDownloadListener>> b = new di6.e<>();
    private final com.dragon.read.kmp.i c = new com.dragon.read.kmp.i(p.o("Font-FontDownloadDispatcher"));

    /* JADX INFO: Access modifiers changed from: private */
    public static final f f() {
        return new f();
    }

    public static final class a {
        static {
            Covode.recordClassIndex(608446);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final f a() {
            return (f) f.f.getValue();
        }
    }

    static {
        Lazy<f> lazy;
        Covode.recordClassIndex(608445);
        d = new a(null);
        e = 8;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.dragon.read.kmp.reader.font.manager.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                f f2;
                f2 = f.f();
                return f2;
            }
        });
        f = lazy;
    }

    private f() {
    }

    public final void g(String str) {
        if (str != null) {
        }
    }

    public void onProgress(DownloadInfo entity) {
        String str;
        Intrinsics.checkNotNullParameter(entity, "entity");
        com.dragon.read.kmp.i iVar = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append("FontDownloadDispatcher.onProgress: ");
        com.dragon.read.kmp.reader.font.h o = FontDataManager.a.o(entity.getUrl());
        List list = null;
        if (o != null) {
            str = o.a;
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(", ");
        sb.append(entity.getDownloadProcess());
        sb.append("%, ");
        sb.append(entity.getUrl());
        sb.append(' ');
        iVar.a(sb.toString());
        di6.c cVar = (di6.c) this.b.get(entity.getUrl());
        if (cVar != null) {
            list = CollectionsKt___CollectionsKt.toList((Iterable) cVar);
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((IDownloadListener) it2.next()).onProgress(entity);
            }
        }
    }

    public void onStart(DownloadInfo entity) {
        String str;
        Intrinsics.checkNotNullParameter(entity, "entity");
        com.dragon.read.kmp.i iVar = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append("FontDownloadDispatcher.onStart: ");
        com.dragon.read.kmp.reader.font.h o = FontDataManager.a.o(entity.getUrl());
        List list = null;
        if (o != null) {
            str = o.a;
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(", ");
        sb.append(entity.getUrl());
        iVar.d(sb.toString());
        di6.c cVar = (di6.c) this.b.get(entity.getUrl());
        if (cVar != null) {
            list = CollectionsKt___CollectionsKt.toList((Iterable) cVar);
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((IDownloadListener) it2.next()).onStart(entity);
            }
        }
    }

    public void onSuccessed(DownloadInfo entity) {
        String str;
        Intrinsics.checkNotNullParameter(entity, "entity");
        com.dragon.read.kmp.i iVar = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append("FontDownloadDispatcher.onSuccessed: ");
        com.dragon.read.kmp.reader.font.h o = FontDataManager.a.o(entity.getUrl());
        List list = null;
        if (o != null) {
            str = o.a;
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(", ");
        sb.append(entity.getUrl());
        iVar.d(sb.toString());
        di6.c cVar = (di6.c) this.b.get(entity.getUrl());
        if (cVar != null) {
            list = CollectionsKt___CollectionsKt.toList((Iterable) cVar);
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((IDownloadListener) it2.next()).onSuccessed(entity);
            }
        }
    }

    public final void e(String str, IDownloadListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (str != null) {
            di6.c cVar = (di6.c) this.b.get(str);
            if (cVar == null) {
                cVar = new di6.c();
                this.b.put(str, cVar);
            }
            cVar.add(listener);
        }
    }

    public void b(DownloadInfo downloadInfo, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        List<com.dragon.read.reader.newfont.a> list;
        com.dragon.read.reader.newfont.a aVar;
        super.b(downloadInfo, str);
        com.dragon.read.kmp.i iVar = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append("FontDownloadDispatcher.onFontUnzipSuccess: ");
        FontDataManager fontDataManager = FontDataManager.a;
        if (downloadInfo != null) {
            str2 = downloadInfo.getUrl();
        } else {
            str2 = null;
        }
        com.dragon.read.kmp.reader.font.h o = fontDataManager.o(str2);
        if (o != null) {
            str3 = o.a;
        } else {
            str3 = null;
        }
        sb.append(str3);
        sb.append(", ");
        if (downloadInfo != null) {
            str4 = downloadInfo.getUrl();
        } else {
            str4 = null;
        }
        sb.append(str4);
        sb.append(", ");
        sb.append(str);
        iVar.d(sb.toString());
        if (downloadInfo != null) {
            str5 = downloadInfo.getUrl();
        } else {
            str5 = null;
        }
        di6.c cVar = (di6.c) this.b.get(str5);
        if (cVar != null) {
            list = CollectionsKt___CollectionsKt.toList((Iterable) cVar);
        } else {
            list = null;
        }
        if (list != null) {
            for (com.dragon.read.reader.newfont.a aVar2 : list) {
                if (aVar2 instanceof com.dragon.read.reader.newfont.a) {
                    aVar = aVar2;
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    aVar.b(downloadInfo, str);
                }
            }
        }
        g(str5);
    }

    public void onFailed(DownloadInfo entity, BaseException e2) {
        String str;
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(e2, "e");
        String url = entity.getUrl();
        com.dragon.read.kmp.i iVar = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append("FontDownloadDispatcher.onFailed: ");
        com.dragon.read.kmp.reader.font.h o = FontDataManager.a.o(entity.getUrl());
        List list = null;
        if (o != null) {
            str = o.a;
        } else {
            str = null;
        }
        sb.append(str);
        sb.append(", ");
        sb.append(entity.getUrl());
        sb.append(", ");
        sb.append(e2);
        iVar.d(sb.toString());
        di6.c cVar = (di6.c) this.b.get(url);
        if (cVar != null) {
            list = CollectionsKt___CollectionsKt.toList((Iterable) cVar);
        }
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((IDownloadListener) it2.next()).onFailed(entity, e2);
            }
        }
        g(url);
    }

    public void a(DownloadInfo downloadInfo, Throwable e2) {
        String str;
        String str2;
        String str3;
        String str4;
        List<com.dragon.read.reader.newfont.a> list;
        com.dragon.read.reader.newfont.a aVar;
        Intrinsics.checkNotNullParameter(e2, "e");
        super.a(downloadInfo, e2);
        com.dragon.read.kmp.i iVar = this.c;
        StringBuilder sb = new StringBuilder();
        sb.append("FontDownloadDispatcher.onFontUnzipFailed: ");
        FontDataManager fontDataManager = FontDataManager.a;
        if (downloadInfo != null) {
            str = downloadInfo.getUrl();
        } else {
            str = null;
        }
        com.dragon.read.kmp.reader.font.h o = fontDataManager.o(str);
        if (o != null) {
            str2 = o.a;
        } else {
            str2 = null;
        }
        sb.append(str2);
        sb.append(", ");
        if (downloadInfo != null) {
            str3 = downloadInfo.getUrl();
        } else {
            str3 = null;
        }
        sb.append(str3);
        sb.append(", ");
        sb.append(e2);
        iVar.d(sb.toString());
        if (downloadInfo != null) {
            str4 = downloadInfo.getUrl();
        } else {
            str4 = null;
        }
        di6.c cVar = (di6.c) this.b.get(str4);
        if (cVar != null) {
            list = CollectionsKt___CollectionsKt.toList((Iterable) cVar);
        } else {
            list = null;
        }
        if (list != null) {
            for (com.dragon.read.reader.newfont.a aVar2 : list) {
                if (aVar2 instanceof com.dragon.read.reader.newfont.a) {
                    aVar = aVar2;
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    aVar.a(downloadInfo, e2);
                }
            }
        }
        g(str4);
    }
}
