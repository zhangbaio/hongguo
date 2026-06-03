package kotlin.io.encoding;

import com.bytedance.covode.number.Covode;
import java.nio.charset.Charset;
import kotlin.collections.AbstractList;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.Charsets;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class Base64 {
    public static final a d;
    private static final byte[] e;
    private static final Base64 f;
    private static final Base64 g;
    public final boolean a;
    public final boolean b;
    public final PaddingOption c;

    public /* synthetic */ Base64(boolean z, boolean z2, PaddingOption paddingOption, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, paddingOption);
    }

    public static final class a extends Base64 {
        static {
            Covode.recordClassIndex(658400);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private a() {
            /*
                r3 = this;
                kotlin.io.encoding.Base64$PaddingOption r0 = kotlin.io.encoding.Base64.PaddingOption.PRESENT
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.io.encoding.Base64.a.<init>():void");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class PaddingOption {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PaddingOption[] $VALUES;
        public static final PaddingOption ABSENT;
        public static final PaddingOption ABSENT_OPTIONAL;
        public static final PaddingOption PRESENT;
        public static final PaddingOption PRESENT_OPTIONAL;

        private static final /* synthetic */ PaddingOption[] $values() {
            return new PaddingOption[]{PRESENT, ABSENT, PRESENT_OPTIONAL, ABSENT_OPTIONAL};
        }

        public static EnumEntries<PaddingOption> getEntries() {
            return $ENTRIES;
        }

        public static PaddingOption[] values() {
            return (PaddingOption[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(658401);
            PRESENT = new PaddingOption("PRESENT", 0);
            ABSENT = new PaddingOption("ABSENT", 1);
            PRESENT_OPTIONAL = new PaddingOption("PRESENT_OPTIONAL", 2);
            ABSENT_OPTIONAL = new PaddingOption("ABSENT_OPTIONAL", 3);
            PaddingOption[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static PaddingOption valueOf(String str) {
            return (PaddingOption) Enum.valueOf(PaddingOption.class, str);
        }

        private PaddingOption(String str, int i) {
        }
    }

    static {
        Covode.recordClassIndex(658399);
        d = new a(null);
        e = new byte[]{13, 10};
        PaddingOption paddingOption = PaddingOption.PRESENT;
        f = new Base64(true, false, paddingOption);
        g = new Base64(false, true, paddingOption);
    }

    private final void b(int i) {
        if (this.c != PaddingOption.ABSENT) {
            return;
        }
        throw new IllegalArgumentException("The padding option is set to ABSENT, but the input has a pad character at index " + i);
    }

    public final void c(int i, int i2, int i3) {
        AbstractList.Companion.a(i2, i3, i);
    }

    private Base64(boolean z, boolean z2, PaddingOption paddingOption) {
        boolean z3;
        this.a = z;
        this.b = z2;
        this.c = paddingOption;
        if (z && z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final int k(byte[] bArr, int i, int i2) {
        int[] iArr;
        if (!this.b) {
            return i;
        }
        while (i < i2) {
            int i3 = bArr[i] & 255;
            iArr = um6.a.b;
            if (iArr[i3] != -1) {
                return i;
            }
            i++;
        }
        return i;
    }

    public final byte[] a(CharSequence source, int i, int i2) {
        Intrinsics.checkNotNullParameter(source, "source");
        c(source.length(), i, i2);
        byte[] bArr = new byte[i2 - i];
        int i3 = 0;
        while (i < i2) {
            char charAt = source.charAt(i);
            if (charAt <= 255) {
                bArr[i3] = (byte) charAt;
                i3++;
            } else {
                bArr[i3] = 63;
                i3++;
            }
            i++;
        }
        return bArr;
    }

    public final byte[] d(CharSequence source, int i, int i2) {
        byte[] a2;
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof String) {
            String str = (String) source;
            c(str.length(), i, i2);
            String substring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Charset charset = Charsets.ISO_8859_1;
            Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            a2 = substring.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(a2, "getBytes(...)");
        } else {
            a2 = a(source, i, i2);
        }
        return g(this, a2, 0, 0, 6, null);
    }

    public final byte[] e(byte[] source, int i, int i2) {
        boolean z;
        Intrinsics.checkNotNullParameter(source, "source");
        c(source.length, i, i2);
        int i3 = i(source, i, i2);
        byte[] bArr = new byte[i3];
        if (h(source, bArr, 0, i, i2) == i3) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return bArr;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final int i(byte[] source, int i, int i2) {
        int[] iArr;
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = i2 - i;
        if (i3 == 0) {
            return 0;
        }
        if (i3 != 1) {
            if (this.b) {
                while (true) {
                    if (i >= i2) {
                        break;
                    }
                    int i4 = source[i] & 255;
                    iArr = um6.a.b;
                    int i5 = iArr[i4];
                    if (i5 < 0) {
                        if (i5 == -2) {
                            i3 -= i2 - i;
                            break;
                        }
                        i3--;
                    }
                    i++;
                }
            } else if (source[i2 - 1] == 61) {
                i3--;
                if (source[i2 - 2] == 61) {
                    i3--;
                }
            }
            return (int) ((i3 * 6) / 8);
        }
        throw new IllegalArgumentException("Input should have at least 2 symbols for Base64 decoding, startIndex: " + i + ", endIndex: " + i2);
    }

    private final int j(byte[] bArr, int i, int i2, int i3) {
        if (i3 != -8) {
            if (i3 != -6) {
                if (i3 != -4) {
                    if (i3 != -2) {
                        throw new IllegalStateException("Unreachable".toString());
                    }
                } else {
                    b(i);
                    i = k(bArr, i + 1, i2);
                    if (i == i2 || bArr[i] != 61) {
                        throw new IllegalArgumentException("Missing one pad character at index " + i);
                    }
                }
            } else {
                b(i);
            }
            return i + 1;
        }
        throw new IllegalArgumentException("Redundant pad character at index " + i);
    }

    private final int h(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        int[] iArr;
        boolean z;
        int checkRadix;
        int checkRadix2;
        if (this.a) {
            iArr = um6.a.d;
        } else {
            iArr = um6.a.b;
        }
        int i4 = -8;
        int i5 = i;
        int i6 = i2;
        int i7 = -8;
        int i8 = 0;
        while (true) {
            if (i6 < i3) {
                if (i7 == i4 && i6 + 3 < i3) {
                    int i9 = i6 + 1;
                    int i10 = iArr[bArr[i6] & 255];
                    int i11 = i9 + 1;
                    int i12 = iArr[bArr[i9] & 255];
                    int i13 = i11 + 1;
                    int i14 = iArr[bArr[i11] & 255];
                    int i15 = i13 + 1;
                    int i16 = (i12 << 12) | (i10 << 18) | (i14 << 6) | iArr[bArr[i13] & 255];
                    if (i16 >= 0) {
                        int i17 = i5 + 1;
                        bArr2[i5] = (byte) (i16 >> 16);
                        int i18 = i17 + 1;
                        bArr2[i17] = (byte) (i16 >> 8);
                        i5 = i18 + 1;
                        bArr2[i18] = (byte) i16;
                        i6 = i15;
                        i4 = -8;
                    } else {
                        i6 = i15 - 4;
                    }
                }
                int i19 = bArr[i6] & 255;
                int i20 = iArr[i19];
                if (i20 < 0) {
                    if (i20 == -2) {
                        i6 = j(bArr, i6, i3, i7);
                        z = true;
                        break;
                    }
                    if (this.b) {
                        i6++;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid symbol '");
                        sb.append((char) i19);
                        sb.append("'(");
                        checkRadix2 = CharsKt__CharJVMKt.checkRadix(8);
                        String num = Integer.toString(i19, checkRadix2);
                        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
                        sb.append(num);
                        sb.append(") at index ");
                        sb.append(i6);
                        throw new IllegalArgumentException(sb.toString());
                    }
                } else {
                    i6++;
                    i8 = (i8 << 6) | i20;
                    i7 += 6;
                    if (i7 >= 0) {
                        bArr2[i5] = (byte) (i8 >>> i7);
                        i8 &= (1 << i7) - 1;
                        i7 -= 8;
                        i5++;
                    }
                }
                i4 = -8;
            } else {
                z = false;
                break;
            }
        }
        if (i7 != -2) {
            if (i7 != -8 && !z && this.c == PaddingOption.PRESENT) {
                throw new IllegalArgumentException("The padding option is set to PRESENT, but the input is not properly padded");
            }
            if (i8 == 0) {
                int k = k(bArr, i6, i3);
                if (k >= i3) {
                    return i5 - i;
                }
                int i21 = bArr[k] & 255;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Symbol '");
                sb2.append((char) i21);
                sb2.append("'(");
                checkRadix = CharsKt__CharJVMKt.checkRadix(8);
                String num2 = Integer.toString(i21, checkRadix);
                Intrinsics.checkNotNullExpressionValue(num2, "toString(...)");
                sb2.append(num2);
                sb2.append(") at index ");
                sb2.append(k - 1);
                sb2.append(" is prohibited after the pad character");
                throw new IllegalArgumentException(sb2.toString());
            }
            throw new IllegalArgumentException("The pad bits must be zeros");
        }
        throw new IllegalArgumentException("The last unit of input does not have enough bits");
    }

    public static /* synthetic */ byte[] f(Base64 base64, CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = charSequence.length();
            }
            return base64.d(charSequence, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public static /* synthetic */ byte[] g(Base64 base64, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return base64.e(bArr, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }
}
