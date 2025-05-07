package com.badiga.esa;

import com.badiga.esa.commands.CommandExecutor;
import com.badiga.esa.commands.CreateGroupCommand;
import com.badiga.esa.commands.RegisterUserCommand;
import com.badiga.esa.commands.SettleUpUserCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EsaApplication implements CommandLineRunner {

    private CommandExecutor commandExecutor;

    public EsaApplication(CommandExecutor commandExecutor,
                                     SettleUpUserCommand settleUpUserCommand,
                                     CreateGroupCommand createGroupCommand,
                                     RegisterUserCommand registerUserCommand){
        this.commandExecutor = commandExecutor;
    }

    public static void main(String[] args) {
        SpringApplication.run(EsaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);


        while(true){
            String input = scanner.next();
            //give the input to command executor
            commandExecutor.execute(input);
        }
    }
}