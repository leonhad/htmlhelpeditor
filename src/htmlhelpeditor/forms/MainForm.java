/*
 * MainForm.java
 *
 * Created on 25 de Setembro de 2007, 12:32
 */

package htmlhelpeditor.forms;

import framework.forms.utils.FrameManager;
import framework.gui.Mensagem;
import htmlhelpeditor.filters.HSFilter;
import htmlhelpeditor.forms.listeners.FileKey;
import htmlhelpeditor.forms.listeners.FileMouse;
import htmlhelpeditor.od.HelpsetOD;
import htmlhelpeditor.od.IndexOD;
import htmlhelpeditor.od.MapOD;
import htmlhelpeditor.od.ViewOD;
import htmlhelpeditor.xml.HelpsetXML;
import htmlhelpeditor.xml.IndexXML;
import htmlhelpeditor.xml.MapXML;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author  leonardo.costa
 */
public class MainForm extends javax.swing.JFrame {

    private DefaultMutableTreeNode arquivosRoot = new DefaultMutableTreeNode("Arquivos");
    private DefaultMutableTreeNode projetoRoot = new DefaultMutableTreeNode("Projeto");
    private DefaultMutableTreeNode indiceRoot = new DefaultMutableTreeNode("Índice");
    private DefaultTreeModel arquivosModel = new DefaultTreeModel(arquivosRoot);
    private DefaultTreeModel projetoModel = new DefaultTreeModel(projetoRoot);
    private DefaultTreeModel indiceModel = new DefaultTreeModel(indiceRoot);
    private HelpsetOD help = null;
    private String dir = null;

    private static MainForm instance = null;
    
    public static MainForm getInstance() {
        if (instance == null) {
            instance = new MainForm();
        }
        return instance;
    }
    
    /** Creates new form MainForm */
    private MainForm() {
        initComponents();

        arquivos.setModel(arquivosModel);
        projetos.setModel(projetoModel);
        indice.setModel(indiceModel);
        
        FrameManager manager = FrameManager.getInstance();
        manager.setDefaultDesktop(desktop);

        arquivos.addMouseListener(new FileMouse(arquivos));
        projetos.addMouseListener(new FileMouse(projetos));
        indice.addMouseListener(new FileMouse(indice));
        arquivos.addKeyListener(new FileKey(arquivos));
        projetos.addKeyListener(new FileKey(projetos));
        indice.addKeyListener(new FileKey(indice));
        
        novoProjeto();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        projetoNovo = new javax.swing.JButton();
        projetoAbrir = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        jButton12 = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        jButton16 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        scrollProjeto = new javax.swing.JScrollPane();
        projetos = new javax.swing.JTree();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        arquivos = new javax.swing.JTree();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        indice = new javax.swing.JTree();
        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        arquivo = new javax.swing.JMenu();
        novoProjeto = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        novoHtml = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        abrirProjeto = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JSeparator();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JSeparator();
        jMenu4 = new javax.swing.JMenu();
        jSeparator8 = new javax.swing.JSeparator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JSeparator();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JSeparator();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem31 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JSeparator();
        jMenuItem32 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HTML Help Editor 1.0");
        setIconImage(new ImageIcon(getClass().getResource("/htmlhelpeditor/images/help_book.png")).getImage());

        jToolBar1.setRollover(true);

        projetoNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Project_Add.png"))); // NOI18N
        projetoNovo.setFocusable(false);
        projetoNovo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        projetoNovo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        projetoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projetoNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(projetoNovo);

        projetoAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Folder-Open.png"))); // NOI18N
        projetoAbrir.setFocusable(false);
        projetoAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        projetoAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        projetoAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projetoAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(projetoAbrir);
        jToolBar1.add(jSeparator12);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Doc-Add.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Save.png"))); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton5);
        jToolBar1.add(jSeparator13);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Computer.png"))); // NOI18N
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton12);
        jToolBar1.add(jSeparator16);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/IndexFile.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Compile-Ok.png"))); // NOI18N
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton13);
        jToolBar1.add(jSeparator17);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/question_ok.png"))); // NOI18N
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton14);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Web-info.png"))); // NOI18N
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton15);
        jToolBar1.add(jSeparator18);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/question.png"))); // NOI18N
        jButton16.setFocusable(false);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton16);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.NORTH);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Iniciando...");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jProgressBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jProgressBar1, java.awt.BorderLayout.LINE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(200, 100));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel2.setLayout(new java.awt.BorderLayout());

        scrollProjeto.setViewportView(projetos);

        jPanel2.add(scrollProjeto, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Projeto", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(arquivos);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Arquivos", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setViewportView(indice);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Índice", jPanel4);

        getContentPane().add(jTabbedPane1, java.awt.BorderLayout.WEST);

        desktop.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(desktop, java.awt.BorderLayout.CENTER);

        menu.setText("Arquivo");

        arquivo.setText("Novo");

        novoProjeto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        novoProjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Project_Add.png"))); // NOI18N
        novoProjeto.setText("Projeto...");
        novoProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoProjetoActionPerformed(evt);
            }
        });
        arquivo.add(novoProjeto);
        arquivo.add(jSeparator1);

        novoHtml.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        novoHtml.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Html_Add.png"))); // NOI18N
        novoHtml.setText("Documento HTML...");
        novoHtml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoHtmlActionPerformed(evt);
            }
        });
        arquivo.add(novoHtml);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Rss-Add.png"))); // NOI18N
        jMenuItem3.setText("Tabela de Conteúdo...");
        arquivo.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Datbase-Add.png"))); // NOI18N
        jMenuItem4.setText("Índice...");
        arquivo.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Talk-Add.png"))); // NOI18N
        jMenuItem5.setText("Glossário...");
        arquivo.add(jMenuItem5);

        menu.add(arquivo);
        menu.add(jSeparator2);

        abrirProjeto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        abrirProjeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Folder-Open.png"))); // NOI18N
        abrirProjeto.setText("Abrir Projeto...");
        abrirProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirProjetoActionPerformed(evt);
            }
        });
        menu.add(abrirProjeto);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Delete.png"))); // NOI18N
        jMenuItem7.setText("Fechar Projeto");
        menu.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Folder-Open.png"))); // NOI18N
        jMenuItem8.setText("Importar Projeto...");
        menu.add(jMenuItem8);
        menu.add(jSeparator3);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Doc-Add.png"))); // NOI18N
        jMenuItem9.setText("Adicionar Documento...");
        menu.add(jMenuItem9);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Folder-Add.png"))); // NOI18N
        jMenuItem10.setText("Novo Diretório...");
        menu.add(jMenuItem10);
        menu.add(jSeparator4);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Doc-Cancel.png"))); // NOI18N
        jMenuItem11.setText("Fechar");
        menu.add(jMenuItem11);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Delete.png"))); // NOI18N
        jMenuItem12.setText("Fechar Todos");
        menu.add(jMenuItem12);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Save.png"))); // NOI18N
        jMenuItem13.setText("Salvar");
        menu.add(jMenuItem13);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Save.png"))); // NOI18N
        jMenuItem14.setText("Salvar Todos");
        menu.add(jMenuItem14);
        menu.add(jSeparator5);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Printer.png"))); // NOI18N
        jMenuItem15.setText("Imprimir...");
        menu.add(jMenuItem15);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Web-info.png"))); // NOI18N
        jMenuItem16.setText("Exportar para HTML...");
        menu.add(jMenuItem16);
        menu.add(jSeparator7);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Save.png"))); // NOI18N
        jMenuItem17.setText("Salvar Projeto");
        menu.add(jMenuItem17);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Compile.png"))); // NOI18N
        jMenuItem18.setText("Publicar Projeto...");
        menu.add(jMenuItem18);
        menu.add(jSeparator9);

        jMenu4.setText("Recentes...");
        menu.add(jMenu4);
        menu.add(jSeparator8);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Delete.png"))); // NOI18N
        jMenuItem19.setText("Sair");
        menu.add(jMenuItem19);

        jMenuBar1.add(menu);

        jMenu2.setText("Editar");

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/undo.png"))); // NOI18N
        jMenuItem20.setText("Desfazer");
        jMenu2.add(jMenuItem20);

        jMenuItem21.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/redo.png"))); // NOI18N
        jMenuItem21.setText("Refazer");
        jMenu2.add(jMenuItem21);
        jMenu2.add(jSeparator6);

        jMenuItem22.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Cut.png"))); // NOI18N
        jMenuItem22.setText("Cortar");
        jMenu2.add(jMenuItem22);

        jMenuItem23.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Copy.png"))); // NOI18N
        jMenuItem23.setText("Copiar");
        jMenu2.add(jMenuItem23);

        jMenuItem24.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Paste.png"))); // NOI18N
        jMenuItem24.setText("Colar");
        jMenu2.add(jMenuItem24);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("Visão");

        jMenuItem25.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Computer.png"))); // NOI18N
        jMenuItem25.setText("Console");
        jMenu5.add(jMenuItem25);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Ferramentas");

        jMenuItem27.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/IndexFile.png"))); // NOI18N
        jMenuItem27.setText("Criar/Atualizar arquivo de procura");
        jMenu6.add(jMenuItem27);

        jMenuItem28.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Compile-Ok.png"))); // NOI18N
        jMenuItem28.setText("Verificar consistência do projeto");
        jMenu6.add(jMenuItem28);

        jMenuItem29.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/question_ok.png"))); // NOI18N
        jMenuItem29.setText("Ver o Helpset");
        jMenu6.add(jMenuItem29);
        jMenu6.add(jSeparator10);

        jMenuItem30.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Favorite2.png"))); // NOI18N
        jMenuItem30.setText("Preferências");
        jMenu6.add(jMenuItem30);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Ajuda");

        jMenuItem31.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/question.png"))); // NOI18N
        jMenuItem31.setText("Conteúdo");
        jMenu7.add(jMenuItem31);
        jMenu7.add(jSeparator11);

        jMenuItem32.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/question.png"))); // NOI18N
        jMenuItem32.setText("Sobre...");
        jMenu7.add(jMenuItem32);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-600)/2, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void abrirProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirProjetoActionPerformed
        abrirProjeto();
    }//GEN-LAST:event_abrirProjetoActionPerformed

    private void processaProjeto(HelpsetOD help) throws Exception {
        projetoRoot.setUserObject(help);
        if (help.getMap() != null) {
            DefaultMutableTreeNode mapNode = new DefaultMutableTreeNode(help.getMap());
            projetoRoot.add(mapNode);
        }
        for (ViewOD view : help.getView()) {
            if (view.getData() != null && !view.getType().equals("javax.help.SearchView")) {
                DefaultMutableTreeNode viewNode = new DefaultMutableTreeNode(view);
                projetoRoot.add(viewNode);

                if (view.getType().equals("javax.help.IndexView")) {
                    IndexXML xml = new IndexXML();
                    File indexFile = new File(dir + view.getData().getData());
                    InputStream indexIS = new FileInputStream(indexFile);
                    help.setIndices(xml.parse(indexIS));

                    processaIndice(indiceRoot, help.getIndices());
                    indice.expandRow(0);
                }
            }
        }
        projetos.expandRow(0);
    }

    private void processaIndice(DefaultMutableTreeNode node, ArrayList<IndexOD> indxs) throws Exception {
        DefaultMutableTreeNode root = null;
        for (IndexOD idx : indxs) {
            root = new DefaultMutableTreeNode(idx);
            node.add(root);
            if (idx.getFilhos() != null) {
                processaIndice(root, idx.getFilhos());
            }
        }
    }

    private void processaMap(HelpsetOD helpset) throws Exception {
        if (helpset.getMap() != null) {
            String mapref = helpset.getMap().getMapref();
            File mapFile = new File(dir + mapref);
            InputStream mapIS = new FileInputStream(mapFile);
            MapXML xml = new MapXML();
            helpset.setMaps(xml.parse(mapIS));

            for (MapOD mapOD : helpset.getMaps()) {
                DefaultMutableTreeNode temp = arquivosRoot;
                String[] path = mapOD.getUrl().split("/");
                for (int loop = 0; loop < path.length; loop++) {
                    String p = path[loop];
                    if (loop == path.length - 1) {
                        DefaultMutableTreeNode mapNode = new DefaultMutableTreeNode(mapOD);
                        temp.add(mapNode);
                    } else {
                        DefaultMutableTreeNode found = null;
                        for (int i = 0; i < temp.getChildCount(); i++) {
                            DefaultMutableTreeNode temp2 = (DefaultMutableTreeNode) temp.getChildAt(i);
                            if (temp2.getUserObject().toString().equals(p)) {
                                found = temp2;
                                break;
                            }
                        }
                        if (found != null) {
                            temp = found;
                        } else {
                            DefaultMutableTreeNode mapNode = new DefaultMutableTreeNode(p);
                            temp.insert(mapNode, 0);
                            temp = mapNode;
                        }
                    }
                }
            }
        }
        arquivos.expandRow(0);
    }
    
    public void abrirProjeto() {
        try {
            indiceRoot.removeAllChildren();
            projetoRoot.removeAllChildren();
            arquivosRoot.removeAllChildren();

            JFileChooser chooser = new JFileChooser();
            chooser.setMultiSelectionEnabled(false);
            chooser.setFileFilter(new HSFilter());
            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                String absolute = file.getAbsolutePath();
                dir = absolute.substring(0, absolute.length() - file.getName().length());
                InputStream is = new FileInputStream(file);
                HelpsetXML helpset = new HelpsetXML();
                help = helpset.parse(is);
                help.setFile(file.getName());
                is.close();

                processaProjeto(help);
                processaMap(help);

                for (ViewOD view : help.getView()) {
                    if (view.getType().equals("javax.help.IndexView")) {
                        // Índice
                    } else if (view.getType().equals("javax.help.TOCView")) {
                        // TOC
                    } else if (view.getType().equals("javax.help.FavoritesView")) {
                        // Favoritos
                    } else if (view.getType().equals("javax.help.SearchView")) {
                        // Search
                    }
                }
            }
        } catch (Exception ex) {
            Mensagem.error("Falha ao abrir o arquivo de projeto.", ex);
        }
    }
    
    public void novoProjeto() {
        help = new HelpsetOD();
        help.setFile("Novo.hs");
        projetoRoot.setUserObject(help);
        projetoRoot.removeAllChildren();
        arquivosRoot.setUserObject("Arquivos");
        arquivosRoot.removeAllChildren();
        indiceRoot.setUserObject("Índice");
        indiceRoot.removeAllChildren();
        projetos.collapseRow(0);
        arquivos.collapseRow(0);
        indice.collapseRow(0);
        projetos.repaint();
        arquivos.repaint();
        indice.repaint();
    }

    private void novoHtmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoHtmlActionPerformed
        DocumentForm form = new DocumentForm();
        desktop.add(form);
        form.setVisible(true);
    }//GEN-LAST:event_novoHtmlActionPerformed

    private void projetoAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projetoAbrirActionPerformed
        abrirProjeto();
    }//GEN-LAST:event_projetoAbrirActionPerformed

    private void projetoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projetoNovoActionPerformed
        novoProjeto();
    }//GEN-LAST:event_projetoNovoActionPerformed

    private void novoProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoProjetoActionPerformed
        novoProjeto();
    }//GEN-LAST:event_novoProjetoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirProjeto;
    private javax.swing.JMenu arquivo;
    private javax.swing.JTree arquivos;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JTree indice;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu menu;
    private javax.swing.JMenuItem novoHtml;
    private javax.swing.JMenuItem novoProjeto;
    private javax.swing.JButton projetoAbrir;
    private javax.swing.JButton projetoNovo;
    private javax.swing.JTree projetos;
    private javax.swing.JScrollPane scrollProjeto;
    // End of variables declaration//GEN-END:variables

    public HelpsetOD getHelp() {
        return help;
    }

    public void setHelp(HelpsetOD help) {
        this.help = help;
    }
}