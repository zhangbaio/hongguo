package com.dragon.read.kmp.reader.background;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class ReaderBgColorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReaderBgColorType[] $VALUES;
    public static final a Companion;
    public static final ReaderBgColorType DIM;
    public static final ReaderBgColorType LIGHT;
    public static final ReaderBgColorType STANDARD;
    private final int value;

    private static final /* synthetic */ ReaderBgColorType[] $values() {
        return new ReaderBgColorType[]{DIM, STANDARD, LIGHT};
    }

    public static EnumEntries<ReaderBgColorType> getEntries() {
        return $ENTRIES;
    }

    public static final ReaderBgColorType getReaderColorType(int i) {
        return Companion.a(i);
    }

    public final int getValue() {
        return this.value;
    }

    public static ReaderBgColorType[] values() {
        return (ReaderBgColorType[]) $VALUES.clone();
    }

    static {
        Covode.recordClassIndex(608238);
        DIM = new ReaderBgColorType("DIM", 0, 0);
        STANDARD = new ReaderBgColorType("STANDARD", 1, 1);
        LIGHT = new ReaderBgColorType("LIGHT", 2, 2);
        ReaderBgColorType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new a(null);
    }

    public static ReaderBgColorType valueOf(String str) {
        return (ReaderBgColorType) Enum.valueOf(ReaderBgColorType.class, str);
    }

    public static final class a {
        static {
            Covode.recordClassIndex(608239);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ReaderBgColorType a(int i) {
            switch (i) {
                case -1:
                case 0:
                case 1:
                case 4:
                case 5:
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                case 7:
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                case 9:
                case 10:
                case 11:
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                    return ReaderBgColorType.STANDARD;
                case 2:
                case 3:
                    return ReaderBgColorType.LIGHT;
                default:
                    return ReaderBgColorType.DIM;
            }
        }
    }

    private ReaderBgColorType(String str, int i, int i2) {
        this.value = i2;
    }
}
