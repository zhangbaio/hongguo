package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoOutPreloadConfigV651 {
    public static final Companion a;
    private static final Lazy<VideoOutPreloadConfigV651> b;

    @SerializedName("hot_time")
    public final Companion.Item hotTime;

    @SerializedName("normal")
    public final Companion.Item normal;

    @SerializedName("wifi")
    public final Companion.Item wifi;

    public VideoOutPreloadConfigV651() {
        this(null, null, null, 7, null);
    }

    public static final class Companion {
        static {
            Covode.recordClassIndex(598586);
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoOutPreloadConfigV651 a() {
            return (VideoOutPreloadConfigV651) VideoOutPreloadConfigV651.b.getValue();
        }

        public static final class Item {

            @SerializedName("preload_kb")
            public final long preloadKb;

            @SerializedName("preload_kb_book_mall")
            public final long preloadKbBookMall;

            @SerializedName("preload_kb_floating_view")
            public final long preloadKbFloatingView;

            static {
                Covode.recordClassIndex(598587);
            }

            public Item() {
                this(0L, 0L, 0L, 7, null);
            }

            public Item(long j, long j2, long j3) {
                this.preloadKb = j;
                this.preloadKbFloatingView = j2;
                this.preloadKbBookMall = j3;
            }

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public /* synthetic */ Item(long r7, long r9, long r11, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
                /*
                    r6 = this;
                    r14 = r13 & 1
                    r0 = -1
                    if (r14 == 0) goto L8
                    r2 = r0
                    goto L9
                L8:
                    r2 = r7
                L9:
                    r7 = r13 & 2
                    if (r7 == 0) goto Lf
                    r4 = r0
                    goto L10
                Lf:
                    r4 = r9
                L10:
                    r7 = r13 & 4
                    if (r7 == 0) goto L16
                    r12 = r0
                    goto L17
                L16:
                    r12 = r11
                L17:
                    r7 = r6
                    r8 = r2
                    r10 = r4
                    r7.<init>(r8, r10, r12)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.shortvideo.api.config.ssconfig.VideoOutPreloadConfigV651.Companion.Item.<init>(long, long, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }
        }
    }

    static {
        Lazy<VideoOutPreloadConfigV651> lazy;
        Covode.recordClassIndex(598585);
        a = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.c3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoOutPreloadConfigV651 c;
                c = VideoOutPreloadConfigV651.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoOutPreloadConfigV651 c() {
        return (VideoOutPreloadConfigV651) qq3.a.c("video_out_preload_v651", new VideoOutPreloadConfigV651(null, null, null, 7, null), false, 4, null);
    }

    public VideoOutPreloadConfigV651(Companion.Item item, Companion.Item item2, Companion.Item item3) {
        this.normal = item;
        this.wifi = item2;
        this.hotTime = item3;
    }

    public /* synthetic */ VideoOutPreloadConfigV651(Companion.Item item, Companion.Item item2, Companion.Item item3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : item, (i & 2) != 0 ? null : item2, (i & 4) != 0 ? null : item3);
    }
}
