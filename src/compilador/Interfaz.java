/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import static java.nio.file.Files.lines;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Jorge-PC
 */
public class Interfaz extends javax.swing.JFrame {

    public int bandera = 0;
    private String contenido = "";
   public LineasText lines; //crea un text pane y le agrega su scrooll y dibuja los numeros en el panel donde se agrega
    public LineasText lines2;
    
    public Interfaz() {

        initComponents();
        inicializar();
        System.out.println("constructor " + contenido);
        Codigo_txt.setText(contenido);
        this.revalidate();
        this.repaint();

        
        Codigo_txt.setLayout(new BorderLayout());
        lines =new LineasText();
        Codigo_txt.add(lines,BorderLayout.WEST);
        Codigo_txt.add(lines.scrollPane,BorderLayout.CENTER);
        
        Formato1.setLayout(new BorderLayout());
        lines2= new LineasText();
        Formato1.add(lines2,BorderLayout.WEST);
        Formato1.add(lines2.scrollPane,BorderLayout.CENTER);
        posicionPuntero();
        Resultados_txt.setText("BIENVENIDO!");
    }

    private void posicionPuntero() {
        Codigo_txt.addCaretListener(new CaretListener() {

            @Override
            public void caretUpdate(CaretEvent e) {
                int pos = e.getDot();
                int fila = 1, columna = 0;
                int ultimalinea = -1;
                String text = Codigo_txt.getText().replaceAll("\r", "");

                for (int i = 0; i < pos; i++) {
                    if (text.charAt(i) == 10) {
                        fila++;
                        ultimalinea = i;
                    }
                }

                columna = pos - ultimalinea;
                noFila.setText(fila + "");
                noCol.setText(columna + "");
            }
        });
        Codigo_txt.addCaretListener(new CaretListener(){
            
            @Override
            public void caretUpdate(CaretEvent e) {
                int pos = e.getDot();
		int fila = 1, columna=0;
		int ultimalinea=-1;
		String text =Codigo_txt.getText().replaceAll("\r","");
				
		for(int i=0;i<pos;i++){
                    if(text.charAt(i)==10){
                        fila++;
                        ultimalinea=i;
                    }
                }
				
		columna=pos-ultimalinea;                
                noFila.setText(fila +"");
                noCol.setText(columna+"");
            }
        });
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Sint_p = new javax.swing.JTabbedPane();
        Lexico_txt = new javax.swing.JTextField();
        Sintactico_txt = new javax.swing.JTextField();
        Semantico_txt = new javax.swing.JTextField();
        Inter_txt = new javax.swing.JTextField();
        Resultados = new javax.swing.JTabbedPane();
        Resultados_txt = new javax.swing.JTextField();
        Errores_txt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        Formato = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        Codigo_txt = new compilador.JTextField();
        Formato1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        noFila = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        noCol = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        compilar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        Abrir = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        GuardarComo = new javax.swing.JMenuItem();
        Cerrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilador");
        setForeground(java.awt.Color.darkGray);
        setName("Compilador"); // NOI18N

        Lexico_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Lexico_txtActionPerformed(evt);
            }
        });
        Sint_p.addTab("Léxico", Lexico_txt);
        Sint_p.addTab("Sintáctico", Sintactico_txt);
        Sint_p.addTab("Semántico", Semantico_txt);
        Sint_p.addTab("Código Intermediario", Inter_txt);

        Resultados_txt.setEditable(false);
        Resultados.addTab("Resultados", Resultados_txt);

        Errores_txt.setEditable(false);
        Resultados.addTab("Errores", Errores_txt);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(Codigo_txt);

        Formato.addTab("Codigo a Compilar", jScrollPane1);

        javax.swing.GroupLayout Formato1Layout = new javax.swing.GroupLayout(Formato1);
        Formato1.setLayout(Formato1Layout);
        Formato1Layout.setHorizontalGroup(
            Formato1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
        );
        Formato1Layout.setVerticalGroup(
            Formato1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );

        Formato.addTab("Area de Formato", Formato1);

        jLabel1.setText("FILA:");

        noFila.setText("0");

        jLabel3.setText("COLUMNA:");

        noCol.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );

        compilar.setText("Compilar");
        compilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compilarActionPerformed(evt);
            }
        });

        File.setText("Archivo");

        Abrir.setText("Abrir");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });
        File.add(Abrir);

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        File.add(Guardar);

        GuardarComo.setText("Guardar Como");
        GuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarComoActionPerformed(evt);
            }
        });
        File.add(GuardarComo);

        Cerrar.setText("Cerrar");
        Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarActionPerformed(evt);
            }
        });
        File.add(Cerrar);

        jMenuBar1.add(File);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        jMenu1.setText("Formato");
        jMenuBar1.add(jMenu1);

        jMenu4.setText("Ayuda");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Resultados)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)
                                .addComponent(noFila)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noCol)
                                .addGap(549, 549, 549)
                                .addComponent(compilar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Formato, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Sint_p, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Sint_p)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Formato))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(noFila)
                            .addComponent(jLabel3)
                            .addComponent(noCol)
                            .addComponent(compilar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(Resultados, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Lexico_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Lexico_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Lexico_txtActionPerformed

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
        FuncionesMenu abrir = new FuncionesMenu();
        String contenido = abrir.AbrirArchivo(Codigo_txt);
        Codigo_txt.setText(contenido);
        bandera = 1;

    }//GEN-LAST:event_AbrirActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        if (bandera == 1) {
            FuncionesMenu guardar = new FuncionesMenu();
            guardar.GuardarArchivo(Codigo_txt.getText());
        } else {
            FuncionesMenu crear = new FuncionesMenu();
            crear.CrearArchivo(Codigo_txt, Codigo_txt.getText());
            bandera = 1;
        }
    }//GEN-LAST:event_GuardarActionPerformed

    private void GuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarComoActionPerformed
        FuncionesMenu crear = new FuncionesMenu();
        crear.CrearArchivo(Codigo_txt, Codigo_txt.getText());
    }//GEN-LAST:event_GuardarComoActionPerformed

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed
        Codigo_txt.setText("");
        FuncionesMenu cerrar = new FuncionesMenu();
        cerrar.CerrarArchivo();
        bandera = 0;
    }//GEN-LAST:event_CerrarActionPerformed

    private void compilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compilarActionPerformed
         if (!"".equals(Codigo_txt.getText())) {

            Lexico lex = new Lexico(new BufferedReader(new StringReader(Codigo_txt.getText())));
            lex.pintar.darEstilo(Codigo_txt.getText());
            lines2.pane.setDocument(lex.pintar.caja2.getDocument());
            Sintactico sint = new Sintactico(lex);
            try {
                //aca se compila                   
                sint.parse();
                
                Resultados_txt.setText(Resultados_txt.getText() + "\nAVISO: Analisis realizado correctamente.");
               //jTabbedPane1.setSelectedIndex(1);
            } catch (Exception ex) {
                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
                Resultados_txt.setText(Resultados_txt.getText() + "\nError: No se pudo realizar el analisis sintactico.");
            }
        } else {
            Resultados_txt.setText(Resultados_txt.getText() + "\nAVISO: No hay texto para realizar el analisis.");
        }
    }//GEN-LAST:event_compilarActionPerformed

    public void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);

            }
        });

    }
    
   

    public void inicializar() {
        System.out.println("inicializar");
        FuncionesMenu archivoConfiguracion = new FuncionesMenu();
        String ruta = archivoConfiguracion.LeerConfiguracion();
        contenido = archivoConfiguracion.DatosConfiguracion(ruta);

        System.out.println("termino");

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir;
    private javax.swing.JMenuItem Cerrar;
    private compilador.JTextField Codigo_txt;
    private javax.swing.JTextField Errores_txt;
    private javax.swing.JMenu File;
    private javax.swing.JTabbedPane Formato;
    private javax.swing.JPanel Formato1;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JMenuItem GuardarComo;
    private javax.swing.JTextField Inter_txt;
    private javax.swing.JTextField Lexico_txt;
    private javax.swing.JTabbedPane Resultados;
    private javax.swing.JTextField Resultados_txt;
    private javax.swing.JTextField Semantico_txt;
    private javax.swing.JTabbedPane Sint_p;
    private javax.swing.JTextField Sintactico_txt;
    private javax.swing.JButton compilar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel noCol;
    private javax.swing.JLabel noFila;
    // End of variables declaration//GEN-END:variables
}
