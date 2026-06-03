package jl6;

import al2.i0;
import android.os.Looper;
import androidx.collection.LruCache;
import com.bytedance.covode.number.Covode;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dragon.read.component.biz.api.NsXrayApi;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.xs.fm.player.base.play.address.PlayAddress;
import com.xs.fm.player.base.play.data.VoiceBgmInfoFromServer;
import com.xs.fm.player.sdk.play.address.PlayAddressCache;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import xk6.g;
import xk6.h;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a {
    private static final bl6.a a;
    private static final bl6.a b;
    private static final String c;
    private static final HashMap<String, LruCache<String, PlayAddressCache>> d;
    private static final HashMap<String, com.xs.fm.player.sdk.play.address.disklrucache.a> e;
    private static final C0199a f;
    public static final a g;

    private a() {
    }

    public final void g(String str, jl6.d dVar, ok6.c cVar) {
        k(this, str, dVar, cVar);
    }

    public final String n() {
        return c;
    }

    public static final class c implements ok6.a {
        final /* synthetic */ String a;
        final /* synthetic */ com.xs.fm.player.sdk.play.address.disklrucache.a b;

        /* renamed from: jl6.a$c$a, reason: collision with other inner class name */
        static final class RunnableC0200a implements Runnable {
            final /* synthetic */ PlayAddress b;

            RunnableC0200a(PlayAddress playAddress) {
                this.b = playAddress;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this.b != null) {
                    a.d(a.g).d(" after get disk cache, update save put to disk cache, cacheKey = " + c.this.a, new Object[0]);
                    PlayAddress a = jl6.b.a(this.b);
                    if (a != null) {
                        c cVar = c.this;
                        cVar.b.e(cVar.a, a);
                    }
                }
            }
        }

        c(String str, com.xs.fm.player.sdk.play.address.disklrucache.a aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // ok6.a
        public void a(PlayAddress playAddress, boolean z) {
            g.d(new RunnableC0200a(playAddress));
        }

        @Override // ok6.a
        public void b(int i, String str) {
            nk6.c cVar;
            a aVar = a.g;
            a.d(aVar).b("after get disk cache and update, fail update disk cache, code = " + i + ", errorMsg = " + str, new Object[0]);
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (cVar = bVar.m) != null && cVar.s(i)) {
                a.d(aVar).d("after get disk cache and update, remove disk cache, code = " + i + ", cacheKey=" + this.a + ", errorMsg = " + str, new Object[0]);
                this.b.f(this.a);
            }
        }
    }

    static final class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ PlayAddress b;
        final /* synthetic */ jl6.d c;

        b(String str, PlayAddress playAddress, jl6.d dVar) {
            this.a = str;
            this.b = playAddress;
            this.c = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.xs.fm.player.sdk.play.address.disklrucache.a m;
            a aVar = a.g;
            a.d(aVar).d(" after get memory cache, update save put to disk cache, cacheKey = " + this.a, new Object[0]);
            PlayAddress a = jl6.b.a(this.b);
            if (a != null && (m = aVar.m(Integer.valueOf(this.c.a.getGenreType()))) != null) {
                m.e(this.a, a);
            }
        }
    }

    public static final class d implements ok6.a {
        final /* synthetic */ ok6.c a;
        final /* synthetic */ jl6.d b;
        final /* synthetic */ String c;

        static final class b implements Runnable {
            final /* synthetic */ PlayAddress b;
            final /* synthetic */ boolean c;

            b(PlayAddress playAddress, boolean z) {
                this.b = playAddress;
                this.c = z;
            }

            /* renamed from: jl6.a$d$b$a, reason: collision with other inner class name */
            static final class RunnableC0202a implements Runnable {
                final /* synthetic */ com.xs.fm.player.sdk.play.address.disklrucache.a b;

                RunnableC0202a(com.xs.fm.player.sdk.play.address.disklrucache.a aVar) {
                    this.b = aVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.xs.fm.player.sdk.play.address.disklrucache.a aVar;
                    if (d.this.c != null) {
                        a.d(a.g).d("save put to disk cache from network, cacheKey = " + d.this.c, new Object[0]);
                        PlayAddress a = jl6.b.a(b.this.b);
                        if (a != null && (aVar = this.b) != null) {
                            aVar.e(d.this.c, a);
                        }
                    }
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                lk6.b bVar;
                nk6.c cVar;
                a aVar = a.g;
                if (!aVar.h(this.b) && !aVar.i(this.b)) {
                    if (!d.this.b.f) {
                        bl6.a d = a.d(aVar);
                        jl6.d dVar = d.this.b;
                        d.d("request success genreType = %s itemId = %s，playTone = %d, bgNoiseId = %d", Integer.valueOf(d.this.b.a.getGenreType()), dVar.b, Integer.valueOf(dVar.d), Integer.valueOf(d.this.b.e));
                    } else {
                        bl6.a e = a.e(aVar);
                        jl6.d dVar2 = d.this.b;
                        e.d("request success genreType = %s itemId = %s，playTone = %d, bgNoiseId = %d", Integer.valueOf(d.this.b.a.getGenreType()), dVar2.b, Integer.valueOf(dVar2.d), Integer.valueOf(d.this.b.e));
                    }
                    if (!this.c) {
                        aVar.f(d.this.c, new PlayAddressCache(this.b), Integer.valueOf(d.this.b.a.getGenreType()));
                        if (!d.this.b.f && (bVar = lk6.c.a) != null && (cVar = bVar.m) != null && cVar.j()) {
                            g.d(new RunnableC0202a(aVar.m(Integer.valueOf(d.this.b.a.getGenreType()))));
                        }
                    }
                    PlayAddress playAddress = this.b;
                    playAddress.cacheType = 3;
                    d dVar3 = d.this;
                    dVar3.a.b(playAddress, dVar3.b);
                    return;
                }
                a.d(aVar).d("playAddress is invalid, callBack fail, ", new Object[0]);
                d dVar4 = d.this;
                dVar4.a.a(-900000, "playAddress is invalid", dVar4.b);
            }
        }

        /* renamed from: jl6.a$d$a, reason: collision with other inner class name */
        static final class RunnableC0201a implements Runnable {
            final /* synthetic */ int b;
            final /* synthetic */ String c;

            RunnableC0201a(int i, String str) {
                this.b = i;
                this.c = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                nk6.c cVar;
                String str;
                Serializable serializable;
                VoiceBgmInfoFromServer voiceBgmInfoFromServer;
                nk6.c cVar2;
                if (!d.this.b.f) {
                    bl6.a d = a.d(a.g);
                    jl6.d dVar = d.this.b;
                    d.b("request fail dataType = %s itemId = %s，playTone = %d, bgNoiseId = %d", Integer.valueOf(d.this.b.a.getGenreType()), dVar.b, Integer.valueOf(dVar.d), Integer.valueOf(d.this.b.e));
                } else {
                    bl6.a e = a.e(a.g);
                    jl6.d dVar2 = d.this.b;
                    e.b("request fail dataType = %s itemId = %s，playTone = %d, bgNoiseId = %d", Integer.valueOf(d.this.b.a.getGenreType()), dVar2.b, Integer.valueOf(dVar2.d), Integer.valueOf(d.this.b.e));
                }
                a aVar = a.g;
                com.xs.fm.player.sdk.play.address.disklrucache.a m = aVar.m(Integer.valueOf(d.this.b.a.getGenreType()));
                lk6.b bVar = lk6.c.a;
                if (bVar != null && (cVar2 = bVar.m) != null && cVar2.s(this.b) && d.this.c != null) {
                    a.d(aVar).d("after get disk cache and update, remove disk cache, code = " + this.b + ", cacheKey=" + d.this.c + ", errorMsg = " + this.c, new Object[0]);
                    if (m != null) {
                        m.f(d.this.c);
                    }
                }
                d dVar3 = d.this;
                PlayAddress l = aVar.l(dVar3.c, Integer.valueOf(dVar3.b.a.getGenreType()));
                if (l == null && (str = d.this.c) != null) {
                    VoiceBgmInfoFromServer voiceBgmInfoFromServer2 = null;
                    if (m != null) {
                        serializable = m.c(str);
                    } else {
                        serializable = null;
                    }
                    if (!(serializable instanceof PlayAddress)) {
                        serializable = null;
                    }
                    PlayAddress playAddress = (PlayAddress) serializable;
                    bl6.a d2 = a.d(aVar);
                    StringBuilder sb = new StringBuilder();
                    sb.append("get disk cache, playAddress voiceBgmInfoFromServer = ");
                    if (playAddress != null) {
                        voiceBgmInfoFromServer2 = playAddress.voiceBgmInfoFromServer;
                    }
                    sb.append(voiceBgmInfoFromServer2);
                    d2.a(sb.toString(), new Object[0]);
                    if (playAddress != null && (voiceBgmInfoFromServer = playAddress.voiceBgmInfoFromServer) != null) {
                        voiceBgmInfoFromServer.bgmVideoModel = h.a.b(voiceBgmInfoFromServer.bgmVideoModelStr);
                    }
                    l = playAddress;
                }
                lk6.b bVar2 = lk6.c.a;
                if (bVar2 != null && (cVar = bVar2.m) != null && cVar.a(this.b) && l != null) {
                    a.d(aVar).b("enableVideoModelNoNetOpt=true and playAddress is not null, callBack.success, code = " + this.b, new Object[0]);
                    d dVar4 = d.this;
                    dVar4.a.b(l, dVar4.b);
                    return;
                }
                a.d(aVar).b("real fail, enableVideoModelNoNetOpt=false or playAddress is null, callBack.fail, code = " + this.b, new Object[0]);
                d dVar5 = d.this;
                dVar5.a.a(this.b, this.c, dVar5.b);
            }
        }

        @Override // ok6.a
        public void a(PlayAddress playAddress, boolean z) {
            a.g.p(new b(playAddress, z));
        }

        @Override // ok6.a
        public void b(int i, String str) {
            a.g.p(new RunnableC0201a(i, str));
        }

        d(ok6.c cVar, jl6.d dVar, String str) {
            this.a = cVar;
            this.b = dVar;
            this.c = str;
        }
    }

    static {
        int i;
        nk6.c cVar;
        Covode.recordClassIndex(655920);
        g = new a();
        a = new bl6.a("FMSDKPlayerTrace-PlayAddressCacheManager");
        b = new bl6.a("FMSDKPlayerPreload-PlayAddressCacheManager");
        c = c;
        d = new HashMap<>();
        e = new HashMap<>();
        lk6.b bVar = lk6.c.a;
        if (bVar != null && (cVar = bVar.m) != null) {
            i = cVar.d();
        } else {
            i = 50;
        }
        f = new C0199a(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0078, code lost:
    
        r3 = jl6.a.f;
        r4 = (com.xs.fm.player.sdk.play.address.PlayAddressCache) r3.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0080, code lost:
    
        if (r4 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0082, code lost:
    
        r4.setHasAddPreloadTask(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0085, code lost:
    
        r1 = (com.xs.fm.player.sdk.play.address.PlayAddressCache) r3.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008b, code lost:
    
        if (r1 == null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008d, code lost:
    
        r1.setAuditing(false);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void j() {
        /*
            r7 = this;
            monitor-enter(r7)
            bl6.a r0 = jl6.a.a     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = "clearAllCacheTaskFlag"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L93
            r0.d(r1, r3)     // Catch: java.lang.Throwable -> L93
            java.util.HashSet r0 = pl6.h.c()     // Catch: java.lang.Throwable -> L93
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L93
        L13:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L91
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L93
            lk6.b r3 = lk6.c.a     // Catch: java.lang.Throwable -> L93
            if (r3 == 0) goto L76
            nk6.c r3 = r3.m     // Catch: java.lang.Throwable -> L93
            if (r3 == 0) goto L76
            boolean r3 = r3.c()     // Catch: java.lang.Throwable -> L93
            r4 = 1
            if (r3 != r4) goto L76
            java.util.HashMap<java.lang.String, androidx.collection.LruCache<java.lang.String, com.xs.fm.player.sdk.play.address.PlayAddressCache>> r3 = jl6.a.d     // Catch: java.lang.Throwable -> L93
            java.util.Set r3 = r3.keySet()     // Catch: java.lang.Throwable -> L93
            java.lang.String r4 = "cacheMapForTag.keys"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)     // Catch: java.lang.Throwable -> L93
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch: java.lang.Throwable -> L93
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L93
        L3f:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L93
            if (r4 == 0) goto L13
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L93
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L3f
            java.util.HashMap<java.lang.String, androidx.collection.LruCache<java.lang.String, com.xs.fm.player.sdk.play.address.PlayAddressCache>> r5 = jl6.a.d     // Catch: java.lang.Throwable -> L93
            java.lang.Object r6 = r5.get(r4)     // Catch: java.lang.Throwable -> L93
            androidx.collection.LruCache r6 = (androidx.collection.LruCache) r6     // Catch: java.lang.Throwable -> L93
            if (r6 == 0) goto L62
            java.lang.Object r6 = r6.get(r1)     // Catch: java.lang.Throwable -> L93
            com.xs.fm.player.sdk.play.address.PlayAddressCache r6 = (com.xs.fm.player.sdk.play.address.PlayAddressCache) r6     // Catch: java.lang.Throwable -> L93
            if (r6 == 0) goto L62
            r6.setHasAddPreloadTask(r2)     // Catch: java.lang.Throwable -> L93
        L62:
            java.lang.Object r4 = r5.get(r4)     // Catch: java.lang.Throwable -> L93
            androidx.collection.LruCache r4 = (androidx.collection.LruCache) r4     // Catch: java.lang.Throwable -> L93
            if (r4 == 0) goto L3f
            java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Throwable -> L93
            com.xs.fm.player.sdk.play.address.PlayAddressCache r4 = (com.xs.fm.player.sdk.play.address.PlayAddressCache) r4     // Catch: java.lang.Throwable -> L93
            if (r4 == 0) goto L3f
            r4.setAuditing(r2)     // Catch: java.lang.Throwable -> L93
            goto L3f
        L76:
            if (r1 == 0) goto L13
            jl6.a$a r3 = jl6.a.f     // Catch: java.lang.Throwable -> L93
            java.lang.Object r4 = r3.get(r1)     // Catch: java.lang.Throwable -> L93
            com.xs.fm.player.sdk.play.address.PlayAddressCache r4 = (com.xs.fm.player.sdk.play.address.PlayAddressCache) r4     // Catch: java.lang.Throwable -> L93
            if (r4 == 0) goto L85
            r4.setHasAddPreloadTask(r2)     // Catch: java.lang.Throwable -> L93
        L85:
            java.lang.Object r1 = r3.get(r1)     // Catch: java.lang.Throwable -> L93
            com.xs.fm.player.sdk.play.address.PlayAddressCache r1 = (com.xs.fm.player.sdk.play.address.PlayAddressCache) r1     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L13
            r1.setAuditing(r2)     // Catch: java.lang.Throwable -> L93
            goto L13
        L91:
            monitor-exit(r7)
            return
        L93:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jl6.a.j():void");
    }

    /* renamed from: jl6.a$a, reason: collision with other inner class name */
    public static final class C0199a extends LruCache<String, PlayAddressCache> {
        C0199a(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z, String str, PlayAddressCache playAddressCache, PlayAddressCache playAddressCache2) {
            super.entryRemoved(z, str, playAddressCache, playAddressCache2);
            a.d(a.g).d("evicted = " + z + ", key = " + str + ", oldValue = " + playAddressCache + ", newValue = " + playAddressCache2, new Object[0]);
        }
    }

    public static final /* synthetic */ bl6.a d(a aVar) {
        return a;
    }

    public static final /* synthetic */ bl6.a e(a aVar) {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean h(PlayAddress playAddress) {
        lk6.b bVar;
        nk6.c cVar;
        if (!jl6.b.b(playAddress) && (bVar = lk6.c.a) != null && (cVar = bVar.m) != null && cVar.k(playAddress)) {
            return true;
        }
        return false;
    }

    public final void p(Runnable runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            new HandlerDelegate(Looper.getMainLooper()).post(runnable);
        }
    }

    public final synchronized void q(String str) {
        if (str != null) {
            a.d("tryRemoveVideoModelCache, key = " + str + ", removedVal = " + ((PlayAddressCache) f.remove(str)), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i(PlayAddress playAddress) {
        lk6.b bVar;
        nk6.c cVar;
        boolean z;
        if (playAddress == null) {
            return false;
        }
        try {
            if (playAddress.playType != 1 || (bVar = lk6.c.a) == null || (cVar = bVar.m) == null || !cVar.b()) {
                return false;
            }
            String str = playAddress.playFile;
            Intrinsics.checkExpressionValueIsNotNull(str, "playAddress.playFile");
            if (str.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z || new PolarisFileWrapper(playAddress.playFile).exists()) {
                return false;
            }
            String str2 = playAddress.playFile;
            Intrinsics.checkExpressionValueIsNotNull(str2, "playAddress.playFile");
            if (StringsKt__StringsJVMKt.startsWith$default(str2, "file:", false, 2, null)) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            a.b("checkPlayFileIsExist: e = " + e2, new Object[0]);
            return false;
        }
    }

    public final synchronized com.xs.fm.player.sdk.play.address.disklrucache.a m(Integer num) {
        nk6.c cVar;
        String str;
        Integer num2;
        lk6.b bVar = lk6.c.a;
        if (bVar != null) {
            cVar = bVar.m;
        } else {
            cVar = null;
        }
        if (cVar == null || !cVar.j()) {
            return null;
        }
        ok6.b t = cVar.t();
        if (t == null || (str = t.a(num)) == null) {
            str = "default";
        }
        HashMap<String, com.xs.fm.player.sdk.play.address.disklrucache.a> hashMap = e;
        com.xs.fm.player.sdk.play.address.disklrucache.a aVar = hashMap.get(str);
        if (aVar == null) {
            HashMap<String, Integer> o = cVar.o();
            if (o == null || (num2 = o.get(str)) == null) {
                num2 = 0;
            }
            Intrinsics.checkExpressionValueIsNotNull(num2, "playAddressCacheConfig.g…NumByTag()?.get(tag) ?: 0");
            int intValue = num2.intValue();
            if (!cVar.g()) {
                intValue = 100;
            }
            hashMap.put(str, new com.xs.fm.player.sdk.play.address.disklrucache.a(intValue, str));
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0006, B:7:0x000a, B:9:0x0011, B:11:0x0015, B:13:0x0019, B:15:0x001f, B:19:0x002a, B:21:0x0034, B:23:0x0049, B:31:0x003f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized com.xs.fm.player.base.play.address.PlayAddress l(java.lang.String r4, java.lang.Integer r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            lk6.b r0 = lk6.c.a     // Catch: java.lang.Throwable -> L4f
            r1 = 0
            if (r0 == 0) goto L3d
            nk6.c r0 = r0.m     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L3d
            boolean r0 = r0.c()     // Catch: java.lang.Throwable -> L4f
            r2 = 1
            if (r0 != r2) goto L3d
            lk6.b r0 = lk6.c.a     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L26
            nk6.c r0 = r0.m     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L26
            ok6.b r0 = r0.t()     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L26
            java.lang.String r5 = r0.a(r5)     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L26
            goto L28
        L26:
            java.lang.String r5 = "default"
        L28:
            if (r4 == 0) goto L3b
            java.util.HashMap<java.lang.String, androidx.collection.LruCache<java.lang.String, com.xs.fm.player.sdk.play.address.PlayAddressCache>> r0 = jl6.a.d     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r5 = r0.get(r5)     // Catch: java.lang.Throwable -> L4f
            androidx.collection.LruCache r5 = (androidx.collection.LruCache) r5     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L3b
            java.lang.Object r4 = r5.get(r4)     // Catch: java.lang.Throwable -> L4f
            com.xs.fm.player.sdk.play.address.PlayAddressCache r4 = (com.xs.fm.player.sdk.play.address.PlayAddressCache) r4     // Catch: java.lang.Throwable -> L4f
            goto L47
        L3b:
            r4 = r1
            goto L47
        L3d:
            if (r4 == 0) goto L3b
            jl6.a$a r5 = jl6.a.f     // Catch: java.lang.Throwable -> L4f
            java.lang.Object r4 = r5.get(r4)     // Catch: java.lang.Throwable -> L4f
            com.xs.fm.player.sdk.play.address.PlayAddressCache r4 = (com.xs.fm.player.sdk.play.address.PlayAddressCache) r4     // Catch: java.lang.Throwable -> L4f
        L47:
            if (r4 == 0) goto L4d
            com.xs.fm.player.base.play.address.PlayAddress r1 = r4.getPlayAddress()     // Catch: java.lang.Throwable -> L4f
        L4d:
            monitor-exit(r3)
            return r1
        L4f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: jl6.a.l(java.lang.String, java.lang.Integer):com.xs.fm.player.base.play.address.PlayAddress");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e2, code lost:
    
        if (r0.q() == true) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized com.xs.fm.player.base.play.address.PlayAddress o(java.lang.String r6, java.lang.Integer r7) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: jl6.a.o(java.lang.String, java.lang.Integer):com.xs.fm.player.base.play.address.PlayAddress");
    }

    public final synchronized void f(String str, PlayAddressCache playAddressCache, Integer num) {
        nk6.c cVar;
        String str2;
        Integer num2;
        nk6.c cVar2;
        HashMap<String, Integer> l;
        nk6.c cVar3;
        ok6.b t;
        if (str != null && playAddressCache != null) {
            lk6.b bVar = lk6.c.a;
            if (bVar != null && (cVar = bVar.m) != null && cVar.c()) {
                lk6.b bVar2 = lk6.c.a;
                if (bVar2 == null || (cVar3 = bVar2.m) == null || (t = cVar3.t()) == null || (str2 = t.a(num)) == null) {
                    str2 = "default";
                }
                HashMap<String, LruCache<String, PlayAddressCache>> hashMap = d;
                LruCache<String, PlayAddressCache> lruCache = hashMap.get(str2);
                if (lruCache != null) {
                    a.d("addCache: enableMultiTagCache=true, tag=" + str2 + ", key is " + str + " , tagCacheMap is not null and cacheNum = " + lruCache.size() + ",  data is " + playAddressCache, new Object[0]);
                    lruCache.put(str, playAddressCache);
                } else {
                    lk6.b bVar3 = lk6.c.a;
                    if (bVar3 == null || (cVar2 = bVar3.m) == null || (l = cVar2.l()) == null || (num2 = l.get(str2)) == null) {
                        num2 = 100;
                    }
                    Intrinsics.checkExpressionValueIsNotNull(num2, "PlayConfigUtil.playConfi…MapNum()?.get(tag) ?: 100");
                    LruCache<String, PlayAddressCache> lruCache2 = new LruCache<>(num2.intValue());
                    lruCache2.put(str, playAddressCache);
                    hashMap.put(str2, lruCache2);
                    a.d("addCache: enableMultiTagCache=true, tag=" + str2 + ", key is " + str + " , tagCacheMap is null and cacheNum = " + lruCache2.size() + ",  data is " + playAddressCache, new Object[0]);
                }
            } else {
                a.d("addCache: key is " + str + " and data is " + playAddressCache, new Object[0]);
                f.put(str, playAddressCache);
            }
        }
    }

    public final void a(String str, jl6.d dVar, ok6.c cVar) {
        qk6.a a2;
        lk6.b bVar;
        nk6.c cVar2;
        lk6.b bVar2;
        nk6.c cVar3;
        Serializable serializable;
        lk6.b bVar3;
        nk6.c cVar4;
        jl6.d a3;
        lk6.b bVar4;
        nk6.c cVar5;
        nk6.c cVar6;
        lk6.b bVar5 = lk6.c.a;
        if (bVar5 != null && (a2 = bVar5.a(dVar.a, dVar.c)) != null) {
            if (!dVar.f) {
                ll6.d.e.I(dVar);
            }
            if (dVar.g && (bVar = lk6.c.a) != null && (cVar2 = bVar.m) != null && cVar2.f()) {
                PlayAddress o = o(str, Integer.valueOf(dVar.a.getGenreType()));
                if (o != null && (bVar4 = lk6.c.a) != null && (cVar5 = bVar4.m) != null && cVar5.p(dVar, o)) {
                    if (!dVar.f) {
                        a.d("callPlayAddress: cacheKey = " + str + " validCache = " + o, new Object[0]);
                        lk6.b bVar6 = lk6.c.a;
                        if (bVar6 != null && (cVar6 = bVar6.m) != null && cVar6.j() && str != null) {
                            g.d(new b(str, o, dVar));
                        }
                    } else {
                        b.d("callPlayAddress: cacheKey = " + str + " validCache = " + o, new Object[0]);
                    }
                    o.isFromCache = true;
                    o.cacheType = 1;
                    cVar.b(o, dVar);
                    return;
                }
                bl6.a aVar = a;
                aVar.d("no valid cache", new Object[0]);
                q(str);
                if (str != null && !dVar.f && (bVar2 = lk6.c.a) != null && (cVar3 = bVar2.m) != null && cVar3.j()) {
                    com.xs.fm.player.sdk.play.address.disklrucache.a m = m(Integer.valueOf(dVar.a.getGenreType()));
                    if (m != null) {
                        serializable = m.c(str);
                    } else {
                        serializable = null;
                    }
                    if (serializable != null && (serializable instanceof PlayAddress) && (bVar3 = lk6.c.a) != null && (cVar4 = bVar3.m) != null) {
                        PlayAddress playAddress = (PlayAddress) serializable;
                        if (cVar4.p(dVar, playAddress)) {
                            playAddress.isFromDisk = true;
                            playAddress.cacheType = 2;
                            aVar.a("get disk cache, diskPlayAddressCache voiceBgmInfoFromServer = " + playAddress.voiceBgmInfoFromServer, new Object[0]);
                            VoiceBgmInfoFromServer voiceBgmInfoFromServer = playAddress.voiceBgmInfoFromServer;
                            if (voiceBgmInfoFromServer != null) {
                                voiceBgmInfoFromServer.bgmVideoModel = h.a.b(voiceBgmInfoFromServer.bgmVideoModelStr);
                            }
                            aVar.d("success get diskPlayAddressCache from disk cache, cacheKey = " + str, new Object[0]);
                            if (!h(playAddress) && !i(playAddress)) {
                                cVar.b(playAddress, dVar);
                                a3 = dVar.a((r20 & 1) != 0 ? dVar.a : null, (r20 & 2) != 0 ? dVar.b : null, (r20 & 4) != 0 ? dVar.c : null, (r20 & 8) != 0 ? dVar.d : 0, (r20 & 16) != 0 ? dVar.e : 0, (r20 & 32) != 0 ? dVar.f : true, (r20 & 64) != 0 ? dVar.g : false, (r20 & 128) != 0 ? dVar.h : false, (r20 & 256) != 0 ? dVar.i : null);
                                a2.i(a3, new c(str, m));
                                return;
                            }
                            aVar.d("diskPlayAddressCache is invalid, return", new Object[0]);
                        }
                    }
                }
            }
            a.d("try get playAddress, isPreload = " + dVar.f, new Object[0]);
            a2.i(dVar, new d(cVar, dVar, str));
        }
    }

    @TargetClass("com.xs.fm.player.sdk.play.address.PlayAddressCacheManager")
    @Insert("callPlayAddress")
    public static void k(a aVar, String str, jl6.d dVar, ok6.c cVar) {
        NsXrayApi nsXrayApi = NsXrayApi.IMPL;
        if (nsXrayApi.enable()) {
            i0.a.i("开始播放地址请求..." + dVar, new Object[0]);
            nsXrayApi.sendEvent("开始播放地址请求...", i0.h(new v03.g(), dVar));
        }
        aVar.a(str, dVar, cVar);
    }
}
