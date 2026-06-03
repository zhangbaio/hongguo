package com.dragon.read.kmp.reader;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class DecryptKey$Source {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DecryptKey$Source[] $VALUES;
    public static final DecryptKey$Source CACHE;
    public static final DecryptKey$Source NONE;
    public static final DecryptKey$Source SERVER;
    private final String symbol;

    private static final /* synthetic */ DecryptKey$Source[] $values() {
        return new DecryptKey$Source[]{SERVER, CACHE, NONE};
    }

    public static EnumEntries<DecryptKey$Source> getEntries() {
        return $ENTRIES;
    }

    public final String getSymbol() {
        return this.symbol;
    }

    public static DecryptKey$Source[] values() {
        return (DecryptKey$Source[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608234);
        SERVER = new DecryptKey$Source("SERVER", 0, "server");
        CACHE = new DecryptKey$Source("CACHE", 1, "cache");
        NONE = new DecryptKey$Source("NONE", 2, "");
        DecryptKey$Source[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DecryptKey$Source valueOf(String str) {
        return (DecryptKey$Source) Enum.valueOf(DecryptKey$Source.class, str);
    }

    private DecryptKey$Source(String str, int i, String str2) {
        this.symbol = str2;
    }
}
