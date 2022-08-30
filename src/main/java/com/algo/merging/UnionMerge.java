package com.algo.merging;

import java.util.*;

public class UnionMerge {

    public static void main(String[] args) {
            List<List<String>> adj = new ArrayList<>();
            adj.add(Arrays.asList("Cormak", "Carrickmail.com ","Brendanmail.com"));
            adj.add(Arrays.asList("Ahmed", "Didiermail.com ","Ameermail.com" ,"Denzelmail.com" ,"Eduardomail.com" ,"Eljaymail.com"));
            adj.add(Arrays.asList("Deagan", "Caelanmail.com", "Danmail.com", "Fabianmail.com", "Chestermail.com", "Darrochmail.com", "Deanmail.com", "Cohenmail.com", "Finleymail.com" ,"Edwynmail.com"));

            UnionMerge obj = new UnionMerge();
            List<List<String>> ans = obj.mergeDetails(adj);
            Collections.sort(ans,
                    (x, y) -> {
                        return x.get(0).compareTo(y.get(0));
                    });

            System.out.println(ans);
        }


    public List<List<String>> mergeDetails(List<List<String>> details) {
        // Your code here
        List<List<String>> res = new ArrayList<>();
        Set<String> emails = new TreeSet<>();
        for(int i = 0;i<details.size();i++){
            List<String> detail = details.get(i);
            if(detail.size()==0)
                continue;
            String name = detail.get(0);
            emails.clear();
            for(int k = 1;k<detail.size();k++)
                emails.add(detail.get(k));

            for(int j = i+1;j<details.size();j++){
                List<String> temp = details.get(j);
                if(temp.size() == 0)
                    continue;
                boolean found = false;
                for(int k = 1;k<temp.size();k++){
                    if(emails.contains(temp.get(k))){
                        for(int l =1;l<temp.size();l++){
                            emails.add(temp.get(l));
                        }
                        found = true;
                        break;
                    }
                }
                if(found == true)
                    temp.clear();
            }
            List<String> det = new ArrayList<>();
            det.add(name);
            for(String email:emails){
                det.add(email);
            }
            res.add(det);
        }
        return res;
    }
}
