package com.dragon.read.component.shortvideo;

import com.bytedance.covode.number.Covode;
import com.dragon.read.ab.UserWork2Column;
import com.dragon.read.base.AbsFragment;
import com.dragon.read.component.shortvideo.album.AbsMineAlbumListFragment;
import com.dragon.read.component.shortvideo.brickservice.BsMyPublishService;
import com.dragon.read.component.shortvideo.impl.album.MineAlbumListFragment;
import com.dragon.read.component.shortvideo.impl.playletcomment.MyPlayletCommentListFragment;
import com.dragon.read.component.shortvideo.impl.userworks.UserWorks3ColumnFragment;
import com.dragon.read.component.shortvideo.impl.userworks.UserWorksFragment;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: D:\code\hongguo\capture\classes6.dex */
public final class BsMyPublishServiceImpl implements BsMyPublishService {
    public static final int $stable = 0;

    static {
        Covode.recordClassIndex(598099);
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMyPublishService
    public AbsFragment getUserWorks3ColumnFragment() {
        return new UserWorks3ColumnFragment();
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMyPublishService
    public AbsFragment getUserWorksFragment() {
        return new UserWorksFragment();
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMyPublishService
    public boolean isVideoUploadFailed() {
        return UserWorksFragment.V3.b();
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMyPublishService
    public boolean isVideoUploading() {
        return UserWorksFragment.V3.c();
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMyPublishService
    public AbsMineAlbumListFragment mineAlbumListFragment() {
        return new MineAlbumListFragment();
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMyPublishService
    public AbsFragment myPlayletCommentListFragment() {
        return new MyPlayletCommentListFragment();
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMyPublishService
    public boolean isUserWork2Column() {
        return UserWork2Column.a.c().enable;
    }

    @Override // com.dragon.read.component.shortvideo.brickservice.BsMyPublishService
    public void scrollToTargetItem(String itemId, AbsFragment absFragment) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        if (!(absFragment instanceof UserWorksFragment)) {
            return;
        }
        ((UserWorksFragment) absFragment).Ok(itemId);
    }
}
