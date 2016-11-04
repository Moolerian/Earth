package util;

import com.ibm.icu.util.*;
import gov.nasa.worldwind.Configuration;
import gov.nasa.worldwind.util.Logging;
import model.Facility;
import model.Satellite;
import org.joda.time.DateTime;
import view.FacilityDialog;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.Calendar;

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

    //Convert Date to Calendar
    public static Calendar dateToCalendar(java.util.Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;

    }

    public static String convertJulianToPersianForUi(java.util.Date date) {
        if (date == null) {
            return "";
        }
        com.ibm.icu.util.Calendar calendar = j2p(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return year + "/" + (month + 1) + "/" + day;

    }

    public static java.util.Date convertPersianToJulian(String persianDate) {
        String[] parts = persianDate.split("[/-]");
        return convertPersianToJulian(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[2]));
    }

    public static String convertJulianToPersian(java.util.Date date) {
        return convertJulianToPersian(date, "EEEE d MMMM y");
    }

    public static String convertJulianToPersian(java.util.Date date, String format) {
        if (date == null) {
            return "";
        }
        com.ibm.icu.util.Calendar calendar = j2p(date);

        com.ibm.icu.util.ULocale uLocale = com.ibm.icu.util.ULocale.createCanonical("fa_IR");
        com.ibm.icu.text.SimpleDateFormat sdf = (com.ibm.icu.text.SimpleDateFormat) calendar.getDateTimeFormat(0, 0, uLocale);
        sdf.applyPattern(format);
        return sdf.format(calendar.getTime());
    }

    private static java.util.Date convertPersianToJulian(int year, int month, int day_of_month) {

        com.ibm.icu.util.Calendar calendar = p2j(year, month, day_of_month);
        return new DateTime(calendar.getTimeInMillis()).toDate();
    }

    private static com.ibm.icu.util.Calendar p2j(int year, int month, int day_of_month) {
        String timeZoneId = "Iran";
        String loc = "fa_IR";

        com.ibm.icu.util.TimeZone timeZone = com.ibm.icu.util.TimeZone.getTimeZone(timeZoneId);
        com.ibm.icu.util.ULocale uLocale = com.ibm.icu.util.ULocale.createCanonical(loc);
        com.ibm.icu.util.Calendar calendar = new com.ghasemkiani.util.icu.PersianCalendar(timeZone, uLocale);

        calendar.set(com.ibm.icu.util.Calendar.YEAR, year);
        calendar.set(com.ibm.icu.util.Calendar.MONTH, month);
        calendar.set(com.ibm.icu.util.Calendar.DAY_OF_MONTH, day_of_month);

        return clearTime(calendar);
    }

    private static com.ibm.icu.util.Calendar clearTime(com.ibm.icu.util.Calendar calendar) {
        calendar.set(com.ibm.icu.util.Calendar.HOUR_OF_DAY, 0);
        calendar.set(com.ibm.icu.util.Calendar.MINUTE, 0);
        calendar.set(com.ibm.icu.util.Calendar.SECOND, 0);
        calendar.set(com.ibm.icu.util.Calendar.MILLISECOND, 0);
        return calendar;
    }


    private static com.ibm.icu.util.Calendar j2p(java.util.Date date) {
        if (date == null) {
            return null;
        }
        String timeZoneId = "Iran";
        String loc = "fa_IR";

        com.ibm.icu.util.TimeZone timeZone = com.ibm.icu.util.TimeZone.getTimeZone(timeZoneId);
        com.ibm.icu.util.ULocale uLocale = com.ibm.icu.util.ULocale.createCanonical(loc);
        com.ibm.icu.util.Calendar calendar = new com.ghasemkiani.util.icu.PersianCalendar(timeZone, uLocale);
        calendar.setTimeInMillis(new DateTime(date).getMillis());
        return calendar;
    }




}
