import org.springframework.context.annotation.Configuration;

@Configuration
public class CheckInputAlpha{
	CheckInputAlpha() {
	}
	public FormatEnumAha checkInputAdd( String key) {
		String validationString = "[a-zA-Z]+";
		String validationInt = "[0-9]+";
		if (key.matches(validationString)) {
			return FormatEnumAha.string;
		} else if (key.matches(validationInt)) {
			return FormatEnumAha.integer;
		}
		return FormatEnumAha.mix;
	}
	public boolean checkLength(int stringKeyLength, String key) throws Exception {
		if (key.length() <= stringKeyLength)
			return true;
		else throw new Exception("Ключ не должен быть больше " + stringKeyLength + " символов ");
	}
}