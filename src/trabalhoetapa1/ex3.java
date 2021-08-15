package trabalhoetapa1;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author jrrod
 * @email rodolfojunior.pf237@academico.ifsul.edu.br
 * @professor Me. Jorge Bavaresco
 */
public class ex3 {

    public static void main(String[] args) {
        String data;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            data = JOptionPane.showInputDialog("Informe a para simulação (formato dd/MM/AA): ");
             cal.setTime(sdf.parse(data));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um erro referente as datas. ERRO IDENTIFICADO -> " + e.getMessage());
            return;
        }
        System.out.println("Data digitada: " + sdf.format(cal.getTime()));
        for (int i=0; i < 5; i++) //laço para gerar as "faturas"
        {
            cal.add(Calendar.DAY_OF_MONTH,7);
            System.out.println("Data de pagamento: " + sdf.format(cal.getTime()));
        }
     
    }

}
