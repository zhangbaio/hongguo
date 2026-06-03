package lm4;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class n extends g {
    public static final int i;
    private final gj4.a g;
    private int h;

    static {
        Covode.recordClassIndex(608490);
        i = 8;
    }

    @Override // lm4.g
    public int a() {
        return this.g.getInt("reader_lib_auto_read_page_turn_mode", 2);
    }

    @Override // lm4.g
    public int b() {
        return this.g.getInt("reader_lib_key_left_right_auto_page_speed_gear", 3);
    }

    @Override // lm4.g
    public int d() {
        return this.g.getInt("reader_lib_key_auto_page_speed_gear", 3);
    }

    @Override // lm4.g
    public int c() {
        int i2 = this.g.getInt("reader_lib_page_turn_mode", 2);
        if (!pm4.g.a(i2)) {
            return 2;
        }
        return i2;
    }

    public n(gj4.a preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.g = preferences;
    }

    @Override // lm4.g
    public void e(int i2) {
        this.g.edit().putInt("reader_lib_auto_read_page_turn_mode", i2).apply();
    }

    @Override // lm4.g
    public void f(int i2) {
        this.g.edit().putInt("reader_lib_key_left_right_auto_page_speed_gear", i2).apply();
    }

    @Override // lm4.g
    public void h(int i2) {
        this.g.edit().putInt("reader_lib_key_auto_page_speed_gear", i2).apply();
    }

    @Override // lm4.g
    public void g(int i2) {
        this.a.d("当前翻页模式是: " + this.h + ", 更新翻页模式: " + i2);
        if (pm4.g.a(i2)) {
            this.h = i2;
            this.g.edit().putInt("reader_lib_page_turn_mode", i2).apply();
        }
    }
}
