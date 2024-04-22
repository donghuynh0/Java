package Models.Product;

import java.util.Date;

public class NoteBook extends Product{
    private String pageSize;
    private int pageCount;
    private boolean isLined;

    public NoteBook(String pid, String name, String origin, String maf_date, String supplier,
                    double price,String pageSize, int pageCount, boolean isLined) {
        super(pid, name, origin, maf_date, supplier,price);
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.isLined = isLined;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public boolean isLined() {
        return isLined;
    }

    public void setLined(boolean lined) {
        isLined = lined;
    }

    @Override
    public String toString() {
        return "NoteBook{" +
                super.toString() +
                ", pageSize='" + pageSize + '\'' +
                ", pageCount=" + pageCount +
                ", isLined=" + isLined +
                '}';
    }
}
