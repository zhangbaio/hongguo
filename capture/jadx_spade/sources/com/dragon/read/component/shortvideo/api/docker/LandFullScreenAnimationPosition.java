package com.dragon.read.component.shortvideo.api.docker;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class LandFullScreenAnimationPosition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LandFullScreenAnimationPosition[] $VALUES;
    public static final LandFullScreenAnimationPosition ANIMATION_BOTTOM;
    public static final LandFullScreenAnimationPosition ANIMATION_MIDDLE_LEFT_END;
    public static final LandFullScreenAnimationPosition ANIMATION_TOP;
    public static final LandFullScreenAnimationPosition BEST_TOP_POSITION;
    public static final LandFullScreenAnimationPosition CUSTOM_LAYOUT_PARAM_COMPONENT_AREA;
    public static final LandFullScreenAnimationPosition DANMAKU_POSITION;
    public static final LandFullScreenAnimationPosition FULL_SCREEN_POSITION;
    public static final LandFullScreenAnimationPosition SEEK_BAR_RIGHT_AREA;
    public static final LandFullScreenAnimationPosition SEEK_BAR_TOP_AREA;
    private final String animationPosition;

    private static final /* synthetic */ LandFullScreenAnimationPosition[] $values() {
        return new LandFullScreenAnimationPosition[]{ANIMATION_TOP, ANIMATION_BOTTOM, ANIMATION_MIDDLE_LEFT_END, BEST_TOP_POSITION, DANMAKU_POSITION, SEEK_BAR_RIGHT_AREA, FULL_SCREEN_POSITION, SEEK_BAR_TOP_AREA, CUSTOM_LAYOUT_PARAM_COMPONENT_AREA};
    }

    public static EnumEntries<LandFullScreenAnimationPosition> getEntries() {
        return $ENTRIES;
    }

    public final String getAnimationPosition() {
        return this.animationPosition;
    }

    public static LandFullScreenAnimationPosition[] values() {
        return (LandFullScreenAnimationPosition[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598653);
        ANIMATION_TOP = new LandFullScreenAnimationPosition("ANIMATION_TOP", 0, "animation_top");
        ANIMATION_BOTTOM = new LandFullScreenAnimationPosition("ANIMATION_BOTTOM", 1, "animation_bottom");
        ANIMATION_MIDDLE_LEFT_END = new LandFullScreenAnimationPosition("ANIMATION_MIDDLE_LEFT_END", 2, "animation_middle_left_end");
        BEST_TOP_POSITION = new LandFullScreenAnimationPosition("BEST_TOP_POSITION", 3, "best_top_position");
        DANMAKU_POSITION = new LandFullScreenAnimationPosition("DANMAKU_POSITION", 4, "danmaku_position");
        SEEK_BAR_RIGHT_AREA = new LandFullScreenAnimationPosition("SEEK_BAR_RIGHT_AREA", 5, "seek_bar_right_area");
        FULL_SCREEN_POSITION = new LandFullScreenAnimationPosition("FULL_SCREEN_POSITION", 6, "full_screen_position");
        SEEK_BAR_TOP_AREA = new LandFullScreenAnimationPosition("SEEK_BAR_TOP_AREA", 7, "seek_bar_top_area");
        CUSTOM_LAYOUT_PARAM_COMPONENT_AREA = new LandFullScreenAnimationPosition("CUSTOM_LAYOUT_PARAM_COMPONENT_AREA", 8, "custom_layout_param_component_area");
        LandFullScreenAnimationPosition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static LandFullScreenAnimationPosition valueOf(String str) {
        return (LandFullScreenAnimationPosition) Enum.valueOf(LandFullScreenAnimationPosition.class, str);
    }

    private LandFullScreenAnimationPosition(String str, int i, String str2) {
        this.animationPosition = str2;
    }
}
