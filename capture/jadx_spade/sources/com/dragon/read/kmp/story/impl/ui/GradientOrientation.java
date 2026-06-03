package com.dragon.read.kmp.story.impl.ui;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class GradientOrientation {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GradientOrientation[] $VALUES;
    public static final GradientOrientation BOTTOM_TO_TOP;
    public static final GradientOrientation LEFT_TO_RIGHT;
    public static final GradientOrientation RIGHT_TO_LEFT;
    public static final GradientOrientation TOP_TO_BOTTOM;

    private static final /* synthetic */ GradientOrientation[] $values() {
        return new GradientOrientation[]{LEFT_TO_RIGHT, TOP_TO_BOTTOM, RIGHT_TO_LEFT, BOTTOM_TO_TOP};
    }

    public static EnumEntries<GradientOrientation> getEntries() {
        return $ENTRIES;
    }

    public static GradientOrientation[] values() {
        return (GradientOrientation[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609418);
        LEFT_TO_RIGHT = new GradientOrientation("LEFT_TO_RIGHT", 0);
        TOP_TO_BOTTOM = new GradientOrientation("TOP_TO_BOTTOM", 1);
        RIGHT_TO_LEFT = new GradientOrientation("RIGHT_TO_LEFT", 2);
        BOTTOM_TO_TOP = new GradientOrientation("BOTTOM_TO_TOP", 3);
        GradientOrientation[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static GradientOrientation valueOf(String str) {
        return (GradientOrientation) Enum.valueOf(GradientOrientation.class, str);
    }

    private GradientOrientation(String str, int i) {
    }
}
