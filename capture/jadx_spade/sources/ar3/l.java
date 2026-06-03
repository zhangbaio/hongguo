package ar3;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.bytedance.covode.number.Covode;
import com.dragon.read.component.shortvideo.data.consts.HolderType;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface l {
    public static final /* synthetic */ int u0 = 0;

    static {
        Covode.recordClassIndex(598683);
    }

    Rect B1();

    void C0(p pVar);

    String L();

    List<View> P1();

    void T0(String str, Bundle bundle);

    o W();

    Context getContext();

    View getRootView();

    int getVideoScene();

    View getVideoView();

    HolderType i2();

    boolean isSurfaceView();

    n k1();

    void onAppear();

    void onDisappear();

    d y1();

    a z1();
}
