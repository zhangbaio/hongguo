package xn4;

import android.app.Activity;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.base.ui.util.ScreenUtils;
import com.dragon.read.base.util.ActivityRecordHelper;
import com.dragon.read.component.biz.api.NsUgDepend;
import com.dragon.read.util.ToastUtils;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class a0 implements zn4.f {
    public static final a0 a;

    static {
        Covode.recordClassIndex(608959);
        a = new a0();
    }

    private a0() {
    }

    @Override // zn4.f
    public void L() {
        ToastUtils.hideLoadingToast();
    }

    @Override // zn4.f
    public int c4() {
        int screenWidthDp = ScreenUtils.getScreenWidthDp(App.context());
        int screenHeightDp = ScreenUtils.getScreenHeightDp(App.context());
        if (NsUgDepend.IMPL.isPadOrFoldDevice()) {
            return Math.min(screenWidthDp, screenHeightDp);
        }
        return screenWidthDp;
    }

    @Override // zn4.f
    public int getScreenWidth() {
        xs4.f n;
        int i;
        int screenWidthDp = ScreenUtils.getScreenWidthDp(App.context());
        if (xs4.e.t() && (n = xs4.e.n()) != null && (i = n.k) < screenWidthDp) {
            return i;
        }
        return screenWidthDp;
    }

    @Override // zn4.f
    public void y(String str) {
        ToastUtils.showLoadingToast(str);
    }

    @Override // zn4.f
    public void N9(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ToastUtils.showCommonToastSafely(text);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I1(un4.b bVar, bh1.a channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        bVar.a(channel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j2(un4.b bVar, bh1.a channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        bVar.a(channel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(un4.b bVar, bh1.a channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        bVar.a(channel);
        return Unit.INSTANCE;
    }

    @Override // zn4.f
    public wn4.b R5(String title, List<bh1.a> shareChannelList, final un4.b onClickListener) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        Activity currentVisibleActivity = ActivityRecordHelper.getCurrentVisibleActivity();
        if (currentVisibleActivity != null) {
            return new wn4.p(currentVisibleActivity, title, shareChannelList, new Function1() { // from class: xn4.y
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit j2;
                    j2 = a0.j2(un4.b.this, (bh1.a) obj);
                    return j2;
                }
            }, 0, false, 48, null);
        }
        return null;
    }

    @Override // zn4.f
    public wn4.b G2(String title, List<bh1.a> shareChannelList, final un4.b onClickListener, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        Activity currentVisibleActivity = ActivityRecordHelper.getCurrentVisibleActivity();
        if (currentVisibleActivity != null) {
            return new wn4.e(currentVisibleActivity, title, shareChannelList, new Function1() { // from class: xn4.x
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit I1;
                    I1 = a0.I1(un4.b.this, (bh1.a) obj);
                    return I1;
                }
            }, z);
        }
        return null;
    }

    @Override // zn4.f
    public wn4.b O1(String title, vn4.a shareParams, List<bh1.a> shareChannelList, final un4.b onClickListener) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(shareParams, "shareParams");
        Intrinsics.checkNotNullParameter(shareChannelList, "shareChannelList");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        Activity currentVisibleActivity = ActivityRecordHelper.getCurrentVisibleActivity();
        if (currentVisibleActivity != null) {
            return new wn4.i(currentVisibleActivity, title, shareParams, shareChannelList, new Function1() { // from class: xn4.z
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit s1;
                    s1 = a0.s1(un4.b.this, (bh1.a) obj);
                    return s1;
                }
            }, 0, false, 96, null);
        }
        return null;
    }
}
