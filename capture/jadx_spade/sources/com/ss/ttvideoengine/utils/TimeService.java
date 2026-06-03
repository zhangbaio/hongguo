package com.ss.ttvideoengine.utils;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.ss.ttvideoengine.net.NetUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TimeService {
    private static int mErrorCount;
    private static boolean mForceUseLocalTime;
    private static String mNtpServer;
    private static int mState;
    private static TimeInfo mTimeInfo;

    static /* synthetic */ int access$508() {
        int i = mErrorCount;
        mErrorCount = i + 1;
        return i;
    }

    static class TimeInfo {
        private long mNtpTime = -1;
        private long mLocalTime = -1;

        static {
            Covode.recordClassIndex(652766);
        }

        TimeInfo() {
        }

        public boolean isUpdated() {
            if (this.mNtpTime > 0) {
                return true;
            }
            return false;
        }
    }

    static {
        Covode.recordClassIndex(652765);
        mNtpServer = null;
        mTimeInfo = new TimeInfo();
        mState = 0;
        mForceUseLocalTime = true;
        mErrorCount = 0;
    }

    public static boolean isUpdated() {
        synchronized (TimeService.class) {
            TimeInfo timeInfo = mTimeInfo;
            if (timeInfo != null) {
                return timeInfo.isUpdated();
            }
            return false;
        }
    }

    public static long currentTimeMillis() {
        if (!mForceUseLocalTime) {
            synchronized (TimeService.class) {
                TimeInfo timeInfo = mTimeInfo;
                if (timeInfo != null && timeInfo.isUpdated()) {
                    return (mTimeInfo.mNtpTime + SystemClock.elapsedRealtime()) - mTimeInfo.mLocalTime;
                }
            }
        }
        return System.currentTimeMillis();
    }

    public static void updateTimeFromNTP(final Context context) {
        if (!mForceUseLocalTime && !TextUtils.isEmpty(mNtpServer)) {
            synchronized (TimeService.class) {
                TimeInfo timeInfo = mTimeInfo;
                if (timeInfo != null && timeInfo.isUpdated()) {
                    return;
                }
                if (context != null && !NetUtils.isNetAvailable(context)) {
                    TTVideoEngineLog.d("TimeService", "network unavailable");
                } else if (mState == 0) {
                    mState = 1;
                    if (mErrorCount > 6) {
                        return;
                    }
                    EngineThreadPool.addExecuteTask(new Runnable() { // from class: com.ss.ttvideoengine.utils.TimeService.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SntpClient sntpClient = new SntpClient();
                            boolean requestTime = sntpClient.requestTime(TimeService.mNtpServer, 10000);
                            synchronized (TimeService.class) {
                                if (requestTime) {
                                    if (TimeService.mTimeInfo != null) {
                                        TimeService.mTimeInfo.mNtpTime = sntpClient.getNtpTime();
                                        TimeService.mTimeInfo.mLocalTime = sntpClient.getNtpTimeReference();
                                        int unused = TimeService.mState = 2;
                                        TTVideoEngineLog.d("TimeService", "NTP updated time:" + TimeService.longToStringWithFormat((TimeService.mTimeInfo.mNtpTime + SystemClock.elapsedRealtime()) - TimeService.mTimeInfo.mLocalTime, "yyyy-MM-dd HH:mm:ss.SSS"));
                                    }
                                } else {
                                    Context context2 = context;
                                    if (context2 != null && NetUtils.isNetAvailable(context2)) {
                                        TimeService.access$508();
                                    }
                                    TTVideoEngineLog.d("TimeService", "NTP update fail,error count:" + TimeService.mErrorCount);
                                    int unused2 = TimeService.mState = 0;
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    public static String longToStringWithFormat(long j, String str) {
        try {
            return new SimpleDateFormat(str).format(new Date(j));
        } catch (Exception unused) {
            return "";
        }
    }

    public static void setForceUseLocalTime(boolean z, String str) {
        TTVideoEngineLog.d("TimeService", "force use localtime:" + z);
        mForceUseLocalTime = z;
        mNtpServer = str;
    }
}
