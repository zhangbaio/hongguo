package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.ShortSeriesApi;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class VideoStopCloseIOABValue {
    public static final a a;
    private static final Lazy<VideoStopCloseIOABValue> b;

    @SerializedName("type")
    public final int type;

    public VideoStopCloseIOABValue() {
        this(0, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598599);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoStopCloseIOABValue a() {
            return (VideoStopCloseIOABValue) VideoStopCloseIOABValue.b.getValue();
        }
    }

    static {
        Lazy<VideoStopCloseIOABValue> lazy;
        Covode.recordClassIndex(598598);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.h3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoStopCloseIOABValue d;
                d = VideoStopCloseIOABValue.d();
                return d;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoStopCloseIOABValue d() {
        return (VideoStopCloseIOABValue) qq3.a.a("video_stop_close_v637", new VideoStopCloseIOABValue(0, 1, null), true);
    }

    public final boolean c() {
        int i = this.type;
        if (i == 1) {
            return true;
        }
        if (i == 2 && ShortSeriesApi.Companion.c().isNowInHotTime()) {
            return true;
        }
        return false;
    }

    public VideoStopCloseIOABValue(int i) {
        this.type = i;
    }

    public /* synthetic */ VideoStopCloseIOABValue(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
