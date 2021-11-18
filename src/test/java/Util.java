import org.idmef.IDMEFObject;
import org.idmef.Message;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Util {

    static String now() {
        return ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT);
    }

    static String uuid() {
        return UUID.randomUUID().toString();
    }

    static Message message1() {
        Message msg = new Message();
        msg.put("Version", "2.0.3");
        msg.put("ID", uuid());
        msg.put("CreateTime", now());
        IDMEFObject analyzer = new IDMEFObject(msg, "Analyzer");
        analyzer.put("IP", "127.0.0.1");
        analyzer.put("Name", "foobar");
        analyzer.put("Model", "generic");
        analyzer.put("Category", new String[]{"LOG"});
        analyzer.put("Data", new String[]{"Log"});
        analyzer.put("Method", new String[]{"Monitor"});

        return msg;
    }

    static String string1() {
        return "{\n" +
                "\"Version\":\"2.0.3\",\n" +
                "\"CreateTime\":\"" + now() + "\",\n" +
                "\"ID\":\"" + uuid() + "\",\n" +
                "\"Analyzer\":{\n" +
                    "\"Category\":[\"LOG\"],\n" +
                    "\"IP\":\"127.0.0.1\",\n" +
                    "\"Model\":\"generic\",\n" +
                    "\"Data\":[\"Log\"],\n" +
                    "\"Method\":[\"Monitor\"],\n" +
                    "\"Name\":\"foobar\"\n" +
                    "}\n" +
                "}\n";
    }

    static String string2() {
        return "{\"Version\": \"2.0.3\",\n" +
                " \"ID\": \"e2f2cef4-25fb-4a24-a47a-cf88aa2b8cd8\",\n" +
                " \"CreateTime\": \"2021-11-18T16:43:48.606197\",\n" +
                " \"Analyzer\": {\"IP\": \"127.0.0.1\",\n" +
                "\t      \"Name\": \"foobar\",\n" +
                "\t      \"Model\": \"generic\",\n" +
                "\t      \"Category\": [\"LOG\"],\n" +
                "\t      \"Data\": [\"Log\"],\n" +
                "\t      \"Method\": [\"Monitor\"]},\n" +
                " \"Sensor\": [{\"IP\": \"192.168.1.1\",\n" +
                "\t     \"Name\": \"TheSensor\",\n" +
                "\t     \"Model\": \"TheSensorModel\"},\n" +
                "\t    {\"IP\": \"192.168.1.2\",\n" +
                "\t     \"Name\": \"TheSensor2\",\n" +
                "\t     \"Model\": \"TheSensor2Model\"}]}\n";
    }
}
