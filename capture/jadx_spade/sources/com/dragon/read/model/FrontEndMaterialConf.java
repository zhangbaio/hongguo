package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FrontEndMaterialConf implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("arrow_conf")
    public ArrowConf arrowConf;

    @SerializedName("button_conf")
    public TextConf buttonConf;

    @SerializedName("carousel_conf")
    public List<CarouselConf> carouselConf;

    @SerializedName("direct_schema")
    public String directSchema;

    @SerializedName("disappear_tapped")
    public boolean disappearTapped;
    public String extra;

    @SerializedName("icon_conf")
    public IconConf iconConf;
    public long id;

    @SerializedName("invite_code")
    public String inviteCode;

    @SerializedName("is_kouling")
    public boolean isKouling;

    @SerializedName("is_success")
    public boolean isSuccess;

    @SerializedName("lynx_schema")
    public String lynxSchema;

    @SerializedName("need_login")
    public boolean needLogin;
    public String position;
    public String priority;

    @SerializedName("reward_conf")
    public RewardConf rewardConf;

    @SerializedName("sub_title_conf")
    public TextConf subTitleConf;

    @SerializedName("time_conf")
    public TimeConf timeConf;

    @SerializedName("title_conf")
    public TextConf titleConf;

    @SerializedName("user_conf")
    public UserConf userConf;

    static {
        Covode.recordClassIndex(612105);
        fieldTypeClassRef = FieldType.class;
    }
}
