package com.dragon.read.kmp.reader.font.manager;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.services.x;
import com.dragon.read.kmp.reader.utils.p;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import dm4.q;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FontDataManager {
    public static final FontDataManager a;
    private static final Lazy b;
    private static final Lazy c;
    private static final com.dragon.read.kmp.i d;
    private static volatile a e;
    private static final Mutex f;
    private static boolean g;
    private static final CoroutineScope h;
    public static final int i;

    private FontDataManager() {
    }

    public final List<com.dragon.read.kmp.reader.font.h> q() {
        return e.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h h() {
        return x.a.e().Z7();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i j() {
        return x.a.e().n4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h k() {
        return (h) b.getValue();
    }

    private final i l() {
        return (i) c.getValue();
    }

    public final void t() {
        d.d("preloadFontDataList");
        kotlinx.coroutines.i.e(h, Dispatchers.getIO(), null, new FontDataManager$preloadFontDataList$1(null), 2, null);
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Covode.recordClassIndex(608441);
        a = new FontDataManager();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.reader.font.manager.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                h h2;
                h2 = FontDataManager.h();
                return h2;
            }
        });
        b = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.kmp.reader.font.manager.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                i j;
                j = FontDataManager.j();
                return j;
            }
        });
        c = lazy2;
        d = new com.dragon.read.kmp.i(p.o("FontDataManager"));
        e = new a(null, null, null, 7, null);
        f = MutexKt.Mutex$default(false, 1, null);
        h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
        i = 8;
    }

    public static final class b extends com.dragon.read.reader.newfont.a {
        final /* synthetic */ com.dragon.read.kmp.reader.font.h b;

        b(com.dragon.read.kmp.reader.font.h hVar) {
            this.b = hVar;
        }

        public void onStart(DownloadInfo entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            super/*com.ss.android.socialbase.downloader.depend.AbsDownloadListener*/.onStart(entity);
            FontDataManager.d.d("开始预下载字体, " + this.b.a + ", font name: " + this.b.b + ", font url: " + this.b.e);
        }

        public void onSuccessed(DownloadInfo entity) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            super/*com.ss.android.socialbase.downloader.depend.AbsDownloadListener*/.onSuccessed(entity);
            FontDataManager.d.d("预下载字体成功, font name: " + this.b.b + ", font url: " + this.b.e);
        }

        public void onFailed(DownloadInfo entity, BaseException e) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(e, "e");
            super/*com.ss.android.socialbase.downloader.depend.AbsDownloadListener*/.onFailed(entity, e);
            FontDataManager.d.d("预下载字体失败, font name: " + this.b.b + ", font url: " + this.b.e + "， error: " + e.getErrorMessage());
        }
    }

    public final com.dragon.read.kmp.reader.font.h m(String fontFamily) {
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        return e.b.get(fontFamily);
    }

    public final com.dragon.read.kmp.reader.font.h n(String fontTitle) {
        Intrinsics.checkNotNullParameter(fontTitle, "fontTitle");
        return e.c.get(fontTitle);
    }

    private final void i(List<com.dragon.read.kmp.reader.font.h> list) {
        if (l() == null) {
            return;
        }
        for (com.dragon.read.kmp.reader.font.h hVar : list) {
            if (hVar.j) {
                FontDownloadManager fontDownloadManager = FontDownloadManager.a;
                if (!fontDownloadManager.q(hVar.i) && !q.b.q(hVar.i)) {
                    fontDownloadManager.m(hVar.e, hVar.b, new b(hVar));
                }
            }
        }
    }

    public final com.dragon.read.kmp.reader.font.h o(String str) {
        Object obj;
        Iterator<T> it2 = e.a.iterator();
        while (true) {
            if (it2.hasNext()) {
                obj = it2.next();
                if (Intrinsics.areEqual(((com.dragon.read.kmp.reader.font.h) obj).e, str)) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (com.dragon.read.kmp.reader.font.h) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(List<com.dragon.read.kmp.reader.font.h> list) {
        int mapCapacity;
        int coerceAtLeast;
        int mapCapacity2;
        int coerceAtLeast2;
        d.d("updateCacheList，size:" + list.size());
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list) {
            linkedHashMap.put(((com.dragon.read.kmp.reader.font.h) obj).b, obj);
        }
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast2);
        for (Object obj2 : list) {
            linkedHashMap2.put(((com.dragon.read.kmp.reader.font.h) obj2).a, obj2);
        }
        e = new a(list, linkedHashMap, linkedHashMap2);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(8:5|6|7|(1:(1:(2:11|12)(2:14|15))(1:16))(2:25|(2:27|28)(2:29|(2:31|32)(2:33|(1:35))))|17|(2:19|20)|22|(1:24)(1:12)))|38|6|7|(0)(0)|17|(0)|22|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0038, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0076, code lost:
    
        com.dragon.read.kmp.reader.font.manager.FontDataManager.d.b("获取本地字体缓存失败", r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0087 A[PHI: r6
  0x0087: PHI (r6v4 java.lang.Object) = (r6v3 java.lang.Object), (r6v1 java.lang.Object) binds: [B:23:0x0084, B:11:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006a A[Catch: Exception -> 0x0038, TRY_LEAVE, TryCatch #0 {Exception -> 0x0038, blocks: (B:16:0x0034, B:17:0x0061, B:19:0x006a, B:33:0x0058), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(kotlin.coroutines.Continuation<? super java.util.List<com.dragon.read.kmp.reader.font.h>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.dragon.read.kmp.reader.font.manager.FontDataManager$getFontConfigList$1
            if (r0 == 0) goto L13
            r0 = r6
            com.dragon.read.kmp.reader.font.manager.FontDataManager$getFontConfigList$1 r0 = (com.dragon.read.kmp.reader.font.manager.FontDataManager$getFontConfigList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.reader.font.manager.FontDataManager$getFontConfigList$1 r0 = new com.dragon.read.kmp.reader.font.manager.FontDataManager$getFontConfigList$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L87
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            kotlin.ResultKt.throwOnFailure(r6)     // Catch: java.lang.Exception -> L38
            goto L61
        L38:
            r6 = move-exception
            goto L76
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.dragon.read.kmp.reader.font.manager.h r6 = r5.k()
            if (r6 != 0) goto L48
            com.dragon.read.kmp.reader.font.manager.FontDataManager$a r6 = com.dragon.read.kmp.reader.font.manager.FontDataManager.e
            java.util.List<com.dragon.read.kmp.reader.font.h> r6 = r6.a
            return r6
        L48:
            com.dragon.read.kmp.reader.font.manager.FontDataManager$a r2 = com.dragon.read.kmp.reader.font.manager.FontDataManager.e
            java.util.List<com.dragon.read.kmp.reader.font.h> r2 = r2.a
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r4
            if (r2 == 0) goto L58
            com.dragon.read.kmp.reader.font.manager.FontDataManager$a r6 = com.dragon.read.kmp.reader.font.manager.FontDataManager.e
            java.util.List<com.dragon.read.kmp.reader.font.h> r6 = r6.a
            return r6
        L58:
            r0.label = r4     // Catch: java.lang.Exception -> L38
            java.lang.Object r6 = r6.b(r0)     // Catch: java.lang.Exception -> L38
            if (r6 != r1) goto L61
            return r1
        L61:
            java.util.List r6 = (java.util.List) r6     // Catch: java.lang.Exception -> L38
            boolean r2 = r6.isEmpty()     // Catch: java.lang.Exception -> L38
            r2 = r2 ^ r4
            if (r2 == 0) goto L7e
            java.util.List r6 = kotlin.collections.CollectionsKt.toMutableList(r6)     // Catch: java.lang.Exception -> L38
            r5.u(r6)     // Catch: java.lang.Exception -> L38
            com.dragon.read.kmp.reader.font.manager.FontDataManager$a r6 = com.dragon.read.kmp.reader.font.manager.FontDataManager.e     // Catch: java.lang.Exception -> L38
            java.util.List<com.dragon.read.kmp.reader.font.h> r6 = r6.a     // Catch: java.lang.Exception -> L38
            return r6
        L76:
            com.dragon.read.kmp.i r2 = com.dragon.read.kmp.reader.font.manager.FontDataManager.d
            java.lang.String r4 = "获取本地字体缓存失败"
            r2.b(r4, r6)
        L7e:
            r0.label = r3
            java.lang.Object r6 = r5.s(r0)
            if (r6 != r1) goto L87
            return r1
        L87:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.font.manager.FontDataManager.p(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:106:0x0157
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(kotlin.coroutines.Continuation<? super java.util.List<com.dragon.read.kmp.reader.font.h>> r17) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.font.manager.FontDataManager.r(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:31:0x004f, B:32:0x00c6, B:38:0x009f, B:40:0x00a3, B:41:0x00ac, B:42:0x00b4), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ac A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #0 {all -> 0x0054, blocks: (B:31:0x004f, B:32:0x00c6, B:38:0x009f, B:40:0x00a3, B:41:0x00ac, B:42:0x00b4), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(kotlin.coroutines.Continuation<? super java.util.List<com.dragon.read.kmp.reader.font.h>> r12) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.reader.font.manager.FontDataManager.s(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private static final class a {
        public final List<com.dragon.read.kmp.reader.font.h> a;
        public final Map<String, com.dragon.read.kmp.reader.font.h> b;
        public final Map<String, com.dragon.read.kmp.reader.font.h> c;

        static {
            Covode.recordClassIndex(608442);
        }

        public a() {
            this(null, null, null, 7, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "FontCaches(configListCache=" + this.a + ", fontFamilyMap=" + this.b + ", fontTitleMap=" + this.c + ')';
        }

        public a(List<com.dragon.read.kmp.reader.font.h> configListCache, Map<String, com.dragon.read.kmp.reader.font.h> fontFamilyMap, Map<String, com.dragon.read.kmp.reader.font.h> fontTitleMap) {
            Intrinsics.checkNotNullParameter(configListCache, "configListCache");
            Intrinsics.checkNotNullParameter(fontFamilyMap, "fontFamilyMap");
            Intrinsics.checkNotNullParameter(fontTitleMap, "fontTitleMap");
            this.a = configListCache;
            this.b = fontFamilyMap;
            this.c = fontTitleMap;
        }

        public /* synthetic */ a(List list, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i & 2) != 0 ? MapsKt__MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map2);
        }
    }
}
