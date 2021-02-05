package app.sabeeldev.dawaihazir.General;


import org.json.JSONObject;

import java.util.ArrayList;

public class Result {
    private String status;
    private ArrayList<Store> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Store> getData() {
        return data;
    }

    public void setData(ArrayList<Store> data) {
        this.data = data;
    }

   public static class Store {
        private String id;
        private String name;
        private String shopopen;
        private String shopclose;
        private String shopdiscount;
        private String contact;
        private String shoplat;
        private String shoplong;
        private String pic;

        public Store(String id, String name, String shopopen, String shopclose, String shopdiscount, String contact, String shoplat, String shoplong, String pic) {
            this.id = id;
            this.name = name;
            this.shopopen = shopopen;
            this.shopclose = shopclose;
            this.shopdiscount = shopdiscount;
            this.contact = contact;
            this.shoplat = shoplat;
            this.shoplong = shoplong;
            this.pic = pic;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getShopopen() {
            return shopopen;
        }

        public void setShopopen(String shopopen) {
            this.shopopen = shopopen;
        }

        public String getShopclose() {
            return shopclose;
        }

        public void setShopclose(String shopclose) {
            this.shopclose = shopclose;
        }

        public String getShopdiscount() {
            return shopdiscount;
        }

        public void setShopdiscount(String shopdiscount) {
            this.shopdiscount = shopdiscount;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getShoplat() {
            return shoplat;
        }

        public void setShoplat(String shoplat) {
            this.shoplat = shoplat;
        }

        public String getShoplong() {
            return shoplong;
        }

        public void setShoplong(String shoplong) {
            this.shoplong = shoplong;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }
    }
}