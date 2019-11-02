package designpattern;

import sun.reflect.generics.repository.GenericDeclRepository;

/**
 * 描述性别的多例
 * Author:ywh
 */
public class Gender {

    private final String value;

    private static final Gender FEMALE = new Gender("女");

    private static final Gender MALE = new Gender("男");

    private Gender(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static Gender getInstance(int type) {
        switch (type) {
            case 0:
                return MALE;
            case 1:
                return FEMALE;
            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Gender m = Gender.getInstance(1);
        Gender w = Gender.getInstance(0);
        System.out.println(m == w);//false
        System.out.println(m == Gender.getInstance(1));//true

        if (m != null) {
            System.out.println(m.getValue());//女
        }

        TestGender f = TestGender.FEMALE;
        TestGender g = TestGender.MALE;
        System.out.println(f == g);//false
        System.out.println(f.getType());//女

        TestGender[] genders = TestGender.values();
        for (TestGender testGender : genders) {
            System.out.println("Type" + testGender.getType() + "Name" + testGender.name());
        }

        TestGender gender1 = TestGender.valueOf("MALE");
        System.out.println("Type" + gender1.getType() + "Name" + gender1.name());

    }


}
