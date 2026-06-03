package com.dragon.read.component.shortvideo.api.docker.viewmamanager;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BizArea {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BizArea[] $VALUES;
    public static final BizArea BASE_INFO;
    public static final BizArea BOOK;
    public static final BizArea BOTTOM;
    public static final BizArea BOTTOM_INTERACT;
    public static final BizArea CLEAR_SCREEN;
    public static final BizArea DANMAKU;
    public static final BizArea ENTER_EPISODE_AND_FULL_SCREEN;
    public static final BizArea FULL_SCREEN;
    public static final BizArea FULL_SCREEN_PATCH_AD;
    public static final BizArea INTERACTION;
    public static final BizArea INTERCEPT_LOCK;
    public static final BizArea QUESTIONNAIRE;
    public static final BizArea RELATED_BOOK_CARD;
    public static final BizArea SERIES;
    private final int areaId;
    private final boolean lazy;

    private static final /* synthetic */ BizArea[] $values() {
        return new BizArea[]{INTERCEPT_LOCK, BASE_INFO, INTERACTION, BOTTOM, BOOK, SERIES, CLEAR_SCREEN, BOTTOM_INTERACT, DANMAKU, QUESTIONNAIRE, RELATED_BOOK_CARD, FULL_SCREEN, ENTER_EPISODE_AND_FULL_SCREEN, FULL_SCREEN_PATCH_AD};
    }

    public static EnumEntries<BizArea> getEntries() {
        return $ENTRIES;
    }

    public final int getAreaId() {
        return this.areaId;
    }

    public final boolean getLazy() {
        return this.lazy;
    }

    public static BizArea[] values() {
        return (BizArea[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598697);
        boolean z = false;
        int i = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        INTERCEPT_LOCK = new BizArea("INTERCEPT_LOCK", 0, 2131827602, z, i, defaultConstructorMarker);
        boolean z2 = false;
        int i2 = 2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        BASE_INFO = new BizArea("BASE_INFO", 1, 2131822075, z2, i2, defaultConstructorMarker2);
        INTERACTION = new BizArea("INTERACTION", 2, 2131831459, z, i, defaultConstructorMarker);
        BOTTOM = new BizArea("BOTTOM", 3, 2131820883, z2, i2, defaultConstructorMarker2);
        BOOK = new BizArea("BOOK", 4, 2131822304, z, i, defaultConstructorMarker);
        SERIES = new BizArea("SERIES", 5, 2131822621, z2, i2, defaultConstructorMarker2);
        CLEAR_SCREEN = new BizArea("CLEAR_SCREEN", 6, 2131824470, z, i, defaultConstructorMarker);
        BOTTOM_INTERACT = new BizArea("BOTTOM_INTERACT", 7, 2131822596, z2, i2, defaultConstructorMarker2);
        DANMAKU = new BizArea("DANMAKU", 8, 2131825329, z, i, defaultConstructorMarker);
        QUESTIONNAIRE = new BizArea("QUESTIONNAIRE", 9, 2131830877, z2, i2, defaultConstructorMarker2);
        RELATED_BOOK_CARD = new BizArea("RELATED_BOOK_CARD", 10, 2131831255, z, i, defaultConstructorMarker);
        FULL_SCREEN = new BizArea("FULL_SCREEN", 11, 2131826711, z2, i2, defaultConstructorMarker2);
        ENTER_EPISODE_AND_FULL_SCREEN = new BizArea("ENTER_EPISODE_AND_FULL_SCREEN", 12, 2131825981, z, i, defaultConstructorMarker);
        FULL_SCREEN_PATCH_AD = new BizArea("FULL_SCREEN_PATCH_AD", 13, 2131826720, true);
        BizArea[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static BizArea valueOf(String str) {
        return (BizArea) Enum.valueOf(BizArea.class, str);
    }

    private BizArea(String str, int i, int i2, boolean z) {
        this.areaId = i2;
        this.lazy = z;
    }

    /* synthetic */ BizArea(String str, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, (i3 & 2) != 0 ? false : z);
    }
}
