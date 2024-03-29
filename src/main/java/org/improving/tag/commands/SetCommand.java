package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.Player;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class SetCommand implements Command {
    private InputOutput io;

    public SetCommand(InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input.contains("=") == false) return false;
        input = input.trim();
        var parts = input.split("=");
        if (parts.length == 1) return false;
        return parts[0].equalsIgnoreCase("@set name");
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        var name = input.split("=")[1].trim();
        game.getPlayer().setName(name);
        io.displayText("Your name is now " + name);
    }

}
