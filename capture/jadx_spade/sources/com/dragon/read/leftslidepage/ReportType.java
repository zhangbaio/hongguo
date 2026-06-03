package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ReportType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReportType[] $VALUES;
    public static final ReportType Follow;
    public static final ReportType Func;
    public static final ReportType Game;
    public static final ReportType Msg;
    public static final ReportType RecentWatch;
    public static final ReportType Subscribe;
    public static final ReportType User;

    private static final /* synthetic */ ReportType[] $values() {
        return new ReportType[]{Func, Msg, Game, User, RecentWatch, Subscribe, Follow};
    }

    public static EnumEntries<ReportType> getEntries() {
        return $ENTRIES;
    }

    public static ReportType[] values() {
        return (ReportType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(611252);
        Func = new ReportType("Func", 0);
        Msg = new ReportType("Msg", 1);
        Game = new ReportType("Game", 2);
        User = new ReportType("User", 3);
        RecentWatch = new ReportType("RecentWatch", 4);
        Subscribe = new ReportType("Subscribe", 5);
        Follow = new ReportType("Follow", 6);
        ReportType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ReportType valueOf(String str) {
        return (ReportType) Enum.valueOf(ReportType.class, str);
    }

    private ReportType(String str, int i) {
    }
}
