package com.dragon.read.kmp.shortvideo.distribution.page.search;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesRankSearchUiState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SeriesRankSearchUiState[] $VALUES;
    public static final SeriesRankSearchUiState Data;
    public static final SeriesRankSearchUiState Empty;
    public static final SeriesRankSearchUiState Error;
    public static final SeriesRankSearchUiState Loading;
    public static final SeriesRankSearchUiState Ready;

    private static final /* synthetic */ SeriesRankSearchUiState[] $values() {
        return new SeriesRankSearchUiState[]{Ready, Loading, Empty, Error, Data};
    }

    public static EnumEntries<SeriesRankSearchUiState> getEntries() {
        return $ENTRIES;
    }

    public static SeriesRankSearchUiState[] values() {
        return (SeriesRankSearchUiState[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609068);
        Ready = new SeriesRankSearchUiState("Ready", 0);
        Loading = new SeriesRankSearchUiState("Loading", 1);
        Empty = new SeriesRankSearchUiState("Empty", 2);
        Error = new SeriesRankSearchUiState("Error", 3);
        Data = new SeriesRankSearchUiState("Data", 4);
        SeriesRankSearchUiState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SeriesRankSearchUiState valueOf(String str) {
        return (SeriesRankSearchUiState) Enum.valueOf(SeriesRankSearchUiState.class, str);
    }

    private SeriesRankSearchUiState(String str, int i) {
    }
}
