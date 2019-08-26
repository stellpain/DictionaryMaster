import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
    @Bean(name="crud")
    public ICrud CrudConfig() {
        return new Crud();
    }
    @Bean(name="opec")
    public IOperation OperationConfig() {
        return new Operation();
    }
    @Bean(name="input")
    public CheckInputAlpha InputConfig() {
        return new CheckInputAlpha();
    }
    @Bean
    public ControlConsole ConsoleConfig() {
        return new ControlConsole();
    }
}