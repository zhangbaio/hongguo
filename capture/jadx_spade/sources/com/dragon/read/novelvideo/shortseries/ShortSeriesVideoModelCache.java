package com.dragon.read.novelvideo.shortseries;

import com.bytedance.covode.number.Covode;
import com.dragon.read.base.util.LogHelper;
import com.dragon.read.rpc.model.VideoPlatformType;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortSeriesVideoModelCache implements Serializable {
    public static final int $stable;
    public static final a Companion;
    private static final LogHelper log;
    private final String tag;
    private final Map<String, List<b>> vid2ReqListenerMap;
    private final Map<String, d> vid2VideoModelDataMap;

    public static final class a {
        static {
            Covode.recordClassIndex(612523);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public interface b {
        void a(d dVar);
    }

    public static final class d {
        public static final int e;
        public final String a;
        public final VideoModelWrapperType b;
        public final String c;
        public final Serializable d;

        static {
            Covode.recordClassIndex(612526);
            e = 8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return Intrinsics.areEqual(this.a, dVar.a) && this.b == dVar.b && Intrinsics.areEqual(this.c, dVar.c) && Intrinsics.areEqual(this.d, dVar.d);
        }

        public int hashCode() {
            String str = this.a;
            int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            Serializable serializable = this.d;
            return hashCode + (serializable != null ? serializable.hashCode() : 0);
        }

        public String toString() {
            return "VideoModelData(videoModel=" + this.a + ", type=" + this.b + ", vid=" + this.c + ", extra=" + this.d + ')';
        }

        public final VideoModelWrapperType getType() {
            return this.b;
        }

        public d(String str, VideoModelWrapperType type, String vid, Serializable serializable) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(vid, "vid");
            this.a = str;
            this.b = type;
            this.c = vid;
            this.d = serializable;
        }

        public /* synthetic */ d(String str, VideoModelWrapperType videoModelWrapperType, String str2, Serializable serializable, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, videoModelWrapperType, str2, (i & 8) != 0 ? null : serializable);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class VideoModelWrapperType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ VideoModelWrapperType[] $VALUES;
        public static final VideoModelWrapperType FROM_CACHE;
        public static final VideoModelWrapperType FROM_NET;
        public static final VideoModelWrapperType THROW_EXCEPTION;

        private static final /* synthetic */ VideoModelWrapperType[] $values() {
            return new VideoModelWrapperType[]{FROM_NET, FROM_CACHE, THROW_EXCEPTION};
        }

        public static EnumEntries<VideoModelWrapperType> getEntries() {
            return $ENTRIES;
        }

        public static VideoModelWrapperType[] values() {
            return (VideoModelWrapperType[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(612527);
            FROM_NET = new VideoModelWrapperType("FROM_NET", 0);
            FROM_CACHE = new VideoModelWrapperType("FROM_CACHE", 1);
            THROW_EXCEPTION = new VideoModelWrapperType("THROW_EXCEPTION", 2);
            VideoModelWrapperType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static VideoModelWrapperType valueOf(String str) {
            return (VideoModelWrapperType) Enum.valueOf(VideoModelWrapperType.class, str);
        }

        private VideoModelWrapperType(String str, int i) {
        }
    }

    static {
        Covode.recordClassIndex(612522);
        Companion = new a(null);
        $stable = 8;
        log = new LogHelper("ShortSeriesVideoModelCache");
    }

    public ShortSeriesVideoModelCache(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        this.vid2ReqListenerMap = new LinkedHashMap();
        this.vid2VideoModelDataMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoModel convertVideoModel(String str) {
        JSONObject jSONObject = new JSONObject(str);
        VideoModel videoModel = new VideoModel();
        VideoRef videoRef = new VideoRef();
        videoRef.extractFields(jSONObject);
        videoModel.setVideoRef(videoRef);
        return videoModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(8:5|6|7|(1:(2:10|11)(2:24|25))(3:26|27|(1:29))|12|13|(4:15|(2:18|16)|19|20)|21))|32|6|7|(0)(0)|12|13|(0)|21) */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005b, code lost:
    
        r8 = new com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.d(null, com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.VideoModelWrapperType.THROW_EXCEPTION, r7.a, r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object doLoadVideoModel(com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.c r7, kotlin.coroutines.Continuation<? super com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.d> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$doLoadVideoModel$1
            if (r0 == 0) goto L13
            r0 = r8
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$doLoadVideoModel$1 r0 = (com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$doLoadVideoModel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$doLoadVideoModel$1 r0 = new com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$doLoadVideoModel$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 != r4) goto L2e
            java.lang.Object r7 = r0.L$0
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$c r7 = (com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.c) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L5a
            goto L57
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.Map<java.lang.String, java.util.List<com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$b>> r8 = r6.vid2ReqListenerMap
            java.lang.String r2 = r7.a
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r8.put(r2, r5)
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$doLoadVideoModel$videoModelData$1 r8 = new com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$doLoadVideoModel$videoModelData$1     // Catch: java.lang.Throwable -> L5a
            r8.<init>(r7, r6, r3)     // Catch: java.lang.Throwable -> L5a
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L5a
            r0.label = r4     // Catch: java.lang.Throwable -> L5a
            r4 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeout(r4, r8, r0)     // Catch: java.lang.Throwable -> L5a
            if (r8 != r1) goto L57
            return r1
        L57:
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$d r8 = (com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.d) r8     // Catch: java.lang.Throwable -> L5a
            goto L65
        L5a:
            r8 = move-exception
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$d r0 = new com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$d
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$VideoModelWrapperType r1 = com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.VideoModelWrapperType.THROW_EXCEPTION
            java.lang.String r2 = r7.a
            r0.<init>(r3, r1, r2, r8)
            r8 = r0
        L65:
            java.util.Map<java.lang.String, java.util.List<com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$b>> r0 = r6.vid2ReqListenerMap
            java.lang.String r1 = r7.a
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L8f
            java.util.Iterator r0 = r0.iterator()
        L75:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L85
            java.lang.Object r1 = r0.next()
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$b r1 = (com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.b) r1
            r1.a(r8)
            goto L75
        L85:
            java.util.Map<java.lang.String, java.util.List<com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$b>> r0 = r6.vid2ReqListenerMap
            java.lang.String r7 = r7.a
            java.lang.Object r7 = r0.remove(r7)
            java.util.List r7 = (java.util.List) r7
        L8f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.doLoadVideoModel(com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$c, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadVideoModelDataAsyncIfAlreadyReq(com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.c r10, kotlin.coroutines.Continuation<? super com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.d> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$1
            if (r0 == 0) goto L13
            r0 = r11
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$1 r0 = (com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$1 r0 = new com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$1
            r0.<init>(r9, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r10 = r0.L$0
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$c r10 = (com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.c) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Throwable -> L4e
            goto L4b
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            kotlin.ResultKt.throwOnFailure(r11)
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$videoModelData$1 r11 = new com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$loadVideoModelDataAsyncIfAlreadyReq$videoModelData$1     // Catch: java.lang.Throwable -> L4e
            r2 = 0
            r11.<init>(r9, r10, r2)     // Catch: java.lang.Throwable -> L4e
            r0.L$0 = r10     // Catch: java.lang.Throwable -> L4e
            r0.label = r3     // Catch: java.lang.Throwable -> L4e
            r2 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r11 = kotlinx.coroutines.TimeoutKt.withTimeout(r2, r11, r0)     // Catch: java.lang.Throwable -> L4e
            if (r11 != r1) goto L4b
            return r1
        L4b:
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$d r11 = (com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.d) r11     // Catch: java.lang.Throwable -> L4e
            goto L87
        L4e:
            r11 = move-exception
            boolean r0 = r11 instanceof kotlinx.coroutines.TimeoutCancellationException
            r1 = 0
            if (r0 == 0) goto L5f
            com.dragon.read.base.util.LogHelper r11 = com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.log
            java.lang.String r0 = "等待回调超时"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r11.e(r0, r1)
            goto L78
        L5f:
            com.dragon.read.base.util.LogHelper r0 = com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.log
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "捕获异常, t="
            r2.append(r3)
            r2.append(r11)
            java.lang.String r11 = r2.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.e(r11, r1)
        L78:
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$d r11 = new com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$d
            r3 = 0
            com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$VideoModelWrapperType r4 = com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.VideoModelWrapperType.THROW_EXCEPTION
            java.lang.String r5 = r10.a
            r6 = 0
            r7 = 8
            r8 = 0
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
        L87:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.loadVideoModelDataAsyncIfAlreadyReq(com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$c, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadVideoModelDataAsync(com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.c r8, kotlin.coroutines.Continuation<? super com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.d> r9) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache.loadVideoModelDataAsync(com.dragon.read.novelvideo.shortseries.ShortSeriesVideoModelCache$c, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final class c {
        public final String a;
        public final VideoPlatformType b;
        public final int c;

        static {
            Covode.recordClassIndex(612525);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.areEqual(this.a, cVar.a) && this.b == cVar.b && this.c == cVar.c;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
        }

        public String toString() {
            return "LoadVideoModelParams(vid=" + this.a + ", videoPlatform=" + this.b + ", contentType=" + this.c + ')';
        }

        public c(String vid, VideoPlatformType videoPlatform, int i) {
            Intrinsics.checkNotNullParameter(vid, "vid");
            Intrinsics.checkNotNullParameter(videoPlatform, "videoPlatform");
            this.a = vid;
            this.b = videoPlatform;
            this.c = i;
        }
    }
}
