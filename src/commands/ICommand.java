package commands;

import java.util.List;

public interface ICommand{
    void invoke(List<String> tokens);
}
