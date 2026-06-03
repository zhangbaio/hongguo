package rq3;

import android.content.Context;
import android.graphics.Bitmap;
import com.ss.ttvideoengine.Resolution;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import seriessdk.com.dragon.read.saas.rpc.model.VideoShareInfo;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface g {
    Resolution[] C();

    boolean H2();

    void J(boolean z);

    VideoShareInfo J0();

    void L2(boolean z);

    String M1();

    void S0(boolean z, Function1<? super Bitmap, Unit> function1);

    void W0();

    int c3();

    boolean e0();

    void e2(float f, boolean z, boolean z2);

    float getCacheVideoSpeed(String str);

    int getCurrentPlaySpeed();

    Resolution getResolution();

    int getVideoScene();

    boolean isVertical();

    void j(Resolution resolution);

    void l2();

    void n3(int i);

    void o(boolean z);

    void p(boolean z);

    Context q3();

    void s0(boolean z);

    int t0();

    float x();

    boolean y();
}
