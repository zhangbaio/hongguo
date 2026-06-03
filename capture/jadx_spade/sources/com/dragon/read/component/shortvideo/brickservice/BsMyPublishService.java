package com.dragon.read.component.shortvideo.brickservice;

import com.bytedance.covode.number.Covode;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.dragon.read.base.AbsFragment;
import com.dragon.read.component.shortvideo.album.AbsMineAlbumListFragment;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public interface BsMyPublishService extends IService {
    public static final a Companion;

    static {
        Covode.recordClassIndex(598984);
        Companion = a.a;
    }

    AbsFragment getUserWorks3ColumnFragment();

    AbsFragment getUserWorksFragment();

    boolean isUserWork2Column();

    boolean isVideoUploadFailed();

    boolean isVideoUploading();

    AbsMineAlbumListFragment mineAlbumListFragment();

    AbsFragment myPlayletCommentListFragment();

    void scrollToTargetItem(String str, AbsFragment absFragment);

    public static final class a {
        static final /* synthetic */ a a;
        private static final BsMyPublishService b;

        private a() {
        }

        public final BsMyPublishService a() {
            return b;
        }

        static {
            Covode.recordClassIndex(598985);
            a = new a();
            b = (BsMyPublishService) ServiceManager.getService(BsMyPublishService.class);
        }
    }
}
