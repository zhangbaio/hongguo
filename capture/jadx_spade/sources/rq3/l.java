package rq3;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.base.Args;
import com.dragon.read.component.shortvideo.api.model.DataSource;
import com.dragon.read.component.shortvideo.data.saas.video.SaasVideoData;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface l {
    public static final /* synthetic */ int c3 = 0;

    static {
        Covode.recordClassIndex(598616);
    }

    void A3(boolean z);

    void Ad(String str);

    void B5(String str);

    void C5(String str, Bundle bundle);

    void Cd(boolean z);

    boolean Dc(ds3.b bVar);

    boolean De();

    void G4(boolean z);

    void H6(SaasVideoData saasVideoData, int i, String str, Map<String, ? extends Object> map);

    Object Hd(String str);

    g Ia();

    void Ib();

    boolean Id();

    void J4(boolean z, String str, Float f, Typeface typeface);

    void Kc(boolean z);

    void N0(boolean z);

    ts3.a R9();

    gs3.a T9();

    void Te();

    FrameLayout Xd();

    boolean Z6();

    boolean Za();

    void b3(boolean z);

    void b7(ts3.a aVar);

    void bc(String str, boolean z);

    void dd(Function2<? super DataSource, ? super Boolean, Unit> function2, Function1<? super Throwable, Unit> function1);

    boolean e0();

    List<Runnable> fb();

    String i6();

    /* renamed from: if, reason: not valid java name */
    int m1108if();

    jr3.a k7();

    void lf(int i);

    boolean n6();

    void s0(boolean z);

    void s3(SaasVideoData saasVideoData, int i, String str);

    boolean u9();

    void y6(boolean z);

    Args z9();
}
