package lm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.properties.PropertyName;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class h {
    public static final g b;
    public static final int c;
    private static final f d;
    private static final a e;
    private static final d f;
    private static final c g;
    private static final b h;
    private static final e i;
    public final Map<PropertyName, com.dragon.read.kmp.b> a;

    public static final class g {
        static {
            Covode.recordClassIndex(608484);
        }

        private g() {
        }

        public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract void update(cm4.i iVar);

    public abstract void update(pm4.h hVar);

    public static final class a extends lm4.c {
        a() {
        }
    }

    public static final class b extends lm4.d {
        b() {
        }
    }

    public static final class c extends lm4.f {
        c() {
        }
    }

    public static final class d extends lm4.g {
        d() {
        }
    }

    public static final class e extends i {
        e() {
        }
    }

    public static final class f extends j {
        f() {
        }
    }

    public final lm4.c a() {
        com.dragon.read.kmp.b d2 = d(PropertyName.Background);
        Intrinsics.checkNotNull(d2, "null cannot be cast to non-null type com.dragon.read.kmp.reader.properties.IBackgroundProperty");
        return (lm4.c) d2;
    }

    public final lm4.d b() {
        com.dragon.read.kmp.b d2 = d(PropertyName.Font);
        Intrinsics.checkNotNull(d2, "null cannot be cast to non-null type com.dragon.read.kmp.reader.properties.IFontProperty");
        return (lm4.d) d2;
    }

    public final lm4.f c() {
        com.dragon.read.kmp.b d2 = d(PropertyName.LineSpacing);
        Intrinsics.checkNotNull(d2, "null cannot be cast to non-null type com.dragon.read.kmp.reader.properties.ILineSpacingProperty");
        return (lm4.f) d2;
    }

    public final lm4.g e() {
        com.dragon.read.kmp.b d2 = d(PropertyName.PageTurnMode);
        Intrinsics.checkNotNull(d2, "null cannot be cast to non-null type com.dragon.read.kmp.reader.properties.IPageTurnModeProperty");
        return (lm4.g) d2;
    }

    public final i f() {
        com.dragon.read.kmp.b d2 = d(PropertyName.Setting);
        Intrinsics.checkNotNull(d2, "null cannot be cast to non-null type com.dragon.read.kmp.reader.properties.ISettingProperty");
        return (i) d2;
    }

    public final j g() {
        com.dragon.read.kmp.b d2 = d(PropertyName.Theme);
        Intrinsics.checkNotNull(d2, "null cannot be cast to non-null type com.dragon.read.kmp.reader.properties.IThemeProperty");
        return (j) d2;
    }

    static {
        Covode.recordClassIndex(608483);
        b = new g(null);
        c = 8;
        d = new f();
        e = new a();
        f = new d();
        g = new c();
        h = new b();
        i = new e();
    }

    public h() {
        di6.e eVar = new di6.e();
        this.a = eVar;
        eVar.put(PropertyName.Theme, d);
        eVar.put(PropertyName.Background, e);
        eVar.put(PropertyName.PageTurnMode, f);
        eVar.put(PropertyName.LineSpacing, g);
        eVar.put(PropertyName.Font, h);
        eVar.put(PropertyName.Setting, i);
    }

    public k h() {
        int g2 = g().g();
        int d2 = c().d();
        lm4.d b2 = b();
        lm4.g e2 = e();
        int c2 = e2.c();
        return new k(b2.c(), g2, c2, d2, b2.f(), b2.h(), e2.b(), e2.d(), a().e(), f().t(), f().q());
    }

    public com.dragon.read.kmp.b d(PropertyName key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.a.get(key);
    }
}
