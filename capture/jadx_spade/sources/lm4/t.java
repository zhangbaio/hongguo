package lm4;

import com.bytedance.covode.number.Covode;
import ec4.c0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class t extends j {
    public static final int i;
    private final gj4.a g;
    private int h;

    static {
        Covode.recordClassIndex(608497);
        i = 8;
    }

    @Override // lm4.j
    public void h() {
        p(true);
    }

    @Override // lm4.j
    public int c() {
        return this.g.getInt("reader_custom_bg_theme", 1);
    }

    @Override // lm4.j
    public int d() {
        return this.g.getInt("reader_lib_reader_dark_theme", 5);
    }

    @Override // lm4.j
    public boolean f() {
        return this.g.getBoolean("key_intelligent_theme", true);
    }

    @Override // lm4.j
    public int g() {
        return this.g.getInt("reader_lib_theme", 2);
    }

    public boolean m() {
        return this.g.getBoolean("key_has_reader_dark_theme_changed", false);
    }

    public long n() {
        return this.g.getLong("key_setting_theme_hint_show_timestamp", 0L);
    }

    @Override // lm4.j
    public void b() {
        int e;
        o();
        if (dm4.t.b.isDarkSkin()) {
            e = d();
        } else {
            e = e();
        }
        l(e);
    }

    @Override // lm4.j
    public int e() {
        return this.g.getInt("reader_lib_reader_day_theme", im4.c.t.a().c);
    }

    @Override // lm4.j
    public boolean a() {
        if (!c0.Companion.b().b) {
            return false;
        }
        long n = n();
        if (n == 0) {
            return true;
        }
        if (n < 0 || com.dragon.read.kmp.utils.o.a.b(n, Clock.System.INSTANCE.now().toEpochMilliseconds()) >= 3) {
            return false;
        }
        return true;
    }

    private final void o() {
        int g = g();
        this.a.d("处理主题切换逻辑");
        c0.b bVar = c0.Companion;
        if (bVar.a().a && bVar.a().c > 0 && !m()) {
            int i2 = (bVar.b().c - 1) + 5;
            if (pm4.q.a.a(i2)) {
                gj4.b edit = this.g.edit();
                edit.putInt("reader_lib_reader_dark_theme", i2);
                edit.apply();
            }
            this.a.d("命中更多夜间模式实验, 夜间默认landing到: " + bVar.b().c);
        }
        if (!bVar.a().a) {
            gj4.b edit2 = this.g.edit();
            edit2.putInt("reader_lib_reader_dark_theme", 5);
            edit2.apply();
            this.a.d("未命中更多夜间模式实验，夜间切回默认主题black1");
        }
        if (pm4.q.a.a(g)) {
            g = d();
        }
        this.a.d("当前主题是: " + g() + ", 预期更新主题为: " + g);
        l(g);
    }

    public t(gj4.a preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.g = preferences;
    }

    @Override // lm4.j
    public void i(int i2) {
        this.g.edit().putInt("reader_custom_bg_theme", i2).apply();
    }

    @Override // lm4.j
    public void j(boolean z) {
        this.g.edit().putBoolean("key_intelligent_theme", z).apply();
    }

    public void p(boolean z) {
        this.g.edit().putBoolean("key_has_reader_dark_theme_changed", z).apply();
    }

    @Override // lm4.j
    public void k(long j) {
        long j2 = this.g.getLong("key_setting_theme_hint_show_timestamp", 0L);
        if (c0.Companion.b().b) {
            if (j2 > 0 || j >= 0) {
                this.g.edit().putLong("key_setting_theme_hint_show_timestamp", j).apply();
            }
        }
    }

    @Override // lm4.j
    public void l(int i2) {
        gj4.b edit = this.g.edit();
        this.a.d("当前主题是: " + this.h + ", 更新主题是: " + i2);
        if (this.h != i2) {
            this.h = i2;
            edit.putInt("reader_lib_theme", i2);
            if (!pm4.q.a.a(i2)) {
                edit.putInt("reader_lib_reader_day_theme", i2);
            } else {
                edit.putInt("reader_lib_reader_dark_theme", i2);
            }
            edit.apply();
        }
    }
}
