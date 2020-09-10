package br.edu.uniso;

import java.sql.*;

public class ConexaoJDBC {

    public static void main(String[] args) {


        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://34.225.155.37:3306/pedro_tizl",
                    "pedro_tizl", "430994");
           boolean valido =  c.isValid(1000);
           System.out.println("conexao eh valida :" + valido);
           //pegar aqui o que tem no banco
            Statement s = c.createStatement();
            //executar um select
            ResultSet rs = s.executeQuery("select * from ALUNO");
            while (rs.next()){

                System.out.println("Ra :" + rs.getInt("ra"));
                System.out.println("Nome :" + rs.getString("primeiro_nome"));
                System.out.println("Sobrenome :" + rs.getString("sobrenome"));
                System.out.println("Idade :"+ rs.getInt("idade"));


            }

            Statement i = c.createStatement();
            int resultado = i.executeUpdate("insert into ALUNO(ra , primeiro_nome , sobrenome , idade ) values "+
                    "(12345 , 'Ze', 'Condaongas' , 78)");

            System.out.println(resultado);
            rs.close();
            i.close();
            s.close();
            //c.close();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
