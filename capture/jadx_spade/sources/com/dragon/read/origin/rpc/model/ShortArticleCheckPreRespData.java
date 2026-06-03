package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ShortArticleCheckPreRespData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("check_resp_list")
    @RpcField(FieldType.BODY)
    public List<ShortArticleCheckPreMetaResp> checkRespList;

    static {
        Covode.recordClassIndex(613437);
        fieldTypeClassRef = FieldType.class;
    }
}
