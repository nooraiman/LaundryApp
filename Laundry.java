


import java.text.DecimalFormat;
 abstract  class Laundry
{
    protected String customerName;
    protected boolean membership;
    protected String phone;
    protected DecimalFormat df = new DecimalFormat("#0.00");
    //Default Constructor
    public Laundry()
    {
        this.customerName = "";
        this.membership = false;
        this.phone = "";
    }

    //Normal Constructor
    public Laundry(String cN,boolean m,String p)
    {
        this.customerName = cN;
        this.membership = m;
        this.phone = p;
    }

    //Mutator

    public void setCustomerName(String customerName)
    {
        this.customerName = customerName;
    }

    public void setMembership(boolean membership)
    {
        this.membership = membership;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setLaundry(String cN,boolean m,String p)
    {
        this.customerName = cN;
        this.membership = m;
        this.phone = p;
    }

    //Accesor
    public String getCustomerName()
    {
        return customerName;
    }

    public boolean getMembership()
    {
        return membership;
    }

    public String getPhone()
    {
        return phone;
    }

    
    public String toString()
    {
        return "Customer Name: " + this.customerName +
                "\nMembership: " + this.membership +
                "\nPhone Number: " + this.phone;
    }

    public abstract double calculateCharge();
    public abstract String printBill();
}