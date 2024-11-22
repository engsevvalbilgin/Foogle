/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bilginyilmaz;

/**
 *
 * @author hp
 */
public class BilginYilmazBNode {
    BilginYilmazBNode left,right;
    String data;
    BilginYilmazFileLL file_list;
    //public BNode(){}
    public BilginYilmazBNode(String data){
    this.data= data;
    }
   public void printFileList(){
       int sum=0;
       if(this.file_list!=null){
       BilginYilmazFNode fnode=this.file_list.head;
       while(fnode!=null){
       sum+=fnode.data;
       fnode=fnode.next;
       }
       }
   }
   public void addFileList(String file_name) {
       BilginYilmazFNode fnode = new BilginYilmazFNode(file_name); 
    boolean isAdded = false;
    BilginYilmazFNode temp;

    if (this.file_list == null) {
        this.file_list = new BilginYilmazFileLL(); 
        this.file_list.head = fnode; 
        isAdded = true;
    } else {
        temp = this.file_list.head;
        while (temp != null) {
            if (temp.file_name.equals(file_name)) {
                temp.data++;
                isAdded = true;
                break;
            }
            temp = temp.next; 
        }
        if (!isAdded) {
            temp = this.file_list.head;
            while (temp.next != null) {
                temp = temp.next; 
            }
            temp.next = fnode; 
        }
    }

}


}
