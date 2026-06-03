package kotlin.uuid;

import androidx.collection.w;
import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import kotlin.ULong;
import kotlin.h;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class Uuid implements Comparable<Uuid>, Serializable {
    public static final a Companion;
    private static final Uuid NIL;
    private final long leastSignificantBits;
    private final long mostSignificantBits;

    public /* synthetic */ Uuid(long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2);
    }

    public static /* synthetic */ void getLeastSignificantBits$annotations() {
    }

    public static /* synthetic */ void getMostSignificantBits$annotations() {
    }

    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(658843);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Uuid b() {
            return Uuid.NIL;
        }

        public final Uuid c(String uuidString) {
            String j;
            Intrinsics.checkNotNullParameter(uuidString, "uuidString");
            int length = uuidString.length();
            if (length != 32) {
                if (length == 36) {
                    return kotlin.uuid.a.e(uuidString);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
                j = b.j(uuidString, 64);
                sb.append(j);
                sb.append("\" of length ");
                sb.append(uuidString.length());
                throw new IllegalArgumentException(sb.toString());
            }
            return kotlin.uuid.a.d(uuidString);
        }

        public final Uuid a(long j, long j2) {
            if (j == 0 && j2 == 0) {
                return b();
            }
            return new Uuid(j, j2, null);
        }
    }

    private final Object writeReplace() {
        return kotlin.uuid.a.b(this);
    }

    public String toString() {
        return toHexDashString();
    }

    public int hashCode() {
        return j.a(this.mostSignificantBits ^ this.leastSignificantBits);
    }

    /* renamed from: toUByteArray-TcUX1vc, reason: not valid java name */
    public final byte[] m1067toUByteArrayTcUX1vc() {
        return h.j(toByteArray());
    }

    static {
        Covode.recordClassIndex(658842);
        Companion = new a(null);
        NIL = new Uuid(0L, 0L);
    }

    public final byte[] toByteArray() {
        byte[] bArr = new byte[16];
        kotlin.uuid.a.c(bArr, 0, this.mostSignificantBits);
        kotlin.uuid.a.c(bArr, 8, this.leastSignificantBits);
        return bArr;
    }

    public final String toHexString() {
        String decodeToString;
        byte[] bArr = new byte[32];
        kotlin.uuid.a.a(this.mostSignificantBits, bArr, 0, 0, 8);
        kotlin.uuid.a.a(this.leastSignificantBits, bArr, 16, 0, 8);
        decodeToString = StringsKt__StringsJVMKt.decodeToString(bArr);
        return decodeToString;
    }

    public final String toHexDashString() {
        String decodeToString;
        byte[] bArr = new byte[36];
        kotlin.uuid.a.a(this.mostSignificantBits, bArr, 0, 0, 4);
        bArr[8] = 45;
        kotlin.uuid.a.a(this.mostSignificantBits, bArr, 9, 4, 6);
        bArr[13] = 45;
        kotlin.uuid.a.a(this.mostSignificantBits, bArr, 14, 6, 8);
        bArr[18] = 45;
        kotlin.uuid.a.a(this.leastSignificantBits, bArr, 19, 0, 2);
        bArr[23] = 45;
        kotlin.uuid.a.a(this.leastSignificantBits, bArr, 24, 2, 8);
        decodeToString = StringsKt__StringsJVMKt.decodeToString(bArr);
        return decodeToString;
    }

    private final <T> T toLongs(Function2<? super Long, ? super Long, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(getMostSignificantBits()), Long.valueOf(getLeastSignificantBits()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Uuid)) {
            return false;
        }
        Uuid uuid = (Uuid) obj;
        if (this.mostSignificantBits == uuid.mostSignificantBits && this.leastSignificantBits == uuid.leastSignificantBits) {
            return true;
        }
        return false;
    }

    private final <T> T toULongs(Function2<? super ULong, ? super ULong, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(ULong.m844boximpl(ULong.m850constructorimpl(getMostSignificantBits())), ULong.m844boximpl(ULong.m850constructorimpl(getLeastSignificantBits())));
    }

    @Override // java.lang.Comparable
    public int compareTo(Uuid other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long j = this.mostSignificantBits;
        if (j != other.mostSignificantBits) {
            return w.a(ULong.m850constructorimpl(j), ULong.m850constructorimpl(other.mostSignificantBits));
        }
        return w.a(ULong.m850constructorimpl(this.leastSignificantBits), ULong.m850constructorimpl(other.leastSignificantBits));
    }

    private Uuid(long j, long j2) {
        this.mostSignificantBits = j;
        this.leastSignificantBits = j2;
    }
}
