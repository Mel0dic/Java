public class money {

    private final int euros;
    private final int cents;

    public static void main(String[] args){
        money a = new money(10,0);
        money b = new money(3,50);

        money c = a.minus(b);

        System.out.println(a);  // 10.00e
        System.out.println(b);  // 3.50e
        System.out.println(c);  // 6.50e

        c = c.minus(a);         // NOTE: new Money-object is created and reference to that is assigned to variable c
                        //       the Money object 6.50e that variable c used to hold, is not referenced anymore

        System.out.println(a);  // 10.00e
        System.out.println(b);  // 3.50e
        System.out.println(c);  // 0.00e
    }

    public money(int euros, int cents) {

        if (cents > 99) {
            euros += cents / 100;
            cents %= 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros(){
        return euros;
    }

    public int cents(){
        return cents;
    }

    public money plus(money money){
        int euros = this.euros + money.euros();
        int cents = this.cents + money.cents();
        return new money(euros, cents);
    }

    public boolean less(money money){
        if(this.euros > money.euros){
            return false;
        }else if(money.euros > this.euros){
            return true;
        }else if((money.euros == this.euros) && (this.cents > money.cents)){
            return false;
        }else{
            return true;
        }
    }

    public money minus(money decremented){
        int newEuros = (this.euros - decremented.euros);//((this.euros - decremented.euros < 0) ? 0 : (this.euros - decremented.euros))
        System.out.println(newEuros);
        int newCents;
        int tempCents = this.cents - decremented.cents;
        if(tempCents < 0){
            System.out.println("Hello");
            System.out.println(newEuros);
            if(newEuros < 0){
                System.out.println("Hello");
                return new money(0, 0);
            }
            newEuros--;
            newCents = 100 + tempCents;
        }else{
            newCents = this.cents - decremented.cents;
        }
        return new money(newEuros, newCents);
    }

    public String toString() {
        String zero = "";
        if (cents <= 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }
}
