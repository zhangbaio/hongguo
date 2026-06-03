package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.dragon.read.saas.ugc.model.CommentApiERR;
import com.dragon.read.saas.ugc.model.GetUserProfileResponse;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import seriessdk.com.dragon.read.saas.rpc.model.SaaSVideoDetailData;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final int c;
    public final GetUserProfileResponse a;
    public final HashMap<String, SaaSVideoDetailData> b;

    static {
        Covode.recordClassIndex(599002);
        c = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b);
    }

    public int hashCode() {
        GetUserProfileResponse getUserProfileResponse = this.a;
        int hashCode = (getUserProfileResponse == null ? 0 : getUserProfileResponse.hashCode()) * 31;
        HashMap<String, SaaSVideoDetailData> hashMap = this.b;
        return hashCode + (hashMap != null ? hashMap.hashCode() : 0);
    }

    public String toString() {
        return "MineWorksPreloadResult(response=" + this.a + ", videoDetails=" + this.b + ')';
    }

    public final boolean a() {
        GetUserProfileResponse getUserProfileResponse = this.a;
        if (getUserProfileResponse != null && getUserProfileResponse.code == CommentApiERR.Success && getUserProfileResponse.data != null && this.b != null) {
            return true;
        }
        return false;
    }

    public a(GetUserProfileResponse getUserProfileResponse, HashMap<String, SaaSVideoDetailData> hashMap) {
        this.a = getUserProfileResponse;
        this.b = hashMap;
    }
}
