package lw01.unguided;

public class ProjectorRental extends Rental{

    public ProjectorRental(String id, int days){
        super(id, days);
    }

    @Override 
    public int calculateCharge(){
        int rentCharge;
        if(getDays()<=3){
            rentCharge = getDays()*60000;
        } else {
            rentCharge = (3*60000) + ((getDays()-3)*45000);
        }
        return rentCharge + 20000;
    }

    @Override 
    public String label(){
        return "Projector";
    }

    
}
