package 项目管理实践;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

 class Password {
    public static void main(String[] args) {
        while (true) {
            print();
            System.out.println("           请选择操作：");
            System.out.println("1. 加密\n2. 解密\n3. 判断密码强度\n4. 随机生成密码\n5. 退出");
            System.out.println();
            String num = init1();
            if(num.equals("5")){
                break;
           }
            switch (num) {
                case "1":
                    print();
                    System.out.print("请输入要加密的数字密码：");
                    System.out.println("加密后的结果是：" + encrypt(init2()));
                    System.out.println();
                    System.out.println("按任意键返回");
                    break;

                case "2":
                    print();
                    System.out.println("请输入要解密的数字密码：");
                    System.out.println("解密后的结果是：" + decrypt(init2()));
                    System.out.println("按任意键返回");
                    break;
                case "3":
                    print();
                    System.out.print("请输入要判断的数字密码：");
                    System.out.println("密码强度为：" + judge(init2()));
                    System.out.println("按任意键返回");
                    break;
                case "4":
                    print();
                    System.out.print("请输入要判断的数字密码：");
                    System.out.println("随机生成的密码："+generate());
                    System.out.println("按任意键返回");
                    break;
                case "5":break;
            }
        }

    }
    public static String init1(){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入选择序号：");
        try {
            String num = sc.nextLine();
            if (num.matches("[1-5]")) {
                return num;
            }else {
                throw new Exception("输入的密码不合法");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String init2() {
        Scanner sc = new Scanner(System.in);
        try {
            String password = sc.nextLine();
            if (password.matches(".*\\W+.*")||password.matches(".*_+.*")) {
                throw new Exception("输入的密码不合法");
            }else {
                return password;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String encrypt(String password){
        String word = "";
        char []Staging = new char[password.length()];
        for (int i = 0; i < password.length(); i++) {
            Staging[i]= (char) ((int)password.charAt(i)+i+4);
        }
        char a = Staging[0];
        Staging[0] = Staging[Staging.length-1];
        Staging[Staging.length-1] = a;


        for (int i = Staging.length-1; i >=0 ; i--) {
            word += Staging[i];
        }
        return word;
    }
    public static String decrypt(String password){
        String word = "";
        char []Staging = new char[password.length()];
        for (int i = 0; i < password.length(); i++) {
            Staging[i]= (char) ((int)password.charAt(Staging.length-1-i));
        }
        char a = Staging[0];
        Staging[0] = Staging[Staging.length-1];
        Staging[Staging.length-1] = a;


        for (int i = 0; i < password.length(); i++) {
            word += (char)((int)Staging[i]-i-4);
        }
        return word;
    }
    public static String judge(String password) {
        if (password.length()>=8&&password.matches(".*\\d.*")&&password.matches(".*[a-z].*")&&password.matches(".*[A-Z].*")) {
            return "强";
        } else if (password.length()>=8&&password.matches(".*\\d.*")&&password.matches(".*[a-zA-Z].*")) {
            return "中";
        } else if(password.length()<8||(password.length()>=8&&(password.matches("\\d+")||password.matches("[a-zA-Z]+")))){
            return "弱";
        }
        return "异常";
    }
    public static String generate(){
        String word = "";
        Random r = new Random();
        ArrayList<Character> arr = new ArrayList<>();
        int number = r.nextInt(9)+8;
        char num1 = (char)(r.nextInt(10)+48);
        char num2 = (char)(r.nextInt(26)+97);
        char num3 = (char)(r.nextInt(26)+65);
        arr.add(num1);
        arr.add(r.nextInt(arr.size()),num2);
        arr.add(r.nextInt(arr.size()),num3);
        int count = 3;
        while (count<number){
            arr.add(r.nextInt(arr.size()),(char)random());
            count++;
        }
        for (int i = 0; i < arr.size(); i++) {
            word += arr.get(i);
        }
        return word;
    }
    public static void print(){
        System.out.println("==============================");
        System.out.println("      欢迎使用密码管理系统        ");
        System.out.println("==============================");
    }
    public static int random(){
        Random r = new Random();
        while (true){
            int num = r.nextInt(123);
            if((num>=48&&num<=57)||(num>=97&&num<=122)||(num>=65&&num<=90)){
                return num;
            }
        }
    }
}
