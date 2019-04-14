package Hometask5;

public class Main {
    public static void main(String[] args) {
        Worker[] WorkerArr = new Worker[5];
        WorkerArr[0] = new Worker("Alexander Al", "saller", "al@gmail.hh", "78126443346", 4000000, 30);
        WorkerArr[1] = new Worker("Ivan uBAH","secretry","iv@gmai.jj","79237645235",8126737,45);
        WorkerArr[2] = new Worker("Gary Gray","Uber driver","wgt@jsdf.ru","37123656",43757,42);
        WorkerArr[3] = new Worker("Jane Gas", "Model","Mew@dsf.gg","6213412534",999991,20);
        WorkerArr[4] = new Worker("Grace Black","teacher","Teach@hfg.lll","723652861",912394,50);

        for(int i=0;i<5;i++){
            if(WorkerArr[i].getAge()>=40){
                WorkerArr[i].showINFO();
            }
        }
    }
}

    class Worker{
        String name;
        String job;
        String email;
        String phoneNum;
        int salary;
        int age;

        public Worker(String name, String job, Stri     ng email, String phoneNum, int salary, int age) {
            this.name = name;
            this.job = job;
            this.email = email;
            this.phoneNum = phoneNum;
            this.salary = salary;
            this.age = age;
        }

        public void showINFO(){
            System.out.println(name+" "+job+" "+email+" "+phoneNum+" "+salary+" "+age);
        }

        public int getAge(){
            return age;
        }
    }

