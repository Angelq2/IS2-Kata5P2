package controller;

import java.util.List;
import view.HistogramDisplay;
import model.Histogram;
import model.Mail;
import view.MailHistogramBuilder;
import static view.MailListReader.read;
import static view.MailListReader.read;


/**
 * Representación gráfica de un Histograma leyendo los datos
 * desde un fichero, compuesto por un conjunto de direcciones
 * email, mostraremos el histograma de los dominios.
 * 
 * @author Ángel 
 */

public class Kata5P2 {
    
    private static String fileName;
    private static List<Mail> mailList;
    private static Histogram<String> histo;
    private static HistogramDisplay histoDisplay;
    
    public static void main(String[] args) throws Exception {
        execute();
    }
    
      public static void execute() throws Exception {
        input();
        process();
        output();
    }

    public static void input() {
        try {
           // fileName = new String("C:\\Users\\angel\\OneDrive\\Documentos\\NetBeansProjects\\Kata4\\txtFileEmail\\email.txt");
           // mailList = MailListReader.read(fileName);
           mailList = read();
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error con el fichero");
        }
    }

    public static void process() {
        histo = MailHistogramBuilder.build(mailList);
    }

    public static void output() {
        histoDisplay = new HistogramDisplay(histo);
        histoDisplay.execute();
    }        

}
 
  
