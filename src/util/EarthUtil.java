package util;

import model.Facility;
import model.Satellite;
import view.FacilityDialog;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by Mohammad on 9/16/2016.
 */

public class EarthUtil {


    public static void createFacilityTree() {
        HierarchyTreeModel root = new HierarchyTreeModel("تجهیزات");

        List<Facility> parents = getParents();
        for (Facility facility : parents) {
            HierarchyTreeModel parentNode = new HierarchyTreeModel(facility);
            parentNode.setLeaf(false);
            addNode(parentNode, facility);
            root.add(parentNode);
        }

        TreeModel treeModel = new DefaultTreeModel(root);
        FacilityDialog.facilityTree.setModel(treeModel);
    }

    private static void addNode(HierarchyTreeModel treeNode, Facility parent) {
        List<Facility> children = getByParentId(parent.getId());
        HierarchyTreeModel node;
        for (Facility facility : children) {
            node = new HierarchyTreeModel(facility);
            if (facility.isParent()) {
                addNode(node, facility);
                node.setLeaf(false);
                treeNode.add(node);
            } else {
                node.setLeaf(true);
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
    public static List<Facility> getAllIsParents() {
        Connection connection = connectDB();
        Statement statement;
        List<Facility> facilities = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM facility where isParent = 1");
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
    public static boolean addFacility(Facility toBeInserted) {
        Connection connection = connectDB();
        PreparedStatement statement;
        Long maxId = 0L;
        boolean succeed = false;
        try {
            statement = connection.prepareStatement("SELECT max(id) AS id FROM facility");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                maxId = resultSet.getLong("id");
            }

            String sql = "INSERT INTO facility (id, displayName, isParent, parentId) VALUES (?, ?, ?, ?)";

            statement = connection.prepareStatement(sql);
            statement.setLong(1, maxId + 1);
            statement.setString(2, toBeInserted.getDisplayName());
            statement.setBoolean(3, toBeInserted.isParent());
            statement.setLong(4, toBeInserted.getParentId());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
                succeed = true;
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return succeed;
    }

    @SuppressWarnings({"SqlNoDataSourceInspection", "Duplicates", "SqlDialectInspection"})
    public static boolean addSatellite(Satellite toBeInserted) {
        Connection connection = connectDB();
        PreparedStatement statement;
        Long maxId = 0L;
        boolean succeed = false;
        try {
            statement = connection.prepareStatement("SELECT max(id) AS id FROM satellite");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                maxId = resultSet.getLong("id");
            }

            String sql = "INSERT INTO satellite (id, displayName, tleFile, width,length) VALUES (?, ?, ?, ? , ?)";

            statement = connection.prepareStatement(sql);
            statement.setLong(1, maxId + 1);
            statement.setString(2, toBeInserted.getDisplayName());
            statement.setString(3, toBeInserted.getTleFile());
            statement.setLong(4, toBeInserted.getWidth());
            statement.setLong(5, toBeInserted.getLength());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("A new user was inserted successfully!");
                succeed = true;
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return succeed;
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

    public static List<Satellite> getSatellites() {
        Connection connection = connectDB();
        Statement statement;
        List<Satellite> satellites = new ArrayList<>();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM satellite");
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String displayName = resultSet.getString("displayName");
                String tleFile = resultSet.getString("tleFile");
                Long width = resultSet.getLong("width");
                Long length = resultSet.getLong("length");

                Satellite satellite = new Satellite(id,displayName,tleFile,width,length);
                satellites.add(satellite);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return satellites;
    }

    public static int daysBetween(java.util.Date d1, java.util.Date d2) {
        return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

}
