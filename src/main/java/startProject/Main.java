package startProject;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		// Start start = new Start();
		Database database = new Database();

		Set<Entry<String, String>> st = database.hm.entrySet();

		for (Map.Entry<String, String> me : st) {
			System.out.print(me.getKey() + " - ");
			System.out.println(me.getValue());
		}
		System.out.println();
		database.checkUsernameInDatabase();

	}
}
