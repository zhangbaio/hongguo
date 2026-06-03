package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Looper;
import com.bytedance.apm.agent.instrumentation.HttpInstrumentation;
import com.bytedance.covode.number.Covode;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.android.ugc.bytex.taskmonitor.proxy.HandlerDelegate;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONObject;
import u55.k;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class WXAPiSecurityHelper {
    private final Context context;
    private final CopyOnWriteArraySet<String> overtimeSyncReqSet = new CopyOnWriteArraySet<>();
    private final SharedPreferences sp;

    private static class CheckRuleResult {
        static {
            Covode.recordClassIndex(653461);
        }

        private CheckRuleResult() {
        }
    }

    public static class ExtraSecurityCheckRes {
        static {
            Covode.recordClassIndex(653462);
        }
    }

    interface IHttpCheckCallback {
        void onHttpCheckFinish(PromiseShareRule promiseShareRule);
    }

    interface ISecurityCheck {
        void onCheckFinish(boolean z);
    }

    interface ISecuritySyncCheck {
        void onSyncCheckFinish(boolean z);
    }

    private static class PassContext {
        String appid;
        String inputUrl;
        PromiseShareRule localRule;
        String reqSessionId;
        String version;

        static {
            Covode.recordClassIndex(653466);
        }

        private PassContext() {
            this.reqSessionId = "";
            this.appid = "";
            this.inputUrl = "";
            this.version = "";
            this.localRule = new PromiseShareRule();
        }
    }

    private static class PromiseShareRule {
        String appidInRule;
        String buffer;
        public long nextRequestIntervalSecond;
        String orgJsonData;
        String reqAppid;
        int state;
        List<UrlRule> urlRuleList;
        long userWaitTimeMs;

        static {
            Covode.recordClassIndex(653467);
        }

        private PromiseShareRule() {
            this.orgJsonData = "";
            this.reqAppid = "";
            this.appidInRule = "";
            this.urlRuleList = new ArrayList();
            this.buffer = "";
        }

        public long getLegalReqInterval() {
            long j = this.nextRequestIntervalSecond;
            if (j <= 0 || j >= 86400) {
                j = 3600;
            }
            Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "getLegalReqInterval = " + j);
            return j;
        }

        public long getLegalUserWaitTime() {
            long j = this.userWaitTimeMs;
            if (j <= 100 || j >= 60000) {
                j = 5000;
            }
            Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "getLegalUserWaitTime = " + j);
            return j;
        }
    }

    private static class RuleState {
        static {
            Covode.recordClassIndex(653468);
        }

        private RuleState() {
        }
    }

    private static class UrlRule {
        String host;
        List<String> mustQueryKey;

        static {
            Covode.recordClassIndex(653469);
        }

        private UrlRule() {
            this.host = "";
            this.mustQueryKey = new ArrayList();
        }
    }

    private static class WXSecurityData {
        String appid;
        long lastStoreTimeStampSecond;
        String respDataJson;

        static {
            Covode.recordClassIndex(653470);
        }

        private WXSecurityData() {
            this.appid = "";
            this.respDataJson = "";
        }

        public boolean isBasicParamsAllowed() {
            long j = this.lastStoreTimeStampSecond;
            return ((j > 0L ? 1 : (j == 0L ? 0 : -1)) > 0 && (j > (System.currentTimeMillis() / 1000) ? 1 : (j == (System.currentTimeMillis() / 1000) ? 0 : -1)) < 0) && (b.b(this.appid) ^ true) && (b.b(this.respDataJson) ^ true);
        }
    }

    static {
        Covode.recordClassIndex(653460);
    }

    public WXAPiSecurityHelper(Context context) {
        this.context = context;
        this.sp = context.getSharedPreferences("__wx_opensdk_sp__", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int checkRuleCanPass(String str, PromiseShareRule promiseShareRule) {
        String str2;
        Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "checkRuleCanPass, start check!");
        if (promiseShareRule.orgJsonData.length() > 2048) {
            Log.w("MicroMsg.SDK.WXAPiSecurityHelper", "response json is too long!");
            return 0;
        }
        int i = promiseShareRule.state;
        if (i == 2) {
            str2 = "checkRuleCanPass, not in rule";
        } else {
            if (i != 1 || !promiseShareRule.appidInRule.equals(promiseShareRule.reqAppid)) {
                Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "checkRuleCanPass, unknown");
                return 0;
            }
            if (promiseShareRule.urlRuleList.size() == 0) {
                str2 = "checkRuleCanPass, urlRuleList empty!";
            } else {
                boolean checkUrlParametersLegal = checkUrlParametersLegal(str, promiseShareRule);
                Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "checkRuleCanPass, urlCheckResult = " + checkUrlParametersLegal);
                if (!checkUrlParametersLegal) {
                    Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "checkRuleCanPass, no pass");
                    return 2;
                }
                str2 = "checkRuleCanPass, pass";
            }
        }
        Log.d("MicroMsg.SDK.WXAPiSecurityHelper", str2);
        return 1;
    }

    private boolean checkUrlParametersLegal(String str, PromiseShareRule promiseShareRule) {
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (b.b(host)) {
            Log.i("MicroMsg.SDK.WXAPiSecurityHelper", "checkUrlParameters, host empty!");
            return false;
        }
        for (int i = 0; i < promiseShareRule.urlRuleList.size(); i++) {
            UrlRule urlRule = promiseShareRule.urlRuleList.get(i);
            if (host.equals(urlRule.host)) {
                int i2 = 0;
                for (int i3 = 0; i3 < urlRule.mustQueryKey.size(); i3++) {
                    try {
                        String str2 = urlRule.mustQueryKey.get(i3);
                        Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "checkRuleCanPass, key = " + str2);
                        if (!b.b(parse.getQueryParameter(str2))) {
                            i2++;
                        }
                    } catch (Exception e) {
                        Log.e("MicroMsg.SDK.WXAPiSecurityHelper", "checkRuleCanPass, parse fail, e = %s" + e.getMessage());
                    }
                }
                boolean z = i2 == urlRule.mustQueryKey.size();
                Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "checkRuleCanPass, rule.host = " + urlRule.host + ", queryOk = " + z);
                return z;
            }
        }
        return false;
    }

    private void doRequest(final PassContext passContext, final IHttpCheckCallback iHttpCheckCallback) {
        b.b.submit(new Runnable() { // from class: com.tencent.mm.opensdk.openapi.WXAPiSecurityHelper.6
            @Override // java.lang.Runnable
            public void run() {
                WXAPiSecurityHelper wXAPiSecurityHelper = WXAPiSecurityHelper.this;
                PassContext passContext2 = passContext;
                iHttpCheckCallback.onHttpCheckFinish(WXAPiSecurityHelper.this.convert2ShareRule(passContext.appid, wXAPiSecurityHelper.postHttpRequest(passContext2.appid, passContext2.version, passContext2.localRule.buffer).toString()));
            }
        });
    }

    private void doRequestAsync(PassContext passContext) {
        Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "doRequestAsync");
        doRequest(passContext, new IHttpCheckCallback() { // from class: com.tencent.mm.opensdk.openapi.WXAPiSecurityHelper.3
            @Override // com.tencent.mm.opensdk.openapi.WXAPiSecurityHelper.IHttpCheckCallback
            public void onHttpCheckFinish(PromiseShareRule promiseShareRule) {
                WXAPiSecurityHelper.this.storeIfNecessary(promiseShareRule);
            }
        });
    }

    private void doRequestSync(final PassContext passContext, final ISecuritySyncCheck iSecuritySyncCheck) {
        Log.i("MicroMsg.SDK.WXAPiSecurityHelper", "requestId = " + passContext.reqSessionId);
        final PthreadTimer pthreadTimer = new PthreadTimer(passContext.reqSessionId);
        pthreadTimer.schedule(new TimerTask() { // from class: com.tencent.mm.opensdk.openapi.WXAPiSecurityHelper.4
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Log.i("MicroMsg.SDK.WXAPiSecurityHelper", "sync request overtime, requestId = " + passContext.reqSessionId);
                WXAPiSecurityHelper.this.overtimeSyncReqSet.add(passContext.reqSessionId);
                ISecuritySyncCheck iSecuritySyncCheck2 = iSecuritySyncCheck;
                if (iSecuritySyncCheck2 != null) {
                    iSecuritySyncCheck2.onSyncCheckFinish(true);
                }
            }
        }, passContext.localRule.getLegalUserWaitTime());
        doRequest(passContext, new IHttpCheckCallback() { // from class: com.tencent.mm.opensdk.openapi.WXAPiSecurityHelper.5
            @Override // com.tencent.mm.opensdk.openapi.WXAPiSecurityHelper.IHttpCheckCallback
            public void onHttpCheckFinish(PromiseShareRule promiseShareRule) {
                pthreadTimer.cancel();
                if (WXAPiSecurityHelper.this.overtimeSyncReqSet.contains(passContext.reqSessionId)) {
                    WXAPiSecurityHelper.this.overtimeSyncReqSet.remove(passContext.reqSessionId);
                } else if (iSecuritySyncCheck != null) {
                    int checkRuleCanPass = WXAPiSecurityHelper.this.checkRuleCanPass(passContext.inputUrl, promiseShareRule);
                    if (checkRuleCanPass == 1) {
                        iSecuritySyncCheck.onSyncCheckFinish(true);
                    } else if (checkRuleCanPass == 2) {
                        iSecuritySyncCheck.onSyncCheckFinish(false);
                    } else {
                        iSecuritySyncCheck.onSyncCheckFinish(WXAPiSecurityHelper.this.checkRuleCanPass(passContext.inputUrl, WXAPiSecurityHelper.this.convert2ShareRule(passContext.appid, WXAPiSecurityHelper.this.getStoredData(passContext.appid).respDataJson)) != 2);
                    }
                }
                WXAPiSecurityHelper.this.storeIfNecessary(promiseShareRule);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void extraSecurityCheckDoCallback(final ISecurityCheck iSecurityCheck, final boolean z) {
        if (iSecurityCheck != null) {
            new HandlerDelegate(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mm.opensdk.openapi.WXAPiSecurityHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "has got result, callback on Main Thread.");
                    iSecurityCheck.onCheckFinish(z);
                }
            });
        }
    }

    private String getStoreKey(String str) {
        return "security_key_appid_" + str;
    }

    private void storeCheckResp(String str, PromiseShareRule promiseShareRule) {
        String cookStoreJson = cookStoreJson(str, promiseShareRule);
        Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "cookStoreJson = " + cookStoreJson);
        if (b.b(cookStoreJson)) {
            Log.w("MicroMsg.SDK.WXAPiSecurityHelper", "cookStoreJson get null!");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("security_key_timestamp_second", System.currentTimeMillis() / 1000);
            jSONObject.put("security_key_resp", cookStoreJson);
            commitSp(str, jSONObject.toString());
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXAPiSecurityHelper", "storeCheckResp fail, ex = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void storeIfNecessary(PromiseShareRule promiseShareRule) {
        String str;
        Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "storeIfNecessary");
        if (b.b(promiseShareRule.reqAppid) || promiseShareRule.reqAppid.length() > 100) {
            str = "store fail! reqAppid illegal!";
        } else {
            if (!b.b(promiseShareRule.orgJsonData) && promiseShareRule.orgJsonData.length() <= 2048) {
                if (promiseShareRule.state == 1 && promiseShareRule.reqAppid.equals(promiseShareRule.appidInRule)) {
                    Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "storeIfNecessary, in rule");
                    storeCheckResp(promiseShareRule.reqAppid, promiseShareRule);
                }
                if (promiseShareRule.state == 2) {
                    Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "storeIfNecessary, not rule");
                    storeCheckResp(promiseShareRule.reqAppid, promiseShareRule);
                    return;
                }
                return;
            }
            str = "store fail! response json illegal!";
        }
        Log.i("MicroMsg.SDK.WXAPiSecurityHelper", str);
    }

    protected void commitSp(String str, String str2) {
        SharedPreferences.Editor edit = this.sp.edit();
        edit.putString(getStoreKey(str), str2);
        edit.commit();
    }

    protected PromiseShareRule convert2ShareRule(String str, String str2) {
        PromiseShareRule promiseShareRule = new PromiseShareRule();
        promiseShareRule.reqAppid = str;
        promiseShareRule.orgJsonData = str2;
        if (b.b(str2)) {
            Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "convert2ShareRule: jsonRespData is empty");
            return promiseShareRule;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            promiseShareRule.state = jSONObject.optInt("state", 0);
            promiseShareRule.appidInRule = jSONObject.optString("appid_rule", "");
            promiseShareRule.userWaitTimeMs = jSONObject.optLong("wait_time", 0L);
            promiseShareRule.nextRequestIntervalSecond = jSONObject.optLong("interval", 0L);
            promiseShareRule.buffer = jSONObject.optString("buffer", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("rules");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    UrlRule urlRule = new UrlRule();
                    urlRule.host = jSONObject2.optString("host");
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("querys");
                    if (optJSONArray2 != null) {
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            if (!b.b(optJSONArray2.optString(i2, ""))) {
                                urlRule.mustQueryKey.add(optJSONArray2.optString(i2, ""));
                            }
                        }
                    }
                    promiseShareRule.urlRuleList.add(urlRule);
                }
            }
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXAPiSecurityHelper", "coverJson2ShareRule fail, ex = " + e.getMessage());
        }
        return promiseShareRule;
    }

    protected String cookStoreJson(String str, PromiseShareRule promiseShareRule) {
        String covertShareRule2Json;
        if (promiseShareRule != null && !b.b(str)) {
            try {
                int i = promiseShareRule.state;
                if (i == 2) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("state", promiseShareRule.state);
                    jSONObject.put("interval", promiseShareRule.getLegalReqInterval());
                    jSONObject.put("buffer", promiseShareRule.buffer.length() > 64 ? "" : promiseShareRule.buffer);
                    covertShareRule2Json = jSONObject.toString();
                } else {
                    if (i != 1) {
                        return "";
                    }
                    covertShareRule2Json = covertShareRule2Json(promiseShareRule);
                }
                return covertShareRule2Json;
            } catch (Exception e) {
                Log.e("MicroMsg.SDK.WXAPiSecurityHelper", "storeCheckResp fail, ex = " + e.getMessage());
            }
        }
        return "";
    }

    protected String covertShareRule2Json(PromiseShareRule promiseShareRule) {
        if (promiseShareRule == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", promiseShareRule.state);
            jSONObject.put("appid_rule", promiseShareRule.appidInRule);
            jSONObject.put("wait_time", promiseShareRule.userWaitTimeMs);
            jSONObject.put("interval", promiseShareRule.nextRequestIntervalSecond);
            jSONObject.put("buffer", promiseShareRule.buffer.length() > 64 ? "" : promiseShareRule.buffer);
            JSONArray jSONArray = new JSONArray();
            for (UrlRule urlRule : promiseShareRule.urlRuleList) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("host", urlRule.host);
                jSONObject2.put("querys", new JSONArray((Collection) urlRule.mustQueryKey));
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("rules", jSONArray);
            return jSONObject.toString();
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXAPiSecurityHelper", "covertShareRule2Json fail, ex = " + e.getMessage());
            return "";
        }
    }

    public int doExtraSecurityCheck(String str, String str2, String str3, final ISecurityCheck iSecurityCheck) {
        Log.i("MicroMsg.SDK.WXAPiSecurityHelper", "doExtraSecurityCheck: start!");
        if (b.b(str) || b.b(str3)) {
            Log.e("MicroMsg.SDK.WXAPiSecurityHelper", "doExtraSecurityCheck: appid or inputurl is empty!");
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis();
        PassContext passContext = new PassContext();
        passContext.reqSessionId = String.format("%s", currentTimeMillis + "" + new Random().nextInt(9999));
        passContext.appid = str;
        passContext.inputUrl = str3;
        passContext.version = str2;
        WXSecurityData storedData = getStoredData(str);
        if (this.context.getPackageManager().checkPermission("android.permission.INTERNET", this.context.getPackageName()) != 0) {
            Log.w("MicroMsg.SDK.WXAPiSecurityHelper", "doExtraSecurityCheck: No Internet permission!");
            return 0;
        }
        if (!storedData.isBasicParamsAllowed()) {
            Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "doExtraSecurityCheck: local data illegal!");
            doRequestAsync(passContext);
            return 0;
        }
        PromiseShareRule convert2ShareRule = convert2ShareRule(passContext.appid, storedData.respDataJson);
        passContext.localRule = convert2ShareRule;
        boolean z = (storedData.lastStoreTimeStampSecond + convert2ShareRule.getLegalReqInterval()) * 1000 < System.currentTimeMillis();
        Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "doExtraSecurityCheck: needDoNextReq: " + z + ", last req time stamp:" + storedData.lastStoreTimeStampSecond);
        if (!z) {
            int checkRuleCanPass = checkRuleCanPass(passContext.inputUrl, passContext.localRule);
            Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "doExtraSecurityCheck: no needDoNextReq, read local rule: " + checkRuleCanPass);
            return checkRuleCanPass == 2 ? 1 : 0;
        }
        Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "doExtraSecurityCheck: needDoNextReq, state: " + passContext.localRule.state);
        if (passContext.localRule.state != 1) {
            doRequestAsync(passContext);
            return 0;
        }
        doRequestSync(passContext, new ISecuritySyncCheck() { // from class: com.tencent.mm.opensdk.openapi.WXAPiSecurityHelper.1
            @Override // com.tencent.mm.opensdk.openapi.WXAPiSecurityHelper.ISecuritySyncCheck
            public void onSyncCheckFinish(boolean z2) {
                WXAPiSecurityHelper.this.extraSecurityCheckDoCallback(iSecurityCheck, z2);
            }
        });
        return 2;
    }

    public String extractMayNeedDoSecurityCheckUrl(String str, BaseReq baseReq) {
        if (baseReq.getType() != 2) {
            return "";
        }
        SendMessageToWX.Req req = (SendMessageToWX.Req) baseReq;
        if (req.message.getType() != 5) {
            return "";
        }
        WXWebpageObject wXWebpageObject = (WXWebpageObject) req.message.mediaObject;
        if (b.b(wXWebpageObject.webpageUrl)) {
            Log.i("MicroMsg.SDK.WXAPiSecurityHelper", "webpageUrl empty, don't need check.");
            return "";
        }
        Log.i("MicroMsg.SDK.WXAPiSecurityHelper", "need check.");
        return wXWebpageObject.webpageUrl;
    }

    protected String getLocalStoredJson(String str) {
        return getStoredData(str).respDataJson;
    }

    protected WXSecurityData getStoredData(String str) {
        String str2;
        WXSecurityData wXSecurityData = new WXSecurityData();
        Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "getStoredData, appid = " + str);
        try {
            if (this.sp.contains(getStoreKey(str))) {
                JSONObject jSONObject = new JSONObject(this.sp.getString(getStoreKey(str), ""));
                long optLong = jSONObject.optLong("security_key_timestamp_second");
                String optString = jSONObject.optString("security_key_resp");
                wXSecurityData.appid = str;
                wXSecurityData.lastStoreTimeStampSecond = optLong;
                wXSecurityData.respDataJson = optString;
                str2 = "getStoredData, Ok, appid = " + str + "timeStampSecond: " + wXSecurityData.lastStoreTimeStampSecond;
            } else {
                str2 = "getStoredData, fail, not exist!";
            }
            Log.d("MicroMsg.SDK.WXAPiSecurityHelper", str2);
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXAPiSecurityHelper", "getStoredData fail, ex = " + e.getMessage());
        }
        return wXSecurityData;
    }

    protected StringBuffer postHttpRequest(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            String encode2 = URLEncoder.encode(str3, "UTF-8");
            String format = String.format("https://mp.weixin.qq.com/publicpoc/opensdkconf?action=GetShareConf&appid=%s&sdkVersion=%s&buffer=%s", encode, str2, encode2);
            Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "request http, url = " + format + ", appid = " + encode + ", version = " + str2 + ", buffer = " + encode2);
            HttpURLConnection httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXAPiSecurityHelper_com_dragon_read_aop_NetworkTrafficAop_openConnection(new URL(format)));
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(60000);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            Log.i("MicroMsg.SDK.WXAPiSecurityHelper", "http respCode = " + responseCode);
            if (responseCode == 200) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                Log.d("MicroMsg.SDK.WXAPiSecurityHelper", "http response = " + ((Object) stringBuffer));
                bufferedReader.close();
            }
            httpURLConnection.disconnect();
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXAPiSecurityHelper", "http request fail, ex = " + e.getMessage());
        }
        return stringBuffer;
    }

    @Proxy("openConnection")
    @TargetClass("java.net.URL")
    @Skip({"com.bytedance.crash.upload.CrashUploader"})
    public static URLConnection INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXAPiSecurityHelper_com_dragon_read_aop_NetworkTrafficAop_openConnection(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (!k.o()) {
            return openConnection;
        }
        return u55.b.a(openConnection);
    }
}
