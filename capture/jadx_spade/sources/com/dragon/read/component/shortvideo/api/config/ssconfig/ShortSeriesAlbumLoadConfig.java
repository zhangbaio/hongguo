package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortSeriesAlbumLoadConfig {
    public static final a a;

    @SerializedName("init_prefetch_more_size")
    public final int initPrefetchMoreSize;

    @SerializedName("init_prefetch_pre_size")
    public final int initPrefetchPreSize;

    @SerializedName("load_more_size")
    public final int loadMoreSize;

    @SerializedName("load_pre_size")
    public final int loadPreSize;

    @SerializedName("load_pre_threshold")
    public final int loadPreThreshold;

    @SerializedName("select_prefetch_more_size")
    public final int selectPrefetchMoreSize;

    @SerializedName("select_prefetch_pre_size")
    public final int selectPrefetchPreSize;

    static {
        Covode.recordClassIndex(598509);
        a = new a(null);
    }

    public ShortSeriesAlbumLoadConfig() {
        this(0, 0, 0, 0, 0, 0, 0, 127, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598510);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ShortSeriesAlbumLoadConfig a() {
            return (ShortSeriesAlbumLoadConfig) qq3.a.c("short_series_album_load_config_v668", new ShortSeriesAlbumLoadConfig(0, 0, 0, 0, 0, 0, 0, 127, null), false, 4, null);
        }
    }

    public ShortSeriesAlbumLoadConfig(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.initPrefetchPreSize = i;
        this.initPrefetchMoreSize = i2;
        this.selectPrefetchPreSize = i3;
        this.selectPrefetchMoreSize = i4;
        this.loadMoreSize = i5;
        this.loadPreSize = i6;
        this.loadPreThreshold = i7;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ShortSeriesAlbumLoadConfig(int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            r0 = 3
            if (r14 == 0) goto L7
            r14 = 3
            goto L8
        L7:
            r14 = r6
        L8:
            r6 = r13 & 2
            r1 = 4
            if (r6 == 0) goto Lf
            r2 = 4
            goto L10
        Lf:
            r2 = r7
        L10:
            r6 = r13 & 4
            if (r6 == 0) goto L15
            goto L16
        L15:
            r0 = r8
        L16:
            r6 = r13 & 8
            if (r6 == 0) goto L1b
            goto L1c
        L1b:
            r1 = r9
        L1c:
            r6 = r13 & 16
            r7 = 10
            if (r6 == 0) goto L25
            r3 = 10
            goto L26
        L25:
            r3 = r10
        L26:
            r6 = r13 & 32
            if (r6 == 0) goto L2d
            r4 = 10
            goto L2e
        L2d:
            r4 = r11
        L2e:
            r6 = r13 & 64
            if (r6 == 0) goto L35
            r12 = 2
            r13 = 2
            goto L36
        L35:
            r13 = r12
        L36:
            r6 = r5
            r7 = r14
            r8 = r2
            r9 = r0
            r10 = r1
            r11 = r3
            r12 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.ShortSeriesAlbumLoadConfig.<init>(int, int, int, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
