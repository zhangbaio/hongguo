package com.dragon.read.kmp.profile;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SeriesGuestProfileUserType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SeriesGuestProfileUserType[] $VALUES;
    public static final SeriesGuestProfileUserType TYPE_ACTOR;
    public static final SeriesGuestProfileUserType TYPE_BRAND;
    public static final SeriesGuestProfileUserType TYPE_DIRECTOR;
    public static final SeriesGuestProfileUserType TYPE_NONE;
    public static final SeriesGuestProfileUserType TYPE_NORMAL_USER;
    private final int value;

    private static final /* synthetic */ SeriesGuestProfileUserType[] $values() {
        return new SeriesGuestProfileUserType[]{TYPE_NONE, TYPE_NORMAL_USER, TYPE_BRAND, TYPE_ACTOR, TYPE_DIRECTOR};
    }

    public static EnumEntries<SeriesGuestProfileUserType> getEntries() {
        return $ENTRIES;
    }

    public final int getValue() {
        return this.value;
    }

    public static SeriesGuestProfileUserType[] values() {
        return (SeriesGuestProfileUserType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608019);
        TYPE_NONE = new SeriesGuestProfileUserType("TYPE_NONE", 0, -1);
        TYPE_NORMAL_USER = new SeriesGuestProfileUserType("TYPE_NORMAL_USER", 1, 0);
        TYPE_BRAND = new SeriesGuestProfileUserType("TYPE_BRAND", 2, 1);
        TYPE_ACTOR = new SeriesGuestProfileUserType("TYPE_ACTOR", 3, 2);
        TYPE_DIRECTOR = new SeriesGuestProfileUserType("TYPE_DIRECTOR", 4, 3);
        SeriesGuestProfileUserType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SeriesGuestProfileUserType valueOf(String str) {
        return (SeriesGuestProfileUserType) Enum.valueOf(SeriesGuestProfileUserType.class, str);
    }

    private SeriesGuestProfileUserType(String str, int i, int i2) {
        this.value = i2;
    }
}
