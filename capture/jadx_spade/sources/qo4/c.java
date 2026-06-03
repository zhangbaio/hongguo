package qo4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.base.l;
import com.dragon.read.kmp.j;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class c {
    public static final c a;

    static {
        Covode.recordClassIndex(609110);
        a = new c();
    }

    private c() {
    }

    public final String a(String orgUri, int i) {
        Intrinsics.checkNotNullParameter(orgUri, "orgUri");
        try {
            l a2 = l.i.a(orgUri);
            if (Intrinsics.areEqual("//guest_profile", "//" + a2.d)) {
                a2.a("enter_from_type", String.valueOf(i));
                return a2.c();
            }
        } catch (Exception e) {
            j.c(j.a, "GuestProfileUtil", "appendEnterFromForActorProfileLink error " + orgUri + ' ' + e.getMessage(), (Throwable) null, 4, (Object) null);
        }
        return orgUri;
    }
}
