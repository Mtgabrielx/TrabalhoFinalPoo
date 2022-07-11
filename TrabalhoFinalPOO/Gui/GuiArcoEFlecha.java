package TrabalhoFinalPOO.Gui;

import TrabalhoFinalPOO.Gui.Tabela;
import TrabalhoFinalPOO.Gui.TabelaTorneio;
import TrabalhoFinalPOO.ClasseBasicas.Jogador;
import TrabalhoFinalPOO.ClasseBasicas.TimesPreExistentes;
import TrabalhoFinalPOO.Collection.*;
import TrabalhoFinalPOO.Excecoes.*;
import TrabalhoFinalPOO.Collection.Time;
import TrabalhoFinalPOO.Excecoes.TimeVazioException;
import TrabalhoFinalPOO.Fachada.Fachada;

import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GuiArcoEFlecha {

    private JFrame frmCampeonatoDeArco;
    private Fachada fachada = Fachada.getInstance();

    /**
     * chama a aplicacao.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GuiArcoEFlecha window = new GuiArcoEFlecha();
                    window.frmCampeonatoDeArco.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Cria a aplicacao
     */
    public GuiArcoEFlecha() {
        initialize();
    }

    /**
     * Inicializa o frame
     */
    private void initialize() {
        frmCampeonatoDeArco = new JFrame();
        frmCampeonatoDeArco.setResizable(false);
        frmCampeonatoDeArco.setTitle("Campeonato de Arco e Flecha");
        frmCampeonatoDeArco.setBounds(200, 200, 500, 300);
        frmCampeonatoDeArco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCampeonatoDeArco.getContentPane().setLayout(new BorderLayout(0, 0));

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        frmCampeonatoDeArco.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        JPanel Cadastrar_Jogador = new JPanel();
        Cadastrar_Jogador.setBackground(new Color(245, 245, 220));
        tabbedPane.addTab("Cadastrar Jogador", null, Cadastrar_Jogador, null);
        GridBagLayout gbl_Cadastrar_Jogador = new GridBagLayout();
        gbl_Cadastrar_Jogador.columnWidths = new int[]{30, 30, 63, 70, 133, 133, 30, 30, 30, 59};
        gbl_Cadastrar_Jogador.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
        gbl_Cadastrar_Jogador.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0};
        gbl_Cadastrar_Jogador.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        Cadastrar_Jogador.setLayout(gbl_Cadastrar_Jogador);

        JLabel nomeLabel = new JLabel("Nome:");
        GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
        gbc_nomeLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
        gbc_nomeLabel.gridx = 2;
        gbc_nomeLabel.gridy = 1;
        Cadastrar_Jogador.add(nomeLabel, gbc_nomeLabel);

        JTextField nome = new JTextField();
        nome.setBackground(new Color(255, 250, 240));
        nome.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_nome = new GridBagConstraints();
        gbc_nome.fill = GridBagConstraints.HORIZONTAL;
        gbc_nome.gridwidth = 3;
        gbc_nome.insets = new Insets(0, 0, 5, 5);
        gbc_nome.gridx = 3;
        gbc_nome.gridy = 1;
        Cadastrar_Jogador.add(nome, gbc_nome);
        nome.setColumns(30);

        JLabel Jid = new JLabel("ID:");
        GridBagConstraints gbc_Jid = new GridBagConstraints();
        gbc_Jid.fill = GridBagConstraints.HORIZONTAL;
        gbc_Jid.insets = new Insets(0, 0, 5, 5);
        gbc_Jid.gridx = 2;
        gbc_Jid.gridy = 2;
        Cadastrar_Jogador.add(Jid, gbc_Jid);

        JTextField id = new JTextField();
        id.setBackground(new Color(255, 250, 240));
        id.setHorizontalAlignment(SwingConstants.CENTER);
        id.setColumns(30);
        GridBagConstraints gbc_id = new GridBagConstraints();
        gbc_id.fill = GridBagConstraints.HORIZONTAL;
        gbc_id.insets = new Insets(0, 0, 5, 5);
        gbc_id.gridx = 3;
        gbc_id.gridy = 2;
        Cadastrar_Jogador.add(id, gbc_id);
        id.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) ) {
                    e.consume();
                }
            }
        });


        JLabel precisaoLabel = new JLabel("Precisao:");
        GridBagConstraints gbc_precisaoLabel = new GridBagConstraints();
        gbc_precisaoLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_precisaoLabel.insets = new Insets(0, 0, 5, 5);
        gbc_precisaoLabel.gridx = 2;
        gbc_precisaoLabel.gridy = 3;
        Cadastrar_Jogador.add(precisaoLabel, gbc_precisaoLabel);

        JTextField precisao = new JTextField();
        precisao.setBackground(new Color(255, 250, 240));
        precisao.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_precisao = new GridBagConstraints();
        gbc_precisao.fill = GridBagConstraints.HORIZONTAL;
        gbc_precisao.insets = new Insets(0, 0, 5, 5);
        gbc_precisao.gridx = 3;
        gbc_precisao.gridy = 3;
        Cadastrar_Jogador.add(precisao, gbc_precisao);
        precisao.setColumns(50);

        precisao.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.')) {
                    e.consume();
                }
            }
        });

        JLabel Time = new JLabel("Time:");
        GridBagConstraints gbc_Time = new GridBagConstraints();
        gbc_Time.fill = GridBagConstraints.HORIZONTAL;
        gbc_Time.insets = new Insets(0, 0, 5, 5);
        gbc_Time.gridx = 2;
        gbc_Time.gridy = 4;
        Cadastrar_Jogador.add(Time, gbc_Time);

        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(new Color(255, 250, 240));
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.gridwidth = 2;
        gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBox.insets = new Insets(0, 0, 5, 5);
        gbc_comboBox.gridx = 3;
        gbc_comboBox.gridy = 4;
        Cadastrar_Jogador.add(comboBox, gbc_comboBox);

        JLabel lesionado = new JLabel("Lesionado:");
        GridBagConstraints gbc_lesionado = new GridBagConstraints();
        gbc_lesionado.fill = GridBagConstraints.HORIZONTAL;
        gbc_lesionado.insets = new Insets(0, 0, 5, 5);
        gbc_lesionado.gridx = 2;
        gbc_lesionado.gridy = 5;
        Cadastrar_Jogador.add(lesionado, gbc_lesionado);

        JCheckBox lesionadoCheck = new JCheckBox("Sim");
        lesionadoCheck.setBackground(new Color(245, 245, 220));
        GridBagConstraints gbc_lesionadoCheck = new GridBagConstraints();
        gbc_lesionadoCheck.insets = new Insets(0, 0, 5, 5);
        gbc_lesionadoCheck.gridx = 3;
        gbc_lesionadoCheck.gridy = 5;
        Cadastrar_Jogador.add(lesionadoCheck, gbc_lesionadoCheck);

        JCheckBox noLesionadoCheck = new JCheckBox("Não");
        noLesionadoCheck.setBackground(new Color(245, 245, 220));
        GridBagConstraints gbc_noLesionadoCheck = new GridBagConstraints();
        gbc_noLesionadoCheck.anchor = GridBagConstraints.WEST;
        gbc_noLesionadoCheck.insets = new Insets(0, 0, 5, 5);
        gbc_noLesionadoCheck.gridx = 4;
        gbc_noLesionadoCheck.gridy = 5;
        Cadastrar_Jogador.add(noLesionadoCheck, gbc_noLesionadoCheck);

        lesionadoCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lesionadoCheck.isSelected()){
                    noLesionadoCheck.setSelected(false);
                }
            }
        });

        noLesionadoCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(noLesionadoCheck.isSelected()){
                    lesionadoCheck.setSelected(false);
                }
            }
        });

        // consulta um jogador pelo seu ID
        JButton consultar = new JButton("Consultar");
        consultar.setBackground(new Color(238, 232, 170));

        GridBagConstraints gbc_consultar = new GridBagConstraints();
        gbc_consultar.gridwidth = 2;
        gbc_consultar.fill = GridBagConstraints.HORIZONTAL;
        gbc_consultar.insets = new Insets(0, 0, 5, 5);
        gbc_consultar.gridx = 2;
        gbc_consultar.gridy = 7;
        Cadastrar_Jogador.add(consultar, gbc_consultar);
        consultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String buscar = JOptionPane.showInputDialog("Digite o ID do candidato:");
                try {
                    Jogador procurado = fachada.consultarJogador(Integer.parseInt(buscar));
                    nome.setText(procurado.getNome());
                    id.setText(String.valueOf(procurado.getId()));
                    precisao.setText(String.valueOf(procurado.getPrecisao()));
                    comboBox.setSelectedItem(fachada.jogadorPertenceTime(procurado.getId()).getNome());
                    if(procurado.isLesionado()) {
                        lesionadoCheck.setSelected(true);
                        noLesionadoCheck.setSelected(false);
                    }
                    else{
                        noLesionadoCheck.setSelected(true);
                        lesionadoCheck.setSelected(false);
                    };

                } catch (TrabalhoFinalPOO.Excecoes.JogadorInexistenteException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Jogador Inexistente!", "Mensagem",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        // adiciona um jogador
        JButton adicionar = new JButton("Adicionar");
        adicionar.setBackground(new Color(238, 232, 170));

        GridBagConstraints gbc_adicionar = new GridBagConstraints();
        gbc_adicionar.fill = GridBagConstraints.HORIZONTAL;
        gbc_adicionar.insets = new Insets(0, 0, 5, 5);
        gbc_adicionar.gridx = 4;
        gbc_adicionar.gridy = 7;
        Cadastrar_Jogador.add(adicionar, gbc_adicionar);

        adicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (precisao.getText().isEmpty() || nome.getText().isEmpty() || comboBox.getSelectedItem() == null || id.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Preencha todos os campo!", "Mensagem",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    try {
                        fachada.consultarJogador(Integer.parseInt(id.getText()));
                        JOptionPane.showMessageDialog(null,
                                "Jogador já existente!", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (TrabalhoFinalPOO.Excecoes.JogadorInexistenteException ex) {
                        double valorPrescisao = Double.parseDouble(precisao.getText());
                        if (valorPrescisao < 1) {
                            Jogador novo = new Jogador(nome.getText(), Integer.parseInt(id.getText()),
                                    valorPrescisao, lesionadoCheck.isSelected());
                            String nomeTime = (String) comboBox.getSelectedItem();
                            TrabalhoFinalPOO.Collection.Time time = fachada.consultarTime(nomeTime);
                            try {
                                fachada.cadastrarJogador(nomeTime, novo);
                            } catch (TrabalhoFinalPOO.Excecoes.TimeCompletoException exc) {
                                JOptionPane.showMessageDialog(null,
                                        "Time Completo!", "Mensagem",
                                        JOptionPane.INFORMATION_MESSAGE);
                            }
                            nome.setText("");
                            id.setText("");
                            precisao.setText("");
                            comboBox.setSelectedItem(0);
                            lesionadoCheck.setSelected(false);
                            noLesionadoCheck.setSelected(false);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,
                                    "A precisão é um número real que vai de 0 a 1", "Mensagem",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        });

        // exclui um jogador
        JButton excluir = new JButton("Excluir");
        excluir.setBackground(new Color(238, 232, 170));

        GridBagConstraints gbc_excluir = new GridBagConstraints();
        gbc_excluir.fill = GridBagConstraints.HORIZONTAL;
        gbc_excluir.insets = new Insets(0, 0, 5, 5);
        gbc_excluir.gridx = 5;
        gbc_excluir.gridy = 7;
        Cadastrar_Jogador.add(excluir, gbc_excluir);

        excluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String buscar = JOptionPane.showInputDialog("Digite o ID do candidato:");
                try {
                    fachada.excluirJogador(Integer.parseInt(buscar));
                } catch (TrabalhoFinalPOO.Excecoes.JogadorInexistenteException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Jogador Inexistente", "Mensagem",
                            JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        JPanel Cadastrar_Time = new JPanel();
        Cadastrar_Time.setBackground(new Color(245, 245, 220));
        tabbedPane.addTab("Cadastrar Time", null, Cadastrar_Time, null);
        GridBagLayout gbl_Cadastrar_Time = new GridBagLayout();
        gbl_Cadastrar_Time.columnWidths = new int[]{33, 33, 33, 133, 133, 133, 33, 33, 33, 0};
        gbl_Cadastrar_Time.rowHeights = new int[]{20, 30, 30, 30, 30, 30};
        gbl_Cadastrar_Time.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_Cadastrar_Time.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        Cadastrar_Time.setLayout(gbl_Cadastrar_Time);

        JLabel nome_Time = new JLabel("Nome do Time:");
        nome_Time.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_nome_Time = new GridBagConstraints();
        gbc_nome_Time.fill = GridBagConstraints.HORIZONTAL;
        gbc_nome_Time.insets = new Insets(0, 0, 5, 5);
        gbc_nome_Time.gridx = 3;
        gbc_nome_Time.gridy = 1;
        Cadastrar_Time.add(nome_Time, gbc_nome_Time);

        JTextField time_1 = new JTextField();
        time_1.setBackground(new Color(255, 250, 240));
        time_1.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_time_1 = new GridBagConstraints();
        gbc_time_1.gridwidth = 2;
        gbc_time_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_time_1.insets = new Insets(0, 0, 5, 0);
        gbc_time_1.gridx = 4;
        gbc_time_1.gridy = 1;
        Cadastrar_Time.add(time_1, gbc_time_1);
        time_1.setColumns(10);

        JButton consultarNoTime = new JButton("Consultar");
        consultarNoTime.setBackground(new Color(238, 232, 170));
        GridBagConstraints gbc_consultarNoTime = new GridBagConstraints();
        gbc_consultarNoTime.fill = GridBagConstraints.HORIZONTAL;
        gbc_consultarNoTime.insets = new Insets(0, 0, 5, 5);
        gbc_consultarNoTime.gridx = 3;
        gbc_consultarNoTime.gridy = 4;
        Cadastrar_Time.add(consultarNoTime, gbc_consultarNoTime);

        // consulta do time
        consultarNoTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buscar = JOptionPane.showInputDialog("Digite o nome do Time:");
                TrabalhoFinalPOO.Collection.Time time = fachada.consultarTime(buscar);
                if (time != null) {
                    new Tabela(time);
                } else if (!buscar.isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Time Inexistente", "Mensagem",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Adiciona um time
        JButton AdicionarTime = new JButton("Adicionar");
        AdicionarTime.setBackground(new Color(238, 232, 170));

        GridBagConstraints gbc_AdicionarTime = new GridBagConstraints();
        gbc_AdicionarTime.fill = GridBagConstraints.HORIZONTAL;
        gbc_AdicionarTime.insets = new Insets(0, 0, 5, 5);
        gbc_AdicionarTime.gridx = 4;
        gbc_AdicionarTime.gridy = 4;
        Cadastrar_Time.add(AdicionarTime, gbc_AdicionarTime);

        AdicionarTime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (time_1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Adicione o nome do time", "Mensagem",
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (fachada.totalTimes() >= 8) {
                    JOptionPane.showMessageDialog(null,
                            "Número máximo de times cadastrados!", "Mensagem",
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (fachada.validarTime(time_1.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Time já existente!", "Mensagem",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Time novo = new Time(time_1.getText());
                    fachada.adicionarTime(novo);
                    comboBox.addItem(time_1.getText());
                    time_1.setText("");
                }
            }
        });

        JButton excluirTime = new JButton("Excluir");
        excluirTime.setBackground(new Color(238, 232, 170));

        GridBagConstraints gbc_excluirTime = new GridBagConstraints();
        gbc_excluirTime.insets = new Insets(0, 0, 5, 0);
        gbc_excluirTime.fill = GridBagConstraints.HORIZONTAL;
        gbc_excluirTime.gridx = 5;
        gbc_excluirTime.gridy = 4;
        Cadastrar_Time.add(excluirTime, gbc_excluirTime);

        excluirTime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String buscar = JOptionPane.showInputDialog("Digite o nome do Time:");
                try {
                    fachada.excluirTime(buscar);
                    comboBox.removeItem(buscar);
                } catch (TrabalhoFinalPOO.Excecoes.TimeInexistenteException ex) {
                    if (!buscar.isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Time Inexistente", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });

        JPanel Campeonato = new JPanel();
        Campeonato.setBackground(new Color(245, 245, 220));
        tabbedPane.addTab("Campeonato", null, Campeonato, null);
        GridBagLayout gbl_Campeonato = new GridBagLayout();
        gbl_Campeonato.columnWidths = new int[]{140, 200, 150};
        gbl_Campeonato.rowHeights = new int[]{20, 30, 30};
        gbl_Campeonato.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_Campeonato.rowWeights = new double[]{0.0, 0.0, 0.0};
        Campeonato.setLayout(gbl_Campeonato);

        JButton comecarTorneio = new JButton("Começar Torneio");
        comecarTorneio.setBackground(new Color(238, 232, 170));
        GridBagConstraints gbc_comecarTorneio = new GridBagConstraints();
        gbc_comecarTorneio.fill = GridBagConstraints.BOTH;
        gbc_comecarTorneio.gridheight = 3;
        gbc_comecarTorneio.insets = new Insets(0, 0, 5, 0);
        gbc_comecarTorneio.gridx = 1;
        gbc_comecarTorneio.gridy = 0;
        Campeonato.add(comecarTorneio, gbc_comecarTorneio);

        // comeca o torneio
        comecarTorneio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fachada.getTimes().size() == 8) {
                    try {
                        new TabelaTorneio(fachada.comecarTorneio());
                    } catch (TrabalhoFinalPOO.Excecoes.TimeIncompletoException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null,
                                "Um time está incompleto", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (TimeVazioException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null,
                                "Um time está vazio", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "É necessário cadastrar 8 times para o jogo começar!!!", "Mensagem",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        JPanel Times_Pre_Existentes = new JPanel();
        tabbedPane.addTab("Times Pre Existentes", null, Times_Pre_Existentes, null);
        Times_Pre_Existentes.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 220));
        Times_Pre_Existentes.add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lbTimesExistentesl = new JLabel("Clique em marcar para adicionar os times existentes ao torneio");
        panel.add(lbTimesExistentesl);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(245, 245, 220));
        Times_Pre_Existentes.add(panel_1, BorderLayout.CENTER);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{100, 100, 100, 100, 100, 100};
        gbl_panel_1.rowHeights = new int[]{30, 20, 20, 10, 10, 30, 0, 30};
        gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        panel_1.setLayout(gbl_panel_1);

        JRadioButton timeAzul = new JRadioButton("Time Azul");
        timeAzul.setBackground(new Color(245, 245, 220));
        GridBagConstraints gbc_timeAzul = new GridBagConstraints();
        gbc_timeAzul.fill = GridBagConstraints.VERTICAL;
        gbc_timeAzul.anchor = GridBagConstraints.WEST;
        gbc_timeAzul.insets = new Insets(0, 0, 5, 5);
        gbc_timeAzul.gridx = 1;
        gbc_timeAzul.gridy = 1;
        panel_1.add(timeAzul, gbc_timeAzul);

        JButton informacoesAzul = new JButton("Informações");
        informacoesAzul.setBackground(new Color(255, 250, 205));
        GridBagConstraints gbc_informacoesAzul = new GridBagConstraints();
        gbc_informacoesAzul.fill = GridBagConstraints.VERTICAL;
        gbc_informacoesAzul.insets = new Insets(0, 0, 5, 5);
        gbc_informacoesAzul.gridx = 2;
        gbc_informacoesAzul.gridy = 1;
        panel_1.add(informacoesAzul, gbc_informacoesAzul);

        JRadioButton timeReal = new JRadioButton("Time Real");
        timeReal.setBackground(new Color(245, 245, 220));
        GridBagConstraints gbc_timeReal = new GridBagConstraints();
        gbc_timeReal.fill = GridBagConstraints.VERTICAL;
        gbc_timeReal.anchor = GridBagConstraints.WEST;
        gbc_timeReal.insets = new Insets(0, 0, 5, 5);
        gbc_timeReal.gridx = 3;
        gbc_timeReal.gridy = 1;
        panel_1.add(timeReal, gbc_timeReal);

        JButton informacoesReal = new JButton("Informações");
        informacoesReal.setBackground(new Color(255, 250, 205));
        GridBagConstraints gbc_informacoesReal = new GridBagConstraints();
        gbc_informacoesReal.fill = GridBagConstraints.VERTICAL;
        gbc_informacoesReal.insets = new Insets(0, 0, 5, 5);
        gbc_informacoesReal.gridx = 4;
        gbc_informacoesReal.gridy = 1;
        panel_1.add(informacoesReal, gbc_informacoesReal);

        JRadioButton timeAmarelo = new JRadioButton("Time Amarelo");
        timeAmarelo.setBackground(new Color(245, 245, 220));
        GridBagConstraints gbc_timeAmarelo = new GridBagConstraints();
        gbc_timeAmarelo.anchor = GridBagConstraints.WEST;
        gbc_timeAmarelo.insets = new Insets(0, 0, 5, 5);
        gbc_timeAmarelo.gridx = 1;
        gbc_timeAmarelo.gridy = 2;
        panel_1.add(timeAmarelo, gbc_timeAmarelo);

        JButton informacoesAmarelo = new JButton("Informações");
        informacoesAmarelo.setBackground(new Color(255, 250, 205));
        GridBagConstraints gbc_informacoesAmarelo = new GridBagConstraints();
        gbc_informacoesAmarelo.insets = new Insets(0, 0, 5, 5);
        gbc_informacoesAmarelo.gridx = 2;
        gbc_informacoesAmarelo.gridy = 2;
        panel_1.add(informacoesAmarelo, gbc_informacoesAmarelo);

        JRadioButton timeVermelho = new JRadioButton("Time Vermelho");
        timeVermelho.setBackground(new Color(245, 245, 220));
        GridBagConstraints gbc_timeVermelho = new GridBagConstraints();
        gbc_timeVermelho.anchor = GridBagConstraints.WEST;
        gbc_timeVermelho.insets = new Insets(0, 0, 5, 5);
        gbc_timeVermelho.gridx = 3;
        gbc_timeVermelho.gridy = 2;
        panel_1.add(timeVermelho, gbc_timeVermelho);

        JButton informacoesVermelho = new JButton("Informações");
        informacoesVermelho.setBackground(new Color(255, 250, 205));
        GridBagConstraints gbc_informacoesVermelho = new GridBagConstraints();
        gbc_informacoesVermelho.insets = new Insets(0, 0, 5, 5);
        gbc_informacoesVermelho.gridx = 4;
        gbc_informacoesVermelho.gridy = 2;
        panel_1.add(informacoesVermelho, gbc_informacoesVermelho);

        JRadioButton timeCinza = new JRadioButton("Time Cinza");
        timeCinza.setBackground(new Color(245, 245, 220));
        GridBagConstraints gbc_timeCinza = new GridBagConstraints();
        gbc_timeCinza.anchor = GridBagConstraints.WEST;
        gbc_timeCinza.insets = new Insets(0, 0, 5, 5);
        gbc_timeCinza.gridx = 1;
        gbc_timeCinza.gridy = 3;
        panel_1.add(timeCinza, gbc_timeCinza);

        JButton informacoesCinza = new JButton("Informações");
        informacoesCinza.setBackground(new Color(255, 250, 205));
        GridBagConstraints gbc_informacoesCinza = new GridBagConstraints();
        gbc_informacoesCinza.insets = new Insets(0, 0, 5, 5);
        gbc_informacoesCinza.gridx = 2;
        gbc_informacoesCinza.gridy = 3;
        panel_1.add(informacoesCinza, gbc_informacoesCinza);

        JRadioButton timeLaranja = new JRadioButton("Time Laranja");
        timeLaranja.setBackground(new Color(245, 245, 220));
        GridBagConstraints gbc_timeLaranja = new GridBagConstraints();
        gbc_timeLaranja.anchor = GridBagConstraints.WEST;
        gbc_timeLaranja.insets = new Insets(0, 0, 5, 5);
        gbc_timeLaranja.gridx = 3;
        gbc_timeLaranja.gridy = 3;
        panel_1.add(timeLaranja, gbc_timeLaranja);

        JButton informacoesLaranja = new JButton("Informações");
        informacoesLaranja.setBackground(new Color(255, 250, 205));
        GridBagConstraints gbc_informacoesLaranja = new GridBagConstraints();
        gbc_informacoesLaranja.insets = new Insets(0, 0, 5, 5);
        gbc_informacoesLaranja.gridx = 4;
        gbc_informacoesLaranja.gridy = 3;
        panel_1.add(informacoesLaranja, gbc_informacoesLaranja);

        JRadioButton timeVasco = new JRadioButton("Time Vasco");
        timeVasco.setBackground(new Color(245, 245, 220));
        GridBagConstraints gbc_timeVasco = new GridBagConstraints();
        gbc_timeVasco.anchor = GridBagConstraints.WEST;
        gbc_timeVasco.insets = new Insets(0, 0, 5, 5);
        gbc_timeVasco.gridx = 1;
        gbc_timeVasco.gridy = 4;
        panel_1.add(timeVasco, gbc_timeVasco);

        JButton informacoesVasco = new JButton("Informações");
        informacoesVasco.setBackground(new Color(255, 250, 205));
        GridBagConstraints gbc_informacoesVasco = new GridBagConstraints();
        gbc_informacoesVasco.insets = new Insets(0, 0, 5, 5);
        gbc_informacoesVasco.gridx = 2;
        gbc_informacoesVasco.gridy = 4;
        panel_1.add(informacoesVasco, gbc_informacoesVasco);

        JRadioButton timeVerde = new JRadioButton("Time Verde");
        timeVerde.setBackground(new Color(245, 245, 220));
        GridBagConstraints gbc_timeVerde = new GridBagConstraints();
        gbc_timeVerde.anchor = GridBagConstraints.WEST;
        gbc_timeVerde.insets = new Insets(0, 0, 5, 5);
        gbc_timeVerde.gridx = 3;
        gbc_timeVerde.gridy = 4;
        panel_1.add(timeVerde, gbc_timeVerde);

        JButton informacoesVerde = new JButton("Informações");
        informacoesVerde.setBackground(new Color(255, 250, 205));
        GridBagConstraints gbc_informacoesVerde = new GridBagConstraints();
        gbc_informacoesVerde.insets = new Insets(0, 0, 5, 5);
        gbc_informacoesVerde.gridx = 4;
        gbc_informacoesVerde.gridy = 4;
        panel_1.add(informacoesVerde, gbc_informacoesVerde);

        // adiciona os times pre existentes selecionados ao torneio
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBackground(new Color(238, 232, 170));
        btnAdicionar.setVerticalAlignment(SwingConstants.BOTTOM);
        GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
        gbc_btnAdicionar.gridwidth = 2;
        gbc_btnAdicionar.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnAdicionar.insets = new Insets(0, 0, 5, 5);
        gbc_btnAdicionar.gridx = 2;
        gbc_btnAdicionar.gridy = 6;
        panel_1.add(btnAdicionar, gbc_btnAdicionar);

        informacoesCinza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tabela(TimesPreExistentes.getTimeCinza());
            }
        });

        informacoesAmarelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tabela(TimesPreExistentes.getTimeAmarelo());
            }
        });

        informacoesLaranja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tabela(TimesPreExistentes.getTimeLaranja());
            }
        });

        informacoesAzul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tabela(TimesPreExistentes.getTimeAzul());
            }
        });

        informacoesVasco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tabela(TimesPreExistentes.getTimeVasco());
            }
        });

        informacoesReal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tabela(TimesPreExistentes.getTimeReal());
            }
        });

        informacoesVerde.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tabela(TimesPreExistentes.getTimeVerde());
            }
        });

        informacoesVermelho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tabela(TimesPreExistentes.getTimeVermelho());
            }
        });

        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = fachada.totalTimes();
                if (timeAmarelo.isSelected()) {
                    if (num >= 8) {
                        JOptionPane.showMessageDialog(null,
                                "Número máximo de times cadastrados", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (!fachada.validarTime("timeAmarelo")) {
                        fachada.adicionarTime(TimesPreExistentes.getTimeAmarelo());
                        comboBox.addItem("timeAmarelo");
                        num++;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Time já adicionado", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    timeAmarelo.setSelected(false);
                }
                if (timeCinza.isSelected()) {
                    if (num >= 8) {
                        JOptionPane.showMessageDialog(null,
                                "Número máximo de times cadastrados", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (!fachada.validarTime("timeCinza")) {
                        fachada.adicionarTime(TimesPreExistentes.getTimeCinza());
                        comboBox.addItem("timeCinza");
                        num++;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Time já adicionado", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    timeCinza.setSelected(false);
                }
                if (timeLaranja.isSelected()) {
                    if (num >= 8) {
                        JOptionPane.showMessageDialog(null,
                                "Número máximo de times cadastrados", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (!fachada.validarTime("timeLaranja")) {
                        fachada.adicionarTime(TimesPreExistentes.getTimeLaranja());
                        comboBox.addItem("timeLaranja");
                        num++;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Time já adicionado", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    timeLaranja.setSelected(false);
                }
                if (timeAzul.isSelected()) {
                    if (num >= 8) {
                        JOptionPane.showMessageDialog(null,
                                "Número máximo de times cadastrados", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (!fachada.validarTime("timeAzul")) {
                        fachada.adicionarTime(TimesPreExistentes.getTimeAzul());
                        comboBox.addItem("timeAzul");
                        num++;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Time já adicionado", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    timeAzul.setSelected(false);
                }
                if (timeReal.isSelected()) {
                    if (num >= 8) {
                        JOptionPane.showMessageDialog(null,
                                "Número máximo de times cadastrados", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (!fachada.validarTime("timeReal")) {
                        fachada.adicionarTime(TimesPreExistentes.getTimeReal());
                        comboBox.addItem("timeReal");
                        num++;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Time já adicionado", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    timeReal.setSelected(false);
                }
                if (timeVasco.isSelected()) {
                    if (num >= 8) {
                        JOptionPane.showMessageDialog(null,
                                "Número máximo de times cadastrados", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (!fachada.validarTime("timeVasco")) {
                        fachada.adicionarTime(TimesPreExistentes.getTimeVasco());
                        comboBox.addItem("timeVasco");
                        num++;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Time já adicionado", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    timeVasco.setSelected(false);
                }
                if (timeVerde.isSelected()) {
                    if (num >= 8) {
                        JOptionPane.showMessageDialog(null,
                                "Número máximo de times cadastrados", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (!fachada.validarTime("timeVerde")) {
                        fachada.adicionarTime(TimesPreExistentes.getTimeVerde());
                        comboBox.addItem("timeVerde");
                        num++;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Time já adicionado", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    timeVerde.setSelected(false);
                }
                if (timeVermelho.isSelected()) {
                    if (num >= 8) {
                        JOptionPane.showMessageDialog(null,
                                "Número máximo de times cadastrados", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else if (!fachada.validarTime("timeVermelho")) {
                        fachada.adicionarTime(TimesPreExistentes.getTimeVermelho());
                        comboBox.addItem("timeVermelho");
                        num++;
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Time já adicionado", "Mensagem",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    timeVermelho.setSelected(false);
                }
            }
        });

    }

}