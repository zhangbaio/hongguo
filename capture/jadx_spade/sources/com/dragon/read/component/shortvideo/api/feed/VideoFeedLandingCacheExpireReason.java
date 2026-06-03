package com.dragon.read.component.shortvideo.api.feed;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class VideoFeedLandingCacheExpireReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VideoFeedLandingCacheExpireReason[] $VALUES;
    public static final VideoFeedLandingCacheExpireReason NETWORK_EXPIRED_LOCAL_EXPIRED;
    public static final VideoFeedLandingCacheExpireReason NETWORK_EXPIRED_NO_LOCAL;
    public static final VideoFeedLandingCacheExpireReason NONE;
    public static final VideoFeedLandingCacheExpireReason NO_NETWORK_LOCAL_EXPIRED;
    public static final VideoFeedLandingCacheExpireReason NO_NETWORK_NO_LOCAL;
    private final int value;

    private static final /* synthetic */ VideoFeedLandingCacheExpireReason[] $values() {
        return new VideoFeedLandingCacheExpireReason[]{NONE, NO_NETWORK_NO_LOCAL, NETWORK_EXPIRED_NO_LOCAL, NO_NETWORK_LOCAL_EXPIRED, NETWORK_EXPIRED_LOCAL_EXPIRED};
    }

    public static EnumEntries<VideoFeedLandingCacheExpireReason> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static VideoFeedLandingCacheExpireReason[] values() {
        return (VideoFeedLandingCacheExpireReason[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598740);
        NONE = new VideoFeedLandingCacheExpireReason("NONE", 0, 0);
        NO_NETWORK_NO_LOCAL = new VideoFeedLandingCacheExpireReason("NO_NETWORK_NO_LOCAL", 1, 1);
        NETWORK_EXPIRED_NO_LOCAL = new VideoFeedLandingCacheExpireReason("NETWORK_EXPIRED_NO_LOCAL", 2, 2);
        NO_NETWORK_LOCAL_EXPIRED = new VideoFeedLandingCacheExpireReason("NO_NETWORK_LOCAL_EXPIRED", 3, 3);
        NETWORK_EXPIRED_LOCAL_EXPIRED = new VideoFeedLandingCacheExpireReason("NETWORK_EXPIRED_LOCAL_EXPIRED", 4, 4);
        VideoFeedLandingCacheExpireReason[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static VideoFeedLandingCacheExpireReason valueOf(String str) {
        return (VideoFeedLandingCacheExpireReason) Enum.valueOf(VideoFeedLandingCacheExpireReason.class, str);
    }

    private VideoFeedLandingCacheExpireReason(String str, int i, int i2) {
        this.value = i2;
    }
}
