package bd.com.letsride.user.utilities;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class FontManager {
    private static FontManager instance;
    private static final Map<Integer, Typeface> fontMap = new HashMap<>();

    public static FontManager getInstance(Context context) {
        if (instance == null) {
            instance = new FontManager(context.getApplicationContext());
        }
        return instance;
    }

    private FontManager(Context context) {
        AssetManager am = context.getResources().getAssets();
        fontMap.put(Typeface.NORMAL, Typeface.createFromAsset(am, "fonts/ubuntu_regular.ttf"));
        fontMap.put(Typeface.BOLD, Typeface.createFromAsset(am, "fonts/ubuntu_bold.ttf"));
        fontMap.put(Typeface.ITALIC, Typeface.createFromAsset(am, "fonts/ubuntu_italic.ttf"));
        fontMap.put(Typeface.BOLD_ITALIC, Typeface.createFromAsset(am, "fonts/ubuntu_bold_italic.ttf"));
    }

    public void replaceFonts(ViewGroup viewTree) {
        View child;
        for (int i = 0; i < viewTree.getChildCount(); ++i) {
            child = viewTree.getChildAt(i);
            if (child instanceof ViewGroup) {
                replaceFonts((ViewGroup) child);
            } else if (child instanceof TextView) {
                TextView textView = (TextView) child;
                int style = textView.getTypeface().getStyle();

                if (style == Typeface.NORMAL) {
                    textView.setTypeface(fontMap.get(Typeface.NORMAL));
                } else if (style == Typeface.BOLD) {
                    textView.setTypeface(fontMap.get(Typeface.BOLD));
                } else if (style == Typeface.ITALIC) {
                    textView.setTypeface(fontMap.get(Typeface.ITALIC));
                } else if (style == Typeface.BOLD_ITALIC) {
                    textView.setTypeface(fontMap.get(Typeface.BOLD_ITALIC));
                }
            }
        }
    }
}

