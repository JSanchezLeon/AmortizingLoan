import java.util.ArrayList;

public class AmortizingLoan{

    public int maturity;
    public double interest;
    public int principal;
    public int[] period;

    public AmortizingLoan(){

    }

    public AmortizingLoan(int maturity, double interest, int principal){
        this.maturity = maturity;
        this.interest = interest;
        this.principal = principal;
        this.period = new int[this.maturity+1];
    }

    public int[] populateIndex(){
        for(int i = 0; i <= this.maturity; ++i){
            this.period[i] = i;
            System.out.println(this.period[i]);
        }
        return this.period;
    }

    public double calculatePayment(){
        double sumFactor = 0;
        for(int i:this.period){
            sumFactor += Math.pow(1/(1+this.interest),i);
        }
        double payment = this.principal/sumFactor;
        return payment;
    }

    
    public static void main(String[] args){

        AmortizingLoan mortgage = new AmortizingLoan(10,0.1,200000);
        mortgage.populateIndex();
        System.out.println(mortgage.calculatePayment());

    }


}