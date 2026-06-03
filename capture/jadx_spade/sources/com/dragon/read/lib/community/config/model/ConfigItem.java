package com.dragon.read.lib.community.config.model;

import com.bytedance.covode.number.Covode;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ConfigItem implements Serializable {
    public static final int $stable = 0;
    public static final a Companion;
    private static final long serialVersionUID = 0;

    @SerializedName("cache_hour")
    public final int cacheHour;

    @SerializedName("publish_hour")
    public final int publishHour;

    public static final class a {
        static {
            Covode.recordClassIndex(611352);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Covode.recordClassIndex(611351);
        Companion = new a(null);
    }

    public ConfigItem(int i, int i2) {
        this.publishHour = i;
        this.cacheHour = i2;
    }
}
