package fl4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j implements jd4.b {
    public static final int i;
    public final String a;
    public final String b;
    public final String c;
    public int d;
    public final String e;
    public final int f;
    public final boolean g;
    private boolean h;

    static {
        Covode.recordClassIndex(608095);
        i = 8;
    }

    public static /* synthetic */ j b(j jVar, String str, String str2, String str3, int i2, String str4, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = jVar.a;
        }
        if ((i4 & 2) != 0) {
            str2 = jVar.b;
        }
        String str5 = str2;
        if ((i4 & 4) != 0) {
            str3 = jVar.c;
        }
        String str6 = str3;
        if ((i4 & 8) != 0) {
            i2 = jVar.d;
        }
        int i5 = i2;
        if ((i4 & 16) != 0) {
            str4 = jVar.e;
        }
        String str7 = str4;
        if ((i4 & 32) != 0) {
            i3 = jVar.f;
        }
        int i6 = i3;
        if ((i4 & 64) != 0) {
            z = jVar.g;
        }
        return jVar.a(str, str5, str6, i5, str7, i6, z);
    }

    public final j a(String userId, String userAvatar, String userName, int i2, String subInfo, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userAvatar, "userAvatar");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(subInfo, "subInfo");
        return new j(userId, userAvatar, userName, i2, subInfo, i3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return Intrinsics.areEqual(this.a, jVar.a) && Intrinsics.areEqual(this.b, jVar.b) && Intrinsics.areEqual(this.c, jVar.c) && this.d == jVar.d && Intrinsics.areEqual(this.e, jVar.e) && this.f == jVar.f && this.g == jVar.g;
    }

    public int hashCode() {
        return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e.hashCode()) * 31) + this.f) * 31) + androidx.compose.animation.m.a(this.g);
    }

    public String toString() {
        return "RecommendUserItem(userId=" + this.a + ", userAvatar=" + this.b + ", userName=" + this.c + ", relationType=" + this.d + ", subInfo=" + this.e + ", position=" + this.f + ", isPugcAlbumAuthor=" + this.g + ')';
    }

    public boolean isShown() {
        return this.h;
    }

    public void setShown(boolean z) {
        this.h = z;
    }

    public j(String userId, String userAvatar, String userName, int i2, String subInfo, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userAvatar, "userAvatar");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(subInfo, "subInfo");
        this.a = userId;
        this.b = userAvatar;
        this.c = userName;
        this.d = i2;
        this.e = subInfo;
        this.f = i3;
        this.g = z;
    }
}
