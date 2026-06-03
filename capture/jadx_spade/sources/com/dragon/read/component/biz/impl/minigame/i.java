package com.dragon.read.component.biz.impl.minigame;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ca3.a;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.base.skin.SkinDelegate;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.recyler.AbsRecyclerViewHolder;
import com.dragon.read.recyler.IHolderFactory;
import com.dragon.read.recyler.RecyclerClient;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.rpc.model.ReportAdRequest;
import com.dragon.read.rpc.model.ReportAdScene;
import com.dragon.read.util.ToastUtils;
import gg3.c;
import gg3.e;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class i extends a {
    public static final int n;
    private final Context c;
    private final List<c> d;
    private final String e;
    private final String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private JSONObject k;
    private String l;
    private String m;

    static {
        Covode.recordClassIndex(594686);
        n = 8;
    }

    public void initDialog() {
        super/*com.dragon.read.widget.dialog.AnimationSwipeBottomDialog*/.initDialog();
        getSwipeBackLayout().setEnableLeftSideSlipPullDown(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        WindowManager.LayoutParams layoutParams;
        Window window;
        super/*com.dragon.read.widget.dialog.AnimationBottomDialog*/.onCreate(bundle);
        View inflate = LayoutInflater.from(this.c).inflate(2131040773, (ViewGroup) getContentContainer(), true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        Window window2 = getWindow();
        if (window2 != null) {
            layoutParams = window2.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 80;
        }
        if (layoutParams != null) {
            layoutParams.width = -1;
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setAttributes(layoutParams);
        }
        RecyclerView findViewById = inflate.findViewById(2131821033);
        RecyclerClient recyclerClient = new RecyclerClient();
        recyclerClient.register(c.class, new IHolderFactory() { // from class: com.dragon.read.component.biz.impl.minigame.f
            public final AbsRecyclerViewHolder createHolder(ViewGroup viewGroup) {
                AbsRecyclerViewHolder f0;
                f0 = i.f0(i.this, viewGroup);
                return f0;
            }
        });
        findViewById.setAdapter(recyclerClient);
        findViewById.setLayoutManager(new LinearLayoutManager(this.c));
        recyclerClient.dispatchDataUpdate(this.d);
        Activity activity = ContextUtils.getActivity(this.c);
        int i = 2131558463;
        if (activity != null && (window = activity.getWindow()) != null) {
            ContextUtils.setNavigationBar(window, SkinDelegate.getSkinColor(this.c, 2131558463), 255);
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.setBackgroundDrawable(new ColorDrawable(0));
            window4.setDimAmount(0.0f);
            window4.clearFlags(2);
        }
        boolean isNightMode = SkinManager.isNightMode();
        Context context = this.c;
        if (isNightMode) {
            i = 2131558453;
        }
        inflate.getBackground().setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(context, i), PorterDuff.Mode.SRC_IN));
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.dragon.read.component.biz.impl.minigame.g
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                i.h0(i.this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(i iVar, DialogInterface dialogInterface) {
        Window window;
        Activity activity = ContextUtils.getActivity(iVar.c);
        if (activity != null && (window = activity.getWindow()) != null) {
            ContextUtils.setNavigationBar(window, -16777216, 255);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbsRecyclerViewHolder f0(final i iVar, ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(iVar.c).inflate(2131040774, parent, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        return new e((ViewGroup) inflate, new Function1() { // from class: com.dragon.read.component.biz.impl.minigame.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g0;
                g0 = i.g0(i.this, (c) obj);
                return g0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(i iVar, c it2) {
        boolean z;
        Intrinsics.checkNotNullParameter(it2, "it");
        iVar.dismiss();
        String str = it2.e;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            NsCommonDepend.IMPL.appNavigator().openUrl(iVar.c, it2.e, (PageRecorder) null);
        }
        Function0 function0 = ((a) iVar).a;
        if (function0 != null) {
            function0.invoke();
        }
        ReportAdRequest reportAdRequest = new ReportAdRequest();
        reportAdRequest.noInterestScene = it2.d;
        reportAdRequest.scene = ReportAdScene.AdRemainMiniGame;
        reportAdRequest.notInterest = true;
        reportAdRequest.id = iVar.g;
        ToastUtils.showCommonToast(2131102887);
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c2, code lost:
    
        r2.m = new org.json.JSONObject(r0).optString("log_id");
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f A[Catch: all -> 0x00d5, TryCatch #0 {all -> 0x00d5, blocks: (B:7:0x002d, B:9:0x0033, B:14:0x003f, B:16:0x004a, B:18:0x0057, B:19:0x005f, B:21:0x0063, B:22:0x006b, B:24:0x006f, B:25:0x0077, B:27:0x007b, B:28:0x0083, B:30:0x008d, B:32:0x0093, B:33:0x00a7, B:35:0x00b0, B:37:0x00b8, B:42:0x00c2, B:47:0x00cf), top: B:6:0x002d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i(android.content.Context r3, int r4, java.util.List<gg3.c> r5, java.lang.String r6) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "itemList"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r2.<init>(r3)
            r2.c = r3
            r2.d = r5
            r2.e = r6
            com.dragon.read.component.biz.impl.ecom.config.ReaderBackupAd$a r3 = com.dragon.read.component.biz.impl.ecom.config.ReaderBackupAd.a
            com.dragon.read.component.biz.impl.ecom.config.ReaderBackupAd r3 = r3.a()
            java.util.Map r3 = r3.contentType
            if (r3 == 0) goto L29
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L2b
        L29:
            java.lang.String r3 = ""
        L2b:
            r2.f = r3
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> Ld5
            r3 = 1
            r4 = 0
            if (r6 == 0) goto L3c
            int r5 = r6.length()     // Catch: java.lang.Throwable -> Ld5
            if (r5 != 0) goto L3a
            goto L3c
        L3a:
            r5 = 0
            goto L3d
        L3c:
            r5 = 1
        L3d:
            if (r5 != 0) goto Lcf
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch: java.lang.Throwable -> Ld5
            r5.<init>(r6)     // Catch: java.lang.Throwable -> Ld5
            int r6 = r5.length()     // Catch: java.lang.Throwable -> Ld5
            if (r6 <= 0) goto Lcf
            org.json.JSONObject r5 = r5.getJSONObject(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r6 = "game_content"
            org.json.JSONObject r6 = r5.optJSONObject(r6)     // Catch: java.lang.Throwable -> Ld5
            r0 = 0
            if (r6 == 0) goto L5e
            java.lang.String r1 = "mp_id"
            java.lang.String r1 = r6.optString(r1)     // Catch: java.lang.Throwable -> Ld5
            goto L5f
        L5e:
            r1 = r0
        L5f:
            r2.g = r1     // Catch: java.lang.Throwable -> Ld5
            if (r6 == 0) goto L6a
            java.lang.String r1 = "mp_name"
            java.lang.String r1 = r6.optString(r1)     // Catch: java.lang.Throwable -> Ld5
            goto L6b
        L6a:
            r1 = r0
        L6b:
            r2.h = r1     // Catch: java.lang.Throwable -> Ld5
            if (r6 == 0) goto L76
            java.lang.String r1 = "game_summary"
            java.lang.String r1 = r6.optString(r1)     // Catch: java.lang.Throwable -> Ld5
            goto L77
        L76:
            r1 = r0
        L77:
            r2.i = r1     // Catch: java.lang.Throwable -> Ld5
            if (r6 == 0) goto L82
            java.lang.String r1 = "label_info"
            org.json.JSONObject r6 = r6.optJSONObject(r1)     // Catch: java.lang.Throwable -> Ld5
            goto L83
        L82:
            r6 = r0
        L83:
            r2.k = r6     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r6 = "display_content_list"
            org.json.JSONArray r6 = r5.optJSONArray(r6)     // Catch: java.lang.Throwable -> Ld5
            if (r6 == 0) goto La7
            int r1 = r6.length()     // Catch: java.lang.Throwable -> Ld5
            if (r1 <= 0) goto La7
            org.json.JSONObject r6 = r6.getJSONObject(r4)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r1 = "material_id"
            java.lang.String r1 = r6.optString(r1)     // Catch: java.lang.Throwable -> Ld5
            r2.j = r1     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r1 = "feed_card_channel"
            java.lang.String r6 = r6.optString(r1)     // Catch: java.lang.Throwable -> Ld5
            r2.l = r6     // Catch: java.lang.Throwable -> Ld5
        La7:
            java.lang.String r6 = "track_info"
            org.json.JSONObject r5 = r5.optJSONObject(r6)     // Catch: java.lang.Throwable -> Ld5
            if (r5 == 0) goto Lb6
            java.lang.String r6 = "extra"
            java.lang.String r0 = r5.optString(r6)     // Catch: java.lang.Throwable -> Ld5
        Lb6:
            if (r0 == 0) goto Lc0
            int r5 = r0.length()     // Catch: java.lang.Throwable -> Ld5
            if (r5 != 0) goto Lbf
            goto Lc0
        Lbf:
            r3 = 0
        Lc0:
            if (r3 != 0) goto Lcf
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Ld5
            r3.<init>(r0)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r4 = "log_id"
            java.lang.String r3 = r3.optString(r4)     // Catch: java.lang.Throwable -> Ld5
            r2.m = r3     // Catch: java.lang.Throwable -> Ld5
        Lcf:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Ld5
            kotlin.Result.m773constructorimpl(r3)     // Catch: java.lang.Throwable -> Ld5
            goto Ldf
        Ld5:
            r3 = move-exception
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)
            kotlin.Result.m773constructorimpl(r3)
        Ldf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.biz.impl.minigame.i.<init>(android.content.Context, int, java.util.List, java.lang.String):void");
    }
}
