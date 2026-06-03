package com.dragon.read.nps;

import com.dragon.read.rpc.model.UserResearchData;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface INpsViewProxy {

    public interface IOnSelectChanged {
        void onChanged(int i);
    }

    void setClickSelectUIChangeEnable(boolean z);

    void setCurrentIndex(int i);

    void setOnSelectChangedListener(IOnSelectChanged iOnSelectChanged);

    void setTouchEnable(boolean z);

    void updateData(UserResearchData userResearchData);

    void updateTheme(int i);
}
