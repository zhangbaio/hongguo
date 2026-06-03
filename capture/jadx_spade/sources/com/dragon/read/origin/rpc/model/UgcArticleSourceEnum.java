package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum UgcArticleSourceEnum {
    None(0),
    UGCTtab(1),
    Item(2),
    OutShareBackflowPage(3),
    AuthorCenterPublishStory(4);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613493);
    }

    public static UgcArticleSourceEnum findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return AuthorCenterPublishStory;
                    }
                    return OutShareBackflowPage;
                }
                return Item;
            }
            return UGCTtab;
        }
        return None;
    }

    UgcArticleSourceEnum(int i) {
        this.value = i;
    }
}
