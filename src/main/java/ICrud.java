import java.util.Map;
import java.util.List;
public interface ICrud {
	String read();

	String create(String key, String value, int i);

	String delete(String key, int i);

	Map<String, String> getAlphabet();

	String getValue(String key);

	List<String> getAlphabetNames();
}