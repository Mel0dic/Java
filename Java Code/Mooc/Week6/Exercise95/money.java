public class money {

    private final int euros;
    private final int cents;

    public static void main(String[] args){
        money a = new money(10,0);
        money b = new money(5,0);

        money c = a.plus(b);

        System.out.println(a);  // 10.00e
        System.out.println(b);  // 5.00e
        System.out.println(c);  // 15.00e

        a = a.plus(c);          // NOTE: new Money-object is created and reference to that
                                //           is assigned to variable a.
                                //       The Money object 10.00e that variable a used to hold
                                //           is not referenced anymore

        System.out.println(a);  // 25.00e
        System.out.println(b);  // 5.00e
        System.out.println(c);  // 15.00e
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

    public String toString() {
        String zero = "";
        if (cents <= 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }
}
