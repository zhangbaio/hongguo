package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;
import com.bytedance.rpc.serialize.FieldType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public class ChatMessage implements Serializable {
    private static Class fieldTypeClassRef;
    private static final long serialVersionUID = 0;

    @SerializedName("chat_role")
    public ChatRole chatRole;
    public String content;
    public Map<String, String> ext;

    @SerializedName("msg_type")
    public int msgType;

    static {
        Covode.recordClassIndex(612803);
        fieldTypeClassRef = FieldType.class;
    }
}
