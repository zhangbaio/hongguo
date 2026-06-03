package com.ss.ttvideoengine;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import androidx.core.content.ContextCompat;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.dragon.read.base.util.LogWrapper;
import com.ss.ttvideoengine.log.PortraitNetworkScore;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import com.ss.ttvideoengine.utils.TTVideoEngineUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTNetWorkListener extends BroadcastReceiver {
    private static TTNetWorkListener mInst;
    private Thread mThread;
    private int mCurrentAccessType = 1000;
    private int mCurrentAccessStrength = 10;
    private Lock mLock = new ReentrantLock();
    private CopyOnWriteArrayList<WeakReference<TTNetworkStateCallback>> mListeners = new CopyOnWriteArrayList<>();
    private int mInited = 0;
    private TTPhoneStateListener mPhoneStateListener = null;
    private boolean mIsWifiSensitiveMode = false;

    private static int convertNetworkType(int i) {
        if (i == 20) {
            return 4;
        }
        switch (i) {
            case 1:
            case 2:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 4:
            case 5:
            case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
            case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
            case 9:
            case 10:
            case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
            case 14:
            case 15:
            case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                return 3;
            case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                return 1;
            default:
                return 6;
        }
    }

    public int getCurrentAccessStrength() {
        return this.mCurrentAccessStrength;
    }

    public int getCurrentAccessType() {
        return this.mCurrentAccessType;
    }

    static {
        Covode.recordClassIndex(652324);
        mInst = null;
    }

    public static synchronized TTNetWorkListener getInstance() {
        TTNetWorkListener tTNetWorkListener;
        synchronized (TTNetWorkListener.class) {
            if (mInst == null) {
                mInst = new TTNetWorkListener();
            }
            tTNetWorkListener = mInst;
        }
        return tTNetWorkListener;
    }

    private TTNetWorkListener() {
    }

    public String getSignalStrength() {
        if (this.mCurrentAccessType == 1000) {
            return "unknown";
        }
        int i = this.mCurrentAccessStrength;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return "unknown";
                    }
                    return "excellent";
                }
                return "good";
            }
            return "medium";
        }
        return "weak";
    }

    private static class MyThread extends Thread {
        private WeakReference<Context> mContextRef;
        private WeakReference<TTNetWorkListener> mTTNetworkListener;

        static {
            Covode.recordClassIndex(652325);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            int sensitiveScene = TTVideoEngineUtils.getSensitiveScene();
            if (sensitiveScene == 1 || sensitiveScene == 2 || sensitiveScene == 3) {
                TTNetWorkListener.getInstance().mIsWifiSensitiveMode = true;
                TTVideoEngineLog.i("TTNetWorkListener", "is wifi sensitive mode:" + sensitiveScene);
            }
            TTNetWorkListener.getInstance().registerListener(this.mContextRef.get());
            Looper.loop();
            TTNetWorkListener tTNetWorkListener = this.mTTNetworkListener.get();
            if (tTNetWorkListener != null) {
                tTNetWorkListener.unregisterListener(this.mContextRef.get());
            }
        }

        public MyThread(Context context, TTNetWorkListener tTNetWorkListener) {
            this.mContextRef = new WeakReference<>(context.getApplicationContext());
            this.mTTNetworkListener = new WeakReference<>(tTNetWorkListener);
        }
    }

    private void _handleNetworkChange(Context context) {
        updateAccessType(getNetworkType(context));
    }

    private static class TTPhoneStateListener extends PhoneStateListener {
        private WeakReference<TTNetWorkListener> mHandler;
        private TelephonyManager mTelephonyManager;

        static {
            Covode.recordClassIndex(652326);
        }

        private static int com_ss_ttvideoengine_TTNetWorkListener$TTPhoneStateListener_android_content_Context_checkSelfPermission(Context context, String str) {
            Result preInvoke = new HeliosApiHook().preInvoke(102608, "android/content/Context", "checkSelfPermission", context, new Object[]{str}, "int", new ExtraInfo(false, "(Ljava/lang/String;)I", "auto_cert_com_ss_ttvideoengine_TTNetWorkListener$TTPhoneStateListener_android_content_Context_checkSelfPermission"));
            return preInvoke.isIntercept() ? ((Integer) preInvoke.getReturnValue()).intValue() : context.checkSelfPermission(str);
        }

        public void unregister(Context context) {
            if (this.mTelephonyManager != null) {
                listenCompact(context, this, 0);
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            TTNetWorkListener tTNetWorkListener;
            int i;
            super.onSignalStrengthsChanged(signalStrength);
            if (signalStrength != null && Build.VERSION.SDK_INT >= 23) {
                WeakReference<TTNetWorkListener> weakReference = this.mHandler;
                if (weakReference != null) {
                    tTNetWorkListener = weakReference.get();
                } else {
                    tTNetWorkListener = null;
                }
                if (tTNetWorkListener != null && tTNetWorkListener.mCurrentAccessType == 0) {
                    return;
                }
                try {
                    i = signalStrength.getLevel();
                    if (i == 0) {
                        i = 1;
                    }
                } catch (Exception unused) {
                    TTVideoEngineLog.e("TTNetWorkListener", "failed to get signalStrength");
                    i = -1;
                }
                if (tTNetWorkListener == null) {
                    return;
                }
                tTNetWorkListener._handleSigStrengthChange(i);
            }
        }

        public void register(Context context) {
            if (this.mTelephonyManager != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        TTVideoEngineLog.d("TTNetWorkListener", "start listen signal strength");
                        listenCompact(context, this, 256);
                    } catch (Exception unused) {
                        TTVideoEngineLog.e("TTNetWorkListener", "listen signal strength failed");
                    }
                }
                listenCompact(context, this, 64);
            }
        }

        public TTPhoneStateListener(Context context, TTNetWorkListener tTNetWorkListener) {
            this.mTelephonyManager = null;
            this.mHandler = null;
            if (tTNetWorkListener != null) {
                this.mHandler = new WeakReference<>(tTNetWorkListener);
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return;
                }
                this.mTelephonyManager = telephonyManager;
            } catch (Exception unused) {
                TTVideoEngineLog.e("TTNetWorkListener", "create telephonyManager failed");
                this.mTelephonyManager = null;
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int i, int i2) {
            WeakReference<TTNetWorkListener> weakReference;
            TTNetWorkListener tTNetWorkListener;
            super.onDataConnectionStateChanged(i, i2);
            TTVideoEngineLog.d("TTNetWorkListener", "data connection state changed, state: " + i + ", networkType: " + i2);
            if (i == 2 && (weakReference = this.mHandler) != null && (tTNetWorkListener = weakReference.get()) != null && tTNetWorkListener.mCurrentAccessType != 0) {
                tTNetWorkListener._handleNetworkChange(i2);
            }
        }

        private void listenCompact(Context context, PhoneStateListener phoneStateListener, int i) {
            TelephonyManager telephonyManager = this.mTelephonyManager;
            if (telephonyManager != null && context != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    if (com_ss_ttvideoengine_TTNetWorkListener$TTPhoneStateListener_android_content_Context_checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                        l3.a.y(this.mTelephonyManager, phoneStateListener, i);
                        return;
                    }
                    return;
                }
                l3.a.y(telephonyManager, phoneStateListener, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleNetworkChange(int i) {
        int convertNetworkType = convertNetworkType(i);
        TTVideoEngineLog.d("TTNetWorkListener", "network change to: " + convertNetworkType);
        updateAccessType(convertNetworkType);
    }

    public synchronized void init(Context context) {
        if (this.mInited != 0) {
            return;
        }
        this.mInited = 1;
        MyThread myThread = new MyThread(context, this);
        this.mThread = myThread;
        myThread.start();
    }

    public void startListen(WeakReference<TTNetworkStateCallback> weakReference) {
        if (weakReference == null) {
            return;
        }
        this.mLock.lock();
        this.mListeners.add(weakReference);
        this.mLock.unlock();
    }

    public void stopListen(WeakReference<TTNetworkStateCallback> weakReference) {
        if (weakReference == null) {
            return;
        }
        this.mLock.lock();
        this.mListeners.remove(weakReference);
        this.mLock.unlock();
    }

    public void unregisterListener(Context context) {
        if (context != null && this.mPhoneStateListener != null) {
            try {
                INVOKEVIRTUAL_com_ss_ttvideoengine_TTNetWorkListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(context, this);
                this.mPhoneStateListener.unregister(context);
            } catch (Exception unused) {
                TTVideoEngineLog.e("TTNetWorkListener", "Receiver has been unregistered!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void _handleSigStrengthChange(int i) {
        if (i != this.mCurrentAccessStrength) {
            this.mLock.lock();
            int i2 = this.mCurrentAccessStrength;
            this.mCurrentAccessStrength = i;
            TTVideoEngineLog.i("TTNetWorkListener", "strength changed, from: " + i2 + " to: " + this.mCurrentAccessStrength + " callback list size: " + this.mListeners.size());
            ArrayList arrayList = new ArrayList();
            Iterator<WeakReference<TTNetworkStateCallback>> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                WeakReference<TTNetworkStateCallback> next = it2.next();
                TTNetworkStateCallback tTNetworkStateCallback = next.get();
                if (tTNetworkStateCallback == null) {
                    arrayList.add(next);
                } else {
                    tTNetworkStateCallback.onAccessChanged(1, i2, this.mCurrentAccessStrength);
                }
            }
            if (arrayList.size() > 0) {
                this.mListeners.removeAll(arrayList);
            }
            this.mLock.unlock();
        }
    }

    private void updateAccessType(int i) {
        if (i != this.mCurrentAccessType) {
            this.mLock.lock();
            int i2 = this.mCurrentAccessType;
            this.mCurrentAccessType = i;
            TTVideoEngineLog.d("TTNetWorkListener", "access changed, from: " + i2 + " to: " + this.mCurrentAccessType + " callback list size: " + this.mListeners.size());
            ArrayList arrayList = new ArrayList();
            Iterator<WeakReference<TTNetworkStateCallback>> it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                WeakReference<TTNetworkStateCallback> next = it2.next();
                TTNetworkStateCallback tTNetworkStateCallback = next.get();
                if (tTNetworkStateCallback == null) {
                    arrayList.add(next);
                } else {
                    tTNetworkStateCallback.onAccessChanged(0, i2, this.mCurrentAccessType);
                }
            }
            if (arrayList.size() > 0) {
                this.mListeners.removeAll(arrayList);
            }
            this.mLock.unlock();
        }
    }

    public void registerListener(Context context) {
        try {
            TTVideoEngineLog.d("TTNetWorkListener", "enter start listen");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.net.wifi.RSSI_CHANGED");
            INVOKEVIRTUAL_com_ss_ttvideoengine_TTNetWorkListener_com_dragon_read_aop_BroadcastAop_registerReceiver(context, this, intentFilter);
            updateAccessType(getNetworkType(context));
            if (this.mCurrentAccessType == 0) {
                this.mCurrentAccessStrength = getWIFISignalStrength(context, null);
            }
            TTPhoneStateListener tTPhoneStateListener = new TTPhoneStateListener(context, this);
            this.mPhoneStateListener = tTPhoneStateListener;
            if (!this.mIsWifiSensitiveMode) {
                tTPhoneStateListener.register(context);
            }
            this.mInited = 1;
        } catch (Exception e) {
            TTVideoEngineLog.d(e);
            TTVideoEngineLog.d("TTNetWorkListener", "start listen network state failed");
        }
    }

    private int getNetworkType(Context context) {
        NetworkInfo.State state;
        if (context == null) {
            return 1000;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            TTVideoEngineLog.d("TTNetWorkListener", "disconnect");
            return -1;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                    TTVideoEngineLog.d("TTNetWorkListener", "wifi");
                    return 0;
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null) {
                    NetworkInfo.State state2 = networkInfo2.getState();
                    int subtype = activeNetworkInfo.getSubtype();
                    TTVideoEngineLog.d("TTNetWorkListener", "state: " + state2 + ", subtype: " + subtype);
                    if (state2 != null && (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                        return convertNetworkType(subtype);
                    }
                }
                return 1000;
            }
            TTVideoEngineLog.d("TTNetWorkListener", "disconnect 1");
            return -1;
        } catch (Exception e) {
            TTVideoEngineLog.e("TTNetWorkListener", e.toString());
            return 1000;
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    public static void INVOKEVIRTUAL_com_ss_ttvideoengine_TTNetWorkListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }

    public void setIntValue(int i, int i2) {
        if (i != 1) {
            if (i == 2) {
                PortraitNetworkScore.getInstance().setIntOption(3, i2);
                return;
            }
            return;
        }
        PortraitNetworkScore.getInstance().setIntOption(2, i2);
    }

    public void setStringValue(int i, String str) {
        if (i == 3 || i == 4 || i == 5) {
            PortraitNetworkScore.getInstance().setStringOption(i, str);
        }
    }

    private int getRssi(Context context, ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        WifiInfo wifiInfo = null;
        if (networkInfo != null && networkInfo.isConnected() && context.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", context.getPackageName()) == 0) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (Build.VERSION.SDK_INT >= 29 && (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) != null) {
                wifiInfo = (WifiInfo) networkCapabilities.getTransportInfo();
            }
            if (wifiInfo == null && wifiManager != null) {
                wifiInfo = l3.a.s(wifiManager);
            }
        }
        if (wifiInfo != null) {
            return wifiInfo.getRssi();
        }
        return -1;
    }

    private int getWIFISignalStrength(Context context, Intent intent) {
        int i;
        if (context == null) {
            return 10;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return 10;
            }
            if (intent != null) {
                i = intent.getIntExtra("newRssi", -70);
            } else if (!this.mIsWifiSensitiveMode) {
                i = getRssi(context, connectivityManager);
            } else {
                i = -1;
            }
            int calculateSignalLevel = WifiManager.calculateSignalLevel(i, 4);
            TTVideoEngineLog.d("TTNetWorkListener", "wifi dbm:" + i + ", level:" + calculateSignalLevel);
            return calculateSignalLevel + 1;
        } catch (Exception e) {
            TTVideoEngineLog.e("TTNetWorkListener", e.toString());
            return 10;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (!isInitialStickyBroadcast() && intent != null) {
            if ("android.net.wifi.RSSI_CHANGED".equals(intent.getAction()) && this.mCurrentAccessType == 0) {
                if (!TTVideoEngineUtils.isFlagOn(EngineGlobalConfig.getInstance().getEngineOptimizeFlag(), 32L)) {
                    _handleSigStrengthChange(getWIFISignalStrength(context, intent));
                }
            } else {
                if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    return;
                }
                TTVideoEngineLog.d("TTNetWorkListener", "network broadcast:" + intent.getAction());
                _handleNetworkChange(context);
            }
        }
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_TTNetWorkListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
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
    public static Intent INVOKEVIRTUAL_com_ss_ttvideoengine_TTNetWorkListener_com_dragon_read_aop_BroadcastAop_registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter filter) {
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
        return INVOKEVIRTUAL_com_ss_ttvideoengine_TTNetWorkListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(context, broadcastReceiver, filter);
    }
}
