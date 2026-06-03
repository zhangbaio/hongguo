package com.dragon.read.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.annotation.RpcField;
import com.bytedance.rpc.annotation.RpcFieldModify;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

@RpcFieldModify
/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class SingleTaskReq implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("book_id")
    @RpcField(FieldType.QUERY)
    public String bookId;

    @RpcField(FieldType.QUERY)
    public int chapter;

    @SerializedName("cur_chapter")
    @RpcField(FieldType.QUERY)
    public int curChapter;

    @SerializedName("from_push")
    @RpcField(FieldType.QUERY)
    public int fromPush;

    @RpcField(FieldType.QUERY)
    public String genre;

    @SerializedName("group_id")
    @RpcField(FieldType.QUERY)
    public String groupId;

    @SerializedName("is_new_book")
    @RpcField(FieldType.QUERY)
    public boolean isNewBook;

    @SerializedName("is_new_video")
    @RpcField(FieldType.QUERY)
    public boolean isNewVideo;

    @SerializedName("read_type")
    @RpcField(FieldType.QUERY)
    public String readType;

    @RpcField(FieldType.QUERY)
    public String scene;

    @SerializedName("series_id")
    @RpcField(FieldType.QUERY)
    public String seriesId;

    @SerializedName("task_key")
    @RpcField(FieldType.QUERY)
    public String taskKey;

    static {
        Covode.recordClassIndex(612255);
        fieldTypeClassRef = FieldType.class;
    }
}
