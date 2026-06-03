package com.dragon.read.kmp.story.impl.feeds.data;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.GenreTypeEnum;
import com.bytedance.kmp.ugc.model.bm;
import com.bytedance.kmp.ugc.model.iy;
import com.dragon.read.kmp.service.KmpBookshelfService;
import com.dragon.read.kmp.utils.h0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import yo4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryDataSource {
    public static final StoryDataSource a;
    private static final tp4.b b;

    private StoryDataSource() {
    }

    public static final class a implements yo4.b {
        final /* synthetic */ bm a;
        final /* synthetic */ String b;

        @Override // yo4.b
        public String b() {
            return "8";
        }

        @Override // yo4.b
        public String getPostId() {
            return this.b;
        }

        @Override // yo4.b
        public String c() {
            return b.a.c(this);
        }

        @Override // yo4.b
        public List<String> e() {
            return b.a.a(this);
        }

        @Override // yo4.b
        public String getBookId() {
            return this.a.U0;
        }

        @Override // yo4.b
        public Integer getCreationStatus() {
            return 1;
        }

        @Override // yo4.b
        public String getGroupId() {
            return this.a.V0;
        }

        @Override // yo4.b
        public int a() {
            Integer num = this.a.N0;
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        @Override // yo4.b
        public int d() {
            Integer num = this.a.P0;
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        @Override // yo4.b
        public Integer getGenreType() {
            return Integer.valueOf(GenreTypeEnum.STORY_GENRE_TYPE.getValue());
        }

        a(bm bmVar, String str) {
            this.a = bmVar;
            this.b = str;
        }
    }

    public static final class b implements yo4.b {
        final /* synthetic */ String a;
        final /* synthetic */ iy b;

        @Override // yo4.b
        public String getBookId() {
            return this.a;
        }

        @Override // yo4.b
        public int a() {
            return b.a.e(this);
        }

        @Override // yo4.b
        public String b() {
            return this.b.i;
        }

        @Override // yo4.b
        public String c() {
            return this.b.u;
        }

        @Override // yo4.b
        public int d() {
            return b.a.d(this);
        }

        @Override // yo4.b
        public String getGroupId() {
            return b.a.b(this);
        }

        @Override // yo4.b
        public String getPostId() {
            return this.b.x;
        }

        @Override // yo4.b
        public List<String> e() {
            List<String> split$default;
            String str = this.b.A;
            if (str != null) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
                return split$default;
            }
            return null;
        }

        @Override // yo4.b
        public Integer getCreationStatus() {
            String str = this.b.f;
            if (str != null) {
                return Integer.valueOf(h0.i(str, -1));
            }
            return null;
        }

        @Override // yo4.b
        public Integer getGenreType() {
            String str = this.b.l;
            if (str != null) {
                return Integer.valueOf(h0.i(str, 0));
            }
            return null;
        }

        b(String str, iy iyVar) {
            this.a = str;
            this.b = iyVar;
        }
    }

    public static final class c implements yo4.b {
        final /* synthetic */ bm a;
        final /* synthetic */ String b;

        @Override // yo4.b
        public String b() {
            return "8";
        }

        @Override // yo4.b
        public String getPostId() {
            return this.b;
        }

        @Override // yo4.b
        public String c() {
            return b.a.c(this);
        }

        @Override // yo4.b
        public List<String> e() {
            return b.a.a(this);
        }

        @Override // yo4.b
        public String getBookId() {
            return this.a.U0;
        }

        @Override // yo4.b
        public Integer getCreationStatus() {
            return 1;
        }

        @Override // yo4.b
        public String getGroupId() {
            return this.a.V0;
        }

        @Override // yo4.b
        public int a() {
            Integer num = this.a.N0;
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        @Override // yo4.b
        public int d() {
            Integer num = this.a.P0;
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }

        @Override // yo4.b
        public Integer getGenreType() {
            return Integer.valueOf(GenreTypeEnum.STORY_GENRE_TYPE.getValue());
        }

        c(bm bmVar, String str) {
            this.a = bmVar;
            this.b = str;
        }
    }

    static {
        Covode.recordClassIndex(609270);
        a = new StoryDataSource();
        b = new tp4.b("StoryDataSource");
    }

    public final void f(String bookId) {
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        KmpBookshelfService.a.d(new String[]{bookId});
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(ip4.f r5, kotlin.coroutines.Continuation<? super kotlin.Result<com.dragon.read.kmp.story.impl.feeds.data.e>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$loadFullData$1
            if (r0 == 0) goto L13
            r0 = r6
            com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$loadFullData$1 r0 = (com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$loadFullData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$loadFullData$1 r0 = new com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$loadFullData$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.m782unboximpl()
            goto L58
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            ip4.c r6 = new ip4.c
            r6.<init>()
            java.lang.String r2 = r5.a
            r6.a = r2
            java.lang.String r2 = r5.b
            r6.g = r2
            int r5 = r5.c
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            r6.b = r5
            r0.label = r3
            java.lang.Object r5 = r4.c(r6, r0)
            if (r5 != r1) goto L58
            return r1
        L58:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource.e(ip4.f, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:10:0x0026, B:11:0x004a, B:13:0x0051, B:15:0x0057, B:17:0x005d, B:18:0x005f, B:20:0x006a, B:22:0x006e, B:25:0x0073, B:26:0x007a, B:32:0x0035), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:10:0x0026, B:11:0x004a, B:13:0x0051, B:15:0x0057, B:17:0x005d, B:18:0x005f, B:20:0x006a, B:22:0x006e, B:25:0x0073, B:26:0x007a, B:32:0x0035), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:10:0x0026, B:11:0x004a, B:13:0x0051, B:15:0x0057, B:17:0x005d, B:18:0x005f, B:20:0x006a, B:22:0x006e, B:25:0x0073, B:26:0x007a, B:32:0x0035), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(ip4.a r9, kotlin.coroutines.Continuation<? super kotlin.Result<com.bytedance.kmp.ugc.model.fg>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getInsideContentFeed$1
            if (r0 == 0) goto L13
            r0 = r10
            com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getInsideContentFeed$1 r0 = (com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getInsideContentFeed$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getInsideContentFeed$1 r0 = new com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getInsideContentFeed$1
            r0.<init>(r8, r10)
        L18:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L7b
            goto L4a
        L2a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L32:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L7b
            com.bytedance.kmp.ugc.rpc.UgcApiService r1 = com.bytedance.kmp.ugc.rpc.UgcApiService.a     // Catch: java.lang.Throwable -> L7b
            com.bytedance.kmp.ugc.model.jd r9 = ip4.b.a(r9)     // Catch: java.lang.Throwable -> L7b
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2     // Catch: java.lang.Throwable -> L7b
            r2 = r9
            java.lang.Object r10 = com.bytedance.kmp.ugc.rpc.UgcApiService.x(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L7b
            if (r10 != r0) goto L4a
            return r0
        L4a:
            com.bytedance.kmp.ugc.model.kd r10 = (com.bytedance.kmp.ugc.model.kd) r10     // Catch: java.lang.Throwable -> L7b
            bc4.b r0 = bc4.b.a     // Catch: java.lang.Throwable -> L7b
            r9 = 0
            if (r10 == 0) goto L54
            java.lang.Integer r1 = r10.a     // Catch: java.lang.Throwable -> L7b
            goto L55
        L54:
            r1 = r9
        L55:
            if (r10 == 0) goto L5a
            java.lang.String r2 = r10.b     // Catch: java.lang.Throwable -> L7b
            goto L5b
        L5a:
            r2 = r9
        L5b:
            if (r10 == 0) goto L5f
            com.bytedance.kmp.ugc.model.fg r9 = r10.c     // Catch: java.lang.Throwable -> L7b
        L5f:
            r3 = r9
            r4 = 0
            r5 = 0
            r6 = 24
            r7 = 0
            bc4.b.d(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7b
            if (r10 == 0) goto L73
            com.bytedance.kmp.ugc.model.fg r9 = r10.c     // Catch: java.lang.Throwable -> L7b
            if (r9 == 0) goto L73
            java.lang.Object r9 = kotlin.Result.m773constructorimpl(r9)     // Catch: java.lang.Throwable -> L7b
            goto L86
        L73:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L7b
            java.lang.String r10 = "getInsideContentFeed is null"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L7b
            throw r9     // Catch: java.lang.Throwable -> L7b
        L7b:
            r9 = move-exception
            kotlin.Result$Companion r10 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m773constructorimpl(r9)
        L86:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource.a(ip4.a, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0051 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:10:0x0026, B:11:0x004a, B:13:0x0051, B:15:0x0057, B:17:0x005d, B:18:0x005f, B:20:0x006a, B:22:0x006e, B:25:0x0073, B:26:0x007a, B:32:0x0035), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:10:0x0026, B:11:0x004a, B:13:0x0051, B:15:0x0057, B:17:0x005d, B:18:0x005f, B:20:0x006a, B:22:0x006e, B:25:0x0073, B:26:0x007a, B:32:0x0035), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005d A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:10:0x0026, B:11:0x004a, B:13:0x0051, B:15:0x0057, B:17:0x005d, B:18:0x005f, B:20:0x006a, B:22:0x006e, B:25:0x0073, B:26:0x007a, B:32:0x0035), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(ip4.c r9, kotlin.coroutines.Continuation<? super kotlin.Result<com.bytedance.kmp.ugc.model.bm>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getPostData$1
            if (r0 == 0) goto L13
            r0 = r10
            com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getPostData$1 r0 = (com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getPostData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getPostData$1 r0 = new com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getPostData$1
            r0.<init>(r8, r10)
        L18:
            r4 = r0
            java.lang.Object r10 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Throwable -> L7b
            goto L4a
        L2a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L32:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L7b
            com.bytedance.kmp.ugc.rpc.UgcApiService r1 = com.bytedance.kmp.ugc.rpc.UgcApiService.a     // Catch: java.lang.Throwable -> L7b
            com.bytedance.kmp.ugc.model.nd r9 = ip4.d.a(r9)     // Catch: java.lang.Throwable -> L7b
            r3 = 0
            r5 = 2
            r6 = 0
            r4.label = r2     // Catch: java.lang.Throwable -> L7b
            r2 = r9
            java.lang.Object r10 = com.bytedance.kmp.ugc.rpc.UgcApiService.B(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L7b
            if (r10 != r0) goto L4a
            return r0
        L4a:
            com.bytedance.kmp.ugc.model.od r10 = (com.bytedance.kmp.ugc.model.od) r10     // Catch: java.lang.Throwable -> L7b
            bc4.b r0 = bc4.b.a     // Catch: java.lang.Throwable -> L7b
            r9 = 0
            if (r10 == 0) goto L54
            java.lang.Integer r1 = r10.a     // Catch: java.lang.Throwable -> L7b
            goto L55
        L54:
            r1 = r9
        L55:
            if (r10 == 0) goto L5a
            java.lang.String r2 = r10.b     // Catch: java.lang.Throwable -> L7b
            goto L5b
        L5a:
            r2 = r9
        L5b:
            if (r10 == 0) goto L5f
            com.bytedance.kmp.ugc.model.bm r9 = r10.c     // Catch: java.lang.Throwable -> L7b
        L5f:
            r3 = r9
            r4 = 0
            r5 = 0
            r6 = 24
            r7 = 0
            bc4.b.d(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L7b
            if (r10 == 0) goto L73
            com.bytedance.kmp.ugc.model.bm r9 = r10.c     // Catch: java.lang.Throwable -> L7b
            if (r9 == 0) goto L73
            java.lang.Object r9 = kotlin.Result.m773constructorimpl(r9)     // Catch: java.lang.Throwable -> L7b
            goto L86
        L73:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L7b
            java.lang.String r10 = "postData is null"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L7b
            throw r9     // Catch: java.lang.Throwable -> L7b
        L7b:
            r9 = move-exception
            kotlin.Result$Companion r10 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m773constructorimpl(r9)
        L86:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource.b(ip4.c, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(ip4.c r5, kotlin.coroutines.Continuation<? super kotlin.Result<com.dragon.read.kmp.story.impl.feeds.data.e>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getStoryData$1
            if (r0 == 0) goto L13
            r0 = r6
            com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getStoryData$1 r0 = (com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getStoryData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getStoryData$1 r0 = new com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$getStoryData$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.Result r6 = (kotlin.Result) r6
            java.lang.Object r5 = r6.m782unboximpl()
            goto L43
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.label = r3
            java.lang.Object r5 = r4.b(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            boolean r6 = kotlin.Result.m780isSuccessimpl(r5)
            if (r6 == 0) goto Lcc
            com.bytedance.kmp.ugc.model.bm r5 = (com.bytedance.kmp.ugc.model.bm) r5     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r6 = r5.a     // Catch: java.lang.Throwable -> Lc5
            if (r6 == 0) goto Lbd
            com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$a r0 = new com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource$a     // Catch: java.lang.Throwable -> Lc5
            r0.<init>(r5, r6)     // Catch: java.lang.Throwable -> Lc5
            com.dragon.read.kmp.story.impl.feeds.data.e r1 = new com.dragon.read.kmp.story.impl.feeds.data.e     // Catch: java.lang.Throwable -> Lc5
            r1.<init>(r6, r0)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r6 = r5.k     // Catch: java.lang.Throwable -> Lc5
            r1.d = r6     // Catch: java.lang.Throwable -> Lc5
            java.util.List r6 = r5.X0     // Catch: java.lang.Throwable -> Lc5
            r1.e = r6     // Catch: java.lang.Throwable -> Lc5
            com.bytedance.kmp.ugc.model.d6 r6 = r5.l     // Catch: java.lang.Throwable -> Lc5
            r1.i = r6     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r6 = r5.y     // Catch: java.lang.Throwable -> Lc5
            r1.j = r6     // Catch: java.lang.Throwable -> Lc5
            com.dragon.read.kmp.story.impl.feeds.data.a r6 = new com.dragon.read.kmp.story.impl.feeds.data.a     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r0 = r5.V0     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r2 = ""
            if (r0 != 0) goto L72
            r0 = r2
        L72:
            r6.<init>(r0)     // Catch: java.lang.Throwable -> Lc5
            r0 = 0
            r6.b = r0     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r0 = r5.k     // Catch: java.lang.Throwable -> Lc5
            if (r0 != 0) goto L7d
            r0 = r2
        L7d:
            r6.a(r0)     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r0 = r5.e1     // Catch: java.lang.Throwable -> Lc5
            if (r0 != 0) goto L85
            goto L86
        L85:
            r2 = r0
        L86:
            r6.b(r2)     // Catch: java.lang.Throwable -> Lc5
            java.util.List<com.dragon.read.kmp.story.impl.feeds.data.a> r0 = r1.f     // Catch: java.lang.Throwable -> Lc5
            r0.add(r6)     // Catch: java.lang.Throwable -> Lc5
            java.util.List<com.bytedance.kmp.ugc.model.rj> r6 = r1.g     // Catch: java.lang.Throwable -> Lc5
            java.util.List r0 = r5.F     // Catch: java.lang.Throwable -> Lc5
            if (r0 == 0) goto L95
            goto L99
        L95:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()     // Catch: java.lang.Throwable -> Lc5
        L99:
            r6.addAll(r0)     // Catch: java.lang.Throwable -> Lc5
            java.lang.Integer r6 = r5.M0     // Catch: java.lang.Throwable -> Lc5
            if (r6 == 0) goto La9
            int r6 = r6.intValue()     // Catch: java.lang.Throwable -> Lc5
            com.bytedance.kmp.ugc.model.TruncateFlag r6 = com.dragon.read.kmp.story.impl.b.e(r6)     // Catch: java.lang.Throwable -> Lc5
            goto Laa
        La9:
            r6 = 0
        Laa:
            r1.h = r6     // Catch: java.lang.Throwable -> Lc5
            java.lang.Boolean r5 = r5.g1     // Catch: java.lang.Throwable -> Lc5
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch: java.lang.Throwable -> Lc5
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)     // Catch: java.lang.Throwable -> Lc5
            r1.k = r5     // Catch: java.lang.Throwable -> Lc5
            java.lang.Object r5 = kotlin.Result.m773constructorimpl(r1)     // Catch: java.lang.Throwable -> Lc5
            goto Ld0
        Lbd:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> Lc5
            java.lang.String r6 = "postId is null"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Lc5
            throw r5     // Catch: java.lang.Throwable -> Lc5
        Lc5:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
        Lcc:
            java.lang.Object r5 = kotlin.Result.m773constructorimpl(r5)
        Ld0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource.c(ip4.c, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x039f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x037c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(ip4.a r104, kotlin.coroutines.Continuation<? super kotlin.Result<com.dragon.read.kmp.story.impl.feeds.data.g>> r105) {
        /*
            Method dump skipped, instructions count: 1019
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.kmp.story.impl.feeds.data.StoryDataSource.d(ip4.a, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
