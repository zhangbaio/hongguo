package com.dragon.read.component.shortvideo.api.model;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class PanelItemType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PanelItemType[] $VALUES;
    public static final PanelItemType BACK_TO_FIRST_GUIDE;
    public static final PanelItemType BACK_TO_SPECIFIC_EPISODE_GUIDE;
    public static final PanelItemType CLEAR_SCREEN;
    public static final PanelItemType DEFAULT_MUTE;
    public static final PanelItemType DISLIKE;
    public static final PanelItemType FILL_SCREEN;
    public static final PanelItemType FLOATING_WINDOW_SELECT;
    public static final PanelItemType LISTEN_VIDEO;
    public static final PanelItemType OTHER;
    public static final PanelItemType REPORT;
    public static final PanelItemType REPORT_SUCCESS;
    public static final PanelItemType RESOLUTION;
    public static final PanelItemType SCHEDULED_CLOSE;
    public static final PanelItemType SELECT_RESOLUTION;
    public static final PanelItemType SELECT_VIDEO_SPEED;
    public static final PanelItemType SHARE;
    public static final PanelItemType VIDEO_SPEED;

    private static final /* synthetic */ PanelItemType[] $values() {
        return new PanelItemType[]{REPORT, REPORT_SUCCESS, RESOLUTION, SELECT_RESOLUTION, VIDEO_SPEED, FILL_SCREEN, SELECT_VIDEO_SPEED, FLOATING_WINDOW_SELECT, CLEAR_SCREEN, DEFAULT_MUTE, SHARE, DISLIKE, SCHEDULED_CLOSE, BACK_TO_FIRST_GUIDE, BACK_TO_SPECIFIC_EPISODE_GUIDE, LISTEN_VIDEO, OTHER};
    }

    public static EnumEntries<PanelItemType> getEntries() {
        return $ENTRIES;
    }

    public static PanelItemType[] values() {
        return (PanelItemType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598781);
        REPORT = new PanelItemType("REPORT", 0);
        REPORT_SUCCESS = new PanelItemType("REPORT_SUCCESS", 1);
        RESOLUTION = new PanelItemType("RESOLUTION", 2);
        SELECT_RESOLUTION = new PanelItemType("SELECT_RESOLUTION", 3);
        VIDEO_SPEED = new PanelItemType("VIDEO_SPEED", 4);
        FILL_SCREEN = new PanelItemType("FILL_SCREEN", 5);
        SELECT_VIDEO_SPEED = new PanelItemType("SELECT_VIDEO_SPEED", 6);
        FLOATING_WINDOW_SELECT = new PanelItemType("FLOATING_WINDOW_SELECT", 7);
        CLEAR_SCREEN = new PanelItemType("CLEAR_SCREEN", 8);
        DEFAULT_MUTE = new PanelItemType("DEFAULT_MUTE", 9);
        SHARE = new PanelItemType("SHARE", 10);
        DISLIKE = new PanelItemType("DISLIKE", 11);
        SCHEDULED_CLOSE = new PanelItemType("SCHEDULED_CLOSE", 12);
        BACK_TO_FIRST_GUIDE = new PanelItemType("BACK_TO_FIRST_GUIDE", 13);
        BACK_TO_SPECIFIC_EPISODE_GUIDE = new PanelItemType("BACK_TO_SPECIFIC_EPISODE_GUIDE", 14);
        LISTEN_VIDEO = new PanelItemType("LISTEN_VIDEO", 15);
        OTHER = new PanelItemType("OTHER", 16);
        PanelItemType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PanelItemType valueOf(String str) {
        return (PanelItemType) Enum.valueOf(PanelItemType.class, str);
    }

    private PanelItemType(String str, int i) {
    }
}
