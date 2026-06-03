package kl4;

import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.VideoContentType;
import com.dragon.read.kmp.utils.g0;
import com.dragon.read.kmp.utils.k0;
import com.dragon.read.rpc.kmp.community.model.k7;
import com.dragon.read.rpc.kmp.community.model.v6;
import kotlin.jvm.internal.Intrinsics;
import rl4.c;
import rl4.d;
import ym4.o;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a {
    public static final a a;

    static {
        Covode.recordClassIndex(608127);
        a = new a();
    }

    private a() {
    }

    public final void a(boolean z, c tabParams, String albumId, String position, int i, int i2) {
        String str;
        Intrinsics.checkNotNullParameter(tabParams, "tabParams");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(position, "position");
        ym4.a g = new ym4.a().j(k0.a.b().n()).j(d.a(tabParams)).g("playlist_position", position).g("playlist_id", albumId).g("rank", Integer.valueOf(i)).g("follow_position", "profile_playlist_list").g("is_pin_to_top", Integer.valueOf(i2));
        o oVar = o.a;
        if (z) {
            str = "follow_playlist";
        } else {
            str = "cancel_follow_playlist";
        }
        oVar.d(str, g);
    }

    public final void b(boolean z, c tabParams, String albumId, String position, int i, int i2, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(tabParams, "tabParams");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(position, "position");
        ym4.a g = new ym4.a().j(k0.a.b().n()).j(d.a(tabParams)).g("playlist_id", albumId).g("playlist_position", position).g("rank", Integer.valueOf(i)).g("click_content", str).g("is_pin_to_top", Integer.valueOf(i2));
        o oVar = o.a;
        if (z) {
            str2 = "show_playlist";
        } else {
            str2 = "click_playlist";
        }
        oVar.d(str2, g);
    }

    public final void c(boolean z, c tabParams, v6 ugcVideoData, String relateAlbumId, String position, int i, int i2) {
        VideoContentType videoContentType;
        Boolean bool;
        String str;
        String str2;
        Integer num;
        Intrinsics.checkNotNullParameter(tabParams, "tabParams");
        Intrinsics.checkNotNullParameter(ugcVideoData, "ugcVideoData");
        Intrinsics.checkNotNullParameter(relateAlbumId, "relateAlbumId");
        Intrinsics.checkNotNullParameter(position, "position");
        ym4.a g = new ym4.a().j(k0.a.b().n()).j(d.a(tabParams)).g("position", position).g("rank", Integer.valueOf(i)).g("src_material_id", ugcVideoData.a);
        ld4.a aVar = ld4.a.a;
        k7 k7Var = ugcVideoData.b;
        Long l = null;
        if (k7Var != null && (num = k7Var.g) != null) {
            videoContentType = jd4.a.c(num.intValue());
        } else {
            videoContentType = null;
        }
        ym4.a g2 = g.g("material_type", aVar.c(videoContentType));
        k7 k7Var2 = ugcVideoData.b;
        if (k7Var2 != null) {
            bool = k7Var2.j;
        } else {
            bool = null;
        }
        if (g0.a(bool)) {
            str = "vertical";
        } else {
            str = "horizontal";
        }
        ym4.a g3 = g2.g("direction", str);
        k7 k7Var3 = ugcVideoData.b;
        if (k7Var3 != null) {
            l = k7Var3.i;
        }
        ym4.a g4 = g3.g("material_rank", Long.valueOf(g0.d(l) + 1)).g("related_playlist_id", relateAlbumId).g("is_pin_to_top", Integer.valueOf(i2));
        o oVar = o.a;
        if (z) {
            str2 = "show_video";
        } else {
            str2 = "click_video";
        }
        oVar.d(str2, g4);
    }
}
