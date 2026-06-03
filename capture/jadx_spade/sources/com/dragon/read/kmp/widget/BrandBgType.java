package com.dragon.read.kmp.widget;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BrandBgType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BrandBgType[] $VALUES;
    public static final BrandBgType Fanqie;
    public static final BrandBgType FanqieWithDark;
    public static final BrandBgType Hongguo;

    private static final /* synthetic */ BrandBgType[] $values() {
        return new BrandBgType[]{Hongguo, Fanqie, FanqieWithDark};
    }

    public static EnumEntries<BrandBgType> getEntries() {
        return $ENTRIES;
    }

    public static BrandBgType[] values() {
        return (BrandBgType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609631);
        Hongguo = new BrandBgType("Hongguo", 0);
        Fanqie = new BrandBgType("Fanqie", 1);
        FanqieWithDark = new BrandBgType("FanqieWithDark", 2);
        BrandBgType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static BrandBgType valueOf(String str) {
        return (BrandBgType) Enum.valueOf(BrandBgType.class, str);
    }

    private BrandBgType(String str, int i) {
    }
}
