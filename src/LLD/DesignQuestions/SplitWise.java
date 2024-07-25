package LLD.DesignQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SplitWiseUser {
    private int id;
    private String name;
    private List<SplitWiseUser> friends;
    private Map<Integer, Integer> balanceSheet;

    public int getId() {
        return id;
    }

    public SplitWiseUser(int id, String name, List<SplitWiseUser> friends, Map<Integer, Integer> balanceSheet) {
        this.id = id;
        this.name = name;
        this.friends = friends;
        this.balanceSheet = balanceSheet;
    }

    public void updateBalanceSheet(int user_id, int amount) {
        this.balanceSheet.put(user_id, this.balanceSheet.getOrDefault(user_id, 0) + amount);
    }

    public String getBalanceSheet() {
        return this.balanceSheet.toString();
    }
}
class UserController {
    Map<Integer, SplitWiseUser> users;

    public UserController(Map<Integer, SplitWiseUser> users) {
        this.users = users;
    }
    public void addUser(SplitWiseUser user) {
        this.users.put(user.getId(), user);
    }

    public SplitWiseUser getUser(int user_id) {
        return this.users.get(user_id);
    }
}

enum SplitType{
    EQUAL,
    UNEQUAL,
    PERCENTAGE
}


class Expense {
    private int expenseCreatorId;
    private SplitType splitType;
    private int totalAmount;
    private List<Integer> user_ids;

    public Expense(int expenseCreatorId,SplitType splitType, int totalAmount, List<Integer> user_ids) {
        this.expenseCreatorId = expenseCreatorId;
        this.splitType = splitType;
        this.totalAmount = totalAmount;
        this.user_ids = user_ids;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getExpenseCreatorId() {
        return expenseCreatorId;
    }

    public List<Integer> getUser_ids() {
        return user_ids;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void updateUserBalanceSheet(UserController service) {
        int splitAmount = totalAmount / user_ids.size();
        for (int userId : user_ids) {
            SplitWiseUser user = service.getUser(userId);
            SplitWiseUser expenseCreator = service.getUser(expenseCreatorId);
            user.updateBalanceSheet(expenseCreatorId, -splitAmount);
            expenseCreator.updateBalanceSheet(userId, splitAmount);
        }
    }
}

class ExpenseController {
    UserController userController;

    public ExpenseController(UserController userController) {
        this.userController = userController;
    }

    public Expense createExpense(int expenseCreatorId,SplitType splitType, int totalAmount, List<Integer> user_ids) {
        return new Expense(expenseCreatorId, splitType, totalAmount, user_ids);
    }

    public void settleExpense(Expense expense) {
        List<Integer> user_ids = expense.getUser_ids();
        int splitAmount = expense.getTotalAmount() / user_ids.size();
        int expenseCreatorId = expense.getExpenseCreatorId();
        for (int userId : user_ids) {
            SplitWiseUser user = userController.getUser(userId);
            SplitWiseUser expenseCreator = userController.getUser(expenseCreatorId);
            user.updateBalanceSheet(expenseCreatorId, -splitAmount);
            expenseCreator.updateBalanceSheet(userId, splitAmount);
        }
    }
}


class Payment {
    SplitWiseUser sender;
    SplitWiseUser receiver;
    int totalAmount;

    public Payment(SplitWiseUser sender, SplitWiseUser receiver, int totalAmount) {
        this.sender = sender;
        this.receiver = receiver;
        this.totalAmount = totalAmount;
    }

    public void execute() {
        this.sender.updateBalanceSheet(this.receiver.getId(), totalAmount);
        this.receiver.updateBalanceSheet(this.sender.getId(), -totalAmount);
    }
}



public class SplitWise {
    public static void main(String[] args) {
        SplitWiseUser user1 = new SplitWiseUser(1, "Alice", new ArrayList<>(), new HashMap<>());
        SplitWiseUser user2 = new SplitWiseUser(2, "Bob", new ArrayList<>(), new HashMap<>());
        SplitWiseUser user3 = new SplitWiseUser(3, "Charlie", new ArrayList<>(), new HashMap<>());

        // Initialize UserService with a user map
        UserController userController = new UserController(new HashMap<>());


        // Add users to the UserService
        userController.addUser(user1);
        userController.addUser(user2);
        userController.addUser(user3);

        List<Integer> userIds = List.of(user2.getId(), user3.getId()); // Alice, Bob, Charlie
        ExpenseController expenseController = new ExpenseController(userController);
        Expense expense = expenseController.createExpense(user1.getId(), SplitType.EQUAL, 90, userIds);
        expenseController.settleExpense(expense);

        System.out.println("Alice's balance sheet: " + user1.getBalanceSheet());
        System.out.println("Bob's balance sheet: " + user2.getBalanceSheet());
        System.out.println("Charlie's balance sheet: " + user3.getBalanceSheet());


        // Create payment instances
        Payment payment1 = new Payment(user2, user1, 45); // Alice pays Bob 50
        Payment payment2 = new Payment(user3, user1, 30); // Bob pays Charlie 30

        // Execute payments
        payment1.execute();
        payment2.execute();

        // Print out balance sheets for verification
        System.out.println("#############################################");
        System.out.println("Alice's balance sheet: " + user1.getBalanceSheet());
        System.out.println("Bob's balance sheet: " + user2.getBalanceSheet());
        System.out.println("Charlie's balance sheet: " + user3.getBalanceSheet());
    }
}
