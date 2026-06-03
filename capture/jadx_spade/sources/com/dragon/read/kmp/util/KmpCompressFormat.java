package com.dragon.read.kmp.util;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class KmpCompressFormat {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ KmpCompressFormat[] $VALUES;
    public static final KmpCompressFormat JPEG;
    public static final KmpCompressFormat PNG;
    public static final KmpCompressFormat WEBP;

    private static final /* synthetic */ KmpCompressFormat[] $values() {
        return new KmpCompressFormat[]{JPEG, PNG, WEBP};
    }

    public static EnumEntries<KmpCompressFormat> getEntries() {
        return $ENTRIES;
    }

    public static KmpCompressFormat[] values() {
        return (KmpCompressFormat[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(609466);
        JPEG = new KmpCompressFormat("JPEG", 0);
        PNG = new KmpCompressFormat("PNG", 1);
        WEBP = new KmpCompressFormat("WEBP", 2);
        KmpCompressFormat[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static KmpCompressFormat valueOf(String str) {
        return (KmpCompressFormat) Enum.valueOf(KmpCompressFormat.class, str);
    }

    private KmpCompressFormat(String str, int i) {
    }
}
