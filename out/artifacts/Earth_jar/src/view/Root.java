package view;

import gov.nasa.worldwind.Configuration;
import gov.nasa.worldwind.layers.WorldMapLayer;
import gov.nasa.worldwind.util.Logging;
import gov.nasa.worldwindx.examples.ClickAndGoSelectListener;
import model.Facility;
import model.Satellite;
import name.gano.astro.AER;
import name.gano.astro.time.Time;
import util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @author Mohammad
 */
public class Root extends JFrame {

    /**
     * Creates new form root
     */
    public Root() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    static {
        try {
            String architecture = System.getProperty("os.arch");
            if ("x86".equals(architecture))
                System.loadLibrary("WebView32");
            else
                System.loadLibrary("WebView64");
        } catch (Throwable t) {
            String message = Logging.getMessage("WebView.ExceptionCreatingWebView", t);
            Logging.logger().severe(message);
        }

        Configuration.setValue(
                "gov.nasa.worldwind.avkey.DataFileStoreConfigurationFileName",
                "src/resource/CacheLocationConfiguration.xml");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        top = new javax.swing.JPanel();
        Go = new javax.swing.JButton();
        removeFacilityFromList = new javax.swing.JButton();
        runPassPrediction = new javax.swing.JButton();
        center = new javax.swing.JPanel();
        bottom = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        localTime = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        universalTime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        localDate = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        universalDate = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        left = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        facilityList = new javax.swing.JList<>();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        customeFacilityMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        CustomSatelliteMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        compassMenuItem = new javax.swing.JCheckBoxMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        worldMenuItem = new javax.swing.JCheckBoxMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        scaleMenuItem = new javax.swing.JCheckBoxMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        top.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        top.setPreferredSize(new java.awt.Dimension(701, 70));

        Go.setText("Go");
        Go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoActionPerformed(evt);
            }
        });

        removeFacilityFromList.setText("remove");
        removeFacilityFromList.setToolTipText("");
        removeFacilityFromList.setEnabled(false);
        removeFacilityFromList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFacilityFromListActionPerformed(evt);
            }
        });

        runPassPrediction.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        runPassPrediction.setForeground(new java.awt.Color(0, 51, 153));
        runPassPrediction.setText("Run");
        runPassPrediction.setToolTipText("");
        runPassPrediction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runPassPredictionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
                topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(topLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Go)
                                .addGap(18, 18, 18)
                                .addComponent(removeFacilityFromList)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                                .addComponent(runPassPrediction, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(448, Short.MAX_VALUE))
        );
        topLayout.setVerticalGroup(
                topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(topLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(topLayout.createSequentialGroup()
                                                .addGroup(topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(Go)
                                                        .addComponent(removeFacilityFromList))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(runPassPrediction, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(top, java.awt.BorderLayout.PAGE_START);

        bottom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("زمان محلی");

        localTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        localTime.setForeground(new java.awt.Color(0, 0, 102));
        localTime.setText("00:00:00");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("زمان جهانی");

        universalTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        universalTime.setForeground(new java.awt.Color(0, 0, 102));
        universalTime.setText("00:00:00");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("تاریخ محلی");

        localDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        localDate.setForeground(new java.awt.Color(0, 0, 102));
        localDate.setText("14/10/2016");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("تاریخ جهانی");

        universalDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        universalDate.setForeground(new java.awt.Color(51, 0, 102));
        universalDate.setText("14/10/2016");

        javax.swing.GroupLayout bottomLayout = new javax.swing.GroupLayout(bottom);
        bottom.setLayout(bottomLayout);
        bottomLayout.setHorizontalGroup(
                bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(universalDate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(localDate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(58, 58, 58)
                                .addComponent(universalTime)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(41, 41, 41)
                                .addComponent(localTime, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bottomLayout.setVerticalGroup(
                bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(localTime)
                                        .addComponent(jLabel2)
                                        .addComponent(universalTime)
                                        .addComponent(jLabel3)
                                        .addComponent(localDate)
                                        .addComponent(jLabel5)
                                        .addComponent(universalDate))
                                .addContainerGap())
        );

        jButton1.setText("jButton1");

        javax.swing.GroupLayout centerLayout = new javax.swing.GroupLayout(center);
        center.setLayout(centerLayout);
        centerLayout.setHorizontalGroup(
                centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(WWJUtil.getWwj(), javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
        );
        centerLayout.setVerticalGroup(
                centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, centerLayout.createSequentialGroup()
                                .addComponent(WWJUtil.getWwj(), javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(center, java.awt.BorderLayout.CENTER);

        left.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        facilityList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        facilityList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facilityListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(facilityList);

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
                leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );
        leftLayout.setVerticalGroup(
                leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        getContentPane().add(left, java.awt.BorderLayout.LINE_START);

        fileMenu.setText("File");

        newMenuItem.setText("NewFacility");
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newMenuItem);
        fileMenu.add(jSeparator3);

        customeFacilityMenuItem.setText("CustomFacility");
        customeFacilityMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customeFacilityMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(customeFacilityMenuItem);
        fileMenu.add(jSeparator4);

        CustomSatelliteMenuItem.setText("CustomSatellite");
        CustomSatelliteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomSatelliteMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(CustomSatelliteMenuItem);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");
        menuBar.add(editMenu);

        jMenu1.setText("view");

        compassMenuItem.setText("compass");
        compassMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compassMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(compassMenuItem);
        jMenu1.add(jSeparator1);

        worldMenuItem.setText("worldView");
        worldMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                worldMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(worldMenuItem);
        jMenu1.add(jSeparator2);

        scaleMenuItem.setText("Scale");
        scaleMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(scaleMenuItem);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>


/****************************************************************************************/
/*************************************** METHODS ****************************************/
/****************************************************************************************/
    Facility facility = null;

    private void GoActionPerformed(java.awt.event.ActionEvent evt) {
        GoDialog goDialog = new GoDialog(this, false);
        goDialog.setVisible(true);
    }

    private void scaleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBoxMenuItem scale = (JCheckBoxMenuItem) evt.getSource();
        if (scale.isSelected()) {
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getScaleLayer());
            WWJUtil.getWwj().addSelectListener(new ClickAndGoSelectListener(WWJUtil.getWwj(), WorldMapLayer.class));
        } else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getScaleLayer());
        }
    }

    private void worldMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBoxMenuItem scale = (JCheckBoxMenuItem) evt.getSource();
        if (scale.isSelected()) {
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getWorldMapLayer());
        } else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getWorldMapLayer());
        }
    }

    private void compassMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBoxMenuItem scale = (JCheckBoxMenuItem) evt.getSource();
        if (scale.isSelected()) {
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getCompassLayer());
        } else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getCompassLayer());
        }
    }

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            FacilityDialog facilityDialog = new FacilityDialog(this, true);
            EarthUtil.createFacilityTree();
            facilityDialog.setVisible(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "خطایی در پردازش شما رخ داده است.", "نا موفق", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void facilityListMouseClicked(java.awt.event.MouseEvent evt) {
        facility = ((JList<Facility>) evt.getSource()).getSelectedValue();
        if (evt.getClickCount() == 2) {
            FacilityPropertyDialog propertyDialog = new FacilityPropertyDialog(this, true);
            propertyDialog.setCurrentFacility(facility);
            propertyDialog.setVisible(true);
        } else if (evt.getClickCount() == 1) {
            WWJUtil.addFacilityToEarth(facility);
            removeFacilityFromList.setEnabled(true);
        }
    }

    private void customeFacilityMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        CreateFacilityDialog facilityDialog = new CreateFacilityDialog(this, true);
        facilityDialog.setVisible(true);
    }

    private void removeFacilityFromListActionPerformed(java.awt.event.ActionEvent evt) {
        if (facility != null) {
            FacilityDialog.getModel().remove(facilityList.getSelectedIndex());
            validate();
            repaint();
            doLayout();
        }
    }

    private void CustomSatelliteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        CreateSatelliteDialog createSatelliteDialog = new CreateSatelliteDialog(this, rootPaneCheckingEnabled);
        createSatelliteDialog.setVisible(true);
    }

    private void runPassPredictionActionPerformed(java.awt.event.ActionEvent evt) {
        if (facilityList.getModel().getSize() != 0) {
            try {
                passPrediction();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "خطایی در پردازش شما رخ داده است.", "نا موفق", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "طلفا تجهیزات خود را انتخاب کنید.", "نا موفق", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void passPrediction() throws Exception {
        int countFacilities = facilityList.getModel().getSize();
        ListModel<Facility> listModel = facilityList.getModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS z");
        Time currentJulianDate = new Time();
        currentJulianDate.setDateFormat(dateFormat);
        List<Satellite> satellites = EarthUtil.getSatellites();
        ResultDialog resultDialog = new ResultDialog(this, true);
        DefaultTableModel model = (DefaultTableModel) ResultDialog.resultTable.getModel();


        for (int index = 0; index < countFacilities; index++) {
            Facility facility = listModel.getElementAt(index);
            for (Satellite satellite : satellites) {
                if (satellite.getLength() >= facility.getLength() && satellite.getWidth() >= facility.getWidth()) {

                    // Define GroundStation
                    double[] lla = {facility.getLatitude(), facility.getLongitude(), 0};
                    GroundStation groundStation = new GroundStation("", lla, currentJulianDate.getJulianDate());
                    groundStation.setElevationConst(0);
                    groundStation.setStationName(facility.getDisplayName());

                    // Define AbstractSatellite by reading tle file
                    File file = new File("src/resource/tle/" + satellite.getTleFile());
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String satelliteName = bufferedReader.readLine();
                    String lineOne = bufferedReader.readLine();
                    String lineTwo = bufferedReader.readLine();
                    AbstractSatellite abstractSatellite = new SatelliteTleSGP4(satelliteName, lineOne, lineTwo);
                    abstractSatellite.setDisplayName(satelliteName);


                    Calendar startCalendar = EarthUtil.dateToCalendar(facility.getStartDate());
                    Time start = new Time(startCalendar.get(Calendar.YEAR),
                            startCalendar.get(Calendar.MONTH) + 1,
                            startCalendar.get(Calendar.DAY_OF_MONTH),
                            startCalendar.get(Calendar.HOUR_OF_DAY),
                            startCalendar.get(Calendar.MINUTE),
                            startCalendar.get(Calendar.SECOND));
                    start.setDateFormat(dateFormat);

                    double timeSpanDays = EarthUtil.daysBetween(facility.getStartDate(), facility.getEndDate());

                    runPassPrediction(timeSpanDays, groundStation, abstractSatellite, start, model);
                    resultDialog.setVisible(true);

                }
            }
        }
    }


    @SuppressWarnings("Duplicates")
    private void runPassPrediction(double timeSpanDays, GroundStation gs, AbstractSatellite sat,
                                   Time startJulianDate, DefaultTableModel model) {
        double timeStepSec = 60d;
        double jdStart = startJulianDate.getJulianDate();
        double time0, h0;
        double time1 = jdStart;
        double h1 = AER.calculate_AER(gs.getLla_deg_m(), sat.calculateTemePositionFromUT(time1), time1)[1] - gs.getElevationConst();
        double lastRise = 0;
        int row = -1;

        for (double jd = jdStart; jd <= jdStart + timeSpanDays; jd += timeStepSec / (60.0 * 60.0 * 24.0)) {
            time0 = time1;
            time1 = jd + timeStepSec / (60.0 * 60.0 * 24.0);
            h0 = h1;
            h1 = AER.calculate_AER(gs.getLla_deg_m(), sat.calculateTemePositionFromUT(time1), time1)[1] - gs.getElevationConst();
            // rise
            if (h0 <= 0 && h1 > 0) {
                double riseTime = findSatRiseSetRoot(sat, gs, time0, time1, h0, h1);
                lastRise = riseTime;
                String riseTimeStr = startJulianDate.convertJD2String(riseTime);
                model.addRow(new Object[]{gs.getStationName(), sat.getDisplayName(), riseTimeStr, null});
                row++;
            }

            // set
            if (h1 <= 0 && h0 > 0) {
                double setTime = findSatRiseSetRoot(sat, gs, time0, time1, h0, h1);
                String setTimeStr = startJulianDate.convertJD2String(setTime);
                // add duration
                if (lastRise > 0) {
                    DecimalFormat fmt2Dig = new DecimalFormat("00.000");

                    double duration = (setTime - lastRise) * 24.0 * 60.0 * 60.0; // seconds
                    String durStr = fmt2Dig.format(duration);
                    model.setValueAt(durStr, row, 3);
                }
            }


        }
    }

    @SuppressWarnings("Duplicates")
    private double findSatRiseSetRoot(AbstractSatellite sat, GroundStation gs, double time0, double time1, double f0, double f1) {
        double tol = (1.157407E-5) / 4;
        while (Math.abs(time1 - time0) > 2 * tol) {
            double timeMid = (time1 + time0) / 2.0;
            double fmid = AER.calculate_AER(gs.getLla_deg_m(), sat.calculateTemePositionFromUT(timeMid), timeMid)[1] - gs.getElevationConst();
            if (f0 * fmid > 0) {
                f0 = fmid;
                time0 = timeMid;

            } else {
                f1 = fmid;
                time1 = timeMid;
            }
        }
        double a = (f1 - f0) / (time1 - time0);
        double b = f1 - a * time1;
        return -b / a;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WWJUtil.createWWJ();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Root().setVisible(true);
            }
        });
    }

/*****************************************************************************/
/***************************** VARIABLES *************************************/
/*****************************************************************************/

    // Variables declaration - do not modify
    private javax.swing.JMenuItem CustomSatelliteMenuItem;
    private javax.swing.JButton Go;
    private javax.swing.JPanel bottom;
    private javax.swing.JPanel center;
    private javax.swing.JCheckBoxMenuItem compassMenuItem;
    private javax.swing.JMenuItem customeFacilityMenuItem;
    private javax.swing.JMenu editMenu;
    public static javax.swing.JList<Facility> facilityList;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPanel left;
    private javax.swing.JLabel localDate;
    private javax.swing.JLabel localTime;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JButton removeFacilityFromList;
    private javax.swing.JButton runPassPrediction;
    private javax.swing.JCheckBoxMenuItem scaleMenuItem;
    private javax.swing.JPanel top;
    private javax.swing.JLabel universalDate;
    private javax.swing.JLabel universalTime;
    private javax.swing.JCheckBoxMenuItem worldMenuItem;
    // End of variables declaration
}
