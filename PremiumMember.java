public class PremiumMember extends GymMember 
{
    private final double premiumCharge = 50000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer) 
    {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    public double getPremiumCharge() 
    {
        return premiumCharge; 
    }
    
    public String getPersonalTrainer()
    {
        return personalTrainer; 
    }
    
    public boolean getIsFullPayment() 
    {
        return isFullPayment; 
    }
    
    public double getPaidAmount() 
    {
        return paidAmount; 
    }
    
    public double getDiscountAmount()
    {
        return discountAmount; 
    }
    
    @Override
    public void markAttendance() 
    {
        this.attendance++;
        this.loyaltyPoints += 10.0;
    }

    public String payDueAmount(double amount)
    {
        if (isFullPayment)
        {
            return "Payment is already complete.";
        }
        if (paidAmount + amount > premiumCharge)
        {
            return "Payment exceeds the premium charge.";
        }
        paidAmount += amount;
        if (paidAmount == premiumCharge) 
        {
            isFullPayment = true;
        }
        double remainingAmount = premiumCharge - paidAmount;
        return "Payment successful. Remaining amount: " + remainingAmount;
    }

    public void calculateDiscount()
    {
        if (isFullPayment) 
        {
            discountAmount = premiumCharge * 0.10;
            System.out.println("Discount calculated: " + discountAmount);
        } else 
        {
            System.out.println("No discount available.");
        }
    }

    public void revertPremiumMember()
    {
        super.resetMembership();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }

    @Override
    public void display() 
    {
        super.display();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment: " + isFullPayment);
        System.out.println("Remaining Amount: " + (premiumCharge - paidAmount));
        if (isFullPayment) 
        {
            System.out.println("Discount Amount: " + discountAmount);
        }
    }
}