package com.dragon.read.kmp.reader.detail.platform;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.text.TextUtils;
import c64.y;
import com.bytedance.covode.number.Covode;
import com.bytedance.kmp.reading.model.t3;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.q;
import com.dragon.read.base.Args;
import com.dragon.read.base.share2.model.ShareEntrance;
import com.dragon.read.base.share2.model.SharePanelBottomItem;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.component.biz.api.NsBookshelfApi;
import com.dragon.read.component.biz.api.NsReaderServiceApi;
import com.dragon.read.component.biz.api.NsShareProxy;
import com.dragon.read.component.biz.api.NsVipApi;
import com.dragon.read.component.download.base.api.NsDownloadApi;
import com.dragon.read.feedback.api.NsFeedbackApi;
import com.dragon.read.kmp.reader.detail.platform.j;
import com.dragon.read.kmp.service.b1;
import com.dragon.read.pages.bookshelf.model.BookType;
import com.dragon.read.pages.download.Status;
import com.dragon.read.reader.download.ClickBookDownloadAction;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.report.PageRecorderUtils;
import com.dragon.read.rpc.model.DislikeTargetType;
import com.dragon.read.rpc.model.PubPayType;
import com.dragon.read.rpc.model.ShareType;
import com.dragon.read.util.BookUtils;
import com.dragon.read.util.NetworkUtils;
import com.dragon.read.util.ToastUtils;
import com.dragon.read.util.w1;
import com.ss.android.messagebus.BusProvider;
import com.ss.android.ugc.bytex.taskmonitor.proxy.SingleDelegate;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import jp2.a;
import jp2.b;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import op1.g;
import qo3.p;
import vs4.r;
import vt4.c;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class j {
    public static final j a;

    static {
        Covode.recordClassIndex(608389);
        a = new j();
    }

    private j() {
    }

    public static final class c extends g.a {
        final /* synthetic */ String a;
        final /* synthetic */ b b;
        final /* synthetic */ Activity c;
        final /* synthetic */ t3 d;

        public void onPanelShow() {
            super.onPanelShow();
            Single observeOn = NsDownloadApi.IMPL.bookService().b(this.a).observeOn(AndroidSchedulers.mainThread());
            final Activity activity = this.c;
            final t3 t3Var = this.d;
            observeOn.subscribe(new Consumer() { // from class: com.dragon.read.kmp.reader.detail.platform.k
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    j.c.b(activity, t3Var, (Float) obj);
                }
            });
            IntentFilter intentFilter = new IntentFilter("action_chapter_download_progress");
            intentFilter.addCategory(this.a);
            AppUtils.registerLocalReceiver(this.b, intentFilter);
        }

        public void onPanelDismiss(boolean z) {
            super.onPanelDismiss(z);
            AppUtils.unregisterLocalReceiver(new BroadcastReceiver[]{this.b});
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(Activity activity, t3 t3Var, Float f) {
            j jVar = j.a;
            Intrinsics.checkNotNull(f);
            BusProvider.post(new y(jVar.h(activity, t3Var, f.floatValue())));
        }

        c(String str, b bVar, Activity activity, t3 t3Var) {
            this.a = str;
            this.b = bVar;
            this.c = activity;
            this.d = t3Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(boolean z) {
        return Unit.INSTANCE;
    }

    public static final class a implements c.a {
        final /* synthetic */ t3 a;

        a(t3 t3Var) {
            this.a = t3Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(Throwable th) {
            String stackTraceToString;
            Intrinsics.checkNotNull(th);
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(th);
            com.dragon.read.kmp.k.c("zjf", stackTraceToString);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(Boolean bool) {
            if (bool.booleanValue()) {
                ToastUtils.showCommonToastSafely(2131103024);
            } else {
                ToastUtils.showCommonToastSafely("下载成功");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(t3 t3Var, SingleEmitter emitter) {
            Intrinsics.checkNotNullParameter(emitter, "emitter");
            NsBookshelfApi nsBookshelfApi = NsBookshelfApi.IMPL;
            String str = t3Var.e;
            Intrinsics.checkNotNull(str);
            emitter.onSuccess(Boolean.valueOf(nsBookshelfApi.isInBookshelf(str, BookType.READ)));
        }

        public void f(String taskKey, Status status) {
            Intrinsics.checkNotNullParameter(taskKey, "taskKey");
            Intrinsics.checkNotNullParameter(status, "status");
            if (status == Status.ERROR) {
                ToastUtils.showCommonToastSafely("下载失败，请重试");
            } else if (status == Status.FINISH) {
                final t3 t3Var = this.a;
                SingleDelegate.create(new SingleOnSubscribe() { // from class: com.dragon.read.kmp.reader.detail.platform.g
                    @Override // io.reactivex.SingleOnSubscribe
                    public final void subscribe(SingleEmitter singleEmitter) {
                        j.a.k(t3Var, singleEmitter);
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() { // from class: com.dragon.read.kmp.reader.detail.platform.h
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        j.a.l((Boolean) obj);
                    }
                }, new Consumer() { // from class: com.dragon.read.kmp.reader.detail.platform.i
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        j.a.m((Throwable) obj);
                    }
                });
            }
        }
    }

    public static final class d implements ap2.h {
        final /* synthetic */ Activity a;
        final /* synthetic */ String b;
        final /* synthetic */ t3 c;
        final /* synthetic */ p55.a d;

        public void a(SharePanelBottomItem data) {
            String type;
            Intrinsics.checkNotNullParameter(data, "data");
            if (!TextUtils.isEmpty(data.getType()) && (type = data.getType()) != null) {
                int hashCode = type.hashCode();
                if (hashCode != 361037183) {
                    if (hashCode != 736860448) {
                        if (hashCode == 1759337451 && type.equals("type_reader_report")) {
                            NsFeedbackApi.IMPL.showFeedbackDialog(this.a, this.b, (String) null, BookUtils.isPublishBook(this.c.s), true, (Integer) null);
                            return;
                        }
                        return;
                    }
                    if (type.equals("type_dislike")) {
                        lv5.j.h("reader_detail", new Args().putAll(PageRecorderUtils.getParentPage(this.a).toArgs()).put("book_id", this.b), DislikeTargetType.Novel, this.b, this.a);
                        return;
                    }
                    return;
                }
                if (!type.equals("type_reader_download") || Intrinsics.areEqual(data.i, "已下载")) {
                    return;
                }
                j.a.e(this.a, this.c, this.d);
            }
        }

        d(Activity activity, String str, t3 t3Var, p55.a aVar) {
            this.a = activity;
            this.b = str;
            this.c = t3Var;
            this.d = aVar;
        }
    }

    private final Map<String, String> i(String str) {
        boolean z;
        int parseColor;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            parseColor = Color.parseColor("#000000");
        } else {
            parseColor = Color.parseColor(str);
        }
        float[] fArr = new float[3];
        Color.colorToHSV(parseColor, fArr);
        float f = fArr[0];
        String hexString = Integer.toHexString(Color.HSVToColor(w1.b(f)));
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(...)");
        String substring = hexString.substring(2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        String hexString2 = Integer.toHexString(Color.HSVToColor(w1.e(f)));
        Intrinsics.checkNotNullExpressionValue(hexString2, "toHexString(...)");
        String substring2 = hexString2.substring(2);
        Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
        String hexString3 = Integer.toHexString(Color.HSVToColor(w1.d(f)));
        Intrinsics.checkNotNullExpressionValue(hexString3, "toHexString(...)");
        String substring3 = hexString3.substring(2);
        Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
        HashMap hashMap = new HashMap();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s-%s-%s", Arrays.copyOf(new Object[]{substring, substring2, substring3}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        hashMap.put("bg", format);
        hashMap.put("book_detail_new_style", "1");
        return hashMap;
    }

    public static final class b extends BroadcastReceiver {
        final /* synthetic */ Activity a;
        final /* synthetic */ t3 b;

        b(Activity activity, t3 t3Var) {
            this.a = activity;
            this.b = t3Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            if (intent != null) {
                str = intent.getAction();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, "action_chapter_download_progress")) {
                BusProvider.post(new y(j.a.h(this.a, this.b, intent.getFloatExtra("key_download_percent", 0.0f))));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(p55.a aVar, ClickBookDownloadAction clickBookDownloadAction) {
        ClickBookDownloadAction clickBookDownloadAction2 = ClickBookDownloadAction.SHOW_SEE_AD_DIALOG;
        if (clickBookDownloadAction == clickBookDownloadAction2) {
            aVar.z("show_ad_enter", r.a.b());
        }
        if (!NetworkUtils.isNetworkAvailable() && clickBookDownloadAction != clickBookDownloadAction2) {
            ToastUtils.showCommonToastSafely(2131107331);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h(Context context, t3 t3Var, float f) {
        int i = (int) (f * 100);
        boolean z = false;
        if (i == 100) {
            if (!NsReaderServiceApi.IMPL.readerChapterService().p(t3Var.e, t3Var.v)) {
                Boolean bool = t3Var.C0;
                if (bool != null) {
                    z = bool.booleanValue();
                }
                if (!z || NsVipApi.IMPL.privilegeManager().isVip()) {
                    String string = context.getString(2131102960);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    return string;
                }
            }
            String string2 = context.getString(2131103890);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (i < 0) {
            String string3 = context.getString(2131102960);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        String string4 = context.getString(2131103034, format);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        return string4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(Context context, t3 t3Var, final p55.a aVar) {
        boolean z;
        int value;
        q qVar = q.b;
        if (qVar.isEnabled()) {
            qVar.b(context);
            return;
        }
        Boolean bool = t3Var.C0;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            z = false;
        }
        Integer num = t3Var.T0;
        if (num != null) {
            value = num.intValue();
        } else {
            value = PubPayType.VipForFree.getValue();
        }
        if (BookUtils.isPayTypeBook(z, PubPayType.findByValue(value))) {
            NsVipApi nsVipApi = NsVipApi.IMPL;
            String str = t3Var.e;
            Intrinsics.checkNotNull(str);
            if (!nsVipApi.isBuyPaidBook(str)) {
                ToastUtils.showCommonToastSafely("应版权方要求，仅付费后可下载");
                return;
            }
        }
        p bookDownloadPrivilegeHelper = NsCommonDepend.IMPL.bookDownloadPrivilegeHelper();
        String str2 = t3Var.e;
        Intrinsics.checkNotNull(str2);
        PageRecorder parentPage = PageRecorderUtils.getParentPage(context);
        Intrinsics.checkNotNullExpressionValue(parentPage, "getParentPage(...)");
        bookDownloadPrivilegeHelper.a(str2, context, parentPage, "active", "detail", new Function1() { // from class: com.dragon.read.kmp.reader.detail.platform.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f;
                f = j.f(aVar, (ClickBookDownloadAction) obj);
                return f;
            }
        }, new Function1() { // from class: com.dragon.read.kmp.reader.detail.platform.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g;
                g = j.g(((Boolean) obj).booleanValue());
                return g;
            }
        }, new a(t3Var));
        BusProvider.post(new y("下载中"));
        aVar.l(r.a.b(), "download");
        NsReaderServiceApi.IMPL.readerInitConfigService().n().g(true);
    }

    public final void j(String bookId, t3 bookDetailData, boolean z) {
        Activity activity;
        String str;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(bookDetailData, "bookDetailData");
        Context b2 = ig4.f.b();
        if (b2 instanceof Activity) {
            activity = (Activity) b2;
        } else {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        NsShareProxy nsShareProxy = NsShareProxy.INSTANCE;
        if (nsShareProxy.getNsShare() == null) {
            b1.a.D("资源加载中，请稍后重试");
            return;
        }
        p55.a aVar = new p55.a(activity);
        if (BookUtils.isPublishBook(bookDetailData.s)) {
            str = "publication";
        } else {
            str = "novel";
        }
        ShareEntrance shareEntrance = ShareEntrance.BOOK_DETAIL_FOLD;
        jp2.b bVar = new b.a(shareEntrance).b(bookId, ShareType.Book).g(new jp2.e((Args) null, 1, (DefaultConstructorMarker) null).g(bookId).y("book_detail").D(new jp2.d(shareEntrance, "book_detail").c(str, "book_id", bookId))).j(i(bookDetailData.H0)).a;
        ArrayList arrayList = new ArrayList();
        SharePanelBottomItem sharePanelBottomItem = new SharePanelBottomItem("type_reader_download");
        sharePanelBottomItem.s = 2130847543;
        sharePanelBottomItem.i = "下载";
        sharePanelBottomItem.p = false;
        arrayList.add(sharePanelBottomItem);
        lv5.g gVar = lv5.g.a;
        if (gVar.c(bookId)) {
            SharePanelBottomItem sharePanelBottomItem2 = new SharePanelBottomItem("type_dislike");
            sharePanelBottomItem2.s = 2130847944;
            if (gVar.f(bookId)) {
                i2 = 2131104525;
            } else {
                i2 = 2131104531;
            }
            sharePanelBottomItem2.g = i2;
            arrayList.add(sharePanelBottomItem2);
        }
        SharePanelBottomItem sharePanelBottomItem3 = new SharePanelBottomItem("type_reader_report");
        sharePanelBottomItem3.s = 2130848053;
        if (jy2.a.d().enableNew) {
            i = 2131105970;
        } else {
            i = 2131105967;
        }
        sharePanelBottomItem3.g = i;
        arrayList.add(sharePanelBottomItem3);
        nsShareProxy.showBookSharePanelWithType(activity, bVar, new a.a(true).f(true).a(arrayList).k(new c(bookId, new b(activity, bookDetailData), activity, bookDetailData)).c(new d(activity, bookId, bookDetailData, aVar)).b);
    }
}
