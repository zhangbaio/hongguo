package xn4;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.base.share2.utils.m0;
import com.dragon.read.base.util.ActivityRecordHelper;
import com.dragon.read.util.PictureUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class v implements zn4.d {
    public static final v a;

    static {
        Covode.recordClassIndex(608957);
        a = new v();
    }

    private v() {
    }

    @Override // zn4.d
    public Map<String, String> n9() {
        return m0.a.c0();
    }

    @Override // zn4.d
    public un4.h a8() {
        Bitmap decodeResource = BitmapFactory.decodeResource(App.context().getResources(), 2130844583);
        if (decodeResource == null) {
            return null;
        }
        return new un4.h(androidx.compose.ui.graphics.j.c(decodeResource), null, 2, null);
    }

    @Override // zn4.d
    public un4.f o6(String colorHex) {
        Intrinsics.checkNotNullParameter(colorHex, "colorHex");
        Pair c = hp2.n.a.c(colorHex);
        return new un4.f(((Number) c.getFirst()).intValue(), ((Number) c.getSecond()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H2(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O3(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j2(un4.b bVar, bh1.a channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        bVar.a(channel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l3(un4.c cVar, Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = "handleSeriesCover failed";
        }
        cVar.onFailure(message);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u2(un4.c cVar, Bitmap bitmap) {
        hp2.n nVar = hp2.n.a;
        Bitmap decodeResource = BitmapFactory.decodeResource(App.context().getResources(), 2130839496);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(...)");
        Intrinsics.checkNotNull(bitmap);
        Bitmap e = nVar.e(decodeResource, bitmap);
        if (e != null) {
            cVar.a(new un4.h(androidx.compose.ui.graphics.j.c(e), null, 2, null));
        } else {
            cVar.onFailure("handleSeriesCover result is null");
        }
        return Unit.INSTANCE;
    }

    @Override // zn4.d
    public void T2(String coverUrl, final un4.c callback) {
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Observable observable = PictureUtils.getBitmap(coverUrl).toObservable();
        final Function1 function1 = new Function1() { // from class: xn4.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u2;
                u2 = v.u2(un4.c.this, (Bitmap) obj);
                return u2;
            }
        };
        Consumer consumer = new Consumer() { // from class: xn4.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                v.H2(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: xn4.t
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l3;
                l3 = v.l3(un4.c.this, (Throwable) obj);
                return l3;
            }
        };
        observable.subscribe(consumer, new Consumer() { // from class: xn4.u
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                v.O3(Function1.this, obj);
            }
        });
    }

    @Override // zn4.d
    public wn4.a j1(com.dragon.read.kmp.share.business.series.o videoPlayerPost, List<bh1.a> shareChannelList, final un4.b onClickListener) {
        Intrinsics.checkNotNullParameter(videoPlayerPost, "videoPlayerPost");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        Activity currentVisibleActivity = ActivityRecordHelper.getCurrentVisibleActivity();
        if (currentVisibleActivity != null) {
            return new wn4.o(currentVisibleActivity, videoPlayerPost, shareChannelList, new Function1() { // from class: xn4.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit j2;
                    j2 = v.j2(un4.b.this, (bh1.a) obj);
                    return j2;
                }
            });
        }
        return null;
    }
}
