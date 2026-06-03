package rq3;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import com.dragon.read.recyler.AbsRecyclerViewHolder;
import com.ss.ttvideoengine.SeekCompletionListener;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface e {
    public static final /* synthetic */ int a3 = 0;

    static {
        Covode.recordClassIndex(598611);
    }

    void B0();

    boolean B1();

    void B2(SaasVideoData saasVideoData, int i, String str);

    boolean C3();

    void D();

    void E0(boolean z);

    boolean J1();

    boolean J2();

    void K0(ir3.c cVar);

    boolean O2(String str, boolean z);

    void P();

    View P0();

    void P1();

    void Q1(boolean z);

    void R0();

    View S2();

    int T0();

    boolean T1();

    void U0();

    void V0(ds3.d dVar);

    boolean V2(int i, boolean z);

    void X(boolean z);

    void X0();

    void Y(boolean z, boolean z2);

    boolean Z();

    int a1();

    void c2(boolean z);

    AbsRecyclerViewHolder<Object> d3();

    void e3(boolean z, boolean z2);

    AbsRecyclerViewHolder<Object> g3(int i);

    int getPlaybackState();

    boolean h();

    void h1(int i, String str);

    void h3();

    void i1();

    void j2(boolean z);

    boolean k1(String str, boolean z);

    void k2();

    void k3();

    ViewGroup l1();

    void n0();

    void seekTo(int i, SeekCompletionListener seekCompletionListener);

    void u3(boolean z);

    void v2(boolean z);

    void w3(boolean z, String str, Bundle bundle, boolean z2, Integer num, Boolean bool, Boolean bool2);

    boolean x0(View view, RelativeLayout.LayoutParams layoutParams);

    boolean x1();

    void x2();
}
