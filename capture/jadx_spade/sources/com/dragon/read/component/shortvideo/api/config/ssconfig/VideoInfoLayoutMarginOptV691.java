package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.ssconfig.SingleFeedMarginConfigV711;
import com.dragon.read.util.kotlin.UIKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoInfoLayoutMarginOptV691 {
    public static final a a;
    private static final Lazy<VideoInfoLayoutMarginOptV691> b;

    @SerializedName("style")
    public final int style;

    public VideoInfoLayoutMarginOptV691() {
        this(0, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598575);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final VideoInfoLayoutMarginOptV691 c() {
            return (VideoInfoLayoutMarginOptV691) VideoInfoLayoutMarginOptV691.b.getValue();
        }

        public final boolean a() {
            return SingleFeedMarginConfigV711.a.a().enable;
        }

        public final boolean b() {
            if (c().style != 0) {
                return true;
            }
            return false;
        }

        public final boolean g() {
            return SingleFeedMarginConfigV711.a.a().fixRightViewLayout;
        }

        public final Integer d() {
            SingleFeedMarginConfigV711.a aVar = SingleFeedMarginConfigV711.a;
            if (aVar.a().bottomMargin > 0) {
                return Integer.valueOf(UIKt.getDp(aVar.a().bottomMargin));
            }
            return null;
        }

        public final Integer e() {
            SingleFeedMarginConfigV711.a aVar = SingleFeedMarginConfigV711.a;
            if (aVar.a().bottomMarginWithoutBottomBar > 0) {
                return Integer.valueOf(UIKt.getDp(aVar.a().bottomMarginWithoutBottomBar));
            }
            return null;
        }

        public final Integer f() {
            int i;
            Integer valueOf;
            if (PlayerBugfixV645.a.a().fixCollectionAnimCollapseIssue) {
                i = 50;
            } else {
                i = 0;
            }
            int dp = UIKt.getDp(i);
            SingleFeedMarginConfigV711.a aVar = SingleFeedMarginConfigV711.a;
            if (aVar.a().endMargin > 0) {
                return Integer.valueOf(UIKt.getDp(aVar.a().endMargin) + dp);
            }
            if (SignalColumnType.a.a().isSpaceOpt) {
                return Integer.valueOf(UIKt.getDp(54) + dp);
            }
            int i2 = c().style;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(UIKt.getDp(40));
                    }
                } else {
                    valueOf = Integer.valueOf(UIKt.getDp(48));
                }
            } else {
                valueOf = Integer.valueOf(UIKt.getDp(54));
            }
            if (valueOf == null) {
                return null;
            }
            return Integer.valueOf(valueOf.intValue() + dp);
        }
    }

    static {
        Lazy<VideoInfoLayoutMarginOptV691> lazy;
        Covode.recordClassIndex(598574);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.z2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                VideoInfoLayoutMarginOptV691 c;
                c = VideoInfoLayoutMarginOptV691.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoInfoLayoutMarginOptV691 c() {
        return (VideoInfoLayoutMarginOptV691) qq3.a.b("video_info_margin_opt_691", new VideoInfoLayoutMarginOptV691(0, 1, null), true);
    }

    public VideoInfoLayoutMarginOptV691(int i) {
        this.style = i;
    }

    public /* synthetic */ VideoInfoLayoutMarginOptV691(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
