package trabalhoetapa1;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * @author jrrod
 * @email rodolfojunior.pf237@academico.ifsul.edu.br
 * @professor Me. Jorge Bavaresco
 */
public class ex4 {

    public static void main(String[] args) {
        Double value = 0.0, parcela;
        int qtd = 0;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("0.00");

        try {
            value = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor: "));
            qtd = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de parcelas: "));
            
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(null, "Houve um problema com a sua entrada de valores. Execute o programa novamente. -> Mensagem de erro: " + ne.getMessage());
            return;
        }
        Double arrValue[] = new Double[qtd];
        String[] arrCal = new String[qtd];
        parcela = value / qtd;
        int z = 1;
        System.out.println("Valor da compra: " + value);
        System.out.println("Total de parcelas: " + qtd);
        for (int i = 0; i < qtd; i++) {
            arrValue[i] = parcela;
            arrCal[i] = sdf.format(cal.getTime());
            System.out.print("Valor da parcela: " + new DecimalFormat("0.00").format(arrValue[i]) + " Data do " + z + "º vencimento: " + arrCal[i] + "\n");
            cal.add(Calendar.DAY_OF_MONTH, 30);
            z++;
        }

    }
}
