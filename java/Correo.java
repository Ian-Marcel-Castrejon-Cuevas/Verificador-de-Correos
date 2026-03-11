
/**
 * The Correo class is a Java Swing application that allows users to verify the validity of an email
 * address and displays its components in a table.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ian
 */
public class Correo extends javax.swing.JFrame {

    // Gestionar la tabla
    DefaultTableModel mt = new DefaultTableModel();

    // Listas de dominios permitidos
    public String[] dominiosPermitidos = {
            "outlook",
            "gmail",
            "yahoo",
            "hotmail",
            "aol",
            "protonmail",
            "icloud",
            "mail",
            "yandex",
            "zoho"
    };

    // Listas de extensiones permitidas
    public String[] extensionesPermitidas = {
            ".com",
            ".es",
            ".org",
            ".net",
            ".mx",
    };

    public Correo() {
        initComponents();

        // Modificacion de la tabla
        String ids[] = { "Token", "Tipo" };
        mt.setColumnIdentifiers(ids);
        jTable1.setModel(mt);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("INGRESA EL CORREO ELECTRONICO");

        jTextField1.setText("xvasesinxv@outlook.com");

        jButton1.setText("VERIFICAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Dominios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Extensiones");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                .addComponent(jLabel1,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(jTextField1,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 226,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                layout.createSequentialGroup()
                                                                        .addComponent(jButton1)
                                                                        .addGap(68, 68, 68)))
                                                .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jButton2)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jButton3)
                                                        .addGap(39, 39, 39)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addContainerGap(118, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Patrón de expresión regular para validar direcciones de correo electrónico
    public String patronCorreo = "^(?<Usuario>[a-zA-Z0-9_-]+)" +
            "(?<Arroba>@)" +
            "(?<Dominio>[a-zA-Z0-9-]+)" +
            "(?<Punto>\\.)" +
            "(?<Extension>[a-zA-Z]{1,3})$";

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        String correo = jTextField1.getText();
        mt.setRowCount(0);

        if (!correo.contains(" ")) {

            // Validar la dirección de correo con el patrón
            Pattern pattern = Pattern.compile(patronCorreo);
            Matcher matcher = pattern.matcher(correo);

            if (matcher.matches()) {
                String[] nombresTokens = { "Usuario", "Arroba", "Dominio", "Punto", "Extension" };
                String[] tiposTokens = new String[5];
                String[] valoresTokens = new String[5];

                // Obtener y mostrar los componentes del correo en la tabla
                for (int i = 0; i < nombresTokens.length; i++) {
                    tiposTokens[i] = nombresTokens[i];
                    valoresTokens[i] = matcher.group(nombresTokens[i]);
                    mt.addRow(new Object[] { valoresTokens[i], tiposTokens[i] });
                }

                // Verificación semántica del dominio
                String dominio = valoresTokens[2];
                if (esDominioValido(dominio)) {

                    // Verificación semántica de la extencion
                    String extension = valoresTokens[3] + valoresTokens[4];
                    if (esExtensionValida(extension)) {
                        JOptionPane.showMessageDialog(null, "Correo válido");

                    } else {
                        JOptionPane.showMessageDialog(null, "Verifica las extensiones validas");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Verifica los dominios validos");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Compruebe el correo");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No coloque espacios");
        }

    }

    // Boton para mostrar los dominios
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        // Crear el mensaje con las extensiones
        StringBuilder mensaje = new StringBuilder("Dominios Permitidos:\n");
        for (String extension : dominiosPermitidos) {
            mensaje.append("\"").append(extension).append("\"").append("\n");
        }

        // Mostrar el JOptionPane con la lista de dominios permitidos
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Dominios Permitidos", JOptionPane.INFORMATION_MESSAGE);
    }

    // Boton para mostrar las extensiones
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
        // Crear el mensaje con las extensiones
        StringBuilder mensaje = new StringBuilder("Extensiones Permitidas:\n");
        for (String extension : extensionesPermitidas) {
            mensaje.append("\"").append(extension).append("\"").append("\n");
        }

        // Mostrar el JOptionPane con la lista de extensiones permitidas
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Extensiones Permitidas",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean esDominioValido(String dominio) {
        // Verificar si el dominio stá en la lista de dominios permitidos
        for (String dominioPermitido : dominiosPermitidos) {
            if (dominioPermitido.equals(dominio)) {
                return true;
            }
        }
        return false;
    }

    private boolean esExtensionValida(String extension) {
        // Verificar si el dominio stá en la lista de dominios permitidos
        for (String extensionPermitida : extensionesPermitidas) {
            if (extensionPermitida.equals(extension)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Correo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Correo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Correo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Correo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Correo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
