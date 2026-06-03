package com.dragon.read.kmp.util;

import com.bytedance.covode.number.Covode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BitmapCommonUtils {
    public static final BitmapCommonUtils a;

    static {
        Covode.recordClassIndex(609451);
        a = new BitmapCommonUtils();
    }

    private BitmapCommonUtils() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ChannelOrder {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ChannelOrder[] $VALUES;
        public static final ChannelOrder ABGR;
        public static final ChannelOrder ARGB;
        public static final ChannelOrder BGRA;
        public static final ChannelOrder RGBA;

        private static final /* synthetic */ ChannelOrder[] $values() {
            return new ChannelOrder[]{ARGB, RGBA, BGRA, ABGR};
        }

        public static EnumEntries<ChannelOrder> getEntries() {
            return $ENTRIES;
        }

        public static ChannelOrder[] values() {
            return (ChannelOrder[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(609452);
            ARGB = new ChannelOrder("ARGB", 0);
            RGBA = new ChannelOrder("RGBA", 1);
            BGRA = new ChannelOrder("BGRA", 2);
            ABGR = new ChannelOrder("ABGR", 3);
            ChannelOrder[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static ChannelOrder valueOf(String str) {
            return (ChannelOrder) Enum.valueOf(ChannelOrder.class, str);
        }

        private ChannelOrder(String str, int i) {
        }
    }

    public final int a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i4 > i2 || i3 > i) {
            int i6 = i4 / 2;
            int i7 = i3 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public final int b(int i, int i2, int i3, int i4, float f) {
        float f2 = 1.0f;
        if (i4 > i2 || i3 > i) {
            int i5 = (int) (i4 / f);
            int i6 = (int) (i3 / f);
            while (i5 / f2 >= i2 && i6 / f2 >= i) {
                f2 *= f;
            }
        }
        return (int) Math.floor(f2);
    }
}
