import java.util.Scanner;


//将文件拷贝下来之后的修改



public class Password {
    public static void main(String[] args) {
        while (true) {
            print();
            System.out.println("           请选择操作：");
            System.out.println("1. 加密\n2. 解密\n5. 退出");
            System.out.println();
            String num = init1();
            if(num.equals("5")){
                break;
            }
            switch (num) {
                case "1":
                    print();
                    System.out.println("请输入要加密的数字密码：");
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
                case "5":break;
            }
        }

    }

    public static String init1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入选择序号：");
        String num = sc.nextLine();
        if (num.matches("[1-5]")) {
            return num;
        } else {
            try {
                throw new Exception("输入的密码不合法");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public static String init2() {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        if (password.matches("[1-9a-zA-Z]{1,16}")) {
            return password;
        } else {
            try {
                throw new Exception("输入的密码不合法");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
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
    public static void print(){
        System.out.println("==============================");
        System.out.println("      欢迎使用密码管理系统        ");
        System.out.println("==============================");

    }
}
