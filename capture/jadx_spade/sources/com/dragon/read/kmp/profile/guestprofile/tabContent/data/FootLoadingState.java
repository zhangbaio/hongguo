package com.dragon.read.kmp.profile.guestprofile.tabContent.data;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class FootLoadingState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FootLoadingState[] $VALUES;
    public static final FootLoadingState ERROR;
    public static final FootLoadingState GONE;
    public static final FootLoadingState INIT;
    public static final FootLoadingState LOADING;
    public static final FootLoadingState NOT_MORE;
    private final int value;

    private static final /* synthetic */ FootLoadingState[] $values() {
        return new FootLoadingState[]{GONE, INIT, LOADING, ERROR, NOT_MORE};
    }

    public static EnumEntries<FootLoadingState> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static FootLoadingState[] values() {
        return (FootLoadingState[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608147);
        GONE = new FootLoadingState("GONE", 0, 0);
        INIT = new FootLoadingState("INIT", 1, 1);
        LOADING = new FootLoadingState("LOADING", 2, 2);
        ERROR = new FootLoadingState("ERROR", 3, 3);
        NOT_MORE = new FootLoadingState("NOT_MORE", 4, 4);
        FootLoadingState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static FootLoadingState valueOf(String str) {
        return (FootLoadingState) Enum.valueOf(FootLoadingState.class, str);
    }

    private FootLoadingState(String str, int i, int i2) {
        this.value = i2;
    }
}
