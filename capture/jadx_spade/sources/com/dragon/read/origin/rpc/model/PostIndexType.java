package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum PostIndexType {
    PostWithScript(10000),
    PostAuthorSpeak2(10001),
    PostSavior(10002),
    PostSaviorBooklist(10003),
    PostTalk(10004),
    PostTalkItemComment(10005),
    PostAuthorProduct(10006),
    PostTalkStory(10007),
    PostSaviorStory(10008),
    TopicSavior(11000),
    TopicTalk(11001);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613310);
    }

    public static PostIndexType findByValue(int i) {
        if (i != 11000) {
            if (i != 11001) {
                switch (i) {
                    case 10000:
                        return PostWithScript;
                    case 10001:
                        return PostAuthorSpeak2;
                    case 10002:
                        return PostSavior;
                    case 10003:
                        return PostSaviorBooklist;
                    case 10004:
                        return PostTalk;
                    case 10005:
                        return PostTalkItemComment;
                    case 10006:
                        return PostAuthorProduct;
                    case 10007:
                        return PostTalkStory;
                    case 10008:
                        return PostSaviorStory;
                    default:
                        return null;
                }
            }
            return TopicTalk;
        }
        return TopicSavior;
    }

    PostIndexType(int i) {
        this.value = i;
    }
}
