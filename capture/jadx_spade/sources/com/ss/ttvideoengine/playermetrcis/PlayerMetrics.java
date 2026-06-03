package com.ss.ttvideoengine.playermetrcis;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.bytedance.covode.number.Covode;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.log.DeviceMonitorUtils;
import com.ss.ttvideoengine.playermetrcis.BatteryListener;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PlayerMetrics {
    private static ArrayList<String> mTheadList;
    private static final String[] mdlNames;
    private static final String[] pcdnNames;
    private BatteryListener batteryListener;
    private BatteryMetricsInfo mBatteryMetricsInfo;
    private Context mContext;
    private long mCurDuraiton;
    private ArrayList<DiagnoseInfo> mDiagnoseInfos;
    private long mLastMetricsTime;
    private int mMetricsAbility;
    private int mMetricsInterval;
    private PowerManager.OnThermalStatusChangedListener mThermalListener;
    private ThreadCPU mThreadCPU;
    private DiagnoseResult powResult;

    private static final class InstanceHolder {
        private static final PlayerMetrics sInstance;

        private InstanceHolder() {
        }

        static {
            Covode.recordClassIndex(652599);
            sInstance = new PlayerMetrics();
        }
    }

    public int getAbility() {
        return this.mMetricsAbility;
    }

    public static PlayerMetrics getInstance() {
        return InstanceHolder.sInstance;
    }

    public void refreshWhenBegin() {
        ThreadCPU threadCPU;
        if ((this.mMetricsAbility & 1024) <= 0 || (threadCPU = this.mThreadCPU) == null) {
            return;
        }
        threadCPU.refreshWhenBegin();
    }

    public void refreshWhenEnd() {
        ThreadCPU threadCPU;
        if ((this.mMetricsAbility & MediaPlayer.MEDIA_PLAYER_OPTION_APPID) <= 0 || (threadCPU = this.mThreadCPU) == null) {
            return;
        }
        threadCPU.refreshWhenEnd();
    }

    private PlayerMetrics() {
        this.mContext = null;
        this.mCurDuraiton = 0L;
        this.mLastMetricsTime = 0L;
        this.powResult = null;
        this.mBatteryMetricsInfo = null;
        this.mThermalListener = null;
        this.batteryListener = null;
        this.mDiagnoseInfos = null;
        this.mThreadCPU = null;
        this.mMetricsInterval = 60;
        this.mMetricsAbility = 0;
    }

    static {
        Covode.recordClassIndex(652598);
        pcdnNames = new String[]{"KSThread", "XYThread", "vdp:vidtask:m"};
        mdlNames = new String[]{"MediaLoad", "com.video.mdl.network_manager", "com.video.mdl.network_session"};
        mTheadList = null;
    }

    private void diagnose() {
        ArrayList<DiagnoseInfo> arrayList = this.mDiagnoseInfos;
        if (arrayList != null && !arrayList.isEmpty() && this.mDiagnoseInfos.size() > 5) {
            diagnoseInternal();
            TTVideoEngineLog.d("PlayerMetrics", "startDiagnose");
            this.mDiagnoseInfos.remove(0);
        }
    }

    private void removeThrmal() {
        PowerManager.OnThermalStatusChangedListener onThermalStatusChangedListener;
        Context context = this.mContext;
        if (context != null && this.mThermalListener != null && Build.VERSION.SDK_INT >= 29) {
            try {
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null && (onThermalStatusChangedListener = this.mThermalListener) != null) {
                    powerManager.removeThermalStatusListener(onThermalStatusChangedListener);
                    this.mThermalListener = null;
                }
            } catch (Exception e) {
                TTVideoEngineLog.i("PlayerMetrics", "thermalError: " + e);
            }
        }
    }

    private void diagnoseInternal() {
        DiagnoseResult diagnoseResult = this.powResult;
        if (diagnoseResult != null && this.mDiagnoseInfos != null) {
            diagnoseResult.reset();
            Iterator<DiagnoseInfo> it2 = this.mDiagnoseInfos.iterator();
            int i = 0;
            int i2 = 0;
            while (it2.hasNext()) {
                DiagnoseInfo next = it2.next();
                if (i > 0) {
                    i2 = Math.abs(i - next.mPowerUsage);
                }
                DiagnoseResult diagnoseResult2 = this.powResult;
                if (i2 > diagnoseResult2.maxValue) {
                    diagnoseResult2.maxValue = i2;
                }
                if (i2 > 1) {
                    diagnoseResult2.overCount++;
                }
                i = next.mPowerUsage;
            }
            if (this.mDiagnoseInfos.size() > 1) {
                DiagnoseInfo diagnoseInfo = this.mDiagnoseInfos.get(0);
                ArrayList<DiagnoseInfo> arrayList = this.mDiagnoseInfos;
                this.powResult.avgValue = diagnoseInfo.mPowerUsage - arrayList.get(arrayList.size() - 1).mPowerUsage;
            }
        }
    }

    private void startThermal() {
        Context context = this.mContext;
        if (context != null && this.mThermalListener == null && Build.VERSION.SDK_INT >= 29) {
            try {
                final PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    TTVideoEngineLog.i("PlayerMetrics", "start thermal");
                    PowerManager.OnThermalStatusChangedListener onThermalStatusChangedListener = new PowerManager.OnThermalStatusChangedListener() { // from class: com.ss.ttvideoengine.playermetrcis.PlayerMetrics.2
                        @Override // android.os.PowerManager.OnThermalStatusChangedListener
                        public void onThermalStatusChanged(int i) {
                            if (PlayerMetrics.this.mBatteryMetricsInfo == null) {
                                return;
                            }
                            TTVideoEngineLog.i("PlayerMetrics", "onThermalStatusChanged " + i);
                            if (PlayerMetrics.this.mBatteryMetricsInfo != null) {
                                if (i == 4) {
                                    PlayerMetrics.this.mBatteryMetricsInfo.mStartCriticalTime = System.currentTimeMillis();
                                } else if (PlayerMetrics.this.mBatteryMetricsInfo.mStartCriticalTime > 0) {
                                    PlayerMetrics.this.mBatteryMetricsInfo.mTotalCriticalTime += System.currentTimeMillis() - PlayerMetrics.this.mBatteryMetricsInfo.mStartCriticalTime;
                                    PlayerMetrics.this.mBatteryMetricsInfo.mStartCriticalTime = 0L;
                                } else {
                                    PlayerMetrics.this.mBatteryMetricsInfo.mStartCriticalTime = 0L;
                                }
                            }
                            if (i == 5) {
                                PlayerMetrics.this.mBatteryMetricsInfo.mStartEmergencyTime = System.currentTimeMillis();
                            } else if (PlayerMetrics.this.mBatteryMetricsInfo.mStartEmergencyTime > 0) {
                                PlayerMetrics.this.mBatteryMetricsInfo.mTotalEmergencyTime += System.currentTimeMillis() - PlayerMetrics.this.mBatteryMetricsInfo.mStartEmergencyTime;
                                PlayerMetrics.this.mBatteryMetricsInfo.mStartEmergencyTime = 0L;
                            } else {
                                PlayerMetrics.this.mBatteryMetricsInfo.mStartEmergencyTime = 0L;
                            }
                            PlayerMetrics.this.mBatteryMetricsInfo.mLastThermalState = i;
                        }
                    };
                    this.mThermalListener = onThermalStatusChangedListener;
                    powerManager.addThermalStatusListener(onThermalStatusChangedListener);
                }
            } catch (Exception e) {
                TTVideoEngineLog.i("PlayerMetrics", "thermalError: " + e);
            }
        }
    }

    public Map<String, Object> getMetricsLog() {
        Map<String, Object> playerThreads;
        HashMap hashMap = new HashMap();
        synchronized (this) {
            DiagnoseResult diagnoseResult = this.powResult;
            if (diagnoseResult != null && diagnoseResult.avgValue > 0) {
                hashMap.putAll(diagnoseResult.getMetricsInfo("pow"));
            }
            BatteryMetricsInfo batteryMetricsInfo = this.mBatteryMetricsInfo;
            if (batteryMetricsInfo != null) {
                Map<String, Object> metricsInfo = batteryMetricsInfo.getMetricsInfo(null);
                TTVideoEngineLog.d("PlayerMetrics", "getMetricsLog: " + metricsInfo);
                if (metricsInfo != null && metricsInfo.size() > 0) {
                    hashMap.putAll(metricsInfo);
                }
            }
            ThreadCPU threadCPU = this.mThreadCPU;
            if (threadCPU != null && (playerThreads = threadCPU.getPlayerThreads()) != null && playerThreads.size() > 0) {
                hashMap.putAll(playerThreads);
            }
        }
        return hashMap;
    }

    private void checkAbility() {
        int i = 0;
        if ((this.mMetricsAbility & 2) > 0) {
            if (this.mBatteryMetricsInfo == null) {
                this.mBatteryMetricsInfo = new BatteryMetricsInfo();
            }
            if (this.mContext != null && this.batteryListener == null) {
                BatteryListener batteryListener = new BatteryListener(this.mContext);
                this.batteryListener = batteryListener;
                batteryListener.register(new BatteryListener.BatteryStateListener() { // from class: com.ss.ttvideoengine.playermetrcis.PlayerMetrics.1
                    @Override // com.ss.ttvideoengine.playermetrcis.BatteryListener.BatteryStateListener
                    public void onStatePowerConnected() {
                        TTVideoEngineLog.i("PlayerMetrics", "onStatePowerConnected");
                        PlayerMetrics.this.mBatteryMetricsInfo.mStartPowerTime = 0L;
                        PlayerMetrics.this.mBatteryMetricsInfo.mPowerState = 0;
                    }

                    @Override // com.ss.ttvideoengine.playermetrcis.BatteryListener.BatteryStateListener
                    public void onStatePowerDisconnected() {
                        TTVideoEngineLog.i("PlayerMetrics", "onStatePowerDisconnected");
                        PlayerMetrics.this.mBatteryMetricsInfo.mStartPowerTime = System.currentTimeMillis();
                        PlayerMetrics.this.mBatteryMetricsInfo.mLastBatteryLevel = DeviceMonitorUtils.getPowerCapacity(PlayerMetrics.this.mContext);
                        PlayerMetrics.this.mBatteryMetricsInfo.mPowerState = 1;
                    }
                });
                if (!this.batteryListener.getInitialCharging()) {
                    TTVideoEngineLog.i("PlayerMetrics", "getInitialCharging");
                    this.mBatteryMetricsInfo.mStartPowerTime = System.currentTimeMillis();
                    this.mBatteryMetricsInfo.mLastBatteryLevel = DeviceMonitorUtils.getPowerCapacity(this.mContext);
                    this.mBatteryMetricsInfo.mPowerState = 0;
                }
            }
        }
        if ((this.mMetricsAbility & 4) > 0) {
            startThermal();
        }
        if ((this.mMetricsAbility & 1) > 0) {
            if (mTheadList == null) {
                mTheadList = new ArrayList<>();
                if ((this.mMetricsAbility & 64) > 0) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = mdlNames;
                        if (i2 >= strArr.length) {
                            break;
                        }
                        mTheadList.add(strArr[i2]);
                        i2++;
                    }
                }
                if ((this.mMetricsAbility & 128) > 0) {
                    while (true) {
                        String[] strArr2 = pcdnNames;
                        if (i >= strArr2.length) {
                            break;
                        }
                        mTheadList.add(strArr2[i]);
                        i++;
                    }
                }
            }
            if (this.mThreadCPU == null) {
                ThreadCPU threadCPU = new ThreadCPU();
                this.mThreadCPU = threadCPU;
                threadCPU.initThreadMonitor(mTheadList);
                this.mThreadCPU.refreshStaticThreads();
            }
        }
        synchronized (this) {
            if (this.powResult == null) {
                this.powResult = new DiagnoseResult();
            }
            if (this.mDiagnoseInfos == null) {
                this.mDiagnoseInfos = new ArrayList<>();
            }
        }
    }

    private void collectMetrics() {
        BatteryMetricsInfo batteryMetricsInfo;
        BatteryMetricsInfo batteryMetricsInfo2;
        ThreadCPU threadCPU;
        TTVideoEngineLog.d("PlayerMetrics", "start collectMetrics");
        DiagnoseInfo diagnoseInfo = new DiagnoseInfo();
        if ((this.mMetricsAbility & 1) > 0 && (threadCPU = this.mThreadCPU) != null) {
            threadCPU.refresh();
        }
        if ((this.mMetricsAbility & 2) > 0 && (batteryMetricsInfo2 = this.mBatteryMetricsInfo) != null && batteryMetricsInfo2.mStartPowerTime > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            int powerCapacity = DeviceMonitorUtils.getPowerCapacity(this.mContext);
            long currentTimeMillis2 = System.currentTimeMillis();
            BatteryMetricsInfo batteryMetricsInfo3 = this.mBatteryMetricsInfo;
            int i = batteryMetricsInfo3.mLastBatteryLevel;
            if (i > 0) {
                batteryMetricsInfo3.mCurrentBatteryUse = powerCapacity - i;
            } else {
                batteryMetricsInfo3.mCurrentBatteryUse = 0;
            }
            batteryMetricsInfo3.mLastBatteryLevel = powerCapacity;
            diagnoseInfo.mPowerUsage = powerCapacity;
            long j = currentTimeMillis2 - batteryMetricsInfo3.mStartPowerTime;
            diagnoseInfo.mPowerUsageTime = j;
            batteryMetricsInfo3.mTotalPowerTime = j;
            batteryMetricsInfo3.mStartPowerTime = currentTimeMillis2;
            TTVideoEngineLog.d("PlayerMetrics", "METRICS_ABILITY_POWER " + this.mBatteryMetricsInfo.mLastBatteryLevel + " costTime: " + (currentTimeMillis2 - currentTimeMillis) + " powertime: " + diagnoseInfo.mPowerUsageTime);
        }
        if ((this.mMetricsAbility & 16) > 0) {
            long currentTimeMillis3 = System.currentTimeMillis();
            int usingMemory = DeviceMonitorUtils.getUsingMemory();
            long currentTimeMillis4 = System.currentTimeMillis();
            diagnoseInfo.mMemUsage = usingMemory;
            TTVideoEngineLog.d("PlayerMetrics", "METRICS_ABILITY_MEMORY " + usingMemory + " costTime: " + (currentTimeMillis4 - currentTimeMillis3));
        }
        if ((this.mMetricsAbility & 4) > 0 && (batteryMetricsInfo = this.mBatteryMetricsInfo) != null) {
            diagnoseInfo.mCiticalTime = batteryMetricsInfo.getCurCriticalTime();
            diagnoseInfo.mEmergencyTime = this.mBatteryMetricsInfo.getCurEmergencyTime();
        }
        if ((this.mMetricsAbility & 256) > 0) {
            synchronized (this) {
                ArrayList<DiagnoseInfo> arrayList = this.mDiagnoseInfos;
                if (arrayList != null) {
                    arrayList.add(diagnoseInfo);
                }
                diagnose();
            }
        }
    }

    public void setMetricsAbilityOption(int i) {
        this.mMetricsAbility = i;
    }

    public void setMetricsIntervalOption(int i) {
        if (i == 0) {
            this.mMetricsInterval = 60;
        } else {
            this.mMetricsInterval = i;
        }
    }

    public void beginCpuRefresh(String str) {
        ThreadCPU threadCPU;
        int i = this.mMetricsAbility;
        if ((i & 1) <= 0 || (i & 32) <= 0 || (threadCPU = this.mThreadCPU) == null) {
            return;
        }
        threadCPU.refreshSingleThreads(str);
    }

    public void startMetric(Context context) {
        if (this.mMetricsAbility == 0) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = context.getApplicationContext();
        }
        checkAbility();
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mLastMetricsTime;
        if (j == 0) {
            this.mCurDuraiton = 0L;
        } else {
            this.mCurDuraiton += (currentTimeMillis - j) / 1000;
        }
        this.mLastMetricsTime = currentTimeMillis;
        int i = this.mMetricsInterval;
        if (i > 0 && this.mCurDuraiton >= i) {
            this.mCurDuraiton = 0L;
            collectMetrics();
        }
    }
}
