package com.zhihu.matisse.internal.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.apm.agent.v2.instrumentation.ClickAgent;
import com.bytedance.covode.number.Covode;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.widget.DraweeViewTouch;
import fm6.d;
import it.sephiroth.android.library.imagezoom.ImageViewTouchBase;
import it.sephiroth.android.library.imagezoom.a;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class PreviewItemFragment extends Fragment {
    private fm6.a a;
    public com.zhihu.matisse.internal.entity.a b;

    static {
        Covode.recordClassIndex(656135);
    }

    public void onDetach() {
        super.onDetach();
        this.a = null;
    }

    class c implements a.c {
        @Override // it.sephiroth.android.library.imagezoom.a.c
        public void a() {
            if (PreviewItemFragment.this.a != null) {
                PreviewItemFragment.this.a.onClick();
            }
        }

        c() {
        }
    }

    public void yf() {
        if (getView() != null) {
            ((it.sephiroth.android.library.imagezoom.a) getView().findViewById(2131821118)).w();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ClickAgent.onClick(view);
            if (PreviewItemFragment.this.a != null) {
                PreviewItemFragment.this.a.onClick();
            }
        }
    }

    public class a implements View.OnClickListener {
        final /* synthetic */ Item a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar;
            ClickAgent.onClick(view);
            com.zhihu.matisse.internal.entity.a aVar = PreviewItemFragment.this.b;
            if (aVar != null && (dVar = aVar.q) != null) {
                dVar.a(this.a);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(this.a.uri, "video/*");
            try {
                PreviewItemFragment.this.startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                l3.a.A(PreviewItemFragment.this.getContext(), 2131104505, 0).show();
            }
        }

        a(Item item) {
            this.a = item;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof fm6.a) {
            this.a = (fm6.a) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
    }

    public static PreviewItemFragment xf(Item item, com.zhihu.matisse.internal.entity.a aVar) {
        PreviewItemFragment previewItemFragment = new PreviewItemFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("args_item", item);
        previewItemFragment.setArguments(bundle);
        previewItemFragment.b = aVar;
        return previewItemFragment;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Item item = (Item) getArguments().getParcelable("args_item");
        if (item == null) {
            return;
        }
        View findViewById = view.findViewById(2131835752);
        if (item.isVideo()) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new a(item));
        } else {
            findViewById.setVisibility(8);
        }
        DraweeViewTouch draweeViewTouch = (DraweeViewTouch) view.findViewById(2131821118);
        SimpleDraweeView findViewById2 = view.findViewById(2131826822);
        Uri compatUri = item.getCompatUri();
        Point c2 = em6.c.c(compatUri, getActivity());
        ImageRequest build = ImageRequestBuilder.newBuilderWithSource(compatUri).setResizeOptions(new ResizeOptions(c2.x, c2.y)).build();
        if (item.isGif()) {
            draweeViewTouch.setVisibility(4);
            findViewById2.setVisibility(0);
            findViewById2.setOnClickListener(new b());
            findViewById2.setController(Fresco.newDraweeControllerBuilder().setOldController(findViewById2.getController()).setImageRequest(build).setAutoPlayAnimations(true).build());
            return;
        }
        draweeViewTouch.setVisibility(0);
        findViewById2.setVisibility(4);
        draweeViewTouch.setDisplayType(ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        draweeViewTouch.setSingleTapListener(new c());
        draweeViewTouch.setImageRequest(build);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131036368, viewGroup, false);
    }
}
