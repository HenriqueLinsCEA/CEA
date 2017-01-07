package impressao;

public class TelaBoletim extends javax.swing.JFrame{  
	  
    FormatacaoConteudo conteudoCentralizado = new FormatacaoConteudo();  
    FormatacaoConteudo corNomes = new FormatacaoConteudo();  
    Color nomesCor = new Color (202, 225, 255);  
  
    public TelaBoletim() {          
          
    }  
  
    public TelaBoletim(List<AlunoBoletimVisualizacao> alunos){  
        final JButton Imprimir = new JButton("Imprimir");  
        JLabel nome = null;  
        JLabel turma = null;  
        JPanel panel = new JPanel();  
        JTable table = null;  
        JScrollPane jstable = null;  
        JScrollPane jspane = null;  
        BoletimTabelModel modelBoletim = null;  
        List<DisciplinaBoletimVisualizacao> disciplinasBoletim = null;  
        corNomes.setBackground(nomesCor);  
        conteudoCentralizado.setHorizontalAlignment(SwingConstants.CENTER);  
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  
        panel.setBorder(new EmptyBorder(40, 60, 40, 60));  
        panel.add(Imprimir);  
        panel.add(Box.createRigidArea(new Dimension(30, 10)));  
        for (AlunoBoletimVisualizacao alunoBoletimVisualizacao : alunos) {  
            nome = new JLabel("Aluno: " + alunoBoletimVisualizacao.getNome());              
            turma = new JLabel("Turma: " + alunoBoletimVisualizacao.getTurma());  
            panel.add(new JLabel("Escola Municipal Amadeu Bolognesi"));  
            panel.add(nome);  
            panel.add(turma);  
            disciplinasBoletim = alunoBoletimVisualizacao.getDisciplinas();              
            modelBoletim = new BoletimTabelModel(disciplinasBoletim);  
            table = new JTable();  
            table.setModel(modelBoletim);  
            table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
            table.getColumnModel().getColumn(0).setPreferredWidth(150);  
            table.getColumnModel().getColumn(1).setPreferredWidth(57);  
            table.getColumnModel().getColumn(2).setPreferredWidth(90);  
            table.getColumnModel().getColumn(3).setPreferredWidth(57);  
            table.getColumnModel().getColumn(4).setPreferredWidth(57);  
            table.getColumnModel().getColumn(5).setPreferredWidth(90);  
            table.getColumnModel().getColumn(6).setPreferredWidth(57);  
            table.getColumnModel().getColumn(7).setPreferredWidth(57);  
            table.getColumnModel().getColumn(8).setPreferredWidth(90);  
            table.getColumnModel().getColumn(9).setPreferredWidth(57);  
            table.getColumnModel().getColumn(10).setPreferredWidth(75);  
            table.getColumnModel().getColumn(11).setPreferredWidth(90);  
            table.setPreferredScrollableViewportSize(new Dimension(927,128));  
            table.getColumnModel().getColumn(0).setCellRenderer(corNomes);  
            table.getColumnModel().getColumn(1).setCellRenderer(conteudoCentralizado);  
            table.getColumnModel().getColumn(2).setCellRenderer(conteudoCentralizado);  
            table.getColumnModel().getColumn(3).setCellRenderer(conteudoCentralizado);  
            table.getColumnModel().getColumn(4).setCellRenderer(conteudoCentralizado);  
            table.getColumnModel().getColumn(5).setCellRenderer(conteudoCentralizado);  
            table.getColumnModel().getColumn(6).setCellRenderer(conteudoCentralizado);  
            table.getColumnModel().getColumn(7).setCellRenderer(conteudoCentralizado);  
            table.getColumnModel().getColumn(8).setCellRenderer(conteudoCentralizado);  
            table.getColumnModel().getColumn(9).setCellRenderer(conteudoCentralizado);  
            table.getColumnModel().getColumn(10).setCellRenderer(conteudoCentralizado);  
            table.getColumnModel().getColumn(11).setCellRenderer(conteudoCentralizado);  
            jstable = new JScrollPane();  
            jstable.setViewportView(table);  
            panel.add(jstable);  
            panel.add(Box.createRigidArea(new Dimension(30, 100)));  
        }  
        jspane = new JScrollPane();  
        jspane.setViewportView(panel);  
        this.add(jspane);  
        this.setLocation(100, 5);  
        initComponents();  
    }  
  
    @SuppressWarnings("unchecked")  
        private void initComponents() {  
  
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);  
        setTitle("Boletins");  
        setMinimumSize(new java.awt.Dimension(700, 300));  
        setResizable(false);  
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));  
  
        pack();  
    }  
  
    public static void main(String args[]) {  
        java.awt.EventQueue.invokeLater(new Runnable() {  
            public void run() {  
                new TelaBoletim().setVisible(true);  
            }  
        });  
    }  
  
}  