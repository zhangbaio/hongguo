package com.dragon.read.kmp.mine.profile;

import androidx.compose.runtime.MutableState;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.Gender;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a0 {
    public final MutableState<String> a;
    public final MutableState<String> b;
    public final MutableState<VerifyStatus> c;
    public final MutableState<String> d;
    public final MutableState<VerifyStatus> e;
    public final MutableState<Gender> f;
    public final MutableState<String> g;
    public final MutableState<VerifyStatus> h;
    public final MutableState<String> i;
    public final MutableState<VerifyStatus> j;
    public final String k;
    public final MutableState<String> l;
    public final MutableState<String> m;
    public final MutableState<VerifyStatus> n;
    public final MutableState<Boolean> o;
    public final MutableState<String> p;
    public final String q;

    static {
        Covode.recordClassIndex(607733);
    }

    public final a0 a(MutableState<String> avatarUrl, MutableState<String> avatarDecorationUrl, MutableState<VerifyStatus> avatarVerifyStatus, MutableState<String> userName, MutableState<VerifyStatus> userNameVerifyStatus, MutableState<Gender> gender, MutableState<String> description, MutableState<VerifyStatus> descriptionVerifyStatus, MutableState<String> bizUserId, MutableState<VerifyStatus> bizUserIdVerifyStatus, String preferenceList, MutableState<String> profileCoverUrl, MutableState<String> profileCoverUrlColor, MutableState<VerifyStatus> profileCoverVerifyStatus, MutableState<Boolean> forbiddSetUserName, MutableState<String> forbiddSetUserNameReason, String userId) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(avatarDecorationUrl, "avatarDecorationUrl");
        Intrinsics.checkNotNullParameter(avatarVerifyStatus, "avatarVerifyStatus");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userNameVerifyStatus, "userNameVerifyStatus");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(descriptionVerifyStatus, "descriptionVerifyStatus");
        Intrinsics.checkNotNullParameter(bizUserId, "bizUserId");
        Intrinsics.checkNotNullParameter(bizUserIdVerifyStatus, "bizUserIdVerifyStatus");
        Intrinsics.checkNotNullParameter(preferenceList, "preferenceList");
        Intrinsics.checkNotNullParameter(profileCoverUrl, "profileCoverUrl");
        Intrinsics.checkNotNullParameter(profileCoverUrlColor, "profileCoverUrlColor");
        Intrinsics.checkNotNullParameter(profileCoverVerifyStatus, "profileCoverVerifyStatus");
        Intrinsics.checkNotNullParameter(forbiddSetUserName, "forbiddSetUserName");
        Intrinsics.checkNotNullParameter(forbiddSetUserNameReason, "forbiddSetUserNameReason");
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new a0(avatarUrl, avatarDecorationUrl, avatarVerifyStatus, userName, userNameVerifyStatus, gender, description, descriptionVerifyStatus, bizUserId, bizUserIdVerifyStatus, preferenceList, profileCoverUrl, profileCoverUrlColor, profileCoverVerifyStatus, forbiddSetUserName, forbiddSetUserNameReason, userId);
    }

    public String toString() {
        return "KmpUserInfo(avatarUrl=" + this.a + ", avatarDecorationUrl=" + this.b + ", avatarVerifyStatus=" + this.c + ", userName=" + this.d + ", userNameVerifyStatus=" + this.e + ", gender=" + this.f + ", description=" + this.g + ", descriptionVerifyStatus=" + this.h + ", bizUserId=" + this.i + ", bizUserIdVerifyStatus=" + this.j + ", preferenceList=" + this.k + ", profileCoverUrl=" + this.l + ", profileCoverUrlColor=" + this.m + ", profileCoverVerifyStatus=" + this.n + ", forbiddSetUserName=" + this.o + ", forbiddSetUserNameReason=" + this.p + ", userId=" + this.q + ')';
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a0)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        a0 a0Var = (a0) obj;
        if (!Intrinsics.areEqual(this.a.getValue(), a0Var.a.getValue()) || !Intrinsics.areEqual(this.d.getValue(), a0Var.d.getValue()) || this.f.getValue() != a0Var.f.getValue() || !Intrinsics.areEqual(this.g.getValue(), a0Var.g.getValue()) || !Intrinsics.areEqual(this.i.getValue(), a0Var.i.getValue()) || !Intrinsics.areEqual(this.l.getValue(), a0Var.l.getValue())) {
            return false;
        }
        return true;
    }

    public a0(MutableState<String> avatarUrl, MutableState<String> avatarDecorationUrl, MutableState<VerifyStatus> avatarVerifyStatus, MutableState<String> userName, MutableState<VerifyStatus> userNameVerifyStatus, MutableState<Gender> gender, MutableState<String> description, MutableState<VerifyStatus> descriptionVerifyStatus, MutableState<String> bizUserId, MutableState<VerifyStatus> bizUserIdVerifyStatus, String preferenceList, MutableState<String> profileCoverUrl, MutableState<String> profileCoverUrlColor, MutableState<VerifyStatus> profileCoverVerifyStatus, MutableState<Boolean> forbiddSetUserName, MutableState<String> forbiddSetUserNameReason, String userId) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(avatarDecorationUrl, "avatarDecorationUrl");
        Intrinsics.checkNotNullParameter(avatarVerifyStatus, "avatarVerifyStatus");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userNameVerifyStatus, "userNameVerifyStatus");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(descriptionVerifyStatus, "descriptionVerifyStatus");
        Intrinsics.checkNotNullParameter(bizUserId, "bizUserId");
        Intrinsics.checkNotNullParameter(bizUserIdVerifyStatus, "bizUserIdVerifyStatus");
        Intrinsics.checkNotNullParameter(preferenceList, "preferenceList");
        Intrinsics.checkNotNullParameter(profileCoverUrl, "profileCoverUrl");
        Intrinsics.checkNotNullParameter(profileCoverUrlColor, "profileCoverUrlColor");
        Intrinsics.checkNotNullParameter(profileCoverVerifyStatus, "profileCoverVerifyStatus");
        Intrinsics.checkNotNullParameter(forbiddSetUserName, "forbiddSetUserName");
        Intrinsics.checkNotNullParameter(forbiddSetUserNameReason, "forbiddSetUserNameReason");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.a = avatarUrl;
        this.b = avatarDecorationUrl;
        this.c = avatarVerifyStatus;
        this.d = userName;
        this.e = userNameVerifyStatus;
        this.f = gender;
        this.g = description;
        this.h = descriptionVerifyStatus;
        this.i = bizUserId;
        this.j = bizUserIdVerifyStatus;
        this.k = preferenceList;
        this.l = profileCoverUrl;
        this.m = profileCoverUrlColor;
        this.n = profileCoverVerifyStatus;
        this.o = forbiddSetUserName;
        this.p = forbiddSetUserNameReason;
        this.q = userId;
    }
}
