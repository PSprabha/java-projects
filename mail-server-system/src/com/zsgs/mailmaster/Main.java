package com.zsgs.mailmaster;

import com.zsgs.mailmaster.data.db.MailRepository;
import com.zsgs.mailmaster.features.mail.manage.ManageModel;
import com.zsgs.mailmaster.features.mail.manage.ManageView;
import com.zsgs.mailmaster.features.registration.RegistrationModel;
import com.zsgs.mailmaster.features.registration.RegistrationView;
import com.zsgs.mailmaster.data.dto.User;
import com.zsgs.mailmaster.data.dto.Mail;
import java.util.Scanner;
import java.util.Optional;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        MailRepository mailRepository = new MailRepository();
        ManageModel mailManageModel = new ManageModel(mailRepository);
        ManageView mailManageView = new ManageView();
        RegistrationModel registrationModel = new RegistrationModel();
        RegistrationView registrationView = new RegistrationView();

        User currentUser = null;
        while (true) 
        {
            System.out.println("\n--- Mail Console Application ---");
            
            if (currentUser == null) 
            {
                System.out.println("1. Register User");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine();
                
                switch (choice)
                {
                    case "1":
                    	
                        String name = registrationView.getNameInput();
                        int age = registrationView.getAgeInput();
                        String phone = registrationView.getPhoneInput();
                        String email = registrationView.getEmailInput();
                        String password = registrationView.getPasswordInput();
                        
                        User user = registrationModel.registerUser(name, password, email, age, phone);
                        registrationView.showUser(user);
                        break;
                        
                    case "2":
                    	
                        String loginEmail = registrationView.getEmailInput();
                        String loginPassword = registrationView.getPasswordInput();
                        
                        Optional<User> loginUser = registrationModel.authenticateUser(loginEmail, loginPassword);
                        
                        if (loginUser.isPresent()) 
                        {
                            currentUser = loginUser.get();
                            registrationView.showMessage("Login successful! Welcome, " + currentUser.getUsername() + ".");
                        } 
                        else 
                            registrationView.showMessage("Invalid email or password.");
                        
                        break;
                    case "0":
                    	
                        System.out.println("Exiting application.");
                        System.exit(0);
                        
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } 
            else 
            {
                System.out.println("Logged in as: " + currentUser.getUsername() + " (ID: " + currentUser.getId() + ")");
                System.out.println("1. Send Mail");
                System.out.println("2. View Inbox");
                System.out.println("3. View Sent Mails");
                System.out.println("4. Switch User");
                System.out.println("0. Logout");
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine();
                
                switch (choice) 
                {
                    case "1":
                    	
                        String receiverEmail = registrationView.prompt("Enter receiver's email: ");
                        String subject = registrationView.prompt("Enter subject: ");
                        String body = registrationView.prompt("Enter message: ");
                        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        // Validate receiver exists
                        
                        Optional<User> receiver = registrationModel.getAllUsers().stream().filter(u -> u.getEmail().equals(receiverEmail)).findFirst();
                        
                        if (!receiver.isPresent()) 
                            registrationView.showMessage("Receiver email not found. Mail not sent.");
                        else 
                        {
                            mailManageModel.createMail(currentUser.getEmail(), receiverEmail, subject, body, timestamp);
                            registrationView.showMessage("Mail sent successfully!");
                        }
                        break;
                        
                    case "2":
                    	
                        List<Mail> inbox = mailManageModel.getAllMails();
                        boolean foundInbox = false;
                        
                        for (Mail mail : inbox) 
                        {
                            if (mail.getRecipient().equals(currentUser.getEmail())) 
                            {
                                mailManageView.showMail(mail);
                                foundInbox = true;
                            }
                        }
                        if (!foundInbox)
                            registrationView.showMessage("No mails in your inbox.");
                        
                        break;
                        
                    case "3":
                    	
                        List<Mail> sent = mailManageModel.getAllMails();
                        boolean foundSent = false;
                        for (Mail mail : sent)
                        {
                            if (mail.getSender().equals(currentUser.getEmail())) 
                            {
                                mailManageView.showMail(mail);
                                foundSent = true;
                            }
                        }
                        if (!foundSent) 
                            registrationView.showMessage("No sent mails.");
                        
                        break;
                        
                    case "4":
                        currentUser = null;
                        break;
                        
                    case "0":
                        registrationView.showMessage("Logged out.");
                        currentUser = null;
                        break;
                        
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }
        }
    }
}
