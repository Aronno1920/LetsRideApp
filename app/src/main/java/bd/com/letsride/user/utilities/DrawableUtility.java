package bd.com.letsride.user.utilities;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class DrawableUtility {
    public static Drawable getDrawableByName(String name, Context context) {
        int drawableResource = context.getResources().getIdentifier(name, "drawable", context.getPackageName());
        if (drawableResource == 0) {
            throw new RuntimeException("Can't find drawable with name: " + name);
        }//w  w  w  .j  ava  2 s  .co  m
        return context.getResources().getDrawable(drawableResource);
    }

}
