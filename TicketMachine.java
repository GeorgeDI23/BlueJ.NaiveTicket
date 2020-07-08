/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class TicketMachine
{
    // The price of a ticket of type 1 from this machine.
    private Integer price1;
    // The price of a ticket of type 2 from this machine
    private Integer price2;
    // The types of prices available
    private Integer ticketType;
    // The amount of money entered by a customer so far.
    private Integer balance;
    // The total amount of money collected by this machine.
    private Integer total;
    // The number of tickets printed.
    private Integer ticketNumber;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine()
    {
        price1 = 1000;
        price2 = 500;
        balance = 0;
        total = 0;
        ticketNumber = 0;
    }
    /**
     * Second constructor that takes a value
     */
    public TicketMachine(Integer priceProvided1, Integer priceProvided2)
    {
        price1 = priceProvided1;
        price2 = priceProvided2;
        balance = 0;
        total = 0;
        ticketNumber = 0;
    }
    /**
     * Return the price of a ticket. Type is 1 or 2.
     */
    public Integer getPrice(Integer ticket)
    {
        if (ticket == 1){
            return price1;
        }else{
            return price2;
        }
    }
    /**
     * Subtract value from price (Discount). Type is 1 or 2.
     */
    public void discount(Integer amount, Integer ticket){
        if (ticket == 1){
            price1 = price1 - amount;
        }else{
            price2 = price2 - amount;
        }
    }
    
    /**
     *  Reset the price of a ticket. Type is 1 or 2.
     */
    public void setPrice(Integer ticketCost, Integer ticket){
        if (ticket == 1){
            price1 = ticketCost;
        }else{
            price2 = ticketCost;
        }
    }
    
    /**
     * Return ticketNumber.
     * (Increments on each print.)
     */
    public Integer getTicketNumber()
    {
        return ticketNumber;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public Integer getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money in cents from a customer.
     */
    public Integer insertMoney(Integer amount)
    {
        balance = balance + amount;
        return balance;
    }
    
    public Integer calculateTotal(){
        total = balance + total;
        return total;
    }
    
    public Integer incrementTicketNumber(){
        ticketNumber++;
        return ticketNumber;
    }
    

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     * Type is 1 or 2.
     */
    public String printTicket(Integer ticket)
    {
        //Determine amount left to pay if applicable
        Integer price;
        if(ticket == 1){
            price = price1;
        }else{
            price = price2;
        }
        Integer amountLeftToPay = price - balance;
        if (amountLeftToPay <= 0){
            //Increment the number of tickets printed
            incrementTicketNumber();
            // Update the total collected with the balance.
            total = total + price;
            // Clear the balance.
            balance = balance - price;
        } else {
            System.out.println("Amount still due: "+ (price - balance));
        }        
        return "Ticket price: " + price + " cents. " + "Your total is " + total + ".";
    }
    /** 
     * Prints the ticket to the terminal. Type is 1 or 2.
     */
    public void printTicketGUI(Integer ticket){
        System.out.println("Ticket");
        if(ticket == 1){
            System.out.println(price1 + " cents");
        }else{
            System.out.println(price1 + " cents");
        }
        System.out.println();
        total = total + balance;
        balance = 0;
    }
    //prompt
    public void prompt(){
        System.out.println("Please insert the correct amount of money");
    }
    //Show price for type 1 or 2.
    public void showPrice(Integer ticket){
        if(ticket == 1){
            System.out.println("The price of the ticket is " + price1 + " cents.");
        }else{
            System.out.println("The price of the ticket is " + price2 + " cents.");
        }
    }
    // Empty out the machine
    public Integer empty(){
        Integer totalReturn = total;
        total = 0;
        return totalReturn;        
    }
    /* other statements intentionally commented out
    Integer saving = price * discount;
    Integer mean = total / count;
    if(price > budget){
        System.out.println("Too expensive, budget is " + budget);
    } else {
        System.out.println("Just right");
    }
    
    */
     
}
