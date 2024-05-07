package com.company.oop.dealership.commands;

import com.company.oop.dealership.core.contracts.VehicleDealershipRepository;
import com.company.oop.dealership.models.contracts.User;

import java.util.List;

public class ShowUsersCommand extends BaseCommand {

    public static final String USER_NOT_ADMIN_ERR = "You are not an admin!";

    public ShowUsersCommand(VehicleDealershipRepository vehicleDealershipRepository) {
        super(vehicleDealershipRepository);
    }

    @Override
    protected String executeCommand(List<String> parameters) {
        User currentlyLoggedUser = getVehicleDealershipRepository().getLoggedInUser();

        if (!currentlyLoggedUser.isAdmin()) {
            throw new IllegalArgumentException(USER_NOT_ADMIN_ERR);
        }

        return printUsers();
    }

    private String printUsers() {
        List<User> users = getVehicleDealershipRepository().getUsers();

        StringBuilder sb = new StringBuilder();
        sb.append("--USERS--").append(System.lineSeparator());

        for (int i = 0; i < users.size(); i++) {
            sb.append(String.format("%d. ", i + 1)).append(users.get(i)).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    protected boolean requiresLogin() {
        return true;
    }
}
