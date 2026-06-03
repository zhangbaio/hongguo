package com.ss.ttvideoengine.log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.base.util.LogWrapper;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.ss.ttvideoengine.EngineGlobalConfig;
import com.ss.ttvideoengine.log.HeadsetStateMonitor;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class HeadsetStateMonitor {
    private static HeadsetStateMonitor sInstance;
    private final Context mContext;
    private HeadsetReceiver mHeadsetReceiver;
    private volatile boolean mIsStarted;
    private final List<HeadsetStateChangedListener> mChangeListener = new ArrayList();
    private volatile int mHeadsetState = 65280;
    private final Handler mHandler = new HandlerDelegate(Looper.getMainLooper());

    public interface HeadsetStateChangedListener {
        void onHeadsetStateChanged(boolean z, boolean z2);
    }

    static {
        Covode.recordClassIndex(652469);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class HeadsetReceiver extends BroadcastReceiver {
        static {
            Covode.recordClassIndex(652470);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$0() {
            HeadsetStateMonitor.this.onConnected(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$1() {
            HeadsetStateMonitor.this.onDisconnected(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$2() {
            HeadsetStateMonitor.this.onConnected(2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$3() {
            HeadsetStateMonitor.this.onDisconnected(2);
        }

        private HeadsetReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && !TextUtils.isEmpty(intent.getAction())) {
                TTVideoEngineLog.d("HeadsetStateMonitor", "onReceive: " + intent.getAction());
                String action = intent.getAction();
                action.hashCode();
                if (!action.equals("android.intent.action.HEADSET_PLUG")) {
                    if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                        if (intExtra == 2) {
                            HeadsetStateMonitor.runOnThread(HeadsetStateMonitor.this.mHandler, new Runnable() { // from class: com.ss.ttvideoengine.log.i
                                @Override // java.lang.Runnable
                                public final void run() {
                                    HeadsetStateMonitor.HeadsetReceiver.this.lambda$onReceive$2();
                                }
                            });
                            return;
                        } else {
                            if (intExtra == 0) {
                                HeadsetStateMonitor.runOnThread(HeadsetStateMonitor.this.mHandler, new Runnable() { // from class: com.ss.ttvideoengine.log.j
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        HeadsetStateMonitor.HeadsetReceiver.this.lambda$onReceive$3();
                                    }
                                });
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                int intExtra2 = intent.getIntExtra("state", -1);
                if (intExtra2 == 1) {
                    HeadsetStateMonitor.runOnThread(HeadsetStateMonitor.this.mHandler, new Runnable() { // from class: com.ss.ttvideoengine.log.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            HeadsetStateMonitor.HeadsetReceiver.this.lambda$onReceive$0();
                        }
                    });
                } else if (intExtra2 == 0) {
                    HeadsetStateMonitor.runOnThread(HeadsetStateMonitor.this.mHandler, new Runnable() { // from class: com.ss.ttvideoengine.log.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            HeadsetStateMonitor.HeadsetReceiver.this.lambda$onReceive$1();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0() {
        this.mHeadsetState = getHeadsetState(this.mContext);
    }

    public void stop() {
        if (!this.mIsStarted) {
            return;
        }
        this.mIsStarted = false;
        unregisterBroadcastReceiver(this.mContext);
    }

    public boolean isWiredConnected() {
        if (this.mHeadsetState == 65280) {
            this.mHeadsetState = getHeadsetState(this.mContext);
        }
        if ((this.mHeadsetState & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean isWirelessConnected() {
        if (this.mHeadsetState == 65280) {
            this.mHeadsetState = getHeadsetState(this.mContext);
        }
        if ((this.mHeadsetState & 2) != 0) {
            return true;
        }
        return false;
    }

    public void start() {
        if (this.mIsStarted) {
            return;
        }
        this.mIsStarted = true;
        EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.log.e
            @Override // java.lang.Runnable
            public final void run() {
                HeadsetStateMonitor.this.lambda$start$0();
            }
        });
        if (this.mHeadsetReceiver == null) {
            registerBroadcastReceiver(this.mContext);
        }
    }

    public void addStateChangedListener(final HeadsetStateChangedListener headsetStateChangedListener) {
        runOnThread(this.mHandler, new Runnable() { // from class: com.ss.ttvideoengine.log.f
            @Override // java.lang.Runnable
            public final void run() {
                HeadsetStateMonitor.this.lambda$addStateChangedListener$1(headsetStateChangedListener);
            }
        });
    }

    public void removeStateChangedListener(final HeadsetStateChangedListener headsetStateChangedListener) {
        runOnThread(this.mHandler, new Runnable() { // from class: com.ss.ttvideoengine.log.d
            @Override // java.lang.Runnable
            public final void run() {
                HeadsetStateMonitor.this.lambda$removeStateChangedListener$2(headsetStateChangedListener);
            }
        });
    }

    public static HeadsetStateMonitor getInstance(Context context) {
        if (sInstance == null) {
            synchronized (HeadsetStateMonitor.class) {
                if (sInstance == null) {
                    sInstance = new HeadsetStateMonitor(context);
                }
            }
        }
        return sInstance;
    }

    private void registerBroadcastReceiver(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        HeadsetReceiver headsetReceiver = new HeadsetReceiver();
        this.mHeadsetReceiver = headsetReceiver;
        INVOKEVIRTUAL_com_ss_ttvideoengine_log_HeadsetStateMonitor_com_dragon_read_aop_BroadcastAop_registerReceiver(context, headsetReceiver, intentFilter);
    }

    private void unregisterBroadcastReceiver(Context context) {
        HeadsetReceiver headsetReceiver = this.mHeadsetReceiver;
        if (headsetReceiver != null) {
            try {
                INVOKEVIRTUAL_com_ss_ttvideoengine_log_HeadsetStateMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(context, headsetReceiver);
            } catch (Exception e) {
                TTVideoEngineLog.w("HeadsetStateMonitor", e.getMessage());
            }
            this.mHeadsetReceiver = null;
        }
    }

    private HeadsetStateMonitor(Context context) {
        this.mContext = context.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addListenerInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$addStateChangedListener$1(HeadsetStateChangedListener headsetStateChangedListener) {
        if (headsetStateChangedListener != null && !this.mChangeListener.contains(headsetStateChangedListener)) {
            this.mChangeListener.add(headsetStateChangedListener);
        }
        TTVideoEngineLog.d("HeadsetStateMonitor", "listener: " + this.mChangeListener.size());
    }

    private void notifyStateChanged(boolean z) {
        boolean z2;
        if (this.mChangeListener.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.mChangeListener.size(); i++) {
            try {
                HeadsetStateChangedListener headsetStateChangedListener = this.mChangeListener.get(i);
                if (headsetStateChangedListener != null) {
                    if (!isWiredConnected() && !isWirelessConnected()) {
                        z2 = false;
                        headsetStateChangedListener.onHeadsetStateChanged(z2, z);
                    }
                    z2 = true;
                    headsetStateChangedListener.onHeadsetStateChanged(z2, z);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnected(int i) {
        boolean z;
        TTVideoEngineLog.d("HeadsetStateMonitor", "onConnected, " + i);
        if (this.mHeadsetState == 65280) {
            this.mHeadsetState = getHeadsetState(this.mContext);
        }
        int i2 = this.mHeadsetState | i;
        if (i2 == this.mHeadsetState) {
            return;
        }
        this.mHeadsetState = i2;
        if (i == 2) {
            z = true;
        } else {
            z = false;
        }
        notifyStateChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDisconnected(int i) {
        TTVideoEngineLog.d("HeadsetStateMonitor", "onDisconnected");
        if (this.mHeadsetState == 65280) {
            this.mHeadsetState = getHeadsetState(this.mContext);
        }
        int i2 = (~i) & this.mHeadsetState;
        if (i2 == this.mHeadsetState) {
            return;
        }
        this.mHeadsetState = i2;
        notifyStateChanged(isWirelessConnected());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: removeListenerInternal, reason: merged with bridge method [inline-methods] */
    public void lambda$removeStateChangedListener$2(HeadsetStateChangedListener headsetStateChangedListener) {
        if (headsetStateChangedListener != null) {
            this.mChangeListener.remove(headsetStateChangedListener);
        }
        TTVideoEngineLog.d("HeadsetStateMonitor", "listener: " + this.mChangeListener.size());
    }

    private int getHeadsetState(Context context) {
        if (TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 4L) && !this.mIsStarted) {
            return 1;
        }
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (audioManager == null) {
                TTVideoEngineLog.e("HeadsetStateMonitor", "AudioManager is null");
                return 65280;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 23 && i != 25) {
                int i2 = 0;
                for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                    if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4) {
                        i2 |= 1;
                        TTVideoEngineLog.d("HeadsetStateMonitor", "wired device: " + ((Object) audioDeviceInfo.getProductName()));
                    }
                    if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 7) {
                        i2 |= 2;
                        TTVideoEngineLog.d("HeadsetStateMonitor", "bluetooth device: " + ((Object) audioDeviceInfo.getProductName()));
                    }
                }
                return i2;
            }
            boolean isWiredHeadsetOn = audioManager.isWiredHeadsetOn();
            if (audioManager.isBluetoothScoOn() || audioManager.isBluetoothA2dpOn()) {
                return (isWiredHeadsetOn ? 1 : 0) | 2;
            }
            return isWiredHeadsetOn ? 1 : 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 65280;
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void INVOKEVIRTUAL_com_ss_ttvideoengine_log_HeadsetStateMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void runOnThread(Handler handler, Runnable runnable) {
        if (Looper.myLooper() == handler.getLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_log_HeadsetStateMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
            }
            throw e;
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_log_HeadsetStateMonitor_com_dragon_read_aop_BroadcastAop_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        if (Build.VERSION.SDK_INT >= 34) {
            if (!(context instanceof Context)) {
                context = null;
            }
            if (context == null) {
                return null;
            }
            LogWrapper.error("BroadcastAop", "registerReceiver 要传flag参数啦！", new Object[0]);
            return ContextCompat.registerReceiver(context, broadcastReceiver, filter, 2);
        }
        return INVOKEVIRTUAL_com_ss_ttvideoengine_log_HeadsetStateMonitor_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, broadcastReceiver, filter);
    }
}
