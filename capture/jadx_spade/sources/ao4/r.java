package ao4;

import com.bytedance.covode.number.Covode;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.dragon.read.app.App;
import com.dragon.read.util.ToastUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class r extends a {
    static {
        Covode.recordClassIndex(608980);
    }

    @Override // ao4.a
    public boolean a() {
        return true;
    }

    public final ShareContent g(String str) {
        com.bytedance.ug.sdk.share.api.entity.c cVar = new com.bytedance.ug.sdk.share.api.entity.c();
        cVar.c = str;
        com.bytedance.ug.sdk.share.api.entity.a aVar = new com.bytedance.ug.sdk.share.api.entity.a();
        aVar.h = cVar;
        qn4.a aVar2 = qn4.a.a;
        ShareChannelType shareChannelType = ShareChannelType.SYSTEM;
        if (str == null) {
            str = "";
        }
        ShareContent f = aVar2.c(shareChannelType, str).l(aVar).f();
        Intrinsics.checkNotNullExpressionValue(f, "build(...)");
        return f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, java.lang.String] */
    @Override // ao4.a
    public void b(un4.e kmpShareContent) {
        boolean z;
        Intrinsics.checkNotNullParameter(kmpShareContent, "kmpShareContent");
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? r1 = kmpShareContent.c;
        ref$ObjectRef.element = r1;
        final String str = kmpShareContent.f;
        CharSequence charSequence = (CharSequence) r1;
        boolean z2 = false;
        if (charSequence != null && charSequence.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
            return;
        }
        if (kmpShareContent.h) {
            if (str == null || str.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                Observable observeOn = hp2.h.a.r(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                final Function1 function1 = new Function1() { // from class: ao4.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit h;
                        h = r.h(Ref$ObjectRef.this, this, (String) obj);
                        return h;
                    }
                };
                Consumer consumer = new Consumer() { // from class: ao4.o
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        r.i(Function1.this, obj);
                    }
                };
                final Function1 function12 = new Function1() { // from class: ao4.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit j;
                        j = r.j(Ref$ObjectRef.this, str, this, (Throwable) obj);
                        return j;
                    }
                };
                observeOn.subscribe(consumer, new Consumer() { // from class: ao4.q
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        r.k(Function1.this, obj);
                    }
                });
                return;
            }
        }
        tq1.g.b(App.context(), g((String) ref$ObjectRef.element));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0017 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit h(kotlin.jvm.internal.Ref$ObjectRef r6, ao4.r r7, java.lang.String r8) {
        /*
            T r0 = r6.element
            java.lang.String r0 = (java.lang.String) r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L14
            r3 = 2
            r4 = 0
            java.lang.String r5 = "%s"
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r5, r2, r3, r4)
            if (r0 != r1) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L46
            kotlin.jvm.internal.StringCompanionObject r0 = kotlin.jvm.internal.StringCompanionObject.INSTANCE     // Catch: java.util.IllegalFormatException -> L32
            T r0 = r6.element     // Catch: java.util.IllegalFormatException -> L32
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch: java.util.IllegalFormatException -> L32
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.util.IllegalFormatException -> L32
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.util.IllegalFormatException -> L32
            r3[r2] = r8     // Catch: java.util.IllegalFormatException -> L32
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r3, r1)     // Catch: java.util.IllegalFormatException -> L32
            java.lang.String r0 = java.lang.String.format(r0, r1)     // Catch: java.util.IllegalFormatException -> L32
            java.lang.String r1 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: java.util.IllegalFormatException -> L32
            goto L59
        L32:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            T r1 = r6.element
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            goto L59
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            T r1 = r6.element
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
        L59:
            r6.element = r0
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8
            if (r0 == 0) goto L6f
            android.app.Application r8 = com.dragon.read.app.App.context()
            T r6 = r6.element
            java.lang.String r6 = (java.lang.String) r6
            com.bytedance.ug.sdk.share.api.entity.ShareContent r6 = r7.g(r6)
            tq1.g.b(r8, r6)
        L6f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ao4.r.h(kotlin.jvm.internal.Ref$ObjectRef, ao4.r, java.lang.String):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0017 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit j(kotlin.jvm.internal.Ref$ObjectRef r5, java.lang.String r6, ao4.r r7, java.lang.Throwable r8) {
        /*
            T r8 = r5.element
            java.lang.String r8 = (java.lang.String) r8
            r0 = 1
            r1 = 0
            if (r8 == 0) goto L14
            r2 = 2
            r3 = 0
            java.lang.String r4 = "%s"
            boolean r8 = kotlin.text.StringsKt.contains$default(r8, r4, r1, r2, r3)
            if (r8 != r0) goto L14
            r8 = 1
            goto L15
        L14:
            r8 = 0
        L15:
            if (r8 == 0) goto L46
            kotlin.jvm.internal.StringCompanionObject r8 = kotlin.jvm.internal.StringCompanionObject.INSTANCE     // Catch: java.util.IllegalFormatException -> L32
            T r8 = r5.element     // Catch: java.util.IllegalFormatException -> L32
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch: java.util.IllegalFormatException -> L32
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.util.IllegalFormatException -> L32
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.util.IllegalFormatException -> L32
            r2[r1] = r6     // Catch: java.util.IllegalFormatException -> L32
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r2, r0)     // Catch: java.util.IllegalFormatException -> L32
            java.lang.String r8 = java.lang.String.format(r8, r0)     // Catch: java.util.IllegalFormatException -> L32
            java.lang.String r0 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)     // Catch: java.util.IllegalFormatException -> L32
            goto L59
        L32:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            T r0 = r5.element
            java.lang.String r0 = (java.lang.String) r0
            r8.append(r0)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
            goto L59
        L46:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            T r0 = r5.element
            java.lang.String r0 = (java.lang.String) r0
            r8.append(r0)
            r8.append(r6)
            java.lang.String r8 = r8.toString()
        L59:
            r5.element = r8
            android.app.Application r6 = com.dragon.read.app.App.context()
            T r5 = r5.element
            java.lang.String r5 = (java.lang.String) r5
            com.bytedance.ug.sdk.share.api.entity.ShareContent r5 = r7.g(r5)
            tq1.g.b(r6, r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ao4.r.j(kotlin.jvm.internal.Ref$ObjectRef, java.lang.String, ao4.r, java.lang.Throwable):kotlin.Unit");
    }
}
