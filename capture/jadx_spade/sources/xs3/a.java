package xs3;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.covode.number.Covode;
import com.dragon.read.asyncinflate.PreloadViewInfo;
import com.dragon.read.asyncinflate.e;
import com.dragon.read.component.shortvideo.api.config.SingleTabSwipeStyleV715;
import com.dragon.read.component.shortvideo.api.config.ssconfig.SingleFeedPlayTimeOptV651;
import java.util.Map;
import k44.e0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a extends e {
    public static final a x;

    public boolean j() {
        return true;
    }

    public String p() {
        return "VideoPlayerHolderModule";
    }

    public boolean y() {
        return true;
    }

    private a() {
    }

    public void H() {
        e();
    }

    private final String I() {
        if (SingleTabSwipeStyleV715.a.c().enableXmlPreload) {
            return "player_short_series_panel_v2";
        }
        return "player_short_series_panel";
    }

    private final int J() {
        if (SingleTabSwipeStyleV715.a.c().enableXmlPreload) {
            return 2131036412;
        }
        return 2131036411;
    }

    static {
        Covode.recordClassIndex(599171);
        a aVar = new a();
        x = aVar;
        int J = aVar.J();
        ((e) aVar).j.put(Integer.valueOf(J), new PreloadViewInfo.a().e(J).c("short_series_single_fragment").f(1).b());
        if (SingleFeedPlayTimeOptV651.a.b()) {
            ((e) aVar).j.put(2131036391, new PreloadViewInfo.a().e(2131036391).c("fragment_series_book_mall_tab").f(1).b());
        }
        ((e) aVar).j.put(2131039292, new PreloadViewInfo.a().e(2131039292).c("short_series_single_holder").f(5).b());
        e0 e0Var = e0.a;
        int M3 = e0Var.k().M3();
        if (M3 != -1) {
            ((e) aVar).j.put(Integer.valueOf(M3), new PreloadViewInfo.a().e(M3).c("player_short_series_mask").f(5).a(true).b());
        }
        int J4 = e0Var.k().J4();
        if (J4 != -1) {
            ((e) aVar).j.put(Integer.valueOf(J4), new PreloadViewInfo.a().e(J4).c(aVar.I()).f(5).a(true).b());
        }
        int i2 = e0Var.k().i2();
        if (i2 != -1) {
            ((e) aVar).j.put(Integer.valueOf(i2), new PreloadViewInfo.a().e(i2).c("player_short_series_tool_bar").f(5).a(true).b());
        }
        int Y0 = e0Var.k().Y0();
        if (Y0 != -1) {
            ((e) aVar).j.put(Integer.valueOf(Y0), new PreloadViewInfo.a().e(Y0).c("player_short_series_drag_tips").f(5).a(true).b());
        }
        int h2 = e0Var.k().h2();
        if (h2 != -1) {
            ((e) aVar).j.put(Integer.valueOf(h2), new PreloadViewInfo.a().e(h2).c("player_short_series_drag_seek").f(5).a(true).b());
        }
        int x4 = e0Var.k().x4();
        if (x4 != 1) {
            ((e) aVar).j.put(Integer.valueOf(x4), new PreloadViewInfo.a().e(x4).c("player_short_series_force_layer").f(5).a(true).b());
        }
        int q3 = e0Var.k().q3();
        if (q3 != -1) {
            ((e) aVar).j.put(Integer.valueOf(q3), new PreloadViewInfo.a().e(q3).c("player_short_series_error_layer").f(5).a(true).b());
        }
        int G0 = e0Var.k().G0();
        if (G0 != -1) {
            ((e) aVar).j.put(Integer.valueOf(G0), new PreloadViewInfo.a().e(G0).c("player_short_series_seek_bar").f(5).a(true).b());
        }
        int r3 = e0Var.k().r3();
        if (r3 != -1) {
            ((e) aVar).j.put(Integer.valueOf(r3), new PreloadViewInfo.a().e(r3).c("player_short_series_speed_tips").f(5).a(true).b());
        }
        Map<Integer, PreloadViewInfo> b0 = e0Var.k().b0();
        if (!b0.isEmpty()) {
            ((e) aVar).j.putAll(b0);
        }
    }

    public boolean x(Context context) {
        return context instanceof AppCompatActivity;
    }
}
