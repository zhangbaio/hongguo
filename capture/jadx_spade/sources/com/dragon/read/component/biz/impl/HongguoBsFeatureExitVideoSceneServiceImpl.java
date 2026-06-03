package com.dragon.read.component.biz.impl;

import android.app.Activity;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.component.silk.road.subwindow.GlobalMutexSubWindowManager;
import com.bytedance.component.silk.road.subwindow.manager.IMutexSubWindowManager;
import com.bytedance.covode.number.Covode;
import com.bytedance.ies.xbridge.event.Event;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.model.collections.defaultimpl.DefaultXReadableMapImpl;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.App;
import com.dragon.read.base.util.DateUtils;
import com.dragon.read.component.biz.api.NsUgDepend;
import com.dragon.read.component.biz.impl.brickservice.BsFeatureExitVideoSceneService;
import com.dragon.read.component.biz.impl.brickservice.BsResourceConfigService;
import com.dragon.read.local.KvCacheMgr;
import com.dragon.read.polaris.model.SingleTaskModel;
import com.dragon.read.polaris.utils.i;
import com.dragon.read.polaris.video.e0;
import com.dragon.read.report.PageRecorder;
import com.dragon.read.util.ToastUtils;
import com.dragon.read.widget.ActionToastView;
import ix4.d5;
import ix4.z3;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;
import pv4.b;
import qx4.d;
import uy4.n;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class HongguoBsFeatureExitVideoSceneServiceImpl implements BsFeatureExitVideoSceneService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(588074);
    }

    public void tryShowNovelExitShortVideoToast() {
        int i;
        boolean z;
        boolean z2;
        int optInt;
        int i2;
        boolean z3;
        List listOf;
        List listOf2;
        int i3;
        e0 e0Var = e0.b;
        e0Var.s0().d("tryShowExitShortVideoToast", new Object[0]);
        Activity currentVisibleActivity = ActivityRecordManager.inst().getCurrentVisibleActivity();
        if (currentVisibleActivity == null) {
            return;
        }
        if (!e0Var.A()) {
            e0Var.s0().d("任务未完成，不展示", new Object[0]);
            return;
        }
        IMutexSubWindowManager unitedMutexSubWindowManager = GlobalMutexSubWindowManager.inst().getUnitedMutexSubWindowManager(currentVisibleActivity);
        if (unitedMutexSubWindowManager != null) {
            z = unitedMutexSubWindowManager.hasShowingSubWindow();
            i = unitedMutexSubWindowManager.a();
        } else {
            i = 0;
            z = false;
        }
        if (!z && i == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            e0Var.s0().d("弹窗队列异常，不展示", new Object[0]);
            return;
        }
        if (z3.a.D("consume_from_video")) {
            e0Var.s0().d("消费场景弹窗已展示，不展示", new Object[0]);
            return;
        }
        if (e0Var.w0()) {
            e0.a o0 = e0Var.o0();
            if (o0.b >= 3) {
                e0Var.s0().d("已达展示上限，不展示", new Object[0]);
                return;
            }
            if (o0.c.contains(Integer.valueOf(e0Var.f()))) {
                e0Var.s0().d("当前节点已展示，不展示", new Object[0]);
                return;
            }
            int k0 = (int) e0Var.k0();
            e0Var.s0().d("curNodeNum:" + e0Var.f() + ", curNodeProgress = " + e0Var.g() + ", amount = " + k0, new Object[0]);
            if (e0Var.g() >= 0.7f && e0Var.g() < 1.0f && k0 > 0) {
                d Q1 = d5.X2().Q1();
                if (Q1 != null && Q1.b) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                i iVar = i.a;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"new_user_watch_new_short_video", "continue_short_video", "old_user_continue_short_video", "new_user_signin_v2", "lost_return_user_signin", "bind_douyin_v2", "publication_read_task", "daily_short_video_collect", "mix_task_collect"});
                long a2 = iVar.a(listOf);
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 29, 23});
                long b = a2 + iVar.b(listOf2);
                e0Var.s0().d("opt:" + z3 + ", totalAmount = " + b, new Object[0]);
                if (z3 && b > 0) {
                    ActionToastView actionToastView = new ActionToastView(currentVisibleActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
                    actionToastView.setTitle("今日已赚" + b + "金币");
                    actionToastView.setActionText("去领取");
                    actionToastView.setIcon(2130843838);
                    actionToastView.setOnActionClickListener(new a(currentVisibleActivity, actionToastView));
                    actionToastView.showToast(5000);
                    n.v0(n.a, "get_coin_toast", NsUgDepend.IMPL.getGoldBoxPosition(currentVisibleActivity), (String) null, 4, (Object) null);
                    i3 = 1;
                } else {
                    BsResourceConfigService bsResourceConfigService = BsResourceConfigService.IMPL;
                    int i4 = 2131108127;
                    if (bsResourceConfigService != null) {
                        i4 = bsResourceConfigService.getTargetStringRes(2131108127);
                    }
                    String string = ContextCompat.getString(currentVisibleActivity, i4);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    i3 = 1;
                    String format = String.format(Locale.getDefault(), string, Arrays.copyOf(new Object[]{Integer.valueOf(k0), Long.valueOf(e0Var.n())}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    ToastUtils.showIconToast(format, 2130841558);
                }
                o0.a = System.currentTimeMillis();
                o0.b += i3;
                o0.c.add(Integer.valueOf(e0Var.f()));
                e0Var.X0(o0);
                return;
            }
            return;
        }
        SingleTaskModel n0 = e0Var.n0();
        if (n0 != null && (optInt = n0.getConfExtra().optInt("popup_uncompleted_num")) > 0 && e0Var.q() >= optInt) {
            long j = KvCacheMgr.getPrivate(App.context(), "preference_luckycat_task").getLong("key_novel_quit_no_award_task_toast_not_click_date", -1L);
            if (DateUtils.isToday(j)) {
                i2 = KvCacheMgr.getPrivate(App.context(), "preference_luckycat_task").getInt("key_novel_quit_no_award_task_toast_not_click_count", 0);
            } else {
                i2 = 0;
            }
            if (DateUtils.isToday(j) && i2 >= 3) {
                return;
            }
            KvCacheMgr.getPrivate(App.context(), "preference_luckycat_task").edit().putLong("key_novel_quit_no_award_task_toast_not_click_date", System.currentTimeMillis()).putInt("key_novel_quit_no_award_task_toast_not_click_count", i2 + 1).apply();
            BsResourceConfigService bsResourceConfigService2 = BsResourceConfigService.IMPL;
            int i5 = 2131108116;
            if (bsResourceConfigService2 != null) {
                i5 = bsResourceConfigService2.getTargetStringRes(2131108116);
            }
            String string2 = ContextCompat.getString(currentVisibleActivity, i5);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ActionToastView actionToastView2 = new ActionToastView(currentVisibleActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.getDefault(), string2, Arrays.copyOf(new Object[]{Long.valueOf(e0Var.q())}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            actionToastView2.setTitle(format2);
            actionToastView2.setActionText("去领取");
            actionToastView2.setIcon(2130843837);
            actionToastView2.setOnActionClickListener(new View.OnClickListener() { // from class: com.dragon.read.component.biz.impl.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HongguoBsFeatureExitVideoSceneServiceImpl.tryShowNovelExitShortVideoToast$lambda$3$lambda$2(view);
                }
            });
            actionToastView2.showToast(5000);
        }
    }

    public String getFirstInBubbleText(long j) {
        return BsFeatureExitVideoSceneService.b.a(this, j);
    }

    public static final class a extends b {
        final /* synthetic */ Activity d;
        final /* synthetic */ ActionToastView e;

        public void a(View view) {
            n.s0(n.a, "get_coin_toast", NsUgDepend.IMPL.getGoldBoxPosition(this.d), "get_coin", (String) null, 8, (Object) null);
            NsCommonDepend.IMPL.appNavigator().openPolaris(this.e.getContext(), new PageRecorder("daily_short_video_collect_task_toast", "", "", (PageRecorder) null), true);
            ToastUtils.toastCancel();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Activity activity, ActionToastView actionToastView) {
            super(0L, 1, (DefaultConstructorMarker) null);
            this.d = activity;
            this.e = actionToastView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryShowNovelExitShortVideoToast$lambda$3$lambda$2(View view) {
        NsCommonDepend.IMPL.appNavigator().openPolaris(view.getContext(), new PageRecorder("daily_short_video_collect_task_toast", "", "", (PageRecorder) null), true);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("task_key", "daily_short_video_collect");
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("Anchor");
            jSONArray.put("Highlight");
            jSONObject.put("type_list", jSONArray);
            EventCenter.enqueueEvent(new Event("AUTO_TOUCH_AND_TEACH", System.currentTimeMillis(), new DefaultXReadableMapImpl(jSONObject)));
        } catch (Exception unused) {
        }
        ToastUtils.toastCancel();
        KvCacheMgr.getPrivate(App.context(), "preference_luckycat_task").edit().putLong("key_novel_quit_no_award_task_toast_not_click_date", System.currentTimeMillis()).putInt("key_novel_quit_no_award_task_toast_not_click_count", 0).apply();
    }
}
