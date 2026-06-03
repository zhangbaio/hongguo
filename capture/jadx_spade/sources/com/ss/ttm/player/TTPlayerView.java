package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.util.Pair;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.ITTRenderView;
import com.ss.ttm.player.TTAVPlayerView;
import com.ss.ttm.player.TTPlayerViewHelper;
import com.ss.ttm.player.TTWindowClient;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class TTPlayerView extends FrameLayout implements TTAVPlayerView {
    private float mCropHeightLimit;
    private float mCropWidthLimit;
    private boolean mIsNeededFixedSize;
    private boolean mIsOnloadCallback;
    private boolean mIsSurfaceCreated;
    private boolean mIsTTPlayerDisplaySizeCalled;
    private TTAVPlayerView.LifeCycleCallback mLifeCycleCallback;
    private boolean mLockCpuBuffer;
    private boolean mNeedCrop;
    private ITTRenderView mRenderView;
    private int mScaleType;
    private float mVideoAspect;
    private TTPlayerViewHelper.Size mVideoSize;
    private int mViewType;
    private TTWindowClient mWindowClient;

    static {
        Covode.recordClassIndex(652194);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setScaleType$0() {
        forceLayout();
        requestLayout();
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public int getViewHeight() {
        return super.getHeight();
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public int getViewWidth() {
        return super.getWidth();
    }

    @Override // android.view.View, com.ss.ttm.player.TTAVPlayerView
    public int getVisibility() {
        return super.getVisibility();
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public boolean isSurfaceView() {
        return this.mRenderView instanceof TTSurfaceView;
    }

    private void registerRenderViewCallback() {
        this.mRenderView.setRenderCallback(new ITTRenderView.RenderCallback() { // from class: com.ss.ttm.player.TTPlayerView.2
            @Override // com.ss.ttm.player.ITTRenderView.RenderCallback
            public void onSurfaceDestroyed() {
                if (TTPlayerView.this.mWindowClient != null) {
                    TTPlayerView.this.mWindowClient.onWindowDestroyed();
                }
            }

            @Override // com.ss.ttm.player.ITTRenderView.RenderCallback
            public void onSurfaceCreated(Surface surface) {
                TTPlayerView.this.mLockCpuBuffer = false;
                TTPlayerView.this.mIsSurfaceCreated = true;
                if (TTPlayerView.this.mIsNeededFixedSize && TTPlayerView.this.mVideoSize != null) {
                    TTPlayerView.this.mRenderView.setFixedSizeIfNeeded(TTPlayerView.this.mVideoSize.getWidth(), TTPlayerView.this.mVideoSize.getHeight());
                }
                if (TTPlayerView.this.mLifeCycleCallback != null) {
                    if (TTPlayerView.this.mIsOnloadCallback) {
                        TTPlayerView.this.mWindowClient.onNewWindowAvailable(surface);
                    } else {
                        TTPlayerView.this.mIsOnloadCallback = true;
                        TTPlayerView.this.mLifeCycleCallback.onLoad(TTPlayerView.this.mWindowClient);
                    }
                    TTPlayerView.this.mLifeCycleCallback.onNewSurfaceAvailable();
                }
            }

            @Override // com.ss.ttm.player.ITTRenderView.RenderCallback
            public void onSurfaceChanged(int i, int i2) {
                com.ss.vcbkit.a.c("TTPlayerView", "ttmn player view: " + TTPlayerViewHelper.objectToString(this) + ", client: " + TTPlayerViewHelper.objectToString(TTPlayerView.this.mWindowClient) + ", vsize: " + TTPlayerView.this.mVideoSize + ", on surface changed： w: " + i + ", h: " + i2 + ", ext: " + TTPlayerView.this.mIsNeededFixedSize);
                if (TTPlayerView.this.mIsNeededFixedSize) {
                    if (TTPlayerView.this.mVideoSize != null && (i != TTPlayerView.this.mVideoSize.getWidth() || i2 != TTPlayerView.this.mVideoSize.getHeight())) {
                        TTPlayerView.this.mRenderView.setFixedSizeIfNeeded(TTPlayerView.this.mVideoSize.getWidth(), TTPlayerView.this.mVideoSize.getHeight());
                    }
                    if (TTPlayerView.this.mWindowClient != null) {
                        TTPlayerView.this.mWindowClient.onWindowChanged(TTPlayerView.this.mRenderView.getView().getWidth(), TTPlayerView.this.mRenderView.getView().getHeight(), TTPlayerView.this.mNeedCrop);
                        return;
                    }
                    return;
                }
                if (TTPlayerView.this.mWindowClient != null) {
                    TTPlayerView.this.mWindowClient.onWindowChanged(i, i2, TTPlayerView.this.mNeedCrop);
                }
            }
        });
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public Rect getSurfacePosition() {
        ITTRenderView iTTRenderView = this.mRenderView;
        if (iTTRenderView == null) {
            return null;
        }
        return TTPlayerViewHelper.getSurfaceRenderPosition(iTTRenderView.getView());
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public boolean isSurfaceAvailable() {
        Surface surface = this.mRenderView.getSurface();
        if (surface != null && surface.isValid()) {
            return true;
        }
        return false;
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void detachFromParent() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        com.ss.vcbkit.a.c("TTPlayerView", "ttmn player view detachFromParent:" + TTPlayerViewHelper.objectToString(this) + ", parent: " + TTPlayerViewHelper.objectToString(viewGroup));
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public Size getSurfaceSize() {
        if (this.mRenderView == null) {
            return new Size(0, 0);
        }
        return new Size(this.mRenderView.getView().getWidth(), this.mRenderView.getView().getHeight());
    }

    private void setupView() {
        if (this.mViewType != 2) {
            this.mRenderView = new TTSurfaceView(getContext());
        } else {
            this.mRenderView = new TTTextureView(getContext());
        }
        addView(this.mRenderView.getView());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRenderView.getView().getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        } else {
            layoutParams.gravity = 17;
        }
        this.mRenderView.getView().setLayoutParams(layoutParams);
        this.mWindowClient = new TTWindowClient(this.mRenderView, new TTWindowClient.WindowClientOnInfoCallback() { // from class: com.ss.ttm.player.TTPlayerView.1
            /* JADX WARN: Removed duplicated region for block: B:31:0x0112  */
            /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
            @Override // com.ss.ttm.player.TTWindowClient.WindowClientOnInfoCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onInfo(int r8, int r9) {
                /*
                    Method dump skipped, instructions count: 449
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.TTPlayerView.AnonymousClass1.onInfo(int, int):void");
            }
        });
        registerRenderViewCallback();
    }

    @Override // android.view.View, com.ss.ttm.player.TTAVPlayerView
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void attachToParent(ViewGroup viewGroup) {
        attachToParent(viewGroup, null);
    }

    @Override // android.view.View, com.ss.ttm.player.TTAVPlayerView
    public void setVisibility(int i) {
        super.setVisibility(i);
        ITTRenderView iTTRenderView = this.mRenderView;
        if (iTTRenderView != null) {
            iTTRenderView.getView().setVisibility(i);
        }
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void setLifeCycleCallback(TTAVPlayerView.LifeCycleCallback lifeCycleCallback) {
        TTAVPlayerView.LifeCycleCallback lifeCycleCallback2 = this.mLifeCycleCallback;
        if (lifeCycleCallback2 == null && lifeCycleCallback2 != lifeCycleCallback) {
            this.mLifeCycleCallback = lifeCycleCallback;
            if (lifeCycleCallback != null && !this.mIsOnloadCallback && this.mIsSurfaceCreated) {
                this.mIsOnloadCallback = true;
                lifeCycleCallback.onLoad(this.mWindowClient);
                this.mLifeCycleCallback.onNewSurfaceAvailable();
            }
        }
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void attachToParent(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        com.ss.vcbkit.a.c("TTPlayerView", "ttmn player view attachToParent: " + TTPlayerViewHelper.objectToString(this) + ", parent: " + TTPlayerViewHelper.objectToString(viewGroup));
        ViewGroup viewGroup2 = (ViewGroup) getParent();
        if (viewGroup != null && viewGroup2 != viewGroup) {
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
            }
            this.mRenderView.reuse();
            detachFromParent();
            setLayoutParams(layoutParams);
            viewGroup.addView(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDisplaySize(int i, int i2) {
        float f;
        com.ss.vcbkit.a.c("TTPlayerView", "ttmn player view: " + TTPlayerViewHelper.objectToString(this) + ", window: " + TTPlayerViewHelper.objectToString(this.mWindowClient) + ",update size called: " + this.mIsTTPlayerDisplaySizeCalled + ",width: " + i + ", height: " + i2 + ". fixed: " + this.mIsNeededFixedSize);
        if (i2 == 0) {
            f = 1.0f;
        } else {
            f = i / i2;
        }
        if (Math.abs(this.mVideoAspect - f) > 0.001f) {
            this.mVideoAspect = f;
            forceLayout();
            requestLayout();
        }
        TTPlayerViewHelper.Size size = this.mVideoSize;
        if (size == null || i != size.getWidth() || i2 != this.mVideoSize.getHeight()) {
            this.mVideoSize = new TTPlayerViewHelper.Size(i, i2);
            if (this.mIsNeededFixedSize) {
                this.mRenderView.setFixedSizeIfNeeded(i, i2);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected final void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Pair<TTPlayerViewHelper.Size, Boolean> calculatePlayerViewSize = TTPlayerViewHelper.calculatePlayerViewSize(this.mScaleType, this.mVideoAspect, size, size2, this.mCropWidthLimit, this.mCropHeightLimit);
        TTPlayerViewHelper.Size size3 = (TTPlayerViewHelper.Size) calculatePlayerViewSize.first;
        this.mNeedCrop = Boolean.TRUE.equals(calculatePlayerViewSize.second);
        if (size3 != null && size3.getWidth() != 0 && size3.getHeight() != 0) {
            com.ss.vcbkit.a.c("TTPlayerView", "ttmn player view : " + TTPlayerViewHelper.objectToString(this) + ", client: " + TTPlayerViewHelper.objectToString(this.mWindowClient) + ", render view: " + TTPlayerViewHelper.objectToString(this.mRenderView) + ",onMeasure: " + size3.toString() + " viewSize: " + size + "x" + size2 + ", scaleType: " + this.mScaleType + ", videoAspect: " + this.mVideoAspect);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3.getWidth(), 1073741824);
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size3.getHeight(), 1073741824);
            this.mRenderView.getView().measure(makeMeasureSpec, makeMeasureSpec2);
            if (getLayoutParams().width == -2) {
                setMeasuredDimension(makeMeasureSpec, makeMeasureSpec2);
                return;
            } else {
                setMeasuredDimension(i, i2);
                return;
            }
        }
        com.ss.vcbkit.a.e("TTPlayerView", "ttmn player view: " + TTPlayerViewHelper.objectToString(this) + ", client: " + TTPlayerViewHelper.objectToString(this.mWindowClient) + ", viewSize: " + size + "x" + size2 + "vaspect: " + this.mVideoAspect);
        measureChildren(i, i2);
        setMeasuredDimension(i, i2);
    }

    @Override // com.ss.ttm.player.TTAVPlayerView
    public void setScaleType(int i, float f, float f2) {
        if (this.mScaleType == i && this.mCropWidthLimit == f && this.mCropHeightLimit == f2) {
            return;
        }
        this.mScaleType = i;
        this.mCropWidthLimit = f;
        this.mCropHeightLimit = f2;
        post(new Runnable() { // from class: com.ss.ttm.player.e
            @Override // java.lang.Runnable
            public final void run() {
                TTPlayerView.this.lambda$setScaleType$0();
            }
        });
    }

    public TTPlayerView(Context context, int i, float f, int i2) {
        super(context);
        this.mWindowClient = null;
        this.mRenderView = null;
        this.mVideoAspect = 1.7777778f;
        this.mVideoSize = null;
        this.mScaleType = 0;
        this.mCropWidthLimit = 0.0f;
        this.mCropHeightLimit = 0.0f;
        this.mViewType = 1;
        this.mLifeCycleCallback = null;
        this.mIsOnloadCallback = false;
        this.mIsSurfaceCreated = false;
        this.mNeedCrop = false;
        this.mLockCpuBuffer = false;
        this.mIsNeededFixedSize = false;
        this.mIsTTPlayerDisplaySizeCalled = false;
        init(context, null, i, f, i2);
    }

    private void init(Context context, TTAVPlayerView.LifeCycleCallback lifeCycleCallback, int i, float f, int i2) {
        int i3;
        this.mLifeCycleCallback = lifeCycleCallback;
        if (i == 2) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        this.mViewType = i3;
        if (1 == i && !TTPlayerViewHelper.isEnableSurfaceView(context)) {
            this.mViewType = 2;
            com.ss.vcbkit.a.e("TTPlayerView", "ttmn player view current device not support surface view");
        }
        this.mVideoAspect = f;
        this.mScaleType = i2;
        setupView();
    }

    public TTPlayerView(Context context, TTAVPlayerView.LifeCycleCallback lifeCycleCallback, int i, float f, int i2) {
        super(context);
        this.mWindowClient = null;
        this.mRenderView = null;
        this.mVideoAspect = 1.7777778f;
        this.mVideoSize = null;
        this.mScaleType = 0;
        this.mCropWidthLimit = 0.0f;
        this.mCropHeightLimit = 0.0f;
        this.mViewType = 1;
        this.mLifeCycleCallback = null;
        this.mIsOnloadCallback = false;
        this.mIsSurfaceCreated = false;
        this.mNeedCrop = false;
        this.mLockCpuBuffer = false;
        this.mIsNeededFixedSize = false;
        this.mIsTTPlayerDisplaySizeCalled = false;
        init(context, lifeCycleCallback, i, f, i2);
    }
}
