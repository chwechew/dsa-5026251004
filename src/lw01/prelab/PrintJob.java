package lw01.prelab;
public abstract class PrintJob implements Chargeable{
    
    private String id;
    private int pages;

    protected PrintJob(String id, int pages){
        if(pages <= 0){
            throw new IllegalArgumentException("Pages must be positive!!");
        }

        this.id = id;
        this.pages = pages;
    }

    String getId() {
        return id;
    }

    int getPages() {
        return pages;
    }

    public int calculateCharge(int copies) {
        if(copies <= 0){
            throw new IllegalArgumentException("Copies must be positive!!");
        }
        return copies * calculateCharge();
    }

    @Override
    public abstract int calculateCharge();

    public String label() {
        return "Print";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
