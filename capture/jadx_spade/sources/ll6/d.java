package ll6;

import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakContainer;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.inter.AbsPlayListener;
import com.xs.fm.player.base.play.inter.IPlayManager;
import com.xs.fm.player.base.play.player.IPlayer;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class d {
    private static final bl6.a a;
    private static final WeakContainer<AbsPlayListener> b;
    private static int c;
    private static int d;
    public static final d e;

    private d() {
    }

    public final int c() {
        return c;
    }

    public final int d() {
        return d;
    }

    public final void K() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    absPlayListener.onResume();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void f() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    absPlayListener.onAllTipCancel();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void g() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    absPlayListener.onAllTipFinish();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void l() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    absPlayListener.onFirstListPlay();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void u() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    absPlayListener.onPause();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    static {
        Covode.recordClassIndex(655937);
        e = new d();
        a = new bl6.a("PlayListenerHandler");
        b = new WeakContainer<>();
        c = 101;
        d = 301;
    }

    public final void B() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onPlayerPlay();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void C() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onPlayerPrepare();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void D() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onPlayerPrepared();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void E() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onPlayerRenderStart();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void F() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onPlayerResetBegin();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void H() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onRequestAudioFocus();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void e() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onAbandonAudioFocus();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void t() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onListPlayCompletion();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void r() {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    try {
                        absPlayListener.onListChanged();
                    } catch (Throwable th) {
                        a.b("onListChanged, fail, errMsg = " + th.getMessage(), new Object[0]);
                        ml6.b.a.e("fail_onListChanged_old_handler");
                    }
                }
            }
            zk6.c.q("onListChanged_2", System.currentTimeMillis() - currentTimeMillis);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void S(AbsPlayListener absPlayListener) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            weakContainer.remove(absPlayListener);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void a(AbsPlayListener absPlayListener) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            weakContainer.add(absPlayListener);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final boolean R(AbsPlayListener absPlayListener) {
        IPlayManager B = il6.a.B();
        Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
        return TextUtils.equals(B.getCurrentListId(), absPlayListener.getListId());
    }

    public final void M(pk6.c cVar) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    absPlayListener.onStop(cVar);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void N(String str) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    absPlayListener.onTipPlay(str);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void m(boolean z) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    absPlayListener.onInitBeforePlay(z);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void I(jl6.d dVar) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onRequestPlayAddress(dVar);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void L(long j) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onSeekTo(j);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void h(int i) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onAudioFocusChange(i);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void j(int i) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onBufferingUpdate(i);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void k(jl6.e eVar) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onFetchPlayAddress(eVar);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void o(IPlayer iPlayer) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onItemPlayCompletion(iPlayer);
                }
            }
            zk6.c.q("onItemPlayCompletion", System.currentTimeMillis() - currentTimeMillis);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void x(String str) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onPlayPre(str);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void A(IPlayer iPlayer, IPlayer iPlayer2) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    absPlayListener.onPlayerChanged(iPlayer, iPlayer2);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void b(String str, String str2) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    absPlayListener.beforePlay(str, str2);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void v(IPlayer iPlayer, PlayEngineInfo playEngineInfo) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    absPlayListener.onPlay(iPlayer, playEngineInfo);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void z(Integer num, Integer num2) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    absPlayListener.onPlayTypeChanged(num, num2);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void J(Resolution resolution, Resolution resolution2) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onResolutionChange(resolution, resolution2);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void O(int i, int i2) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onToneChanged(i, i2);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void Q(IPlayer iPlayer, VideoEngineInfos videoEngineInfos) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onVideoEngineInfos(iPlayer, videoEngineInfos);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void i(int i, int i2) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onBgNoiseIdChanged(i, i2);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void w(boolean z, pk6.c cVar) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onPlayNext(z, cVar);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void n(String str, String str2) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    try {
                        if (e.R(absPlayListener)) {
                            absPlayListener.onItemChanged(str, str2);
                        }
                    } catch (Throwable th) {
                        a.b("onItemChanged, fail, oldItem = " + str + ", newItem = " + str2 + ", errMsg= " + th.getMessage(), new Object[0]);
                        ml6.b.a.e("fail_onItemChanged_handler");
                    }
                }
            }
            zk6.c.q("onItemChanged", System.currentTimeMillis() - currentTimeMillis);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void s(pk6.b bVar, pk6.b bVar2) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    try {
                        absPlayListener.onListChanged(bVar, bVar2);
                    } catch (Throwable th) {
                        a.b("onListChanged, fail , oldPlayContextInfo = " + bVar.toString() + ", currentPlayContextInfo = " + bVar2.toString() + ", errMsg = " + th.getMessage(), new Object[0]);
                        ml6.b.a.e("fail_onListChanged_handler");
                    }
                }
            }
            zk6.c.q("onListChanged_1", System.currentTimeMillis() - currentTimeMillis);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void P(IPlayer iPlayer, int i) {
        nk6.b bVar;
        bl6.a aVar = a;
        StringBuilder sb = new StringBuilder();
        sb.append("onUIStateChange, uiState = ");
        sb.append(i);
        sb.append(", curThreadName = ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb.append(currentThread.getName());
        aVar.d(sb.toString(), new Object[0]);
        if (i == d && (bVar = lk6.c.a.l) != null && bVar.m0()) {
            return;
        }
        d = i;
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    try {
                        if (e.R(absPlayListener)) {
                            absPlayListener.onUIStateChange(iPlayer, i);
                        }
                    } catch (Throwable th) {
                        a.b("onUIStateChange, fail uiState = " + i + ", errMsg = " + th.getMessage(), new Object[0]);
                        ml6.b.a.e("fail_onUIStateChange_handler");
                    }
                }
            }
            zk6.c.q("onUIStateChange_" + i, System.currentTimeMillis() - currentTimeMillis);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void y(IPlayer iPlayer, int i) {
        nk6.b bVar;
        a.d("onPlayStateChange, playState = " + i, new Object[0]);
        if (i == c && (bVar = lk6.c.a.l) != null && bVar.m0()) {
            return;
        }
        c = i;
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null) {
                    try {
                        if (e.R(absPlayListener)) {
                            absPlayListener.onPlayStateChange(iPlayer, i);
                        }
                    } catch (Throwable th) {
                        a.b("onPlayStateChange, fail playState = " + i + ", errorMsg = " + th.getMessage(), new Object[0]);
                        ml6.b.a.e("fail_onPlayStateChange_handler");
                    }
                }
            }
            zk6.c.q("onPlayStateChange_" + i, System.currentTimeMillis() - currentTimeMillis);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void G(IPlayer iPlayer, boolean z, long j) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onReachDynamicBuffer(iPlayer, z, j);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void p(IPlayer iPlayer, int i, String str) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onPlayError(iPlayer, i, str);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void q(IPlayer iPlayer, int i, int i2) {
        WeakContainer<AbsPlayListener> weakContainer = b;
        synchronized (weakContainer) {
            Iterator it2 = weakContainer.iterator();
            while (it2.hasNext()) {
                AbsPlayListener absPlayListener = (AbsPlayListener) it2.next();
                if (absPlayListener != null && e.R(absPlayListener)) {
                    absPlayListener.onPlayProgressChanged(iPlayer, i, i2);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
