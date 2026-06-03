package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class MaterialInfo implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("client_material")
    public Map<String, List<ClientMaterialConf>> clientMaterial;

    @SerializedName("front_end_material")
    public Map<String, List<FrontEndMaterialConf>> frontEndMaterial;

    static {
        Covode.recordClassIndex(612152);
        fieldTypeClassRef = FieldType.class;
    }
}
