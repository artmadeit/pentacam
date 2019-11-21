import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import static java.util.Collections.EMPTY_LIST;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public class Oculus extends javax.swing.JFrame implements Delay {

    class Eye {

        public static final String I = "Izquierdo";
        public static final String D = "Derecho";
    }

    List<Exam> fakeExams = Arrays.asList(
            new Exam(1, LocalDate.of(2016, 8, 12), LocalTime.of(12, 15), Eye.D),
            new Exam(2, LocalDate.of(2016, 10, 8), LocalTime.of(10, 20), Eye.D),
            new Exam(3, LocalDate.of(2016, 10, 8), LocalTime.of(10, 35), Eye.I)
    );

    List<Patient> patients = Arrays.asList(
            new Patient("Arthur", "Mauricio Delgadillo", LocalDate.of(1995, 11, 04), fakeExams),
            new Patient("Diana", "Quintanilla Perez", LocalDate.of(1994, 06, 05),
                    Arrays.asList(new Exam(1, LocalDate.of(2018, 9, 3), LocalTime.of(11, 20), Eye.D))),
            new Patient("DIANA", "QUINTANILLA PEREZ", LocalDate.of(1994, 06, 05),
                    Arrays.asList(
                            new Exam(1, LocalDate.of(2019, 3, 4), LocalTime.of(12, 30), Eye.D),
                            new Exam(2, LocalDate.of(2019, 3, 4), LocalTime.of(12, 35), Eye.I))
            ),
            new Patient("Alex", "Quintanilla Perez", LocalDate.of(1991, 10, 12), EMPTY_LIST),
            new Patient("Paul", "McCartney", LocalDate.of(1948, 02, 20), fakeExams)
    );

    private int selectedPatient = 0;
    private List<Patient> selectedPatients = patients;

    /**
     * Creates new form Oculus
     */
    public Oculus() {
        initComponents();

        updatePatientsTable();

        Oculus frame = this;
        examsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    onDoubleClickRow();
                }
            }

            private void onDoubleClickRow() {
                delay();
                examTopography = new ExamTopographyUI();
                examTopography.setVisible(true);
                examTopography.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowOpened(WindowEvent we) {
                        examTopography.delay(4);
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                        frame.refresh();
                    }
                });

            }
        });
    }

    public void refresh() {
        delay();
        SwingUtilities.updateComponentTreeUI(this);
        delay();

    }

    public class NonEditableTableModel extends DefaultTableModel {

        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    }

    private void updatePatientsTable() {
        NonEditableTableModel tableModel = new NonEditableTableModel();
        tableModel.setColumnIdentifiers(new String[]{"Apellido", "Nombre", "Fecha de nacimiento",
            "ID"});

        selectedPatients.stream().forEach(p -> {
            tableModel.addRow(new Object[]{p.lastName, p.firstName, p.birthDate.toString(),
                "asdasd"});
        });

        patientsTable.setModel(tableModel);

        if (!selectedPatients.isEmpty()) {
            patientsTable.setRowSelectionInterval(selectedPatient, selectedPatient);
        }
    }

    private void updateExamsTable(List<Exam> exams) {
        NonEditableTableModel tableModel = new NonEditableTableModel();
        tableModel.setColumnIdentifiers(new String[]{"#", "Fecha", "Hora",
            "Dispositivo", "Ojo", "Tipo de examen", "Texto de informacion"});

        exams.stream().forEach(x -> {
            tableModel.addRow(new Object[]{x.number, x.date, x.time, "Pentacam", "(25) 3D-Scan HR", x.eye,
                "asdasd"});
        });

        examsTable.setModel(tableModel);
        examsTable.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        saveButtton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientsTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        examsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Paciente"));
        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jPanel6.setLayout(new java.awt.GridLayout(5, 2));

        jLabel1.setText("Apellido");
        jPanel6.add(jLabel1);

        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });
        lastNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lastNameTextFieldKeyPressed(evt);
            }
        });
        jPanel6.add(lastNameTextField);

        jLabel2.setText("Nombre");
        jPanel6.add(jLabel2);

        firstNameTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                firstNameTextFieldKeyPressed(evt);
            }
        });
        jPanel6.add(firstNameTextField);

        jLabel3.setText("Fecha Nac.:");
        jPanel6.add(jLabel3);
        jPanel6.add(jTextField3);

        jLabel4.setText("N° de ident.");
        jPanel6.add(jLabel4);
        jPanel6.add(jTextField4);

        jLabel5.setText("Comment 1");
        jPanel6.add(jLabel5);
        jPanel6.add(jTextField5);

        jPanel4.add(jPanel6);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        saveButtton.setText("Guardar");
        saveButtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButttonActionPerformed(evt);
            }
        });
        jPanel5.add(saveButtton);

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel5.add(cancelButton);

        jPanel4.add(jPanel5);

        jPanel1.add(jPanel4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("Lista de pacientes");
        jPanel8.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        patientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        patientsTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                patientsTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(patientsTable);
        patientsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jPanel8.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel7.setText("Pruebas disponibles");
        jPanel7.add(jLabel7, java.awt.BorderLayout.PAGE_START);

        examsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(examsTable);

        jPanel7.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel7);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void saveButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButttonActionPerformed
        search();
    }//GEN-LAST:event_saveButttonActionPerformed

    private void search() {
        selectedPatients = patients.stream().filter(x -> isSimilar(x)).collect(toList());
        selectedPatient = 0;
        updatePatientsTable();

        List<Exam> exams = selectedPatients.isEmpty() ? EMPTY_LIST : selectedPatients.get(0).exams;
        updateExamsTable(exams);
    }

    private boolean isSimilar(Patient x) {
        return isSimilar(x.lastName, lastNameTextField.getText()) && isSimilar(x.firstName, firstNameTextField.getText());
    }

    private boolean isSimilar(String text, String otherText) {
        return text.toLowerCase().contains(otherText.toLowerCase());
    }


    private void lastNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastNameTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search();
        }
    }//GEN-LAST:event_lastNameTextFieldKeyPressed

    private void firstNameTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstNameTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search();
        }
    }//GEN-LAST:event_firstNameTextFieldKeyPressed

    ExamTopographyUI examTopography;

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        selectedPatient = patients.indexOf(selectedPatients.get(0));
        selectedPatients = patients;
        
        updatePatientsTable();
        examsTable.setEnabled(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void patientsTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patientsTableKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            selectedPatient = patientsTable.getSelectedRow() + 1;
            showExams();
        }

        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            selectedPatient = patientsTable.getSelectedRow() - 1;
            showExams();
        }
    }//GEN-LAST:event_patientsTableKeyPressed

    private void showExams() {
        if (selectedPatient < 0 || selectedPatient >= selectedPatients.size()) {
            return;
        }

        Patient patient = selectedPatients.get(selectedPatient);
        updateExamsTable(patient.exams);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Oculus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Oculus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Oculus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Oculus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Oculus().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable examsTable;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTable patientsTable;
    private javax.swing.JButton saveButtton;
    // End of variables declaration//GEN-END:variables
}
