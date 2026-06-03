package com.dragon.read.nps.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.covode.number.Covode;
import com.dragon.read.NsCommonDepend;
import com.dragon.read.NsUiDepend;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.App;
import com.dragon.read.base.AbsBroadcastReceiver;
import com.dragon.read.base.AbsFragment;
import com.dragon.read.base.Args;
import com.dragon.read.base.skin.SkinManager;
import com.dragon.read.base.transition.ActivityAnimType;
import com.dragon.read.base.ui.util.KeyBoardUtils;
import com.dragon.read.base.ui.util.StatusBarUtil;
import com.dragon.read.base.util.AppUtils;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.base.util.ThreadUtils;
import com.dragon.read.nps.INpsViewProxy;
import com.dragon.read.nps.ui.NpsPopDialogFragment;
import com.dragon.read.nps.ui.NpsPopMemoryCache;
import com.dragon.read.nps.ui.b1;
import com.dragon.read.report.ReportManager;
import com.dragon.read.rpc.model.OptionInfo;
import com.dragon.read.rpc.model.ResearchEvent;
import com.dragon.read.rpc.model.ResearchSceneType;
import com.dragon.read.rpc.model.UserEventReportRequest;
import com.dragon.read.rpc.model.UserEventReportResponse;
import com.dragon.read.rpc.model.UserEventReportType;
import com.dragon.read.rpc.model.UserResearchData;
import com.dragon.read.util.ToastUtils;
import com.dragon.read.util.kotlin.UIKt;
import com.dragon.read.util.t3;
import com.dragon.read.util.u2;
import com.dragon.read.util.v6;
import com.dragon.read.widget.swipeback.SwipeBackLayout;
import com.dragon.reader.lib.ReaderClient;
import com.dragon.reader.lib.parserlevel.model.page.IDragonPage;
import com.dragon.reader.lib.support.DefaultFrameController;
import com.ss.android.excitingvideo.utils.GsonUtilKt;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Map;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class NpsPopDialogFragment extends AbsFragment implements u2.a {
    public static final int A;
    private final UserResearchData a;
    private final ReaderClient b;
    private final a c;
    private final boolean d;
    private final String e;
    private final k f;
    private final AbsBroadcastReceiver g;
    private j h;
    private STATE i;
    private int j;
    private boolean k;
    private boolean l;
    private ConstraintLayout m;
    private SwipeBackLayout n;
    private TextView o;
    private INpsViewProxy p;
    private ConstraintLayout q;
    private TextView r;
    private RecyclerView s;
    private EditText t;
    private FrameLayout u;
    private ConstraintLayout v;
    private TextView w;
    private EditText x;
    private b1.a y;
    private final View.OnClickListener z;

    public interface a {
        long a();

        long b();

        String getPosition();

        Args h();

        void onCommit();
    }

    static {
        Covode.recordClassIndex(612577);
        A = 8;
    }

    public final void pg() {
        this.l = true;
    }

    public static final class c extends ViewOutlineProvider {
        c() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int i;
            int i2;
            if (outline != null) {
                if (view != null) {
                    i = view.getWidth();
                } else {
                    i = 0;
                }
                if (view != null) {
                    i2 = view.getHeight();
                } else {
                    i2 = 0;
                }
                outline.setRoundRect(0, 0, i, i2, UIKt.getDp(12));
            }
        }
    }

    public static final class l implements b1.a {
        @Override // com.dragon.read.nps.ui.b1.a
        public void b(String text) {
            Intrinsics.checkNotNullParameter(text, "text");
        }

        @Override // com.dragon.read.nps.ui.b1.a
        public int getTheme() {
            return NpsPopDialogFragment.this.j;
        }

        l() {
        }

        @Override // com.dragon.read.nps.ui.b1.a
        public boolean c(String item) {
            Intrinsics.checkNotNullParameter(item, "item");
            NpsPopMemoryCache npsPopMemoryCache = NpsPopMemoryCache.a;
            if (npsPopMemoryCache.d(npsPopMemoryCache.e()).get(item) != null && Intrinsics.areEqual(npsPopMemoryCache.d(npsPopMemoryCache.e()).get(item), Boolean.TRUE)) {
                return true;
            }
            return false;
        }

        @Override // com.dragon.read.nps.ui.b1.a
        public void a(boolean z, String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            Boolean valueOf = Boolean.valueOf(z);
            NpsPopMemoryCache npsPopMemoryCache = NpsPopMemoryCache.a;
            npsPopMemoryCache.d(npsPopMemoryCache.e()).put(text, valueOf);
        }
    }

    private final boolean hg() {
        return Qg();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class STATE {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ STATE[] $VALUES;
        public static final STATE enum_high_score_state;
        public static final STATE enum_init_state;
        public static final STATE enum_low_score_state;
        public static final STATE enum_no_reason_item_state;
        public static final STATE enum_no_select_state;

        private static final /* synthetic */ STATE[] $values() {
            return new STATE[]{enum_init_state, enum_no_select_state, enum_no_reason_item_state, enum_high_score_state, enum_low_score_state};
        }

        public static EnumEntries<STATE> getEntries() {
            return $ENTRIES;
        }

        public static STATE[] values() {
            return (STATE[]) $VALUES.clone();
        }

        static {
            Covode.recordClassIndex(612579);
            enum_init_state = new STATE("enum_init_state", 0);
            enum_no_select_state = new STATE("enum_no_select_state", 1);
            enum_no_reason_item_state = new STATE("enum_no_reason_item_state", 2);
            enum_high_score_state = new STATE("enum_high_score_state", 3);
            enum_low_score_state = new STATE("enum_low_score_state", 4);
            STATE[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static STATE valueOf(String str) {
            return (STATE) Enum.valueOf(STATE.class, str);
        }

        private STATE(String str, int i) {
        }
    }

    private final boolean Qg() {
        if (this.a.scene == ResearchSceneType.ReaderChapterEnd) {
            return true;
        }
        return false;
    }

    private final boolean Pg() {
        ResearchSceneType researchSceneType = this.a.scene;
        if (researchSceneType != ResearchSceneType.AllGenreNps709 && researchSceneType != ResearchSceneType.ReaderExist) {
            return false;
        }
        return true;
    }

    private final boolean Rg() {
        ResearchSceneType researchSceneType = this.a.scene;
        if (researchSceneType != ResearchSceneType.BeforeReturnFromReaderToUnlimited && researchSceneType != ResearchSceneType.AtSpecifiedChapterInReader) {
            return false;
        }
        return true;
    }

    private final boolean ig() {
        if (!Rg() && !Qg() && !Pg()) {
            return false;
        }
        return true;
    }

    public static final class i implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ View a;
        final /* synthetic */ NpsPopDialogFragment b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            UIKt.removeOnGlobalLayoutListener(this.a, this);
            String str = this.b.e;
            StringBuilder sb = new StringBuilder();
            sb.append("NPS弹窗初始选择:");
            NpsPopMemoryCache npsPopMemoryCache = NpsPopMemoryCache.a;
            sb.append(npsPopMemoryCache.e().getNumber());
            LogWrapper.info(str, sb.toString(), new Object[0]);
            this.b.gh(npsPopMemoryCache.e().getNumber());
        }

        i(View view, NpsPopDialogFragment npsPopDialogFragment) {
            this.a = view;
            this.b = npsPopDialogFragment;
        }
    }

    private final void Mg() {
        ReaderClient readerClient = this.b;
        if (readerClient != null) {
            this.j = readerClient.getReaderConfig().getTheme();
            this.b.getConfigObservable().o0(this.f);
        } else {
            if (SkinManager.isNightMode()) {
                this.j = 5;
            } else {
                this.j = 1;
            }
            App.registerLocalReceiver(this.g, new String[0]);
        }
    }

    private final void Sg() {
        LogWrapper.info(this.e, "call onNoReasonState", new Object[0]);
        jg();
        ViewGroup viewGroup = this.q;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        this.i = STATE.enum_no_reason_item_state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void og() {
        Object obj;
        LogWrapper.info(this.e, "on hideSoftKeyBoard", new Object[0]);
        Context context = getContext();
        EditText editText = null;
        if (context != null) {
            obj = context.getSystemService("input_method");
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) obj;
        EditText editText2 = this.x;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
            editText2 = null;
        }
        inputMethodManager.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
        EditText editText3 = this.x;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
        } else {
            editText = editText3;
        }
        editText.clearFocus();
    }

    public void onDestroyView() {
        jx5.c configObservable;
        super.onDestroyView();
        ReaderClient readerClient = this.b;
        if (readerClient != null && (configObservable = readerClient.getConfigObservable()) != null) {
            configObservable.V0(this.f);
        }
        App.unregisterLocalReceiver(new BroadcastReceiver[]{this.g});
        ViewGroup viewGroup = this.n;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swipeBackLayout");
            viewGroup = null;
        }
        viewGroup.animate().cancel();
    }

    public static final class h implements ViewTreeObserver.OnGlobalLayoutListener {
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View view = NpsPopDialogFragment.this.n;
            ViewGroup viewGroup = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("swipeBackLayout");
                view = null;
            }
            UIKt.removeOnGlobalLayoutListener(view, this);
            ViewGroup viewGroup2 = NpsPopDialogFragment.this.n;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("swipeBackLayout");
                viewGroup2 = null;
            }
            ViewGroup viewGroup3 = NpsPopDialogFragment.this.n;
            if (viewGroup3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("swipeBackLayout");
                viewGroup3 = null;
            }
            viewGroup2.setTranslationY(viewGroup3.getHeight());
            ViewGroup viewGroup4 = NpsPopDialogFragment.this.n;
            if (viewGroup4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("swipeBackLayout");
            } else {
                viewGroup = viewGroup4;
            }
            viewGroup.animate().translationY(0.0f).alpha(1.0f).setDuration(300L).start();
        }

        h() {
        }
    }

    protected final void Ig() {
        String str;
        DefaultFrameController frameController;
        IDragonPage currentPageData;
        if (this.b == null || this.l) {
            return;
        }
        vs4.r rVar = vs4.r.a;
        rVar.v(new WeakReference<>(this.b.getContext()));
        vs4.n nVar = vs4.n.a;
        rVar.p(nVar.t());
        rVar.u(nVar.u());
        rVar.m(this.b.getBookProviderProxy().bookId);
        ReaderClient readerClient = this.b;
        if (readerClient != null && (frameController = readerClient.getFrameController()) != null && (currentPageData = frameController.getCurrentPageData()) != null) {
            str = currentPageData.getChapterId();
        } else {
            str = null;
        }
        rVar.n(str);
        String c2 = rVar.c();
        if (c2 != null) {
            rVar.o(this.b.getCatalogProvider().getIndex(c2) + 1);
        }
    }

    protected final void Wg() {
        String str;
        UserEventReportRequest userEventReportRequest = new UserEventReportRequest();
        ResearchEvent researchEvent = new ResearchEvent();
        userEventReportRequest.reportType = UserEventReportType.UserResearch;
        UserResearchData userResearchData = this.a;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        researchEvent.researchId = str;
        researchEvent.isShown = false;
        researchEvent.isSubmitted = true;
        userEventReportRequest.researchEvent = researchEvent;
        LogWrapper.info(this.e, "[report_card_commit]:" + GsonUtilKt.toJsonString(userEventReportRequest), new Object[0]);
        Observable subscribeOn = g65.k.j0(userEventReportRequest).subscribeOn(Schedulers.io());
        final Function1 function1 = new Function1() { // from class: com.dragon.read.nps.ui.m0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Xg;
                Xg = NpsPopDialogFragment.Xg((UserEventReportResponse) obj);
                return Xg;
            }
        };
        subscribeOn.subscribe(new Consumer() { // from class: com.dragon.read.nps.ui.n0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NpsPopDialogFragment.Yg(Function1.this, obj);
            }
        });
    }

    protected final void Zg() {
        String str;
        if (this.k) {
            return;
        }
        UserEventReportRequest userEventReportRequest = new UserEventReportRequest();
        ResearchEvent researchEvent = new ResearchEvent();
        userEventReportRequest.reportType = UserEventReportType.UserResearch;
        UserResearchData userResearchData = this.a;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        researchEvent.researchId = str;
        researchEvent.isShown = true;
        researchEvent.isSubmitted = false;
        userEventReportRequest.researchEvent = researchEvent;
        LogWrapper.info(this.e, "[report_card_show]:" + GsonUtilKt.toJsonString(userEventReportRequest), new Object[0]);
        Observable subscribeOn = g65.k.j0(userEventReportRequest).subscribeOn(Schedulers.io());
        final Function1 function1 = new Function1() { // from class: com.dragon.read.nps.ui.w0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit ah;
                ah = NpsPopDialogFragment.ah((UserEventReportResponse) obj);
                return ah;
            }
        };
        subscribeOn.subscribe(new Consumer() { // from class: com.dragon.read.nps.ui.h0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                NpsPopDialogFragment.bh(Function1.this, obj);
            }
        });
    }

    private final void jg() {
        Drawable drawable;
        Resources resources;
        Resources resources2;
        Resources resources3;
        LogWrapper.info(this.e, "on enableCommitButton", new Object[0]);
        TextView textView = (TextView) findViewById(2131824953);
        textView.setOnClickListener(this.z);
        NsUiDepend nsUiDepend = NsUiDepend.IMPL;
        GradientDrawable gradientDrawable = null;
        r3 = null;
        Drawable drawable2 = null;
        r3 = null;
        Drawable drawable3 = null;
        if (nsUiDepend.isBlackTheme(this.j)) {
            Context context = textView.getContext();
            if (context != null && (resources3 = context.getResources()) != null) {
                drawable2 = resources3.getDrawable(2130848400);
            }
            textView.setBackground(drawable2);
            return;
        }
        if (this.j == 1) {
            Context context2 = textView.getContext();
            if (context2 != null && (resources2 = context2.getResources()) != null) {
                drawable3 = resources2.getDrawable(2130848402);
            }
            textView.setBackground(drawable3);
            return;
        }
        Context context3 = textView.getContext();
        if (context3 != null && (resources = context3.getResources()) != null) {
            drawable = resources.getDrawable(2130848403);
        } else {
            drawable = null;
        }
        if (drawable != null) {
            drawable.mutate();
        }
        if (drawable instanceof GradientDrawable) {
            gradientDrawable = (GradientDrawable) drawable;
        }
        if (gradientDrawable != null) {
            gradientDrawable.setColor(nsUiDepend.getReaderCommonColor().a(this.j));
        }
        textView.setBackground(drawable);
    }

    protected final void Vg() {
        String str;
        if (this.k) {
            return;
        }
        String position = this.c.getPosition();
        if (position == null) {
            Map<ResearchSceneType, String> a2 = vs4.p.a.a();
            Integer num = this.a.scene;
            if (num == null) {
                num = 0;
            }
            position = a2.get(num);
            if (position == null) {
                position = "unknown";
            }
        }
        Args args = new Args();
        args.putAll(this.c.h());
        args.put("position", position);
        NsCommonDepend nsCommonDepend = NsCommonDepend.IMPL;
        args.put("read_duration", nsCommonDepend.getTodayReadingTime());
        args.put("listen_duration", nsCommonDepend.getTodayAudioTime());
        UserResearchData userResearchData = this.a;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        args.put("research_id", str);
        vs4.r rVar = vs4.r.a;
        String b2 = rVar.b();
        if (b2 != null) {
            args.put("book_id", b2);
        }
        String c2 = rVar.c();
        if (c2 != null) {
            args.put("group_id", c2);
        }
        if (rVar.d() != -1) {
            args.put("group_index", Integer.valueOf(rVar.d()));
        }
        LogWrapper.info(this.e, "[nps_query_close]:$" + args.toJsonString(), new Object[0]);
        ReportManager.onReport("nps_query_close", args);
    }

    protected final void eh() {
        String str;
        if (this.k) {
            return;
        }
        String position = this.c.getPosition();
        if (position == null) {
            Map<ResearchSceneType, String> a2 = vs4.p.a.a();
            Integer num = this.a.scene;
            if (num == null) {
                num = 0;
            }
            position = a2.get(num);
            if (position == null) {
                position = "unknown";
            }
        }
        Args args = new Args();
        args.putAll(this.c.h());
        args.put("position", position);
        NsCommonDepend nsCommonDepend = NsCommonDepend.IMPL;
        args.put("read_duration", nsCommonDepend.getTodayReadingTime());
        args.put("listen_duration", nsCommonDepend.getTodayAudioTime());
        UserResearchData userResearchData = this.a;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        args.put("research_id", str);
        vs4.r rVar = vs4.r.a;
        String b2 = rVar.b();
        if (b2 != null) {
            args.put("book_id", b2);
        }
        String c2 = rVar.c();
        if (c2 != null) {
            args.put("group_id", c2);
        }
        if (rVar.d() != -1) {
            args.put("group_index", Integer.valueOf(rVar.d()));
        }
        LogWrapper.info(this.e, "[nps_query_show]:$" + args.toJsonString(), new Object[0]);
        ReportManager.onReport("nps_query_show", args);
    }

    private final void Fg() {
        LogWrapper.info(this.e, "call initLowScoreState, currentState = " + this.i.name(), new Object[0]);
        NpsPopMemoryCache npsPopMemoryCache = NpsPopMemoryCache.a;
        OptionInfo lg = lg(npsPopMemoryCache.e().getNumber());
        if (lg != null) {
            ViewGroup viewGroup = this.q;
            RecyclerView recyclerView = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonContainer");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            EditText editText = this.t;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonEditText");
                editText = null;
            }
            if (npsPopMemoryCache.c()) {
                String b2 = npsPopMemoryCache.b(npsPopMemoryCache.e());
                LogWrapper.info(this.e, "call initLowScoreState, getEditTextContent = " + b2, new Object[0]);
                if (b2 != null) {
                    editText.setText(b2);
                    EditText editText2 = this.x;
                    if (editText2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                        editText2 = null;
                    }
                    editText2.setText(b2);
                    EditText editText3 = this.x;
                    if (editText3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                        editText3 = null;
                    }
                    EditText editText4 = this.x;
                    if (editText4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                        editText4 = null;
                    }
                    editText3.setSelection(editText4.getText().length());
                } else {
                    editText.setText("");
                    EditText editText5 = this.x;
                    if (editText5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                        editText5 = null;
                    }
                    editText5.setText("");
                }
                String mg = mg(npsPopMemoryCache.e().getNumber());
                if (mg != null) {
                    editText.setHint(mg);
                } else {
                    editText.setHint(getString(2131105069));
                }
            }
            kh(npsPopMemoryCache.e().getNumber());
            if (this.i != STATE.enum_low_score_state) {
                RecyclerView recyclerView2 = this.s;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerReasonFlow");
                } else {
                    recyclerView = recyclerView2;
                }
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.dragon.read.nps.ui.ReasonAdapter");
                b1 b1Var = (b1) adapter;
                b1Var.f = true;
                if (hg()) {
                    b1Var.g = false;
                } else {
                    b1Var.g = true;
                }
                b1Var.e = lg;
                b1Var.notifyDataSetChanged();
            }
        } else {
            new Function0() { // from class: com.dragon.read.nps.ui.i0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit Gg;
                    Gg = NpsPopDialogFragment.Gg(NpsPopDialogFragment.this);
                    return Gg;
                }
            };
        }
        jg();
        this.i = STATE.enum_low_score_state;
    }

    private final void yg() {
        LogWrapper.info(this.e, "call initHighScoreState, currentState = " + this.i, new Object[0]);
        NpsPopMemoryCache npsPopMemoryCache = NpsPopMemoryCache.a;
        OptionInfo lg = lg(npsPopMemoryCache.e().getNumber());
        if (lg != null) {
            ViewGroup viewGroup = this.q;
            RecyclerView recyclerView = null;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonContainer");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            EditText editText = this.t;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonEditText");
                editText = null;
            }
            if (npsPopMemoryCache.c()) {
                String b2 = npsPopMemoryCache.b(npsPopMemoryCache.e());
                LogWrapper.info(this.e, "call initHighScoreState, getEditTextContent = " + b2, new Object[0]);
                if (b2 != null) {
                    editText.setText(b2);
                    EditText editText2 = this.x;
                    if (editText2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                        editText2 = null;
                    }
                    editText2.setText(b2);
                    EditText editText3 = this.x;
                    if (editText3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                        editText3 = null;
                    }
                    EditText editText4 = this.x;
                    if (editText4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                        editText4 = null;
                    }
                    editText3.setSelection(editText4.getText().length());
                } else {
                    editText.setText("");
                    EditText editText5 = this.x;
                    if (editText5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                        editText5 = null;
                    }
                    editText5.setText("");
                }
                String mg = mg(npsPopMemoryCache.e().getNumber());
                if (mg != null) {
                    editText.setHint(mg);
                } else {
                    editText.setHint(getString(2131105074));
                }
            }
            kh(npsPopMemoryCache.e().getNumber());
            if (this.i != STATE.enum_high_score_state) {
                RecyclerView recyclerView2 = this.s;
                if (recyclerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerReasonFlow");
                } else {
                    recyclerView = recyclerView2;
                }
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.dragon.read.nps.ui.ReasonAdapter");
                b1 b1Var = (b1) adapter;
                b1Var.f = true;
                if (hg()) {
                    b1Var.g = false;
                }
                b1Var.e = lg;
                b1Var.notifyDataSetChanged();
            }
        } else {
            new Function0() { // from class: com.dragon.read.nps.ui.t0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit zg;
                    zg = NpsPopDialogFragment.zg(NpsPopDialogFragment.this);
                    return zg;
                }
            };
        }
        jg();
        this.i = STATE.enum_high_score_state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Xg(UserEventReportResponse userEventReportResponse) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ah(UserEventReportResponse userEventReportResponse) {
        return Unit.INSTANCE;
    }

    public static final class b extends AbsBroadcastReceiver {
        b() {
        }

        public void onReceive(Context context, Intent intent, String action) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(action, "action");
            if (Intrinsics.areEqual(action, "action_skin_type_change")) {
                LogWrapper.info(NpsPopDialogFragment.this.e, "onThemeChanged darkMode:" + SkinManager.isNightMode(), new Object[0]);
                if (SkinManager.isNightMode()) {
                    NpsPopDialogFragment.this.j = 5;
                } else {
                    NpsPopDialogFragment.this.j = 1;
                }
                View view = NpsPopDialogFragment.this.getView();
                if (view != null) {
                    NpsPopDialogFragment.this.nh(view);
                }
                Activity previousActivity = ActivityRecordManager.inst().getPreviousActivity();
                if (previousActivity != null) {
                    eq2.b.h().onActivityResume(previousActivity);
                }
            }
        }
    }

    public static final class f extends com.dragon.read.widget.swipeback.b {
        f() {
            super(false);
        }

        public void f(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ActivityAnimType.FADE_IN_FADE_OUT.finish(NpsPopDialogFragment.this.getActivity());
        }
    }

    public static final class g implements SwipeBackLayout.f {
        public void b(SwipeBackLayout swipeBackLayout, View view, int i) {
        }

        public void c(SwipeBackLayout swipeBackLayout, int i) {
        }

        g() {
        }

        public void a(SwipeBackLayout swipeBackLayout, View view, float f) {
            NpsPopDialogFragment.this.og();
        }
    }

    public static final class j implements INpsViewProxy.IOnSelectChanged {
        j() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(NpsPopDialogFragment npsPopDialogFragment) {
            npsPopDialogFragment.z.onClick(npsPopDialogFragment.findViewById(2131824953));
        }

        @Override // com.dragon.read.nps.INpsViewProxy.IOnSelectChanged
        public void onChanged(int i) {
            boolean z;
            boolean z2 = false;
            LogWrapper.info(NpsPopDialogFragment.this.e, "收到选择变化，当前选择的是：" + i, new Object[0]);
            int number = NpsPopMemoryCache.ResultKey.enum_extremely_dissatisfied.getNumber();
            if (i <= NpsPopMemoryCache.ResultKey.enum_extremely_satisfied.getNumber() && number <= i) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return;
            }
            NpsPopMemoryCache npsPopMemoryCache = NpsPopMemoryCache.a;
            if (npsPopMemoryCache.e() != npsPopMemoryCache.f(i)) {
                INpsViewProxy iNpsViewProxy = NpsPopDialogFragment.this.p;
                EditText editText = null;
                if (iNpsViewProxy == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
                    iNpsViewProxy = null;
                }
                iNpsViewProxy.setCurrentIndex(i - 1);
                EditText editText2 = NpsPopDialogFragment.this.t;
                if (editText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("reasonEditText");
                    editText2 = null;
                }
                Editable text = editText2.getText();
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                if (text.length() > 0) {
                    z2 = true;
                }
                if (z2) {
                    NpsPopMemoryCache.ResultKey e = npsPopMemoryCache.e();
                    EditText editText3 = NpsPopDialogFragment.this.t;
                    if (editText3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("reasonEditText");
                    } else {
                        editText = editText3;
                    }
                    npsPopMemoryCache.i(e, editText.getText().toString());
                }
                npsPopMemoryCache.k(i);
                NpsPopDialogFragment npsPopDialogFragment = NpsPopDialogFragment.this;
                npsPopDialogFragment.fg(npsPopDialogFragment.ng(i));
                if (NpsPopDialogFragment.this.a.hideSubmitButton) {
                    final NpsPopDialogFragment npsPopDialogFragment2 = NpsPopDialogFragment.this;
                    ThreadUtils.postInForeground(new Runnable() { // from class: com.dragon.read.nps.ui.x0
                        @Override // java.lang.Runnable
                        public final void run() {
                            NpsPopDialogFragment.j.b(NpsPopDialogFragment.this);
                        }
                    }, 2000L);
                }
            }
        }
    }

    public static final class k extends jx5.d {
        k() {
        }

        public void a(int i) {
            super.a(i);
            LogWrapper.info(NpsPopDialogFragment.this.e, "onThemeChanged theme:" + i, new Object[0]);
            NpsPopDialogFragment.this.j = i;
            View view = NpsPopDialogFragment.this.getView();
            if (view != null) {
                NpsPopDialogFragment.this.nh(view);
            }
            Activity previousActivity = ActivityRecordManager.inst().getPreviousActivity();
            if (previousActivity != null) {
                eq2.b.h().onActivityResume(previousActivity);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ug(View view) {
        ToastUtils.showCommonToast("请评分后再提交");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xg(NpsPopDialogFragment npsPopDialogFragment) {
        EditText editText = npsPopDialogFragment.x;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
            editText = null;
        }
        KeyBoardUtils.showKeyBoard(editText);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Gg(NpsPopDialogFragment npsPopDialogFragment) {
        ViewGroup viewGroup = npsPopDialogFragment.q;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        return Unit.INSTANCE;
    }

    private final void qg(View view) {
        ((ImageView) view.findViewById(2131820985)).setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NpsPopDialogFragment.rg(NpsPopDialogFragment.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit zg(NpsPopDialogFragment npsPopDialogFragment) {
        ViewGroup viewGroup = npsPopDialogFragment.q;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        return Unit.INSTANCE;
    }

    public void gh(int i2) {
        if (i2 > 0 && i2 <= 5) {
            INpsViewProxy iNpsViewProxy = this.p;
            if (iNpsViewProxy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
                iNpsViewProxy = null;
            }
            iNpsViewProxy.setCurrentIndex(i2 - 1);
            fg(ng(i2));
        }
    }

    public final void kg(boolean z) {
        LogWrapper.info(this.e, "enableOpenFromCard: " + z, new Object[0]);
        this.k = z;
    }

    public void o6(int i2) {
        LogWrapper.info(this.e, "onHeightChanged height:" + i2, new Object[0]);
    }

    public static final class d implements TextWatcher {
        final /* synthetic */ View b;
        final /* synthetic */ EditText c;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i;
            String obj;
            NpsPopDialogFragment.this.lh(this.b);
            if (editable != null && (obj = editable.toString()) != null) {
                i = obj.length();
            } else {
                i = 0;
            }
            if (i > 150) {
                ToastUtils.showCommonToast("最多输入150个字");
                String substring = String.valueOf(editable).substring(0, 150);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                this.c.setText(substring);
                this.c.setSelection(150);
            }
        }

        d(View view, EditText editText) {
            this.b = view;
            this.c = editText;
        }
    }

    private final void Lg(View view) {
        SwipeBackLayout findViewById = view.findViewById(2131832974);
        findViewById.setAlpha(0.0f);
        findViewById.setMaskDrawEnabled(false);
        findViewById.setBackgroundDrawEnabled(false);
        findViewById.H(false);
        findViewById.B(new f());
        findViewById.B(new g());
        this.n = findViewById;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swipeBackLayout");
            findViewById = null;
        }
        UIKt.addOnGlobalLayoutListener(findViewById, new h());
    }

    private final void Ng(View view) {
        TextView textView;
        String str = null;
        if (view != null) {
            textView = (TextView) view.findViewById(2131831329);
        } else {
            textView = null;
        }
        Intrinsics.checkNotNull(textView);
        this.o = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("researchTitle");
            textView = null;
        }
        UserResearchData userResearchData = this.a;
        if (userResearchData != null) {
            str = userResearchData.researchTitle;
        }
        textView.setText(str);
    }

    private final void kh(int i2) {
        Map map = this.a.scoreSubTitle;
        if (map != null && map.containsKey(String.valueOf(i2))) {
            TextView textView = this.r;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emotionSubTitle");
                textView = null;
            }
            textView.setText((CharSequence) map.get(String.valueOf(i2)));
        }
    }

    private final String mg(int i2) {
        boolean contains$default;
        Map map = this.a.editorHint;
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            Intrinsics.checkNotNull(str);
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) String.valueOf(i2), false, 2, (Object) null);
            if (contains$default) {
                return str2;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final STATE ng(int i2) {
        if (i2 >= 1 && i2 <= 5) {
            if (lg(i2) == null) {
                return STATE.enum_no_reason_item_state;
            }
            if (i2 != NpsPopMemoryCache.ResultKey.enum_extremely_satisfied.getNumber() && i2 != NpsPopMemoryCache.ResultKey.enum_satisfied.getNumber()) {
                return STATE.enum_low_score_state;
            }
            return STATE.enum_high_score_state;
        }
        return STATE.enum_no_select_state;
    }

    private final void sg(View view) {
        ConstraintLayout findViewById = view.findViewById(2131821115);
        findViewById.setClipToOutline(true);
        findViewById.setOutlineProvider(new c());
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NpsPopDialogFragment.tg(NpsPopDialogFragment.this, view2);
            }
        });
        this.m = findViewById;
        view.findViewById(2131831770).setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NpsPopDialogFragment.ug(NpsPopDialogFragment.this, view2);
            }
        });
    }

    protected final OptionInfo lg(int i2) {
        boolean contains$default;
        Map scoreOptionInfo = this.a.scoreOptionInfo;
        if (scoreOptionInfo == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(scoreOptionInfo, "scoreOptionInfo");
        for (Map.Entry entry : scoreOptionInfo.entrySet()) {
            String str = (String) entry.getKey();
            OptionInfo optionInfo = (OptionInfo) entry.getValue();
            Intrinsics.checkNotNull(str);
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) String.valueOf(i2), false, 2, (Object) null);
            if (contains$default) {
                return optionInfo;
            }
        }
        return null;
    }

    public void onCreate(Bundle bundle) {
        Window window;
        super.onCreate(bundle);
        if (this.d) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                window = activity.getWindow();
            } else {
                window = null;
            }
            nz5.e.p(window);
            LogWrapper.info(this.e, "NPS弹窗 hideSystemBar", new Object[0]);
        }
    }

    private final void Jg(View view) {
        String str;
        this.q = view.findViewById(2131831063);
        TextView textView = (TextView) view.findViewById(2131825942);
        Map map = this.a.scoreSubTitle;
        if (map == null || (str = (String) map.get(String.valueOf(NpsPopMemoryCache.a.e().getNumber()))) == null) {
            str = "";
        }
        textView.setText(str);
        this.r = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emotionSubTitle");
            textView = null;
        }
        UIKt.setFontWeight(textView, 500);
        Kg(view);
    }

    private final void Kg(View view) {
        int i2;
        int dp;
        int dp2;
        RecyclerView findViewById = view.findViewById(2131831167);
        this.s = findViewById;
        RecyclerView recyclerView = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerReasonFlow");
            findViewById = null;
        }
        findViewById.setAdapter(new b1(this.y));
        if (hg()) {
            i2 = 3;
        } else {
            i2 = 2;
        }
        if (hg()) {
            dp = UIKt.getDp(8);
        } else {
            dp = UIKt.getDp(12);
        }
        if (hg()) {
            dp2 = UIKt.getDp(8);
        } else {
            dp2 = UIKt.getDp(12);
        }
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerReasonFlow");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), i2));
        RecyclerView recyclerView3 = this.s;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerReasonFlow");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.addItemDecoration(new e(dp, dp2, i2));
    }

    private final void Tg(View view) {
        TextView textView;
        LogWrapper.info(this.e, "call onNoSelectState", new Object[0]);
        ViewGroup viewGroup = this.q;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonContainer");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        if (view != null && (textView = (TextView) view.findViewById(2131824953)) != null) {
            if (this.a.hideSubmitButton) {
                view.findViewById(2131831291).setVisibility(0);
                textView.setVisibility(8);
            } else {
                view.findViewById(2131831291).setVisibility(8);
                textView.setVisibility(0);
                UIKt.setClickListener(textView, new View.OnClickListener() { // from class: com.dragon.read.nps.ui.g0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        NpsPopDialogFragment.Ug(view2);
                    }
                });
                textView.setBackground(ContextCompat.getDrawable(App.context(), 2130848401));
            }
        }
        this.i = STATE.enum_no_select_state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fg(STATE state) {
        LogWrapper.info(this.e, "changeState: " + state, new Object[0]);
        if (state == STATE.enum_no_select_state) {
            Tg(getView());
        } else if (state == STATE.enum_no_reason_item_state) {
            Sg();
        } else if (state == STATE.enum_high_score_state) {
            yg();
        } else if (state == STATE.enum_low_score_state) {
            Fg();
        }
        View view = getView();
        if (view != null) {
            view.invalidate();
        }
        View view2 = getView();
        if (view2 != null) {
            view2.requestLayout();
        }
    }

    private final void hh(View view) {
        Resources resources;
        Resources resources2;
        Drawable drawable = null;
        if (NsUiDepend.IMPL.isBlackTheme(this.j)) {
            ImageView imageView = (ImageView) view.findViewById(2131820985);
            if (imageView != null) {
                Context context = getContext();
                if (context != null && (resources2 = context.getResources()) != null) {
                    drawable = resources2.getDrawable(2130845579);
                }
                imageView.setBackground(drawable);
                return;
            }
            return;
        }
        ImageView imageView2 = (ImageView) view.findViewById(2131820985);
        if (imageView2 != null) {
            Context context2 = getContext();
            if (context2 != null && (resources = context2.getResources()) != null) {
                drawable = resources.getDrawable(2130845578);
            }
            imageView2.setBackground(drawable);
        }
    }

    private final void jh(View view) {
        Resources resources;
        Resources resources2;
        NsUiDepend nsUiDepend = NsUiDepend.IMPL;
        Drawable drawable = null;
        if (nsUiDepend.isBlackTheme(this.j)) {
            EditText editText = (EditText) view.findViewById(2131831064);
            if (editText != null) {
                Context context = editText.getContext();
                if (context != null && (resources2 = context.getResources()) != null) {
                    drawable = resources2.getDrawable(2130848410);
                }
                editText.setBackground(drawable);
                editText.setHintTextColor(Color.parseColor("#99FFFFFF"));
            }
        } else {
            EditText editText2 = (EditText) view.findViewById(2131831064);
            if (editText2 != null) {
                Context context2 = editText2.getContext();
                if (context2 != null && (resources = context2.getResources()) != null) {
                    drawable = resources.getDrawable(2130848411);
                }
                editText2.setBackground(drawable);
                editText2.setHintTextColor(Color.parseColor("#66000000"));
            }
        }
        EditText editText3 = (EditText) view.findViewById(2131831064);
        if (editText3 != null) {
            editText3.setTextColor(nsUiDepend.getReaderCommonColor().c(this.j));
        }
    }

    private final void vg(View view) {
        NpsPopMemoryCache npsPopMemoryCache = NpsPopMemoryCache.a;
        npsPopMemoryCache.j(true);
        EditText editText = (EditText) view.findViewById(2131831064);
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
        this.t = editText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonEditText");
            editText = null;
        }
        editText.setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NpsPopDialogFragment.wg(NpsPopDialogFragment.this, view2);
            }
        });
        EditText editText3 = this.t;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonEditText");
            editText3 = null;
        }
        editText3.setTextSize(2, com.dragon.read.base.basescale.d.c(14.0f));
        if (npsPopMemoryCache.b(npsPopMemoryCache.e()) != null) {
            EditText editText4 = this.t;
            if (editText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("reasonEditText");
            } else {
                editText2 = editText4;
            }
            editText2.setText(npsPopMemoryCache.b(npsPopMemoryCache.e()));
        }
    }

    public void Og(View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        sg(root);
        Lg(root);
        Ng(root);
        Hg(root);
        Jg(root);
        Ag(root);
        vg(root);
        qg(root);
        Tg(root);
        nh(root);
        Activity previousActivity = ActivityRecordManager.inst().getPreviousActivity();
        if (previousActivity != null) {
            eq2.b.h().onActivityResume(previousActivity);
        }
        if (NpsPopMemoryCache.a.e() != NpsPopMemoryCache.ResultKey.enum_none) {
            UIKt.addOnGlobalLayoutListener(root, new i(root, this));
        }
    }

    private final void Ag(final View view) {
        ConstraintLayout findViewById = view.findViewById(2131828407);
        this.v = findViewById;
        EditText editText = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupContainer");
            findViewById = null;
        }
        findViewById.setVisibility(8);
        TextView textView = (TextView) view.findViewById(2131828406);
        textView.setFocusable(true);
        this.w = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupButton");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NpsPopDialogFragment.Bg(NpsPopDialogFragment.this, view2);
            }
        });
        EditText editText2 = (EditText) view.findViewById(2131828408);
        editText2.addTextChangedListener(new d(view, editText2));
        editText2.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.dragon.read.nps.ui.q0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z) {
                NpsPopDialogFragment.Cg(NpsPopDialogFragment.this, view2, z);
            }
        });
        this.x = editText2;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
            editText2 = null;
        }
        editText2.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.dragon.read.nps.ui.r0
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                NpsPopDialogFragment.Dg(NpsPopDialogFragment.this, view);
            }
        });
        NpsPopMemoryCache npsPopMemoryCache = NpsPopMemoryCache.a;
        if (npsPopMemoryCache.b(npsPopMemoryCache.e()) != null) {
            EditText editText3 = this.x;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                editText3 = null;
            }
            editText3.setText(npsPopMemoryCache.b(npsPopMemoryCache.e()));
            EditText editText4 = this.x;
            if (editText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                editText4 = null;
            }
            EditText editText5 = this.x;
            if (editText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
            } else {
                editText = editText5;
            }
            editText4.setSelection(editText.getText().length());
        }
        ((ImageView) view.findViewById(2131827522)).setOnClickListener(new View.OnClickListener() { // from class: com.dragon.read.nps.ui.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NpsPopDialogFragment.Eg(NpsPopDialogFragment.this, view2);
            }
        });
    }

    private final void ih(View view) {
        boolean z;
        Resources resources;
        Drawable drawable;
        Resources resources2;
        Drawable drawable2;
        Resources resources3;
        Resources resources4;
        Resources resources5;
        STATE state = this.i;
        STATE state2 = STATE.enum_low_score_state;
        if (state != state2 && state != state2 && state != STATE.enum_no_reason_item_state) {
            z = false;
        } else {
            z = true;
        }
        NsUiDepend nsUiDepend = NsUiDepend.IMPL;
        Drawable drawable3 = null;
        r6 = null;
        Drawable drawable4 = null;
        r6 = null;
        Drawable drawable5 = null;
        GradientDrawable gradientDrawable = null;
        drawable3 = null;
        if (nsUiDepend.isBlackTheme(this.j)) {
            if (z) {
                TextView textView = (TextView) view.findViewById(2131824953);
                if (textView != null) {
                    Context context = getContext();
                    if (context != null && (resources5 = context.getResources()) != null) {
                        drawable4 = resources5.getDrawable(2130848400);
                    }
                    textView.setBackground(drawable4);
                    return;
                }
                return;
            }
            TextView textView2 = (TextView) view.findViewById(2131824953);
            if (textView2 != null) {
                Context context2 = getContext();
                if (context2 != null && (resources4 = context2.getResources()) != null) {
                    drawable5 = resources4.getDrawable(2130848401);
                }
                textView2.setBackground(drawable5);
                return;
            }
            return;
        }
        if (z) {
            TextView textView3 = (TextView) view.findViewById(2131824953);
            if (textView3 != null) {
                Context context3 = getContext();
                if (context3 != null && (resources3 = context3.getResources()) != null) {
                    drawable2 = resources3.getDrawable(2130848402);
                } else {
                    drawable2 = null;
                }
                textView3.setBackground(drawable2);
            }
            if (this.j != 1) {
                Context context4 = getContext();
                if (context4 != null && (resources2 = context4.getResources()) != null) {
                    drawable = resources2.getDrawable(2130848403);
                } else {
                    drawable = null;
                }
                if (drawable != null) {
                    drawable.mutate();
                }
                if (drawable instanceof GradientDrawable) {
                    gradientDrawable = (GradientDrawable) drawable;
                }
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(nsUiDepend.getReaderCommonColor().a(this.j));
                }
                TextView textView4 = (TextView) view.findViewById(2131824953);
                if (textView4 != null) {
                    textView4.setBackground(drawable);
                    return;
                }
                return;
            }
            return;
        }
        TextView textView5 = (TextView) view.findViewById(2131824953);
        if (textView5 != null) {
            Context context5 = getContext();
            if (context5 != null && (resources = context5.getResources()) != null) {
                drawable3 = resources.getDrawable(2130848401);
            }
            textView5.setBackground(drawable3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void lh(View view) {
        Resources resources;
        Drawable drawable;
        Resources resources2;
        Drawable drawable2;
        Resources resources3;
        Resources resources4;
        Resources resources5;
        NsUiDepend nsUiDepend = NsUiDepend.IMPL;
        boolean z = false;
        Drawable drawable3 = null;
        r7 = null;
        Drawable drawable4 = null;
        r7 = null;
        Drawable drawable5 = null;
        GradientDrawable gradientDrawable = null;
        drawable3 = null;
        if (nsUiDepend.isBlackTheme(this.j)) {
            EditText editText = this.x;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                editText = null;
            }
            Editable text = editText.getText();
            if (text == null || text.length() == 0) {
                z = true;
            }
            if (!z) {
                TextView textView = (TextView) view.findViewById(2131828406);
                if (textView != null) {
                    Context context = getContext();
                    if (context != null && (resources5 = context.getResources()) != null) {
                        drawable4 = resources5.getDrawable(2130848404);
                    }
                    textView.setBackground(drawable4);
                    return;
                }
                return;
            }
            TextView textView2 = (TextView) view.findViewById(2131828406);
            if (textView2 != null) {
                Context context2 = getContext();
                if (context2 != null && (resources4 = context2.getResources()) != null) {
                    drawable5 = resources4.getDrawable(2130848405);
                }
                textView2.setBackground(drawable5);
                return;
            }
            return;
        }
        EditText editText2 = this.x;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
            editText2 = null;
        }
        Editable text2 = editText2.getText();
        if (text2 == null || text2.length() == 0) {
            z = true;
        }
        if (!z) {
            TextView textView3 = (TextView) view.findViewById(2131828406);
            if (textView3 != null) {
                Context context3 = getContext();
                if (context3 != null && (resources3 = context3.getResources()) != null) {
                    drawable2 = resources3.getDrawable(2130848406);
                } else {
                    drawable2 = null;
                }
                textView3.setBackground(drawable2);
            }
            if (this.j != 1) {
                Context context4 = getContext();
                if (context4 != null && (resources2 = context4.getResources()) != null) {
                    drawable = resources2.getDrawable(2130848407);
                } else {
                    drawable = null;
                }
                if (drawable != null) {
                    drawable.mutate();
                }
                if (drawable instanceof GradientDrawable) {
                    gradientDrawable = (GradientDrawable) drawable;
                }
                if (gradientDrawable != null) {
                    gradientDrawable.setColor(nsUiDepend.getReaderCommonColor().a(this.j));
                }
                TextView textView4 = (TextView) view.findViewById(2131828406);
                if (textView4 != null) {
                    textView4.setBackground(drawable);
                    return;
                }
                return;
            }
            return;
        }
        TextView textView5 = (TextView) view.findViewById(2131828406);
        if (textView5 != null) {
            Context context5 = getContext();
            if (context5 != null && (resources = context5.getResources()) != null) {
                drawable3 = resources.getDrawable(2130848405);
            }
            textView5.setBackground(drawable3);
        }
    }

    private final void mh(View view) {
        Drawable drawable;
        Resources resources;
        Drawable drawable2;
        GradientDrawable gradientDrawable;
        Resources resources2;
        NsUiDepend nsUiDepend = NsUiDepend.IMPL;
        EditText editText = null;
        if (!nsUiDepend.isBlackTheme(this.j) && this.j != 1) {
            Context context = getContext();
            if (context != null && (resources2 = context.getResources()) != null) {
                drawable2 = resources2.getDrawable(2130845581);
            } else {
                drawable2 = null;
            }
            if (drawable2 != null) {
                drawable2.mutate();
            }
            if (drawable2 instanceof GradientDrawable) {
                gradientDrawable = (GradientDrawable) drawable2;
            } else {
                gradientDrawable = null;
            }
            if (gradientDrawable != null) {
                gradientDrawable.setColor(nsUiDepend.getReaderCommonColor().a(this.j));
            }
            EditText editText2 = this.x;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                editText2 = null;
            }
            fh(editText2, drawable2);
        } else {
            EditText editText3 = this.x;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                editText3 = null;
            }
            Context context2 = getContext();
            if (context2 != null && (resources = context2.getResources()) != null) {
                drawable = resources.getDrawable(2130845581);
            } else {
                drawable = null;
            }
            fh(editText3, drawable);
        }
        EditText editText4 = this.x;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
        } else {
            editText = editText4;
        }
        editText.setTextColor(nsUiDepend.getReaderCommonColor().c(this.j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void nh(View view) {
        try {
            ConstraintLayout findViewById = view.findViewById(2131821115);
            if (findViewById != null) {
                findViewById.setBackground(new ColorDrawable(NsUiDepend.IMPL.getReaderCommonColor().b(this.j)));
            }
            ConstraintLayout findViewById2 = view.findViewById(2131828407);
            if (findViewById2 != null) {
                findViewById2.setBackground(new ColorDrawable(NsUiDepend.IMPL.getReaderCommonColor().b(this.j)));
            }
            ImageView imageView = (ImageView) view.findViewById(2131822181);
            if (imageView != null) {
                imageView.setBackground(new ColorDrawable(NsUiDepend.IMPL.getReaderCommonColor().b(this.j)));
            }
            TextView textView = (TextView) view.findViewById(2131831329);
            if (textView != null) {
                textView.setTextColor(NsUiDepend.IMPL.getReaderCommonColor().c(this.j));
            }
            TextView textView2 = (TextView) view.findViewById(2131825942);
            if (textView2 != null) {
                textView2.setTextColor(NsUiDepend.IMPL.getReaderCommonColor().c(this.j));
            }
            INpsViewProxy iNpsViewProxy = this.p;
            RecyclerView recyclerView = null;
            if (iNpsViewProxy == null) {
                Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
                iNpsViewProxy = null;
            }
            iNpsViewProxy.updateTheme(this.j);
            lh(view);
            mh(view);
            ih(view);
            hh(view);
            jh(view);
            RecyclerView recyclerView2 = this.s;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerReasonFlow");
            } else {
                recyclerView = recyclerView2;
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } catch (Exception e2) {
            LogWrapper.info(this.e, v6.e(e2), new Object[0]);
        }
    }

    protected final void dh(int i2) {
        String str;
        String position = this.c.getPosition();
        if (position == null) {
            Map<ResearchSceneType, String> a2 = vs4.p.a.a();
            Integer num = this.a.scene;
            if (num == null) {
                num = 0;
            }
            position = a2.get(num);
            if (position == null) {
                position = "unknown";
            }
        }
        Args args = new Args();
        args.putAll(this.c.h());
        args.put("position", position);
        args.put("score", Integer.valueOf(i2));
        UserResearchData userResearchData = this.a;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        args.put("research_id", str);
        args.put("read_duration", Long.valueOf(this.c.a()));
        args.put("listen_duration", Long.valueOf(this.c.b()));
        vs4.r rVar = vs4.r.a;
        String b2 = rVar.b();
        if (b2 != null) {
            args.put("book_id", b2);
        }
        String c2 = rVar.c();
        if (c2 != null) {
            args.put("group_id", c2);
        }
        if (rVar.d() != -1) {
            args.put("group_index", Integer.valueOf(rVar.d()));
        }
        LogWrapper.info(this.e, "[nps_query_score_result]:$" + args.toJsonString(), new Object[0]);
        ReportManager.onReport("nps_query_score_result", args);
    }

    private final void Hg(View view) {
        Context context;
        int i2;
        Context context2;
        Context context3;
        this.u = (FrameLayout) view.findViewById(2131830143);
        INpsViewProxy iNpsViewProxy = null;
        if (ig()) {
            View view2 = getView();
            if (view2 == null || (context3 = view2.getContext()) == null) {
                context3 = AppUtils.context();
                Intrinsics.checkNotNullExpressionValue(context3, "context(...)");
            }
            this.p = new h1(context3, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, UIKt.getDp(82));
            layoutParams.topMargin = UIKt.getDp(23);
            INpsViewProxy iNpsViewProxy2 = this.p;
            if (iNpsViewProxy2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
                iNpsViewProxy2 = null;
            }
            ((ConstraintLayout) iNpsViewProxy2).setPadding(UIKt.getDp(60), 0, UIKt.getDp(60), 0);
            INpsViewProxy iNpsViewProxy3 = this.p;
            if (iNpsViewProxy3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
                iNpsViewProxy3 = null;
            }
            ((ConstraintLayout) iNpsViewProxy3).setClipToPadding(false);
            INpsViewProxy iNpsViewProxy4 = this.p;
            if (iNpsViewProxy4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
                iNpsViewProxy4 = null;
            }
            ((ConstraintLayout) iNpsViewProxy4).setClipChildren(false);
            FrameLayout frameLayout = this.u;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("npsHeadContainer");
                frameLayout = null;
            }
            INpsViewProxy iNpsViewProxy5 = this.p;
            if (iNpsViewProxy5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
                iNpsViewProxy5 = null;
            }
            frameLayout.addView((View) iNpsViewProxy5, (ViewGroup.LayoutParams) layoutParams);
        } else {
            if (this.a.scoreOptionInfo.size() <= 3) {
                Map map = this.a.scoreSubTitle;
                if (map != null) {
                    i2 = map.size();
                } else {
                    i2 = 0;
                }
                if (i2 <= 3) {
                    View view3 = getView();
                    if (view3 == null || (context2 = view3.getContext()) == null) {
                        context2 = AppUtils.context();
                        Intrinsics.checkNotNullExpressionValue(context2, "context(...)");
                    }
                    this.p = new f1(context2, null);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, UIKt.getDp(52));
                    layoutParams2.topMargin = UIKt.getDp(27);
                    FrameLayout frameLayout2 = this.u;
                    if (frameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("npsHeadContainer");
                        frameLayout2 = null;
                    }
                    Object obj = this.p;
                    if (obj == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
                        obj = null;
                    }
                    frameLayout2.addView((View) obj, layoutParams2);
                }
            }
            View view4 = getView();
            if (view4 == null || (context = view4.getContext()) == null) {
                context = AppUtils.context();
                Intrinsics.checkNotNullExpressionValue(context, "context(...)");
            }
            this.p = new FiveEmojiView(context, null);
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, UIKt.getDp(90));
            layoutParams3.topMargin = UIKt.getDp(12);
            INpsViewProxy iNpsViewProxy6 = this.p;
            if (iNpsViewProxy6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
                iNpsViewProxy6 = null;
            }
            ((ConstraintLayout) iNpsViewProxy6).setPadding(UIKt.getDp(18), 0, UIKt.getDp(18), 0);
            INpsViewProxy iNpsViewProxy7 = this.p;
            if (iNpsViewProxy7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
                iNpsViewProxy7 = null;
            }
            ((ConstraintLayout) iNpsViewProxy7).setClipToPadding(false);
            INpsViewProxy iNpsViewProxy8 = this.p;
            if (iNpsViewProxy8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
                iNpsViewProxy8 = null;
            }
            ((ConstraintLayout) iNpsViewProxy8).setClipChildren(false);
            FrameLayout frameLayout3 = this.u;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("npsHeadContainer");
                frameLayout3 = null;
            }
            INpsViewProxy iNpsViewProxy9 = this.p;
            if (iNpsViewProxy9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
                iNpsViewProxy9 = null;
            }
            frameLayout3.addView((View) iNpsViewProxy9, (ViewGroup.LayoutParams) layoutParams3);
        }
        INpsViewProxy iNpsViewProxy10 = this.p;
        if (iNpsViewProxy10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
            iNpsViewProxy10 = null;
        }
        iNpsViewProxy10.setOnSelectChangedListener(this.h);
        INpsViewProxy iNpsViewProxy11 = this.p;
        if (iNpsViewProxy11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
            iNpsViewProxy11 = null;
        }
        iNpsViewProxy11.setClickSelectUIChangeEnable(false);
        INpsViewProxy iNpsViewProxy12 = this.p;
        if (iNpsViewProxy12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("npsEmotionView");
        } else {
            iNpsViewProxy = iNpsViewProxy12;
        }
        iNpsViewProxy.updateData(this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eg(NpsPopDialogFragment npsPopDialogFragment, View view) {
        npsPopDialogFragment.og();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Yg(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bh(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tg(NpsPopDialogFragment npsPopDialogFragment, View view) {
        npsPopDialogFragment.og();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rg(NpsPopDialogFragment npsPopDialogFragment, View view) {
        ActivityAnimType.FADE_IN_FADE_OUT.finish(npsPopDialogFragment.getActivity());
        npsPopDialogFragment.Vg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wg(final NpsPopDialogFragment npsPopDialogFragment, View view) {
        EditText editText = npsPopDialogFragment.x;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
            editText = null;
        }
        editText.requestFocus();
        ThreadUtils.postInForeground(new Runnable() { // from class: com.dragon.read.nps.ui.l0
            @Override // java.lang.Runnable
            public final void run() {
                NpsPopDialogFragment.xg(NpsPopDialogFragment.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bg(NpsPopDialogFragment npsPopDialogFragment, View view) {
        boolean z;
        EditText editText = npsPopDialogFragment.x;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
            editText = null;
        }
        Editable text = editText.getText();
        if (text != null && text.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            ToastUtils.showCommonToast("请输入内容");
        } else {
            npsPopDialogFragment.og();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ug(NpsPopDialogFragment npsPopDialogFragment, View view) {
        EditText editText = npsPopDialogFragment.x;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
            editText = null;
        }
        if (editText.isFocused()) {
            npsPopDialogFragment.og();
        } else {
            ActivityAnimType.FADE_IN_FADE_OUT.finish(npsPopDialogFragment.getActivity());
            npsPopDialogFragment.Vg();
        }
    }

    public final void fh(EditText editText, Drawable drawable) {
        try {
            if (editText != null && drawable != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    editText.setTextCursorDrawable(drawable);
                    return;
                }
                Field declaredField = EditText.class.getDeclaredField("mCursorDrawableRes");
                declaredField.setAccessible(true);
                declaredField.set(editText, 0);
                Field declaredField2 = EditText.class.getDeclaredField("mCursorDrawable");
                declaredField2.setAccessible(true);
                declaredField2.set(editText, drawable);
                Field declaredField3 = TextView.class.getDeclaredField("mEditor");
                declaredField3.setAccessible(true);
                Intrinsics.checkNotNullExpressionValue(declaredField3, "apply(...)");
                Object obj = declaredField3.get(editText);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                Field declaredField4 = obj.getClass().getDeclaredField("mDrawableForCursor");
                declaredField4.setAccessible(true);
                declaredField4.set(obj, drawable);
                return;
            }
            LogWrapper.info(this.e, "setCursorDrawable editText or drawable is null", new Object[0]);
        } catch (Exception e2) {
            v6.e(e2);
        }
    }

    protected final void ch(int i2, String reason) {
        boolean z;
        String str;
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (reason.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        ResearchSceneType researchSceneType = this.a.scene;
        String position = this.c.getPosition();
        if (position == null) {
            Map<ResearchSceneType, String> a2 = vs4.p.a.a();
            Integer num = this.a.scene;
            if (num == null) {
                num = 0;
            }
            position = a2.get(num);
            if (position == null) {
                position = "unknown";
            }
        }
        Args args = new Args();
        args.putAll(this.c.h());
        args.put("position", position);
        args.put("score", String.valueOf(i2));
        UserResearchData userResearchData = this.a;
        if (userResearchData != null) {
            str = userResearchData.researchId;
        } else {
            str = null;
        }
        args.put("research_id", str);
        args.put("reason", reason);
        args.put("read_duration", Long.valueOf(this.c.a()));
        args.put("listen_duration", Long.valueOf(this.c.b()));
        vs4.r rVar = vs4.r.a;
        String b2 = rVar.b();
        if (b2 != null) {
            args.put("book_id", b2);
        }
        String c2 = rVar.c();
        if (c2 != null) {
            args.put("group_id", c2);
        }
        if (rVar.d() != -1) {
            args.put("group_index", Integer.valueOf(rVar.d()));
        }
        LogWrapper.info(this.e, "[nps_query_reason_result]:" + args.toJsonString(), new Object[0]);
        ReportManager.onReport("nps_query_reason_result", args);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dg(NpsPopDialogFragment npsPopDialogFragment, View view) {
        int c2;
        ConstraintLayout.LayoutParams layoutParams;
        Rect rect = new Rect();
        View view2 = npsPopDialogFragment.getView();
        if (view2 != null) {
            view2.getWindowVisibleDisplayFrame(rect);
        }
        EditText editText = npsPopDialogFragment.x;
        ConstraintLayout.LayoutParams layoutParams2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
            editText = null;
        }
        int height = editText.getRootView().getHeight();
        int i2 = rect.bottom - rect.top;
        LogWrapper.info(npsPopDialogFragment.e, "screenHeight:" + height + " visibleHeight:" + i2, new Object[0]);
        if (npsPopDialogFragment.d) {
            c2 = height - rect.bottom;
        } else {
            int i3 = height - i2;
            EditText editText2 = npsPopDialogFragment.x;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                editText2 = null;
            }
            int statusHeight = i3 - StatusBarUtil.getStatusHeight(editText2.getContext());
            t3 t3Var = t3.a;
            EditText editText3 = npsPopDialogFragment.x;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
                editText3 = null;
            }
            Context context = editText3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            c2 = statusHeight - t3Var.c(context);
        }
        EditText editText4 = npsPopDialogFragment.x;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
            editText4 = null;
        }
        if (editText4.isFocused() && c2 > height * 0.15f) {
            LogWrapper.info(npsPopDialogFragment.e, "soft keyboard show", new Object[0]);
            ((ImageView) view.findViewById(2131827522)).setVisibility(0);
            ViewGroup viewGroup = npsPopDialogFragment.v;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jackupContainer");
                viewGroup = null;
            }
            viewGroup.setVisibility(0);
            ViewGroup viewGroup2 = npsPopDialogFragment.v;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jackupContainer");
                viewGroup2 = null;
            }
            ConstraintLayout.LayoutParams layoutParams3 = viewGroup2.getLayoutParams();
            if (layoutParams3 instanceof ConstraintLayout.LayoutParams) {
                layoutParams2 = layoutParams3;
            }
            if (layoutParams2 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = c2;
                return;
            }
            return;
        }
        LogWrapper.info(npsPopDialogFragment.e, "soft keyboard hide", new Object[0]);
        ((ImageView) view.findViewById(2131827522)).setVisibility(8);
        ViewGroup viewGroup3 = npsPopDialogFragment.v;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupContainer");
            viewGroup3 = null;
        }
        viewGroup3.setVisibility(8);
        ViewGroup viewGroup4 = npsPopDialogFragment.v;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupContainer");
            viewGroup4 = null;
        }
        ConstraintLayout.LayoutParams layoutParams4 = viewGroup4.getLayoutParams();
        if (layoutParams4 instanceof ConstraintLayout.LayoutParams) {
            layoutParams = layoutParams4;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = 0;
        }
        NpsPopMemoryCache npsPopMemoryCache = NpsPopMemoryCache.a;
        NpsPopMemoryCache.ResultKey e2 = npsPopMemoryCache.e();
        EditText editText5 = npsPopDialogFragment.x;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
            editText5 = null;
        }
        npsPopMemoryCache.i(e2, editText5.getText().toString());
        EditText editText6 = npsPopDialogFragment.t;
        if (editText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reasonEditText");
            editText6 = null;
        }
        ConstraintLayout.LayoutParams layoutParams5 = npsPopDialogFragment.x;
        if (layoutParams5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jackupEditText");
        } else {
            layoutParams2 = layoutParams5;
        }
        editText6.setText(layoutParams2.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ad, code lost:
    
        if (r3 != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void gg(com.dragon.read.nps.ui.NpsPopDialogFragment r7, android.view.View r8) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.nps.ui.NpsPopDialogFragment.gg(com.dragon.read.nps.ui.NpsPopDialogFragment, android.view.View):void");
    }

    public static final class e extends RecyclerView.ItemDecoration {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        e(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            outRect.left = UIKt.getDp(0);
            outRect.right = this.a;
            outRect.top = this.b;
            outRect.bottom = UIKt.getDp(0);
            if (childAdapterPosition < this.c) {
                outRect.top = UIKt.getDp(0);
            }
            int i = this.c;
            if (childAdapterPosition % i == i - 1) {
                outRect.right = UIKt.getDp(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Cg(NpsPopDialogFragment npsPopDialogFragment, View view, boolean z) {
        LogWrapper.info(npsPopDialogFragment.e, "isFocus:" + z + ' ' + view, new Object[0]);
    }

    public View onCreateContent(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LogWrapper.info(this.e, "NPS弹窗 onCreateContent", new Object[0]);
        vs4.n.a.h();
        Ig();
        View inflate = inflater.inflate(2131038814, viewGroup, false);
        Mg();
        Intrinsics.checkNotNull(inflate);
        Og(inflate);
        eh();
        Zg();
        Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
        return inflate;
    }

    public NpsPopDialogFragment(UserResearchData data, ReaderClient readerClient, a npsListener, boolean z) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(npsListener, "npsListener");
        this.a = data;
        this.b = readerClient;
        this.c = npsListener;
        this.d = z;
        this.e = "NPS_GLOBAL | NPS_POP_DIALOG";
        this.f = new k();
        this.g = new b();
        this.h = new j();
        this.i = STATE.enum_init_state;
        this.y = new l();
        this.z = new View.OnClickListener() { // from class: com.dragon.read.nps.ui.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NpsPopDialogFragment.gg(NpsPopDialogFragment.this, view);
            }
        };
    }
}
