package com.ss.videoarch.liveplayer;

import com.bytedance.covode.number.Covode;
import org.json.JSONObject;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface INetworkClient {

    public static class Result {
        public final String body;
        public final int code;
        public final Exception e;
        public final String header;
        public final JSONObject response;

        static {
            Covode.recordClassIndex(652920);
        }

        public static class Builder {
            String body;
            int code;
            Exception e;
            String header;
            JSONObject response;

            static {
                Covode.recordClassIndex(652921);
            }

            private Builder() {
            }

            public Result build() {
                return new Result(this);
            }

            public Builder setBody(String str) {
                this.body = str;
                return this;
            }

            public Builder setCode(int i) {
                this.code = i;
                return this;
            }

            public Builder setException(Exception exc) {
                this.e = exc;
                return this;
            }

            public Builder setHeader(String str) {
                this.header = str;
                return this;
            }

            public Builder setResponse(JSONObject jSONObject) {
                this.response = jSONObject;
                return this;
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        private Result(Builder builder) {
            this.response = builder.response;
            this.body = builder.body;
            this.header = builder.header;
            this.e = builder.e;
            this.code = builder.code;
        }
    }

    Result doPost(String str, String str2);

    Result doRequest(String str, String str2);
}
