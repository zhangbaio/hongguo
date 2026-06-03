package lm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.font.Font;
import com.dragon.read.kmp.service.e0;
import ec4.a0;
import ec4.b0;
import ec4.t;
import ec4.x;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class b extends d {
    public static final int n;
    private final gj4.a k;
    private final int l;
    private final int m;

    static {
        Covode.recordClassIndex(608477);
        n = 8;
    }

    private final boolean t() {
        return this.k.getBoolean("key_mark_hint_font_size_changed", false);
    }

    @Override // lm4.d
    public int f() {
        return pn4.a.a(g());
    }

    @Override // lm4.d
    public int g() {
        return this.k.getInt("reader_font_dp_size", this.l);
    }

    public boolean r() {
        return this.k.getBoolean("key_has_reader_text_size_setted", false);
    }

    private final int s() {
        if (!dm4.q.b.isFoldDevice()) {
            t.b bVar = ec4.t.Companion;
            if (bVar.a().a) {
                w(true);
                return bVar.a().b;
            }
        }
        return this.m;
    }

    private final int u() {
        if (!dm4.q.b.isFoldDevice()) {
            a0.b bVar = a0.Companion;
            if (bVar.a().a) {
                w(true);
                return bVar.a().b;
            }
        }
        return this.l;
    }

    @Override // lm4.d
    public Boolean b() {
        if (!this.k.contains("key_has_change_font")) {
            return null;
        }
        return Boolean.valueOf(this.k.getBoolean("key_has_change_font", false));
    }

    @Override // lm4.d
    public String c() {
        gj4.a aVar = this.k;
        Font font = Font.DEFAULT;
        String string = aVar.getString("reader_lib_font_name", font.getFontTitle());
        if (string == null) {
            return font.getFontTitle();
        }
        return string;
    }

    @Override // lm4.d
    public Boolean i() {
        if (!this.k.contains("key_is_traditional_chinese")) {
            return null;
        }
        return Boolean.valueOf(this.k.getBoolean("key_is_traditional_chinese", false));
    }

    private final int v() {
        if (!dm4.q.b.isFoldDevice()) {
            b0.b bVar = b0.Companion;
            if (bVar.a().a) {
                w(true);
                return bVar.a().b;
            }
        }
        return ec4.s.Companion.a().a;
    }

    @Override // lm4.d
    public int h() {
        boolean z;
        boolean z2;
        int f;
        int a;
        int c = pn4.a.c(f());
        boolean z3 = false;
        if (13 <= c && c < 20) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f = f();
            a = pn4.a.a(4);
        } else {
            if (20 <= c && c < 25) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                f = f();
                a = pn4.a.a(3);
            } else {
                if (25 <= c && c < 31) {
                    z3 = true;
                }
                if (z3) {
                    f = f();
                    a = pn4.a.a(2);
                } else {
                    f = f();
                    a = pn4.a.a(1);
                }
            }
        }
        return f + a;
    }

    @Override // lm4.d
    public void a() {
        int i;
        if (!this.k.contains("reader_font_dp_size")) {
            int i2 = this.k.getInt("reader_lib_para_text_size", pn4.a.a(this.l));
            o(pn4.a.c(i2));
            this.a.d("迁移配置：old:" + i2 + ", new:" + g());
        }
        int i3 = this.k.getInt("reader_font_dp_size", this.l);
        if (!r() && ec4.r.Companion.a().a) {
            com.dragon.read.kmp.i iVar = this.a;
            StringBuilder sb = new StringBuilder();
            sb.append("处理字体切换，curTextSize:");
            sb.append(i3);
            sb.append(", scale:");
            e0 e0Var = e0.a;
            sb.append(e0Var.F0().a());
            sb.append(", hint mark:");
            sb.append(t());
            iVar.d(sb.toString());
            dm4.q qVar = dm4.q.b;
            boolean z = true;
            if (qVar.needFitPadScreen() && qVar.isPadDevice()) {
                if (e0Var.F0().c()) {
                    if (q(i3)) {
                        i = x.Companion.a().b;
                        w(!r0.b());
                        i3 = i;
                    }
                } else if (q(i3)) {
                    i = x.Companion.a().c;
                    w(!r0.b());
                    i3 = i;
                }
            } else if (e0Var.F0().b()) {
                if (q(i3)) {
                    i3 = s();
                    w(true);
                }
            } else if (e0Var.F0().d()) {
                if (q(i3)) {
                    i3 = v();
                    if (ec4.s.Companion.b() && b0.Companion.b()) {
                        z = false;
                    }
                    w(z);
                }
            } else if (q(i3)) {
                i3 = u();
            }
        }
        o(x(i3));
    }

    private final void w(boolean z) {
        if (!t()) {
            y(z);
        }
    }

    private final void y(boolean z) {
        this.k.edit().putBoolean("key_mark_hint_font_size_changed", z).apply();
    }

    @Override // lm4.d
    public void n(boolean z) {
        this.k.edit().putBoolean("key_has_reader_text_size_setted", z).apply();
    }

    public b(gj4.a preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.k = preferences;
        this.l = 24;
        this.m = 25;
    }

    private final boolean q(int i) {
        if (i != this.l && i != this.m && !t()) {
            return false;
        }
        return true;
    }

    @Override // lm4.d
    public void m(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.k.edit().putString("reader_lib_font_name", value).apply();
    }

    @Override // lm4.d
    public void l(Boolean bool) {
        if (bool == null) {
            this.k.edit().remove("key_has_change_font").apply();
        } else {
            this.k.edit().putBoolean("key_has_change_font", bool.booleanValue()).apply();
        }
    }

    @Override // lm4.d
    public void p(Boolean bool) {
        if (bool == null) {
            this.k.edit().remove("key_is_traditional_chinese").apply();
        } else {
            this.k.edit().putBoolean("key_is_traditional_chinese", bool.booleanValue()).apply();
        }
    }

    private final int x(int i) {
        this.a.d("curTextSize:" + i);
        Integer[] a = e.a();
        int length = a.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int intValue = a[i2].intValue();
            int intValue2 = a[i2].intValue();
            if (intValue >= i) {
                this.a.d("在综合字号列表中查询到:" + intValue + "，接近或等于当前字号");
                return intValue2;
            }
            i2++;
            i3 = intValue2;
        }
        return i3;
    }

    @Override // lm4.d
    public void o(int i) {
        if (ArraysKt___ArraysKt.contains(e.a(), Integer.valueOf(i))) {
            this.k.edit().putInt("reader_font_dp_size", i).apply();
            return;
        }
        com.dragon.read.kmp.i.c(this.a, "设置字体时，字体编号不在序列里面，value=" + i + ", array=" + e.a(), (Throwable) null, 2, (Object) null);
        this.k.edit().putInt("reader_font_dp_size", x(i)).apply();
    }
}
