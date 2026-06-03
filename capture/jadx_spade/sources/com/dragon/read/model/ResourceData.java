package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ResourceData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("client_log_data")
    public Map<String, String> clientLogData;

    @SerializedName("client_overwrites")
    public List<ClientOverwrite> clientOverwrites;

    @SerializedName("custom_data")
    public Map<String, Content> customData;
    public Map<String, Content> data;

    @SerializedName("log_data")
    public LogData logData;

    @SerializedName("resource_meta")
    public ResourceMeta resourceMeta;
    public Content schema;

    static {
        Covode.recordClassIndex(612229);
        fieldTypeClassRef = FieldType.class;
    }
}
