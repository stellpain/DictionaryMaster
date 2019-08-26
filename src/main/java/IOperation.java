import java.util.Map;
import java.util.List;
public interface IOperation {

    String getValue(String key);

    int scannerInt(int count) throws Exception;

    Map<String, String> getAlphabet();

    boolean getAlphabetCount();

    List<String> getAlphabetNames();

    String read();

    String create(String key, String value, int i);

    String delete(String key, int i);

    String inputString();
}