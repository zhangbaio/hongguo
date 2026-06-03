package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.bytedance.covode.number.Covode;
import com.dragon.read.app.PrivacyMgr;
import com.dragon.read.base.util.LogWrapper;
import com.dragon.read.util.DebugManager;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;
import x55.a;
import x55.b;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
class WXApiImplComm {
    static {
        Covode.recordClassIndex(653471);
    }

    private WXApiImplComm() {
        throw new RuntimeException(WXApiImplComm.class.getSimpleName() + " should not be instantiated");
    }

    public static boolean isIntentFromWx(Intent intent, String str) {
        String stringExtra;
        return (intent == null || (stringExtra = intent.getStringExtra(ConstantsAPI.Token.WX_TOKEN_KEY)) == null || !stringExtra.equals(str)) ? false : true;
    }

    public static boolean validateAppSignature(Context context, Signature[] signatureArr, boolean z) {
        String str;
        if (z) {
            for (Signature signature : signatureArr) {
                if (signature == null) {
                    Log.i("MicroMsg.SDK.WXMsgImplComm", "validateAppSignature signature is null");
                } else {
                    String lowerCase = signature.toCharsString().toLowerCase();
                    Log.d("MicroMsg.SDK.WXMsgImplComm", "check signature:" + lowerCase);
                    if (lowerCase.equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                        str = "pass";
                    }
                }
            }
            return false;
        }
        str = "ignore wechat app signature validation";
        Log.d("MicroMsg.SDK.WXMsgImplComm", str);
        return true;
    }

    public static boolean validateAppSignatureForPackage(Context context, String str, boolean z) {
        StringBuilder sb;
        String message;
        if (!z) {
            Log.d("MicroMsg.SDK.WXMsgImplComm", "ignore wechat app signature validation");
            return true;
        }
        try {
            return validateAppSignature(context, INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXApiImplComm_com_dragon_read_resource_PackageManagerAop_getPackageInfo(context.getPackageManager(), str, 64).signatures, z);
        } catch (PackageManager.NameNotFoundException e) {
            sb = new StringBuilder();
            sb.append("validateAppSignatureForPackage ex ");
            message = e.getMessage();
            sb.append(message);
            Log.w("MicroMsg.SDK.WXMsgImplComm", sb.toString());
            return false;
        } catch (Exception e2) {
            sb = new StringBuilder();
            sb.append("validateAppSignatureForPackage ex ");
            message = e2.getMessage();
            sb.append(message);
            Log.w("MicroMsg.SDK.WXMsgImplComm", sb.toString());
            return false;
        }
    }

    @Proxy("getPackageInfo")
    @TargetClass("android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXApiImplComm_com_dragon_read_resource_PackageManagerAop_getPackageInfo(PackageManager packageManager, String packageName, int i) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (a.a()) {
            PackageInfo INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXApiImplComm_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo = INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXApiImplComm_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
            Intrinsics.checkNotNull(INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXApiImplComm_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo, "null cannot be cast to non-null type android.content.pm.PackageInfo");
            return INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXApiImplComm_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo;
        }
        b bVar = b.a;
        PackageInfo f = bVar.f(packageName, i);
        if (f != null) {
            return f;
        }
        PackageInfo INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXApiImplComm_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2 = INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXApiImplComm_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(packageManager, packageName, i);
        Intrinsics.checkNotNull(INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXApiImplComm_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2, "null cannot be cast to non-null type android.content.pm.PackageInfo");
        bVar.c(packageName, i, INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXApiImplComm_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2);
        return INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXApiImplComm_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo2;
    }

    @Proxy("getPackageInfo")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.pm.PackageManager")
    public static PackageInfo INVOKEVIRTUAL_com_tencent_mm_opensdk_openapi_WXApiImplComm_com_dragon_read_base_lancet_PrivacyAop_getPackageInfo(PackageManager packageManager, String str, int i) {
        if (!PrivacyMgr.inst().hasConfirmedAndNotBasic() && !lz4.a.a(str)) {
            return null;
        }
        if (DebugManager.isDebugBuild() && DebugManager.inst().isComplianceLogEnable()) {
            LogWrapper.info("getPackageInfo", "getPackageInfo(" + str + ") " + android.util.Log.getStackTraceString(new Exception()), new Object[0]);
        }
        return packageManager.getPackageInfo(str, i);
    }
}
