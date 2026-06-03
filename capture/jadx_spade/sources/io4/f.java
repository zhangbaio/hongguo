package io4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f {
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final boolean e;
    public final String f;
    public final Long g;
    public final String h;
    public final String i;

    static {
        Covode.recordClassIndex(609042);
    }

    public f(String userId, String name, String avatarUrl, int i, boolean z, String voteCountLabel, Long l, String iconUrl, String iconDarkUrl) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(voteCountLabel, "voteCountLabel");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(iconDarkUrl, "iconDarkUrl");
        this.a = userId;
        this.b = name;
        this.c = avatarUrl;
        this.d = i;
        this.e = z;
        this.f = voteCountLabel;
        this.g = l;
        this.h = iconUrl;
        this.i = iconDarkUrl;
    }
}
