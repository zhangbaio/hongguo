package ls3;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.facebook.drawee.drawable.ScalingUtils;
import eh6.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends e {
    public static final int d;
    public final C0240a c;

    static {
        Covode.recordClassIndex(598952);
        d = 8;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(C0240a data) {
        super(310000, data);
        Intrinsics.checkNotNullParameter(data, "data");
        this.c = data;
    }

    /* renamed from: ls3.a$a, reason: collision with other inner class name */
    public static final class C0240a {
        public static final int i;
        public final String a;
        public final String b;
        public final boolean c;
        public final boolean d;
        public final Integer e;
        public final Object f;
        public final ScalingUtils.ScaleType g;
        public final ScalingUtils.ScaleType h;

        static {
            Covode.recordClassIndex(598953);
            i = 8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0240a)) {
                return false;
            }
            C0240a c0240a = (C0240a) obj;
            return Intrinsics.areEqual(this.a, c0240a.a) && Intrinsics.areEqual(this.b, c0240a.b) && this.c == c0240a.c && this.d == c0240a.d && Intrinsics.areEqual(this.e, c0240a.e) && Intrinsics.areEqual(this.f, c0240a.f) && Intrinsics.areEqual(this.g, c0240a.g) && Intrinsics.areEqual(this.h, c0240a.h);
        }

        public int hashCode() {
            int hashCode = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + m.a(this.c)) * 31) + m.a(this.d)) * 31;
            Integer num = this.e;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Object obj = this.f;
            return ((((hashCode2 + (obj != null ? obj.hashCode() : 0)) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
        }

        public String toString() {
            return "Data(title=" + this.a + ", coverUrl=" + this.b + ", withAnim=" + this.c + ", placeHolderByFrameWhenPause=" + this.d + ", placeHolderSkinResId=" + this.e + ", callerContext=" + this.f + ", placeHolderScaleType=" + this.g + ", actualScaleType=" + this.h + ')';
        }

        public C0240a(String title, String coverUrl, boolean z, boolean z2, Integer num, Object obj, ScalingUtils.ScaleType placeHolderScaleType, ScalingUtils.ScaleType actualScaleType) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
            Intrinsics.checkNotNullParameter(placeHolderScaleType, "placeHolderScaleType");
            Intrinsics.checkNotNullParameter(actualScaleType, "actualScaleType");
            this.a = title;
            this.b = coverUrl;
            this.c = z;
            this.d = z2;
            this.e = num;
            this.f = obj;
            this.g = placeHolderScaleType;
            this.h = actualScaleType;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public /* synthetic */ C0240a(java.lang.String r12, java.lang.String r13, boolean r14, boolean r15, java.lang.Integer r16, java.lang.Object r17, com.facebook.drawee.drawable.ScalingUtils.ScaleType r18, com.facebook.drawee.drawable.ScalingUtils.ScaleType r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
            /*
                r11 = this;
                r0 = r20
                r1 = r0 & 4
                if (r1 == 0) goto L9
                r1 = 0
                r5 = 0
                goto La
            L9:
                r5 = r14
            La:
                r1 = r0 & 8
                if (r1 == 0) goto L11
                r1 = 1
                r6 = 1
                goto L12
            L11:
                r6 = r15
            L12:
                r1 = r0 & 16
                r2 = 0
                if (r1 == 0) goto L19
                r7 = r2
                goto L1b
            L19:
                r7 = r16
            L1b:
                r1 = r0 & 32
                if (r1 == 0) goto L21
                r8 = r2
                goto L23
            L21:
                r8 = r17
            L23:
                r1 = r0 & 64
                if (r1 == 0) goto L2b
                com.facebook.drawee.drawable.ScalingUtils$ScaleType r1 = com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_CROP
                r9 = r1
                goto L2d
            L2b:
                r9 = r18
            L2d:
                r0 = r0 & 128(0x80, float:1.8E-43)
                if (r0 == 0) goto L35
                com.facebook.drawee.drawable.ScalingUtils$ScaleType r0 = com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_CROP
                r10 = r0
                goto L37
            L35:
                r10 = r19
            L37:
                r2 = r11
                r3 = r12
                r4 = r13
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ls3.a.C0240a.<init>(java.lang.String, java.lang.String, boolean, boolean, java.lang.Integer, java.lang.Object, com.facebook.drawee.drawable.ScalingUtils$ScaleType, com.facebook.drawee.drawable.ScalingUtils$ScaleType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }
    }
}
