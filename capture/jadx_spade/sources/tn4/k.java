package tn4;

import com.bytedance.covode.number.Covode;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import tn4.k;
import xn4.e0;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class k {
    public static final k a;

    static {
        Covode.recordClassIndex(608915);
        a = new k();
    }

    private k() {
    }

    public final boolean c(String channelId) {
        List listOf;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"xhs", "douyin_feed"});
        return listOf.contains(channelId);
    }

    public static final class a implements uh1.d {
        final /* synthetic */ Function1<Object, T> a;
        final /* synthetic */ Function2<String, bh1.a, String> b;
        final /* synthetic */ Function2<T, un4.e, Unit> c;

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(Function1 function1, Object obj) {
            function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(Function1 function1, Object obj) {
            function1.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit j(Function0 function0, Throwable th) {
            function0.invoke();
            return Unit.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<Object, ? extends T> function1, Function2<? super String, ? super bh1.a, String> function2, Function2<? super T, ? super un4.e, Unit> function22) {
            this.a = function1;
            this.b = function2;
            this.c = function22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(Function2 function2, un4.j jVar, un4.e eVar, Function1 function1) {
            function2.invoke(jVar, eVar);
            function1.invoke(eVar);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(un4.e eVar, un4.j jVar, Function0 function0, String str) {
            eVar.f = str;
            MutableStateFlow<String> mutableStateFlow = jVar.j;
            Intrinsics.checkNotNull(str);
            mutableStateFlow.setValue(str);
            function0.invoke();
            return Unit.INSTANCE;
        }

        public void a(Object obj, Object obj2, bh1.a channel, final Function1<Object, Unit> completion) {
            final un4.e eVar;
            Intrinsics.checkNotNullParameter(channel, "channel");
            Intrinsics.checkNotNullParameter(completion, "completion");
            if (obj2 instanceof un4.e) {
                eVar = (un4.e) obj2;
            } else {
                eVar = null;
            }
            if (eVar == null) {
                completion.invoke(obj2);
                return;
            }
            String str = eVar.f;
            if (str != null) {
                eVar.f = this.b.invoke(str, channel);
            }
            final un4.j jVar = (un4.j) this.a.invoke(obj);
            if (jVar == null) {
                completion.invoke(obj2);
                return;
            }
            final Function2<T, un4.e, Unit> function2 = this.c;
            final Function0 function0 = new Function0() { // from class: tn4.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit g;
                    g = k.a.g(Function2.this, jVar, eVar, completion);
                    return g;
                }
            };
            if (jVar.m == null) {
                function0.invoke();
                return;
            }
            com.dragon.read.kmp.share.manger.c cVar = com.dragon.read.kmp.share.manger.c.a;
            String str2 = eVar.f;
            if (str2 == null) {
                str2 = "";
            }
            Observable<String> e = cVar.e(str2);
            final Function1 function1 = new Function1() { // from class: tn4.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    Unit h;
                    h = k.a.h(un4.e.this, jVar, function0, (String) obj3);
                    return h;
                }
            };
            Consumer<? super String> consumer = new Consumer() { // from class: tn4.h
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj3) {
                    k.a.i(Function1.this, obj3);
                }
            };
            final Function1 function12 = new Function1() { // from class: tn4.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    Unit j;
                    j = k.a.j(Function0.this, (Throwable) obj3);
                    return j;
                }
            };
            e.subscribe(consumer, new Consumer() { // from class: tn4.j
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj3) {
                    k.a.k(Function1.this, obj3);
                }
            });
        }
    }

    public final void d(un4.e shareContent, un4.h hVar) {
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        shareContent.g = hVar;
        shareContent.e = e0.a.i(hVar);
    }

    public final un4.h b(un4.e shareContent, vn4.a postParams) {
        boolean z;
        String value;
        boolean z2;
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        Intrinsics.checkNotNullParameter(postParams, "postParams");
        if (postParams.l()) {
            String str = shareContent.b;
            if (str == null) {
                str = "";
            }
            if (!c(str)) {
                String h = postParams.h();
                vn4.d i = postParams.i();
                String value2 = postParams.j.getValue();
                boolean z3 = false;
                if (value2 != null && value2.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    value = shareContent.f;
                } else {
                    value = postParams.j.getValue();
                }
                if (h != null && !StringsKt__StringsKt.isBlank(h)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    if (value == null || StringsKt__StringsKt.isBlank(value)) {
                        z3 = true;
                    }
                    if (!z3 && i != null) {
                        e0 e0Var = e0.a;
                        un4.h h2 = e0Var.h(h, value, i);
                        if (h2 == null) {
                            return e0Var.a(h);
                        }
                        return h2;
                    }
                }
                e0 e0Var2 = e0.a;
                un4.h a2 = e0Var2.a(h);
                if (a2 == null) {
                    return e0Var2.a(postParams.g());
                }
                return a2;
            }
        }
        return e0.a.a(postParams.g());
    }

    public final <T extends un4.j> uh1.d a(Function1<Object, ? extends T> castPostParams, Function2<? super String, ? super bh1.a, String> appendShareUrl, Function2<? super T, ? super un4.e, Unit> updatePoster) {
        Intrinsics.checkNotNullParameter(castPostParams, "castPostParams");
        Intrinsics.checkNotNullParameter(appendShareUrl, "appendShareUrl");
        Intrinsics.checkNotNullParameter(updatePoster, "updatePoster");
        return new a(castPostParams, appendShareUrl, updatePoster);
    }
}
