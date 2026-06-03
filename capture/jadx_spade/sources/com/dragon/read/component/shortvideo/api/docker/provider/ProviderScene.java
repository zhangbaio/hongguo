package com.dragon.read.component.shortvideo.api.docker.provider;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ProviderScene {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProviderScene[] $VALUES;
    public static final ProviderScene ALBUM_PORTRAIT;
    public static final ProviderScene ALBUM_ROTATABLE;
    public static final ProviderScene FEED_VIDEO_TAB;
    public static final ProviderScene LANDSCAPE;
    public static final ProviderScene LONG;
    public static final ProviderScene MID_ROLL;
    public static final ProviderScene PORTRAIT;
    public static final ProviderScene PRE_ROLL;
    public static final ProviderScene ROTATABLE;
    public static final ProviderScene SHORT;

    private static final /* synthetic */ ProviderScene[] $values() {
        return new ProviderScene[]{PRE_ROLL, MID_ROLL, SHORT, LONG, ROTATABLE, PORTRAIT, LANDSCAPE, ALBUM_PORTRAIT, ALBUM_ROTATABLE, FEED_VIDEO_TAB};
    }

    public static EnumEntries<ProviderScene> getEntries() {
        return $ENTRIES;
    }

    public static ProviderScene[] values() {
        return (ProviderScene[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598696);
        PRE_ROLL = new ProviderScene("PRE_ROLL", 0);
        MID_ROLL = new ProviderScene("MID_ROLL", 1);
        SHORT = new ProviderScene("SHORT", 2);
        LONG = new ProviderScene("LONG", 3);
        ROTATABLE = new ProviderScene("ROTATABLE", 4);
        PORTRAIT = new ProviderScene("PORTRAIT", 5);
        LANDSCAPE = new ProviderScene("LANDSCAPE", 6);
        ALBUM_PORTRAIT = new ProviderScene("ALBUM_PORTRAIT", 7);
        ALBUM_ROTATABLE = new ProviderScene("ALBUM_ROTATABLE", 8);
        FEED_VIDEO_TAB = new ProviderScene("FEED_VIDEO_TAB", 9);
        ProviderScene[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ProviderScene valueOf(String str) {
        return (ProviderScene) Enum.valueOf(ProviderScene.class, str);
    }

    private ProviderScene(String str, int i) {
    }
}
