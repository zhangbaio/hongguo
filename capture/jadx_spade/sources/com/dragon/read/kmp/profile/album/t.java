package com.dragon.read.kmp.profile.album;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t {
    public static final int d;
    public final b a;
    public final ProfileAlbumHolderType b;
    public boolean c;

    static {
        Covode.recordClassIndex(608029);
        d = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return Intrinsics.areEqual(this.a, tVar.a) && this.b == tVar.b;
    }

    public int hashCode() {
        b bVar = this.a;
        return ((bVar == null ? 0 : bVar.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ProfileAlbumModel(albumData=" + this.a + ", albumHolderType=" + this.b + ')';
    }

    public t(b bVar, ProfileAlbumHolderType albumHolderType) {
        Intrinsics.checkNotNullParameter(albumHolderType, "albumHolderType");
        this.a = bVar;
        this.b = albumHolderType;
    }

    public /* synthetic */ t(b bVar, ProfileAlbumHolderType profileAlbumHolderType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i & 2) != 0 ? ProfileAlbumHolderType.NormalAlbum : profileAlbumHolderType);
    }
}
