package com.dragon.read.origin.rpc.model;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public enum ResourceType {
    Writer(100),
    Contractor(101),
    Actor(102),
    IP(200),
    Script(201),
    Video(202),
    MatchCreator(203),
    MusicArtist(10001),
    MusicBGM(10002),
    MusicUserClue(10003),
    MusicSongClue(10004),
    PlayletFeature(20001);

    private final int value;

    public int getValue() {
        return this.value;
    }

    static {
        Covode.recordClassIndex(613371);
    }

    public static ResourceType findByValue(int i) {
        if (i != 20001) {
            switch (i) {
                case 100:
                    return Writer;
                case 101:
                    return Contractor;
                case 102:
                    return Actor;
                default:
                    switch (i) {
                        case 200:
                            return IP;
                        case 201:
                            return Script;
                        case 202:
                            return Video;
                        case 203:
                            return MatchCreator;
                        default:
                            switch (i) {
                                case 10001:
                                    return MusicArtist;
                                case 10002:
                                    return MusicBGM;
                                case 10003:
                                    return MusicUserClue;
                                case 10004:
                                    return MusicSongClue;
                                default:
                                    return null;
                            }
                    }
            }
        }
        return PlayletFeature;
    }

    ResourceType(int i) {
        this.value = i;
    }
}
