package com.badiga.esa.services;

import com.badiga.esa.commands.SettleUpUserCommand;
import com.badiga.esa.models.*;
import com.badiga.esa.repositories.ExpenseRepository;
import com.badiga.esa.repositories.ExpenseUserRepository;
import com.badiga.esa.repositories.GroupRepository;
import com.badiga.esa.repositories.UserRepository;
import com.badiga.esa.strategies.HeapSettleUpStrategy;
import com.badiga.esa.strategies.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;
    private SettleUpStrategy settleUpStrategy;
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;

    public SettleUpService(UserRepository userRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy,
                           GroupRepository groupRepository,
                           ExpenseRepository expenseRepository){
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> settleUpUser(Long userId){

        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new RuntimeException("Invalid user " + userId);
        }

        User user = optionalUser.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

        Set<Expense> expenses = new HashSet<>();

        for(ExpenseUser expenseUser:expenseUsers){
            expenses.add(expenseUser.getExpense());
        }



        //Settle up the expenses
        List<Expense> transactionsToBeDone = settleUpStrategy.settleUp(expenses.stream().toList());

        List<Expense> expensesToReturn = new ArrayList<>();



        for(Expense expense:transactionsToBeDone){
            for(ExpenseUser expenseUser:expense.getExpenseUsers()){
                if(expenseUser.getUser().equals(user)){
                    expensesToReturn.add(expenseUser.getExpense());
                }
            }
        }

        return expensesToReturn;
    }

    public List<Expense> settleUpGroup(Long groupId){
        Optional<Group> optionalGroup = groupRepository.findById(groupId);

        if(optionalGroup.isEmpty()){
            throw new RuntimeException("Group is invalid " + groupId);
        }

        Group group = optionalGroup.get();

        List<Expense> expenses = expenseRepository.findAllByGroup(group);

        return settleUpStrategy.settleUp(expenses);
    }
}