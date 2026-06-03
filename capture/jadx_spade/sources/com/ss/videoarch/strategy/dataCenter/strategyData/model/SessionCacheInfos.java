package com.ss.videoarch.strategy.dataCenter.strategyData.model;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.Serializable;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class SessionCacheInfos implements Serializable {
    String TAG = "SessionCacheInfos";
    public boolean isValid = false;
    public String mSessionId = "";
    public String mDomain = "";
    public long mPlayTime = 0;
    public long mDownloadSpeed = 0;
    public String mNetwork = "";
    public String mUpdate = "";
    public String mCreate = "";
    public int mRetryTotalCount = 0;
    public long mStopTimestamp = 0;
    public JSONObject mSession_time_series = null;
    public long mFirstFrameAudioBuffer = 0;
    public long mFirstFrameVideoBuffer = 0;
    public long mFirstFrameDownloadSpeed = 0;
    public long mFirstFrame = 0;
    public int mSuccess = 0;
    public int m302 = 0;
    public int mConnectCost = 0;
    public int mStallType = 0;
    public long mStallTime = 0;
    public long mStartTs = 0;
    public int mStallTotalCount = 0;
    public long mStallTotalTime = 0;
    public long mEndTs = 0;
    public long mDuration = 0;
    public String mEnterMethod = "none";
    public String mEnterAction = "none";
    public int mIsPreview = 0;
    public int mBitrate = 0;
    public String mNeptuneName = "";
    public float mFPS = 0.0f;
    public int mGop = 0;
    public int mSampleRate = 0;
    public int mChannel = 0;
    public int mHeight = 0;
    public int mWidth = 0;
    public String mStreamSuffix = "";
    public String mProtocol = "";
    public long mVideoBuffer = 0;
    public long mAudioBuffer = 0;
    public long mEstimatedBandwidth = 0;
    public ConcurrentLinkedQueue<Long> mVideoBufferList = new ConcurrentLinkedQueue<>();
    public ConcurrentLinkedQueue<Long> mAudioBufferList = new ConcurrentLinkedQueue<>();
    public ConcurrentLinkedQueue<Long> mRenderAudioSeries = new ConcurrentLinkedQueue<>();
    public ConcurrentLinkedQueue<Long> mRenderVideoSeries = new ConcurrentLinkedQueue<>();
    public ConcurrentLinkedQueue<Long> mStallSeries = new ConcurrentLinkedQueue<>();
    public int mBufferDataSeconds = 0;
    public int mDoubleBufferDataSeconds = 0;

    static {
        Covode.recordClassIndex(653132);
    }

    public String toString() {
        return "SessionCacheInfos{mSessionId='" + this.mSessionId + "', mDomain='" + this.mDomain + "', mPlayTime=" + this.mPlayTime + ", mDownloadSpeed=" + this.mDownloadSpeed + ", mNetwork='" + this.mNetwork + "', mUpdate='" + this.mUpdate + "', mCreate='" + this.mCreate + "'}";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getValue(String str, T t) {
        char c;
        Object obj;
        try {
            switch (str.hashCode()) {
                case -1927368268:
                    if (str.equals("Duration")) {
                        c = 11;
                        break;
                    }
                    c = 65535;
                    break;
                case -1754979095:
                    if (str.equals("Update")) {
                        c = '!';
                        break;
                    }
                    c = 65535;
                    break;
                case -1683202543:
                    if (str.equals("SessionID")) {
                        c = 30;
                        break;
                    }
                    c = 65535;
                    break;
                case -1656530148:
                    if (str.equals("NeptuneName")) {
                        c = 26;
                        break;
                    }
                    c = 65535;
                    break;
                case -1348421033:
                    if (str.equals("RenderAudioSeries")) {
                        c = 25;
                        break;
                    }
                    c = 65535;
                    break;
                case -1266030831:
                    if (str.equals("StreamSuffix")) {
                        c = 27;
                        break;
                    }
                    c = 65535;
                    break;
                case -1231353099:
                    if (str.equals("BufferDataSeconds")) {
                        c = '$';
                        break;
                    }
                    c = 65535;
                    break;
                case -1157606636:
                    if (str.equals("StopTimestamp")) {
                        c = 17;
                        break;
                    }
                    c = 65535;
                    break;
                case -924519752:
                    if (str.equals("Protocol")) {
                        c = 31;
                        break;
                    }
                    c = 65535;
                    break;
                case -903626825:
                    if (str.equals("ConnectCost")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -786828786:
                    if (str.equals("Network")) {
                        c = ' ';
                        break;
                    }
                    c = 65535;
                    break;
                case -747805892:
                    if (str.equals("RenderVideoSeries")) {
                        c = 24;
                        break;
                    }
                    c = 65535;
                    break;
                case -709528236:
                    if (str.equals("AudioBufferList")) {
                        c = 23;
                        break;
                    }
                    c = 65535;
                    break;
                case -589160937:
                    if (str.equals("StallSeries")) {
                        c = 21;
                        break;
                    }
                    c = 65535;
                    break;
                case -304489875:
                    if (str.equals("StallTime")) {
                        c = '\t';
                        break;
                    }
                    c = 65535;
                    break;
                case -304474406:
                    if (str.equals("StallType")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -232532383:
                    if (str.equals("StartTs")) {
                        c = '\b';
                        break;
                    }
                    c = 65535;
                    break;
                case -202516509:
                    if (str.equals("Success")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 50549:
                    if (str.equals("302")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case 69833:
                    if (str.equals("FPS")) {
                        c = 20;
                        break;
                    }
                    c = 65535;
                    break;
                case 67098778:
                    if (str.equals("EndTs")) {
                        c = '\n';
                        break;
                    }
                    c = 65535;
                    break;
                case 84113122:
                    if (str.equals("FirstFrameDownloadSpeed")) {
                        c = 15;
                        break;
                    }
                    c = 65535;
                    break;
                case 278230227:
                    if (str.equals("RetryTotalCount")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case 568537785:
                    if (str.equals("FirstFrameAudioBuffer")) {
                        c = '\r';
                        break;
                    }
                    c = 65535;
                    break;
                case 819629183:
                    if (str.equals("DownloadSpeed")) {
                        c = 19;
                        break;
                    }
                    c = 65535;
                    break;
                case 888094667:
                    if (str.equals("StallTotalCount")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1106004766:
                    if (str.equals("IsPreview")) {
                        c = 7;
                        break;
                    }
                    c = 65535;
                    break;
                case 1169152926:
                    if (str.equals("FirstFrameVideoBuffer")) {
                        c = 14;
                        break;
                    }
                    c = 65535;
                    break;
                case 1193711374:
                    if (str.equals("EnterAction")) {
                        c = 28;
                        break;
                    }
                    c = 65535;
                    break;
                case 1539107257:
                    if (str.equals("EnterMethod")) {
                        c = 29;
                        break;
                    }
                    c = 65535;
                    break;
                case 1809510589:
                    if (str.equals("FirstFrame")) {
                        c = 16;
                        break;
                    }
                    c = 65535;
                    break;
                case 1830263953:
                    if (str.equals("StallTotalTime")) {
                        c = '\f';
                        break;
                    }
                    c = 65535;
                    break;
                case 1943403585:
                    if (str.equals("PlayTime")) {
                        c = 18;
                        break;
                    }
                    c = 65535;
                    break;
                case 2052636900:
                    if (str.equals("Domain")) {
                        c = '\"';
                        break;
                    }
                    c = 65535;
                    break;
                case 2073378034:
                    if (str.equals("isValid")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 2105319413:
                    if (str.equals("EstimatedBandwidth")) {
                        c = '#';
                        break;
                    }
                    c = 65535;
                    break;
                case 2131714852:
                    if (str.equals("DoubleBufferDataSeconds")) {
                        c = '%';
                        break;
                    }
                    c = 65535;
                    break;
                case 2139694009:
                    if (str.equals("VideoBufferList")) {
                        c = 22;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                    obj = Boolean.valueOf(this.isValid);
                    break;
                case 1:
                    obj = Integer.valueOf(this.mSuccess);
                    break;
                case 2:
                    obj = Integer.valueOf(this.m302);
                    break;
                case 3:
                    obj = Integer.valueOf(this.mConnectCost);
                    break;
                case 4:
                    obj = Integer.valueOf(this.mStallType);
                    break;
                case 5:
                    obj = Integer.valueOf(this.mStallTotalCount);
                    break;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    obj = Integer.valueOf(this.mRetryTotalCount);
                    break;
                case 7:
                    obj = Integer.valueOf(this.mIsPreview);
                    break;
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                    obj = Long.valueOf(this.mStartTs);
                    break;
                case '\t':
                    obj = Long.valueOf(this.mStallTime);
                    break;
                case '\n':
                    obj = Long.valueOf(this.mEndTs);
                    break;
                case 11:
                    obj = Long.valueOf(this.mDuration);
                    break;
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    obj = Long.valueOf(this.mStallTotalTime);
                    break;
                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                    obj = Long.valueOf(this.mFirstFrameAudioBuffer);
                    break;
                case 14:
                    obj = Long.valueOf(this.mFirstFrameVideoBuffer);
                    break;
                case 15:
                    obj = Long.valueOf(this.mFirstFrameDownloadSpeed);
                    break;
                case 16:
                    obj = Long.valueOf(this.mFirstFrame);
                    break;
                case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                    obj = Long.valueOf(this.mStopTimestamp);
                    break;
                case 18:
                    obj = Long.valueOf(this.mPlayTime);
                    break;
                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                    obj = Long.valueOf(this.mDownloadSpeed);
                    break;
                case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                    obj = Float.valueOf(this.mFPS);
                    break;
                case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                    obj = this.mStallSeries;
                    break;
                case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                    obj = this.mVideoBufferList;
                    break;
                case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                    obj = this.mAudioBufferList;
                    break;
                case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                    obj = this.mRenderVideoSeries;
                    break;
                case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                    obj = this.mRenderAudioSeries;
                    break;
                case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                    obj = this.mNeptuneName;
                    break;
                case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                    obj = this.mStreamSuffix;
                    break;
                case 28:
                    obj = this.mEnterAction;
                    break;
                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                    obj = this.mEnterMethod;
                    break;
                case 30:
                    obj = this.mSessionId;
                    break;
                case 31:
                    obj = this.mProtocol;
                    break;
                case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                    obj = this.mNetwork;
                    break;
                case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                    obj = this.mUpdate;
                    break;
                case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                    obj = this.mDomain;
                    break;
                case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                    obj = Long.valueOf(this.mEstimatedBandwidth);
                    break;
                case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                    obj = Integer.valueOf(this.mBufferDataSeconds);
                    break;
                case ConstantsAPI.COMMAND_OPEN_CUSTOMER_SERVICE_CHAT /* 37 */:
                    obj = Integer.valueOf(this.mDoubleBufferDataSeconds);
                    break;
                default:
                    Log.e(this.TAG, "don't have " + str + " to get");
                    return t;
            }
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return t;
        }
    }
}
