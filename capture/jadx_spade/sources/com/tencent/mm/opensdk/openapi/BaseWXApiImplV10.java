package com.tencent.mm.opensdk.openapi;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.bytedance.covode.number.Covode;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom;
import com.tencent.mm.opensdk.modelbiz.HandleScanResult;
import com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.opensdk.modelbiz.OpenWebview;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage;
import com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg;
import com.tencent.mm.opensdk.modelbiz.WXChannelBaseJumpInfo;
import com.tencent.mm.opensdk.modelbiz.WXChannelJumpMiniProgramInfo;
import com.tencent.mm.opensdk.modelbiz.WXChannelJumpUrlInfo;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenEvent;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenFeed;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenLive;
import com.tencent.mm.opensdk.modelbiz.WXChannelOpenProfile;
import com.tencent.mm.opensdk.modelbiz.WXChannelShareVideo;
import com.tencent.mm.opensdk.modelbiz.WXChannelStartLive;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken;
import com.tencent.mm.opensdk.modelbiz.WXLaunchWxaRedirectingPage;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview;
import com.tencent.mm.opensdk.modelbiz.WXOpenCustomerServiceChat;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgramEnvironment;
import com.tencent.mm.opensdk.modelbiz.WXQRCodePay;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.SendTdiAuth;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay;
import com.tencent.mm.opensdk.openapi.WXAPiSecurityHelper;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class BaseWXApiImplV10 implements IWXAPI {
    private static String wxappPayEntryClassname;
    protected String appId;
    protected boolean checkSignature;
    protected Context context;
    protected boolean detached = false;
    private int launchMode;
    private WXAPiSecurityHelper securityHelper;
    private int wxSdkVersion;

    static {
        Covode.recordClassIndex(653453);
    }

    BaseWXApiImplV10(Context context, String str, boolean z, int i) {
        this.checkSignature = false;
        this.launchMode = 2;
        Log.d("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + str + ", checkSignature = " + z + ", launchMode = " + i);
        this.context = context;
        this.appId = str;
        this.checkSignature = z;
        this.launchMode = i;
        b.a = context.getApplicationContext();
        this.securityHelper = new WXAPiSecurityHelper(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackReq(SendReqCallback sendReqCallback, boolean z) {
        if (sendReqCallback != null) {
            sendReqCallback.onSendFinish(z);
        }
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        String str;
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            str = "checkSumConsistent fail, invalid arguments";
        } else {
            if (bArr.length == bArr2.length) {
                for (int i = 0; i < bArr.length; i++) {
                    if (bArr[i] != bArr2[i]) {
                        return false;
                    }
                }
                return true;
            }
            str = "checkSumConsistent fail, length is different";
        }
        Log.e("MicroMsg.SDK.WXApiImplV10", str);
        return false;
    }

    private static Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Result preInvoke = new HeliosApiHook().preInvoke(240004, "android/content/ContentResolver", "query", contentResolver, new Object[]{uri, strArr, str, strArr2, str2}, "android.database.Cursor", new ExtraInfo(false, "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;"));
        return preInvoke.isIntercept() ? (Cursor) preInvoke.getReturnValue() : contentResolver.query(uri, strArr, str, strArr2, str2);
    }

    private boolean createChatroom(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_create_chatroom_group_id", ""), bundle.getString("_wxapi_create_chatroom_chatroom_name", ""), bundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_create_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doLaunchApp(Bundle bundle) {
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.bundle = bundle;
        args.content = "weixin://sendreq?appid=" + this.appId;
        args.targetPkgName = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
        args.targetClassName = ConstantsAPI.WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
        args.launchMode = this.launchMode;
        try {
            String tokenFromWX = getTokenFromWX(this.context);
            if (tokenFromWX != null) {
                args.token = tokenFromWX;
            }
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "getTokenFromWX fail, exception = " + e);
        }
        return MMessageActV2.send(this.context, args);
    }

    private String finderShareVideoJumpInfoToString(IWXChannelJumpInfo iWXChannelJumpInfo) {
        String str;
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jumpType", iWXChannelJumpInfo.type());
            if (iWXChannelJumpInfo instanceof WXChannelBaseJumpInfo) {
                jSONObject.put("wording", ((WXChannelBaseJumpInfo) iWXChannelJumpInfo).wording);
                jSONObject.put("extra", ((WXChannelBaseJumpInfo) iWXChannelJumpInfo).extra);
                if (iWXChannelJumpInfo instanceof WXChannelJumpMiniProgramInfo) {
                    jSONObject.put("username", ((WXChannelJumpMiniProgramInfo) iWXChannelJumpInfo).username);
                    str = ((WXChannelJumpMiniProgramInfo) iWXChannelJumpInfo).path;
                    str2 = "path";
                } else if (iWXChannelJumpInfo instanceof WXChannelJumpUrlInfo) {
                    str = ((WXChannelJumpUrlInfo) iWXChannelJumpInfo).url;
                    str2 = "url";
                }
                jSONObject.put(str2, str);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private String getTokenFromWX(Context context) {
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new String[]{this.appId, "638063616"}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query == null || !com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.moveToFirst()) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "getTokenFromWX , token is null , if your app targetSdkVersion >= 30, include 'com.tencent.mm' in a set of <package> elements inside the <queries> element");
            return null;
        }
        String string = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.getString(0);
        Log.i("MicroMsg.SDK.WXApiImplV10", "getTokenFromWX token is " + string);
        com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        return string;
    }

    private boolean handleWxInternalRespType(String str, IWXAPIEventHandler iWXAPIEventHandler) {
        Uri parse;
        String queryParameter;
        Log.i("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType, extInfo = " + str);
        try {
            parse = Uri.parse(str);
            queryParameter = parse.getQueryParameter("wx_internal_resptype");
            Log.i("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType, respType = " + queryParameter);
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, ex = " + e.getMessage());
        }
        if (b.b(queryParameter)) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "handleWxInternalRespType fail, respType is null");
            return false;
        }
        if (queryParameter.equals("subscribemessage")) {
            SubscribeMessage.Resp resp = new SubscribeMessage.Resp();
            String queryParameter2 = parse.getQueryParameter("ret");
            if (queryParameter2 != null && queryParameter2.length() > 0) {
                resp.errCode = b.a(queryParameter2, 0);
            }
            resp.openId = parse.getQueryParameter("openid");
            resp.templateID = parse.getQueryParameter("template_id");
            resp.scene = b.a(parse.getQueryParameter("scene"), 0);
            resp.action = parse.getQueryParameter("action");
            resp.reserved = parse.getQueryParameter("reserved");
            iWXAPIEventHandler.onResp(resp);
            return true;
        }
        if (queryParameter.contains("invoice_auth_insert")) {
            WXInvoiceAuthInsert.Resp resp2 = new WXInvoiceAuthInsert.Resp();
            String queryParameter3 = parse.getQueryParameter("ret");
            if (queryParameter3 != null && queryParameter3.length() > 0) {
                resp2.errCode = b.a(queryParameter3, 0);
            }
            resp2.wxOrderId = parse.getQueryParameter("wx_order_id");
            iWXAPIEventHandler.onResp(resp2);
            return true;
        }
        if (queryParameter.contains("payinsurance")) {
            WXPayInsurance.Resp resp3 = new WXPayInsurance.Resp();
            String queryParameter4 = parse.getQueryParameter("ret");
            if (queryParameter4 != null && queryParameter4.length() > 0) {
                resp3.errCode = b.a(queryParameter4, 0);
            }
            resp3.wxOrderId = parse.getQueryParameter("wx_order_id");
            iWXAPIEventHandler.onResp(resp3);
            return true;
        }
        if (queryParameter.contains("nontaxpay")) {
            WXNontaxPay.Resp resp4 = new WXNontaxPay.Resp();
            String queryParameter5 = parse.getQueryParameter("ret");
            if (queryParameter5 != null && queryParameter5.length() > 0) {
                resp4.errCode = b.a(queryParameter5, 0);
            }
            resp4.wxOrderId = parse.getQueryParameter("wx_order_id");
            iWXAPIEventHandler.onResp(resp4);
            return true;
        }
        if (!"subscribeminiprogrammsg".equals(queryParameter) && !"5".equals(queryParameter)) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "this open sdk version not support the request type");
            return false;
        }
        SubscribeMiniProgramMsg.Resp resp5 = new SubscribeMiniProgramMsg.Resp();
        String queryParameter6 = parse.getQueryParameter("ret");
        if (queryParameter6 != null && queryParameter6.length() > 0) {
            resp5.errCode = b.a(queryParameter6, 0);
        }
        resp5.openId = parse.getQueryParameter("openid");
        resp5.unionId = parse.getQueryParameter("unionid");
        resp5.nickname = parse.getQueryParameter("nickname");
        resp5.errStr = parse.getQueryParameter("errmsg");
        iWXAPIEventHandler.onResp(resp5);
        return true;
    }

    private boolean joinChatroom(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_join_chatroom_group_id", ""), bundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_join_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private void launchWXIfNeed() {
        if (Build.VERSION.SDK_INT < 29 || this.launchMode != 2) {
            openWXApp();
        } else {
            launchWXUsingPendingIntent();
        }
    }

    private void launchWXUsingPendingIntent() {
        if (this.detached) {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        }
        if (!isWXAppInstalled()) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "openWXApp failed, not installed or signature check failed");
            return;
        }
        try {
            Log.i("MicroMsg.SDK.WXApiImplV10", "launchWXUsingPendingIntent");
            INVOKESTATIC_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_aop_target31_PendingIntentAop_getActivity(this.context, 1, INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage(this.context.getPackageManager(), ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME), 134217728).send(this.context, 2, null, new PendingIntent.OnFinished() { // from class: com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.3
                @Override // android.app.PendingIntent.OnFinished
                public void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
                    Log.d("MicroMsg.SDK.WXApiImplV10", "onSendFinished resultCode: " + i + ", resultData: " + str);
                }
            }, null);
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "launchWXUsingPendingIntent pendingIntent send failed: " + e.getMessage());
            openWXApp();
        }
    }

    private boolean sendAddCardToWX(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendChooseCardFromWX(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[]{bundle.getString("_wxapi_choose_card_from_wx_card_app_id"), bundle.getString("_wxapi_choose_card_from_wx_card_location_id"), bundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), bundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), bundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), bundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), bundle.getString("_wxapi_choose_card_from_wx_card_card_id"), bundle.getString("_wxapi_choose_card_from_wx_card_card_type"), bundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendFinderOpenEvent(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Log.i("MicroMsg.SDK.WXApiImplV10", "sendFinderOpenEvent");
        WXChannelOpenEvent.Req req = (WXChannelOpenEvent.Req) baseReq;
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenEvent"), null, null, new String[]{this.appId, req.username, req.eventId, req.extInfo}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendFinderOpenFeed(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Log.i("MicroMsg.SDK.WXApiImplV10", "sendFinderOpenFeed");
        WXChannelOpenFeed.Req req = (WXChannelOpenFeed.Req) baseReq;
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenFeed"), null, null, new String[]{this.appId, req.feedID, req.nonceID, String.valueOf(req.notGetReleatedList)}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendFinderOpenLive(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Log.i("MicroMsg.SDK.WXApiImplV10", "sendFinderOpenLive");
        WXChannelOpenLive.Req req = (WXChannelOpenLive.Req) baseReq;
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenLive"), null, null, new String[]{this.appId, req.feedID, req.nonceID}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendFinderOpenProfile(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Log.i("MicroMsg.SDK.WXApiImplV10", "sendFinderOpenProfile");
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderOpenProfile"), null, null, new String[]{this.appId, ((WXChannelOpenProfile.Req) baseReq).userName}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendFinderShareVideo(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Log.i("MicroMsg.SDK.WXApiImplV10", "sendFinderShareVideo");
        WXChannelShareVideo.Req req = (WXChannelShareVideo.Req) baseReq;
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderShareVideo"), null, null, new String[]{this.appId, req.videoPath, "", "", req.extData, finderShareVideoJumpInfoToString(req.jumpInfo)}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendFinderStartLive(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Log.i("MicroMsg.SDK.WXApiImplV10", "sendFinderStartLive");
        WXChannelStartLive.Req req = (WXChannelStartLive.Req) baseReq;
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/finderStartLive"), null, null, new String[]{this.appId, req.liveJsonInfo, req.openId}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendHandleScanResult(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[]{this.appId, bundle.getString("_wxapi_scan_qrcode_result")}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendInvoiceAuthInsert(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, String.valueOf(2), URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXInvoiceAuthInsert.Req) baseReq).url)))}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendJumpToOfflinePayReq(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), null, null, new String[]{this.appId}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendLaunchWXMiniprogram(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        WXLaunchMiniProgram.Req req = (WXLaunchMiniProgram.Req) baseReq;
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram"), null, null, new String[]{this.appId, req.userName, req.path, req.miniprogramType + "", req.extData}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendLaunchWXMiniprogramWithToken(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogramWithToken"), null, null, new String[]{this.appId, ((WXLaunchMiniProgramWithToken.Req) baseReq).token}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendNonTaxPay(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, String.valueOf(3), URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXNontaxPay.Req) baseReq).url)))}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendOpenBusiLuckyMoney(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendOpenBusinessView(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        WXOpenBusinessView.Req req = (WXOpenBusinessView.Req) baseReq;
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessView"), null, null, new String[]{this.appId, req.businessType, req.query, req.extInfo, req.transaction, req.openId}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendOpenBusinessWebview(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        WXOpenBusinessWebview.Req req = (WXOpenBusinessWebview.Req) baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
        HashMap<String, String> hashMap = req.queryInfo;
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(contentResolver, parse, null, null, new String[]{this.appId, req.businessType + "", (hashMap == null || hashMap.size() <= 0) ? "" : new JSONObject(req.queryInfo).toString()}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendOpenCustomerServiceChat(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        WXOpenCustomerServiceChat.Req req = (WXOpenCustomerServiceChat.Req) baseReq;
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/openCustomerServiceChat"), null, null, new String[]{this.appId, req.corpId, req.url}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendOpenRankListReq(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query == null) {
            return true;
        }
        com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        return true;
    }

    private boolean sendOpenWebview(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendPayInSurance(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, String.valueOf(4), URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXPayInsurance.Req) baseReq).url)))}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context).getString("_wxapp_pay_entry_classname_", null);
            Log.d("MicroMsg.SDK.WXApiImplV10", "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                try {
                    wxappPayEntryClassname = INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_resource_PackageManagerAop_getApplicationInfo(context.getPackageManager(), ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
                } catch (Exception e) {
                    Log.e("MicroMsg.SDK.WXApiImplV10", "get from metaData failed : " + e.getMessage());
                }
            }
            if (wxappPayEntryClassname == null) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.bundle = bundle;
        args.targetPkgName = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
        args.targetClassName = wxappPayEntryClassname;
        args.launchMode = this.launchMode;
        try {
            String tokenFromWX = getTokenFromWX(context);
            if (tokenFromWX != null) {
                args.token = tokenFromWX;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "getTokenFromWX fail, exception = " + e2);
        }
        return MMessageActV2.send(context, args);
    }

    private boolean sendPreloadWXMiniProgramEnvironment(Context context, BaseReq baseReq) {
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogramEnvironment"), null, null, new String[]{this.appId, ((WXPreloadMiniProgramEnvironment.Req) baseReq).extData}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendPreloadWXMiniprogram(Context context, BaseReq baseReq) {
        WXPreloadMiniProgram.Req req = (WXPreloadMiniProgram.Req) baseReq;
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram"), null, null, new String[]{this.appId, req.userName, req.path, req.miniprogramType + "", req.extData}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendQRCodePayReq(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        WXQRCodePay.Req req = (WXQRCodePay.Req) baseReq;
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/QRCodePay"), null, null, new String[]{this.appId, req.codeContent, req.extraMsg}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendSubscribeMessage(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        SubscribeMessage.Req req = (SubscribeMessage.Req) baseReq;
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, String.valueOf(1), String.valueOf(req.scene), req.templateID, req.reserved}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendSubscribeMiniProgramMsg(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(context.getContentResolver(), Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, String.valueOf(5), ((SubscribeMiniProgramMsg.Req) baseReq).miniProgramAppId}, null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query != null) {
            com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        }
        return true;
    }

    private boolean sendToWxaRedirectingPage(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        WXLaunchWxaRedirectingPage.Req req = (WXLaunchWxaRedirectingPage.Req) baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWxaOpenApiRedirectingPage");
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, this.appId);
        arrayList.addAll(Arrays.asList(req.toArray()));
        Cursor com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query = com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query(contentResolver, parse, null, null, (String[]) arrayList.toArray(new String[0]), null);
        if (com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query == null) {
            return true;
        }
        com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_android_content_ContentResolver_query.close();
        return true;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void detach() {
        Log.d("MicroMsg.SDK.WXApiImplV10", "detach");
        this.detached = true;
        this.context = null;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public int getWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        }
        if (!isWXAppInstalled()) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "open wx app failed, not installed or signature check failed");
            return 0;
        }
        this.wxSdkVersion = 0;
        try {
            this.wxSdkVersion = INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_resource_PackageManagerAop_getApplicationInfo(this.context.getPackageManager(), ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
            Log.d("MicroMsg.SDK.WXApiImplV10", "OPEN_SDK_VERSION = " + this.wxSdkVersion);
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "get from metaData failed : " + e.getMessage());
        }
        if (this.wxSdkVersion == 0) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            b.b.submit(new Runnable() { // from class: com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MMSharedPreferences mMSharedPreferences = new MMSharedPreferences(BaseWXApiImplV10.this.context);
                        BaseWXApiImplV10.this.wxSdkVersion = mMSharedPreferences.getInt("_build_info_sdk_int_", 0);
                    } catch (Exception e2) {
                        Log.w("MicroMsg.SDK.WXApiImplV10", e2.getMessage());
                    }
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Log.w("MicroMsg.SDK.WXApiImplV10", e2.getMessage());
            }
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", "wxSdkVersion = " + this.wxSdkVersion);
        return this.wxSdkVersion;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        try {
        } catch (Exception e) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, ex = " + e.getMessage());
        }
        if (!WXApiImplComm.isIntentFromWx(intent, ConstantsAPI.Token.WX_TOKEN_VALUE_MSG)) {
            Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
            return false;
        }
        if (this.detached) {
            throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
        }
        String stringExtra = intent.getStringExtra(ConstantsAPI.CONTENT);
        int intExtra = intent.getIntExtra(ConstantsAPI.SDK_VERSION, 0);
        String stringExtra2 = intent.getStringExtra(ConstantsAPI.APP_PACKAGE);
        if (stringExtra2 != null && stringExtra2.length() != 0) {
            if (!checkSumConsistent(intent.getByteArrayExtra(ConstantsAPI.CHECK_SUM), a.a(stringExtra, intExtra, stringExtra2))) {
                Log.e("MicroMsg.SDK.WXApiImplV10", "checksum fail");
                return false;
            }
            int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
            Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent, cmd = " + intExtra2);
            switch (intExtra2) {
                case 1:
                    iWXAPIEventHandler.onResp(new SendAuth.Resp(intent.getExtras()));
                    return true;
                case 2:
                    iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                    return true;
                case 3:
                    iWXAPIEventHandler.onReq(new GetMessageFromWX.Req(intent.getExtras()));
                    return true;
                case 4:
                    ShowMessageFromWX.Req req = new ShowMessageFromWX.Req(intent.getExtras());
                    String str = req.message.messageExt;
                    if (str != null && str.contains("wx_internal_resptype")) {
                        boolean handleWxInternalRespType = handleWxInternalRespType(str, iWXAPIEventHandler);
                        Log.i("MicroMsg.SDK.WXApiImplV10", "handleIntent, extInfo contains wx_internal_resptype, ret = " + handleWxInternalRespType);
                        return handleWxInternalRespType;
                    }
                    if (str != null && str.contains("openbusinesswebview")) {
                        try {
                            Uri parse = Uri.parse(str);
                            if (parse != null && "openbusinesswebview".equals(parse.getHost())) {
                                WXOpenBusinessWebview.Resp resp = new WXOpenBusinessWebview.Resp();
                                String queryParameter = parse.getQueryParameter("ret");
                                if (queryParameter != null && queryParameter.length() > 0) {
                                    resp.errCode = b.a(queryParameter, 0);
                                }
                                resp.resultInfo = parse.getQueryParameter("resultInfo");
                                resp.errStr = parse.getQueryParameter("errmsg");
                                String queryParameter2 = parse.getQueryParameter("type");
                                if (queryParameter2 != null && queryParameter2.length() > 0) {
                                    resp.businessType = b.a(queryParameter2, 0);
                                }
                                iWXAPIEventHandler.onResp(resp);
                                return true;
                            }
                            Log.d("MicroMsg.SDK.WXApiImplV10", "not openbusinesswebview %" + str);
                        } catch (Exception e2) {
                            Log.e("MicroMsg.SDK.WXApiImplV10", "parse fail, ex = " + e2.getMessage());
                        }
                    }
                    iWXAPIEventHandler.onReq(req);
                    return true;
                case 5:
                    iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_LAUNCH_BY_WX /* 6 */:
                    iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                    return true;
                case 7:
                case ConstantsAPI.COMMAND_JUMP_BIZ_WEBVIEW /* 8 */:
                case 10:
                case 11:
                case ConstantsAPI.COMMAND_OPEN_BUSI_LUCKY_MONEY /* 13 */:
                case 18:
                case ConstantsAPI.COMMAND_INVOICE_AUTH_INSERT /* 20 */:
                case ConstantsAPI.COMMAND_NON_TAX_PAY /* 21 */:
                case ConstantsAPI.COMMAND_PAY_INSURANCE /* 22 */:
                case ConstantsAPI.COMMAND_SUBSCRIBE_MINI_PROGRAM_MSG /* 23 */:
                case 40:
                default:
                    Log.e("MicroMsg.SDK.WXApiImplV10", "unknown cmd = " + intExtra2);
                    return false;
                case 9:
                    iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_OPEN_WEBVIEW /* 12 */:
                    iWXAPIEventHandler.onResp(new OpenWebview.Resp(intent.getExtras()));
                    return true;
                case 14:
                    iWXAPIEventHandler.onResp(new CreateChatroom.Resp(intent.getExtras()));
                    return true;
                case 15:
                    iWXAPIEventHandler.onResp(new JoinChatroom.Resp(intent.getExtras()));
                    return true;
                case 16:
                    iWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_HANDLE_SCAN_RESULT /* 17 */:
                    iWXAPIEventHandler.onResp(new HandleScanResult.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM /* 19 */:
                    iWXAPIEventHandler.onResp(new WXLaunchMiniProgram.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_JUMP_TO_OFFLINE_PAY /* 24 */:
                    iWXAPIEventHandler.onResp(new JumpToOfflinePay.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_OPEN_BUSINESS_WEBVIEW /* 25 */:
                    iWXAPIEventHandler.onResp(new WXOpenBusinessWebview.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_OPEN_BUSINESS_VIEW /* 26 */:
                    iWXAPIEventHandler.onResp(new WXOpenBusinessView.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_JOINT_PAY /* 27 */:
                    iWXAPIEventHandler.onResp(new WXJointPay.JointPayResp(intent.getExtras()));
                    return true;
                case 28:
                    iWXAPIEventHandler.onResp(new WXPreloadMiniProgram.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_LAUNCH_WX_MINIPROGRAM_WITH_TOKEN /* 29 */:
                    iWXAPIEventHandler.onResp(new WXLaunchMiniProgramWithToken.Resp(intent.getExtras()));
                    return true;
                case 30:
                    iWXAPIEventHandler.onResp(new WXLaunchWxaRedirectingPage.Resp(intent.getExtras()));
                    return true;
                case 31:
                    iWXAPIEventHandler.onResp(new SendTdiAuth.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_PRELOAD_MINI_PROGRAM_ENVIRONMENT /* 32 */:
                    iWXAPIEventHandler.onResp(new WXPreloadMiniProgramEnvironment.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_FINDER_SHARE_VIDEO /* 33 */:
                    iWXAPIEventHandler.onResp(new WXChannelShareVideo.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_FINDER_OPEN_PROFILE /* 34 */:
                    iWXAPIEventHandler.onResp(new WXChannelOpenProfile.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_FINDER_OPEN_LIVE /* 35 */:
                    iWXAPIEventHandler.onResp(new WXChannelOpenLive.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_FINDER_OPEN_FEED /* 36 */:
                    iWXAPIEventHandler.onResp(new WXChannelOpenFeed.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_OPEN_CUSTOMER_SERVICE_CHAT /* 37 */:
                    iWXAPIEventHandler.onResp(new WXOpenCustomerServiceChat.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_OPEN_QRCODE_PAY /* 38 */:
                    iWXAPIEventHandler.onResp(new WXQRCodePay.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_FINDER_START_LIVE /* 39 */:
                    iWXAPIEventHandler.onResp(new WXChannelStartLive.Resp(intent.getExtras()));
                    return true;
                case ConstantsAPI.COMMAND_FINDER_OPEN_EVENT /* 41 */:
                    iWXAPIEventHandler.onResp(new WXChannelOpenEvent.Resp(intent.getExtras()));
                    return true;
            }
        }
        Log.e("MicroMsg.SDK.WXApiImplV10", "invalid argument");
        return false;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean isWXAppInstalled() {
        if (this.detached) {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
        try {
            PackageInfo INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_resource_PackageManagerAop_getPackageInfo = INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_resource_PackageManagerAop_getPackageInfo(this.context.getPackageManager(), ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, 64);
            if (INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_resource_PackageManagerAop_getPackageInfo != null) {
                return WXApiImplComm.validateAppSignature(this.context, INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_resource_PackageManagerAop_getPackageInfo.signatures, this.checkSignature);
            }
            Log.w("MicroMsg.SDK.WXApiImplV10", "isWXAppInstalled packageInfo is null");
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean openWXApp() {
        String str;
        if (this.detached) {
            throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
        }
        if (isWXAppInstalled()) {
            try {
                Context context = this.context;
                context.startActivity(INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage(context.getPackageManager(), ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME));
                return true;
            } catch (Exception e) {
                str = "startActivity fail, exception = " + e.getMessage();
            }
        } else {
            str = "open wx app failed, not installed or signature check failed";
        }
        Log.e("MicroMsg.SDK.WXApiImplV10", str);
        return false;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean registerApp(String str) {
        return registerApp(str, 0L);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean registerApp(String str, long j) {
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
            return false;
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + str);
        if (str != null) {
            this.appId = str;
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + str);
        if (str != null) {
            this.appId = str;
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", "register app " + this.context.getPackageName());
        a.C0107a c0107a = new a.C0107a();
        c0107a.a = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
        c0107a.b = ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
        c0107a.c = "weixin://registerapp?appid=" + this.appId;
        c0107a.d = j;
        return a.a(this.context, c0107a);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean sendReq(BaseReq baseReq) {
        return sendReq(baseReq, null);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean sendReq(BaseReq baseReq, final SendReqCallback sendReqCallback) {
        StringBuilder sb;
        String str;
        String str2;
        if (this.detached) {
            throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "sendReq failed for wechat app signature check failed");
            return false;
        }
        if (baseReq.getType() == 2) {
            SendMessageToWX.Req req = (SendMessageToWX.Req) baseReq;
            if (req.scene == 4) {
                SendMessageToWX.IWXSceneDataObject iWXSceneDataObject = req.sceneDataObject;
                if (iWXSceneDataObject instanceof WXStateSceneDataObject) {
                    WXStateSceneDataObject wXStateSceneDataObject = (WXStateSceneDataObject) iWXSceneDataObject;
                    WXMediaMessage wXMediaMessage = req.message;
                    if (wXMediaMessage.mediaObject == null) {
                        wXMediaMessage.mediaObject = new WXTextObject();
                    }
                    if (req.message.getType() == 1 && ((str2 = wXStateSceneDataObject.stateTitle) == null || str2.length() <= 0)) {
                        wXStateSceneDataObject.stateTitle = ((WXTextObject) req.message.mediaObject).text;
                    }
                }
            }
        }
        if (!baseReq.checkArgs()) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "sendReq checkArgs fail");
            return false;
        }
        Log.i("MicroMsg.SDK.WXApiImplV10", "sendReq, req type = " + baseReq.getType());
        final Bundle bundle = new Bundle();
        baseReq.toBundle(bundle);
        if (baseReq.getType() == 5 || baseReq.getType() == 27) {
            return sendPayReq(this.context, bundle);
        }
        if (baseReq.getType() == 9) {
            return sendAddCardToWX(this.context, bundle);
        }
        if (baseReq.getType() == 16) {
            return sendChooseCardFromWX(this.context, bundle);
        }
        if (baseReq.getType() == 11) {
            return sendOpenRankListReq(this.context, bundle);
        }
        if (baseReq.getType() == 12) {
            return sendOpenWebview(this.context, bundle);
        }
        if (baseReq.getType() == 25) {
            return sendOpenBusinessWebview(this.context, baseReq);
        }
        if (baseReq.getType() == 13) {
            return sendOpenBusiLuckyMoney(this.context, bundle);
        }
        if (baseReq.getType() == 14) {
            return createChatroom(this.context, bundle);
        }
        if (baseReq.getType() == 15) {
            return joinChatroom(this.context, bundle);
        }
        if (baseReq.getType() == 17) {
            return sendHandleScanResult(this.context, bundle);
        }
        if (baseReq.getType() == 18) {
            return sendSubscribeMessage(this.context, baseReq);
        }
        if (baseReq.getType() == 28) {
            return sendPreloadWXMiniprogram(this.context, baseReq);
        }
        if (baseReq.getType() == 29) {
            return sendLaunchWXMiniprogramWithToken(this.context, baseReq);
        }
        if (baseReq.getType() == 23) {
            return sendSubscribeMiniProgramMsg(this.context, baseReq);
        }
        if (baseReq.getType() == 19) {
            return sendLaunchWXMiniprogram(this.context, baseReq);
        }
        if (baseReq.getType() == 32) {
            return sendPreloadWXMiniProgramEnvironment(this.context, baseReq);
        }
        if (baseReq.getType() == 30) {
            return sendToWxaRedirectingPage(this.context, baseReq);
        }
        if (baseReq.getType() == 26) {
            return sendOpenBusinessView(this.context, baseReq);
        }
        if (baseReq.getType() == 33) {
            return sendFinderShareVideo(this.context, baseReq);
        }
        if (baseReq.getType() == 39) {
            return sendFinderStartLive(this.context, baseReq);
        }
        if (baseReq.getType() == 34) {
            return sendFinderOpenProfile(this.context, baseReq);
        }
        if (baseReq.getType() == 35) {
            return sendFinderOpenLive(this.context, baseReq);
        }
        if (baseReq.getType() == 36) {
            return sendFinderOpenFeed(this.context, baseReq);
        }
        if (baseReq.getType() == 41) {
            return sendFinderOpenEvent(this.context, baseReq);
        }
        if (baseReq.getType() == 37) {
            return sendOpenCustomerServiceChat(this.context, baseReq);
        }
        if (baseReq.getType() == 38) {
            return sendQRCodePayReq(this.context, baseReq);
        }
        if (baseReq.getType() == 20) {
            return sendInvoiceAuthInsert(this.context, baseReq);
        }
        if (baseReq.getType() == 21) {
            return sendNonTaxPay(this.context, baseReq);
        }
        if (baseReq.getType() == 22) {
            return sendPayInSurance(this.context, baseReq);
        }
        if (baseReq.getType() == 24) {
            return sendJumpToOfflinePayReq(this.context, bundle);
        }
        if (baseReq.getType() == 2) {
            SendMessageToWX.Req req2 = (SendMessageToWX.Req) baseReq;
            if (b.a(req2.message.getType())) {
                WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) req2.message.mediaObject;
                wXMiniProgramObject.userName += "@app";
                String str3 = wXMiniProgramObject.path;
                if (!b.b(str3)) {
                    String[] split = str3.split("\\?");
                    if (split.length > 1) {
                        sb = new StringBuilder();
                        sb.append(split[0]);
                        sb.append(".html?");
                        str = split[1];
                    } else {
                        sb = new StringBuilder();
                        sb.append(split[0]);
                        str = ".html";
                    }
                    sb.append(str);
                    wXMiniProgramObject.path = sb.toString();
                }
                int i = req2.scene;
                if (i != 3 && i != 1) {
                    req2.scene = 0;
                }
                baseReq.toBundle(bundle);
            }
        }
        String extractMayNeedDoSecurityCheckUrl = this.securityHelper.extractMayNeedDoSecurityCheckUrl(this.appId, baseReq);
        if (b.b(extractMayNeedDoSecurityCheckUrl)) {
            boolean doLaunchApp = doLaunchApp(bundle);
            callbackReq(sendReqCallback, doLaunchApp);
            return doLaunchApp;
        }
        int doExtraSecurityCheck = this.securityHelper.doExtraSecurityCheck(this.appId, "638063616", extractMayNeedDoSecurityCheckUrl, new WXAPiSecurityHelper.ISecurityCheck() { // from class: com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.2
            @Override // com.tencent.mm.opensdk.openapi.WXAPiSecurityHelper.ISecurityCheck
            public void onCheckFinish(boolean z) {
                if (!z) {
                    Log.i("MicroMsg.SDK.WXApiImplV10", "WXAPiSecurityHelper, extra check do next step: check fail, stop process!");
                    BaseWXApiImplV10.this.callbackReq(sendReqCallback, false);
                } else {
                    Log.i("MicroMsg.SDK.WXApiImplV10", "WXAPiSecurityHelper, extra check do next step: check pass, doLaunchApp");
                    BaseWXApiImplV10.this.callbackReq(sendReqCallback, BaseWXApiImplV10.this.doLaunchApp(bundle));
                }
            }
        });
        if (doExtraSecurityCheck == 0) {
            Log.i("MicroMsg.SDK.WXApiImplV10", "WXAPiSecurityHelper, extra check pass, doLaunchApp");
            boolean doLaunchApp2 = doLaunchApp(bundle);
            callbackReq(sendReqCallback, doLaunchApp2);
            return doLaunchApp2;
        }
        if (doExtraSecurityCheck != 1) {
            Log.i("MicroMsg.SDK.WXApiImplV10", "WXAPiSecurityHelper, hold on request, extra check need to do next step");
            return true;
        }
        Log.i("MicroMsg.SDK.WXApiImplV10", "WXAPiSecurityHelper, extra check fail, return");
        callbackReq(sendReqCallback, false);
        return false;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean sendResp(BaseResp baseResp) {
        String str;
        if (this.detached) {
            throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            str = "sendResp failed for wechat app signature check failed";
        } else {
            if (baseResp.checkArgs()) {
                Bundle bundle = new Bundle();
                baseResp.toBundle(bundle);
                MMessageActV2.Args args = new MMessageActV2.Args();
                args.bundle = bundle;
                args.content = "weixin://sendresp?appid=" + this.appId;
                args.targetPkgName = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
                args.targetClassName = ConstantsAPI.WXApp.WXAPP_MSG_ENTRY_CLASSNAME;
                try {
                    String tokenFromWX = getTokenFromWX(this.context);
                    if (tokenFromWX != null) {
                        args.token = tokenFromWX;
                    }
                } catch (Exception e) {
                    Log.e("MicroMsg.SDK.WXApiImplV10", "getTokenFromWX fail, exception = " + e);
                }
                return MMessageActV2.send(this.context, args);
            }
            str = "sendResp checkArgs fail";
        }
        Log.e("MicroMsg.SDK.WXApiImplV10", str);
        return false;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void setLogImpl(ILog iLog) {
        Log.setLogImpl(iLog);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        }
        if (!WXApiImplComm.validateAppSignatureForPackage(this.context, ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME, this.checkSignature)) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "unregister app failed for wechat app signature check failed");
            return;
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", "unregisterApp, appId = " + this.appId);
        String str = this.appId;
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.SDK.WXApiImplV10", "unregisterApp fail, appId is empty");
            return;
        }
        Log.d("MicroMsg.SDK.WXApiImplV10", "unregister app " + this.context.getPackageName());
        a.C0107a c0107a = new a.C0107a();
        c0107a.a = ConstantsAPI.WXApp.WXAPP_PACKAGE_NAME;
        c0107a.b = ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER;
        c0107a.c = "weixin://unregisterapp?appid=" + this.appId;
        a.a(this.context, c0107a);
    }

    @Proxy("getLaunchIntentForPackage")
    @TargetClass("android.content.pm.PackageManager")
    public static Intent INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getLaunchIntentForPackage(PackageManager packageManager, String str) {
        if (PrivacyMgr.inst().hasConfirmedAndNotBasic()) {
            return packageManager.getLaunchIntentForPackage(str);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.phoenix.read", "com.dragon.read.pages.splash.SplashActivity"));
        return intent;
    }

    @Proxy("getApplicationInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static ApplicationInfo INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_resource_PackageManagerAop_getApplicationInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, i);
            Intrinsics.checkNotNull(applicationInfo, "null cannot be cast to non-null type android.content.pm.ApplicationInfo");
            return applicationInfo;
        }
        x55.b bVar = x55.b.a;
        ApplicationInfo d = bVar.d(packageName, i);
        if (d != null) {
            return d;
        }
        ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(packageName, i);
        Intrinsics.checkNotNull(applicationInfo2, "null cannot be cast to non-null type android.content.pm.ApplicationInfo");
        bVar.a(packageName, i, applicationInfo2);
        return applicationInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (x55.a.a()) {
            PackageInfo INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        x55.b bVar = x55.b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + android.util.Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }

    @Proxy("getActivity")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.app.PendingIntent")
    public static PendingIntent INVOKESTATIC_com_tencent_mm_opensdk_openapi_BaseWXApiImplV10_com_dragon_read_aop_target31_PendingIntentAop_getActivity(Context context, int i, Intent intent, int i2) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 31) {
            boolean z2 = true;
            if ((67108864 & i2) != 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i2 & 33554432) == 0) {
                z2 = false;
            }
            if (!z2 && !z) {
                i2 |= 33554432;
            }
        }
        return PendingIntent.getActivity(context, i, intent, i2);
    }
}
