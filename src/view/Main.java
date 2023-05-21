package view;

import generate.FilterGerador;
import generate.RecursoCriadoEventGerador;
import generate.RecursoCriadoListener;
import model.Atributo;
import model.Classe;
import generate.CriandoModelo;
import generate.DadosDoProjeto;
import util.SaveClass;
import generate.RepositoryGerador;
import generate.ResourseGerador;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.SwingWorker;
import generate.ExceptionhandlerGerador;
import generate.MainApiGerador;

/*
 *  Autor:    Claiton Lopes Matavele 
 *  LinkedIn: https://www.linkedin.com/in/claiton-lopes-b47095160} 
 *  GitHub:   https://github.com/claythonlophess} 
 */
/**
 *
 * @author Administrator
 */
public class Main extends javax.swing.JDialog {

    int nrDeVariaveis;
    private String executando = null;
    public static int contador = 1;

    /**
     * Creates new form AtributosJD
     */
    public Main(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jProgressBarBarraDeStatus = new javax.swing.JProgressBar();
        jButton2 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);

        jButton2.setText("Gerar Classes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(0, 102, 153));

        jButton3.setText("Add classe");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("numero de atributos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 538, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(39, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nrDeVariaveis = Integer.parseInt(jTextField1.getText());
        int index = jTabbedPane1.getSelectedIndex();

        for (int i = 0; i < nrDeVariaveis; i++) {
            JTextField rr = new JTextField("var_" + i);
            JComboBox cb = new JComboBox();
            JComboBox cbAnotacao = new JComboBox();
            JComboBox cbClasses = new JComboBox();
            JComboBox cbRelacionamento = new JComboBox();
            JRadioButton rb = new JRadioButton("Primitivo");
            JRadioButton rbClasse = new JRadioButton("Classe");
            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(rb);
            buttonGroup.add(rbClasse);

            cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"int", "String", "double", "LocalDate", "BigDecimal"}));
            cbAnotacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"nenhum", "@NotNull", "enum", "@Embedded", "LocalDate", "BigDecimal"}));
            cbRelacionamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"nenhum", "@ManyToOne", "@ManyToMany", "@OneToMany", "@OneToOne", "BigDecimal"}));

            cbClasses.addMouseListener(new java.awt.event.MouseAdapter() {
                //Adiciona classes na combobox
                @Override
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    String[] str = new String[jTabbedPane1.getTabCount()];
                    for (int j = 0; j < jTabbedPane1.getTabCount(); j++) {
                        str[j] = jTabbedPane1.getTitleAt(j);
                    }
                    cbClasses.setModel(new javax.swing.DefaultComboBoxModel<>(str));
                }
            });

            rb.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (rb.isSelected()) {
                        cb.setVisible(true);
                        cbAnotacao.setVisible(true);
                        cbClasses.setVisible(false);
                        cbRelacionamento.setVisible(false);
                    }
                }
            });

            rbClasse.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (rbClasse.isSelected()) {
                        cb.setVisible(false);
                        cbAnotacao.setVisible(true);
                        cbClasses.setVisible(true);
                        cbRelacionamento.setVisible(true);
                    }
                }
            });

            rr.setBounds(10, i * 25, 150, 25);
            rb.setBounds(200, i * 25, 100, 25);
            rbClasse.setBounds(270, i * 25, 100, 25);

            cb.setBounds(380, i * 25, 150, 25);
            cbClasses.setBounds(380, i * 25, 150, 25);

            cbAnotacao.setBounds(530, i * 25, 150, 25);
            cbRelacionamento.setBounds(680, i * 25, 150, 25);

            rr.setVisible(true);

            cb.setVisible(true);
            cbClasses.setVisible(false);
            cbRelacionamento.setVisible(false);
            cbAnotacao.setVisible(true);

            ListaAtributos.listaJComboBox.get(index).add(cb);
            ListaAtributos.listaJComboBoxClasses.get(index).add(cbClasses);
            ListaAtributos.listaJTextField.get(index).add(rr);
            ListaAtributos.anotacao.get(index).add(cbAnotacao);
            ListaAtributos.relacionamento.get(index).add(cbRelacionamento);
            int Iitem = jTabbedPane1.getSelectedIndex();
            JPanel c = (JPanel) jTabbedPane1.getSelectedComponent();
            c.add(rr);
            c.add(cb);
            c.add(cbClasses);
            c.add(cbAnotacao);
            c.add(cbRelacionamento);
            c.add(rbClasse);
            c.add(rb);
            jTabbedPane1.add(c, jTabbedPane1.getTitleAt(Iitem), Iitem);
           
            jTabbedPane1.setSelectedComponent(c);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        compilarArquivos();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void compilarArquivos() {

        /**
         * **barra de progresso*****************
         */
        jProgressBarBarraDeStatus.setVisible(true);
        jProgressBarBarraDeStatus.setIndeterminate(true);

        final JWindow jWindow = new JWindow(this);
        final JPanel jPanelCompilando = new JPanel();
        final JProgressBar jProgressBarCompilando = new JProgressBar();

        SwingWorker worker = new SwingWorker() {

            @Override
            protected Object doInBackground() throws Exception {
                /*
                     * Janela Aguarde
                 */
                jPanelCompilando.setLayout(new GridLayout(2, 1, 10, 10));
                jPanelCompilando.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                jPanelCompilando.add(new JLabel("Compilando arquivos! Aguarde..."));
                jPanelCompilando.add(jProgressBarCompilando);

                jWindow.add(jPanelCompilando);
                jWindow.pack();
                jWindow.setLocationRelativeTo(Main.this);
                jWindow.setVisible(true);

                jProgressBarCompilando.setVisible(true);
                jProgressBarCompilando.setIndeterminate(true);
                /*
                     *
                 */
                executando = "Compilando arquivos!\nAguarde...";
                geradoClasses();

                return null;
            } // fim do método doInBackground

            @Override
            protected void done() {
                jProgressBarBarraDeStatus.setIndeterminate(false);
                jProgressBarBarraDeStatus.setVisible(false);

                executando = null;

                jProgressBarCompilando.setIndeterminate(false);
                jWindow.dispose();
            }

        };

        worker.execute();
        // fim do else
    } // fim do metodo compilarArquivos

    private void geradoClasses() {
        int total = jTabbedPane1.getTabCount();//total de classes
        for (int j = 0; j < total; j++) {
           
            for (int i = 0; i < ListaAtributos.listaJTextField.get(j).size(); i++) {
                try {
                     ListaAtributos.atributos.get(j).remove(i);
                } catch (Exception e) {
                }
                if (ListaAtributos.listaJComboBox.get(j).get(i).isVisible()) {
                    Atributo atributo = new Atributo(j,
                            ListaAtributos.listaJComboBox.get(j).get(i).getSelectedItem().toString(),
                            ListaAtributos.listaJTextField.get(j).get(i).getText(),
                            "nenhum",
                            ListaAtributos.anotacao.get(j).get(i).getSelectedItem().toString());
                    ListaAtributos.atributos.get(j).add(i,atributo);
                } else {
                    Atributo atributo = new Atributo(j,
                            ListaAtributos.listaJComboBoxClasses.get(j).get(i).getSelectedItem().toString(),
                            ListaAtributos.listaJTextField.get(j).get(i).getText(),
                            ListaAtributos.relacionamento.get(j).get(i).getSelectedItem().toString(),
                            ListaAtributos.anotacao.get(j).get(i).getSelectedItem().toString());
                    ListaAtributos.atributos.get(j).add(i,atributo);
                }

            }
        }

        for (int i = 0; i <= jTabbedPane1.getTabCount(); i++) {
            Classe classe = new Classe("nomeProgeto", ListaAtributos.tipoClasse.get(i), jTabbedPane1.getTitleAt(i), ListaAtributos.atributos.get(i));
            CriandoModelo criandoModelo = new CriandoModelo(classe);
            ResourseGerador resourseGerador = new ResourseGerador(classe);
            RepositoryGerador repositoryGerador = new RepositoryGerador(classe);
            FilterGerador filterGerador = new FilterGerador(classe);
            SaveClass.gravar(DadosDoProjeto.CAMINHO_EXTERNO + repositoryGerador.getPACKAGE(), repositoryGerador.getPrograma(), classe.getNomeClasse() + "Repository", "java");
            SaveClass.gravar(DadosDoProjeto.CAMINHO_EXTERNO + resourseGerador.getPACKAGE(), resourseGerador.getPrograma(), classe.getNomeClasse() + "Resourse", "java");
            SaveClass.gravar(DadosDoProjeto.CAMINHO_EXTERNO + filterGerador.getPACKAGE(), filterGerador.getPrograma(), classe.getNomeClasse() + "Filter", "java");
            SaveClass.gravar(DadosDoProjeto.CAMINHO_EXTERNO + criandoModelo.getPACKAGE(), criandoModelo.getPrograma(), classe.getNomeClasse(), "java");
        }
        /**
         * Classes padrao
         */
        SaveClass.gravar(DadosDoProjeto.CAMINHO_EXTERNO + ExceptionhandlerGerador.PACKAGE, ExceptionhandlerGerador.CONTEUDO, DadosDoProjeto.NOME_D0_PROJETO + "ExceptionHandler", "java");
        SaveClass.gravar(DadosDoProjeto.CAMINHO_EXTERNO + RecursoCriadoEventGerador.PACKAGE, RecursoCriadoEventGerador.CONTEUDO, "RecursoCriadoEvent", "java");
        SaveClass.gravar(DadosDoProjeto.CAMINHO_EXTERNO + RecursoCriadoListener.PACKAGE.replace(".", "\\"), RecursoCriadoListener.CONTEUDO, "RecursoCriadoListener", "java");
        SaveClass.gravar(DadosDoProjeto.CAMINHO_EXTERNO + MainApiGerador.PACKAGE, MainApiGerador.CONTEUDO, "AlgamoneyApiApplication", "java");
        //ListaAtributos.atributos = new ArrayList<>();

    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ClasseJDialog addClasse = new ClasseJDialog(this, false);
        addClasse.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main dialog = new Main(new javax.swing.JFrame(), false);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBarBarraDeStatus;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    void addclasses(String nome, String tipoClasse) {
        jPanel1 = new JPanel();
        jPanel1.setLayout(null);
        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(378, 1000));
        jTabbedPane1.addTab(nome, jPanel1);
        jTabbedPane1.setSelectedComponent(jPanel1);

        ListaAtributos.tipoClasse.add(tipoClasse);
        ListaAtributos.atributos.add(new ArrayList<>());
        ListaAtributos.listaJComboBox.add(new ArrayList<>());
        ListaAtributos.listaJTextField.add(new ArrayList<>());
        ListaAtributos.listaJComboBoxClasses.add(new ArrayList<>());
        ListaAtributos.relacionamento.add(new ArrayList<>());
        ListaAtributos.anotacao.add(new ArrayList<>());
        ListaAtributos.listaNomeClasse.add(nome);
    }

    public class ListaAtributos {
        public static List<List<Atributo>> atributos = new ArrayList<>();
        public static List<List<JTextField>> listaJTextField = new ArrayList<>();
        public static List<List<JComboBox>> listaJComboBox = new ArrayList<>();
        public static List<String> tipoClasse = new ArrayList<>();
        public static List<List<JComboBox>> anotacao = new ArrayList<>();
        public static List<List<JComboBox>> relacionamento = new ArrayList<>();
        public static List<String> listaNomeClasse = new ArrayList<>();
        public static List<List<JComboBox>> listaJComboBoxClasses = new ArrayList<>();// tipo de variavel nao primitiva
    }
}