import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
public class VotingSystem {
    
    static class Candidate {
    String Name;
    String Position;
    int Votes;
    
    Candidate(String Name, String Position) {
        
      this.Name = Name;
      this.Position = Position;
      this.Votes = 0;
      
      }
    }
    
    static ArrayList<Candidate> candidates = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    static HashMap<String, String> Account = new HashMap<>();
    static HashMap<String, Boolean> HasVoted = new HashMap<>();
    
    public static void main(String[] args) {
        
    candidates.add(new Candidate("John Mark", "President"));
    candidates.add(new Candidate("Lucy Grace", "President"));
    candidates.add(new Candidate("Max George", "President"));
    
    boolean running = true;
    
    while(running) {
    System.out.println("=== Main Menu ===");
    System.out.println("1. Login/Signup");
    System.out.println("2. Admin");
    System.out.println("3. Exit");
    System.out.print("Type '1' Login/Signup, '2' Admin, '3' Exit: ");
    String choice = input.nextLine();
    
    if (choice.equals("1")) {
   
    while(true) {
    System.out.println("Login");
    System.out.println("Signup");
    System.out.print("Type either 'L' or 'S': ");
    String Type = input.nextLine();
    
      if (Type.equals("L")) {
      Login();
      break;
      } else if (Type.equals("S")) {
      Signup();
      break;
       } else { System.out.println("Wrong input! Type either 'L' or 'S");}
      
       }
   } else if (choice.equals("2")) {
     System.out.println("=== Admin ===");
     
     while(true) {
     System.out.print("Enter Username: ");
     String username = input.nextLine();
     System.out.print("Enter Password: ");
     String password = input.nextLine();
     
     if (!username.equals("admin") || !password.equals("123")) {
         System.out.println("Your Username or Password is Incorrect/You Can't Leave both Username and Password empty."
                 + "Try Again!"); 
    } else if (username.equals("admin") && password.equals("123")) { System.out.println("Login Succefful!");
    System.out.println("Proceeding into Admin Section");
     admin();
     break;
    }
   }
  } else if (choice.equals("3")) {
     System.out.print("Are Sure You Wanted to Exit Y/N: ");
     String confirm = input.nextLine();
     
     if (confirm.equals("Y")) {
     System.out.println("Goodbye");
     running = false;
     } else if (confirm.equals("N")) {
     } 
  } else { System.out.println("Choose Only Between '1-3'"); }
 }
}
   public static void Signup() {
        
    System.out.println("=== Signup ===");
    
    String user;
    String pass;
    
    while(true) {
    System.out.print("Create Username: ");
    user = input.nextLine();
    
    if (!user.equals("")){
        break;
      } System.out.println("Username Cannot be Empty. Try Again!");
    }
    
     while(true) {
    System.out.print("Create Password: ");
    pass = input.nextLine();
    
    if (!pass.equals("")){
        break;
      } System.out.println("Password Cannot be Empty. Try Again!");
    
    }
     
     Account.put(user, pass);
     HasVoted.put(user, false);
     
     System.out.println("Signup Successful!");
}
   public static void Login() {
       
    System.out.println("=== Login ===");
   
    while(true) {
    System.out.print("Enter Username: ");
    String user = input.nextLine();
    System.out.print("Enter Password: ");
    String pass = input.nextLine();
    
    if (!Account.containsKey(user) || !Account.get(user).equals(pass) ) {
        System.out.println("Username or Password is incorrect");
        System.out.print("Type 'B' to Signup or 'C' to Login: ");
        String type = input.nextLine();
        if (type.equals("C")) {} 
        else if (type.equals("B")) { System.out.println("Proceeding to Signup");
        Signup();
        break;}
     } else if (Account.containsKey(user) && Account.get(user).equals(pass) ) {
     System.out.println("Login successful!");
     VotingSection(user);
     break;
     }
    }
  }
    public static void VotingSection (String user) {
     
     if (Boolean.TRUE.equals(HasVoted.get(user))) {
     System.out.println("=== View Candidate ===");
     
     for (int i = 0; i < candidates.size(); i++) {
      Candidate C = candidates.get(i);
      System.out.println((i + 1) + ". " + C.Name + " - " + C.Position);
    }
     
      System.out.println("============");
      System.out.println("You Alread Voted. You cannot Vote Again!");
      System.out.print("Type 'B' to return: ");
      String press = input.nextLine();
      if (press.equals("B")) {
          return;
        }
    } 
     showCandidates();
     
     while(true) {
     System.out.print("Choose Candidate Number:");
     int Choice = input.nextInt();
     input.nextLine();
     
     if (Choice >= 1 && Choice <= candidates.size()) {
     candidates.get(Choice - 1).Votes++;
     HasVoted.put(user, true);
     System.out.println("Vote Counted");
     break;
     } else { System.out.println("Invalid Choice!");
     }
    }
       System.out.print("Do you wanted to 'Y' return to Main menu or 'N' Back to VotingSection: ");
       String choose = input.nextLine();
       
       if (choose.equals("Y")) {
           return;
       } else if (choose.equals("N")) {
       VotingSection(user);
       }
  }
    
   public static void showCandidates () {
    System.out.println("=== Candidate List ===");
        
    for (int i = 0; i < candidates.size(); i++) {
      Candidate C = candidates.get(i);
      System.out.println((i + 1) + ". " + C.Name + " - " + C.Position);
    }
  }
   
   public static void admin () {
   while(true) {
    System.out.println("=== Admin Section ===");
    System.out.println("1.Add Candidates");
    System.out.println("2.Show Ranking");
    System.out.println("3.Back to Main Menu");
    
    System.out.print("Choose '1', '2', '3': ");
    String num = input.nextLine();
    
    if (num.equals("1")) {
        AddCandidates();
    } else if (num.equals("2")) {
        ShowRanking();
    } else if (num.equals("3")) {
        return;
    } else {
        System.out.println("Wrong input. Try Again!");
    }
   }
 } 
   public static void AddCandidates() {
    System.out.println("=== ADD CANDIDATES ===");
    
    while(true) {
    
      System.out.print("Enter the Candidate Name: ");
      String man = input.nextLine();
      System.out.print("Enter the Candidate Position: ");
      String pose = input.nextLine();
      
      candidates.add(new Candidate(man, pose));
      
      System.out.print("Do you Want to ADD more? Y/N: ");
      String Decision = input.nextLine();
      
      if (Decision.equals("Y")) {}
      else if (Decision.equals("N")) {
      return;
      }
    }
 }
   public static void ShowRanking() {
   
    ArrayList<Candidate> sorted = new ArrayList<>(candidates);
    
    // Sort Highest Votes First
    sorted.sort((a, b) -> b.Votes - a.Votes);
    
    System.out.println("=== Candidate Ranking ===");
   
    for(int i = 0; i < sorted.size(); i++) {
    
        Candidate c = sorted.get(i);
        System.out.println((i + 1) + ". " + c.Name + " - " + c.Position + " | Votes: " + c.Votes);
    }
   
     System.out.println("===================");
     System.out.print("Back to Admin Section 'Y': ");
     String the = input.nextLine();
     
     if (the.equals("Y")) {}
   
 }
}
   