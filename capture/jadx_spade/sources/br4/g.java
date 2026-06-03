package br4;

import android.app.Activity;
import androidx.compose.animation.m;
import androidx.fragment.app.Fragment;
import com.bytedance.covode.number.Covode;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final int m;
    public Activity a;
    public Fragment b;
    public String c;
    public Map<String, ? extends Object> d;
    public boolean e;
    public int f;
    public boolean g;
    public int h;
    public boolean i;
    public boolean j;
    public List<? extends f> k;
    public Object l;

    static {
        Covode.recordClassIndex(611450);
        m = 8;
    }

    public g() {
        this(null, null, null, null, false, 0, false, 0, false, false, null, null, 4095, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual(this.a, gVar.a) && Intrinsics.areEqual(this.b, gVar.b) && Intrinsics.areEqual(this.c, gVar.c) && Intrinsics.areEqual(this.d, gVar.d) && this.e == gVar.e && this.f == gVar.f && this.g == gVar.g && this.h == gVar.h && this.i == gVar.i && this.j == gVar.j && Intrinsics.areEqual(this.k, gVar.k) && Intrinsics.areEqual(this.l, gVar.l);
    }

    public int hashCode() {
        Activity activity = this.a;
        int hashCode = (activity == null ? 0 : activity.hashCode()) * 31;
        Fragment fragment = this.b;
        int hashCode2 = (hashCode + (fragment == null ? 0 : fragment.hashCode())) * 31;
        String str = this.c;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, ? extends Object> map = this.d;
        int hashCode4 = (((((((((((((hashCode3 + (map == null ? 0 : map.hashCode())) * 31) + m.a(this.e)) * 31) + this.f) * 31) + m.a(this.g)) * 31) + this.h) * 31) + m.a(this.i)) * 31) + m.a(this.j)) * 31;
        List<? extends f> list = this.k;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Object obj = this.l;
        return hashCode5 + (obj != null ? obj.hashCode() : 0);
    }

    public String toString() {
        return "MediaFinderConfig(activity=" + this.a + ", fragment=" + this.b + ", openMediaFrom=" + this.c + ", reportMap=" + this.d + ", singleModeEnable=" + this.e + ", maxSelectImageCount=" + this.f + ", enableSelectLocalVideo=" + this.g + ", maxSelectVideoCount=" + this.h + ", getResultByCallback=" + this.i + ", showMultiSelectEntrance=" + this.j + ", defaultSelectedItem=" + this.k + ", aiDependency=" + this.l + ')';
    }

    public final Activity getActivity() {
        return this.a;
    }

    public g(Activity activity, Fragment fragment, String str, Map<String, ? extends Object> map, boolean z, int i, boolean z2, int i2, boolean z3, boolean z4, List<? extends f> list, Object obj) {
        this.a = activity;
        this.b = fragment;
        this.c = str;
        this.d = map;
        this.e = z;
        this.f = i;
        this.g = z2;
        this.h = i2;
        this.i = z3;
        this.j = z4;
        this.k = list;
        this.l = obj;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ g(android.app.Activity r14, androidx.fragment.app.Fragment r15, java.lang.String r16, java.util.Map r17, boolean r18, int r19, boolean r20, int r21, boolean r22, boolean r23, java.util.List r24, java.lang.Object r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L9
            r1 = r2
            goto La
        L9:
            r1 = r14
        La:
            r3 = r0 & 2
            if (r3 == 0) goto L10
            r3 = r2
            goto L11
        L10:
            r3 = r15
        L11:
            r4 = r0 & 4
            if (r4 == 0) goto L17
            r4 = r2
            goto L19
        L17:
            r4 = r16
        L19:
            r5 = r0 & 8
            if (r5 == 0) goto L1f
            r5 = r2
            goto L21
        L1f:
            r5 = r17
        L21:
            r6 = r0 & 16
            r7 = 1
            if (r6 == 0) goto L28
            r6 = 1
            goto L2a
        L28:
            r6 = r18
        L2a:
            r8 = r0 & 32
            if (r8 == 0) goto L30
            r8 = 1
            goto L32
        L30:
            r8 = r19
        L32:
            r9 = r0 & 64
            r10 = 0
            if (r9 == 0) goto L39
            r9 = 0
            goto L3b
        L39:
            r9 = r20
        L3b:
            r11 = r0 & 128(0x80, float:1.8E-43)
            if (r11 == 0) goto L40
            goto L42
        L40:
            r7 = r21
        L42:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L48
            r11 = 0
            goto L4a
        L48:
            r11 = r22
        L4a:
            r12 = r0 & 512(0x200, float:7.17E-43)
            if (r12 == 0) goto L4f
            goto L51
        L4f:
            r10 = r23
        L51:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L57
            r12 = r2
            goto L59
        L57:
            r12 = r24
        L59:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L5e
            goto L60
        L5e:
            r2 = r25
        L60:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r8
            r21 = r9
            r22 = r7
            r23 = r11
            r24 = r10
            r25 = r12
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: br4.g.<init>(android.app.Activity, androidx.fragment.app.Fragment, java.lang.String, java.util.Map, boolean, int, boolean, int, boolean, boolean, java.util.List, java.lang.Object, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
