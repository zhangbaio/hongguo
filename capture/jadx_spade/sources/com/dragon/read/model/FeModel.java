package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class FeModel implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public Map<String, List<FeContentElement>> actions;
    public Map<String, List<FeContentElement>> contents;

    @SerializedName("data_source")
    public String dataSource;

    @SerializedName("fe_variables")
    public List<FeVariable> feVariables;
    public FeMetaData metadata;
    public FeProgress progress;

    @SerializedName("task_status")
    public FeTaskStatus taskStatus;

    static {
        Covode.recordClassIndex(612095);
        fieldTypeClassRef = FieldType.class;
    }
}
