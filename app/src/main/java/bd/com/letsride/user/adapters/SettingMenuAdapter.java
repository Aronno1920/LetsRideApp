package bd.com.letsride.user.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bd.com.letsride.user.R;
import bd.com.letsride.user.models.SettingMenuModel;
import bd.com.letsride.user.utilities.DrawableUtility;

public class SettingMenuAdapter extends ArrayAdapter<SettingMenuModel> {

    Context sContext;
    TextView tvMenuTitle, tvMenuSubtitle;
    ImageView menuLogo, menuSubMenu;
    LinearLayout llSingleMenu;
    List<SettingMenuModel> myMenuList = new ArrayList<SettingMenuModel>();

    public SettingMenuAdapter(Context context, List<SettingMenuModel> menus) {
        super(context, R.layout.layout_setting_menu, menus);
        myMenuList = menus;
        sContext = context;
    }

    @Override
    public View getView(int position, View singleView, ViewGroup parent) {
        SettingMenuModel aMenu = getItem(position);

        singleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_setting_menu, parent, false);
        tvMenuTitle = (TextView) singleView.findViewById(R.id.TextView_MenuTitle);
        tvMenuSubtitle = (TextView) singleView.findViewById(R.id.TextView_MenuSubTitle);
        menuLogo = (ImageView) singleView.findViewById(R.id.ImageView_MenuIcon);
        menuSubMenu = (ImageView) singleView.findViewById(R.id.ImageView_SubMenu);
        llSingleMenu = (LinearLayout) singleView.findViewById(R.id.LinerLayout_Single_Menu);

        tvMenuTitle.setText(aMenu.getMenuTitle());
        tvMenuSubtitle.setText(aMenu.getMenuSubTitle());
        if(aMenu.getLogoName().length()>2)
        {
            menuLogo.setImageDrawable(DrawableUtility.getDrawableByName(aMenu.getLogoName(),getContext()));
        }
        if (!aMenu.getSubMenu()) {
            menuSubMenu.setVisibility(View.INVISIBLE);
        }

        return singleView;
    }
}
