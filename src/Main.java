import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        float[] salarios = new float[5];

        for (int i = 0; i < salarios.length; i++) {
            System.out.printf("Digite o %dº salário: ", i+1);
            salarios[i] = scanner.nextFloat();}

        float[] descontosInss = calculaDescontoInss(salarios);
        float[] descontoIR = calculaDescontoImpostoRenda(salarios);

        for (int i = 0; i < salarios.length; i++) {
            System.out.printf("O %dº salário informado é R$%.2f. O desconto do INSS é: R$%.2f. O desconto do imposto de renda é: R$%.2f. O valor após os descontos é R$%.2f.", i+1, salarios[i], descontosInss[i], descontoIR[i], (salarios[i] - (descontosInss[i] + descontoIR[i])));
            System.out.println();
        }

    scanner.close();
    }

    public static float[] calculaDescontoInss(float[] listaSalarios) {
        float desconto = 0;
        float[] listaDescontos = new float[listaSalarios.length];
        int cont = 0;
        for (float salario : listaSalarios) {

            if (salario <= 1212) {
                desconto = (float) (salario * 0.075);
            } else if (salario >= 1212.01 && salario <= 2427.35) {
                desconto = (float) (salario * 0.09);
            } else if (salario >= 2427.36 && salario <= 3641.03) {
                desconto = (float) (salario * 0.12);
            } else {
                desconto = (float) (salario * 0.14);
            }
            listaDescontos[cont] = desconto;
            cont ++;
        }
        return listaDescontos;
    }

    public static float[] calculaDescontoImpostoRenda(float[] listaSalarios) {
        float desconto = 0;
        float[] listaDescontos = new float[listaSalarios.length];
        int cont = 0;

        for (float salario : listaSalarios) {
            if (salario <= 1903.98) {
                desconto = 0;
            } else if (salario >= 1903.99 && salario <= 2826.65) {
                desconto = (float) (salario * 0.075);
            } else if (salario >= 2826.66 && salario <= 3751.05) {
                desconto = (float) (salario * 0.15);
            } else if (salario >= 3751.06 && salario <= 4664.68) {
                desconto = (float) (salario * 0.225);
            } else {
                desconto = (float) (salario * 0.275);
            }
            listaDescontos[cont] = desconto;
            cont ++;

        }
        return listaDescontos;
    }

}

