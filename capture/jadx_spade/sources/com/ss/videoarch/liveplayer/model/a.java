package com.ss.videoarch.liveplayer.model;

import com.bytedance.covode.number.Covode;
import com.ss.videoarch.liveplayer.model.LiveStreamInfo;
import com.ss.videoarch.liveplayer.utils.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import zi6.f;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class a {
    private LiveURL[] a;
    private LiveStreamInfo b;
    private String[] c;
    public int d;
    private int e;

    static {
        Covode.recordClassIndex(653058);
    }

    public String B() {
        this.e++;
        return E();
    }

    public JSONObject C() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return null;
        }
        return liveStreamInfo.u();
    }

    public void G0() {
        this.e = 0;
        this.c = null;
        this.b = null;
        this.a = null;
    }

    public JSONObject J() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.N;
        }
        return null;
    }

    public JSONObject R() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.P;
        }
        return null;
    }

    public String X() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return "";
        }
        return liveStreamInfo.r0;
    }

    public LiveStreamInfo Y() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo;
        }
        return null;
    }

    public String Z() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return null;
        }
        return liveStreamInfo.u0;
    }

    public long b0() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.w0;
        }
        return -1L;
    }

    public String f() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.H;
        }
        return null;
    }

    public JSONObject f0() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return null;
        }
        return liveStreamInfo.S();
    }

    public String j() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.L;
        }
        return null;
    }

    public boolean l0() {
        HashMap<String, String> v = v();
        if (v != null && !v.isEmpty()) {
            return true;
        }
        return false;
    }

    public String m() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.K;
        }
        return null;
    }

    public String o() {
        LiveStreamInfo liveStreamInfo;
        if (this.d != 2 || (liveStreamInfo = this.b) == null) {
            return null;
        }
        return liveStreamInfo.d;
    }

    public String p() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return null;
        }
        return liveStreamInfo.B;
    }

    public int s() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.O;
        }
        return -1;
    }

    public boolean s0() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return false;
        }
        return liveStreamInfo.b0();
    }

    public boolean u0() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.R;
        }
        return false;
    }

    public HashMap<String, String> v() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return null;
        }
        return liveStreamInfo.p();
    }

    public boolean w0() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.S;
        }
        return false;
    }

    public String y() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.M;
        }
        return null;
    }

    public long z() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo != null) {
            return liveStreamInfo.i0;
        }
        return -1L;
    }

    public LiveURL D() {
        LiveURL[] liveURLArr = this.a;
        if (liveURLArr != null && liveURLArr.length != 0) {
            for (LiveURL liveURL : liveURLArr) {
                if (liveURL.mainURL != null) {
                    return liveURL;
                }
            }
        }
        return null;
    }

    public String E() {
        String[] strArr = this.c;
        if (strArr != null && strArr.length != 0) {
            int i = this.e;
            if (i >= strArr.length) {
                i = 0;
            }
            return strArr[i];
        }
        return null;
    }

    public String O() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.B();
        }
        return null;
    }

    public String S() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.F();
        }
        return null;
    }

    public long T() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.G();
        }
        return 0L;
    }

    public String a0() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.L();
        }
        return null;
    }

    public JSONObject d() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.d();
        }
        return null;
    }

    public boolean o0() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            com.ss.videoarch.liveplayer.log.a.c("LiveIonfo", "stream data is null");
            return false;
        }
        if (liveStreamInfo.a0 != 1) {
            return false;
        }
        return true;
    }

    public boolean p0() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            com.ss.videoarch.liveplayer.log.a.c("LiveIonfo", "stream data is null");
            return false;
        }
        if (liveStreamInfo.V != 1) {
            return false;
        }
        return true;
    }

    public String q() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            com.ss.videoarch.liveplayer.log.a.c("LiveIonfo", "stream data is null");
            return "h2q";
        }
        return liveStreamInfo.c0;
    }

    public Map<String, String> r() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.n();
        }
        return null;
    }

    public boolean r0() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            com.ss.videoarch.liveplayer.log.a.c("LiveIonfo", "stream data is null");
            return false;
        }
        if (liveStreamInfo.Y != 1) {
            return false;
        }
        return true;
    }

    public int t() {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.h0();
        }
        return -1;
    }

    public boolean v0() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            com.ss.videoarch.liveplayer.log.a.c("LiveIonfo", "stream data is null");
            return false;
        }
        if (liveStreamInfo.b0 != 1) {
            return false;
        }
        return true;
    }

    public boolean x0() {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            com.ss.videoarch.liveplayer.log.a.c("LiveIonfo", "stream data is null");
            return false;
        }
        if (liveStreamInfo.Z != 1) {
            return false;
        }
        return true;
    }

    public void H0(int i) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo != null) {
            liveStreamInfo.n = i;
        }
    }

    public void J0(int i) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo != null) {
            liveStreamInfo.f0 = i;
        }
    }

    public void K0(boolean z) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return;
        }
        liveStreamInfo.f = z;
    }

    public void M0(boolean z) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo != null) {
            liveStreamInfo.G = z;
        }
    }

    public void P0(int i) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo != null) {
            liveStreamInfo.m = i;
        }
    }

    public void R0(String str) {
        this.b.m0 = str;
    }

    public void S0(String str) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo != null) {
            liveStreamInfo.k0 = str;
        }
    }

    public void F0(HashSet<String> hashSet) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return;
        }
        liveStreamInfo.q0(hashSet);
    }

    public void I0(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.d != 2 || (liveStreamInfo = this.b) == null) {
            return;
        }
        liveStreamInfo.r0(str);
    }

    public void L0(int i) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return;
        }
        liveStreamInfo.s0(i);
    }

    public void T0(LiveStreamInfo liveStreamInfo) {
        this.b = liveStreamInfo;
        this.e = 0;
        this.d = 2;
    }

    public boolean U0(int i) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return false;
        }
        return liveStreamInfo.t0(i);
    }

    public JSONObject g0(String str) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return null;
        }
        return liveStreamInfo.T(str);
    }

    public boolean n0(String str) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return false;
        }
        return liveStreamInfo.a0(str);
    }

    public long w(String str) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return -1L;
        }
        return liveStreamInfo.q(str);
    }

    public String A(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.t(str);
        }
        return null;
    }

    public boolean E0(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.n0(str);
        }
        return false;
    }

    public int K(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.w(str);
        }
        return 0;
    }

    public JSONObject L(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.x(str);
        }
        return null;
    }

    public ArrayList<String> M(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONObject N = N(str);
        if (N != null) {
            Iterator<String> keys = N.keys();
            while (keys.hasNext()) {
                arrayList.add(keys.next());
            }
        }
        return arrayList;
    }

    public JSONObject N(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.z(str);
        }
        return null;
    }

    public int V(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.I(str);
        }
        return -1;
    }

    public JSONObject W(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.K(str);
        }
        return null;
    }

    public LiveStreamInfo.a b(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null && str != null) {
            return liveStreamInfo.b(str);
        }
        return null;
    }

    public JSONObject i(String str) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.h(str);
        }
        return null;
    }

    public boolean y0(float f) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.f0(f);
        }
        return false;
    }

    public boolean z0(float f) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.g0(f);
        }
        return false;
    }

    public LiveURL F(String str) {
        LiveURL[] liveURLArr;
        if (str != null && (liveURLArr = this.a) != null && liveURLArr.length != 0) {
            for (LiveURL liveURL : liveURLArr) {
                if (str.equals(liveURL.getVCodec()) && liveURL.mainURL != null) {
                    return liveURL;
                }
            }
        }
        return null;
    }

    public void N0(LiveURL[] liveURLArr) {
        this.a = liveURLArr;
        this.e = 0;
        this.d = 1;
        ArrayList arrayList = new ArrayList();
        for (LiveURL liveURL : liveURLArr) {
            String str = liveURL.mainURL;
            if (str != null) {
                arrayList.add(str);
            }
            String str2 = liveURL.backupURL;
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
        String[] strArr = new String[arrayList.size()];
        this.c = strArr;
        arrayList.toArray(strArr);
    }

    public boolean q0(int i) {
        String str;
        if (this.b == null) {
            com.ss.videoarch.liveplayer.log.a.c("LiveIonfo", "stream data is null");
            return false;
        }
        if (i == 1) {
            str = f.t().x(1100);
        } else {
            str = "";
        }
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo.X != 1 || !d.a(liveStreamInfo.W, str)) {
            return false;
        }
        return true;
    }

    public void V0(String str, String str2) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo != null) {
            liveStreamInfo.w0(str, str2);
        }
    }

    public String c0(String str, String str2) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return null;
        }
        return liveStreamInfo.O(str, str2);
    }

    public String d0(String str, String str2) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return null;
        }
        return liveStreamInfo.P(str, str2);
    }

    public String e0(String str, String str2) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return null;
        }
        return liveStreamInfo.Q(str, str2);
    }

    public long i0(String str, String str2) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return -1L;
        }
        return liveStreamInfo.V(str, str2);
    }

    public boolean D0(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.m0(str, str2);
        }
        return false;
    }

    public JSONObject P(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.D(str, str2);
        }
        return null;
    }

    public JSONObject Q(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.E(str, str2);
        }
        return null;
    }

    public String g(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.f(str, str2);
        }
        return null;
    }

    public long h(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.g(str, str2);
        }
        return 0L;
    }

    public String h0(String str, int i) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.U(str, i);
        }
        return null;
    }

    public String j0(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.W(str, str2);
        }
        return null;
    }

    public JSONObject k(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.i(str, str2);
        }
        return null;
    }

    public int k0(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.X(str, str2);
        }
        return -1;
    }

    public int l(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.j(str, str2);
        }
        return -1;
    }

    public String n(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.k(str, str2);
        }
        return null;
    }

    public boolean t0(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.d0(str, str2);
        }
        return false;
    }

    public JSONObject x(String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.s(str, str2);
        }
        return null;
    }

    public void O0(String str, String str2, String str3) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo != null) {
            liveStreamInfo.u0(str, str2, str3);
        }
    }

    public void Q0(String str, String str2, JSONObject jSONObject) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return;
        }
        liveStreamInfo.v0(str, str2, jSONObject);
    }

    public boolean a(String str, String str2, String str3) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return false;
        }
        return liveStreamInfo.a(str, str2, str3);
    }

    public boolean m0(String str, String str2, long j) {
        LiveStreamInfo liveStreamInfo = this.b;
        if (liveStreamInfo == null) {
            return false;
        }
        return liveStreamInfo.Z(str, str2, j);
    }

    public boolean A0(int i, int i2, boolean z) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.j0(i, i2, z);
        }
        return false;
    }

    public boolean B0(String str, String str2, boolean z) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.k0(str, str2, z);
        }
        return false;
    }

    public boolean C0(int i, int i2, boolean z) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.l0(i, i2, z);
        }
        return false;
    }

    public String G(String str, String str2, String str3) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.M(str, str2, str3);
        }
        return null;
    }

    public String H(String str, String str2, String str3) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.N(str, str2, str3);
        }
        return null;
    }

    public JSONObject U(String str, String str2, boolean z) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.H(str, str2, z);
        }
        return null;
    }

    public JSONObject c(String str, int i, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.c(str, i, str2);
        }
        return null;
    }

    public JSONObject e(String str, int i, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.e(str, i, str2);
        }
        return null;
    }

    public String u(long j, String str, String str2) {
        LiveStreamInfo liveStreamInfo;
        if (this.d == 2 && (liveStreamInfo = this.b) != null) {
            return liveStreamInfo.o(j, str, str2);
        }
        return null;
    }

    public String I(String str, String str2, String str3) {
        if (this.b == null) {
            return null;
        }
        if (("udpsdp".equals(str3) || "quicsdp".equals(str3)) && !"lls".equals(str)) {
            return null;
        }
        return this.b.v(str, str2, str3);
    }
}
