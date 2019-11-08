package test;

/**
 * @author ywh
 * @date 2019/11/5 8:12
 * @description
 * 有位。10个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问后留下的是原来第几号的那
 */
public class Circle {
    public static void main(String[] args) {
        //1.先给人标号
        int [] people =new int[10];
        for(int i=0;i<10;i++){
            people[i]=i+1;
        }
        //2.flag表示出队的条件
        int flag=0;
        //3.退出去的人
        int quitPeople=0;
        //4.标记走到那个人
        int i=0;
        //退出的条件,退出人数为9的时候，不执行
        while(quitPeople<9){
            if(people[i]!=0){
                //说明这个人还在里面
                flag++;
            }
            if(flag==3){
                flag=0;
                people[i]=0;
                quitPeople++;
            }
            i++;
            if(i==10){
                i=0;
            }
        }
        for(int j=0;j<10;j++){
            if(people[j]!=0){
                System.out.println(j+1);
            }
        }
    }


}
