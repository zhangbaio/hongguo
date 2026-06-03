package com.xs.fm.player.sdk.play.address.disklrucache;

import com.bytedance.covode.number.Covode;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import lk6.b;
import nk6.c;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public final class a extends PlayAddressDiskCache {
    public static final C0133a f;
    public final int d;
    public final String e;

    static {
        Covode.recordClassIndex(655928);
        f = new C0133a(null);
    }

    /* renamed from: com.xs.fm.player.sdk.play.address.disklrucache.a$a, reason: collision with other inner class name */
    public static final class C0133a {
        static {
            Covode.recordClassIndex(655929);
        }

        private C0133a() {
        }

        public /* synthetic */ C0133a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.xs.fm.player.sdk.play.address.disklrucache.PlayAddressDiskCache
    public void g(String str) {
        c cVar;
        b bVar = lk6.c.a;
        if (bVar != null && (cVar = bVar.m) != null) {
            cVar.e("play_address_disk_cache", this.e, str);
        }
    }

    @Override // com.xs.fm.player.sdk.play.address.disklrucache.PlayAddressDiskCache
    public Serializable d(String str) {
        c cVar;
        b bVar = lk6.c.a;
        if (bVar != null && (cVar = bVar.m) != null) {
            return cVar.n("play_address_disk_cache", this.e, str);
        }
        return null;
    }

    public a(int i, String str) {
        super(i);
        this.d = i;
        this.e = str;
    }

    @Override // com.xs.fm.player.sdk.play.address.disklrucache.PlayAddressDiskCache
    public void h(String str, Serializable serializable) {
        c cVar;
        c cVar2;
        b bVar;
        c cVar3;
        b bVar2 = lk6.c.a;
        long j = 5242880;
        if (bVar2 != null && (cVar2 = bVar2.m) != null && cVar2.h() && (bVar = lk6.c.a) != null && (cVar3 = bVar.m) != null) {
            j = cVar3.r();
        }
        long j2 = j;
        b bVar3 = lk6.c.a;
        if (bVar3 != null && (cVar = bVar3.m) != null) {
            cVar.m("play_address_disk_cache", this.e, str, j2, this.d, serializable);
        }
    }
}
