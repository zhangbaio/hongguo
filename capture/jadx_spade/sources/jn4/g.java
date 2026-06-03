package jn4;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class g {
    public static final int b;
    public final ym4.a a;

    static {
        Covode.recordClassIndex(608784);
        b = ym4.a.b;
    }

    public g(Map<String, ? extends Object> map) {
        ym4.a aVar = new ym4.a();
        this.a = aVar;
        if (map != null) {
            aVar.h(map);
        }
    }

    public final g e(String str) {
        if (str != null) {
            this.a.g("category_name", str);
        }
        return this;
    }

    public final g f(String str) {
        if (str != null) {
            this.a.g("module_name", str);
        }
        return this;
    }

    public final g g(String str) {
        if (str != null) {
            this.a.g("module_rank", str);
        }
        return this;
    }

    public final g h(String str) {
        if (str != null) {
            this.a.g("page_name", str);
        }
        return this;
    }

    public final g i(String str) {
        if (str != null) {
            this.a.g("search_attached_info", str);
        }
        return this;
    }

    public final g j(String str) {
        if (str != null) {
            this.a.g("search_topic_position", str);
        }
        return this;
    }

    public final g k(String str) {
        if (str != null) {
            this.a.g("tab_name", str);
        }
        return this;
    }

    public final g l(String str) {
        if (str != null) {
            this.a.g("topic_position", str);
        }
        return this;
    }

    public final g m(String str) {
        if (str != null) {
            this.a.g("topic_rank", str);
        }
        return this;
    }

    public final g n(String str) {
        if (str != null) {
            this.a.g("type", str);
        }
        return this;
    }

    public final void b(String str, String topicPosition) {
        Intrinsics.checkNotNullParameter(topicPosition, "topicPosition");
        ro4.a aVar = ro4.a.a;
        if (!aVar.b(str)) {
            return;
        }
        a(aVar.a(str), topicPosition);
    }

    public final void d(String str, String topicPosition) {
        Intrinsics.checkNotNullParameter(topicPosition, "topicPosition");
        ro4.a aVar = ro4.a.a;
        if (!aVar.b(str)) {
            return;
        }
        c(aVar.a(str), topicPosition);
    }

    public final void a(String topicId, String topicPosition) {
        Intrinsics.checkNotNullParameter(topicId, "topicId");
        Intrinsics.checkNotNullParameter(topicPosition, "topicPosition");
        this.a.g("topic_id", topicId);
        this.a.g("topic_position", topicPosition);
        o.a.d("click_topic_entrance", this.a);
    }

    public final void c(String topicId, String topicPosition) {
        Intrinsics.checkNotNullParameter(topicId, "topicId");
        Intrinsics.checkNotNullParameter(topicPosition, "topicPosition");
        this.a.g("topic_id", topicId);
        this.a.g("topic_position", topicPosition);
        o.a.d("impr_topic_entrance", this.a);
    }
}
