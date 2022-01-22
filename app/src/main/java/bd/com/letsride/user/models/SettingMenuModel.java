package bd.com.letsride.user.models;

public class SettingMenuModel {
    private Integer MenuId;
    private String MenuTitle;
    private String MenuSubTitle;
    private String LogoName;
    private Boolean IsSubMenu;

    public SettingMenuModel(Integer menuId, String menuTitle, String menuSubTitle, String logoName, Boolean isSubMenu) {
        MenuId = menuId;
        MenuTitle = menuTitle;
        MenuSubTitle = menuSubTitle;
        LogoName = logoName;
        IsSubMenu = isSubMenu;
    }

    public Integer getMenuId() {
        return MenuId;
    }

    public void setMenuId(Integer menuId) {
        MenuId = menuId;
    }

    public String getMenuTitle() {
        return MenuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        MenuTitle = menuTitle;
    }

    public String getMenuSubTitle() {
        return MenuSubTitle;
    }

    public void setMenuSubTitle(String menuSubTitle) {
        MenuSubTitle = menuSubTitle;
    }

    public String getLogoName() {
        return LogoName;
    }

    public void setLogoName(String logoName) {
        LogoName = logoName;
    }

    public Boolean getSubMenu() {
        return IsSubMenu;
    }

    public void setSubMenu(Boolean subMenu) {
        IsSubMenu = subMenu;
    }
}
