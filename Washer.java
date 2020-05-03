public class Washer extends Laundry
{
    private String temperature;
    private boolean detergent;

    //Normal Constructor
    public Washer(String cN,boolean m,String p,String t, boolean d)
    {
        super(cN,m,p);
        this.temperature = t;
        this.detergent = d;
    }

    //Mutator
    public void setTemperature(String t)
    {
        this.temperature = t;
    }

    public void setDetergent(boolean d) {
        this.detergent = d;
    }

    public void setWasher(String cN,boolean m,String p,String t, boolean d)
    {
        super.setLaundry(cN,m,p);
        this.temperature = t;
        this.detergent = d;
    }

    //Accesor
    public String getTemperature() {
        return this.temperature;
    }

    public boolean getDetergent() {
        return this.detergent;
    }

    public double calculateCharge()
    {
        double charge=0.00;
        if(temperature.equalsIgnoreCase("Cold"))
        {
            if(this.detergent == false)
                charge = 10.00;
            else
                charge = 10.00 + 1.00;
        }
        else if(temperature.equalsIgnoreCase("Moderate"))
        {
            if(this.detergent == false)
                charge = 9.00;
            else
                charge = 9.00 + 1.00;
        }
        else if(temperature.equalsIgnoreCase("Warm"))
        {
            if(this.detergent == false)
                charge = 11.00;
            else
                charge = 11.00 + 1.00;
        }
        return charge;
    }

    public String printBill()
    {
        return "\nTemperature: " + this.temperature +
                "\nBuy Detergent: " + this.detergent +
                "\nCharge: RM" + df.format(this.calculateCharge());
    }
}
