package tn4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.kmp.share.manger.KmpShareManger;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class e implements vf1.b {
    static {
        Covode.recordClassIndex(608914);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final o e() {
        return new o();
    }

    public vf1.a buildConfig() {
        vf1.a aVar = new vf1.a();
        aVar.a("common_poster_share");
        aVar.b(new Function0() { // from class: tn4.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                o e;
                e = e.e();
                return e;
            }
        });
        aVar.d = k.a.a(new Function1() { // from class: tn4.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                vn4.a f;
                f = e.f(obj);
                return f;
            }
        }, new Function2() { // from class: tn4.c
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                String g;
                g = e.g((String) obj, (bh1.a) obj2);
                return g;
            }
        }, new Function2() { // from class: tn4.d
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit h;
                h = e.h((vn4.a) obj, (un4.e) obj2);
                return h;
            }
        });
        aVar.c = new a();
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vn4.a f(Object obj) {
        if (obj instanceof vn4.a) {
            return (vn4.a) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(String shareUrl, bh1.a channel) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(channel, "channel");
        com.dragon.read.kmp.share.manger.c cVar = com.dragon.read.kmp.share.manger.c.a;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return cVar.d(shareUrl, emptyMap, channel.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(vn4.a postParams, un4.e shareContent) {
        Intrinsics.checkNotNullParameter(postParams, "postParams");
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        k kVar = k.a;
        kVar.d(shareContent, kVar.b(shareContent, postParams));
        return Unit.INSTANCE;
    }

    public static final class a implements uh1.c {
        a() {
        }

        public List<bh1.a> a(List<bh1.a> channels, bh1.b params) {
            List<String> mutableListOf;
            Intrinsics.checkNotNullParameter(channels, "channels");
            Intrinsics.checkNotNullParameter(params, "params");
            if (channels.size() == 1 && Intrinsics.areEqual(((bh1.a) CollectionsKt___CollectionsKt.first((List) channels)).a, "copy_link")) {
                KmpShareManger kmpShareManger = KmpShareManger.a;
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("image_share");
                return kmpShareManger.t(params, mutableListOf);
            }
            return channels;
        }
    }
}
