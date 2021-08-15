package trabalhoetapa1;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * @author jrrod
 * @email rodolfojunior.pf237@academico.ifsul.edu.br
 * @professor Me. Jorge Bavaresco
 */
public class ex2 {

    public static void main(String[] args) {
        String locaDate = ""; //dia locação
        String locaReturn = ""; //dia retorno
        Double value;
        Double vlrFinal;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("0.00");

        try {
            value = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da diária da locação: "));

            locaDate = JOptionPane.showInputDialog("Informe a data de locação (formato dd/MM/AA): ");
            sdf.setLenient(false);
            Date dataEntrada = sdf.parse(locaDate);

            Calendar cal = Calendar.getInstance();
            cal.setTime(dataEntrada);
            int year1 = cal.get(Calendar.YEAR);

            locaReturn = JOptionPane.showInputDialog("Informe a data de devolução (formato dd/MM/AA): ");
            sdf.setLenient(false);
            Date dataRetorno = sdf.parse(locaReturn);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(dataRetorno);
            int year2 = cal2.get(Calendar.YEAR);

            if (year1 > year2) // depois de pegar os anos com o calendar, vamos ver se a data inicial é maior do que a data final. Se for maior, vamos "atirar" a exceção para o user.
            {
                throw new Exception("Data inicial maior do que a data final. Verifique suas entradas e execute o programa novamente.");
            }
            long diferencaMili = Math.abs(dataRetorno.getTime() - dataEntrada.getTime());   //diferença de milisegundos entre as datas   
            int dias = (int) (diferencaMili / (1000 * 60 * 60 * 24));                              //transformando para dias
            vlrFinal = value * dias;

            System.out.println("Valor da diária: "
                    + new DecimalFormat(".00").format(value)
                    + "\nData de locação: " + locaDate
                    + "\nData de devolução: " + locaReturn
                    + "\nDias de locação: " + dias
                    + "\nValor total da locação: " + new DecimalFormat(".00").format(vlrFinal));

        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(null, "Houve um erro de conversão na digitação do valor da diária. Verifique sua entrada e tente novamente! ERRO IDENTIFICADO -> " + ne.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um erro referente as datas. ERRO IDENTIFICADO -> " + e.getMessage());
        }

    }

}
