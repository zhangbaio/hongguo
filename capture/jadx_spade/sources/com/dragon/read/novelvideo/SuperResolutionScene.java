package com.dragon.read.novelvideo;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class SuperResolutionScene {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SuperResolutionScene[] $VALUES;
    public static final SuperResolutionScene AUDIO_PATCH_VIDEO;
    public static final SuperResolutionScene BOOK_REC_VIDEO;
    public static final SuperResolutionScene READER_LYNX_VIDEO;
    public static final SuperResolutionScene X_VIDEO_PRO;

    private static final /* synthetic */ SuperResolutionScene[] $values() {
        return new SuperResolutionScene[]{READER_LYNX_VIDEO, BOOK_REC_VIDEO, AUDIO_PATCH_VIDEO, X_VIDEO_PRO};
    }

    public static EnumEntries<SuperResolutionScene> getEntries() {
        return $ENTRIES;
    }

    public static SuperResolutionScene[] values() {
        return (SuperResolutionScene[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(612514);
        READER_LYNX_VIDEO = new SuperResolutionScene("READER_LYNX_VIDEO", 0);
        BOOK_REC_VIDEO = new SuperResolutionScene("BOOK_REC_VIDEO", 1);
        AUDIO_PATCH_VIDEO = new SuperResolutionScene("AUDIO_PATCH_VIDEO", 2);
        X_VIDEO_PRO = new SuperResolutionScene("X_VIDEO_PRO", 3);
        SuperResolutionScene[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SuperResolutionScene valueOf(String str) {
        return (SuperResolutionScene) Enum.valueOf(SuperResolutionScene.class, str);
    }

    private SuperResolutionScene(String str, int i) {
    }
}
