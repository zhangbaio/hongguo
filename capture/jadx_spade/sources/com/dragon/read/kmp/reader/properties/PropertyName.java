package com.dragon.read.kmp.reader.properties;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PropertyName {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PropertyName[] $VALUES;
    public static final PropertyName Background;
    public static final PropertyName Font;
    public static final PropertyName LineSpacing;
    public static final PropertyName PageTurnMode;
    public static final PropertyName Setting;
    public static final PropertyName Theme;

    private static final /* synthetic */ PropertyName[] $values() {
        return new PropertyName[]{Theme, Background, PageTurnMode, LineSpacing, Font, Setting};
    }

    public static EnumEntries<PropertyName> getEntries() {
        return $ENTRIES;
    }

    public static PropertyName[] values() {
        return (PropertyName[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608492);
        Theme = new PropertyName("Theme", 0);
        Background = new PropertyName("Background", 1);
        PageTurnMode = new PropertyName("PageTurnMode", 2);
        LineSpacing = new PropertyName("LineSpacing", 3);
        Font = new PropertyName("Font", 4);
        Setting = new PropertyName("Setting", 5);
        PropertyName[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PropertyName valueOf(String str) {
        return (PropertyName) Enum.valueOf(PropertyName.class, str);
    }

    private PropertyName(String str, int i) {
    }
}
