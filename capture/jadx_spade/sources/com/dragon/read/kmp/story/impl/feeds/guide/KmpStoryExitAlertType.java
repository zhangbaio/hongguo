package com.dragon.read.kmp.story.impl.feeds.guide;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpStoryExitAlertType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ KmpStoryExitAlertType[] $VALUES;
    public static final KmpStoryExitAlertType NONE;
    public static final KmpStoryExitAlertType V2;

    private static final /* synthetic */ KmpStoryExitAlertType[] $values() {
        return new KmpStoryExitAlertType[]{NONE, V2};
    }

    public static EnumEntries<KmpStoryExitAlertType> getEntries() {
        return $ENTRIES;
    }

    public static KmpStoryExitAlertType[] values() {
        return (KmpStoryExitAlertType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609292);
        NONE = new KmpStoryExitAlertType("NONE", 0);
        V2 = new KmpStoryExitAlertType("V2", 1);
        KmpStoryExitAlertType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static KmpStoryExitAlertType valueOf(String str) {
        return (KmpStoryExitAlertType) Enum.valueOf(KmpStoryExitAlertType.class, str);
    }

    private KmpStoryExitAlertType(String str, int i) {
    }
}
