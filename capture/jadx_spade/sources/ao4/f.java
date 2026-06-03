package ao4;

import com.bytedance.covode.number.Covode;
import com.dragon.read.app.App;
import com.dragon.read.util.ToastUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class f extends a {
    static {
        Covode.recordClassIndex(608976);
    }

    @Override // ao4.a
    public boolean a() {
        return true;
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
        if (charSequence != null && charSequence.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
            return;
        }
        if (str == null) {
            mq1.a.L().e.b(App.context(), (String) ref$ObjectRef.element);
            return;
        }
        Observable subscribeOn = hp2.h.a.r(str).subscribeOn(Schedulers.io());
        final Function1 function1 = new Function1() { // from class: ao4.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g;
                g = f.g(Ref$ObjectRef.this, (String) obj);
                return g;
            }
        };
        Consumer consumer = new Consumer() { // from class: ao4.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                f.h(Function1.this, obj);
            }
        };
        final Function1 function12 = new Function1() { // from class: ao4.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i;
                i = f.i(Ref$ObjectRef.this, str, (Throwable) obj);
                return i;
            }
        };
        subscribeOn.subscribe(consumer, new Consumer() { // from class: ao4.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                f.j(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0017 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit g(kotlin.jvm.internal.Ref$ObjectRef r6, java.lang.String r7) {
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
            r3[r2] = r7     // Catch: java.util.IllegalFormatException -> L32
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
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            goto L59
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            T r1 = r6.element
            java.lang.String r1 = (java.lang.String) r1
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
        L59:
            r6.element = r0
            mq1.a r7 = mq1.a.L()
            pp1.c r7 = r7.e
            android.app.Application r0 = com.dragon.read.app.App.context()
            T r6 = r6.element
            java.lang.String r6 = (java.lang.String) r6
            r7.b(r0, r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ao4.f.g(kotlin.jvm.internal.Ref$ObjectRef, java.lang.String):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0017 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit i(kotlin.jvm.internal.Ref$ObjectRef r5, java.lang.String r6, java.lang.Throwable r7) {
        /*
            T r7 = r5.element
            java.lang.String r7 = (java.lang.String) r7
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L14
            r2 = 2
            r3 = 0
            java.lang.String r4 = "%s"
            boolean r7 = kotlin.text.StringsKt.contains$default(r7, r4, r1, r2, r3)
            if (r7 != r0) goto L14
            r7 = 1
            goto L15
        L14:
            r7 = 0
        L15:
            if (r7 == 0) goto L46
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE     // Catch: java.util.IllegalFormatException -> L32
            T r7 = r5.element     // Catch: java.util.IllegalFormatException -> L32
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch: java.util.IllegalFormatException -> L32
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.util.IllegalFormatException -> L32
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.util.IllegalFormatException -> L32
            r2[r1] = r6     // Catch: java.util.IllegalFormatException -> L32
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r2, r0)     // Catch: java.util.IllegalFormatException -> L32
            java.lang.String r7 = java.lang.String.format(r7, r0)     // Catch: java.util.IllegalFormatException -> L32
            java.lang.String r0 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)     // Catch: java.util.IllegalFormatException -> L32
            goto L59
        L32:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            T r0 = r5.element
            java.lang.String r0 = (java.lang.String) r0
            r7.append(r0)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            goto L59
        L46:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            T r0 = r5.element
            java.lang.String r0 = (java.lang.String) r0
            r7.append(r0)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
        L59:
            r5.element = r7
            mq1.a r6 = mq1.a.L()
            pp1.c r6 = r6.e
            android.app.Application r7 = com.dragon.read.app.App.context()
            T r5 = r5.element
            java.lang.String r5 = (java.lang.String) r5
            r6.b(r7, r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ao4.f.i(kotlin.jvm.internal.Ref$ObjectRef, java.lang.String, java.lang.Throwable):kotlin.Unit");
    }
}
