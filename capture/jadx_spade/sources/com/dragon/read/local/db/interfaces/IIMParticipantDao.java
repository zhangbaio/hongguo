package com.dragon.read.local.db.interfaces;

import com.dragon.read.local.db.entity.IMParticipant;
import java.util.List;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface IIMParticipantDao {
    void deleteAllParticipant(String str);

    void deleteParticipant(String str, String str2);

    void deleteParticipant(String str, List<String> list);

    void insertOrReplaceParticipant(IMParticipant iMParticipant);

    void insertOrReplaceParticipant(List<IMParticipant> list);

    List<IMParticipant> queryAllParticipant(String str);

    IMParticipant queryParticipant(String str, String str2);

    List<IMParticipant> queryParticipant(String str, List<String> list);
}
