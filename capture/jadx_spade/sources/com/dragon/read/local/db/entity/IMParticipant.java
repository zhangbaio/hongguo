package com.dragon.read.local.db.entity;

import com.bytedance.covode.number.Covode;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class IMParticipant {
    public static final int $stable;
    private String avatarUri;
    private final String conversationId;
    private long createTime;
    private String description;
    private boolean isRobot;
    private String name;
    private Integer role;
    private long updateTime;
    private final String userId;

    static {
        Covode.recordClassIndex(611580);
        $stable = 8;
    }

    public final String getAvatarUri() {
        return this.avatarUri;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getRole() {
        return this.role;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final boolean isRobot() {
        return this.isRobot;
    }

    public final void setAvatarUri(String str) {
        this.avatarUri = str;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setRobot(boolean z) {
        this.isRobot = z;
    }

    public final void setRole(Integer num) {
        this.role = num;
    }

    public final void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public IMParticipant(String conversationId, String userId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.conversationId = conversationId;
        this.userId = userId;
        this.name = "";
        this.avatarUri = "";
        this.description = "";
    }
}
