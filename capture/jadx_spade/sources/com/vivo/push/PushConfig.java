package com.vivo.push;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PushConfig {
    private boolean mAgreePrivacyStatement;
    private boolean mOpenMultiUser;

    static {
        Covode.recordClassIndex(654974);
    }

    public boolean isAgreePrivacyStatement() {
        return this.mAgreePrivacyStatement;
    }

    public boolean isOpenMultiUser() {
        return this.mOpenMultiUser;
    }

    public static final class Builder {
        private boolean mAgreePrivacyStatement = true;
        private boolean mOpenMultiUser = false;

        static {
            Covode.recordClassIndex(654975);
        }

        public final PushConfig build() {
            return new PushConfig(this, null);
        }

        public final Builder agreePrivacyStatement(boolean z) {
            this.mAgreePrivacyStatement = z;
            return this;
        }

        public final Builder openMultiUserMode(boolean z) {
            this.mOpenMultiUser = z;
            return this;
        }
    }

    private PushConfig(Builder builder) {
        this.mAgreePrivacyStatement = true;
        this.mOpenMultiUser = false;
        this.mAgreePrivacyStatement = builder.mAgreePrivacyStatement;
        this.mOpenMultiUser = builder.mOpenMultiUser;
    }

    /* synthetic */ PushConfig(Builder builder, w wVar) {
        this(builder);
    }
}
