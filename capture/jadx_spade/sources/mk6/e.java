package mk6;

import com.bytedance.covode.number.Covode;
import com.xs.fm.player.base.play.address.PlayAddress;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class e implements nk6.c {
    private final a a = new a();

    public static final class a implements ok6.b {
        a() {
        }

        @Override // ok6.b
        public String a(Integer num) {
            return "default";
        }
    }

    static {
        Covode.recordClassIndex(655793);
    }

    @Override // nk6.c
    public boolean a(int i) {
        return false;
    }

    @Override // nk6.c
    public boolean b() {
        return false;
    }

    @Override // nk6.c
    public boolean c() {
        return false;
    }

    @Override // nk6.c
    public int d() {
        return 50;
    }

    @Override // nk6.c
    public void e(String str, String str2, String str3) {
    }

    @Override // nk6.c
    public boolean f() {
        return true;
    }

    @Override // nk6.c
    public boolean g() {
        return false;
    }

    @Override // nk6.c
    public boolean h() {
        return false;
    }

    @Override // nk6.c
    public int i() {
        return 2700000;
    }

    @Override // nk6.c
    public boolean j() {
        return false;
    }

    @Override // nk6.c
    public boolean k(PlayAddress playAddress) {
        return false;
    }

    @Override // nk6.c
    public void m(String str, String str2, String str3, long j, int i, Serializable serializable) {
    }

    @Override // nk6.c
    public Serializable n(String str, String str2, String str3) {
        return null;
    }

    @Override // nk6.c
    public boolean p(jl6.d dVar, PlayAddress playAddress) {
        return true;
    }

    @Override // nk6.c
    public boolean q() {
        return false;
    }

    @Override // nk6.c
    public long r() {
        return 5242880L;
    }

    @Override // nk6.c
    public boolean s(int i) {
        return true;
    }

    @Override // nk6.c
    public ok6.b t() {
        return this.a;
    }

    @Override // nk6.c
    public HashMap<String, Integer> l() {
        HashMap<String, Integer> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("default", 100));
        return hashMapOf;
    }

    @Override // nk6.c
    public HashMap<String, Integer> o() {
        HashMap<String, Integer> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("default", 0));
        return hashMapOf;
    }
}
