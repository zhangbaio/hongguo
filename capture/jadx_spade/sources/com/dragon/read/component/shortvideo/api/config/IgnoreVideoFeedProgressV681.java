package com.dragon.read.component.shortvideo.api.config;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.IgnoreVideoFeedProgressV681;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class IgnoreVideoFeedProgressV681 {
    public static final a a;
    private static final Lazy<IgnoreVideoFeedProgressV681> b;

    @SerializedName("enable")
    public final boolean enable;

    public IgnoreVideoFeedProgressV681() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598227);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IgnoreVideoFeedProgressV681 a() {
            return (IgnoreVideoFeedProgressV681) IgnoreVideoFeedProgressV681.b.getValue();
        }
    }

    static {
        Lazy<IgnoreVideoFeedProgressV681> lazy;
        Covode.recordClassIndex(598226);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: pq3.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IgnoreVideoFeedProgressV681 c;
                c = IgnoreVideoFeedProgressV681.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IgnoreVideoFeedProgressV681 c() {
        return (IgnoreVideoFeedProgressV681) qq3.a.c("ignore_video_feed_progress_681", new IgnoreVideoFeedProgressV681(false, 1, null), false, 4, null);
    }

    public IgnoreVideoFeedProgressV681(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ IgnoreVideoFeedProgressV681(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
