/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arraylist;

import java.util.ArrayList;

/**
 *
 * @author Brahian Vera
 */
public class Main {
    
    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList();
        ArrayList<Integer> usedPosition = new ArrayList();
        Integer evenNumBackup =  0;
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(4);
        nums.add(7);
        nums.add(9);
        nums.add(11);
        
        for(int posEven = 0; posEven < nums.size(); posEven++){
            if(!(nums.get(posEven) %2 == 0)){
                continue;
            }
            for(int posOdd = posEven; posOdd < nums.size(); posOdd++){
                evenNumBackup = nums.get(posEven);
                Boolean changedPositionNumberEven = usedPosition.indexOf(posEven) == -1;
                if(!(nums.get(posOdd) %2 == 0) && changedPositionNumberEven ){
                    usedPosition.add(posOdd);
                    nums.set(posEven,nums.get(posOdd));
                    nums.set(posOdd,evenNumBackup);
                    break;
                }
            }
            
        }
        System.out.println(nums);   
    }
    
}
