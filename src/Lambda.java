public class Lambda {
    public static void main(String[] args) {
        Admin Den = new Admin();
        Den.getUserInfo();

        User s = new User(){
            @Override
            public void getUserInfo(){
                System.out.println("Den also ASAP");
            }
        };

        s.getUserInfo();

        User u3 = () -> System.out.println("AAAAAA");

        u3.getUserInfo();
    }
}

interface User{
    void getUserInfo();
}

class Admin implements User{
    @Override
    public void getUserInfo(){
        System.out.println("Tolon married ASAP");
    }
}