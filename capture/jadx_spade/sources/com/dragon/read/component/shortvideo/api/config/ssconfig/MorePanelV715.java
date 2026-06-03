package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MorePanelV715 {
    public static final a a;
    private static final Lazy<MorePanelV715> b;

    @SerializedName("item_order_list")
    public final List<String> itemOrderList;

    @SerializedName("legacyEnableHeightChange")
    public final Boolean legacyEnableHeightChange;

    @SerializedName("legacyPanelStyle")
    public final Integer legacyPanelStyle;

    @SerializedName("panelStyle")
    public final int panelStyle;

    public MorePanelV715() {
        this(0, null, null, null, 15, null);
    }

    public final boolean c() {
        if (this.panelStyle == 1) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        if (this.panelStyle != 0) {
            return true;
        }
        return false;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(598391);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MorePanelV715 a() {
            return (MorePanelV715) MorePanelV715.b.getValue();
        }
    }

    public final boolean d() {
        if (this.panelStyle == 2) {
            return true;
        }
        return false;
    }

    public final boolean h() {
        Boolean bool = this.legacyEnableHeightChange;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    static {
        Lazy<MorePanelV715> lazy;
        Covode.recordClassIndex(598390);
        a = new a(null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: com.dragon.read.component.shortvideo.api.config.ssconfig.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MorePanelV715 g;
                g = MorePanelV715.g();
                return g;
            }
        });
        b = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MorePanelV715 g() {
        return (MorePanelV715) qq3.a.c("short_viedo_panel_style_opt_v719", new MorePanelV715(0, null, null, null, 15, null), false, 4, null);
    }

    public final boolean e() {
        Integer num = this.legacyPanelStyle;
        if (num != null && (num == null || num.intValue() != 0)) {
            return true;
        }
        return false;
    }

    public MorePanelV715(int i, List<String> itemOrderList, Integer num, Boolean bool) {
        Intrinsics.checkNotNullParameter(itemOrderList, "itemOrderList");
        this.panelStyle = i;
        this.itemOrderList = itemOrderList;
        this.legacyPanelStyle = num;
        this.legacyEnableHeightChange = bool;
    }

    public /* synthetic */ MorePanelV715(int i, List list, Integer num, Boolean bool, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : bool);
    }
}
