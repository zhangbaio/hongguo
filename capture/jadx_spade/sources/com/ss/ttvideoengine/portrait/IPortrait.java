package com.ss.ttvideoengine.portrait;

import com.bytedance.covode.number.Covode;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public interface IPortrait {
    public static final IPortrait EMPTY;

    /* renamed from: com.ss.ttvideoengine.portrait.IPortrait$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getId(IPortrait iPortrait) {
            return 0;
        }
    }

    int getId();

    static {
        Covode.recordClassIndex(652603);
        EMPTY = new IPortrait() { // from class: com.ss.ttvideoengine.portrait.IPortrait.1
            @Override // com.ss.ttvideoengine.portrait.IPortrait
            public /* synthetic */ int getId() {
                return CC.$default$getId(this);
            }
        };
    }
}
