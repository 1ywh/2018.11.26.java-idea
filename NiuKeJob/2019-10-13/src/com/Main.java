package com;

/**
 * @author ywh
 * @date 2019/10/13 10:21
 * @description 
 */
public class Main {
    static boolean out(char c){
        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {
        int i=0;
        for(out('A');out('B')&&(i<2);out('C')){
            i++;
            out('D');
        }
    }
}
//A
//B
//D
//C
//B
//D
//C
//B