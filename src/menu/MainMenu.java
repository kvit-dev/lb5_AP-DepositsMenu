package menu;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MainMenu {
    private Map<String, Option> menuItems;

    public MainMenu() {
        menuItems = new LinkedHashMap<>();
        menuItems.put("0", new Option("Exit program", new ExitOption()));
        menuItems.put("1", new Option("Search deposit in bank", new SearchDepositInBank()));
        menuItems.put("2", new Option("Add deposit", new AddDeposit()));
        menuItems.put("3", new Option("Remove deposit", new RemoveDeposit()));
        menuItems.put("4", new Option("Search deposits", new SearchDeposits()));
        menuItems.put("5", new Option("Sort deposits", new SortDeposits()));
        menuItems.put("6", new Option("Change deposit info", new ChangeDepositInfo()));
    }

    public void displayMenu() {
        System.out.println("\nMenu:");
        menuItems.forEach((key, option) ->
                System.out.println(key + "-" + option.getName()));
    }

    public void executeCommand(String command) {
        menuItems.getOrDefault(command, new Option("Invalid", () -> {
            System.out.println("Incorrect command was used");
            System.out.println("Available commands: " + getAvailableCommands());
        })).getCommand().execute();
    }

    public Set<String> getAvailableCommands() {
        return menuItems.keySet();
    }
}
