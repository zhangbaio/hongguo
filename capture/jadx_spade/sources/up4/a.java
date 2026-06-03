package up4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.ugc.model.TruncateFlag;
import com.dragon.read.kmp.utils.v;
import com.dragon.read.kmp.utils.w;
import gd4.e;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import yo4.b;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(609374);
        a = new a();
    }

    private a() {
    }

    /* renamed from: up4.a$a, reason: collision with other inner class name */
    public static final class C0277a implements b {
        final /* synthetic */ zo4.a a;

        @Override // yo4.b
        public int a() {
            return 0;
        }

        @Override // yo4.b
        public int d() {
            return -1;
        }

        @Override // yo4.b
        public String b() {
            return this.a.h;
        }

        @Override // yo4.b
        public String c() {
            return b.a.c(this);
        }

        @Override // yo4.b
        public List<String> e() {
            return b.a.a(this);
        }

        @Override // yo4.b
        public String getBookId() {
            return this.a.e;
        }

        @Override // yo4.b
        public Integer getCreationStatus() {
            return -1;
        }

        @Override // yo4.b
        public Integer getGenreType() {
            return this.a.g;
        }

        @Override // yo4.b
        public String getGroupId() {
            return this.a.f;
        }

        @Override // yo4.b
        public String getPostId() {
            return this.a.d;
        }

        C0277a(zo4.a aVar) {
            this.a = aVar;
        }
    }

    public final void d() {
        gd4.b.a.c("preload_story");
    }

    public final zo4.a a() {
        e b = gd4.b.a.b("preload_story");
        if (b instanceof zo4.a) {
            return (zo4.a) b;
        }
        return null;
    }

    public final com.dragon.read.kmp.story.impl.feeds.data.e b() {
        String str;
        TruncateFlag truncateFlag;
        zo4.a a2 = a();
        TruncateFlag truncateFlag2 = null;
        if (a2 == null || (str = a2.d) == null) {
            return null;
        }
        String str2 = a2.k;
        if (str2 == null && (str2 = c(a2.j)) == null) {
            return null;
        }
        com.dragon.read.kmp.story.impl.feeds.data.e eVar = new com.dragon.read.kmp.story.impl.feeds.data.e(str, new C0277a(a2));
        eVar.d = a2.i;
        Integer num = a2.l;
        if (num != null) {
            truncateFlag = com.dragon.read.kmp.story.impl.b.e(num.intValue());
        } else {
            truncateFlag = null;
        }
        eVar.h = truncateFlag;
        eVar.j = a2.m;
        String str3 = a2.f;
        String str4 = "";
        if (str3 == null) {
            str3 = "";
        }
        com.dragon.read.kmp.story.impl.feeds.data.a aVar = new com.dragon.read.kmp.story.impl.feeds.data.a(str3);
        aVar.b = 0;
        String str5 = a2.i;
        if (str5 != null) {
            str4 = str5;
        }
        aVar.a(str4);
        aVar.b(str2);
        eVar.f.add(aVar);
        Integer num2 = a2.l;
        if (num2 != null) {
            truncateFlag2 = com.dragon.read.kmp.story.impl.b.e(num2.intValue());
        }
        eVar.h = truncateFlag2;
        return eVar;
    }

    public final void e(zo4.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        gd4.b.a.d("preload_story", data);
    }

    private final String c(String str) {
        boolean z;
        JsonObject e;
        String f;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        JsonObject jsonObject = null;
        if (z) {
            return null;
        }
        JsonElement g = v.a.g(str);
        if (g instanceof JsonObject) {
            jsonObject = (JsonObject) g;
        }
        if (jsonObject != null && (e = w.e(jsonObject, "skeleton")) != null && (f = w.f(e, "data", "")) != null) {
            str = f;
        }
        return "<body>" + str + "</body>";
    }
}
