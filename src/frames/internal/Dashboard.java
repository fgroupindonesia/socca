package frames.internal;

import data.CurrentUser;
import data.PostEntry;
import frames.MainFrame;
import data.User;
import data.controller.DBOperations;
import helper.ui.Opener;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Timer;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.DefaultCaret;
import runner.Poster;

/**
 * this is the Dashboard frame
 *
 * @author (c) www.fgroupindonesia.com
 *
 */
public class Dashboard extends javax.swing.JInternalFrame {

    private static boolean selectAllStat = false;
    private static final String TEXT_EXECUTE = "EXECUTE", TEXT_STOP = "STOP";
    private static DefaultCaret caret;
    private static Poster timerTask = null;
    private Cursor kursorTangan = null, kursorBiasa = null;

    /**
     * Creates new form Dashboard
     */
    public Dashboard(User obUser) {
        initComponents();
        panelsplit_bottom.setEnabled(false);
        caret = (DefaultCaret) textarea_console.getCaret();
        prepareTableColoring();
        kursorTangan = new Cursor(Cursor.HAND_CURSOR);
        kursorBiasa = new Cursor(Cursor.DEFAULT_CURSOR);
    }

    private void prepareTableColoring() {
        table_dataContainer.setDefaultRenderer(Object.class, new TableCellRenderer() {
            private DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                // stripped color effects
                if (row % 2 == 0) {
                    c.setBackground(Color.LIGHT_GRAY);
                } else {
                    c.setBackground(Color.WHITE);
                }

                if (isSelected) {
                    c.setBackground(table.getSelectionBackground());
                    c.setForeground(table.getBackground());
                }

                if (value != null) {
                    if (value.equals("waiting")) {
                        c.setForeground(Color.RED);
                        ((JLabel) c).setFont(new java.awt.Font("Tahoma", 1, 14));
                    } else if (value.equals("success")) {
                        // bold
                        c.setForeground(Color.BLUE);
                        ((JLabel) c).setFont(new java.awt.Font("Tahoma", 1, 14));
                    } else if (value.equals("View Image")) {
                        ((JLabel) c).setText("<html><u>" + value + "</u></html>");

                    } else {
                        c.setForeground(Color.BLACK);
                    }
                }

                //Add below code here
                return c;
            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        labelTimer = new javax.swing.JLabel();
        btn_allSelection = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_execute = new javax.swing.JToggleButton();
        jSplitPane2 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_dataContainer = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        panelsplit_bottom = new javax.swing.JSplitPane();
        scrollPanel = new javax.swing.JScrollPane();
        textarea_console = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setClosable(true);
        setResizable(true);
        setTitle("Dashboard");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        labelTimer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTimer.setForeground(new java.awt.Color(255, 255, 255));
        labelTimer.setText("Timer : 00:00");
        labelTimer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(labelTimer);

        btn_allSelection.setBackground(new java.awt.Color(204, 255, 0));
        btn_allSelection.setText("Select All");
        btn_allSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_allSelectionActionPerformed(evt);
            }
        });
        jPanel2.add(btn_allSelection);

        btn_add.setBackground(new java.awt.Color(204, 255, 0));
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel2.add(btn_add);

        btn_edit.setBackground(new java.awt.Color(204, 255, 0));
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jPanel2.add(btn_edit);

        btn_delete.setBackground(new java.awt.Color(204, 255, 0));
        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel2.add(btn_delete);

        btn_execute.setBackground(new java.awt.Color(204, 255, 0));
        btn_execute.setText("Execute");
        btn_execute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_executeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_execute);

        getContentPane().add(jPanel2, java.awt.BorderLayout.NORTH);

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        table_dataContainer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "-", "Title", "Message", "Social Media(s)", "Attachment", "Status", "Last Posted"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_dataContainer.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                table_dataContainerMouseMoved(evt);
            }
        });
        table_dataContainer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dataContainerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table_dataContainerMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(table_dataContainer);
        if (table_dataContainer.getColumnModel().getColumnCount() > 0) {
            table_dataContainer.getColumnModel().getColumn(0).setMinWidth(25);
            table_dataContainer.getColumnModel().getColumn(0).setPreferredWidth(25);
            table_dataContainer.getColumnModel().getColumn(0).setMaxWidth(25);
        }
        table_dataContainer.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                preparePostEntryData();
            }
        });

        jPanel3.add(jScrollPane1);

        jSplitPane2.setLeftComponent(jPanel3);

        jPanel1.setPreferredSize(new java.awt.Dimension(10, 45));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        panelsplit_bottom.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        textarea_console.setColumns(20);
        textarea_console.setRows(5);
        scrollPanel.setViewportView(textarea_console);

        panelsplit_bottom.setBottomComponent(scrollPanel);

        jLabel2.setText("Output : ");
        panelsplit_bottom.setLeftComponent(jLabel2);

        jPanel1.add(panelsplit_bottom);

        jSplitPane2.setRightComponent(jPanel1);

        getContentPane().add(jSplitPane2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        openAddPost();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed

        openEditPost();

    }//GEN-LAST:event_btn_editActionPerformed

    public static void openAddPost() {
        Opener.showPostFrame(Opener.NEW_FORM);
    }

    public static void openEditPost() {

        if (postEntryRef != null) {
            Opener.setData(postEntryRef);
            Opener.showPostFrame(Opener.EDIT_FORM);
        } else {
            JOptionPane.showMessageDialog(null, "Choose the data first before clicking edit button!", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        refreshTable();
        //writeToConsole("Database successfully reloaded! Found " + table_dataContainer.getRowCount() + " data.");

    }//GEN-LAST:event_formInternalFrameActivated

    private static void clearTable() {
        DefaultTableModel dfm = (DefaultTableModel) table_dataContainer.getModel();
        dfm.setNumRows(0);
    }

    public static void refreshTable() {
        clearTable();

        ArrayList allDatas = DBOperations.getAllPosts();

        for (Object raw : allDatas) {
            PostEntry dPost = (PostEntry) raw;
            addNewPost(dPost);
        }

    }

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        deleteSelectedPost();
    }//GEN-LAST:event_btn_deleteActionPerformed

    public static void deleteSelectedPost() {

        int indexRows[];

        if (table_dataContainer.getSelectedRowCount() > 0) {

            indexRows = table_dataContainer.getSelectedRows();

            for (int x : indexRows) {
                // delete by its ID number appeared
                int dataNum = Integer.parseInt(table_dataContainer.getValueAt(x, 0).toString());
                DBOperations.deletePost(dataNum);
            }

            DefaultTableModel dfm = (DefaultTableModel) table_dataContainer.getModel();

            for (int y = indexRows.length - 1; y > -1; y--) {
                int nomor = indexRows[y];
                dfm.removeRow(nomor);
            }

            writeToConsole("about " + indexRows.length + " data has been removed!");

        } else {
            writeToConsole("no data has been selected. Delete Operation is cancelled.");
        }

    }

    private static void addNewPost(PostEntry anewData) {
        DefaultTableModel defaultTabMod = (DefaultTableModel) table_dataContainer.getModel();
        Vector<Object> dataForTable = new Vector<Object>();

        dataForTable.add(anewData.getId());
        dataForTable.add(anewData.getTitle());
        dataForTable.add(anewData.getMessage());
        dataForTable.add(anewData.getSocialMediaProfileActive());

        if (anewData.getAttachmentFile() != null) {
            dataForTable.add("View Image");
        } else {
            dataForTable.add("Empty");
        }

        dataForTable.add(anewData.getStatus());
        dataForTable.add(anewData.getLastPosted());

        defaultTabMod.addRow(dataForTable);

    }

    private void btn_allSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_allSelectionActionPerformed
        selectAll();
    }//GEN-LAST:event_btn_allSelectionActionPerformed

    public static void selectAll() {

        if (selectAllStat == false) {
            btn_allSelection.setText("De-select All");
            selectAllStat = true;
            table_dataContainer.setRowSelectionInterval(0, table_dataContainer.getModel().getRowCount() - 1);
        } else {
            btn_allSelection.setText("Select All");
            selectAllStat = false;
            table_dataContainer.clearSelection();
        }

    }

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

        MainFrame.setLoginMenu(true);
        MainFrame.setSettingMenu(false);
        MainFrame.setControlMenu(false);

    }//GEN-LAST:event_formInternalFrameClosed

    private void btn_executeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_executeActionPerformed
        executeOrStop();
    }//GEN-LAST:event_btn_executeActionPerformed

    public static void executeOrStop() {

        if (btn_execute.getText().equalsIgnoreCase(TEXT_EXECUTE)) {
            lockAllButtons(true);
            // start execution...

            CurrentUser.stopExecution = false;

            //running timer task as daemon thread
            Timer timer = new Timer(true);
            timerTask = new Poster(timer, 0, labelTimer);
            timerTask.run();

            CurrentUser.addExecution(timer);
        } else {
            lockAllButtons(false);
            // stop execution...

            CurrentUser.stopExecution = true;

            if (timerTask != null) {
                timerTask.cancel();
                CurrentUser.stopAllExecution();
            }

        }

    }

    private void table_dataContainerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dataContainerMouseClicked
        // TODO add your handling code here:
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = source.columnAtPoint(evt.getPoint());

        if (column == 4) {
            //JOptionPane.showMessageDialog(this, "A");
            // get the image from db
            int nomer = Integer.parseInt(source.getValueAt(row, 0).toString());
            PostEntry data = DBOperations.getPost(nomer);

            if (data.getAttachmentFile() != null) {
                showAttachmentPreview(data.getAttachmentFile());
            }

        }


    }//GEN-LAST:event_table_dataContainerMouseClicked

    private void showAttachmentPreview(String alamatGambar) {
        Opener.showAttachmentPreviewFrame(alamatGambar);
    }

    private void table_dataContainerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dataContainerMouseEntered

    }//GEN-LAST:event_table_dataContainerMouseEntered

    private void table_dataContainerMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dataContainerMouseMoved
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = source.columnAtPoint(evt.getPoint());

        if (column == 4) {
            source.setCursor(kursorTangan);
        } else {
            source.setCursor(kursorBiasa);
        }
    }//GEN-LAST:event_table_dataContainerMouseMoved

    public static void lockAllButtons(boolean stat) {

        btn_add.setEnabled(!stat);
        btn_edit.setEnabled(!stat);
        btn_delete.setEnabled(!stat);
        btn_allSelection.setEnabled(!stat);

        if (stat) {
            btn_execute.setText(TEXT_STOP);
        } else {
            btn_execute.setText(TEXT_EXECUTE);
        }

    }

    public static void writeToConsole(String mess) {

        String currText = textarea_console.getText();

        if (currText.length() != 0) {
            textarea_console.setText(mess + "\n" + currText);
        } else {
            textarea_console.setText(mess);
        }

        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

    }

    private static PostEntry postEntryRef = null;
    private String attachmentRef = null;

    private void preparePostEntryData() {

        // table was clicked
        // get the attachment ref for editing purposes
        int nomorIndex = table_dataContainer.getSelectedRow();
        if (nomorIndex > -1) {
            int nomorID = Integer.parseInt(table_dataContainer.getValueAt(nomorIndex, 0).toString());
            postEntryRef = DBOperations.getPost(nomorID);
        } else {
            postEntryRef = null;
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btn_add;
    private static javax.swing.JButton btn_allSelection;
    private static javax.swing.JButton btn_delete;
    private static javax.swing.JButton btn_edit;
    private static javax.swing.JToggleButton btn_execute;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private static javax.swing.JLabel labelTimer;
    private javax.swing.JSplitPane panelsplit_bottom;
    private static javax.swing.JScrollPane scrollPanel;
    private static javax.swing.JTable table_dataContainer;
    private static javax.swing.JTextArea textarea_console;
    // End of variables declaration//GEN-END:variables
}