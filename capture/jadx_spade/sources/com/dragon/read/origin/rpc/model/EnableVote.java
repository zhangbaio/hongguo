package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum EnableVote {
    EnableVoteClose(0),
    EnableVoteOpen(1);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(612918);
    }

    public static EnableVote findByValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return EnableVoteOpen;
        }
        return EnableVoteClose;
    }

    EnableVote(int i) {
        this.value = i;
    }
}
