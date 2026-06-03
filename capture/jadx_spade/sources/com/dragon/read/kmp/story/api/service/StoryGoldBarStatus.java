package com.dragon.read.kmp.story.api.service;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class StoryGoldBarStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ StoryGoldBarStatus[] $VALUES;
    public static final StoryGoldBarStatus FINISH;
    public static final StoryGoldBarStatus HIDE;
    public static final StoryGoldBarStatus HIDE_FINISH;
    public static final StoryGoldBarStatus PROGRESS;

    private static final /* synthetic */ StoryGoldBarStatus[] $values() {
        return new StoryGoldBarStatus[]{PROGRESS, FINISH, HIDE, HIDE_FINISH};
    }

    public static EnumEntries<StoryGoldBarStatus> getEntries() {
        return $ENTRIES;
    }

    public static StoryGoldBarStatus[] values() {
        return (StoryGoldBarStatus[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609192);
        PROGRESS = new StoryGoldBarStatus("PROGRESS", 0);
        FINISH = new StoryGoldBarStatus("FINISH", 1);
        HIDE = new StoryGoldBarStatus("HIDE", 2);
        HIDE_FINISH = new StoryGoldBarStatus("HIDE_FINISH", 3);
        StoryGoldBarStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static StoryGoldBarStatus valueOf(String str) {
        return (StoryGoldBarStatus) Enum.valueOf(StoryGoldBarStatus.class, str);
    }

    private StoryGoldBarStatus(String str, int i) {
    }
}
