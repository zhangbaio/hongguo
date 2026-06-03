package com.dragon.read.leftslidepage;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SidebarSectionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SidebarSectionType[] $VALUES;
    public static final SidebarSectionType FOLLOW;
    public static final SidebarSectionType FUNCTION_LIST;
    public static final SidebarSectionType GAME;
    public static final SidebarSectionType MSG;
    public static final SidebarSectionType RECENT_WATCH;
    public static final SidebarSectionType SUBSCRIBE;

    private static final /* synthetic */ SidebarSectionType[] $values() {
        return new SidebarSectionType[]{MSG, RECENT_WATCH, GAME, FUNCTION_LIST, SUBSCRIBE, FOLLOW};
    }

    public static EnumEntries<SidebarSectionType> getEntries() {
        return $ENTRIES;
    }

    public static SidebarSectionType[] values() {
        return (SidebarSectionType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(611270);
        MSG = new SidebarSectionType("MSG", 0);
        RECENT_WATCH = new SidebarSectionType("RECENT_WATCH", 1);
        GAME = new SidebarSectionType("GAME", 2);
        FUNCTION_LIST = new SidebarSectionType("FUNCTION_LIST", 3);
        SUBSCRIBE = new SidebarSectionType("SUBSCRIBE", 4);
        FOLLOW = new SidebarSectionType("FOLLOW", 5);
        SidebarSectionType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SidebarSectionType valueOf(String str) {
        return (SidebarSectionType) Enum.valueOf(SidebarSectionType.class, str);
    }

    private SidebarSectionType(String str, int i) {
    }
}
