package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 
import model.Mail;
/**
 * Lee del fichero de texto los emails y crear una
 * lista de correos válidos, ya que en el fichero
 * email.txt hay cadenas no validas con el formato email
 * 
 * @author angel
 */
public class MailListReaderBD {
    
    public static List<Mail> read() throws Exception{
        
        List<Mail> lista = new ArrayList<>();
        File fichero = new File("jdbc:sqlite:C:\\Users\\angel\\OneDrive\\Documentos\\NetBeansProjects\\Kata5P2\\BD_Kata5.db");
        
        try{
            Scanner scan = new Scanner(fichero);
            
            
    
            Pattern pattern = Pattern
                    .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            
            while(scan.hasNextLine()){
                String linea =  scan.nextLine();
                Matcher mather = pattern.matcher(linea);
                if (mather.find() == true) {
                    lista.add(new Mail(linea));
                }
            }
        
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return lista;
    }
        private static Connection connect() {
    // SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\angel\\OneDrive\\Documentos\\NetBeansProjects\\Kata5P2\\BD_Kata5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        try (
            Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            // Bucle sobre el conjunto de registros.
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                rs.getString("Name") + "\t" +
                rs.getString("Apellidos") + "\t" +
                rs.getString("Departamento") + "\t");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
}
