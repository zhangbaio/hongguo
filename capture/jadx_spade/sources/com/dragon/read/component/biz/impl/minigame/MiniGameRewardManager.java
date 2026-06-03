package com.dragon.read.component.biz.impl.minigame;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.compose.runtime.internal.t;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.core.view.ViewCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.router.SmartRouter;
import com.dragon.read.app.ActivityRecordManager;
import com.dragon.read.app.App;
import com.dragon.read.base.ui.util.StatusBarUtil;
import com.dragon.read.base.util.ContextUtils;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.component.biz.api.IMiniGameCallbackRegister;
import com.dragon.read.component.biz.api.NsUgApi;
import com.dragon.read.component.biz.api.interfaces.IMiniGameRewardManager;
import com.dragon.read.component.biz.impl.game.minigamereward.CountdownManager;
import com.dragon.read.component.biz.impl.gamecenter.GameCenterActivity;
import com.dragon.read.util.ToastUtils;
import com.dragon.read.util.i7;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlow;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class MiniGameRewardManager implements IMiniGameRewardManager {
    public static final int $stable;
    public static final a Companion;
    private static final AtomicBoolean REGISTERED;
    private long accumulatedRewardCoin;
    private final b activityLifecycleCallback;
    private Job autoCollapseJob;
    private long cooldownEndUptimeMillis;
    private Job cooldownTickerJob;
    private final CoroutineExceptionHandler coroutineExceptionHandler;
    private CountdownManager countdownManager;
    private boolean enterRewardGranted;
    private long lastRoundRewardCoin;
    private final CoroutineScope mainScope;
    private final d miniGameCallback;
    private boolean miniGameResumed;
    private Job observingJob;
    private boolean requestingReward;
    private int roundsRewarded;
    private boolean showPendantInGameCenter;
    private long showRoundRewardHintEndUptimeMillis;
    private v taskConfig;
    private int countdownTotalSeconds = 60;
    private int countdownRemainingSeconds = 60;
    private boolean pendantExpanded = true;

    public static final class a {
        static {
            Covode.recordClassIndex(594690);
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void cancelCooldownTicker() {
        Job job = this.cooldownTickerJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.cooldownTickerJob = null;
    }

    private final void cancelPendantAutoCollapse() {
        Job job = this.autoCollapseJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.autoCollapseJob = null;
    }

    private final void onCountdownFinished() {
        v vVar = this.taskConfig;
        if (vVar == null || this.requestingReward) {
            return;
        }
        requestRoundRewardInternal(vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopCountdown() {
        int i;
        CountdownManager countdownManager = this.countdownManager;
        if (countdownManager != null) {
            i = countdownManager.g();
        } else {
            i = this.countdownRemainingSeconds;
        }
        this.countdownRemainingSeconds = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopCountdownForDailyCap() {
        int i = this.countdownTotalSeconds;
        this.countdownRemainingSeconds = i;
        CountdownManager countdownManager = this.countdownManager;
        if (countdownManager != null) {
            countdownManager.k(i);
        }
    }

    static {
        Covode.recordClassIndex(594689);
        Companion = new a(null);
        $stable = 8;
        REGISTERED = new AtomicBoolean(false);
    }

    private final int cooldownRemainingSeconds() {
        long coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.cooldownEndUptimeMillis - SystemClock.elapsedRealtime(), 0L);
        return (int) ((coerceAtLeast + 999) / 1000);
    }

    private final void detachPendant() {
        Activity currentVisibleActivity = ActivityRecordManager.inst().getCurrentVisibleActivity();
        if (currentVisibleActivity == null) {
            currentVisibleActivity = ActivityRecordManager.inst().getCurrentActivity();
        }
        detachPendant(currentVisibleActivity);
    }

    private final void ensureCountdownManager() {
        if (this.countdownManager != null) {
            return;
        }
        this.countdownManager = new CountdownManager(new com.dragon.read.component.biz.impl.game.minigamereward.a(this.countdownTotalSeconds, 3000L));
    }

    private final void ensureObservers() {
        CountdownManager countdownManager;
        Job e;
        if (this.observingJob != null || (countdownManager = this.countdownManager) == null) {
            return;
        }
        e = kotlinx.coroutines.i.e(this.mainScope, null, null, new ensureObservers.1(countdownManager, this, (Continuation) null), 3, null);
        this.observingJob = e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isInCooldown() {
        long j = this.cooldownEndUptimeMillis;
        if (j <= 0 || SystemClock.elapsedRealtime() >= j) {
            return false;
        }
        return true;
    }

    private final boolean isShowingRoundRewardHint() {
        long j = this.showRoundRewardHintEndUptimeMillis;
        if (j <= 0 || SystemClock.elapsedRealtime() >= j) {
            return false;
        }
        return true;
    }

    private final void ensureCooldownTicker() {
        Job e;
        Job job = this.cooldownTickerJob;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (z) {
            return;
        }
        e = kotlinx.coroutines.i.e(this.mainScope, null, null, new ensureCooldownTicker.1(this, (Continuation) null), 3, null);
        this.cooldownTickerJob = e;
    }

    private final String formatCooldownTimeText() {
        int cooldownRemainingSeconds = cooldownRemainingSeconds();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(cooldownRemainingSeconds / 60), Integer.valueOf(cooldownRemainingSeconds % 60)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final void resetForNewSchemaCall() {
        this.requestingReward = false;
        this.enterRewardGranted = false;
        this.accumulatedRewardCoin = 0L;
        this.roundsRewarded = 0;
        this.cooldownEndUptimeMillis = 0L;
        this.showRoundRewardHintEndUptimeMillis = 0L;
        this.lastRoundRewardCoin = 0L;
        cancelPendantAutoCollapse();
        cancelCooldownTicker();
        CountdownManager countdownManager = this.countdownManager;
        if (countdownManager != null) {
            countdownManager.e();
        }
        this.countdownManager = null;
        Job job = this.observingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.observingJob = null;
        this.countdownTotalSeconds = 60;
        this.countdownRemainingSeconds = 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetTimestamp() {
        v vVar = this.taskConfig;
        if (vVar != null) {
            this.taskConfig = v.b(vVar, false, (String) null, (String) null, 0L, 0, 0L, 0L, 0, 0, false, 0L, 0L, 0L, 4095, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearTask() {
        this.taskConfig = null;
        this.showPendantInGameCenter = false;
        this.requestingReward = false;
        CountdownManager countdownManager = this.countdownManager;
        if (countdownManager != null) {
            countdownManager.e();
        }
        this.countdownManager = null;
        Job job = this.observingJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.observingJob = null;
        cancelPendantAutoCollapse();
        cancelCooldownTicker();
        this.countdownTotalSeconds = 60;
        this.countdownRemainingSeconds = 60;
        this.accumulatedRewardCoin = 0L;
        this.enterRewardGranted = false;
        this.roundsRewarded = 0;
        this.cooldownEndUptimeMillis = 0L;
        this.showRoundRewardHintEndUptimeMillis = 0L;
        this.lastRoundRewardCoin = 0L;
        detachPendant();
        u.a.b(new t(false, "", "", 0.0f, true, false, "", "", 0L, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openWelfarePage() {
        Object m773constructorimpl;
        Activity currentVisibleActivity = ActivityRecordManager.inst().getCurrentVisibleActivity();
        if (currentVisibleActivity == null && (currentVisibleActivity = ActivityRecordManager.inst().getCurrentActivity()) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            SmartRouter.buildRoute(currentVisibleActivity, "sslocal://main?tabName=goldcoin&tab_type=0").open();
            m773constructorimpl = Result.m773constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
        if (m776exceptionOrNullimpl != null) {
            LogWrapper.error("MiniGameRewardManager", "openWelfarePage error", new Object[]{m776exceptionOrNullimpl});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startCountdown() {
        v vVar = this.taskConfig;
        if (vVar == null) {
            return;
        }
        if (!vVar.a) {
            clearTask();
            return;
        }
        if (isDailyCapReached(vVar)) {
            stopCountdownForDailyCap();
            updatePendantUi(vVar);
        } else {
            if (isInCooldown()) {
                updatePendantUi(vVar);
                return;
            }
            ensureCountdownManager();
            ensureObservers();
            CountdownManager countdownManager = this.countdownManager;
            if (countdownManager != null) {
                countdownManager.j(this.countdownTotalSeconds, Integer.valueOf(this.countdownRemainingSeconds), new Function0() { // from class: com.dragon.read.component.biz.impl.minigame.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit startCountdown$lambda$5;
                        startCountdown$lambda$5 = MiniGameRewardManager.startCountdown$lambda$5(MiniGameRewardManager.this);
                        return startCountdown$lambda$5;
                    }
                });
            }
            updatePendantUi(vVar);
        }
    }

    public MiniGameRewardManager() {
        Object m773constructorimpl;
        Object m773constructorimpl2;
        f fVar = new f(CoroutineExceptionHandler.Key);
        this.coroutineExceptionHandler = fVar;
        this.mainScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()).plus(fVar));
        d dVar = new d(this);
        this.miniGameCallback = dVar;
        this.activityLifecycleCallback = new b(this);
        if (REGISTERED.compareAndSet(false, true)) {
            try {
                Result.Companion companion = Result.Companion;
                ((IMiniGameCallbackRegister) ServiceManager.getService(IMiniGameCallbackRegister.class)).registerCallback(dVar);
                m773constructorimpl = Result.m773constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
            }
            Throwable m776exceptionOrNullimpl = Result.m776exceptionOrNullimpl(m773constructorimpl);
            if (m776exceptionOrNullimpl != null) {
                LogWrapper.error("MiniGameRewardManager", "registerCallback error", new Object[]{m776exceptionOrNullimpl});
            }
            try {
                App.context().registerActivityLifecycleCallbacks(this.activityLifecycleCallback);
                m773constructorimpl2 = Result.m773constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                m773constructorimpl2 = Result.m773constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable m776exceptionOrNullimpl2 = Result.m776exceptionOrNullimpl(m773constructorimpl2);
            if (m776exceptionOrNullimpl2 != null) {
                LogWrapper.error("MiniGameRewardManager", "registerActivityLifecycleCallbacks error", new Object[]{m776exceptionOrNullimpl2});
            }
        }
    }

    private final void schedulePendantAutoCollapse(v vVar) {
        this.pendantExpanded = true;
        schedulePendantAutoCollapseInternal(vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startCountdown$lambda$5(MiniGameRewardManager miniGameRewardManager) {
        miniGameRewardManager.onCountdownFinished();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDailyCapReached(v vVar) {
        long j = vVar.k;
        if (j <= 0 || vVar.l < j) {
            return false;
        }
        return true;
    }

    private final boolean isSameDay(v vVar) {
        v vVar2;
        if (vVar == null || (vVar2 = this.taskConfig) == null) {
            return false;
        }
        long j = vVar2.m;
        long j2 = vVar.m;
        if (j <= 0 || j2 <= 0) {
            return false;
        }
        return i7.t(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRewardSuccessForUi(long j) {
        long coerceAtLeast;
        this.pendantExpanded = true;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j, 0L);
        this.lastRoundRewardCoin = coerceAtLeast;
        this.showRoundRewardHintEndUptimeMillis = SystemClock.elapsedRealtime() + 3000;
        schedulePendantAutoCollapseInternal$default(this, null, 1, null);
    }

    private final void schedulePendantAutoCollapseInternal(v vVar) {
        Job e;
        cancelPendantAutoCollapse();
        e = kotlinx.coroutines.i.e(this.mainScope, null, null, new schedulePendantAutoCollapseInternal.1(this, vVar, (Continuation) null), 3, null);
        this.autoCollapseJob = e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFromGame(Uri uri) {
        if (uri == null) {
            return false;
        }
        String queryParameter = uri.getQueryParameter("launch_from");
        String queryParameter2 = uri.getQueryParameter("enter_from");
        if (!Intrinsics.areEqual(queryParameter, "in_mp") && !Intrinsics.areEqual(queryParameter2, "micro_game") && !Intrinsics.areEqual(queryParameter2, "mine_function")) {
            return false;
        }
        return true;
    }

    private final Uri parseUri(String str) {
        Object m773constructorimpl;
        Object obj = null;
        if (str == null) {
            return null;
        }
        if (!(!StringsKt__StringsKt.isBlank(str))) {
            str = null;
        }
        if (str == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(Uri.parse(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m773constructorimpl = Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m779isFailureimpl(m773constructorimpl)) {
            obj = m773constructorimpl;
        }
        return (Uri) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.dragon.read.component.biz.impl.minigame.v resolveTaskConfigForCreate(android.net.Uri r8) {
        /*
            r7 = this;
            com.dragon.read.component.biz.impl.minigame.v r0 = r7.parseTaskConfig(r8)
            if (r0 == 0) goto L18
            if (r8 == 0) goto Ld
            java.lang.String r8 = r8.getAuthority()
            goto Le
        Ld:
            r8 = 0
        Le:
            java.lang.String r1 = "game_center"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r1)
            if (r8 == 0) goto L18
            r8 = 1
            goto L19
        L18:
            r8 = 0
        L19:
            r7.showPendantInGameCenter = r8
            r1 = 0
            if (r0 == 0) goto L22
            long r3 = r0.l
            goto L23
        L22:
            r3 = r1
        L23:
            long r5 = r7.accumulatedRewardCoin
            int r8 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r8 > 0) goto L2f
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 <= 0) goto L2f
            r7.accumulatedRewardCoin = r3
        L2f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.biz.impl.minigame.MiniGameRewardManager.resolveTaskConfigForCreate(android.net.Uri):com.dragon.read.component.biz.impl.minigame.v");
    }

    private static final String updatePendantUi$formatAsWan(long j) {
        long coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j, 0L);
        int i = (int) (coerceAtLeast / 1000);
        int i2 = i / 10;
        int i3 = i % 10;
        if (i3 == 0) {
            return String.valueOf(i2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i2);
        sb.append('.');
        sb.append(i3);
        return sb.toString();
    }

    private static final String updatePendantUi$formatMinutes(int i) {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i, 0);
        int i2 = (int) ((coerceAtLeast * 10.0f) / 60.0f);
        int i3 = i2 / 10;
        int i4 = i2 % 10;
        if (i4 == 0) {
            return String.valueOf(i3);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i3);
        sb.append('.');
        sb.append(i4);
        return sb.toString();
    }

    public void onNewIntent(Intent intent) {
        Uri uri;
        Uri uri2 = null;
        if (intent != null) {
            uri = intent.getData();
        } else {
            uri = null;
        }
        if (isFromGame(uri)) {
            return;
        }
        if (intent != null) {
            uri2 = intent.getData();
        }
        if (parseTaskConfig(uri2) == null) {
            return;
        }
        resetTimestamp();
    }

    public void onSchemaEnter(String str) {
        if (!this.showPendantInGameCenter) {
            return;
        }
        Uri parseUri = parseUri(str);
        if (parseUri == null) {
            clearTask();
            return;
        }
        v parseTaskConfig = parseTaskConfig(parseUri);
        if (parseTaskConfig == null) {
            clearTask();
        } else {
            updatePendantUi(applyTaskConfig(parseTaskConfig));
        }
    }

    private final v applyTaskConfig(v vVar) {
        int coerceAtLeast;
        int i;
        int coerceIn;
        int coerceAtLeast2;
        long j;
        StateFlow stateFlow;
        boolean isSameDay = isSameDay(vVar);
        v vVar2 = this.taskConfig;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.countdownTotalSeconds, 1);
        CountdownManager countdownManager = this.countdownManager;
        if (countdownManager != null && (stateFlow = countdownManager.e) != null) {
            i = ((Number) stateFlow.getValue()).intValue();
        } else {
            i = this.countdownRemainingSeconds;
        }
        boolean z = false;
        coerceIn = RangesKt___RangesKt.coerceIn(i, 0, coerceAtLeast);
        if (!isSameDay || hasRoundTaskChanged(vVar2, vVar)) {
            z = true;
        }
        if (z) {
            resetForNewSchemaCall();
        }
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(vVar.e, 1);
        this.countdownTotalSeconds = coerceAtLeast2;
        if (z) {
            coerceIn = coerceAtLeast2;
        }
        this.countdownRemainingSeconds = coerceIn;
        if (!z) {
            j = Math.max(this.accumulatedRewardCoin, vVar.l);
        } else {
            j = vVar.l;
        }
        long j2 = j;
        this.accumulatedRewardCoin = j2;
        v b = v.b(vVar, false, (String) null, (String) null, 0L, 0, 0L, 0L, 0, 0, false, 0L, j2, 0L, 6143, (Object) null);
        this.taskConfig = b;
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void detachPendant(Activity activity) {
        View decorView;
        ViewGroup viewGroup;
        DraggablePendantContainer findViewById;
        ViewGroup viewGroup2;
        if (activity == null) {
            return;
        }
        cancelPendantAutoCollapse();
        cancelCooldownTicker();
        this.pendantExpanded = true;
        Window window = activity.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null || (viewGroup = (ViewGroup) decorView.findViewById(R.id.content)) == null || (findViewById = viewGroup.findViewById(2131829841)) == null) {
            return;
        }
        ViewParent parent = findViewById.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup2 = (ViewGroup) parent;
        } else {
            viewGroup2 = null;
        }
        if (viewGroup2 != null) {
            viewGroup2.removeView(findViewById);
        }
    }

    private final void attachPendantIfNeeded(GameCenterActivity gameCenterActivity) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = (ViewGroup) gameCenterActivity.getWindow().getDecorView().findViewById(R.id.content);
        if (viewGroup2 == null) {
            return;
        }
        DraggablePendantContainer findViewById = viewGroup2.findViewById(2131829841);
        if (findViewById != null) {
            if (findViewById.getParent() != null) {
                return;
            }
            ViewParent parent = findViewById.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(findViewById);
            }
        }
        DraggablePendantContainer draggablePendantContainer = new DraggablePendantContainer(gameCenterActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        draggablePendantContainer.setId(2131829841);
        ViewCompat.setElevation(draggablePendantContainer, ContextUtils.dp2px(gameCenterActivity, 8.0f));
        ComposeView composeView = new ComposeView(gameCenterActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setViewCompositionStrategy(new ViewCompositionStrategy.b(gameCenterActivity));
        composeView.setContent(t.c(1580703010, true, new c(draggablePendantContainer, this)));
        draggablePendantContainer.addView(composeView, new FrameLayout.LayoutParams(-2, -2));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = StatusBarUtil.getStatusHeight(gameCenterActivity) + ContextUtils.dp2px(gameCenterActivity, 80.0f);
        layoutParams.setMarginEnd(ContextUtils.dp2px(gameCenterActivity, 12.0f));
        viewGroup2.addView((View) draggablePendantContainer, (ViewGroup.LayoutParams) layoutParams);
    }

    private final void requestRoundRewardInternal(v vVar) {
        boolean z;
        LogWrapper.info("MiniGameRewardManager", "requestRoundRewardInternal, config: " + vVar, new Object[0]);
        if (isDailyCapReached(vVar)) {
            stopCountdownForDailyCap();
            updatePendantUi(vVar);
            LogWrapper.info("MiniGameRewardManager", "daily cap reached, config: " + vVar, new Object[0]);
            return;
        }
        if (isInCooldown()) {
            updatePendantUi(vVar);
            LogWrapper.info("MiniGameRewardManager", "cooldown, config: " + vVar, new Object[0]);
            return;
        }
        if (vVar.j && !this.enterRewardGranted && this.roundsRewarded == 0 && vVar.d > 0) {
            z = true;
        } else {
            z = false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Result.Companion companion = Result.Companion;
            jSONObject.put("enter_from", vVar.c);
            Result.m773constructorimpl(jSONObject.put("is_cheat", false));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m773constructorimpl(ResultKt.createFailure(th));
        }
        this.requestingReward = true;
        NsUgApi.IMPL.getTaskService().getReward(vVar.b, jSONObject, new e(this, vVar, z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0112, code lost:
    
        if (r5 > 0) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.dragon.read.component.biz.impl.minigame.v parseTaskConfig(android.net.Uri r31) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.biz.impl.minigame.MiniGameRewardManager.parseTaskConfig(android.net.Uri):com.dragon.read.component.biz.impl.minigame.v");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePendantUi(v vVar) {
        boolean z;
        float f;
        float coerceIn;
        float coerceIn2;
        float f2;
        boolean z2;
        String string;
        String string2;
        String str;
        boolean z3;
        StateFlow stateFlow;
        boolean booleanValue;
        String str2;
        StateFlow stateFlow2;
        boolean isDailyCapReached = isDailyCapReached(vVar);
        if (!isDailyCapReached && isInCooldown()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ensureCooldownTicker();
        } else {
            cancelCooldownTicker();
        }
        CountdownManager countdownManager = this.countdownManager;
        if (countdownManager != null && (stateFlow2 = countdownManager.c) != null) {
            f = ((Number) stateFlow2.getValue()).floatValue();
        } else {
            f = 1.0f;
        }
        if (z) {
            f2 = 0.0f;
        } else {
            coerceIn = RangesKt___RangesKt.coerceIn(1.0f - f, 0.0f, 1.0f);
            coerceIn2 = RangesKt___RangesKt.coerceIn(coerceIn * 100.0f, 0.0f, 100.0f);
            f2 = coerceIn2;
        }
        if (!isDailyCapReached && isShowingRoundRewardHint()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (isDailyCapReached) {
            if (this.accumulatedRewardCoin >= 10000) {
                string = App.context().getString(2131104716, new Object[]{updatePendantUi$formatAsWan(this.accumulatedRewardCoin)});
            } else {
                string = App.context().getString(2131104715, new Object[]{Long.valueOf(this.accumulatedRewardCoin)});
            }
        } else if (z2) {
            string = App.context().getString(2131104715, new Object[]{Long.valueOf(this.lastRoundRewardCoin)});
        } else if (vVar.j && this.roundsRewarded == 0 && !this.enterRewardGranted && vVar.d > 0) {
            string = App.context().getString(2131104719, new Object[]{Long.valueOf(vVar.d)});
        } else {
            string = App.context().getString(2131104722);
        }
        Intrinsics.checkNotNull(string);
        if (isDailyCapReached) {
            string2 = App.context().getString(2131104718);
        } else if (z2) {
            string2 = App.context().getString(2131104717);
        } else if (vVar.j) {
            string2 = App.context().getString(2131104720, new Object[]{updatePendantUi$formatMinutes(vVar.e), Long.valueOf(vVar.f)});
        } else {
            string2 = App.context().getString(2131104721);
        }
        Intrinsics.checkNotNull(string2);
        u uVar = u.a;
        boolean z4 = this.showPendantInGameCenter;
        if (z) {
            str = "";
        } else {
            str = string;
        }
        if (z) {
            string2 = "";
        }
        if (z) {
            z3 = false;
        } else {
            if (z4) {
                booleanValue = this.pendantExpanded;
            } else {
                CountdownManager countdownManager2 = this.countdownManager;
                if (countdownManager2 != null && (stateFlow = countdownManager2.g) != null) {
                    booleanValue = ((Boolean) stateFlow.getValue()).booleanValue();
                } else {
                    z3 = true;
                }
            }
            z3 = booleanValue;
        }
        if (!z) {
            str2 = "";
        } else {
            str2 = formatCooldownTimeText();
        }
        uVar.b(new t(z4, str, string2, f2, z3, z, str2, String.valueOf(this.accumulatedRewardCoin), this.accumulatedRewardCoin, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshPendant(GameCenterActivity gameCenterActivity, v vVar) {
        updatePendantUi(vVar);
        attachPendantIfNeeded(gameCenterActivity);
        schedulePendantAutoCollapse(vVar);
    }

    private final boolean parseBoolean(String str, boolean z) {
        boolean z2;
        if (str != null && str.length() != 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return z;
        }
        if (!Intrinsics.areEqual(str, "1") && !StringsKt__StringsJVMKt.equals(str, "true", true)) {
            return false;
        }
        return true;
    }

    private static final String parseTaskConfig$getTaskParamString(JSONObject jSONObject, String... strArr) {
        boolean z;
        int length = strArr.length;
        int i = 0;
        while (true) {
            String str = null;
            if (i >= length) {
                return null;
            }
            String str2 = strArr[i];
            if (jSONObject != null) {
                str = jSONObject.optString(str2);
            }
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                return str;
            }
            i++;
        }
    }

    private final boolean hasRoundTaskChanged(v vVar, v vVar2) {
        if (vVar == null) {
            return false;
        }
        if (Intrinsics.areEqual(vVar.b, vVar2.b) && vVar.d == vVar2.d && vVar.e == vVar2.e && vVar.f == vVar2.f && vVar.g == vVar2.g && vVar.h == vVar2.h && vVar.i == vVar2.i && vVar.k == vVar2.k && vVar.j == vVar2.j) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRoundRewarded(v vVar, long j) {
        int i = this.roundsRewarded + 1;
        this.roundsRewarded = i;
        int i2 = vVar.h;
        if (i2 > 0 && vVar.i > 0 && i % i2 == 0) {
            this.cooldownEndUptimeMillis = SystemClock.elapsedRealtime() + (vVar.i * 1000);
            CountdownManager countdownManager = this.countdownManager;
            if (countdownManager != null) {
                countdownManager.g();
            }
            this.countdownRemainingSeconds = this.countdownTotalSeconds;
        }
        updatePendantUi(vVar);
        ToastUtils.showCommonToast(App.context().getString(2131104723, new Object[]{Integer.valueOf(vVar.e / 60), Long.valueOf(j)}));
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000d, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final int parseTaskConfig$getTaskParamInt(org.json.JSONObject r1, java.lang.String[] r2, int r3) {
        /*
            int r0 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r0)
            java.lang.String[] r2 = (java.lang.String[]) r2
            java.lang.String r1 = parseTaskConfig$getTaskParamString(r1, r2)
            if (r1 == 0) goto L17
            java.lang.Integer r1 = kotlin.text.StringsKt.toIntOrNull(r1)
            if (r1 == 0) goto L17
            int r3 = r1.intValue()
        L17:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.biz.impl.minigame.MiniGameRewardManager.parseTaskConfig$getTaskParamInt(org.json.JSONObject, java.lang.String[], int):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000d, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final long parseTaskConfig$getTaskParamLong(org.json.JSONObject r1, java.lang.String[] r2, long r3) {
        /*
            int r0 = r2.length
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r0)
            java.lang.String[] r2 = (java.lang.String[]) r2
            java.lang.String r1 = parseTaskConfig$getTaskParamString(r1, r2)
            if (r1 == 0) goto L17
            java.lang.Long r1 = kotlin.text.StringsKt.toLongOrNull(r1)
            if (r1 == 0) goto L17
            long r3 = r1.longValue()
        L17:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dragon.read.component.biz.impl.minigame.MiniGameRewardManager.parseTaskConfig$getTaskParamLong(org.json.JSONObject, java.lang.String[], long):long");
    }

    static /* synthetic */ void schedulePendantAutoCollapse$default(MiniGameRewardManager miniGameRewardManager, v vVar, int i, Object obj) {
        if ((i & 1) != 0) {
            vVar = miniGameRewardManager.taskConfig;
        }
        miniGameRewardManager.schedulePendantAutoCollapse(vVar);
    }

    static /* synthetic */ void schedulePendantAutoCollapseInternal$default(MiniGameRewardManager miniGameRewardManager, v vVar, int i, Object obj) {
        if ((i & 1) != 0) {
            vVar = miniGameRewardManager.taskConfig;
        }
        miniGameRewardManager.schedulePendantAutoCollapseInternal(vVar);
    }

    private static final boolean parseTaskConfig$getTaskParamBoolean(MiniGameRewardManager miniGameRewardManager, JSONObject jSONObject, String[] strArr, boolean z) {
        String parseTaskConfig$getTaskParamString = parseTaskConfig$getTaskParamString(jSONObject, (String[]) Arrays.copyOf(strArr, strArr.length));
        if (parseTaskConfig$getTaskParamString == null) {
            return z;
        }
        return miniGameRewardManager.parseBoolean(parseTaskConfig$getTaskParamString, z);
    }

    static /* synthetic */ int parseTaskConfig$getTaskParamInt$default(JSONObject jSONObject, String[] strArr, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return parseTaskConfig$getTaskParamInt(jSONObject, strArr, i);
    }

    static /* synthetic */ long parseTaskConfig$getTaskParamLong$default(JSONObject jSONObject, String[] strArr, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        return parseTaskConfig$getTaskParamLong(jSONObject, strArr, j);
    }
}
