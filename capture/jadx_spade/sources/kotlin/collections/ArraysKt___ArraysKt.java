package kotlin.collections;

import ak4.d;
import com.bytedance.covode.number.Covode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class ArraysKt___ArraysKt extends ArraysKt___ArraysJvmKt {
    static {
        Covode.recordClassIndex(658174);
    }

    private static final boolean component1(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[0];
    }

    private static final boolean component2(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[1];
    }

    private static final boolean component3(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[2];
    }

    private static final boolean component4(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[3];
    }

    private static final boolean component5(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr[4];
    }

    public static final boolean contains(boolean[] zArr, boolean z) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return indexOf(zArr, z) >= 0;
    }

    private static final short elementAtOrElse(short[] sArr, int i2, Function1<? super Integer, Short> defaultValue) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < sArr.length) {
            z = true;
        }
        return z ? sArr[i2] : defaultValue.invoke(Integer.valueOf(i2)).shortValue();
    }

    private static final boolean elementAtOrElse(boolean[] zArr, int i2, Function1<? super Integer, Boolean> defaultValue) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < zArr.length) {
            z = true;
        }
        return z ? zArr[i2] : defaultValue.invoke(Integer.valueOf(i2)).booleanValue();
    }

    private static final Short elementAtOrNull(short[] sArr, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return getOrNull(sArr, i2);
    }

    public static <T> T first(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[0];
    }

    public static final short first(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return sArr[0];
    }

    public static int first(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[0];
    }

    public static final long first(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return jArr[0];
    }

    public static final boolean first(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return zArr[0];
    }

    public static final <T> T first(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final short first(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                return s2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int first(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i2 : iArr) {
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                return i2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final long first(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j2 : jArr) {
            if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                return j2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float first(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                return f2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final boolean first(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return z;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static <T> T firstOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static final Short firstOrNull(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[0]);
    }

    public static final Integer firstOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[0]);
    }

    public static final Long firstOrNull(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    public static final Float firstOrNull(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[0]);
    }

    public static final <T> T firstOrNull(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    public static final Short firstOrNull(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                return Short.valueOf(s2);
            }
        }
        return null;
    }

    public static final Integer firstOrNull(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i2 : iArr) {
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                return Integer.valueOf(i2);
            }
        }
        return null;
    }

    public static final Long firstOrNull(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j2 : jArr) {
            if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                return Long.valueOf(j2);
            }
        }
        return null;
    }

    public static final Float firstOrNull(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                return Float.valueOf(f2);
            }
        }
        return null;
    }

    public static final Double firstOrNull(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                return Double.valueOf(d2);
            }
        }
        return null;
    }

    private static final short getOrElse(short[] sArr, int i2, Function1<? super Integer, Short> defaultValue) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < sArr.length) {
            z = true;
        }
        return z ? sArr[i2] : defaultValue.invoke(Integer.valueOf(i2)).shortValue();
    }

    private static final boolean getOrElse(boolean[] zArr, int i2, Function1<? super Integer, Boolean> defaultValue) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < zArr.length) {
            z = true;
        }
        return z ? zArr[i2] : defaultValue.invoke(Integer.valueOf(i2)).booleanValue();
    }

    public static <T> T getOrNull(T[] tArr, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        boolean z = false;
        if (i2 >= 0 && i2 < tArr.length) {
            z = true;
        }
        if (z) {
            return tArr[i2];
        }
        return null;
    }

    public static final Short getOrNull(short[] sArr, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        boolean z = false;
        if (i2 >= 0 && i2 < sArr.length) {
            z = true;
        }
        if (z) {
            return Short.valueOf(sArr[i2]);
        }
        return null;
    }

    public static final int indexOf(short[] sArr, short s2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (s2 == sArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOf(boolean[] zArr, boolean z) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (z == zArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final <T> int indexOfFirst(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (predicate.invoke(tArr[i2]).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (predicate.invoke(Short.valueOf(sArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (predicate.invoke(Boolean.valueOf(zArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final <T> int indexOfLast(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (predicate.invoke(tArr[length]).booleanValue()) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (predicate.invoke(Short.valueOf(sArr[length])).booleanValue()) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (predicate.invoke(Boolean.valueOf(zArr[length])).booleanValue()) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static <T> T last(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[getLastIndex(tArr)];
    }

    public static final short last(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return sArr[getLastIndex(sArr)];
    }

    public static int last(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[getLastIndex(iArr)];
    }

    public static final long last(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return jArr[getLastIndex(jArr)];
    }

    public static final boolean last(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return zArr[getLastIndex(zArr)];
    }

    public static final <T> T last(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                T t = tArr[length];
                if (!predicate.invoke(t).booleanValue()) {
                    if (i2 < 0) {
                        break;
                    }
                    length = i2;
                } else {
                    return t;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final short last(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                short s2 = sArr[length];
                if (!predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                    if (i2 < 0) {
                        break;
                    }
                    length = i2;
                } else {
                    return s2;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int last(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                int i3 = iArr[length];
                if (!predicate.invoke(Integer.valueOf(i3)).booleanValue()) {
                    if (i2 < 0) {
                        break;
                    }
                    length = i2;
                } else {
                    return i3;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final long last(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                long j2 = jArr[length];
                if (!predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                    if (i2 < 0) {
                        break;
                    }
                    length = i2;
                } else {
                    return j2;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final float last(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                float f2 = fArr[length];
                if (!predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                    if (i2 < 0) {
                        break;
                    }
                    length = i2;
                } else {
                    return f2;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final boolean last(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                boolean z = zArr[length];
                if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                    if (i2 < 0) {
                        break;
                    }
                    length = i2;
                } else {
                    return z;
                }
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int lastIndexOf(short[] sArr, short s2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (s2 == sArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final int lastIndexOf(boolean[] zArr, boolean z) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (z == zArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static <T> T lastOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[tArr.length - 1];
    }

    public static final Short lastOrNull(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[sArr.length - 1]);
    }

    public static Integer lastOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[iArr.length - 1]);
    }

    public static final Long lastOrNull(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[jArr.length - 1]);
    }

    public static final Float lastOrNull(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[fArr.length - 1]);
    }

    public static final <T> T lastOrNull(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i2 = length - 1;
            T t = tArr[length];
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
            if (i2 < 0) {
                return null;
            }
            length = i2;
        }
    }

    public static final Short lastOrNull(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i2 = length - 1;
            short s2 = sArr[length];
            if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                return Short.valueOf(s2);
            }
            if (i2 < 0) {
                return null;
            }
            length = i2;
        }
    }

    public static final Integer lastOrNull(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i2 = length - 1;
            int i3 = iArr[length];
            if (predicate.invoke(Integer.valueOf(i3)).booleanValue()) {
                return Integer.valueOf(i3);
            }
            if (i2 < 0) {
                return null;
            }
            length = i2;
        }
    }

    public static final Long lastOrNull(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i2 = length - 1;
            long j2 = jArr[length];
            if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                return Long.valueOf(j2);
            }
            if (i2 < 0) {
                return null;
            }
            length = i2;
        }
    }

    public static final Float lastOrNull(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i2 = length - 1;
            float f2 = fArr[length];
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                return Float.valueOf(f2);
            }
            if (i2 < 0) {
                return null;
            }
            length = i2;
        }
    }

    public static final Double lastOrNull(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i2 = length - 1;
            double d2 = dArr[length];
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                return Double.valueOf(d2);
            }
            if (i2 < 0) {
                return null;
            }
            length = i2;
        }
    }

    private static final <T> T random(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (T) random(tArr, Random.Default);
    }

    private static final short random(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return random(sArr, (Random) Random.Default);
    }

    private static final int random(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return random(iArr, (Random) Random.Default);
    }

    private static final long random(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return random(jArr, (Random) Random.Default);
    }

    private static final boolean random(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return random(zArr, Random.Default);
    }

    public static final <T> T random(T[] tArr, Random random) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (tArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return tArr[random.nextInt(tArr.length)];
    }

    public static final short random(short[] sArr, Random random) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (sArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return sArr[random.nextInt(sArr.length)];
    }

    public static int random(int[] iArr, Random random) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (iArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return iArr[random.nextInt(iArr.length)];
    }

    public static final long random(long[] jArr, Random random) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (jArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return jArr[random.nextInt(jArr.length)];
    }

    public static final boolean random(boolean[] zArr, Random random) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (zArr.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        return zArr[random.nextInt(zArr.length)];
    }

    private static final <T> T randomOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (T) randomOrNull(tArr, Random.Default);
    }

    private static final Short randomOrNull(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return randomOrNull(sArr, (Random) Random.Default);
    }

    private static final Integer randomOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return randomOrNull(iArr, (Random) Random.Default);
    }

    private static final Long randomOrNull(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return randomOrNull(jArr, (Random) Random.Default);
    }

    private static final Float randomOrNull(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return randomOrNull(fArr, (Random) Random.Default);
    }

    public static final <T> T randomOrNull(T[] tArr, Random random) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[random.nextInt(tArr.length)];
    }

    public static final Short randomOrNull(short[] sArr, Random random) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (sArr.length == 0) {
            return null;
        }
        return Short.valueOf(sArr[random.nextInt(sArr.length)]);
    }

    public static final Integer randomOrNull(int[] iArr, Random random) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (iArr.length == 0) {
            return null;
        }
        return Integer.valueOf(iArr[random.nextInt(iArr.length)]);
    }

    public static final Long randomOrNull(long[] jArr, Random random) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[random.nextInt(jArr.length)]);
    }

    public static final Float randomOrNull(float[] fArr, Random random) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (fArr.length == 0) {
            return null;
        }
        return Float.valueOf(fArr[random.nextInt(fArr.length)]);
    }

    public static <T> T single(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return tArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final short single(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return sArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final int single(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return iArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final long single(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return jArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final boolean single(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return zArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static final <T> T single(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : tArr) {
            if (predicate.invoke(t2).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                t = t2;
                z = true;
            }
        }
        if (z) {
            return t;
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final short single(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Short sh = null;
        boolean z = false;
        for (short s2 : sArr) {
            if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                sh = Short.valueOf(s2);
                z = true;
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        Intrinsics.checkNotNull(sh, "null cannot be cast to non-null type kotlin.Short");
        return sh.shortValue();
    }

    public static final int single(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Integer num = null;
        boolean z = false;
        for (int i2 : iArr) {
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                num = Integer.valueOf(i2);
                z = true;
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        Intrinsics.checkNotNull(num, "null cannot be cast to non-null type kotlin.Int");
        return num.intValue();
    }

    public static final long single(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Long l2 = null;
        boolean z = false;
        for (long j2 : jArr) {
            if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                l2 = Long.valueOf(j2);
                z = true;
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        Intrinsics.checkNotNull(l2, "null cannot be cast to non-null type kotlin.Long");
        return l2.longValue();
    }

    public static final float single(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Float f2 = null;
        boolean z = false;
        for (float f3 : fArr) {
            if (predicate.invoke(Float.valueOf(f3)).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                f2 = Float.valueOf(f3);
                z = true;
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        Intrinsics.checkNotNull(f2, "null cannot be cast to non-null type kotlin.Float");
        return f2.floatValue();
    }

    public static final boolean single(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Boolean bool = null;
        boolean z = false;
        for (boolean z2 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z2)).booleanValue()) {
                if (z) {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
                bool = Boolean.valueOf(z2);
                z = true;
            }
        }
        if (!z) {
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        Intrinsics.checkNotNull(bool, "null cannot be cast to non-null type kotlin.Boolean");
        return bool.booleanValue();
    }

    public static final Short singleOrNull(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 1) {
            return Short.valueOf(sArr[0]);
        }
        return null;
    }

    public static final Integer singleOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 1) {
            return Integer.valueOf(iArr[0]);
        }
        return null;
    }

    public static final Long singleOrNull(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 1) {
            return Long.valueOf(jArr[0]);
        }
        return null;
    }

    public static final Float singleOrNull(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 1) {
            return Float.valueOf(fArr[0]);
        }
        return null;
    }

    public static final <T> T singleOrNull(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        T t = null;
        boolean z = false;
        for (T t2 : tArr) {
            if (predicate.invoke(t2).booleanValue()) {
                if (z) {
                    return null;
                }
                z = true;
                t = t2;
            }
        }
        if (z) {
            return t;
        }
        return null;
    }

    public static final Short singleOrNull(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Short sh = null;
        boolean z = false;
        for (short s2 : sArr) {
            if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                if (z) {
                    return null;
                }
                sh = Short.valueOf(s2);
                z = true;
            }
        }
        if (z) {
            return sh;
        }
        return null;
    }

    public static final Integer singleOrNull(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Integer num = null;
        boolean z = false;
        for (int i2 : iArr) {
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                if (z) {
                    return null;
                }
                num = Integer.valueOf(i2);
                z = true;
            }
        }
        if (z) {
            return num;
        }
        return null;
    }

    public static final Long singleOrNull(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Long l2 = null;
        boolean z = false;
        for (long j2 : jArr) {
            if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                if (z) {
                    return null;
                }
                l2 = Long.valueOf(j2);
                z = true;
            }
        }
        if (z) {
            return l2;
        }
        return null;
    }

    public static final Float singleOrNull(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Float f2 = null;
        boolean z = false;
        for (float f3 : fArr) {
            if (predicate.invoke(Float.valueOf(f3)).booleanValue()) {
                if (z) {
                    return null;
                }
                f2 = Float.valueOf(f3);
                z = true;
            }
        }
        if (z) {
            return f2;
        }
        return null;
    }

    public static final Double singleOrNull(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Double d2 = null;
        boolean z = false;
        for (double d3 : dArr) {
            if (predicate.invoke(Double.valueOf(d3)).booleanValue()) {
                if (z) {
                    return null;
                }
                d2 = Double.valueOf(d3);
                z = true;
            }
        }
        if (z) {
            return d2;
        }
        return null;
    }

    public static <T> List<T> drop(T[] tArr, int i2) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(tArr.length - i2, 0);
        return takeLast(tArr, coerceAtLeast);
    }

    public static final List<Short> drop(short[] sArr, int i2) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(sArr.length - i2, 0);
        return takeLast(sArr, coerceAtLeast);
    }

    public static final List<Boolean> drop(boolean[] zArr, int i2) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(zArr.length - i2, 0);
        return takeLast(zArr, coerceAtLeast);
    }

    public static <T> List<T> dropLast(T[] tArr, int i2) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(tArr.length - i2, 0);
        return take(tArr, coerceAtLeast);
    }

    public static final List<Short> dropLast(short[] sArr, int i2) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(sArr.length - i2, 0);
        return take(sArr, coerceAtLeast);
    }

    public static final List<Boolean> dropLast(boolean[] zArr, int i2) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(zArr.length - i2, 0);
        return take(zArr, coerceAtLeast);
    }

    public static final <T> List<T> dropLastWhile(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(tArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(tArr[lastIndex]).booleanValue()) {
                return take(tArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Short> dropLastWhile(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(sArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Short.valueOf(sArr[lastIndex])).booleanValue()) {
                return take(sArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Boolean> dropLastWhile(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(zArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Boolean.valueOf(zArr[lastIndex])).booleanValue()) {
                return take(zArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final <T> List<T> dropWhile(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (T t : tArr) {
            if (z) {
                arrayList.add(t);
            } else if (!predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
                z = true;
            }
        }
        return arrayList;
    }

    public static final List<Short> dropWhile(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (short s2 : sArr) {
            if (z) {
                arrayList.add(Short.valueOf(s2));
            } else if (!predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
                z = true;
            }
        }
        return arrayList;
    }

    public static final List<Boolean> dropWhile(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (boolean z2 : zArr) {
            if (z) {
                arrayList.add(Boolean.valueOf(z2));
            } else if (!predicate.invoke(Boolean.valueOf(z2)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z2));
                z = true;
            }
        }
        return arrayList;
    }

    public static final <T> List<T> filter(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final List<Short> filter(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
            }
        }
        return arrayList;
    }

    public static final List<Boolean> filter(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    public static final <T> List<T> filterIndexed(T[] tArr, Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            T t = tArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), t).booleanValue()) {
                arrayList.add(t);
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final List<Short> filterIndexed(short[] sArr, Function2<? super Integer, ? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            short s2 = sArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Short.valueOf(s2)).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final List<Boolean> filterIndexed(boolean[] zArr, Function2<? super Integer, ? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            boolean z = zArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final <T> List<T> filterNot(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (!predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final List<Short> filterNot(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            if (!predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
            }
        }
        return arrayList;
    }

    public static final List<Boolean> filterNot(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(T[] tArr, C destination, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (!predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Short>> C filterNotTo(short[] sArr, C destination, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (!predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                destination.add(Short.valueOf(s2));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Boolean>> C filterNotTo(boolean[] zArr, C destination, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                destination.add(Boolean.valueOf(z));
            }
        }
        return destination;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(T[] tArr, C destination, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                destination.add(t);
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Short>> C filterTo(short[] sArr, C destination, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                destination.add(Short.valueOf(s2));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Boolean>> C filterTo(boolean[] zArr, C destination, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                destination.add(Boolean.valueOf(z));
            }
        }
        return destination;
    }

    public static final <T> List<T> slice(T[] tArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(tArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final List<Short> slice(short[] sArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(sArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final List<Integer> slice(int[] iArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(iArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final List<Long> slice(long[] jArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(jArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final List<Float> slice(float[] fArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(fArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final List<Boolean> slice(boolean[] zArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? CollectionsKt__CollectionsKt.emptyList() : ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(zArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final <T> List<T> slice(T[] tArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(tArr[it2.next().intValue()]);
        }
        return arrayList;
    }

    public static final List<Short> slice(short[] sArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Short.valueOf(sArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    public static final List<Integer> slice(int[] iArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Integer.valueOf(iArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    public static final List<Long> slice(long[] jArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Long.valueOf(jArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    public static final List<Float> slice(float[] fArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Float.valueOf(fArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    public static final List<Boolean> slice(boolean[] zArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Boolean.valueOf(zArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    public static final <T> T[] sliceArray(T[] tArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        T[] tArr2 = (T[]) kotlin.collections.g.arrayOfNulls(tArr, indices.size());
        Iterator<Integer> it2 = indices.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            tArr2[i2] = tArr[it2.next().intValue()];
            i2++;
        }
        return tArr2;
    }

    public static final short[] sliceArray(short[] sArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        short[] sArr2 = new short[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            sArr2[i2] = sArr[it2.next().intValue()];
            i2++;
        }
        return sArr2;
    }

    public static final int[] sliceArray(int[] iArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int[] iArr2 = new int[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            iArr2[i2] = iArr[it2.next().intValue()];
            i2++;
        }
        return iArr2;
    }

    public static final long[] sliceArray(long[] jArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        long[] jArr2 = new long[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            jArr2[i2] = jArr[it2.next().intValue()];
            i2++;
        }
        return jArr2;
    }

    public static final float[] sliceArray(float[] fArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        float[] fArr2 = new float[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            fArr2[i2] = fArr[it2.next().intValue()];
            i2++;
        }
        return fArr2;
    }

    public static final boolean[] sliceArray(boolean[] zArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        boolean[] zArr2 = new boolean[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            zArr2[i2] = zArr[it2.next().intValue()];
            i2++;
        }
        return zArr2;
    }

    public static final <T> T[] sliceArray(T[] tArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? (T[]) ArraysKt___ArraysJvmKt.copyOfRange(tArr, 0, 0) : (T[]) ArraysKt___ArraysJvmKt.copyOfRange(tArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final short[] sliceArray(short[] sArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new short[0] : ArraysKt___ArraysJvmKt.copyOfRange(sArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final int[] sliceArray(int[] iArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new int[0] : ArraysKt___ArraysJvmKt.copyOfRange(iArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final long[] sliceArray(long[] jArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new long[0] : ArraysKt___ArraysJvmKt.copyOfRange(jArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final float[] sliceArray(float[] fArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new float[0] : ArraysKt___ArraysJvmKt.copyOfRange(fArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final boolean[] sliceArray(boolean[] zArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        return indices.isEmpty() ? new boolean[0] : ArraysKt___ArraysJvmKt.copyOfRange(zArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static <T> List<T> take(T[] tArr, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i2 >= tArr.length) {
            return toList(tArr);
        }
        if (i2 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(tArr[0]);
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (T t : tArr) {
            arrayList.add(t);
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Short> take(short[] sArr, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i2 >= sArr.length) {
            return toList(sArr);
        }
        if (i2 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Short.valueOf(sArr[0]));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (short s2 : sArr) {
            arrayList.add(Short.valueOf(s2));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Long> take(long[] jArr, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i2 >= jArr.length) {
            return toList(jArr);
        }
        if (i2 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(jArr[0]));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (long j2 : jArr) {
            arrayList.add(Long.valueOf(j2));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final List<Boolean> take(boolean[] zArr, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (i2 >= zArr.length) {
            return toList(zArr);
        }
        if (i2 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Boolean.valueOf(zArr[0]));
        }
        ArrayList arrayList = new ArrayList(i2);
        int i3 = 0;
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
            i3++;
            if (i3 == i2) {
                break;
            }
        }
        return arrayList;
    }

    public static final <T> List<T> takeLast(T[] tArr, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = tArr.length;
        if (i2 >= length) {
            return toList(tArr);
        }
        if (i2 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(tArr[length - 1]);
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(tArr[i3]);
        }
        return arrayList;
    }

    public static final List<Short> takeLast(short[] sArr, int i2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = sArr.length;
        if (i2 >= length) {
            return toList(sArr);
        }
        if (i2 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Short.valueOf(sArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(Short.valueOf(sArr[i3]));
        }
        return arrayList;
    }

    public static final List<Long> takeLast(long[] jArr, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = jArr.length;
        if (i2 >= length) {
            return toList(jArr);
        }
        if (i2 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(jArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(Long.valueOf(jArr[i3]));
        }
        return arrayList;
    }

    public static final List<Boolean> takeLast(boolean[] zArr, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
        }
        if (i2 == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int length = zArr.length;
        if (i2 >= length) {
            return toList(zArr);
        }
        if (i2 == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Boolean.valueOf(zArr[length - 1]));
        }
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = length - i2; i3 < length; i3++) {
            arrayList.add(Boolean.valueOf(zArr[i3]));
        }
        return arrayList;
    }

    public static final <T> List<T> takeLastWhile(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(tArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(tArr[lastIndex]).booleanValue()) {
                return drop(tArr, lastIndex + 1);
            }
        }
        return toList(tArr);
    }

    public static final List<Short> takeLastWhile(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(sArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Short.valueOf(sArr[lastIndex])).booleanValue()) {
                return drop(sArr, lastIndex + 1);
            }
        }
        return toList(sArr);
    }

    public static final List<Boolean> takeLastWhile(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(zArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Boolean.valueOf(zArr[lastIndex])).booleanValue()) {
                return drop(zArr, lastIndex + 1);
            }
        }
        return toList(zArr);
    }

    public static final <T> List<T> takeWhile(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (!predicate.invoke(t).booleanValue()) {
                break;
            }
            arrayList.add(t);
        }
        return arrayList;
    }

    public static final List<Short> takeWhile(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            if (!predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                break;
            }
            arrayList.add(Short.valueOf(s2));
        }
        return arrayList;
    }

    public static final List<Boolean> takeWhile(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                break;
            }
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    public static final <T> void reverse(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = (tArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(tArr);
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            T t = tArr[i2];
            tArr[i2] = tArr[lastIndex];
            tArr[lastIndex] = t;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final void reverse(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = (sArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(sArr);
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            short s2 = sArr[i2];
            sArr[i2] = sArr[lastIndex];
            sArr[lastIndex] = s2;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final void reverse(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = (iArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(iArr);
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = iArr[i2];
            iArr[i2] = iArr[lastIndex];
            iArr[lastIndex] = i3;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final void reverse(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = (jArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(jArr);
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            jArr[i2] = jArr[lastIndex];
            jArr[lastIndex] = j2;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final void reverse(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = (fArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(fArr);
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            float f2 = fArr[i2];
            fArr[i2] = fArr[lastIndex];
            fArr[lastIndex] = f2;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final void reverse(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = (zArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(zArr);
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            boolean z = zArr[i2];
            zArr[i2] = zArr[lastIndex];
            zArr[lastIndex] = z;
            lastIndex--;
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public static final <T> void reverse(T[] tArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        AbstractList.Companion.d(i2, i3, tArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            T t = tArr[i2];
            tArr[i2] = tArr[i5];
            tArr[i5] = t;
            i5--;
            i2++;
        }
    }

    public static final void reverse(short[] sArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        AbstractList.Companion.d(i2, i3, sArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            short s2 = sArr[i2];
            sArr[i2] = sArr[i5];
            sArr[i5] = s2;
            i5--;
            i2++;
        }
    }

    public static final void reverse(int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        AbstractList.Companion.d(i2, i3, iArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            int i6 = iArr[i2];
            iArr[i2] = iArr[i5];
            iArr[i5] = i6;
            i5--;
            i2++;
        }
    }

    public static final void reverse(long[] jArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        AbstractList.Companion.d(i2, i3, jArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            long j2 = jArr[i2];
            jArr[i2] = jArr[i5];
            jArr[i5] = j2;
            i5--;
            i2++;
        }
    }

    public static final void reverse(float[] fArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        AbstractList.Companion.d(i2, i3, fArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            float f2 = fArr[i2];
            fArr[i2] = fArr[i5];
            fArr[i5] = f2;
            i5--;
            i2++;
        }
    }

    public static final void reverse(boolean[] zArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        AbstractList.Companion.d(i2, i3, zArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            boolean z = zArr[i2];
            zArr[i2] = zArr[i5];
            zArr[i5] = z;
            i5--;
            i2++;
        }
    }

    public static final List<Short> reversed(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Short> mutableList = toMutableList(sArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final List<Boolean> reversed(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Boolean> mutableList = toMutableList(zArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final <T> T[] reversedArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i2 = 0;
        if (tArr.length == 0) {
            return tArr;
        }
        T[] tArr2 = (T[]) kotlin.collections.g.arrayOfNulls(tArr, tArr.length);
        int lastIndex = getLastIndex(tArr);
        if (lastIndex >= 0) {
            while (true) {
                tArr2[lastIndex - i2] = tArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return tArr2;
    }

    public static final short[] reversedArray(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int i2 = 0;
        if (sArr.length == 0) {
            return sArr;
        }
        short[] sArr2 = new short[sArr.length];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex >= 0) {
            while (true) {
                sArr2[lastIndex - i2] = sArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return sArr2;
    }

    public static final boolean[] reversedArray(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int i2 = 0;
        if (zArr.length == 0) {
            return zArr;
        }
        boolean[] zArr2 = new boolean[zArr.length];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex >= 0) {
            while (true) {
                zArr2[lastIndex - i2] = zArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return zArr2;
    }

    public static final <T> void shuffle(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        shuffle(tArr, Random.Default);
    }

    public static final void shuffle(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        shuffle(sArr, (Random) Random.Default);
    }

    public static final void shuffle(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        shuffle(iArr, (Random) Random.Default);
    }

    public static final void shuffle(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        shuffle(jArr, (Random) Random.Default);
    }

    public static final void shuffle(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        shuffle(zArr, Random.Default);
    }

    public static final <T> void shuffle(T[] tArr, Random random) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(tArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            T t = tArr[lastIndex];
            tArr[lastIndex] = tArr[nextInt];
            tArr[nextInt] = t;
        }
    }

    public static final void shuffle(short[] sArr, Random random) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(sArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            short s2 = sArr[lastIndex];
            sArr[lastIndex] = sArr[nextInt];
            sArr[nextInt] = s2;
        }
    }

    public static final void shuffle(int[] iArr, Random random) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(iArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            int i2 = iArr[lastIndex];
            iArr[lastIndex] = iArr[nextInt];
            iArr[nextInt] = i2;
        }
    }

    public static final void shuffle(long[] jArr, Random random) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(jArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            long j2 = jArr[lastIndex];
            jArr[lastIndex] = jArr[nextInt];
            jArr[nextInt] = j2;
        }
    }

    public static final void shuffle(boolean[] zArr, Random random) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(zArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            boolean z = zArr[lastIndex];
            zArr[lastIndex] = zArr[nextInt];
            zArr[nextInt] = z;
        }
    }

    public static final <T extends Comparable<? super T>> void sortDescending(T[] tArr) {
        Comparator reverseOrder;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        reverseOrder = ComparisonsKt__ComparisonsKt.reverseOrder();
        ArraysKt___ArraysJvmKt.sortWith(tArr, reverseOrder);
    }

    public static final void sortDescending(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(sArr);
            reverse(sArr);
        }
    }

    public static final void sortDescending(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(iArr);
            reverse(iArr);
        }
    }

    public static final void sortDescending(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(jArr);
            reverse(jArr);
        }
    }

    public static final short[] sortedArray(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    public static final short[] sortedArrayDescending(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return sArr;
        }
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        sortDescending(copyOf);
        return copyOf;
    }

    public static final <R extends Comparable<? super R>> List<Short> sortedBy(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new ComparisonsKt__ComparisonsKt.a(selector));
    }

    public static final <R extends Comparable<? super R>> List<Boolean> sortedBy(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(zArr, new ComparisonsKt__ComparisonsKt.a(selector));
    }

    public static final <R extends Comparable<? super R>> List<Short> sortedByDescending(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(sArr, (Comparator<? super Short>) new ComparisonsKt__ComparisonsKt.c(selector));
    }

    public static final <R extends Comparable<? super R>> List<Boolean> sortedByDescending(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(zArr, new ComparisonsKt__ComparisonsKt.c(selector));
    }

    public static final List<Short> sortedWith(short[] sArr, Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Short[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(sArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final List<Boolean> sortedWith(boolean[] zArr, Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Boolean[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(zArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final IntRange getIndices(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return new IntRange(0, getLastIndex(zArr));
    }

    private static final boolean isEmpty(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length == 0;
    }

    private static final boolean isNotEmpty(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return !(zArr.length == 0);
    }

    public static final int getLastIndex(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length - 1;
    }

    public static final <T extends Comparable<? super T>> void sortDescending(T[] tArr, int i2, int i3) {
        Comparator reverseOrder;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        reverseOrder = ComparisonsKt__ComparisonsKt.reverseOrder();
        ArraysKt___ArraysJvmKt.sortWith(tArr, reverseOrder, i2, i3);
    }

    public static final void sortDescending(short[] sArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(sArr, i2, i3);
        reverse(sArr, i2, i3);
    }

    public static final void sortDescending(int[] iArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(iArr, i2, i3);
        reverse(iArr, i2, i3);
    }

    public static final void sortDescending(long[] jArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(jArr, i2, i3);
        reverse(jArr, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, V> associate(T[] tArr, Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(tArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (d.a.C0000a c0000a : tArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(c0000a);
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> associate(short[] sArr, Function1<? super Short, ? extends Pair<? extends K, ? extends V>> transform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(sArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (short s2 : sArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Short.valueOf(s2));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> associate(boolean[] zArr, Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> transform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(zArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (boolean z : zArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Boolean.valueOf(z));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <T, K> Map<K, T> associateBy(T[] tArr, Function1<? super T, ? extends K> keySelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(tArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (T t : tArr) {
            linkedHashMap.put(keySelector.invoke(t), t);
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Short> associateBy(short[] sArr, Function1<? super Short, ? extends K> keySelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(sArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (short s2 : sArr) {
            linkedHashMap.put(keySelector.invoke(Short.valueOf(s2)), Short.valueOf(s2));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Integer> associateBy(int[] iArr, Function1<? super Integer, ? extends K> keySelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(iArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (int i2 : iArr) {
            linkedHashMap.put(keySelector.invoke(Integer.valueOf(i2)), Integer.valueOf(i2));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Long> associateBy(long[] jArr, Function1<? super Long, ? extends K> keySelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(jArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (long j2 : jArr) {
            linkedHashMap.put(keySelector.invoke(Long.valueOf(j2)), Long.valueOf(j2));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Float> associateBy(float[] fArr, Function1<? super Float, ? extends K> keySelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(fArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (float f2 : fArr) {
            linkedHashMap.put(keySelector.invoke(Float.valueOf(f2)), Float.valueOf(f2));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Boolean> associateBy(boolean[] zArr, Function1<? super Boolean, ? extends K> keySelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(zArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (boolean z : zArr) {
            linkedHashMap.put(keySelector.invoke(Boolean.valueOf(z)), Boolean.valueOf(z));
        }
        return linkedHashMap;
    }

    public static final <T, K, V> Map<K, V> associateBy(T[] tArr, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(tArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (T t : tArr) {
            linkedHashMap.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> associateBy(short[] sArr, Function1<? super Short, ? extends K> keySelector, Function1<? super Short, ? extends V> valueTransform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(sArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (short s2 : sArr) {
            linkedHashMap.put(keySelector.invoke(Short.valueOf(s2)), valueTransform.invoke(Short.valueOf(s2)));
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> associateBy(int[] iArr, Function1<? super Integer, ? extends K> keySelector, Function1<? super Integer, ? extends V> valueTransform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(iArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (int i2 : iArr) {
            linkedHashMap.put(keySelector.invoke(Integer.valueOf(i2)), valueTransform.invoke(Integer.valueOf(i2)));
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> associateBy(long[] jArr, Function1<? super Long, ? extends K> keySelector, Function1<? super Long, ? extends V> valueTransform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(jArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (long j2 : jArr) {
            linkedHashMap.put(keySelector.invoke(Long.valueOf(j2)), valueTransform.invoke(Long.valueOf(j2)));
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> associateBy(float[] fArr, Function1<? super Float, ? extends K> keySelector, Function1<? super Float, ? extends V> valueTransform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(fArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (float f2 : fArr) {
            linkedHashMap.put(keySelector.invoke(Float.valueOf(f2)), valueTransform.invoke(Float.valueOf(f2)));
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> associateBy(boolean[] zArr, Function1<? super Boolean, ? extends K> keySelector, Function1<? super Boolean, ? extends V> valueTransform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(zArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (boolean z : zArr) {
            linkedHashMap.put(keySelector.invoke(Boolean.valueOf(z)), valueTransform.invoke(Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    public static final <K, M extends Map<? super K, ? super Short>> M associateByTo(short[] sArr, M destination, Function1<? super Short, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (short s2 : sArr) {
            destination.put(keySelector.invoke(Short.valueOf(s2)), Short.valueOf(s2));
        }
        return destination;
    }

    public static final <K, M extends Map<? super K, ? super Integer>> M associateByTo(int[] iArr, M destination, Function1<? super Integer, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (int i2 : iArr) {
            destination.put(keySelector.invoke(Integer.valueOf(i2)), Integer.valueOf(i2));
        }
        return destination;
    }

    public static final <K, M extends Map<? super K, ? super Long>> M associateByTo(long[] jArr, M destination, Function1<? super Long, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (long j2 : jArr) {
            destination.put(keySelector.invoke(Long.valueOf(j2)), Long.valueOf(j2));
        }
        return destination;
    }

    public static final <K, M extends Map<? super K, ? super Float>> M associateByTo(float[] fArr, M destination, Function1<? super Float, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (float f2 : fArr) {
            destination.put(keySelector.invoke(Float.valueOf(f2)), Float.valueOf(f2));
        }
        return destination;
    }

    public static final <K, M extends Map<? super K, ? super Boolean>> M associateByTo(boolean[] zArr, M destination, Function1<? super Boolean, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (boolean z : zArr) {
            destination.put(keySelector.invoke(Boolean.valueOf(z)), Boolean.valueOf(z));
        }
        return destination;
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(T[] tArr, M destination, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t : tArr) {
            destination.put(keySelector.invoke(t), valueTransform.invoke(t));
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(short[] sArr, M destination, Function1<? super Short, ? extends K> keySelector, Function1<? super Short, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (short s2 : sArr) {
            destination.put(keySelector.invoke(Short.valueOf(s2)), valueTransform.invoke(Short.valueOf(s2)));
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(int[] iArr, M destination, Function1<? super Integer, ? extends K> keySelector, Function1<? super Integer, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (int i2 : iArr) {
            destination.put(keySelector.invoke(Integer.valueOf(i2)), valueTransform.invoke(Integer.valueOf(i2)));
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(long[] jArr, M destination, Function1<? super Long, ? extends K> keySelector, Function1<? super Long, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (long j2 : jArr) {
            destination.put(keySelector.invoke(Long.valueOf(j2)), valueTransform.invoke(Long.valueOf(j2)));
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(float[] fArr, M destination, Function1<? super Float, ? extends K> keySelector, Function1<? super Float, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (float f2 : fArr) {
            destination.put(keySelector.invoke(Float.valueOf(f2)), valueTransform.invoke(Float.valueOf(f2)));
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(boolean[] zArr, M destination, Function1<? super Boolean, ? extends K> keySelector, Function1<? super Boolean, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (boolean z : zArr) {
            destination.put(keySelector.invoke(Boolean.valueOf(z)), valueTransform.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(T[] tArr, M destination, Function1<? super T, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t : tArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(t);
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(short[] sArr, M destination, Function1<? super Short, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (short s2 : sArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Short.valueOf(s2));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(boolean[] zArr, M destination, Function1<? super Boolean, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (boolean z : zArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Boolean.valueOf(z));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    public static final <K, V> Map<K, V> associateWith(K[] kArr, Function1<? super K, ? extends V> valueSelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(kArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(kArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (K k2 : kArr) {
            linkedHashMap.put(k2, valueSelector.invoke(k2));
        }
        return linkedHashMap;
    }

    private static final <V> Map<Short, V> associateWith(short[] sArr, Function1<? super Short, ? extends V> valueSelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(sArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (short s2 : sArr) {
            linkedHashMap.put(Short.valueOf(s2), valueSelector.invoke(Short.valueOf(s2)));
        }
        return linkedHashMap;
    }

    private static final <V> Map<Boolean, V> associateWith(boolean[] zArr, Function1<? super Boolean, ? extends V> valueSelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(zArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (boolean z : zArr) {
            linkedHashMap.put(Boolean.valueOf(z), valueSelector.invoke(Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    private static final <V, M extends Map<? super Short, ? super V>> M associateWithTo(short[] sArr, M destination, Function1<? super Short, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (short s2 : sArr) {
            destination.put(Short.valueOf(s2), valueSelector.invoke(Short.valueOf(s2)));
        }
        return destination;
    }

    private static final <V, M extends Map<? super Boolean, ? super V>> M associateWithTo(boolean[] zArr, M destination, Function1<? super Boolean, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (boolean z : zArr) {
            destination.put(Boolean.valueOf(z), valueSelector.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    public static final <C extends Collection<? super Short>> C toCollection(short[] sArr, C destination) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (short s2 : sArr) {
            destination.add(Short.valueOf(s2));
        }
        return destination;
    }

    public static final <C extends Collection<? super Boolean>> C toCollection(boolean[] zArr, C destination) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (boolean z : zArr) {
            destination.add(Boolean.valueOf(z));
        }
        return destination;
    }

    public static final HashSet<Short> toHashSet(short[] sArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(sArr.length);
        return (HashSet) toCollection(sArr, new HashSet(mapCapacity));
    }

    public static final HashSet<Boolean> toHashSet(boolean[] zArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(zArr.length);
        return (HashSet) toCollection(zArr, new HashSet(mapCapacity));
    }

    public static final List<Short> toList(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Short.valueOf(sArr[0]));
        }
        return toMutableList(sArr);
    }

    public static final List<Boolean> toList(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        if (length == 1) {
            return CollectionsKt__CollectionsJVMKt.listOf(Boolean.valueOf(zArr[0]));
        }
        return toMutableList(zArr);
    }

    public static final List<Boolean> toMutableList(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    public static <T> Set<T> toSet(T[] tArr) {
        Set<T> emptySet;
        Set<T> of;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        if (length == 1) {
            of = SetsKt__SetsJVMKt.setOf(tArr[0]);
            return of;
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(tArr.length);
        return (Set) toCollection(tArr, new LinkedHashSet(mapCapacity));
    }

    public static final Set<Short> toSet(short[] sArr) {
        Set<Short> emptySet;
        Set<Short> of;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        if (length == 1) {
            of = SetsKt__SetsJVMKt.setOf(Short.valueOf(sArr[0]));
            return of;
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(sArr.length);
        return (Set) toCollection(sArr, new LinkedHashSet(mapCapacity));
    }

    public static final Set<Boolean> toSet(boolean[] zArr) {
        Set<Boolean> emptySet;
        Set<Boolean> of;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        int length = zArr.length;
        if (length == 0) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        if (length == 1) {
            of = SetsKt__SetsJVMKt.setOf(Boolean.valueOf(zArr[0]));
            return of;
        }
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(zArr.length);
        return (Set) toCollection(zArr, new LinkedHashSet(mapCapacity));
    }

    public static final <T, R> List<R> flatMap(T[] tArr, Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(t));
        }
        return arrayList;
    }

    public static final <R> List<R> flatMap(short[] sArr, Function1<? super Short, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Short.valueOf(s2)));
        }
        return arrayList;
    }

    public static final <R> List<R> flatMap(boolean[] zArr, Function1<? super Boolean, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Boolean.valueOf(z)));
        }
        return arrayList;
    }

    private static final <T, R> List<R> flatMapIndexedIterable(T[] tArr, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i3), tArr[i2]));
            i2++;
            i3++;
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(short[] sArr, Function2<? super Integer, ? super Short, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i3), Short.valueOf(sArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(boolean[] zArr, Function2<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i3), Boolean.valueOf(zArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedIterableTo(T[] tArr, C destination, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i3), tArr[i2]));
            i2++;
            i3++;
        }
        return destination;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(short[] sArr, C destination, Function2<? super Integer, ? super Short, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i3), Short.valueOf(sArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(boolean[] zArr, C destination, Function2<? super Integer, ? super Boolean, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i3), Boolean.valueOf(zArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(T[] tArr, C destination, Function1<? super T, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t : tArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(t));
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(short[] sArr, C destination, Function1<? super Short, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (short s2 : sArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Short.valueOf(s2)));
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(boolean[] zArr, C destination, Function1<? super Boolean, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (boolean z : zArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    public static final <T, K> Map<K, List<T>> groupBy(T[] tArr, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : tArr) {
            K invoke = keySelector.invoke(t);
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(t);
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, List<Short>> groupBy(short[] sArr, Function1<? super Short, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s2 : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Short.valueOf(s2));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, List<Integer>> groupBy(int[] iArr, Function1<? super Integer, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Integer.valueOf(i2));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, List<Long>> groupBy(long[] jArr, Function1<? super Long, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j2 : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Long.valueOf(j2));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, List<Float>> groupBy(float[] fArr, Function1<? super Float, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f2 : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Float.valueOf(f2));
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, List<Boolean>> groupBy(boolean[] zArr, Function1<? super Boolean, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Boolean.valueOf(z));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V> Map<K, List<V>> groupBy(T[] tArr, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (d.a.C0000a c0000a : tArr) {
            K invoke = keySelector.invoke(c0000a);
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(c0000a));
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, List<V>> groupBy(short[] sArr, Function1<? super Short, ? extends K> keySelector, Function1<? super Short, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (short s2 : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s2));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Short.valueOf(s2)));
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, List<V>> groupBy(int[] iArr, Function1<? super Integer, ? extends K> keySelector, Function1<? super Integer, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i2 : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i2));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Integer.valueOf(i2)));
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, List<V>> groupBy(long[] jArr, Function1<? super Long, ? extends K> keySelector, Function1<? super Long, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (long j2 : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j2));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Long.valueOf(j2)));
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, List<V>> groupBy(float[] fArr, Function1<? super Float, ? extends K> keySelector, Function1<? super Float, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (float f2 : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f2));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Float.valueOf(f2)));
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, List<V>> groupBy(boolean[] zArr, Function1<? super Boolean, ? extends K> keySelector, Function1<? super Boolean, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (boolean z : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Boolean.valueOf(z)));
        }
        return linkedHashMap;
    }

    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(T[] tArr, M destination, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t : tArr) {
            K invoke = keySelector.invoke(t);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(t);
        }
        return destination;
    }

    public static final <K, M extends Map<? super K, List<Short>>> M groupByTo(short[] sArr, M destination, Function1<? super Short, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (short s2 : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Short.valueOf(s2));
        }
        return destination;
    }

    public static final <K, M extends Map<? super K, List<Integer>>> M groupByTo(int[] iArr, M destination, Function1<? super Integer, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (int i2 : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Integer.valueOf(i2));
        }
        return destination;
    }

    public static final <K, M extends Map<? super K, List<Long>>> M groupByTo(long[] jArr, M destination, Function1<? super Long, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (long j2 : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Long.valueOf(j2));
        }
        return destination;
    }

    public static final <K, M extends Map<? super K, List<Float>>> M groupByTo(float[] fArr, M destination, Function1<? super Float, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (float f2 : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Float.valueOf(f2));
        }
        return destination;
    }

    public static final <K, M extends Map<? super K, List<Boolean>>> M groupByTo(boolean[] zArr, M destination, Function1<? super Boolean, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (boolean z : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Boolean.valueOf(z));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(T[] tArr, M destination, Function1<? super T, ? extends K> keySelector, Function1<? super T, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (T t : tArr) {
            K invoke = keySelector.invoke(t);
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(t));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(short[] sArr, M destination, Function1<? super Short, ? extends K> keySelector, Function1<? super Short, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (short s2 : sArr) {
            K invoke = keySelector.invoke(Short.valueOf(s2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Short.valueOf(s2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(int[] iArr, M destination, Function1<? super Integer, ? extends K> keySelector, Function1<? super Integer, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (int i2 : iArr) {
            K invoke = keySelector.invoke(Integer.valueOf(i2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Integer.valueOf(i2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(long[] jArr, M destination, Function1<? super Long, ? extends K> keySelector, Function1<? super Long, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (long j2 : jArr) {
            K invoke = keySelector.invoke(Long.valueOf(j2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Long.valueOf(j2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(float[] fArr, M destination, Function1<? super Float, ? extends K> keySelector, Function1<? super Float, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (float f2 : fArr) {
            K invoke = keySelector.invoke(Float.valueOf(f2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Float.valueOf(f2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(boolean[] zArr, M destination, Function1<? super Boolean, ? extends K> keySelector, Function1<? super Boolean, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (boolean z : zArr) {
            K invoke = keySelector.invoke(Boolean.valueOf(z));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    public static final <T, R> List<R> map(T[] tArr, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        for (T t : tArr) {
            arrayList.add(transform.invoke(t));
        }
        return arrayList;
    }

    public static final <R> List<R> map(short[] sArr, Function1<? super Short, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s2 : sArr) {
            arrayList.add(transform.invoke(Short.valueOf(s2)));
        }
        return arrayList;
    }

    public static final <R> List<R> map(boolean[] zArr, Function1<? super Boolean, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        for (boolean z : zArr) {
            arrayList.add(transform.invoke(Boolean.valueOf(z)));
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexed(T[] tArr, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(tArr.length);
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i3), tArr[i2]));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(short[] sArr, Function2<? super Integer, ? super Short, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(sArr.length);
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i3), Short.valueOf(sArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(boolean[] zArr, Function2<? super Integer, ? super Boolean, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(zArr.length);
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i3), Boolean.valueOf(zArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(T[] tArr, C destination, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            destination.add(transform.invoke(Integer.valueOf(i3), tArr[i2]));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(short[] sArr, C destination, Function2<? super Integer, ? super Short, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            destination.add(transform.invoke(Integer.valueOf(i3), Short.valueOf(sArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(boolean[] zArr, C destination, Function2<? super Integer, ? super Boolean, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            destination.add(transform.invoke(Integer.valueOf(i3), Boolean.valueOf(zArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(short[] sArr, C destination, Function1<? super Short, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (short s2 : sArr) {
            destination.add(transform.invoke(Short.valueOf(s2)));
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(boolean[] zArr, C destination, Function1<? super Boolean, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (boolean z : zArr) {
            destination.add(transform.invoke(Boolean.valueOf(z)));
        }
        return destination;
    }

    public static final Iterable<IndexedValue<Boolean>> withIndex(final boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return new b0(new Function0() { // from class: kotlin.collections.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator a2;
                a2 = kotlin.jvm.internal.h.a(zArr);
                return a2;
            }
        });
    }

    public static final List<Boolean> distinct(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(zArr));
    }

    public static final <T, K> List<T> distinctBy(T[] tArr, Function1<? super T, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            if (hashSet.add(selector.invoke(t))) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <K> List<Short> distinctBy(short[] sArr, Function1<? super Short, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (short s2 : sArr) {
            if (hashSet.add(selector.invoke(Short.valueOf(s2)))) {
                arrayList.add(Short.valueOf(s2));
            }
        }
        return arrayList;
    }

    public static final <K> List<Boolean> distinctBy(boolean[] zArr, Function1<? super Boolean, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (boolean z : zArr) {
            if (hashSet.add(selector.invoke(Boolean.valueOf(z)))) {
                arrayList.add(Boolean.valueOf(z));
            }
        }
        return arrayList;
    }

    public static final Set<Short> intersect(short[] sArr, Iterable<Short> other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final Set<Boolean> intersect(boolean[] zArr, Iterable<Boolean> other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final Set<Short> subtract(short[] sArr, Iterable<Short> other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final Set<Boolean> subtract(boolean[] zArr, Iterable<Boolean> other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    public static final Set<Short> toMutableSet(short[] sArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(sArr.length);
        return (Set) toCollection(sArr, new LinkedHashSet(mapCapacity));
    }

    public static final Set<Boolean> toMutableSet(boolean[] zArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(zArr.length);
        return (Set) toCollection(zArr, new LinkedHashSet(mapCapacity));
    }

    public static final Set<Short> union(short[] sArr, Iterable<Short> other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Short> mutableSet = toMutableSet(sArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final Set<Boolean> union(boolean[] zArr, Iterable<Boolean> other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Boolean> mutableSet = toMutableSet(zArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final <T> boolean all(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (!predicate.invoke(t).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean all(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (!predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean all(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (!predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean any(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return !(tArr.length == 0);
    }

    public static final boolean any(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return !(sArr.length == 0);
    }

    public static final boolean any(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return !(iArr.length == 0);
    }

    public static final boolean any(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return !(jArr.length == 0);
    }

    public static final boolean any(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return !(zArr.length == 0);
    }

    public static final <T> boolean any(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean any(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean any(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i2 : iArr) {
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean any(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j2 : jArr) {
            if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean any(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private static final <T> int count(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length;
    }

    private static final int count(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length;
    }

    private static final int count(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length;
    }

    private static final int count(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length;
    }

    public static final <T> int count(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final int count(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        for (short s2 : sArr) {
            if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final int count(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        for (int i3 : iArr) {
            if (predicate.invoke(Integer.valueOf(i3)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final int count(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        for (long j2 : jArr) {
            if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final int count(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final <R> R fold(short[] sArr, R r2, Function2<? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (short s2 : sArr) {
            r2 = operation.invoke(r2, Short.valueOf(s2));
        }
        return r2;
    }

    public static final <R> R fold(boolean[] zArr, R r2, Function2<? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (boolean z : zArr) {
            r2 = operation.invoke(r2, Boolean.valueOf(z));
        }
        return r2;
    }

    public static final <R> R foldIndexed(short[] sArr, R r2, Function3<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            R r3 = r2;
            r2 = operation.invoke(Integer.valueOf(i3), r3, Short.valueOf(sArr[i2]));
            i2++;
            i3++;
        }
        return r2;
    }

    public static final <R> R foldIndexed(boolean[] zArr, R r2, Function3<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            R r3 = r2;
            r2 = operation.invoke(Integer.valueOf(i3), r3, Boolean.valueOf(zArr[i2]));
            i2++;
            i3++;
        }
        return r2;
    }

    public static final <R> R foldRight(short[] sArr, R r2, Function2<? super Short, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Short.valueOf(sArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRight(boolean[] zArr, R r2, Function2<? super Boolean, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Boolean.valueOf(zArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(short[] sArr, R r2, Function3<? super Integer, ? super Short, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(sArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Integer.valueOf(lastIndex), Short.valueOf(sArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(boolean[] zArr, R r2, Function3<? super Integer, ? super Boolean, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(zArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Integer.valueOf(lastIndex), Boolean.valueOf(zArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final void forEach(short[] sArr, Function1<? super Short, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (short s2 : sArr) {
            action.invoke(Short.valueOf(s2));
        }
    }

    public static final void forEach(boolean[] zArr, Function1<? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (boolean z : zArr) {
            action.invoke(Boolean.valueOf(z));
        }
    }

    public static final void forEachIndexed(short[] sArr, Function2<? super Integer, ? super Short, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Short.valueOf(sArr[i2]));
            i2++;
            i3++;
        }
    }

    public static final void forEachIndexed(boolean[] zArr, Function2<? super Integer, ? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Boolean.valueOf(zArr[i2]));
            i2++;
            i3++;
        }
    }

    public static final <T extends Comparable<? super T>> T maxOrThrow(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                if (t.compareTo(t2) < 0) {
                    t = t2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    public static final short maxOrThrow(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                if (s2 < s3) {
                    s2 = s3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return s2;
    }

    public static int maxOrThrow(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i2 = 1;
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (i3 < i4) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return i3;
    }

    public static final long maxOrThrow(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                if (j2 < j3) {
                    j2 = j3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return j2;
    }

    public static final <T, R extends Comparable<? super R>> T maxByOrThrow(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex == 0) {
            return t;
        }
        R invoke = selector.invoke(t);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                R invoke2 = selector.invoke(t2);
                if (invoke.compareTo(invoke2) < 0) {
                    t = t2;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    public static final <R extends Comparable<? super R>> short maxByOrThrow(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return s2;
        }
        R invoke = selector.invoke(Short.valueOf(s2));
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                R invoke2 = selector.invoke(Short.valueOf(s3));
                if (invoke.compareTo(invoke2) < 0) {
                    s2 = s3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return s2;
    }

    public static final <R extends Comparable<? super R>> long maxByOrThrow(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return j2;
        }
        R invoke = selector.invoke(Long.valueOf(j2));
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                R invoke2 = selector.invoke(Long.valueOf(j3));
                if (invoke.compareTo(invoke2) < 0) {
                    j2 = j3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return j2;
    }

    public static final <R extends Comparable<? super R>> boolean maxByOrThrow(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return z;
        }
        R invoke = selector.invoke(Boolean.valueOf(z));
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i2];
                R invoke2 = selector.invoke(Boolean.valueOf(z2));
                if (invoke.compareTo(invoke2) < 0) {
                    z = z2;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return z;
    }

    public static final <R extends Comparable<? super R>> Short maxByOrNull(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s2);
        }
        R invoke = selector.invoke(Short.valueOf(s2));
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                R invoke2 = selector.invoke(Short.valueOf(s3));
                if (invoke.compareTo(invoke2) < 0) {
                    s2 = s3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final <R extends Comparable<? super R>> Integer maxByOrNull(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        R invoke = selector.invoke(Integer.valueOf(i3));
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                R invoke2 = selector.invoke(Integer.valueOf(i4));
                if (invoke.compareTo(invoke2) < 0) {
                    i3 = i4;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final <R extends Comparable<? super R>> Long maxByOrNull(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j2);
        }
        R invoke = selector.invoke(Long.valueOf(j2));
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                R invoke2 = selector.invoke(Long.valueOf(j3));
                if (invoke.compareTo(invoke2) < 0) {
                    j2 = j3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    private static final <T> double maxOf(T[] tArr, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(tArr[0]).doubleValue();
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(tArr[i2]).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return doubleValue;
    }

    private static final double maxOf(short[] sArr, Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Short.valueOf(sArr[0])).doubleValue();
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Short.valueOf(sArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return doubleValue;
    }

    private static final double maxOf(long[] jArr, Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Long.valueOf(jArr[0])).doubleValue();
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Long.valueOf(jArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return doubleValue;
    }

    private static final double maxOf(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Boolean.valueOf(zArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return doubleValue;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final <T> float m909maxOf(T[] tArr, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(tArr[0]).floatValue();
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(tArr[i2]).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final float m903maxOf(byte[] bArr, Function1<? super Byte, Float> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Byte.valueOf(bArr[0])).floatValue();
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Byte.valueOf(bArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final float m910maxOf(short[] sArr, Function1<? super Short, Float> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Short.valueOf(sArr[0])).floatValue();
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Short.valueOf(sArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final float m907maxOf(int[] iArr, Function1<? super Integer, Float> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Integer.valueOf(iArr[0])).floatValue();
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Integer.valueOf(iArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final float m908maxOf(long[] jArr, Function1<? super Long, Float> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Long.valueOf(jArr[0])).floatValue();
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Long.valueOf(jArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final float m906maxOf(float[] fArr, Function1<? super Float, Float> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Float.valueOf(fArr[0])).floatValue();
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Float.valueOf(fArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final float m905maxOf(double[] dArr, Function1<? super Double, Float> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Double.valueOf(dArr[0])).floatValue();
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Double.valueOf(dArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final float m911maxOf(boolean[] zArr, Function1<? super Boolean, Float> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Boolean.valueOf(zArr[0])).floatValue();
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Boolean.valueOf(zArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final float m904maxOf(char[] cArr, Function1<? super Character, Float> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Character.valueOf(cArr[0])).floatValue();
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Character.valueOf(cArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m912maxOf(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Byte.valueOf(bArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m919maxOf(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Short.valueOf(sArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m916maxOf(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Integer.valueOf(iArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m917maxOf(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Long.valueOf(jArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m915maxOf(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Float.valueOf(fArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m914maxOf(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Double.valueOf(dArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m920maxOf(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Boolean.valueOf(zArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m913maxOf(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Character.valueOf(cArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Double m927maxOfOrNull(T[] tArr, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(tArr[0]).doubleValue();
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(tArr[i2]).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m921maxOfOrNull(byte[] bArr, Function1<? super Byte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Byte.valueOf(bArr[0])).doubleValue();
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Byte.valueOf(bArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m928maxOfOrNull(short[] sArr, Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Short.valueOf(sArr[0])).doubleValue();
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Short.valueOf(sArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m925maxOfOrNull(int[] iArr, Function1<? super Integer, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Integer.valueOf(iArr[0])).doubleValue();
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Integer.valueOf(iArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m926maxOfOrNull(long[] jArr, Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Long.valueOf(jArr[0])).doubleValue();
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Long.valueOf(jArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m924maxOfOrNull(float[] fArr, Function1<? super Float, Double> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Float.valueOf(fArr[0])).doubleValue();
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Float.valueOf(fArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m923maxOfOrNull(double[] dArr, Function1<? super Double, Double> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Double.valueOf(dArr[0])).doubleValue();
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Double.valueOf(dArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m929maxOfOrNull(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Boolean.valueOf(zArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Double m922maxOfOrNull(char[] cArr, Function1<? super Character, Double> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Character.valueOf(cArr[0])).doubleValue();
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, selector.invoke(Character.valueOf(cArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Float m936maxOfOrNull(T[] tArr, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(tArr[0]).floatValue();
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(tArr[i2]).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m930maxOfOrNull(byte[] bArr, Function1<? super Byte, Float> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Byte.valueOf(bArr[0])).floatValue();
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Byte.valueOf(bArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m937maxOfOrNull(short[] sArr, Function1<? super Short, Float> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Short.valueOf(sArr[0])).floatValue();
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Short.valueOf(sArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m934maxOfOrNull(int[] iArr, Function1<? super Integer, Float> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Integer.valueOf(iArr[0])).floatValue();
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Integer.valueOf(iArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m935maxOfOrNull(long[] jArr, Function1<? super Long, Float> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Long.valueOf(jArr[0])).floatValue();
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Long.valueOf(jArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m933maxOfOrNull(float[] fArr, Function1<? super Float, Float> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Float.valueOf(fArr[0])).floatValue();
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Float.valueOf(fArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m932maxOfOrNull(double[] dArr, Function1<? super Double, Float> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Double.valueOf(dArr[0])).floatValue();
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Double.valueOf(dArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m938maxOfOrNull(boolean[] zArr, Function1<? super Boolean, Float> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Boolean.valueOf(zArr[0])).floatValue();
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Boolean.valueOf(zArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final Float m931maxOfOrNull(char[] cArr, Function1<? super Character, Float> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Character.valueOf(cArr[0])).floatValue();
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, selector.invoke(Character.valueOf(cArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Short.valueOf(sArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Long.valueOf(jArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Boolean.valueOf(zArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWith(short[] sArr, Comparator<? super R> comparator, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Short.valueOf(sArr[i2]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWith(long[] jArr, Comparator<? super R> comparator, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Long.valueOf(jArr[i2]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWith(boolean[] zArr, Comparator<? super R> comparator, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Boolean.valueOf(zArr[i2]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWithOrNull(short[] sArr, Comparator<? super R> comparator, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Short.valueOf(sArr[i2]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWithOrNull(long[] jArr, Comparator<? super R> comparator, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Long.valueOf(jArr[i2]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWithOrNull(boolean[] zArr, Comparator<? super R> comparator, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Boolean.valueOf(zArr[i2]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    public static final Float maxOrNull(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = fArr[0].floatValue();
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.max(floatValue, fArr[i2].floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    public static final Short maxOrNull(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                if (s2 < s3) {
                    s2 = s3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static Integer maxOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (i3 < i4) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final Long maxOrNull(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                if (j2 < j3) {
                    j2 = j3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final <T> T maxWithOrThrow(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                if (comparator.compare(t, t2) < 0) {
                    t = t2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    public static final short maxWithOrThrow(short[] sArr, Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                if (comparator.compare(Short.valueOf(s2), Short.valueOf(s3)) < 0) {
                    s2 = s3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return s2;
    }

    public static final boolean maxWithOrThrow(boolean[] zArr, Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i2];
                if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) < 0) {
                    z = z2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return z;
    }

    public static final <T> T maxWithOrNull(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                if (comparator.compare(t, t2) < 0) {
                    t = t2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    public static final Short maxWithOrNull(short[] sArr, Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                if (comparator.compare(Short.valueOf(s2), Short.valueOf(s3)) < 0) {
                    s2 = s3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final Long maxWithOrNull(long[] jArr, Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                if (comparator.compare(Long.valueOf(j2), Long.valueOf(j3)) < 0) {
                    j2 = j3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final <T extends Comparable<? super T>> T minOrThrow(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                if (t.compareTo(t2) > 0) {
                    t = t2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    public static final short minOrThrow(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                if (s2 > s3) {
                    s2 = s3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return s2;
    }

    public static int minOrThrow(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i2 = 1;
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (i3 > i4) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return i3;
    }

    public static final long minOrThrow(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                if (j2 > j3) {
                    j2 = j3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return j2;
    }

    public static final <T, R extends Comparable<? super R>> T minByOrThrow(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex == 0) {
            return t;
        }
        R invoke = selector.invoke(t);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                R invoke2 = selector.invoke(t2);
                if (invoke.compareTo(invoke2) > 0) {
                    t = t2;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    public static final <R extends Comparable<? super R>> short minByOrThrow(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return s2;
        }
        R invoke = selector.invoke(Short.valueOf(s2));
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                R invoke2 = selector.invoke(Short.valueOf(s3));
                if (invoke.compareTo(invoke2) > 0) {
                    s2 = s3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return s2;
    }

    public static final <R extends Comparable<? super R>> long minByOrThrow(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return j2;
        }
        R invoke = selector.invoke(Long.valueOf(j2));
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                R invoke2 = selector.invoke(Long.valueOf(j3));
                if (invoke.compareTo(invoke2) > 0) {
                    j2 = j3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return j2;
    }

    public static final <R extends Comparable<? super R>> boolean minByOrThrow(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return z;
        }
        R invoke = selector.invoke(Boolean.valueOf(z));
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i2];
                R invoke2 = selector.invoke(Boolean.valueOf(z2));
                if (invoke.compareTo(invoke2) > 0) {
                    z = z2;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return z;
    }

    public static final <R extends Comparable<? super R>> Short minByOrNull(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (lastIndex == 0) {
            return Short.valueOf(s2);
        }
        R invoke = selector.invoke(Short.valueOf(s2));
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                R invoke2 = selector.invoke(Short.valueOf(s3));
                if (invoke.compareTo(invoke2) > 0) {
                    s2 = s3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final <R extends Comparable<? super R>> Integer minByOrNull(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex == 0) {
            return Integer.valueOf(i3);
        }
        R invoke = selector.invoke(Integer.valueOf(i3));
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                R invoke2 = selector.invoke(Integer.valueOf(i4));
                if (invoke.compareTo(invoke2) > 0) {
                    i3 = i4;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final <R extends Comparable<? super R>> Long minByOrNull(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex == 0) {
            return Long.valueOf(j2);
        }
        R invoke = selector.invoke(Long.valueOf(j2));
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                R invoke2 = selector.invoke(Long.valueOf(j3));
                if (invoke.compareTo(invoke2) > 0) {
                    j2 = j3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    private static final <T> double minOf(T[] tArr, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(tArr[0]).doubleValue();
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(tArr[i2]).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return doubleValue;
    }

    private static final double minOf(short[] sArr, Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Short.valueOf(sArr[0])).doubleValue();
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Short.valueOf(sArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return doubleValue;
    }

    private static final double minOf(long[] jArr, Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Long.valueOf(jArr[0])).doubleValue();
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Long.valueOf(jArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return doubleValue;
    }

    private static final double minOf(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        double doubleValue = selector.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Boolean.valueOf(zArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return doubleValue;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final <T> float m945minOf(T[] tArr, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(tArr[0]).floatValue();
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(tArr[i2]).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final float m939minOf(byte[] bArr, Function1<? super Byte, Float> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Byte.valueOf(bArr[0])).floatValue();
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Byte.valueOf(bArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final float m946minOf(short[] sArr, Function1<? super Short, Float> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Short.valueOf(sArr[0])).floatValue();
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Short.valueOf(sArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final float m943minOf(int[] iArr, Function1<? super Integer, Float> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Integer.valueOf(iArr[0])).floatValue();
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Integer.valueOf(iArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final float m944minOf(long[] jArr, Function1<? super Long, Float> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Long.valueOf(jArr[0])).floatValue();
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Long.valueOf(jArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final float m942minOf(float[] fArr, Function1<? super Float, Float> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Float.valueOf(fArr[0])).floatValue();
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Float.valueOf(fArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final float m941minOf(double[] dArr, Function1<? super Double, Float> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Double.valueOf(dArr[0])).floatValue();
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Double.valueOf(dArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final float m947minOf(boolean[] zArr, Function1<? super Boolean, Float> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Boolean.valueOf(zArr[0])).floatValue();
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Boolean.valueOf(zArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final float m940minOf(char[] cArr, Function1<? super Character, Float> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        float floatValue = selector.invoke(Character.valueOf(cArr[0])).floatValue();
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Character.valueOf(cArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return floatValue;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m948minOf(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Byte.valueOf(bArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m955minOf(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Short.valueOf(sArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m952minOf(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Integer.valueOf(iArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m953minOf(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Long.valueOf(jArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m951minOf(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Float.valueOf(fArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m950minOf(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Double.valueOf(dArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m956minOf(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Boolean.valueOf(zArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final <R extends Comparable<? super R>> R m949minOf(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            throw new NoSuchElementException();
        }
        R invoke = selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Character.valueOf(cArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Double m963minOfOrNull(T[] tArr, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(tArr[0]).doubleValue();
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(tArr[i2]).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m957minOfOrNull(byte[] bArr, Function1<? super Byte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Byte.valueOf(bArr[0])).doubleValue();
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Byte.valueOf(bArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m964minOfOrNull(short[] sArr, Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Short.valueOf(sArr[0])).doubleValue();
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Short.valueOf(sArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m961minOfOrNull(int[] iArr, Function1<? super Integer, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Integer.valueOf(iArr[0])).doubleValue();
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Integer.valueOf(iArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m962minOfOrNull(long[] jArr, Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Long.valueOf(jArr[0])).doubleValue();
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Long.valueOf(jArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m960minOfOrNull(float[] fArr, Function1<? super Float, Double> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Float.valueOf(fArr[0])).doubleValue();
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Float.valueOf(fArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m959minOfOrNull(double[] dArr, Function1<? super Double, Double> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Double.valueOf(dArr[0])).doubleValue();
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Double.valueOf(dArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m965minOfOrNull(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Boolean.valueOf(zArr[0])).doubleValue();
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Boolean.valueOf(zArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Double m958minOfOrNull(char[] cArr, Function1<? super Character, Double> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        double doubleValue = selector.invoke(Character.valueOf(cArr[0])).doubleValue();
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, selector.invoke(Character.valueOf(cArr[i2])).doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Float m972minOfOrNull(T[] tArr, Function1<? super T, Float> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(tArr[0]).floatValue();
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(tArr[i2]).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m966minOfOrNull(byte[] bArr, Function1<? super Byte, Float> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Byte.valueOf(bArr[0])).floatValue();
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Byte.valueOf(bArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m973minOfOrNull(short[] sArr, Function1<? super Short, Float> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Short.valueOf(sArr[0])).floatValue();
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Short.valueOf(sArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m970minOfOrNull(int[] iArr, Function1<? super Integer, Float> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Integer.valueOf(iArr[0])).floatValue();
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Integer.valueOf(iArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m971minOfOrNull(long[] jArr, Function1<? super Long, Float> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Long.valueOf(jArr[0])).floatValue();
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Long.valueOf(jArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m969minOfOrNull(float[] fArr, Function1<? super Float, Float> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Float.valueOf(fArr[0])).floatValue();
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Float.valueOf(fArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m968minOfOrNull(double[] dArr, Function1<? super Double, Float> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Double.valueOf(dArr[0])).floatValue();
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Double.valueOf(dArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m974minOfOrNull(boolean[] zArr, Function1<? super Boolean, Float> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Boolean.valueOf(zArr[0])).floatValue();
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Boolean.valueOf(zArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    /* renamed from: minOfOrNull, reason: collision with other method in class */
    private static final Float m967minOfOrNull(char[] cArr, Function1<? super Character, Float> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            return null;
        }
        float floatValue = selector.invoke(Character.valueOf(cArr[0])).floatValue();
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, selector.invoke(Character.valueOf(cArr[i2])).floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(short[] sArr, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Short.valueOf(sArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Long.valueOf(jArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        R invoke = selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Boolean.valueOf(zArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWith(short[] sArr, Comparator<? super R> comparator, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Short.valueOf(sArr[i2]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWith(long[] jArr, Comparator<? super R> comparator, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Long.valueOf(jArr[i2]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWith(boolean[] zArr, Comparator<? super R> comparator, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        Object obj = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Boolean.valueOf(zArr[i2]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWithOrNull(short[] sArr, Comparator<? super R> comparator, Function1<? super Short, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Short.valueOf(sArr[0]));
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Short.valueOf(sArr[i2]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWithOrNull(long[] jArr, Comparator<? super R> comparator, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Long.valueOf(jArr[0]));
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Long.valueOf(jArr[i2]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWithOrNull(boolean[] zArr, Comparator<? super R> comparator, Function1<? super Boolean, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            return null;
        }
        Object obj = (R) selector.invoke(Boolean.valueOf(zArr[0]));
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Boolean.valueOf(zArr[i2]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    public static final Float minOrNull(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int i2 = 1;
        if (fArr.length == 0) {
            return null;
        }
        float floatValue = fArr[0].floatValue();
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                floatValue = Math.min(floatValue, fArr[i2].floatValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(floatValue);
    }

    public static final Short minOrNull(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                if (s2 > s3) {
                    s2 = s3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static Integer minOrNull(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i2 = 1;
        if (iArr.length == 0) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (i3 > i4) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final Long minOrNull(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                if (j2 > j3) {
                    j2 = j3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final <T> T minWithOrThrow(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new NoSuchElementException();
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                if (comparator.compare(t, t2) > 0) {
                    t = t2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    public static final short minWithOrThrow(short[] sArr, Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new NoSuchElementException();
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                if (comparator.compare(Short.valueOf(s2), Short.valueOf(s3)) > 0) {
                    s2 = s3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return s2;
    }

    public static final boolean minWithOrThrow(boolean[] zArr, Comparator<? super Boolean> comparator) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new NoSuchElementException();
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                boolean z2 = zArr[i2];
                if (comparator.compare(Boolean.valueOf(z), Boolean.valueOf(z2)) > 0) {
                    z = z2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return z;
    }

    public static final <T> T minWithOrNull(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                if (comparator.compare(t, t2) > 0) {
                    t = t2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    public static final Short minWithOrNull(short[] sArr, Comparator<? super Short> comparator) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                short s3 = sArr[i2];
                if (comparator.compare(Short.valueOf(s2), Short.valueOf(s3)) > 0) {
                    s2 = s3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final Long minWithOrNull(long[] jArr, Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                long j3 = jArr[i2];
                if (comparator.compare(Long.valueOf(j2), Long.valueOf(j3)) > 0) {
                    j2 = j3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final <T> boolean none(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length == 0;
    }

    public static final boolean none(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length == 0;
    }

    public static final boolean none(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length == 0;
    }

    public static final boolean none(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length == 0;
    }

    public static final boolean none(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length == 0;
    }

    public static final <T> boolean none(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean none(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean none(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i2 : iArr) {
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean none(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j2 : jArr) {
            if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean none(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private static final short[] onEach(short[] sArr, Function1<? super Short, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (short s2 : sArr) {
            action.invoke(Short.valueOf(s2));
        }
        return sArr;
    }

    private static final boolean[] onEach(boolean[] zArr, Function1<? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (boolean z : zArr) {
            action.invoke(Boolean.valueOf(z));
        }
        return zArr;
    }

    public static final <S, T extends S> S reduce(T[] tArr, Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (tArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s2 = (Object) tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                s2 = operation.invoke(s2, (Object) tArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return s2;
    }

    public static final short reduce(short[] sArr, Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                s2 = operation.invoke(Short.valueOf(s2), Short.valueOf(sArr[i2])).shortValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return s2;
    }

    public static final boolean reduce(boolean[] zArr, Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                z = operation.invoke(Boolean.valueOf(z), Boolean.valueOf(zArr[i2])).booleanValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return z;
    }

    public static final short reduceIndexed(short[] sArr, Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (sArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                s2 = operation.invoke(Integer.valueOf(i2), Short.valueOf(s2), Short.valueOf(sArr[i2])).shortValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return s2;
    }

    public static final long reduceIndexed(long[] jArr, Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (jArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                j2 = operation.invoke(Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(jArr[i2])).longValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return j2;
    }

    public static final boolean reduceIndexed(boolean[] zArr, Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (zArr.length == 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean z = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                z = operation.invoke(Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(zArr[i2])).booleanValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return z;
    }

    public static final <S, T extends S> S reduceIndexedOrNull(T[] tArr, Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        S s2 = (Object) tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                s2 = operation.invoke(Integer.valueOf(i2), s2, (Object) tArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return s2;
    }

    public static final Short reduceIndexedOrNull(short[] sArr, Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                s2 = operation.invoke(Integer.valueOf(i2), Short.valueOf(s2), Short.valueOf(sArr[i2])).shortValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final Long reduceIndexedOrNull(long[] jArr, Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                j2 = operation.invoke(Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(jArr[i2])).longValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final <S, T extends S> S reduceOrNull(T[] tArr, Function2<? super S, ? super T, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (tArr.length == 0) {
            return null;
        }
        S s2 = (Object) tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                s2 = operation.invoke(s2, (Object) tArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return s2;
    }

    public static final Short reduceOrNull(short[] sArr, Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (sArr.length == 0) {
            return null;
        }
        short s2 = sArr[0];
        int lastIndex = getLastIndex(sArr);
        if (1 <= lastIndex) {
            while (true) {
                s2 = operation.invoke(Short.valueOf(s2), Short.valueOf(sArr[i2])).shortValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Short.valueOf(s2);
    }

    public static final Long reduceOrNull(long[] jArr, Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (jArr.length == 0) {
            return null;
        }
        long j2 = jArr[0];
        int lastIndex = getLastIndex(jArr);
        if (1 <= lastIndex) {
            while (true) {
                j2 = operation.invoke(Long.valueOf(j2), Long.valueOf(jArr[i2])).longValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Long.valueOf(j2);
    }

    public static final <S, T extends S> S reduceRight(T[] tArr, Function2<? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s2 = (S) tArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            s2 = operation.invoke((Object) tArr[i2], s2);
        }
        return s2;
    }

    public static final short reduceRight(short[] sArr, Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short s2 = sArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            s2 = operation.invoke(Short.valueOf(sArr[i2]), Short.valueOf(s2)).shortValue();
        }
        return s2;
    }

    public static final boolean reduceRight(boolean[] zArr, Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean z = zArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            z = operation.invoke(Boolean.valueOf(zArr[i2]), Boolean.valueOf(z)).booleanValue();
        }
        return z;
    }

    public static final <S, T extends S> S reduceRightIndexed(T[] tArr, Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        S s2 = (S) tArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            s2 = operation.invoke(Integer.valueOf(i2), (Object) tArr[i2], s2);
        }
        return s2;
    }

    public static final short reduceRightIndexed(short[] sArr, Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        short s2 = sArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            s2 = operation.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i2]), Short.valueOf(s2)).shortValue();
        }
        return s2;
    }

    public static final boolean reduceRightIndexed(boolean[] zArr, Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            throw new UnsupportedOperationException("Empty array can't be reduced.");
        }
        boolean z = zArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            z = operation.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i2]), Boolean.valueOf(z)).booleanValue();
        }
        return z;
    }

    public static final <S, T extends S> S reduceRightIndexedOrNull(T[] tArr, Function3<? super Integer, ? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            return null;
        }
        S s2 = (S) tArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            s2 = operation.invoke(Integer.valueOf(i2), (Object) tArr[i2], s2);
        }
        return s2;
    }

    public static final Short reduceRightIndexedOrNull(short[] sArr, Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short s2 = sArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            s2 = operation.invoke(Integer.valueOf(i2), Short.valueOf(sArr[i2]), Short.valueOf(s2)).shortValue();
        }
        return Short.valueOf(s2);
    }

    public static final Long reduceRightIndexedOrNull(long[] jArr, Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long j2 = jArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            j2 = operation.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i2]), Long.valueOf(j2)).longValue();
        }
        return Long.valueOf(j2);
    }

    public static final <S, T extends S> S reduceRightOrNull(T[] tArr, Function2<? super T, ? super S, ? extends S> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(tArr);
        if (lastIndex < 0) {
            return null;
        }
        S s2 = (S) tArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            s2 = operation.invoke((Object) tArr[i2], s2);
        }
        return s2;
    }

    public static final Short reduceRightOrNull(short[] sArr, Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(sArr);
        if (lastIndex < 0) {
            return null;
        }
        short s2 = sArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            s2 = operation.invoke(Short.valueOf(sArr[i2]), Short.valueOf(s2)).shortValue();
        }
        return Short.valueOf(s2);
    }

    public static final Long reduceRightOrNull(long[] jArr, Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex < 0) {
            return null;
        }
        long j2 = jArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            j2 = operation.invoke(Long.valueOf(jArr[i2]), Long.valueOf(j2)).longValue();
        }
        return Long.valueOf(j2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> List<R> runningFold(T[] tArr, R r2, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r2);
        for (d.a.C0000a c0000a : tArr) {
            r2 = operation.invoke(r2, c0000a);
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFold(short[] sArr, R r2, Function2<? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r2);
        for (short s2 : sArr) {
            r2 = operation.invoke(r2, Short.valueOf(s2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFold(boolean[] zArr, R r2, Function2<? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r2);
        for (boolean z : zArr) {
            r2 = operation.invoke(r2, Boolean.valueOf(z));
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> List<R> runningFoldIndexed(T[] tArr, R r2, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r2);
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, tArr[i2]);
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(short[] sArr, R r2, Function3<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r2);
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Short.valueOf(sArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(boolean[] zArr, R r2, Function3<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r2);
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Boolean.valueOf(zArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final List<Short> runningReduce(short[] sArr, Function2<? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        short s2 = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(s2));
        int length = sArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            s2 = operation.invoke(Short.valueOf(s2), Short.valueOf(sArr[i2])).shortValue();
            arrayList.add(Short.valueOf(s2));
        }
        return arrayList;
    }

    private static final List<Long> runningReduce(long[] jArr, Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        long j2 = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(j2));
        int length = jArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            j2 = operation.invoke(Long.valueOf(j2), Long.valueOf(jArr[i2])).longValue();
            arrayList.add(Long.valueOf(j2));
        }
        return arrayList;
    }

    private static final List<Boolean> runningReduce(boolean[] zArr, Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        boolean z = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(z));
        int length = zArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            z = operation.invoke(Boolean.valueOf(z), Boolean.valueOf(zArr[i2])).booleanValue();
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    private static final List<Short> runningReduceIndexed(short[] sArr, Function3<? super Integer, ? super Short, ? super Short, Short> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        short s2 = sArr[0];
        ArrayList arrayList = new ArrayList(sArr.length);
        arrayList.add(Short.valueOf(s2));
        int length = sArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            s2 = operation.invoke(Integer.valueOf(i2), Short.valueOf(s2), Short.valueOf(sArr[i2])).shortValue();
            arrayList.add(Short.valueOf(s2));
        }
        return arrayList;
    }

    private static final List<Long> runningReduceIndexed(long[] jArr, Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        long j2 = jArr[0];
        ArrayList arrayList = new ArrayList(jArr.length);
        arrayList.add(Long.valueOf(j2));
        int length = jArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            j2 = operation.invoke(Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(jArr[i2])).longValue();
            arrayList.add(Long.valueOf(j2));
        }
        return arrayList;
    }

    private static final List<Boolean> runningReduceIndexed(boolean[] zArr, Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        boolean z = zArr[0];
        ArrayList arrayList = new ArrayList(zArr.length);
        arrayList.add(Boolean.valueOf(z));
        int length = zArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            z = operation.invoke(Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(zArr[i2])).booleanValue();
            arrayList.add(Boolean.valueOf(z));
        }
        return arrayList;
    }

    private static final <R> List<R> scan(short[] sArr, R r2, Function2<? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r2);
        for (short s2 : sArr) {
            r2 = operation.invoke(r2, Short.valueOf(s2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scan(boolean[] zArr, R r2, Function2<? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r2);
        for (boolean z : zArr) {
            r2 = operation.invoke(r2, Boolean.valueOf(z));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(short[] sArr, R r2, Function3<? super Integer, ? super R, ? super Short, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (sArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(sArr.length + 1);
        arrayList.add(r2);
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Short.valueOf(sArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(boolean[] zArr, R r2, Function3<? super Integer, ? super R, ? super Boolean, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (zArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(zArr.length + 1);
        arrayList.add(r2);
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Boolean.valueOf(zArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(short[] sArr, Function1<? super Short, Integer> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (short s2 : sArr) {
            i2 += selector.invoke(Short.valueOf(s2)).intValue();
        }
        return i2;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(boolean[] zArr, Function1<? super Boolean, Integer> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (boolean z : zArr) {
            i2 += selector.invoke(Boolean.valueOf(z)).intValue();
        }
        return i2;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> double sumByDouble(T[] tArr, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (T t : tArr) {
            d2 += selector.invoke(t).doubleValue();
        }
        return d2;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(short[] sArr, Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (short s2 : sArr) {
            d2 += selector.invoke(Short.valueOf(s2)).doubleValue();
        }
        return d2;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (boolean z : zArr) {
            d2 += selector.invoke(Boolean.valueOf(z)).doubleValue();
        }
        return d2;
    }

    private static final <T> double sumOfDouble(T[] tArr, Function1<? super T, Double> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (T t : tArr) {
            d2 += selector.invoke(t).doubleValue();
        }
        return d2;
    }

    private static final double sumOfDouble(short[] sArr, Function1<? super Short, Double> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (short s2 : sArr) {
            d2 += selector.invoke(Short.valueOf(s2)).doubleValue();
        }
        return d2;
    }

    private static final double sumOfDouble(boolean[] zArr, Function1<? super Boolean, Double> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (boolean z : zArr) {
            d2 += selector.invoke(Boolean.valueOf(z)).doubleValue();
        }
        return d2;
    }

    private static final <T> int sumOfInt(T[] tArr, Function1<? super T, Integer> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (T t : tArr) {
            i2 += selector.invoke(t).intValue();
        }
        return i2;
    }

    private static final int sumOfInt(short[] sArr, Function1<? super Short, Integer> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (short s2 : sArr) {
            i2 += selector.invoke(Short.valueOf(s2)).intValue();
        }
        return i2;
    }

    private static final int sumOfInt(boolean[] zArr, Function1<? super Boolean, Integer> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (boolean z : zArr) {
            i2 += selector.invoke(Boolean.valueOf(z)).intValue();
        }
        return i2;
    }

    private static final <T> long sumOfLong(T[] tArr, Function1<? super T, Long> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long j2 = 0;
        for (T t : tArr) {
            j2 += selector.invoke(t).longValue();
        }
        return j2;
    }

    private static final long sumOfLong(short[] sArr, Function1<? super Short, Long> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long j2 = 0;
        for (short s2 : sArr) {
            j2 += selector.invoke(Short.valueOf(s2)).longValue();
        }
        return j2;
    }

    private static final long sumOfLong(boolean[] zArr, Function1<? super Boolean, Long> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long j2 = 0;
        for (boolean z : zArr) {
            j2 += selector.invoke(Boolean.valueOf(z)).longValue();
        }
        return j2;
    }

    private static final <T> int sumOfUInt(T[] tArr, Function1<? super T, UInt> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int m790constructorimpl = UInt.m790constructorimpl(0);
        for (T t : tArr) {
            m790constructorimpl = UInt.m790constructorimpl(m790constructorimpl + selector.invoke(t).m842unboximpl());
        }
        return m790constructorimpl;
    }

    private static final int sumOfUInt(short[] sArr, Function1<? super Short, UInt> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int m790constructorimpl = UInt.m790constructorimpl(0);
        for (short s2 : sArr) {
            m790constructorimpl = UInt.m790constructorimpl(m790constructorimpl + selector.invoke(Short.valueOf(s2)).m842unboximpl());
        }
        return m790constructorimpl;
    }

    private static final int sumOfUInt(boolean[] zArr, Function1<? super Boolean, UInt> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int m790constructorimpl = UInt.m790constructorimpl(0);
        for (boolean z : zArr) {
            m790constructorimpl = UInt.m790constructorimpl(m790constructorimpl + selector.invoke(Boolean.valueOf(z)).m842unboximpl());
        }
        return m790constructorimpl;
    }

    private static final <T> long sumOfULong(T[] tArr, Function1<? super T, ULong> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long m850constructorimpl = ULong.m850constructorimpl(0L);
        for (T t : tArr) {
            m850constructorimpl = ULong.m850constructorimpl(m850constructorimpl + selector.invoke(t).m902unboximpl());
        }
        return m850constructorimpl;
    }

    private static final long sumOfULong(short[] sArr, Function1<? super Short, ULong> selector) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long m850constructorimpl = ULong.m850constructorimpl(0L);
        for (short s2 : sArr) {
            m850constructorimpl = ULong.m850constructorimpl(m850constructorimpl + selector.invoke(Short.valueOf(s2)).m902unboximpl());
        }
        return m850constructorimpl;
    }

    private static final long sumOfULong(boolean[] zArr, Function1<? super Boolean, ULong> selector) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long m850constructorimpl = ULong.m850constructorimpl(0L);
        for (boolean z : zArr) {
            m850constructorimpl = ULong.m850constructorimpl(m850constructorimpl + selector.invoke(Boolean.valueOf(z)).m902unboximpl());
        }
        return m850constructorimpl;
    }

    public static final Pair<List<Short>, List<Short>> partition(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (short s2 : sArr) {
            if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                arrayList.add(Short.valueOf(s2));
            } else {
                arrayList2.add(Short.valueOf(s2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final Pair<List<Long>, List<Long>> partition(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (long j2 : jArr) {
            if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                arrayList.add(Long.valueOf(j2));
            } else {
                arrayList2.add(Long.valueOf(j2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final Pair<List<Boolean>, List<Boolean>> partition(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                arrayList.add(Boolean.valueOf(z));
            } else {
                arrayList2.add(Boolean.valueOf(z));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final <T, R, V> List<V> zip(T[] tArr, R[] other, Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(tArr[i2], other[i2]));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(short[] sArr, R[] other, Function2<? super Short, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Short.valueOf(sArr[i2]), other[i2]));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(int[] iArr, R[] other, Function2<? super Integer, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i2]), other[i2]));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(long[] jArr, R[] other, Function2<? super Long, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Long.valueOf(jArr[i2]), other[i2]));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(float[] fArr, R[] other, Function2<? super Float, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Float.valueOf(fArr[i2]), other[i2]));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(double[] dArr, R[] other, Function2<? super Double, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Double.valueOf(dArr[i2]), other[i2]));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(boolean[] zArr, R[] other, Function2<? super Boolean, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i2]), other[i2]));
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(char[] cArr, R[] other, Function2<? super Character, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Character.valueOf(cArr[i2]), other[i2]));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R, V> List<V> zip(T[] tArr, Iterable<? extends R> other, Function2<? super T, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(transform.invoke(tArr[i2], r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(short[] sArr, Iterable<? extends R> other, Function2<? super Short, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Short.valueOf(sArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(int[] iArr, Iterable<? extends R> other, Function2<? super Integer, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(long[] jArr, Iterable<? extends R> other, Function2<? super Long, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Long.valueOf(jArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(float[] fArr, Iterable<? extends R> other, Function2<? super Float, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Float.valueOf(fArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(double[] dArr, Iterable<? extends R> other, Function2<? super Double, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Double.valueOf(dArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(boolean[] zArr, Iterable<? extends R> other, Function2<? super Boolean, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R, V> List<V> zip(char[] cArr, Iterable<? extends R> other, Function2<? super Character, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Character.valueOf(cArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <V> List<V> zip(short[] sArr, short[] other, Function2<? super Short, ? super Short, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Short.valueOf(sArr[i2]), Short.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final <V> List<V> zip(int[] iArr, int[] other, Function2<? super Integer, ? super Integer, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Integer.valueOf(iArr[i2]), Integer.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final <V> List<V> zip(long[] jArr, long[] other, Function2<? super Long, ? super Long, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Long.valueOf(jArr[i2]), Long.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final <V> List<V> zip(float[] fArr, float[] other, Function2<? super Float, ? super Float, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Float.valueOf(fArr[i2]), Float.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final <V> List<V> zip(double[] dArr, double[] other, Function2<? super Double, ? super Double, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Double.valueOf(dArr[i2]), Double.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final <V> List<V> zip(boolean[] zArr, boolean[] other, Function2<? super Boolean, ? super Boolean, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Boolean.valueOf(zArr[i2]), Boolean.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final <V> List<V> zip(char[] cArr, char[] other, Function2<? super Character, ? super Character, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Character.valueOf(cArr[i2]), Character.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final <T, A extends Appendable> A joinTo(T[] tArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (T t : tArr) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            kotlin.text.m.appendElement(buffer, t, function1);
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <A extends Appendable> A joinTo(short[] sArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Short, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (short s2 : sArr) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Short.valueOf(s2)));
            } else {
                buffer.append(String.valueOf((int) s2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <A extends Appendable> A joinTo(long[] jArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (long j2 : jArr) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Long.valueOf(j2)));
            } else {
                buffer.append(String.valueOf(j2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <A extends Appendable> A joinTo(boolean[] zArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Boolean, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (boolean z : zArr) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Boolean.valueOf(z)));
            } else {
                buffer.append(String.valueOf(z));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ String joinToString$default(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(objArr, charSequence, charSequence5, charSequence6, i4, charSequence7, function1);
    }

    public static final <T> String joinToString(T[] tArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(tArr, new StringBuilder(), separator, prefix, postfix, i2, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(sArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (Function1<? super Short, ? extends CharSequence>) function1);
    }

    public static final String joinToString(short[] sArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Short, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(sArr, new StringBuilder(), separator, prefix, postfix, i2, truncated, function1)).toString();
    }

    public static /* synthetic */ String joinToString$default(boolean[] zArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(zArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (Function1<? super Boolean, ? extends CharSequence>) function1);
    }

    public static final String joinToString(boolean[] zArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Boolean, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(zArr, new StringBuilder(), separator, prefix, postfix, i2, truncated, function1)).toString();
    }

    public static final Iterable<Short> asIterable(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new c(sArr);
    }

    public static final Iterable<Boolean> asIterable(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length == 0 ? CollectionsKt__CollectionsKt.emptyList() : new h(zArr);
    }

    public static final Sequence<Short> asSequence(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length == 0 ? SequencesKt__SequencesKt.emptySequence() : new l(sArr);
    }

    public static final Sequence<Boolean> asSequence(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return zArr.length == 0 ? SequencesKt__SequencesKt.emptySequence() : new q(zArr);
    }

    private static final <T> T find(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                return t;
            }
        }
        return null;
    }

    private static final Short find(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (short s2 : sArr) {
            if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                return Short.valueOf(s2);
            }
        }
        return null;
    }

    private static final Long find(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j2 : jArr) {
            if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                return Long.valueOf(j2);
            }
        }
        return null;
    }

    private static final <T> T findLast(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                T t = tArr[length];
                if (predicate.invoke(t).booleanValue()) {
                    return t;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return null;
    }

    private static final Short findLast(short[] sArr, Function1<? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                short s2 = sArr[length];
                if (predicate.invoke(Short.valueOf(s2)).booleanValue()) {
                    return Short.valueOf(s2);
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return null;
    }

    private static final Long findLast(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                long j2 = jArr[length];
                if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                    return Long.valueOf(j2);
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return null;
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(T[] tArr, C destination, Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            T t = tArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), t).booleanValue()) {
                destination.add(t);
            }
            i2++;
            i3 = i4;
        }
        return destination;
    }

    public static final <C extends Collection<? super Short>> C filterIndexedTo(short[] sArr, C destination, Function2<? super Integer, ? super Short, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            short s2 = sArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Short.valueOf(s2)).booleanValue()) {
                destination.add(Short.valueOf(s2));
            }
            i2++;
            i3 = i4;
        }
        return destination;
    }

    public static final <C extends Collection<? super Boolean>> C filterIndexedTo(boolean[] zArr, C destination, Function2<? super Integer, ? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            boolean z = zArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Boolean.valueOf(z)).booleanValue()) {
                destination.add(Boolean.valueOf(z));
            }
            i2++;
            i3 = i4;
        }
        return destination;
    }

    private static final short[] onEachIndexed(short[] sArr, Function2<? super Integer, ? super Short, Unit> action) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = sArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Short.valueOf(sArr[i2]));
            i2++;
            i3++;
        }
        return sArr;
    }

    private static final boolean[] onEachIndexed(boolean[] zArr, Function2<? super Integer, ? super Boolean, Unit> action) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = zArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Boolean.valueOf(zArr[i2]));
            i2++;
            i3++;
        }
        return zArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> List<R> scan(T[] tArr, R r2, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r2);
        for (d.a.C0000a c0000a : tArr) {
            r2 = operation.invoke(r2, c0000a);
            arrayList.add(r2);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> List<R> scanIndexed(T[] tArr, R r2, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(tArr.length + 1);
        arrayList.add(r2);
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, tArr[i2]);
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static <T, R> List<Pair<T, R>> zip(T[] tArr, R[] other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(tArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(tArr[i2], other[i2]));
        }
        return arrayList;
    }

    public static final <R> List<Pair<Short, R>> zip(short[] sArr, R[] other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            short s2 = sArr[i2];
            arrayList.add(TuplesKt.to(Short.valueOf(s2), other[i2]));
        }
        return arrayList;
    }

    public static final <R> List<Pair<Integer, R>> zip(int[] iArr, R[] other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            int i3 = iArr[i2];
            arrayList.add(TuplesKt.to(Integer.valueOf(i3), other[i2]));
        }
        return arrayList;
    }

    public static final <R> List<Pair<Long, R>> zip(long[] jArr, R[] other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            long j2 = jArr[i2];
            arrayList.add(TuplesKt.to(Long.valueOf(j2), other[i2]));
        }
        return arrayList;
    }

    public static final <R> List<Pair<Float, R>> zip(float[] fArr, R[] other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            float f2 = fArr[i2];
            arrayList.add(TuplesKt.to(Float.valueOf(f2), other[i2]));
        }
        return arrayList;
    }

    public static final <R> List<Pair<Double, R>> zip(double[] dArr, R[] other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            double d2 = dArr[i2];
            arrayList.add(TuplesKt.to(Double.valueOf(d2), other[i2]));
        }
        return arrayList;
    }

    public static final <R> List<Pair<Boolean, R>> zip(boolean[] zArr, R[] other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            boolean z = zArr[i2];
            arrayList.add(TuplesKt.to(Boolean.valueOf(z), other[i2]));
        }
        return arrayList;
    }

    public static final <R> List<Pair<Character, R>> zip(char[] cArr, R[] other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            char c2 = cArr[i2];
            arrayList.add(TuplesKt.to(Character.valueOf(c2), other[i2]));
        }
        return arrayList;
    }

    public static final <T, R> List<Pair<T, R>> zip(T[] tArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = tArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(tArr[i2], r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<Pair<Short, R>> zip(short[] sArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = sArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Short.valueOf(sArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<Pair<Integer, R>> zip(int[] iArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = iArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Integer.valueOf(iArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<Pair<Long, R>> zip(long[] jArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = jArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Long.valueOf(jArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<Pair<Float, R>> zip(float[] fArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = fArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Float.valueOf(fArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<Pair<Double, R>> zip(double[] dArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = dArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Double.valueOf(dArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<Pair<Boolean, R>> zip(boolean[] zArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = zArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Boolean.valueOf(zArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <R> List<Pair<Character, R>> zip(char[] cArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = cArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Character.valueOf(cArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final List<Pair<Short, Short>> zip(short[] sArr, short[] other) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(sArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Short.valueOf(sArr[i2]), Short.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final List<Pair<Integer, Integer>> zip(int[] iArr, int[] other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(iArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Integer.valueOf(iArr[i2]), Integer.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final List<Pair<Long, Long>> zip(long[] jArr, long[] other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(jArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Long.valueOf(jArr[i2]), Long.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final List<Pair<Float, Float>> zip(float[] fArr, float[] other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(fArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Float.valueOf(fArr[i2]), Float.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final List<Pair<Double, Double>> zip(double[] dArr, double[] other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(dArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Double.valueOf(dArr[i2]), Double.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final List<Pair<Boolean, Boolean>> zip(boolean[] zArr, boolean[] other) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(zArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Boolean.valueOf(zArr[i2]), Boolean.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final List<Pair<Character, Character>> zip(char[] cArr, char[] other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(cArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Character.valueOf(cArr[i2]), Character.valueOf(other[i2])));
        }
        return arrayList;
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements Iterable<T>, KMappedMarker {
        final /* synthetic */ Object[] a;

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return ArrayIteratorKt.iterator(this.a);
        }

        public a(Object[] objArr) {
            this.a = objArr;
        }
    }

    public static final class b implements Iterable<Byte>, KMappedMarker {
        final /* synthetic */ byte[] a;

        @Override // java.lang.Iterable
        public Iterator<Byte> iterator() {
            return kotlin.jvm.internal.h.b(this.a);
        }

        public b(byte[] bArr) {
            this.a = bArr;
        }
    }

    public static final class c implements Iterable<Short>, KMappedMarker {
        final /* synthetic */ short[] a;

        @Override // java.lang.Iterable
        public Iterator<Short> iterator() {
            return kotlin.jvm.internal.h.h(this.a);
        }

        public c(short[] sArr) {
            this.a = sArr;
        }
    }

    public static final class d implements Iterable<Integer>, KMappedMarker {
        final /* synthetic */ int[] a;

        @Override // java.lang.Iterable
        public Iterator<Integer> iterator() {
            return kotlin.jvm.internal.h.f(this.a);
        }

        public d(int[] iArr) {
            this.a = iArr;
        }
    }

    public static final class e implements Iterable<Long>, KMappedMarker {
        final /* synthetic */ long[] a;

        @Override // java.lang.Iterable
        public Iterator<Long> iterator() {
            return kotlin.jvm.internal.h.g(this.a);
        }

        public e(long[] jArr) {
            this.a = jArr;
        }
    }

    public static final class f implements Iterable<Float>, KMappedMarker {
        final /* synthetic */ float[] a;

        @Override // java.lang.Iterable
        public Iterator<Float> iterator() {
            return kotlin.jvm.internal.h.e(this.a);
        }

        public f(float[] fArr) {
            this.a = fArr;
        }
    }

    public static final class g implements Iterable<Double>, KMappedMarker {
        final /* synthetic */ double[] a;

        @Override // java.lang.Iterable
        public Iterator<Double> iterator() {
            return kotlin.jvm.internal.h.d(this.a);
        }

        public g(double[] dArr) {
            this.a = dArr;
        }
    }

    public static final class h implements Iterable<Boolean>, KMappedMarker {
        final /* synthetic */ boolean[] a;

        @Override // java.lang.Iterable
        public Iterator<Boolean> iterator() {
            return kotlin.jvm.internal.h.a(this.a);
        }

        public h(boolean[] zArr) {
            this.a = zArr;
        }
    }

    public static final class i implements Iterable<Character>, KMappedMarker {
        final /* synthetic */ char[] a;

        @Override // java.lang.Iterable
        public Iterator<Character> iterator() {
            return kotlin.jvm.internal.h.c(this.a);
        }

        public i(char[] cArr) {
            this.a = cArr;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class j<T> implements Sequence<T> {
        final /* synthetic */ Object[] a;

        @Override // kotlin.sequences.Sequence
        public Iterator<T> iterator() {
            return ArrayIteratorKt.iterator(this.a);
        }

        public j(Object[] objArr) {
            this.a = objArr;
        }
    }

    public static final class k implements Sequence<Byte> {
        final /* synthetic */ byte[] a;

        @Override // kotlin.sequences.Sequence
        public Iterator<Byte> iterator() {
            return kotlin.jvm.internal.h.b(this.a);
        }

        public k(byte[] bArr) {
            this.a = bArr;
        }
    }

    public static final class l implements Sequence<Short> {
        final /* synthetic */ short[] a;

        @Override // kotlin.sequences.Sequence
        public Iterator<Short> iterator() {
            return kotlin.jvm.internal.h.h(this.a);
        }

        public l(short[] sArr) {
            this.a = sArr;
        }
    }

    public static final class m implements Sequence<Integer> {
        final /* synthetic */ int[] a;

        @Override // kotlin.sequences.Sequence
        public Iterator<Integer> iterator() {
            return kotlin.jvm.internal.h.f(this.a);
        }

        public m(int[] iArr) {
            this.a = iArr;
        }
    }

    public static final class n implements Sequence<Long> {
        final /* synthetic */ long[] a;

        @Override // kotlin.sequences.Sequence
        public Iterator<Long> iterator() {
            return kotlin.jvm.internal.h.g(this.a);
        }

        public n(long[] jArr) {
            this.a = jArr;
        }
    }

    public static final class o implements Sequence<Float> {
        final /* synthetic */ float[] a;

        @Override // kotlin.sequences.Sequence
        public Iterator<Float> iterator() {
            return kotlin.jvm.internal.h.e(this.a);
        }

        public o(float[] fArr) {
            this.a = fArr;
        }
    }

    public static final class p implements Sequence<Double> {
        final /* synthetic */ double[] a;

        @Override // kotlin.sequences.Sequence
        public Iterator<Double> iterator() {
            return kotlin.jvm.internal.h.d(this.a);
        }

        public p(double[] dArr) {
            this.a = dArr;
        }
    }

    public static final class q implements Sequence<Boolean> {
        final /* synthetic */ boolean[] a;

        @Override // kotlin.sequences.Sequence
        public Iterator<Boolean> iterator() {
            return kotlin.jvm.internal.h.a(this.a);
        }

        public q(boolean[] zArr) {
            this.a = zArr;
        }
    }

    public static final class r implements Sequence<Character> {
        final /* synthetic */ char[] a;

        @Override // kotlin.sequences.Sequence
        public Iterator<Character> iterator() {
            return kotlin.jvm.internal.h.c(this.a);
        }

        public r(char[] cArr) {
            this.a = cArr;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, K] */
    public static final class s<K, T> implements Grouping<T, K> {
        final /* synthetic */ T[] a;
        final /* synthetic */ Function1<T, K> b;

        @Override // kotlin.collections.Grouping
        public Iterator<T> sourceIterator() {
            return ArrayIteratorKt.iterator(this.a);
        }

        @Override // kotlin.collections.Grouping
        public K keyOf(T t) {
            return this.b.invoke(t);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public s(T[] tArr, Function1<? super T, ? extends K> function1) {
            this.a = tArr;
            this.b = function1;
        }
    }

    private static final int count(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length;
    }

    public static final boolean any(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    private static final byte component1(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr[0];
    }

    private static final byte component2(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr[1];
    }

    private static final byte component3(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr[2];
    }

    private static final byte component4(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr[3];
    }

    private static final byte component5(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr[4];
    }

    private static final int count(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length;
    }

    public static final List<Byte> distinct(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(bArr));
    }

    public static final IntRange getIndices(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new IntRange(0, getLastIndex(bArr));
    }

    public static final int getLastIndex(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return bArr.length - 1;
    }

    private static final boolean isEmpty(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return true;
        }
        return false;
    }

    private static final boolean isNotEmpty(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final boolean none(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            return true;
        }
        return false;
    }

    private static final byte random(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return random(bArr, (Random) Random.Default);
    }

    private static final Boolean randomOrNull(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return randomOrNull(zArr, Random.Default);
    }

    public static final void shuffle(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        shuffle(bArr, (Random) Random.Default);
    }

    public static <T> T singleOrNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final void sortDescending(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(bArr);
            reverse(bArr);
        }
    }

    public static final <T extends Comparable<? super T>> List<T> sorted(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return ArraysKt___ArraysJvmKt.asList(sortedArray(tArr));
    }

    public static final <T extends Comparable<? super T>> List<T> sortedDescending(T[] tArr) {
        Comparator reverseOrder;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        reverseOrder = ComparisonsKt__ComparisonsKt.reverseOrder();
        return sortedWith(tArr, reverseOrder);
    }

    public static <T> List<T> toMutableList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new ArrayList(CollectionsKt__CollectionsKt.asCollection(tArr));
    }

    public static final Iterable<IndexedValue<Byte>> withIndex(final byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new b0(new Function0() { // from class: kotlin.collections.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator b2;
                b2 = kotlin.jvm.internal.h.b(bArr);
                return b2;
            }
        });
    }

    public static final boolean any(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final Iterable<Byte> asIterable(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new b(bArr);
    }

    public static final Sequence<Byte> asSequence(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new k(bArr);
    }

    public static final double average(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        double d2 = 0.0d;
        int i2 = 0;
        for (byte b2 : bArr) {
            d2 += b2;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    private static final char component1(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr[0];
    }

    private static final char component2(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr[1];
    }

    private static final char component3(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr[2];
    }

    private static final char component4(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr[3];
    }

    private static final char component5(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr[4];
    }

    private static final int count(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length;
    }

    public static final List<Character> distinct(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(cArr));
    }

    public static <T> List<T> filterNotNull(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (List) filterNotNullTo(tArr, new ArrayList());
    }

    public static final byte first(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return bArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Boolean firstOrNull(boolean[] zArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    public static final IntRange getIndices(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new IntRange(0, getLastIndex(cArr));
    }

    public static final int getLastIndex(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return cArr.length - 1;
    }

    private static final boolean isEmpty(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return true;
        }
        return false;
    }

    private static final boolean isNotEmpty(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static byte last(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return bArr[getLastIndex(bArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Boolean lastOrNull(boolean[] zArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Boolean.valueOf(zArr[zArr.length - 1]);
    }

    public static final boolean none(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            return true;
        }
        return false;
    }

    private static final char random(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return random(cArr, (Random) Random.Default);
    }

    public static final List<Byte> reversed(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Byte> mutableList = toMutableList(bArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final void shuffle(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        shuffle(cArr, (Random) Random.Default);
    }

    public static final byte single(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (length != 0) {
            if (length == 1) {
                return bArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Boolean singleOrNull(boolean[] zArr) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        if (zArr.length == 1) {
            return Boolean.valueOf(zArr[0]);
        }
        return null;
    }

    public static final List<Byte> sorted(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Byte[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(bArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final byte[] sortedArray(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    public static final byte[] sortedArrayDescending(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        sortDescending(copyOf);
        return copyOf;
    }

    public static final List<Byte> sortedDescending(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    public static final double sum(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double d2 = 0.0d;
        for (double d3 : dArr) {
            d2 += d3;
        }
        return d2;
    }

    public static final int sumOfByte(Byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i2 = 0;
        for (Byte b2 : bArr) {
            i2 += b2.byteValue();
        }
        return i2;
    }

    public static final double sumOfDouble(Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double d2 = 0.0d;
        for (Double d3 : dArr) {
            d2 += d3.doubleValue();
        }
        return d2;
    }

    public static final float sumOfFloat(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float f2 = 0.0f;
        for (Float f3 : fArr) {
            f2 += f3.floatValue();
        }
        return f2;
    }

    public static final int sumOfInt(Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "<this>");
        int i2 = 0;
        for (Integer num : numArr) {
            i2 += num.intValue();
        }
        return i2;
    }

    public static final long sumOfLong(Long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "<this>");
        long j2 = 0;
        for (Long l2 : lArr) {
            j2 += l2.longValue();
        }
        return j2;
    }

    public static final int sumOfShort(Short[] shArr) {
        Intrinsics.checkNotNullParameter(shArr, "<this>");
        int i2 = 0;
        for (Short sh : shArr) {
            i2 += sh.shortValue();
        }
        return i2;
    }

    public static final boolean[] toBooleanArray(Boolean[] boolArr) {
        Intrinsics.checkNotNullParameter(boolArr, "<this>");
        int length = boolArr.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zArr[i2] = boolArr[i2].booleanValue();
        }
        return zArr;
    }

    public static final byte[] toByteArray(Byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr2[i2] = bArr[i2].byteValue();
        }
        return bArr2;
    }

    public static final char[] toCharArray(Character[] chArr) {
        Intrinsics.checkNotNullParameter(chArr, "<this>");
        int length = chArr.length;
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = chArr[i2].charValue();
        }
        return cArr;
    }

    public static final double[] toDoubleArray(Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        double[] dArr2 = new double[length];
        for (int i2 = 0; i2 < length; i2++) {
            dArr2[i2] = dArr[i2].doubleValue();
        }
        return dArr2;
    }

    public static float[] toFloatArray(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i2 = 0; i2 < length; i2++) {
            fArr2[i2] = fArr[i2].floatValue();
        }
        return fArr2;
    }

    public static final HashSet<Byte> toHashSet(byte[] bArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(bArr.length);
        return (HashSet) toCollection(bArr, new HashSet(mapCapacity));
    }

    public static int[] toIntArray(Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "<this>");
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }

    public static <T> List<T> toList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int length = tArr.length;
        if (length != 0) {
            if (length != 1) {
                return toMutableList(tArr);
            }
            return CollectionsKt__CollectionsJVMKt.listOf(tArr[0]);
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final long[] toLongArray(Long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "<this>");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i2 = 0; i2 < length; i2++) {
            jArr[i2] = lArr[i2].longValue();
        }
        return jArr;
    }

    public static final List<Byte> toMutableList(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b2 : bArr) {
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    public static final Set<Byte> toMutableSet(byte[] bArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(bArr.length);
        return (Set) toCollection(bArr, new LinkedHashSet(mapCapacity));
    }

    public static final short[] toShortArray(Short[] shArr) {
        Intrinsics.checkNotNullParameter(shArr, "<this>");
        int length = shArr.length;
        short[] sArr = new short[length];
        for (int i2 = 0; i2 < length; i2++) {
            sArr[i2] = shArr[i2].shortValue();
        }
        return sArr;
    }

    public static final Iterable<IndexedValue<Character>> withIndex(final char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new b0(new Function0() { // from class: kotlin.collections.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator c2;
                c2 = kotlin.jvm.internal.h.c(cArr);
                return c2;
            }
        });
    }

    public static final Iterable<Character> asIterable(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new i(cArr);
    }

    public static final Sequence<Character> asSequence(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new r(cArr);
    }

    public static final double average(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double d2 = 0.0d;
        int i2 = 0;
        for (double d3 : dArr) {
            d2 += d3;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    public static final double averageOfByte(Byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        double d2 = 0.0d;
        int i2 = 0;
        for (Byte b2 : bArr) {
            d2 += b2.byteValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    public static final double averageOfDouble(Double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double d2 = 0.0d;
        int i2 = 0;
        for (Double d3 : dArr) {
            d2 += d3.doubleValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    public static final double averageOfFloat(Float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        double d2 = 0.0d;
        int i2 = 0;
        for (Float f2 : fArr) {
            d2 += f2.floatValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    public static double averageOfInt(Integer[] numArr) {
        Intrinsics.checkNotNullParameter(numArr, "<this>");
        double d2 = 0.0d;
        int i2 = 0;
        for (Integer num : numArr) {
            d2 += num.intValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    public static final double averageOfLong(Long[] lArr) {
        Intrinsics.checkNotNullParameter(lArr, "<this>");
        double d2 = 0.0d;
        int i2 = 0;
        for (Long l2 : lArr) {
            d2 += l2.longValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    public static final double averageOfShort(Short[] shArr) {
        Intrinsics.checkNotNullParameter(shArr, "<this>");
        double d2 = 0.0d;
        int i2 = 0;
        for (Short sh : shArr) {
            d2 += sh.shortValue();
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    private static final double component1(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr[0];
    }

    private static final double component2(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr[1];
    }

    private static final double component3(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr[2];
    }

    private static final double component4(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr[3];
    }

    private static final double component5(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr[4];
    }

    public static final List<Double> distinct(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(dArr));
    }

    public static final /* synthetic */ <R> List<R> filterIsInstance(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final IntRange getIndices(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return new IntRange(0, getLastIndex(dArr));
    }

    public static final int getLastIndex(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return dArr.length - 1;
    }

    private static final boolean isEmpty(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return true;
        }
        return false;
    }

    private static final boolean isNotEmpty(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final Byte maxOrNull(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                if (b2 < b3) {
                    b2 = b3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final byte maxOrThrow(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            byte b2 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    byte b3 = bArr[i2];
                    if (b2 < b3) {
                        b2 = b3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return b2;
        }
        throw new NoSuchElementException();
    }

    public static final Byte minOrNull(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                if (b2 > b3) {
                    b2 = b3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final byte minOrThrow(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            byte b2 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    byte b3 = bArr[i2];
                    if (b2 > b3) {
                        b2 = b3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return b2;
        }
        throw new NoSuchElementException();
    }

    private static final Byte randomOrNull(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return randomOrNull(bArr, (Random) Random.Default);
    }

    public static <T> T[] requireNoNulls(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        for (T t : tArr) {
            if (t == null) {
                throw new IllegalArgumentException("null element found in " + tArr + '.');
            }
        }
        return tArr;
    }

    public static final void reverse(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = (bArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(bArr);
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                byte b2 = bArr[i2];
                bArr[i2] = bArr[lastIndex];
                bArr[lastIndex] = b2;
                lastIndex--;
                if (i2 != length) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public static final List<Character> reversed(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Character> mutableList = toMutableList(cArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final byte[] reversedArray(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i2 = 0;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return bArr;
        }
        byte[] bArr2 = new byte[bArr.length];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            while (true) {
                bArr2[lastIndex - i2] = bArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return bArr2;
    }

    public static char single(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final void sortDescending(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(cArr);
            reverse(cArr);
        }
    }

    public static final List<Character> sorted(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Character[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(cArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final char[] sortedArray(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return cArr;
        }
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    public static final char[] sortedArrayDescending(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return cArr;
        }
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        sortDescending(copyOf);
        return copyOf;
    }

    public static final List<Character> sortedDescending(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        char[] copyOf = Arrays.copyOf(cArr, cArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    public static final float sum(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float f2 = 0.0f;
        for (float f3 : fArr) {
            f2 += f3;
        }
        return f2;
    }

    public static final HashSet<Character> toHashSet(char[] cArr) {
        int coerceAtMost;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(cArr.length, 128);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(coerceAtMost);
        return (HashSet) toCollection(cArr, new HashSet(mapCapacity));
    }

    public static List<Byte> toList(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (length != 0) {
            if (length != 1) {
                return toMutableList(bArr);
            }
            return CollectionsKt__CollectionsJVMKt.listOf(Byte.valueOf(bArr[0]));
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Character> toMutableList(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c2 : cArr) {
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    public static final Set<Character> toMutableSet(char[] cArr) {
        int coerceAtMost;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(cArr.length, 128);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(coerceAtMost);
        return (Set) toCollection(cArr, new LinkedHashSet(mapCapacity));
    }

    public static final Set<Byte> toSet(byte[] bArr) {
        Set<Byte> emptySet;
        Set<Byte> of;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        if (length != 0) {
            if (length != 1) {
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(bArr.length);
                return (Set) toCollection(bArr, new LinkedHashSet(mapCapacity));
            }
            of = SetsKt__SetsJVMKt.setOf(Byte.valueOf(bArr[0]));
            return of;
        }
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    public static final Iterable<IndexedValue<Double>> withIndex(final double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return new b0(new Function0() { // from class: kotlin.collections.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator d2;
                d2 = kotlin.jvm.internal.h.d(dArr);
                return d2;
            }
        });
    }

    public static final Iterable<Double> asIterable(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new g(dArr);
    }

    public static final Sequence<Double> asSequence(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new p(dArr);
    }

    public static final double average(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        double d2 = 0.0d;
        int i2 = 0;
        for (float f2 : fArr) {
            d2 += f2;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    private static final float component1(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr[0];
    }

    private static final float component2(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr[1];
    }

    private static final float component3(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr[2];
    }

    private static final float component4(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr[3];
    }

    private static final float component5(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr[4];
    }

    public static final List<Float> distinct(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(fArr));
    }

    public static final char first(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return cArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Byte firstOrNull(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    public static final IntRange getIndices(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return new IntRange(0, getLastIndex(fArr));
    }

    public static final int getLastIndex(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length - 1;
    }

    private static final boolean isEmpty(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return true;
        }
        return false;
    }

    private static final boolean isNotEmpty(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final char last(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return cArr[getLastIndex(cArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Byte lastOrNull(byte[] bArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Byte.valueOf(bArr[bArr.length - 1]);
    }

    public static final Character maxOrNull(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                if (Intrinsics.compare((int) c2, (int) c3) < 0) {
                    c2 = c3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final char maxOrThrow(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            char c2 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    char c3 = cArr[i2];
                    if (Intrinsics.compare((int) c2, (int) c3) < 0) {
                        c2 = c3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return c2;
        }
        throw new NoSuchElementException();
    }

    public static final Character minOrNull(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                if (Intrinsics.compare((int) c2, (int) c3) > 0) {
                    c2 = c3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final char minOrThrow(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            char c2 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    char c3 = cArr[i2];
                    if (Intrinsics.compare((int) c2, (int) c3) > 0) {
                        c2 = c3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return c2;
        }
        throw new NoSuchElementException();
    }

    public static final List<Double> reversed(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Double> mutableList = toMutableList(dArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final char[] reversedArray(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int i2 = 0;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return cArr;
        }
        char[] cArr2 = new char[cArr.length];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            while (true) {
                cArr2[lastIndex - i2] = cArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return cArr2;
    }

    public static final Byte singleOrNull(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (bArr.length == 1) {
            return Byte.valueOf(bArr[0]);
        }
        return null;
    }

    public static final List<Double> sorted(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Double[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(dArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final double[] sortedArray(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return dArr;
        }
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    public static final double[] sortedArrayDescending(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return dArr;
        }
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        sortDescending(copyOf);
        return copyOf;
    }

    public static final List<Double> sortedDescending(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        double[] copyOf = Arrays.copyOf(dArr, dArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    public static final int sum(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i2 = 0;
        for (byte b2 : bArr) {
            i2 += b2;
        }
        return i2;
    }

    public static final HashSet<Double> toHashSet(double[] dArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(dArr.length);
        return (HashSet) toCollection(dArr, new HashSet(mapCapacity));
    }

    public static final List<Character> toList(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length != 1) {
                return toMutableList(cArr);
            }
            return CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(cArr[0]));
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Double> toMutableList(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d2 : dArr) {
            arrayList.add(Double.valueOf(d2));
        }
        return arrayList;
    }

    public static final Set<Double> toMutableSet(double[] dArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(dArr.length);
        return (Set) toCollection(dArr, new LinkedHashSet(mapCapacity));
    }

    public static final Set<Character> toSet(char[] cArr) {
        Set<Character> emptySet;
        Set<Character> of;
        int coerceAtMost;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length != 1) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(cArr.length, 128);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(coerceAtMost);
                return (Set) toCollection(cArr, new LinkedHashSet(mapCapacity));
            }
            of = SetsKt__SetsJVMKt.setOf(Character.valueOf(cArr[0]));
            return of;
        }
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    public static final Iterable<IndexedValue<Float>> withIndex(final float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return new b0(new Function0() { // from class: kotlin.collections.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator e2;
                e2 = kotlin.jvm.internal.h.e(fArr);
                return e2;
            }
        });
    }

    public static final boolean any(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final Iterable<Float> asIterable(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new f(fArr);
    }

    public static final Sequence<Float> asSequence(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new o(fArr);
    }

    public static final double average(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        double d2 = 0.0d;
        int i2 = 0;
        for (int i3 : iArr) {
            d2 += i3;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    private static final int component1(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr[0];
    }

    private static final int component2(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr[1];
    }

    private static final int component3(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr[2];
    }

    private static final int component4(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr[3];
    }

    private static final int component5(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr[4];
    }

    public static final List<Integer> distinct(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(iArr));
    }

    public static IntRange getIndices(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new IntRange(0, getLastIndex(iArr));
    }

    public static int getLastIndex(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length - 1;
    }

    private static final boolean isEmpty(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            return true;
        }
        return false;
    }

    private static final boolean isNotEmpty(int[] iArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final <T extends Comparable<? super T>> T maxOrNull(T[] tArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                if (t.compareTo(t2) < 0) {
                    t = t2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    public static final double maxOrThrow(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double d2 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    d2 = Math.max(d2, dArr[i2]);
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return d2;
        }
        throw new NoSuchElementException();
    }

    public static final <T extends Comparable<? super T>> T minOrNull(T[] tArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                if (t.compareTo(t2) > 0) {
                    t = t2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    public static final double minOrThrow(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double d2 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    d2 = Math.min(d2, dArr[i2]);
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return d2;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            return true;
        }
        return false;
    }

    private static final double random(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return random(dArr, Random.Default);
    }

    private static final Character randomOrNull(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return randomOrNull(cArr, (Random) Random.Default);
    }

    public static final void reverse(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = (cArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(cArr);
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                char c2 = cArr[i2];
                cArr[i2] = cArr[lastIndex];
                cArr[lastIndex] = c2;
                lastIndex--;
                if (i2 != length) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public static final List<Float> reversed(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Float> mutableList = toMutableList(fArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final double[] reversedArray(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int i2 = 0;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return dArr;
        }
        double[] dArr2 = new double[dArr.length];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            while (true) {
                dArr2[lastIndex - i2] = dArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return dArr2;
    }

    public static final void shuffle(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        shuffle(dArr, Random.Default);
    }

    public static final void sortDescending(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(dArr);
            reverse(dArr);
        }
    }

    public static final List<Float> sorted(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Float[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(fArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final float[] sortedArray(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return fArr;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    public static final float[] sortedArrayDescending(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return fArr;
        }
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        sortDescending(copyOf);
        return copyOf;
    }

    public static final List<Float> sortedDescending(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        float[] copyOf = Arrays.copyOf(fArr, fArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    public static int sum(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        return i2;
    }

    public static final HashSet<Float> toHashSet(float[] fArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(fArr.length);
        return (HashSet) toCollection(fArr, new HashSet(mapCapacity));
    }

    public static final List<Double> toList(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        if (length != 0) {
            if (length != 1) {
                return toMutableList(dArr);
            }
            return CollectionsKt__CollectionsJVMKt.listOf(Double.valueOf(dArr[0]));
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Float> toMutableList(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f2 : fArr) {
            arrayList.add(Float.valueOf(f2));
        }
        return arrayList;
    }

    public static final Set<Float> toMutableSet(float[] fArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(fArr.length);
        return (Set) toCollection(fArr, new LinkedHashSet(mapCapacity));
    }

    public static final Set<Double> toSet(double[] dArr) {
        Set<Double> emptySet;
        Set<Double> of;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        if (length != 0) {
            if (length != 1) {
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(dArr.length);
                return (Set) toCollection(dArr, new LinkedHashSet(mapCapacity));
            }
            of = SetsKt__SetsJVMKt.setOf(Double.valueOf(dArr[0]));
            return of;
        }
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    public static final Iterable<IndexedValue<Integer>> withIndex(final int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return new b0(new Function0() { // from class: kotlin.collections.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator f2;
                f2 = kotlin.jvm.internal.h.f(iArr);
                return f2;
            }
        });
    }

    public static final Iterable<Integer> asIterable(int[] iArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new d(iArr);
    }

    public static final Sequence<Integer> asSequence(int[] iArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new m(iArr);
    }

    public static final double average(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        double d2 = 0.0d;
        int i2 = 0;
        for (long j2 : jArr) {
            d2 += j2;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    private static final long component1(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr[0];
    }

    private static final long component2(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr[1];
    }

    private static final long component3(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr[2];
    }

    private static final long component4(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr[3];
    }

    private static final long component5(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr[4];
    }

    private static final int count(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return fArr.length;
    }

    public static final List<Long> distinct(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(jArr));
    }

    public static final double first(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return dArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Character firstOrNull(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Character.valueOf(cArr[0]);
    }

    public static final IntRange getIndices(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return new IntRange(0, getLastIndex(jArr));
    }

    public static int getLastIndex(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return jArr.length - 1;
    }

    private static final boolean isEmpty(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            return true;
        }
        return false;
    }

    private static final boolean isNotEmpty(long[] jArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final double last(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return dArr[getLastIndex(dArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Character lastOrNull(char[] cArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Character.valueOf(cArr[cArr.length - 1]);
    }

    public static final Double maxOrNull(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                d2 = Math.max(d2, dArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final double maxOrThrow(Double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double doubleValue = dArr[0].doubleValue();
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    doubleValue = Math.max(doubleValue, dArr[i2].doubleValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    public static final Double minOrNull(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                d2 = Math.min(d2, dArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final double minOrThrow(Double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double doubleValue = dArr[0].doubleValue();
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    doubleValue = Math.min(doubleValue, dArr[i2].doubleValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    public static final List<Integer> reversed(int[] iArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Integer> mutableList = toMutableList(iArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final float[] reversedArray(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int i2 = 0;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return fArr;
        }
        float[] fArr2 = new float[fArr.length];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            while (true) {
                fArr2[lastIndex - i2] = fArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return fArr2;
    }

    public static final double single(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        if (length != 0) {
            if (length == 1) {
                return dArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Character singleOrNull(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (cArr.length == 1) {
            return Character.valueOf(cArr[0]);
        }
        return null;
    }

    public static final List<Integer> sorted(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Integer[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(iArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final int[] sortedArray(int[] iArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    public static final int[] sortedArrayDescending(int[] iArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return iArr;
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        sortDescending(copyOf);
        return copyOf;
    }

    public static final List<Integer> sortedDescending(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    public static final int sum(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        int i2 = 0;
        for (short s2 : sArr) {
            i2 += s2;
        }
        return i2;
    }

    public static final HashSet<Integer> toHashSet(int[] iArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(iArr.length);
        return (HashSet) toCollection(iArr, new HashSet(mapCapacity));
    }

    public static final List<Float> toList(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        if (length != 0) {
            if (length != 1) {
                return toMutableList(fArr);
            }
            return CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(fArr[0]));
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static List<Integer> toMutableList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    public static final Set<Integer> toMutableSet(int[] iArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(iArr.length);
        return (Set) toCollection(iArr, new LinkedHashSet(mapCapacity));
    }

    public static final Set<Float> toSet(float[] fArr) {
        Set<Float> emptySet;
        Set<Float> of;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        if (length != 0) {
            if (length != 1) {
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(fArr.length);
                return (Set) toCollection(fArr, new LinkedHashSet(mapCapacity));
            }
            of = SetsKt__SetsJVMKt.setOf(Float.valueOf(fArr[0]));
            return of;
        }
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    public static final Iterable<IndexedValue<Long>> withIndex(final long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return new b0(new Function0() { // from class: kotlin.collections.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator g2;
                g2 = kotlin.jvm.internal.h.g(jArr);
                return g2;
            }
        });
    }

    public static final boolean any(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final Iterable<Long> asIterable(long[] jArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new e(jArr);
    }

    public static final Sequence<Long> asSequence(long[] jArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new n(jArr);
    }

    public static final double average(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        double d2 = 0.0d;
        int i2 = 0;
        for (short s2 : sArr) {
            d2 += s2;
            i2++;
        }
        if (i2 == 0) {
            return Double.NaN;
        }
        return d2 / i2;
    }

    private static final <T> T component1(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[0];
    }

    private static final <T> T component2(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[1];
    }

    private static final <T> T component3(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[2];
    }

    private static final <T> T component4(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[3];
    }

    private static final <T> T component5(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr[4];
    }

    public static final <T> List<T> distinct(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(tArr));
    }

    public static <T> IntRange getIndices(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new IntRange(0, getLastIndex(tArr));
    }

    public static <T> int getLastIndex(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return tArr.length - 1;
    }

    private static final <T> boolean isEmpty(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            return true;
        }
        return false;
    }

    private static final <T> boolean isNotEmpty(T[] tArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final Double maxOrNull(Double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        double doubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.max(doubleValue, dArr[i2].doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    public static final float maxOrThrow(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            float f2 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    f2 = Math.max(f2, fArr[i2]);
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return f2;
        }
        throw new NoSuchElementException();
    }

    public static final Double minOrNull(Double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        double doubleValue = dArr[0].doubleValue();
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                doubleValue = Math.min(doubleValue, dArr[i2].doubleValue());
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(doubleValue);
    }

    public static final float minOrThrow(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            float f2 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    f2 = Math.min(f2, fArr[i2]);
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return f2;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            return true;
        }
        return false;
    }

    private static final float random(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return random(fArr, (Random) Random.Default);
    }

    private static final Double randomOrNull(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return randomOrNull(dArr, Random.Default);
    }

    public static final void reverse(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = (dArr.length / 2) - 1;
        if (length < 0) {
            return;
        }
        int lastIndex = getLastIndex(dArr);
        if (length >= 0) {
            int i2 = 0;
            while (true) {
                double d2 = dArr[i2];
                dArr[i2] = dArr[lastIndex];
                dArr[lastIndex] = d2;
                lastIndex--;
                if (i2 != length) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public static final List<Long> reversed(long[] jArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<Long> mutableList = toMutableList(jArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final int[] reversedArray(int[] iArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i2 = 0;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return iArr;
        }
        int[] iArr2 = new int[iArr.length];
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            while (true) {
                iArr2[lastIndex - i2] = iArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return iArr2;
    }

    public static final void shuffle(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        shuffle(fArr, (Random) Random.Default);
    }

    public static final void sortDescending(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length > 1) {
            ArraysKt___ArraysJvmKt.sort(fArr);
            reverse(fArr);
        }
    }

    public static final List<Long> sorted(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Long[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(jArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final long[] sortedArray(long[] jArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return copyOf;
    }

    public static final long[] sortedArrayDescending(long[] jArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return jArr;
        }
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        sortDescending(copyOf);
        return copyOf;
    }

    public static final List<Long> sortedDescending(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        long[] copyOf = Arrays.copyOf(jArr, jArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    public static long sum(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        long j2 = 0;
        for (long j3 : jArr) {
            j2 += j3;
        }
        return j2;
    }

    public static final HashSet<Long> toHashSet(long[] jArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(jArr.length);
        return (HashSet) toCollection(jArr, new HashSet(mapCapacity));
    }

    public static List<Integer> toList(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            if (length != 1) {
                return toMutableList(iArr);
            }
            return CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(iArr[0]));
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Long> toMutableList(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j2 : jArr) {
            arrayList.add(Long.valueOf(j2));
        }
        return arrayList;
    }

    public static final Set<Long> toMutableSet(long[] jArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(jArr.length);
        return (Set) toCollection(jArr, new LinkedHashSet(mapCapacity));
    }

    public static final Set<Integer> toSet(int[] iArr) {
        Set<Integer> emptySet;
        Set<Integer> of;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        if (length != 0) {
            if (length != 1) {
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(iArr.length);
                return (Set) toCollection(iArr, new LinkedHashSet(mapCapacity));
            }
            of = SetsKt__SetsJVMKt.setOf(Integer.valueOf(iArr[0]));
            return of;
        }
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    public static <T> Iterable<IndexedValue<T>> withIndex(final T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return new b0(new Function0() { // from class: kotlin.collections.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator it2;
                it2 = ArrayIteratorKt.iterator(tArr);
                return it2;
            }
        });
    }

    public static <T> Iterable<T> asIterable(T[] tArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return new a(tArr);
    }

    public static <T> Sequence<T> asSequence(T[] tArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return SequencesKt__SequencesKt.emptySequence();
        }
        return new j(tArr);
    }

    private static final short component1(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr[0];
    }

    private static final short component2(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr[1];
    }

    private static final short component3(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr[2];
    }

    private static final short component4(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr[3];
    }

    private static final short component5(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr[4];
    }

    private static final int count(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return iArr.length;
    }

    public static final List<Short> distinct(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return CollectionsKt___CollectionsKt.toList(toMutableSet(sArr));
    }

    public static final float first(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return fArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double firstOrNull(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Double.valueOf(dArr[0]);
    }

    public static final IntRange getIndices(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return new IntRange(0, getLastIndex(sArr));
    }

    public static final int getLastIndex(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return sArr.length - 1;
    }

    private static final boolean isEmpty(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            return true;
        }
        return false;
    }

    private static final boolean isNotEmpty(short[] sArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (sArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    public static final float last(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return fArr[getLastIndex(fArr)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double lastOrNull(double[] dArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Double.valueOf(dArr[dArr.length - 1]);
    }

    public static final Float maxOrNull(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                f2 = Math.max(f2, fArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final float maxOrThrow(Float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            float floatValue = fArr[0].floatValue();
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    floatValue = Math.max(floatValue, fArr[i2].floatValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    public static final Float minOrNull(float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                f2 = Math.min(f2, fArr[i2]);
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final float minOrThrow(Float[] fArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            float floatValue = fArr[0].floatValue();
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    floatValue = Math.min(floatValue, fArr[i2].floatValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    public static <T> List<T> reversed(T[] tArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<T> mutableList = toMutableList(tArr);
        CollectionsKt___CollectionsJvmKt.reverse(mutableList);
        return mutableList;
    }

    public static final long[] reversedArray(long[] jArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int i2 = 0;
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return jArr;
        }
        long[] jArr2 = new long[jArr.length];
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            while (true) {
                jArr2[lastIndex - i2] = jArr[i2];
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return jArr2;
    }

    public static final float single(float[] fArr) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        if (length != 0) {
            if (length == 1) {
                return fArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double singleOrNull(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (dArr.length == 1) {
            return Double.valueOf(dArr[0]);
        }
        return null;
    }

    public static final List<Short> sorted(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        Short[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(sArr);
        ArraysKt___ArraysJvmKt.sort((Object[]) typedArray);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final <T extends Comparable<? super T>> T[] sortedArray(T[] tArr) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) copyOf);
        ArraysKt___ArraysJvmKt.sort((Object[]) tArr2);
        return tArr2;
    }

    public static final <T extends Comparable<? super T>> T[] sortedArrayDescending(T[] tArr) {
        boolean z;
        Comparator reverseOrder;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        T[] tArr2 = (T[]) ((Comparable[]) copyOf);
        reverseOrder = ComparisonsKt__ComparisonsKt.reverseOrder();
        ArraysKt___ArraysJvmKt.sortWith(tArr2, reverseOrder);
        return tArr2;
    }

    public static final List<Short> sortedDescending(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        short[] copyOf = Arrays.copyOf(sArr, sArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sort(copyOf);
        return reversed(copyOf);
    }

    public static <T> HashSet<T> toHashSet(T[] tArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(tArr.length);
        return (HashSet) toCollection(tArr, new HashSet(mapCapacity));
    }

    public static List<Long> toList(long[] jArr) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            if (length != 1) {
                return toMutableList(jArr);
            }
            return CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(jArr[0]));
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Short> toMutableList(short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s2 : sArr) {
            arrayList.add(Short.valueOf(s2));
        }
        return arrayList;
    }

    public static <T> Set<T> toMutableSet(T[] tArr) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(tArr.length);
        return (Set) toCollection(tArr, new LinkedHashSet(mapCapacity));
    }

    public static final Set<Long> toSet(long[] jArr) {
        Set<Long> emptySet;
        Set<Long> of;
        int mapCapacity;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        if (length != 0) {
            if (length != 1) {
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(jArr.length);
                return (Set) toCollection(jArr, new LinkedHashSet(mapCapacity));
            }
            of = SetsKt__SetsJVMKt.setOf(Long.valueOf(jArr[0]));
            return of;
        }
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    public static final Iterable<IndexedValue<Short>> withIndex(final short[] sArr) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        return new b0(new Function0() { // from class: kotlin.collections.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Iterator h2;
                h2 = kotlin.jvm.internal.h.h(sArr);
                return h2;
            }
        });
    }

    public static boolean contains(byte[] bArr, byte b2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (indexOf(bArr, b2) >= 0) {
            return true;
        }
        return false;
    }

    private static final Boolean elementAtOrNull(boolean[] zArr, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        return getOrNull(zArr, i2);
    }

    public static final <T, K> Grouping<T, K> groupingBy(T[] tArr, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        return new s(tArr, keySelector);
    }

    public static boolean contains(char[] cArr, char c2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (indexOf(cArr, c2) >= 0) {
            return true;
        }
        return false;
    }

    private static final Byte elementAtOrNull(byte[] bArr, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return getOrNull(bArr, i2);
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(T[] tArr, C destination) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t : tArr) {
            if (t != null) {
                destination.add(t);
            }
        }
        return destination;
    }

    private static final <T, R> R firstNotNullOfOrNull(T[] tArr, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t : tArr) {
            R invoke = transform.invoke(t);
            if (invoke != null) {
                return invoke;
            }
        }
        return null;
    }

    public static final void forEach(byte[] bArr, Function1<? super Byte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (byte b2 : bArr) {
            action.invoke(Byte.valueOf(b2));
        }
    }

    public static final <T> void forEachIndexed(T[] tArr, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), tArr[i2]);
            i2++;
            i3++;
        }
    }

    public static final Boolean getOrNull(boolean[] zArr, int i2) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        boolean z = false;
        if (i2 >= 0 && i2 < zArr.length) {
            z = true;
        }
        if (z) {
            return Boolean.valueOf(zArr[i2]);
        }
        return null;
    }

    public static final int indexOf(byte[] bArr, byte b2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (b2 == bArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final Set<Byte> intersect(byte[] bArr, Iterable<Byte> other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final int lastIndexOf(byte[] bArr, byte b2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (b2 == bArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    private static final byte[] onEach(byte[] bArr, Function1<? super Byte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (byte b2 : bArr) {
            action.invoke(Byte.valueOf(b2));
        }
        return bArr;
    }

    private static final <T> T[] onEachIndexed(T[] tArr, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), tArr[i2]);
            i2++;
            i3++;
        }
        return tArr;
    }

    public static final Boolean randomOrNull(boolean[] zArr, Random random) {
        boolean z;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (zArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Boolean.valueOf(zArr[random.nextInt(zArr.length)]);
    }

    public static final <T, R extends Comparable<? super R>> void sortBy(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(tArr, new ComparisonsKt__ComparisonsKt.a(selector));
        }
    }

    public static final <T, R extends Comparable<? super R>> void sortByDescending(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        if (tArr.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(tArr, new ComparisonsKt__ComparisonsKt.c(selector));
        }
    }

    public static final <R extends Comparable<? super R>> List<Byte> sortedBy(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new ComparisonsKt__ComparisonsKt.a(selector));
    }

    public static final <R extends Comparable<? super R>> List<Byte> sortedByDescending(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(bArr, (Comparator<? super Byte>) new ComparisonsKt__ComparisonsKt.c(selector));
    }

    public static final List<Byte> sortedWith(byte[] bArr, Comparator<? super Byte> comparator) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Byte[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(bArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final Set<Byte> subtract(byte[] bArr, Iterable<Byte> other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> int sumBy(T[] tArr, Function1<? super T, Integer> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (T t : tArr) {
            i2 += selector.invoke(t).intValue();
        }
        return i2;
    }

    public static final <C extends Collection<? super Byte>> C toCollection(byte[] bArr, C destination) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (byte b2 : bArr) {
            destination.add(Byte.valueOf(b2));
        }
        return destination;
    }

    public static final Set<Byte> union(byte[] bArr, Iterable<Byte> other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Byte> mutableSet = toMutableSet(bArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final boolean all(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b2 : bArr) {
            if (!predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <K, V> Map<K, V> associate(byte[] bArr, Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> transform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(bArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (byte b2 : bArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Byte.valueOf(b2));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Byte> associateBy(byte[] bArr, Function1<? super Byte, ? extends K> keySelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(bArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (byte b2 : bArr) {
            linkedHashMap.put(keySelector.invoke(Byte.valueOf(b2)), Byte.valueOf(b2));
        }
        return linkedHashMap;
    }

    private static final <V> Map<Byte, V> associateWith(byte[] bArr, Function1<? super Byte, ? extends V> valueSelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(bArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (byte b2 : bArr) {
            linkedHashMap.put(Byte.valueOf(b2), valueSelector.invoke(Byte.valueOf(b2)));
        }
        return linkedHashMap;
    }

    @DeprecatedSinceKotlin(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ boolean contains(double[] dArr, double d2) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        for (double d3 : dArr) {
            if (d3 == d2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static final int count(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final <K> List<Byte> distinctBy(byte[] bArr, Function1<? super Byte, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            if (hashSet.add(selector.invoke(Byte.valueOf(b2)))) {
                arrayList.add(Byte.valueOf(b2));
            }
        }
        return arrayList;
    }

    public static final List<Byte> drop(byte[] bArr, int i2) {
        boolean z;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(bArr.length - i2, 0);
            return takeLast(bArr, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Byte> dropLast(byte[] bArr, int i2) {
        boolean z;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(bArr.length - i2, 0);
            return take(bArr, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Byte> dropLastWhile(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(bArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Byte.valueOf(bArr[lastIndex])).booleanValue()) {
                return take(bArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Byte> dropWhile(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (byte b2 : bArr) {
            if (z) {
                arrayList.add(Byte.valueOf(b2));
            } else if (!predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
                z = true;
            }
        }
        return arrayList;
    }

    private static final Character elementAtOrNull(char[] cArr, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return getOrNull(cArr, i2);
    }

    public static final List<Byte> filter(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
            }
        }
        return arrayList;
    }

    public static final List<Byte> filterIndexed(byte[] bArr, Function2<? super Integer, ? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Object[] objArr, C destination) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (Object obj : objArr) {
            Intrinsics.reifiedOperationMarker(3, "R");
            if (obj instanceof Object) {
                destination.add(obj);
            }
        }
        return destination;
    }

    public static final List<Byte> filterNot(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            if (!predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
            }
        }
        return arrayList;
    }

    private static final Boolean find(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    private static final Boolean findLast(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                boolean z = zArr[length];
                if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                    return Boolean.valueOf(z);
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return null;
    }

    public static final byte first(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                return b2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    private static final <T, R> R firstNotNullOf(T[] tArr, Function1<? super T, ? extends R> transform) {
        R r2;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                r2 = transform.invoke(tArr[i2]);
                if (r2 != null) {
                    break;
                }
                i2++;
            } else {
                r2 = null;
                break;
            }
        }
        if (r2 != null) {
            return r2;
        }
        throw new NoSuchElementException("No element of the array was transformed to a non-null value.");
    }

    public static final Boolean firstOrNull(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (boolean z : zArr) {
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    public static final <R> List<R> flatMap(byte[] bArr, Function1<? super Byte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Byte.valueOf(b2)));
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(byte[] bArr, Function2<? super Integer, ? super Byte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i3), Byte.valueOf(bArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    private static final <T, R> List<R> flatMapIndexedSequence(T[] tArr, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i3), tArr[i2]));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final <T, R> List<R> flatMapSequence(T[] tArr, Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(t));
        }
        return arrayList;
    }

    public static final void forEach(char[] cArr, Function1<? super Character, Unit> action) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (char c2 : cArr) {
            action.invoke(Character.valueOf(c2));
        }
    }

    public static final void forEachIndexed(byte[] bArr, Function2<? super Integer, ? super Byte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Byte.valueOf(bArr[i2]));
            i2++;
            i3++;
        }
    }

    public static final Byte getOrNull(byte[] bArr, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        boolean z = false;
        if (i2 >= 0 && i2 < bArr.length) {
            z = true;
        }
        if (z) {
            return Byte.valueOf(bArr[i2]);
        }
        return null;
    }

    public static final <K> Map<K, List<Byte>> groupBy(byte[] bArr, Function1<? super Byte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b2 : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Byte.valueOf(b2));
        }
        return linkedHashMap;
    }

    public static int indexOf(char[] cArr, char c2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (c2 == cArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (predicate.invoke(Byte.valueOf(bArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (predicate.invoke(Byte.valueOf(bArr[length])).booleanValue()) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final Set<Character> intersect(char[] cArr, Iterable<Character> other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final byte last(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                byte b2 = bArr[length];
                if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                    return b2;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int lastIndexOf(char[] cArr, char c2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (c2 == cArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final Boolean lastOrNull(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = zArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i2 = length - 1;
            boolean z = zArr[length];
            if (predicate.invoke(Boolean.valueOf(z)).booleanValue()) {
                return Boolean.valueOf(z);
            }
            if (i2 >= 0) {
                length = i2;
            } else {
                return null;
            }
        }
    }

    public static final <R> List<R> map(byte[] bArr, Function1<? super Byte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b2 : bArr) {
            arrayList.add(transform.invoke(Byte.valueOf(b2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(byte[] bArr, Function2<? super Integer, ? super Byte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(bArr.length);
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i3), Byte.valueOf(bArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapIndexedNotNull(T[] tArr, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            R invoke = transform.invoke(Integer.valueOf(i3), tArr[i2]);
            if (invoke != null) {
                arrayList.add(invoke);
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final <T, R> List<R> mapNotNull(T[] tArr, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (T t : tArr) {
            R invoke = transform.invoke(t);
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    public static final <T, R extends Comparable<? super R>> T maxByOrNull(T[] tArr, Function1<? super T, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex == 0) {
            return t;
        }
        R invoke = selector.invoke(t);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                R invoke2 = selector.invoke(t2);
                if (invoke.compareTo(invoke2) < 0) {
                    t = t2;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    /* renamed from: maxOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m918maxOf(T[] tArr, Function1<? super T, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            R invoke = selector.invoke(tArr[0]);
            int lastIndex = getLastIndex(tArr);
            if (1 <= lastIndex) {
                while (true) {
                    R invoke2 = selector.invoke(tArr[i2]);
                    if (invoke.compareTo(invoke2) < 0) {
                        invoke = invoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    private static final <T, R extends Comparable<? super R>> R maxOfOrNull(T[] tArr, Function1<? super T, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        R invoke = selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(tArr[i2]);
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    public static final Boolean maxWithOrNull(boolean[] zArr, Comparator<? super Boolean> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (zArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i2];
                if (comparator.compare(Boolean.valueOf(z2), Boolean.valueOf(z3)) < 0) {
                    z2 = z3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final byte maxWithOrThrow(byte[] bArr, Comparator<? super Byte> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            byte b2 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    byte b3 = bArr[i2];
                    if (comparator.compare(Byte.valueOf(b2), Byte.valueOf(b3)) < 0) {
                        b2 = b3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return b2;
        }
        throw new NoSuchElementException();
    }

    public static final <T, R extends Comparable<? super R>> T minByOrNull(T[] tArr, Function1<? super T, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        T t = tArr[0];
        int lastIndex = getLastIndex(tArr);
        if (lastIndex == 0) {
            return t;
        }
        R invoke = selector.invoke(t);
        if (1 <= lastIndex) {
            while (true) {
                T t2 = tArr[i2];
                R invoke2 = selector.invoke(t2);
                if (invoke.compareTo(invoke2) > 0) {
                    t = t2;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return t;
    }

    /* renamed from: minOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m954minOf(T[] tArr, Function1<? super T, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            R invoke = selector.invoke(tArr[0]);
            int lastIndex = getLastIndex(tArr);
            if (1 <= lastIndex) {
                while (true) {
                    R invoke2 = selector.invoke(tArr[i2]);
                    if (invoke.compareTo(invoke2) > 0) {
                        invoke = invoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    private static final <T, R extends Comparable<? super R>> R minOfOrNull(T[] tArr, Function1<? super T, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        R invoke = selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(tArr[i2]);
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    public static final Boolean minWithOrNull(boolean[] zArr, Comparator<? super Boolean> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (zArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i2];
                if (comparator.compare(Boolean.valueOf(z2), Boolean.valueOf(z3)) > 0) {
                    z2 = z3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final byte minWithOrThrow(byte[] bArr, Comparator<? super Byte> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            byte b2 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    byte b3 = bArr[i2];
                    if (comparator.compare(Byte.valueOf(b2), Byte.valueOf(b3)) > 0) {
                        b2 = b3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return b2;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private static final char[] onEach(char[] cArr, Function1<? super Character, Unit> action) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (char c2 : cArr) {
            action.invoke(Character.valueOf(c2));
        }
        return cArr;
    }

    private static final byte[] onEachIndexed(byte[] bArr, Function2<? super Integer, ? super Byte, Unit> action) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Byte.valueOf(bArr[i2]));
            i2++;
            i3++;
        }
        return bArr;
    }

    public static final <T> Pair<List<T>, List<T>> partition(T[] tArr, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (T t : tArr) {
            if (predicate.invoke(t).booleanValue()) {
                arrayList.add(t);
            } else {
                arrayList2.add(t);
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final byte random(byte[] bArr, Random random) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return bArr[random.nextInt(bArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final byte reduce(byte[] bArr, Function2<? super Byte, ? super Byte, Byte> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            byte b2 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    b2 = operation.invoke(Byte.valueOf(b2), Byte.valueOf(bArr[i2])).byteValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return b2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(T[] tArr, Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            S s2 = (Object) tArr[0];
            int lastIndex = getLastIndex(tArr);
            if (1 <= lastIndex) {
                while (true) {
                    s2 = operation.invoke(Integer.valueOf(i2), s2, (Object) tArr[i2]);
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return s2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Boolean reduceIndexedOrNull(boolean[] zArr, Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (zArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                z2 = operation.invoke(Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(zArr[i2])).booleanValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final Boolean reduceOrNull(boolean[] zArr, Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (zArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (1 <= lastIndex) {
            while (true) {
                z2 = operation.invoke(Boolean.valueOf(z2), Boolean.valueOf(zArr[i2])).booleanValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final byte reduceRight(byte[] bArr, Function2<? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte b2 = bArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                b2 = operation.invoke(Byte.valueOf(bArr[i2]), Byte.valueOf(b2)).byteValue();
            }
            return b2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final byte reduceRightIndexed(byte[] bArr, Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex >= 0) {
            byte b2 = bArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                b2 = operation.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i2]), Byte.valueOf(b2)).byteValue();
            }
            return b2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Boolean reduceRightIndexedOrNull(boolean[] zArr, Function3<? super Integer, ? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            return null;
        }
        boolean z = zArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            z = operation.invoke(Integer.valueOf(i2), Boolean.valueOf(zArr[i2]), Boolean.valueOf(z)).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    public static final Boolean reduceRightOrNull(boolean[] zArr, Function2<? super Boolean, ? super Boolean, Boolean> operation) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(zArr);
        if (lastIndex < 0) {
            return null;
        }
        boolean z = zArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            z = operation.invoke(Boolean.valueOf(zArr[i2]), Boolean.valueOf(z)).booleanValue();
        }
        return Boolean.valueOf(z);
    }

    public static final <S, T extends S> List<S> runningReduce(T[] tArr, Function2<? super S, ? super T, ? extends S> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        S s2 = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(s2);
        int length = tArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            s2 = operation.invoke(s2, (Object) tArr[i2]);
            arrayList.add(s2);
        }
        return arrayList;
    }

    public static final <S, T extends S> List<S> runningReduceIndexed(T[] tArr, Function3<? super Integer, ? super S, ? super T, ? extends S> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        S s2 = (Object) tArr[0];
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.add(s2);
        int length = tArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            s2 = operation.invoke(Integer.valueOf(i2), s2, (Object) tArr[i2]);
            arrayList.add(s2);
        }
        return arrayList;
    }

    public static final void shuffle(byte[] bArr, Random random) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(bArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            byte b2 = bArr[lastIndex];
            bArr[lastIndex] = bArr[nextInt];
            bArr[nextInt] = b2;
        }
    }

    public static final Boolean singleOrNull(boolean[] zArr, Function1<? super Boolean, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Boolean bool = null;
        boolean z = false;
        for (boolean z2 : zArr) {
            if (predicate.invoke(Boolean.valueOf(z2)).booleanValue()) {
                if (z) {
                    return null;
                }
                bool = Boolean.valueOf(z2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return bool;
    }

    public static final List<Byte> slice(byte[] bArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Byte.valueOf(bArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    public static final byte[] sliceArray(byte[] bArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        byte[] bArr2 = new byte[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            bArr2[i2] = bArr[it2.next().intValue()];
            i2++;
        }
        return bArr2;
    }

    public static final <T> T[] sortedArrayWith(T[] tArr, Comparator<? super T> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return tArr;
        }
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        Intrinsics.checkNotNullExpressionValue(tArr2, "copyOf(...)");
        ArraysKt___ArraysJvmKt.sortWith(tArr2, comparator);
        return tArr2;
    }

    public static final <R extends Comparable<? super R>> List<Character> sortedBy(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new ComparisonsKt__ComparisonsKt.a(selector));
    }

    public static final <R extends Comparable<? super R>> List<Character> sortedByDescending(char[] cArr, Function1<? super Character, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(cArr, (Comparator<? super Character>) new ComparisonsKt__ComparisonsKt.c(selector));
    }

    public static final List<Character> sortedWith(char[] cArr, Comparator<? super Character> comparator) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Character[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(cArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final Set<Character> subtract(char[] cArr, Iterable<Character> other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(byte[] bArr, Function1<? super Byte, Integer> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (byte b2 : bArr) {
            i2 += selector.invoke(Byte.valueOf(b2)).intValue();
        }
        return i2;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(byte[] bArr, Function1<? super Byte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (byte b2 : bArr) {
            d2 += selector.invoke(Byte.valueOf(b2)).doubleValue();
        }
        return d2;
    }

    private static final double sumOfDouble(byte[] bArr, Function1<? super Byte, Double> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (byte b2 : bArr) {
            d2 += selector.invoke(Byte.valueOf(b2)).doubleValue();
        }
        return d2;
    }

    private static final int sumOfInt(byte[] bArr, Function1<? super Byte, Integer> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (byte b2 : bArr) {
            i2 += selector.invoke(Byte.valueOf(b2)).intValue();
        }
        return i2;
    }

    private static final long sumOfLong(byte[] bArr, Function1<? super Byte, Long> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long j2 = 0;
        for (byte b2 : bArr) {
            j2 += selector.invoke(Byte.valueOf(b2)).longValue();
        }
        return j2;
    }

    private static final int sumOfUInt(byte[] bArr, Function1<? super Byte, UInt> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int m790constructorimpl = UInt.m790constructorimpl(0);
        for (byte b2 : bArr) {
            m790constructorimpl = UInt.m790constructorimpl(m790constructorimpl + selector.invoke(Byte.valueOf(b2)).m842unboximpl());
        }
        return m790constructorimpl;
    }

    private static final long sumOfULong(byte[] bArr, Function1<? super Byte, ULong> selector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long m850constructorimpl = ULong.m850constructorimpl(0L);
        for (byte b2 : bArr) {
            m850constructorimpl = ULong.m850constructorimpl(m850constructorimpl + selector.invoke(Byte.valueOf(b2)).m902unboximpl());
        }
        return m850constructorimpl;
    }

    public static final List<Byte> takeLastWhile(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(bArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Byte.valueOf(bArr[lastIndex])).booleanValue()) {
                return drop(bArr, lastIndex + 1);
            }
        }
        return toList(bArr);
    }

    public static final List<Byte> takeWhile(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (byte b2 : bArr) {
            if (!predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                break;
            }
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Character>> C toCollection(char[] cArr, C destination) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (char c2 : cArr) {
            destination.add(Character.valueOf(c2));
        }
        return destination;
    }

    public static final Set<Character> union(char[] cArr, Iterable<Character> other) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Character> mutableSet = toMutableSet(cArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final <R> List<Pair<Byte, R>> zip(byte[] bArr, Iterable<? extends R> other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(TuplesKt.to(Byte.valueOf(bArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final boolean all(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c2 : cArr) {
            if (!predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c2 : cArr) {
            if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <K, V> Map<K, V> associate(char[] cArr, Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(cArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (char c2 : cArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(c2));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    private static final <V> Map<Character, V> associateWith(char[] cArr, Function1<? super Character, ? extends V> valueSelector) {
        int coerceAtMost;
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(cArr.length, 128);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(coerceAtMost);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (char c2 : cArr) {
            linkedHashMap.put(Character.valueOf(c2), valueSelector.invoke(Character.valueOf(c2)));
        }
        return linkedHashMap;
    }

    @DeprecatedSinceKotlin(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ boolean contains(float[] fArr, float f2) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        for (float f3 : fArr) {
            if (f3 == f2) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static final int count(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        for (char c2 : cArr) {
            if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final <K> List<Character> distinctBy(char[] cArr, Function1<? super Character, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            if (hashSet.add(selector.invoke(Character.valueOf(c2)))) {
                arrayList.add(Character.valueOf(c2));
            }
        }
        return arrayList;
    }

    public static final List<Character> drop(char[] cArr, int i2) {
        boolean z;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(cArr.length - i2, 0);
            return takeLast(cArr, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Character> dropLast(char[] cArr, int i2) {
        boolean z;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(cArr.length - i2, 0);
            return take(cArr, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Character> dropLastWhile(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(cArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Character.valueOf(cArr[lastIndex])).booleanValue()) {
                return take(cArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Character> dropWhile(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (char c2 : cArr) {
            if (z) {
                arrayList.add(Character.valueOf(c2));
            } else if (!predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
                z = true;
            }
        }
        return arrayList;
    }

    private static final Double elementAtOrNull(double[] dArr, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        return getOrNull(dArr, i2);
    }

    public static final List<Character> filter(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
            }
        }
        return arrayList;
    }

    public static final List<Character> filterIndexed(char[] cArr, Function2<? super Integer, ? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char c2 = cArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final List<Character> filterNot(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            if (!predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
            }
        }
        return arrayList;
    }

    private static final Byte find(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                return Byte.valueOf(b2);
            }
        }
        return null;
    }

    private static final Byte findLast(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                byte b2 = bArr[length];
                if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                    return Byte.valueOf(b2);
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return null;
    }

    public static final <R> List<R> flatMap(char[] cArr, Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Character.valueOf(c2)));
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(char[] cArr, Function2<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i3), Character.valueOf(cArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final void forEach(double[] dArr, Function1<? super Double, Unit> action) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (double d2 : dArr) {
            action.invoke(Double.valueOf(d2));
        }
    }

    public static final void forEachIndexed(char[] cArr, Function2<? super Integer, ? super Character, Unit> action) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Character.valueOf(cArr[i2]));
            i2++;
            i3++;
        }
    }

    public static final Character getOrNull(char[] cArr, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        boolean z = false;
        if (i2 >= 0 && i2 < cArr.length) {
            z = true;
        }
        if (z) {
            return Character.valueOf(cArr[i2]);
        }
        return null;
    }

    @DeprecatedSinceKotlin(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int indexOf(double[] dArr, double d2) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (d2 == dArr[i2]) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (predicate.invoke(Character.valueOf(cArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (predicate.invoke(Character.valueOf(cArr[length])).booleanValue()) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final Set<Double> intersect(double[] dArr, Iterable<Double> other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    @DeprecatedSinceKotlin(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int lastIndexOf(double[] dArr, double d2) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (d2 == dArr[length]) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final <R> List<R> map(char[] cArr, Function1<? super Character, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        for (char c2 : cArr) {
            arrayList.add(transform.invoke(Character.valueOf(c2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(char[] cArr, Function2<? super Integer, ? super Character, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(cArr.length);
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i3), Character.valueOf(cArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final <R extends Comparable<? super R>> Boolean maxByOrNull(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z2);
        }
        R invoke = selector.invoke(Boolean.valueOf(z2));
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i2];
                R invoke2 = selector.invoke(Boolean.valueOf(z3));
                if (invoke.compareTo(invoke2) < 0) {
                    z2 = z3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final <R extends Comparable<? super R>> byte maxByOrThrow(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            byte b2 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (lastIndex == 0) {
                return b2;
            }
            R invoke = selector.invoke(Byte.valueOf(b2));
            if (1 <= lastIndex) {
                while (true) {
                    byte b3 = bArr[i2];
                    R invoke2 = selector.invoke(Byte.valueOf(b3));
                    if (invoke.compareTo(invoke2) < 0) {
                        b2 = b3;
                        invoke = invoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return b2;
        }
        throw new NoSuchElementException();
    }

    private static final double maxOf(byte[] bArr, Function1<? super Byte, Double> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double doubleValue = selector.invoke(Byte.valueOf(bArr[0])).doubleValue();
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    doubleValue = Math.max(doubleValue, selector.invoke(Byte.valueOf(bArr[i2])).doubleValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        R invoke = selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Byte.valueOf(bArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    public static final Byte maxWithOrNull(byte[] bArr, Comparator<? super Byte> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                if (comparator.compare(Byte.valueOf(b2), Byte.valueOf(b3)) < 0) {
                    b2 = b3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final char maxWithOrThrow(char[] cArr, Comparator<? super Character> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            char c2 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    char c3 = cArr[i2];
                    if (comparator.compare(Character.valueOf(c2), Character.valueOf(c3)) < 0) {
                        c2 = c3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return c2;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> Boolean minByOrNull(boolean[] zArr, Function1<? super Boolean, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (zArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        boolean z2 = zArr[0];
        int lastIndex = getLastIndex(zArr);
        if (lastIndex == 0) {
            return Boolean.valueOf(z2);
        }
        R invoke = selector.invoke(Boolean.valueOf(z2));
        if (1 <= lastIndex) {
            while (true) {
                boolean z3 = zArr[i2];
                R invoke2 = selector.invoke(Boolean.valueOf(z3));
                if (invoke.compareTo(invoke2) > 0) {
                    z2 = z3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z2);
    }

    public static final <R extends Comparable<? super R>> byte minByOrThrow(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            byte b2 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (lastIndex == 0) {
                return b2;
            }
            R invoke = selector.invoke(Byte.valueOf(b2));
            if (1 <= lastIndex) {
                while (true) {
                    byte b3 = bArr[i2];
                    R invoke2 = selector.invoke(Byte.valueOf(b3));
                    if (invoke.compareTo(invoke2) > 0) {
                        b2 = b3;
                        invoke = invoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return b2;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(byte[] bArr, Function1<? super Byte, Double> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double doubleValue = selector.invoke(Byte.valueOf(bArr[0])).doubleValue();
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    doubleValue = Math.min(doubleValue, selector.invoke(Byte.valueOf(bArr[i2])).doubleValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        R invoke = selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Byte.valueOf(bArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    public static final Byte minWithOrNull(byte[] bArr, Comparator<? super Byte> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                if (comparator.compare(Byte.valueOf(b2), Byte.valueOf(b3)) > 0) {
                    b2 = b3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final char minWithOrThrow(char[] cArr, Comparator<? super Character> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            char c2 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    char c3 = cArr[i2];
                    if (comparator.compare(Character.valueOf(c2), Character.valueOf(c3)) > 0) {
                        c2 = c3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return c2;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c2 : cArr) {
            if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private static final double[] onEach(double[] dArr, Function1<? super Double, Unit> action) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (double d2 : dArr) {
            action.invoke(Double.valueOf(d2));
        }
        return dArr;
    }

    private static final char[] onEachIndexed(char[] cArr, Function2<? super Integer, ? super Character, Unit> action) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Character.valueOf(cArr[i2]));
            i2++;
            i3++;
        }
        return cArr;
    }

    public static final Pair<List<Byte>, List<Byte>> partition(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                arrayList.add(Byte.valueOf(b2));
            } else {
                arrayList2.add(Byte.valueOf(b2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final char random(char[] cArr, Random random) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return cArr[random.nextInt(cArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Byte randomOrNull(byte[] bArr, Random random) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Byte.valueOf(bArr[random.nextInt(bArr.length)]);
    }

    public static final char reduce(char[] cArr, Function2<? super Character, ? super Character, Character> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            char c2 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    c2 = operation.invoke(Character.valueOf(c2), Character.valueOf(cArr[i2])).charValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return c2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final byte reduceIndexed(byte[] bArr, Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            byte b2 = bArr[0];
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    b2 = operation.invoke(Integer.valueOf(i2), Byte.valueOf(b2), Byte.valueOf(bArr[i2])).byteValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return b2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Byte reduceIndexedOrNull(byte[] bArr, Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                b2 = operation.invoke(Integer.valueOf(i2), Byte.valueOf(b2), Byte.valueOf(bArr[i2])).byteValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final Byte reduceOrNull(byte[] bArr, Function2<? super Byte, ? super Byte, Byte> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                b2 = operation.invoke(Byte.valueOf(b2), Byte.valueOf(bArr[i2])).byteValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final char reduceRight(char[] cArr, Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char c2 = cArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                c2 = operation.invoke(Character.valueOf(cArr[i2]), Character.valueOf(c2)).charValue();
            }
            return c2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceRightIndexed(char[] cArr, Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex >= 0) {
            char c2 = cArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                c2 = operation.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i2]), Character.valueOf(c2)).charValue();
            }
            return c2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Byte reduceRightIndexedOrNull(byte[] bArr, Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte b2 = bArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            b2 = operation.invoke(Integer.valueOf(i2), Byte.valueOf(bArr[i2]), Byte.valueOf(b2)).byteValue();
        }
        return Byte.valueOf(b2);
    }

    public static final Byte reduceRightOrNull(byte[] bArr, Function2<? super Byte, ? super Byte, Byte> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(bArr);
        if (lastIndex < 0) {
            return null;
        }
        byte b2 = bArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            b2 = operation.invoke(Byte.valueOf(bArr[i2]), Byte.valueOf(b2)).byteValue();
        }
        return Byte.valueOf(b2);
    }

    private static final List<Byte> runningReduce(byte[] bArr, Function2<? super Byte, ? super Byte, Byte> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        byte b2 = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(b2));
        int length = bArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            b2 = operation.invoke(Byte.valueOf(b2), Byte.valueOf(bArr[i2])).byteValue();
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    private static final List<Byte> runningReduceIndexed(byte[] bArr, Function3<? super Integer, ? super Byte, ? super Byte, Byte> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        byte b2 = bArr[0];
        ArrayList arrayList = new ArrayList(bArr.length);
        arrayList.add(Byte.valueOf(b2));
        int length = bArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            b2 = operation.invoke(Integer.valueOf(i2), Byte.valueOf(b2), Byte.valueOf(bArr[i2])).byteValue();
            arrayList.add(Byte.valueOf(b2));
        }
        return arrayList;
    }

    public static final void shuffle(char[] cArr, Random random) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(cArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            char c2 = cArr[lastIndex];
            cArr[lastIndex] = cArr[nextInt];
            cArr[nextInt] = c2;
        }
    }

    public static final byte single(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Byte b2 = null;
        boolean z = false;
        for (byte b3 : bArr) {
            if (predicate.invoke(Byte.valueOf(b3)).booleanValue()) {
                if (!z) {
                    b2 = Byte.valueOf(b3);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Intrinsics.checkNotNull(b2, "null cannot be cast to non-null type kotlin.Byte");
            return b2.byteValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static List<Byte> slice(byte[] bArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static byte[] sliceArray(byte[] bArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return new byte[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(bArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final <R extends Comparable<? super R>> List<Double> sortedBy(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(dArr, new ComparisonsKt__ComparisonsKt.a(selector));
    }

    public static final <R extends Comparable<? super R>> List<Double> sortedByDescending(double[] dArr, Function1<? super Double, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(dArr, new ComparisonsKt__ComparisonsKt.c(selector));
    }

    public static final List<Double> sortedWith(double[] dArr, Comparator<? super Double> comparator) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Double[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(dArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final Set<Double> subtract(double[] dArr, Iterable<Double> other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(char[] cArr, Function1<? super Character, Integer> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (char c2 : cArr) {
            i2 += selector.invoke(Character.valueOf(c2)).intValue();
        }
        return i2;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(char[] cArr, Function1<? super Character, Double> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (char c2 : cArr) {
            d2 += selector.invoke(Character.valueOf(c2)).doubleValue();
        }
        return d2;
    }

    private static final double sumOfDouble(char[] cArr, Function1<? super Character, Double> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (char c2 : cArr) {
            d2 += selector.invoke(Character.valueOf(c2)).doubleValue();
        }
        return d2;
    }

    private static final int sumOfInt(char[] cArr, Function1<? super Character, Integer> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (char c2 : cArr) {
            i2 += selector.invoke(Character.valueOf(c2)).intValue();
        }
        return i2;
    }

    private static final long sumOfLong(char[] cArr, Function1<? super Character, Long> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long j2 = 0;
        for (char c2 : cArr) {
            j2 += selector.invoke(Character.valueOf(c2)).longValue();
        }
        return j2;
    }

    private static final int sumOfUInt(char[] cArr, Function1<? super Character, UInt> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int m790constructorimpl = UInt.m790constructorimpl(0);
        for (char c2 : cArr) {
            m790constructorimpl = UInt.m790constructorimpl(m790constructorimpl + selector.invoke(Character.valueOf(c2)).m842unboximpl());
        }
        return m790constructorimpl;
    }

    private static final long sumOfULong(char[] cArr, Function1<? super Character, ULong> selector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long m850constructorimpl = ULong.m850constructorimpl(0L);
        for (char c2 : cArr) {
            m850constructorimpl = ULong.m850constructorimpl(m850constructorimpl + selector.invoke(Character.valueOf(c2)).m902unboximpl());
        }
        return m850constructorimpl;
    }

    public static final List<Byte> take(byte[] bArr, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (i2 >= bArr.length) {
                return toList(bArr);
            }
            if (i2 == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Byte.valueOf(bArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (byte b2 : bArr) {
                arrayList.add(Byte.valueOf(b2));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Byte> takeLast(byte[] bArr, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            int length = bArr.length;
            if (i2 >= length) {
                return toList(bArr);
            }
            if (i2 == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Byte.valueOf(bArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Byte.valueOf(bArr[i3]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Character> takeLastWhile(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(cArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Character.valueOf(cArr[lastIndex])).booleanValue()) {
                return drop(cArr, lastIndex + 1);
            }
        }
        return toList(cArr);
    }

    public static final List<Character> takeWhile(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (char c2 : cArr) {
            if (!predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                break;
            }
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Double>> C toCollection(double[] dArr, C destination) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (double d2 : dArr) {
            destination.add(Double.valueOf(d2));
        }
        return destination;
    }

    public static final Set<Double> union(double[] dArr, Iterable<Double> other) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Double> mutableSet = toMutableSet(dArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final boolean all(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d2 : dArr) {
            if (!predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> Map<K, V> associate(double[] dArr, Function1<? super Double, ? extends Pair<? extends K, ? extends V>> transform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(dArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (double d2 : dArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Double.valueOf(d2));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Character> associateBy(char[] cArr, Function1<? super Character, ? extends K> keySelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(cArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (char c2 : cArr) {
            linkedHashMap.put(keySelector.invoke(Character.valueOf(c2)), Character.valueOf(c2));
        }
        return linkedHashMap;
    }

    private static final <V> Map<Double, V> associateWith(double[] dArr, Function1<? super Double, ? extends V> valueSelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(dArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (double d2 : dArr) {
            linkedHashMap.put(Double.valueOf(d2), valueSelector.invoke(Double.valueOf(d2)));
        }
        return linkedHashMap;
    }

    public static boolean contains(int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (indexOf(iArr, i2) >= 0) {
            return true;
        }
        return false;
    }

    public static final int count(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final <K> List<Double> distinctBy(double[] dArr, Function1<? super Double, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            if (hashSet.add(selector.invoke(Double.valueOf(d2)))) {
                arrayList.add(Double.valueOf(d2));
            }
        }
        return arrayList;
    }

    public static final List<Double> drop(double[] dArr, int i2) {
        boolean z;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(dArr.length - i2, 0);
            return takeLast(dArr, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Double> dropLast(double[] dArr, int i2) {
        boolean z;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(dArr.length - i2, 0);
            return take(dArr, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Double> dropLastWhile(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(dArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Double.valueOf(dArr[lastIndex])).booleanValue()) {
                return take(dArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Double> dropWhile(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (double d2 : dArr) {
            if (z) {
                arrayList.add(Double.valueOf(d2));
            } else if (!predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
                z = true;
            }
        }
        return arrayList;
    }

    private static final Float elementAtOrNull(float[] fArr, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        return getOrNull(fArr, i2);
    }

    public static final List<Double> filter(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
            }
        }
        return arrayList;
    }

    public static final List<Double> filterIndexed(double[] dArr, Function2<? super Integer, ? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            double d2 = dArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final List<Double> filterNot(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            if (!predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
            }
        }
        return arrayList;
    }

    private static final Character find(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c2 : cArr) {
            if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                return Character.valueOf(c2);
            }
        }
        return null;
    }

    private static final Character findLast(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                char c2 = cArr[length];
                if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                    return Character.valueOf(c2);
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return null;
    }

    public static final char first(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c2 : cArr) {
            if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                return c2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Byte firstOrNull(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                return Byte.valueOf(b2);
            }
        }
        return null;
    }

    public static final <R> List<R> flatMap(double[] dArr, Function1<? super Double, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Double.valueOf(d2)));
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(double[] dArr, Function2<? super Integer, ? super Double, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i3), Double.valueOf(dArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final void forEach(float[] fArr, Function1<? super Float, Unit> action) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (float f2 : fArr) {
            action.invoke(Float.valueOf(f2));
        }
    }

    public static final void forEachIndexed(double[] dArr, Function2<? super Integer, ? super Double, Unit> action) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Double.valueOf(dArr[i2]));
            i2++;
            i3++;
        }
    }

    public static final Double getOrNull(double[] dArr, int i2) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        boolean z = false;
        if (i2 >= 0 && i2 < dArr.length) {
            z = true;
        }
        if (z) {
            return Double.valueOf(dArr[i2]);
        }
        return null;
    }

    public static final <K> Map<K, List<Character>> groupBy(char[] cArr, Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c2 : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(c2));
        }
        return linkedHashMap;
    }

    @DeprecatedSinceKotlin(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int indexOf(float[] fArr, float f2) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (f2 == fArr[i2]) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (predicate.invoke(Double.valueOf(dArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (predicate.invoke(Double.valueOf(dArr[length])).booleanValue()) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final Set<Float> intersect(float[] fArr, Iterable<Float> other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final char last(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                char c2 = cArr[length];
                if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                    return c2;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    @DeprecatedSinceKotlin(errorSince = "1.6", hiddenSince = "1.7", warningSince = "1.4")
    public static final /* synthetic */ int lastIndexOf(float[] fArr, float f2) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (f2 == fArr[length]) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final Byte lastOrNull(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i2 = length - 1;
            byte b2 = bArr[length];
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                return Byte.valueOf(b2);
            }
            if (i2 >= 0) {
                length = i2;
            } else {
                return null;
            }
        }
    }

    public static final <R> List<R> map(double[] dArr, Function1<? super Double, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d2 : dArr) {
            arrayList.add(transform.invoke(Double.valueOf(d2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(double[] dArr, Function2<? super Integer, ? super Double, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(dArr.length);
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i3), Double.valueOf(dArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final <R extends Comparable<? super R>> Byte maxByOrNull(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b2);
        }
        R invoke = selector.invoke(Byte.valueOf(b2));
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                R invoke2 = selector.invoke(Byte.valueOf(b3));
                if (invoke.compareTo(invoke2) < 0) {
                    b2 = b3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final <R extends Comparable<? super R>> char maxByOrThrow(char[] cArr, Function1<? super Character, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            char c2 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (lastIndex == 0) {
                return c2;
            }
            R invoke = selector.invoke(Character.valueOf(c2));
            if (1 <= lastIndex) {
                while (true) {
                    char c3 = cArr[i2];
                    R invoke2 = selector.invoke(Character.valueOf(c3));
                    if (invoke.compareTo(invoke2) < 0) {
                        c2 = c3;
                        invoke = invoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return c2;
        }
        throw new NoSuchElementException();
    }

    private static final double maxOf(char[] cArr, Function1<? super Character, Double> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double doubleValue = selector.invoke(Character.valueOf(cArr[0])).doubleValue();
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    doubleValue = Math.max(doubleValue, selector.invoke(Character.valueOf(cArr[i2])).doubleValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(char[] cArr, Function1<? super Character, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        R invoke = selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Character.valueOf(cArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    public static final Character maxWithOrNull(char[] cArr, Comparator<? super Character> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                if (comparator.compare(Character.valueOf(c2), Character.valueOf(c3)) < 0) {
                    c2 = c3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final double maxWithOrThrow(double[] dArr, Comparator<? super Double> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double d2 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    double d3 = dArr[i2];
                    if (comparator.compare(Double.valueOf(d2), Double.valueOf(d3)) < 0) {
                        d2 = d3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return d2;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> Byte minByOrNull(byte[] bArr, Function1<? super Byte, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        byte b2 = bArr[0];
        int lastIndex = getLastIndex(bArr);
        if (lastIndex == 0) {
            return Byte.valueOf(b2);
        }
        R invoke = selector.invoke(Byte.valueOf(b2));
        if (1 <= lastIndex) {
            while (true) {
                byte b3 = bArr[i2];
                R invoke2 = selector.invoke(Byte.valueOf(b3));
                if (invoke.compareTo(invoke2) > 0) {
                    b2 = b3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Byte.valueOf(b2);
    }

    public static final <R extends Comparable<? super R>> char minByOrThrow(char[] cArr, Function1<? super Character, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            char c2 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (lastIndex == 0) {
                return c2;
            }
            R invoke = selector.invoke(Character.valueOf(c2));
            if (1 <= lastIndex) {
                while (true) {
                    char c3 = cArr[i2];
                    R invoke2 = selector.invoke(Character.valueOf(c3));
                    if (invoke.compareTo(invoke2) > 0) {
                        c2 = c3;
                        invoke = invoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return c2;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(char[] cArr, Function1<? super Character, Double> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double doubleValue = selector.invoke(Character.valueOf(cArr[0])).doubleValue();
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    doubleValue = Math.min(doubleValue, selector.invoke(Character.valueOf(cArr[i2])).doubleValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(char[] cArr, Function1<? super Character, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        R invoke = selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Character.valueOf(cArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    public static final Character minWithOrNull(char[] cArr, Comparator<? super Character> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                if (comparator.compare(Character.valueOf(c2), Character.valueOf(c3)) > 0) {
                    c2 = c3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final double minWithOrThrow(double[] dArr, Comparator<? super Double> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double d2 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    double d3 = dArr[i2];
                    if (comparator.compare(Double.valueOf(d2), Double.valueOf(d3)) > 0) {
                        d2 = d3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return d2;
        }
        throw new NoSuchElementException();
    }

    private static final float[] onEach(float[] fArr, Function1<? super Float, Unit> action) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (float f2 : fArr) {
            action.invoke(Float.valueOf(f2));
        }
        return fArr;
    }

    private static final double[] onEachIndexed(double[] dArr, Function2<? super Integer, ? super Double, Unit> action) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Double.valueOf(dArr[i2]));
            i2++;
            i3++;
        }
        return dArr;
    }

    public static final Pair<List<Character>, List<Character>> partition(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (char c2 : cArr) {
            if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                arrayList.add(Character.valueOf(c2));
            } else {
                arrayList2.add(Character.valueOf(c2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final double reduce(double[] dArr, Function2<? super Double, ? super Double, Double> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double d2 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    d2 = operation.invoke(Double.valueOf(d2), Double.valueOf(dArr[i2])).doubleValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return d2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final char reduceIndexed(char[] cArr, Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            char c2 = cArr[0];
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    c2 = operation.invoke(Integer.valueOf(i2), Character.valueOf(c2), Character.valueOf(cArr[i2])).charValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return c2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Character reduceIndexedOrNull(char[] cArr, Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                c2 = operation.invoke(Integer.valueOf(i2), Character.valueOf(c2), Character.valueOf(cArr[i2])).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final Character reduceOrNull(char[] cArr, Function2<? super Character, ? super Character, Character> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                c2 = operation.invoke(Character.valueOf(c2), Character.valueOf(cArr[i2])).charValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final double reduceRight(double[] dArr, Function2<? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double d2 = dArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                d2 = operation.invoke(Double.valueOf(dArr[i2]), Double.valueOf(d2)).doubleValue();
            }
            return d2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceRightIndexed(double[] dArr, Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex >= 0) {
            double d2 = dArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                d2 = operation.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i2]), Double.valueOf(d2)).doubleValue();
            }
            return d2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Character reduceRightIndexedOrNull(char[] cArr, Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex < 0) {
            return null;
        }
        char c2 = cArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            c2 = operation.invoke(Integer.valueOf(i2), Character.valueOf(cArr[i2]), Character.valueOf(c2)).charValue();
        }
        return Character.valueOf(c2);
    }

    public static final Character reduceRightOrNull(char[] cArr, Function2<? super Character, ? super Character, Character> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(cArr);
        if (lastIndex < 0) {
            return null;
        }
        char c2 = cArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            c2 = operation.invoke(Character.valueOf(cArr[i2]), Character.valueOf(c2)).charValue();
        }
        return Character.valueOf(c2);
    }

    private static final List<Character> runningReduce(char[] cArr, Function2<? super Character, ? super Character, Character> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        char c2 = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(c2));
        int length = cArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            c2 = operation.invoke(Character.valueOf(c2), Character.valueOf(cArr[i2])).charValue();
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    private static final List<Character> runningReduceIndexed(char[] cArr, Function3<? super Integer, ? super Character, ? super Character, Character> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        char c2 = cArr[0];
        ArrayList arrayList = new ArrayList(cArr.length);
        arrayList.add(Character.valueOf(c2));
        int length = cArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            c2 = operation.invoke(Integer.valueOf(i2), Character.valueOf(c2), Character.valueOf(cArr[i2])).charValue();
            arrayList.add(Character.valueOf(c2));
        }
        return arrayList;
    }

    public static final char single(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Character ch = null;
        boolean z = false;
        for (char c2 : cArr) {
            if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                if (!z) {
                    ch = Character.valueOf(c2);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Intrinsics.checkNotNull(ch, "null cannot be cast to non-null type kotlin.Char");
            return ch.charValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Byte singleOrNull(byte[] bArr, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Byte b2 = null;
        boolean z = false;
        for (byte b3 : bArr) {
            if (predicate.invoke(Byte.valueOf(b3)).booleanValue()) {
                if (z) {
                    return null;
                }
                b2 = Byte.valueOf(b3);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return b2;
    }

    public static final List<Character> slice(char[] cArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Character.valueOf(cArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    public static final char[] sliceArray(char[] cArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        char[] cArr2 = new char[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            cArr2[i2] = cArr[it2.next().intValue()];
            i2++;
        }
        return cArr2;
    }

    public static final <R extends Comparable<? super R>> List<Float> sortedBy(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new ComparisonsKt__ComparisonsKt.a(selector));
    }

    public static final <R extends Comparable<? super R>> List<Float> sortedByDescending(float[] fArr, Function1<? super Float, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(fArr, (Comparator<? super Float>) new ComparisonsKt__ComparisonsKt.c(selector));
    }

    public static final List<Float> sortedWith(float[] fArr, Comparator<? super Float> comparator) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Float[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(fArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final Set<Float> subtract(float[] fArr, Iterable<Float> other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(double[] dArr, Function1<? super Double, Integer> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (double d2 : dArr) {
            i2 += selector.invoke(Double.valueOf(d2)).intValue();
        }
        return i2;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(double[] dArr, Function1<? super Double, Double> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (double d3 : dArr) {
            d2 += selector.invoke(Double.valueOf(d3)).doubleValue();
        }
        return d2;
    }

    private static final double sumOfDouble(double[] dArr, Function1<? super Double, Double> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (double d3 : dArr) {
            d2 += selector.invoke(Double.valueOf(d3)).doubleValue();
        }
        return d2;
    }

    private static final int sumOfInt(double[] dArr, Function1<? super Double, Integer> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (double d2 : dArr) {
            i2 += selector.invoke(Double.valueOf(d2)).intValue();
        }
        return i2;
    }

    private static final long sumOfLong(double[] dArr, Function1<? super Double, Long> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long j2 = 0;
        for (double d2 : dArr) {
            j2 += selector.invoke(Double.valueOf(d2)).longValue();
        }
        return j2;
    }

    private static final int sumOfUInt(double[] dArr, Function1<? super Double, UInt> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int m790constructorimpl = UInt.m790constructorimpl(0);
        for (double d2 : dArr) {
            m790constructorimpl = UInt.m790constructorimpl(m790constructorimpl + selector.invoke(Double.valueOf(d2)).m842unboximpl());
        }
        return m790constructorimpl;
    }

    private static final long sumOfULong(double[] dArr, Function1<? super Double, ULong> selector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long m850constructorimpl = ULong.m850constructorimpl(0L);
        for (double d2 : dArr) {
            m850constructorimpl = ULong.m850constructorimpl(m850constructorimpl + selector.invoke(Double.valueOf(d2)).m902unboximpl());
        }
        return m850constructorimpl;
    }

    public static final List<Character> take(char[] cArr, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (i2 >= cArr.length) {
                return toList(cArr);
            }
            if (i2 == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(cArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (char c2 : cArr) {
                arrayList.add(Character.valueOf(c2));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Character> takeLast(char[] cArr, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            int length = cArr.length;
            if (i2 >= length) {
                return toList(cArr);
            }
            if (i2 == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(cArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Character.valueOf(cArr[i3]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Double> takeLastWhile(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(dArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Double.valueOf(dArr[lastIndex])).booleanValue()) {
                return drop(dArr, lastIndex + 1);
            }
        }
        return toList(dArr);
    }

    public static final List<Double> takeWhile(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (double d2 : dArr) {
            if (!predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                break;
            }
            arrayList.add(Double.valueOf(d2));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Float>> C toCollection(float[] fArr, C destination) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (float f2 : fArr) {
            destination.add(Float.valueOf(f2));
        }
        return destination;
    }

    public static final Set<Float> union(float[] fArr, Iterable<Float> other) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Float> mutableSet = toMutableSet(fArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final List<Pair<Byte, Byte>> zip(byte[] bArr, byte[] other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(TuplesKt.to(Byte.valueOf(bArr[i2]), Byte.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final boolean all(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f2 : fArr) {
            if (!predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <K, V> Map<K, V> associate(float[] fArr, Function1<? super Float, ? extends Pair<? extends K, ? extends V>> transform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(fArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (float f2 : fArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Float.valueOf(f2));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    private static final <V> Map<Float, V> associateWith(float[] fArr, Function1<? super Float, ? extends V> valueSelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(fArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (float f2 : fArr) {
            linkedHashMap.put(Float.valueOf(f2), valueSelector.invoke(Float.valueOf(f2)));
        }
        return linkedHashMap;
    }

    public static boolean contains(long[] jArr, long j2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (indexOf(jArr, j2) >= 0) {
            return true;
        }
        return false;
    }

    public static final <K> List<Float> distinctBy(float[] fArr, Function1<? super Float, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            if (hashSet.add(selector.invoke(Float.valueOf(f2)))) {
                arrayList.add(Float.valueOf(f2));
            }
        }
        return arrayList;
    }

    public static final List<Float> drop(float[] fArr, int i2) {
        boolean z;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(fArr.length - i2, 0);
            return takeLast(fArr, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Float> dropLast(float[] fArr, int i2) {
        boolean z;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(fArr.length - i2, 0);
            return take(fArr, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Float> dropLastWhile(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(fArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Float.valueOf(fArr[lastIndex])).booleanValue()) {
                return take(fArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Float> dropWhile(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (float f2 : fArr) {
            if (z) {
                arrayList.add(Float.valueOf(f2));
            } else if (!predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
                z = true;
            }
        }
        return arrayList;
    }

    private static final Integer elementAtOrNull(int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        return getOrNull(iArr, i2);
    }

    public static final List<Float> filter(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
            }
        }
        return arrayList;
    }

    public static final List<Float> filterIndexed(float[] fArr, Function2<? super Integer, ? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            float f2 = fArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final List<Float> filterNot(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            if (!predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
            }
        }
        return arrayList;
    }

    private static final Double find(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                return Double.valueOf(d2);
            }
        }
        return null;
    }

    private static final Double findLast(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                double d2 = dArr[length];
                if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                    return Double.valueOf(d2);
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return null;
    }

    public static final <R> List<R> flatMap(float[] fArr, Function1<? super Float, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Float.valueOf(f2)));
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(float[] fArr, Function2<? super Integer, ? super Float, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i3), Float.valueOf(fArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final void forEach(int[] iArr, Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (int i2 : iArr) {
            action.invoke(Integer.valueOf(i2));
        }
    }

    public static final void forEachIndexed(float[] fArr, Function2<? super Integer, ? super Float, Unit> action) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Float.valueOf(fArr[i2]));
            i2++;
            i3++;
        }
    }

    public static Float getOrNull(float[] fArr, int i2) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        boolean z = false;
        if (i2 >= 0 && i2 < fArr.length) {
            z = true;
        }
        if (z) {
            return Float.valueOf(fArr[i2]);
        }
        return null;
    }

    public static int indexOf(int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i2 == iArr[i3]) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (predicate.invoke(Float.valueOf(fArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (predicate.invoke(Float.valueOf(fArr[length])).booleanValue()) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final Set<Integer> intersect(int[] iArr, Iterable<Integer> other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final int lastIndexOf(int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (i2 == iArr[length]) {
                    return length;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
        }
        return -1;
    }

    public static final <R> List<R> map(float[] fArr, Function1<? super Float, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f2 : fArr) {
            arrayList.add(transform.invoke(Float.valueOf(f2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(float[] fArr, Function2<? super Integer, ? super Float, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(fArr.length);
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i3), Float.valueOf(fArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final <R extends Comparable<? super R>> Character maxByOrNull(char[] cArr, Function1<? super Character, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c2);
        }
        R invoke = selector.invoke(Character.valueOf(c2));
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                R invoke2 = selector.invoke(Character.valueOf(c3));
                if (invoke.compareTo(invoke2) < 0) {
                    c2 = c3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final <R extends Comparable<? super R>> double maxByOrThrow(double[] dArr, Function1<? super Double, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double d2 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (lastIndex == 0) {
                return d2;
            }
            R invoke = selector.invoke(Double.valueOf(d2));
            if (1 <= lastIndex) {
                while (true) {
                    double d3 = dArr[i2];
                    R invoke2 = selector.invoke(Double.valueOf(d3));
                    if (invoke.compareTo(invoke2) < 0) {
                        d2 = d3;
                        invoke = invoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return d2;
        }
        throw new NoSuchElementException();
    }

    private static final double maxOf(double[] dArr, Function1<? super Double, Double> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double doubleValue = selector.invoke(Double.valueOf(dArr[0])).doubleValue();
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    doubleValue = Math.max(doubleValue, selector.invoke(Double.valueOf(dArr[i2])).doubleValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(double[] dArr, Function1<? super Double, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        R invoke = selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Double.valueOf(dArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    public static final Double maxWithOrNull(double[] dArr, Comparator<? super Double> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                if (comparator.compare(Double.valueOf(d2), Double.valueOf(d3)) < 0) {
                    d2 = d3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final float maxWithOrThrow(float[] fArr, Comparator<? super Float> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            float f2 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    float f3 = fArr[i2];
                    if (comparator.compare(Float.valueOf(f2), Float.valueOf(f3)) < 0) {
                        f2 = f3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return f2;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> Character minByOrNull(char[] cArr, Function1<? super Character, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        char c2 = cArr[0];
        int lastIndex = getLastIndex(cArr);
        if (lastIndex == 0) {
            return Character.valueOf(c2);
        }
        R invoke = selector.invoke(Character.valueOf(c2));
        if (1 <= lastIndex) {
            while (true) {
                char c3 = cArr[i2];
                R invoke2 = selector.invoke(Character.valueOf(c3));
                if (invoke.compareTo(invoke2) > 0) {
                    c2 = c3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Character.valueOf(c2);
    }

    public static final <R extends Comparable<? super R>> double minByOrThrow(double[] dArr, Function1<? super Double, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double d2 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (lastIndex == 0) {
                return d2;
            }
            R invoke = selector.invoke(Double.valueOf(d2));
            if (1 <= lastIndex) {
                while (true) {
                    double d3 = dArr[i2];
                    R invoke2 = selector.invoke(Double.valueOf(d3));
                    if (invoke.compareTo(invoke2) > 0) {
                        d2 = d3;
                        invoke = invoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return d2;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(double[] dArr, Function1<? super Double, Double> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double doubleValue = selector.invoke(Double.valueOf(dArr[0])).doubleValue();
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    doubleValue = Math.min(doubleValue, selector.invoke(Double.valueOf(dArr[i2])).doubleValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(double[] dArr, Function1<? super Double, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        R invoke = selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Double.valueOf(dArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    public static final Double minWithOrNull(double[] dArr, Comparator<? super Double> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                if (comparator.compare(Double.valueOf(d2), Double.valueOf(d3)) > 0) {
                    d2 = d3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final float minWithOrThrow(float[] fArr, Comparator<? super Float> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            float f2 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    float f3 = fArr[i2];
                    if (comparator.compare(Float.valueOf(f2), Float.valueOf(f3)) > 0) {
                        f2 = f3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return f2;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private static final int[] onEach(int[] iArr, Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (int i2 : iArr) {
            action.invoke(Integer.valueOf(i2));
        }
        return iArr;
    }

    private static final float[] onEachIndexed(float[] fArr, Function2<? super Integer, ? super Float, Unit> action) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Float.valueOf(fArr[i2]));
            i2++;
            i3++;
        }
        return fArr;
    }

    public static final Pair<List<Double>, List<Double>> partition(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                arrayList.add(Double.valueOf(d2));
            } else {
                arrayList2.add(Double.valueOf(d2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final double random(double[] dArr, Random random) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return dArr[random.nextInt(dArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Character randomOrNull(char[] cArr, Random random) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Character.valueOf(cArr[random.nextInt(cArr.length)]);
    }

    public static final float reduce(float[] fArr, Function2<? super Float, ? super Float, Float> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            float f2 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    f2 = operation.invoke(Float.valueOf(f2), Float.valueOf(fArr[i2])).floatValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return f2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final double reduceIndexed(double[] dArr, Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double d2 = dArr[0];
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    d2 = operation.invoke(Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(dArr[i2])).doubleValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return d2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Double reduceIndexedOrNull(double[] dArr, Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                d2 = operation.invoke(Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(dArr[i2])).doubleValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final Double reduceOrNull(double[] dArr, Function2<? super Double, ? super Double, Double> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                d2 = operation.invoke(Double.valueOf(d2), Double.valueOf(dArr[i2])).doubleValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final float reduceRight(float[] fArr, Function2<? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float f2 = fArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                f2 = operation.invoke(Float.valueOf(fArr[i2]), Float.valueOf(f2)).floatValue();
            }
            return f2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceRightIndexed(float[] fArr, Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex >= 0) {
            float f2 = fArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                f2 = operation.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i2]), Float.valueOf(f2)).floatValue();
            }
            return f2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Double reduceRightIndexedOrNull(double[] dArr, Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex < 0) {
            return null;
        }
        double d2 = dArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            d2 = operation.invoke(Integer.valueOf(i2), Double.valueOf(dArr[i2]), Double.valueOf(d2)).doubleValue();
        }
        return Double.valueOf(d2);
    }

    public static final Double reduceRightOrNull(double[] dArr, Function2<? super Double, ? super Double, Double> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(dArr);
        if (lastIndex < 0) {
            return null;
        }
        double d2 = dArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            d2 = operation.invoke(Double.valueOf(dArr[i2]), Double.valueOf(d2)).doubleValue();
        }
        return Double.valueOf(d2);
    }

    private static final List<Double> runningReduce(double[] dArr, Function2<? super Double, ? super Double, Double> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        double d2 = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(d2));
        int length = dArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            d2 = operation.invoke(Double.valueOf(d2), Double.valueOf(dArr[i2])).doubleValue();
            arrayList.add(Double.valueOf(d2));
        }
        return arrayList;
    }

    private static final List<Double> runningReduceIndexed(double[] dArr, Function3<? super Integer, ? super Double, ? super Double, Double> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        double d2 = dArr[0];
        ArrayList arrayList = new ArrayList(dArr.length);
        arrayList.add(Double.valueOf(d2));
        int length = dArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            d2 = operation.invoke(Integer.valueOf(i2), Double.valueOf(d2), Double.valueOf(dArr[i2])).doubleValue();
            arrayList.add(Double.valueOf(d2));
        }
        return arrayList;
    }

    public static final void shuffle(double[] dArr, Random random) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(dArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            double d2 = dArr[lastIndex];
            dArr[lastIndex] = dArr[nextInt];
            dArr[nextInt] = d2;
        }
    }

    public static final List<Character> slice(char[] cArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(cArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final char[] sliceArray(char[] cArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return new char[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(cArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final <R extends Comparable<? super R>> List<Integer> sortedBy(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new ComparisonsKt__ComparisonsKt.a(selector));
    }

    public static final <R extends Comparable<? super R>> List<Integer> sortedByDescending(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(iArr, (Comparator<? super Integer>) new ComparisonsKt__ComparisonsKt.c(selector));
    }

    public static List<Integer> sortedWith(int[] iArr, Comparator<? super Integer> comparator) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Integer[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(iArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final Set<Integer> subtract(int[] iArr, Iterable<Integer> other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(float[] fArr, Function1<? super Float, Integer> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (float f2 : fArr) {
            i2 += selector.invoke(Float.valueOf(f2)).intValue();
        }
        return i2;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(float[] fArr, Function1<? super Float, Double> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (float f2 : fArr) {
            d2 += selector.invoke(Float.valueOf(f2)).doubleValue();
        }
        return d2;
    }

    private static final double sumOfDouble(float[] fArr, Function1<? super Float, Double> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (float f2 : fArr) {
            d2 += selector.invoke(Float.valueOf(f2)).doubleValue();
        }
        return d2;
    }

    private static final int sumOfInt(float[] fArr, Function1<? super Float, Integer> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (float f2 : fArr) {
            i2 += selector.invoke(Float.valueOf(f2)).intValue();
        }
        return i2;
    }

    private static final long sumOfLong(float[] fArr, Function1<? super Float, Long> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long j2 = 0;
        for (float f2 : fArr) {
            j2 += selector.invoke(Float.valueOf(f2)).longValue();
        }
        return j2;
    }

    private static final int sumOfUInt(float[] fArr, Function1<? super Float, UInt> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int m790constructorimpl = UInt.m790constructorimpl(0);
        for (float f2 : fArr) {
            m790constructorimpl = UInt.m790constructorimpl(m790constructorimpl + selector.invoke(Float.valueOf(f2)).m842unboximpl());
        }
        return m790constructorimpl;
    }

    private static final long sumOfULong(float[] fArr, Function1<? super Float, ULong> selector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long m850constructorimpl = ULong.m850constructorimpl(0L);
        for (float f2 : fArr) {
            m850constructorimpl = ULong.m850constructorimpl(m850constructorimpl + selector.invoke(Float.valueOf(f2)).m902unboximpl());
        }
        return m850constructorimpl;
    }

    public static final List<Double> take(double[] dArr, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (i2 >= dArr.length) {
                return toList(dArr);
            }
            if (i2 == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Double.valueOf(dArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (double d2 : dArr) {
                arrayList.add(Double.valueOf(d2));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Double> takeLast(double[] dArr, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            int length = dArr.length;
            if (i2 >= length) {
                return toList(dArr);
            }
            if (i2 == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Double.valueOf(dArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Double.valueOf(dArr[i3]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Float> takeLastWhile(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(fArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Float.valueOf(fArr[lastIndex])).booleanValue()) {
                return drop(fArr, lastIndex + 1);
            }
        }
        return toList(fArr);
    }

    public static final List<Float> takeWhile(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (float f2 : fArr) {
            if (!predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                break;
            }
            arrayList.add(Float.valueOf(f2));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Integer>> C toCollection(int[] iArr, C destination) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (int i2 : iArr) {
            destination.add(Integer.valueOf(i2));
        }
        return destination;
    }

    public static final Set<Integer> union(int[] iArr, Iterable<Integer> other) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Integer> mutableSet = toMutableSet(iArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final boolean all(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i2 : iArr) {
            if (!predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> Map<K, V> associate(int[] iArr, Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> transform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(iArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (int i2 : iArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Integer.valueOf(i2));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    public static final <K> Map<K, Double> associateBy(double[] dArr, Function1<? super Double, ? extends K> keySelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(dArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (double d2 : dArr) {
            linkedHashMap.put(keySelector.invoke(Double.valueOf(d2)), Double.valueOf(d2));
        }
        return linkedHashMap;
    }

    private static final <V> Map<Integer, V> associateWith(int[] iArr, Function1<? super Integer, ? extends V> valueSelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(iArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (int i2 : iArr) {
            linkedHashMap.put(Integer.valueOf(i2), valueSelector.invoke(Integer.valueOf(i2)));
        }
        return linkedHashMap;
    }

    public static <T> boolean contains(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (indexOf(tArr, t) >= 0) {
            return true;
        }
        return false;
    }

    public static final int count(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i2 = 0;
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                i2++;
            }
        }
        return i2;
    }

    public static final <K> List<Integer> distinctBy(int[] iArr, Function1<? super Integer, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (hashSet.add(selector.invoke(Integer.valueOf(i2)))) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    public static final List<Integer> drop(int[] iArr, int i2) {
        boolean z;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(iArr.length - i2, 0);
            return takeLast(iArr, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Integer> dropLast(int[] iArr, int i2) {
        boolean z;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(iArr.length - i2, 0);
            return take(iArr, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Integer> dropLastWhile(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(iArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Integer.valueOf(iArr[lastIndex])).booleanValue()) {
                return take(iArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Integer> dropWhile(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (int i2 : iArr) {
            if (z) {
                arrayList.add(Integer.valueOf(i2));
            } else if (!predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                arrayList.add(Integer.valueOf(i2));
                z = true;
            }
        }
        return arrayList;
    }

    private static final Long elementAtOrNull(long[] jArr, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        return getOrNull(jArr, i2);
    }

    public static final List<Integer> filter(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    public static final List<Integer> filterIndexed(int[] iArr, Function2<? super Integer, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Integer.valueOf(i4)).booleanValue()) {
                arrayList.add(Integer.valueOf(i4));
            }
            i2++;
            i3 = i5;
        }
        return arrayList;
    }

    public static final List<Integer> filterNot(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (!predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    private static final Float find(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                return Float.valueOf(f2);
            }
        }
        return null;
    }

    private static final Float findLast(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                float f2 = fArr[length];
                if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                    return Float.valueOf(f2);
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return null;
    }

    public static final double first(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                return d2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Character firstOrNull(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c2 : cArr) {
            if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                return Character.valueOf(c2);
            }
        }
        return null;
    }

    public static final <R> List<R> flatMap(int[] iArr, Function1<? super Integer, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(int[] iArr, Function2<? super Integer, ? super Integer, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final void forEach(long[] jArr, Function1<? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (long j2 : jArr) {
            action.invoke(Long.valueOf(j2));
        }
    }

    public static final void forEachIndexed(int[] iArr, Function2<? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i2]));
            i2++;
            i3++;
        }
    }

    public static Integer getOrNull(int[] iArr, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        boolean z = false;
        if (i2 >= 0 && i2 < iArr.length) {
            z = true;
        }
        if (z) {
            return Integer.valueOf(iArr[i2]);
        }
        return null;
    }

    public static final <K> Map<K, List<Double>> groupBy(double[] dArr, Function1<? super Double, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d2 : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d2));
            Object obj = linkedHashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(invoke, obj);
            }
            ((List) obj).add(Double.valueOf(d2));
        }
        return linkedHashMap;
    }

    public static final int indexOf(long[] jArr, long j2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (j2 == jArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfFirst(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (predicate.invoke(Integer.valueOf(iArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (predicate.invoke(Integer.valueOf(iArr[length])).booleanValue()) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final Set<Long> intersect(long[] jArr, Iterable<Long> other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static final double last(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                double d2 = dArr[length];
                if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                    return d2;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final int lastIndexOf(long[] jArr, long j2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (j2 == jArr[length]) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final Character lastOrNull(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i2 = length - 1;
            char c2 = cArr[length];
            if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                return Character.valueOf(c2);
            }
            if (i2 >= 0) {
                length = i2;
            } else {
                return null;
            }
        }
    }

    public static final <R> List<R> map(int[] iArr, Function1<? super Integer, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i2 : iArr) {
            arrayList.add(transform.invoke(Integer.valueOf(i2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(int[] iArr, Function2<? super Integer, ? super Integer, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(iArr.length);
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final <R extends Comparable<? super R>> Double maxByOrNull(double[] dArr, Function1<? super Double, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d2);
        }
        R invoke = selector.invoke(Double.valueOf(d2));
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                R invoke2 = selector.invoke(Double.valueOf(d3));
                if (invoke.compareTo(invoke2) < 0) {
                    d2 = d3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final <R extends Comparable<? super R>> float maxByOrThrow(float[] fArr, Function1<? super Float, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            float f2 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (lastIndex == 0) {
                return f2;
            }
            R invoke = selector.invoke(Float.valueOf(f2));
            if (1 <= lastIndex) {
                while (true) {
                    float f3 = fArr[i2];
                    R invoke2 = selector.invoke(Float.valueOf(f3));
                    if (invoke.compareTo(invoke2) < 0) {
                        f2 = f3;
                        invoke = invoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return f2;
        }
        throw new NoSuchElementException();
    }

    private static final double maxOf(float[] fArr, Function1<? super Float, Double> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double doubleValue = selector.invoke(Float.valueOf(fArr[0])).doubleValue();
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    doubleValue = Math.max(doubleValue, selector.invoke(Float.valueOf(fArr[i2])).doubleValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(float[] fArr, Function1<? super Float, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        R invoke = selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Float.valueOf(fArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    public static final Float maxWithOrNull(float[] fArr, Comparator<? super Float> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                if (comparator.compare(Float.valueOf(f2), Float.valueOf(f3)) < 0) {
                    f2 = f3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final int maxWithOrThrow(int[] iArr, Comparator<? super Integer> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    int i4 = iArr[i2];
                    if (comparator.compare(Integer.valueOf(i3), Integer.valueOf(i4)) < 0) {
                        i3 = i4;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return i3;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> Double minByOrNull(double[] dArr, Function1<? super Double, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        double d2 = dArr[0];
        int lastIndex = getLastIndex(dArr);
        if (lastIndex == 0) {
            return Double.valueOf(d2);
        }
        R invoke = selector.invoke(Double.valueOf(d2));
        if (1 <= lastIndex) {
            while (true) {
                double d3 = dArr[i2];
                R invoke2 = selector.invoke(Double.valueOf(d3));
                if (invoke.compareTo(invoke2) > 0) {
                    d2 = d3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Double.valueOf(d2);
    }

    public static final <R extends Comparable<? super R>> float minByOrThrow(float[] fArr, Function1<? super Float, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            float f2 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (lastIndex == 0) {
                return f2;
            }
            R invoke = selector.invoke(Float.valueOf(f2));
            if (1 <= lastIndex) {
                while (true) {
                    float f3 = fArr[i2];
                    R invoke2 = selector.invoke(Float.valueOf(f3));
                    if (invoke.compareTo(invoke2) > 0) {
                        f2 = f3;
                        invoke = invoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return f2;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(float[] fArr, Function1<? super Float, Double> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double doubleValue = selector.invoke(Float.valueOf(fArr[0])).doubleValue();
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    doubleValue = Math.min(doubleValue, selector.invoke(Float.valueOf(fArr[i2])).doubleValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(float[] fArr, Function1<? super Float, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        R invoke = selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Float.valueOf(fArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    public static final Float minWithOrNull(float[] fArr, Comparator<? super Float> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                if (comparator.compare(Float.valueOf(f2), Float.valueOf(f3)) > 0) {
                    f2 = f3;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final int minWithOrThrow(int[] iArr, Comparator<? super Integer> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    int i4 = iArr[i2];
                    if (comparator.compare(Integer.valueOf(i3), Integer.valueOf(i4)) > 0) {
                        i3 = i4;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return i3;
        }
        throw new NoSuchElementException();
    }

    private static final long[] onEach(long[] jArr, Function1<? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (long j2 : jArr) {
            action.invoke(Long.valueOf(j2));
        }
        return jArr;
    }

    private static final int[] onEachIndexed(int[] iArr, Function2<? super Integer, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i2]));
            i2++;
            i3++;
        }
        return iArr;
    }

    public static final Pair<List<Float>, List<Float>> partition(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                arrayList.add(Float.valueOf(f2));
            } else {
                arrayList2.add(Float.valueOf(f2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final int reduce(int[] iArr, Function2<? super Integer, ? super Integer, Integer> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    i3 = operation.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i2])).intValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return i3;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final float reduceIndexed(float[] fArr, Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            float f2 = fArr[0];
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    f2 = operation.invoke(Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(fArr[i2])).floatValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return f2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Float reduceIndexedOrNull(float[] fArr, Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                f2 = operation.invoke(Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(fArr[i2])).floatValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final Float reduceOrNull(float[] fArr, Function2<? super Float, ? super Float, Float> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                f2 = operation.invoke(Float.valueOf(f2), Float.valueOf(fArr[i2])).floatValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final int reduceRight(int[] iArr, Function2<? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int i2 = iArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                i2 = operation.invoke(Integer.valueOf(iArr[i3]), Integer.valueOf(i2)).intValue();
            }
            return i2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceRightIndexed(int[] iArr, Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex >= 0) {
            int i2 = iArr[lastIndex];
            for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
                i2 = operation.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i3]), Integer.valueOf(i2)).intValue();
            }
            return i2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Float reduceRightIndexedOrNull(float[] fArr, Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex < 0) {
            return null;
        }
        float f2 = fArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            f2 = operation.invoke(Integer.valueOf(i2), Float.valueOf(fArr[i2]), Float.valueOf(f2)).floatValue();
        }
        return Float.valueOf(f2);
    }

    public static final Float reduceRightOrNull(float[] fArr, Function2<? super Float, ? super Float, Float> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(fArr);
        if (lastIndex < 0) {
            return null;
        }
        float f2 = fArr[lastIndex];
        for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
            f2 = operation.invoke(Float.valueOf(fArr[i2]), Float.valueOf(f2)).floatValue();
        }
        return Float.valueOf(f2);
    }

    private static final List<Float> runningReduce(float[] fArr, Function2<? super Float, ? super Float, Float> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        float f2 = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(f2));
        int length = fArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            f2 = operation.invoke(Float.valueOf(f2), Float.valueOf(fArr[i2])).floatValue();
            arrayList.add(Float.valueOf(f2));
        }
        return arrayList;
    }

    private static final List<Float> runningReduceIndexed(float[] fArr, Function3<? super Integer, ? super Float, ? super Float, Float> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        float f2 = fArr[0];
        ArrayList arrayList = new ArrayList(fArr.length);
        arrayList.add(Float.valueOf(f2));
        int length = fArr.length;
        for (int i2 = 1; i2 < length; i2++) {
            f2 = operation.invoke(Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(fArr[i2])).floatValue();
            arrayList.add(Float.valueOf(f2));
        }
        return arrayList;
    }

    public static final double single(double[] dArr, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Double d2 = null;
        boolean z = false;
        for (double d3 : dArr) {
            if (predicate.invoke(Double.valueOf(d3)).booleanValue()) {
                if (!z) {
                    d2 = Double.valueOf(d3);
                    z = true;
                } else {
                    throw new IllegalArgumentException("Array contains more than one matching element.");
                }
            }
        }
        if (z) {
            Intrinsics.checkNotNull(d2, "null cannot be cast to non-null type kotlin.Double");
            return d2.doubleValue();
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    public static final Character singleOrNull(char[] cArr, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Character ch = null;
        boolean z = false;
        for (char c2 : cArr) {
            if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                if (z) {
                    return null;
                }
                ch = Character.valueOf(c2);
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        return ch;
    }

    public static final List<Double> slice(double[] dArr, Iterable<Integer> indices) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        int collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(indices, 10);
        if (collectionSizeOrDefault == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            arrayList.add(Double.valueOf(dArr[it2.next().intValue()]));
        }
        return arrayList;
    }

    public static final double[] sliceArray(double[] dArr, Collection<Integer> indices) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        double[] dArr2 = new double[indices.size()];
        Iterator<Integer> it2 = indices.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            dArr2[i2] = dArr[it2.next().intValue()];
            i2++;
        }
        return dArr2;
    }

    public static final <R extends Comparable<? super R>> List<Long> sortedBy(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new ComparisonsKt__ComparisonsKt.a(selector));
    }

    public static final <R extends Comparable<? super R>> List<Long> sortedByDescending(long[] jArr, Function1<? super Long, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(jArr, (Comparator<? super Long>) new ComparisonsKt__ComparisonsKt.c(selector));
    }

    public static final List<Long> sortedWith(long[] jArr, Comparator<? super Long> comparator) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Long[] typedArray = ArraysKt___ArraysJvmKt.toTypedArray(jArr);
        ArraysKt___ArraysJvmKt.sortWith(typedArray, comparator);
        return ArraysKt___ArraysJvmKt.asList(typedArray);
    }

    public static final Set<Long> subtract(long[] jArr, Iterable<Long> other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(int[] iArr, Function1<? super Integer, Integer> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += selector.invoke(Integer.valueOf(i3)).intValue();
        }
        return i2;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(int[] iArr, Function1<? super Integer, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (int i2 : iArr) {
            d2 += selector.invoke(Integer.valueOf(i2)).doubleValue();
        }
        return d2;
    }

    private static final double sumOfDouble(int[] iArr, Function1<? super Integer, Double> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (int i2 : iArr) {
            d2 += selector.invoke(Integer.valueOf(i2)).doubleValue();
        }
        return d2;
    }

    private static final int sumOfInt(int[] iArr, Function1<? super Integer, Integer> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += selector.invoke(Integer.valueOf(i3)).intValue();
        }
        return i2;
    }

    private static final long sumOfLong(int[] iArr, Function1<? super Integer, Long> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long j2 = 0;
        for (int i2 : iArr) {
            j2 += selector.invoke(Integer.valueOf(i2)).longValue();
        }
        return j2;
    }

    private static final int sumOfUInt(int[] iArr, Function1<? super Integer, UInt> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int m790constructorimpl = UInt.m790constructorimpl(0);
        for (int i2 : iArr) {
            m790constructorimpl = UInt.m790constructorimpl(m790constructorimpl + selector.invoke(Integer.valueOf(i2)).m842unboximpl());
        }
        return m790constructorimpl;
    }

    private static final long sumOfULong(int[] iArr, Function1<? super Integer, ULong> selector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long m850constructorimpl = ULong.m850constructorimpl(0L);
        for (int i2 : iArr) {
            m850constructorimpl = ULong.m850constructorimpl(m850constructorimpl + selector.invoke(Integer.valueOf(i2)).m902unboximpl());
        }
        return m850constructorimpl;
    }

    public static final List<Float> take(float[] fArr, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (i2 >= fArr.length) {
                return toList(fArr);
            }
            if (i2 == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(fArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (float f2 : fArr) {
                arrayList.add(Float.valueOf(f2));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Float> takeLast(float[] fArr, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            int length = fArr.length;
            if (i2 >= length) {
                return toList(fArr);
            }
            if (i2 == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(fArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Float.valueOf(fArr[i3]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Integer> takeLastWhile(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(iArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Integer.valueOf(iArr[lastIndex])).booleanValue()) {
                return drop(iArr, lastIndex + 1);
            }
        }
        return toList(iArr);
    }

    public static final List<Integer> takeWhile(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (!predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    public static final <C extends Collection<? super Long>> C toCollection(long[] jArr, C destination) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (long j2 : jArr) {
            destination.add(Long.valueOf(j2));
        }
        return destination;
    }

    public static final Set<Long> union(long[] jArr, Iterable<Long> other) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<Long> mutableSet = toMutableSet(jArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final <R> List<Pair<Byte, R>> zip(byte[] bArr, R[] other) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            byte b2 = bArr[i2];
            arrayList.add(TuplesKt.to(Byte.valueOf(b2), other[i2]));
        }
        return arrayList;
    }

    public static final boolean all(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j2 : jArr) {
            if (!predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final boolean any(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <K, V> Map<K, V> associate(long[] jArr, Function1<? super Long, ? extends Pair<? extends K, ? extends V>> transform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(jArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (long j2 : jArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Long.valueOf(j2));
            linkedHashMap.put(invoke.getFirst(), invoke.getSecond());
        }
        return linkedHashMap;
    }

    private static final <V> Map<Long, V> associateWith(long[] jArr, Function1<? super Long, ? extends V> valueSelector) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(jArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (long j2 : jArr) {
            linkedHashMap.put(Long.valueOf(j2), valueSelector.invoke(Long.valueOf(j2)));
        }
        return linkedHashMap;
    }

    public static boolean contains(short[] sArr, short s2) {
        Intrinsics.checkNotNullParameter(sArr, "<this>");
        if (indexOf(sArr, s2) >= 0) {
            return true;
        }
        return false;
    }

    public static final <K> List<Long> distinctBy(long[] jArr, Function1<? super Long, ? extends K> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (long j2 : jArr) {
            if (hashSet.add(selector.invoke(Long.valueOf(j2)))) {
                arrayList.add(Long.valueOf(j2));
            }
        }
        return arrayList;
    }

    public static final List<Long> drop(long[] jArr, int i2) {
        boolean z;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(jArr.length - i2, 0);
            return takeLast(jArr, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Long> dropLast(long[] jArr, int i2) {
        boolean z;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(jArr.length - i2, 0);
            return take(jArr, coerceAtLeast);
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Long> dropLastWhile(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(jArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Long.valueOf(jArr[lastIndex])).booleanValue()) {
                return take(jArr, lastIndex + 1);
            }
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    public static final List<Long> dropWhile(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (long j2 : jArr) {
            if (z) {
                arrayList.add(Long.valueOf(j2));
            } else if (!predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                arrayList.add(Long.valueOf(j2));
                z = true;
            }
        }
        return arrayList;
    }

    private static final <T> T elementAtOrNull(T[] tArr, int i2) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        return (T) getOrNull(tArr, i2);
    }

    public static final List<Long> filter(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j2 : jArr) {
            if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                arrayList.add(Long.valueOf(j2));
            }
        }
        return arrayList;
    }

    public static final List<Long> filterIndexed(long[] jArr, Function2<? super Integer, ? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            long j2 = jArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Long.valueOf(j2)).booleanValue()) {
                arrayList.add(Long.valueOf(j2));
            }
            i2++;
            i3 = i4;
        }
        return arrayList;
    }

    public static final List<Long> filterNot(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j2 : jArr) {
            if (!predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                arrayList.add(Long.valueOf(j2));
            }
        }
        return arrayList;
    }

    private static final Integer find(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i2 : iArr) {
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                return Integer.valueOf(i2);
            }
        }
        return null;
    }

    private static final Integer findLast(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                int i3 = iArr[length];
                if (predicate.invoke(Integer.valueOf(i3)).booleanValue()) {
                    return Integer.valueOf(i3);
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return null;
    }

    public static final <R> List<R> flatMap(long[] jArr, Function1<? super Long, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (long j2 : jArr) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Long.valueOf(j2)));
        }
        return arrayList;
    }

    private static final <R> List<R> flatMapIndexedIterable(long[] jArr, Function2<? super Integer, ? super Long, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, transform.invoke(Integer.valueOf(i3), Long.valueOf(jArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final <T> void forEach(T[] tArr, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (T t : tArr) {
            action.invoke(t);
        }
    }

    public static final void forEachIndexed(long[] jArr, Function2<? super Integer, ? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Long.valueOf(jArr[i2]));
            i2++;
            i3++;
        }
    }

    public static final Long getOrNull(long[] jArr, int i2) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        boolean z = false;
        if (i2 >= 0 && i2 < jArr.length) {
            z = true;
        }
        if (z) {
            return Long.valueOf(jArr[i2]);
        }
        return null;
    }

    public static <T> int indexOf(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        int i2 = 0;
        if (t == null) {
            int length = tArr.length;
            while (i2 < length) {
                if (tArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i2 < length2) {
            if (Intrinsics.areEqual(t, tArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final int indexOfFirst(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (predicate.invoke(Long.valueOf(jArr[i2])).booleanValue()) {
                return i2;
            }
        }
        return -1;
    }

    public static final int indexOfLast(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i2 = length - 1;
                if (predicate.invoke(Long.valueOf(jArr[length])).booleanValue()) {
                    return length;
                }
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        }
        return -1;
    }

    public static final <T> Set<T> intersect(T[] tArr, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        CollectionsKt__MutableCollectionsKt.retainAll(mutableSet, other);
        return mutableSet;
    }

    public static <T> int lastIndexOf(T[] tArr, T t) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        if (t == null) {
            int length = tArr.length - 1;
            if (length >= 0) {
                while (true) {
                    int i2 = length - 1;
                    if (tArr[length] == null) {
                        return length;
                    }
                    if (i2 < 0) {
                        break;
                    }
                    length = i2;
                }
            }
        } else {
            int length2 = tArr.length - 1;
            if (length2 >= 0) {
                while (true) {
                    int i3 = length2 - 1;
                    if (Intrinsics.areEqual(t, tArr[length2])) {
                        return length2;
                    }
                    if (i3 < 0) {
                        break;
                    }
                    length2 = i3;
                }
            }
        }
        return -1;
    }

    public static final <R> List<R> map(long[] jArr, Function1<? super Long, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j2 : jArr) {
            arrayList.add(transform.invoke(Long.valueOf(j2)));
        }
        return arrayList;
    }

    public static final <R> List<R> mapIndexed(long[] jArr, Function2<? super Integer, ? super Long, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(jArr.length);
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            arrayList.add(transform.invoke(Integer.valueOf(i3), Long.valueOf(jArr[i2])));
            i2++;
            i3++;
        }
        return arrayList;
    }

    public static final <R extends Comparable<? super R>> Float maxByOrNull(float[] fArr, Function1<? super Float, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f2);
        }
        R invoke = selector.invoke(Float.valueOf(f2));
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                R invoke2 = selector.invoke(Float.valueOf(f3));
                if (invoke.compareTo(invoke2) < 0) {
                    f2 = f3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final <R extends Comparable<? super R>> int maxByOrThrow(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (lastIndex == 0) {
                return i3;
            }
            R invoke = selector.invoke(Integer.valueOf(i3));
            if (1 <= lastIndex) {
                while (true) {
                    int i4 = iArr[i2];
                    R invoke2 = selector.invoke(Integer.valueOf(i4));
                    if (invoke.compareTo(invoke2) < 0) {
                        i3 = i4;
                        invoke = invoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return i3;
        }
        throw new NoSuchElementException();
    }

    private static final double maxOf(int[] iArr, Function1<? super Integer, Double> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double doubleValue = selector.invoke(Integer.valueOf(iArr[0])).doubleValue();
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    doubleValue = Math.max(doubleValue, selector.invoke(Integer.valueOf(iArr[i2])).doubleValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R maxOfOrNull(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        R invoke = selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Integer.valueOf(iArr[i2]));
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    public static final Integer maxWithOrNull(int[] iArr, Comparator<? super Integer> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (comparator.compare(Integer.valueOf(i3), Integer.valueOf(i4)) < 0) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final long maxWithOrThrow(long[] jArr, Comparator<? super Long> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            long j2 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (1 <= lastIndex) {
                while (true) {
                    long j3 = jArr[i2];
                    if (comparator.compare(Long.valueOf(j2), Long.valueOf(j3)) < 0) {
                        j2 = j3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return j2;
        }
        throw new NoSuchElementException();
    }

    public static final <R extends Comparable<? super R>> Float minByOrNull(float[] fArr, Function1<? super Float, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        float f2 = fArr[0];
        int lastIndex = getLastIndex(fArr);
        if (lastIndex == 0) {
            return Float.valueOf(f2);
        }
        R invoke = selector.invoke(Float.valueOf(f2));
        if (1 <= lastIndex) {
            while (true) {
                float f3 = fArr[i2];
                R invoke2 = selector.invoke(Float.valueOf(f3));
                if (invoke.compareTo(invoke2) > 0) {
                    f2 = f3;
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Float.valueOf(f2);
    }

    public static final <R extends Comparable<? super R>> int minByOrThrow(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (lastIndex == 0) {
                return i3;
            }
            R invoke = selector.invoke(Integer.valueOf(i3));
            if (1 <= lastIndex) {
                while (true) {
                    int i4 = iArr[i2];
                    R invoke2 = selector.invoke(Integer.valueOf(i4));
                    if (invoke.compareTo(invoke2) > 0) {
                        i3 = i4;
                        invoke = invoke2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return i3;
        }
        throw new NoSuchElementException();
    }

    private static final double minOf(int[] iArr, Function1<? super Integer, Double> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            double doubleValue = selector.invoke(Integer.valueOf(iArr[0])).doubleValue();
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    doubleValue = Math.min(doubleValue, selector.invoke(Integer.valueOf(iArr[i2])).doubleValue());
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    private static final <R extends Comparable<? super R>> R minOfOrNull(int[] iArr, Function1<? super Integer, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        R invoke = selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                R invoke2 = selector.invoke(Integer.valueOf(iArr[i2]));
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return invoke;
    }

    public static final Integer minWithOrNull(int[] iArr, Comparator<? super Integer> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                int i4 = iArr[i2];
                if (comparator.compare(Integer.valueOf(i3), Integer.valueOf(i4)) > 0) {
                    i3 = i4;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final long minWithOrThrow(long[] jArr, Comparator<? super Long> comparator) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int i2 = 1;
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            long j2 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (1 <= lastIndex) {
                while (true) {
                    long j3 = jArr[i2];
                    if (comparator.compare(Long.valueOf(j2), Long.valueOf(j3)) > 0) {
                        j2 = j3;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return j2;
        }
        throw new NoSuchElementException();
    }

    public static final boolean none(float[] fArr, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    private static final <T> T[] onEach(T[] tArr, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        for (T t : tArr) {
            action.invoke(t);
        }
        return tArr;
    }

    private static final long[] onEachIndexed(long[] jArr, Function2<? super Integer, ? super Long, Unit> action) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            action.invoke(Integer.valueOf(i3), Long.valueOf(jArr[i2]));
            i2++;
            i3++;
        }
        return jArr;
    }

    public static final Pair<List<Integer>, List<Integer>> partition(int[] iArr, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 : iArr) {
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                arrayList.add(Integer.valueOf(i2));
            } else {
                arrayList2.add(Integer.valueOf(i2));
            }
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public static final float random(float[] fArr, Random random) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return fArr[random.nextInt(fArr.length)];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static final Double randomOrNull(double[] dArr, Random random) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        return Double.valueOf(dArr[random.nextInt(dArr.length)]);
    }

    public static final long reduce(long[] jArr, Function2<? super Long, ? super Long, Long> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            long j2 = jArr[0];
            int lastIndex = getLastIndex(jArr);
            if (1 <= lastIndex) {
                while (true) {
                    j2 = operation.invoke(Long.valueOf(j2), Long.valueOf(jArr[i2])).longValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return j2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final int reduceIndexed(int[] iArr, Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            int i3 = iArr[0];
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    i3 = operation.invoke(Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(iArr[i2])).intValue();
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return i3;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Integer reduceIndexedOrNull(int[] iArr, Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                i3 = operation.invoke(Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(iArr[i2])).intValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final Integer reduceOrNull(int[] iArr, Function2<? super Integer, ? super Integer, Integer> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        int i3 = iArr[0];
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                i3 = operation.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i2])).intValue();
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return Integer.valueOf(i3);
    }

    public static final long reduceRight(long[] jArr, Function2<? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long j2 = jArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                j2 = operation.invoke(Long.valueOf(jArr[i2]), Long.valueOf(j2)).longValue();
            }
            return j2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final long reduceRightIndexed(long[] jArr, Function3<? super Integer, ? super Long, ? super Long, Long> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(jArr);
        if (lastIndex >= 0) {
            long j2 = jArr[lastIndex];
            for (int i2 = lastIndex - 1; i2 >= 0; i2--) {
                j2 = operation.invoke(Integer.valueOf(i2), Long.valueOf(jArr[i2]), Long.valueOf(j2)).longValue();
            }
            return j2;
        }
        throw new UnsupportedOperationException("Empty array can't be reduced.");
    }

    public static final Integer reduceRightIndexedOrNull(int[] iArr, Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int i2 = iArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            i2 = operation.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i3]), Integer.valueOf(i2)).intValue();
        }
        return Integer.valueOf(i2);
    }

    public static final Integer reduceRightOrNull(int[] iArr, Function2<? super Integer, ? super Integer, Integer> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int lastIndex = getLastIndex(iArr);
        if (lastIndex < 0) {
            return null;
        }
        int i2 = iArr[lastIndex];
        for (int i3 = lastIndex - 1; i3 >= 0; i3--) {
            i2 = operation.invoke(Integer.valueOf(iArr[i3]), Integer.valueOf(i2)).intValue();
        }
        return Integer.valueOf(i2);
    }

    private static final List<Integer> runningReduce(int[] iArr, Function2<? super Integer, ? super Integer, Integer> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int i2 = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(i2));
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            i2 = operation.invoke(Integer.valueOf(i2), Integer.valueOf(iArr[i3])).intValue();
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    private static final List<Integer> runningReduceIndexed(int[] iArr, Function3<? super Integer, ? super Integer, ? super Integer, Integer> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        int i2 = iArr[0];
        ArrayList arrayList = new ArrayList(iArr.length);
        arrayList.add(Integer.valueOf(i2));
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            i2 = operation.invoke(Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(iArr[i3])).intValue();
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    public static final void shuffle(float[] fArr, Random random) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        for (int lastIndex = getLastIndex(fArr); lastIndex > 0; lastIndex--) {
            int nextInt = random.nextInt(lastIndex + 1);
            float f2 = fArr[lastIndex];
            fArr[lastIndex] = fArr[nextInt];
            fArr[nextInt] = f2;
        }
    }

    public static final List<Double> slice(double[] dArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ArraysKt___ArraysJvmKt.asList(ArraysKt___ArraysJvmKt.copyOfRange(dArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1));
    }

    public static final double[] sliceArray(double[] dArr, IntRange indices) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(indices, "indices");
        if (indices.isEmpty()) {
            return new double[0];
        }
        return ArraysKt___ArraysJvmKt.copyOfRange(dArr, indices.getStart().intValue(), indices.getEndInclusive().intValue() + 1);
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedBy(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(tArr, new ComparisonsKt__ComparisonsKt.a(selector));
    }

    public static final <T, R extends Comparable<? super R>> List<T> sortedByDescending(T[] tArr, Function1<? super T, ? extends R> selector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        return sortedWith(tArr, new ComparisonsKt__ComparisonsKt.c(selector));
    }

    public static <T> List<T> sortedWith(T[] tArr, Comparator<? super T> comparator) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return ArraysKt___ArraysJvmKt.asList(sortedArrayWith(tArr, comparator));
    }

    public static final <T> Set<T> subtract(T[] tArr, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        CollectionsKt__MutableCollectionsKt.removeAll(mutableSet, other);
        return mutableSet;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final int sumBy(long[] jArr, Function1<? super Long, Integer> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (long j2 : jArr) {
            i2 += selector.invoke(Long.valueOf(j2)).intValue();
        }
        return i2;
    }

    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final double sumByDouble(long[] jArr, Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (long j2 : jArr) {
            d2 += selector.invoke(Long.valueOf(j2)).doubleValue();
        }
        return d2;
    }

    private static final double sumOfDouble(long[] jArr, Function1<? super Long, Double> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        double d2 = 0.0d;
        for (long j2 : jArr) {
            d2 += selector.invoke(Long.valueOf(j2)).doubleValue();
        }
        return d2;
    }

    private static final int sumOfInt(long[] jArr, Function1<? super Long, Integer> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 0;
        for (long j2 : jArr) {
            i2 += selector.invoke(Long.valueOf(j2)).intValue();
        }
        return i2;
    }

    private static final long sumOfLong(long[] jArr, Function1<? super Long, Long> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long j2 = 0;
        for (long j3 : jArr) {
            j2 += selector.invoke(Long.valueOf(j3)).longValue();
        }
        return j2;
    }

    private static final int sumOfUInt(long[] jArr, Function1<? super Long, UInt> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int m790constructorimpl = UInt.m790constructorimpl(0);
        for (long j2 : jArr) {
            m790constructorimpl = UInt.m790constructorimpl(m790constructorimpl + selector.invoke(Long.valueOf(j2)).m842unboximpl());
        }
        return m790constructorimpl;
    }

    private static final long sumOfULong(long[] jArr, Function1<? super Long, ULong> selector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(selector, "selector");
        long m850constructorimpl = ULong.m850constructorimpl(0L);
        for (long j2 : jArr) {
            m850constructorimpl = ULong.m850constructorimpl(m850constructorimpl + selector.invoke(Long.valueOf(j2)).m902unboximpl());
        }
        return m850constructorimpl;
    }

    public static final List<Integer> take(int[] iArr, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (i2 >= iArr.length) {
                return toList(iArr);
            }
            if (i2 == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(iArr[0]));
            }
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            for (int i4 : iArr) {
                arrayList.add(Integer.valueOf(i4));
                i3++;
                if (i3 == i2) {
                    break;
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Integer> takeLast(int[] iArr, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i2 == 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            int length = iArr.length;
            if (i2 >= length) {
                return toList(iArr);
            }
            if (i2 == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(iArr[length - 1]));
            }
            ArrayList arrayList = new ArrayList(i2);
            for (int i3 = length - i2; i3 < length; i3++) {
                arrayList.add(Integer.valueOf(iArr[i3]));
            }
            return arrayList;
        }
        throw new IllegalArgumentException(("Requested element count " + i2 + " is less than zero.").toString());
    }

    public static final List<Long> takeLastWhile(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int lastIndex = getLastIndex(jArr); -1 < lastIndex; lastIndex--) {
            if (!predicate.invoke(Long.valueOf(jArr[lastIndex])).booleanValue()) {
                return drop(jArr, lastIndex + 1);
            }
        }
        return toList(jArr);
    }

    public static final List<Long> takeWhile(long[] jArr, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList();
        for (long j2 : jArr) {
            if (!predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                break;
            }
            arrayList.add(Long.valueOf(j2));
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C toCollection(T[] tArr, C destination) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (T t : tArr) {
            destination.add(t);
        }
        return destination;
    }

    public static final <T> Set<T> union(T[] tArr, Iterable<? extends T> other) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Set<T> mutableSet = toMutableSet(tArr);
        CollectionsKt__MutableCollectionsKt.addAll(mutableSet, other);
        return mutableSet;
    }

    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(T[] tArr, M destination, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (T t : tArr) {
            destination.put(keySelector.invoke(t), t);
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(K[] kArr, M destination, Function1<? super K, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(kArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (K k2 : kArr) {
            destination.put(k2, valueSelector.invoke(k2));
        }
        return destination;
    }

    private static final <T> T elementAtOrElse(T[] tArr, int i2, Function1<? super Integer, ? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < tArr.length) {
            z = true;
        }
        if (z) {
            return tArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2));
    }

    public static final <R> R fold(byte[] bArr, R r2, Function2<? super R, ? super Byte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (byte b2 : bArr) {
            r2 = operation.invoke(r2, Byte.valueOf(b2));
        }
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R foldIndexed(T[] tArr, R r2, Function3<? super Integer, ? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            r2 = operation.invoke(Integer.valueOf(i3), r2, tArr[i2]);
            i2++;
            i3++;
        }
        return r2;
    }

    public static final <R> R foldRight(byte[] bArr, R r2, Function2<? super Byte, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Byte.valueOf(bArr[lastIndex]), r2);
        }
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R foldRightIndexed(T[] tArr, R r2, Function3<? super Integer, ? super T, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Integer.valueOf(lastIndex), tArr[lastIndex], r2);
        }
        return r2;
    }

    private static final <T> T getOrElse(T[] tArr, int i2, Function1<? super Integer, ? extends T> defaultValue) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < tArr.length) {
            z = true;
        }
        if (z) {
            return tArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2));
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(T[] tArr, C destination, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t : tArr) {
            destination.add(transform.invoke(t));
        }
        return destination;
    }

    public static final void sortDescending(byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(bArr, i2, i3);
        reverse(bArr, i2, i3);
    }

    public static final <K, M extends Map<? super K, ? super Byte>> M associateByTo(byte[] bArr, M destination, Function1<? super Byte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (byte b2 : bArr) {
            destination.put(keySelector.invoke(Byte.valueOf(b2)), Byte.valueOf(b2));
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(byte[] bArr, M destination, Function1<? super Byte, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (byte b2 : bArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Byte.valueOf(b2));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    private static final <V, M extends Map<? super Byte, ? super V>> M associateWithTo(byte[] bArr, M destination, Function1<? super Byte, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (byte b2 : bArr) {
            destination.put(Byte.valueOf(b2), valueSelector.invoke(Byte.valueOf(b2)));
        }
        return destination;
    }

    private static final byte elementAtOrElse(byte[] bArr, int i2, Function1<? super Integer, Byte> defaultValue) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < bArr.length) {
            z = true;
        }
        if (z) {
            return bArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2)).byteValue();
    }

    public static final <C extends Collection<? super Byte>> C filterIndexedTo(byte[] bArr, C destination, Function2<? super Integer, ? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = bArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Byte.valueOf(b2)).booleanValue()) {
                destination.add(Byte.valueOf(b2));
            }
            i2++;
            i3 = i4;
        }
        return destination;
    }

    public static final <C extends Collection<? super Byte>> C filterNotTo(byte[] bArr, C destination, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b2 : bArr) {
            if (!predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                destination.add(Byte.valueOf(b2));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Byte>> C filterTo(byte[] bArr, C destination, Function1<? super Byte, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (byte b2 : bArr) {
            if (predicate.invoke(Byte.valueOf(b2)).booleanValue()) {
                destination.add(Byte.valueOf(b2));
            }
        }
        return destination;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(byte[] bArr, C destination, Function2<? super Integer, ? super Byte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i3), Byte.valueOf(bArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedSequenceTo(T[] tArr, C destination, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i3), tArr[i2]));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapSequenceTo(T[] tArr, C destination, Function1<? super T, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t : tArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(t));
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(byte[] bArr, C destination, Function1<? super Byte, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (byte b2 : bArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Byte.valueOf(b2)));
        }
        return destination;
    }

    public static final <R> R fold(char[] cArr, R r2, Function2<? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (char c2 : cArr) {
            r2 = operation.invoke(r2, Character.valueOf(c2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(byte[] bArr, R r2, Function3<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            R r3 = r2;
            r2 = operation.invoke(Integer.valueOf(i3), r3, Byte.valueOf(bArr[i2]));
            i2++;
            i3++;
        }
        return r2;
    }

    public static final <R> R foldRight(char[] cArr, R r2, Function2<? super Character, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Character.valueOf(cArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(byte[] bArr, R r2, Function3<? super Integer, ? super Byte, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(bArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Integer.valueOf(lastIndex), Byte.valueOf(bArr[lastIndex]), r2);
        }
        return r2;
    }

    private static final byte getOrElse(byte[] bArr, int i2, Function1<? super Integer, Byte> defaultValue) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < bArr.length) {
            z = true;
        }
        if (z) {
            return bArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2)).byteValue();
    }

    public static final <K, M extends Map<? super K, List<Byte>>> M groupByTo(byte[] bArr, M destination, Function1<? super Byte, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (byte b2 : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Byte.valueOf(b2));
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(T[] tArr, C destination, Function2<? super Integer, ? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = tArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = i3 + 1;
            R invoke = transform.invoke(Integer.valueOf(i3), tArr[i2]);
            if (invoke != null) {
                destination.add(invoke);
            }
            i2++;
            i3 = i4;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(byte[] bArr, C destination, Function2<? super Integer, ? super Byte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            destination.add(transform.invoke(Integer.valueOf(i3), Byte.valueOf(bArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(T[] tArr, C destination, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (T t : tArr) {
            R invoke = transform.invoke(t);
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(byte[] bArr, C destination, Function1<? super Byte, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (byte b2 : bArr) {
            destination.add(transform.invoke(Byte.valueOf(b2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    private static final <T, R> R maxOfWith(T[] tArr, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Object obj = (R) selector.invoke(tArr[0]);
            int lastIndex = getLastIndex(tArr);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = (R) selector.invoke(tArr[i2]);
                    if (comparator.compare(obj, obj2) < 0) {
                        obj = (R) obj2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    private static final <T, R> R maxOfWithOrNull(T[] tArr, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Object obj = (R) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(tArr[i2]);
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    private static final <T, R> R minOfWith(T[] tArr, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Object obj = (R) selector.invoke(tArr[0]);
            int lastIndex = getLastIndex(tArr);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = (R) selector.invoke(tArr[i2]);
                    if (comparator.compare(obj, obj2) > 0) {
                        obj = (R) obj2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    private static final <T, R> R minOfWithOrNull(T[] tArr, Comparator<? super R> comparator, Function1<? super T, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Object obj = (R) selector.invoke(tArr[0]);
        int lastIndex = getLastIndex(tArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(tArr[i2]);
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    private static final <R> List<R> runningFold(byte[] bArr, R r2, Function2<? super R, ? super Byte, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r2);
        for (byte b2 : bArr) {
            r2 = operation.invoke(r2, Byte.valueOf(b2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(byte[] bArr, R r2, Function3<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r2);
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Byte.valueOf(bArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scan(byte[] bArr, R r2, Function2<? super R, ? super Byte, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r2);
        for (byte b2 : bArr) {
            r2 = operation.invoke(r2, Byte.valueOf(b2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(byte[] bArr, R r2, Function3<? super Integer, ? super R, ? super Byte, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(bArr.length + 1);
        arrayList.add(r2);
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Byte.valueOf(bArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(byte[] bArr, Function1<? super Byte, ? extends K> keySelector, Function1<? super Byte, ? extends V> valueTransform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(bArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (byte b2 : bArr) {
            linkedHashMap.put(keySelector.invoke(Byte.valueOf(b2)), valueTransform.invoke(Byte.valueOf(b2)));
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(char[] cArr, M destination, Function1<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (char c2 : cArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Character.valueOf(c2));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    private static final <V, M extends Map<? super Character, ? super V>> M associateWithTo(char[] cArr, M destination, Function1<? super Character, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (char c2 : cArr) {
            destination.put(Character.valueOf(c2), valueSelector.invoke(Character.valueOf(c2)));
        }
        return destination;
    }

    private static final char elementAtOrElse(char[] cArr, int i2, Function1<? super Integer, Character> defaultValue) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < cArr.length) {
            z = true;
        }
        if (z) {
            return cArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2)).charValue();
    }

    public static final <C extends Collection<? super Character>> C filterIndexedTo(char[] cArr, C destination, Function2<? super Integer, ? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            char c2 = cArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Character.valueOf(c2)).booleanValue()) {
                destination.add(Character.valueOf(c2));
            }
            i2++;
            i3 = i4;
        }
        return destination;
    }

    public static final <C extends Collection<? super Character>> C filterNotTo(char[] cArr, C destination, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c2 : cArr) {
            if (!predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                destination.add(Character.valueOf(c2));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Character>> C filterTo(char[] cArr, C destination, Function1<? super Character, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (char c2 : cArr) {
            if (predicate.invoke(Character.valueOf(c2)).booleanValue()) {
                destination.add(Character.valueOf(c2));
            }
        }
        return destination;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(char[] cArr, C destination, Function2<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i3), Character.valueOf(cArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(char[] cArr, C destination, Function1<? super Character, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (char c2 : cArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Character.valueOf(c2)));
        }
        return destination;
    }

    public static final <R> R fold(double[] dArr, R r2, Function2<? super R, ? super Double, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (double d2 : dArr) {
            r2 = operation.invoke(r2, Double.valueOf(d2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(char[] cArr, R r2, Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            R r3 = r2;
            r2 = operation.invoke(Integer.valueOf(i3), r3, Character.valueOf(cArr[i2]));
            i2++;
            i3++;
        }
        return r2;
    }

    public static final <R> R foldRight(double[] dArr, R r2, Function2<? super Double, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Double.valueOf(dArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(char[] cArr, R r2, Function3<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(cArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Integer.valueOf(lastIndex), Character.valueOf(cArr[lastIndex]), r2);
        }
        return r2;
    }

    private static final char getOrElse(char[] cArr, int i2, Function1<? super Integer, Character> defaultValue) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < cArr.length) {
            z = true;
        }
        if (z) {
            return cArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2)).charValue();
    }

    public static final <K, V> Map<K, List<V>> groupBy(byte[] bArr, Function1<? super Byte, ? extends K> keySelector, Function1<? super Byte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (byte b2 : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b2));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Byte.valueOf(b2)));
        }
        return linkedHashMap;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(char[] cArr, C destination, Function2<? super Integer, ? super Character, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = cArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            destination.add(transform.invoke(Integer.valueOf(i3), Character.valueOf(cArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(char[] cArr, C destination, Function1<? super Character, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (char c2 : cArr) {
            destination.add(transform.invoke(Character.valueOf(c2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWith(byte[] bArr, Comparator<? super R> comparator, Function1<? super Byte, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Object obj = (R) selector.invoke(Byte.valueOf(bArr[0]));
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = (R) selector.invoke(Byte.valueOf(bArr[i2]));
                    if (comparator.compare(obj, obj2) < 0) {
                        obj = (R) obj2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWithOrNull(byte[] bArr, Comparator<? super R> comparator, Function1<? super Byte, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Object obj = (R) selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Byte.valueOf(bArr[i2]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWith(byte[] bArr, Comparator<? super R> comparator, Function1<? super Byte, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Object obj = (R) selector.invoke(Byte.valueOf(bArr[0]));
            int lastIndex = getLastIndex(bArr);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = (R) selector.invoke(Byte.valueOf(bArr[i2]));
                    if (comparator.compare(obj, obj2) > 0) {
                        obj = (R) obj2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWithOrNull(byte[] bArr, Comparator<? super R> comparator, Function1<? super Byte, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (bArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Object obj = (R) selector.invoke(Byte.valueOf(bArr[0]));
        int lastIndex = getLastIndex(bArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Byte.valueOf(bArr[i2]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    public static final void reverse(byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        AbstractList.Companion.d(i2, i3, bArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[i5];
            bArr[i5] = b2;
            i5--;
            i2++;
        }
    }

    private static final <R> List<R> runningFold(char[] cArr, R r2, Function2<? super R, ? super Character, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r2);
        for (char c2 : cArr) {
            r2 = operation.invoke(r2, Character.valueOf(c2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(char[] cArr, R r2, Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r2);
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Character.valueOf(cArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scan(char[] cArr, R r2, Function2<? super R, ? super Character, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r2);
        for (char c2 : cArr) {
            r2 = operation.invoke(r2, Character.valueOf(c2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(char[] cArr, R r2, Function3<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(cArr.length + 1);
        arrayList.add(r2);
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Character.valueOf(cArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final void sortDescending(char[] cArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(cArr, i2, i3);
        reverse(cArr, i2, i3);
    }

    public static final <R, V> List<V> zip(byte[] bArr, Iterable<? extends R> other, Function2<? super Byte, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = bArr.length;
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(other, 10), length));
        int i2 = 0;
        for (R r2 : other) {
            if (i2 >= length) {
                break;
            }
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i2]), r2));
            i2++;
        }
        return arrayList;
    }

    public static final <K, M extends Map<? super K, ? super Character>> M associateByTo(char[] cArr, M destination, Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (char c2 : cArr) {
            destination.put(keySelector.invoke(Character.valueOf(c2)), Character.valueOf(c2));
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(double[] dArr, M destination, Function1<? super Double, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (double d2 : dArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Double.valueOf(d2));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    private static final <V, M extends Map<? super Double, ? super V>> M associateWithTo(double[] dArr, M destination, Function1<? super Double, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (double d2 : dArr) {
            destination.put(Double.valueOf(d2), valueSelector.invoke(Double.valueOf(d2)));
        }
        return destination;
    }

    private static final double elementAtOrElse(double[] dArr, int i2, Function1<? super Integer, Double> defaultValue) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < dArr.length) {
            z = true;
        }
        if (z) {
            return dArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2)).doubleValue();
    }

    public static final <C extends Collection<? super Double>> C filterIndexedTo(double[] dArr, C destination, Function2<? super Integer, ? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            double d2 = dArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Double.valueOf(d2)).booleanValue()) {
                destination.add(Double.valueOf(d2));
            }
            i2++;
            i3 = i4;
        }
        return destination;
    }

    public static final <C extends Collection<? super Double>> C filterNotTo(double[] dArr, C destination, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d2 : dArr) {
            if (!predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                destination.add(Double.valueOf(d2));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Double>> C filterTo(double[] dArr, C destination, Function1<? super Double, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (double d2 : dArr) {
            if (predicate.invoke(Double.valueOf(d2)).booleanValue()) {
                destination.add(Double.valueOf(d2));
            }
        }
        return destination;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(double[] dArr, C destination, Function2<? super Integer, ? super Double, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i3), Double.valueOf(dArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(double[] dArr, C destination, Function1<? super Double, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (double d2 : dArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Double.valueOf(d2)));
        }
        return destination;
    }

    public static final <R> R fold(float[] fArr, R r2, Function2<? super R, ? super Float, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (float f2 : fArr) {
            r2 = operation.invoke(r2, Float.valueOf(f2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(double[] dArr, R r2, Function3<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            R r3 = r2;
            r2 = operation.invoke(Integer.valueOf(i3), r3, Double.valueOf(dArr[i2]));
            i2++;
            i3++;
        }
        return r2;
    }

    public static final <R> R foldRight(float[] fArr, R r2, Function2<? super Float, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Float.valueOf(fArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(double[] dArr, R r2, Function3<? super Integer, ? super Double, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(dArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Integer.valueOf(lastIndex), Double.valueOf(dArr[lastIndex]), r2);
        }
        return r2;
    }

    private static final double getOrElse(double[] dArr, int i2, Function1<? super Integer, Double> defaultValue) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < dArr.length) {
            z = true;
        }
        if (z) {
            return dArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2)).doubleValue();
    }

    public static final <K, M extends Map<? super K, List<Character>>> M groupByTo(char[] cArr, M destination, Function1<? super Character, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (char c2 : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Character.valueOf(c2));
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(double[] dArr, C destination, Function2<? super Integer, ? super Double, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = dArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            destination.add(transform.invoke(Integer.valueOf(i3), Double.valueOf(dArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(double[] dArr, C destination, Function1<? super Double, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (double d2 : dArr) {
            destination.add(transform.invoke(Double.valueOf(d2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWith(char[] cArr, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Object obj = (R) selector.invoke(Character.valueOf(cArr[0]));
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = (R) selector.invoke(Character.valueOf(cArr[i2]));
                    if (comparator.compare(obj, obj2) < 0) {
                        obj = (R) obj2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWithOrNull(char[] cArr, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Object obj = (R) selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Character.valueOf(cArr[i2]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWith(char[] cArr, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Object obj = (R) selector.invoke(Character.valueOf(cArr[0]));
            int lastIndex = getLastIndex(cArr);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = (R) selector.invoke(Character.valueOf(cArr[i2]));
                    if (comparator.compare(obj, obj2) > 0) {
                        obj = (R) obj2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWithOrNull(char[] cArr, Comparator<? super R> comparator, Function1<? super Character, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (cArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Object obj = (R) selector.invoke(Character.valueOf(cArr[0]));
        int lastIndex = getLastIndex(cArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Character.valueOf(cArr[i2]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    private static final <R> List<R> runningFold(double[] dArr, R r2, Function2<? super R, ? super Double, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r2);
        for (double d2 : dArr) {
            r2 = operation.invoke(r2, Double.valueOf(d2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(double[] dArr, R r2, Function3<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r2);
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Double.valueOf(dArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scan(double[] dArr, R r2, Function2<? super R, ? super Double, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r2);
        for (double d2 : dArr) {
            r2 = operation.invoke(r2, Double.valueOf(d2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(double[] dArr, R r2, Function3<? super Integer, ? super R, ? super Double, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(dArr.length + 1);
        arrayList.add(r2);
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Double.valueOf(dArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(char[] cArr, Function1<? super Character, ? extends K> keySelector, Function1<? super Character, ? extends V> valueTransform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(cArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (char c2 : cArr) {
            linkedHashMap.put(keySelector.invoke(Character.valueOf(c2)), valueTransform.invoke(Character.valueOf(c2)));
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(float[] fArr, M destination, Function1<? super Float, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (float f2 : fArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Float.valueOf(f2));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    private static final <V, M extends Map<? super Float, ? super V>> M associateWithTo(float[] fArr, M destination, Function1<? super Float, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (float f2 : fArr) {
            destination.put(Float.valueOf(f2), valueSelector.invoke(Float.valueOf(f2)));
        }
        return destination;
    }

    private static final float elementAtOrElse(float[] fArr, int i2, Function1<? super Integer, Float> defaultValue) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < fArr.length) {
            z = true;
        }
        if (z) {
            return fArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2)).floatValue();
    }

    public static final <C extends Collection<? super Float>> C filterIndexedTo(float[] fArr, C destination, Function2<? super Integer, ? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            float f2 = fArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Float.valueOf(f2)).booleanValue()) {
                destination.add(Float.valueOf(f2));
            }
            i2++;
            i3 = i4;
        }
        return destination;
    }

    public static final <C extends Collection<? super Float>> C filterNotTo(float[] fArr, C destination, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f2 : fArr) {
            if (!predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                destination.add(Float.valueOf(f2));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Float>> C filterTo(float[] fArr, C destination, Function1<? super Float, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (float f2 : fArr) {
            if (predicate.invoke(Float.valueOf(f2)).booleanValue()) {
                destination.add(Float.valueOf(f2));
            }
        }
        return destination;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(float[] fArr, C destination, Function2<? super Integer, ? super Float, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i3), Float.valueOf(fArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(float[] fArr, C destination, Function1<? super Float, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (float f2 : fArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Float.valueOf(f2)));
        }
        return destination;
    }

    public static final <R> R fold(int[] iArr, R r2, Function2<? super R, ? super Integer, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int i2 : iArr) {
            r2 = operation.invoke(r2, Integer.valueOf(i2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(float[] fArr, R r2, Function3<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            R r3 = r2;
            r2 = operation.invoke(Integer.valueOf(i3), r3, Float.valueOf(fArr[i2]));
            i2++;
            i3++;
        }
        return r2;
    }

    public static final <R> R foldRight(int[] iArr, R r2, Function2<? super Integer, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Integer.valueOf(iArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(float[] fArr, R r2, Function3<? super Integer, ? super Float, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(fArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Integer.valueOf(lastIndex), Float.valueOf(fArr[lastIndex]), r2);
        }
        return r2;
    }

    private static final float getOrElse(float[] fArr, int i2, Function1<? super Integer, Float> defaultValue) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < fArr.length) {
            z = true;
        }
        if (z) {
            return fArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2)).floatValue();
    }

    public static final <K, V> Map<K, List<V>> groupBy(char[] cArr, Function1<? super Character, ? extends K> keySelector, Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (char c2 : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c2));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Character.valueOf(c2)));
        }
        return linkedHashMap;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(float[] fArr, C destination, Function2<? super Integer, ? super Float, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = fArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            destination.add(transform.invoke(Integer.valueOf(i3), Float.valueOf(fArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(float[] fArr, C destination, Function1<? super Float, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (float f2 : fArr) {
            destination.add(transform.invoke(Float.valueOf(f2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWith(double[] dArr, Comparator<? super R> comparator, Function1<? super Double, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Object obj = (R) selector.invoke(Double.valueOf(dArr[0]));
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = (R) selector.invoke(Double.valueOf(dArr[i2]));
                    if (comparator.compare(obj, obj2) < 0) {
                        obj = (R) obj2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWithOrNull(double[] dArr, Comparator<? super R> comparator, Function1<? super Double, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Object obj = (R) selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Double.valueOf(dArr[i2]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWith(double[] dArr, Comparator<? super R> comparator, Function1<? super Double, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Object obj = (R) selector.invoke(Double.valueOf(dArr[0]));
            int lastIndex = getLastIndex(dArr);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = (R) selector.invoke(Double.valueOf(dArr[i2]));
                    if (comparator.compare(obj, obj2) > 0) {
                        obj = (R) obj2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWithOrNull(double[] dArr, Comparator<? super R> comparator, Function1<? super Double, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (dArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Object obj = (R) selector.invoke(Double.valueOf(dArr[0]));
        int lastIndex = getLastIndex(dArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Double.valueOf(dArr[i2]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    public static final void reverse(char[] cArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        AbstractList.Companion.d(i2, i3, cArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            char c2 = cArr[i2];
            cArr[i2] = cArr[i5];
            cArr[i5] = c2;
            i5--;
            i2++;
        }
    }

    private static final <R> List<R> runningFold(float[] fArr, R r2, Function2<? super R, ? super Float, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r2);
        for (float f2 : fArr) {
            r2 = operation.invoke(r2, Float.valueOf(f2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(float[] fArr, R r2, Function3<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r2);
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Float.valueOf(fArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scan(float[] fArr, R r2, Function2<? super R, ? super Float, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r2);
        for (float f2 : fArr) {
            r2 = operation.invoke(r2, Float.valueOf(f2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(float[] fArr, R r2, Function3<? super Integer, ? super R, ? super Float, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(fArr.length + 1);
        arrayList.add(r2);
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Float.valueOf(fArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final void sortDescending(double[] dArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(dArr, i2, i3);
        reverse(dArr, i2, i3);
    }

    public static final <V> List<V> zip(byte[] bArr, byte[] other, Function2<? super Byte, ? super Byte, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i2]), Byte.valueOf(other[i2])));
        }
        return arrayList;
    }

    public static final <K, M extends Map<? super K, ? super Double>> M associateByTo(double[] dArr, M destination, Function1<? super Double, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (double d2 : dArr) {
            destination.put(keySelector.invoke(Double.valueOf(d2)), Double.valueOf(d2));
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(int[] iArr, M destination, Function1<? super Integer, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i2 : iArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Integer.valueOf(i2));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    private static final <V, M extends Map<? super Integer, ? super V>> M associateWithTo(int[] iArr, M destination, Function1<? super Integer, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (int i2 : iArr) {
            destination.put(Integer.valueOf(i2), valueSelector.invoke(Integer.valueOf(i2)));
        }
        return destination;
    }

    private static final int elementAtOrElse(int[] iArr, int i2, Function1<? super Integer, Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < iArr.length) {
            z = true;
        }
        if (z) {
            return iArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2)).intValue();
    }

    public static final <C extends Collection<? super Integer>> C filterIndexedTo(int[] iArr, C destination, Function2<? super Integer, ? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            int i5 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Integer.valueOf(i4)).booleanValue()) {
                destination.add(Integer.valueOf(i4));
            }
            i2++;
            i3 = i5;
        }
        return destination;
    }

    public static final <C extends Collection<? super Integer>> C filterNotTo(int[] iArr, C destination, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i2 : iArr) {
            if (!predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                destination.add(Integer.valueOf(i2));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Integer>> C filterTo(int[] iArr, C destination, Function1<? super Integer, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (int i2 : iArr) {
            if (predicate.invoke(Integer.valueOf(i2)).booleanValue()) {
                destination.add(Integer.valueOf(i2));
            }
        }
        return destination;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(int[] iArr, C destination, Function2<? super Integer, ? super Integer, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(int[] iArr, C destination, Function1<? super Integer, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i2 : iArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i2)));
        }
        return destination;
    }

    public static final <R> R fold(long[] jArr, R r2, Function2<? super R, ? super Long, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (long j2 : jArr) {
            r2 = operation.invoke(r2, Long.valueOf(j2));
        }
        return r2;
    }

    public static final <R> R foldIndexed(int[] iArr, R r2, Function3<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            R r3 = r2;
            r2 = operation.invoke(Integer.valueOf(i3), r3, Integer.valueOf(iArr[i2]));
            i2++;
            i3++;
        }
        return r2;
    }

    public static final <R> R foldRight(long[] jArr, R r2, Function2<? super Long, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Long.valueOf(jArr[lastIndex]), r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(int[] iArr, R r2, Function3<? super Integer, ? super Integer, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(iArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Integer.valueOf(lastIndex), Integer.valueOf(iArr[lastIndex]), r2);
        }
        return r2;
    }

    private static final int getOrElse(int[] iArr, int i2, Function1<? super Integer, Integer> defaultValue) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < iArr.length) {
            z = true;
        }
        if (z) {
            return iArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2)).intValue();
    }

    public static final <K, M extends Map<? super K, List<Double>>> M groupByTo(double[] dArr, M destination, Function1<? super Double, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        for (double d2 : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(Double.valueOf(d2));
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(int[] iArr, C destination, Function2<? super Integer, ? super Integer, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            destination.add(transform.invoke(Integer.valueOf(i3), Integer.valueOf(iArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(int[] iArr, C destination, Function1<? super Integer, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (int i2 : iArr) {
            destination.add(transform.invoke(Integer.valueOf(i2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWith(float[] fArr, Comparator<? super R> comparator, Function1<? super Float, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Object obj = (R) selector.invoke(Float.valueOf(fArr[0]));
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = (R) selector.invoke(Float.valueOf(fArr[i2]));
                    if (comparator.compare(obj, obj2) < 0) {
                        obj = (R) obj2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWithOrNull(float[] fArr, Comparator<? super R> comparator, Function1<? super Float, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Object obj = (R) selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Float.valueOf(fArr[i2]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWith(float[] fArr, Comparator<? super R> comparator, Function1<? super Float, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Object obj = (R) selector.invoke(Float.valueOf(fArr[0]));
            int lastIndex = getLastIndex(fArr);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = (R) selector.invoke(Float.valueOf(fArr[i2]));
                    if (comparator.compare(obj, obj2) > 0) {
                        obj = (R) obj2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWithOrNull(float[] fArr, Comparator<? super R> comparator, Function1<? super Float, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (fArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Object obj = (R) selector.invoke(Float.valueOf(fArr[0]));
        int lastIndex = getLastIndex(fArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Float.valueOf(fArr[i2]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    private static final <R> List<R> runningFold(int[] iArr, R r2, Function2<? super R, ? super Integer, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r2);
        for (int i2 : iArr) {
            r2 = operation.invoke(r2, Integer.valueOf(i2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(int[] iArr, R r2, Function3<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r2);
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Integer.valueOf(iArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scan(int[] iArr, R r2, Function2<? super R, ? super Integer, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r2);
        for (int i2 : iArr) {
            r2 = operation.invoke(r2, Integer.valueOf(i2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(int[] iArr, R r2, Function3<? super Integer, ? super R, ? super Integer, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(iArr.length + 1);
        arrayList.add(r2);
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Integer.valueOf(iArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> associateBy(double[] dArr, Function1<? super Double, ? extends K> keySelector, Function1<? super Double, ? extends V> valueTransform) {
        int mapCapacity;
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(dArr.length);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (double d2 : dArr) {
            linkedHashMap.put(keySelector.invoke(Double.valueOf(d2)), valueTransform.invoke(Double.valueOf(d2)));
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateTo(long[] jArr, M destination, Function1<? super Long, ? extends Pair<? extends K, ? extends V>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (long j2 : jArr) {
            Pair<? extends K, ? extends V> invoke = transform.invoke(Long.valueOf(j2));
            destination.put(invoke.getFirst(), invoke.getSecond());
        }
        return destination;
    }

    private static final <V, M extends Map<? super Long, ? super V>> M associateWithTo(long[] jArr, M destination, Function1<? super Long, ? extends V> valueSelector) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(valueSelector, "valueSelector");
        for (long j2 : jArr) {
            destination.put(Long.valueOf(j2), valueSelector.invoke(Long.valueOf(j2)));
        }
        return destination;
    }

    private static final long elementAtOrElse(long[] jArr, int i2, Function1<? super Integer, Long> defaultValue) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < jArr.length) {
            z = true;
        }
        if (z) {
            return jArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2)).longValue();
    }

    public static final <C extends Collection<? super Long>> C filterIndexedTo(long[] jArr, C destination, Function2<? super Integer, ? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            long j2 = jArr[i2];
            int i4 = i3 + 1;
            if (predicate.invoke(Integer.valueOf(i3), Long.valueOf(j2)).booleanValue()) {
                destination.add(Long.valueOf(j2));
            }
            i2++;
            i3 = i4;
        }
        return destination;
    }

    public static final <C extends Collection<? super Long>> C filterNotTo(long[] jArr, C destination, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j2 : jArr) {
            if (!predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                destination.add(Long.valueOf(j2));
            }
        }
        return destination;
    }

    public static final <C extends Collection<? super Long>> C filterTo(long[] jArr, C destination, Function1<? super Long, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        for (long j2 : jArr) {
            if (predicate.invoke(Long.valueOf(j2)).booleanValue()) {
                destination.add(Long.valueOf(j2));
            }
        }
        return destination;
    }

    private static final <R, C extends Collection<? super R>> C flatMapIndexedIterableTo(long[] jArr, C destination, Function2<? super Integer, ? super Long, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Integer.valueOf(i3), Long.valueOf(jArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C flatMapTo(long[] jArr, C destination, Function1<? super Long, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (long j2 : jArr) {
            CollectionsKt__MutableCollectionsKt.addAll(destination, transform.invoke(Long.valueOf(j2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R fold(T[] tArr, R r2, Function2<? super R, ? super T, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (d.a.C0000a c0000a : tArr) {
            r2 = operation.invoke(r2, c0000a);
        }
        return r2;
    }

    public static final <R> R foldIndexed(long[] jArr, R r2, Function3<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            R r3 = r2;
            r2 = operation.invoke(Integer.valueOf(i3), r3, Long.valueOf(jArr[i2]));
            i2++;
            i3++;
        }
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, R> R foldRight(T[] tArr, R r2, Function2<? super T, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(tArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(tArr[lastIndex], r2);
        }
        return r2;
    }

    public static final <R> R foldRightIndexed(long[] jArr, R r2, Function3<? super Integer, ? super Long, ? super R, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        for (int lastIndex = getLastIndex(jArr); lastIndex >= 0; lastIndex--) {
            r2 = operation.invoke(Integer.valueOf(lastIndex), Long.valueOf(jArr[lastIndex]), r2);
        }
        return r2;
    }

    private static final long getOrElse(long[] jArr, int i2, Function1<? super Integer, Long> defaultValue) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        boolean z = false;
        if (i2 >= 0 && i2 < jArr.length) {
            z = true;
        }
        if (z) {
            return jArr[i2];
        }
        return defaultValue.invoke(Integer.valueOf(i2)).longValue();
    }

    public static final <K, V> Map<K, List<V>> groupBy(double[] dArr, Function1<? super Double, ? extends K> keySelector, Function1<? super Double, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (double d2 : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d2));
            List<V> list = linkedHashMap.get(invoke);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(invoke, list);
            }
            list.add(valueTransform.invoke(Double.valueOf(d2)));
        }
        return linkedHashMap;
    }

    public static final <R, C extends Collection<? super R>> C mapIndexedTo(long[] jArr, C destination, Function2<? super Integer, ? super Long, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int length = jArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            destination.add(transform.invoke(Integer.valueOf(i3), Long.valueOf(jArr[i2])));
            i2++;
            i3++;
        }
        return destination;
    }

    public static final <R, C extends Collection<? super R>> C mapTo(long[] jArr, C destination, Function1<? super Long, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (long j2 : jArr) {
            destination.add(transform.invoke(Long.valueOf(j2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWith(int[] iArr, Comparator<? super R> comparator, Function1<? super Integer, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Object obj = (R) selector.invoke(Integer.valueOf(iArr[0]));
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = (R) selector.invoke(Integer.valueOf(iArr[i2]));
                    if (comparator.compare(obj, obj2) < 0) {
                        obj = (R) obj2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R maxOfWithOrNull(int[] iArr, Comparator<? super R> comparator, Function1<? super Integer, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Object obj = (R) selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Integer.valueOf(iArr[i2]));
                if (comparator.compare(obj, obj2) < 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWith(int[] iArr, Comparator<? super R> comparator, Function1<? super Integer, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            Object obj = (R) selector.invoke(Integer.valueOf(iArr[0]));
            int lastIndex = getLastIndex(iArr);
            if (1 <= lastIndex) {
                while (true) {
                    Object obj2 = (R) selector.invoke(Integer.valueOf(iArr[i2]));
                    if (comparator.compare(obj, obj2) > 0) {
                        obj = (R) obj2;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <R> R minOfWithOrNull(int[] iArr, Comparator<? super R> comparator, Function1<? super Integer, ? extends R> selector) {
        boolean z;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(selector, "selector");
        int i2 = 1;
        if (iArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return null;
        }
        Object obj = (R) selector.invoke(Integer.valueOf(iArr[0]));
        int lastIndex = getLastIndex(iArr);
        if (1 <= lastIndex) {
            while (true) {
                Object obj2 = (R) selector.invoke(Integer.valueOf(iArr[i2]));
                if (comparator.compare(obj, obj2) > 0) {
                    obj = (R) obj2;
                }
                if (i2 == lastIndex) {
                    break;
                }
                i2++;
            }
        }
        return (R) obj;
    }

    public static final void reverse(double[] dArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        AbstractList.Companion.d(i2, i3, dArr.length);
        int i4 = (i2 + i3) / 2;
        if (i2 == i4) {
            return;
        }
        int i5 = i3 - 1;
        while (i2 < i4) {
            double d2 = dArr[i2];
            dArr[i2] = dArr[i5];
            dArr[i5] = d2;
            i5--;
            i2++;
        }
    }

    private static final <R> List<R> runningFold(long[] jArr, R r2, Function2<? super R, ? super Long, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r2);
        for (long j2 : jArr) {
            r2 = operation.invoke(r2, Long.valueOf(j2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> runningFoldIndexed(long[] jArr, R r2, Function3<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r2);
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Long.valueOf(jArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scan(long[] jArr, R r2, Function2<? super R, ? super Long, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r2);
        for (long j2 : jArr) {
            r2 = operation.invoke(r2, Long.valueOf(j2));
            arrayList.add(r2);
        }
        return arrayList;
    }

    private static final <R> List<R> scanIndexed(long[] jArr, R r2, Function3<? super Integer, ? super R, ? super Long, ? extends R> operation) {
        boolean z;
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(operation, "operation");
        if (jArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return CollectionsKt__CollectionsJVMKt.listOf(r2);
        }
        ArrayList arrayList = new ArrayList(jArr.length + 1);
        arrayList.add(r2);
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            r2 = operation.invoke(Integer.valueOf(i2), r2, Long.valueOf(jArr[i2]));
            arrayList.add(r2);
        }
        return arrayList;
    }

    public static final void sortDescending(float[] fArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        ArraysKt___ArraysJvmKt.sort(fArr, i2, i3);
        reverse(fArr, i2, i3);
    }

    public static final <R, V> List<V> zip(byte[] bArr, R[] other, Function2<? super Byte, ? super R, ? extends V> transform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(transform, "transform");
        int min = Math.min(bArr.length, other.length);
        ArrayList arrayList = new ArrayList(min);
        for (int i2 = 0; i2 < min; i2++) {
            arrayList.add(transform.invoke(Byte.valueOf(bArr[i2]), other[i2]));
        }
        return arrayList;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(byte[] bArr, M destination, Function1<? super Byte, ? extends K> keySelector, Function1<? super Byte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (byte b2 : bArr) {
            destination.put(keySelector.invoke(Byte.valueOf(b2)), valueTransform.invoke(Byte.valueOf(b2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(byte[] bArr, M destination, Function1<? super Byte, ? extends K> keySelector, Function1<? super Byte, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (byte b2 : bArr) {
            K invoke = keySelector.invoke(Byte.valueOf(b2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Byte.valueOf(b2)));
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(char[] cArr, M destination, Function1<? super Character, ? extends K> keySelector, Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (char c2 : cArr) {
            destination.put(keySelector.invoke(Character.valueOf(c2)), valueTransform.invoke(Character.valueOf(c2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(char[] cArr, M destination, Function1<? super Character, ? extends K> keySelector, Function1<? super Character, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (char c2 : cArr) {
            K invoke = keySelector.invoke(Character.valueOf(c2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Character.valueOf(c2)));
        }
        return destination;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M associateByTo(double[] dArr, M destination, Function1<? super Double, ? extends K> keySelector, Function1<? super Double, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (double d2 : dArr) {
            destination.put(keySelector.invoke(Double.valueOf(d2)), valueTransform.invoke(Double.valueOf(d2)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, M extends Map<? super K, List<V>>> M groupByTo(double[] dArr, M destination, Function1<? super Double, ? extends K> keySelector, Function1<? super Double, ? extends V> valueTransform) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        Intrinsics.checkNotNullParameter(valueTransform, "valueTransform");
        for (double d2 : dArr) {
            K invoke = keySelector.invoke(Double.valueOf(d2));
            Object obj = destination.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                destination.put(invoke, obj);
            }
            ((List) obj).add(valueTransform.invoke(Double.valueOf(d2)));
        }
        return destination;
    }

    public static final String joinToString(byte[] bArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(bArr, new StringBuilder(), separator, prefix, postfix, i2, truncated, function1)).toString();
    }

    public static final String joinToString(char[] cArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(cArr, new StringBuilder(), separator, prefix, postfix, i2, truncated, function1)).toString();
    }

    public static final String joinToString(double[] dArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Double, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(dArr, new StringBuilder(), separator, prefix, postfix, i2, truncated, function1)).toString();
    }

    public static final String joinToString(float[] fArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Float, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(fArr, new StringBuilder(), separator, prefix, postfix, i2, truncated, function1)).toString();
    }

    public static final String joinToString(int[] iArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Integer, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(iArr, new StringBuilder(), separator, prefix, postfix, i2, truncated, function1)).toString();
    }

    public static final String joinToString(long[] jArr, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Long, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(jArr, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        return ((StringBuilder) joinTo(jArr, new StringBuilder(), separator, prefix, postfix, i2, truncated, function1)).toString();
    }

    public static final <A extends Appendable> A joinTo(byte[] bArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Byte, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (byte b2 : bArr) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Byte.valueOf(b2)));
            } else {
                buffer.append(String.valueOf((int) b2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <A extends Appendable> A joinTo(char[] cArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (char c2 : cArr) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Character.valueOf(c2)));
            } else {
                buffer.append(c2);
            }
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <A extends Appendable> A joinTo(double[] dArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Double, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (double d2 : dArr) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Double.valueOf(d2)));
            } else {
                buffer.append(String.valueOf(d2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <A extends Appendable> A joinTo(float[] fArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Float, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (float f2 : fArr) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Float.valueOf(f2)));
            } else {
                buffer.append(String.valueOf(f2));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <A extends Appendable> A joinTo(int[] iArr, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, Function1<? super Integer, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (int i4 : iArr) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            if (function1 != null) {
                buffer.append(function1.invoke(Integer.valueOf(i4)));
            } else {
                buffer.append(String.valueOf(i4));
            }
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static /* synthetic */ String joinToString$default(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        int i4;
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i3 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i3 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i3 & 8) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(bArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (Function1<? super Byte, ? extends CharSequence>) function1);
    }

    public static /* synthetic */ String joinToString$default(char[] cArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        int i4;
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i3 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i3 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i3 & 8) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(cArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (Function1<? super Character, ? extends CharSequence>) function1);
    }

    public static /* synthetic */ String joinToString$default(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        int i4;
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i3 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i3 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i3 & 8) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(dArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (Function1<? super Double, ? extends CharSequence>) function1);
    }

    public static /* synthetic */ String joinToString$default(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        int i4;
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i3 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i3 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i3 & 8) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(fArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (Function1<? super Float, ? extends CharSequence>) function1);
    }

    public static /* synthetic */ String joinToString$default(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        int i4;
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i3 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i3 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i3 & 8) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(iArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (Function1<? super Integer, ? extends CharSequence>) function1);
    }

    public static /* synthetic */ String joinToString$default(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        int i4;
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence6 = "";
        if ((i3 & 2) != 0) {
            charSequence5 = "";
        } else {
            charSequence5 = charSequence2;
        }
        if ((i3 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i3 & 8) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            function1 = null;
        }
        return joinToString(jArr, charSequence, charSequence5, charSequence6, i4, charSequence7, (Function1<? super Long, ? extends CharSequence>) function1);
    }

    public static /* synthetic */ Appendable joinTo$default(byte[] bArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i4;
        CharSequence charSequence7;
        Function1 function12;
        if ((i3 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i3 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i3 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i3 & 16) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i3 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return joinTo(bArr, appendable, charSequence5, charSequence6, charSequence8, i4, charSequence7, (Function1<? super Byte, ? extends CharSequence>) function12);
    }

    public static /* synthetic */ Appendable joinTo$default(char[] cArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i4;
        CharSequence charSequence7;
        Function1 function12;
        if ((i3 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i3 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i3 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i3 & 16) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i3 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return joinTo(cArr, appendable, charSequence5, charSequence6, charSequence8, i4, charSequence7, (Function1<? super Character, ? extends CharSequence>) function12);
    }

    public static /* synthetic */ Appendable joinTo$default(double[] dArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i4;
        CharSequence charSequence7;
        Function1 function12;
        if ((i3 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i3 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i3 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i3 & 16) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i3 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return joinTo(dArr, appendable, charSequence5, charSequence6, charSequence8, i4, charSequence7, (Function1<? super Double, ? extends CharSequence>) function12);
    }

    public static /* synthetic */ Appendable joinTo$default(float[] fArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i4;
        CharSequence charSequence7;
        Function1 function12;
        if ((i3 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i3 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i3 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i3 & 16) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i3 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return joinTo(fArr, appendable, charSequence5, charSequence6, charSequence8, i4, charSequence7, (Function1<? super Float, ? extends CharSequence>) function12);
    }

    public static /* synthetic */ Appendable joinTo$default(int[] iArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i4;
        CharSequence charSequence7;
        Function1 function12;
        if ((i3 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i3 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i3 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i3 & 16) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i3 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return joinTo(iArr, appendable, charSequence5, charSequence6, charSequence8, i4, charSequence7, (Function1<? super Integer, ? extends CharSequence>) function12);
    }

    public static /* synthetic */ Appendable joinTo$default(long[] jArr, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, Function1 function1, int i3, Object obj) {
        CharSequence charSequence5;
        CharSequence charSequence6;
        int i4;
        CharSequence charSequence7;
        Function1 function12;
        if ((i3 & 2) != 0) {
            charSequence5 = ", ";
        } else {
            charSequence5 = charSequence;
        }
        CharSequence charSequence8 = "";
        if ((i3 & 4) != 0) {
            charSequence6 = "";
        } else {
            charSequence6 = charSequence2;
        }
        if ((i3 & 8) == 0) {
            charSequence8 = charSequence3;
        }
        if ((i3 & 16) != 0) {
            i4 = -1;
        } else {
            i4 = i2;
        }
        if ((i3 & 32) != 0) {
            charSequence7 = "...";
        } else {
            charSequence7 = charSequence4;
        }
        if ((i3 & 64) != 0) {
            function12 = null;
        } else {
            function12 = function1;
        }
        return joinTo(jArr, appendable, charSequence5, charSequence6, charSequence8, i4, charSequence7, (Function1<? super Long, ? extends CharSequence>) function12);
    }
}
