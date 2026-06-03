package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProgressAnimationOptV689 {
    public static final a a;
    private static final Lazy<ProgressAnimationOptV689> b;

    @SerializedName("enable")
    public final boolean enable;

    @SerializedName("is_30_fps")
    public final boolean is30Fps;

    @SerializedName("limit_playrate")
    public final int limitPlayRate;

    @SerializedName("max_video_duration")
    public final int maxVideoDuration;

    public ProgressAnimationOptV689() {
        this(false, 0, 0, false, 15, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598440);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProgressAnimationOptV689 a() {
            return (ProgressAnimationOptV689) ProgressAnimationOptV689.b.getValue();
        }

        public final boolean b(int i, int i2) {
            if (!a().enable || i > a().maxVideoDuration * 1000) {
                return false;
            }
            if (i2 > a().limitPlayRate * 100 && a().limitPlayRate != -1) {
                return false;
            }
            return true;
        }
    }

    static {
        Lazy<ProgressAnimationOptV689> lazy;
        Covode.recordClassIndex(598439);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.y0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ProgressAnimationOptV689 c;
                c = ProgressAnimationOptV689.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProgressAnimationOptV689 c() {
        return (ProgressAnimationOptV689) qq3.a.c("progress_animation_opt_689", new ProgressAnimationOptV689(false, 0, 0, false, 15, null), false, 4, null);
    }

    public ProgressAnimationOptV689(boolean z, int i, int i2, boolean z2) {
        this.enable = z;
        this.maxVideoDuration = i;
        this.limitPlayRate = i2;
        this.is30Fps = z2;
    }

    public /* synthetic */ ProgressAnimationOptV689(boolean z, int i, int i2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 900 : i, (i3 & 4) != 0 ? -1 : i2, (i3 & 8) != 0 ? false : z2);
    }
}
