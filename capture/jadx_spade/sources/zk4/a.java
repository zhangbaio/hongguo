package zk4;

import c54.b4;
import c54.d4;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.RecTypeStyle;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.bytedance.kmp.reading.model.a5;
import com.bytedance.kmp.reading.model.e90;
import com.bytedance.kmp.reading.model.om0;
import com.bytedance.kmp.reading.model.qn0;
import com.bytedance.kmp.ugc.model.x30;
import com.dragon.read.kmp.utils.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends bl4.a {
    public static final int e;
    public final String c;
    private final a5 d;

    static {
        Covode.recordClassIndex(608030);
        e = 8;
    }

    @Override // bl4.a
    public String C() {
        return null;
    }

    @Override // bl4.a
    public String L() {
        return null;
    }

    @Override // bl4.a
    public String K() {
        return this.d.d;
    }

    @Override // bl4.a
    public String A() {
        return B(M());
    }

    @Override // bl4.a
    public String F() {
        String str = this.d.z;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // bl4.a
    public String G() {
        om0 om0Var = this.d.a;
        if (om0Var != null) {
            return om0Var.p;
        }
        return null;
    }

    @Override // bl4.a
    public String I() {
        om0 om0Var = this.d.a;
        if (om0Var != null) {
            return om0Var.p;
        }
        return null;
    }

    @Override // bl4.a
    public String y() {
        String str = this.d.c;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // bl4.a
    public String z() {
        om0 om0Var = this.d.a;
        if (om0Var != null) {
            return om0Var.a;
        }
        return null;
    }

    @Override // bl4.a
    public VideoContentType M() {
        Integer num = this.d.h;
        if (num != null) {
            return s.b(num.intValue());
        }
        return null;
    }

    @Override // bl4.a
    public List<String> J() {
        List list = this.d.y;
        if (list != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                String str = ((e90) it2.next()).a;
                if (str == null) {
                    str = "";
                }
                arrayList.add(str);
            }
            return arrayList;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Override // bl4.a
    public x30 N() {
        Object firstOrNull;
        List list = this.d.x;
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            qn0 qn0Var = (qn0) firstOrNull;
            if (qn0Var != null) {
                return new x30(qn0Var.a, qn0Var.b, qn0Var.c, (String) null, (String) null, (Boolean) null, qn0Var.g, qn0Var.h, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (Boolean) null, qn0Var.q, (Integer) null, (String) null, 458552, (DefaultConstructorMarker) null);
            }
        }
        return null;
    }

    @Override // bl4.a
    public org.jetbrains.compose.resources.b E() {
        Integer num = this.d.A;
        int value = RecTypeStyle.HotResing.getValue();
        if (num != null && num.intValue() == value) {
            return b4.w0(d4.a);
        }
        int value2 = RecTypeStyle.Following.getValue();
        if (num != null && num.intValue() == value2) {
            return b4.y0(d4.a);
        }
        int value3 = RecTypeStyle.Popularity.getValue();
        if (num != null && num.intValue() == value3) {
            return b4.v0(d4.a);
        }
        int value4 = RecTypeStyle.HotSearch.getValue();
        if (num != null && num.intValue() == value4) {
            return b4.x0(d4.a);
        }
        return b4.m0(d4.a);
    }

    @Override // bl4.a
    public ym4.a w(int i) {
        boolean z;
        ym4.a w = super.w(i);
        w.g("profile_tab_name", "profile_followed_video");
        w.g("profile_user_id", this.c);
        w.g("upper_right_info", x());
        w.g("cover_url", y());
        w.g("side_title", CollectionsKt___CollectionsKt.joinToString$default(J(), "·", null, null, 0, null, null, 62, null));
        boolean z2 = true;
        if (x().length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            w.g("upper_right_info", x());
        }
        if (F().length() <= 0) {
            z2 = false;
        }
        if (z2) {
            w.g("lower_right_info", F());
        }
        return w;
    }

    public a(String targetUserId, a5 bookshelfVideoData) {
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        Intrinsics.checkNotNullParameter(bookshelfVideoData, "bookshelfVideoData");
        this.c = targetUserId;
        this.d = bookshelfVideoData;
    }
}
