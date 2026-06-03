package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class PublicationReadTaskData implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;
    public String extra;

    @SerializedName("restricted_genres")
    public List<String> restrictedGenres;

    @SerializedName("task_list")
    public List<TaskDetail> taskList;
    public String title;

    static {
        Covode.recordClassIndex(612200);
        fieldTypeClassRef = FieldType.class;
    }
}
