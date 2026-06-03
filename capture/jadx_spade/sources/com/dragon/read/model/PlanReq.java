package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PlanReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("app_install_status_map")
    @RpcField(FieldType.QUERY)
    public Map<String, String> appInstallStatusMap;

    @SerializedName("custom_attribute")
    public Map<String, String> customAttribute;

    @SerializedName("custom_biz_attribute")
    public Map<String, String> customBizAttribute;

    @SerializedName("custom_biz_variable")
    public Map<String, String> customBizVariable;

    @SerializedName("custom_variable")
    public Map<String, String> customVariable;
    public List<String> event;

    @SerializedName("need_landing_data")
    public boolean needLandingData;

    static {
        Covode.recordClassIndex(612188);
        fieldTypeClassRef = FieldType.class;
    }
}
