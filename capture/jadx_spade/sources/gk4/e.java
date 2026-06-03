package gk4;

import com.bytedance.covode.number.Covode;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class e extends b {
    public static final int i;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public long e;
    public final String f;
    private boolean g;
    private final Lazy h;

    static {
        Covode.recordClassIndex(607792);
        i = 8;
    }

    public boolean isShown() {
        return this.g;
    }

    public void setShown(boolean z) {
        this.g = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String v(e eVar) {
        try {
            return com.dragon.read.kmp.utils.r.a.a(eVar.c);
        } catch (Exception e) {
            com.dragon.read.kmp.j.c(com.dragon.read.kmp.j.a, "ThreeColumnSeriesPostModel", "getVideoSeriesPostFormatTitle=" + e.getMessage(), (Throwable) null, 4, (Object) null);
            return eVar.c;
        }
    }

    public final ym4.a p(int i2, String clickedContent) {
        Intrinsics.checkNotNullParameter(clickedContent, "clickedContent");
        ym4.a aVar = new ym4.a();
        Map<String, Object> i3 = com.dragon.read.kmp.utils.k0.a.b().i();
        if (i3.containsKey("category_name")) {
            aVar.g("category_name", i3.get("category_name"));
        }
        if (i3.containsKey("tab_name")) {
            aVar.g("tab_name", i3.get("tab_name"));
        }
        if (i3.containsKey("first_entrance")) {
            aVar.g("first_entrance", i3.get("first_entrance"));
        }
        aVar.g("card_type", "picture");
        aVar.g("card_title", this.c);
        aVar.g("card_user_id", this.d);
        boolean z = true;
        aVar.g("rank", Integer.valueOf(i2 + 1));
        aVar.g("post_card_id", this.a);
        if (clickedContent.length() <= 0) {
            z = false;
        }
        if (z) {
            aVar.g("clicked_content", clickedContent);
        }
        aVar.g("like_count", Long.valueOf(this.e));
        aVar.g("profile_tab_name", "profile_post");
        aVar.g("profile_user_id", this.f);
        aVar.g("trace_enter_from", "profile_post");
        return aVar;
    }

    public e(String postId, String cover, String title, String authorId, long j, String targetUserId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(postId, "postId");
        Intrinsics.checkNotNullParameter(cover, "cover");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(authorId, "authorId");
        Intrinsics.checkNotNullParameter(targetUserId, "targetUserId");
        this.a = postId;
        this.b = cover;
        this.c = title;
        this.d = authorId;
        this.e = j;
        this.f = targetUserId;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0() { // from class: gk4.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String v;
                v = e.v(e.this);
                return v;
            }
        });
        this.h = lazy;
    }
}
