package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PrefetchCacheConfig {

    @SerializedName("book_store")
    public final ScopeCacheConfig bookstoreConfig;

    @SerializedName("default")
    public final ScopeCacheConfig defaultConfig;

    @SerializedName("profile")
    public final ScopeCacheConfig profileConfig;

    @SerializedName("single_feed")
    public final ScopeCacheConfig singleFeedConfig;

    @SerializedName("unlimited")
    public final boolean unlimited;

    static {
        Covode.recordClassIndex(598425);
    }

    public PrefetchCacheConfig() {
        this(false, null, null, null, null, 31, null);
    }

    public PrefetchCacheConfig(boolean z, ScopeCacheConfig defaultConfig, ScopeCacheConfig singleFeedConfig, ScopeCacheConfig bookstoreConfig, ScopeCacheConfig profileConfig) {
        Intrinsics.checkNotNullParameter(defaultConfig, "defaultConfig");
        Intrinsics.checkNotNullParameter(singleFeedConfig, "singleFeedConfig");
        Intrinsics.checkNotNullParameter(bookstoreConfig, "bookstoreConfig");
        Intrinsics.checkNotNullParameter(profileConfig, "profileConfig");
        this.unlimited = z;
        this.defaultConfig = defaultConfig;
        this.singleFeedConfig = singleFeedConfig;
        this.bookstoreConfig = bookstoreConfig;
        this.profileConfig = profileConfig;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ PrefetchCacheConfig(boolean r12, com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig r13, com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig r14, com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig r15, com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r11 = this;
            r0 = r17 & 1
            if (r0 == 0) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = r12
        L7:
            r1 = r17 & 2
            if (r1 == 0) goto L19
            com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig r1 = new com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 15
            r8 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
            goto L1a
        L19:
            r1 = r13
        L1a:
            r2 = r17 & 4
            if (r2 == 0) goto L2c
            com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig r2 = new com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 15
            r9 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9)
            goto L2d
        L2c:
            r2 = r14
        L2d:
            r3 = r17 & 8
            if (r3 == 0) goto L3f
            com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig r3 = new com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 15
            r10 = 0
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10)
            goto L40
        L3f:
            r3 = r15
        L40:
            r4 = r17 & 16
            if (r4 == 0) goto L5b
            com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig r4 = new com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 15
            r10 = 0
            r12 = r4
            r13 = r5
            r14 = r6
            r15 = r7
            r16 = r8
            r17 = r9
            r18 = r10
            r12.<init>(r13, r14, r15, r16, r17, r18)
            goto L5d
        L5b:
            r4 = r16
        L5d:
            r12 = r11
            r13 = r0
            r14 = r1
            r15 = r2
            r16 = r3
            r17 = r4
            r12.<init>(r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.PrefetchCacheConfig.<init>(boolean, com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig, com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig, com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig, com.dragon.read.component.shortvideo.api.config.ssconfig.ScopeCacheConfig, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
