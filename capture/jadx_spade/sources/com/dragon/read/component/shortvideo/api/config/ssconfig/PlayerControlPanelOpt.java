package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.api.config.base.ISeriesAbValueApi;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PlayerControlPanelOpt {
    public static final a a;
    private static final Lazy<PlayerControlPanelOpt> b;

    @SerializedName("playrate_list")
    public final List<Float> playrateList;

    @SerializedName("use_new_option_item_style")
    public final boolean useNewOptionItemStyle;

    /* JADX WARN: Multi-variable type inference failed */
    public PlayerControlPanelOpt() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598407);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PlayerControlPanelOpt a() {
            return (PlayerControlPanelOpt) PlayerControlPanelOpt.b.getValue();
        }
    }

    static {
        Lazy<PlayerControlPanelOpt> lazy;
        Covode.recordClassIndex(598406);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.m0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlayerControlPanelOpt c;
                c = PlayerControlPanelOpt.c();
                return c;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final PlayerControlPanelOpt c() {
        return (PlayerControlPanelOpt) ISeriesAbValueApi.CC.getABValue2$default(ISeriesAbValueApi.Companion.c(), "player_control_panel_opt_v645", new PlayerControlPanelOpt(null, false, 3, 0 == true ? 1 : 0), false, 4, null);
    }

    public PlayerControlPanelOpt(List<Float> playrateList, boolean z) {
        Intrinsics.checkNotNullParameter(playrateList, "playrateList");
        this.playrateList = playrateList;
        this.useNewOptionItemStyle = z;
    }

    public /* synthetic */ PlayerControlPanelOpt(List list, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt__CollectionsKt.arrayListOf(Float.valueOf(0.75f), Float.valueOf(1.0f), Float.valueOf(1.25f), Float.valueOf(1.5f), Float.valueOf(1.75f), Float.valueOf(2.0f)) : list, (i & 2) != 0 ? false : z);
    }
}
