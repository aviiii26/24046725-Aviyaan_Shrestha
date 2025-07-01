public class RegularMember extends GymMember 
{
    private final int attendanceLimit = 30;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource) 
    {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = "";
    }

    public int getAttendanceLimit() 
    {
        return attendanceLimit; 
    }
    
    public boolean getIsEligibleForUpgrade()
    {
        return isEligibleForUpgrade;
    }
    
    public String getRemovalReason() 
    {
        return removalReason; 
    }
    
    public String getReferralSource() 
    { 
        return referralSource; 
    }
    
    public String getPlan()
    {
        return plan; 
    }
    
    public double getPrice() 
    {
        return price;
    }
    
    @Override
    public void markAttendance() 
    {
        this.attendance++;
        this.loyaltyPoints += 5.0;
    }

    public double getPlanPrice(String plan) 
    {
        switch (plan.toLowerCase()) 
        {
            case "basic": return 6500;
            case "standard": return 12500;
            case "deluxe": return 18500;
            default: return -1;
        }
    }

    public String upgradePlan(String newPlan)
    {
        if (newPlan.equalsIgnoreCase(this.plan)) 
        {
            return "You are already subscribed to this plan.";
        }
        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) 
        {
            return "Invalid plan selected.";
        }
        
        if (this.attendance >= attendanceLimit) 
        {
            this.plan = newPlan;
            this.price = newPrice;
            return "Plan upgraded successfully to " + newPlan + ".";
        }
        return "You are not eligible for an upgrade.";
    }

    public void revertRegularMember(String removalReason) 
    {
        super.resetMembership();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
        this.removalReason = removalReason;
    }

    @Override
    public void display() 
    {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty())
        {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}