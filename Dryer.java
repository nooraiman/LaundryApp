public class Dryer extends Laundry
{
    private double weight;
    private int duration;

    //Normal Constructor
    public Dryer(String cN,boolean m,String p,double w, int d)
    {
        super(cN,m,p);
        this.weight = w;
        this.duration = d;
    }

    //Mutator
    public void setWeight(double w)
    {
        this.weight = w;
    }

    public void setDuration(int d)
    {
        this.duration = d;
    }

    public void setDryer(String cN,boolean m,String p,double w, int d)
    {
        super.setLaundry(cN,m,p);
        this.weight = w;
        this.duration = d;
    }

    //Accessor
    public double getWeight()
    {
        return  this.weight;
    }

    public int getDuration()
    {
        return this.duration;
    }

    //Abstract@Overrive Method
    public double calculateCharge()
    {
        double charge = 0.00;

        if(this.weight == 7)
        {
            charge = duration * 0.10;
        }
        else if(this.weight == 10)
        {
            charge = duration * 0.20;
        }

        return charge;
    }

    public String printBill()
    {
        return  "\nWeight: " + this.weight + " kg" +
                "\nDuration: " + this.duration + " minutes" +
                "\nCharge: RM" + df.format(this.calculateCharge());
    }
}
