package pl6;

import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.xs.fm.player.base.play.inter.AbsPlayListener;
import com.xs.fm.player.base.play.inter.IPlayManager;
import com.xs.fm.player.base.play.player.IPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class f extends AbsPlayListener implements e {
    private static volatile boolean a;
    private static final List<vk6.a> b;
    private static final Map<Integer, vk6.a> c;
    public static final f d;

    private f() {
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onFirstListPlay() {
        vk6.a g = g();
        if (g != null) {
            g.onFirstListPlay();
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onListDataChanged() {
        vk6.a g = g();
        if (g != null) {
            g.onListDataChanged();
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onListPlayCompletion() {
        vk6.a g = g();
        if (g != null) {
            g.onListPlayCompletion();
        }
    }

    static {
        Covode.recordClassIndex(655968);
        d = new f();
        b = new ArrayList();
        c = new LinkedHashMap();
    }

    private final vk6.a g() {
        IPlayManager B = il6.a.B();
        Intrinsics.checkExpressionValueIsNotNull(B, "PlayManager.getInstance()");
        qk6.a currentStrategy = B.getCurrentStrategy();
        if (currentStrategy != null) {
            return currentStrategy.p();
        }
        return null;
    }

    public synchronized void i() {
        if (a) {
            return;
        }
        if (a.a.a()) {
            a = true;
            il6.a.B().addPlayListener(this);
        }
    }

    private final void h() {
        Map<Integer, qk6.a> map = lk6.c.a.j;
        Intrinsics.checkExpressionValueIsNotNull(map, "PlayConfigUtil.playConfig.playStrategyMap");
        Iterator<Map.Entry<Integer, qk6.a>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            qk6.a value = it2.next().getValue();
            Intrinsics.checkExpressionValueIsNotNull(value, "entry.value");
            vk6.a it4 = value.p();
            if (it4 != null) {
                List<vk6.a> list = b;
                if (!list.contains(it4)) {
                    Intrinsics.checkExpressionValueIsNotNull(it4, "it");
                    list.add(it4);
                }
            }
        }
    }

    @Override // pl6.e
    public void d() {
        h.g();
        h();
        for (vk6.a aVar : b) {
            if (aVar != null) {
                aVar.d();
            }
        }
        h.a();
        TTVideoEngine.cancelAllPreloadTasks();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onBufferingUpdate(int i) {
        vk6.a g = g();
        if (g != null) {
            g.onBufferingUpdate(i);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onItemPlayCompletion(IPlayer iPlayer) {
        vk6.a g = g();
        if (g != null) {
            g.onItemPlayCompletion(iPlayer);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onItemChanged(String str, String str2) {
        vk6.a g = g();
        if (g != null) {
            g.onItemChanged(str, str2);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onListChanged(pk6.b bVar, pk6.b bVar2) {
        vk6.a g = g();
        if (g != null) {
            g.onListChanged(bVar, bVar2);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayStateChange(IPlayer iPlayer, int i) {
        vk6.a g = g();
        if (g != null) {
            g.onPlayStateChange(iPlayer, i);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayTypeChanged(Integer num, Integer num2) {
        vk6.a g = g();
        if (g != null) {
            g.onPlayTypeChanged(num, num2);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onResolutionChange(Resolution resolution, Resolution resolution2) {
        vk6.a g = g();
        if (g != null) {
            g.onResolutionChange(resolution, resolution2);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onToneChanged(int i, int i2) {
        vk6.a g = g();
        if (g != null) {
            g.onToneChanged(i, i2);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onUIStateChange(IPlayer iPlayer, int i) {
        vk6.a g = g();
        if (g != null) {
            g.onUIStateChange(iPlayer, i);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onVideoEngineInfos(IPlayer iPlayer, VideoEngineInfos videoEngineInfos) {
        vk6.a g = g();
        if (g != null) {
            g.onVideoEngineInfos(iPlayer, videoEngineInfos);
        }
    }

    public final void l(vk6.c cVar, vk6.b bVar) {
        if (h.d(h.b(cVar.n))) {
            return;
        }
        g gVar = new g(cVar);
        gVar.i = bVar;
        gVar.x();
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onPlayProgressChanged(IPlayer iPlayer, int i, int i2) {
        vk6.a g = g();
        if (g != null) {
            g.onPlayProgressChanged(iPlayer, i, i2);
        }
    }

    @Override // com.xs.fm.player.base.play.inter.AbsPlayListener
    public void onReachDynamicBuffer(IPlayer iPlayer, boolean z, long j) {
        vk6.a g = g();
        if (g != null) {
            g.onReachDynamicBuffer(iPlayer, z, j);
        }
    }
}
