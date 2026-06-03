package com.dragon.read.nps.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.base.AbsBroadcastReceiver;
import com.dragon.read.base.Args;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.nps.INpsViewProxy;
import com.dragon.read.report.ReportManager;
import com.dragon.read.rpc.model.ResearchEvent;
import com.dragon.read.rpc.model.ResearchSceneType;
import com.dragon.read.rpc.model.UserEventReportRequest;
import com.dragon.read.rpc.model.UserEventReportType;
import com.dragon.read.rpc.model.UserResearchData;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public abstract class a extends ConstraintLayout {
    public static final int p;
    private UserResearchData g;
    private int h;
    private int i;
    private int j;
    private ResearchSceneType k;
    private boolean l;
    private INpsViewProxy m;
    private String n;
    private final AbsBroadcastReceiver o;

    static {
        Covode.recordClassIndex(612563);
        p = 8;
    }

    public abstract void V1();

    protected String getLogTag() {
        return "NPS_GLOBAL | NPS_ABS_CARD";
    }

    public abstract void setPosition(String str);

    public abstract void setSceneType(ResearchSceneType researchSceneType);

    protected final int getBgColor() {
        return this.h;
    }

    protected final int getCloseColor() {
        return this.j;
    }

    protected final UserResearchData getData() {
        return this.g;
    }

    protected final boolean getHideSysTemBar() {
        return this.l;
    }

    protected final INpsViewProxy getNpsHeadView() {
        return this.m;
    }

    protected final String getOpenPosition() {
        return this.n;
    }

    protected final AbsBroadcastReceiver getReceiver() {
        return this.o;
    }

    protected final ResearchSceneType getScene() {
        return this.k;
    }

    protected final int getTextColor() {
        return this.i;
    }

    protected void Q1() {
        String str;
        UserEventReportRequest userEventReportRequest = new UserEventReportRequest();
        ResearchEvent researchEvent = new ResearchEvent();
        userEventReportRequest.reportType = UserEventReportType.UserResearch;
        UserResearchData userResearchData = this.g;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        researchEvent.researchId = str;
        researchEvent.isShown = true;
        researchEvent.isSubmitted = false;
        userEventReportRequest.researchEvent = researchEvent;
        g65.k.j0(userEventReportRequest).subscribeOn(Schedulers.io()).subscribe();
    }

    protected void S1() {
        String str;
        Args args = new Args();
        args.put("position", this.n);
        NsCommonDepend nsCommonDepend = NsCommonDepend.IMPL;
        args.put("read_duration", nsCommonDepend.getTodayReadingTime());
        args.put("listen_duration", nsCommonDepend.getTodayAudioTime());
        UserResearchData userResearchData = this.g;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        args.put("research_id", str);
        vs4.r rVar = vs4.r.a;
        String b = rVar.b();
        if (b != null) {
            args.put("book_id", b);
        }
        String c = rVar.c();
        if (c != null) {
            args.put("group_id", c);
        }
        if (rVar.d() != -1) {
            args.put("group_index", Integer.valueOf(rVar.d()));
        }
        LogWrapper.info(getLogTag(), "[nps_query_close]:$" + args.toJsonString(), new Object[0]);
        ReportManager.onReport("nps_query_close", args);
    }

    protected void T1() {
        String str;
        Args args = new Args();
        args.put("position", this.n);
        NsCommonDepend nsCommonDepend = NsCommonDepend.IMPL;
        args.put("read_duration", nsCommonDepend.getTodayReadingTime());
        args.put("listen_duration", nsCommonDepend.getTodayAudioTime());
        UserResearchData userResearchData = this.g;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        args.put("research_id", str);
        vs4.r rVar = vs4.r.a;
        String b = rVar.b();
        if (b != null) {
            args.put("book_id", b);
        }
        String c = rVar.c();
        if (c != null) {
            args.put("group_id", c);
        }
        if (rVar.d() != -1) {
            args.put("group_index", Integer.valueOf(rVar.d()));
        }
        LogWrapper.info(getLogTag(), "[nps_query_show]:$" + args.toJsonString(), new Object[0]);
        ReportManager.onReport("nps_query_show", args);
    }

    protected final void setBgColor(int i) {
        this.h = i;
    }

    protected final void setCloseColor(int i) {
        this.j = i;
    }

    protected final void setData(UserResearchData userResearchData) {
        this.g = userResearchData;
    }

    protected final void setHideSysTemBar(boolean z) {
        this.l = z;
    }

    public void setHideSystemBar(boolean z) {
        this.l = z;
    }

    protected final void setNpsHeadView(INpsViewProxy iNpsViewProxy) {
        this.m = iNpsViewProxy;
    }

    protected final void setTextColor(int i) {
        this.i = i;
    }

    /* renamed from: com.dragon.read.nps.ui.a$a, reason: collision with other inner class name */
    public static final class C0095a extends AbsBroadcastReceiver {
        C0095a() {
        }

        public void onReceive(Context context, Intent intent, String action) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(action, "action");
            if (Intrinsics.areEqual(action, "action_skin_type_change")) {
                a.this.V1();
            }
        }
    }

    protected final void setOpenPosition(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.n = str;
    }

    protected final void setScene(ResearchSceneType researchSceneType) {
        Intrinsics.checkNotNullParameter(researchSceneType, "<set-?>");
        this.k = researchSceneType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        ResearchSceneType researchSceneType;
        Intrinsics.checkNotNullParameter(context, "context");
        this.k = ResearchSceneType.BookStoreMainFeed;
        Map<ResearchSceneType, String> a = vs4.p.a.a();
        UserResearchData userResearchData = this.g;
        String str = a.get((userResearchData == null || (researchSceneType = userResearchData.scene) == null) ? 0 : researchSceneType);
        this.n = str == null ? "unknown" : str;
        this.o = new C0095a();
    }
}
