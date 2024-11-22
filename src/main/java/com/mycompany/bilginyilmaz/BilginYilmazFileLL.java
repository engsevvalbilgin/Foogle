/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bilginyilmaz;

/**
 *
 * @author hp
 */
public class BilginYilmazFileLL {
    BilginYilmazFNode head;
    public BilginYilmazFNode get(String file_name) {
    BilginYilmazFNode current = head;
    while (current != null) {
        if (current.file_name.equals(file_name)) {
            return current; // Dosya adına sahip düğümü bulduk, dolayısıyla onu döndür
        }
        current = current.next; // Bir sonraki düğüme geç
    }
    return null; // Dosya adına sahip düğümü bulamadık, dolayısıyla null döndür
}

//    public BilginYilmazFNode get(String file_name){
//        BilginYilmazFNode n=head;
//        while (n!=null&&n.file_name.compareTo(file_name)!=0) {            
//            n=n.next;
//          
//        }
//        return n;
//    }
}
