package com.dragon.read.kmp.widget;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class CommonLayoutState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CommonLayoutState[] $VALUES;
    public static final CommonLayoutState Empty;
    public static final CommonLayoutState Failed;
    public static final CommonLayoutState Init;
    public static final CommonLayoutState Loading;
    public static final CommonLayoutState Success;

    private static final /* synthetic */ CommonLayoutState[] $values() {
        return new CommonLayoutState[]{Init, Loading, Success, Failed, Empty};
    }

    public static EnumEntries<CommonLayoutState> getEntries() {
        return $ENTRIES;
    }

    public static CommonLayoutState[] values() {
        return (CommonLayoutState[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609642);
        Init = new CommonLayoutState("Init", 0);
        Loading = new CommonLayoutState("Loading", 1);
        Success = new CommonLayoutState("Success", 2);
        Failed = new CommonLayoutState("Failed", 3);
        Empty = new CommonLayoutState("Empty", 4);
        CommonLayoutState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static CommonLayoutState valueOf(String str) {
        return (CommonLayoutState) Enum.valueOf(CommonLayoutState.class, str);
    }

    private CommonLayoutState(String str, int i) {
    }
}
