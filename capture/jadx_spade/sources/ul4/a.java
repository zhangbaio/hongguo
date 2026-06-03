package ul4;

import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.ugc.model.us;
import com.dragon.read.kmp.utils.i0;
import com.dragon.read.kmp.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends bl4.a {
    public static final int e;
    public final String c;
    private final cc4.a d;

    static {
        Covode.recordClassIndex(608198);
        e = 8;
    }

    public Object O() {
        return this.d;
    }

    @Override // bl4.a
    public org.jetbrains.compose.resources.b E() {
        return b4.m0(d4.a);
    }

    @Override // bl4.a
    public String I() {
        return G();
    }

    @Override // bl4.a
    public String y() {
        return this.d.b;
    }

    @Override // bl4.a
    public String A() {
        return B(M());
    }

    @Override // bl4.a
    public String C() {
        cc4.a aVar = this.d;
        if (aVar.M) {
            return aVar.f;
        }
        return null;
    }

    @Override // bl4.a
    public String F() {
        return i0.a.i(String.valueOf(this.d.g));
    }

    @Override // bl4.a
    public String G() {
        cc4.a aVar = this.d;
        if (aVar.M) {
            return aVar.a;
        }
        return aVar.f;
    }

    @Override // bl4.a
    public String K() {
        cc4.a aVar = this.d;
        if (aVar.M) {
            return aVar.L;
        }
        return aVar.s;
    }

    @Override // bl4.a
    public VideoContentType M() {
        return s.b(this.d.v);
    }

    @Override // bl4.a
    public String z() {
        cc4.a aVar = this.d;
        if (aVar.M) {
            return null;
        }
        return aVar.f;
    }

    @Override // bl4.a
    public List<String> J() {
        List list = this.d.b0;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            String str = ((us) it2.next()).a;
            if (str == null) {
                str = "";
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // bl4.a
    public String L() {
        if (this.d.v == VideoContentType.Movie.getValue() || this.d.v == VideoContentType.TelePlay.getValue() || this.d.t <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((char) 31532);
        sb.append(this.d.t);
        sb.append((char) 38598);
        return sb.toString();
    }

    @Override // bl4.a
    public ym4.a w(int i) {
        boolean z;
        ym4.a w = super.w(i);
        w.g("profile_tab_name", "profile_liked_video");
        w.g("profile_user_id", this.c);
        w.g("side_title", CollectionsKt___CollectionsKt.joinToString$default(J(), "·", null, null, 0, null, null, 62, null));
        boolean z2 = true;
        if (L().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            w.g("upper_right_info", L());
        }
        if (F().length() <= 0) {
            z2 = false;
        }
        if (z2) {
            w.g("lower_right_info", F());
        }
        return w;
    }

    public a(String targetUserId, cc4.a videoLikeModel) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(videoLikeModel, "videoLikeModel");
        this.c = targetUserId;
        this.d = videoLikeModel;
    }
}
