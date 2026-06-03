package com.dragon.read.kmp.reader.download;

import android.content.Intent;
import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.compose.ToastDuration;
import com.dragon.read.kmp.network.ReaderErrorException;
import com.dragon.read.kmp.reader.services.x;
import com.dragon.read.kmp.reader.utils.p;
import com.dragon.read.kmp.utils.ListUtils;
import com.dragon.read.kmp.utils.ThreadUtils;
import com.dragon.read.reader.download.ChapterInfo;
import dm4.r;
import dm4.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ReaderDownloadMgr {
    public static final ReaderDownloadMgr a;
    private static final qj4.a b;
    private static final List<String> c;
    private static final Map<String, Deferred<a>> d;
    private static final Map<String, Job> e;
    private static Set<o> f;
    private static final CoroutineScope g;
    private static final com.dragon.read.kmp.i h;
    public static final int i;

    private ReaderDownloadMgr() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String M() {
        return u.b.b();
    }

    private final void x() {
        boolean z = true;
        if (!(!e.isEmpty()) && !(!d.isEmpty())) {
            z = false;
        }
        y(z);
    }

    public static final class a {
        public final String a;
        public final int b;
        public final int c;

        static {
            Covode.recordClassIndex(608422);
        }

        public String toString() {
            return "DownloadResult{totalSize=" + this.b + ", unfinishedSize=" + this.c + '}';
        }

        public a(String bookId, int i, int i2) {
            Intrinsics.checkNotNullParameter(bookId, "bookId");
            this.a = bookId;
            this.b = i;
            this.c = i2;
        }
    }

    public final void A() {
        Set set;
        d.clear();
        set = CollectionsKt___CollectionsKt.toSet(e.keySet());
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            Job remove = e.remove((String) it2.next());
            if (remove != null && !remove.isCancelled()) {
                Job.DefaultImpls.cancel$default(remove, (CancellationException) null, 1, (Object) null);
            }
        }
        x();
    }

    static {
        Covode.recordClassIndex(608421);
        a = new ReaderDownloadMgr();
        b = x.a.b().X6("book_download_");
        c = new di6.c();
        d = new di6.e(new LinkedHashMap(), (Object) null, 2, (DefaultConstructorMarker) null);
        e = new di6.e();
        f = new di6.f();
        g = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        h = new com.dragon.read.kmp.i(p.c("DownloadMgr"));
        i = 8;
    }

    public final void o() {
        Map<String, Deferred<a>> map = d;
        if (map.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            if (dm4.p.b.a(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            com.dragon.read.kmp.i iVar = h;
            StringBuilder sb = new StringBuilder();
            sb.append("当前pendingTasks里对应书籍都没有离线权利，clean pending task, size =");
            Map<String, Deferred<a>> map2 = d;
            sb.append(map2.size());
            iVar.d(sb.toString());
            map2.clear();
            return;
        }
        Iterator it2 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            Deferred<a> remove = d.remove(str2);
            if (remove != null) {
                I(str2, remove);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(String str) {
        c.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(String str) {
        d.remove(str);
        e.remove(str);
    }

    public final boolean R(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        return c.contains(bookId);
    }

    public final void Z(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        c.add(bookId);
    }

    private final String[] T(String str) {
        List split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"download_chapter_image"}, false, 0, 6, (Object) null);
        return (String[]) split$default.toArray(new String[0]);
    }

    private final String[] U(String str) {
        List split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"download_create_time"}, false, 0, 6, (Object) null);
        return (String[]) split$default.toArray(new String[0]);
    }

    private final String[] V(String str) {
        List split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"download_chapter_percent"}, false, 0, 6, (Object) null);
        return (String[]) split$default.toArray(new String[0]);
    }

    private final String[] W(String str) {
        List split$default;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"download_chapter_total"}, false, 0, 6, (Object) null);
        return (String[]) split$default.toArray(new String[0]);
    }

    public final void y(boolean z) {
        Iterator<o> it2 = f.iterator();
        while (it2.hasNext()) {
            it2.next().a(z);
        }
    }

    private final void z(String str) throws Exception {
        if (Intrinsics.areEqual(str, M())) {
            return;
        }
        com.dragon.read.kmp.i.f(h, "目标账号和当前账号不一致，拒绝处理， current = " + M() + ", targetId = " + str, (Throwable) null, 2, (Object) null);
        A();
        throw new ReaderErrorException(100000000, "currentUserId与targetUserId不一致");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetAllDownloadPercent$1
            if (r0 == 0) goto L13
            r0 = r8
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetAllDownloadPercent$1 r0 = (com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetAllDownloadPercent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetAllDownloadPercent$1 r0 = new com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetAllDownloadPercent$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r8)
            goto L3f
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L31:
            kotlin.ResultKt.throwOnFailure(r8)
            qj4.a r8 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.b
            r0.label = r3
            java.lang.Object r8 = r8.b(r0)
            if (r8 != r1) goto L3f
            return r1
        L3f:
            java.util.Map r8 = (java.util.Map) r8
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Set r1 = r8.keySet()
            java.util.Iterator r1 = r1.iterator()
        L4e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L84
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String[] r4 = r7.V(r2)
            int r4 = r4.length
            r5 = 2
            if (r4 < r5) goto L4e
            java.lang.String[] r4 = r7.V(r2)
            r5 = 0
            r4 = r4[r5]
            java.lang.String[] r5 = r7.V(r2)
            r5 = r5[r3]
            java.lang.String r6 = r7.M()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r4)
            if (r4 == 0) goto L4e
            java.lang.Object r2 = r8.get(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r0.put(r5, r2)
            goto L4e
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.q(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object O(String str, Continuation<? super Float> continuation) {
        return N(M(), str, continuation);
    }

    private final String F(String str, String str2) {
        return str + "download_create_time" + str2;
    }

    private final void I(String str, Deferred<a> deferred) {
        Job e2;
        e2 = kotlinx.coroutines.i.e(g, null, null, new ReaderDownloadMgr$executeDownloadTask$job$1(deferred, str, null), 3, null);
        e.put(str, e2);
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a0(String str, String str2) {
        return str + "download_chapter_percent" + str2;
    }

    private final String l0(String str, String str2) {
        return str + "download_chapter_total" + str2;
    }

    public final void C(List<String> bookId, String cause) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(cause, "cause");
        Iterator<String> it2 = bookId.iterator();
        while (it2.hasNext()) {
            B(it2.next(), cause);
        }
    }

    public final void G(String targetUserId, List<String> bookIds) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(bookIds, "bookIds");
        ThreadUtils.a.l(new ReaderDownloadMgr$deleteDownloadPercent$1(bookIds, targetUserId, null));
    }

    public final void B(String bookId, String cause) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(cause, "cause");
        d.remove(bookId);
        Job remove = e.remove(bookId);
        if (remove != null && !remove.isCancelled()) {
            remove.cancel(new CancellationException(cause));
        }
        x();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|1|(2:3|(9:5|6|7|(1:(2:10|11)(2:25|26))(2:27|28)|12|(3:15|(2:17|18)(1:20)|13)|21|22|23))|30|6|7|(0)(0)|12|(1:13)|21|22|23) */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042 A[Catch: all -> 0x007a, TRY_LEAVE, TryCatch #0 {all -> 0x007a, blocks: (B:11:0x0029, B:13:0x003c, B:15:0x0042, B:28:0x0038), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e0(java.util.List<java.lang.String> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.dragon.read.kmp.reader.download.ReaderDownloadMgr$removeAllChapterCache$2
            if (r0 == 0) goto L13
            r0 = r8
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$removeAllChapterCache$2 r0 = (com.dragon.read.kmp.reader.download.ReaderDownloadMgr$removeAllChapterCache$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$removeAllChapterCache$2 r0 = new com.dragon.read.kmp.reader.download.ReaderDownloadMgr$removeAllChapterCache$2
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            java.util.Iterator r7 = (java.util.Iterator) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L7a
            goto L3c
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L7a
        L3c:
            boolean r8 = r7.hasNext()     // Catch: java.lang.Throwable -> L7a
            if (r8 == 0) goto L7a
            java.lang.Object r8 = r7.next()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L7a
            com.dragon.read.kmp.i r2 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.h     // Catch: java.lang.Throwable -> L7a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7a
            r4.<init>()     // Catch: java.lang.Throwable -> L7a
            java.lang.String r5 = "删除书籍缓存，bookId="
            r4.append(r5)     // Catch: java.lang.Throwable -> L7a
            r4.append(r8)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r5 = ", readerType="
            r4.append(r5)     // Catch: java.lang.Throwable -> L7a
            lm4.r r5 = lm4.r.a     // Catch: java.lang.Throwable -> L7a
            int r5 = r5.a(r8)     // Catch: java.lang.Throwable -> L7a
            r4.append(r5)     // Catch: java.lang.Throwable -> L7a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L7a
            r2.d(r4)     // Catch: java.lang.Throwable -> L7a
            com.dragon.read.kmp.local.a r2 = com.dragon.read.kmp.local.a.a     // Catch: java.lang.Throwable -> L7a
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L7a
            r0.label = r3     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r8 = r2.f(r8, r0)     // Catch: java.lang.Throwable -> L7a
            if (r8 != r1) goto L3c
            return r1
        L7a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.e0(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|24|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0029, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0074, code lost:
    
        com.dragon.read.kmp.reader.download.ReaderDownloadMgr.h.d("注册秘钥失败，error = " + r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d0(java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.dragon.read.kmp.reader.download.ReaderDownloadMgr$registerCrypt$1
            if (r0 == 0) goto L13
            r0 = r7
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$registerCrypt$1 r0 = (com.dragon.read.kmp.reader.download.ReaderDownloadMgr$registerCrypt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$registerCrypt$1 r0 = new com.dragon.read.kmp.reader.download.ReaderDownloadMgr$registerCrypt$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L29
            goto L5a
        L29:
            r6 = move-exception
            goto L74
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.dragon.read.kmp.i r7 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.h
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "尝试注册秘钥，bookId = "
            r2.append(r4)
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            r7.d(r6)
            java.lang.String r6 = r5.M()     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r7 = com.dragon.read.kmp.reader.utils.c.a(r6, r0)     // Catch: java.lang.Throwable -> L29
            if (r7 != r1) goto L5a
            return r1
        L5a:
            com.dragon.read.reader.DecryptKey r7 = (com.dragon.read.reader.DecryptKey) r7     // Catch: java.lang.Throwable -> L29
            com.dragon.read.kmp.i r6 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.h     // Catch: java.lang.Throwable -> L29
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L29
            r0.<init>()     // Catch: java.lang.Throwable -> L29
            java.lang.String r1 = "注册秘钥成功 "
            r0.append(r1)     // Catch: java.lang.Throwable -> L29
            r0.append(r7)     // Catch: java.lang.Throwable -> L29
            java.lang.String r7 = r0.toString()     // Catch: java.lang.Throwable -> L29
            r6.d(r7)     // Catch: java.lang.Throwable -> L29
            goto L8b
        L74:
            com.dragon.read.kmp.i r7 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.h
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "注册秘钥失败，error = "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.d(r6)
        L8b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.d0(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(java.lang.String r8, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, java.lang.String>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetChapterImage$1
            if (r0 == 0) goto L13
            r0 = r9
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetChapterImage$1 r0 = (com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetChapterImage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetChapterImage$1 r0 = new com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetChapterImage$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L45
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r9)
            qj4.a r9 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.b
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = r9.b(r0)
            if (r9 != r1) goto L45
            return r1
        L45:
            java.util.Map r9 = (java.util.Map) r9
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Set r1 = r9.keySet()
            java.util.Iterator r1 = r1.iterator()
        L54:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L83
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String[] r4 = r7.T(r2)
            int r5 = r4.length
            r6 = 2
            if (r5 < r6) goto L54
            r5 = r4[r3]
            r4 = r4[r6]
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r5)
            if (r5 == 0) goto L54
            java.lang.Object r5 = r9.get(r2)
            if (r5 == 0) goto L54
            java.lang.Object r2 = r9.get(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r0.put(r4, r2)
            goto L54
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.r(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.String r8, kotlin.coroutines.Continuation<? super java.lang.Long> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetCreateTime$1
            if (r0 == 0) goto L13
            r0 = r9
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetCreateTime$1 r0 = (com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetCreateTime$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetCreateTime$1 r0 = new com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetCreateTime$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L45
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r9)
            qj4.a r9 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.b
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = r9.b(r0)
            if (r9 != r1) goto L45
            return r1
        L45:
            java.util.Map r9 = (java.util.Map) r9
            java.util.Set r0 = r9.keySet()
            java.util.Iterator r0 = r0.iterator()
        L4f:
            boolean r1 = r0.hasNext()
            r4 = 0
            if (r1 == 0) goto L8c
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String[] r2 = r7.U(r1)
            int r2 = r2.length
            r6 = 2
            if (r2 < r6) goto L4f
            java.lang.String[] r2 = r7.U(r1)
            r2 = r2[r3]
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r2)
            if (r2 == 0) goto L4f
            java.lang.Object r2 = r9.get(r1)
            if (r2 == 0) goto L4f
            com.dragon.read.kmp.utils.i0 r8 = com.dragon.read.kmp.utils.i0.a
            java.lang.Object r9 = r9.get(r1)
            java.lang.String r9 = (java.lang.String) r9
            if (r9 != 0) goto L83
            java.lang.String r9 = ""
        L83:
            long r8 = r8.f(r9, r4)
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)
            return r8
        L8c:
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.s(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(java.lang.String r9, kotlin.coroutines.Continuation<? super java.lang.Double> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetDownloadPercent$1
            if (r0 == 0) goto L13
            r0 = r10
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetDownloadPercent$1 r0 = (com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetDownloadPercent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetDownloadPercent$1 r0 = new com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetDownloadPercent$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L45
        L2d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L35:
            kotlin.ResultKt.throwOnFailure(r10)
            qj4.a r10 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.b
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = r10.b(r0)
            if (r10 != r1) goto L45
            return r1
        L45:
            java.util.Map r10 = (java.util.Map) r10
            java.util.Set r0 = r10.keySet()
            java.util.Iterator r0 = r0.iterator()
        L4f:
            boolean r1 = r0.hasNext()
            r4 = 0
            if (r1 == 0) goto L93
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String[] r2 = r8.V(r1)
            int r2 = r2.length
            r6 = 2
            if (r2 < r6) goto L4f
            java.lang.String[] r2 = r8.V(r1)
            r6 = 0
            r2 = r2[r6]
            java.lang.String[] r6 = r8.V(r1)
            r6 = r6[r3]
            java.lang.String r7 = r8.M()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r2)
            if (r2 == 0) goto L4f
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r6)
            if (r2 == 0) goto L4f
            com.dragon.read.kmp.utils.i0 r9 = com.dragon.read.kmp.utils.i0.a
            java.lang.Object r10 = r10.get(r1)
            java.lang.String r10 = (java.lang.String) r10
            double r9 = r9.d(r10, r4)
            java.lang.Double r9 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r9)
            return r9
        L93:
            java.lang.Double r9 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r4)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.t(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(java.lang.String r7, kotlin.coroutines.Continuation<? super java.lang.Integer> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetDownloadTotal$1
            if (r0 == 0) goto L13
            r0 = r8
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetDownloadTotal$1 r0 = (com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetDownloadTotal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetDownloadTotal$1 r0 = new com.dragon.read.kmp.reader.download.ReaderDownloadMgr$blockingGetDownloadTotal$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L45
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            qj4.a r8 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.b
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r8 = r8.b(r0)
            if (r8 != r1) goto L45
            return r1
        L45:
            java.util.Map r8 = (java.util.Map) r8
            java.util.Set r0 = r8.keySet()
            java.util.Iterator r0 = r0.iterator()
        L4f:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L87
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String[] r4 = r6.W(r1)
            int r4 = r4.length
            r5 = 2
            if (r4 < r5) goto L4f
            java.lang.String[] r4 = r6.W(r1)
            r4 = r4[r3]
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r4)
            if (r4 == 0) goto L4f
            java.lang.Object r4 = r8.get(r1)
            if (r4 == 0) goto L4f
            com.dragon.read.kmp.utils.i0 r7 = com.dragon.read.kmp.utils.i0.a
            java.lang.Object r8 = r8.get(r1)
            java.lang.String r8 = (java.lang.String) r8
            int r7 = r7.g(r8, r2)
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r7
        L87:
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.u(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Object N(String str, String str2, Continuation<? super Float> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new ReaderDownloadMgr$getDownloadPercent$3(str, str2, null), continuation);
    }

    public final Object Q(String str, String str2, Continuation<? super Boolean> continuation) {
        return com.dragon.read.kmp.local.a.a.e(M(), str, str2, continuation);
    }

    private final String D(String str, String str2, String str3) {
        return str + "download_chapter_image" + str2 + "download_chapter_image" + str3;
    }

    public final Object j0(String str, ChapterInfo chapterInfo, Continuation<? super Unit> continuation) throws Exception {
        Object coroutine_suspended;
        if (chapterInfo == null) {
            return Unit.INSTANCE;
        }
        z(str);
        Object a2 = com.dragon.read.kmp.reader.utils.a.a.a(chapterInfo, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (a2 == coroutine_suspended) {
            return a2;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object L(String str, List<String> list, Continuation<? super Map<String, Double>> continuation) {
        Map emptyMap;
        if (ListUtils.INSTANCE.isEmpty(list)) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(a0(str, it2.next()));
        }
        return b.e(arrayList, -1.0d, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object K(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.Float> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.dragon.read.kmp.reader.download.ReaderDownloadMgr$getChapterDownloadPercent$1
            if (r0 == 0) goto L13
            r0 = r7
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$getChapterDownloadPercent$1 r0 = (com.dragon.read.kmp.reader.download.ReaderDownloadMgr$getChapterDownloadPercent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$getChapterDownloadPercent$1 r0 = new com.dragon.read.kmp.reader.download.ReaderDownloadMgr$getChapterDownloadPercent$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L45
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            qj4.a r7 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.b
            java.lang.String r5 = r4.a0(r5, r6)
            r0.label = r3
            r2 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            java.lang.Object r7 = r7.d(r5, r2, r0)
            if (r7 != r1) goto L45
            return r1
        L45:
            java.lang.Number r7 = (java.lang.Number) r7
            double r5 = r7.doubleValue()
            float r5 = (float) r5
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.K(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void v(String bookId, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (i2 == 0) {
            com.dragon.read.kmp.i.c(h, "totalSize == 0 return", (Throwable) null, 2, (Object) null);
            return;
        }
        com.dragon.read.kmp.i iVar = h;
        StringBuilder sb = new StringBuilder();
        sb.append("broadcastProgress:");
        sb.append(bookId);
        sb.append(" resetStatus:");
        float f2 = i2;
        sb.append((int) ((((i2 - i3) * 1.0f) / f2) * 100));
        iVar.d(sb.toString());
        Intent intent = new Intent("action_chapter_download_progress");
        intent.putExtra("bookId", bookId);
        intent.putExtra("key_total_size", i2);
        intent.putExtra("key_unfinished_size", i3);
        intent.putExtra("key_download_percent", 1.0f - ((i3 * 1.0f) / f2));
        intent.addCategory(bookId);
        kotlinx.coroutines.i.e(g, null, null, new ReaderDownloadMgr$broadcastProgress$1(intent, null), 3, null);
    }

    public final void w(String bookId, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        if (i2 == 0) {
            com.dragon.read.kmp.i.c(h, "broadcastProgressWithoutCategory totalSize == 0 return", (Throwable) null, 2, (Object) null);
            return;
        }
        com.dragon.read.kmp.i iVar = h;
        StringBuilder sb = new StringBuilder();
        sb.append("broadcastProgressWithoutCategory:");
        sb.append(bookId);
        sb.append(" resetStatus:");
        float f2 = i2;
        sb.append((int) ((((i2 - i3) * 1.0f) / f2) * 100));
        iVar.d(sb.toString());
        Intent intent = new Intent("action_chapter_download_progress");
        intent.putExtra("bookId", bookId);
        intent.putExtra("key_total_size", i2);
        intent.putExtra("key_unfinished_size", i3);
        intent.putExtra("key_download_percent", 1.0f - ((i3 * 1.0f) / f2));
        intent.addCategory("download_info_global");
        kotlinx.coroutines.i.e(g, null, null, new ReaderDownloadMgr$broadcastProgressWithoutCategory$1(intent, null), 3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x009e, code lost:
    
        if (r4.intValue() != r5) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(java.util.List<java.lang.String> r20, java.lang.String r21, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, com.dragon.read.kmprpc.reader.saas.model.p2>> r22) throws com.dragon.read.kmp.network.ReaderErrorException, java.util.concurrent.CancellationException {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.J(java.util.List, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00c6 -> B:11:0x00d3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object X(java.lang.String r19, java.util.List<java.lang.String> r20, kotlin.coroutines.Continuation<? super java.util.Set<java.lang.String>> r21) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.X(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00de -> B:11:0x00e7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y(java.lang.String r19, java.util.List<java.lang.String> r20, kotlin.coroutines.Continuation<? super java.util.Set<java.lang.String>> r21) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.Y(java.lang.String, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void P(String str, int i2, int i3, n nVar) {
        com.dragon.read.kmp.i.c(h, "handleNoDownloadPrivilege: 服务端报错无下载权益, 取消任务", (Throwable) null, 2, (Object) null);
        float f2 = (i3 * 1.0f) / i2;
        if (f2 <= 0.0f) {
            Z(str);
            if (nVar != null) {
                nVar.onCancel();
            }
        } else if (nVar != null) {
            nVar.a(i2, i3, f2);
        }
        ig4.g.b("暂无免费下载权益，请开通会员", (ToastDuration) null, 2, (Object) null);
        r.b.c(str);
    }

    public final Object i0(String str, String str2, String str3, Continuation<? super Unit> continuation) {
        boolean z;
        Map mapOf;
        Object coroutine_suspended;
        if (str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Unit.INSTANCE;
        }
        qj4.a aVar = b;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(D(str, str2, str3), "1"));
        Object a2 = aVar.a(mapOf, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (a2 == coroutine_suspended) {
            return a2;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(7:5|6|7|(1:(1:10)(2:16|17))(3:18|19|(1:21))|11|12|13))|24|6|7|(0)(0)|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0029, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        r6 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.h;
        r7 = new java.lang.StringBuilder();
        r7.append("自动下载更新目录信息出错，error = ");
        r5 = kotlin.ExceptionsKt__ExceptionsKt.stackTraceToString(r5);
        r7.append(r5);
        com.dragon.read.kmp.i.c(r6, r7.toString(), (java.lang.Throwable) null, 2, (java.lang.Object) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m0(java.lang.String r5, java.lang.String r6, an4.c r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Exception {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.dragon.read.kmp.reader.download.ReaderDownloadMgr$tryToUpdateCatalogInfoAsync$1
            if (r0 == 0) goto L13
            r0 = r8
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$tryToUpdateCatalogInfoAsync$1 r0 = (com.dragon.read.kmp.reader.download.ReaderDownloadMgr$tryToUpdateCatalogInfoAsync$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.download.ReaderDownloadMgr$tryToUpdateCatalogInfoAsync$1 r0 = new com.dragon.read.kmp.reader.download.ReaderDownloadMgr$tryToUpdateCatalogInfoAsync$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L29
            goto L44
        L29:
            r5 = move-exception
            goto L4d
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r8)
            r4.z(r5)
            com.dragon.read.kmp.reader.download.c r5 = com.dragon.read.kmp.reader.download.c.a     // Catch: java.lang.Throwable -> L29
            r0.label = r3     // Catch: java.lang.Throwable -> L29
            java.lang.Object r5 = r5.a(r6, r7, r0)     // Catch: java.lang.Throwable -> L29
            if (r5 != r1) goto L44
            return r1
        L44:
            com.dragon.read.kmp.i r5 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.h     // Catch: java.lang.Throwable -> L29
            java.lang.String r6 = "自动下载更新目录信息完成"
            r5.d(r6)     // Catch: java.lang.Throwable -> L29
            goto L6a
        L4d:
            com.dragon.read.kmp.i r6 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.h
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "自动下载更新目录信息出错，error = "
            r7.append(r8)
            java.lang.String r5 = kotlin.ExceptionsKt.stackTraceToString(r5)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r7 = 2
            r8 = 0
            com.dragon.read.kmp.i.c(r6, r5, r8, r7, r8)
        L6a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.m0(java.lang.String, java.lang.String, an4.c, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(6:5|6|7|(1:(1:(6:11|12|13|14|15|16)(2:22|23))(2:24|25))(3:38|39|(2:41|42)(2:43|(1:45)))|26|(2:28|29)(3:30|31|(1:33)(4:34|14|15|16))))|48|6|7|(0)(0)|26|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f6, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f7, code lost:
    
        r9 = com.dragon.read.kmp.reader.download.ReaderDownloadMgr.h;
        r10 = new java.lang.StringBuilder();
        r10.append("下载器 - 自动添加书架（收藏）失败，error = ");
        r8 = kotlin.ExceptionsKt__ExceptionsKt.stackTraceToString(r8);
        r10.append(r8);
        com.dragon.read.kmp.i.c(r9, r10.toString(), (java.lang.Throwable) null, 2, (java.lang.Object) null);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0083 A[Catch: all -> 0x00f6, TRY_LEAVE, TryCatch #1 {all -> 0x00f6, blocks: (B:20:0x00d2, B:21:0x00f5, B:25:0x0046, B:26:0x007b, B:28:0x0083, B:39:0x004d, B:41:0x0052, B:43:0x006c), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(java.lang.String r8, java.lang.String r9, boolean r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.p(java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Deferred<a> E(String str, String str2, boolean z, boolean z2, n nVar) {
        Deferred<a> b2;
        b2 = kotlinx.coroutines.i.b(g, null, null, new ReaderDownloadMgr$createDownloadTask$job$1(str2, nVar, z, str, z2, null), 3, null);
        return b2;
    }

    public final void b0(String targetUserId, String bookId, boolean z, boolean z2, n nVar) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Map<String, Job> map = e;
        Job job = map.get(bookId);
        if (job != null && !job.isCancelled()) {
            com.dragon.read.kmp.i.c(h, "下载器 - 离线下载任务还在进行中 userId: " + targetUserId + ", bookId = " + bookId, (Throwable) null, 2, (Object) null);
            return;
        }
        if (map.size() > 3) {
            Map<String, Deferred<a>> map2 = d;
            if (!map2.containsKey(bookId)) {
                map2.put(bookId, E(targetUserId, bookId, z, z2, nVar));
            }
            com.dragon.read.kmp.i.c(h, "下载器 - 离线下载并行任务超过最大限制 userId: " + targetUserId + ", bookId = " + bookId, (Throwable) null, 2, (Object) null);
            return;
        }
        Deferred<a> remove = d.remove(bookId);
        if (remove == null) {
            remove = E(targetUserId, bookId, z, z2, nVar);
        }
        I(bookId, remove);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0166 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0147 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h0(java.lang.String r20, java.lang.String r21, float r22, int r23, kotlin.coroutines.Continuation<? super kotlin.Unit> r24) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.h0(java.lang.String, java.lang.String, float, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00d5 -> B:17:0x0053). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object f0(int r20, long r21, long r23, double r25, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r27, kotlin.coroutines.Continuation<? super T> r28) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.f0(int, long, long, double, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0232 -> B:12:0x023e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01fc -> B:21:0x0136). Please report as a decompilation issue!!! */
    public final java.lang.Object H(java.lang.String r26, java.lang.String r27, java.util.List<java.lang.String> r28, java.util.Set<java.lang.String> r29, com.dragon.read.kmp.reader.download.n r30, kotlin.coroutines.Continuation<? super kotlin.Unit> r31) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.H(java.lang.String, java.lang.String, java.util.List, java.util.Set, com.dragon.read.kmp.reader.download.n, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0317 -> B:26:0x031f). Please report as a decompilation issue!!! */
    public final java.lang.Object c0(java.lang.String r20, java.lang.String r21, java.util.Map<java.lang.String, com.dragon.read.kmprpc.reader.saas.model.p2> r22, java.util.List<java.lang.String> r23, java.util.Set<java.lang.String> r24, com.dragon.read.kmp.reader.download.n r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
        /*
            Method dump skipped, instructions count: 992
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.download.ReaderDownloadMgr.c0(java.lang.String, java.lang.String, java.util.Map, java.util.List, java.util.Set, com.dragon.read.kmp.reader.download.n, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object g0(ReaderDownloadMgr readerDownloadMgr, int i2, long j, long j2, double d2, Function1 function1, Continuation continuation, int i3, Object obj) {
        long j3;
        long j4;
        double d3;
        if ((i3 & 2) != 0) {
            j3 = 100;
        } else {
            j3 = j;
        }
        if ((i3 & 4) != 0) {
            j4 = 1000;
        } else {
            j4 = j2;
        }
        if ((i3 & 8) != 0) {
            d3 = 2.0d;
        } else {
            d3 = d2;
        }
        return readerDownloadMgr.f0(i2, j3, j4, d3, function1, continuation);
    }
}
