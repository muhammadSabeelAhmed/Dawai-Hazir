package app.sabeeldev.dawaihazir.General;

import java.util.ArrayList;

public class CateogoryResult {
    private String status;
    private String medicalstore;
    private String banner;
    private String logo;
    private String rating;
    private ArrayList<Categories> Categories;

    public CateogoryResult(String status, String medicalstore, String banner, String logo, String rating) {
        this.status = status;
        this.medicalstore = medicalstore;
        this.banner = banner;
        this.logo = logo;
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMedicalstore() {
        return medicalstore;
    }

    public void setMedicalstore(String medicalstore) {
        this.medicalstore = medicalstore;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public ArrayList<CateogoryResult.Categories> getCategories() {
        return Categories;
    }

    public void setCategories(ArrayList<CateogoryResult.Categories> categories) {
        Categories = categories;
    }

    public static class Categories {
        private String categoryid;
        private String categoryname;
        private String categoryimage;
        private String vendorid;
        private String created_at;
        private String categorystatus;

        public Categories(String categoryid, String categoryname, String categoryimage, String vendorid, String created_at, String categorystatus) {
            this.categoryid = categoryid;
            this.categoryname = categoryname;
            this.categoryimage = categoryimage;
            this.vendorid = vendorid;
            this.created_at = created_at;
            this.categorystatus = categorystatus;
        }

        public String getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(String categoryid) {
            this.categoryid = categoryid;
        }

        public String getCategoryname() {
            return categoryname;
        }

        public void setCategoryname(String categoryname) {
            this.categoryname = categoryname;
        }

        public String getCategoryimage() {
            return categoryimage;
        }

        public void setCategoryimage(String categoryimage) {
            this.categoryimage = categoryimage;
        }

        public String getVendorid() {
            return vendorid;
        }

        public void setVendorid(String vendorid) {
            this.vendorid = vendorid;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getCategorystatus() {
            return categorystatus;
        }

        public void setCategorystatus(String categorystatus) {
            this.categorystatus = categorystatus;
        }
    }

}
