package jl4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.rpc.kmp.community.model.z;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b implements jd4.b {
    public static final int d;
    public final z a;
    public final List<a> b;
    private boolean c;

    static {
        Covode.recordClassIndex(608124);
        d = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Intrinsics.areEqual(this.a, bVar.a) && Intrinsics.areEqual(this.b, bVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ProfileAlbumListItemModel(albumData=" + this.a + ", innerVideoDataList=" + this.b + ')';
    }

    public boolean isShown() {
        return this.c;
    }

    public final boolean a() {
        return !this.b.isEmpty();
    }

    public void setShown(boolean z) {
        this.c = z;
    }

    public b(z albumData, List<a> innerVideoDataList) {
        Intrinsics.checkNotNullParameter(albumData, "albumData");
        Intrinsics.checkNotNullParameter(innerVideoDataList, "innerVideoDataList");
        this.a = albumData;
        this.b = innerVideoDataList;
    }
}
