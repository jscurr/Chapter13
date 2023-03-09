package pp1305;


import java.util.Timer;

public class BankDriver {
    public static void main(String[] args){

        Bank myBank = new Bank();
        Timer Customertimer = new Timer(false);
        Customertimer.scheduleAtFixedRate(myBank.getCustomerMaker(), 1000, 2000);
        Timer tellerTimer = new Timer(false);
        tellerTimer.scheduleAtFixedRate(myBank.getTellerTask(), 20000, 1000);

    }
}
