package lm4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l extends f {
    public static final int m;
    private final gj4.a k;
    private int l;

    static {
        Covode.recordClassIndex(608488);
        m = 8;
    }

    @Override // lm4.f
    public float a() {
        return this.k.getFloat("key_custom_space_line_setting", 0.0f);
    }

    @Override // lm4.f
    public float b() {
        return this.k.getFloat("key_custom_space_para_setting", 0.0f);
    }

    @Override // lm4.f
    public boolean c() {
        return this.k.getBoolean("key_has_show_report_page_margin_adapt_dialog", false);
    }

    @Override // lm4.f
    public float e() {
        return this.k.getFloat("key_local_line_space_setting", 0.0f);
    }

    @Override // lm4.f
    public float f() {
        return this.k.getFloat("key_local_para_space_setting", 0.0f);
    }

    @Override // lm4.f
    public int g() {
        return this.k.getInt("key_page_space_setting", 0);
    }

    @Override // lm4.f
    public int h() {
        return this.k.getInt("key_pre_landing_page_margin_mode", -2);
    }

    @Override // lm4.f
    public int d() {
        return Math.min(Math.max(this.k.getInt("reader_lib_key_line_spacing_mode", 1), -1), 2);
    }

    public l(gj4.a preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.k = preferences;
        this.l = 1;
    }

    @Override // lm4.f
    public void j(float f) {
        this.k.edit().putFloat("key_custom_space_line_setting", f).apply();
    }

    @Override // lm4.f
    public void k(float f) {
        this.k.edit().putFloat("key_custom_space_para_setting", f).apply();
    }

    @Override // lm4.f
    public void l(boolean z) {
        this.k.edit().putBoolean("key_has_show_report_page_margin_adapt_dialog", z).apply();
    }

    @Override // lm4.f
    public void n(float f) {
        this.k.edit().putFloat("key_local_line_space_setting", f).apply();
    }

    @Override // lm4.f
    public void o(float f) {
        this.k.edit().putFloat("key_local_para_space_setting", f).apply();
    }

    @Override // lm4.f
    public void p(int i) {
        this.k.edit().putInt("key_page_space_setting", i).apply();
    }

    @Override // lm4.f
    public void q(int i) {
        this.k.edit().putInt("key_pre_page_margin_mode", i).apply();
    }

    @Override // lm4.f
    public void r(int i) {
        this.k.edit().putInt("key_pre_landing_page_margin_mode", i).apply();
    }

    @Override // lm4.f
    public void m(int i) {
        this.l = i;
        this.k.edit().putInt("reader_lib_key_line_spacing_mode", i).apply();
    }
}
