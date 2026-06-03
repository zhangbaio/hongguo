package jl6;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.AbsPlayList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class e {
    public final boolean a;
    public final int b;
    public final PlayAddress c;
    public final AbsPlayList d;
    public final String e;
    public final int f;
    public final int g;
    public final int h;
    public final boolean i;

    static {
        Covode.recordClassIndex(655926);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (this.a == eVar.a) {
                    if ((this.b == eVar.b) && Intrinsics.areEqual(this.c, eVar.c) && Intrinsics.areEqual(this.d, eVar.d) && Intrinsics.areEqual(this.e, eVar.e)) {
                        if (this.f == eVar.f) {
                            if (this.g == eVar.g) {
                                if (this.h == eVar.h) {
                                    if (this.i == eVar.i) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    public int hashCode() {
        boolean z = this.a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = ((r0 * 31) + this.b) * 31;
        PlayAddress playAddress = this.c;
        int hashCode = (i + (playAddress != null ? playAddress.hashCode() : 0)) * 31;
        AbsPlayList absPlayList = this.d;
        int hashCode2 = (hashCode + (absPlayList != null ? absPlayList.hashCode() : 0)) * 31;
        String str = this.e;
        int hashCode3 = (((((((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.f) * 31) + this.g) * 31) + this.h) * 31;
        boolean z2 = this.i;
        return hashCode3 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "RespOfPlayAddress(result=" + this.a + ", playerType=" + this.b + ", playAddress=" + this.c + ", playList=" + this.d + ", itemId=" + this.e + ", playTone=" + this.f + ", bgNoiseId=" + this.g + ", code=" + this.h + ", isFromCache=" + this.i + ")";
    }

    public e(boolean z, int i, PlayAddress playAddress, AbsPlayList absPlayList, String str, int i2, int i3, int i4, boolean z2) {
        this.a = z;
        this.b = i;
        this.c = playAddress;
        this.d = absPlayList;
        this.e = str;
        this.f = i2;
        this.g = i3;
        this.h = i4;
        this.i = z2;
    }
}
