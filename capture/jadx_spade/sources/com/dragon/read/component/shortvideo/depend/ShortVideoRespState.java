package com.dragon.read.component.shortvideo.depend;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ShortVideoRespState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ShortVideoRespState[] $VALUES;
    public static final ShortVideoRespState DEFAULT;
    public static final ShortVideoRespState NOT_SET;
    public static final ShortVideoRespState SUCCESS;
    public static final ShortVideoRespState THROWABLE;

    private static final /* synthetic */ ShortVideoRespState[] $values() {
        return new ShortVideoRespState[]{NOT_SET, DEFAULT, SUCCESS, THROWABLE};
    }

    public static EnumEntries<ShortVideoRespState> getEntries() {
        return $ENTRIES;
    }

    public static ShortVideoRespState[] values() {
        return (ShortVideoRespState[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(599167);
        NOT_SET = new ShortVideoRespState("NOT_SET", 0);
        DEFAULT = new ShortVideoRespState("DEFAULT", 1);
        SUCCESS = new ShortVideoRespState("SUCCESS", 2);
        THROWABLE = new ShortVideoRespState("THROWABLE", 3);
        ShortVideoRespState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ShortVideoRespState valueOf(String str) {
        return (ShortVideoRespState) Enum.valueOf(ShortVideoRespState.class, str);
    }

    private ShortVideoRespState(String str, int i) {
    }
}
