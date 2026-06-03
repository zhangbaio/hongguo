package lm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.reader.background.ReaderBgColorType;
import ec4.c0;
import ec4.w;
import ec4.y;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends c {
    public static final int k;
    private final gj4.a h;
    private int i;
    private long j;

    static {
        Covode.recordClassIndex(608476);
        k = 8;
    }

    @Override // lm4.c
    public int h() {
        return this.h.getInt(i("key_reader_last_bg_type"), 0);
    }

    @Override // lm4.c
    public boolean k() {
        return this.h.getBoolean("is_first_change_theme_in_custom", true);
    }

    @Override // lm4.c
    public boolean m() {
        return this.h.getBoolean("key_is_show_custom_bg", false);
    }

    public long v() {
        long j = this.h.getLong("key_setting_background_hint_show_timestamp", 0L);
        this.j = j;
        return j;
    }

    @Override // lm4.c
    public boolean a() {
        if (c0.Companion.b().b) {
            return false;
        }
        return !u();
    }

    @Override // lm4.c
    public boolean l() {
        if (w.Companion.a().a && ReaderBgColorType.Companion.a(e()) != ReaderBgColorType.STANDARD) {
            return true;
        }
        return false;
    }

    @Override // lm4.c
    public void t() {
        o(this.h.getInt(g("key_reader_bg_type"), 0));
    }

    public boolean u() {
        if (!y.Companion.a().c) {
            return this.h.getBoolean("key_background_holder_hint_show", false);
        }
        return true;
    }

    @Override // lm4.c
    public int e() {
        this.i = this.h.getInt(i("key_reader_bg_type"), 0);
        if (!w.Companion.a().a && this.i > 3) {
            this.i = 0;
        }
        if (!ec4.a.Companion.a().a && this.i > 7) {
            this.i = 0;
        }
        return this.i;
    }

    @Override // lm4.c
    public boolean b() {
        if (y.Companion.a().c) {
            return false;
        }
        dm4.q qVar = dm4.q.b;
        if (qVar.isBasicMode() || qVar.isPadDevice() || qVar.isFoldDevice() || c0.Companion.b().b) {
            return false;
        }
        long v = v();
        if (v == 0) {
            return true;
        }
        if (v < 0 || u() || com.dragon.read.kmp.utils.o.a.b(v, Clock.System.INSTANCE.now().toEpochMilliseconds()) >= 3) {
            return false;
        }
        return true;
    }

    public a(gj4.a preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.h = preferences;
    }

    @Override // lm4.c
    public void p(boolean z) {
        this.h.edit().putBoolean("is_first_change_theme_in_custom", z).apply();
    }

    @Override // lm4.c
    public void q(boolean z) {
        this.h.edit().putBoolean("key_background_holder_hint_show", z).apply();
    }

    @Override // lm4.c
    public void s(boolean z) {
        gj4.b edit = this.h.edit();
        edit.putBoolean("key_is_show_custom_bg", z);
        edit.apply();
    }

    @Override // lm4.c
    public void r(long j) {
        if (this.j == 0) {
            this.h.edit().putLong("key_setting_background_hint_show_timestamp", j).apply();
        }
    }

    @Override // lm4.c
    public void d(j themeProperty) {
        boolean z;
        Intrinsics.checkNotNullParameter(themeProperty, "themeProperty");
        if (m() && ec4.g.Companion.b().a) {
            boolean z2 = true;
            if (themeProperty.g() == 5) {
                z = true;
            } else {
                z = false;
            }
            if (themeProperty.c() != 5) {
                z2 = false;
            }
            if ((z && z2) || (!z && !z2)) {
                o(-1);
                s(false);
            }
        }
    }

    @Override // lm4.c
    public void o(int i) {
        this.a.d("当前背景是:" + this.i + ", 更新后是：" + i);
        gj4.b edit = this.h.edit();
        if (i == -1 && this.i != -1) {
            edit.putInt(i("key_reader_last_bg_type"), this.i);
        }
        this.i = i;
        edit.putInt(i("key_reader_bg_type"), i);
        edit.apply();
    }
}
