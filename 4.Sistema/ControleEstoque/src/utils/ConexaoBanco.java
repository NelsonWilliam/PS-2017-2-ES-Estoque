package utils;

import java.io.File;
import java.sql.*;
import model.FuncaoEnum;
import model.Funcionario;
import model.Login;

/**
 * Singleton utilitario para efetuar consultas no banco de dados.
 *
 * @author Nelson
 */
public class ConexaoBanco {

    /**
     * Nome do arquivo correspondente ao banco de dados. 
     */
    private static final String ARQUIVO_BANCO = "banco.db";

    /**
     * Declaração do objeto ConexaoBanco.
     */
    private static ConexaoBanco instance = null;

    /**
     * Declaração do objeto.
     */
    private Connection conexao = null;

    /**
     * Construtor.
     */
    private ConexaoBanco() {
    }

    /**
     * Verifica se há uma instância da ConexaoBanco.
     * 
     * @return A instância de ConexaoBanco. 
     */
    public static ConexaoBanco getInstance() {
        if (instance == null) {
            instance = new ConexaoBanco();
        }
        return instance;
    }

    /**
     * Conecta-se ao banco ou cria um novo caso não exista.
     *
     * @throws SQLException
     */
    public void conectar() throws SQLException {

        String dir = System.getProperty("user.dir") + File.separator + ARQUIVO_BANCO;
        String bancoDir = "jdbc:sqlite:" + dir;

        File file = new File(dir);
        boolean novoBanco = false;
        if (!file.exists()) {
            novoBanco = true;
        }

        conexao = DriverManager.getConnection(bancoDir);
        System.out.println("Conexão com SQLite estabelecida.");

        if (novoBanco) {
            criarTabelas();
            inserirFuncionariosIniciais();
            Mensagens.exibirAviso("Um novo banco de dados foi criado com "
                    + "funcionários inciais.");
        }
    }

    /**
     * Fecha a conexão com o banco.
     *
     * @throws SQLException
     */
    public void desconectar() throws SQLException {
        if (conexao != null) {
            conexao.close();
        }
    }

    /**
     * Cria as tabelas do banco, caso não existam.
     *
     * @throws java.sql.SQLException
     */
    private void criarTabelas() throws SQLException {
        Statement stmt;
        String query;

        //FUNCIONARIO
        stmt = conexao.createStatement();
        query = "CREATE TABLE IF NOT EXISTS FUNCIONARIO (\n"
                + "  `Cpf` VARCHAR(9) NOT NULL,\n"
                + "  `Nome` VARCHAR(45) NULL,\n"
                + "  `User` VARCHAR(45) NOT NULL,\n"
                + "  `Senha` VARCHAR(45) NOT NULL,\n"
                + "  `Funcao` VARCHAR(13) NULL,\n"
                + "  PRIMARY KEY (`Cpf`))";
        stmt.executeUpdate(query);
        stmt = conexao.createStatement();
        query = "CREATE UNIQUE INDEX IF NOT EXISTS `Cpf_UNIQUE` "
                + "ON `FUNCIONARIO` (`Cpf`);";
        stmt.executeUpdate(query);
        stmt = conexao.createStatement();
        query = "CREATE UNIQUE INDEX IF NOT EXISTS `User_UNIQUE` "
                + "ON `FUNCIONARIO` (`User`);";
        stmt.executeUpdate(query);
    }

    /**
     * Insere os funcionários padrão.
     * 
     * @throws SQLException Erros relacionados a SQL.
     */
    private void inserirFuncionariosIniciais() throws SQLException {
        Funcionario f;

        f = new Funcionario();
        f.setCpf("12345678901");
        f.setNome("Administrador");
        f.setLogin(new Login("admin", "12345"));
        f.setFuncao(FuncaoEnum.ADMINISTRADOR.toString());
        Funcionario.inserir(f);

        f = new Funcionario();
        f.setCpf("12345678902");
        f.setNome("Operador");
        f.setLogin(new Login("operador", "12345"));
        f.setFuncao(FuncaoEnum.OPERADOR.toString());
        Funcionario.inserir(f);

        f = new Funcionario();
        f.setCpf("12345678903");
        f.setNome("Gestor");
        f.setLogin(new Login("gestor", "12345"));
        f.setFuncao(FuncaoEnum.GESTOR.toString());
        Funcionario.inserir(f);

    }

    /**
     * Insere dados no banco.
     * 
     * @param tabela A tabela a ter dados inseridos.
     * @param colunas A coluna a ter dados inseridos.
     * @param valores Os valores a serem inseridos como dados.
     * @throws SQLException Erros relacionados a SQL.
     */
    public void inserir(String tabela, String colunas, String valores)
            throws SQLException {

        if (conexao == null) {
            conectar();
        }

        String sql = "INSERT "
                + " INTO `" + tabela + "` (" + colunas + ") VALUES ("
                + valores + ");";

        System.out.println(sql);
        PreparedStatement s = conexao.prepareStatement(sql);
        s.executeUpdate();
    }

    /**
     * Consulta SQL simples.
     * 
     * @param tabela A tabela a ser consultada.
     * @param colunas As colunas a serem consultadas.
     * @param where Determinada cláusula a especificar a consulta.
     * @return A consulta propriamente dita.
     * @throws SQLException Erros relacionados a SQL.
     */
    public ResultSet obter(String tabela, String colunas, String where)
            throws SQLException {
        if (conexao == null) {
            conectar();
        }

        String sql = "SELECT " + colunas + " FROM `" + tabela + "`"
                + (where.isEmpty() ? "" : (" WHERE " + where));
        System.out.println(sql);
        PreparedStatement stmt = conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    /**
     * Atualiza dados no banco.
     * 
     * @param tabela A tabela a ser atualizada.
     * @param sets O elemento a ser alterado.
     * @param where Determinada cláusula a especificar a atualização.
     * @throws SQLException 
     */
    public void atualizar(String tabela, String sets, String where)
            throws SQLException {
        if (conexao == null) {
            conectar();
        }

        String sql = "UPDATE `" + tabela + "` SET " + sets
                + " WHERE " + where;
        System.out.println(sql);
        PreparedStatement s = conexao.prepareStatement(sql);
        s.executeUpdate();
    }

    /**
     * Deleta dados de determinada tabela.
     * 
     * @param tabela A tabela que terá o dado excluído.
     * @param where Determinada cláusula a especificar a exclusão.
     * @throws SQLException Erros relacionados a SQL.
     */
    public void deletar(String tabela, String where) throws SQLException {
        if (conexao == null) {
            conectar();
        }

        String sql = "DELETE FROM `" + tabela + "` WHERE " + where;
        System.out.println(sql);
        PreparedStatement s = conexao.prepareStatement(sql);
        s.executeUpdate();
    }

}
