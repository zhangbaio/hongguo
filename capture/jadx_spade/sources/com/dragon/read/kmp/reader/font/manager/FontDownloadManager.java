package com.dragon.read.kmp.reader.font.manager;

import android.graphics.Typeface;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.font.x0;
import com.dragon.read.kmp.reader.services.x;
import com.dragon.read.kmp.reader.utils.p;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.kmp.ugc.aweme.concurrent.lock.ReentrantReadWriteLock;
import dm4.q;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FontDownloadManager {
    public static final FontDownloadManager a;
    private static final com.dragon.read.kmp.i b;
    private static String c;
    private static final i d;
    private static final di6.e<String, Integer> e;
    private static final di6.e<String, Long> f;
    private static final ReentrantReadWriteLock g;
    private static final CoroutineScope h;
    public static final int i;

    private FontDownloadManager() {
    }

    public static final class a extends wf4.c {
        a() {
        }

        public void a() {
            FontDownloadManager.b.d("网络连接，重启没完成的任务.");
            Iterator it2 = CollectionsKt___CollectionsKt.toList(FontDownloadManager.e.values()).iterator();
            while (it2.hasNext()) {
                int intValue = ((Number) it2.next()).intValue();
                i iVar = FontDownloadManager.d;
                if (iVar != null) {
                    iVar.a(intValue);
                }
            }
        }
    }

    static {
        Covode.recordClassIndex(608447);
        a = new FontDownloadManager();
        b = new com.dragon.read.kmp.i(p.o("Font", "Download"));
        c = "";
        x xVar = x.a;
        d = xVar.e().n4();
        e = new di6.e<>();
        f = new di6.e<>();
        g = new ReentrantReadWriteLock();
        h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
        xVar.g().T4(new a());
        i = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n() {
        boolean z;
        if (c.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return c;
        }
        String C9 = x.a.d().C9();
        if (new rn0.c(C9).exists()) {
            c = C9 + "/font";
            boolean a2 = com.dragon.read.kmp.reader.utils.e.a(new rn0.c(c));
            b.d("base path: " + c + ", " + a2);
            return c;
        }
        return "";
    }

    public final DownloadInfo o(String str) {
        Integer num = (Integer) e.get(str);
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        i iVar = d;
        if (iVar == null) {
            return null;
        }
        return iVar.b(intValue);
    }

    public final String p(String str) {
        return n() + '/' + str;
    }

    public final boolean q(String str) {
        if (str == null) {
            return false;
        }
        return new rn0.c(p(str)).exists();
    }

    public final boolean r(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return false;
        }
        return f.containsKey(str);
    }

    public final boolean s(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return false;
        }
        return e.containsKey(str);
    }

    public final boolean l(rn0.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        try {
            cVar.delete();
            return true;
        } catch (Exception e2) {
            com.dragon.read.kmp.i.c(b, "文件删除失败：" + cVar.getPath() + ", 原因: " + e2.getMessage(), (Throwable) null, 2, (Object) null);
            return false;
        }
    }

    public final Typeface j(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        ReentrantReadWriteLock.ReadLock readLock = g.b;
        boolean tryLock = readLock.tryLock();
        Typeface typeface = null;
        if (!tryLock) {
            return null;
        }
        try {
            String p = a.p(fileName);
            if (new rn0.c(p).exists()) {
                try {
                    typeface = x.a.e().e0(p);
                } catch (Exception e2) {
                    b.d("加载字体失败" + fileName + " e=" + e2.getMessage());
                }
            }
            if (tryLock) {
                readLock.unlock();
            }
            return typeface;
        } finally {
            if (tryLock) {
                readLock.unlock();
            }
        }
    }

    public final void i(String fileName, Function1<? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(action, "action");
        kotlinx.coroutines.i.e(h, Dispatchers.getMain(), null, new FontDownloadManager$checkFontFileValid$1(action, fileName, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t(String str, String str2, Continuation<? super Unit> continuation) {
        boolean z;
        Object coroutine_suspended;
        if (str.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            rn0.c cVar = new rn0.c(str2);
            if (cVar.exists()) {
                Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new FontDownloadManager$unZip$2(str2, str, cVar, null), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (withContext == coroutine_suspended) {
                    return withContext;
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("源文件不存在");
        }
        throw new IllegalArgumentException("目标文件名为空");
    }

    public final void m(String str, String str2, IDownloadListener downloadListener) {
        com.dragon.read.kmp.reader.font.h m;
        Intrinsics.checkNotNullParameter(downloadListener, "downloadListener");
        b.d("准备下载字体: " + str2 + '.');
        if (str2 != null && (m = FontDataManager.a.m(str2)) != null) {
            q.b.o(m.i);
        }
        kotlinx.coroutines.i.e(h, Dispatchers.getMain(), null, new FontDownloadManager$download$2(str, downloadListener, str2, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(String str, String str2, String str3, DownloadInfo downloadInfo) {
        String url = downloadInfo.getUrl();
        if (url == null) {
            return;
        }
        kotlinx.coroutines.i.e(CoroutineScopeKt.MainScope(), Dispatchers.getMain(), null, new FontDownloadManager$unzipFile$1(str, str2, downloadInfo, str3, url, null), 2, null);
    }

    public final void k(String str, String str2, String str3, x0 deleteListener) {
        Intrinsics.checkNotNullParameter(deleteListener, "deleteListener");
        b.d("准备删除字体：" + str2 + "- " + str + " - " + str3);
        kotlinx.coroutines.i.e(h, Dispatchers.getMain(), null, new FontDownloadManager$deleteFont$1(str, deleteListener, str2, null), 2, null);
    }
}
