package com.dragon.read.kmp.profile.params;

import android.content.Context;
import cl4.p;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.cj0;
import com.dragon.read.kmp.compose.common.list.k;
import com.dragon.read.kmp.profile.guestprofile.viewmodel.GuestProfileViewModel;
import com.dragon.read.rpc.kmp.community.model.ProfileTab;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface a {
    void A(String str);

    k a();

    void b(String str);

    Map<String, String> c();

    void d(String str, float f, float f2, float f3, float f4);

    void e(String str, int i, String str2, ym4.k kVar, dl4.b bVar, Function1<? super String, Unit> function1);

    boolean enableMultiRoles();

    void f(String str, String str2, ym4.k kVar, p pVar);

    void g(String str, ym4.k kVar, int i, dl4.b bVar, ProfileTab profileTab);

    Map<String, String> getRequestSharkParam();

    void h(String str, int i, String str2, ym4.k kVar);

    boolean i(Integer num);

    void j(String str, ym4.k kVar, dl4.b bVar);

    boolean k();

    boolean l(Map<String, String> map);

    void m(int i, String str);

    void n(String str, ym4.k kVar);

    void o(int i);

    void p(cj0 cj0Var, com.dragon.read.kmp.profile.guestprofile.viewmodel.a aVar);

    void q(String str, ym4.k kVar, int i, dl4.b bVar, p pVar, ProfileTab profileTab);

    dl4.b r(boolean z, wl4.a aVar);

    void s(String str, String str2);

    boolean t();

    void u(String str, String str2, ym4.k kVar);

    void v(String str, cc4.a aVar, ym4.k kVar);

    void w(com.dragon.read.kmp.subscribe.a aVar, boolean z);

    void x(String str, ym4.k kVar);

    void y(String str);

    void z(String str, Context context);

    /* renamed from: com.dragon.read.kmp.profile.params.a$a, reason: collision with other inner class name */
    public static final class C0033a {
        static {
            Covode.recordClassIndex(608205);
        }

        public static boolean b(a aVar, Integer num) {
            return false;
        }

        public static boolean c(a aVar) {
            return true;
        }

        public static void d(a aVar, int i) {
            GuestProfileViewModel.U.a(i);
        }

        public static /* synthetic */ dl4.b a(a aVar, boolean z, wl4.a aVar2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                return aVar.r(z, aVar2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createKmpUgcVideoDataSource");
        }
    }
}
