package com.vivo.push;

import android.content.Intent;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IPushClientFactory {
    com.vivo.push.h.ab createReceiveTask(v vVar);

    v createReceiverCommand(Intent intent);

    s createTask(v vVar);
}
