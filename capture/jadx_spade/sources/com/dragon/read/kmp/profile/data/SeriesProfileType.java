package com.dragon.read.kmp.profile.data;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesProfileType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SeriesProfileType[] $VALUES;
    public static final SeriesProfileType ACTOR;
    public static final SeriesProfileType DIRECTOR;
    public static final SeriesProfileType MCN;
    public static final SeriesProfileType NONE;
    public static final SeriesProfileType SCREENWRITER;
    public static final SeriesProfileType USER;
    private final String value;

    private static final /* synthetic */ SeriesProfileType[] $values() {
        return new SeriesProfileType[]{NONE, ACTOR, DIRECTOR, SCREENWRITER, MCN, USER};
    }

    public static EnumEntries<SeriesProfileType> getEntries() {
        return $ENTRIES;
    }

    public final String getValue() {
        return this.value;
    }

    public static SeriesProfileType[] values() {
        return (SeriesProfileType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608083);
        NONE = new SeriesProfileType("NONE", 0, "none");
        ACTOR = new SeriesProfileType("ACTOR", 1, "actor");
        DIRECTOR = new SeriesProfileType("DIRECTOR", 2, "director");
        SCREENWRITER = new SeriesProfileType("SCREENWRITER", 3, "screenwriter");
        MCN = new SeriesProfileType("MCN", 4, "mcn");
        USER = new SeriesProfileType("USER", 5, "user");
        SeriesProfileType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SeriesProfileType valueOf(String str) {
        return (SeriesProfileType) Enum.valueOf(SeriesProfileType.class, str);
    }

    private SeriesProfileType(String str, int i, String str2) {
        this.value = str2;
    }
}
