package com.ss.ttvideoengine;

import android.text.TextUtils;
import com.bytedance.covode.number.Covode;
import com.bytedance.vcloud.networkpredictor.SpeedPredictorResultCollection;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class TTTestSpeedListener implements TestSpeedListener {
    private WeakReference<TTVideoEngine> engineWeakReference;
    private ss1.b mAbrPredictor;
    private ss1.b mPredictor;
    public float mAverageDownloadSpeed = 0.0f;
    public float mAveragePredictSpeed = 0.0f;
    public int mSpeedAverageCount = 0;
    private long lastSampleTimestamp = 0;

    static {
        Covode.recordClassIndex(652328);
    }

    private Map<String, Integer> _getCurrentPlaybackStreamId() {
        IVideoModel iVideoModel;
        List<VideoInfo> videoInfoList;
        TTVideoEngine tTVideoEngine = this.engineWeakReference.get();
        if (tTVideoEngine == null || (iVideoModel = tTVideoEngine.getIVideoModel()) == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (iVideoModel.hasData() && (videoInfoList = iVideoModel.getVideoInfoList()) != null && videoInfoList.size() > 0) {
            for (VideoInfo videoInfo : videoInfoList) {
                hashMap.put(videoInfo.getValueStr(15), Integer.valueOf(videoInfo.getMediatype()));
            }
        }
        return hashMap;
    }

    private String _getProtocolFromJson(String str) {
        if (str != null && str.length() > 0) {
            try {
                return new JSONObject(str).optString("protocol");
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
        return "unknown";
    }

    private long _getTcpInfoRtt(String str) {
        if (str != null && str.length() > 0) {
            try {
                try {
                    return Long.parseLong(new JSONObject(str).optJSONObject("tcpInfo").optString("tcpRtt"));
                } catch (NumberFormatException unused) {
                    return 0L;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return -1L;
    }

    private void _streamInfoMapAppendOtherInfo(Map<String, Integer> map) {
        TTVideoEngine tTVideoEngine = this.engineWeakReference.get();
        if (tTVideoEngine != null && map != null) {
            long longOption = tTVideoEngine.getLongOption(62);
            long longOption2 = tTVideoEngine.getLongOption(61);
            int intOption = tTVideoEngine.getIntOption(0) * 1000;
            int intOption2 = tTVideoEngine.getIntOption(0) * 1000;
            map.put("playerVideoBufLen", Integer.valueOf((int) longOption));
            map.put("playerAudioBufLen", Integer.valueOf((int) longOption2));
            map.put("playerVideoMaxBufLen", Integer.valueOf(intOption));
            map.put("playerAudioMaxBufLen", Integer.valueOf(intOption2));
        }
    }

    private long _getIntInfoFromtcpInfoJson(String str, String str2) {
        if (str != null && str.length() > 0) {
            try {
                try {
                    return Long.parseLong(new JSONObject(str).optJSONObject("tcpInfo").optString(str2));
                } catch (NumberFormatException unused) {
                    return 0L;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return 0L;
            }
        }
        return -1L;
    }

    @Override // com.ss.ttvideoengine.TestSpeedListener
    public void onNotify(int i, String str) {
        long j;
        ArrayList arrayList;
        int i2;
        int i3;
        Locale locale = Locale.US;
        TTVideoEngineLog.d("TTVideoEngine", String.format(locale, "speed notify, what:%d, info:%s", Integer.valueOf(i), str));
        TTVideoEngine tTVideoEngine = this.engineWeakReference.get();
        if (tTVideoEngine == null) {
            return;
        }
        if (i == 2) {
            tTVideoEngine.getLogger().updateMultiNetworkSpeed(str);
        }
        ss1.b bVar = this.mAbrPredictor;
        if (bVar != null && TTVideoEngine.getSpeedPredictorInputType() == 2 && i == 2) {
            Map<String, Integer> _getCurrentPlaybackStreamId = _getCurrentPlaybackStreamId();
            _streamInfoMapAppendOtherInfo(_getCurrentPlaybackStreamId);
            bVar.update(str, _getCurrentPlaybackStreamId);
            if (str != null) {
                TTVideoEngineLog.d("TTVideoEngine", String.format(locale, "[ABR]: speedRecordsJson:%s", str));
            }
            this.mSpeedAverageCount++;
            Map<String, String> f = bVar.f(0);
            float d = bVar.d(0);
            Map<String, String> f2 = bVar.f(1);
            float d2 = bVar.d(1);
            StringBuffer stringBuffer = new StringBuffer(" ");
            StringBuffer stringBuffer2 = new StringBuffer(" ");
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            float _getDownSpeed = _getDownSpeed(f, stringBuffer, hashMap);
            float _getDownSpeed2 = _getDownSpeed(f2, stringBuffer2, hashMap2);
            if (_getDownSpeed > 0.0f && (i3 = this.mSpeedAverageCount) > 0) {
                float f3 = this.mAverageDownloadSpeed;
                this.mAverageDownloadSpeed = f3 + ((_getDownSpeed - f3) / i3);
            }
            if (d > 0.0f && (i2 = this.mSpeedAverageCount) > 0) {
                float f4 = this.mAveragePredictSpeed;
                this.mAveragePredictSpeed = f4 + ((d - f4) / i2);
            }
            SpeedPredictorResultCollection e = bVar.e();
            SpeedPredictorResultCollection i4 = bVar.i();
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.lastSampleTimestamp;
            long j3 = currentTimeMillis - j2;
            if (j2 == 0) {
                j = 0;
            } else {
                j = j3;
            }
            this.lastSampleTimestamp = currentTimeMillis;
            if (tTVideoEngine.getIntOption(525) == 0) {
                TTVideoEngineLog.d("TTVideoEngine", String.format(locale, "[SPEEDPREDICT] use sing predictor data outing", new Object[0]));
                tTVideoEngine.getLogger().updateNetworkSpeedPredictorSampleValue(stringBuffer.toString(), stringBuffer2.toString(), _getDownSpeed, _getDownSpeed2, d, d2, j, hashMap, hashMap2);
                tTVideoEngine.getLogger().setIsMultiDimensionsOut(0);
            } else {
                long j4 = j;
                if (tTVideoEngine.getIntOption(525) == 1) {
                    TTVideoEngineLog.d("TTVideoEngine", String.format(locale, "[SPEEDPREDICT] use multi data outing", new Object[0]));
                    if (i4 != null && (arrayList = i4.a) != null && !arrayList.isEmpty()) {
                        tTVideoEngine.getLogger().updateNetworkSpeedPredictorSampleMutiValue(e, i4, j4);
                    }
                    tTVideoEngine.getLogger().setIsMultiDimensionsOut(1);
                }
            }
            tTVideoEngine.getLogger().setIsMultiDimensionsInput(2);
        }
    }

    TTTestSpeedListener(TTVideoEngine tTVideoEngine, ss1.b bVar, ss1.b bVar2) {
        this.engineWeakReference = new WeakReference<>(tTVideoEngine);
        this.mPredictor = bVar;
        this.mAbrPredictor = bVar2;
    }

    @Override // com.ss.ttvideoengine.TestSpeedListener
    public void onNotifyGlobalSpeed(long j, long j2, int i) {
        TTVideoEngine tTVideoEngine = this.engineWeakReference.get();
        if (tTVideoEngine != null) {
            tTVideoEngine.getLogger().updateGlobalNetworkSpeed(j, j2, i);
        }
    }

    private float _getDownSpeed(Map<String, String> map, StringBuffer stringBuffer, Map<String, String> map2) {
        float f;
        if (map != null && map.size() > 1 && map.get("download_speed") != null) {
            try {
                f = Float.parseFloat(map.get("download_speed"));
            } catch (NumberFormatException e) {
                TTVideoEngineLog.e("TTVideoEngine", String.format(Locale.US, "[SPEEDPREDICT] exception %s", e.toString()));
                f = 0.0f;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !key.equals("stream_id") && !key.equals("download_speed")) {
                    map2.put(entry.getKey(), entry.getValue());
                }
            }
            String str = map.get("stream_id");
            if (str != null && !str.equals("-1")) {
                stringBuffer.delete(0, stringBuffer.capacity()).append(map.get("stream_id"));
                return f;
            }
        }
        return 0.0f;
    }

    @Override // com.ss.ttvideoengine.TestSpeedListener
    public void onNotify(int i, long j, long j2, String str, String str2, String str3) {
        int i2;
        int i3;
        int i4;
        Locale locale = Locale.US;
        TTVideoEngineLog.d("TTVideoEngine", String.format(locale, "speed notify, what:%d, code:%d, para:%d, inf:%s, extraInfoJsonStr:%s", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), str, str3));
        TTVideoEngine tTVideoEngine = this.engineWeakReference.get();
        if (tTVideoEngine == null) {
            return;
        }
        if (i == 2) {
            tTVideoEngine.getLogger().updateGlobalNetworkSpeed(j, j2, -1);
        }
        ss1.b bVar = this.mAbrPredictor;
        if (bVar != null && i == 2) {
            ss1.n nVar = new ss1.n();
            nVar.a = str;
            nVar.c = j;
            nVar.d = j2;
            long _getTcpInfoRtt = _getTcpInfoRtt(str3);
            long _getIntInfoFromtcpInfoJson = _getIntInfoFromtcpInfoJson(str3, "tcpLastRecvDate");
            nVar.f = _getTcpInfoRtt;
            nVar.g = _getIntInfoFromtcpInfoJson;
            nVar.h = _getProtocolFromJson(str3);
            if (!TextUtils.isEmpty(str2) && str2.equals("audio")) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            nVar.b = i2 ^ 1;
            nVar.e = System.currentTimeMillis();
            if (nVar.b() != 0) {
                TTVideoEngineLog.d("TTVideoEngine", String.format(locale, "[ABR]: speedRecord:%s", new DecimalFormat("#.000000000").format(nVar.a() / nVar.b())));
            }
            Map<String, Integer> _getCurrentPlaybackStreamId = _getCurrentPlaybackStreamId();
            _streamInfoMapAppendOtherInfo(_getCurrentPlaybackStreamId);
            bVar.update(nVar, _getCurrentPlaybackStreamId);
            this.mSpeedAverageCount++;
            Map<String, String> f = bVar.f(0);
            float d = bVar.d(0);
            Map<String, String> f2 = bVar.f(1);
            float d2 = bVar.d(1);
            StringBuffer stringBuffer = new StringBuffer(" ");
            StringBuffer stringBuffer2 = new StringBuffer(" ");
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            float _getDownSpeed = _getDownSpeed(f, stringBuffer, hashMap);
            float _getDownSpeed2 = _getDownSpeed(f2, stringBuffer2, hashMap2);
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.lastSampleTimestamp;
            long j4 = currentTimeMillis - j3;
            long j5 = 0;
            if (j3 != 0) {
                j5 = j4;
            }
            this.lastSampleTimestamp = currentTimeMillis;
            if (_getDownSpeed > 0.0f && (i4 = this.mSpeedAverageCount) > 0) {
                float f3 = this.mAverageDownloadSpeed;
                this.mAverageDownloadSpeed = f3 + ((_getDownSpeed - f3) / i4);
            }
            if (d > 0.0f && (i3 = this.mSpeedAverageCount) > 0) {
                float f4 = this.mAveragePredictSpeed;
                this.mAveragePredictSpeed = f4 + ((d - f4) / i3);
            }
            tTVideoEngine.getLogger().updateNetworkSpeedPredictorSampleValue(stringBuffer.toString(), stringBuffer2.toString(), _getDownSpeed, _getDownSpeed2, d, d2, j5, hashMap, hashMap2);
            tTVideoEngine.getLogger().setIsMultiDimensionsInput(1);
            tTVideoEngine.getLogger().setIsMultiDimensionsOut(0);
        }
    }
}
