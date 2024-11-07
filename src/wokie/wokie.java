
package wokie;

import java.util.Scanner;

public class wokie {

    
    public static void main(String[] args) {
             
        Scanner sc = new Scanner(System.in);
        String resp;
        do{

            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            wokie test = new wokie();
            switch(action){
                case 1:
                    test.addLoaners();
                break;
                case 2:
                    test.viewLoaners();
                break;
                case 3:
                    test.viewLoaners();
                    test.updateLoaners();
                break;
                case 4:
                    test.viewLoaners();
                    test.deleteLoaners();
                    test.viewLoaners();
                break;
            }
            
            System.out.print("Continue? ");
            resp = sc.next();

        }while(resp.equalsIgnoreCase("yes"));
            System.out.println("Thank You!");

    }

    private static void test() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addLoaners(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Loaner's Full Name: ");
        String fname = sc.nextLine();
        System.out.print("Loaner's Email: ");
        String email = sc.nextLine();
        System.out.print("Loaner's Address: ");
        String address = sc.nextLine();
        System.out.print("Loaner's Status: ");
        String status = sc.nextLine();

        String sql = "INSERT INTO loanapp (name, email, address, status) VALUES (?, ?, ?, ?)";


        conf.addLoaners(sql, fname,  email, address, status);
    }
    
    private void viewLoaners() {
        
        String qry = "SELECT * FROM loanapp";
        String[] hdrs = {"ID", "Full Name", "Email", "Adress", "Status"};
        String[] clms = {"id", "name", "email", "address", "status"};

        config conf = new config();
        conf.viewLoaners(qry, hdrs, clms);
    }
    
    private void updateLoaners(){
    
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Update: ");
        int id = sc.nextInt();
        
        System.out.print("Enter Loaner's Full Name: ");
        String nfname = sc.next();
        System.out.print("Enter Loaner's new Email: ");
        String nemail = sc.next();
        System.out.print("Enter Loaner's new Address: ");
        String naddress = sc.next();
        System.out.print("Enter new Loaner's Status: ");
        String nstatus = sc.next();
        
        String qry = "UPDATE loanapp SET name = ?, email = ?, address = ?, status = ? WHERE id = ?";
        
        config conf = new config();
        conf.updateLoaners(qry, nfname, nemail, naddress, nstatus, id);
        
    }
    
    private void deleteLoaners(){
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int id = sc.nextInt();
        
        String qry = "DELETE FROM loanapp WHERE id = ?";
        
        config conf = new config();
        conf.deleteLoaners(qry, id);
    
    }
   
      
}
