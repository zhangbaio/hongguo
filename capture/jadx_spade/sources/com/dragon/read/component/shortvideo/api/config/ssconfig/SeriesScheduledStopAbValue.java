package com.dragon.read.component.shortvideo.api.config.ssconfig;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SeriesScheduledStopAbValue {

    @SerializedName("enable_scheduled")
    public final boolean enableScheduled;

    @SerializedName("loop_ad_3_min")
    public final boolean loopAd3Min;

    @SerializedName("more_panel_style")
    public final int morePanelStyle;

    static {
        Covode.recordClassIndex(598502);
    }

    public SeriesScheduledStopAbValue() {
        this(false, 0, false, 7, null);
    }

    public SeriesScheduledStopAbValue(boolean z, int i, boolean z2) {
        this.enableScheduled = z;
        this.morePanelStyle = i;
        this.loopAd3Min = z2;
    }

    public /* synthetic */ SeriesScheduledStopAbValue(boolean z, int i, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z2);
    }
}
