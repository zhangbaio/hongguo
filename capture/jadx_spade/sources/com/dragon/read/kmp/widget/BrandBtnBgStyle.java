package com.dragon.read.kmp.widget;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BrandBtnBgStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BrandBtnBgStyle[] $VALUES;
    public static final BrandBtnBgStyle BRAND_FORCE_GRADIENT;
    public static final BrandBtnBgStyle BRAND_GRADIENT;
    public static final BrandBtnBgStyle BRAND_PURE;
    public static final BrandBtnBgStyle BRAND_PURE_10;

    private static final /* synthetic */ BrandBtnBgStyle[] $values() {
        return new BrandBtnBgStyle[]{BRAND_PURE, BRAND_PURE_10, BRAND_GRADIENT, BRAND_FORCE_GRADIENT};
    }

    public static EnumEntries<BrandBtnBgStyle> getEntries() {
        return $ENTRIES;
    }

    public static BrandBtnBgStyle[] values() {
        return (BrandBtnBgStyle[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609634);
        BRAND_PURE = new BrandBtnBgStyle("BRAND_PURE", 0);
        BRAND_PURE_10 = new BrandBtnBgStyle("BRAND_PURE_10", 1);
        BRAND_GRADIENT = new BrandBtnBgStyle("BRAND_GRADIENT", 2);
        BRAND_FORCE_GRADIENT = new BrandBtnBgStyle("BRAND_FORCE_GRADIENT", 3);
        BrandBtnBgStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static BrandBtnBgStyle valueOf(String str) {
        return (BrandBtnBgStyle) Enum.valueOf(BrandBtnBgStyle.class, str);
    }

    private BrandBtnBgStyle(String str, int i) {
    }
}
