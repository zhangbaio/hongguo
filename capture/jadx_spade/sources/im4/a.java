package im4;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public final long a;
    public final long b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final String g;
    public final String h;
    public final boolean i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;

    static {
        Covode.recordClassIndex(608463);
    }

    public final a a(long j, long j2, int i, int i2, int i3, int i4, String str, String str2, boolean z, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        return new a(j, j2, i, i2, i3, i4, str, str2, z, i5, i6, i7, i8, i9, i10, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d && this.e == aVar.e && this.f == aVar.f && Intrinsics.areEqual(this.g, aVar.g) && Intrinsics.areEqual(this.h, aVar.h) && this.i == aVar.i && this.j == aVar.j && this.k == aVar.k && this.l == aVar.l && this.m == aVar.m && this.n == aVar.n && this.o == aVar.o && this.p == aVar.p && this.q == aVar.q;
    }

    public int hashCode() {
        int a = ((((((((((j.a(this.a) * 31) + j.a(this.b)) * 31) + this.c) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31;
        String str = this.g;
        int hashCode = (a + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.h;
        return ((((((((((((((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + m.a(this.i)) * 31) + this.j) * 31) + this.k) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q;
    }

    public String toString() {
        return "KmpAudioSyncReaderModel(startTime=" + this.a + ", endTime=" + this.b + ", startPara=" + this.c + ", startParaOff=" + this.d + ", endPara=" + this.e + ", endParaOff=" + this.f + ", audioItemId=" + this.g + ", novelItemId=" + this.h + ", isTitle=" + this.i + ", startContainerId=" + this.j + ", startElementIndex=" + this.k + ", startElementOffset=" + this.l + ", endContainerId=" + this.m + ", endElementIndex=" + this.n + ", endElementOffset=" + this.o + ", startElementOrder=" + this.p + ", endElementOrder=" + this.q + ')';
    }

    public a(long j, long j2, int i, int i2, int i3, int i4, String str, String str2, boolean z, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.a = j;
        this.b = j2;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = str;
        this.h = str2;
        this.i = z;
        this.j = i5;
        this.k = i6;
        this.l = i7;
        this.m = i8;
        this.n = i9;
        this.o = i10;
        this.p = i11;
        this.q = i12;
    }
}
