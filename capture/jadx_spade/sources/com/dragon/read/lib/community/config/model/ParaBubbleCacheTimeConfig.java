package com.dragon.read.lib.community.config.model;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ParaBubbleCacheTimeConfig implements Serializable {
    public static final int $stable;
    public static final a Companion;
    private static final long serialVersionUID = 0;

    @SerializedName("max_publish_time_cache_hour")
    public final int maxPublishTimeCacheHour;

    @SerializedName("no_publish_time_cache_hour")
    public final int noPublishTimeCacheHour;

    @SerializedName("publish_time_config")
    public final List<ConfigItem> publishTimeConfig;

    public static final class a {
        static {
            Covode.recordClassIndex(611356);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(611355);
        Companion = new a(null);
        $stable = 8;
    }

    public ParaBubbleCacheTimeConfig(List<ConfigItem> publishTimeConfig, int i, int i2) {
        Intrinsics.checkNotNullParameter(publishTimeConfig, "publishTimeConfig");
        this.publishTimeConfig = publishTimeConfig;
        this.maxPublishTimeCacheHour = i;
        this.noPublishTimeCacheHour = i2;
    }
}
