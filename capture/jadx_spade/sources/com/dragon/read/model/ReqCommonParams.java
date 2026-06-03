package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ReqCommonParams implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("ab_params")
    @RpcField(FieldType.QUERY)
    public String abParams;

    @SerializedName("ab_sdk_version")
    @RpcField(FieldType.QUERY)
    public String abSdkVersion;

    @RpcField(FieldType.QUERY)
    public String ac;

    @SerializedName("act_version")
    @RpcField(FieldType.QUERY)
    public int actVersion;

    @SerializedName("aid")
    @RpcField(FieldType.QUERY)
    public int appId;

    @SerializedName("app_install_status_map")
    @RpcField(FieldType.QUERY)
    public Map<String, String> appInstallStatusMap;

    @SerializedName("app_language")
    @RpcField(FieldType.QUERY)
    public String appLanguage;

    @SerializedName("app_name")
    @RpcField(FieldType.QUERY)
    public String appName;

    @SerializedName("app_region")
    @RpcField(FieldType.QUERY)
    public String appRegion;

    @SerializedName("app_version")
    @RpcField(FieldType.QUERY)
    public String appVersion;

    @SerializedName("base_revision_switch")
    @RpcField(FieldType.QUERY)
    public String baseRevisionSwitch;

    @SerializedName("bottom_tab_list")
    @RpcField(FieldType.QUERY)
    public String bottomTabList;

    @RpcField(FieldType.QUERY)
    public String caid1;

    @RpcField(FieldType.QUERY)
    public String caid2;

    @SerializedName("can_listen_presell")
    @RpcField(FieldType.QUERY)
    public boolean canListenPresell;

    @SerializedName("carrier_region")
    @RpcField(FieldType.QUERY)
    public String carrierRegion;

    @RpcField(FieldType.QUERY)
    public String cdid;

    @RpcField(FieldType.QUERY)
    public String channel;

    @SerializedName("common_hashtags_json")
    @RpcField(FieldType.QUERY)
    public String commonHashtagsJson;

    @SerializedName("compliance_status")
    @RpcField(FieldType.QUERY)
    public int complianceStatus;

    @SerializedName("device_brand")
    @RpcField(FieldType.QUERY)
    public String deviceBrand;

    @SerializedName("device_id")
    @RpcField(FieldType.QUERY)
    public long deviceId;

    @SerializedName("device_platform")
    @RpcField(FieldType.QUERY)
    public String devicePlatform;

    @SerializedName("device_type")
    @RpcField(FieldType.QUERY)
    public String deviceType;

    @SerializedName("dragon_device_type")
    @RpcField(FieldType.QUERY)
    public String dragonDeviceType;

    @SerializedName("enter_from")
    @RpcField(FieldType.QUERY)
    public String enterFrom;

    @SerializedName("entry_from")
    @RpcField(FieldType.QUERY)
    public String entryFrom;

    @SerializedName("extra_data")
    @RpcField(FieldType.QUERY)
    public String extraData;

    @SerializedName("first_install_time")
    @RpcField(FieldType.QUERY)
    public long firstInstallTime;

    @RpcField(FieldType.QUERY)
    public String forwarded;

    @RpcField(FieldType.QUERY)
    public String fp;

    @RpcField(FieldType.QUERY)
    public String idfa;

    @RpcField(FieldType.QUERY)
    public String imei;

    @SerializedName("important_start_flag")
    @RpcField(FieldType.QUERY)
    public String importantStartFlag;

    @SerializedName("inside_scene")
    @RpcField(FieldType.QUERY)
    public String insideScene;

    @SerializedName("iid")
    @RpcField(FieldType.QUERY)
    public long installId;

    @SerializedName("install_time")
    @RpcField(FieldType.QUERY)
    public long installTime;

    @RpcField(FieldType.QUERY)
    public String ip;

    @SerializedName("is_ad_preload")
    @RpcField(FieldType.QUERY)
    public boolean isAdPreload;

    @SerializedName("is_android_fold")
    @RpcField(FieldType.QUERY)
    public int isAndroidFold;

    @SerializedName("is_android_pad")
    @RpcField(FieldType.QUERY)
    public int isAndroidPad;

    @SerializedName("is_android_pad_screen")
    @RpcField(FieldType.QUERY)
    public int isAndroidPadScreen;

    @SerializedName("is_assist_user")
    @RpcField(FieldType.QUERY)
    public boolean isAssistUser;

    @SerializedName("is_douyin_authorized")
    @RpcField(FieldType.QUERY)
    public boolean isDouyinAuthorized;

    @SerializedName("is_in_review")
    @RpcField(FieldType.QUERY)
    public boolean isInReview;

    @SerializedName("is_main_page")
    @RpcField(FieldType.QUERY)
    public int isMainPage;

    @SerializedName("is_pad")
    @RpcField(FieldType.QUERY)
    public int isPad;

    @RpcField(FieldType.QUERY)
    public String language;

    @SerializedName("latest_reinstall_time")
    @RpcField(FieldType.QUERY)
    public long latestReinstallTime;

    @SerializedName("local_ab_version")
    @RpcField(FieldType.QUERY)
    public String localAbVersion;

    @SerializedName("location_info")
    @RpcField(FieldType.QUERY)
    public LocationInfo locationInfo;

    @SerializedName("lucky_device_score")
    @RpcField(FieldType.QUERY)
    public String luckyDeviceScore;

    @SerializedName("lucky_is_32")
    @RpcField(FieldType.QUERY)
    public int luckyIs32;

    @SerializedName("luckycat_version_code")
    @RpcField(FieldType.QUERY)
    public int luckycatVersionCode;

    @SerializedName("need_personal_recommend")
    @RpcField(FieldType.QUERY)
    public int needPersonalRecommend;

    @SerializedName("not_comics_tab_user")
    @RpcField(FieldType.QUERY)
    public int notComicsTabUser;

    @RpcField(FieldType.QUERY)
    public String oaid;

    @SerializedName("odin_info")
    @RpcField(FieldType.QUERY)
    public OdinInfo odinInfo;

    @SerializedName("open_id")
    @RpcField(FieldType.QUERY)
    public String openId;

    @SerializedName("openudid")
    @RpcField(FieldType.QUERY)
    public String openUdid;

    @SerializedName("order_id")
    @RpcField(FieldType.QUERY)
    public String orderId;

    @RpcField(FieldType.QUERY)
    public String os;

    @SerializedName("os_version")
    @RpcField(FieldType.QUERY)
    public String osVersion;

    @SerializedName("os_api")
    @RpcField(FieldType.QUERY)
    public int osapi;

    @SerializedName("page_key")
    @RpcField(FieldType.QUERY)
    public String pageKey;

    @SerializedName("pass_through")
    @RpcField(FieldType.QUERY)
    public String passThrough;

    @RpcField(FieldType.QUERY)
    public String path;

    @SerializedName("path_version")
    @RpcField(FieldType.QUERY)
    public String pathVersion;

    @SerializedName("personal_switch")
    @RpcField(FieldType.QUERY)
    public String personalSwitch;

    @SerializedName("pitaya_feature")
    @RpcField(FieldType.QUERY)
    public String pitayaFeature;

    @SerializedName("polaris_undertake_method")
    @RpcField(FieldType.QUERY)
    public String polarisUndertakeMethod;

    @RpcField(FieldType.QUERY)
    public String position;

    @SerializedName("pull_active_gd_label")
    @RpcField(FieldType.QUERY)
    public String pullActiveGdLabel;

    @SerializedName("pull_active_info")
    @RpcField(FieldType.QUERY)
    public PullActiveInfo pullActiveInfo;

    @SerializedName("quick_app_params")
    @RpcField(FieldType.QUERY)
    public QuickAppParams quickAppParams;

    @SerializedName("read_time")
    @RpcField(FieldType.QUERY)
    public int readTime;

    @SerializedName("recommend_disable")
    @RpcField(FieldType.QUERY)
    public int recommendDisable;

    @SerializedName("req_time")
    @RpcField(FieldType.QUERY)
    public long reqTime;

    @RpcField(FieldType.QUERY)
    public String resolution;

    @SerializedName("reverse_config")
    @RpcField(FieldType.QUERY)
    public Map<String, Boolean> reverseConfig;

    @SerializedName("room_id")
    @RpcField(FieldType.QUERY)
    public long roomId;

    @SerializedName("sale_app_id")
    @RpcField(FieldType.QUERY)
    public int saleAppId;

    @RpcField(FieldType.QUERY)
    public String scene;

    @SerializedName("scm_build_version")
    @RpcField(FieldType.QUERY)
    public String scmBuildVersion;

    @SerializedName("sesson_rsp_header")
    @RpcField(FieldType.QUERY)
    public String sessionRspHeader;

    @SerializedName("shield_take_cash_recommend")
    @RpcField(FieldType.QUERY)
    public boolean shieldTakeCashRecommend;

    @SerializedName("sign_env")
    @RpcField(FieldType.QUERY)
    public String signEnv;

    @SerializedName("sign_err")
    @RpcField(FieldType.QUERY)
    public String signErr;

    @SerializedName("sign_res")
    @RpcField(FieldType.QUERY)
    public String signRes;

    @SerializedName("sign_res_extra")
    @RpcField(FieldType.QUERY)
    public String signResExtra;

    @SerializedName("skip_cache")
    @RpcField(FieldType.QUERY)
    public String skipCache;

    @SerializedName("strategy_filter_label")
    @RpcField(FieldType.QUERY)
    public String strategyFilterLabel;

    @SerializedName("sub_position")
    @RpcField(FieldType.QUERY)
    public String subPosition;

    @SerializedName("sys_language")
    @RpcField(FieldType.QUERY)
    public String sysLanguage;

    @SerializedName("sys_region")
    @RpcField(FieldType.QUERY)
    public String sysRegion;

    @SerializedName("task_rules_byteconf_key")
    @RpcField(FieldType.QUERY)
    public String taskRulesBcKey;

    @SerializedName("teenager_switch")
    @RpcField(FieldType.QUERY)
    public String teenagerSwitch;

    @SerializedName("tz_name")
    @RpcField(FieldType.QUERY)
    public String timeZoneName;

    @SerializedName("today_first_launch_info")
    @RpcField(FieldType.QUERY)
    public TodayFirstLaunchInfo todayFirstLaunchInfo;

    @SerializedName("tool_grey_user")
    @RpcField(FieldType.QUERY)
    public int toolGreyUser;

    @SerializedName("ui_language")
    @RpcField(FieldType.QUERY)
    public String uiLanguage;

    @SerializedName("unfreeze_left_time")
    @RpcField(FieldType.QUERY)
    public int unfreezeLeftTime;

    @SerializedName("unify_version_code")
    @RpcField(FieldType.QUERY)
    public long unifyVersionCode60101;

    @SerializedName("unify_version_code_611")
    @RpcField(FieldType.QUERY)
    public long unifyVersionCode611;

    @SerializedName("update_version_code")
    @RpcField(FieldType.QUERY)
    public int updateVersionCode;

    @SerializedName("user_agent")
    @RpcField(FieldType.QUERY)
    public String userAgent;

    @SerializedName("user_genre_type")
    @RpcField(FieldType.QUERY)
    public String userGenreType;

    @SerializedName("utm_campaign")
    @RpcField(FieldType.QUERY)
    public String utmCampaign;

    @SerializedName("utm_medium")
    @RpcField(FieldType.QUERY)
    public String utmMedium;

    @SerializedName("utm_source")
    @RpcField(FieldType.QUERY)
    public String utmSource;

    @RpcField(FieldType.QUERY)
    public String uuid;

    @SerializedName("version_code")
    @RpcField(FieldType.QUERY)
    public String versionCode;

    @SerializedName("version_name")
    @RpcField(FieldType.QUERY)
    public String versionName;

    @SerializedName("x_khronos")
    @RpcField(FieldType.QUERY)
    public long xKhronos;

    static {
        Covode.recordClassIndex(612228);
        fieldTypeClassRef = FieldType.class;
    }
}
