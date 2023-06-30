import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double[] salariosB = new double[5];
        double[] salariosL = new double[5];

        for (int i = 1; i <= 5; i++) {
            System.out.print("Digite o "+(i)+"° salário bruto do funcionário:");
            double salarioB = scanner.nextDouble();
            double inss = calcularINSS(salarioB);
            double ir = calcularIR(salarioB);
            double salarioL = salarioB - inss - ir;
            salariosB[i-1] = salarioB;
            salariosL[i-1] = salarioL;
        }

        System.out.println("---------INFORMAÇÕES ABAIXO---------");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Salário bruto "+(i)+": " + (Math.round(salariosB[i-1] * 100))/100.0);
            System.out.println("Desconto INSS "+(i)+": " + (Math.round(calcularINSS(salariosB[i-1]) * 100))/100.0);
            System.out.println("Desconto Imposto de Renda "+(i)+": " +(Math.round(calcularIR(salariosB[i-1]) * 100))/100.0);
            System.out.println("Salário líquido "+(i)+": " + (Math.round(salariosL[i-1] * 100))/100.0);
            System.out.println("");
        }
    }
    public static double calcularINSS(double salario) {
        if (salario <= 1212.00) {
            return salario * 0.075;
        } else if (salario <= 2427.35) {
            return salario * 0.09;
        } else if (salario <= 3641.03) {
            return salario * 0.12;
        } else {
            return salario * 0.14;
        }
    }
    public static double calcularIR(double salario) {
        if (salario <= 1903.98) {
            return 0;
        } else if (salario <= 2826.65) {
            return salario * 0.075;
        } else if (salario <= 3751.05) {
            return salario * 0.15;
        } else if (salario <= 4664.68) {
            return salario * 0.225;
        } else {
            return salario * 0.275;
        }
    }
}