import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.PropertyResourceBundle;

public class ControlConsole {
    @Autowired
    @Qualifier("opec")
    private IOperation opec;
    private PropertyResourceBundle myRes = null;
    ControlConsole() {
    }
    public void outputMenu() {
        System.out.println(opec.read());
        try {
            myRes = new PropertyResourceBundle(new FileReader("resources/res.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (opec.getAlphabetCount()) {
            System.out.println(myRes.getString(ConstRes.menu));
            String command = opec.inputString();
            int enterNumber;
            switch (command) {
                case "1":
                    System.out.println(myRes.getString(ConstRes.fullKey));
                    for (Map.Entry entry : opec.getAlphabet().entrySet()) {
                        System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
                    }
                    break;
                case "2":
                    System.out.println(myRes.getString(ConstRes.printKey));
                    String key = opec.inputString();
                    System.out.println(opec.getValue(key));
                    break;
                case "3":
                    System.out.println(myRes.getString(ConstRes.printKey));
                    key = opec.inputString();
                    System.out.println(myRes.getString(ConstRes.printAlpha));
                    int count = 0;
                    for (Object nameFile : opec.getAlphabetNames()) {
                        System.out.println(count + ": " + nameFile);
                        count++;
                    }
                    while (true) {
                        try {
                            enterNumber = opec.scannerInt(count);
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println(opec.delete(key, enterNumber));
                    break;
                case "4":
                    System.out.println(myRes.getString(ConstRes.fullKey));
                    count = 0;
                    for (Object nameFile : opec.getAlphabetNames()) {
                        System.out.println(count + ": " + nameFile);
                        count++;
                    }
                    while (true) {
                        try {
                            enterNumber = opec.scannerInt(count);
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    System.out.println(myRes.getString(ConstRes.printKey));
                    key = opec.inputString();
                    System.out.println(myRes.getString(ConstRes.printValue));
                    String value = opec.inputString();
                    System.out.println(opec.create(key, value, enterNumber));
                    break;
                default:
                    System.out.println(myRes.getString(ConstRes.errorCommand));
            }
        }
    }
}