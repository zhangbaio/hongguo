package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class EnableVideoFeedLeftSlideGesture {
    public static final a a;
    private static final Lazy<EnableVideoFeedLeftSlideGesture> b;

    @SerializedName("enable")
    public final boolean enable;

    public EnableVideoFeedLeftSlideGesture() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598347);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return b().enable;
        }

        private final EnableVideoFeedLeftSlideGesture b() {
            return (EnableVideoFeedLeftSlideGesture) EnableVideoFeedLeftSlideGesture.b.getValue();
        }
    }

    static {
        Lazy<EnableVideoFeedLeftSlideGesture> lazy;
        Covode.recordClassIndex(598346);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                EnableVideoFeedLeftSlideGesture c;
                c = EnableVideoFeedLeftSlideGesture.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EnableVideoFeedLeftSlideGesture c() {
        return (EnableVideoFeedLeftSlideGesture) qq3.a.b("enable_video_feed_left_slide_gesture", new EnableVideoFeedLeftSlideGesture(false, 1, null), true);
    }

    public EnableVideoFeedLeftSlideGesture(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ EnableVideoFeedLeftSlideGesture(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
