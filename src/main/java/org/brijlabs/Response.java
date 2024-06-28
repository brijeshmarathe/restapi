package org.brijlabs;

public class Response {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private TVShow[] data;

    public int getPage() {
        return page;
    }
    public int getPer_page() {
        return per_page;
    }
    public int getTotal() {
        return total;
    }
    public int getTotal_pages() {
        return total_pages;
    }
    public TVShow[] getData() {
        return data;
    } 

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Response{");
        sb.append("page=").append(page);
        sb.append(", per_page=").append(per_page);
        sb.append(", total=").append(total);
        sb.append(", total_pages=").append(total_pages);
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
