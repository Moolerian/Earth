package util;

import model.Facility;
import view.FacilityDialog;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohammad on 9/16/2016.
 */

public class EarthUtil {


    public static void createFacilityTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("تجهیزات");

        List<Facility> parents = getParents();
        for (Facility facility : parents) {
            DefaultMutableTreeNode parentNode = new DefaultMutableTreeNode(facility);
            addNode(parentNode,facility);
            root.add(parentNode);
        }
        TreeModel treeModel = new DefaultTreeModel(root);
        FacilityDialog.facilityTree.setModel(treeModel);
    }

    private static void addNode(DefaultMutableTreeNode treeNode, Facility parent) {
        List<Facility> children = getByParentId(parent.getId());
        DefaultMutableTreeNode node;
        for(Facility facility : children){
            node = new DefaultMutableTreeNode(facility);
            if(facility.isParent()){
                addNode(node,facility);
                treeNode.add(node);
            }else {
                treeNode.add(node);
            }
        }
    }

    private static Connection connectDB() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:database.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return c;
    }

    @SuppressWarnings({"SqlNoDataSourceInspection", "Duplicates", "SqlDialectInspection"})
    private static List<Facility> getParents() {
        Connection connection = connectDB();
        Statement statement;
        List<Facility> facilities = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM facility WHERE parentId=''");
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String displayName = resultSet.getString("displayName");
                boolean isParent = resultSet.getBoolean("isParent");
                Long parentId = resultSet.getLong("parentId");
                Facility facility = new Facility(id, displayName, isParent, parentId);
                facilities.add(facility);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return facilities;
    }

    @SuppressWarnings({"SqlNoDataSourceInspection", "Duplicates", "SqlDialectInspection"})
    private static List<Facility> getByParentId(Long parent) {
        Connection connection = connectDB();
        String selectSQL = "SELECT * FROM facility WHERE parentId=?";
        List<Facility> facilities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setLong(1, parent);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String displayName = resultSet.getString("displayName");
                boolean isParent = resultSet.getBoolean("isParent");
                Long parentId = resultSet.getLong("parentId");
                Facility facility = new Facility(id, displayName, isParent, parentId);
                facilities.add(facility);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return facilities;
    }

}
