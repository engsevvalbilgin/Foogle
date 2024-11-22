/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bilginyilmaz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class BilginYilmazBTree {
    BilginYilmazBNode root;

    public BilginYilmazBTree() {
        root=null;
    }
    private boolean isIgnored(String word, File ignoreFile) {
        try {
            Scanner ignoreListReader = new Scanner(ignoreFile);
            while (ignoreListReader.hasNext()) {
                String ignoreWord = ignoreListReader.next();
                if (word.equals(ignoreWord)) {
                    ignoreListReader.close();
                    return true; // Kelime ignoreList'te bulunduğunda true döndür
                }
            }
            ignoreListReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the ignoreList file: " + e.getMessage());
        }
        return false; // Kelime ignoreList'te bulunmadığında veya dosya okunamadığında false döndür
    }
//    public  static BilginYilmazBTree createBTree(File[] files,File ignoreFile){
//     BilginYilmazBTree b=new BilginYilmazBTree();
//        for (File file : files) {
//                    try {
//            Scanner fileReader = new Scanner(file);
//            while (fileReader.hasNext()) {
//                String word = fileReader.next().replaceAll("\\<.*?\\>", "");
//                word = word.replaceAll(",", "").replaceAll("\\.", "");
//                if (!word.isEmpty()) {
//
//                   // System.out.println(word);
//                            if (ignoreFile.exists()) {
//            try {
//                Scanner ignoreListReader = new Scanner(ignoreFile);
//                while (ignoreListReader.hasNext()) {
//                    String ignoreWord = ignoreListReader.next();
//                   
//                }
//                System.out.println(word);
//                ignoreListReader.close();
//            } catch (FileNotFoundException e) {
//                System.out.println("An error occurred while reading the  ignoreList file: " + e.getMessage());
//                return null;
//            }
//        } else {
//            System.out.println("ignoreList file could not find.");
//            return null;
//        }
//                }
//            }
//            fileReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred while reading the file:" + e.getMessage());
//            return null;
//        }
//                    
//        }
//        
//     return b;
//    }
    
    public static BilginYilmazBTree createBTree(File[] files, File ignoreFile) {
        BilginYilmazBTree b = new BilginYilmazBTree();
       
        for (File file : files) {
            try {
                Scanner fileReader = new Scanner(file);
                while (fileReader.hasNext()) {
                    String word = fileReader.next().replaceAll("\\<.*?\\>", "");
                    word = word.replaceAll(",", "").replaceAll("\\.", "");
                    word=word.toLowerCase();
                    if (!word.isEmpty() && !b.isIgnored(word, ignoreFile)) {
                        
                        b.add(word,file.getName());
                    }
                }
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred while reading the file: " + e.getMessage());
                return null;
            }
        }
        return b;
    }
//    public boolean contains(String word){
//        if(root==null){
//            return false;
//        }
//        else{
//            BilginYilmazBNode newn=root;
//            while (newn.left!=null&&newn.right!=null) {                
//                if(newn.data.compareTo(word)==0){
//                return true;
//                }
//                else if(newn.data.compareTo(word)<0){
//                newn=newn.right;
//                }
//                else if(newn.data.compareTo(word)>0){
//                newn=newn.left;
//                }
//            }
//        }
//    return false;
//    }
    public void add(String word, String file_name) {
    if (root == null) {
        root = new BilginYilmazBNode(word); // Kök düğümü oluştur
        root.addFileList(file_name); // Kök düğümüne dosya ekle
        return;
    }

    BilginYilmazBNode current = root;
    while (true) {
        if (word.compareTo(current.data) < 0) {
            if (current.left == null) {
                current.left = new BilginYilmazBNode(word); // Yeni sol düğümü oluştur
                current.left.addFileList(file_name); // Yeni sol düğüme dosya ekle
                return;
            }
            current = current.left; // Sol düğüme ilerle
        } else if (word.compareTo(current.data) > 0) {
            if (current.right == null) {
                current.right = new BilginYilmazBNode(word); // Yeni sağ düğümü oluştur
                current.right.addFileList(file_name); // Yeni sağ düğüme dosya ekle
                return;
            }
            current = current.right; // Sağ düğüme ilerle
        } else { // Eğer kelime zaten ağaçta varsa
            
            current.addFileList(file_name); // Dosyayı mevcut düğümün dosya listesine ekle
            return;
        }
    }
}

    }

//    public void add(String word,String file_name){
//        if(!contains(word)){}
//        else{
//        BilginYilmazBNode newn=root;
//            while (newn.left!=null&&newn.right!=null) {                
//                if(newn.data.compareTo(word)==0){
//                    BilginYilmazFNode f=newn.file_list.head;
//                    while (f.next!=null) {                        
//                        if(f.file_name==file_name){
//                            System.out.println("word: "+word+"data: "+f.data);
//                        f.data++;
//                        break;
//                        }
//                        f=f.next;
//                    }
//                }
//                else if(newn.data.compareTo(word)<0){
//                newn=newn.right;
//                }
//                else if(newn.data.compareTo(word)>0){
//                newn=newn.left;
//                }
//            }}
//    }

