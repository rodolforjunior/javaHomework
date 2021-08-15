package trabalhoetapa1;

import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.util.regex.Pattern; //regex funciona como um "matcher" para uma busca em strings 

/**
 * @author jrrod
 * @email rodolfojunior.pf237@academico.ifsul.edu.br
 * @professor Me. Jorge Bavaresco
 */
public class TrabalhoEtapa1 {

    public static void main(String[] args) {
        String name = "";
        DecimalFormat df = new DecimalFormat("0.00"); //classe para setar precisão decimal
        Double sal = 0.0;
        try {
            name = JOptionPane.showInputDialog("Informe o nome da pessoa: ");
            if (!Pattern.matches("[a-zA-Zà-úÀ-Ú- ]+",name)) { //Se a string conter algum caractere fora desse intervalo como caracteres especiais, numeros etc.. Não irá executar
                throw new Exception("Ops... Você digitou um nome com caractere inválido! Execute o programa novamente.");
            }
            sal = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário dessa pessoa: "));

        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(null, "Houve um erro de conversão na digitação dos dados. Reinicie com novos dados." + ne.getMessage());
            return;
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"" + e.getMessage());
            return;
        }
        Double salBruto = sal, aliq;
        if (sal < 0  || sal > 6433.57)
        {
            System.out.println("Atenção! O valor digitado: " + sal + " excede os limites do cálculo da alíquota. Execute o programa novamente!");
        }
        else {
        if (sal <= 1100) {
            aliq = sal * (0.075);
            sal = sal - aliq;
            System.out.println("Nome: " + name
                    + "\nSalário bruto: "
                    + new DecimalFormat(".00").format(salBruto)
                    + "\nINSS: " + new DecimalFormat(".00").format(aliq)
                    + "\nSalário liquido: " + new DecimalFormat(".00").format(sal));

        }
        if (sal > 1100 && sal <= 2203.48) {
            aliq = sal * (0.09);
            sal = sal - aliq;
            System.out.println("Nome: " + name
                    + "\nSalário bruto: "
                    + new DecimalFormat(".00").format(salBruto)
                    + "\nINSS: " + new DecimalFormat(".00").format(aliq)
                    + "\nSalário liquido: " + new DecimalFormat(".00").format(sal));
        }
        if (sal > 2203.48 && sal <= 3305.22) {
            aliq = sal * (0.12);
            sal = sal - aliq;
            System.out.println("Nome: " + name
                    + "\nSalário bruto: "
                    + new DecimalFormat(".00").format(salBruto)
                    + "\nINSS: " + new DecimalFormat(".00").format(aliq)
                    + "\nSalário liquido: " + new DecimalFormat(".00").format(sal));
        }
        if (sal > 3305.22 && sal <= 6433.57) {
            aliq = sal * (0.14);
            sal = sal - aliq;
            System.out.println("Nome: " + name
                    + "\nSalário bruto: "
                    + new DecimalFormat(".00").format(salBruto)
                    + "\nINSS: " + new DecimalFormat(".00").format(aliq)
                    + "\nSalário liquido: " + new DecimalFormat(".00").format(sal));
        }
       
        }
    }

}
