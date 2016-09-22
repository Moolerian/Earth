package util;

import view.FacilityDialog;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

/**
 * Created by Mohammad on 9/16/2016.
 */

public class EarthUtil {

    public static void createFacilitytree(){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("تجهیزات");

        DefaultMutableTreeNode installationParentNode = new DefaultMutableTreeNode("عوارض،امکانات،تاسیسات و سایت ها");
        installationParentNode.add(new DefaultMutableTreeNode("تاسیسات هسته ایی"));
        installationParentNode.add(new DefaultMutableTreeNode("پادگان،اماکن نظامی"));
        installationParentNode.add(new DefaultMutableTreeNode("خاکریز"));
        installationParentNode.add(new DefaultMutableTreeNode("انبار اسلحه"));
        installationParentNode.add(new DefaultMutableTreeNode("کارخانه جات"));
        installationParentNode.add(new DefaultMutableTreeNode("تاسیسات نمک زدایی آب"));
        installationParentNode.add(new DefaultMutableTreeNode("پالایشگاه ها"));
        installationParentNode.add(new DefaultMutableTreeNode("تاسیسات گازی"));
        installationParentNode.add(new DefaultMutableTreeNode("خطوط انتقال انرژی"));
        installationParentNode.add(new DefaultMutableTreeNode("مجموعه رادار"));
        installationParentNode.add(new DefaultMutableTreeNode("آنتن"));
        installationParentNode.add(new DefaultMutableTreeNode("مخازن سوخت"));
        installationParentNode.add(new DefaultMutableTreeNode("تجهیزات زمینی"));
        installationParentNode.add(new DefaultMutableTreeNode("تجهیزات زیر سطحی"));

        DefaultMutableTreeNode transmissionParentNode = new DefaultMutableTreeNode("حمل و نقل،مواصلات،ترابری");
        transmissionParentNode.add(new DefaultMutableTreeNode("نفر بر"));
        transmissionParentNode.add(new DefaultMutableTreeNode("تانک"));

        DefaultMutableTreeNode defensiveParentNode = new DefaultMutableTreeNode("مواضع دفاعی");
        defensiveParentNode.add(new DefaultMutableTreeNode("توپ"));
        defensiveParentNode.add(new DefaultMutableTreeNode("اژدر افکن"));

        DefaultMutableTreeNode marineParentNode = new DefaultMutableTreeNode("تجهیزات دریایی");
        marineParentNode.add(new DefaultMutableTreeNode("اسکله و سکوی نفتی"));
        marineParentNode.add(new DefaultMutableTreeNode("بنادر"));
        DefaultMutableTreeNode marineChildParentNode = new DefaultMutableTreeNode("کشتی");
        marineChildParentNode.add(new DefaultMutableTreeNode("نفتی"));
        marineChildParentNode.add(new DefaultMutableTreeNode("مسافر بری"));
        marineParentNode.add(marineChildParentNode);
        marineParentNode.add(new DefaultMutableTreeNode("پایگاه های دریایی"));

        DefaultMutableTreeNode aerialParentNode = new DefaultMutableTreeNode("تجهیزات هوایی");
        aerialParentNode.add(new DefaultMutableTreeNode("سامانه پدافند هوایی"));
        aerialParentNode.add(new DefaultMutableTreeNode("مخازن سوخت"));
        aerialParentNode.add(new DefaultMutableTreeNode("پایگاه نظامی"));
        DefaultMutableTreeNode aerialChildParentNode = new DefaultMutableTreeNode("هواپیماها");
        aerialChildParentNode.add(new DefaultMutableTreeNode("مسافربری"));
        aerialChildParentNode.add(new DefaultMutableTreeNode("نظامی"));
        aerialParentNode.add(aerialChildParentNode);
        aerialParentNode.add(new DefaultMutableTreeNode("فرودگاه ها"));
        aerialParentNode.add(new DefaultMutableTreeNode("شیلتر"));
        aerialParentNode.add(new DefaultMutableTreeNode("برج کنترل"));

        installationParentNode.add(new DefaultMutableTreeNode("تسلیحات موشکی"));
        installationParentNode.add(new DefaultMutableTreeNode("استعداد نیرو"));


        root.add(installationParentNode);
        root.add(transmissionParentNode);
        root.add(defensiveParentNode);
        root.add(marineParentNode);
        root.add(aerialParentNode);

        TreeModel treeModel = new DefaultTreeModel(root);
        FacilityDialog.facilityTree.setModel(treeModel);

    }

}
