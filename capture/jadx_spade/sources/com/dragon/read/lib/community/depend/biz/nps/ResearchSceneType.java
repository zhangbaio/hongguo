package com.dragon.read.lib.community.depend.biz.nps;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ResearchSceneType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ResearchSceneType[] $VALUES;
    public static final ResearchSceneType AfterReadAIComment;
    public static final ResearchSceneType AfterUseAIGenImage;
    public static final ResearchSceneType IdeaCommentList;
    private final int value;

    private static final /* synthetic */ ResearchSceneType[] $values() {
        return new ResearchSceneType[]{IdeaCommentList, AfterUseAIGenImage, AfterReadAIComment};
    }

    public static EnumEntries<ResearchSceneType> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static ResearchSceneType[] values() {
        return (ResearchSceneType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(611442);
        IdeaCommentList = new ResearchSceneType("IdeaCommentList", 0, 6);
        AfterUseAIGenImage = new ResearchSceneType("AfterUseAIGenImage", 1, 16);
        AfterReadAIComment = new ResearchSceneType("AfterReadAIComment", 2, 17);
        ResearchSceneType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ResearchSceneType valueOf(String str) {
        return (ResearchSceneType) Enum.valueOf(ResearchSceneType.class, str);
    }

    private ResearchSceneType(String str, int i, int i2) {
        this.value = i2;
    }
}
