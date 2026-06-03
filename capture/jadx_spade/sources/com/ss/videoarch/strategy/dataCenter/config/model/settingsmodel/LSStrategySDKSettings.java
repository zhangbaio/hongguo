package com.ss.videoarch.strategy.dataCenter.config.model.settingsmodel;

import android.util.Log;
import com.bytedance.covode.number.Covode;
import com.ss.videoarch.strategy.strategy.networkStrategy.SettingsManager;
import lj6.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class LSStrategySDKSettings {
    public final int DEFAULT_TIME_OUT;
    public int mBasePostRequestInterval;
    public int mCheckIPValid;
    public int mDataBundleCount;
    public long mDelayTimeForFirstDns;
    public long mDeviceFeatureEffectiveTime;
    public int mDisableResetSDKInfo;
    public int mDomainTTL;
    public int mEnableBandWidthAvg;
    public int mEnableCheckHttpDnsAndLocalIntersection;
    public int mEnableCollectTime;
    public int mEnableDefaultReturnIPv4;
    public int mEnableDeviceFeatureData;
    public int mEnableDnsOptimizer;
    public int mEnableDomainType;
    public int mEnableHttpDns;
    public int mEnableIPV6Probe;
    public int mEnableIPv6ProbeLoop;
    public int mEnableInitPtyByStrategy;
    public int mEnableIpRace;
    public int mEnableListenerThread;
    public int mEnableNativeStrategyCenter;
    public int mEnableNetConnectionTypeStrategy;
    public int mEnableNodePersistence;
    public int mEnablePreferParsingPullNode;
    public int mEnablePreferParsingPushNode;
    public int mEnableRefresh;
    public int mEnableRegisterPtyFeatureCenter;
    public int mEnableRtmProbe;
    public int mEnableSetConfigToLiveIO;
    public int mEnableSetSDKParams;
    public int mEnableSimulateLocalDNSFail;
    public int mEnableStartPlayBuffer;
    public int mEnableStaticConfigDecision;
    public int mEnableStaticConfigDecison;
    public int mEnableSuggestQuic;
    public int mEnableSupportIpOnlyMode;
    public int mEnableTransParams;
    public int mEnableUpdateCharToLiveIO;
    public int mEnableUploadStrategyMonitorLog;
    public int mEnableUseIpv6;
    public int mEnableUseNewOptRecordStruct;
    public int mEnableUsePTY;
    public int mFirstDnsDelay;
    public int mForbidUseIpv6InWWAN;
    public int mForbidUseIpv6InWiFi;
    public int mHotDomainTTL;
    public long mLocalDnsTimeOut;
    public int mNodeHttpDnsRequestInterval;
    public int mNodeLocalDnsRequestInterval;
    public int mPerfOptAsync;
    public int mPerfOptIpValid;
    public int mPerfOptNotExeFunc;
    public JSONObject mPitayaABSettingsJSON;
    public String mPitayaABSettingsParams;
    public int mPreferParsingPullNodeByPushDaysIn7Days;
    public int mPreferParsingPushNodeByPushDaysIn7Days;
    public int mRecommendSettingsRequestInterval;
    public int mRequiredHttpIpCount;
    public int mRequiredIpv4IpCount;
    public int mRequiredIpv6IpCount;
    public int mRequiredLocalIpCount;
    public double mRunPtyPackageWaitTime;
    public int mSendHttpDnsByLocalDnsTimeout;
    public long mSimulateLocalDNSTimeout;
    public String mTransParamsDefaultBandWidth;
    public String mUDPProbeHostName;
    public JSONArray mUDPProbeInfos;
    public int mUDPProbeInterval;
    public int mUDPProbePackageSize;
    public int mUDPProbePort;
    public int mUDPProbeResultVaildTime;
    public int mUpdateCharToLiveIOTimer;
    public int mUseH2QByDefault;

    static {
        Covode.recordClassIndex(653121);
    }

    public LSStrategySDKSettings() {
        this.DEFAULT_TIME_OUT = 5000;
        this.mUDPProbePort = 8000;
        this.mDomainTTL = 300000;
        this.mEnableCollectTime = -1;
        this.mEnableDeviceFeatureData = -1;
        this.mDeviceFeatureEffectiveTime = 300000L;
        this.mEnableBandWidthAvg = -1;
        this.mDelayTimeForFirstDns = 10000L;
        this.mRecommendSettingsRequestInterval = 1;
        this.mNodeLocalDnsRequestInterval = 1;
        this.mNodeHttpDnsRequestInterval = 1;
        this.mEnableRtmProbe = -1;
        this.mEnableSimulateLocalDNSFail = -1;
        this.mSimulateLocalDNSTimeout = 5000L;
        this.mEnableDomainType = 2;
        this.mLocalDnsTimeOut = 5000L;
        this.mEnableStaticConfigDecision = -1;
        this.mEnableStartPlayBuffer = 1;
        this.mEnableNetConnectionTypeStrategy = 1;
        this.mTransParamsDefaultBandWidth = "";
        this.mEnableUploadStrategyMonitorLog = 0;
        this.mUDPProbeHostName = "";
        this.mEnableUpdateCharToLiveIO = -1;
        this.mUpdateCharToLiveIOTimer = -1;
        this.mDataBundleCount = 10;
        this.mEnableHttpDns = -1;
        this.mEnableDefaultReturnIPv4 = 0;
        this.mEnableCheckHttpDnsAndLocalIntersection = 0;
        this.mEnableUseIpv6 = -1;
        this.mEnableIPV6Probe = 0;
        this.mEnableIPv6ProbeLoop = 0;
        this.mEnableSupportIpOnlyMode = 0;
        this.mForbidUseIpv6InWiFi = -1;
        this.mForbidUseIpv6InWWAN = -1;
        this.mEnableDnsOptimizer = -1;
        this.mSendHttpDnsByLocalDnsTimeout = -1;
        this.mRequiredIpv6IpCount = -1;
        this.mRequiredIpv4IpCount = -1;
        this.mRequiredHttpIpCount = -1;
        this.mRequiredLocalIpCount = -1;
        this.mEnableStaticConfigDecison = -1;
        this.mEnableListenerThread = 1;
        this.mEnableRefresh = 1;
        this.mEnableTransParams = -1;
        this.mEnableUsePTY = -1;
        this.mEnableInitPtyByStrategy = -1;
        this.mEnableNodePersistence = -1;
        this.mEnableRegisterPtyFeatureCenter = -1;
        this.mPitayaABSettingsParams = "";
        this.mPitayaABSettingsJSON = null;
        this.mRunPtyPackageWaitTime = -1.0d;
        this.mUDPProbeInterval = 30;
        this.mUDPProbePackageSize = 1400;
        this.mUDPProbeResultVaildTime = 5;
        this.mUDPProbeInfos = null;
        this.mEnableUseNewOptRecordStruct = -1;
        this.mBasePostRequestInterval = 300;
        this.mEnablePreferParsingPushNode = -1;
        this.mEnablePreferParsingPullNode = -1;
        this.mPreferParsingPushNodeByPushDaysIn7Days = 8;
        this.mPreferParsingPullNodeByPushDaysIn7Days = -1;
        this.mEnableNativeStrategyCenter = -1;
        this.mEnableSetConfigToLiveIO = -1;
        this.mEnableIpRace = -1;
        this.mEnableSetSDKParams = -1;
        this.mUseH2QByDefault = -1;
        this.mEnableSuggestQuic = 0;
        this.mHotDomainTTL = 60;
        this.mDisableResetSDKInfo = 0;
        this.mPerfOptIpValid = 0;
        this.mPerfOptNotExeFunc = 0;
        this.mPerfOptAsync = 0;
        this.mFirstDnsDelay = 0;
        this.mCheckIPValid = 0;
    }

    public LSStrategySDKSettings(JSONObject jSONObject) {
        JSONObject optJSONObject;
        this.DEFAULT_TIME_OUT = 5000;
        this.mUDPProbePort = 8000;
        this.mDomainTTL = 300000;
        this.mEnableCollectTime = -1;
        this.mEnableDeviceFeatureData = -1;
        this.mDeviceFeatureEffectiveTime = 300000L;
        this.mEnableBandWidthAvg = -1;
        this.mDelayTimeForFirstDns = 10000L;
        this.mRecommendSettingsRequestInterval = 1;
        this.mNodeLocalDnsRequestInterval = 1;
        this.mNodeHttpDnsRequestInterval = 1;
        this.mEnableRtmProbe = -1;
        this.mEnableSimulateLocalDNSFail = -1;
        this.mSimulateLocalDNSTimeout = 5000L;
        this.mEnableDomainType = 2;
        this.mLocalDnsTimeOut = 5000L;
        this.mEnableStaticConfigDecision = -1;
        this.mEnableStartPlayBuffer = 1;
        this.mEnableNetConnectionTypeStrategy = 1;
        this.mTransParamsDefaultBandWidth = "";
        this.mEnableUploadStrategyMonitorLog = 0;
        this.mUDPProbeHostName = "";
        this.mEnableUpdateCharToLiveIO = -1;
        this.mUpdateCharToLiveIOTimer = -1;
        this.mDataBundleCount = 10;
        this.mEnableHttpDns = -1;
        this.mEnableDefaultReturnIPv4 = 0;
        this.mEnableCheckHttpDnsAndLocalIntersection = 0;
        this.mEnableUseIpv6 = -1;
        this.mEnableIPV6Probe = 0;
        this.mEnableIPv6ProbeLoop = 0;
        this.mEnableSupportIpOnlyMode = 0;
        this.mForbidUseIpv6InWiFi = -1;
        this.mForbidUseIpv6InWWAN = -1;
        this.mEnableDnsOptimizer = -1;
        this.mSendHttpDnsByLocalDnsTimeout = -1;
        this.mRequiredIpv6IpCount = -1;
        this.mRequiredIpv4IpCount = -1;
        this.mRequiredHttpIpCount = -1;
        this.mRequiredLocalIpCount = -1;
        this.mEnableStaticConfigDecison = -1;
        this.mEnableListenerThread = 1;
        this.mEnableRefresh = 1;
        this.mEnableTransParams = -1;
        this.mEnableUsePTY = -1;
        this.mEnableInitPtyByStrategy = -1;
        this.mEnableNodePersistence = -1;
        this.mEnableRegisterPtyFeatureCenter = -1;
        this.mPitayaABSettingsParams = "";
        this.mPitayaABSettingsJSON = null;
        this.mRunPtyPackageWaitTime = -1.0d;
        this.mUDPProbeInterval = 30;
        this.mUDPProbePackageSize = 1400;
        this.mUDPProbeResultVaildTime = 5;
        this.mUDPProbeInfos = null;
        this.mEnableUseNewOptRecordStruct = -1;
        this.mBasePostRequestInterval = 300;
        this.mEnablePreferParsingPushNode = -1;
        this.mEnablePreferParsingPullNode = -1;
        this.mPreferParsingPushNodeByPushDaysIn7Days = 8;
        this.mPreferParsingPullNodeByPushDaysIn7Days = -1;
        this.mEnableNativeStrategyCenter = -1;
        this.mEnableSetConfigToLiveIO = -1;
        this.mEnableIpRace = -1;
        this.mEnableSetSDKParams = -1;
        this.mUseH2QByDefault = -1;
        this.mEnableSuggestQuic = 0;
        this.mHotDomainTTL = 60;
        this.mDisableResetSDKInfo = 0;
        this.mPerfOptIpValid = 0;
        this.mPerfOptNotExeFunc = 0;
        this.mPerfOptAsync = 0;
        this.mFirstDnsDelay = 0;
        this.mCheckIPValid = 0;
        if (jSONObject == null) {
            return;
        }
        SettingsManager.getInstance().getStrategySDKSettings(a.m().p.toString(), this);
        a.m().F = this.mBasePostRequestInterval;
        Log.d("SettingsManager", "pitayaABSettingsParams:" + this.mPitayaABSettingsParams);
        if (a.m().r.b.has("PitayaABSettingsParams") && (optJSONObject = a.m().r.b.optJSONObject("PitayaABSettingsParams")) != null && optJSONObject.has("pitaya_ab_settings")) {
            this.mPitayaABSettingsJSON = optJSONObject.optJSONObject("pitaya_ab_settings");
        }
        if (a.m().r.b.has("UdpProbeConfig")) {
            this.mUDPProbeInfos = a.m().r.b.optJSONArray("UdpProbeConfig");
        }
    }

    public <T> T getValue(String str, T t) {
        if (t != null && a.m().r.b.has(str)) {
            if (t.getClass() == Integer.class) {
                return (T) Integer.valueOf(a.m().r.b.optInt(str));
            }
            if (t.getClass() == Long.class) {
                return (T) Long.valueOf(a.m().r.b.optLong(str));
            }
            if (t.getClass() == String.class) {
                return (T) a.m().r.b.optString(str);
            }
            if (t.getClass() == JSONObject.class) {
                return (T) a.m().r.b.optJSONObject(str);
            }
            if (t.getClass() == Double.class) {
                return (T) Double.valueOf(a.m().r.b.optDouble(str));
            }
            return t;
        }
        return t;
    }
}
