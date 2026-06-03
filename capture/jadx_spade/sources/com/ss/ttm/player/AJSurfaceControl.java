package com.ss.ttm.player;

import android.graphics.Rect;
import android.graphics.Region;
import android.hardware.HardwareBuffer;
import android.hardware.SyncFence;
import android.view.SurfaceControl;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.utils.AVLogger;
import java.util.Locale;
import java.util.function.Consumer;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class AJSurfaceControl {
    private long mNativeHandler;
    private SurfaceControl mSurfaceControl;
    private Rect mSourceCrop = new Rect(0, 0, 0, 0);
    private Region mDamageRegion = new Region(0, 0, 0, 0);
    private int mBufferTransform = 0;
    private SurfaceControl.Transaction mTransaction = new SurfaceControl.Transaction();

    static {
        Covode.recordClassIndex(652074);
    }

    private native void _onBufferRelease(long j, long j2, SyncFence syncFence);

    public AJSurfaceControl() {
        AVLogger.Info("AJSurfaceControl", this, "init transaction = " + this.mTransaction);
    }

    public void release() {
        AVLogger.Info("AJSurfaceControl", this, "release transaction = " + this.mTransaction);
        SurfaceControl.Transaction transaction = this.mTransaction;
        if (transaction != null) {
            transaction.close();
            this.mTransaction = null;
        }
        this.mNativeHandler = 0L;
    }

    public void setCallback(long j) {
        AVLogger.Info("AJSurfaceControl", this, "set callback = " + String.format(Locale.US, "%x", Long.valueOf(j)));
        this.mNativeHandler = j;
    }

    public void update(SurfaceControl surfaceControl) {
        AVLogger.Info("AJSurfaceControl", this, "update surface control = " + surfaceControl);
        SurfaceControl surfaceControl2 = this.mSurfaceControl;
        if (surfaceControl2 != null) {
            this.mTransaction.reparent(surfaceControl2, null).apply();
            this.mSourceCrop.setEmpty();
            this.mDamageRegion.setEmpty();
            this.mBufferTransform = 0;
        }
        this.mSurfaceControl = surfaceControl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$draw$0(long j, HardwareBuffer hardwareBuffer, SyncFence syncFence) {
        if (syncFence != null && syncFence.isValid()) {
            _onBufferRelease(this.mNativeHandler, j, syncFence);
        } else {
            _onBufferRelease(this.mNativeHandler, j, null);
        }
        if (hardwareBuffer != null) {
            hardwareBuffer.close();
        }
    }

    public void draw(final long j, final HardwareBuffer hardwareBuffer, Rect rect, Rect rect2, int i) {
        Rect rect3;
        if (this.mSurfaceControl != null && this.mTransaction != null) {
            if ((rect != null && !this.mSourceCrop.equals(rect)) || ((rect2 != null && !this.mDamageRegion.quickContains(rect2)) || this.mBufferTransform != i)) {
                if (rect != null && !rect.isEmpty()) {
                    rect3 = new Rect(rect);
                    if (i != 3) {
                        if (i != 4) {
                            if (i == 7) {
                                rect3.left = rect.top;
                                rect3.top = hardwareBuffer.getWidth() - rect.right;
                                rect3.right = rect3.left + rect.height();
                                rect3.bottom = rect3.top + rect.width();
                            }
                        } else {
                            int height = hardwareBuffer.getHeight() - rect.bottom;
                            rect3.left = height;
                            rect3.top = rect.left;
                            rect3.right = height + rect.height();
                            rect3.bottom = rect3.top + rect.width();
                        }
                    } else {
                        rect3.left = hardwareBuffer.getWidth() - rect.right;
                        rect3.top = hardwareBuffer.getHeight() - rect.bottom;
                        rect3.right = rect3.left + rect.width();
                        rect3.bottom = rect3.top + rect.height();
                    }
                } else {
                    rect3 = new Rect(0, 0, hardwareBuffer.getWidth(), hardwareBuffer.getHeight());
                    int i2 = this.mBufferTransform;
                    if (i2 == 4 || i2 == 7) {
                        rect3.right = hardwareBuffer.getHeight();
                        rect3.bottom = hardwareBuffer.getWidth();
                    }
                }
                AVLogger.Info("AJSurfaceControl", this, "set crop = " + rect3);
                this.mTransaction.setCrop(this.mSurfaceControl, rect3);
                this.mSourceCrop = new Rect(rect);
                if (rect2 != null && !rect2.isEmpty()) {
                    float width = (rect2.width() * 1.0f) / rect3.width();
                    float height2 = (rect2.height() * 1.0f) / rect3.height();
                    AVLogger.Info("AJSurfaceControl", this, "set scale = [" + width + "," + height2 + "]");
                    this.mTransaction.setScale(this.mSurfaceControl, width, height2);
                    float f = width * ((float) rect3.left);
                    float f2 = height2 * ((float) rect3.top);
                    AVLogger.Info("AJSurfaceControl", this, "set position = [" + f + "," + f2 + "]");
                    this.mTransaction.setPosition(this.mSurfaceControl, ((float) rect2.left) - f, ((float) rect2.top) - f2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("set damage region = ");
                    sb.append(rect2);
                    AVLogger.Info("AJSurfaceControl", this, sb.toString());
                    this.mTransaction.setDamageRegion(this.mSurfaceControl, new Region(rect2));
                    this.mDamageRegion = new Region(rect2);
                }
                AVLogger.Info("AJSurfaceControl", this, "set buffer transform = " + i);
                this.mTransaction.setBufferTransform(this.mSurfaceControl, i);
                this.mBufferTransform = i;
            }
            this.mTransaction.setBuffer(this.mSurfaceControl, hardwareBuffer, null, new Consumer() { // from class: com.ss.ttm.player.a
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    AJSurfaceControl.this.lambda$draw$0(j, hardwareBuffer, (SyncFence) obj);
                }
            }).apply();
            return;
        }
        AVLogger.Error("AJSurfaceControl", this, "draw failed, invalid surface control or transaction");
        _onBufferRelease(this.mNativeHandler, j, null);
        if (hardwareBuffer != null) {
            hardwareBuffer.close();
        }
    }
}
