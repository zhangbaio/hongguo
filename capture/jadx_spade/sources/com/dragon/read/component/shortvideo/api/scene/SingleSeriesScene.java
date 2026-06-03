package com.dragon.read.component.shortvideo.api.scene;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SingleSeriesScene {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SingleSeriesScene[] $VALUES;
    public static final SingleSeriesScene ALBUM;
    public static final SingleSeriesScene COMMON_PUGC_VIDEO;
    public static final SingleSeriesScene LIKE;
    public static final SingleSeriesScene NORMAL;

    private static final /* synthetic */ SingleSeriesScene[] $values() {
        return new SingleSeriesScene[]{NORMAL, LIKE, ALBUM, COMMON_PUGC_VIDEO};
    }

    public static EnumEntries<SingleSeriesScene> getEntries() {
        return $ENTRIES;
    }

    public static SingleSeriesScene[] values() {
        return (SingleSeriesScene[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(598847);
        NORMAL = new SingleSeriesScene("NORMAL", 0);
        LIKE = new SingleSeriesScene("LIKE", 1);
        ALBUM = new SingleSeriesScene("ALBUM", 2);
        COMMON_PUGC_VIDEO = new SingleSeriesScene("COMMON_PUGC_VIDEO", 3);
        SingleSeriesScene[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SingleSeriesScene valueOf(String str) {
        return (SingleSeriesScene) Enum.valueOf(SingleSeriesScene.class, str);
    }

    private SingleSeriesScene(String str, int i) {
    }
}
