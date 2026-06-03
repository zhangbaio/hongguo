package kotlin.coroutines.jvm.internal;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Boxing {
    static {
        Covode.recordClassIndex(658316);
    }

    public static final Boolean boxBoolean(boolean z) {
        return Boolean.valueOf(z);
    }

    public static final Byte boxByte(byte b) {
        return Byte.valueOf(b);
    }

    public static final Character boxChar(char c) {
        return new Character(c);
    }

    public static final Double boxDouble(double d) {
        return new Double(d);
    }

    public static final Float boxFloat(float f) {
        return new Float(f);
    }

    public static final Integer boxInt(int i) {
        return new Integer(i);
    }

    public static final Long boxLong(long j) {
        return new Long(j);
    }

    public static final Short boxShort(short s) {
        return new Short(s);
    }
}
