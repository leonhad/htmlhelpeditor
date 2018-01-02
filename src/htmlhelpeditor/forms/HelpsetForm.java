/*
 * HelpsetForm.java
 *
 * Created on 6 de Outubro de 2007, 14:10
 */

package htmlhelpeditor.forms;

import framework.gui.FormInternal;
import framework.gui.PComboBox;
import htmlhelpeditor.od.HelpMapsOD;
import htmlhelpeditor.od.HelpsetOD;
import htmlhelpeditor.od.MapOD;
import htmlhelpeditor.od.PresentationOD;
import htmlhelpeditor.od.ViewOD;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  Leonardo
 */
public class HelpsetForm extends FormInternal {

    private static HelpsetForm instance = null;

    public static HelpsetForm getInstance() {
        if (instance == null) {
            instance = new HelpsetForm();
        }
        return instance;
    }

    /** Creates new form HelpsetForm */
    private HelpsetForm() {
        initComponents();
    }

    public void open(HelpsetOD od) {
        //MainForm main = MainForm.getInstance();

        titulo.setText(od.getTitle());
        localizacao.setText(od.getLocale());
        versao.setText(od.getVersion());

        ViewOD fav = null;
        ViewOD proc = null;
        ViewOD indx = null;
        for (ViewOD view : od.getView()) {
            if (ViewOD.FAVORITOS.equals(view.getType())) {
                fav = view;
            } else if (ViewOD.PROCURA.equals(view.getType())) {
                proc = view;
            } else if (ViewOD.INDICE.equals(view.getType())) {
                indx = view;
            }
        }
        favoritos.setSelected(fav != null);
        procura.setSelected(proc != null);
        if (fav == null) {
            fav = new ViewOD();
        }
        if (proc == null) {
            proc = new ViewOD();
        }

        // Mapa
        HelpMapsOD map = od.getMap();
        nomeMapa.setText(map.getHomeID());
        String home = map.getHomeID();

        paginaInicial.removeAllItems();
        for (MapOD mapOD : od.getMaps()) {
            if (mapOD.isHTML()) {
                paginaInicial.addItem(mapOD);
                if (mapOD.getTarget().equals(home)) {
                    paginaInicial.setSelectedItem(mapOD);
                }
            }
        }

        // Apresentação
        DefaultTableModel apresentacaoModel = (DefaultTableModel) apresentacao.getModel();
        while(apresentacaoModel.getRowCount() > 0) {
            apresentacaoModel.removeRow(0);
        }
        for (PresentationOD presentation : od.getPresentation()) {
            Vector<Object> valores = new Vector<Object>();
            valores.add(presentation);
            valores.add(Boolean.valueOf(presentation.isPadrao()));
            apresentacaoModel.addRow(valores);
        }
        
        // Índice
        nomeIndice.setText(indx.getName());
        tipIndice.setText(indx.getLabel());
        iconeIndice.removeAllItems();
        for (MapOD mapOD : od.getMaps()) {
            if (mapOD.isImage()) {
                iconeIndice.addItem(mapOD);
                if (mapOD.getTarget().equals(indx.getImage())) {
                    iconeIndice.setSelectedItem(mapOD);
                }
            }
        }
        
        // Favoritos
        nomeFav.setText(fav.getName());
        tipFav.setText(fav.getLabel());
        iconeFav.removeAllItems();
        for (MapOD mapOD : od.getMaps()) {
            if (mapOD.isImage()) {
                iconeFav.addItem(mapOD);
                if (mapOD.getTarget().equals(fav.getImage())) {
                    iconeFav.setSelectedItem(mapOD);
                }
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcoes = new javax.swing.JTabbedPane();
        geralPanel = new javax.swing.JPanel();
        projetoPanel = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        localizacao = new javax.swing.JTextField();
        titulo = new javax.swing.JTextField();
        lblVersao = new javax.swing.JLabel();
        versao = new javax.swing.JTextField();
        visoesPanel = new javax.swing.JPanel();
        favoritos = new javax.swing.JCheckBox();
        procura = new javax.swing.JCheckBox();
        mapa = new javax.swing.JPanel();
        lblNomeMapa = new javax.swing.JLabel();
        lblPaginaMapa = new javax.swing.JLabel();
        nomeMapa = new javax.swing.JLabel();
        paginaInicial = new PComboBox();
        apresentacaoPanel = new javax.swing.JPanel();
        adicionarAp = new javax.swing.JButton();
        alterarAp = new javax.swing.JButton();
        removerAp = new javax.swing.JButton();
        scrollAp = new javax.swing.JScrollPane();
        apresentacao = new javax.swing.JTable();
        implementacaoPanel = new javax.swing.JPanel();
        lblHelpbroker = new javax.swing.JLabel();
        helpBroker = new javax.swing.JTextField();
        incluirImp = new javax.swing.JButton();
        excluirImp = new javax.swing.JButton();
        removerImp = new javax.swing.JButton();
        scrollImp = new javax.swing.JScrollPane();
        implementacao = new javax.swing.JTable();
        indicePanel = new javax.swing.JPanel();
        lblNomeIndice = new javax.swing.JLabel();
        lblTipIndice = new javax.swing.JLabel();
        lblIconeIndice = new javax.swing.JLabel();
        nomeIndice = new javax.swing.JTextField();
        tipIndice = new javax.swing.JTextField();
        iconeIndice = new PComboBox();
        tocPanel = new javax.swing.JPanel();
        lblNomeToc = new javax.swing.JLabel();
        lblTipToc = new javax.swing.JLabel();
        lblIconeToc = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        procuraPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        favoritosPanel = new javax.swing.JPanel();
        lblNomeFav = new javax.swing.JLabel();
        lblTipFav = new javax.swing.JLabel();
        lblIconeFav = new javax.swing.JLabel();
        iconeFav = new PComboBox();
        tipFav = new javax.swing.JTextField();
        nomeFav = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Helpset");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/help_book.png"))); // NOI18N

        projetoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Projeto"));

        lblTitulo.setText("Título:");

        jLabel2.setText("Localização:");

        lblVersao.setText("Versão:");

        javax.swing.GroupLayout projetoPanelLayout = new javax.swing.GroupLayout(projetoPanel);
        projetoPanel.setLayout(projetoPanelLayout);
        projetoPanelLayout.setHorizontalGroup(
            projetoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projetoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projetoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblTitulo)
                    .addComponent(lblVersao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(projetoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addGroup(projetoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(versao, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(localizacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );
        projetoPanelLayout.setVerticalGroup(
            projetoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projetoPanelLayout.createSequentialGroup()
                .addGroup(projetoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(projetoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(localizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(projetoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVersao)
                    .addComponent(versao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        visoesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Visões de Navegações Opcionais"));

        favoritos.setText("Favoritos");

        procura.setText("Procura");

        javax.swing.GroupLayout visoesPanelLayout = new javax.swing.GroupLayout(visoesPanel);
        visoesPanel.setLayout(visoesPanelLayout);
        visoesPanelLayout.setHorizontalGroup(
            visoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(visoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(favoritos)
                    .addComponent(procura))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        visoesPanelLayout.setVerticalGroup(
            visoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visoesPanelLayout.createSequentialGroup()
                .addComponent(favoritos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(procura))
        );

        javax.swing.GroupLayout geralPanelLayout = new javax.swing.GroupLayout(geralPanel);
        geralPanel.setLayout(geralPanelLayout);
        geralPanelLayout.setHorizontalGroup(
            geralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(geralPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(geralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projetoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(visoesPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        geralPanelLayout.setVerticalGroup(
            geralPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(geralPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projetoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        opcoes.addTab("Geral", geralPanel);

        lblNomeMapa.setText("Nome Interno:");

        lblPaginaMapa.setText("Página Inicial:");

        nomeMapa.setText("Nome");

        javax.swing.GroupLayout mapaLayout = new javax.swing.GroupLayout(mapa);
        mapa.setLayout(mapaLayout);
        mapaLayout.setHorizontalGroup(
            mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeMapa)
                    .addComponent(lblPaginaMapa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paginaInicial, 0, 327, Short.MAX_VALUE)
                    .addComponent(nomeMapa))
                .addContainerGap())
        );
        mapaLayout.setVerticalGroup(
            mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mapaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeMapa)
                    .addComponent(nomeMapa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaginaMapa)
                    .addComponent(paginaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(258, Short.MAX_VALUE))
        );

        opcoes.addTab("Mapa", mapa);

        adicionarAp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Doc-Add.png"))); // NOI18N
        adicionarAp.setMnemonic('A');
        adicionarAp.setText("Adicionar");

        alterarAp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Doc-Edit_16.png"))); // NOI18N
        alterarAp.setMnemonic('l');
        alterarAp.setText("Alterar");

        removerAp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Doc-Cancel.png"))); // NOI18N
        removerAp.setMnemonic('R');
        removerAp.setText("Remover");

        apresentacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Padrão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollAp.setViewportView(apresentacao);

        javax.swing.GroupLayout apresentacaoPanelLayout = new javax.swing.GroupLayout(apresentacaoPanel);
        apresentacaoPanel.setLayout(apresentacaoPanelLayout);
        apresentacaoPanelLayout.setHorizontalGroup(
            apresentacaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apresentacaoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(apresentacaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollAp, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                    .addGroup(apresentacaoPanelLayout.createSequentialGroup()
                        .addComponent(adicionarAp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alterarAp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removerAp)))
                .addContainerGap())
        );
        apresentacaoPanelLayout.setVerticalGroup(
            apresentacaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(apresentacaoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(apresentacaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adicionarAp)
                    .addComponent(alterarAp)
                    .addComponent(removerAp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollAp, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        opcoes.addTab("Apresentações", apresentacaoPanel);

        lblHelpbroker.setText("HelpBroker Customizado:");

        incluirImp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Doc-Add.png"))); // NOI18N
        incluirImp.setMnemonic('A');
        incluirImp.setText("Adicionar");

        excluirImp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Doc-Edit_16.png"))); // NOI18N
        excluirImp.setMnemonic('l');
        excluirImp.setText("Alterar");

        removerImp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/htmlhelpeditor/images/Doc-Cancel.png"))); // NOI18N
        removerImp.setMnemonic('R');
        removerImp.setText("Remover");

        implementacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MIME Type", "Classe de Visão"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollImp.setViewportView(implementacao);

        javax.swing.GroupLayout implementacaoPanelLayout = new javax.swing.GroupLayout(implementacaoPanel);
        implementacaoPanel.setLayout(implementacaoPanelLayout);
        implementacaoPanelLayout.setHorizontalGroup(
            implementacaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(implementacaoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(implementacaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(implementacaoPanelLayout.createSequentialGroup()
                        .addComponent(lblHelpbroker)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpBroker, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                    .addGroup(implementacaoPanelLayout.createSequentialGroup()
                        .addComponent(incluirImp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluirImp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removerImp))
                    .addComponent(scrollImp, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE))
                .addContainerGap())
        );
        implementacaoPanelLayout.setVerticalGroup(
            implementacaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(implementacaoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(implementacaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHelpbroker)
                    .addComponent(helpBroker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(implementacaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(incluirImp)
                    .addComponent(excluirImp)
                    .addComponent(removerImp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollImp, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        opcoes.addTab("Implementação", implementacaoPanel);

        lblNomeIndice.setText("Nome Interno:");

        lblTipIndice.setText("Tooltip:");

        lblIconeIndice.setText("Ícone Customizado:");

        javax.swing.GroupLayout indicePanelLayout = new javax.swing.GroupLayout(indicePanel);
        indicePanel.setLayout(indicePanelLayout);
        indicePanelLayout.setHorizontalGroup(
            indicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(indicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeIndice)
                    .addComponent(lblTipIndice)
                    .addComponent(lblIconeIndice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(indicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconeIndice, javax.swing.GroupLayout.Alignment.TRAILING, 0, 304, Short.MAX_VALUE)
                    .addComponent(tipIndice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(nomeIndice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addContainerGap())
        );
        indicePanelLayout.setVerticalGroup(
            indicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(indicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(indicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeIndice)
                    .addComponent(nomeIndice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(indicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipIndice)
                    .addComponent(tipIndice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(indicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIconeIndice)
                    .addComponent(iconeIndice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
        );

        opcoes.addTab("Índice", indicePanel);

        lblNomeToc.setText("Nome Interno:");

        lblTipToc.setText("Tooltip:");

        lblIconeToc.setText("Ícone Customizado:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout tocPanelLayout = new javax.swing.GroupLayout(tocPanel);
        tocPanel.setLayout(tocPanelLayout);
        tocPanelLayout.setHorizontalGroup(
            tocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tocPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeToc)
                    .addComponent(lblTipToc)
                    .addComponent(lblIconeToc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, 0, 304, Short.MAX_VALUE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addContainerGap())
        );
        tocPanelLayout.setVerticalGroup(
            tocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tocPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeToc)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipToc)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tocPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIconeToc)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
        );

        opcoes.addTab("TOC", tocPanel);

        jLabel13.setText("Nome Interno:");

        jLabel14.setText("Tooltip:");

        jLabel15.setText("Ícone Customizado:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setText("Palavras de Parada:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout procuraPanelLayout = new javax.swing.GroupLayout(procuraPanel);
        procuraPanel.setLayout(procuraPanelLayout);
        procuraPanelLayout.setHorizontalGroup(
            procuraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(procuraPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(procuraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(procuraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jComboBox4, 0, 302, Short.MAX_VALUE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addContainerGap())
        );
        procuraPanelLayout.setVerticalGroup(
            procuraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(procuraPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(procuraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(procuraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(procuraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(procuraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addContainerGap())
        );

        opcoes.addTab("Busca", procuraPanel);

        lblNomeFav.setText("Nome Interno:");

        lblTipFav.setText("Tooltip:");

        lblIconeFav.setText("Ícone Customizado:");

        javax.swing.GroupLayout favoritosPanelLayout = new javax.swing.GroupLayout(favoritosPanel);
        favoritosPanel.setLayout(favoritosPanelLayout);
        favoritosPanelLayout.setHorizontalGroup(
            favoritosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(favoritosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(favoritosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomeFav)
                    .addComponent(lblTipFav)
                    .addComponent(lblIconeFav))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(favoritosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconeFav, 0, 304, Short.MAX_VALUE)
                    .addComponent(tipFav, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(nomeFav, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                .addContainerGap())
        );
        favoritosPanelLayout.setVerticalGroup(
            favoritosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(favoritosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(favoritosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeFav)
                    .addComponent(nomeFav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(favoritosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipFav)
                    .addComponent(tipFav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(favoritosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIconeFav)
                    .addComponent(iconeFav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(226, Short.MAX_VALUE))
        );

        opcoes.addTab("Favoritos", favoritosPanel);

        getContentPane().add(opcoes, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarAp;
    private javax.swing.JButton alterarAp;
    private javax.swing.JTable apresentacao;
    private javax.swing.JPanel apresentacaoPanel;
    private javax.swing.JButton excluirImp;
    private javax.swing.JCheckBox favoritos;
    private javax.swing.JPanel favoritosPanel;
    private javax.swing.JPanel geralPanel;
    private javax.swing.JTextField helpBroker;
    private javax.swing.JComboBox iconeFav;
    private javax.swing.JComboBox iconeIndice;
    private javax.swing.JTable implementacao;
    private javax.swing.JPanel implementacaoPanel;
    private javax.swing.JButton incluirImp;
    private javax.swing.JPanel indicePanel;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblHelpbroker;
    private javax.swing.JLabel lblIconeFav;
    private javax.swing.JLabel lblIconeIndice;
    private javax.swing.JLabel lblIconeToc;
    private javax.swing.JLabel lblNomeFav;
    private javax.swing.JLabel lblNomeIndice;
    private javax.swing.JLabel lblNomeMapa;
    private javax.swing.JLabel lblNomeToc;
    private javax.swing.JLabel lblPaginaMapa;
    private javax.swing.JLabel lblTipFav;
    private javax.swing.JLabel lblTipIndice;
    private javax.swing.JLabel lblTipToc;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblVersao;
    private javax.swing.JTextField localizacao;
    private javax.swing.JPanel mapa;
    private javax.swing.JTextField nomeFav;
    private javax.swing.JTextField nomeIndice;
    private javax.swing.JLabel nomeMapa;
    private javax.swing.JTabbedPane opcoes;
    private javax.swing.JComboBox paginaInicial;
    private javax.swing.JCheckBox procura;
    private javax.swing.JPanel procuraPanel;
    private javax.swing.JPanel projetoPanel;
    private javax.swing.JButton removerAp;
    private javax.swing.JButton removerImp;
    private javax.swing.JScrollPane scrollAp;
    private javax.swing.JScrollPane scrollImp;
    private javax.swing.JTextField tipFav;
    private javax.swing.JTextField tipIndice;
    private javax.swing.JTextField titulo;
    private javax.swing.JPanel tocPanel;
    private javax.swing.JTextField versao;
    private javax.swing.JPanel visoesPanel;
    // End of variables declaration//GEN-END:variables
}