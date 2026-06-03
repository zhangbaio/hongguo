package cm6;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.bytedance.covode.number.Covode;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.zhihu.matisse.internal.entity.Album;

/* loaded from: D:\code\hongguo\capture\classes16.dex */
public class b extends CursorAdapter {
    private final Drawable a;

    static {
        Covode.recordClassIndex(656143);
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(2131034375, viewGroup, false);
    }

    public b(Context context, Cursor cursor, boolean z) {
        super(context, cursor, z);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{2130772787});
        this.a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        Album valueOf = Album.valueOf(cursor);
        ((TextView) view.findViewById(2131821533)).setText(valueOf.getDisplayName(context));
        ((TextView) view.findViewById(2131821532)).setText(String.valueOf(valueOf.getCount()));
        SimpleDraweeView findViewById = view.findViewById(2131821527);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131493604);
        ImageRequest build = ImageRequestBuilder.newBuilderWithSource(valueOf.getCompatUri()).setResizeOptions(new ResizeOptions(dimensionPixelSize, dimensionPixelSize)).build();
        GenericDraweeHierarchy hierarchy = findViewById.getHierarchy();
        if (hierarchy == null) {
            hierarchy = new GenericDraweeHierarchyBuilder(context.getResources()).build();
        }
        hierarchy.setPlaceholderImage(this.a);
        findViewById.setHierarchy(hierarchy);
        findViewById.setImageRequest(build);
    }
}
