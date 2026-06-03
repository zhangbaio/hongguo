package lm4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmprpc.reader.saas.model.BookmarkLineType;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class s extends i {
    public static final int D;
    private final gj4.a B;
    private final CoroutineScope C;

    static {
        Covode.recordClassIndex(608496);
        D = 8;
    }

    @Override // lm4.i
    public int a() {
        return this.B.getInt("key_auto_listen_read_sync", 0);
    }

    @Override // lm4.i
    public int b() {
        return this.B.getInt("key_lock_screen_time", 0);
    }

    @Override // lm4.i
    public int c() {
        return this.B.getInt("key_screen_brightness", -1);
    }

    @Override // lm4.i
    public int d() {
        return this.B.getInt("key_reader_catalog_mode", 0);
    }

    @Override // lm4.i
    public boolean e() {
        return this.B.getBoolean("key_show_listen_read_sync_tip_click", false);
    }

    @Override // lm4.i
    public boolean f() {
        return this.B.getBoolean("key_show_listen_read_sync_tip_start", false);
    }

    @Override // lm4.i
    public boolean g() {
        return this.B.getBoolean("key_show_bookmark_guide_pull_down", false);
    }

    @Override // lm4.i
    public boolean h() {
        return this.B.getBoolean("key_has_show_note_card", false);
    }

    @Override // lm4.i
    public int i() {
        return this.B.getInt("key_highlight_enabled", 0);
    }

    @Override // lm4.i
    public int j() {
        return this.B.getInt("key_reader_progress_type", 0);
    }

    @Override // lm4.i
    public boolean k() {
        return this.B.getBoolean("key_reader_underline_is_public", true);
    }

    @Override // lm4.i
    public int l() {
        return this.B.getInt("key_pull_down_add_bookmark", 0);
    }

    @Override // lm4.i
    public int m() {
        return this.B.getInt("key_reader_underline_type", BookmarkLineType.StraightLine.getValue());
    }

    @Override // lm4.i
    public int n() {
        return this.B.getInt("key_show_title_play_button", 0);
    }

    @Override // lm4.i
    public boolean o() {
        if (a() != 2) {
            return true;
        }
        return false;
    }

    @Override // lm4.i
    public boolean p() {
        return this.B.getBoolean("key_download_red_rect_have_been_shown", false);
    }

    @Override // lm4.i
    public boolean q() {
        return this.B.getBoolean("reader_lib_key_is_eye_protect_open", false);
    }

    @Override // lm4.i
    public boolean r() {
        return this.B.getBoolean("key_left_exit_reader", true);
    }

    @Override // lm4.i
    public boolean s() {
        return this.B.getBoolean("key_one_hand_turn_page", false);
    }

    @Override // lm4.i
    public boolean t() {
        return this.B.getBoolean("key_reader_content_pic_switch", true);
    }

    @Override // lm4.i
    public boolean u() {
        return this.B.getBoolean("key_phone_flexation_status", false);
    }

    @Override // lm4.i
    public boolean v() {
        return this.B.getBoolean("show_bottom_content", true);
    }

    @Override // lm4.i
    public boolean w() {
        return this.B.getBoolean("key_left_exit_tip_reader", false);
    }

    @Override // lm4.i
    public boolean x() {
        return this.B.getBoolean("key_show_read_status_toolbar", true);
    }

    @Override // lm4.i
    public boolean y() {
        return this.B.getBoolean("key_volume_key_page_turn", true);
    }

    @Override // lm4.i
    public void A(int i) {
        this.B.edit().putInt("key_lock_screen_time", i).apply();
    }

    @Override // lm4.i
    public void B(int i) {
        this.B.edit().putInt("key_screen_brightness", i).apply();
    }

    @Override // lm4.i
    public void C(int i) {
        this.B.edit().putInt("key_reader_catalog_mode", i).apply();
    }

    @Override // lm4.i
    public void D(boolean z) {
        this.B.edit().putBoolean("key_download_red_rect_have_been_shown", z).apply();
    }

    @Override // lm4.i
    public void E(boolean z) {
        this.B.edit().putBoolean("reader_lib_key_is_eye_protect_open", z).apply();
    }

    @Override // lm4.i
    public void F(boolean z) {
        this.B.edit().putBoolean("key_show_listen_read_sync_tip_click", z).apply();
    }

    @Override // lm4.i
    public void G(boolean z) {
        this.B.edit().putBoolean("key_show_listen_read_sync_tip_start", z).apply();
    }

    @Override // lm4.i
    public void H(boolean z) {
        this.B.edit().putBoolean("key_show_bookmark_guide_pull_down", z).apply();
    }

    @Override // lm4.i
    public void I(boolean z) {
        this.B.edit().putBoolean("key_has_show_note_card", z).apply();
    }

    @Override // lm4.i
    public void J(int i) {
        this.B.edit().putInt("key_highlight_enabled", i).apply();
    }

    @Override // lm4.i
    public void K(boolean z) {
        this.B.edit().putBoolean("key_left_exit_reader", z).apply();
    }

    @Override // lm4.i
    public void L(boolean z) {
        this.B.edit().putBoolean("key_one_hand_turn_page", z).apply();
    }

    @Override // lm4.i
    public void M(int i) {
        this.B.edit().putInt("key_reader_progress_type", i).apply();
    }

    @Override // lm4.i
    public void N(boolean z) {
        this.B.edit().putBoolean("key_reader_underline_is_public", z).apply();
    }

    @Override // lm4.i
    public void O(int i) {
        this.B.edit().putInt("key_pull_down_add_bookmark", i).apply();
    }

    @Override // lm4.i
    public void P(boolean z) {
        this.B.edit().putBoolean("key_reader_content_pic_switch", z).apply();
    }

    @Override // lm4.i
    public void Q(boolean z) {
        this.B.edit().putBoolean("key_phone_flexation_status", z).apply();
    }

    @Override // lm4.i
    public void R(int i) {
        this.B.edit().putInt("key_reader_underline_type", i).apply();
    }

    @Override // lm4.i
    public void T(boolean z) {
        this.B.edit().putBoolean("key_left_exit_tip_reader", z).apply();
    }

    @Override // lm4.i
    public void U(boolean z) {
        this.B.edit().putBoolean("key_show_read_status_toolbar", z).apply();
    }

    @Override // lm4.i
    public void V(int i) {
        this.B.edit().putInt("key_show_title_play_button", i).apply();
    }

    @Override // lm4.i
    public void W(boolean z) {
        this.B.edit().putBoolean("key_volume_key_page_turn", z).apply();
    }

    @Override // lm4.i
    public void z(int i) {
        this.B.edit().putInt("key_auto_listen_read_sync", i).apply();
    }

    public s(gj4.a preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        this.B = preferences;
        this.C = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }

    @Override // lm4.i
    public void S(boolean z) {
        this.B.edit().putBoolean("show_bottom_content", z).apply();
    }
}
