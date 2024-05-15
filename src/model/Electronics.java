package model;

public class Electronics extends Product{
    
        String brand;
        int warrantyPeriod;
    
        
        public String getBrand() {
            return brand;
        }
    
        public void setBrand(String brand) {
            this.brand = brand;
        }
    
        public int getWarrantyPeriod() {
            return warrantyPeriod;
        }
    
        public void setWarrantyPeriod(int warrantyPeriod) {
            this.warrantyPeriod = warrantyPeriod;
        }
    
        
    }
