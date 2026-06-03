package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.consts.HolderType;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PlayerInteractiveWidgetOptABValue {
    public static final a a;
    private static final Lazy<PlayerInteractiveWidgetOptABValue> b;

    @SerializedName("outer_enter_episode_in_center")
    public final boolean outerEnterEpisodeInCenter;

    public PlayerInteractiveWidgetOptABValue() {
        this(false, 1, null);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598413);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayerInteractiveWidgetOptABValue a() {
            return (PlayerInteractiveWidgetOptABValue) PlayerInteractiveWidgetOptABValue.b.getValue();
        }

        public final boolean b(int i, HolderType holderType, SaasVideoData saasVideoData) {
            boolean z;
            if (holderType == HolderType.PUGC_VIDEO) {
                return false;
            }
            if ((holderType != HolderType.PUGC_SERIES || i != 0) && i != 1 && i != 2 && i != 7 && i != 8 && i != 5) {
                if (saasVideoData != null && saasVideoData.isSlideToNewRecommendFeed()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return false;
                }
            }
            return true;
        }

        public static /* synthetic */ boolean c(a aVar, int i, HolderType holderType, SaasVideoData saasVideoData, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                saasVideoData = null;
            }
            return aVar.b(i, holderType, saasVideoData);
        }
    }

    static {
        Lazy<PlayerInteractiveWidgetOptABValue> lazy;
        Covode.recordClassIndex(598412);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.n0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlayerInteractiveWidgetOptABValue c;
                c = PlayerInteractiveWidgetOptABValue.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerInteractiveWidgetOptABValue c() {
        return (PlayerInteractiveWidgetOptABValue) qq3.a.a("player_interactive_widget_opt_v663", new PlayerInteractiveWidgetOptABValue(false, 1, null), true);
    }

    public PlayerInteractiveWidgetOptABValue(boolean z) {
        this.outerEnterEpisodeInCenter = z;
    }

    public /* synthetic */ PlayerInteractiveWidgetOptABValue(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
