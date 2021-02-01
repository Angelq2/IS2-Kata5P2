package view;

import model.Histogram;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author angel
 */

public class HistogramDisplay extends ApplicationFrame{
    
    public final Histogram<String> histo;
    
    public HistogramDisplay(Histogram<String> histo){
        super("HISTOGRAMA");
        this.histo = histo;
        setContentPane(createPanel());
        pack(); //la ventana tome el tamaño más pequeño posible que permita ver todoslos componentes.
        
    }
    
    //Metodo que inserta el panel
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    //Metodo que crea el diagrama de barras
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart",
                                            "Dominios de email",
                                            "Numero de emails",
                                            dataSet,
                                            PlotOrientation.VERTICAL, 
                                            false,
                                            false,
                                            rootPaneCheckingEnabled); 
        
        return chart;
    }
    
    //Metodo que crea el conjunto de datos
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
       
        for (String key : histo.keySet()) {
            dataSet.addValue(histo.get(key),"", key);
        }
        
        return dataSet;
        
    }
    
    //Metodo que hace visible el frame
    public void execute(){
        setVisible(true);
    }
}
