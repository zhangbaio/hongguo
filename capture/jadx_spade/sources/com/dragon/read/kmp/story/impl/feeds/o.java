package com.dragon.read.kmp.story.impl.feeds;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.utils.StringUtilsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class o {
    public static final o a;
    private static final xn0.b b;
    public static final int c;

    private o() {
    }

    private final int j() {
        return b.getInt("total_show_bottom_scroll_guide", 0);
    }

    public final void e() {
        b.c("user_has_enter_story_page", 0);
    }

    public final long g() {
        return b.getLong("story_exit_alert_last_count_date", -1L);
    }

    public final void m() {
        b.d("user_has_enter_story_inside_feed", true);
    }

    public final void n() {
        xn0.b bVar = b;
        bVar.c("user_has_enter_story_page", bVar.getInt("user_has_enter_story_page", 0) + 1);
    }

    static {
        Covode.recordClassIndex(609227);
        a = new o();
        b = xn0.c.a("Community-Frequency");
        c = 8;
    }

    private final int h(String str) {
        return b.getInt(f(str), 0);
    }

    private final int i(String str) {
        String takeIfNotEmpty = StringUtilsKt.takeIfNotEmpty(str);
        if (takeIfNotEmpty == null) {
            takeIfNotEmpty = "has_show_guide_dialog_count_v657";
        }
        return b.getInt(takeIfNotEmpty, 0);
    }

    public final void p(long j) {
        b.b("story_exit_alert_last_count_date", j);
    }

    private final String f(String str) {
        return "content_show_bottom_scroll_guide" + str;
    }

    public final void b(String contentId) {
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        a(contentId);
        xn0.b bVar = b;
        bVar.c("total_show_bottom_scroll_guide_for_new_user", bVar.getInt("total_show_bottom_scroll_guide_for_new_user", 0) + 1);
    }

    public final void c(String expKey) {
        Intrinsics.checkNotNullParameter(expKey, "expKey");
        String takeIfNotEmpty = StringUtilsKt.takeIfNotEmpty(expKey);
        if (takeIfNotEmpty == null) {
            takeIfNotEmpty = "has_show_guide_dialog_count_v657";
        }
        b.c(takeIfNotEmpty, i(takeIfNotEmpty) + 1);
    }

    public final void o(String expKey) {
        Intrinsics.checkNotNullParameter(expKey, "expKey");
        String takeIfNotEmpty = StringUtilsKt.takeIfNotEmpty(expKey);
        if (takeIfNotEmpty == null) {
            takeIfNotEmpty = "has_show_guide_dialog_count_v657";
        }
        b.c(takeIfNotEmpty, 0);
    }

    public final void a(String contentId) {
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        String f = f(contentId);
        int h = h(contentId) + 1;
        xn0.b bVar = b;
        bVar.c(f, h);
        Unit unit = Unit.INSTANCE;
        bVar.c("total_show_bottom_scroll_guide", a.j() + 1);
    }

    public final boolean l(String expKey, int i) {
        Intrinsics.checkNotNullParameter(expKey, "expKey");
        String takeIfNotEmpty = StringUtilsKt.takeIfNotEmpty(expKey);
        if (takeIfNotEmpty == null) {
            takeIfNotEmpty = "has_show_guide_dialog_count_v657";
        }
        if (i(takeIfNotEmpty) >= i) {
            return true;
        }
        return false;
    }

    public final boolean k(String contentId, int i, int i2) {
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        if (h(contentId) < i && j() < i2) {
            return false;
        }
        return true;
    }

    public final boolean d(String contentId, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        xn0.b bVar = b;
        boolean z = bVar.getBoolean("user_has_enter_story_inside_feed", false);
        int i4 = bVar.getInt("user_has_enter_story_page", 0);
        int i5 = bVar.getInt("total_show_bottom_scroll_guide_for_new_user", 0);
        if (z || i4 < i || h(contentId) >= i2 || i5 >= i3) {
            return false;
        }
        return true;
    }
}
