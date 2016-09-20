package view;

import gov.nasa.worldwind.layers.WorldMapLayer;
import gov.nasa.worldwindx.examples.ClickAndGoSelectListener;
import util.WWJUtil;

import javax.swing.*;

/**
 * @author Mohammad
 */
public class Root extends JFrame {

    /**
     * Creates new form root
     */
    public Root() {
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        top = new javax.swing.JPanel();
        Go = new javax.swing.JButton();
        center = new javax.swing.JPanel();
        bottom = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        left = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        facilityList = new javax.swing.JList<>();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        compassMenuItem = new javax.swing.JCheckBoxMenuItem();
        worldMenuItem = new javax.swing.JCheckBoxMenuItem();
        scaleMenuItem = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        top.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        top.setPreferredSize(new java.awt.Dimension(701, 70));

        Go.setText("Go");
        Go.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topLayout = new javax.swing.GroupLayout(top);
        top.setLayout(topLayout);
        topLayout.setHorizontalGroup(
                topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(topLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Go)
                                .addContainerGap(1012, Short.MAX_VALUE))
        );
        topLayout.setVerticalGroup(
                topLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(topLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Go)
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(top, java.awt.BorderLayout.PAGE_START);

        bottom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout bottomLayout = new javax.swing.GroupLayout(bottom);
        bottom.setLayout(bottomLayout);
        bottomLayout.setHorizontalGroup(
                bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 950, Short.MAX_VALUE)
        );
        bottomLayout.setVerticalGroup(
                bottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 36, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        javax.swing.GroupLayout centerLayout = new javax.swing.GroupLayout(center);
        center.setLayout(centerLayout);
        centerLayout.setHorizontalGroup(
                centerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(WWJUtil.getWwj(), javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        facilityList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        facilityList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        facilityList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facilityListMouseClicked(evt);
            }
        });
        facilityList.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                facilityListFocusGained(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );

        getContentPane().add(left, java.awt.BorderLayout.LINE_START);

        fileMenu.setText("File");

        newMenuItem.setText("new");
        newMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newMenuItem);

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

        worldMenuItem.setText("worldView");
        worldMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                worldMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(worldMenuItem);

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

    private void GoActionPerformed(java.awt.event.ActionEvent evt) {
        GoDialog goDialog = new GoDialog(this,false);
        goDialog.setVisible(true);
    }

    private void scaleMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBoxMenuItem scale = (JCheckBoxMenuItem) evt.getSource();
        if(scale.isSelected()){
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getScaleLayer());
            WWJUtil.getWwj().addSelectListener(new ClickAndGoSelectListener( WWJUtil.getWwj(), WorldMapLayer.class));
        }else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getScaleLayer());
        }
    }

    private void worldMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBoxMenuItem scale = (JCheckBoxMenuItem) evt.getSource();
        if(scale.isSelected()){
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getWorldMapLayer());
        }else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getWorldMapLayer());
        }
    }

    private void compassMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        JCheckBoxMenuItem scale = (JCheckBoxMenuItem) evt.getSource();
        if(scale.isSelected()){
            WWJUtil.getWwj().getModel().getLayers().add(WWJUtil.getCompassLayer());
        }else {
            WWJUtil.getWwj().getModel().getLayers().remove(WWJUtil.getCompassLayer());
        }
    }

    private void newMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        FacilityDialog facilityDialog = new FacilityDialog(this,true);
        facilityDialog.setVisible(true);
    }

    private void facilityListFocusGained(java.awt.event.FocusEvent evt) {
        WWJUtil.addFacilityToEarth();
    }

    private void facilityListMouseClicked(java.awt.event.MouseEvent evt) {
        if(evt.getClickCount()==2){
           // TODO show facility properties dialog
        }
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
    private javax.swing.JButton Go;
    private javax.swing.JPanel bottom;
    private javax.swing.JPanel center;
    private javax.swing.JCheckBoxMenuItem compassMenuItem;
    private javax.swing.JMenu editMenu;
    public static javax.swing.JList<String> facilityList;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel left;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newMenuItem;
    private javax.swing.JCheckBoxMenuItem scaleMenuItem;
    private javax.swing.JPanel top;
    private javax.swing.JCheckBoxMenuItem worldMenuItem;
    // End of variables declaration
}
