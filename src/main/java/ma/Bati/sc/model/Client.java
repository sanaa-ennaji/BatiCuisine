package main.java.ma.Bati.sc.model;

import java.util.Optional;
import java.util.UUID;

public class Client {
    private UUID id ;
    private String name;
   private String address;
   private String phone;
   private boolean isProfessional;

   public Client (){

   }
   public Client (String name, String address, String phone, boolean isProfessional){
       this.id = UUID.randomUUID();
       this.setName(name);
       this.setAddress(address);
       this.setPhone(phone);
       this.setIsProfessional(isProfessional);
   }
    public UUID getId(){
        return id;
    }

   public void setId(UUID id){
       this.id = id ;
   }
   public void setName (String name){
       this.name = name ;
   }
   public void setAddress (String address){
       this.address = address;
   }
   public void setPhone (String phone){
     this.phone = phone ;

   }
   public void  setIsProfessional (boolean isProfessional){
       this.isProfessional = isProfessional;
   }

   public String getName (){
       return name ;
   }
   public String getAddress(){
       return address ;
   }
   public String getPhone (){
       return phone ;
   }
   public boolean getIsProfessional (){
       return isProfessional;
   }


}
