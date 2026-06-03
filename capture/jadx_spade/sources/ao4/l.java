package ao4;

import android.net.Uri;
import com.bytedance.covode.number.Covode;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.dragon.read.app.App;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.util.ToastUtils;
import com.ss.android.common.util.ToolUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class l extends a {
    static {
        Covode.recordClassIndex(608978);
    }

    @Override // ao4.a
    public boolean a() {
        return hp2.h.a.p();
    }

    public final void k(String str) {
        boolean z;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
            return;
        }
        if (ToolUtils.isInstalledApp(App.context(), "com.ss.android.ugc.aweme")) {
            mq1.a.L().e.b(App.context(), str);
            ToastUtils.showCommonToastSafely("链接已复制，快去分享吧");
            ContextUtils.startActivity(App.context(), Uri.parse("snssdk1128://"));
        } else {
            if (ToolUtils.isInstalledApp(App.context(), "com.ss.android.ugc.aweme.lite")) {
                mq1.a.L().e.b(App.context(), str);
                ToastUtils.showCommonToastSafely("链接已复制，快去分享吧");
                ContextUtils.startActivity(App.context(), Uri.parse("snssdk2329://"));
                return;
            }
            ToastUtils.showCommonToastSafely("未安装抖音");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [T, java.lang.String] */
    @Override // ao4.a
    public void b(un4.e kmpShareContent) {
        Intrinsics.checkNotNullParameter(kmpShareContent, "kmpShareContent");
        int i = kmpShareContent.a;
        boolean z = false;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
                    return;
                }
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = kmpShareContent.c;
                final String str = kmpShareContent.f;
                if (kmpShareContent.h) {
                    if (str == null || str.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        Observable observeOn = hp2.h.a.r(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                        final Function1 function1 = new Function1() { // from class: ao4.h
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit g;
                                g = l.g(Ref$ObjectRef.this, this, (String) obj);
                                return g;
                            }
                        };
                        Consumer consumer = new Consumer() { // from class: ao4.i
                            @Override // io.reactivex.functions.Consumer
                            public final void accept(Object obj) {
                                l.h(Function1.this, obj);
                            }
                        };
                        final Function1 function12 = new Function1() { // from class: ao4.j
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit i2;
                                i2 = l.i(Ref$ObjectRef.this, str, this, (Throwable) obj);
                                return i2;
                            }
                        };
                        observeOn.subscribe(consumer, new Consumer() { // from class: ao4.k
                            @Override // io.reactivex.functions.Consumer
                            public final void accept(Object obj) {
                                l.j(Function1.this, obj);
                            }
                        });
                        return;
                    }
                }
                k((String) ref$ObjectRef.element);
                return;
            }
            String str2 = kmpShareContent.e;
            if (str2 == null || str2.length() == 0) {
                z = true;
            }
            if (z) {
                ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
                return;
            } else {
                ShareSdkManager.getInstance().setShareEventCallback((op1.j) null);
                tq1.g.b(App.context(), qn4.a.a.b(ShareChannelType.DOUYIN_IM, str2).f());
                return;
            }
        }
        String str3 = kmpShareContent.f;
        if (str3 == null || str3.length() == 0) {
            z = true;
        }
        if (z) {
            ToastUtils.showCommonToastSafely(App.context().getString(2131106555));
        } else {
            ShareSdkManager.getInstance().setShareEventCallback((op1.j) null);
            tq1.g.b(App.context(), qn4.a.a.a(ShareChannelType.DOUYIN_IM, kmpShareContent, str3).f());
        }
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
    /* JADX WARN: Type inference failed for: r0v10, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit g(kotlin.jvm.internal.Ref$ObjectRef r6, ao4.l r7, java.lang.String r8) {
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
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            r7.k(r0)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ao4.l.g(kotlin.jvm.internal.Ref$ObjectRef, ao4.l, java.lang.String):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0017 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /* JADX WARN: Type inference failed for: r8v11, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit i(kotlin.jvm.internal.Ref$ObjectRef r5, java.lang.String r6, ao4.l r7, java.lang.Throwable r8) {
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
            r5 = r8
            java.lang.String r5 = (java.lang.String) r5
            r7.k(r8)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ao4.l.i(kotlin.jvm.internal.Ref$ObjectRef, java.lang.String, ao4.l, java.lang.Throwable):kotlin.Unit");
    }
}
