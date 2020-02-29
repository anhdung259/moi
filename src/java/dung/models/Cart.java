/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dung.models;

import dung.dtos.RoomDto;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Pham Anh Dung
 */
public class Cart implements Serializable {

    private HashMap<String, RoomDto> items;

    public HashMap<String, RoomDto> getItems() {
        return items;
    }

    public void setItems(HashMap<String, RoomDto> items) {
        this.items = items;
    }

   
    public Cart() {
        items = new HashMap<>();
    }

    public void AddtoCart(RoomDto dto) throws Exception {
        if(items==null){
            items=new HashMap<>();
        }
        
        this.items.put(dto.getRoomid(), dto);
    }

    public int getTotal() throws Exception {
        int result = 0;
        for (RoomDto dto : this.items.values()) {
            result += (dto.getCosts()) * dto.getNumDate();
            
        }
        return result;
    }

    public void removeCart(String id) throws Exception {
        if (items.containsKey(id)) {
            items.remove(id);
        }
    }
    
    public void updateCost(String id,int cost) throws Exception {
        if (this.items.containsKey(id)) {
            this.items.get(id).setCosts(cost);
        }
    }
     public void updatePay(String id,int pay) throws Exception {
        if (this.items.containsKey(id)) {
            this.items.get(id).setPay(pay);
        }
    }
    public void clear(){
        items.clear();
    }
}
