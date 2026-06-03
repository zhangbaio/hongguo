package gk4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.x30;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i0 {
    public static final a d;
    public static final int e;
    public String a = "";
    public List<String> b = new ArrayList();
    public List<String> c = new ArrayList();

    static {
        Covode.recordClassIndex(607828);
        d = new a(null);
        e = 8;
    }

    public final void a(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.c = list;
    }

    public final void b(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.b = list;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.a = str;
    }

    public static final class a {
        static {
            Covode.recordClassIndex(607829);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i0 a(x30 videoTagInfo) {
            Intrinsics.checkNotNullParameter(videoTagInfo, "videoTagInfo");
            i0 i0Var = new i0();
            String str = videoTagInfo.a;
            if (str == null) {
                str = "";
            }
            i0Var.c(str);
            List list = videoTagInfo.b;
            List list2 = null;
            if (list != null) {
                if (!(!list.isEmpty())) {
                    list = null;
                }
                if (list != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(list);
                    i0Var.b(arrayList);
                }
            }
            List list3 = videoTagInfo.c;
            if (list3 != null) {
                if (!list3.isEmpty()) {
                    list2 = list3;
                }
                if (list2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(list2);
                    i0Var.a(arrayList2);
                }
            }
            return i0Var;
        }
    }
}
