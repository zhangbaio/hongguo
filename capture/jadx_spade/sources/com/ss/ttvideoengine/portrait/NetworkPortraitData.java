package com.ss.ttvideoengine.portrait;

import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.ttvideoengine.TTNetWorkListener;
import com.ss.ttvideoengine.info.networkRTTLevelListener;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class NetworkPortraitData {
    private networkRTTLevelListener mRTTLevelListener;
    private Timer mTimer;
    private TimerTask mTimerTask;
    private List<Integer> mCatowerRttList = Collections.emptyList();
    private List<Integer> mCatowerRttMsList = Collections.emptyList();
    private List<String> mSignalStrengthList = Collections.emptyList();
    private Map<Long, Float> mMdlSpeedList = Collections.emptyMap();
    private volatile int mNetLevelMaxCount = 100;
    private volatile int mNetTimerTaskIntervalMs = 0;
    private volatile int mNetMinDataSize = 120000;

    static {
        Covode.recordClassIndex(652605);
    }

    public List<Integer> getRttList() {
        return this.mCatowerRttList;
    }

    public List<String> getSignalStrengthList() {
        return this.mSignalStrengthList;
    }

    public int getNetworkRTTLevel() {
        networkRTTLevelListener networkrttlevellistener = this.mRTTLevelListener;
        if (networkrttlevellistener != null) {
            return networkrttlevellistener.onNetworkLog();
        }
        return -1;
    }

    public int getNetworkRTTMS() {
        networkRTTLevelListener networkrttlevellistener = this.mRTTLevelListener;
        if (networkrttlevellistener != null) {
            return networkrttlevellistener.getNetworkRTTMs();
        }
        return -1;
    }

    public List<Float> getMdlSeepList() {
        Map<Long, Float> map = this.mMdlSpeedList;
        if (map != null && !map.isEmpty()) {
            return new ArrayList(this.mMdlSpeedList.values());
        }
        return null;
    }

    public synchronized void stop() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        TimerTask timerTask = this.mTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
            this.mTimerTask = null;
        }
    }

    private class MyTimerTask extends TimerTask {
        static {
            Covode.recordClassIndex(652606);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int networkRTTLevel = NetworkPortraitData.this.getNetworkRTTLevel();
            int networkRTTMS = NetworkPortraitData.this.getNetworkRTTMS();
            String signalStrength = TTNetWorkListener.getInstance().getSignalStrength();
            synchronized (this) {
                if (NetworkPortraitData.this.mCatowerRttList.size() >= NetworkPortraitData.this.mNetLevelMaxCount) {
                    NetworkPortraitData.this.mCatowerRttList.remove(0);
                    NetworkPortraitData.this.mCatowerRttMsList.remove(0);
                    NetworkPortraitData.this.mSignalStrengthList.remove(0);
                }
                NetworkPortraitData.this.mCatowerRttList.add(Integer.valueOf(networkRTTLevel));
                NetworkPortraitData.this.mCatowerRttMsList.add(Integer.valueOf(networkRTTMS));
                NetworkPortraitData.this.mSignalStrengthList.add(signalStrength);
            }
        }

        private MyTimerTask() {
        }
    }

    public synchronized void start() {
        if (this.mNetTimerTaskIntervalMs <= 0) {
            TTVideoEngineLog.e("NetworkPortraitData", "invalid parameter");
            return;
        }
        List<Integer> list = this.mCatowerRttList;
        List<Integer> list2 = Collections.EMPTY_LIST;
        if (list == list2) {
            this.mCatowerRttList = new ArrayList();
        }
        if (this.mCatowerRttMsList == list2) {
            this.mCatowerRttMsList = new ArrayList();
        }
        if (this.mSignalStrengthList == list2) {
            this.mSignalStrengthList = new ArrayList();
        }
        if (this.mMdlSpeedList == Collections.EMPTY_MAP) {
            this.mMdlSpeedList = new LinkedHashMap();
        }
        TimerTask timerTask = this.mTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        if (this.mTimer == null) {
            this.mTimer = new PthreadTimer("net-portrait-data");
        }
        MyTimerTask myTimerTask = new MyTimerTask();
        this.mTimerTask = myTimerTask;
        this.mTimer.schedule(myTimerTask, 500L, this.mNetTimerTaskIntervalMs);
        TTVideoEngineLog.d("NetworkPortraitData", "network timer task scheduled, interval " + this.mNetTimerTaskIntervalMs);
    }

    public void setMinDataSize(int i) {
        this.mNetMinDataSize = i;
    }

    public void setNetworkRTTLevelListener(networkRTTLevelListener networkrttlevellistener) {
        this.mRTTLevelListener = networkrttlevellistener;
    }

    public List<Integer> getRttHistoryData(int i) {
        return getSubListToMeetMinSize(this.mCatowerRttList, i);
    }

    public List<Integer> getRttMsHistoryData(int i) {
        return getSubListToMeetMinSize(this.mCatowerRttMsList, i);
    }

    public void setMaxCount(int i) {
        if (i < 0) {
            return;
        }
        if (i < 10) {
            i = 10;
        }
        this.mNetLevelMaxCount = i;
    }

    public void setSampleInterval(int i) {
        if (i < 0) {
            return;
        }
        if (i < 500) {
            i = 500;
        }
        this.mNetTimerTaskIntervalMs = i;
    }

    public List<Float> getNetSpeedHistoryData(int i) {
        try {
            return getSubListToMeetMinSize(new ArrayList(this.mMdlSpeedList.values()), i);
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public void setNetSpeed(float f) {
        try {
            Map<Long, Float> map = this.mMdlSpeedList;
            if (map != Collections.EMPTY_MAP) {
                if (map.size() > this.mNetLevelMaxCount) {
                    this.mMdlSpeedList.remove(this.mMdlSpeedList.keySet().iterator().next());
                }
                this.mMdlSpeedList.put(Long.valueOf(System.currentTimeMillis()), Float.valueOf(f));
            }
        } catch (Exception e) {
            TTVideoEngineLog.e("NetworkPortraitData", e.getMessage());
        }
    }

    private <T> List<T> getSubListToMeetMinSize(List<T> list, int i) {
        if (this.mNetTimerTaskIntervalMs == 0) {
            return new ArrayList();
        }
        int i2 = (this.mNetMinDataSize / this.mNetTimerTaskIntervalMs) - i;
        if (i2 <= 0) {
            return new ArrayList();
        }
        if (i2 > list.size()) {
            return new ArrayList(list);
        }
        return list.subList(list.size() - i2, list.size());
    }

    public synchronized void schedule(TimerTask timerTask, int i) {
        if (this.mTimer == null) {
            this.mTimer = new PthreadTimer("net-portrait-data");
        }
        Timer timer = this.mTimer;
        if (i <= 0) {
            i = this.mNetTimerTaskIntervalMs;
        }
        timer.schedule(timerTask, 1000L, i);
        if (this.mTimerTask == null) {
            MyTimerTask myTimerTask = new MyTimerTask();
            this.mTimerTask = myTimerTask;
            this.mTimer.schedule(myTimerTask, 1000L, this.mNetTimerTaskIntervalMs);
        }
        TTVideoEngineLog.d("NetworkPortraitData", "network timer task scheduled, interval " + this.mNetTimerTaskIntervalMs);
    }
}
