package wj4;

import androidx.compose.animation.m;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.UserPreferenceScene;
import com.bytedance.kmp.reading.model.j00;
import com.bytedance.kmp.reading.model.k00;
import gk4.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c implements f {
    public static final int g;
    public final UserPreferenceScene a;
    public final Integer b;
    public final boolean c;
    public final k00 d;
    public final List<j00> e;
    public final long f;

    static {
        Covode.recordClassIndex(607712);
        g = 8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && Intrinsics.areEqual(this.b, cVar.b) && this.c == cVar.c && Intrinsics.areEqual(this.d, cVar.d) && Intrinsics.areEqual(this.e, cVar.e) && this.f == cVar.f;
    }

    public int hashCode() {
        UserPreferenceScene userPreferenceScene = this.a;
        int hashCode = (userPreferenceScene == null ? 0 : userPreferenceScene.hashCode()) * 31;
        Integer num = this.b;
        int hashCode2 = (((hashCode + (num == null ? 0 : num.hashCode())) * 31) + m.a(this.c)) * 31;
        k00 k00Var = this.d;
        int hashCode3 = (hashCode2 + (k00Var == null ? 0 : k00Var.hashCode())) * 31;
        List<j00> list = this.e;
        return ((hashCode3 + (list != null ? list.hashCode() : 0)) * 31) + j.a(this.f);
    }

    public String toString() {
        return "WatchPreferencePageParams(userPreferenceScene=" + this.a + ", originGender=" + this.b + ", isDoubleGender=" + this.c + ", genderSelectData=" + this.d + ", preferenceDataList=" + this.e + ", launchTimeMs=" + this.f + ')';
    }

    @Override // gk4.f
    public long a() {
        return this.f;
    }

    public c(UserPreferenceScene userPreferenceScene, Integer num, boolean z, k00 k00Var, List<j00> list, long j) {
        this.a = userPreferenceScene;
        this.b = num;
        this.c = z;
        this.d = k00Var;
        this.e = list;
        this.f = j;
    }
}
