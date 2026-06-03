package com.dragon.read.origin.rpc.model;

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
public class VideoExpand implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @RpcField(FieldType.BODY)
    public Map<String, String> extra;

    @SerializedName("sub_title_list")
    @RpcField(FieldType.BODY)
    public List<ExpandTextExt> subTitleList;

    static {
        Covode.recordClassIndex(613568);
        fieldTypeClassRef = FieldType.class;
    }
}
