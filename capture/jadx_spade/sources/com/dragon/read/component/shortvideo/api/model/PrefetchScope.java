package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PrefetchScope {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PrefetchScope[] $VALUES;
    public static final PrefetchScope BOOKSTORE;
    public static final PrefetchScope OTHER;
    public static final PrefetchScope PROFILE;
    public static final PrefetchScope SINGLE_FEED;
    private final String scope;

    private static final /* synthetic */ PrefetchScope[] $values() {
        return new PrefetchScope[]{SINGLE_FEED, BOOKSTORE, PROFILE, OTHER};
    }

    public static EnumEntries<PrefetchScope> getEntries() {
        return $ENTRIES;
    }

    public final String getScope() {
        return this.scope;
    }

    public static PrefetchScope[] values() {
        return (PrefetchScope[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598783);
        SINGLE_FEED = new PrefetchScope("SINGLE_FEED", 0, "single_feed");
        BOOKSTORE = new PrefetchScope("BOOKSTORE", 1, "bookstore");
        PROFILE = new PrefetchScope("PROFILE", 2, "profile");
        OTHER = new PrefetchScope("OTHER", 3, "other");
        PrefetchScope[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PrefetchScope valueOf(String str) {
        return (PrefetchScope) Enum.valueOf(PrefetchScope.class, str);
    }

    private PrefetchScope(String str, int i, String str2) {
        this.scope = str2;
    }
}
