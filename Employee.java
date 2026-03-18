public class Employee extends User {

    private String jobTitle;
    private double pay;
    private String bankAccount;

    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }

    public String getJobTitle(){
        return jobTitle;
    }

    public void setPay(double pay){
        this.pay = pay;
    }

    public double getPay(){
        return pay;
    }

    public void setBankAccount(String bankAccount){
        this.bankAccount = bankAccount;
    }

    public String getBankAccount(){
        return bankAccount;
    }
}