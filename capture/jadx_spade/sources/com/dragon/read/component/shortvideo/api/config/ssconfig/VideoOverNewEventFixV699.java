package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoOverNewEventFixV699 {
    public static final a a;
    private static final Lazy<VideoOverNewEventFixV699> b;

    @SerializedName("fix_video_over_duration_v699")
    public final boolean fixVideoOverDurationV699;

    public VideoOverNewEventFixV699() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598589);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoOverNewEventFixV699 a() {
            return (VideoOverNewEventFixV699) VideoOverNewEventFixV699.b.getValue();
        }
    }

    static {
        Lazy<VideoOverNewEventFixV699> lazy;
        Covode.recordClassIndex(598588);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.d3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoOverNewEventFixV699 c;
                c = VideoOverNewEventFixV699.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoOverNewEventFixV699 c() {
        return (VideoOverNewEventFixV699) qq3.a.c("video_over_new_event_fix_v699", new VideoOverNewEventFixV699(false, 1, null), false, 4, null);
    }

    public VideoOverNewEventFixV699(boolean z) {
        this.fixVideoOverDurationV699 = z;
    }

    public /* synthetic */ VideoOverNewEventFixV699(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
