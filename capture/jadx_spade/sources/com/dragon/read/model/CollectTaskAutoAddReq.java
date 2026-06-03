package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class CollectTaskAutoAddReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("add_scene")
    public String addScene;
    public int amount;

    @SerializedName("collect_times")
    public int collectTimes;

    @SerializedName("ex_device_collect_times")
    public int exDeviceCollectTimes;

    @SerializedName("group_id")
    public String groupId;

    @SerializedName("is_new_book")
    public boolean isNewBook;

    @SerializedName("read_type")
    public String readType;

    @SerializedName("task_key")
    public String taskKey;
    public String type;

    static {
        Covode.recordClassIndex(612058);
        fieldTypeClassRef = FieldType.class;
    }
}
