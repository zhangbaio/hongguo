package rl6;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.PlayEngineInfo;
import com.xs.fm.player.base.play.player.IPlayer;
import com.xs.fm.player.base.play.player.audio.engine.IAudioPlayer;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import ll6.d;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import rk6.a;
import u55.k;
import xk6.g;
import xk6.h;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c {
    private static bl6.a a;
    private static final CopyOnWriteArrayList<a> b;
    public static String c;
    private static Set<String> d;

    public static boolean i() {
        return !b.isEmpty();
    }

    public static class b {
        private rk6.a a;
        private IAudioPlayer b;
        private IPlayer.PlayerListener c;
        private boolean d;

        static {
            Covode.recordClassIndex(655989);
        }

        /* renamed from: rl6.c$b$b, reason: collision with other inner class name */
        class RunnableC0258b implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.k(bVar.a.a, b.this.a.i);
            }

            RunnableC0258b() {
            }
        }

        void h() {
            c.a.d("play tip", new Object[0]);
            rl6.a aVar = lk6.c.a.v;
            if (aVar != null && aVar.g()) {
                j();
            } else {
                i();
            }
        }

        class a extends IPlayer.PlayerListener.Stub {
            final /* synthetic */ rk6.a a;

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onAbandonAudioFocus() {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onAudioFocusChange(int i) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onBufferingUpdate(int i) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onPlayerPrepare() {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onPlayerPrepared() {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onProgressUpdate(IPlayer iPlayer, int i, int i2) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onReachDynamicBuffer(IPlayer iPlayer, boolean z, long j) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onReadyToDisplay(boolean z) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onRequestAudioFocus() {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onUIStateChange(IPlayer iPlayer, int i) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onVideoEngineInfos(IPlayer iPlayer, VideoEngineInfos videoEngineInfos) {
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onPlayerRenderStart() {
                c.a.d("开始播放tips: isVideoModel=" + this.a.d + " , url = " + this.a.a, new Object[0]);
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onPlayerPlay() {
                rl6.a aVar;
                if (b.this.b != null && b.this.b.getPlayAddress() != null) {
                    ll6.d.e.N(b.this.b.getPlayAddress().playUrl);
                } else {
                    ll6.d.e.N(null);
                }
                lk6.b bVar = lk6.c.a;
                if (bVar != null && (aVar = bVar.v) != null) {
                    rk6.a aVar2 = this.a;
                    aVar.m(new rl6.b(aVar2.a, c.c, aVar2.g));
                }
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onPlayCompletion(IPlayer iPlayer) {
                rl6.a aVar;
                c.a.d("onCompletion", new Object[0]);
                b.this.f(true);
                lk6.b bVar = lk6.c.a;
                if (bVar != null && (aVar = bVar.v) != null) {
                    rk6.a aVar2 = this.a;
                    aVar.k(new rl6.b(aVar2.a, c.c, aVar2.g));
                }
            }

            a(rk6.a aVar) {
                this.a = aVar;
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onPlayStateChange(IPlayer iPlayer, int i) {
                c.a.d("tips play state change: play state = " + i, new Object[0]);
                this.a.j = i;
            }

            @Override // com.xs.fm.player.base.play.player.IPlayer.PlayerListener.Stub, com.xs.fm.player.base.play.player.IPlayer.PlayerListener
            public void onError(IPlayer iPlayer, int i, String str) {
                rl6.a aVar;
                rl6.a aVar2;
                int i2 = 0;
                c.a.d("onError: errorCode %d , errorMsg=%s", Integer.valueOf(i), str);
                b.this.f(false);
                lk6.b bVar = lk6.c.a;
                if (bVar != null && (aVar2 = bVar.v) != null) {
                    aVar2.i(i, str, this.a.a, c.c);
                }
                lk6.b bVar2 = lk6.c.a;
                if (bVar2 != null && (aVar = bVar2.v) != null) {
                    rk6.a aVar3 = this.a;
                    aVar.e(new rl6.b(aVar3.a, c.c, aVar3.g), i, str);
                }
                if (!c.c.startsWith("http")) {
                    i2 = 1;
                } else if (this.a.d) {
                    i2 = 2;
                }
                ml6.c cVar = ml6.c.a;
                rk6.a aVar4 = this.a;
                cVar.a(aVar4.a, c.c, aVar4.g, i2, aVar4.e, aVar4.k, aVar4.l, false, i, str, "engine_error");
            }
        }

        class d implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                c.a.d("play: fetchUrlAndPlay", new Object[0]);
                g.e(new a(c.h(b.this.a.a, b.this.a.b)));
            }

            class a implements Runnable {
                final /* synthetic */ String a;

                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.a.d) {
                        if (b.this.a.c != null && b.this.a.e < b.this.a.c.length) {
                            String str = b.this.a.c[b.this.a.e];
                            b bVar = b.this;
                            bVar.l(str, bVar.a.i);
                            return;
                        }
                        return;
                    }
                    String str2 = this.a;
                    if (TextUtils.isEmpty(str2)) {
                        c.a.b("play: no play url final", new Object[0]);
                        b.this.g();
                        return;
                    }
                    rl6.a aVar = lk6.c.a.v;
                    if (aVar != null) {
                        String cachePath = aVar.getCachePath(str2);
                        if (!TextUtils.isEmpty(cachePath)) {
                            str2 = cachePath;
                        }
                    }
                    b bVar2 = b.this;
                    bVar2.k(str2, bVar2.a.i);
                }

                a(String str) {
                    this.a = str;
                }
            }

            d() {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            c.a.d("cancel play tips", new Object[0]);
            if (this.d) {
                return;
            }
            this.d = true;
            rk6.b bVar = this.a.h;
            if (bVar != null) {
                bVar.onCancel();
            }
            IAudioPlayer iAudioPlayer = this.b;
            if (iAudioPlayer != null) {
                iAudioPlayer.stop();
                this.b.release();
                this.b = null;
            }
        }

        /* renamed from: rl6.c$b$c, reason: collision with other inner class name */
        class RunnableC0259c implements Runnable {
            final /* synthetic */ String a;

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a.d) {
                    if (b.this.a.c != null && b.this.a.e < b.this.a.c.length) {
                        String str = b.this.a.c[b.this.a.e];
                        b bVar = b.this;
                        bVar.l(str, bVar.a.i);
                        return;
                    }
                    return;
                }
                b bVar2 = b.this;
                bVar2.k(this.a, bVar2.a.i);
            }

            RunnableC0259c(String str) {
                this.a = str;
            }
        }

        class e implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a.d) {
                    if (b.this.a.c != null && b.this.a.e < b.this.a.c.length) {
                        String str = b.this.a.c[b.this.a.e];
                        b bVar = b.this;
                        bVar.l(str, bVar.a.i);
                        return;
                    }
                    return;
                }
                b bVar2 = b.this;
                bVar2.k(bVar2.a.a, b.this.a.i);
            }

            e() {
            }
        }

        class f implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                if (b.this.a.d) {
                    if (b.this.a.c != null && b.this.a.e < b.this.a.c.length) {
                        String str = b.this.a.c[b.this.a.e];
                        b bVar = b.this;
                        bVar.l(str, bVar.a.i);
                        return;
                    }
                    return;
                }
                b bVar2 = b.this;
                bVar2.k(bVar2.a.a, b.this.a.i);
            }

            f() {
            }
        }

        private void i() {
            rk6.a aVar = this.a;
            if (aVar.d) {
                String[] strArr = aVar.c;
                if (strArr == null || aVar.e >= strArr.length) {
                    c.a.b("no play url", new Object[0]);
                    g();
                    return;
                }
            } else if (TextUtils.isEmpty(aVar.a) && TextUtils.isEmpty(this.a.b)) {
                c.a.b("no play url", new Object[0]);
                g();
                return;
            }
            boolean z = !URLUtil.isNetworkUrl(this.a.a);
            rk6.a aVar2 = this.a;
            if (!aVar2.d && z) {
                g.e(new RunnableC0258b());
                return;
            }
            rl6.a aVar3 = lk6.c.a.v;
            if (aVar3 != null) {
                String cachePath = aVar3.getCachePath(aVar2.a);
                if (!TextUtils.isEmpty(cachePath)) {
                    g.e(new RunnableC0259c(cachePath));
                    return;
                }
            }
            if (!NetworkUtils.isNetworkAvailableFast(lk6.c.a.b)) {
                c.a.b("play: no net, cancel now", new Object[0]);
                g();
            } else if (TextUtils.isEmpty(this.a.a) && TextUtils.isEmpty(this.a.b)) {
                c.a.b("play: no play url", new Object[0]);
                g();
            } else {
                TTExecutors.getNormalExecutor().execute(new d());
            }
        }

        private void j() {
            rk6.a aVar = this.a;
            if (aVar.d) {
                String[] strArr = aVar.c;
                if (strArr == null || aVar.e >= strArr.length) {
                    c.a.b("playTipWithoutBeforeUrlConnect: getVideoModelStr is  ull, return ", new Object[0]);
                    g();
                    return;
                }
            } else if (TextUtils.isEmpty(aVar.a) && TextUtils.isEmpty(this.a.b)) {
                c.a.b("playTipWithoutBeforeUrlConnect: no play url, return", new Object[0]);
                g();
                return;
            }
            rl6.a aVar2 = lk6.c.a.v;
            if (aVar2 != null && aVar2.h(this.a.a)) {
                g.e(new e());
            } else if (!NetworkUtils.isNetworkAvailableFast(lk6.c.a.b)) {
                c.a.b("no net, cancel now", new Object[0]);
                g();
            } else {
                c.a.d("fetchUrlAndPlay", new Object[0]);
                g.e(new f());
            }
        }

        public b(rk6.a aVar) {
            this.a = aVar;
            this.c = new a(aVar);
        }

        private void m(PlayAddress playAddress) {
            rl6.a aVar = lk6.c.a.v;
            if (aVar != null && aVar.o() && aVar.p() != null) {
                playAddress.balanceData = aVar.p();
                playAddress.volumeBalanceType = 0;
            }
        }

        public void f(boolean z) {
            int i;
            c.a.d("doOnFinish", new Object[0]);
            if (this.d) {
                return;
            }
            if (z) {
                rk6.a aVar = this.a;
                if (aVar.d && (i = aVar.e) < aVar.c.length - 1) {
                    aVar.e = i + 1;
                    c.a.d("doOnFinish: vmIndex = %d, length = %d ", Integer.valueOf(this.a.e), Integer.valueOf(this.a.c.length));
                    rk6.a aVar2 = this.a;
                    l(aVar2.c[aVar2.e], aVar2.i);
                    return;
                }
            }
            this.d = true;
            rk6.b bVar = this.a.h;
            if (bVar != null) {
                bVar.onFinish();
            }
            IAudioPlayer iAudioPlayer = this.b;
            if (iAudioPlayer != null) {
                iAudioPlayer.stop();
                this.b.release();
                this.b = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(String str, int i) {
            int i2;
            if (this.d) {
                return;
            }
            a.InterfaceC0256a interfaceC0256a = this.a.f;
            if (interfaceC0256a != null) {
                interfaceC0256a.startPlay();
            }
            rl6.a aVar = lk6.c.a.v;
            if (aVar != null && aVar.g()) {
                rl6.a aVar2 = lk6.c.a.v;
                if (aVar2 != null) {
                    aVar2.j(str);
                    c.c = lk6.c.a.v.getCachePath(str);
                } else {
                    c.c = str;
                }
            } else {
                rl6.a aVar3 = lk6.c.a.v;
                if (aVar3 != null) {
                    aVar3.j(str);
                }
                c.c = str;
            }
            rl6.a aVar4 = lk6.c.a.v;
            if (aVar4 != null && aVar4.a() && c.c.startsWith("http:")) {
                c.a.d("enableTipsHttpsOpt =true, replace http to https, currentTipUrl = " + c.c, new Object[0]);
                c.c = c.c.replace("http:", "https:");
            }
            c.a.d("realPlay originalUrl:%s , finalPlayUrl:%s", str, c.c);
            PlayAddress playAddress = new PlayAddress();
            playAddress.fetchTime = System.currentTimeMillis();
            playAddress.playType = 0;
            playAddress.playUrl = c.c;
            playAddress.isEncrypt = false;
            playAddress.encryptionKey = "";
            playAddress.tag = "tip";
            playAddress.mdlCachePath = null;
            PlayEngineInfo playEngineInfo = new PlayEngineInfo(playAddress, 0L, 100);
            playEngineInfo.genreType = -1;
            playEngineInfo.playerFocusDurationHint = i;
            m(playAddress);
            if (this.b == null) {
                com.xs.fm.player.sdk.play.player.audio.engine.g gVar = new com.xs.fm.player.sdk.play.player.audio.engine.g();
                this.b = gVar;
                gVar.setPlayerListener(this.c);
            }
            rl6.a aVar5 = lk6.c.a.v;
            if (aVar5 != null) {
                aVar5.l(playEngineInfo);
            }
            boolean z = !c.c.startsWith("http");
            int i3 = playAddress.playType;
            if (z) {
                i2 = 1;
            } else {
                i2 = i3;
            }
            ml6.c cVar = ml6.c.a;
            rk6.a aVar6 = this.a;
            cVar.b(aVar6.a, c.c, aVar6.g, i2, aVar6.e, aVar6.k, aVar6.l, false);
            this.b.play(playEngineInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(String str, int i) {
            if (this.d) {
                return;
            }
            a.InterfaceC0256a interfaceC0256a = this.a.f;
            if (interfaceC0256a != null) {
                interfaceC0256a.startPlay();
            }
            rl6.a aVar = lk6.c.a.v;
            if (aVar != null) {
                aVar.j(str);
            }
            c.a.d("realPlay video model :%s", str);
            PlayAddress playAddress = new PlayAddress();
            playAddress.fetchTime = System.currentTimeMillis();
            playAddress.playType = 2;
            playAddress.playVideoModel = str;
            playAddress.videoModel = h.a.b(str);
            playAddress.tag = "tip";
            playAddress.mdlCachePath = null;
            PlayEngineInfo playEngineInfo = new PlayEngineInfo(playAddress, 0L, 100);
            playEngineInfo.genreType = -1;
            playEngineInfo.playerFocusDurationHint = i;
            if (this.b == null) {
                com.xs.fm.player.sdk.play.player.audio.engine.g gVar = new com.xs.fm.player.sdk.play.player.audio.engine.g();
                this.b = gVar;
                gVar.setPlayerListener(this.c);
            }
            rl6.a aVar2 = lk6.c.a.v;
            if (aVar2 != null) {
                aVar2.l(playEngineInfo);
            }
            ml6.c cVar = ml6.c.a;
            rk6.a aVar3 = this.a;
            cVar.b(aVar3.a, c.c, aVar3.g, 2, aVar3.e, aVar3.k, aVar3.l, false);
            this.b.play(playEngineInfo);
        }
    }

    public static class a {
        private rk6.b a = null;
        private boolean b = false;
        private ArrayList<b> c = new ArrayList<>();
        public ArrayList<rk6.a> d = new ArrayList<>();

        static {
            Covode.recordClassIndex(655987);
        }

        public a h() {
            c.b.add(this);
            if (this.c.size() != 0) {
                this.c.get(0).h();
            } else {
                e();
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            if (this.b) {
                return;
            }
            this.b = true;
            c.b.remove(this);
            rk6.b bVar = this.a;
            if (bVar != null) {
                bVar.onFinish();
            }
            d.e.g();
            c.a.d("多Tip播放：全部Tip播放结束", new Object[0]);
        }

        /* renamed from: rl6.c$a$a, reason: collision with other inner class name */
        private class C0257a implements rk6.b {
            private rk6.b a;
            private int b;

            static {
                Covode.recordClassIndex(655988);
            }

            @Override // rk6.b
            public void onCancel() {
                rk6.b bVar = this.a;
                if (bVar != null) {
                    bVar.onCancel();
                }
                c.a.d("多Tip播放：当前Tip播放cancel", new Object[0]);
                if (this.b + 1 < a.this.c.size()) {
                    ((b) a.this.c.get(this.b + 1)).h();
                    c.a.d("多Tip播放：播放下一个:" + (this.b + 1), new Object[0]);
                    return;
                }
                a.this.e();
            }

            @Override // rk6.b
            public void onFinish() {
                rk6.b bVar = this.a;
                if (bVar != null) {
                    bVar.onFinish();
                }
                c.a.d("多Tip播放：当前Tip播放结束", new Object[0]);
                if (this.b + 1 < a.this.c.size()) {
                    ((b) a.this.c.get(this.b + 1)).h();
                    c.a.d("多Tip播放：播放下一个:" + (this.b + 1), new Object[0]);
                    return;
                }
                a.this.e();
            }

            public C0257a(int i, rk6.b bVar) {
                this.b = i;
                this.a = bVar;
            }
        }

        public void f() {
            if (this.b) {
                return;
            }
            this.b = true;
            c.b.remove(this);
            if (this.c.size() > 0) {
                Iterator<b> it2 = this.c.iterator();
                while (it2.hasNext()) {
                    it2.next().g();
                }
            }
            rk6.b bVar = this.a;
            if (bVar != null) {
                bVar.onCancel();
            }
            d.e.f();
            c.a.d("多Tip播放：全部Tip播放取消", new Object[0]);
        }

        public a c(rk6.b bVar) {
            this.a = bVar;
            return this;
        }

        public a d(rk6.a aVar) {
            c.a.d("addTip Tips, scene = " + aVar.g + ", url = " + aVar.a, new Object[0]);
            aVar.h = new C0257a(this.c.size(), aVar.h);
            this.d.add(aVar);
            this.c.add(new b(aVar));
            return this;
        }

        public boolean g(rk6.a aVar) {
            for (int size = c.b.size() - 1; size >= 0; size--) {
                a aVar2 = (a) c.b.get(size);
                for (int i = 0; i < aVar2.c.size(); i++) {
                    rk6.a aVar3 = aVar2.c.get(i).a;
                    if (TextUtils.equals(aVar3.a, aVar.a) && TextUtils.equals(aVar3.g, aVar.g)) {
                        c.a.b("Remove Duplicates Tips....", new Object[0]);
                        return false;
                    }
                }
            }
            return true;
        }
    }

    static {
        Covode.recordClassIndex(655986);
        a = new bl6.a("FMSDKPlayerTrace-TipPlayer");
        b = new CopyOnWriteArrayList<>();
        d = new HashSet();
    }

    public static void g() {
        Iterator<a> it2 = b.iterator();
        while (it2.hasNext()) {
            it2.next().c(null);
        }
    }

    public static void e() {
        try {
            CopyOnWriteArrayList<a> copyOnWriteArrayList = b;
            if (copyOnWriteArrayList.size() > 0) {
                Iterator<a> it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    it2.next().f();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void f() {
        g();
        Iterator<a> it2 = b.iterator();
        while (it2.hasNext()) {
            Iterator it4 = it2.next().c.iterator();
            while (it4.hasNext()) {
                ((b) it4.next()).a.h = null;
            }
        }
    }

    @Proxy("openConnection")
    @TargetClass("java.net.URL")
    @Skip({"com.bytedance.crash.upload.CrashUploader"})
    public static URLConnection a(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!k.o()) {
            return openConnection;
        }
        return u55.b.a(openConnection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String h(java.lang.String r6, java.lang.String r7) {
        /*
            bl6.a r0 = rl6.c.a
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "start getRealPlayUrl"
            r0.d(r3, r2)
            java.util.Set<java.lang.String> r0 = rl6.c.d
            boolean r0 = r0.contains(r6)
            if (r0 == 0) goto L13
            return r6
        L13:
            r0 = 1
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L42
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L42
            java.net.URLConnection r3 = a(r3)     // Catch: java.lang.Throwable -> L42
            java.net.URLConnection r3 = com.bytedance.apm.agent.instrumentation.HttpInstrumentation.openConnection(r3)     // Catch: java.lang.Throwable -> L42
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: java.lang.Throwable -> L42
            java.lang.String r2 = "GET"
            r3.setRequestMethod(r2)     // Catch: java.lang.Throwable -> L40
            r2 = 1000(0x3e8, float:1.401E-42)
            r3.setConnectTimeout(r2)     // Catch: java.lang.Throwable -> L40
            r3.setReadTimeout(r2)     // Catch: java.lang.Throwable -> L40
            int r2 = r3.getResponseCode()     // Catch: java.lang.Throwable -> L40
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 != r4) goto L3b
            r2 = 1
            goto L3c
        L3b:
            r2 = 0
        L3c:
            r3.disconnect()
            goto L4f
        L40:
            r2 = move-exception
            goto L46
        L42:
            r3 = move-exception
            r5 = r3
            r3 = r2
            r2 = r5
        L46:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L6d
            if (r3 == 0) goto L4e
            r3.disconnect()
        L4e:
            r2 = 0
        L4f:
            if (r2 == 0) goto L56
            java.util.Set<java.lang.String> r3 = rl6.c.d
            r3.add(r6)
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r6 = r7
        L5a:
            bl6.a r7 = rl6.c.a
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r3[r1] = r2
            r3[r0] = r6
            java.lang.String r0 = "hasCdnRes:%b, realUrl:%s"
            r7.d(r0, r3)
            return r6
        L6d:
            r6 = move-exception
            if (r3 == 0) goto L73
            r3.disconnect()
        L73:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: rl6.c.h(java.lang.String, java.lang.String):java.lang.String");
    }
}
