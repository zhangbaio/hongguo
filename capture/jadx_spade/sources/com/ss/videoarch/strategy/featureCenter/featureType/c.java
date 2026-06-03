package com.ss.videoarch.strategy.featureCenter.featureType;

import com.bytedance.covode.number.Covode;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class c extends a {
    private static volatile c c;

    static {
        Covode.recordClassIndex(653136);
        c = null;
    }

    private c() {
        this.a = "TypeNetworkFeature";
        mj6.b bVar = this.b;
        if (bVar != null) {
            bVar.a = "TypeNetworkFeature";
        }
    }

    public static c d() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public JSONObject c(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, JSONObject jSONObject2) {
        char c2;
        int i;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            String optString = jSONArray.optString(i2);
            try {
                int i3 = -1;
                switch (optString.hashCode()) {
                    case -195699446:
                        if (optString.equals("NETWORK-PacketLossRate")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 212132371:
                        if (optString.equals("NETWORK-RTT")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 894047505:
                        if (optString.equals("NETWORK-BestMtuLength")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1266276899:
                        if (optString.equals("NETWORK-Access")) {
                            c2 = 6;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1890703221:
                        if (optString.equals("NETWORK-NetworkLevel")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2087921555:
                        if (optString.equals("NETWORK-VodDownloadSpeed")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 2133555472:
                        if (optString.equals("NETWORK-RecommendBitrate")) {
                            c2 = 5;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                switch (c2) {
                    case 0:
                        if (jSONObject2 != null) {
                            i = jSONObject2.optInt("net_effective_connection_type", -1);
                        } else {
                            i = 0;
                        }
                        jSONObject.put(optString, i);
                        continue;
                    case 1:
                        if (jSONObject2 != null) {
                            i3 = jSONObject2.optInt("tcp_rtt", -1);
                        }
                        jSONObject.put(optString, i3);
                        continue;
                    case 2:
                        if (jSONObject2 != null) {
                            i3 = jSONObject2.optInt("video_download_speed", -1);
                        }
                        jSONObject.put(optString, i3);
                        continue;
                    case 3:
                    case 4:
                        jSONObject.put(optString, -1);
                        continue;
                    case 5:
                        if (jSONObject2 != null) {
                            i3 = jSONObject2.optInt("recommend_bitrate", -1);
                        }
                        jSONObject.put(optString, i3);
                        continue;
                    case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                        jSONObject.put(optString, com.ss.videoarch.strategy.network.d.e().c());
                        continue;
                    default:
                        continue;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            e.printStackTrace();
        }
        return jSONObject;
    }
}
